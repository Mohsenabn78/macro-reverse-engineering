package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjh  reason: invalid package */
/* loaded from: classes4.dex */
final class zzjh extends zzkl {
    final /* synthetic */ zzji zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjh(zzji zzjiVar, Class cls) {
        super(cls);
        this.zza = zzjiVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        byte[] zzb;
        byte[] zzb2;
        zzso zzsoVar = (zzso) zzaiiVar;
        int zzf = zzsoVar.zzd().zzf() - 2;
        if (zzf != 1) {
            if (zzf != 2 && zzf != 3 && zzf != 4) {
                throw new GeneralSecurityException("Invalid KEM");
            }
            int zzg = zzjl.zzg(zzsoVar.zzd().zzf());
            KeyPair zzc = zzvg.zzc(zzvg.zzi(zzg));
            ECPoint w3 = ((ECPublicKey) zzc.getPublic()).getW();
            EllipticCurve curve = zzvg.zzi(zzg).getCurve();
            zzjz.zzb(w3, curve);
            int zza = zzvg.zza(curve);
            int i4 = zza + zza + 1;
            zzb2 = new byte[i4];
            byte[] zza2 = zzjx.zza(w3.getAffineX());
            byte[] zza3 = zzjx.zza(w3.getAffineY());
            int length = zza3.length;
            System.arraycopy(zza3, 0, zzb2, i4 - length, length);
            int length2 = zza2.length;
            System.arraycopy(zza2, 0, zzb2, (zza + 1) - length2, length2);
            zzb2[0] = 4;
            zzb = ((ECPrivateKey) zzc.getPrivate()).getS().toByteArray();
        } else {
            zzb = zzlx.zzb(32);
            zzb[0] = (byte) (zzb[0] | 7);
            int i5 = zzb[31] & Utf8.REPLACEMENT_BYTE;
            zzb[31] = (byte) i5;
            zzb[31] = (byte) (i5 | 128);
            zzb2 = zzwg.zzb(zzb);
        }
        zzsw zzc2 = zzsx.zzc();
        zzc2.zzc(0);
        zzc2.zza(zzsoVar.zzd());
        zzc2.zzb(zzafy.zzn(zzb2, 0, zzb2.length));
        zzst zzb3 = zzsu.zzb();
        zzb3.zzc(0);
        zzb3.zzb((zzsx) zzc2.zzi());
        zzb3.zza(zzafy.zzn(zzb, 0, zzb.length));
        return (zzsu) zzb3.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzso.zzc(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() {
        HashMap hashMap = new HashMap();
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzji.zzh(3, 3, 3, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzji.zzh(3, 3, 3, 3));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzji.zzh(3, 3, 4, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzji.zzh(3, 3, 4, 3));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzji.zzh(3, 3, 5, 1));
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzji.zzh(3, 3, 5, 3));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzji.zzh(4, 3, 3, 1));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzji.zzh(4, 3, 3, 3));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzji.zzh(4, 3, 4, 1));
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzji.zzh(4, 3, 4, 3));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzji.zzh(5, 4, 3, 1));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzji.zzh(5, 4, 3, 3));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzji.zzh(5, 4, 4, 1));
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzji.zzh(5, 4, 4, 3));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzji.zzh(6, 5, 3, 1));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzji.zzh(6, 5, 3, 3));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzji.zzh(6, 5, 4, 1));
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzji.zzh(6, 5, 4, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzjl.zza(((zzso) zzaiiVar).zzd());
    }
}
