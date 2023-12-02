package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbj extends zzu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzbq f22694a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbj(zzbq zzbqVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f22694a = zzbqVar;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzbo(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        String str;
        str = this.f22694a.f22709a;
        zzca zzcaVar = new zzca();
        ((zzfb) ((zzim) anyClient).getService()).zzk(new zzht(this, zzcaVar), zzcaVar, str);
    }
}
