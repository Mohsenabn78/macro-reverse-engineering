package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class GmsClientSupervisor {

    /* renamed from: a  reason: collision with root package name */
    private static int f20462a = 4225;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f20463b = new Object();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static zzr f20464c = null;
    @Nullable
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    static HandlerThread f20465d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f20466e = false;

    @KeepForSdk
    public static int getDefaultBindFlags() {
        return f20462a;
    }

    @NonNull
    @KeepForSdk
    public static GmsClientSupervisor getInstance(@NonNull Context context) {
        Looper mainLooper;
        synchronized (f20463b) {
            if (f20464c == null) {
                Context applicationContext = context.getApplicationContext();
                if (f20466e) {
                    mainLooper = getOrStartHandlerThread().getLooper();
                } else {
                    mainLooper = context.getMainLooper();
                }
                f20464c = new zzr(applicationContext, mainLooper);
            }
        }
        return f20464c;
    }

    @NonNull
    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread() {
        synchronized (f20463b) {
            HandlerThread handlerThread = f20465d;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f20465d = handlerThread2;
            handlerThread2.start();
            return f20465d;
        }
    }

    @KeepForSdk
    public static void setUseHandlerThreadForCallbacks() {
        synchronized (f20463b) {
            zzr zzrVar = f20464c;
            if (zzrVar != null && !f20466e) {
                zzrVar.h(getOrStartHandlerThread().getLooper());
            }
            f20466e = true;
        }
    }

    protected abstract void a(zzn zznVar, ServiceConnection serviceConnection, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean b(zzn zznVar, ServiceConnection serviceConnection, String str, @Nullable Executor executor);

    @KeepForSdk
    public boolean bindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        return b(new zzn(componentName, getDefaultBindFlags()), serviceConnection, str, null);
    }

    @KeepForSdk
    public void unbindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        a(new zzn(componentName, getDefaultBindFlags()), serviceConnection, str);
    }

    public final void zzb(@NonNull String str, @NonNull String str2, int i4, @NonNull ServiceConnection serviceConnection, @NonNull String str3, boolean z3) {
        a(new zzn(str, str2, i4, z3), serviceConnection, str3);
    }

    @KeepForSdk
    public boolean bindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        return b(new zzn(str, getDefaultBindFlags(), false), serviceConnection, str2, null);
    }

    @KeepForSdk
    public void unbindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        a(new zzn(str, getDefaultBindFlags(), false), serviceConnection, str2);
    }
}
