package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzns {
    private final zzct zza;
    private zzfsc zzb = zzfsc.zzl();
    private zzfsf zzc = zzfsf.zzd();
    @Nullable
    private zzto zzd;
    private zzto zze;
    private zzto zzf;

    public zzns(zzct zzctVar) {
        this.zza = zzctVar;
    }

    @Nullable
    private static zzto zzj(zzcp zzcpVar, zzfsc zzfscVar, @Nullable zzto zztoVar, zzct zzctVar) {
        Object zzf;
        int i4;
        zzcw zzn = zzcpVar.zzn();
        int zze = zzcpVar.zze();
        if (zzn.zzo()) {
            zzf = null;
        } else {
            zzf = zzn.zzf(zze);
        }
        if (!zzcpVar.zzx() && !zzn.zzo()) {
            i4 = zzn.zzd(zze, zzctVar, false).zzc(zzfj.zzo(zzcpVar.zzk()));
        } else {
            i4 = -1;
        }
        for (int i5 = 0; i5 < zzfscVar.size(); i5++) {
            zzto zztoVar2 = (zzto) zzfscVar.get(i5);
            if (zzm(zztoVar2, zzf, zzcpVar.zzx(), zzcpVar.zzb(), zzcpVar.zzc(), i4)) {
                return zztoVar2;
            }
        }
        if (zzfscVar.isEmpty() && zztoVar != null) {
            if (zzm(zztoVar, zzf, zzcpVar.zzx(), zzcpVar.zzb(), zzcpVar.zzc(), i4)) {
                return zztoVar;
            }
        }
        return null;
    }

    private final void zzk(zzfse zzfseVar, @Nullable zzto zztoVar, zzcw zzcwVar) {
        if (zztoVar == null) {
            return;
        }
        if (zzcwVar.zza(zztoVar.zza) != -1) {
            zzfseVar.zza(zztoVar, zzcwVar);
            return;
        }
        zzcw zzcwVar2 = (zzcw) this.zzc.get(zztoVar);
        if (zzcwVar2 != null) {
            zzfseVar.zza(zztoVar, zzcwVar2);
        }
    }

    private final void zzl(zzcw zzcwVar) {
        zzfse zzfseVar = new zzfse();
        if (this.zzb.isEmpty()) {
            zzk(zzfseVar, this.zze, zzcwVar);
            if (!zzfpc.zza(this.zzf, this.zze)) {
                zzk(zzfseVar, this.zzf, zzcwVar);
            }
            if (!zzfpc.zza(this.zzd, this.zze) && !zzfpc.zza(this.zzd, this.zzf)) {
                zzk(zzfseVar, this.zzd, zzcwVar);
            }
        } else {
            for (int i4 = 0; i4 < this.zzb.size(); i4++) {
                zzk(zzfseVar, (zzto) this.zzb.get(i4), zzcwVar);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfseVar, this.zzd, zzcwVar);
            }
        }
        this.zzc = zzfseVar.zzc();
    }

    private static boolean zzm(zzto zztoVar, @Nullable Object obj, boolean z3, int i4, int i5, int i6) {
        if (!zztoVar.zza.equals(obj)) {
            return false;
        }
        if (z3) {
            if (zztoVar.zzb != i4 || zztoVar.zzc != i5) {
                return false;
            }
        } else if (zztoVar.zzb != -1 || zztoVar.zze != i6) {
            return false;
        }
        return true;
    }

    @Nullable
    public final zzcw zza(zzto zztoVar) {
        return (zzcw) this.zzc.get(zztoVar);
    }

    @Nullable
    public final zzto zzb() {
        return this.zzd;
    }

    @Nullable
    public final zzto zzc() {
        Object next;
        Object obj;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfsc zzfscVar = this.zzb;
        if (zzfscVar instanceof List) {
            if (!zzfscVar.isEmpty()) {
                obj = zzfscVar.get(zzfscVar.size() - 1);
            } else {
                throw new NoSuchElementException();
            }
        } else {
            Iterator<E> it = zzfscVar.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        }
        return (zzto) obj;
    }

    @Nullable
    public final zzto zzd() {
        return this.zze;
    }

    @Nullable
    public final zzto zze() {
        return this.zzf;
    }

    public final void zzg(zzcp zzcpVar) {
        this.zzd = zzj(zzcpVar, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, @Nullable zzto zztoVar, zzcp zzcpVar) {
        this.zzb = zzfsc.zzj(list);
        if (!list.isEmpty()) {
            this.zze = (zzto) list.get(0);
            zztoVar.getClass();
            this.zzf = zztoVar;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzcpVar, this.zzb, this.zze, this.zza);
        }
        zzl(zzcpVar.zzn());
    }

    public final void zzi(zzcp zzcpVar) {
        this.zzd = zzj(zzcpVar, this.zzb, this.zze, this.zza);
        zzl(zzcpVar.zzn());
    }
}
