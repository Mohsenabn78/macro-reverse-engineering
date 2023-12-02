package com.google.android.gms.internal.mlkit_common;

import com.sun.mail.imap.IMAPStore;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzn {
    private static final Method zza;
    private static final Method zzb;
    private static final Method zzc;
    private static final Field zzd;
    private static final Field zze;
    private static final Field zzf;
    private static final Object zzg;
    private static final Throwable zzh;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.lang.reflect.AccessibleObject, java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    static {
        Field field;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Field field2;
        Throwable th;
        Object obj;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        try {
            cls = Class.forName("libcore.io.Libcore");
            cls2 = Class.forName("libcore.io.StructStat");
            Class<?> cls4 = Class.forName("libcore.io.OsConstants");
            cls3 = Class.forName("libcore.io.ForwardingOs");
            method = cls4.getDeclaredMethod("S_ISLNK", Integer.TYPE);
        } catch (Throwable th2) {
            th = th2;
            field = null;
            method = null;
            method2 = null;
        }
        try {
            method.setAccessible(true);
            method3 = cls3.getDeclaredMethod("lstat", String.class);
            try {
                method2 = cls3.getDeclaredMethod("fstat", FileDescriptor.class);
            } catch (Throwable th3) {
                th = th3;
                field = null;
                method2 = null;
                method4 = 0;
            }
            try {
                Field declaredField = cls.getDeclaredField(IMAPStore.ID_OS);
                declaredField.setAccessible(true);
                obj = declaredField.get(cls);
                try {
                    method4 = cls2.getField("st_dev");
                } catch (Throwable th4) {
                    th = th4;
                    method4 = 0;
                    field2 = null;
                }
            } catch (Throwable th5) {
                th = th5;
                field = null;
                method4 = 0;
                field2 = method4;
                th = th;
                obj = field2;
                zza = method;
                zzb = method3;
                zzc = method2;
                zzd = method4;
                zze = field2;
                zzf = field;
                zzg = obj;
                zzh = th;
            }
        } catch (Throwable th6) {
            th = th6;
            field = null;
            method2 = null;
            method3 = method2;
            method4 = method3;
            field2 = method4;
            th = th;
            obj = field2;
            zza = method;
            zzb = method3;
            zzc = method2;
            zzd = method4;
            zze = field2;
            zzf = field;
            zzg = obj;
            zzh = th;
        }
        try {
            field2 = cls2.getField("st_ino");
            try {
                field = cls2.getField("st_mode");
            } catch (Throwable th7) {
                field = null;
                th = th7;
            }
            try {
                method4.setAccessible(true);
                field2.setAccessible(true);
                field.setAccessible(true);
                zza = method;
                zzb = method3;
                zzc = method2;
                zzd = method4;
                zze = field2;
                zzf = field;
                zzg = obj;
                zzh = null;
            } catch (Throwable th8) {
                th = th8;
                zza = method;
                zzb = method3;
                zzc = method2;
                zzd = method4;
                zze = field2;
                zzf = field;
                zzg = obj;
                zzh = th;
            }
        } catch (Throwable th9) {
            th = th9;
            field2 = null;
            method4 = method4;
            th = th;
            field = field2;
            zza = method;
            zzb = method3;
            zzc = method2;
            zzd = method4;
            zze = field2;
            zzf = field;
            zzg = obj;
            zzh = th;
        }
    }

    static zzp zza(final FileDescriptor fileDescriptor) throws IOException {
        return (zzp) zzf(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzp zze2;
                zze2 = zzn.zze(zzn.zzc.invoke(zzn.zzg, fileDescriptor));
                return zze2;
            }
        });
    }

    static zzp zzd(final String str) throws IOException {
        return (zzp) zzf(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzp zze2;
                zze2 = zzn.zze(zzn.zzb.invoke(zzn.zzg, str));
                return zze2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzp zze(Object obj) throws Exception {
        return new zzp(((Long) zzd.get(obj)).longValue(), ((Long) zze.get(obj)).longValue(), ((Boolean) zza.invoke(null, Integer.valueOf(((Integer) zzf.get(obj)).intValue()))).booleanValue());
    }

    private static Object zzf(Callable callable) throws IOException {
        try {
            Throwable th = zzh;
            if (th == null) {
                return callable.call();
            }
            throw new IOException(th);
        } catch (Throwable th2) {
            throw new IOException(th2);
        }
    }
}
