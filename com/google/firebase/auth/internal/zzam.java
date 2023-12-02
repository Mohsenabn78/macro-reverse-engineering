package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzam {

    /* renamed from: h  reason: collision with root package name */
    private static final Logger f28984h = new Logger("TokenRefresher", "FirebaseAuth:");

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f28985a;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    volatile long f28986b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    volatile long f28987c;
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    final long f28988d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    final HandlerThread f28989e;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    final Handler f28990f;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    final Runnable f28991g;

    public zzam(FirebaseApp firebaseApp) {
        f28984h.v("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.f28985a = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.f28989e = handlerThread;
        handlerThread.start();
        this.f28990f = new com.google.android.gms.internal.p002firebaseauthapi.zzc(handlerThread.getLooper());
        this.f28991g = new zzal(this, firebaseApp2.getName());
        this.f28988d = 300000L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        long j4;
        int i4 = (int) this.f28987c;
        if (i4 != 30 && i4 != 60 && i4 != 120 && i4 != 240 && i4 != 480) {
            if (i4 != 960) {
                j4 = 30;
            } else {
                j4 = 960;
            }
        } else {
            long j5 = this.f28987c;
            j4 = j5 + j5;
        }
        this.f28987c = j4;
        this.f28986b = DefaultClock.getInstance().currentTimeMillis() + (this.f28987c * 1000);
        Logger logger = f28984h;
        long j6 = this.f28986b;
        logger.v("Scheduling refresh for " + j6, new Object[0]);
        this.f28990f.postDelayed(this.f28991g, this.f28987c * 1000);
    }

    public final void zzb() {
        this.f28990f.removeCallbacks(this.f28991g);
    }

    public final void zzc() {
        Logger logger = f28984h;
        long j4 = this.f28986b - this.f28988d;
        logger.v("Scheduling refresh for " + j4, new Object[0]);
        zzb();
        this.f28987c = Math.max((this.f28986b - DefaultClock.getInstance().currentTimeMillis()) - this.f28988d, 0L) / 1000;
        this.f28990f.postDelayed(this.f28991g, this.f28987c * 1000);
    }
}
