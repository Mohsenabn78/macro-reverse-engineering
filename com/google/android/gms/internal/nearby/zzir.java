package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzir extends zzji {
    final /* synthetic */ String zza;
    final /* synthetic */ byte[] zzb;
    final /* synthetic */ ListenerHolder zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzir(zzjj zzjjVar, GoogleApiClient googleApiClient, String str, byte[] bArr, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = bArr;
        this.zzc = listenerHolder;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzgz zzgzVar = (zzgz) anyClient;
        String str = this.zza;
        byte[] bArr = this.zzb;
        ListenerHolder listenerHolder = this.zzc;
        zzfh zzfhVar = new zzfh();
        zzfhVar.zze(new zzgw(this));
        zzfhVar.zzd(str);
        zzfhVar.zzb(bArr);
        zzfhVar.zza(new zzgo(zzgzVar.getContext(), listenerHolder));
        ((zzke) zzgzVar.getService()).zzd(zzfhVar.zzf());
    }
}
