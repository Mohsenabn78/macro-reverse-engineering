package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzavl implements Comparator {
    public zzavl(zzavm zzavmVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzava zzavaVar = (zzava) obj;
        zzava zzavaVar2 = (zzava) obj2;
        if (zzavaVar.zzd() < zzavaVar2.zzd()) {
            return -1;
        }
        if (zzavaVar.zzd() <= zzavaVar2.zzd()) {
            if (zzavaVar.zzb() < zzavaVar2.zzb()) {
                return -1;
            }
            if (zzavaVar.zzb() <= zzavaVar2.zzb()) {
                float zza = (zzavaVar.zza() - zzavaVar.zzd()) * (zzavaVar.zzc() - zzavaVar.zzb());
                float zza2 = (zzavaVar2.zza() - zzavaVar2.zzd()) * (zzavaVar2.zzc() - zzavaVar2.zzb());
                if (zza > zza2) {
                    return -1;
                }
                if (zza >= zza2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
