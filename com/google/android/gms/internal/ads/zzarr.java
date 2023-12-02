package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzarr implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzart zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarr(zzart zzartVar, int i4, boolean z3) {
        this.zzb = zzartVar;
        this.zza = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaon zzaonVar;
        zzart zzartVar = this.zzb;
        int i4 = this.zza;
        if (i4 > 0) {
            try {
                Thread.sleep(i4 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            PackageInfo packageInfo = zzartVar.zza.getPackageManager().getPackageInfo(zzartVar.zza.getPackageName(), 0);
            Context context = zzartVar.zza;
            zzaonVar = zzfjj.zza(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused2) {
            zzaonVar = null;
        }
        this.zzb.zzm = zzaonVar;
        if (this.zza < 4) {
            if (zzaonVar == null || !zzaonVar.zzaj() || zzaonVar.zzh().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zzaonVar.zzak() || !zzaonVar.zzf().zze() || zzaonVar.zzf().zza() == -2) {
                this.zzb.zzo(this.zza + 1, true);
            }
        }
    }
}
