package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.Constants;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class DataCollectionArbiter {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f29507a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f29508b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f29509c;

    /* renamed from: d  reason: collision with root package name */
    TaskCompletionSource<Void> f29510d;

    /* renamed from: e  reason: collision with root package name */
    boolean f29511e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29512f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Boolean f29513g;

    /* renamed from: h  reason: collision with root package name */
    private final TaskCompletionSource<Void> f29514h;

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Object obj = new Object();
        this.f29509c = obj;
        this.f29510d = new TaskCompletionSource<>();
        this.f29511e = false;
        this.f29512f = false;
        this.f29514h = new TaskCompletionSource<>();
        Context applicationContext = firebaseApp.getApplicationContext();
        this.f29508b = firebaseApp;
        this.f29507a = CommonUtils.getSharedPrefs(applicationContext);
        Boolean b4 = b();
        this.f29513g = b4 == null ? a(applicationContext) : b4;
        synchronized (obj) {
            if (isAutomaticDataCollectionEnabled()) {
                this.f29510d.trySetResult(null);
                this.f29511e = true;
            }
        }
    }

    @Nullable
    private Boolean a(Context context) {
        Boolean e4 = e(context);
        if (e4 == null) {
            this.f29512f = false;
            return null;
        }
        this.f29512f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(e4));
    }

    @Nullable
    private Boolean b() {
        if (this.f29507a.contains("firebase_crashlytics_collection_enabled")) {
            this.f29512f = false;
            return Boolean.valueOf(this.f29507a.getBoolean("firebase_crashlytics_collection_enabled", true));
        }
        return null;
    }

    private boolean c() {
        try {
            return this.f29508b.isDataCollectionDefaultEnabled();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private void d(boolean z3) {
        String str;
        String str2;
        if (z3) {
            str = Constants.ENABLED_LOG_PREFIX;
        } else {
            str = Constants.DISABLED_LOG_PREFIX;
        }
        if (this.f29513g == null) {
            str2 = "global Firebase setting";
        } else if (this.f29512f) {
            str2 = "firebase_crashlytics_collection_enabled manifest flag";
        } else {
            str2 = "API";
        }
        Logger.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", str, str2));
    }

    @Nullable
    private static Boolean e(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
            }
            return null;
        } catch (PackageManager.NameNotFoundException e4) {
            Logger.getLogger().e("Could not read data collection permission from manifest", e4);
            return null;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private static void f(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (bool != null) {
            edit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            edit.remove("firebase_crashlytics_collection_enabled");
        }
        edit.apply();
    }

    public void grantDataCollectionPermission(boolean z3) {
        if (z3) {
            this.f29514h.trySetResult(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean isAutomaticDataCollectionEnabled() {
        boolean c4;
        Boolean bool = this.f29513g;
        if (bool != null) {
            c4 = bool.booleanValue();
        } else {
            c4 = c();
        }
        d(c4);
        return c4;
    }

    public synchronized void setCrashlyticsDataCollectionEnabled(@Nullable Boolean bool) {
        Boolean a4;
        if (bool != null) {
            try {
                this.f29512f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            a4 = bool;
        } else {
            a4 = a(this.f29508b.getApplicationContext());
        }
        this.f29513g = a4;
        f(this.f29507a, bool);
        synchronized (this.f29509c) {
            if (isAutomaticDataCollectionEnabled()) {
                if (!this.f29511e) {
                    this.f29510d.trySetResult(null);
                    this.f29511e = true;
                }
            } else if (this.f29511e) {
                this.f29510d = new TaskCompletionSource<>();
                this.f29511e = false;
            }
        }
    }

    public Task<Void> waitForAutomaticDataCollectionEnabled() {
        Task<Void> task;
        synchronized (this.f29509c) {
            task = this.f29510d.getTask();
        }
        return task;
    }

    public Task<Void> waitForDataCollectionPermission(Executor executor) {
        return Utils.race(executor, this.f29514h.getTask(), waitForAutomaticDataCollectionEnabled());
    }
}
