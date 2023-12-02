package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes4.dex */
final class zzn extends zzm.zzc<zzq> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f21142a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ LatLngBounds f21143b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ AutocompleteFilter f21144c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(zzh zzhVar, Api api, GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        super(api, googleApiClient);
        this.f21142a = str;
        this.f21143b = latLngBounds;
        this.f21144c = autocompleteFilter;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzq) anyClient).zzb(new com.google.android.gms.location.places.zzm(this), this.f21142a, this.f21143b, 1, this.f21144c);
    }
}
