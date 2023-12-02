package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzos {
    @Nullable
    private final Handler zza;
    @Nullable
    private final zzot zzb;

    public zzos(@Nullable Handler handler, @Nullable zzot zzotVar) {
        this.zza = zzotVar == null ? null : handler;
        this.zzb = zzotVar;
    }

    public final void zza(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoi
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzh(exc);
                }
            });
        }
    }

    public final void zzb(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoo
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzi(exc);
                }
            });
        }
    }

    public final void zzc(final String str, final long j4, final long j5) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzon
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzj(str, j4, j5);
                }
            });
        }
    }

    public final void zzd(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzop
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzk(str);
                }
            });
        }
    }

    public final void zze(final zzhz zzhzVar) {
        zzhzVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoj
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzl(zzhzVar);
                }
            });
        }
    }

    public final void zzf(final zzhz zzhzVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzok
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzm(zzhzVar);
                }
            });
        }
    }

    public final void zzg(final zzam zzamVar, @Nullable final zzia zziaVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoq
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzn(zzamVar, zziaVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Exception exc) {
        zzot zzotVar = this.zzb;
        int i4 = zzfj.zza;
        zzotVar.zzb(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Exception exc) {
        zzot zzotVar = this.zzb;
        int i4 = zzfj.zza;
        zzotVar.zzi(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(String str, long j4, long j5) {
        zzot zzotVar = this.zzb;
        int i4 = zzfj.zza;
        zzotVar.zzc(str, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(String str) {
        zzot zzotVar = this.zzb;
        int i4 = zzfj.zza;
        zzotVar.zzd(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzhz zzhzVar) {
        zzhzVar.zza();
        zzot zzotVar = this.zzb;
        int i4 = zzfj.zza;
        zzotVar.zze(zzhzVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzhz zzhzVar) {
        zzot zzotVar = this.zzb;
        int i4 = zzfj.zza;
        zzotVar.zzf(zzhzVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(zzam zzamVar, zzia zziaVar) {
        int i4 = zzfj.zza;
        this.zzb.zzg(zzamVar, zziaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(long j4) {
        zzot zzotVar = this.zzb;
        int i4 = zzfj.zza;
        zzotVar.zzh(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(boolean z3) {
        zzot zzotVar = this.zzb;
        int i4 = zzfj.zza;
        zzotVar.zzm(z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(int i4, long j4, long j5) {
        zzot zzotVar = this.zzb;
        int i5 = zzfj.zza;
        zzotVar.zzj(i4, j4, j5);
    }

    public final void zzr(final long j4) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzol
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzo(j4);
                }
            });
        }
    }

    public final void zzs(final boolean z3) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzom
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzp(z3);
                }
            });
        }
    }

    public final void zzt(final int i4, final long j4, final long j5) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzor
                @Override // java.lang.Runnable
                public final void run() {
                    zzos.this.zzq(i4, j4, j5);
                }
            });
        }
    }
}
