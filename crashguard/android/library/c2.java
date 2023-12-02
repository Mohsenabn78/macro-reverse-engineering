package crashguard.android.library;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
final class c2 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38683a;

    /* renamed from: b  reason: collision with root package name */
    private final z1 f38684b;

    /* renamed from: c  reason: collision with root package name */
    private final i2 f38685c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c2(Context context) {
        this.f38683a = new WeakReference<>(context);
        this.f38685c = i2.d(context);
        z1 z1Var = new z1();
        z1Var.b(new g5(context));
        this.f38684b = z1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        try {
            Context context = this.f38683a.get();
            boolean z3 = false;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                z3 = true;
            }
            if (z3) {
                long c4 = this.f38685c.c();
                if (c4 < 33) {
                    while (c4 < 33) {
                        c4++;
                        f0 a4 = this.f38684b.a(c4);
                        if (a4 != null) {
                            a4.a();
                        }
                        this.f38685c.e(c4);
                    }
                    this.f38685c.f38623b.apply();
                    return;
                }
                return;
            }
            this.f38685c.f();
        } catch (Throwable unused) {
        }
    }
}
