package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;

/* loaded from: classes5.dex */
public class StringUtils {
    private static IllegalStateException a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static byte[] getBytesIso8859_1(String str) {
        return getBytesUnchecked(str, "ISO-8859-1");
    }

    public static byte[] getBytesUnchecked(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e4) {
            throw a(str2, e4);
        }
    }

    public static byte[] getBytesUsAscii(String str) {
        return getBytesUnchecked(str, "US-ASCII");
    }

    public static byte[] getBytesUtf16(String str) {
        return getBytesUnchecked(str, HTTP.UTF_16);
    }

    public static byte[] getBytesUtf16Be(String str) {
        return getBytesUnchecked(str, "UTF-16BE");
    }

    public static byte[] getBytesUtf16Le(String str) {
        return getBytesUnchecked(str, "UTF-16LE");
    }

    public static byte[] getBytesUtf8(String str) {
        return getBytesUnchecked(str, "UTF-8");
    }

    public static String newString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e4) {
            throw a(str, e4);
        }
    }

    public static String newStringIso8859_1(byte[] bArr) {
        return newString(bArr, "ISO-8859-1");
    }

    public static String newStringUsAscii(byte[] bArr) {
        return newString(bArr, "US-ASCII");
    }

    public static String newStringUtf16(byte[] bArr) {
        return newString(bArr, HTTP.UTF_16);
    }

    public static String newStringUtf16Be(byte[] bArr) {
        return newString(bArr, "UTF-16BE");
    }

    public static String newStringUtf16Le(byte[] bArr) {
        return newString(bArr, "UTF-16LE");
    }

    public static String newStringUtf8(byte[] bArr) {
        return newString(bArr, "UTF-8");
    }
}
