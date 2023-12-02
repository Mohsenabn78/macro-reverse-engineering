package com.google.android.gms.identity.intents;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
/* loaded from: classes4.dex */
final class zzb extends zzc {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UserAddressRequest f20865a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f20866b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i4) {
        super(googleApiClient);
        this.f20865a = userAddressRequest;
        this.f20866b = i4;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.internal.identity.zze zzeVar) throws RemoteException {
        zzeVar.zzp(this.f20865a, this.f20866b);
        setResult((zzb) Status.RESULT_SUCCESS);
    }
}
