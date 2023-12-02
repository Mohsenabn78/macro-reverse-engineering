package com.google.android.gms.internal.places;

import com.sun.mail.imap.IMAPStore;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzdy {
    private static final Logger logger = Logger.getLogger(zzdy.class.getName());
    private static final Class<?> zzdw;
    private static final boolean zzer;
    private static final Unsafe zzkr;
    private static final boolean zzmn;
    private static final boolean zzmo;
    private static final zzd zzmp;
    private static final boolean zzmq;
    private static final long zzmr;
    private static final long zzms;
    private static final long zzmt;
    private static final long zzmu;
    private static final long zzmv;
    private static final long zzmw;
    private static final long zzmx;
    private static final long zzmy;
    private static final long zzmz;
    private static final long zzna;
    private static final long zznb;
    private static final long zznc;
    private static final long zznd;
    private static final long zzne;
    private static final int zznf;
    static final boolean zzng;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class zzd {
        Unsafe zznh;

        zzd(Unsafe unsafe) {
            this.zznh = unsafe;
        }

        public abstract void zzb(Object obj, long j4, double d4);

        public abstract void zzb(Object obj, long j4, float f4);

        public final void zzb(Object obj, long j4, int i4) {
            this.zznh.putInt(obj, j4, i4);
        }

        public abstract void zzb(Object obj, long j4, boolean z3);

        public abstract void zzf(Object obj, long j4, byte b4);

        public final int zzk(Object obj, long j4) {
            return this.zznh.getInt(obj, j4);
        }

        public final long zzl(Object obj, long j4) {
            return this.zznh.getLong(obj, j4);
        }

        public abstract boolean zzm(Object obj, long j4);

        public abstract float zzn(Object obj, long j4);

        public abstract double zzo(Object obj, long j4);

        public abstract byte zzy(Object obj, long j4);

        public final void zzb(Object obj, long j4, long j5) {
            this.zznh.putLong(obj, j4, j5);
        }
    }

    /* loaded from: classes4.dex */
    static final class zze extends zzd {
        zze(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzb(Object obj, long j4, boolean z3) {
            this.zznh.putBoolean(obj, j4, z3);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzf(Object obj, long j4, byte b4) {
            this.zznh.putByte(obj, j4, b4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final boolean zzm(Object obj, long j4) {
            return this.zznh.getBoolean(obj, j4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final float zzn(Object obj, long j4) {
            return this.zznh.getFloat(obj, j4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final double zzo(Object obj, long j4) {
            return this.zznh.getDouble(obj, j4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final byte zzy(Object obj, long j4) {
            return this.zznh.getByte(obj, j4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzb(Object obj, long j4, float f4) {
            this.zznh.putFloat(obj, j4, f4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzb(Object obj, long j4, double d4) {
            this.zznh.putDouble(obj, j4, d4);
        }
    }

    static {
        long j4;
        boolean z3;
        Unsafe zzdn = zzdn();
        zzkr = zzdn;
        zzdw = zzp.zzz();
        boolean zzk = zzk(Long.TYPE);
        zzmn = zzk;
        boolean zzk2 = zzk(Integer.TYPE);
        zzmo = zzk2;
        zzd zzdVar = null;
        if (zzdn != null) {
            if (zzp.zzy()) {
                if (zzk) {
                    zzdVar = new zzb(zzdn);
                } else if (zzk2) {
                    zzdVar = new zzc(zzdn);
                }
            } else {
                zzdVar = new zze(zzdn);
            }
        }
        zzmp = zzdVar;
        zzmq = zzdp();
        zzer = zzdo();
        long zzi = zzi(byte[].class);
        zzmr = zzi;
        zzms = zzi(boolean[].class);
        zzmt = zzj(boolean[].class);
        zzmu = zzi(int[].class);
        zzmv = zzj(int[].class);
        zzmw = zzi(long[].class);
        zzmx = zzj(long[].class);
        zzmy = zzi(float[].class);
        zzmz = zzj(float[].class);
        zzna = zzi(double[].class);
        zznb = zzj(double[].class);
        zznc = zzi(Object[].class);
        zznd = zzj(Object[].class);
        Field zzdq = zzdq();
        if (zzdq != null && zzdVar != null) {
            j4 = zzdVar.zznh.objectFieldOffset(zzdq);
        } else {
            j4 = -1;
        }
        zzne = j4;
        zznf = (int) (zzi & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzng = z3;
    }

    private zzdy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(Object obj, long j4, int i4) {
        zzmp.zzb(obj, j4, i4);
    }

    private static Field zzc(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j4, boolean z3) {
        zzc(obj, j4, z3 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzdl() {
        return zzer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzdm() {
        return zzmq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzdn() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzdx());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzdo() {
        Unsafe unsafe = zzkr;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (zzp.zzy()) {
                return true;
            }
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
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzdp() {
        Unsafe unsafe = zzkr;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzdq() == null) {
                return false;
            }
            if (zzp.zzy()) {
                return true;
            }
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
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzdq() {
        Field zzc2;
        if (zzp.zzy() && (zzc2 = zzc(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzc2;
        }
        Field zzc3 = zzc(Buffer.class, IMAPStore.ID_ADDRESS);
        if (zzc3 != null && zzc3.getType() == Long.TYPE) {
            return zzc3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzh(Class<T> cls) {
        try {
            return (T) zzkr.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzer) {
            return zzmp.zznh.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzer) {
            return zzmp.zznh.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(Object obj, long j4) {
        return zzmp.zzk(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzl(Object obj, long j4) {
        return zzmp.zzl(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzm(Object obj, long j4) {
        return zzmp.zzm(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzn(Object obj, long j4) {
        return zzmp.zzn(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzo(Object obj, long j4) {
        return zzmp.zzo(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzp(Object obj, long j4) {
        return zzmp.zznh.getObject(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j4) {
        return (byte) (zzk(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzr(Object obj, long j4) {
        return (byte) (zzk(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j4) {
        if (zzq(obj, j4) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(Object obj, long j4) {
        if (zzr(obj, j4) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(Object obj, long j4, long j5) {
        zzmp.zzb(obj, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int i4 = (((int) j4) & 3) << 3;
        zzb(obj, j5, ((255 & b4) << i4) | (zzk(obj, j5) & (~(255 << i4))));
    }

    private static boolean zzk(Class<?> cls) {
        if (zzp.zzy()) {
            try {
                Class<?> cls2 = zzdw;
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
        return false;
    }

    /* loaded from: classes4.dex */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzb(Object obj, long j4, boolean z3) {
            if (!zzdy.zzng) {
                zzdy.zzd(obj, j4, z3);
            } else {
                zzdy.zzc(obj, j4, z3);
            }
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzf(Object obj, long j4, byte b4) {
            if (!zzdy.zzng) {
                zzdy.zzc(obj, j4, b4);
            } else {
                zzdy.zzb(obj, j4, b4);
            }
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final boolean zzm(Object obj, long j4) {
            return zzdy.zzng ? zzdy.zzs(obj, j4) : zzdy.zzt(obj, j4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final float zzn(Object obj, long j4) {
            return Float.intBitsToFloat(zzk(obj, j4));
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final double zzo(Object obj, long j4) {
            return Double.longBitsToDouble(zzl(obj, j4));
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final byte zzy(Object obj, long j4) {
            return zzdy.zzng ? zzdy.zzq(obj, j4) : zzdy.zzr(obj, j4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzb(Object obj, long j4, float f4) {
            zzb(obj, j4, Float.floatToIntBits(f4));
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzb(Object obj, long j4, double d4) {
            zzb(obj, j4, Double.doubleToLongBits(d4));
        }
    }

    /* loaded from: classes4.dex */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzb(Object obj, long j4, boolean z3) {
            if (!zzdy.zzng) {
                zzdy.zzd(obj, j4, z3);
            } else {
                zzdy.zzc(obj, j4, z3);
            }
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzf(Object obj, long j4, byte b4) {
            if (!zzdy.zzng) {
                zzdy.zzc(obj, j4, b4);
            } else {
                zzdy.zzb(obj, j4, b4);
            }
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final boolean zzm(Object obj, long j4) {
            return zzdy.zzng ? zzdy.zzs(obj, j4) : zzdy.zzt(obj, j4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final float zzn(Object obj, long j4) {
            return Float.intBitsToFloat(zzk(obj, j4));
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final double zzo(Object obj, long j4) {
            return Double.longBitsToDouble(zzl(obj, j4));
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final byte zzy(Object obj, long j4) {
            return zzdy.zzng ? zzdy.zzq(obj, j4) : zzdy.zzr(obj, j4);
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzb(Object obj, long j4, float f4) {
            zzb(obj, j4, Float.floatToIntBits(f4));
        }

        @Override // com.google.android.gms.internal.places.zzdy.zzd
        public final void zzb(Object obj, long j4, double d4) {
            zzb(obj, j4, Double.doubleToLongBits(d4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(Object obj, long j4, boolean z3) {
        zzmp.zzb(obj, j4, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(Object obj, long j4, float f4) {
        zzmp.zzb(obj, j4, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j4, boolean z3) {
        zzb(obj, j4, z3 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(Object obj, long j4, double d4) {
        zzmp.zzb(obj, j4, d4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(Object obj, long j4, Object obj2) {
        zzmp.zznh.putObject(obj, j4, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zzb(byte[] bArr, long j4) {
        return zzmp.zzy(bArr, zzmr + j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(byte[] bArr, long j4, byte b4) {
        zzmp.zzf(bArr, zzmr + j4, b4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int zzk = zzk(obj, j5);
        int i4 = ((~((int) j4)) & 3) << 3;
        zzb(obj, j5, ((255 & b4) << i4) | (zzk & (~(255 << i4))));
    }
}
