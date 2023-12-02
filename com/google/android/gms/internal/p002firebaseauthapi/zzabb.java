package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabb  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzabb {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzabb";

    private zzabb() {
    }

    public static Object zza(String str, Type type) throws zzyt {
        if (type == String.class) {
            try {
                zzact zzactVar = new zzact();
                zzactVar.zzb(str);
                if (zzactVar.zzd()) {
                    return zzactVar.zzc();
                }
                throw new zzyt("No error message: " + str);
            } catch (Exception e4) {
                throw new zzyt("Json conversion failed! ".concat(String.valueOf(e4.getMessage())), e4);
            }
        } else if (type != Void.class) {
            try {
                try {
                    return ((zzabd) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0])).zza(str);
                } catch (Exception e5) {
                    throw new zzyt("Json conversion failed! ".concat(String.valueOf(e5.getMessage())), e5);
                }
            } catch (Exception e6) {
                throw new zzyt("Instantiation of JsonResponse failed! ".concat(type.toString()), e6);
            }
        } else {
            return null;
        }
    }
}
