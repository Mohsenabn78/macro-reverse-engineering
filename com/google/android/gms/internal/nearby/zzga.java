package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzga extends zzgq {
    final /* synthetic */ zzkx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzga(zzgb zzgbVar, zzkx zzkxVar) {
        super(null);
        this.zza = zzkxVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        Status zzG;
        Connections.ConnectionResponseCallback connectionResponseCallback = (Connections.ConnectionResponseCallback) obj;
        byte[] zzc = this.zza.zzc();
        if (zzc != null) {
            String zzb = this.zza.zzb();
            zzG = zzgz.zzG(this.zza.zza());
            connectionResponseCallback.onConnectionResponse(zzb, zzG, zzc);
        }
    }
}
