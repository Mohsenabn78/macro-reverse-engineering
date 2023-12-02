package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzhj {
    private int zza;

    public final void zza(int i4) {
        this.zza = i4 | this.zza;
    }

    public void zzb() {
        this.zza = 0;
    }

    public final void zzc(int i4) {
        this.zza = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzd(int i4) {
        if ((this.zza & i4) == i4) {
            return true;
        }
        return false;
    }

    public final boolean zze() {
        return zzd(268435456);
    }

    public final boolean zzf() {
        return zzd(Integer.MIN_VALUE);
    }

    public final boolean zzg() {
        return zzd(4);
    }

    public final boolean zzh() {
        return zzd(1);
    }

    public final boolean zzi() {
        return zzd(536870912);
    }
}
