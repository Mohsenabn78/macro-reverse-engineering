package crashguard.android.library;

import android.content.Context;

/* loaded from: classes6.dex */
final class i2 extends b0 {

    /* renamed from: d  reason: collision with root package name */
    private static i2 f38830d;

    /* renamed from: c  reason: collision with root package name */
    private final String f38831c;

    private i2(Context context) {
        super(context, "crashguard.android.library.versioning");
        this.f38831c = "version";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized i2 d(Context context) {
        i2 i2Var;
        synchronized (i2.class) {
            if (f38830d == null) {
                f38830d = new i2(context);
            }
            i2Var = f38830d;
        }
        return i2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long c() {
        return this.f38622a.getLong(this.f38831c, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(long j4) {
        a(this.f38831c, j4, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        a(this.f38831c, 33L, true);
    }
}
