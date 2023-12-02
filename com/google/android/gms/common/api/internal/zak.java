package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zak extends zap {

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray f20316e;

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.f20316e = new SparseArray();
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    @Nullable
    private final zaj h(int i4) {
        if (this.f20316e.size() <= i4) {
            return null;
        }
        SparseArray sparseArray = this.f20316e;
        return (zaj) sparseArray.get(sparseArray.keyAt(i4));
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zakVar = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        if (zakVar != null) {
            return zakVar;
        }
        return new zak(fragment);
    }

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void b(ConnectionResult connectionResult, int i4) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i4 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaj zajVar = (zaj) this.f20316e.get(i4);
        if (zajVar != null) {
            zae(i4);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zajVar.f20314c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void c() {
        for (int i4 = 0; i4 < this.f20316e.size(); i4++) {
            zaj h4 = h(i4);
            if (h4 != null) {
                h4.f20313b.connect();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i4 = 0; i4 < this.f20316e.size(); i4++) {
            zaj h4 = h(i4);
            if (h4 != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(h4.f20312a);
                printWriter.println(":");
                h4.f20313b.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        boolean z3 = this.f20328a;
        String valueOf = String.valueOf(this.f20316e);
        StringBuilder sb = new StringBuilder();
        sb.append("onStart ");
        sb.append(z3);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(valueOf);
        if (this.f20329b.get() == null) {
            for (int i4 = 0; i4 < this.f20316e.size(); i4++) {
                zaj h4 = h(i4);
                if (h4 != null) {
                    h4.f20313b.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        for (int i4 = 0; i4 < this.f20316e.size(); i4++) {
            zaj h4 = h(i4);
            if (h4 != null) {
                h4.f20313b.disconnect();
            }
        }
    }

    public final void zad(int i4, GoogleApiClient googleApiClient, @Nullable GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean z3;
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        String str = "Already managing a GoogleApiClient with id " + i4;
        if (this.f20316e.indexOfKey(i4) < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        zam zamVar = (zam) this.f20329b.get();
        boolean z4 = this.f20328a;
        String valueOf = String.valueOf(zamVar);
        StringBuilder sb = new StringBuilder();
        sb.append("starting AutoManage for client ");
        sb.append(i4);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(z4);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(valueOf);
        zaj zajVar = new zaj(this, i4, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(zajVar);
        this.f20316e.put(i4, zajVar);
        if (this.f20328a && zamVar == null) {
            "connecting ".concat(googleApiClient.toString());
            googleApiClient.connect();
        }
    }

    public final void zae(int i4) {
        zaj zajVar = (zaj) this.f20316e.get(i4);
        this.f20316e.remove(i4);
        if (zajVar != null) {
            zajVar.f20313b.unregisterConnectionFailedListener(zajVar);
            zajVar.f20313b.disconnect();
        }
    }
}
