package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdlu implements Callable {
    private final com.google.android.gms.ads.internal.zza zza;
    private final zzcfl zzb;
    private final Context zzc;
    private final zzdqa zzd;
    private final zzfev zze;
    private final zzeba zzf;
    private final Executor zzg;
    private final zzaqs zzh;
    private final zzbzx zzi;
    private final zzfgr zzj;
    private final zzebl zzk;

    public zzdlu(Context context, Executor executor, zzaqs zzaqsVar, zzbzx zzbzxVar, com.google.android.gms.ads.internal.zza zzaVar, zzcfl zzcflVar, zzeba zzebaVar, zzfgr zzfgrVar, zzdqa zzdqaVar, zzfev zzfevVar, zzebl zzeblVar) {
        this.zzc = context;
        this.zzg = executor;
        this.zzh = zzaqsVar;
        this.zzi = zzbzxVar;
        this.zza = zzaVar;
        this.zzb = zzcflVar;
        this.zzf = zzebaVar;
        this.zzj = zzfgrVar;
        this.zzd = zzdqaVar;
        this.zze = zzfevVar;
        this.zzk = zzeblVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Context zza(zzdlu zzdluVar) {
        return zzdluVar.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzaqs zzb(zzdlu zzdluVar) {
        return zzdluVar.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.zza zzc(zzdlu zzdluVar) {
        return zzdluVar.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzbzx zzd(zzdlu zzdluVar) {
        return zzdluVar.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzcfl zze(zzdlu zzdluVar) {
        return zzdluVar.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzdqa zzf(zzdlu zzdluVar) {
        return zzdluVar.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzeba zzg(zzdlu zzdluVar) {
        return zzdluVar.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzebl zzh(zzdlu zzdluVar) {
        return zzdluVar.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzfev zzi(zzdlu zzdluVar) {
        return zzdluVar.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzfgr zzj(zzdlu zzdluVar) {
        return zzdluVar.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Executor zzk(zzdlu zzdluVar) {
        return zzdluVar.zzg;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdlx zzdlxVar = new zzdlx(this);
        zzdlxVar.zzh();
        return zzdlxVar;
    }
}
