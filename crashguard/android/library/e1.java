package crashguard.android.library;

import android.content.Context;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;
import java.security.PrivateKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class e1 extends b0 {

    /* renamed from: c  reason: collision with root package name */
    private final String f38708c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<Context> f38709d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(Context context) {
        super(context, ".crashguard.android.library.config");
        this.f38708c = new String(new byte[]{55, 102, 99, 53, 54, Framer.STDERR_FRAME_PREFIX, 55, 48, 101, 55, 97, 55, 48, 102, 97, 56, Framer.STDOUT_FRAME_PREFIX, 97, 53, 57, 51, 53, 98, 55, Framer.STDERR_FRAME_PREFIX, 101, 97, 99, 98, 101, Framer.STDERR_FRAME_PREFIX, 57});
        this.f38709d = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return this.f38622a.getString(this.f38708c, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str) {
        b(this.f38708c, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecretKeySpec e() {
        String c4;
        try {
            PrivateKey a4 = new o1(this.f38709d.get()).a();
            if (a4 != null && (c4 = c()) != null) {
                return k2.e(c4, a4);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
