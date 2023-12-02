package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzms  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzms extends zzkm {
    private static final zzll zza = zzll.zzb(new zzlj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmo
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlj
        public final Object zza(zzbn zzbnVar) {
            return new zzod((zzmn) zzbnVar);
        }
    }, zzmn.class, zznd.class);
    private static final zzll zzb = zzll.zzb(new zzlj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmp
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlj
        public final Object zza(zzbn zzbnVar) {
            return zzwd.zzb((zzmn) zzbnVar);
        }
    }, zzmn.class, zzce.class);

    zzms() {
        super(zzox.class, new zzmq(zzce.class));
    }

    public static void zzi(boolean z3) throws GeneralSecurityException {
        zzcr.zzg(new zzms(), true);
        int i4 = zznc.zza;
        zznc.zzc(zzkz.zzc());
        zzkw.zza().zze(zza);
        zzkw.zza().zze(zzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzn(zzpd zzpdVar) throws GeneralSecurityException {
        if (zzpdVar.zza() >= 10) {
            if (zzpdVar.zza() <= 16) {
                return;
            }
            throw new GeneralSecurityException("tag size too long");
        }
        throw new GeneralSecurityException("tag size too short");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzo(int i4) throws GeneralSecurityException {
        if (i4 == 32) {
            return;
        }
        throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzmr(this, zzpa.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzox.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzox zzoxVar = (zzox) zzaiiVar;
        zzwf.zzc(zzoxVar.zza(), 0);
        zzo(zzoxVar.zzf().zzd());
        zzn(zzoxVar.zze());
    }
}
