package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfgb implements Runnable {
    @GuardedBy("enabledLock")
    @VisibleForTesting
    public static Boolean zzb;
    private final Context zze;
    private final zzbzx zzf;
    private int zzi;
    private final zzdns zzj;
    private final List zzk;
    private final zzdyw zzm;
    private final zzbuq zzn;
    @VisibleForTesting
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    @GuardedBy("protoLock")
    private final zzfgg zzg = zzfgj.zzc();
    private String zzh = "";
    @GuardedBy("initLock")
    private boolean zzl = false;

    public zzfgb(Context context, zzbzx zzbzxVar, zzdns zzdnsVar, zzdyw zzdywVar, zzbuq zzbuqVar) {
        this.zze = context;
        this.zzf = zzbzxVar;
        this.zzj = zzdnsVar;
        this.zzm = zzdywVar;
        this.zzn = zzbuqVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziq)).booleanValue()) {
            this.zzk = com.google.android.gms.ads.internal.util.zzs.zzd();
        } else {
            this.zzk = zzfsc.zzl();
        }
    }

    public static boolean zza() {
        boolean booleanValue;
        boolean z3;
        synchronized (zza) {
            if (zzb == null) {
                if (!((Boolean) zzbcy.zzb.zze()).booleanValue()) {
                    zzb = Boolean.FALSE;
                } else {
                    if (Math.random() < ((Double) zzbcy.zza.zze()).doubleValue()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zzb = Boolean.valueOf(z3);
                }
            }
            booleanValue = zzb.booleanValue();
        }
        return booleanValue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] zzax;
        if (!zza()) {
            return;
        }
        Object obj = zzc;
        synchronized (obj) {
            if (this.zzg.zza() == 0) {
                return;
            }
            try {
                synchronized (obj) {
                    zzax = ((zzfgj) this.zzg.zzal()).zzax();
                    this.zzg.zzc();
                }
                new zzdyv(this.zze, this.zzf.zza, this.zzn, Binder.getCallingUid()).zza(new zzdyt((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzik), 60000, new HashMap(), zzax, "application/x-protobuf", false));
            } catch (Exception e4) {
                if ((e4 instanceof zzdtx) && ((zzdtx) e4).zza() == 3) {
                    return;
                }
                com.google.android.gms.ads.internal.zzt.zzo().zzt(e4, "CuiMonitor.sendCuiPing");
            }
        }
    }

    public final void zzb(@Nullable final zzffr zzffrVar) {
        zzcae.zza.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfga
            @Override // java.lang.Runnable
            public final void run() {
                zzfgb.this.zzc(zzffrVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzffr zzffrVar) {
        synchronized (zzd) {
            if (!this.zzl) {
                this.zzl = true;
                if (zza()) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    this.zzh = com.google.android.gms.ads.internal.util.zzs.zzn(this.zze);
                    this.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze);
                    long intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzil)).intValue();
                    zzcae.zzd.scheduleAtFixedRate(this, intValue, intValue, TimeUnit.MILLISECONDS);
                }
            }
        }
        if (!zza() || zzffrVar == null) {
            return;
        }
        synchronized (zzc) {
            if (this.zzg.zza() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzim)).intValue()) {
                return;
            }
            zzfgd zza2 = zzfge.zza();
            zza2.zzt(zzffrVar.zzl());
            zza2.zzp(zzffrVar.zzk());
            zza2.zzg(zzffrVar.zzb());
            zza2.zzv(3);
            zza2.zzm(this.zzf.zza);
            zza2.zzb(this.zzh);
            zza2.zzk(Build.VERSION.RELEASE);
            zza2.zzq(Build.VERSION.SDK_INT);
            zza2.zzu(zzffrVar.zzn());
            zza2.zzj(zzffrVar.zza());
            zza2.zze(this.zzi);
            zza2.zzs(zzffrVar.zzm());
            zza2.zzc(zzffrVar.zzd());
            zza2.zzf(zzffrVar.zzf());
            zza2.zzh(zzffrVar.zzg());
            zza2.zzi(this.zzj.zzc(zzffrVar.zzg()));
            zza2.zzl(zzffrVar.zzh());
            zza2.zzd(zzffrVar.zze());
            zza2.zzr(zzffrVar.zzj());
            zza2.zzn(zzffrVar.zzi());
            zza2.zzo(zzffrVar.zzc());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziq)).booleanValue()) {
                zza2.zza(this.zzk);
            }
            zzfgg zzfggVar = this.zzg;
            zzfgh zza3 = zzfgi.zza();
            zza3.zza(zza2);
            zzfggVar.zzb(zza3);
        }
    }
}
