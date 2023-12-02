package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.Strategy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzix extends zzjg {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ ListenerHolder zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzix(zzjj zzjjVar, GoogleApiClient googleApiClient, String str, long j4, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = j4;
        this.zzc = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        String str = this.zza;
        long j4 = this.zzb;
        ListenerHolder listenerHolder = this.zzc;
        AdvertisingOptions.Builder builder = new AdvertisingOptions.Builder();
        builder.setStrategy(Strategy.P2P_CLUSTER);
        AdvertisingOptions build = builder.build();
        zzmr zzmrVar = new zzmr();
        zzmrVar.zzg(new zzgy(this));
        zzmrVar.zze(str);
        zzmrVar.zzh("__LEGACY_SERVICE_ID__");
        zzmrVar.zzc(j4);
        zzmrVar.zza(new zzfz(listenerHolder));
        zzmrVar.zzf(build);
        ((zzke) ((zzgz) anyClient).getService()).zzk(zzmrVar.zzi());
    }
}
