package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdsa implements zzfvy {
    final /* synthetic */ zzdsc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdsa(zzdsc zzdscVar) {
        this.zza = zzdscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        long j4;
        zzcaj zzcajVar;
        synchronized (this) {
            this.zza.zzc = true;
            zzdsc zzdscVar = this.zza;
            long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
            j4 = this.zza.zzd;
            zzdscVar.zzv("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (elapsedRealtime - j4));
            zzcajVar = this.zza.zze;
            zzcajVar.zze(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        long j4;
        Executor executor;
        final String str = (String) obj;
        synchronized (this) {
            this.zza.zzc = true;
            zzdsc zzdscVar = this.zza;
            long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
            j4 = this.zza.zzd;
            zzdscVar.zzv("com.google.android.gms.ads.MobileAds", true, "", (int) (elapsedRealtime - j4));
            executor = this.zza.zzi;
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrz
                @Override // java.lang.Runnable
                public final void run() {
                    zzdsa zzdsaVar = zzdsa.this;
                    zzdsc.zzj(zzdsaVar.zza, str);
                }
            });
        }
    }
}
