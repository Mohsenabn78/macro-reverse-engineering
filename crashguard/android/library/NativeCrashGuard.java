package crashguard.android.library;

import android.content.Context;
import java.io.ByteArrayInputStream;

/* loaded from: classes6.dex */
class NativeCrashGuard {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeCrashGuard() throws UnsatisfiedLinkError {
        c();
    }

    private static void c() throws UnsatisfiedLinkError {
        System.loadLibrary("CrashGuard");
    }

    private native byte[] get(int i4);

    private native boolean measure(Context context, String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteArrayInputStream a() {
        return new ByteArrayInputStream(get(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Context context, String str, String str2) {
        measure(context, str, str2);
    }
}
