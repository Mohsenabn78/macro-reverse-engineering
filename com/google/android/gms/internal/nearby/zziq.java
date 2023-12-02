package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zziq extends zzji {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ byte[] zzc;
    final /* synthetic */ ListenerHolder zzd;
    final /* synthetic */ ListenerHolder zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zziq(zzjj zzjjVar, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = listenerHolder;
        this.zze = listenerHolder2;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzgz zzgzVar = (zzgz) anyClient;
        String str = this.zza;
        String str2 = this.zzb;
        byte[] bArr = this.zzc;
        ListenerHolder listenerHolder = this.zzd;
        ListenerHolder listenerHolder2 = this.zze;
        zzmj zzmjVar = new zzmj();
        zzmjVar.zzi(new zzgw(this));
        zzmjVar.zzf(str);
        zzmjVar.zzh(str2);
        zzmjVar.zze(bArr);
        zzmjVar.zza(new zzgo(zzgzVar.getContext(), listenerHolder2));
        zzmjVar.zzc(new zzgb(listenerHolder));
        ((zzke) zzgzVar.getService()).zzi(zzmjVar.zzj());
    }
}
