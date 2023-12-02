package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzefq implements zzfvy {
    final /* synthetic */ long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzezn zzc;
    final /* synthetic */ zzezq zzd;
    final /* synthetic */ zzfgn zze;
    final /* synthetic */ zzezz zzf;
    final /* synthetic */ zzefr zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzefq(zzefr zzefrVar, long j4, String str, zzezn zzeznVar, zzezq zzezqVar, zzfgn zzfgnVar, zzezz zzezzVar) {
        this.zzg = zzefrVar;
        this.zza = j4;
        this.zzb = str;
        this.zzc = zzeznVar;
        this.zzd = zzezqVar;
        this.zze = zzfgnVar;
        this.zzf = zzezzVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    @Override // com.google.android.gms.internal.ads.zzfvy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Throwable r13) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefq.zza(java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zzb(Object obj) {
        Clock clock;
        boolean z3;
        zzech zzechVar;
        zzefs zzefsVar;
        clock = this.zzg.zza;
        long elapsedRealtime = clock.elapsedRealtime() - this.zza;
        zzefr.zzg(this.zzg, this.zzb, 0, elapsedRealtime, this.zzc.zzag, null);
        zzefr zzefrVar = this.zzg;
        z3 = zzefrVar.zze;
        if (z3) {
            zzefsVar = zzefrVar.zzb;
            zzefsVar.zza(this.zzd, this.zzc, 0, null, elapsedRealtime);
        }
        zzechVar = this.zzg.zzf;
        zzechVar.zzf(this.zzc, elapsedRealtime, null);
    }
}
