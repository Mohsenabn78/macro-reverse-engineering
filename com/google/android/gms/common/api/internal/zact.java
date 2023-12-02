package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zact extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: h  reason: collision with root package name */
    private static final Api.AbstractClientBuilder f20283h = com.google.android.gms.signin.zad.zac;

    /* renamed from: a  reason: collision with root package name */
    private final Context f20284a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f20285b;

    /* renamed from: c  reason: collision with root package name */
    private final Api.AbstractClientBuilder f20286c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f20287d;

    /* renamed from: e  reason: collision with root package name */
    private final ClientSettings f20288e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.gms.signin.zae f20289f;

    /* renamed from: g  reason: collision with root package name */
    private zacs f20290g;

    @WorkerThread
    public zact(Context context, Handler handler, @NonNull ClientSettings clientSettings) {
        Api.AbstractClientBuilder abstractClientBuilder = f20283h;
        this.f20284a = context;
        this.f20285b = handler;
        this.f20288e = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.f20287d = clientSettings.getRequiredScopes();
        this.f20286c = abstractClientBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void b(zact zactVar, com.google.android.gms.signin.internal.zak zakVar) {
        ConnectionResult zaa = zakVar.zaa();
        if (zaa.isSuccess()) {
            com.google.android.gms.common.internal.zav zavVar = (com.google.android.gms.common.internal.zav) Preconditions.checkNotNull(zakVar.zab());
            ConnectionResult zaa2 = zavVar.zaa();
            if (!zaa2.isSuccess()) {
                String valueOf = String.valueOf(zaa2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                zactVar.f20290g.zae(zaa2);
                zactVar.f20289f.disconnect();
                return;
            }
            zactVar.f20290g.zaf(zavVar.zab(), zactVar.f20287d);
        } else {
            zactVar.f20290g.zae(zaa);
        }
        zactVar.f20289f.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.f20289f.zad(this);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.f20290g.zae(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    @WorkerThread
    public final void onConnectionSuspended(int i4) {
        this.f20289f.disconnect();
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    @BinderThread
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        this.f20285b.post(new zacr(this, zakVar));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @WorkerThread
    public final void zae(zacs zacsVar) {
        com.google.android.gms.signin.zae zaeVar = this.f20289f;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
        this.f20288e.zae(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder abstractClientBuilder = this.f20286c;
        Context context = this.f20284a;
        Looper looper = this.f20285b.getLooper();
        ClientSettings clientSettings = this.f20288e;
        this.f20289f = abstractClientBuilder.buildClient(context, looper, clientSettings, (ClientSettings) clientSettings.zaa(), (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        this.f20290g = zacsVar;
        Set set = this.f20287d;
        if (set != null && !set.isEmpty()) {
            this.f20289f.zab();
        } else {
            this.f20285b.post(new zacq(this));
        }
    }

    public final void zaf() {
        com.google.android.gms.signin.zae zaeVar = this.f20289f;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
    }
}
