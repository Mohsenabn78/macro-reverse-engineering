package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau {
    @NotOnlyInitialized

    /* renamed from: b */
    private final Api.Client f20241b;

    /* renamed from: c */
    private final ApiKey f20242c;

    /* renamed from: d */
    private final zaad f20243d;

    /* renamed from: g */
    private final int f20246g;
    @Nullable

    /* renamed from: h */
    private final zact f20247h;

    /* renamed from: i */
    private boolean f20248i;

    /* renamed from: m */
    final /* synthetic */ GoogleApiManager f20252m;

    /* renamed from: a */
    private final Queue f20240a = new LinkedList();

    /* renamed from: e */
    private final Set f20244e = new HashSet();

    /* renamed from: f */
    private final Map f20245f = new HashMap();

    /* renamed from: j */
    private final List f20249j = new ArrayList();
    @Nullable

    /* renamed from: k */
    private ConnectionResult f20250k = null;

    /* renamed from: l */
    private int f20251l = 0;

    @WorkerThread
    public zabq(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        Handler handler;
        Context context;
        Handler handler2;
        this.f20252m = googleApiManager;
        handler = googleApiManager.f20065n;
        Api.Client zab = googleApi.zab(handler.getLooper(), this);
        this.f20241b = zab;
        this.f20242c = googleApi.getApiKey();
        this.f20243d = new zaad();
        this.f20246g = googleApi.zaa();
        if (zab.requiresSignIn()) {
            context = googleApiManager.f20056e;
            handler2 = googleApiManager.f20065n;
            this.f20247h = googleApi.zac(context, handler2);
            return;
        }
        this.f20247h = null;
    }

    @Nullable
    @WorkerThread
    private final Feature a(@Nullable Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.f20241b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l4 = (Long) arrayMap.get(feature2.getName());
                if (l4 == null || l4.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    @WorkerThread
    private final void b(ConnectionResult connectionResult) {
        String str;
        for (zal zalVar : this.f20244e) {
            if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                str = this.f20241b.getEndpointPackageName();
            } else {
                str = null;
            }
            zalVar.zac(this.f20242c, connectionResult, str);
        }
        this.f20244e.clear();
    }

    @WorkerThread
    public final void c(Status status) {
        Handler handler;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        d(status, null, false);
    }

    @WorkerThread
    private final void d(@Nullable Status status, @Nullable Exception exc, boolean z3) {
        Handler handler;
        boolean z4;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        boolean z5 = false;
        if (status != null) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (exc == null) {
            z5 = true;
        }
        if (z4 != z5) {
            Iterator it = this.f20240a.iterator();
            while (it.hasNext()) {
                zai zaiVar = (zai) it.next();
                if (!z3 || zaiVar.zac == 2) {
                    if (status != null) {
                        zaiVar.zad(status);
                    } else {
                        zaiVar.zae(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    @WorkerThread
    private final void e() {
        ArrayList arrayList = new ArrayList(this.f20240a);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            zai zaiVar = (zai) arrayList.get(i4);
            if (this.f20241b.isConnected()) {
                if (k(zaiVar)) {
                    this.f20240a.remove(zaiVar);
                }
            } else {
                return;
            }
        }
    }

    @WorkerThread
    public final void f() {
        zan();
        b(ConnectionResult.RESULT_SUCCESS);
        j();
        Iterator it = this.f20245f.values().iterator();
        while (it.hasNext()) {
            zaci zaciVar = (zaci) it.next();
            if (a(zaciVar.zaa.getRequiredFeatures()) != null) {
                it.remove();
            } else {
                try {
                    zaciVar.zaa.a(this.f20241b, new TaskCompletionSource<>());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.f20241b.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        e();
        h();
    }

    @WorkerThread
    public final void g(int i4) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        com.google.android.gms.common.internal.zal zalVar;
        zan();
        this.f20248i = true;
        this.f20243d.e(i4, this.f20241b.getLastDisconnectMessage());
        GoogleApiManager googleApiManager = this.f20252m;
        handler = googleApiManager.f20065n;
        handler2 = googleApiManager.f20065n;
        handler.sendMessageDelayed(Message.obtain(handler2, 9, this.f20242c), 5000L);
        GoogleApiManager googleApiManager2 = this.f20252m;
        handler3 = googleApiManager2.f20065n;
        handler4 = googleApiManager2.f20065n;
        handler3.sendMessageDelayed(Message.obtain(handler4, 11, this.f20242c), 120000L);
        zalVar = this.f20252m.f20058g;
        zalVar.zac();
        for (zaci zaciVar : this.f20245f.values()) {
            zaciVar.zac.run();
        }
    }

    private final void h() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        long j4;
        handler = this.f20252m.f20065n;
        handler.removeMessages(12, this.f20242c);
        GoogleApiManager googleApiManager = this.f20252m;
        handler2 = googleApiManager.f20065n;
        handler3 = googleApiManager.f20065n;
        Message obtainMessage = handler3.obtainMessage(12, this.f20242c);
        j4 = this.f20252m.f20052a;
        handler2.sendMessageDelayed(obtainMessage, j4);
    }

    @WorkerThread
    private final void i(zai zaiVar) {
        zaiVar.zag(this.f20243d, zaz());
        try {
            zaiVar.zaf(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.f20241b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    @WorkerThread
    private final void j() {
        Handler handler;
        Handler handler2;
        if (this.f20248i) {
            handler = this.f20252m.f20065n;
            handler.removeMessages(11, this.f20242c);
            handler2 = this.f20252m.f20065n;
            handler2.removeMessages(9, this.f20242c);
            this.f20248i = false;
        }
    }

    @WorkerThread
    private final boolean k(zai zaiVar) {
        boolean z3;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        if (!(zaiVar instanceof zac)) {
            i(zaiVar);
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature a4 = a(zacVar.zab(this));
        if (a4 == null) {
            i(zaiVar);
            return true;
        }
        String name = this.f20241b.getClass().getName();
        String name2 = a4.getName();
        long version = a4.getVersion();
        Log.w("GoogleApiManager", name + " could not execute call because it requires feature (" + name2 + ", " + version + ").");
        z3 = this.f20252m.f20066o;
        if (z3 && zacVar.zaa(this)) {
            zabs zabsVar = new zabs(this.f20242c, a4, null);
            int indexOf = this.f20249j.indexOf(zabsVar);
            if (indexOf >= 0) {
                zabs zabsVar2 = (zabs) this.f20249j.get(indexOf);
                handler5 = this.f20252m.f20065n;
                handler5.removeMessages(15, zabsVar2);
                GoogleApiManager googleApiManager = this.f20252m;
                handler6 = googleApiManager.f20065n;
                handler7 = googleApiManager.f20065n;
                handler6.sendMessageDelayed(Message.obtain(handler7, 15, zabsVar2), 5000L);
                return false;
            }
            this.f20249j.add(zabsVar);
            GoogleApiManager googleApiManager2 = this.f20252m;
            handler = googleApiManager2.f20065n;
            handler2 = googleApiManager2.f20065n;
            handler.sendMessageDelayed(Message.obtain(handler2, 15, zabsVar), 5000L);
            GoogleApiManager googleApiManager3 = this.f20252m;
            handler3 = googleApiManager3.f20065n;
            handler4 = googleApiManager3.f20065n;
            handler3.sendMessageDelayed(Message.obtain(handler4, 16, zabsVar), 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (!l(connectionResult)) {
                this.f20252m.d(connectionResult, this.f20246g);
                return false;
            }
            return false;
        }
        zacVar.zae(new UnsupportedApiCallException(a4));
        return true;
    }

    @WorkerThread
    private final boolean l(@NonNull ConnectionResult connectionResult) {
        Object obj;
        zaae zaaeVar;
        Set set;
        zaae zaaeVar2;
        obj = GoogleApiManager.f20050q;
        synchronized (obj) {
            GoogleApiManager googleApiManager = this.f20252m;
            zaaeVar = googleApiManager.f20062k;
            if (zaaeVar != null) {
                set = googleApiManager.f20063l;
                if (set.contains(this.f20242c)) {
                    zaaeVar2 = this.f20252m.f20062k;
                    zaaeVar2.zah(connectionResult, this.f20246g);
                    return true;
                }
            }
            return false;
        }
    }

    @WorkerThread
    public final boolean m(boolean z3) {
        Handler handler;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        if (!this.f20241b.isConnected() || this.f20245f.size() != 0) {
            return false;
        }
        if (this.f20243d.f()) {
            if (z3) {
                h();
            }
            return false;
        }
        this.f20241b.disconnect("Timing out service connection.");
        return true;
    }

    public static /* bridge */ /* synthetic */ ApiKey p(zabq zabqVar) {
        return zabqVar.f20242c;
    }

    public static /* bridge */ /* synthetic */ void q(zabq zabqVar, Status status) {
        zabqVar.c(status);
    }

    public static /* bridge */ /* synthetic */ void t(zabq zabqVar, zabs zabsVar) {
        if (zabqVar.f20249j.contains(zabsVar) && !zabqVar.f20248i) {
            if (!zabqVar.f20241b.isConnected()) {
                zabqVar.zao();
            } else {
                zabqVar.e();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void u(zabq zabqVar, zabs zabsVar) {
        Handler handler;
        Handler handler2;
        Feature feature;
        Feature[] zab;
        if (zabqVar.f20249j.remove(zabsVar)) {
            handler = zabqVar.f20252m.f20065n;
            handler.removeMessages(15, zabsVar);
            handler2 = zabqVar.f20252m.f20065n;
            handler2.removeMessages(16, zabsVar);
            feature = zabsVar.f20254b;
            ArrayList arrayList = new ArrayList(zabqVar.f20240a.size());
            for (zai zaiVar : zabqVar.f20240a) {
                if ((zaiVar instanceof zac) && (zab = ((zac) zaiVar).zab(zabqVar)) != null && ArrayUtils.contains(zab, feature)) {
                    arrayList.add(zaiVar);
                }
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                zai zaiVar2 = (zai) arrayList.get(i4);
                zabqVar.f20240a.remove(zaiVar2);
                zaiVar2.zae(new UnsupportedApiCallException(feature));
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean w(zabq zabqVar, boolean z3) {
        return zabqVar.m(false);
    }

    @WorkerThread
    public final int n() {
        return this.f20251l;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f20252m.f20065n;
        if (myLooper != handler.getLooper()) {
            handler2 = this.f20252m.f20065n;
            handler2.post(new zabm(this));
            return;
        }
        f();
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.f20252m.f20065n;
        if (myLooper != handler.getLooper()) {
            handler2 = this.f20252m.f20065n;
            handler2.post(new zabn(this, i4));
            return;
        }
        g(i4);
    }

    @WorkerThread
    public final void v() {
        this.f20251l++;
    }

    public final boolean x() {
        return this.f20241b.isConnected();
    }

    @ResultIgnorabilityUnspecified
    @WorkerThread
    public final boolean zaA() {
        return m(true);
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void zaa(ConnectionResult connectionResult, Api api, boolean z3) {
        throw null;
    }

    public final int zab() {
        return this.f20246g;
    }

    @Nullable
    @WorkerThread
    public final ConnectionResult zad() {
        Handler handler;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        return this.f20250k;
    }

    public final Api.Client zaf() {
        return this.f20241b;
    }

    public final Map zah() {
        return this.f20245f;
    }

    @WorkerThread
    public final void zan() {
        Handler handler;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        this.f20250k = null;
    }

    @WorkerThread
    public final void zao() {
        Handler handler;
        com.google.android.gms.common.internal.zal zalVar;
        Context context;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        if (!this.f20241b.isConnected() && !this.f20241b.isConnecting()) {
            try {
                GoogleApiManager googleApiManager = this.f20252m;
                zalVar = googleApiManager.f20058g;
                context = googleApiManager.f20056e;
                int zab = zalVar.zab(context, this.f20241b);
                if (zab != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(zab, null);
                    String name = this.f20241b.getClass().getName();
                    String obj = connectionResult.toString();
                    Log.w("GoogleApiManager", "The service for " + name + " is not available: " + obj);
                    zar(connectionResult, null);
                    return;
                }
                GoogleApiManager googleApiManager2 = this.f20252m;
                Api.Client client = this.f20241b;
                zabu zabuVar = new zabu(googleApiManager2, client, this.f20242c);
                if (client.requiresSignIn()) {
                    ((zact) Preconditions.checkNotNull(this.f20247h)).zae(zabuVar);
                }
                try {
                    this.f20241b.connect(zabuVar);
                } catch (SecurityException e4) {
                    zar(new ConnectionResult(10), e4);
                }
            } catch (IllegalStateException e5) {
                zar(new ConnectionResult(10), e5);
            }
        }
    }

    @WorkerThread
    public final void zap(zai zaiVar) {
        Handler handler;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        if (this.f20241b.isConnected()) {
            if (k(zaiVar)) {
                h();
                return;
            } else {
                this.f20240a.add(zaiVar);
                return;
            }
        }
        this.f20240a.add(zaiVar);
        ConnectionResult connectionResult = this.f20250k;
        if (connectionResult != null && connectionResult.hasResolution()) {
            zar(this.f20250k, null);
        } else {
            zao();
        }
    }

    @WorkerThread
    public final void zar(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
        Handler handler;
        com.google.android.gms.common.internal.zal zalVar;
        boolean z3;
        Status e4;
        Status e5;
        Status e6;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Status status;
        Handler handler5;
        Handler handler6;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        zact zactVar = this.f20247h;
        if (zactVar != null) {
            zactVar.zaf();
        }
        zan();
        zalVar = this.f20252m.f20058g;
        zalVar.zac();
        b(connectionResult);
        if ((this.f20241b instanceof com.google.android.gms.common.internal.service.zap) && connectionResult.getErrorCode() != 24) {
            this.f20252m.f20053b = true;
            GoogleApiManager googleApiManager = this.f20252m;
            handler5 = googleApiManager.f20065n;
            handler6 = googleApiManager.f20065n;
            handler5.sendMessageDelayed(handler6.obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            status = GoogleApiManager.f20049p;
            c(status);
        } else if (this.f20240a.isEmpty()) {
            this.f20250k = connectionResult;
        } else if (exc != null) {
            handler4 = this.f20252m.f20065n;
            Preconditions.checkHandlerThread(handler4);
            d(null, exc, false);
        } else {
            z3 = this.f20252m.f20066o;
            if (z3) {
                e5 = GoogleApiManager.e(this.f20242c, connectionResult);
                d(e5, null, true);
                if (!this.f20240a.isEmpty() && !l(connectionResult) && !this.f20252m.d(connectionResult, this.f20246g)) {
                    if (connectionResult.getErrorCode() == 18) {
                        this.f20248i = true;
                    }
                    if (!this.f20248i) {
                        e6 = GoogleApiManager.e(this.f20242c, connectionResult);
                        c(e6);
                        return;
                    }
                    GoogleApiManager googleApiManager2 = this.f20252m;
                    handler2 = googleApiManager2.f20065n;
                    handler3 = googleApiManager2.f20065n;
                    handler2.sendMessageDelayed(Message.obtain(handler3, 9, this.f20242c), 5000L);
                    return;
                }
                return;
            }
            e4 = GoogleApiManager.e(this.f20242c, connectionResult);
            c(e4);
        }
    }

    @WorkerThread
    public final void zas(@NonNull ConnectionResult connectionResult) {
        Handler handler;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        Api.Client client = this.f20241b;
        String name = client.getClass().getName();
        String valueOf = String.valueOf(connectionResult);
        client.disconnect("onSignInFailed for " + name + " with " + valueOf);
        zar(connectionResult, null);
    }

    @WorkerThread
    public final void zat(zal zalVar) {
        Handler handler;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        this.f20244e.add(zalVar);
    }

    @WorkerThread
    public final void zau() {
        Handler handler;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        if (this.f20248i) {
            zao();
        }
    }

    @WorkerThread
    public final void zav() {
        Handler handler;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        c(GoogleApiManager.zaa);
        this.f20243d.zaf();
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.f20245f.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zap(new zah(listenerKey, new TaskCompletionSource()));
        }
        b(new ConnectionResult(4));
        if (this.f20241b.isConnected()) {
            this.f20241b.onUserSignOut(new zabp(this));
        }
    }

    @WorkerThread
    public final void zaw() {
        Handler handler;
        GoogleApiAvailability googleApiAvailability;
        Context context;
        Status status;
        handler = this.f20252m.f20065n;
        Preconditions.checkHandlerThread(handler);
        if (this.f20248i) {
            j();
            GoogleApiManager googleApiManager = this.f20252m;
            googleApiAvailability = googleApiManager.f20057f;
            context = googleApiManager.f20056e;
            if (googleApiAvailability.isGooglePlayServicesAvailable(context) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            } else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            c(status);
            this.f20241b.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean zaz() {
        return this.f20241b.requiresSignIn();
    }
}
