package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbl extends zzu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Uri f22696a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f22697b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzbq f22698c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbl(zzbq zzbqVar, GoogleApiClient googleApiClient, Uri uri, boolean z3) {
        super(googleApiClient);
        this.f22698c = zzbqVar;
        this.f22696a = uri;
        this.f22697b = z3;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        String str;
        str = this.f22698c.f22709a;
        ((zzim) anyClient).zzw(this, str, this.f22696a, this.f22697b);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
