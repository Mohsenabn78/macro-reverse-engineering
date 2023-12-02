package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zaat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaw f20156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zaat(zaaw zaawVar, zaas zaasVar) {
        this.f20156a = zaawVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        ClientSettings clientSettings;
        com.google.android.gms.signin.zae zaeVar;
        clientSettings = this.f20156a.f20175r;
        ClientSettings clientSettings2 = (ClientSettings) Preconditions.checkNotNull(clientSettings);
        zaeVar = this.f20156a.f20168k;
        ((com.google.android.gms.signin.zae) Preconditions.checkNotNull(zaeVar)).zad(new zaar(this.f20156a));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        boolean i4;
        lock = this.f20156a.f20159b;
        lock.lock();
        try {
            i4 = this.f20156a.i(connectionResult);
            if (i4) {
                this.f20156a.a();
                this.f20156a.f();
            } else {
                this.f20156a.d(connectionResult);
            }
        } finally {
            lock2 = this.f20156a.f20159b;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
    }
}
