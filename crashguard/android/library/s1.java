package crashguard.android.library;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.SecretKey;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class s1 {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList f39033a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private final x1 f39034b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s1(Context context, SecretKey secretKey) {
        this.f39034b = new x1(context, secretKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<h1> a(String str) {
        if (!"4".equalsIgnoreCase(str)) {
            this.f39033a = this.f39034b.b();
        }
        return this.f39033a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (this.f39033a.size() > 0) {
            for (h1 h1Var : this.f39033a) {
                try {
                    this.f39034b.d(h1Var.h());
                } catch (Throwable unused) {
                }
            }
        }
    }
}
