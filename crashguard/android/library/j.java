package crashguard.android.library;

import android.content.Context;
import android.os.Debug;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.SecretKey;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38851a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38852b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38853c;

    /* renamed from: d  reason: collision with root package name */
    private String f38854d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context) {
        this(context, ExifInterface.GPS_MEASUREMENT_3D, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        boolean z3;
        try {
            Context context = this.f38851a.get();
            SecretKey b4 = o1.b(context, new k2());
            if (!n0.b() && !Debug.isDebuggerConnected()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                return false;
            }
            String name = t.class.getName();
            a6 m4 = t4.f(context).m();
            if (m4.a(name, this.f38854d).a()) {
                s1 s1Var = new s1(context, b4);
                List<h1> a4 = s1Var.a(this.f38852b);
                HashSet hashSet = new HashSet();
                LinkedList linkedList = (LinkedList) a4;
                for (int size = linkedList.size() - 1; size > -1 && hashSet.size() < 100; size--) {
                    hashSet.add((h1) linkedList.get(size));
                }
                new k6(context, new LinkedList(hashSet)).c(this.f38852b, this.f38853c);
                s1Var.b();
                m4.d(name);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(String str) {
        try {
            Context context = this.f38851a.get();
            k2 k2Var = new k2();
            x1 x1Var = new x1(context, k2Var, o1.b(context, k2Var));
            h1 e4 = x1Var.e(str);
            if (e4 == null) {
                return false;
            }
            new k6(context, e4).c(ExifInterface.GPS_MEASUREMENT_3D, false);
            x1Var.d(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(String str) {
        this.f38854d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, String str, boolean z3) {
        String str2 = "HeartbeatService";
        this.f38854d = null;
        this.f38851a = new WeakReference<>(context);
        this.f38852b = str;
        this.f38853c = z3;
    }
}
