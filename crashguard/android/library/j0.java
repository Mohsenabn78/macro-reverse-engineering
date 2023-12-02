package crashguard.android.library;

import android.app.ActivityManager;
import android.content.Context;
import java.lang.Thread;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38855a;

    /* renamed from: b  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f38856b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f38855a = new WeakReference<>(context.getApplicationContext());
        this.f38856b = uncaughtExceptionHandler;
    }

    private static Class a(Throwable th, Class cls) {
        for (int i4 = 0; i4 < 15 && th != null; i4++) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                try {
                    for (Class<?> cls2 = Class.forName(stackTraceElement.getClassName()); cls2 != null; cls2 = cls2.getEnclosingClass()) {
                        if (cls.isAssignableFrom(cls2)) {
                            return cls2;
                        }
                    }
                    continue;
                } catch (Throwable unused) {
                }
            }
            th = th.getCause();
        }
        return null;
    }

    private static void b(Context context) {
        for (ActivityManager.AppTask appTask : ((ActivityManager) context.getSystemService("activity")).getAppTasks()) {
            appTask.finishAndRemoveTask();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void uncaughtException(@androidx.annotation.NonNull java.lang.Thread r12, @androidx.annotation.NonNull java.lang.Throwable r13) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: crashguard.android.library.j0.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
