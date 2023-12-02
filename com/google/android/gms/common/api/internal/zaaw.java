package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaaw implements zabf {

    /* renamed from: a  reason: collision with root package name */
    private final zabi f20158a;

    /* renamed from: b  reason: collision with root package name */
    private final Lock f20159b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f20160c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleApiAvailabilityLight f20161d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ConnectionResult f20162e;

    /* renamed from: f  reason: collision with root package name */
    private int f20163f;

    /* renamed from: h  reason: collision with root package name */
    private int f20165h;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private com.google.android.gms.signin.zae f20168k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f20169l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f20170m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f20171n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private IAccountAccessor f20172o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f20173p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f20174q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private final ClientSettings f20175r;

    /* renamed from: s  reason: collision with root package name */
    private final Map f20176s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private final Api.AbstractClientBuilder f20177t;

    /* renamed from: g  reason: collision with root package name */
    private int f20164g = 0;

    /* renamed from: i  reason: collision with root package name */
    private final Bundle f20166i = new Bundle();

    /* renamed from: j  reason: collision with root package name */
    private final Set f20167j = new HashSet();

    /* renamed from: u  reason: collision with root package name */
    private final ArrayList f20178u = new ArrayList();

    public zaaw(zabi zabiVar, @Nullable ClientSettings clientSettings, Map map, GoogleApiAvailabilityLight googleApiAvailabilityLight, @Nullable Api.AbstractClientBuilder abstractClientBuilder, Lock lock, Context context) {
        this.f20158a = zabiVar;
        this.f20175r = clientSettings;
        this.f20176s = map;
        this.f20161d = googleApiAvailabilityLight;
        this.f20177t = abstractClientBuilder;
        this.f20159b = lock;
        this.f20160c = context;
    }

    private final void B() {
        ArrayList arrayList = this.f20178u;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((Future) arrayList.get(i4)).cancel(true);
        }
        this.f20178u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void a() {
        this.f20170m = false;
        this.f20158a.f20231n.f20206p = Collections.emptySet();
        for (Api.AnyClientKey anyClientKey : this.f20167j) {
            if (!this.f20158a.f20224g.containsKey(anyClientKey)) {
                this.f20158a.f20224g.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    @GuardedBy("mLock")
    private final void b(boolean z3) {
        com.google.android.gms.signin.zae zaeVar = this.f20168k;
        if (zaeVar != null) {
            if (zaeVar.isConnected() && z3) {
                zaeVar.zaa();
            }
            zaeVar.disconnect();
            ClientSettings clientSettings = (ClientSettings) Preconditions.checkNotNull(this.f20175r);
            this.f20172o = null;
        }
    }

    @GuardedBy("mLock")
    private final void c() {
        Bundle bundle;
        this.f20158a.c();
        zabj.zaa().execute(new zaak(this));
        com.google.android.gms.signin.zae zaeVar = this.f20168k;
        if (zaeVar != null) {
            if (this.f20173p) {
                zaeVar.zac((IAccountAccessor) Preconditions.checkNotNull(this.f20172o), this.f20174q);
            }
            b(false);
        }
        for (Api.AnyClientKey anyClientKey : this.f20158a.f20224g.keySet()) {
            ((Api.Client) Preconditions.checkNotNull((Api.Client) this.f20158a.f20223f.get(anyClientKey))).disconnect();
        }
        if (this.f20166i.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f20166i;
        }
        this.f20158a.f20232o.zab(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void d(ConnectionResult connectionResult) {
        B();
        b(!connectionResult.hasResolution());
        this.f20158a.e(connectionResult);
        this.f20158a.f20232o.zaa(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void e(ConnectionResult connectionResult, Api api, boolean z3) {
        int priority = api.zac().getPriority();
        if ((!z3 || connectionResult.hasResolution() || this.f20161d.getErrorResolutionIntent(connectionResult.getErrorCode()) != null) && (this.f20162e == null || priority < this.f20163f)) {
            this.f20162e = connectionResult;
            this.f20163f = priority;
        }
        this.f20158a.f20224g.put(api.zab(), connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void f() {
        if (this.f20165h != 0) {
            return;
        }
        if (!this.f20170m || this.f20171n) {
            ArrayList arrayList = new ArrayList();
            this.f20164g = 1;
            this.f20165h = this.f20158a.f20223f.size();
            for (Api.AnyClientKey anyClientKey : this.f20158a.f20223f.keySet()) {
                if (this.f20158a.f20224g.containsKey(anyClientKey)) {
                    if (h()) {
                        c();
                    }
                } else {
                    arrayList.add((Api.Client) this.f20158a.f20223f.get(anyClientKey));
                }
            }
            if (!arrayList.isEmpty()) {
                this.f20178u.add(zabj.zaa().submit(new zaap(this, arrayList)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean g(int i4) {
        if (this.f20164g != i4) {
            Log.w("GACConnecting", this.f20158a.f20231n.c());
            Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
            int i5 = this.f20165h;
            Log.w("GACConnecting", "mRemainingConnections=" + i5);
            String j4 = j(this.f20164g);
            Log.e("GACConnecting", "GoogleApiClient connecting is in step " + j4 + " but received callback for step " + j(i4), new Exception());
            d(new ConnectionResult(8, null));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean h() {
        int i4 = this.f20165h - 1;
        this.f20165h = i4;
        if (i4 > 0) {
            return false;
        }
        if (i4 < 0) {
            Log.w("GACConnecting", this.f20158a.f20231n.c());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            d(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f20162e;
        if (connectionResult != null) {
            this.f20158a.f20230m = this.f20163f;
            d(connectionResult);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean i(ConnectionResult connectionResult) {
        if (this.f20169l && !connectionResult.hasResolution()) {
            return true;
        }
        return false;
    }

    private static final String j(int i4) {
        if (i4 != 0) {
            return "STEP_GETTING_REMOTE_SERVICE";
        }
        return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Set q(zaaw zaawVar) {
        ClientSettings clientSettings = zaawVar.f20175r;
        if (clientSettings == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(clientSettings.getRequiredScopes());
        Map zad = zaawVar.f20175r.zad();
        for (Api api : zad.keySet()) {
            if (!zaawVar.f20158a.f20224g.containsKey(api.zab())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zab) zad.get(api)).zaa);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void t(zaaw zaawVar, com.google.android.gms.signin.internal.zak zakVar) {
        if (!zaawVar.g(0)) {
            return;
        }
        ConnectionResult zaa = zakVar.zaa();
        if (zaa.isSuccess()) {
            com.google.android.gms.common.internal.zav zavVar = (com.google.android.gms.common.internal.zav) Preconditions.checkNotNull(zakVar.zab());
            ConnectionResult zaa2 = zavVar.zaa();
            if (!zaa2.isSuccess()) {
                String valueOf = String.valueOf(zaa2);
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                zaawVar.d(zaa2);
                return;
            }
            zaawVar.f20171n = true;
            zaawVar.f20172o = (IAccountAccessor) Preconditions.checkNotNull(zavVar.zab());
            zaawVar.f20173p = zavVar.zac();
            zaawVar.f20174q = zavVar.zad();
            zaawVar.f();
        } else if (zaawVar.i(zaa)) {
            zaawVar.a();
            zaawVar.f();
        } else {
            zaawVar.d(zaa);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.f20158a.f20231n.f20198h.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final void zad() {
        boolean z3;
        this.f20158a.f20224g.clear();
        this.f20170m = false;
        this.f20162e = null;
        this.f20164g = 0;
        this.f20169l = true;
        this.f20171n = false;
        this.f20173p = false;
        HashMap hashMap = new HashMap();
        boolean z4 = false;
        for (Api api : this.f20176s.keySet()) {
            Api.Client client = (Api.Client) Preconditions.checkNotNull((Api.Client) this.f20158a.f20223f.get(api.zab()));
            if (api.zac().getPriority() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 |= z3;
            boolean booleanValue = ((Boolean) this.f20176s.get(api)).booleanValue();
            if (client.requiresSignIn()) {
                this.f20170m = true;
                if (booleanValue) {
                    this.f20167j.add(api.zab());
                } else {
                    this.f20169l = false;
                }
            }
            hashMap.put(client, new zaal(this, api, booleanValue));
        }
        if (z4) {
            this.f20170m = false;
        }
        if (this.f20170m) {
            Preconditions.checkNotNull(this.f20175r);
            Preconditions.checkNotNull(this.f20177t);
            this.f20175r.zae(Integer.valueOf(System.identityHashCode(this.f20158a.f20231n)));
            zaat zaatVar = new zaat(this, null);
            Api.AbstractClientBuilder abstractClientBuilder = this.f20177t;
            Context context = this.f20160c;
            Looper looper = this.f20158a.f20231n.getLooper();
            ClientSettings clientSettings = this.f20175r;
            this.f20168k = abstractClientBuilder.buildClient(context, looper, clientSettings, (ClientSettings) clientSettings.zaa(), (GoogleApiClient.ConnectionCallbacks) zaatVar, (GoogleApiClient.OnConnectionFailedListener) zaatVar);
        }
        this.f20165h = this.f20158a.f20223f.size();
        this.f20178u.add(zabj.zaa().submit(new zaao(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final void zag(@Nullable Bundle bundle) {
        if (!g(1)) {
            return;
        }
        if (bundle != null) {
            this.f20166i.putAll(bundle);
        }
        if (h()) {
            c();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final void zah(ConnectionResult connectionResult, Api api, boolean z3) {
        if (!g(1)) {
            return;
        }
        e(connectionResult, api, z3);
        if (h()) {
            c();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final void zai(int i4) {
        d(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final boolean zaj() {
        B();
        b(true);
        this.f20158a.e(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
    }
}
