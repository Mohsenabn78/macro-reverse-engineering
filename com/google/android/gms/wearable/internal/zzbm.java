package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzbm extends zzu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Uri f22699a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f22700b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f22701c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzbq f22702d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbm(zzbq zzbqVar, GoogleApiClient googleApiClient, Uri uri, long j4, long j5) {
        super(googleApiClient);
        this.f22702d = zzbqVar;
        this.f22699a = uri;
        this.f22700b = j4;
        this.f22701c = j5;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        String str;
        str = this.f22702d.f22709a;
        ((zzim) anyClient).zzC(this, str, this.f22699a, this.f22700b, this.f22701c);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
