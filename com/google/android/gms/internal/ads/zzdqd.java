package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdqd implements zzfem {
    private final zzdpv zzb;
    private final Clock zzc;
    private final Map zza = new HashMap();
    private final Map zzd = new HashMap();

    public zzdqd(zzdpv zzdpvVar, Set set, Clock clock) {
        zzfef zzfefVar;
        this.zzb = zzdpvVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdqc zzdqcVar = (zzdqc) it.next();
            Map map = this.zzd;
            zzfefVar = zzdqcVar.zzc;
            map.put(zzfefVar, zzdqcVar);
        }
        this.zzc = clock;
    }

    private final void zze(zzfef zzfefVar, boolean z3) {
        zzfef zzfefVar2;
        String str;
        String str2;
        zzfefVar2 = ((zzdqc) this.zzd.get(zzfefVar)).zzb;
        if (this.zza.containsKey(zzfefVar2)) {
            if (true != z3) {
                str = "f.";
            } else {
                str = "s.";
            }
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfefVar2)).longValue();
            Map zza = this.zzb.zza();
            str2 = ((zzdqc) this.zzd.get(zzfefVar)).zza;
            zza.put("label.".concat(str2), str.concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbC(zzfef zzfefVar, String str, Throwable th) {
        if (this.zza.containsKey(zzfefVar)) {
            this.zzb.zza().put("task.".concat(String.valueOf(str)), "f.".concat(String.valueOf(Long.toString(this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfefVar)).longValue()))));
        }
        if (this.zzd.containsKey(zzfefVar)) {
            zze(zzfefVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzc(zzfef zzfefVar, String str) {
        this.zza.put(zzfefVar, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzd(zzfef zzfefVar, String str) {
        if (this.zza.containsKey(zzfefVar)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfefVar)).longValue();
            this.zzb.zza().put("task.".concat(String.valueOf(str)), "s.".concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfefVar)) {
            zze(zzfefVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbB(zzfef zzfefVar, String str) {
    }
}
