package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzge extends zzgq {
    final /* synthetic */ zzlf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzge(zzgh zzghVar, zzlf zzlfVar) {
        super(null);
        this.zza = zzlfVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        boolean zzg;
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        zzg = zzgh.zzg(this.zza);
        if (zzg) {
            com.google.android.gms.nearby.connection.zzs zzsVar = new com.google.android.gms.nearby.connection.zzs();
            zzsVar.zzd(this.zza.zzd());
            zzsVar.zza(this.zza.zza());
            endpointDiscoveryCallback.onEndpointFound("__UNRECOGNIZED_BLUETOOTH_DEVICE__", zzsVar.zze());
            return;
        }
        String zzb = this.zza.zzb();
        com.google.android.gms.nearby.connection.zzs zzsVar2 = new com.google.android.gms.nearby.connection.zzs();
        zzsVar2.zzd(this.zza.zzd());
        zzsVar2.zzc(this.zza.zzc());
        zzsVar2.zzb(this.zza.zze());
        endpointDiscoveryCallback.onEndpointFound(zzb, zzsVar2.zze());
    }
}
