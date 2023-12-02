package com.arlosoft.macrodroid.upgrade.billing;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.arlosoft.macrodroid.BuildConfig;
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

/* compiled from: Security.java */
/* loaded from: classes3.dex */
class b {
    private static PublicKey a(String str) throws IOException {
        try {
            return KeyFactory.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException(e4);
        } catch (InvalidKeySpecException e5) {
            String str2 = "Invalid key specification: " + e5;
            Log.w("IABUtil/Security", str2);
            throw new IOException(str2);
        }
    }

    private static Boolean b(PublicKey publicKey, String str, String str2) {
        try {
            byte[] decode = Base64.decode(str2, 0);
            try {
                Signature signature = Signature.getInstance("SHA1withRSA");
                signature.initVerify(publicKey);
                signature.update(str.getBytes());
                if (!signature.verify(decode)) {
                    Log.w("IABUtil/Security", "Signature verification failed...");
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            } catch (InvalidKeyException unused) {
                Log.e("IABUtil/Security", "Invalid key specification.");
                return Boolean.FALSE;
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(e4);
            } catch (SignatureException unused2) {
                Log.e("IABUtil/Security", "Signature exception.");
                return Boolean.FALSE;
            }
        } catch (IllegalArgumentException unused3) {
            Log.w("IABUtil/Security", "Base64 decoding failed.");
            return Boolean.FALSE;
        }
    }

    public static boolean c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(BuildConfig.BASE64_ENCODED_PUBLIC_KEY) && !TextUtils.isEmpty(str2)) {
            try {
                return b(a(BuildConfig.BASE64_ENCODED_PUBLIC_KEY), str, str2).booleanValue();
            } catch (IOException e4) {
                Log.e("IABUtil/Security", "Error generating PublicKey from encoded key: " + e4.getMessage());
                return false;
            }
        }
        Log.w("IABUtil/Security", "Purchase verification failed: missing data.");
        return false;
    }
}
