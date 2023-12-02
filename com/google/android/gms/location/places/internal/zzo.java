package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzo extends zzm.zzc<zzq> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f21145a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ LatLngBounds f21146b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f21147c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ AutocompleteFilter f21148d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzo(zzh zzhVar, Api api, GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, int i4, AutocompleteFilter autocompleteFilter) {
        super(api, googleApiClient);
        this.f21145a = str;
        this.f21146b = latLngBounds;
        this.f21147c = i4;
        this.f21148d = autocompleteFilter;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzq) anyClient).zzb(new com.google.android.gms.location.places.zzm(this), this.f21145a, this.f21146b, this.f21147c, this.f21148d);
    }
}
