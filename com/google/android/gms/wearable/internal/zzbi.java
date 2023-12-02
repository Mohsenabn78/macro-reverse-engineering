package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbi extends zzu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f22692a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzbq f22693b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbi(zzbq zzbqVar, GoogleApiClient googleApiClient, int i4) {
        super(googleApiClient);
        this.f22693b = zzbqVar;
        this.f22692a = i4;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        String str;
        str = this.f22693b.f22709a;
        ((zzfb) ((zzim) anyClient).getService()).zzg(new zzhp(this), str, this.f22692a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
