package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
final class zzai implements zzat {
    private final zzaj zza;
    private final zzai zzb = this;
    private final zzcl<zzbi> zzc;
    private final zzcl<zzbc> zzd;
    private final zzcl<zzay> zze;
    private final zzcl zzf;
    private final zzcl<zzbg> zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzai(zzaj zzajVar, zzbc zzbcVar, zzaf zzafVar) {
        zzcl zzclVar;
        zzcl zzclVar2;
        zzap zzapVar;
        zzar zzarVar;
        zzcl zzclVar3;
        zzcl zzclVar4;
        zzcl zzclVar5;
        zzap zzapVar2;
        zzcl zzclVar6;
        zzcl zzclVar7;
        zzcl zzclVar8;
        this.zza = zzajVar;
        zzclVar = zzajVar.zzb;
        zzcl<zzbi> zza = zzcg.zza(new zzbj(zzclVar));
        this.zzc = zza;
        zzch zza2 = zzci.zza(zzbcVar);
        this.zzd = zza2;
        zzcf zzcfVar = new zzcf();
        this.zze = zzcfVar;
        zzclVar2 = zzajVar.zzb;
        zzapVar = zzao.zza;
        zzarVar = zzaq.zza;
        zzclVar3 = zzajVar.zzi;
        zzclVar4 = zzajVar.zzj;
        zzclVar5 = zzajVar.zzc;
        zzbn zzbnVar = new zzbn(zzclVar2, zza, zzapVar, zzarVar, zzclVar3, zzclVar4, zzcfVar, zzclVar5);
        this.zzf = zzbnVar;
        zzapVar2 = zzao.zza;
        zzbh zzbhVar = new zzbh(zza, zzapVar2, zzbnVar);
        this.zzg = zzbhVar;
        zzclVar6 = zzajVar.zzb;
        zzclVar7 = zzajVar.zzd;
        zzclVar8 = zzajVar.zzc;
        zzcf.zza(zzcfVar, zzcg.zza(new zzaz(zzclVar6, zzclVar7, zza, zzclVar8, zza2, zzbhVar)));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzat
    public final zzay zza() {
        return this.zze.zzb();
    }
}
