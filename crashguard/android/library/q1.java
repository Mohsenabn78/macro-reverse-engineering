package crashguard.android.library;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class q1 implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f39022a;

    /* renamed from: b  reason: collision with root package name */
    private final v1 f39023b;

    /* renamed from: c  reason: collision with root package name */
    private final g1 f39024c;

    /* renamed from: d  reason: collision with root package name */
    private int f39025d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q1(Context context, v1 v1Var, g1 g1Var) {
        this.f39024c = g1Var;
        this.f39023b = v1Var;
        this.f39022a = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Location location) {
        boolean z3;
        boolean z4;
        float f4;
        int i4 = this.f39025d;
        try {
            if (i4 > 4) {
                h2.c(this.f39022a.get()).h(this);
                return;
            }
            this.f39025d = i4 + 1;
            boolean equals = location.getProvider().equals("network");
            if (location.getAccuracy() <= 2500.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean equals2 = location.getProvider().equals("gps");
            if (location.getAccuracy() <= 20.0f) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((equals2 && z4) || (equals && z3)) {
                Context context = this.f39022a.get();
                h2.c(context).h(this);
                new l2(context).c(location);
                if (Build.VERSION.SDK_INT > 25) {
                    f4 = location.getVerticalAccuracyMeters();
                } else {
                    f4 = 0.0f;
                }
                this.f39024c.d(location.getTime());
                this.f39024c.c(location.getBearing());
                this.f39024c.k(location.getSpeed());
                this.f39024c.h(location.getAccuracy());
                this.f39024c.m(f4);
                this.f39024c.b(location.getLatitude());
                this.f39024c.g(location.getLongitude());
                this.f39024c.i(location.getProvider());
                this.f39023b.d(this.f39024c);
                new d5(context).e(new y1(location, location.getTime() + 604800000, f4));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(@NonNull final Location location) {
        p1.a(new Runnable() { // from class: crashguard.android.library.m1
            @Override // java.lang.Runnable
            public final void run() {
                q1.this.b(location);
            }
        });
    }

    @Override // android.location.LocationListener
    public final void onFlushComplete(int i4) {
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(@NonNull String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(@NonNull String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i4, Bundle bundle) {
    }
}
