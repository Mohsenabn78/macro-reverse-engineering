package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgwf implements zzgwe, zzgvy {
    private static final zzgwf zza = new zzgwf(null);
    private final Object zzb;

    private zzgwf(Object obj) {
        this.zzb = obj;
    }

    public static zzgwe zza(Object obj) {
        zzgwm.zza(obj, "instance cannot be null");
        return new zzgwf(obj);
    }

    public static zzgwe zzc(Object obj) {
        if (obj == null) {
            return zza;
        }
        return new zzgwf(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final Object zzb() {
        return this.zzb;
    }
}
