package com.arlosoft.macrodroid.extensions;

import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import com.arlosoft.macrodroid.common.SimpleEncryption;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import org.jetbrains.annotations.NotNull;

/* compiled from: StringExtensions.kt */
@SourceDebugExtension({"SMAP\nStringExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExtensions.kt\ncom/arlosoft/macrodroid/extensions/StringExtensionsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n1855#2,2:76\n*S KotlinDebug\n*F\n+ 1 StringExtensions.kt\ncom/arlosoft/macrodroid/extensions/StringExtensionsKt\n*L\n32#1:76,2\n*E\n"})
/* loaded from: classes3.dex */
public final class StringExtensionsKt {
    @NotNull
    public static final String decrypt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String decrypt = new SimpleEncryption().decrypt(str);
        Intrinsics.checkNotNullExpressionValue(decrypt, "SimpleEncryption().decrypt(this)");
        return decrypt;
    }

    @NotNull
    public static final String encrypt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String encrypt = new SimpleEncryption().encrypt(str);
        Intrinsics.checkNotNullExpressionValue(encrypt, "SimpleEncryption().encrypt(this)");
        return encrypt;
    }

    public static final int getNumberOnEnd(@NotNull String str) {
        Integer intOrNull;
        boolean z3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length() - 1;
        while (length >= 0) {
            char charAt = str.charAt(length);
            if ('0' <= charAt && charAt < ':') {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                break;
            }
            length--;
        }
        String substring = str.substring(length + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        intOrNull = l.toIntOrNull(substring);
        if (intOrNull == null) {
            return 0;
        }
        return intOrNull.intValue();
    }

    @NotNull
    public static final String md5(@NotNull String str) {
        String padStart;
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String bigInteger = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(1, md.digest(…yteArray())).toString(16)");
        padStart = StringsKt__StringsKt.padStart(bigInteger, 32, '0');
        return padStart;
    }

    @NotNull
    public static final String removeNumbersFromEnd(@NotNull String str) {
        boolean z3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length() - 1;
        while (length > 0) {
            char charAt = str.charAt(length);
            if ('0' <= charAt && charAt < ':') {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                length--;
            }
        }
        try {
            String substring = str.substring(0, length);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        } catch (Exception unused) {
            return str;
        }
    }

    @NotNull
    public static final SpannableString setFontSizeForPaths(@NotNull String str, @NotNull List<String> paths, float f4) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(paths, "paths");
        SpannableString spannableString = new SpannableString(str);
        for (String str2 : paths) {
            String spannableString2 = spannableString.toString();
            Intrinsics.checkNotNullExpressionValue(spannableString2, "spannable.toString()");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableString2, str2, 0, false, 6, (Object) null);
            spannableString.setSpan(new RelativeSizeSpan(f4), indexOf$default, str2.length() + indexOf$default, 0);
        }
        return spannableString;
    }

    @NotNull
    public static final SpannableString setMacroDroidSizePaths(@NotNull String str) {
        List listOf;
        Intrinsics.checkNotNullParameter(str, "<this>");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"ACRO", "ROID"});
        return setFontSizeForPaths(str, listOf, 0.8f);
    }

    @NotNull
    public static final String sha256(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%064x", Arrays.copyOf(new Object[]{new BigInteger(1, digest)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public static final String sha256FromString(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%064x", Arrays.copyOf(new Object[]{new BigInteger(1, digest)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
