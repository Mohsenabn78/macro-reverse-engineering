package com.arlosoft.macrodroid.utils.encryption;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.api.client.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: Encryptor.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class Encryptor {
    public static final int $stable = 0;
    @NotNull
    public static final Encryptor INSTANCE = new Encryptor();

    private Encryptor() {
    }

    @JvmStatic
    private static final SecretKey a(String str) {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        byte[] bytes = "37o3gcd77a77URp".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKey generateSecret = secretKeyFactory.generateSecret(new PBEKeySpec(charArray, bytes, 1000, 128));
        Intrinsics.checkNotNullExpressionValue(generateSecret, "secretKeyFactory.generateSecret(keySpec)");
        return generateSecret;
    }

    @JvmStatic
    @NotNull
    public static final byte[] decrypt(@NotNull byte[] bytesToDecrypt, @NotNull String password) {
        Intrinsics.checkNotNullParameter(bytesToDecrypt, "bytesToDecrypt");
        Intrinsics.checkNotNullParameter(password, "password");
        SecretKey a4 = a(password);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, a4);
        byte[] doFinal = cipher.doFinal(bytesToDecrypt);
        Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(bytesToDecrypt)");
        return doFinal;
    }

    @JvmStatic
    @NotNull
    public static final String decryptFromBase64(@NotNull String stringToDecrypt, @NotNull String password) {
        Intrinsics.checkNotNullParameter(stringToDecrypt, "stringToDecrypt");
        Intrinsics.checkNotNullParameter(password, "password");
        String str = password + "SJginwej49ngmrEERtt9jeE4564tgeW£";
        byte[] decodeBase64 = Base64.decodeBase64(stringToDecrypt);
        Intrinsics.checkNotNullExpressionValue(decodeBase64, "decodeBase64(stringToDecrypt)");
        return new String(decrypt(decodeBase64, str), Charsets.UTF_8);
    }

    @JvmStatic
    @NotNull
    public static final byte[] encrypt(@NotNull byte[] bytesToEncrypt, @NotNull String password) {
        Intrinsics.checkNotNullParameter(bytesToEncrypt, "bytesToEncrypt");
        Intrinsics.checkNotNullParameter(password, "password");
        SecretKey a4 = a(password);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, a4);
        byte[] doFinal = cipher.doFinal(bytesToEncrypt);
        Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(bytesToEncrypt)");
        return doFinal;
    }

    @JvmStatic
    @NotNull
    public static final String encryptToBase64(@NotNull String stringToEncrypt, @NotNull String password) {
        Intrinsics.checkNotNullParameter(stringToEncrypt, "stringToEncrypt");
        Intrinsics.checkNotNullParameter(password, "password");
        byte[] bytes = stringToEncrypt.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeBase64String = Base64.encodeBase64String(encrypt(bytes, password + "SJginwej49ngmrEERtt9jeE4564tgeW£"));
        Intrinsics.checkNotNullExpressionValue(encodeBase64String, "encodeBase64String(encry…yteArray(), newPassword))");
        return encodeBase64String;
    }

    @NotNull
    public final byte[] decryptConfigFile(@NotNull byte[] bytesToDecrypt) {
        Intrinsics.checkNotNullParameter(bytesToDecrypt, "bytesToDecrypt");
        return decrypt(bytesToDecrypt, "SJginwej49ngmrEERtt9jeE4564tgeW£");
    }
}
