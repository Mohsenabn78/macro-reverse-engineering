package crashguard.android.library;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class d1 {

    /* renamed from: a  reason: collision with root package name */
    protected final WeakReference<Context> f38690a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d1(Context context) {
        this.f38690a = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        j jVar = new j(this.f38690a.get());
        jVar.c(UUID.randomUUID().toString());
        jVar.b(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h1 b(Thread thread, Throwable th) {
        return new h1(th, thread.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(final String str) {
        p1.a(new Runnable() { // from class: crashguard.android.library.c1
            @Override // java.lang.Runnable
            public final void run() {
                d1.this.c(str);
            }
        });
    }
}
