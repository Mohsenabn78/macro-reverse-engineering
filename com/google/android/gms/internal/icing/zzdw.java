package com.google.android.gms.internal.icing;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzdw implements zzeq {
    private static final zzec zzb = new zzdu();
    private final zzec zza;

    public zzdw() {
        zzec zzecVar;
        zzec[] zzecVarArr = new zzec[2];
        zzecVarArr[0] = zzcw.zza();
        try {
            zzecVar = (zzec) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzecVar = zzb;
        }
        zzecVarArr[1] = zzecVar;
        zzdv zzdvVar = new zzdv(zzecVarArr);
        zzdh.zzb(zzdvVar, "messageInfoFactory");
        this.zza = zzdvVar;
    }

    private static boolean zzb(zzeb zzebVar) {
        if (zzebVar.zzc() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.icing.zzeq
    public final <T> zzep<T> zza(Class<T> cls) {
        zzer.zza(cls);
        zzeb zzc = this.zza.zzc(cls);
        if (zzc.zza()) {
            if (zzda.class.isAssignableFrom(cls)) {
                return zzei.zzg(zzer.zzC(), zzcs.zza(), zzc.zzb());
            }
            return zzei.zzg(zzer.zzA(), zzcs.zzb(), zzc.zzb());
        } else if (zzda.class.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzeh.zzg(cls, zzc, zzek.zzb(), zzds.zzd(), zzer.zzC(), zzcs.zza(), zzea.zzb());
            }
            return zzeh.zzg(cls, zzc, zzek.zzb(), zzds.zzd(), zzer.zzC(), null, zzea.zzb());
        } else if (zzb(zzc)) {
            return zzeh.zzg(cls, zzc, zzek.zza(), zzds.zzc(), zzer.zzA(), zzcs.zzb(), zzea.zza());
        } else {
            return zzeh.zzg(cls, zzc, zzek.zza(), zzds.zzc(), zzer.zzB(), null, zzea.zza());
        }
    }
}
