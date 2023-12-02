package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaj implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a  reason: collision with root package name */
    public final int f20312a;

    /* renamed from: b  reason: collision with root package name */
    public final GoogleApiClient f20313b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final GoogleApiClient.OnConnectionFailedListener f20314c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zak f20315d;

    public zaj(zak zakVar, int i4, @Nullable GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f20315d = zakVar;
        this.f20312a = i4;
        this.f20313b = googleApiClient;
        this.f20314c = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        "beginFailureResolution for ".concat(String.valueOf(connectionResult));
        this.f20315d.zah(connectionResult, this.f20312a);
    }
}
