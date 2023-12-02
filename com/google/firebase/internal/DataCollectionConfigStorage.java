package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

/* loaded from: classes5.dex */
public class DataCollectionConfigStorage {
    @VisibleForTesting
    public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";

    /* renamed from: a  reason: collision with root package name */
    private final Context f31599a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f31600b;

    /* renamed from: c  reason: collision with root package name */
    private final Publisher f31601c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31602d;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        Context a4 = a(context);
        this.f31599a = a4;
        this.f31600b = a4.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f31601c = publisher;
        this.f31602d = b();
    }

    private static Context a(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        return ContextCompat.createDeviceProtectedStorageContext(context);
    }

    private boolean b() {
        if (this.f31600b.contains(DATA_COLLECTION_DEFAULT_ENABLED)) {
            return this.f31600b.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED, true);
        }
        return c();
    }

    private boolean c() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f31599a.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.f31599a.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(DATA_COLLECTION_DEFAULT_ENABLED)) {
                return applicationInfo.metaData.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    private synchronized void d(boolean z3) {
        if (this.f31602d != z3) {
            this.f31602d = z3;
            this.f31601c.publish(new Event<>(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z3)));
        }
    }

    public synchronized boolean isEnabled() {
        return this.f31602d;
    }

    public synchronized void setEnabled(Boolean bool) {
        if (bool == null) {
            this.f31600b.edit().remove(DATA_COLLECTION_DEFAULT_ENABLED).apply();
            d(c());
        } else {
            boolean equals = Boolean.TRUE.equals(bool);
            this.f31600b.edit().putBoolean(DATA_COLLECTION_DEFAULT_ENABLED, equals).apply();
            d(equals);
        }
    }
}
