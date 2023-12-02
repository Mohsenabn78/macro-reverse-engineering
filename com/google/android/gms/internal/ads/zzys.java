package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzys {
    private static Constructor zza;
    private static Method zzb;
    private static Method zzc;

    public static zzae zza(float f4) throws Exception {
        if (zza == null || zzb == null || zzc == null) {
            Class<?> cls = Class.forName("androidx.media3.effect.ScaleAndRotateTransformation$Builder");
            zza = cls.getConstructor(new Class[0]);
            zzb = cls.getMethod("setRotationDegrees", Float.TYPE);
            zzc = cls.getMethod("build", new Class[0]);
        }
        Object newInstance = zza.newInstance(new Object[0]);
        zzb.invoke(newInstance, Float.valueOf(f4));
        Object invoke = zzc.invoke(newInstance, new Object[0]);
        invoke.getClass();
        return (zzae) invoke;
    }
}
