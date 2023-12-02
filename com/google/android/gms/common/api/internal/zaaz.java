package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zaaz implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f20181a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f20182b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zabe f20183c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaaz(zabe zabeVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.f20183c = zabeVar;
        this.f20181a = atomicReference;
        this.f20182b = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        this.f20183c.j((GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.f20181a.get()), this.f20182b, true);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
    }
}
