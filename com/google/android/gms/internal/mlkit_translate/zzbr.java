package com.google.android.gms.internal.mlkit_translate;

import java.util.Set;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzbr extends zzbo {
    private final zzci zza = new zzci();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzbr) && ((zzbr) obj).zza.equals(this.zza)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzbo zza(String str) {
        return (zzbo) this.zza.get(str);
    }

    public final zzbr zzc(String str) {
        return (zzbr) this.zza.get(str);
    }

    public final zzbu zzd(String str) {
        return (zzbu) this.zza.get(str);
    }

    public final Set zze() {
        return this.zza.entrySet();
    }

    public final void zzf(String str, zzbo zzboVar) {
        this.zza.put(str, zzboVar);
    }

    public final boolean zzg(String str) {
        return this.zza.containsKey(str);
    }
}
