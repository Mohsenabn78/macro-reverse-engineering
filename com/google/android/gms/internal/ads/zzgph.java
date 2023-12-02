package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgph implements zzgqu {
    private static final zzgph zza = new zzgph();

    private zzgph() {
    }

    public static zzgph zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgqu
    public final zzgqt zzb(Class cls) {
        if (zzgpm.class.isAssignableFrom(cls)) {
            try {
                return (zzgqt) zzgpm.zzaC(cls.asSubclass(zzgpm.class)).zzb(3, null, null);
            } catch (Exception e4) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e4);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.ads.zzgqu
    public final boolean zzc(Class cls) {
        return zzgpm.class.isAssignableFrom(cls);
    }
}
