package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzag extends zzu {

    /* renamed from: a  reason: collision with root package name */
    private CapabilityApi.CapabilityListener f22668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzag(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, zzaf zzafVar) {
        super(googleApiClient);
        this.f22668a = capabilityListener;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        this.f22668a = null;
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzim) anyClient).zzx(this, this.f22668a);
        this.f22668a = null;
    }
}
