package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public enum zzlc implements zzbe {
    TYPE_UNKNOWN(0),
    TYPE_THIN(1),
    TYPE_THICK(2),
    TYPE_GMV(3);
    
    private final int zzf;

    zzlc(int i4) {
        this.zzf = i4;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzbe
    public final int zza() {
        return this.zzf;
    }
}
