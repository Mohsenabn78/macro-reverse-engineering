package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public enum zziu implements zzbj {
    UNKNOWN(0),
    TRANSLATE(1);
    
    private final int zzd;

    zziu(int i4) {
        this.zzd = i4;
    }

    public static zziu zzb(int i4) {
        zziu[] values;
        for (zziu zziuVar : values()) {
            if (zziuVar.zzd == i4) {
                return zziuVar;
            }
        }
        return UNKNOWN;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbj
    public final int zza() {
        return this.zzd;
    }
}
