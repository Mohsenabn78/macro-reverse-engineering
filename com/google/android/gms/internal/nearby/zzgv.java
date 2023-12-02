package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzgv extends zzkg implements zzgl {
    private final Context zza;
    private final ListenerHolder zzb;
    private final Map zzc = new ArrayMap();
    @Nullable
    private final zzlu zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgv(Context context, ListenerHolder listenerHolder, @Nullable zzlu zzluVar) {
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.zzd = zzluVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzkh
    public final synchronized void zzb(zzlj zzljVar) {
        Payload zza = zzme.zza(this.zza, zzljVar.zza());
        if (zza == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", Long.valueOf(zzljVar.zza().zzb())));
            return;
        }
        Map map = this.zzc;
        zzgu zzguVar = new zzgu(zzljVar.zzb(), zzljVar.zza().zzb());
        PayloadTransferUpdate.Builder builder = new PayloadTransferUpdate.Builder();
        builder.setPayloadId(zzljVar.zza().zzb());
        map.put(zzguVar, builder.build());
        this.zzb.notifyListener(new zzgr(this, zzljVar, zza));
    }

    @Override // com.google.android.gms.internal.nearby.zzkh
    public final synchronized void zzc(zzll zzllVar) {
        if (zzllVar.zza().getStatus() == 3) {
            this.zzc.put(new zzgu(zzllVar.zzb(), zzllVar.zza().getPayloadId()), zzllVar.zza());
        } else {
            this.zzc.remove(new zzgu(zzllVar.zzb(), zzllVar.zza().getPayloadId()));
            zzlu zzluVar = this.zzd;
            if (zzluVar != null) {
                zzluVar.zzb(zzllVar.zza().getPayloadId());
            }
        }
        this.zzb.notifyListener(new zzgs(this, zzllVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzgl
    public final synchronized void zzf() {
        for (Map.Entry entry : this.zzc.entrySet()) {
            this.zzb.notifyListener(new zzgt(this, ((zzgu) entry.getKey()).zza(), (PayloadTransferUpdate) entry.getValue()));
        }
        this.zzc.clear();
    }
}
