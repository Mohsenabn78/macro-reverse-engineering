package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Verify {
    private Verify() {
    }

    public static void verify(boolean z3) {
        if (!z3) {
            throw new VerifyException();
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@CheckForNull T t3) {
        return (T) verifyNotNull(t3, "expected a non-null reference", new Object[0]);
    }

    public static void verify(boolean z3, String str, @CheckForNull Object... objArr) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@CheckForNull T t3, String str, @CheckForNull Object... objArr) {
        if (t3 != null) {
            return t3;
        }
        throw new VerifyException(Strings.lenientFormat(str, objArr));
    }

    public static void verify(boolean z3, String str, char c4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c4)));
        }
    }

    public static void verify(boolean z3, String str, int i4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i4)));
        }
    }

    public static void verify(boolean z3, String str, long j4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j4)));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj));
        }
    }

    public static void verify(boolean z3, String str, char c4, char c5) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c4), Character.valueOf(c5)));
        }
    }

    public static void verify(boolean z3, String str, int i4, char c4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i4), Character.valueOf(c4)));
        }
    }

    public static void verify(boolean z3, String str, long j4, char c4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j4), Character.valueOf(c4)));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, char c4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Character.valueOf(c4)));
        }
    }

    public static void verify(boolean z3, String str, char c4, int i4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c4), Integer.valueOf(i4)));
        }
    }

    public static void verify(boolean z3, String str, int i4, int i5) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i4), Integer.valueOf(i5)));
        }
    }

    public static void verify(boolean z3, String str, long j4, int i4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j4), Integer.valueOf(i4)));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, int i4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Integer.valueOf(i4)));
        }
    }

    public static void verify(boolean z3, String str, char c4, long j4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c4), Long.valueOf(j4)));
        }
    }

    public static void verify(boolean z3, String str, int i4, long j4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i4), Long.valueOf(j4)));
        }
    }

    public static void verify(boolean z3, String str, long j4, long j5) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j4), Long.valueOf(j5)));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, long j4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Long.valueOf(j4)));
        }
    }

    public static void verify(boolean z3, String str, char c4, @CheckForNull Object obj) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c4), obj));
        }
    }

    public static void verify(boolean z3, String str, int i4, @CheckForNull Object obj) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i4), obj));
        }
    }

    public static void verify(boolean z3, String str, long j4, @CheckForNull Object obj) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j4), obj));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
