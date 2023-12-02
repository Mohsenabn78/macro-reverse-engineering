package com.sun.mail.auth;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.MailLogger;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class Ntlm {

    /* renamed from: l  reason: collision with root package name */
    private static final byte[] f37579l = {0, 0, 0, 0, 0, 0};

    /* renamed from: m  reason: collision with root package name */
    private static final byte[] f37580m = {0, 0, 0, 0};

    /* renamed from: n  reason: collision with root package name */
    private static char[] f37581n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    private byte[] f37582a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f37583b;

    /* renamed from: c  reason: collision with root package name */
    private SecretKeyFactory f37584c;

    /* renamed from: d  reason: collision with root package name */
    private Cipher f37585d;

    /* renamed from: e  reason: collision with root package name */
    private MD4 f37586e;

    /* renamed from: f  reason: collision with root package name */
    private String f37587f;

    /* renamed from: g  reason: collision with root package name */
    private String f37588g;

    /* renamed from: h  reason: collision with root package name */
    private String f37589h;

    /* renamed from: i  reason: collision with root package name */
    private String f37590i;

    /* renamed from: j  reason: collision with root package name */
    private Mac f37591j;

    /* renamed from: k  reason: collision with root package name */
    private MailLogger f37592k;

    public Ntlm(String str, String str2, String str3, String str4, MailLogger mailLogger) {
        int indexOf = str2.indexOf(46);
        str2 = indexOf != -1 ? str2.substring(0, indexOf) : str2;
        int indexOf2 = str3.indexOf(92);
        if (indexOf2 != -1) {
            str = str3.substring(0, indexOf2).toUpperCase(Locale.ENGLISH);
            str3 = str3.substring(indexOf2 + 1);
        } else if (str == null) {
            str = "";
        }
        this.f37588g = str;
        this.f37587f = str2;
        this.f37589h = str3;
        this.f37590i = str4;
        this.f37592k = mailLogger.getLogger(getClass(), "DEBUG NTLM");
        g();
    }

    private byte[] a() throws GeneralSecurityException {
        byte[] bArr;
        byte[] bArr2 = {75, 71, 83, 33, SignedBytes.MAX_POWER_OF_TWO, 35, 36, 37};
        try {
            bArr = this.f37590i.toUpperCase(Locale.ENGLISH).getBytes("iso-8859-1");
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        int i4 = 14;
        byte[] bArr3 = new byte[14];
        int length = this.f37590i.length();
        if (length <= 14) {
            i4 = length;
        }
        System.arraycopy(bArr, 0, bArr3, 0, i4);
        DESKeySpec dESKeySpec = new DESKeySpec(h(bArr3, 0));
        DESKeySpec dESKeySpec2 = new DESKeySpec(h(bArr3, 7));
        SecretKey generateSecret = this.f37584c.generateSecret(dESKeySpec);
        SecretKey generateSecret2 = this.f37584c.generateSecret(dESKeySpec2);
        this.f37585d.init(1, generateSecret);
        byte[] doFinal = this.f37585d.doFinal(bArr2, 0, 8);
        this.f37585d.init(1, generateSecret2);
        byte[] doFinal2 = this.f37585d.doFinal(bArr2, 0, 8);
        byte[] bArr4 = new byte[21];
        System.arraycopy(doFinal, 0, bArr4, 0, 8);
        System.arraycopy(doFinal2, 0, bArr4, 8, 8);
        return bArr4;
    }

    private byte[] b() throws GeneralSecurityException {
        byte[] bArr;
        try {
            bArr = this.f37590i.getBytes("UnicodeLittleUnmarked");
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        byte[] bArr2 = new byte[21];
        System.arraycopy(this.f37586e.digest(bArr), 0, bArr2, 0, 16);
        return bArr2;
    }

    private byte[] c(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        DESKeySpec dESKeySpec = new DESKeySpec(h(bArr, 0));
        DESKeySpec dESKeySpec2 = new DESKeySpec(h(bArr, 7));
        DESKeySpec dESKeySpec3 = new DESKeySpec(h(bArr, 14));
        SecretKey generateSecret = this.f37584c.generateSecret(dESKeySpec);
        SecretKey generateSecret2 = this.f37584c.generateSecret(dESKeySpec2);
        SecretKey generateSecret3 = this.f37584c.generateSecret(dESKeySpec3);
        this.f37585d.init(1, generateSecret);
        byte[] doFinal = this.f37585d.doFinal(bArr2, 0, 8);
        this.f37585d.init(1, generateSecret2);
        byte[] doFinal2 = this.f37585d.doFinal(bArr2, 0, 8);
        this.f37585d.init(1, generateSecret3);
        byte[] doFinal3 = this.f37585d.doFinal(bArr2, 0, 8);
        byte[] bArr3 = new byte[24];
        System.arraycopy(doFinal, 0, bArr3, 0, 8);
        System.arraycopy(doFinal2, 0, bArr3, 8, 8);
        System.arraycopy(doFinal3, 0, bArr3, 16, 8);
        return bArr3;
    }

    private byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArr4;
        try {
            bArr4 = (this.f37589h.toUpperCase(Locale.ENGLISH) + this.f37588g).getBytes("UnicodeLittleUnmarked");
        } catch (UnsupportedEncodingException unused) {
            bArr4 = null;
        }
        byte[] f4 = f(bArr, bArr4);
        byte[] bArr5 = new byte[bArr2.length + 8];
        System.arraycopy(bArr3, 0, bArr5, 0, 8);
        System.arraycopy(bArr2, 0, bArr5, 8, bArr2.length);
        byte[] bArr6 = new byte[bArr2.length + 16];
        System.arraycopy(f(f4, bArr5), 0, bArr6, 0, 16);
        System.arraycopy(bArr2, 0, bArr6, 16, bArr2.length);
        return bArr6;
    }

    private void e(byte[] bArr, int i4, String str, String str2) {
        try {
            byte[] bytes = str.getBytes(str2);
            System.arraycopy(bytes, 0, bArr, i4, bytes.length);
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private byte[] f(byte[] bArr, byte[] bArr2) {
        try {
            if (this.f37591j == null) {
                this.f37591j = Mac.getInstance("HmacMD5");
            }
            int i4 = 16;
            try {
                byte[] bArr3 = new byte[16];
                if (bArr.length <= 16) {
                    i4 = bArr.length;
                }
                System.arraycopy(bArr, 0, bArr3, 0, i4);
                this.f37591j.init(new SecretKeySpec(bArr3, "HmacMD5"));
                return this.f37591j.doFinal(bArr2);
            } catch (RuntimeException | InvalidKeyException unused) {
                return null;
            }
        } catch (NoSuchAlgorithmException unused2) {
            throw new AssertionError();
        }
    }

    private void g() {
        byte[] bArr = new byte[256];
        this.f37582a = bArr;
        this.f37583b = new byte[512];
        System.arraycopy(new byte[]{78, 84, 76, 77, 83, 83, 80, 0, 1}, 0, bArr, 0, 9);
        System.arraycopy(new byte[]{78, 84, 76, 77, 83, 83, 80, 0, 3}, 0, this.f37583b, 0, 9);
        try {
            this.f37584c = SecretKeyFactory.getInstance("DES");
            this.f37585d = Cipher.getInstance("DES/ECB/NoPadding");
            this.f37586e = new MD4();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
        }
    }

    private byte[] h(byte[] bArr, int i4) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = bArr[i5];
            if (i6 < 0) {
                i6 += 256;
            }
            iArr[i5] = i6;
        }
        int i7 = iArr[i4 + 0];
        int i8 = iArr[i4 + 1];
        int i9 = iArr[i4 + 2];
        int i10 = iArr[i4 + 3];
        int i11 = iArr[i4 + 4];
        int i12 = iArr[i4 + 5];
        int i13 = iArr[i4 + 6];
        return new byte[]{(byte) i7, (byte) (((i7 << 7) & 255) | (i8 >> 1)), (byte) (((i8 << 6) & 255) | (i9 >> 2)), (byte) (((i9 << 5) & 255) | (i10 >> 3)), (byte) (((i10 << 4) & 255) | (i11 >> 4)), (byte) (((i11 << 3) & 255) | (i12 >> 5)), (byte) ((i13 >> 6) | ((i12 << 2) & 255)), (byte) ((i13 << 1) & 255)};
    }

    private static int i(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    private static int j(byte[] bArr, int i4) {
        return ((bArr[i4 + 1] & 255) << 8) | (bArr[i4] & 255);
    }

    private static String k(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 3);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            sb.append(f37581n[(bArr[i4] >> 4) & 15]);
            sb.append(f37581n[bArr[i4] & Ascii.SI]);
            sb.append(' ');
        }
        return sb.toString();
    }

    private void l(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) (i5 & 255);
        bArr[i4 + 1] = (byte) ((i5 >> 8) & 255);
        bArr[i4 + 2] = (byte) ((i5 >> 16) & 255);
        bArr[i4 + 3] = (byte) ((i5 >> 24) & 255);
    }

    private void m(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) (i5 & 255);
        bArr[i4 + 1] = (byte) ((i5 >> 8) & 255);
    }

    public String generateType1Msg(int i4) {
        return generateType1Msg(i4, false);
    }

    public String generateType3Msg(String str) {
        byte[] bArr;
        byte[] c4;
        byte[] c5;
        int i4;
        try {
            try {
                bArr = BASE64DecoderStream.decode(str.getBytes("us-ascii"));
            } catch (GeneralSecurityException e4) {
                this.f37592k.log(Level.FINE, "GeneralSecurityException", (Throwable) e4);
                return "";
            }
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        if (this.f37592k.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.f37592k;
            mailLogger.fine("type 2 message: " + k(bArr));
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 24, bArr2, 0, 8);
        int length = this.f37589h.length() * 2;
        m(this.f37583b, 36, length);
        m(this.f37583b, 38, length);
        int length2 = this.f37588g.length() * 2;
        m(this.f37583b, 28, length2);
        m(this.f37583b, 30, length2);
        int length3 = this.f37587f.length() * 2;
        m(this.f37583b, 44, length3);
        m(this.f37583b, 46, length3);
        e(this.f37583b, 64, this.f37588g, "UnicodeLittleUnmarked");
        l(this.f37583b, 32, 64);
        int i5 = length2 + 64;
        e(this.f37583b, i5, this.f37589h, "UnicodeLittleUnmarked");
        l(this.f37583b, 40, i5);
        int i6 = i5 + length;
        e(this.f37583b, i6, this.f37587f, "UnicodeLittleUnmarked");
        l(this.f37583b, 48, i6);
        int i7 = i6 + length3;
        int i8 = i(bArr, 20);
        if ((524288 & i8) != 0) {
            this.f37592k.fine("Using NTLMv2");
            byte[] bArr3 = new byte[8];
            new Random().nextBytes(bArr3);
            byte[] b4 = b();
            c4 = d(b4, bArr3, bArr2);
            byte[] bArr4 = new byte[0];
            if ((i8 & 8388608) != 0) {
                int j4 = j(bArr, 40);
                byte[] bArr5 = new byte[j4];
                System.arraycopy(bArr, i(bArr, 44), bArr5, 0, j4);
                bArr4 = bArr5;
            }
            byte[] bArr6 = new byte[bArr4.length + 32];
            bArr6[0] = 1;
            bArr6[1] = 1;
            System.arraycopy(f37579l, 0, bArr6, 2, 6);
            long currentTimeMillis = (System.currentTimeMillis() + 11644473600000L) * 10000;
            for (int i9 = 0; i9 < 8; i9++) {
                bArr6[i9 + 8] = (byte) (currentTimeMillis & 255);
                currentTimeMillis >>= 8;
            }
            System.arraycopy(bArr3, 0, bArr6, 16, 8);
            byte[] bArr7 = f37580m;
            System.arraycopy(bArr7, 0, bArr6, 24, 4);
            System.arraycopy(bArr4, 0, bArr6, 28, bArr4.length);
            System.arraycopy(bArr7, 0, bArr6, bArr4.length + 28, 4);
            c5 = d(b4, bArr6, bArr2);
            i4 = 557569;
        } else {
            c4 = c(a(), bArr2);
            c5 = c(b(), bArr2);
            i4 = 33281;
        }
        byte[] bArr8 = c4;
        System.arraycopy(bArr8, 0, this.f37583b, i7, bArr8.length);
        m(this.f37583b, 12, bArr8.length);
        m(this.f37583b, 14, bArr8.length);
        l(this.f37583b, 16, i7);
        int i10 = i7 + 24;
        System.arraycopy(c5, 0, this.f37583b, i10, c5.length);
        m(this.f37583b, 20, c5.length);
        m(this.f37583b, 22, c5.length);
        l(this.f37583b, 24, i10);
        int length4 = i10 + c5.length;
        m(this.f37583b, 56, length4);
        byte[] bArr9 = new byte[length4];
        System.arraycopy(this.f37583b, 0, bArr9, 0, length4);
        l(this.f37583b, 60, i4);
        if (this.f37592k.isLoggable(Level.FINE)) {
            MailLogger mailLogger2 = this.f37592k;
            mailLogger2.fine("type 3 message: " + k(bArr9));
        }
        try {
            return new String(BASE64EncoderStream.encode(bArr9), "iso-8859-1");
        } catch (UnsupportedEncodingException unused2) {
            return null;
        }
    }

    public String generateType1Msg(int i4, boolean z3) {
        int length = this.f37588g.length();
        int i5 = i4 | 41475;
        if (length != 0) {
            i5 |= 4096;
        }
        if (z3) {
            i5 |= 524288;
        }
        l(this.f37582a, 12, i5);
        byte[] bArr = this.f37582a;
        bArr[28] = 32;
        m(bArr, 16, length);
        m(this.f37582a, 18, length);
        int length2 = this.f37587f.length();
        m(this.f37582a, 24, length2);
        m(this.f37582a, 26, length2);
        e(this.f37582a, 32, this.f37587f, "iso-8859-1");
        int i6 = length2 + 32;
        e(this.f37582a, i6, this.f37588g, "iso-8859-1");
        l(this.f37582a, 20, i6);
        int i7 = i6 + length;
        byte[] bArr2 = new byte[i7];
        System.arraycopy(this.f37582a, 0, bArr2, 0, i7);
        if (this.f37592k.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.f37592k;
            mailLogger.fine("type 1 message: " + k(bArr2));
        }
        try {
            return new String(BASE64EncoderStream.encode(bArr2), "iso-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
