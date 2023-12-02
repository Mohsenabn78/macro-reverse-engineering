package crashguard.android.library;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class a5 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38613a;

    /* renamed from: b  reason: collision with root package name */
    private final z5 f38614b;

    /* renamed from: c  reason: collision with root package name */
    private final w4 f38615c = new w4();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a5(Context context, z5 z5Var) {
        this.f38613a = new WeakReference<>(context);
        this.f38614b = z5Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:26|27|28|29|30|(2:34|(8:36|37|38|(1:44)|46|47|(3:56|(1:62)|63)(1:53)|54))|66|(1:72)|37|38|(3:40|42|44)|46|47|(1:49)|56|(4:58|60|62|54)|63|54) */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0221 -> B:97:0x0228). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final crashguard.android.library.w4 a(boolean r27) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: crashguard.android.library.a5.a(boolean):crashguard.android.library.w4");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j4) {
        List<h5> s3 = this.f38615c.s();
        if (s3 != null) {
            for (h5 h5Var : s3) {
                h5Var.b(h5Var.n() + j4);
            }
        }
        if (this.f38615c.a() != null) {
            for (g1 g1Var : this.f38615c.a()) {
                g1Var.d(g1Var.x() + j4);
            }
        }
    }
}
