package com.google.common.primitives;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static class LexicographicalComparatorHolder {

        /* renamed from: a  reason: collision with root package name */
        static final String f28182a = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";

        /* renamed from: b  reason: collision with root package name */
        static final Comparator<byte[]> f28183b = a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            @Override // java.util.Comparator
            /* renamed from: b */
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                for (int i4 = 0; i4 < min; i4++) {
                    int compare = UnsignedBytes.compare(bArr[i4], bArr2[i4]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        @VisibleForTesting
        /* loaded from: classes5.dex */
        enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;
            

            /* renamed from: b  reason: collision with root package name */
            static final boolean f28187b = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);

            /* renamed from: c  reason: collision with root package name */
            static final Unsafe f28188c;

            /* renamed from: d  reason: collision with root package name */
            static final int f28189d;

            static {
                Unsafe c4 = c();
                f28188c = c4;
                int arrayBaseOffset = c4.arrayBaseOffset(byte[].class);
                f28189d = arrayBaseOffset;
                if ("64".equals(System.getProperty("sun.arch.data.model")) && arrayBaseOffset % 8 == 0 && c4.arrayIndexScale(byte[].class) == 1) {
                    return;
                }
                throw new Error();
            }

            private static Unsafe c() {
                try {
                    try {
                        return Unsafe.getUnsafe();
                    } catch (SecurityException unused) {
                        return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.1
                            @Override // java.security.PrivilegedExceptionAction
                            /* renamed from: a */
                            public Unsafe run() throws Exception {
                                Field[] declaredFields;
                                for (Field field : Unsafe.class.getDeclaredFields()) {
                                    field.setAccessible(true);
                                    Object obj = field.get(null);
                                    if (Unsafe.class.isInstance(obj)) {
                                        return (Unsafe) Unsafe.class.cast(obj);
                                    }
                                }
                                throw new NoSuchFieldError("the Unsafe");
                            }
                        });
                    }
                } catch (PrivilegedActionException e4) {
                    throw new RuntimeException("Could not initialize intrinsics", e4.getCause());
                }
            }

            @Override // java.util.Comparator
            /* renamed from: b */
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                int i4 = min & (-8);
                int i5 = 0;
                while (i5 < i4) {
                    Unsafe unsafe = f28188c;
                    int i6 = f28189d;
                    long j4 = i5;
                    long j5 = unsafe.getLong(bArr, i6 + j4);
                    long j6 = unsafe.getLong(bArr2, i6 + j4);
                    if (j5 != j6) {
                        if (f28187b) {
                            return UnsignedLongs.compare(j5, j6);
                        }
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j5 ^ j6) & (-8);
                        return ((int) ((j5 >>> numberOfTrailingZeros) & 255)) - ((int) ((j6 >>> numberOfTrailingZeros) & 255));
                    }
                    i5 += 8;
                }
                while (i5 < min) {
                    int compare = UnsignedBytes.compare(bArr[i5], bArr2[i5]);
                    if (compare != 0) {
                        return compare;
                    }
                    i5++;
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        LexicographicalComparatorHolder() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        static Comparator<byte[]> a() {
            try {
                Object[] enumConstants = Class.forName(f28182a).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return UnsignedBytes.b();
            }
        }
    }

    private UnsignedBytes() {
    }

    private static byte a(byte b4) {
        return (byte) (b4 ^ 128);
    }

    @VisibleForTesting
    static Comparator<byte[]> b() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    @CanIgnoreReturnValue
    public static byte checkedCast(long j4) {
        boolean z3;
        if ((j4 >> 8) == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "out of range: %s", j4);
        return (byte) j4;
    }

    public static int compare(byte b4, byte b5) {
        return toInt(b4) - toInt(b5);
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * (str.length() + 3));
        sb.append(toInt(bArr[0]));
        for (int i4 = 1; i4 < bArr.length; i4++) {
            sb.append(str);
            sb.append(toString(bArr[i4]));
        }
        return sb.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.f28183b;
    }

    public static byte max(byte... bArr) {
        boolean z3;
        if (bArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int i4 = toInt(bArr[0]);
        for (int i5 = 1; i5 < bArr.length; i5++) {
            int i6 = toInt(bArr[i5]);
            if (i6 > i4) {
                i4 = i6;
            }
        }
        return (byte) i4;
    }

    public static byte min(byte... bArr) {
        boolean z3;
        if (bArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int i4 = toInt(bArr[0]);
        for (int i5 = 1; i5 < bArr.length; i5++) {
            int i6 = toInt(bArr[i5]);
            if (i6 < i4) {
                i4 = i6;
            }
        }
        return (byte) i4;
    }

    @CanIgnoreReturnValue
    public static byte parseUnsignedByte(String str) {
        return parseUnsignedByte(str, 10);
    }

    public static byte saturatedCast(long j4) {
        if (j4 > toInt((byte) -1)) {
            return (byte) -1;
        }
        if (j4 < 0) {
            return (byte) 0;
        }
        return (byte) j4;
    }

    public static void sort(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sort(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static int toInt(byte b4) {
        return b4 & 255;
    }

    public static String toString(byte b4) {
        return toString(b4, 10);
    }

    @CanIgnoreReturnValue
    public static byte parseUnsignedByte(String str, int i4) {
        int parseInt = Integer.parseInt((String) Preconditions.checkNotNull(str), i4);
        if ((parseInt >> 8) == 0) {
            return (byte) parseInt;
        }
        throw new NumberFormatException("out of range: " + parseInt);
    }

    public static String toString(byte b4, int i4) {
        Preconditions.checkArgument(i4 >= 2 && i4 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i4);
        return Integer.toString(toInt(b4), i4);
    }

    public static void sort(byte[] bArr, int i4, int i5) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i4, i5, bArr.length);
        for (int i6 = i4; i6 < i5; i6++) {
            bArr[i6] = a(bArr[i6]);
        }
        Arrays.sort(bArr, i4, i5);
        while (i4 < i5) {
            bArr[i4] = a(bArr[i4]);
            i4++;
        }
    }

    public static void sortDescending(byte[] bArr, int i4, int i5) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i4, i5, bArr.length);
        for (int i6 = i4; i6 < i5; i6++) {
            bArr[i6] = (byte) (bArr[i6] ^ Byte.MAX_VALUE);
        }
        Arrays.sort(bArr, i4, i5);
        while (i4 < i5) {
            bArr[i4] = (byte) (bArr[i4] ^ Byte.MAX_VALUE);
            i4++;
        }
    }
}
