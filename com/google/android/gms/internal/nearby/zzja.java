package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.Strategy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzja extends zzji {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ ListenerHolder zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzja(zzjj zzjjVar, GoogleApiClient googleApiClient, String str, long j4, ListenerHolder listenerHolder) {
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
        DiscoveryOptions.Builder builder = new DiscoveryOptions.Builder();
        builder.setStrategy(Strategy.P2P_CLUSTER);
        DiscoveryOptions build = builder.build();
        zzmv zzmvVar = new zzmv();
        zzmvVar.zzd(new zzgw(this));
        zzmvVar.zze(str);
        zzmvVar.zzb(j4);
        zzmvVar.zza(new zzgk(listenerHolder));
        zzmvVar.zzc(build);
        ((zzke) ((zzgz) anyClient).getService()).zzl(zzmvVar.zzf());
    }
}
