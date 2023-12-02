package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzlb {
    private final zzoc zza;
    private final zzla zze;
    private final zzls zzh;
    private final zzei zzi;
    private boolean zzj;
    @Nullable
    private zzhg zzk;
    private zzvi zzl = new zzvi(0);
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final List zzb = new ArrayList();
    private final HashMap zzf = new HashMap();
    private final Set zzg = new HashSet();

    public zzlb(zzla zzlaVar, zzls zzlsVar, zzei zzeiVar, zzoc zzocVar) {
        this.zza = zzocVar;
        this.zze = zzlaVar;
        this.zzh = zzlsVar;
        this.zzi = zzeiVar;
    }

    private final void zzp(int i4, int i5) {
        while (i4 < this.zzb.size()) {
            ((zzkz) this.zzb.get(i4)).zzd += i5;
            i4++;
        }
    }

    private final void zzq(zzkz zzkzVar) {
        zzky zzkyVar = (zzky) this.zzf.get(zzkzVar);
        if (zzkyVar != null) {
            zzkyVar.zza.zzi(zzkyVar.zzb);
        }
    }

    private final void zzr() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzkz zzkzVar = (zzkz) it.next();
            if (zzkzVar.zzc.isEmpty()) {
                zzq(zzkzVar);
                it.remove();
            }
        }
    }

    private final void zzs(zzkz zzkzVar) {
        if (zzkzVar.zze && zzkzVar.zzc.isEmpty()) {
            zzky zzkyVar = (zzky) this.zzf.remove(zzkzVar);
            zzkyVar.getClass();
            zzkyVar.zza.zzp(zzkyVar.zzb);
            zzkyVar.zza.zzs(zzkyVar.zzc);
            zzkyVar.zza.zzr(zzkyVar.zzc);
            this.zzg.remove(zzkzVar);
        }
    }

    private final void zzt(zzkz zzkzVar) {
        zztj zztjVar = zzkzVar.zza;
        zztp zztpVar = new zztp() { // from class: com.google.android.gms.internal.ads.zzkr
            @Override // com.google.android.gms.internal.ads.zztp
            public final void zza(zztq zztqVar, zzcw zzcwVar) {
                zzlb.this.zze(zztqVar, zzcwVar);
            }
        };
        zzkx zzkxVar = new zzkx(this, zzkzVar);
        this.zzf.put(zzkzVar, new zzky(zztjVar, zztpVar, zzkxVar));
        zztjVar.zzh(new Handler(zzfj.zzu(), null), zzkxVar);
        zztjVar.zzg(new Handler(zzfj.zzu(), null), zzkxVar);
        zztjVar.zzm(zztpVar, this.zzk, this.zza);
    }

    private final void zzu(int i4, int i5) {
        while (true) {
            i5--;
            if (i5 >= i4) {
                zzkz zzkzVar = (zzkz) this.zzb.remove(i5);
                this.zzd.remove(zzkzVar.zzb);
                zzp(i5, -zzkzVar.zza.zzB().zzc());
                zzkzVar.zze = true;
                if (this.zzj) {
                    zzs(zzkzVar);
                }
            } else {
                return;
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzcw zzb() {
        if (!this.zzb.isEmpty()) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.zzb.size(); i5++) {
                zzkz zzkzVar = (zzkz) this.zzb.get(i5);
                zzkzVar.zzd = i4;
                i4 += zzkzVar.zza.zzB().zzc();
            }
            return new zzlg(this.zzb, this.zzl);
        }
        return zzcw.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zztq zztqVar, zzcw zzcwVar) {
        this.zze.zzh();
    }

    public final void zzf(@Nullable zzhg zzhgVar) {
        zzdy.zzf(!this.zzj);
        this.zzk = zzhgVar;
        for (int i4 = 0; i4 < this.zzb.size(); i4++) {
            zzkz zzkzVar = (zzkz) this.zzb.get(i4);
            zzt(zzkzVar);
            this.zzg.add(zzkzVar);
        }
        this.zzj = true;
    }

    public final void zzg() {
        for (zzky zzkyVar : this.zzf.values()) {
            try {
                zzkyVar.zza.zzp(zzkyVar.zzb);
            } catch (RuntimeException e4) {
                zzer.zzd("MediaSourceList", "Failed to release child source.", e4);
            }
            zzkyVar.zza.zzs(zzkyVar.zzc);
            zzkyVar.zza.zzr(zzkyVar.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzh(zztm zztmVar) {
        zzkz zzkzVar = (zzkz) this.zzc.remove(zztmVar);
        zzkzVar.getClass();
        zzkzVar.zza.zzF(zztmVar);
        zzkzVar.zzc.remove(((zztg) zztmVar).zza);
        if (!this.zzc.isEmpty()) {
            zzr();
        }
        zzs(zzkzVar);
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final zzcw zzj(int i4, List list, zzvi zzviVar) {
        if (!list.isEmpty()) {
            this.zzl = zzviVar;
            for (int i5 = i4; i5 < list.size() + i4; i5++) {
                zzkz zzkzVar = (zzkz) list.get(i5 - i4);
                if (i5 > 0) {
                    zzkz zzkzVar2 = (zzkz) this.zzb.get(i5 - 1);
                    zzkzVar.zzc(zzkzVar2.zzd + zzkzVar2.zza.zzB().zzc());
                } else {
                    zzkzVar.zzc(0);
                }
                zzp(i5, zzkzVar.zza.zzB().zzc());
                this.zzb.add(i5, zzkzVar);
                this.zzd.put(zzkzVar.zzb, zzkzVar);
                if (this.zzj) {
                    zzt(zzkzVar);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzkzVar);
                    } else {
                        zzq(zzkzVar);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcw zzk(int i4, int i5, int i6, zzvi zzviVar) {
        boolean z3;
        if (zza() >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        this.zzl = null;
        return zzb();
    }

    public final zzcw zzl(int i4, int i5, zzvi zzviVar) {
        boolean z3 = false;
        if (i4 >= 0 && i4 <= i5 && i5 <= zza()) {
            z3 = true;
        }
        zzdy.zzd(z3);
        this.zzl = zzviVar;
        zzu(i4, i5);
        return zzb();
    }

    public final zzcw zzm(List list, zzvi zzviVar) {
        zzu(0, this.zzb.size());
        return zzj(this.zzb.size(), list, zzviVar);
    }

    public final zzcw zzn(zzvi zzviVar) {
        int zza = zza();
        if (zzviVar.zzc() != zza) {
            zzviVar = zzviVar.zzf().zzg(0, zza);
        }
        this.zzl = zzviVar;
        return zzb();
    }

    public final zztm zzo(zzto zztoVar, zzxp zzxpVar, long j4) {
        Object obj = zztoVar.zza;
        int i4 = zzlg.zzc;
        Object obj2 = ((Pair) obj).first;
        zzto zzc = zztoVar.zzc(((Pair) obj).second);
        zzkz zzkzVar = (zzkz) this.zzd.get(obj2);
        zzkzVar.getClass();
        this.zzg.add(zzkzVar);
        zzky zzkyVar = (zzky) this.zzf.get(zzkzVar);
        if (zzkyVar != null) {
            zzkyVar.zza.zzk(zzkyVar.zzb);
        }
        zzkzVar.zzc.add(zzc);
        zztg zzH = zzkzVar.zza.zzH(zzc, zzxpVar, j4);
        this.zzc.put(zzH, zzkzVar);
        zzr();
        return zzH;
    }
}
