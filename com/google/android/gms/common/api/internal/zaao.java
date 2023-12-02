package com.google.android.gms.common.api.internal;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaao extends zaav {

    /* renamed from: b  reason: collision with root package name */
    private final Map f20149b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zaaw f20150c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaao(zaaw zaawVar, Map map) {
        super(zaawVar, null);
        this.f20150c = zaawVar;
        this.f20149b = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    @GuardedBy("mLock")
    @WorkerThread
    public final void a() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        boolean z3;
        Context context2;
        zabi zabiVar;
        com.google.android.gms.signin.zae zaeVar;
        com.google.android.gms.signin.zae zaeVar2;
        zabi zabiVar2;
        Context context3;
        boolean z4;
        googleApiAvailabilityLight = this.f20150c.f20161d;
        com.google.android.gms.common.internal.zal zalVar = new com.google.android.gms.common.internal.zal(googleApiAvailabilityLight);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.f20149b.keySet()) {
            if (client.requiresGooglePlayServices()) {
                z4 = ((zaal) this.f20149b.get(client)).f20145c;
                if (!z4) {
                    arrayList.add(client);
                }
            }
            arrayList2.add(client);
        }
        int i4 = 0;
        int i5 = -1;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i4 < size) {
                context3 = this.f20150c.f20160c;
                i5 = zalVar.zab(context3, (Api.Client) arrayList2.get(i4));
                i4++;
                if (i5 == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i4 < size2) {
                context = this.f20150c.f20160c;
                i5 = zalVar.zab(context, (Api.Client) arrayList.get(i4));
                i4++;
                if (i5 != 0) {
                    break;
                }
            }
        }
        if (i5 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i5, null);
            zaaw zaawVar = this.f20150c;
            zabiVar2 = zaawVar.f20158a;
            zabiVar2.f(new zaam(this, zaawVar, connectionResult));
            return;
        }
        zaaw zaawVar2 = this.f20150c;
        z3 = zaawVar2.f20170m;
        if (z3) {
            zaeVar = zaawVar2.f20168k;
            if (zaeVar != null) {
                zaeVar2 = zaawVar2.f20168k;
                zaeVar2.zab();
            }
        }
        for (Api.Client client2 : this.f20149b.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) this.f20149b.get(client2);
            if (client2.requiresGooglePlayServices()) {
                context2 = this.f20150c.f20160c;
                if (zalVar.zab(context2, client2) != 0) {
                    zaaw zaawVar3 = this.f20150c;
                    zabiVar = zaawVar3.f20158a;
                    zabiVar.f(new zaan(this, zaawVar3, connectionProgressReportCallbacks));
                }
            }
            client2.connect(connectionProgressReportCallbacks);
        }
    }
}
