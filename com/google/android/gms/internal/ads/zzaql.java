package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaql implements zzaqo {
    @Nullable
    private static zzaql zzb;
    private final Context zzc;
    private final zzfkq zzd;
    private final zzfkx zze;
    private final zzfkz zzf;
    private final zzarn zzg;
    private final zzfjb zzh;
    private final Executor zzi;
    private final zzfkw zzj;
    private final zzasc zzl;
    @Nullable
    private final zzaru zzm;
    @Nullable
    private final zzarl zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;
    @VisibleForTesting
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    @VisibleForTesting
    zzaql(@NonNull Context context, @NonNull zzfjb zzfjbVar, @NonNull zzfkq zzfkqVar, @NonNull zzfkx zzfkxVar, @NonNull zzfkz zzfkzVar, @NonNull zzarn zzarnVar, @NonNull Executor executor, @NonNull zzfiw zzfiwVar, int i4, @Nullable zzasc zzascVar, @Nullable zzaru zzaruVar, @Nullable zzarl zzarlVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzfjbVar;
        this.zzd = zzfkqVar;
        this.zze = zzfkxVar;
        this.zzf = zzfkzVar;
        this.zzg = zzarnVar;
        this.zzi = executor;
        this.zzr = i4;
        this.zzl = zzascVar;
        this.zzm = zzaruVar;
        this.zzn = zzarlVar;
        this.zzq = false;
        this.zzj = new zzaqj(this, zzfiwVar);
    }

    public static synchronized zzaql zza(@NonNull String str, @NonNull Context context, boolean z3, boolean z4) {
        zzaql zzb2;
        synchronized (zzaql.class) {
            zzb2 = zzb(str, context, Executors.newCachedThreadPool(), z3, z4);
        }
        return zzb2;
    }

    @Deprecated
    public static synchronized zzaql zzb(@NonNull String str, @NonNull Context context, @NonNull Executor executor, boolean z3, boolean z4) {
        zzaql zzaqlVar;
        zzaqw zzaqwVar;
        zzasc zzascVar;
        zzaru zzaruVar;
        zzarl zzarlVar;
        synchronized (zzaql.class) {
            if (zzb == null) {
                zzfjc zza = zzfjd.zza();
                zza.zza(str);
                zza.zzc(z3);
                zzfjd zzd = zza.zzd();
                zzfjb zza2 = zzfjb.zza(context, executor, z4);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcZ)).booleanValue()) {
                    zzaqwVar = zzaqw.zzc(context);
                } else {
                    zzaqwVar = null;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzda)).booleanValue()) {
                    zzascVar = zzasc.zzd(context, executor);
                } else {
                    zzascVar = null;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
                    zzaruVar = new zzaru();
                } else {
                    zzaruVar = null;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcr)).booleanValue()) {
                    zzarlVar = new zzarl();
                } else {
                    zzarlVar = null;
                }
                zzfju zze = zzfju.zze(context, executor, zza2, zzd);
                zzarm zzarmVar = new zzarm(context);
                zzarn zzarnVar = new zzarn(zzd, zze, new zzasa(context, zzarmVar), zzarmVar, zzaqwVar, zzascVar, zzaruVar, zzarlVar);
                int zzb2 = zzfkd.zzb(context, zza2);
                zzfiw zzfiwVar = new zzfiw();
                zzaql zzaqlVar2 = new zzaql(context, zza2, new zzfkq(context, zzb2), new zzfkx(context, zzb2, new zzaqi(zza2), ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbY)).booleanValue()), new zzfkz(context, zzarnVar, zza2, zzfiwVar), zzarnVar, executor, zzfiwVar, zzb2, zzascVar, zzaruVar, zzarlVar);
                zzb = zzaqlVar2;
                zzaqlVar2.zzm();
                zzb.zzp();
            }
            zzaqlVar = zzb;
        }
        return zzaqlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009a, code lost:
        if (r4.zzd().zzj().equals(r5.zzj()) != false) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* bridge */ /* synthetic */ void zzj(com.google.android.gms.internal.ads.zzaql r12) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaql.zzj(com.google.android.gms.internal.ads.zzaql):void");
    }

    private final void zzs() {
        zzasc zzascVar = this.zzl;
        if (zzascVar != null) {
            zzascVar.zzh();
        }
    }

    private final zzfkp zzt(int i4) {
        if (!zzfkd.zza(this.zzr)) {
            return null;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbW)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final String zze(Context context, @Nullable String str, @Nullable View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final String zzf(Context context, String str, @Nullable View view, @Nullable Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfje zza = this.zzf.zza();
        if (zza != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String zza2 = zza.zza(context, null, str, view, activity);
            this.zzh.zzf(5000, System.currentTimeMillis() - currentTimeMillis, zza2, null);
            return zza2;
        }
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final String zzg(Context context) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfje zza = this.zzf.zza();
        if (zza != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String zzc = zza.zzc(context, null);
            this.zzh.zzf(5001, System.currentTimeMillis() - currentTimeMillis, zzc, null);
            return zzc;
        }
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final String zzh(Context context, @Nullable View view, @Nullable Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfje zza = this.zzf.zza();
        if (zza != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String zzb2 = zza.zzb(context, null, view, activity);
            this.zzh.zzf(5002, System.currentTimeMillis() - currentTimeMillis, zzb2, null);
            return zzb2;
        }
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final void zzk(@Nullable MotionEvent motionEvent) {
        zzfje zza = this.zzf.zza();
        if (zza != null) {
            try {
                zza.zzd(null, motionEvent);
            } catch (zzfky e4) {
                this.zzh.zzc(e4.zza(), -1L, e4);
            }
        }
    }

    final synchronized void zzm() {
        long currentTimeMillis = System.currentTimeMillis();
        zzfkp zzt = zzt(1);
        if (zzt != null) {
            if (this.zzf.zzc(zzt)) {
                this.zzq = true;
                this.zzk.countDown();
                return;
            }
            return;
        }
        this.zzh.zzd(4013, System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzarl zzarlVar = this.zzn;
        if (zzarlVar != null) {
            zzarlVar.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final void zzo(@Nullable View view) {
        this.zzg.zzd(view);
    }

    public final void zzp() {
        if (!this.zzp) {
            synchronized (this.zzo) {
                if (!this.zzp) {
                    if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                        return;
                    }
                    zzfkp zzb2 = this.zzf.zzb();
                    if ((zzb2 == null || zzb2.zzd(3600L)) && zzfkd.zza(this.zzr)) {
                        this.zzi.execute(new zzaqk(this));
                    }
                }
            }
        }
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzaqo
    public final void zzl(int i4, int i5, int i6) {
    }
}
