package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Payload;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzgm extends zzgq {
    final /* synthetic */ zzlj zza;
    final /* synthetic */ zzgo zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgm(zzgo zzgoVar, zzlj zzljVar) {
        super(null);
        this.zzb = zzgoVar;
        this.zza = zzljVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        Context context;
        byte[] asBytes;
        Connections.MessageListener messageListener = (Connections.MessageListener) obj;
        context = this.zzb.zza;
        Payload zza = zzme.zza(context, this.zza.zza());
        if (zza == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(this.zza.zza().zzb())));
        } else if (zza.getType() == 1 && (asBytes = zza.asBytes()) != null) {
            messageListener.onMessageReceived(this.zza.zzb(), asBytes, this.zza.zzc());
        }
    }
}
