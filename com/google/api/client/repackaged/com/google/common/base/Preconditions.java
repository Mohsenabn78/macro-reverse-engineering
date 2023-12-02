package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes5.dex */
public final class Preconditions {
    private Preconditions() {
    }

    private static String a(int i4, int i5, String str) {
        if (i4 < 0) {
            return d("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return d("%s (%s) must be less than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }

    private static String b(int i4, int i5, String str) {
        if (i4 < 0) {
            return d("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return d("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }

    private static String c(int i4, int i5, int i6) {
        if (i4 >= 0 && i4 <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                return d("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
            }
            return b(i5, i6, "end index");
        }
        return b(i4, i6, "start index");
    }

    public static void checkArgument(boolean z3) {
        if (!z3) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkElementIndex(int i4, int i5) {
        return checkElementIndex(i4, i5, FirebaseAnalytics.Param.INDEX);
    }

    public static <T> T checkNotNull(T t3) {
        t3.getClass();
        return t3;
    }

    public static int checkPositionIndex(int i4, int i5) {
        return checkPositionIndex(i4, i5, FirebaseAnalytics.Param.INDEX);
    }

    public static void checkPositionIndexes(int i4, int i5, int i6) {
        if (i4 >= 0 && i5 >= i4 && i5 <= i6) {
            return;
        }
        throw new IndexOutOfBoundsException(c(i4, i5, i6));
    }

    public static void checkState(boolean z3) {
        if (!z3) {
            throw new IllegalStateException();
        }
    }

    static String d(String str, @Nullable Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i4 = 0;
        int i5 = 0;
        while (i4 < objArr.length && (indexOf = valueOf.indexOf("%s", i5)) != -1) {
            sb.append(valueOf.substring(i5, indexOf));
            sb.append(objArr[i4]);
            i5 = indexOf + 2;
            i4++;
        }
        sb.append(valueOf.substring(i5));
        if (i4 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i4]);
            for (int i6 = i4 + 1; i6 < objArr.length; i6++) {
                sb.append(", ");
                sb.append(objArr[i6]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static void checkArgument(boolean z3, @Nullable Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkElementIndex(int i4, int i5, @Nullable String str) {
        if (i4 < 0 || i4 >= i5) {
            throw new IndexOutOfBoundsException(a(i4, i5, str));
        }
        return i4;
    }

    public static <T> T checkNotNull(T t3, @Nullable Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkPositionIndex(int i4, int i5, @Nullable String str) {
        if (i4 < 0 || i4 > i5) {
            throw new IndexOutOfBoundsException(b(i4, i5, str));
        }
        return i4;
    }

    public static void checkState(boolean z3, @Nullable Object obj) {
        if (!z3) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z3, @Nullable String str, @Nullable Object... objArr) {
        if (!z3) {
            throw new IllegalArgumentException(d(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t3, @Nullable String str, @Nullable Object... objArr) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(d(str, objArr));
    }

    public static void checkState(boolean z3, @Nullable String str, @Nullable Object... objArr) {
        if (!z3) {
            throw new IllegalStateException(d(str, objArr));
        }
    }
}
