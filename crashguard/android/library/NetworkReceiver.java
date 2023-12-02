package crashguard.android.library;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes6.dex */
public class NetworkReceiver extends i6 {

    /* renamed from: b  reason: collision with root package name */
    private y0 f38603b;

    /* renamed from: c  reason: collision with root package name */
    private z5 f38604c;

    /* renamed from: d  reason: collision with root package name */
    private v1 f38605d;

    /* renamed from: e  reason: collision with root package name */
    private b6 f38606e;

    /* renamed from: f  reason: collision with root package name */
    private long f38607f = SystemClock.elapsedRealtime() + 10000;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f38605d.g();
    }

    private void f(Context context, int i4) {
        if (this.f38604c.f() || this.f38604c.e()) {
            if (this.f38605d == null) {
                this.f38605d = new v1(context);
            }
            if (this.f38606e == null) {
                this.f38606e = new b6(context);
            }
            if (i4 == 1) {
                p1.a(new Runnable() { // from class: crashguard.android.library.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        NetworkReceiver.this.e();
                    }
                });
            } else {
                p1.a(new Runnable() { // from class: crashguard.android.library.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        NetworkReceiver.this.g();
                    }
                });
            }
        }
        if (k6.d(this.f38603b.b0())) {
            i(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f38606e.c(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Context context) {
        j jVar = new j(context, ExifInterface.GPS_MEASUREMENT_2D, true);
        jVar.c(UUID.randomUUID().toString());
        jVar.a();
    }

    private static void i(final Context context) {
        p1.a(new Runnable() { // from class: crashguard.android.library.d
            @Override // java.lang.Runnable
            public final void run() {
                NetworkReceiver.h(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // crashguard.android.library.i6
    public final boolean a(Context context) {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return super.a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // crashguard.android.library.i6
    public final String[] getActions() {
        ArrayList arrayList = new ArrayList(2);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 23) {
            arrayList.add("android.net.conn.CONNECTIVITY_CHANGE");
        }
        if (i4 > 25) {
            arrayList.add("android.net.wifi.STATE_CHANGE");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // crashguard.android.library.i6, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z3;
        super.onReceive(context, intent);
        boolean z4 = false;
        if (!n0.b() && !Debug.isDebuggerConnected()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 || new e1(context).e() == null || isInitialStickyBroadcast() || this.f38607f > SystemClock.elapsedRealtime()) {
            return;
        }
        if (this.f38603b == null) {
            this.f38603b = new y0(context);
        }
        if (this.f38604c == null) {
            this.f38604c = new z5(context);
        }
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.net.wifi.STATE_CHANGE".equals(action)) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            z4 = (networkInfo.getType() == 1 || networkInfo.getType() == 0) ? true : true;
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED && z4) {
                this.f38607f = SystemClock.elapsedRealtime() + 10000;
                f(context, networkInfo.getType());
            }
        }
    }
}
