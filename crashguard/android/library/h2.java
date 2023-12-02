package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h2 implements LocationListener {

    /* renamed from: d  reason: collision with root package name */
    private static h2 f38805d;

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f38806a;

    /* renamed from: b  reason: collision with root package name */
    private final z5 f38807b;

    /* renamed from: c  reason: collision with root package name */
    private final l2 f38808c;

    private h2(Context context) {
        i(context);
        this.f38808c = new l2(context);
        this.f38807b = new z5(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized h2 c(Context context) {
        h2 h2Var;
        synchronized (h2.class) {
            h2Var = f38805d;
            if (h2Var == null) {
                h2Var = new h2(context);
                f38805d = h2Var;
            } else {
                h2Var.i(context);
            }
        }
        return h2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x0012, B:9:0x0022, B:18:0x0039, B:20:0x0041), top: B:23:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(android.content.Context r8, android.location.LocationManager r9) {
        /*
            r7 = this;
            crashguard.android.library.y0 r0 = new crashguard.android.library.y0     // Catch: java.lang.Throwable -> L49
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L49
            crashguard.android.library.y1 r8 = r0.U()     // Catch: java.lang.Throwable -> L49
            if (r8 == 0) goto L10
            long r0 = r8.j()     // Catch: java.lang.Throwable -> L49
            goto L12
        L10:
            r0 = 0
        L12:
            java.lang.String r8 = "gps"
            android.location.Location r8 = r9.getLastKnownLocation(r8)     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = "network"
            android.location.Location r9 = r9.getLastKnownLocation(r2)     // Catch: java.lang.Throwable -> L49
            if (r8 == 0) goto L2f
            if (r9 == 0) goto L2f
            long r2 = r8.getTime()     // Catch: java.lang.Throwable -> L49
            long r4 = r9.getTime()     // Catch: java.lang.Throwable -> L49
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L34
            goto L37
        L2f:
            if (r8 == 0) goto L32
            goto L37
        L32:
            if (r9 == 0) goto L36
        L34:
            r8 = r9
            goto L37
        L36:
            r8 = 0
        L37:
            if (r8 == 0) goto L49
            long r2 = r8.getTime()     // Catch: java.lang.Throwable -> L49
            int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r9 <= 0) goto L49
            crashguard.android.library.g2 r9 = new crashguard.android.library.g2     // Catch: java.lang.Throwable -> L49
            r9.<init>()     // Catch: java.lang.Throwable -> L49
            crashguard.android.library.p1.a(r9)     // Catch: java.lang.Throwable -> L49
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: crashguard.android.library.h2.e(android.content.Context, android.location.LocationManager):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Location location) {
        float f4;
        try {
            this.f38808c.c(location);
            if (Build.VERSION.SDK_INT > 25) {
                f4 = location.getVerticalAccuracyMeters();
            } else {
                f4 = 0.0f;
            }
            y1 y1Var = new y1(location, location.getTime() + 604800000, f4);
            new d5(this.f38806a.get()).e(y1Var);
            new b6(this.f38806a.get()).c(y1Var);
        } catch (Throwable unused) {
        }
    }

    private void i(Context context) {
        this.f38806a = new WeakReference<>(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Location location) {
        float f4;
        try {
            this.f38808c.c(location);
            if (Build.VERSION.SDK_INT > 25) {
                f4 = location.getVerticalAccuracyMeters();
            } else {
                f4 = 0.0f;
            }
            y1 y1Var = new y1(location, location.getTime() + 604800000, f4);
            new d5(this.f38806a.get()).e(y1Var);
            new b6(this.f38806a.get()).c(y1Var);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public final void d() {
        try {
            Context context = this.f38806a.get();
            if (this.f38807b.f() || this.f38807b.e()) {
                LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
                e(context, locationManager);
                locationManager.requestLocationUpdates("passive", 2500L, 5.0f, this);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public final void g(LocationListener locationListener) {
        try {
            if (this.f38807b.f() || this.f38807b.e()) {
                LocationManager locationManager = (LocationManager) this.f38806a.get().getSystemService(FirebaseAnalytics.Param.LOCATION);
                if (locationManager.isProviderEnabled("gps")) {
                    locationManager.requestLocationUpdates("gps", 2500L, 0.0f, locationListener);
                }
                if (locationManager.isProviderEnabled("network")) {
                    locationManager.requestLocationUpdates("network", 2500L, 0.0f, locationListener);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public final void h(LocationListener... locationListenerArr) {
        try {
            LocationManager locationManager = (LocationManager) this.f38806a.get().getSystemService(FirebaseAnalytics.Param.LOCATION);
            if (this.f38807b.f() || this.f38807b.e()) {
                for (LocationListener locationListener : locationListenerArr) {
                    locationManager.removeUpdates(locationListener);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(@NonNull final Location location) {
        if (this.f38806a.get() != null) {
            p1.a(new Runnable() { // from class: crashguard.android.library.f2
                @Override // java.lang.Runnable
                public final void run() {
                    h2.this.j(location);
                }
            });
        }
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
