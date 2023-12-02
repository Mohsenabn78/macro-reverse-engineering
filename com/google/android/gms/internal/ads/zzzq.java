package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzzq {
    @Nullable
    private final Handler zza;
    @Nullable
    private final zzzr zzb;

    public zzzq(@Nullable Handler handler, @Nullable zzzr zzzrVar) {
        this.zza = zzzrVar == null ? null : handler;
        this.zzb = zzzrVar;
    }

    public final void zza(final String str, final long j4, final long j5) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzm
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzg(str, j4, j5);
                }
            });
        }
    }

    public final void zzb(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzp
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzh(str);
                }
            });
        }
    }

    public final void zzc(final zzhz zzhzVar) {
        zzhzVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzl
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzi(zzhzVar);
                }
            });
        }
    }

    public final void zzd(final int i4, final long j4) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzg
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzj(i4, j4);
                }
            });
        }
    }

    public final void zze(final zzhz zzhzVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzk
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzk(zzhzVar);
                }
            });
        }
    }

    public final void zzf(final zzam zzamVar, @Nullable final zzia zziaVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzn
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzl(zzamVar, zziaVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(String str, long j4, long j5) {
        zzzr zzzrVar = this.zzb;
        int i4 = zzfj.zza;
        zzzrVar.zzo(str, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str) {
        zzzr zzzrVar = this.zzb;
        int i4 = zzfj.zza;
        zzzrVar.zzp(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzhz zzhzVar) {
        zzhzVar.zza();
        zzzr zzzrVar = this.zzb;
        int i4 = zzfj.zza;
        zzzrVar.zzq(zzhzVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i4, long j4) {
        zzzr zzzrVar = this.zzb;
        int i5 = zzfj.zza;
        zzzrVar.zzk(i4, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzhz zzhzVar) {
        zzzr zzzrVar = this.zzb;
        int i4 = zzfj.zza;
        zzzrVar.zzr(zzhzVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzam zzamVar, zzia zziaVar) {
        int i4 = zzfj.zza;
        this.zzb.zzt(zzamVar, zziaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(Object obj, long j4) {
        zzzr zzzrVar = this.zzb;
        int i4 = zzfj.zza;
        zzzrVar.zzl(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(long j4, int i4) {
        zzzr zzzrVar = this.zzb;
        int i5 = zzfj.zza;
        zzzrVar.zzs(j4, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Exception exc) {
        zzzr zzzrVar = this.zzb;
        int i4 = zzfj.zza;
        zzzrVar.zzn(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzdn zzdnVar) {
        zzzr zzzrVar = this.zzb;
        int i4 = zzfj.zza;
        zzzrVar.zzu(zzdnVar);
    }

    public final void zzq(final Object obj) {
        if (this.zza != null) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzh
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzm(obj, elapsedRealtime);
                }
            });
        }
    }

    public final void zzr(final long j4, final int i4) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzj
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzn(j4, i4);
                }
            });
        }
    }

    public final void zzs(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzi
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzo(exc);
                }
            });
        }
    }

    public final void zzt(final zzdn zzdnVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzo
                @Override // java.lang.Runnable
                public final void run() {
                    zzzq.this.zzp(zzdnVar);
                }
            });
        }
    }
}
