package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzewk implements zzexe {
    private final zzexe zza;
    private final zzexe zzb;
    private final zzfcq zzc;
    private final String zzd;
    private zzcun zze;
    private final Executor zzf;

    public zzewk(zzexe zzexeVar, zzexe zzexeVar2, zzfcq zzfcqVar, String str, Executor executor) {
        this.zza = zzexeVar;
        this.zzb = zzexeVar2;
        this.zzc = zzfcqVar;
        this.zzd = str;
        this.zzf = executor;
    }

    private final zzfwm zzg(zzfcd zzfcdVar, zzexf zzexfVar) {
        zzcun zzcunVar = zzfcdVar.zza;
        this.zze = zzcunVar;
        if (zzfcdVar.zzc != null) {
            if (zzcunVar.zzf() != null) {
                zzfcdVar.zzc.zzo().zzbG(zzfcdVar.zza.zzf());
            }
            return zzfwc.zzh(zzfcdVar.zzc);
        }
        zzcunVar.zzb().zzl(zzfcdVar.zzb);
        return ((zzewu) this.zza).zzb(zzexfVar, null, zzfcdVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzexe
    /* renamed from: zza */
    public final synchronized zzcun zzd() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(zzexf zzexfVar, zzewj zzewjVar, zzexd zzexdVar, zzcun zzcunVar, zzewp zzewpVar) throws Exception {
        if (zzewpVar != null) {
            zzewj zzewjVar2 = new zzewj(zzewjVar.zza, zzewjVar.zzb, zzewjVar.zzc, zzewjVar.zzd, zzewjVar.zze, zzewjVar.zzf, zzewpVar.zza);
            if (zzewpVar.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzewjVar2);
                return zzg(zzewpVar.zzc, zzexfVar);
            }
            zzfwm zza = this.zzc.zza(zzewjVar2);
            if (zza != null) {
                this.zze = null;
                return zzfwc.zzm(zza, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzewg
                    @Override // com.google.android.gms.internal.ads.zzfvj
                    public final zzfwm zza(Object obj) {
                        return zzewk.this.zze((zzfcn) obj);
                    }
                }, this.zzf);
            }
            this.zzc.zze(zzewjVar2);
            zzexfVar = new zzexf(zzexfVar.zzb, zzewpVar.zzb);
        }
        zzfwm zzb = ((zzewu) this.zza).zzb(zzexfVar, zzexdVar, zzcunVar);
        this.zze = zzcunVar;
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzexe
    public final /* bridge */ /* synthetic */ zzfwm zzc(zzexf zzexfVar, zzexd zzexdVar, Object obj) {
        return zzf(zzexfVar, zzexdVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zze(zzfcn zzfcnVar) throws Exception {
        zzfcp zzfcpVar;
        if (zzfcnVar != null && zzfcnVar.zza != null && (zzfcpVar = zzfcnVar.zzb) != null) {
            zzaxo zza = zzaxu.zza();
            zzaxm zza2 = zzaxn.zza();
            zza2.zzd(2);
            zza2.zzb(zzaxr.zzd());
            zza.zza(zza2);
            zzfcnVar.zza.zza.zzb().zzc().zzi((zzaxu) zza.zzal());
            return zzg(zzfcnVar.zza, ((zzewj) zzfcpVar).zzb);
        }
        throw new zzdtx(1, "Empty prefetch");
    }

    public final synchronized zzfwm zzf(final zzexf zzexfVar, final zzexd zzexdVar, zzcun zzcunVar) {
        zzcum zza = zzexdVar.zza(zzexfVar.zzb);
        zza.zza(new zzewl(this.zzd));
        final zzcun zzcunVar2 = (zzcun) zza.zzh();
        zzcunVar2.zzg();
        zzcunVar2.zzg();
        com.google.android.gms.ads.internal.client.zzl zzlVar = zzcunVar2.zzg().zzd;
        if (zzlVar.zzs == null && zzlVar.zzx == null) {
            zzfai zzg = zzcunVar2.zzg();
            final zzewj zzewjVar = new zzewj(zzexdVar, zzexfVar, zzg.zzd, zzg.zzf, this.zzf, zzg.zzj, null);
            return zzfwc.zzm(zzfvt.zzv(((zzewq) this.zzb).zzb(zzexfVar, zzexdVar, zzcunVar2)), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzewh
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    return zzewk.this.zzb(zzexfVar, zzewjVar, zzexdVar, zzcunVar2, (zzewp) obj);
                }
            }, this.zzf);
        }
        this.zze = zzcunVar2;
        return ((zzewu) this.zza).zzb(zzexfVar, zzexdVar, zzcunVar2);
    }
}
