package com.google.protobuf;

import java.lang.ref.SoftReference;

/* loaded from: classes6.dex */
final class ByteBufferWriter {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<SoftReference<byte[]>> f33198a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f33199b;

    /* renamed from: c  reason: collision with root package name */
    private static final long f33200c;

    static {
        Class<?> b4 = b("java.io.FileOutputStream");
        f33199b = b4;
        f33200c = a(b4);
    }

    private ByteBufferWriter() {
    }

    private static long a(Class<?> cls) {
        if (cls != null) {
            try {
                if (UnsafeUtil.J()) {
                    return UnsafeUtil.M(cls.getDeclaredField("channel"));
                }
                return -1L;
            } catch (Throwable unused) {
                return -1L;
            }
        }
        return -1L;
    }

    private static Class<?> b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
