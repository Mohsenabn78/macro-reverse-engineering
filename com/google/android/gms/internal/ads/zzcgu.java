package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzcgu implements zzcmg {
    @Nullable
    private static zzcgu zza;

    private static synchronized zzcgu zzC(Context context, @Nullable zzbnw zzbnwVar, int i4, boolean z3, int i5, zzchy zzchyVar) {
        synchronized (zzcgu.class) {
            zzcgu zzcguVar = zza;
            if (zzcguVar != null) {
                return zzcguVar;
            }
            zzbbm.zza(context);
            zzfbb zzd = zzfbb.zzd(context);
            zzbzx zzc = zzd.zzc(ModuleDescriptor.MODULE_VERSION, false, i5);
            zzd.zzf(zzbnwVar);
            zzcjm zzcjmVar = new zzcjm(null);
            zzcgv zzcgvVar = new zzcgv();
            zzcgvVar.zzd(zzc);
            zzcgvVar.zzc(context);
            zzcjmVar.zzb(new zzcgx(zzcgvVar, null));
            zzcjmVar.zzc(new zzckz(zzchyVar));
            zzcgu zza2 = zzcjmVar.zza();
            com.google.android.gms.ads.internal.zzt.zzo().zzs(context, zzc);
            com.google.android.gms.ads.internal.zzt.zzc().zzi(context);
            com.google.android.gms.ads.internal.zzt.zzp().zzj(context);
            com.google.android.gms.ads.internal.zzt.zzp().zzi(context);
            com.google.android.gms.ads.internal.util.zzd.zza(context);
            com.google.android.gms.ads.internal.zzt.zzb().zzd(context);
            com.google.android.gms.ads.internal.zzt.zzv().zzb(context);
            zzbxx.zzd(context);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfW)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzav)).booleanValue()) {
                    zzawz zzawzVar = new zzawz(new zzaxf(context));
                    zzdzt zzdztVar = new zzdzt(new zzdzp(context), zza2.zzz());
                    com.google.android.gms.ads.internal.zzt.zzp();
                    new zzeap(context, zzc, zzawzVar, zzdztVar, UUID.randomUUID().toString(), zza2.zzx()).zzb(com.google.android.gms.ads.internal.zzt.zzo().zzh().zzP());
                }
            }
            zza = zza2;
            return zza2;
        }
    }

    public static zzcgu zza(Context context, @Nullable zzbnw zzbnwVar, int i4) {
        return zzC(context, zzbnwVar, ModuleDescriptor.MODULE_VERSION, false, i4, new zzchy());
    }

    public abstract Executor zzA();

    public abstract ScheduledExecutorService zzB();

    public abstract zzclj zzb();

    public abstract zzcoo zzc();

    public abstract zzcpx zzd();

    public abstract zzcxv zze();

    public abstract zzden zzf();

    public abstract zzdfj zzg();

    public abstract zzdmq zzh();

    public abstract zzdri zzi();

    public abstract zzdsx zzj();

    public abstract zzdtr zzk();

    public abstract zzebl zzl();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzc zzm();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzg zzn();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzaa zzo();

    @Override // com.google.android.gms.internal.ads.zzcmg
    public final zzerq zzp(zzbue zzbueVar, int i4) {
        return zzq(new zzets(zzbueVar, i4));
    }

    protected abstract zzerq zzq(zzets zzetsVar);

    public abstract zzeun zzr();

    public abstract zzewb zzs();

    public abstract zzexs zzt();

    public abstract zzezg zzu();

    public abstract zzfau zzv();

    public abstract zzfbe zzw();

    public abstract zzfev zzx();

    public abstract zzfgb zzy();

    public abstract zzfwn zzz();
}
