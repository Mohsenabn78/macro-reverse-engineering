package com.google.android.gms.internal.mlkit_translate;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzdd extends zzbx {
    private static final zzbo zze(zzdt zzdtVar, int i4) throws IOException {
        int i5 = i4 - 1;
        if (i5 != 5) {
            if (i5 != 6) {
                if (i5 != 7) {
                    if (i5 == 8) {
                        zzdtVar.zzi();
                        return zzbq.zza;
                    }
                    zzdu.zza(i4);
                    throw new IllegalStateException("Unexpected token: ".concat(zzdu.zza(i4)));
                }
                return new zzbu(Boolean.valueOf(zzdtVar.zzm()));
            }
            return new zzbu(new zzca(zzdtVar.zzd()));
        }
        return new zzbu(zzdtVar.zzd());
    }

    private static final zzbo zzf(zzdt zzdtVar, int i4) throws IOException {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 2) {
                return null;
            }
            zzdtVar.zzf();
            return new zzbr();
        }
        zzdtVar.zze();
        return new zzbn();
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzbx
    public final /* bridge */ /* synthetic */ Object zza(zzdt zzdtVar) throws IOException {
        String str;
        zzbo zzboVar;
        int zzn = zzdtVar.zzn();
        zzbo zzf = zzf(zzdtVar, zzn);
        if (zzf == null) {
            return zze(zzdtVar, zzn);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzdtVar.zzk()) {
                if (zzf instanceof zzbr) {
                    str = zzdtVar.zzc();
                } else {
                    str = null;
                }
                int zzn2 = zzdtVar.zzn();
                zzbo zzf2 = zzf(zzdtVar, zzn2);
                if (zzf2 == null) {
                    zzboVar = zze(zzdtVar, zzn2);
                } else {
                    zzboVar = zzf2;
                }
                if (zzf instanceof zzbn) {
                    ((zzbn) zzf).zza(zzboVar);
                } else {
                    ((zzbr) zzf).zzf(str, zzboVar);
                }
                if (zzf2 != null) {
                    arrayDeque.addLast(zzf);
                    zzf = zzboVar;
                }
            } else {
                if (zzf instanceof zzbn) {
                    zzdtVar.zzg();
                } else {
                    zzdtVar.zzh();
                }
                if (!arrayDeque.isEmpty()) {
                    zzf = (zzbo) arrayDeque.removeLast();
                } else {
                    return zzf;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzbx
    /* renamed from: zzd */
    public final void zzb(zzdv zzdvVar, zzbo zzboVar) throws IOException {
        if (zzboVar != null && !(zzboVar instanceof zzbq)) {
            if (zzboVar instanceof zzbu) {
                zzbu zzbuVar = (zzbu) zzboVar;
                if (zzbuVar.zzg()) {
                    zzdvVar.zzg(zzbuVar.zzc());
                    return;
                } else if (zzbuVar.zzf()) {
                    zzdvVar.zzi(zzbuVar.zze());
                    return;
                } else {
                    zzdvVar.zzh(zzbuVar.zzd());
                    return;
                }
            } else if (zzboVar instanceof zzbn) {
                zzdvVar.zza();
                Iterator it = ((zzbn) zzboVar).iterator();
                while (it.hasNext()) {
                    zzb(zzdvVar, (zzbo) it.next());
                }
                zzdvVar.zzc();
                return;
            } else if (zzboVar instanceof zzbr) {
                zzdvVar.zzb();
                for (Map.Entry entry : zzboVar.zzb().zze()) {
                    zzdvVar.zze((String) entry.getKey());
                    zzb(zzdvVar, (zzbo) entry.getValue());
                }
                zzdvVar.zzd();
                return;
            } else {
                Class<?> cls = zzboVar.getClass();
                cls.toString();
                throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(cls)));
            }
        }
        zzdvVar.zzf();
    }
}
