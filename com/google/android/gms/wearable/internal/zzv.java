package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzv extends zzu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f22859a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f22860b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzv(zzah zzahVar, GoogleApiClient googleApiClient, String str, int i4) {
        super(googleApiClient);
        this.f22859a = str;
        this.f22860b = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzae(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzfb) ((zzim) anyClient).getService()).zzj(new zzhs(this), this.f22859a, this.f22860b);
    }
}
