package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdu  reason: invalid package */
/* loaded from: classes4.dex */
final class zzdu extends zzkl {
    final /* synthetic */ zzdv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdu(zzdv zzdvVar, Class cls) {
        super(cls);
        this.zza = zzdvVar;
    }

    public static final zzpm zzf(zzpp zzppVar) throws GeneralSecurityException {
        zzpl zzb = zzpm.zzb();
        zzb.zzb(zzppVar.zzf());
        byte[] zzb2 = zzlx.zzb(zzppVar.zza());
        zzb.zza(zzafy.zzn(zzb2, 0, zzb2.length));
        zzb.zzc(0);
        return (zzpm) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        return zzf((zzpp) zzaiiVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzpp.zze(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    /* renamed from: zze */
    public final void zzd(zzpp zzppVar) throws GeneralSecurityException {
        zzwf.zzb(zzppVar.zza());
        zzdv zzdvVar = this.zza;
        zzdv.zzi(zzppVar.zzf());
    }
}
