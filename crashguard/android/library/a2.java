package crashguard.android.library;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class a2 extends m0 {

    /* renamed from: c  reason: collision with root package name */
    static String f38612c = "worker.crash.id";

    /* JADX INFO: Access modifiers changed from: package-private */
    public a2(Context context, c0 c0Var) {
        super(context, c0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // crashguard.android.library.m0
    public final boolean a() {
        String e4 = d().e(f38612c);
        if (e4 != null && !e4.trim().isEmpty()) {
            j jVar = new j(b());
            jVar.c(c());
            return jVar.b(e4);
        }
        return false;
    }
}
