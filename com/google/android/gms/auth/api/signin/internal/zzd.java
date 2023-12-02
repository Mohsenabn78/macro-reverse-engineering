package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public final class zzd extends AsyncTaskLoader<Void> implements SignInConnectionListener {

    /* renamed from: a  reason: collision with root package name */
    private Semaphore f19862a;

    /* renamed from: b  reason: collision with root package name */
    private Set<GoogleApiClient> f19863b;

    public zzd(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.f19862a = new Semaphore(0);
        this.f19863b = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.loader.content.AsyncTaskLoader
    /* renamed from: a */
    public final Void loadInBackground() {
        int i4 = 0;
        for (GoogleApiClient googleApiClient : this.f19863b) {
            if (googleApiClient.maybeSignIn(this)) {
                i4++;
            }
        }
        try {
            this.f19862a.tryAcquire(i4, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e4) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e4);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        this.f19862a.release();
    }

    @Override // androidx.loader.content.Loader
    protected final void onStartLoading() {
        this.f19862a.drainPermits();
        forceLoad();
    }
}
