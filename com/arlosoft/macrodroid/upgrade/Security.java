package com.arlosoft.macrodroid.upgrade;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes3.dex */
public class Security {
    public static PublicKey generatePublicKey(String str) throws IOException {
        try {
            return KeyFactory.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException(e4);
        } catch (InvalidKeySpecException e5) {
            throw new IOException("Invalid key specification: " + e5);
        }
    }

    public static boolean verify(PublicKey publicKey, String str, String str2) {
        try {
            byte[] decode = Base64.decode(str2, 0);
            try {
                Signature signature = Signature.getInstance("SHA1withRSA");
                signature.initVerify(publicKey);
                signature.update(str.getBytes());
                if (!signature.verify(decode)) {
                    return false;
                }
                return true;
            } catch (InvalidKeyException | SignatureException unused) {
                return false;
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(e4);
            }
        } catch (IllegalArgumentException unused2) {
            return false;
        }
    }

    public static boolean verifyPurchase(String str, String str2, String str3) throws IOException {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            return verify(generatePublicKey(str), str2, str3);
        }
        return false;
    }
}
