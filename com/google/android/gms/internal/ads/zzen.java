package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzen {
    public final Object zza;
    private zzaf zzb = new zzaf();
    private boolean zzc;
    private boolean zzd;

    public zzen(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzen.class == obj.getClass()) {
            return this.zza.equals(((zzen) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i4, zzel zzelVar) {
        if (!this.zzd) {
            if (i4 != -1) {
                this.zzb.zza(i4);
            }
            this.zzc = true;
            zzelVar.zza(this.zza);
        }
    }

    public final void zzb(zzem zzemVar) {
        if (!this.zzd && this.zzc) {
            zzah zzb = this.zzb.zzb();
            this.zzb = new zzaf();
            this.zzc = false;
            zzemVar.zza(this.zza, zzb);
        }
    }

    public final void zzc(zzem zzemVar) {
        this.zzd = true;
        if (this.zzc) {
            this.zzc = false;
            zzemVar.zza(this.zza, this.zzb.zzb());
        }
    }
}
