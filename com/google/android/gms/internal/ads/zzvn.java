package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzvn {
    public final int zzc;
    private final zzfsc zze;
    private int zzf;
    public static final zzvn zza = new zzvn(new zzcy[0]);
    private static final String zzd = Integer.toString(0, 36);
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzvm
    };

    public zzvn(zzcy... zzcyVarArr) {
        this.zze = zzfsc.zzk(zzcyVarArr);
        this.zzc = zzcyVarArr.length;
        int i4 = 0;
        while (i4 < this.zze.size()) {
            int i5 = i4 + 1;
            for (int i6 = i5; i6 < this.zze.size(); i6++) {
                if (((zzcy) this.zze.get(i4)).equals(this.zze.get(i6))) {
                    zzer.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i4 = i5;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzvn.class == obj.getClass()) {
            zzvn zzvnVar = (zzvn) obj;
            if (this.zzc == zzvnVar.zzc && this.zze.equals(zzvnVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.zzf;
        if (i4 == 0) {
            int hashCode = this.zze.hashCode();
            this.zzf = hashCode;
            return hashCode;
        }
        return i4;
    }

    public final int zza(zzcy zzcyVar) {
        int indexOf = this.zze.indexOf(zzcyVar);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public final zzcy zzb(int i4) {
        return (zzcy) this.zze.get(i4);
    }
}
