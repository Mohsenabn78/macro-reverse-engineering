package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaia  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaia implements zzaiv {
    private static final zzaig zza = new zzahy();
    private final zzaig zzb;

    public zzaia() {
        zzaig zzaigVar;
        zzaig[] zzaigVarArr = new zzaig[2];
        zzaigVarArr[0] = zzagy.zza();
        try {
            zzaigVar = (zzaig) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzaigVar = zza;
        }
        zzaigVarArr[1] = zzaigVar;
        zzahz zzahzVar = new zzahz(zzaigVarArr);
        byte[] bArr = zzahj.zzd;
        this.zzb = zzahzVar;
    }

    private static boolean zzb(zzaif zzaifVar) {
        if (zzaifVar.zzc() - 1 != 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiv
    public final zzaiu zza(Class cls) {
        zzaiw.zzr(cls);
        zzaif zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzahd.class.isAssignableFrom(cls)) {
                return zzaim.zzc(zzaiw.zzn(), zzagt.zzb(), zzb.zza());
            }
            return zzaim.zzc(zzaiw.zzm(), zzagt.zza(), zzb.zza());
        } else if (zzahd.class.isAssignableFrom(cls)) {
            if (zzb(zzb)) {
                return zzail.zzl(cls, zzb, zzaio.zzb(), zzahw.zze(), zzaiw.zzn(), zzagt.zzb(), zzaie.zzb());
            }
            return zzail.zzl(cls, zzb, zzaio.zzb(), zzahw.zze(), zzaiw.zzn(), null, zzaie.zzb());
        } else if (zzb(zzb)) {
            return zzail.zzl(cls, zzb, zzaio.zza(), zzahw.zzd(), zzaiw.zzm(), zzagt.zza(), zzaie.zza());
        } else {
            return zzail.zzl(cls, zzb, zzaio.zza(), zzahw.zzd(), zzaiw.zzm(), null, zzaie.zza());
        }
    }
}
