package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfbv implements zzfbu {
    private final ConcurrentHashMap zza;
    private final zzfcb zzb;
    private final zzfbx zzc = new zzfbx();

    public zzfbv(zzfcb zzfcbVar) {
        this.zza = new ConcurrentHashMap(zzfcbVar.zzd);
        this.zzb = zzfcbVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfcb> creator = zzfcb.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgf)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i4 = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i4++;
                sb.append(i4);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfce) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i5 = 0; i5 < ((zzfbt) entry.getValue()).zzb(); i5++) {
                    sb.append("[O]");
                }
                for (int zzb = ((zzfbt) entry.getValue()).zzb(); zzb < this.zzb.zzd; zzb++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfbt) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i4 < this.zzb.zzc) {
                i4++;
                sb.append(i4);
                sb.append(".\n");
            }
            zzbzr.zze(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfbu
    public final zzfcb zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfbu
    @Nullable
    public final synchronized zzfcd zzb(zzfce zzfceVar) {
        zzfcd zzfcdVar;
        zzfbt zzfbtVar = (zzfbt) this.zza.get(zzfceVar);
        if (zzfbtVar != null) {
            zzfcdVar = zzfbtVar.zze();
            if (zzfcdVar == null) {
                this.zzc.zze();
            }
            zzfcr zzf = zzfbtVar.zzf();
            if (zzfcdVar != null) {
                zzaxo zza = zzaxu.zza();
                zzaxm zza2 = zzaxn.zza();
                zza2.zzd(2);
                zzaxq zza3 = zzaxr.zza();
                zza3.zza(zzf.zza);
                zza3.zzb(zzf.zzb);
                zza2.zza(zza3);
                zza.zza(zza2);
                zzfcdVar.zza.zzb().zzc().zze((zzaxu) zza.zzal());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfcdVar = null;
        }
        return zzfcdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfbu
    @Deprecated
    public final zzfce zzc(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, com.google.android.gms.ads.internal.client.zzw zzwVar) {
        return new zzfcf(zzlVar, str, new zzbui(this.zzb.zza).zza().zzk, this.zzb.zzf, zzwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfbu
    public final synchronized boolean zzd(zzfce zzfceVar, zzfcd zzfcdVar) {
        boolean zzh;
        zzfbt zzfbtVar = (zzfbt) this.zza.get(zzfceVar);
        zzfcdVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        if (zzfbtVar == null) {
            zzfcb zzfcbVar = this.zzb;
            zzfbtVar = new zzfbt(zzfcbVar.zzd, zzfcbVar.zze * 1000);
            int size = this.zza.size();
            zzfcb zzfcbVar2 = this.zzb;
            if (size == zzfcbVar2.zzc) {
                int i4 = zzfcbVar2.zzg;
                int i5 = i4 - 1;
                zzfce zzfceVar2 = null;
                if (i4 != 0) {
                    long j4 = Long.MAX_VALUE;
                    if (i5 != 0) {
                        if (i5 != 1) {
                            if (i5 == 2) {
                                int i6 = Integer.MAX_VALUE;
                                for (Map.Entry entry : this.zza.entrySet()) {
                                    if (((zzfbt) entry.getValue()).zza() < i6) {
                                        i6 = ((zzfbt) entry.getValue()).zza();
                                        zzfceVar2 = (zzfce) entry.getKey();
                                    }
                                }
                                if (zzfceVar2 != null) {
                                    this.zza.remove(zzfceVar2);
                                }
                            }
                        } else {
                            for (Map.Entry entry2 : this.zza.entrySet()) {
                                if (((zzfbt) entry2.getValue()).zzd() < j4) {
                                    j4 = ((zzfbt) entry2.getValue()).zzd();
                                    zzfceVar2 = (zzfce) entry2.getKey();
                                }
                            }
                            if (zzfceVar2 != null) {
                                this.zza.remove(zzfceVar2);
                            }
                        }
                    } else {
                        for (Map.Entry entry3 : this.zza.entrySet()) {
                            if (((zzfbt) entry3.getValue()).zzc() < j4) {
                                j4 = ((zzfbt) entry3.getValue()).zzc();
                                zzfceVar2 = (zzfce) entry3.getKey();
                            }
                        }
                        if (zzfceVar2 != null) {
                            this.zza.remove(zzfceVar2);
                        }
                    }
                    this.zzc.zzg();
                } else {
                    throw null;
                }
            }
            this.zza.put(zzfceVar, zzfbtVar);
            this.zzc.zzd();
        }
        zzh = zzfbtVar.zzh(zzfcdVar);
        this.zzc.zzc();
        zzfbw zza = this.zzc.zza();
        zzfcr zzf = zzfbtVar.zzf();
        zzaxo zza2 = zzaxu.zza();
        zzaxm zza3 = zzaxn.zza();
        zza3.zzd(2);
        zzaxs zza4 = zzaxt.zza();
        zza4.zza(zza.zza);
        zza4.zzb(zza.zzb);
        zza4.zzc(zzf.zzb);
        zza3.zzc(zza4);
        zza2.zza(zza3);
        zzfcdVar.zza.zzb().zzc().zzf((zzaxu) zza2.zzal());
        zzf();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfbu
    public final synchronized boolean zze(zzfce zzfceVar) {
        zzfbt zzfbtVar = (zzfbt) this.zza.get(zzfceVar);
        if (zzfbtVar == null) {
            return true;
        }
        if (zzfbtVar.zzb() < this.zzb.zzd) {
            return true;
        }
        return false;
    }
}
