package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfk implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final String f21616a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzfl f21617b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfk(zzfl zzflVar, String str) {
        this.f21617b = zzflVar;
        this.f21616a = str;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                com.google.android.gms.internal.measurement.zzbr zzb = com.google.android.gms.internal.measurement.zzbq.zzb(iBinder);
                if (zzb == null) {
                    this.f21617b.f21618a.zzaA().zzk().zza("Install Referrer Service implementation was not found");
                    return;
                }
                this.f21617b.f21618a.zzaA().zzj().zza("Install Referrer Service connected");
                this.f21617b.f21618a.zzaB().zzp(new zzfj(this, zzb, this));
                return;
            } catch (RuntimeException e4) {
                this.f21617b.f21618a.zzaA().zzk().zzb("Exception occurred while calling Install Referrer API", e4);
                return;
            }
        }
        this.f21617b.f21618a.zzaA().zzk().zza("Install Referrer connection returned with null binder");
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f21617b.f21618a.zzaA().zzj().zza("Install Referrer Service disconnected");
    }
}
