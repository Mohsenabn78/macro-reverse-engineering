package com.twofortyfouram.log;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import com.twofortyfouram.spackle.AppBuildInfo;
import com.twofortyfouram.spackle.ContextUtil;
import com.twofortyfouram.spackle.R;
import com.twofortyfouram.spackle.StrictModeCompat;
import com.twofortyfouram.spackle.bundle.BundlePrinter;
import com.twofortyfouram.spackle.internal.Reflector;
import java.util.Arrays;
import java.util.Locale;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class Lumberjack {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f38107a = {String.class, String.class};
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f38108b = "Lumberjack";

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f38109c = false;

    private Lumberjack() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @NonNull
    private static String a(@NonNull Object obj) {
        Class<?> cls = obj.getClass();
        if (cls.getComponentType().isPrimitive()) {
            return (String) Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{cls}, new Object[]{obj});
        }
        return (String) Reflector.tryInvokeStatic(Arrays.class, "deepToString", new Class[]{Object[].class}, new Object[]{obj});
    }

    public static void always(@NonNull String str, @Nullable Object... objArr) {
        l(0, str, objArr);
    }

    @NonNull
    private static String b(@NonNull Bundle bundle) {
        return BundlePrinter.toString(bundle);
    }

    @NonNull
    private static String c(@NonNull Cursor cursor) {
        return DatabaseUtils.dumpCursorToString(cursor);
    }

    public static void d(@NonNull String str, Object... objArr) {
        l(3, str, objArr);
    }

    public static void e(@NonNull String str, @Nullable Object... objArr) {
        l(6, str, objArr);
    }

    @NonNull
    private static String f(@NonNull Throwable th) {
        return String.format(Locale.US, "%n%s", Log.getStackTraceString(th));
    }

    @NonNull
    public static String formatMessage(@NonNull String str, @Nullable Object... objArr) {
        Assertions.assertNotNull(str, NotificationCompat.CATEGORY_MESSAGE);
        if (objArr != null) {
            for (int i4 = 0; i4 < objArr.length; i4++) {
                objArr[i4] = h(objArr[i4]);
            }
        }
        return String.format(Locale.US, str, objArr);
    }

    @NonNull
    private static String g(@NonNull Intent intent) {
        return String.format(Locale.US, "%s with extras %s", intent, BundlePrinter.toString(intent.getExtras()));
    }

    @Nullable
    private static Object h(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Throwable) {
            return f((Throwable) obj);
        }
        if (obj instanceof Intent) {
            return g((Intent) obj);
        }
        if (obj instanceof Bundle) {
            return b((Bundle) obj);
        }
        if (obj instanceof Cursor) {
            return c((Cursor) obj);
        }
        if (obj.getClass().isArray()) {
            return a(obj);
        }
        return obj;
    }

    public static void i(@NonNull String str, @Nullable Object... objArr) {
        l(4, str, objArr);
    }

    public static void init(@NonNull Context context) {
        Context cleanContext = ContextUtil.cleanContext(context);
        f38108b = j(cleanContext);
        f38109c = cleanContext.getResources().getBoolean(R.bool.com_twofortyfouram_log_is_debug);
        if (f38109c) {
            StrictModeCompat.setStrictMode(true);
            try {
                Class[] clsArr = {Boolean.TYPE};
                Boolean[] boolArr = {Boolean.TRUE};
                Reflector.tryInvokeStatic("androidx.fragment.app.FragmentManager", "enableDebugLogging", clsArr, boolArr);
                Reflector.tryInvokeStatic("androidx.loader.app.LoaderManager", "enableDebugLogging", clsArr, boolArr);
            } catch (RuntimeException unused) {
            }
            if (AndroidSdkVersion.isAtLeastSdk(11)) {
                k();
            }
        }
    }

    @NonNull
    private static String j(@NonNull Context context) {
        String string = context.getString(R.string.com_twofortyfouram_log_tag);
        if (string.length() == 0) {
            return i(context);
        }
        return string;
    }

    @TargetApi(11)
    private static void k() {
        FragmentManager.enableDebugLogging(true);
        LoaderManager.enableDebugLogging(true);
    }

    private static void l(int i4, String str, @Nullable Object[] objArr) {
        String formatMessage = formatMessage(str, objArr);
        if (f38109c) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            formatMessage = String.format(Locale.US, "%-30s%s.%s(): %s", Thread.currentThread().getName(), stackTrace[2].getClassName(), stackTrace[2].getMethodName(), formatMessage);
        }
        if (i4 == 0) {
            Reflector.tryInvokeStatic(Log.class, "i", f38107a, new Object[]{f38108b, formatMessage});
            return;
        }
        switch (i4) {
            case 2:
            case 3:
                return;
            case 4:
                Log.i(f38108b, formatMessage);
                return;
            case 5:
                Log.w(f38108b, formatMessage);
                return;
            case 6:
                Log.e(f38108b, formatMessage);
                return;
            case 7:
                Log.wtf(f38108b, formatMessage);
                return;
            default:
                throw new AssertionError();
        }
    }

    public static void v(@NonNull String str, @Nullable Object... objArr) {
        l(2, str, objArr);
    }

    public static void w(@NonNull String str, @Nullable Object... objArr) {
        l(5, str, objArr);
    }

    @NonNull
    private static String i(@NonNull Context context) {
        return AppBuildInfo.getApplicationName(context).toLowerCase(Locale.US).replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "-");
    }
}
