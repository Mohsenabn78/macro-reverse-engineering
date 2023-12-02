package com.github.javiersantos.licensing;

import com.github.javiersantos.licensing.util.Base64;
import com.github.javiersantos.licensing.util.Base64DecoderException;
import com.google.common.base.Ascii;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.objenesis.instantiator.util.ClassDefinitionUtils;

/* loaded from: classes3.dex */
public class AESObfuscator implements Obfuscator {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f18354c = {Ascii.DLE, 74, 71, ClassDefinitionUtils.OPS_areturn, 32, 101, -47, 72, 117, -14, 0, -29, 70, 65, -12, 74};

    /* renamed from: a  reason: collision with root package name */
    private Cipher f18355a;

    /* renamed from: b  reason: collision with root package name */
    private Cipher f18356b;

    public AESObfuscator(byte[] bArr, String str, String str2) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyFactory.generateSecret(new PBEKeySpec((str + str2).toCharArray(), bArr, 1024, 256)).getEncoded(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f18355a = cipher;
            byte[] bArr2 = f18354c;
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f18356b = cipher2;
            cipher2.init(2, secretKeySpec, new IvParameterSpec(bArr2));
        } catch (GeneralSecurityException e4) {
            throw new RuntimeException("Invalid environment", e4);
        }
    }

    @Override // com.github.javiersantos.licensing.Obfuscator
    public String obfuscate(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            Cipher cipher = this.f18355a;
            return Base64.encode(cipher.doFinal(("com.github.javiersantos.licensing.AESObfuscator-1|" + str2 + str).getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | GeneralSecurityException e4) {
            throw new RuntimeException("Invalid environment", e4);
        }
    }

    @Override // com.github.javiersantos.licensing.Obfuscator
    public String unobfuscate(String str, String str2) throws ValidationException {
        if (str == null) {
            return null;
        }
        try {
            String str3 = new String(this.f18356b.doFinal(Base64.decode(str)), "UTF-8");
            if (str3.indexOf("com.github.javiersantos.licensing.AESObfuscator-1|" + str2) == 0) {
                return str3.substring(50 + str2.length(), str3.length());
            }
            throw new ValidationException("Header not found (invalid data or key):" + str);
        } catch (Base64DecoderException e4) {
            e = e4;
            throw new ValidationException(e.getMessage() + ":" + str);
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException("Invalid environment", e5);
        } catch (BadPaddingException e6) {
            e = e6;
            throw new ValidationException(e.getMessage() + ":" + str);
        } catch (IllegalBlockSizeException e7) {
            e = e7;
            throw new ValidationException(e.getMessage() + ":" + str);
        }
    }
}
