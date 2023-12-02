package crashguard.android.library;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    protected final WeakReference<Context> f38886a;

    /* renamed from: b  reason: collision with root package name */
    protected final x0 f38887b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this.f38886a = new WeakReference<>(context);
        this.f38887b = new x0(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 21)
    public static PersistableBundle a(Bundle bundle) {
        PersistableBundle persistableBundle = new PersistableBundle();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Integer) {
                persistableBundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof int[]) {
                persistableBundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof Long) {
                persistableBundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof long[]) {
                persistableBundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof Double) {
                persistableBundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof double[]) {
                persistableBundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof String) {
                persistableBundle.putString(str, (String) obj);
            } else if (obj instanceof String[]) {
                persistableBundle.putStringArray(str, (String[]) obj);
            } else if (obj instanceof Boolean) {
                if (Build.VERSION.SDK_INT > 21) {
                    persistableBundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else {
                    persistableBundle.putInt(str, ((Boolean) obj).booleanValue() ? 1 : 0);
                }
            }
        }
        return persistableBundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k b(Context context) {
        return new k1(context);
    }

    protected abstract boolean c(int i4);

    protected abstract boolean d(int i4, Bundle bundle);

    protected abstract boolean e(int i4, Bundle bundle, long j4);

    protected abstract boolean f(int i4, Bundle bundle, long j4, long j5);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean g(c0 c0Var) {
        Bundle bundle = new Bundle();
        bundle.putString(c0.f38662n, c0Var.h());
        if (c0Var.A()) {
            return f(c0Var.s(), bundle, c0Var.l(), c0Var.n());
        }
        if (c0Var.z()) {
            return e(c0Var.s(), bundle, c0Var.l());
        }
        return d(c0Var.s(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(String str, c0 c0Var) {
        boolean z3;
        h0 o4 = t4.f(this.f38886a.get()).o();
        c0 b4 = o4.b(str);
        if (b4 == null) {
            c0Var.i(this.f38887b.a());
            o4.g(str, c0Var);
            return g(c0Var);
        }
        if (Math.abs(b4.u() - System.currentTimeMillis()) > 86399999) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        c0Var.f(b4.h());
        c0Var.i(b4.s());
        o4.j(c0Var);
        c(b4.s());
        return g(c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(c0 c0Var) {
        try {
            c0Var.i(this.f38887b.a());
            t4.f(this.f38886a.get()).o().j(c0Var);
            return g(c0Var);
        } catch (Throwable unused) {
            return false;
        }
    }
}
