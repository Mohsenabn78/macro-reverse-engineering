package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zabt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConnectionResult f20255a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zabu f20256b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabt(zabu zabuVar, ConnectionResult connectionResult) {
        this.f20256b = zabuVar;
        this.f20255a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        ApiKey apiKey;
        Api.Client client;
        Api.Client client2;
        Api.Client client3;
        Api.Client client4;
        zabu zabuVar = this.f20256b;
        map = zabuVar.f20262f.f20061j;
        apiKey = zabuVar.f20258b;
        zabq zabqVar = (zabq) map.get(apiKey);
        if (zabqVar == null) {
            return;
        }
        if (this.f20255a.isSuccess()) {
            this.f20256b.f20261e = true;
            client = this.f20256b.f20257a;
            if (client.requiresSignIn()) {
                this.f20256b.e();
                return;
            }
            try {
                zabu zabuVar2 = this.f20256b;
                client3 = zabuVar2.f20257a;
                client4 = zabuVar2.f20257a;
                client3.getRemoteService(null, client4.getScopesForConnectionlessNonSignIn());
                return;
            } catch (SecurityException e4) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e4);
                client2 = this.f20256b.f20257a;
                client2.disconnect("Failed to get service from broker.");
                zabqVar.zar(new ConnectionResult(10), null);
                return;
            }
        }
        zabqVar.zar(this.f20255a, null);
    }
}
