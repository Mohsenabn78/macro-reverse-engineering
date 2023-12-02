package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class Storage {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f19858c = new ReentrantLock();
    @Nullable
    @GuardedBy("sLk")

    /* renamed from: d  reason: collision with root package name */
    private static Storage f19859d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f19860a = new ReentrantLock();
    @GuardedBy("mLk")

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f19861b;

    @VisibleForTesting
    Storage(Context context) {
        this.f19861b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    private static final String d(String str, String str2) {
        return str + ":" + str2;
    }

    @NonNull
    @KeepForSdk
    public static Storage getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        Lock lock = f19858c;
        lock.lock();
        try {
            if (f19859d == null) {
                f19859d = new Storage(context.getApplicationContext());
            }
            Storage storage = f19859d;
            lock.unlock();
            return storage;
        } catch (Throwable th) {
            f19858c.unlock();
            throw th;
        }
    }

    @Nullable
    protected final String a(@NonNull String str) {
        this.f19860a.lock();
        try {
            return this.f19861b.getString(str, null);
        } finally {
            this.f19860a.unlock();
        }
    }

    protected final void b(@NonNull String str) {
        this.f19860a.lock();
        try {
            this.f19861b.edit().remove(str).apply();
        } finally {
            this.f19860a.unlock();
        }
    }

    protected final void c(@NonNull String str, @NonNull String str2) {
        this.f19860a.lock();
        try {
            this.f19861b.edit().putString(str, str2).apply();
        } finally {
            this.f19860a.unlock();
        }
    }

    @KeepForSdk
    public void clear() {
        this.f19860a.lock();
        try {
            this.f19861b.edit().clear().apply();
        } finally {
            this.f19860a.unlock();
        }
    }

    @Nullable
    @KeepForSdk
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String a4;
        String a5 = a("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(a5) || (a4 = a(d("googleSignInAccount", a5))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zab(a4);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    @KeepForSdk
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        String a4;
        String a5 = a("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(a5) || (a4 = a(d("googleSignInOptions", a5))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zab(a4);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    @KeepForSdk
    public String getSavedRefreshToken() {
        return a("refreshToken");
    }

    @KeepForSdk
    public void saveDefaultGoogleSignInAccount(@NonNull GoogleSignInAccount googleSignInAccount, @NonNull GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        c("defaultGoogleSignInAccount", googleSignInAccount.zac());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String zac = googleSignInAccount.zac();
        c(d("googleSignInAccount", zac), googleSignInAccount.zad());
        c(d("googleSignInOptions", zac), googleSignInOptions.zaf());
    }

    public final void zac() {
        String a4 = a("defaultGoogleSignInAccount");
        b("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(a4)) {
            return;
        }
        b(d("googleSignInAccount", a4));
        b(d("googleSignInOptions", a4));
    }
}
