package com.google.android.gms.internal.p002firebaseauthapi;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzim  reason: invalid package */
/* loaded from: classes4.dex */
final class zzim extends zzlm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzim(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm
    public final /* bridge */ /* synthetic */ Object zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzrq zzrqVar = (zzrq) zzaiiVar;
        zzrk zzb = zzrqVar.zzb();
        zzrt zze = zzb.zze();
        int zzc = zziu.zzc(zze.zzf());
        byte[] zzq = zzrqVar.zzg().zzq();
        byte[] zzq2 = zzrqVar.zzh().zzq();
        ECParameterSpec zzi = zzvg.zzi(zzc);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, zzq), new BigInteger(1, zzq2));
        zzjz.zzb(eCPoint, zzi.getCurve());
        return new zzvd((ECPublicKey) ((KeyFactory) zzvp.zzg.zza(KeyPropertiesCompact.KEY_ALGORITHM_EC)).generatePublic(new ECPublicKeySpec(eCPoint, zzi)), zze.zzd().zzq(), zziu.zzb(zze.zzg()), zziu.zzd(zzb.zzh()), new zziv(zzb.zza().zzd()));
    }
}
