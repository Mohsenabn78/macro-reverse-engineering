package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzefw implements zzfvj {
    private final zzfel zza;
    private final zzcvi zzb;
    private final zzfgn zzc;
    private final zzfgr zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcrg zzg;
    private final zzefr zzh;
    private final zzech zzi;
    private final Context zzj;
    private final zzffy zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzefw(Context context, zzfel zzfelVar, zzefr zzefrVar, zzcvi zzcviVar, zzfgn zzfgnVar, zzfgr zzfgrVar, zzcrg zzcrgVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzech zzechVar, zzffy zzffyVar) {
        this.zzj = context;
        this.zza = zzfelVar;
        this.zzh = zzefrVar;
        this.zzb = zzcviVar;
        this.zzc = zzfgnVar;
        this.zzd = zzfgrVar;
        this.zzg = zzcrgVar;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzechVar;
        this.zzk = zzffyVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzfj)).booleanValue() == false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    @Override // com.google.android.gms.internal.ads.zzfvj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzfwm zza(java.lang.Object r9) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefw.zza(java.lang.Object):com.google.android.gms.internal.ads.zzfwm");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(zzezn zzeznVar, zzezz zzezzVar, zzecc zzeccVar, Throwable th) throws Exception {
        zzffn zza = zzffm.zza(this.zzj, 12);
        zza.zzd(zzeznVar.zzF);
        zza.zzh();
        zzefr zzefrVar = this.zzh;
        zzfwm zzn = zzfwc.zzn(zzeccVar.zza(zzezzVar, zzeznVar), zzeznVar.zzS, TimeUnit.MILLISECONDS, this.zzf);
        zzefrVar.zze(zzezzVar, zzeznVar, zzn, this.zzc);
        zzffx.zza(zzn, this.zzk, zza);
        return zzn;
    }
}
