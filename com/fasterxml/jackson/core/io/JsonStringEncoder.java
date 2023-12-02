package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;
import okio.Utf8;

/* loaded from: classes3.dex */
public final class JsonStringEncoder {

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f17734d = CharTypes.copyHexChars();

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f17735e = CharTypes.copyHexBytes();

    /* renamed from: f  reason: collision with root package name */
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> f17736f = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    protected TextBuffer f17737a;

    /* renamed from: b  reason: collision with root package name */
    protected ByteArrayBuilder f17738b;

    /* renamed from: c  reason: collision with root package name */
    protected final char[] f17739c;

    public JsonStringEncoder() {
        this.f17739c = r0;
        char[] cArr = {'\\', 0, '0', '0'};
    }

    private int a(int i4, int i5, ByteArrayBuilder byteArrayBuilder, int i6) {
        byteArrayBuilder.setCurrentSegmentLength(i6);
        byteArrayBuilder.append(92);
        if (i5 < 0) {
            byteArrayBuilder.append(117);
            if (i4 > 255) {
                int i7 = i4 >> 8;
                byte[] bArr = f17735e;
                byteArrayBuilder.append(bArr[i7 >> 4]);
                byteArrayBuilder.append(bArr[i7 & 15]);
                i4 &= 255;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byte[] bArr2 = f17735e;
            byteArrayBuilder.append(bArr2[i4 >> 4]);
            byteArrayBuilder.append(bArr2[i4 & 15]);
        } else {
            byteArrayBuilder.append((byte) i5);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private int b(int i4, char[] cArr) {
        cArr[1] = (char) i4;
        return 2;
    }

    private int c(int i4, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = f17734d;
        cArr[4] = cArr2[i4 >> 4];
        cArr[5] = cArr2[i4 & 15];
        return 6;
    }

    private int d(int i4, int i5) {
        if (i5 >= 56320 && i5 <= 57343) {
            return ((i4 - 55296) << 10) + 65536 + (i5 - Utf8.LOG_SURROGATE_HEADER);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i4) + ", second 0x" + Integer.toHexString(i5) + "; illegal combination");
    }

    private void e(int i4) {
        if (i4 <= 1114111) {
            if (i4 >= 55296) {
                if (i4 <= 56319) {
                    throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i4) + ")");
                }
                throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i4) + ")");
            }
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i4) + ") to output");
        }
        throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i4) + ") to output; max is 0x10FFFF as per RFC 4627");
    }

    public static JsonStringEncoder getInstance() {
        JsonStringEncoder jsonStringEncoder;
        ThreadLocal<SoftReference<JsonStringEncoder>> threadLocal = f17736f;
        SoftReference<JsonStringEncoder> softReference = threadLocal.get();
        if (softReference == null) {
            jsonStringEncoder = null;
        } else {
            jsonStringEncoder = softReference.get();
        }
        if (jsonStringEncoder == null) {
            JsonStringEncoder jsonStringEncoder2 = new JsonStringEncoder();
            threadLocal.set(new SoftReference<>(jsonStringEncoder2));
            return jsonStringEncoder2;
        }
        return jsonStringEncoder;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] encodeAsUTF8(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.encodeAsUTF8(java.lang.String):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        r8 = r6 + 1;
        r6 = r12.charAt(r6);
        r9 = r2[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r9 >= 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        r6 = c(r6, r11.f17739c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        r6 = b(r9, r11.f17739c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        r9 = r7 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r9 <= r1.length) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        r9 = r1.length - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        if (r9 <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
        java.lang.System.arraycopy(r11.f17739c, 0, r1, r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        r1 = r0.finishCurrentSegment();
        r6 = r6 - r9;
        java.lang.System.arraycopy(r11.f17739c, r9, r1, 0, r6);
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
        java.lang.System.arraycopy(r11.f17739c, 0, r1, r7, r6);
        r7 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public char[] quoteAsString(java.lang.String r12) {
        /*
            r11 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r11.f17737a
            if (r0 != 0) goto Lc
            com.fasterxml.jackson.core.util.TextBuffer r0 = new com.fasterxml.jackson.core.util.TextBuffer
            r1 = 0
            r0.<init>(r1)
            r11.f17737a = r0
        Lc:
            char[] r1 = r0.emptyAndGetCurrentSegment()
            int[] r2 = com.fasterxml.jackson.core.io.CharTypes.get7BitOutputEscapes()
            int r3 = r2.length
            int r4 = r12.length()
            r5 = 0
            r6 = 0
            r7 = 0
        L1c:
            if (r6 >= r4) goto L75
        L1e:
            char r8 = r12.charAt(r6)
            if (r8 >= r3) goto L61
            r9 = r2[r8]
            if (r9 == 0) goto L61
            int r8 = r6 + 1
            char r6 = r12.charAt(r6)
            r9 = r2[r6]
            if (r9 >= 0) goto L39
            char[] r9 = r11.f17739c
            int r6 = r11.c(r6, r9)
            goto L3f
        L39:
            char[] r6 = r11.f17739c
            int r6 = r11.b(r9, r6)
        L3f:
            int r9 = r7 + r6
            int r10 = r1.length
            if (r9 <= r10) goto L59
            int r9 = r1.length
            int r9 = r9 - r7
            if (r9 <= 0) goto L4d
            char[] r10 = r11.f17739c
            java.lang.System.arraycopy(r10, r5, r1, r7, r9)
        L4d:
            char[] r1 = r0.finishCurrentSegment()
            int r6 = r6 - r9
            char[] r7 = r11.f17739c
            java.lang.System.arraycopy(r7, r9, r1, r5, r6)
            r7 = r6
            goto L5f
        L59:
            char[] r10 = r11.f17739c
            java.lang.System.arraycopy(r10, r5, r1, r7, r6)
            r7 = r9
        L5f:
            r6 = r8
            goto L1c
        L61:
            int r9 = r1.length
            if (r7 < r9) goto L69
            char[] r1 = r0.finishCurrentSegment()
            r7 = 0
        L69:
            int r9 = r7 + 1
            r1[r7] = r8
            int r6 = r6 + 1
            if (r6 < r4) goto L73
            r7 = r9
            goto L75
        L73:
            r7 = r9
            goto L1e
        L75:
            r0.setCurrentLength(r7)
            char[] r12 = r0.contentsAsArray()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.quoteAsString(java.lang.String):char[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r5 < r2.length) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
        r2 = r0.finishCurrentSegment();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        r7 = r4 + 1;
        r4 = r11.charAt(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (r4 > 127) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
        r5 = a(r4, r6[r4], r0, r5);
        r2 = r0.getCurrentSegment();
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
        if (r4 > 2047) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
        r6 = r5 + 1;
        r2[r5] = (byte) ((r4 >> 6) | 192);
        r4 = (r4 & '?') | 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
        r5 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r4 < 55296) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
        if (r4 <= 57343) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
        if (r4 <= 56319) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0081, code lost:
        e(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
        if (r7 < r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
        e(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0089, code lost:
        r6 = r7 + 1;
        r4 = d(r4, r11.charAt(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
        if (r4 <= 1114111) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0098, code lost:
        e(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:
        r7 = r5 + 1;
        r2[r5] = (byte) ((r4 >> 18) | 240);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a5, code lost:
        if (r7 < r2.length) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a7, code lost:
        r2 = r0.finishCurrentSegment();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
        r5 = r7 + 1;
        r2[r7] = (byte) (((r4 >> 12) & 63) | 128);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b8, code lost:
        if (r5 < r2.length) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ba, code lost:
        r2 = r0.finishCurrentSegment();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bf, code lost:
        r7 = r5 + 1;
        r2[r5] = (byte) (((r4 >> 6) & 63) | 128);
        r5 = (r4 & 63) | 128;
        r4 = r6;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d2, code lost:
        r6 = r5 + 1;
        r2[r5] = (byte) ((r4 >> '\f') | com.android.dx.io.Opcodes.SHL_INT_LIT8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00dc, code lost:
        if (r6 < r2.length) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00de, code lost:
        r2 = r0.finishCurrentSegment();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e3, code lost:
        r2[r6] = (byte) (((r4 >> 6) & 63) | 128);
        r4 = (r4 & '?') | 128;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f6, code lost:
        if (r6 < r2.length) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f8, code lost:
        r2 = r0.finishCurrentSegment();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fd, code lost:
        r2[r6] = (byte) r5;
        r5 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] quoteAsUTF8(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.quoteAsUTF8(java.lang.String):byte[]");
    }
}
