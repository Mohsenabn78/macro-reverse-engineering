package crashguard.android.library;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.facebook.stetho.dumpapp.Framer;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes6.dex */
final class j6 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38885a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j6(Context context) {
        this.f38885a = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, int i4) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String processName;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 > 32) {
            return Process.myProcessName();
        }
        if (i5 > 27) {
            processName = Application.getProcessName();
            return processName;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i4) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
        return "";
    }

    private void c(Class<?> cls) {
        try {
            Method declaredMethod = cls.getDeclaredMethod("getInstance", Context.class);
            Object[] objArr = new Object[1];
            try {
                objArr[0] = this.f38885a.get();
                Object invoke = declaredMethod.invoke(null, objArr);
                try {
                    String str = "crashguard.android.library";
                    Method declaredMethod2 = cls.getDeclaredMethod("cancelAllWorkByTag", String.class);
                    try {
                        declaredMethod2.invoke(invoke, String.format("%s.HeartbeatWorker", str));
                    } catch (Throwable unused) {
                    }
                    declaredMethod2.invoke(invoke, String.format("%s.CrashWorker", str));
                } catch (Throwable unused2) {
                }
                cls.getDeclaredMethod("pruneWork", new Class[0]).invoke(invoke, new Object[0]);
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
        }
    }

    private static Class d() {
        try {
            return Class.forName(new String(new byte[]{97, 110, 100, 114, 111, 105, 100, Framer.EXIT_FRAME_PREFIX, 46, 119, 111, 114, 107, 46, 87, 111, 114, 107, 77, 97, 110, 97, 103, 101, 114}));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        try {
            Class<?> d4 = d();
            if (d4 == null) {
                String str = new String(new byte[]{97, 110, 100, 114, 111, 105, 100, Framer.EXIT_FRAME_PREFIX, 46, 119, 111, 114, 107, 46, 119, 111, 114, 107, 100, 98});
                String[] strArr = {str, String.format(new String(new byte[]{37, 115, Framer.STDIN_FRAME_PREFIX, 115, 104, 109}), str), String.format(new String(new byte[]{37, 115, Framer.STDIN_FRAME_PREFIX, 119, 97, 108}), str), String.format(new String(new byte[]{37, 115, Framer.STDIN_FRAME_PREFIX, 106, 111, 117, 114, 110, 97, 108}), str)};
                Context context = this.f38885a.get();
                for (int i4 = 0; i4 < 4; i4++) {
                    File databasePath = context.getDatabasePath(new File(context.getNoBackupFilesDir(), strArr[i4]).getPath());
                    if (databasePath.exists()) {
                        context.deleteDatabase(databasePath.getPath());
                    }
                }
                return;
            }
            c(d4);
        } catch (Throwable unused) {
        }
    }
}
