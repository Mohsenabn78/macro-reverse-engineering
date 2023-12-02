package com.google.android.gms.internal.mlkit_translate;

import java.math.BigInteger;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzbu extends zzbo {
    private final Object zza;

    public zzbu(Boolean bool) {
        this.zza = bool;
    }

    private static boolean zzh(zzbu zzbuVar) {
        Object obj = zzbuVar.zza;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if (!(number instanceof BigInteger) && !(number instanceof Long) && !(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            return false;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzbu.class != obj.getClass()) {
            return false;
        }
        zzbu zzbuVar = (zzbu) obj;
        if (zzh(this) && zzh(zzbuVar)) {
            if (zzc().longValue() == zzbuVar.zzc().longValue()) {
                return true;
            }
            return false;
        }
        Object obj2 = this.zza;
        if ((obj2 instanceof Number) && (zzbuVar.zza instanceof Number)) {
            double doubleValue = zzc().doubleValue();
            double doubleValue2 = zzbuVar.zzc().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                return true;
            }
            return false;
        }
        return obj2.equals(zzbuVar.zza);
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (zzh(this)) {
            doubleToLongBits = zzc().longValue();
        } else {
            Object obj = this.zza;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(zzc().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public final long zza() {
        if (this.zza instanceof Number) {
            return zzc().longValue();
        }
        return Long.parseLong(zzd());
    }

    public final Number zzc() {
        Object obj = this.zza;
        if (obj instanceof String) {
            return new zzca((String) obj);
        }
        return (Number) obj;
    }

    public final String zzd() {
        Object obj = this.zza;
        if (!(obj instanceof Number)) {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).toString();
            }
            return (String) obj;
        }
        return zzc().toString();
    }

    public final boolean zze() {
        Object obj = this.zza;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(zzd());
    }

    public final boolean zzf() {
        return this.zza instanceof Boolean;
    }

    public final boolean zzg() {
        return this.zza instanceof Number;
    }

    public zzbu(Number number) {
        this.zza = number;
    }

    public zzbu(String str) {
        str.getClass();
        this.zza = str;
    }
}
