package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* renamed from: g  reason: collision with root package name */
    private final WeakReference f20302g;

    /* renamed from: h  reason: collision with root package name */
    private final zacz f20303h;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private ResultTransform f20296a = null;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private zada f20297b = null;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private volatile ResultCallbacks f20298c = null;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private PendingResult f20299d = null;

    /* renamed from: e  reason: collision with root package name */
    private final Object f20300e = new Object();
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Status f20301f = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20304i = false;

    public zada(WeakReference weakReference) {
        Looper mainLooper;
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.f20302g = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        if (googleApiClient != null) {
            mainLooper = googleApiClient.getLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        this.f20303h = new zacz(this, mainLooper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Status status) {
        synchronized (this.f20300e) {
            this.f20301f = status;
            k(status);
        }
    }

    @GuardedBy("mSyncToken")
    private final void j() {
        if (this.f20296a == null && this.f20298c == null) {
            return;
        }
        GoogleApiClient googleApiClient = (GoogleApiClient) this.f20302g.get();
        if (!this.f20304i && this.f20296a != null && googleApiClient != null) {
            googleApiClient.zao(this);
            this.f20304i = true;
        }
        Status status = this.f20301f;
        if (status != null) {
            k(status);
            return;
        }
        PendingResult pendingResult = this.f20299d;
        if (pendingResult != null) {
            pendingResult.setResultCallback(this);
        }
    }

    private final void k(Status status) {
        synchronized (this.f20300e) {
            ResultTransform resultTransform = this.f20296a;
            if (resultTransform != null) {
                ((zada) Preconditions.checkNotNull(this.f20297b)).i((Status) Preconditions.checkNotNull(resultTransform.onFailure(status), "onFailure must not return null"));
            } else if (l()) {
                ((ResultCallbacks) Preconditions.checkNotNull(this.f20298c)).onFailure(status);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean l() {
        GoogleApiClient googleApiClient = (GoogleApiClient) this.f20302g.get();
        if (this.f20298c != null && googleApiClient != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e4) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e4);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z3;
        synchronized (this.f20300e) {
            boolean z4 = true;
            if (this.f20298c == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Cannot call andFinally() twice.");
            if (this.f20296a != null) {
                z4 = false;
            }
            Preconditions.checkState(z4, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f20298c = resultCallbacks;
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h() {
        this.f20298c = null;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        synchronized (this.f20300e) {
            if (result.getStatus().isSuccess()) {
                if (this.f20296a != null) {
                    zaco.zaa().submit(new zacy(this, result));
                } else if (l()) {
                    ((ResultCallbacks) Preconditions.checkNotNull(this.f20298c)).onSuccess(result);
                }
            } else {
                i(result.getStatus());
                m(result);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z3;
        zada zadaVar;
        synchronized (this.f20300e) {
            boolean z4 = true;
            if (this.f20296a == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Cannot call then() twice.");
            if (this.f20298c != null) {
                z4 = false;
            }
            Preconditions.checkState(z4, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f20296a = resultTransform;
            zadaVar = new zada(this.f20302g);
            this.f20297b = zadaVar;
            j();
        }
        return zadaVar;
    }

    public final void zai(PendingResult pendingResult) {
        synchronized (this.f20300e) {
            this.f20299d = pendingResult;
            j();
        }
    }
}
