package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfb extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final zzlh f21564a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21565b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21566c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfb(zzlh zzlhVar) {
        Preconditions.checkNotNull(zzlhVar);
        this.f21564a = zzlhVar;
    }

    @WorkerThread
    public final void b() {
        this.f21564a.b();
        this.f21564a.zzaB().zzg();
        if (this.f21565b) {
            return;
        }
        this.f21564a.zzaw().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f21566c = this.f21564a.zzj().zza();
        this.f21564a.zzaA().zzj().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f21566c));
        this.f21565b = true;
    }

    @WorkerThread
    public final void c() {
        this.f21564a.b();
        this.f21564a.zzaB().zzg();
        this.f21564a.zzaB().zzg();
        if (this.f21565b) {
            this.f21564a.zzaA().zzj().zza("Unregistering connectivity change receiver");
            this.f21565b = false;
            this.f21566c = false;
            try {
                this.f21564a.zzaw().unregisterReceiver(this);
            } catch (IllegalArgumentException e4) {
                this.f21564a.zzaA().zzd().zzb("Failed to unregister the network broadcast receiver", e4);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public final void onReceive(Context context, Intent intent) {
        this.f21564a.b();
        String action = intent.getAction();
        this.f21564a.zzaA().zzj().zzb("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zza = this.f21564a.zzj().zza();
            if (this.f21566c != zza) {
                this.f21566c = zza;
                this.f21564a.zzaB().zzp(new zzfa(this, zza));
                return;
            }
            return;
        }
        this.f21564a.zzaA().zzk().zzb("NetworkBroadcastReceiver received unknown action", action);
    }
}
