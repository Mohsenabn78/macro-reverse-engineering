package com.google.android.recaptcha.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzhq implements zzim {
    private static final zzhw zza = new zzho();
    private final zzhw zzb;

    public zzhq() {
        zzhw zzhwVar;
        zzhw[] zzhwVarArr = new zzhw[2];
        zzhwVarArr[0] = zzgh.zza();
        try {
            zzhwVar = (zzhw) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzhwVar = zza;
        }
        zzhwVarArr[1] = zzhwVar;
        zzhp zzhpVar = new zzhp(zzhwVarArr);
        byte[] bArr = zzgw.zzd;
        this.zzb = zzhpVar;
    }

    private static boolean zzb(zzhv zzhvVar) {
        if (zzhvVar.zzc() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzim
    public final zzil zza(Class cls) {
        zzin.zzF(cls);
        zzhv zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzgo.class.isAssignableFrom(cls)) {
                return zzic.zzc(zzin.zzA(), zzgc.zzb(), zzb.zza());
            }
            return zzic.zzc(zzin.zzy(), zzgc.zza(), zzb.zza());
        } else if (zzgo.class.isAssignableFrom(cls)) {
            if (zzb(zzb)) {
                return zzib.zzm(cls, zzb, zzif.zzb(), zzhm.zze(), zzin.zzA(), zzgc.zzb(), zzhu.zzb());
            }
            return zzib.zzm(cls, zzb, zzif.zzb(), zzhm.zze(), zzin.zzA(), null, zzhu.zzb());
        } else if (zzb(zzb)) {
            return zzib.zzm(cls, zzb, zzif.zza(), zzhm.zzd(), zzin.zzy(), zzgc.zza(), zzhu.zza());
        } else {
            return zzib.zzm(cls, zzb, zzif.zza(), zzhm.zzd(), zzin.zzz(), null, zzhu.zza());
        }
    }
}
