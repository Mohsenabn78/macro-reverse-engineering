package crashguard.android.library;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class t extends m0 {

    /* renamed from: c  reason: collision with root package name */
    static final String f39035c = "worker.reason";

    /* renamed from: d  reason: collision with root package name */
    static final String f39036d = "worker.honor.interval";

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Context context, c0 c0Var) {
        super(context, c0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // crashguard.android.library.m0
    public final boolean a() {
        boolean z3;
        s0 d4 = d();
        String str = "1";
        if (d4 != null) {
            String e4 = d4.e(f39035c);
            if (e4 != null) {
                str = e4;
            }
            z3 = d4.c(f39036d);
        } else {
            z3 = true;
        }
        j jVar = new j(b(), str, z3);
        jVar.c(c());
        return jVar.a();
    }
}
