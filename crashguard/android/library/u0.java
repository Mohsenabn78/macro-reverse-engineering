package crashguard.android.library;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
abstract class u0 {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<Context> f39063a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(Context context) {
        a(context);
    }

    protected final void a(Context context) {
        this.f39063a = new WeakReference<>(context.getApplicationContext());
    }
}
