package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzik  reason: invalid package */
/* loaded from: classes4.dex */
final class zzik extends zzkl {
    final /* synthetic */ zzil zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzik(zzil zzilVar, Class cls) {
        super(cls);
        this.zza = zzilVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzrh zzrhVar = (zzrh) zzaiiVar;
        KeyPair zzc = zzvg.zzc(zzvg.zzi(zziu.zzc(zzrhVar.zzd().zze().zzf())));
        ECPoint w3 = ((ECPublicKey) zzc.getPublic()).getW();
        zzrp zzc2 = zzrq.zzc();
        zzc2.zzb(0);
        zzc2.zza(zzrhVar.zzd());
        byte[] byteArray = w3.getAffineX().toByteArray();
        zzafy zzafyVar = zzafy.zzb;
        zzc2.zzc(zzafy.zzn(byteArray, 0, byteArray.length));
        byte[] byteArray2 = w3.getAffineY().toByteArray();
        zzc2.zzd(zzafy.zzn(byteArray2, 0, byteArray2.length));
        zzrm zzb = zzrn.zzb();
        zzb.zzc(0);
        zzb.zzb((zzrq) zzc2.zzi());
        byte[] byteArray3 = ((ECPrivateKey) zzc.getPrivate()).getS().toByteArray();
        zzb.zza(zzafy.zzn(byteArray3, 0, byteArray3.length));
        return (zzrn) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzrh.zzc(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        byte[] bArr7;
        byte[] bArr8;
        byte[] bArr9;
        HashMap hashMap = new HashMap();
        zzbv zza = zzbw.zza("AES128_GCM");
        bArr = zzil.zza;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzil.zzi(4, 5, 3, zza, bArr, 1));
        zzbv zza2 = zzbw.zza("AES128_GCM");
        bArr2 = zzil.zza;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzil.zzi(4, 5, 3, zza2, bArr2, 3));
        zzbv zza3 = zzbw.zza("AES128_GCM");
        bArr3 = zzil.zza;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzil.zzi(4, 5, 4, zza3, bArr3, 1));
        zzbv zza4 = zzbw.zza("AES128_GCM");
        bArr4 = zzil.zza;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzil.zzi(4, 5, 4, zza4, bArr4, 3));
        zzbv zza5 = zzbw.zza("AES128_GCM");
        bArr5 = zzil.zza;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzil.zzi(4, 5, 4, zza5, bArr5, 3));
        zzbv zza6 = zzbw.zza("AES128_CTR_HMAC_SHA256");
        bArr6 = zzil.zza;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzil.zzi(4, 5, 3, zza6, bArr6, 1));
        zzbv zza7 = zzbw.zza("AES128_CTR_HMAC_SHA256");
        bArr7 = zzil.zza;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzil.zzi(4, 5, 3, zza7, bArr7, 3));
        zzbv zza8 = zzbw.zza("AES128_CTR_HMAC_SHA256");
        bArr8 = zzil.zza;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzil.zzi(4, 5, 4, zza8, bArr8, 1));
        zzbv zza9 = zzbw.zza("AES128_CTR_HMAC_SHA256");
        bArr9 = zzil.zza;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzil.zzi(4, 5, 4, zza9, bArr9, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zziu.zza(((zzrh) zzaiiVar).zzd());
    }
}
