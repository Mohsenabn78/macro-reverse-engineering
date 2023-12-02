package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f20333a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private zau f20334b;
    public final Api zaa;

    public zat(Api api, boolean z3) {
        this.zaa = api;
        this.f20333a = z3;
    }

    private final zau a() {
        Preconditions.checkNotNull(this.f20334b, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.f20334b;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        a().onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        a().zaa(connectionResult, this.zaa, this.f20333a);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
        a().onConnectionSuspended(i4);
    }

    public final void zaa(zau zauVar) {
        this.f20334b = zauVar;
    }
}
