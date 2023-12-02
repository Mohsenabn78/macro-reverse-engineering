package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzks {
    private Long zza;
    private zzld zzb;
    private Boolean zzc;

    public final zzks zza(Long l4) {
        this.zza = Long.valueOf(l4.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzks zzb(zzld zzldVar) {
        this.zzb = zzldVar;
        return this;
    }

    public final zzks zzc(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzku zzd() {
        return new zzku(this, null);
    }
}
