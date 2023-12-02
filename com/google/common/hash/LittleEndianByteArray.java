package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray;
import com.google.common.primitives.Longs;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class LittleEndianByteArray {

    /* renamed from: a  reason: collision with root package name */
    private static final LittleEndianBytes f27857a;

    /* loaded from: classes5.dex */
    private enum JavaLittleEndianBytes implements LittleEndianBytes {
        INSTANCE { // from class: com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long a(byte[] bArr, int i4) {
                return Longs.fromBytes(bArr[i4 + 7], bArr[i4 + 6], bArr[i4 + 5], bArr[i4 + 4], bArr[i4 + 3], bArr[i4 + 2], bArr[i4 + 1], bArr[i4]);
            }
        }
    }

    /* loaded from: classes5.dex */
    private interface LittleEndianBytes {
        long a(byte[] bArr, int i4);
    }

    /* loaded from: classes5.dex */
    private enum UnsafeByteArray implements LittleEndianBytes {
        UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long a(byte[] bArr, int i4) {
                return UnsafeByteArray.f27862c.getLong(bArr, i4 + UnsafeByteArray.f27863d);
            }
        },
        UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.2
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long a(byte[] bArr, int i4) {
                return Long.reverseBytes(UnsafeByteArray.f27862c.getLong(bArr, i4 + UnsafeByteArray.f27863d));
            }
        };
        

        /* renamed from: c  reason: collision with root package name */
        private static final Unsafe f27862c;

        /* renamed from: d  reason: collision with root package name */
        private static final int f27863d;

        static {
            Unsafe g4 = g();
            f27862c = g4;
            f27863d = g4.arrayBaseOffset(byte[].class);
            if (g4.arrayIndexScale(byte[].class) == 1) {
                return;
            }
            throw new AssertionError();
        }

        private static Unsafe g() {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.google.common.hash.b
                        @Override // java.security.PrivilegedExceptionAction
                        public final Object run() {
                            Unsafe h4;
                            h4 = LittleEndianByteArray.UnsafeByteArray.h();
                            return h4;
                        }
                    });
                }
            } catch (PrivilegedActionException e4) {
                throw new RuntimeException("Could not initialize intrinsics", e4.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unsafe h() throws Exception {
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
    }

    static {
        LittleEndianBytes littleEndianBytes = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
                    littleEndianBytes = UnsafeByteArray.UNSAFE_LITTLE_ENDIAN;
                } else {
                    littleEndianBytes = UnsafeByteArray.UNSAFE_BIG_ENDIAN;
                }
            }
        } catch (Throwable unused) {
        }
        f27857a = littleEndianBytes;
    }

    private LittleEndianByteArray() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(byte[] bArr, int i4) {
        return f27857a.a(bArr, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long c(byte[] bArr, int i4, int i5) {
        int min = Math.min(i5, 8);
        long j4 = 0;
        for (int i6 = 0; i6 < min; i6++) {
            j4 |= (bArr[i4 + i6] & 255) << (i6 * 8);
        }
        return j4;
    }
}
