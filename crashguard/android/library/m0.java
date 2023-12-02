package crashguard.android.library;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
abstract class m0 {

    /* renamed from: a  reason: collision with root package name */
    private final c0 f38943a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f38944b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(Context context, c0 c0Var) {
        this.f38944b = new WeakReference<>(context);
        this.f38943a = c0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context b() {
        return this.f38944b.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String c() {
        return this.f38943a.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s0 d() {
        return this.f38943a.x();
    }
}
