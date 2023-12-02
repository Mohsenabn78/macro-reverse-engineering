package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.compose.animation.core.d;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    protected volatile boolean f20328a;

    /* renamed from: b  reason: collision with root package name */
    protected final AtomicReference f20329b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f20330c;

    /* renamed from: d  reason: collision with root package name */
    protected final GoogleApiAvailability f20331d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.f20329b = new AtomicReference(null);
        this.f20330c = new com.google.android.gms.internal.base.zau(Looper.getMainLooper());
        this.f20331d = googleApiAvailability;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ConnectionResult connectionResult, int i4) {
        this.f20329b.set(null);
        b(connectionResult, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        this.f20329b.set(null);
        c();
    }

    private static final int e(@Nullable zam zamVar) {
        if (zamVar == null) {
            return -1;
        }
        return zamVar.a();
    }

    protected abstract void b(ConnectionResult connectionResult, int i4);

    protected abstract void c();

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i4, int i5, Intent intent) {
        zam zamVar = (zam) this.f20329b.get();
        if (i4 != 1) {
            if (i4 == 2) {
                int isGooglePlayServicesAvailable = this.f20331d.isGooglePlayServicesAvailable(getActivity());
                if (isGooglePlayServicesAvailable == 0) {
                    d();
                    return;
                } else if (zamVar == null) {
                    return;
                } else {
                    if (zamVar.b().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                        return;
                    }
                }
            }
        } else if (i5 == -1) {
            d();
            return;
        } else if (i5 == 0) {
            if (zamVar == null) {
                return;
            }
            int i6 = 13;
            if (intent != null) {
                i6 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
            }
            a(new ConnectionResult(i6, null, zamVar.b().toString()), e(zamVar));
            return;
        }
        if (zamVar != null) {
            a(zamVar.b(), zamVar.a());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, null), e((zam) this.f20329b.get()));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(@Nullable Bundle bundle) {
        zam zamVar;
        super.onCreate(bundle);
        if (bundle != null) {
            AtomicReference atomicReference = this.f20329b;
            if (bundle.getBoolean("resolving_error", false)) {
                zamVar = new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                zamVar = null;
            }
            atomicReference.set(zamVar);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zamVar = (zam) this.f20329b.get();
        if (zamVar == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", zamVar.a());
        bundle.putInt("failed_status", zamVar.b().getErrorCode());
        bundle.putParcelable("failed_resolution", zamVar.b().getResolution());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.f20328a = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.f20328a = false;
    }

    public final void zah(ConnectionResult connectionResult, int i4) {
        zam zamVar = new zam(connectionResult, i4);
        AtomicReference atomicReference = this.f20329b;
        while (!d.a(atomicReference, null, zamVar)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.f20330c.post(new zao(this, zamVar));
    }
}
