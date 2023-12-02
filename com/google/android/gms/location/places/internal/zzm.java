package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzm extends com.google.android.gms.location.places.zze<zzq> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f21138a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f21139b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f21140c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ int f21141d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(zzh zzhVar, Api api, GoogleApiClient googleApiClient, String str, int i4, int i5, int i6) {
        super(api, googleApiClient);
        this.f21138a = str;
        this.f21139b = i4;
        this.f21140c = i5;
        this.f21141d = i6;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzq) anyClient).zzb(new com.google.android.gms.location.places.zzf(this), this.f21138a, this.f21139b, this.f21140c, this.f21141d);
    }
}
