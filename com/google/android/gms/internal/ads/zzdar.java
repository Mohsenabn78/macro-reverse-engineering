package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdar {
    private final Set zza = new HashSet();
    private final Set zzb = new HashSet();
    private final Set zzc = new HashSet();
    private final Set zzd = new HashSet();
    private final Set zze = new HashSet();
    private final Set zzf = new HashSet();
    private final Set zzg = new HashSet();
    private final Set zzh = new HashSet();
    private final Set zzi = new HashSet();
    private final Set zzj = new HashSet();
    private final Set zzk = new HashSet();
    private final Set zzl = new HashSet();
    private final Set zzm = new HashSet();
    private final Set zzn = new HashSet();
    private zzexb zzo;

    public final zzdar zza(com.google.android.gms.ads.internal.client.zza zzaVar, Executor executor) {
        this.zzc.add(new zzdcm(zzaVar, executor));
        return this;
    }

    public final zzdar zzb(zzcvj zzcvjVar, Executor executor) {
        this.zzi.add(new zzdcm(zzcvjVar, executor));
        return this;
    }

    public final zzdar zzc(zzcvw zzcvwVar, Executor executor) {
        this.zzl.add(new zzdcm(zzcvwVar, executor));
        return this;
    }

    public final zzdar zzd(zzcwa zzcwaVar, Executor executor) {
        this.zzf.add(new zzdcm(zzcwaVar, executor));
        return this;
    }

    public final zzdar zze(zzcvg zzcvgVar, Executor executor) {
        this.zze.add(new zzdcm(zzcvgVar, executor));
        return this;
    }

    public final zzdar zzf(zzcwu zzcwuVar, Executor executor) {
        this.zzh.add(new zzdcm(zzcwuVar, executor));
        return this;
    }

    public final zzdar zzg(zzcxf zzcxfVar, Executor executor) {
        this.zzg.add(new zzdcm(zzcxfVar, executor));
        return this;
    }

    public final zzdar zzh(com.google.android.gms.ads.internal.overlay.zzo zzoVar, Executor executor) {
        this.zzn.add(new zzdcm(zzoVar, executor));
        return this;
    }

    public final zzdar zzi(zzcxr zzcxrVar, Executor executor) {
        this.zzm.add(new zzdcm(zzcxrVar, executor));
        return this;
    }

    public final zzdar zzj(zzcyb zzcybVar, Executor executor) {
        this.zzb.add(new zzdcm(zzcybVar, executor));
        return this;
    }

    public final zzdar zzk(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzdcm(appEventListener, executor));
        return this;
    }

    public final zzdar zzl(zzdcu zzdcuVar, Executor executor) {
        this.zzd.add(new zzdcm(zzdcuVar, executor));
        return this;
    }

    public final zzdar zzm(zzexb zzexbVar) {
        this.zzo = zzexbVar;
        return this;
    }

    public final zzdat zzn() {
        return new zzdat(this, null);
    }
}
