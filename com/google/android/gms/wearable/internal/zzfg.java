package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzfg extends zzu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f22761a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f22762b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ byte[] f22763c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfg(zzfl zzflVar, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        super(googleApiClient);
        this.f22761a = str;
        this.f22762b = str2;
        this.f22763c = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return new zzfk(status, -1);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzfb) ((zzim) anyClient).getService()).zzz(new zzig(this), this.f22761a, this.f22762b, this.f22763c);
    }
}
