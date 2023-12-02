package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class GservicesValue<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f20355d = new Object();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    protected final String f20356a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    protected final Object f20357b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Object f20358c = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public GservicesValue(@NonNull String str, @NonNull Object obj) {
        this.f20356a = str;
        this.f20357b = obj;
    }

    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (f20355d) {
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Float> value(@NonNull String str, @NonNull Float f4) {
        return new zzd(str, f4);
    }

    @NonNull
    protected abstract Object a(@NonNull String str);

    @NonNull
    @KeepForSdk
    public final T get() {
        T t3 = (T) this.f20358c;
        if (t3 != null) {
            return t3;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = f20355d;
        synchronized (obj) {
        }
        synchronized (obj) {
        }
        try {
            return (T) a(this.f20356a);
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            T t4 = (T) a(this.f20356a);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return t4;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    @VisibleForTesting
    @KeepForSdk
    public void override(@NonNull T t3) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.f20358c = t3;
        Object obj = f20355d;
        synchronized (obj) {
            synchronized (obj) {
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public void resetOverride() {
        this.f20358c = null;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Integer> value(@NonNull String str, @NonNull Integer num) {
        return new zzc(str, num);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Long> value(@NonNull String str, @NonNull Long l4) {
        return new zzb(str, l4);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<String> value(@NonNull String str, @NonNull String str2) {
        return new zze(str, str2);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Boolean> value(@NonNull String str, boolean z3) {
        return new zza(str, Boolean.valueOf(z3));
    }
}
