package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdzk implements zzfem {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final zzfeu zzc;

    public zzdzk(Set set, zzfeu zzfeuVar) {
        zzfef zzfefVar;
        String str;
        zzfef zzfefVar2;
        String str2;
        this.zzc = zzfeuVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdzj zzdzjVar = (zzdzj) it.next();
            Map map = this.zza;
            zzfefVar = zzdzjVar.zzb;
            str = zzdzjVar.zza;
            map.put(zzfefVar, str);
            Map map2 = this.zzb;
            zzfefVar2 = zzdzjVar.zzc;
            str2 = zzdzjVar.zza;
            map2.put(zzfefVar2, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbC(zzfef zzfefVar, String str, Throwable th) {
        this.zzc.zze("task.".concat(String.valueOf(str)), "f.");
        if (this.zzb.containsKey(zzfefVar)) {
            this.zzc.zze("label.".concat(String.valueOf((String) this.zzb.get(zzfefVar))), "f.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzc(zzfef zzfefVar, String str) {
        this.zzc.zzd("task.".concat(String.valueOf(str)));
        if (this.zza.containsKey(zzfefVar)) {
            this.zzc.zzd("label.".concat(String.valueOf((String) this.zza.get(zzfefVar))));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzd(zzfef zzfefVar, String str) {
        this.zzc.zze("task.".concat(String.valueOf(str)), "s.");
        if (this.zzb.containsKey(zzfefVar)) {
            this.zzc.zze("label.".concat(String.valueOf((String) this.zzb.get(zzfefVar))), "s.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbB(zzfef zzfefVar, String str) {
    }
}
