package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Preconditions {
    private Preconditions() {
    }

    private static String a(int i4, int i5, String str) {
        if (i4 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }

    private static String b(int i4, int i5, String str) {
        if (i4 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }

    private static String c(int i4, int i5, int i6) {
        if (i4 >= 0 && i4 <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                return Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
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

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i4, int i5) {
        return checkElementIndex(i4, i5, FirebaseAnalytics.Param.INDEX);
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3) {
        t3.getClass();
        return t3;
    }

    @CanIgnoreReturnValue
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

    public static void checkArgument(boolean z3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i4, int i5, String str) {
        if (i4 < 0 || i4 >= i5) {
            throw new IndexOutOfBoundsException(a(i4, i5, str));
        }
        return i4;
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i4, int i5, String str) {
        if (i4 < 0 || i4 > i5) {
            throw new IndexOutOfBoundsException(b(i4, i5, str));
        }
        return i4;
    }

    public static void checkState(boolean z3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object... objArr) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object... objArr) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    public static void checkState(boolean z3, @CheckForNull String str, @CheckForNull Object... objArr) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkArgument(boolean z3, String str, char c4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c4)));
    }

    public static void checkState(boolean z3, String str, char c4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c4)));
        }
    }

    public static void checkArgument(boolean z3, String str, int i4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i4)));
    }

    public static void checkState(boolean z3, String str, int i4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i4)));
        }
    }

    public static void checkArgument(boolean z3, String str, long j4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j4)));
    }

    public static void checkState(boolean z3, String str, long j4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j4)));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z3, String str, char c4, char c5) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c4), Character.valueOf(c5)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c4, char c5) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c4), Character.valueOf(c5)));
    }

    public static void checkState(boolean z3, String str, char c4, char c5) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c4), Character.valueOf(c5)));
        }
    }

    public static void checkArgument(boolean z3, String str, char c4, int i4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c4), Integer.valueOf(i4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c4, int i4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c4), Integer.valueOf(i4)));
    }

    public static void checkState(boolean z3, String str, char c4, int i4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c4), Integer.valueOf(i4)));
        }
    }

    public static void checkArgument(boolean z3, String str, char c4, long j4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c4), Long.valueOf(j4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c4, long j4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c4), Long.valueOf(j4)));
    }

    public static void checkState(boolean z3, String str, char c4, long j4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c4), Long.valueOf(j4)));
        }
    }

    public static void checkArgument(boolean z3, String str, char c4, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c4), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c4, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c4), obj));
    }

    public static void checkState(boolean z3, String str, char c4, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c4), obj));
        }
    }

    public static void checkArgument(boolean z3, String str, int i4, char c4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i4), Character.valueOf(c4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i4, char c4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i4), Character.valueOf(c4)));
    }

    public static void checkState(boolean z3, String str, int i4, char c4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i4), Character.valueOf(c4)));
        }
    }

    public static void checkArgument(boolean z3, String str, int i4, int i5) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i4), Integer.valueOf(i5)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i4, int i5) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    public static void checkState(boolean z3, String str, int i4, int i5) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i4), Integer.valueOf(i5)));
        }
    }

    public static void checkArgument(boolean z3, String str, int i4, long j4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i4), Long.valueOf(j4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i4, long j4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i4), Long.valueOf(j4)));
    }

    public static void checkState(boolean z3, String str, int i4, long j4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i4), Long.valueOf(j4)));
        }
    }

    public static void checkArgument(boolean z3, String str, int i4, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i4), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i4, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i4), obj));
    }

    public static void checkState(boolean z3, String str, int i4, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i4), obj));
        }
    }

    public static void checkArgument(boolean z3, String str, long j4, char c4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j4), Character.valueOf(c4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j4, char c4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j4), Character.valueOf(c4)));
    }

    public static void checkState(boolean z3, String str, long j4, char c4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j4), Character.valueOf(c4)));
        }
    }

    public static void checkArgument(boolean z3, String str, long j4, int i4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j4), Integer.valueOf(i4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j4, int i4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j4), Integer.valueOf(i4)));
    }

    public static void checkState(boolean z3, String str, long j4, int i4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j4), Integer.valueOf(i4)));
        }
    }

    public static void checkArgument(boolean z3, String str, long j4, long j5) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j4), Long.valueOf(j5)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j4, long j5) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j4), Long.valueOf(j5)));
    }

    public static void checkState(boolean z3, String str, long j4, long j5) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j4), Long.valueOf(j5)));
        }
    }

    public static void checkArgument(boolean z3, String str, long j4, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j4), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j4, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j4), obj));
    }

    public static void checkState(boolean z3, String str, long j4, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j4), obj));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, char c4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, char c4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c4)));
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, char c4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c4)));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, int i4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, int i4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i4)));
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, int i4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i4)));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, long j4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j4)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, long j4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j4)));
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, long j4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j4)));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
