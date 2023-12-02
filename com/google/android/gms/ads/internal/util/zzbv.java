package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzfmd;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbv {

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f19305a = null;

    /* renamed from: b  reason: collision with root package name */
    private Handler f19306b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f19307c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final Object f19308d = new Object();

    public final Handler zza() {
        return this.f19306b;
    }

    public final Looper zzb() {
        Looper looper;
        synchronized (this.f19308d) {
            if (this.f19307c == 0) {
                if (this.f19305a == null) {
                    zze.zza("Starting the looper thread.");
                    HandlerThread handlerThread = new HandlerThread("LooperProvider");
                    this.f19305a = handlerThread;
                    handlerThread.start();
                    this.f19306b = new zzfmd(this.f19305a.getLooper());
                    zze.zza("Looper thread started.");
                } else {
                    zze.zza("Resuming the looper thread");
                    this.f19308d.notifyAll();
                }
            } else {
                Preconditions.checkNotNull(this.f19305a, "Invalid state: handlerThread should already been initialized.");
            }
            this.f19307c++;
            looper = this.f19305a.getLooper();
        }
        return looper;
    }
}
