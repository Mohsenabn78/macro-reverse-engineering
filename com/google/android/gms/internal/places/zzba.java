package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;

/* loaded from: classes4.dex */
final class zzba implements zzch {
    private static final zzba zzib = new zzba();

    private zzba() {
    }

    public static zzba zzbb() {
        return zzib;
    }

    @Override // com.google.android.gms.internal.places.zzch
    public final boolean zzb(Class<?> cls) {
        return zzbc.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.places.zzch
    public final zzci zzc(Class<?> cls) {
        String str;
        String str2;
        if (!zzbc.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            if (name.length() != 0) {
                str2 = "Unsupported message type: ".concat(name);
            } else {
                str2 = new String("Unsupported message type: ");
            }
            throw new IllegalArgumentException(str2);
        }
        try {
            return (zzci) zzbc.zzd(cls.asSubclass(zzbc.class)).zzb(zzbc.zze.zzin, (Object) null, (Object) null);
        } catch (Exception e4) {
            String name2 = cls.getName();
            if (name2.length() != 0) {
                str = "Unable to get message info for ".concat(name2);
            } else {
                str = new String("Unable to get message info for ");
            }
            throw new RuntimeException(str, e4);
        }
    }
}
