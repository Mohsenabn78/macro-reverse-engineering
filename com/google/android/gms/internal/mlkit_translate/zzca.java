package com.google.android.gms.internal.mlkit_translate;

import java.math.BigDecimal;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzca extends Number {
    private final String zza;

    public zzca(String str) {
        this.zza = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.zza);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzca)) {
            return false;
        }
        String str = this.zza;
        String str2 = ((zzca) obj).zza;
        if (str == str2 || str.equals(str2)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            try {
                return Integer.parseInt(this.zza);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.zza).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.zza);
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.zza);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.zza).longValue();
        }
    }

    public final String toString() {
        return this.zza;
    }
}
