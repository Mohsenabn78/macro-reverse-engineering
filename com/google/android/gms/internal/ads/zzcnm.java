package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcnm implements zzcvg, zzcwu, zzcwa, com.google.android.gms.ads.internal.client.zza, zzcvw {
    private final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    private final zzezz zze;
    private final zzezn zzf;
    private final zzfgn zzg;
    private final zzfar zzh;
    private final zzaqs zzi;
    private final zzbco zzj;
    private final zzffy zzk;
    private final WeakReference zzl;
    private final WeakReference zzm;
    @Nullable
    private final zzcui zzn;
    private boolean zzo;
    private final AtomicBoolean zzp = new AtomicBoolean();
    private final zzbcq zzq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnm(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzezz zzezzVar, zzezn zzeznVar, zzfgn zzfgnVar, zzfar zzfarVar, @Nullable View view, @Nullable zzcez zzcezVar, zzaqs zzaqsVar, zzbco zzbcoVar, zzbcq zzbcqVar, zzffy zzffyVar, @Nullable zzcui zzcuiVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzezzVar;
        this.zzf = zzeznVar;
        this.zzg = zzfgnVar;
        this.zzh = zzfarVar;
        this.zzi = zzaqsVar;
        this.zzl = new WeakReference(view);
        this.zzm = new WeakReference(zzcezVar);
        this.zzj = zzbcoVar;
        this.zzq = zzbcqVar;
        this.zzk = zzffyVar;
        this.zzn = zzcuiVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs() {
        String str;
        int i4;
        List list;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjY)).booleanValue() && ((list = this.zzf.zzd) == null || list.isEmpty())) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdg)).booleanValue()) {
            str = this.zzi.zzc().zzh(this.zza, (View) this.zzl.get(), null);
        } else {
            str = null;
        }
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzao)).booleanValue() && this.zze.zzb.zzb.zzg) || !((Boolean) zzbde.zzh.zze()).booleanValue()) {
            zzfar zzfarVar = this.zzh;
            zzfgn zzfgnVar = this.zzg;
            zzezz zzezzVar = this.zze;
            zzezn zzeznVar = this.zzf;
            zzfarVar.zza(zzfgnVar.zzd(zzezzVar, zzeznVar, false, str, null, zzeznVar.zzd));
            return;
        }
        if (((Boolean) zzbde.zzg.zze()).booleanValue() && ((i4 = this.zzf.zzb) == 1 || i4 == 2 || i4 == 5)) {
            zzcez zzcezVar = (zzcez) this.zzm.get();
        }
        zzfwc.zzq((zzfvt) zzfwc.zzn(zzfvt.zzv(zzfwc.zzh(null)), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaS)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcnl(this, str), this.zzb);
    }

    private final void zzt(final int i4, final int i5) {
        View view;
        if (i4 > 0 && ((view = (View) this.zzl.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnf
                @Override // java.lang.Runnable
                public final void run() {
                    zzcnm.this.zzi(i4, i5);
                }
            }, i5, TimeUnit.MILLISECONDS);
        } else {
            zzs();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if ((!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzao)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbde.zzd.zze()).booleanValue()) {
            zzfwc.zzq(zzfwc.zze(zzfvt.zzv(this.zzj.zza()), Throwable.class, new zzfov() { // from class: com.google.android.gms.internal.ads.zzcng
                @Override // com.google.android.gms.internal.ads.zzfov
                public final Object apply(Object obj) {
                    Throwable th = (Throwable) obj;
                    return "failure_click_attok";
                }
            }, zzcae.zzf), new zzcnk(this), this.zzb);
            return;
        }
        zzfar zzfarVar = this.zzh;
        zzfgn zzfgnVar = this.zzg;
        zzezz zzezzVar = this.zze;
        zzezn zzeznVar = this.zzf;
        List zzc = zzfgnVar.zzc(zzezzVar, zzeznVar, zzeznVar.zzc);
        int i4 = 1;
        if (true == com.google.android.gms.ads.internal.zzt.zzo().zzx(this.zza)) {
            i4 = 2;
        }
        zzfarVar.zzc(zzc, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzbr() {
        zzfar zzfarVar = this.zzh;
        zzfgn zzfgnVar = this.zzg;
        zzezz zzezzVar = this.zze;
        zzezn zzeznVar = this.zzf;
        zzfarVar.zza(zzfgnVar.zzc(zzezzVar, zzeznVar, zzeznVar.zzh));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnj
            @Override // java.lang.Runnable
            public final void run() {
                zzcnm.this.zzs();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(int i4, int i5) {
        zzt(i4 - 1, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(final int i4, final int i5) {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnh
            @Override // java.lang.Runnable
            public final void run() {
                zzcnm.this.zzh(i4, i5);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbr)).booleanValue()) {
            this.zzh.zza(this.zzg.zzc(this.zze, this.zzf, zzfgn.zzf(2, zzeVar.zza, this.zzf.zzp)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwa
    public final void zzl() {
        if (!this.zzp.compareAndSet(false, true)) {
            return;
        }
        int intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdp)).intValue();
        if (intValue > 0) {
            zzt(intValue, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdq)).intValue());
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdo)).booleanValue()) {
            this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcni
                @Override // java.lang.Runnable
                public final void run() {
                    zzcnm.this.zzg();
                }
            });
        } else {
            zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final synchronized void zzn() {
        zzcui zzcuiVar;
        if (this.zzo) {
            ArrayList arrayList = new ArrayList(this.zzf.zzd);
            arrayList.addAll(this.zzf.zzg);
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, true, null, null, arrayList));
        } else {
            zzfar zzfarVar = this.zzh;
            zzfgn zzfgnVar = this.zzg;
            zzezz zzezzVar = this.zze;
            zzezn zzeznVar = this.zzf;
            zzfarVar.zza(zzfgnVar.zzc(zzezzVar, zzeznVar, zzeznVar.zzn));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdl)).booleanValue() && (zzcuiVar = this.zzn) != null) {
                this.zzh.zza(this.zzg.zzc(this.zzn.zzc(), this.zzn.zzb(), zzfgn.zzg(zzcuiVar.zzb().zzn, zzcuiVar.zza().zzf())));
            }
            zzfar zzfarVar2 = this.zzh;
            zzfgn zzfgnVar2 = this.zzg;
            zzezz zzezzVar2 = this.zze;
            zzezn zzeznVar2 = this.zzf;
            zzfarVar2.zza(zzfgnVar2.zzc(zzezzVar2, zzeznVar2, zzeznVar2.zzg));
        }
        this.zzo = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzp(zzbuu zzbuuVar, String str, String str2) {
        zzfar zzfarVar = this.zzh;
        zzfgn zzfgnVar = this.zzg;
        zzezn zzeznVar = this.zzf;
        zzfarVar.zza(zzfgnVar.zze(zzeznVar, zzeznVar.zzi, zzbuuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzq() {
        zzfar zzfarVar = this.zzh;
        zzfgn zzfgnVar = this.zzg;
        zzezz zzezzVar = this.zze;
        zzezn zzeznVar = this.zzf;
        zzfarVar.zza(zzfgnVar.zzc(zzezzVar, zzeznVar, zzeznVar.zzj));
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzm() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzo() {
    }
}
