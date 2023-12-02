package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes4.dex */
final class zzj extends com.google.android.gms.location.places.zzg<zzq> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f21135a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzj(zzh zzhVar, Api api, GoogleApiClient googleApiClient, String str) {
        super(api, googleApiClient);
        this.f21135a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzq) anyClient).zzb(new com.google.android.gms.location.places.zzf(this), this.f21135a);
    }
}
