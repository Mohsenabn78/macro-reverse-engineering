package com.google.protobuf;

import com.sun.mail.imap.IMAPStore;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class UnsafeUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f33599a = I();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f33600b = Android.b();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f33601c = r(Long.TYPE);

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f33602d = r(Integer.TYPE);

    /* renamed from: e  reason: collision with root package name */
    private static final MemoryAccessor f33603e = G();

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f33604f = a0();

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f33605g = Z();

    /* renamed from: h  reason: collision with root package name */
    static final long f33606h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f33607i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f33608j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f33609k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f33610l;

    /* renamed from: m  reason: collision with root package name */
    private static final long f33611m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f33612n;

    /* renamed from: o  reason: collision with root package name */
    private static final long f33613o;

    /* renamed from: p  reason: collision with root package name */
    private static final long f33614p;

    /* renamed from: q  reason: collision with root package name */
    private static final long f33615q;

    /* renamed from: r  reason: collision with root package name */
    private static final long f33616r;

    /* renamed from: s  reason: collision with root package name */
    private static final long f33617s;

    /* renamed from: t  reason: collision with root package name */
    private static final long f33618t;

    /* renamed from: u  reason: collision with root package name */
    private static final long f33619u;

    /* renamed from: v  reason: collision with root package name */
    private static final int f33620v;

    /* renamed from: w  reason: collision with root package name */
    static final boolean f33621w;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class Android32MemoryAccessor extends MemoryAccessor {
        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j4, byte[] bArr, long j5, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void d(byte[] bArr, long j4, long j5, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean e(Object obj, long j4) {
            return UnsafeUtil.f33621w ? UnsafeUtil.v(obj, j4) : UnsafeUtil.w(obj, j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte g(Object obj, long j4) {
            return UnsafeUtil.f33621w ? UnsafeUtil.z(obj, j4) : UnsafeUtil.A(obj, j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double h(Object obj, long j4) {
            return Double.longBitsToDouble(l(obj, j4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float i(Object obj, long j4) {
            return Float.intBitsToFloat(j(obj, j4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long k(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j4, boolean z3) {
            if (UnsafeUtil.f33621w) {
                UnsafeUtil.O(obj, j4, z3);
            } else {
                UnsafeUtil.P(obj, j4, z3);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void p(long j4, byte b4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j4, byte b4) {
            if (UnsafeUtil.f33621w) {
                UnsafeUtil.S(obj, j4, b4);
            } else {
                UnsafeUtil.T(obj, j4, b4);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void r(Object obj, long j4, double d4) {
            u(obj, j4, Double.doubleToLongBits(d4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void s(Object obj, long j4, float f4) {
            t(obj, j4, Float.floatToIntBits(f4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean x() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j4, byte[] bArr, long j5, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void d(byte[] bArr, long j4, long j5, long j6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean e(Object obj, long j4) {
            return UnsafeUtil.f33621w ? UnsafeUtil.v(obj, j4) : UnsafeUtil.w(obj, j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte g(Object obj, long j4) {
            return UnsafeUtil.f33621w ? UnsafeUtil.z(obj, j4) : UnsafeUtil.A(obj, j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double h(Object obj, long j4) {
            return Double.longBitsToDouble(l(obj, j4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float i(Object obj, long j4) {
            return Float.intBitsToFloat(j(obj, j4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long k(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j4, boolean z3) {
            if (UnsafeUtil.f33621w) {
                UnsafeUtil.O(obj, j4, z3);
            } else {
                UnsafeUtil.P(obj, j4, z3);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void p(long j4, byte b4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j4, byte b4) {
            if (UnsafeUtil.f33621w) {
                UnsafeUtil.S(obj, j4, b4);
            } else {
                UnsafeUtil.T(obj, j4, b4);
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void r(Object obj, long j4, double d4) {
            u(obj, j4, Double.doubleToLongBits(d4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void s(Object obj, long j4, float f4) {
            t(obj, j4, Float.floatToIntBits(f4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean x() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j4, byte[] bArr, long j5, long j6) {
            this.f33622a.copyMemory((Object) null, j4, bArr, UnsafeUtil.f33606h + j5, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void d(byte[] bArr, long j4, long j5, long j6) {
            this.f33622a.copyMemory(bArr, UnsafeUtil.f33606h + j4, (Object) null, j5, j6);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean e(Object obj, long j4) {
            return this.f33622a.getBoolean(obj, j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(long j4) {
            return this.f33622a.getByte(j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte g(Object obj, long j4) {
            return this.f33622a.getByte(obj, j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double h(Object obj, long j4) {
            return this.f33622a.getDouble(obj, j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float i(Object obj, long j4) {
            return this.f33622a.getFloat(obj, j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long k(long j4) {
            return this.f33622a.getLong(j4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j4, boolean z3) {
            this.f33622a.putBoolean(obj, j4, z3);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void p(long j4, byte b4) {
            this.f33622a.putByte(j4, b4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j4, byte b4) {
            this.f33622a.putByte(obj, j4, b4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void r(Object obj, long j4, double d4) {
            this.f33622a.putDouble(obj, j4, d4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void s(Object obj, long j4, float f4) {
            this.f33622a.putFloat(obj, j4, f4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean w() {
            if (!super.w()) {
                return false;
            }
            try {
                Class<?> cls = this.f33622a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.L(th);
                return false;
            }
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean x() {
            if (!super.x()) {
                return false;
            }
            try {
                Class<?> cls = this.f33622a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.L(th);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static abstract class MemoryAccessor {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f33622a;

        MemoryAccessor(Unsafe unsafe) {
            this.f33622a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f33622a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f33622a.arrayIndexScale(cls);
        }

        public abstract void c(long j4, byte[] bArr, long j5, long j6);

        public abstract void d(byte[] bArr, long j4, long j5, long j6);

        public abstract boolean e(Object obj, long j4);

        public abstract byte f(long j4);

        public abstract byte g(Object obj, long j4);

        public abstract double h(Object obj, long j4);

        public abstract float i(Object obj, long j4);

        public final int j(Object obj, long j4) {
            return this.f33622a.getInt(obj, j4);
        }

        public abstract long k(long j4);

        public final long l(Object obj, long j4) {
            return this.f33622a.getLong(obj, j4);
        }

        public final Object m(Object obj, long j4) {
            return this.f33622a.getObject(obj, j4);
        }

        public final long n(java.lang.reflect.Field field) {
            return this.f33622a.objectFieldOffset(field);
        }

        public abstract void o(Object obj, long j4, boolean z3);

        public abstract void p(long j4, byte b4);

        public abstract void q(Object obj, long j4, byte b4);

        public abstract void r(Object obj, long j4, double d4);

        public abstract void s(Object obj, long j4, float f4);

        public final void t(Object obj, long j4, int i4) {
            this.f33622a.putInt(obj, j4, i4);
        }

        public final void u(Object obj, long j4, long j5) {
            this.f33622a.putLong(obj, j4, j5);
        }

        public final void v(Object obj, long j4, Object obj2) {
            this.f33622a.putObject(obj, j4, obj2);
        }

        public boolean w() {
            Unsafe unsafe = this.f33622a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.L(th);
                return false;
            }
        }

        public boolean x() {
            Unsafe unsafe = this.f33622a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                if (UnsafeUtil.b() == null) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                UnsafeUtil.L(th);
                return false;
            }
        }
    }

    static {
        boolean z3;
        long m4 = m(byte[].class);
        f33606h = m4;
        f33607i = m(boolean[].class);
        f33608j = n(boolean[].class);
        f33609k = m(int[].class);
        f33610l = n(int[].class);
        f33611m = m(long[].class);
        f33612n = n(long[].class);
        f33613o = m(float[].class);
        f33614p = n(float[].class);
        f33615q = m(double[].class);
        f33616r = n(double[].class);
        f33617s = m(Object[].class);
        f33618t = n(Object[].class);
        f33619u = t(o());
        f33620v = (int) (m4 & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z3 = true;
        } else {
            z3 = false;
        }
        f33621w = z3;
    }

    private UnsafeUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte A(Object obj, long j4) {
        return (byte) ((D(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double B(Object obj, long j4) {
        return f33603e.h(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float C(Object obj, long j4) {
        return f33603e.i(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D(Object obj, long j4) {
        return f33603e.j(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long E(long j4) {
        return f33603e.k(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long F(Object obj, long j4) {
        return f33603e.l(obj, j4);
    }

    private static MemoryAccessor G() {
        Unsafe unsafe = f33599a;
        if (unsafe == null) {
            return null;
        }
        if (Android.c()) {
            if (f33601c) {
                return new Android64MemoryAccessor(unsafe);
            }
            if (!f33602d) {
                return null;
            }
            return new Android32MemoryAccessor(unsafe);
        }
        return new JvmMemoryAccessor(unsafe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object H(Object obj, long j4) {
        return f33603e.m(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe I() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                /* renamed from: a */
                public Unsafe run() throws Exception {
                    java.lang.reflect.Field[] declaredFields;
                    for (java.lang.reflect.Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean J() {
        return f33605g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K() {
        return f33604f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L(Throwable th) {
        Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long M(java.lang.reflect.Field field) {
        return f33603e.n(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void N(Object obj, long j4, boolean z3) {
        f33603e.o(obj, j4, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(Object obj, long j4, boolean z3) {
        S(obj, j4, z3 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Object obj, long j4, boolean z3) {
        T(obj, j4, z3 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Q(long j4, byte b4) {
        f33603e.p(j4, b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void R(byte[] bArr, long j4, byte b4) {
        f33603e.q(bArr, f33606h + j4, b4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int D = D(obj, j5);
        int i4 = ((~((int) j4)) & 3) << 3;
        W(obj, j5, ((255 & b4) << i4) | (D & (~(255 << i4))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int i4 = (((int) j4) & 3) << 3;
        W(obj, j5, ((255 & b4) << i4) | (D(obj, j5) & (~(255 << i4))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void U(Object obj, long j4, double d4) {
        f33603e.r(obj, j4, d4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void V(Object obj, long j4, float f4) {
        f33603e.s(obj, j4, f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void W(Object obj, long j4, int i4) {
        f33603e.t(obj, j4, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void X(Object obj, long j4, long j5) {
        f33603e.u(obj, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Y(Object obj, long j4, Object obj2) {
        f33603e.v(obj, j4, obj2);
    }

    private static boolean Z() {
        MemoryAccessor memoryAccessor = f33603e;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.w();
    }

    private static boolean a0() {
        MemoryAccessor memoryAccessor = f33603e;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.x();
    }

    static /* synthetic */ java.lang.reflect.Field b() {
        return o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long k(ByteBuffer byteBuffer) {
        return f33603e.l(byteBuffer, f33619u);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T l(Class<T> cls) {
        try {
            return (T) f33599a.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    private static int m(Class<?> cls) {
        if (f33605g) {
            return f33603e.a(cls);
        }
        return -1;
    }

    private static int n(Class<?> cls) {
        if (f33605g) {
            return f33603e.b(cls);
        }
        return -1;
    }

    private static java.lang.reflect.Field o() {
        java.lang.reflect.Field s3;
        if (Android.c() && (s3 = s(Buffer.class, "effectiveDirectAddress")) != null) {
            return s3;
        }
        java.lang.reflect.Field s4 = s(Buffer.class, IMAPStore.ID_ADDRESS);
        if (s4 == null || s4.getType() != Long.TYPE) {
            return null;
        }
        return s4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(long j4, byte[] bArr, long j5, long j6) {
        f33603e.c(j4, bArr, j5, j6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q(byte[] bArr, long j4, long j5, long j6) {
        f33603e.d(bArr, j4, j5, j6);
    }

    static boolean r(Class<?> cls) {
        if (!Android.c()) {
            return false;
        }
        try {
            Class<?> cls2 = f33600b;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static java.lang.reflect.Field s(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long t(java.lang.reflect.Field field) {
        MemoryAccessor memoryAccessor;
        if (field != null && (memoryAccessor = f33603e) != null) {
            return memoryAccessor.n(field);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u(Object obj, long j4) {
        return f33603e.e(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(Object obj, long j4) {
        if (z(obj, j4) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(Object obj, long j4) {
        if (A(obj, j4) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte x(long j4) {
        return f33603e.f(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte y(byte[] bArr, long j4) {
        return f33603e.g(bArr, f33606h + j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte z(Object obj, long j4) {
        return (byte) ((D(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3))) & 255);
    }
}
