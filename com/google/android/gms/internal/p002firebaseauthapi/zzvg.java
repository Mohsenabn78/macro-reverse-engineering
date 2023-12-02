package com.google.android.gms.internal.p002firebaseauthapi;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvg  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzvg {
    public static int zza(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (zzjz.zza(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    public static BigInteger zzb(BigInteger bigInteger, boolean z3, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger zza = zzjz.zza(ellipticCurve);
        BigInteger mod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(zza);
        if (zza.signum() == 1) {
            BigInteger mod2 = mod.mod(zza);
            BigInteger bigInteger2 = BigInteger.ZERO;
            if (!mod2.equals(bigInteger2)) {
                if (zza.testBit(0) && zza.testBit(1)) {
                    bigInteger2 = mod2.modPow(zza.add(BigInteger.ONE).shiftRight(2), zza);
                } else if (zza.testBit(0) && !zza.testBit(1)) {
                    bigInteger2 = BigInteger.ONE;
                    BigInteger shiftRight = zza.subtract(bigInteger2).shiftRight(1);
                    int i4 = 0;
                    while (true) {
                        BigInteger mod3 = bigInteger2.multiply(bigInteger2).subtract(mod2).mod(zza);
                        if (mod3.equals(BigInteger.ZERO)) {
                            break;
                        }
                        BigInteger modPow = mod3.modPow(shiftRight, zza);
                        BigInteger bigInteger3 = BigInteger.ONE;
                        if (modPow.add(bigInteger3).equals(zza)) {
                            BigInteger shiftRight2 = zza.add(bigInteger3).shiftRight(1);
                            BigInteger bigInteger4 = bigInteger2;
                            for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                                BigInteger multiply = bigInteger4.multiply(bigInteger3);
                                bigInteger4 = bigInteger4.multiply(bigInteger4).add(bigInteger3.multiply(bigInteger3).mod(zza).multiply(mod3)).mod(zza);
                                BigInteger mod4 = multiply.add(multiply).mod(zza);
                                if (shiftRight2.testBit(bitLength)) {
                                    BigInteger mod5 = bigInteger4.multiply(bigInteger2).add(mod4.multiply(mod3)).mod(zza);
                                    bigInteger3 = bigInteger2.multiply(mod4).add(bigInteger4).mod(zza);
                                    bigInteger4 = mod5;
                                } else {
                                    bigInteger3 = mod4;
                                }
                            }
                            bigInteger2 = bigInteger4;
                        } else if (modPow.equals(bigInteger3)) {
                            bigInteger2 = bigInteger2.add(bigInteger3);
                            i4++;
                            if (i4 == 128 && !zza.isProbablePrime(80)) {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                        } else {
                            throw new InvalidAlgorithmParameterException("p is not prime");
                        }
                    }
                } else {
                    bigInteger2 = null;
                }
                if (bigInteger2 != null && bigInteger2.multiply(bigInteger2).mod(zza).compareTo(mod2) != 0) {
                    throw new GeneralSecurityException("Could not find a modular square root");
                }
            }
            if (z3 != bigInteger2.testBit(0)) {
                return zza.subtract(bigInteger2).mod(zza);
            }
            return bigInteger2;
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static KeyPair zzc(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzvp.zzf.zza(KeyPropertiesCompact.KEY_ALGORITHM_EC);
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    public static void zzd(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        zze(eCPublicKey, eCPrivateKey);
        zzjz.zzb(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    static void zze(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        try {
            ECParameterSpec params = eCPublicKey.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            ECParameterSpec eCParameterSpec = zzjz.zza;
            if (params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor()) {
                return;
            }
            throw new GeneralSecurityException("invalid public key spec");
        } catch (IllegalArgumentException | NullPointerException e4) {
            throw new GeneralSecurityException(e4);
        }
    }

    public static byte[] zzf(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        zze(eCPublicKey, eCPrivateKey);
        ECPoint w3 = eCPublicKey.getW();
        zzjz.zzb(w3, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = ((KeyFactory) zzvp.zzg.zza(KeyPropertiesCompact.KEY_ALGORITHM_EC)).generatePublic(new ECPublicKeySpec(w3, eCPrivateKey.getParams()));
        KeyAgreement keyAgreement = (KeyAgreement) zzvp.zze.zza("ECDH");
        keyAgreement.init(eCPrivateKey);
        try {
            keyAgreement.doPhase(generatePublic, true);
            byte[] generateSecret = keyAgreement.generateSecret();
            EllipticCurve curve = eCPrivateKey.getParams().getCurve();
            BigInteger bigInteger = new BigInteger(1, generateSecret);
            if (bigInteger.signum() != -1 && bigInteger.compareTo(zzjz.zza(curve)) < 0) {
                zzb(bigInteger, true, curve);
                return generateSecret;
            }
            throw new GeneralSecurityException("shared secret is out of range");
        } catch (IllegalStateException e4) {
            throw new GeneralSecurityException(e4);
        }
    }

    public static ECPrivateKey zzg(int i4, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) ((KeyFactory) zzvp.zzg.zza(KeyPropertiesCompact.KEY_ALGORITHM_EC)).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArr), zzi(i4)));
    }

    public static ECPublicKey zzh(ECParameterSpec eCParameterSpec, int i4, byte[] bArr) throws GeneralSecurityException {
        ECPoint eCPoint;
        EllipticCurve curve = eCParameterSpec.getCurve();
        int zza = zza(curve);
        int i5 = i4 - 1;
        boolean z3 = false;
        if (i5 != 0) {
            if (i5 != 1) {
                int length = bArr.length;
                if (length == zza + zza) {
                    eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, zza)), new BigInteger(1, Arrays.copyOfRange(bArr, zza, length)));
                    zzjz.zzb(eCPoint, curve);
                } else {
                    throw new GeneralSecurityException("invalid point size");
                }
            } else {
                BigInteger zza2 = zzjz.zza(curve);
                int length2 = bArr.length;
                if (length2 == zza + 1) {
                    byte b4 = bArr[0];
                    if (b4 != 2) {
                        if (b4 == 3) {
                            z3 = true;
                        } else {
                            throw new GeneralSecurityException("invalid format");
                        }
                    }
                    BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, length2));
                    if (bigInteger.signum() != -1 && bigInteger.compareTo(zza2) < 0) {
                        eCPoint = new ECPoint(bigInteger, zzb(bigInteger, z3, curve));
                    } else {
                        throw new GeneralSecurityException("x is out of range");
                    }
                } else {
                    throw new GeneralSecurityException("compressed point has wrong length");
                }
            }
        } else {
            int length3 = bArr.length;
            if (length3 == zza + zza + 1) {
                if (bArr[0] == 4) {
                    int i6 = zza + 1;
                    eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i6)), new BigInteger(1, Arrays.copyOfRange(bArr, i6, length3)));
                    zzjz.zzb(eCPoint, curve);
                } else {
                    throw new GeneralSecurityException("invalid point format");
                }
            } else {
                throw new GeneralSecurityException("invalid point size");
            }
        }
        return (ECPublicKey) ((KeyFactory) zzvp.zzg.zza(KeyPropertiesCompact.KEY_ALGORITHM_EC)).generatePublic(new ECPublicKeySpec(eCPoint, eCParameterSpec));
    }

    public static ECParameterSpec zzi(int i4) throws NoSuchAlgorithmException {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 1) {
                return zzjz.zzc;
            }
            return zzjz.zzb;
        }
        return zzjz.zza;
    }
}
