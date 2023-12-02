package com.google.common.cache;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
abstract class Striped64 extends Number {

    /* renamed from: d  reason: collision with root package name */
    static final ThreadLocal<int[]> f26579d = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    static final Random f26580e = new Random();

    /* renamed from: f  reason: collision with root package name */
    static final int f26581f = Runtime.getRuntime().availableProcessors();

    /* renamed from: g  reason: collision with root package name */
    private static final Unsafe f26582g;

    /* renamed from: h  reason: collision with root package name */
    private static final long f26583h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f26584i;
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    volatile transient Cell[] f26585a;

    /* renamed from: b  reason: collision with root package name */
    volatile transient long f26586b;

    /* renamed from: c  reason: collision with root package name */
    volatile transient int f26587c;

    /* loaded from: classes5.dex */
    static final class Cell {

        /* renamed from: b  reason: collision with root package name */
        private static final Unsafe f26588b;

        /* renamed from: c  reason: collision with root package name */
        private static final long f26589c;

        /* renamed from: a  reason: collision with root package name */
        volatile long f26590a;

        static {
            try {
                Unsafe b4 = Striped64.b();
                f26588b = b4;
                f26589c = b4.objectFieldOffset(Cell.class.getDeclaredField("a"));
            } catch (Exception e4) {
                throw new Error(e4);
            }
        }

        Cell(long j4) {
            this.f26590a = j4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean a(long j4, long j5) {
            return f26588b.compareAndSwapLong(this, f26589c, j4, j5);
        }
    }

    static {
        try {
            Unsafe g4 = g();
            f26582g = g4;
            f26583h = g4.objectFieldOffset(Striped64.class.getDeclaredField("b"));
            f26584i = g4.objectFieldOffset(Striped64.class.getDeclaredField(CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT));
        } catch (Exception e4) {
            throw new Error(e4);
        }
    }

    static /* synthetic */ Unsafe b() {
        return g();
    }

    private static Unsafe g() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.cache.Striped64.1
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(long j4, long j5) {
        return f26582g.compareAndSwapLong(this, f26583h, j4, j5);
    }

    final boolean e() {
        return f26582g.compareAndSwapInt(this, f26584i, 0, 1);
    }

    abstract long f(long j4, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(long r17, @javax.annotation.CheckForNull int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.h(long, int[], boolean):void");
    }
}
