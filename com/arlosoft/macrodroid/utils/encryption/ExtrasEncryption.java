package com.arlosoft.macrodroid.utils.encryption;

import android.content.Context;
import android.util.Base64;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.settings.Settings;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtrasEncryption.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ExtrasEncryption {
    public static final int $stable = 0;
    @NotNull
    public static final ExtrasEncryption INSTANCE = new ExtrasEncryption();

    private ExtrasEncryption() {
    }

    @JvmStatic
    @Nullable
    public static final String decrypt(@NotNull Context context, @NotNull String encrypted) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(encrypted, "encrypted");
        String extraChunk = Settings.getExtraChunk(context);
        String uniqueId = Settings.getUniqueId(context, false);
        Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
        String substring = uniqueId.substring(0, 16);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String str = extraChunk + substring;
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        String substring2 = encrypted.substring(0, 16);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes2 = substring2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        String substring3 = encrypted.substring(16);
        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(CIPHER_TRANSFORMATION)");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        byte[] decode = Base64.decode(substring3, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(encryptedData, android.util.Base64.DEFAULT)");
        byte[] doFinal = cipher.doFinal(decode);
        Intrinsics.checkNotNullExpressionValue(doFinal, "ecipher.doFinal(raw)");
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
        return new String(doFinal, defaultCharset);
    }

    @JvmStatic
    @Nullable
    public static final byte[] encrypt(@NotNull Context context, @NotNull String stringToEncrypt) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stringToEncrypt, "stringToEncrypt");
        String extraChunk = Settings.getExtraChunk(context);
        String uniqueId = Settings.getUniqueId(context, false);
        Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
        String substring = uniqueId.substring(0, 16);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String str = extraChunk + substring;
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        String extraIV = Settings.getExtraIV(context);
        Intrinsics.checkNotNullExpressionValue(extraIV, "getExtraIV(context)");
        byte[] bytes2 = extraIV.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(CIPHER_TRANSFORMATION)");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        byte[] bytes3 = stringToEncrypt.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
        return cipher.doFinal(bytes3);
    }

    @JvmStatic
    @NotNull
    public static final String encryptToBase64(@NotNull Context context, @NotNull String stringToEncrypt) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stringToEncrypt, "stringToEncrypt");
        byte[] encrypt = encrypt(context, stringToEncrypt);
        String extraIV = Settings.getExtraIV(context);
        String encodeToString = Base64.encodeToString(encrypt, 2);
        return extraIV + encodeToString;
    }
}
