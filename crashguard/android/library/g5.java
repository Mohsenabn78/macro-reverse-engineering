package crashguard.android.library;

import android.content.Context;
import com.facebook.stetho.dumpapp.Framer;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
final class g5 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38767a;

    /* renamed from: b  reason: collision with root package name */
    private final j6 f38768b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g5(Context context) {
        this.f38767a = new WeakReference<>(context);
        this.f38768b = new j6(context);
    }

    @Override // crashguard.android.library.f0
    public final void a() throws Throwable {
        try {
            Context context = this.f38767a.get();
            String str = "crashguard.android.library.crashguard.db";
            String[] strArr = {str, String.format(new String(new byte[]{37, 115, Framer.STDIN_FRAME_PREFIX, 115, 104, 109}), str), String.format(new String(new byte[]{37, 115, Framer.STDIN_FRAME_PREFIX, 119, 97, 108}), str), String.format(new String(new byte[]{37, 115, Framer.STDIN_FRAME_PREFIX, 106, 111, 117, 114, 110, 97, 108}), str)};
            for (int i4 = 0; i4 < 4; i4++) {
                String str2 = strArr[i4];
                File databasePath = context.getDatabasePath(str2);
                if (databasePath.exists()) {
                    databasePath.renameTo(context.getDatabasePath(new File(context.getNoBackupFilesDir(), str2).getPath()));
                }
            }
        } catch (Throwable unused) {
        }
        this.f38768b.b();
    }
}
