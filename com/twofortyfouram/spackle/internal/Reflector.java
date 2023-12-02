package com.twofortyfouram.spackle.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class Reflector {
    private Reflector() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    private static <T> T a(Object obj, Class<?> cls, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            if (cls == null) {
                if (obj != null) {
                    cls = obj.getClass();
                } else {
                    cls = Class.forName(str);
                }
            }
            return (T) cls.getMethod(str2, clsArr).invoke(obj, objArr);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException(e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException(e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static <T> T tryInvokeInstance(@NonNull Object obj, @NonNull String str, @Nullable Class<?>[] clsArr, @Nullable Object[] objArr) {
        return (T) a(obj, null, null, str, clsArr, objArr);
    }

    public static <T> T tryInvokeStatic(@NonNull Class<?> cls, @NonNull String str, @Nullable Class<?>[] clsArr, @Nullable Object[] objArr) {
        return (T) a(null, cls, null, str, clsArr, objArr);
    }

    public static <T> T tryInvokeStatic(@NonNull String str, @NonNull String str2, @Nullable Class<?>[] clsArr, @Nullable Object[] objArr) {
        return (T) a(null, null, str, str2, clsArr, objArr);
    }
}
