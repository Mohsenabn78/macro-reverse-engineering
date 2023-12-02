package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class SharedPreferencesQueue {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f31719a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31720b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31721c;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f31723e;
    @GuardedBy("internalQueue")
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    final ArrayDeque<String> f31722d = new ArrayDeque<>();
    @GuardedBy("internalQueue")

    /* renamed from: f  reason: collision with root package name */
    private boolean f31724f = false;

    private SharedPreferencesQueue(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f31719a = sharedPreferences;
        this.f31720b = str;
        this.f31721c = str2;
        this.f31723e = executor;
    }

    @GuardedBy("internalQueue")
    private boolean c(boolean z3) {
        if (z3 && !this.f31724f) {
            j();
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public static SharedPreferencesQueue d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences, str, str2, executor);
        sharedPreferencesQueue.e();
        return sharedPreferencesQueue;
    }

    @WorkerThread
    private void e() {
        synchronized (this.f31722d) {
            this.f31722d.clear();
            String string = this.f31719a.getString(this.f31720b, "");
            if (!TextUtils.isEmpty(string) && string.contains(this.f31721c)) {
                String[] split = string.split(this.f31721c, -1);
                if (split.length == 0) {
                    Log.e(Constants.TAG, "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f31722d.add(str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void i() {
        synchronized (this.f31722d) {
            this.f31719a.edit().putString(this.f31720b, h()).commit();
        }
    }

    private void j() {
        this.f31723e.execute(new Runnable() { // from class: com.google.firebase.messaging.c0
            @Override // java.lang.Runnable
            public final void run() {
                SharedPreferencesQueue.this.i();
            }
        });
    }

    public boolean b(@NonNull String str) {
        boolean c4;
        if (!TextUtils.isEmpty(str) && !str.contains(this.f31721c)) {
            synchronized (this.f31722d) {
                c4 = c(this.f31722d.add(str));
            }
            return c4;
        }
        return false;
    }

    @Nullable
    public String f() {
        String peek;
        synchronized (this.f31722d) {
            peek = this.f31722d.peek();
        }
        return peek;
    }

    public boolean g(@Nullable Object obj) {
        boolean c4;
        synchronized (this.f31722d) {
            c4 = c(this.f31722d.remove(obj));
        }
        return c4;
    }

    @NonNull
    @GuardedBy("internalQueue")
    public String h() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f31722d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(this.f31721c);
        }
        return sb.toString();
    }
}
