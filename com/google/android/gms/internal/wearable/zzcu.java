package com.google.android.gms.internal.wearable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzcu implements zzdo {
    private static final zzda zza = new zzcs();
    private final zzda zzb;

    public zzcu() {
        zzda zzdaVar;
        zzda[] zzdaVarArr = new zzda[2];
        zzdaVarArr[0] = zzbr.zza();
        try {
            zzdaVar = (zzda) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzdaVar = zza;
        }
        zzdaVarArr[1] = zzdaVar;
        zzct zzctVar = new zzct(zzdaVarArr);
        zzcd.zzf(zzctVar, "messageInfoFactory");
        this.zzb = zzctVar;
    }

    private static boolean zzb(zzcz zzczVar) {
        if (zzczVar.zzc() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.wearable.zzdo
    public final zzdn zza(Class cls) {
        zzdp.zzG(cls);
        zzcz zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzbv.class.isAssignableFrom(cls)) {
                return zzdg.zzc(zzdp.zzB(), zzbm.zzb(), zzb.zza());
            }
            return zzdg.zzc(zzdp.zzz(), zzbm.zza(), zzb.zza());
        } else if (zzbv.class.isAssignableFrom(cls)) {
            if (zzb(zzb)) {
                return zzdf.zzl(cls, zzb, zzdi.zzb(), zzcq.zzd(), zzdp.zzB(), zzbm.zzb(), zzcy.zzb());
            }
            return zzdf.zzl(cls, zzb, zzdi.zzb(), zzcq.zzd(), zzdp.zzB(), null, zzcy.zzb());
        } else if (zzb(zzb)) {
            return zzdf.zzl(cls, zzb, zzdi.zza(), zzcq.zzc(), zzdp.zzz(), zzbm.zza(), zzcy.zza());
        } else {
            return zzdf.zzl(cls, zzb, zzdi.zza(), zzcq.zzc(), zzdp.zzA(), null, zzcy.zza());
        }
    }
}
