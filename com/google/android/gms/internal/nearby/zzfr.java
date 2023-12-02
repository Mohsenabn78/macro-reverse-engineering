package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzfr extends zzgq {
    final /* synthetic */ zzkt zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfr(zzfx zzfxVar, zzkt zzktVar) {
        super(null);
        this.zza = zzktVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ConnectionLifecycleCallback connectionLifecycleCallback = (ConnectionLifecycleCallback) obj;
        String zzc = this.zza.zzc();
        com.google.android.gms.nearby.connection.zzk zzkVar = new com.google.android.gms.nearby.connection.zzk();
        zzkVar.zzd(this.zza.zzd());
        zzkVar.zzb(this.zza.zzb());
        zzkVar.zzg(this.zza.zzg());
        zzkVar.zzf(this.zza.zzf());
        zzkVar.zzc(this.zza.zzh());
        zzkVar.zze(this.zza.zze());
        int zza = this.zza.zza();
        int i4 = zzgz.zze;
        int i5 = 0;
        if (zza != 0) {
            if (zza != 1) {
                if (zza == 2) {
                    i5 = 2;
                }
            } else {
                i5 = 1;
            }
        }
        zzkVar.zza(i5);
        connectionLifecycleCallback.onConnectionInitiated(zzc, zzkVar.zzh());
    }
}
