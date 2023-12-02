package com.google.protobuf;

import com.android.dx.io.Opcodes;
import com.google.android.gms.location.places.Place;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.jetbrains.anko.DimensionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    private static final Processor f33623a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b4, byte b5, byte b6, byte b7, char[] cArr, int i4) throws InvalidProtocolBufferException {
            if (!m(b5) && (((b4 << Ascii.FS) + (b5 + 112)) >> 30) == 0 && !m(b6) && !m(b7)) {
                int r4 = ((b4 & 7) << 18) | (r(b5) << 12) | (r(b6) << 6) | r(b7);
                cArr[i4] = l(r4);
                cArr[i4 + 1] = q(r4);
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void i(byte b4, char[] cArr, int i4) {
            cArr[i4] = (char) b4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(byte b4, byte b5, byte b6, char[] cArr, int i4) throws InvalidProtocolBufferException {
            if (!m(b5) && ((b4 != -32 || b5 >= -96) && ((b4 != -19 || b5 < -96) && !m(b6)))) {
                cArr[i4] = (char) (((b4 & Ascii.SI) << 12) | (r(b5) << 6) | r(b6));
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b4, byte b5, char[] cArr, int i4) throws InvalidProtocolBufferException {
            if (b4 >= -62 && !m(b5)) {
                cArr[i4] = (char) (((b4 & Ascii.US) << 6) | r(b5));
                return;
            }
            throw InvalidProtocolBufferException.e();
        }

        private static char l(int i4) {
            return (char) ((i4 >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean m(byte b4) {
            if (b4 > -65) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(byte b4) {
            if (b4 >= 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(byte b4) {
            if (b4 < -16) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(byte b4) {
            if (b4 < -32) {
                return true;
            }
            return false;
        }

        private static char q(int i4) {
            return (char) ((i4 & Place.TYPE_SUBLOCALITY_LEVEL_1) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int r(byte b4) {
            return b4 & okio.Utf8.REPLACEMENT_BYTE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class Processor {
        Processor() {
        }

        private static int m(ByteBuffer byteBuffer, int i4, int i5) {
            int m4 = i4 + Utf8.m(byteBuffer, i4, i5);
            while (m4 < i5) {
                int i6 = m4 + 1;
                byte b4 = byteBuffer.get(m4);
                if (b4 < 0) {
                    if (b4 < -32) {
                        if (i6 >= i5) {
                            return b4;
                        }
                        if (b4 < -62 || byteBuffer.get(i6) > -65) {
                            return -1;
                        }
                        i6++;
                    } else if (b4 < -16) {
                        if (i6 >= i5 - 1) {
                            return Utf8.q(byteBuffer, b4, i6, i5 - i6);
                        }
                        int i7 = i6 + 1;
                        byte b5 = byteBuffer.get(i6);
                        if (b5 > -65 || ((b4 == -32 && b5 < -96) || ((b4 == -19 && b5 >= -96) || byteBuffer.get(i7) > -65))) {
                            return -1;
                        }
                        m4 = i7 + 1;
                    } else if (i6 >= i5 - 2) {
                        return Utf8.q(byteBuffer, b4, i6, i5 - i6);
                    } else {
                        int i8 = i6 + 1;
                        byte b6 = byteBuffer.get(i6);
                        if (b6 <= -65 && (((b4 << Ascii.FS) + (b6 + 112)) >> 30) == 0) {
                            int i9 = i8 + 1;
                            if (byteBuffer.get(i8) <= -65) {
                                i6 = i9 + 1;
                                if (byteBuffer.get(i9) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                m4 = i6;
            }
            return 0;
        }

        final String a(ByteBuffer byteBuffer, int i4, int i5) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i4, i5);
            } else if (byteBuffer.isDirect()) {
                return d(byteBuffer, i4, i5);
            } else {
                return c(byteBuffer, i4, i5);
            }
        }

        abstract String b(byte[] bArr, int i4, int i5) throws InvalidProtocolBufferException;

        final String c(ByteBuffer byteBuffer, int i4, int i5) throws InvalidProtocolBufferException {
            if ((i4 | i5 | ((byteBuffer.limit() - i4) - i5)) >= 0) {
                int i6 = i4 + i5;
                char[] cArr = new char[i5];
                int i7 = 0;
                while (i4 < i6) {
                    byte b4 = byteBuffer.get(i4);
                    if (!DecodeUtil.n(b4)) {
                        break;
                    }
                    i4++;
                    DecodeUtil.i(b4, cArr, i7);
                    i7++;
                }
                int i8 = i7;
                while (i4 < i6) {
                    int i9 = i4 + 1;
                    byte b5 = byteBuffer.get(i4);
                    if (DecodeUtil.n(b5)) {
                        int i10 = i8 + 1;
                        DecodeUtil.i(b5, cArr, i8);
                        while (i9 < i6) {
                            byte b6 = byteBuffer.get(i9);
                            if (!DecodeUtil.n(b6)) {
                                break;
                            }
                            i9++;
                            DecodeUtil.i(b6, cArr, i10);
                            i10++;
                        }
                        i4 = i9;
                        i8 = i10;
                    } else if (DecodeUtil.p(b5)) {
                        if (i9 < i6) {
                            DecodeUtil.k(b5, byteBuffer.get(i9), cArr, i8);
                            i4 = i9 + 1;
                            i8++;
                        } else {
                            throw InvalidProtocolBufferException.e();
                        }
                    } else if (DecodeUtil.o(b5)) {
                        if (i9 < i6 - 1) {
                            int i11 = i9 + 1;
                            DecodeUtil.j(b5, byteBuffer.get(i9), byteBuffer.get(i11), cArr, i8);
                            i4 = i11 + 1;
                            i8++;
                        } else {
                            throw InvalidProtocolBufferException.e();
                        }
                    } else if (i9 < i6 - 2) {
                        int i12 = i9 + 1;
                        byte b7 = byteBuffer.get(i9);
                        int i13 = i12 + 1;
                        DecodeUtil.h(b5, b7, byteBuffer.get(i12), byteBuffer.get(i13), cArr, i8);
                        i4 = i13 + 1;
                        i8 = i8 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.e();
                    }
                }
                return new String(cArr, 0, i8);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i4), Integer.valueOf(i5)));
        }

        abstract String d(ByteBuffer byteBuffer, int i4, int i5) throws InvalidProtocolBufferException;

        abstract int e(CharSequence charSequence, byte[] bArr, int i4, int i5);

        final void f(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(Utf8.i(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                h(charSequence, byteBuffer);
            } else {
                g(charSequence, byteBuffer);
            }
        }

        final void g(CharSequence charSequence, ByteBuffer byteBuffer) {
            int length = charSequence.length();
            int position = byteBuffer.position();
            int i4 = 0;
            while (i4 < length) {
                try {
                    char charAt = charSequence.charAt(i4);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i4, (byte) charAt);
                    i4++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i4) + " at index " + (byteBuffer.position() + Math.max(i4, (position - byteBuffer.position()) + 1)));
                }
            }
            if (i4 == length) {
                byteBuffer.position(position + i4);
                return;
            }
            position += i4;
            while (i4 < length) {
                char charAt2 = charSequence.charAt(i4);
                if (charAt2 < 128) {
                    byteBuffer.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    int i5 = position + 1;
                    try {
                        byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                        byteBuffer.put(i5, (byte) ((charAt2 & '?') | 128));
                        position = i5;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i5;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i4) + " at index " + (byteBuffer.position() + Math.max(i4, (position - byteBuffer.position()) + 1)));
                    }
                } else if (charAt2 >= 55296 && 57343 >= charAt2) {
                    int i6 = i4 + 1;
                    if (i6 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i6);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i7 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    int i8 = i7 + 1;
                                    byteBuffer.put(i7, (byte) (((codePoint >>> 12) & 63) | 128));
                                    int i9 = i8 + 1;
                                    byteBuffer.put(i8, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i9, (byte) ((codePoint & 63) | 128));
                                    position = i9;
                                    i4 = i6;
                                } catch (IndexOutOfBoundsException unused3) {
                                    position = i7;
                                    i4 = i6;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i4) + " at index " + (byteBuffer.position() + Math.max(i4, (position - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i4 = i6;
                            }
                        } catch (IndexOutOfBoundsException unused4) {
                        }
                    }
                    throw new UnpairedSurrogateException(i4, length);
                } else {
                    int i10 = position + 1;
                    byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | Opcodes.SHL_INT_LIT8));
                    position = i10 + 1;
                    byteBuffer.put(i10, (byte) (((charAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
                }
                i4++;
                position++;
            }
            byteBuffer.position(position);
        }

        abstract void h(CharSequence charSequence, ByteBuffer byteBuffer);

        final boolean i(ByteBuffer byteBuffer, int i4, int i5) {
            if (k(0, byteBuffer, i4, i5) != 0) {
                return false;
            }
            return true;
        }

        final boolean j(byte[] bArr, int i4, int i5) {
            if (l(0, bArr, i4, i5) != 0) {
                return false;
            }
            return true;
        }

        final int k(int i4, ByteBuffer byteBuffer, int i5, int i6) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return l(i4, byteBuffer.array(), i5 + arrayOffset, arrayOffset + i6);
            } else if (byteBuffer.isDirect()) {
                return o(i4, byteBuffer, i5, i6);
            } else {
                return n(i4, byteBuffer, i5, i6);
            }
        }

        abstract int l(int i4, byte[] bArr, int i5, int i6);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r8.get(r9) > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
            if (r8.get(r9) > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
            if (r8.get(r7) > (-65)) goto L51;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int n(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = com.google.protobuf.Utf8.a(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = com.google.protobuf.Utf8.a(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = com.google.protobuf.Utf8.b(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.n(int, java.nio.ByteBuffer, int, int):int");
        }

        abstract int o(int i4, ByteBuffer byteBuffer, int i5, int i6);
    }

    /* loaded from: classes6.dex */
    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        private static int p(byte[] bArr, int i4, int i5) {
            while (i4 < i5 && bArr[i4] >= 0) {
                i4++;
            }
            if (i4 >= i5) {
                return 0;
            }
            return q(bArr, i4, i5);
        }

        private static int q(byte[] bArr, int i4, int i5) {
            while (i4 < i5) {
                int i6 = i4 + 1;
                byte b4 = bArr[i4];
                if (b4 < 0) {
                    if (b4 < -32) {
                        if (i6 >= i5) {
                            return b4;
                        }
                        if (b4 >= -62) {
                            i4 = i6 + 1;
                            if (bArr[i6] > -65) {
                            }
                        }
                        return -1;
                    } else if (b4 < -16) {
                        if (i6 >= i5 - 1) {
                            return Utf8.r(bArr, i6, i5);
                        }
                        int i7 = i6 + 1;
                        byte b5 = bArr[i6];
                        if (b5 <= -65 && ((b4 != -32 || b5 >= -96) && (b4 != -19 || b5 < -96))) {
                            i4 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                        return -1;
                    } else if (i6 >= i5 - 2) {
                        return Utf8.r(bArr, i6, i5);
                    } else {
                        int i8 = i6 + 1;
                        byte b6 = bArr[i6];
                        if (b6 <= -65 && (((b4 << Ascii.FS) + (b6 + 112)) >> 30) == 0) {
                            int i9 = i8 + 1;
                            if (bArr[i8] <= -65) {
                                i6 = i9 + 1;
                                if (bArr[i9] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i4 = i6;
            }
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        String b(byte[] bArr, int i4, int i5) throws InvalidProtocolBufferException {
            if ((i4 | i5 | ((bArr.length - i4) - i5)) >= 0) {
                int i6 = i4 + i5;
                char[] cArr = new char[i5];
                int i7 = 0;
                while (i4 < i6) {
                    byte b4 = bArr[i4];
                    if (!DecodeUtil.n(b4)) {
                        break;
                    }
                    i4++;
                    DecodeUtil.i(b4, cArr, i7);
                    i7++;
                }
                int i8 = i7;
                while (i4 < i6) {
                    int i9 = i4 + 1;
                    byte b5 = bArr[i4];
                    if (DecodeUtil.n(b5)) {
                        int i10 = i8 + 1;
                        DecodeUtil.i(b5, cArr, i8);
                        while (i9 < i6) {
                            byte b6 = bArr[i9];
                            if (!DecodeUtil.n(b6)) {
                                break;
                            }
                            i9++;
                            DecodeUtil.i(b6, cArr, i10);
                            i10++;
                        }
                        i4 = i9;
                        i8 = i10;
                    } else if (DecodeUtil.p(b5)) {
                        if (i9 < i6) {
                            DecodeUtil.k(b5, bArr[i9], cArr, i8);
                            i4 = i9 + 1;
                            i8++;
                        } else {
                            throw InvalidProtocolBufferException.e();
                        }
                    } else if (DecodeUtil.o(b5)) {
                        if (i9 < i6 - 1) {
                            int i11 = i9 + 1;
                            DecodeUtil.j(b5, bArr[i9], bArr[i11], cArr, i8);
                            i4 = i11 + 1;
                            i8++;
                        } else {
                            throw InvalidProtocolBufferException.e();
                        }
                    } else if (i9 < i6 - 2) {
                        int i12 = i9 + 1;
                        byte b7 = bArr[i9];
                        int i13 = i12 + 1;
                        DecodeUtil.h(b5, b7, bArr[i12], bArr[i13], cArr, i8);
                        i4 = i13 + 1;
                        i8 = i8 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.e();
                    }
                }
                return new String(cArr, 0, i8);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        String d(ByteBuffer byteBuffer, int i4, int i5) throws InvalidProtocolBufferException {
            return c(byteBuffer, i4, i5);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
            return r10 + r0;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int e(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.e(java.lang.CharSequence, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        void h(CharSequence charSequence, ByteBuffer byteBuffer) {
            g(charSequence, byteBuffer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r8[r9] > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
            if (r8[r9] > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
            if (r8[r7] > (-65)) goto L51;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int l(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = com.google.protobuf.Utf8.a(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = com.google.protobuf.Utf8.a(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = com.google.protobuf.Utf8.b(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = p(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.l(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        int o(int i4, ByteBuffer byteBuffer, int i5, int i6) {
            return n(i4, byteBuffer, i5, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        /* JADX INFO: Access modifiers changed from: package-private */
        public UnpairedSurrogateException(int i4, int i5) {
            super("Unpaired surrogate at index " + i4 + " of " + i5);
        }
    }

    /* loaded from: classes6.dex */
    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean p() {
            if (UnsafeUtil.J() && UnsafeUtil.K()) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int q(long r8, int r10) {
            /*
                int r0 = s(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r10 <= 0) goto L1a
                long r4 = r8 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r8)
                if (r1 < 0) goto L19
                int r10 = r10 + (-1)
                r8 = r4
                goto L9
            L19:
                r8 = r4
            L1a:
                if (r10 != 0) goto L1d
                return r0
            L1d:
                int r10 = r10 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r10 != 0) goto L29
                return r1
            L29:
                int r10 = r10 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.x(r8)
                if (r8 <= r4) goto L37
                goto L39
            L37:
                r8 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r10 >= r6) goto L46
                int r8 = u(r8, r1, r10)
                return r8
            L46:
                int r10 = r10 + (-2)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.x(r8)
                if (r8 > r4) goto L63
                r9 = -96
                if (r1 != r0) goto L56
                if (r8 < r9) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r8 >= r9) goto L63
            L5c:
                long r2 = r2 + r6
                byte r8 = com.google.protobuf.UnsafeUtil.x(r6)
                if (r8 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r10 >= r0) goto L6c
                int r8 = u(r8, r1, r10)
                return r8
            L6c:
                int r10 = r10 + (-3)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.x(r8)
                if (r8 > r4) goto L8e
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L8e
                long r8 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.x(r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.x(r8)
                if (r8 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.q(long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int r(byte[] r8, long r9, int r11) {
            /*
                int r0 = t(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r11 <= 0) goto L1a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.y(r8, r9)
                if (r1 < 0) goto L19
                int r11 = r11 + (-1)
                r9 = r4
                goto L9
            L19:
                r9 = r4
            L1a:
                if (r11 != 0) goto L1d
                return r0
            L1d:
                int r11 = r11 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r11 != 0) goto L29
                return r1
            L29:
                int r11 = r11 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.y(r8, r9)
                if (r9 <= r4) goto L37
                goto L39
            L37:
                r9 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r11 >= r6) goto L46
                int r8 = v(r8, r1, r9, r11)
                return r8
            L46:
                int r11 = r11 + (-2)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.y(r8, r9)
                if (r9 > r4) goto L63
                r10 = -96
                if (r1 != r0) goto L56
                if (r9 < r10) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r9 >= r10) goto L63
            L5c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.UnsafeUtil.y(r8, r6)
                if (r9 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r11 >= r0) goto L6c
                int r8 = v(r8, r1, r9, r11)
                return r8
            L6c:
                int r11 = r11 + (-3)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.y(r8, r9)
                if (r9 > r4) goto L8e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L8e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.y(r8, r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.y(r8, r9)
                if (r9 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.r(byte[], long, int):int");
        }

        private static int s(long j4, int i4) {
            if (i4 < 16) {
                return 0;
            }
            int i5 = (int) ((-j4) & 7);
            int i6 = i5;
            while (i6 > 0) {
                long j5 = 1 + j4;
                if (UnsafeUtil.x(j4) < 0) {
                    return i5 - i6;
                }
                i6--;
                j4 = j5;
            }
            int i7 = i4 - i5;
            while (i7 >= 8 && (UnsafeUtil.E(j4) & (-9187201950435737472L)) == 0) {
                j4 += 8;
                i7 -= 8;
            }
            return i4 - i7;
        }

        private static int t(byte[] bArr, long j4, int i4) {
            int i5 = 0;
            if (i4 < 16) {
                return 0;
            }
            int i6 = 8 - (((int) j4) & 7);
            while (i5 < i6) {
                long j5 = 1 + j4;
                if (UnsafeUtil.y(bArr, j4) < 0) {
                    return i5;
                }
                i5++;
                j4 = j5;
            }
            while (true) {
                int i7 = i5 + 8;
                if (i7 > i4 || (UnsafeUtil.F(bArr, UnsafeUtil.f33606h + j4) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j4 += 8;
                i5 = i7;
            }
            while (i5 < i4) {
                long j6 = j4 + 1;
                if (UnsafeUtil.y(bArr, j4) < 0) {
                    return i5;
                }
                i5++;
                j4 = j6;
            }
            return i4;
        }

        private static int u(long j4, int i4, int i5) {
            if (i5 == 0) {
                return Utf8.n(i4);
            }
            if (i5 == 1) {
                return Utf8.o(i4, UnsafeUtil.x(j4));
            }
            if (i5 == 2) {
                return Utf8.p(i4, UnsafeUtil.x(j4), UnsafeUtil.x(j4 + 1));
            }
            throw new AssertionError();
        }

        private static int v(byte[] bArr, int i4, long j4, int i5) {
            if (i5 == 0) {
                return Utf8.n(i4);
            }
            if (i5 == 1) {
                return Utf8.o(i4, UnsafeUtil.y(bArr, j4));
            }
            if (i5 == 2) {
                return Utf8.p(i4, UnsafeUtil.y(bArr, j4), UnsafeUtil.y(bArr, j4 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.Utf8.Processor
        String b(byte[] bArr, int i4, int i5) throws InvalidProtocolBufferException {
            Charset charset = Internal.f33419b;
            String str = new String(bArr, i4, i5, charset);
            if (!str.contains("�")) {
                return str;
            }
            if (Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i4, i5 + i4))) {
                return str;
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // com.google.protobuf.Utf8.Processor
        String d(ByteBuffer byteBuffer, int i4, int i5) throws InvalidProtocolBufferException {
            if ((i4 | i5 | ((byteBuffer.limit() - i4) - i5)) >= 0) {
                long k4 = UnsafeUtil.k(byteBuffer) + i4;
                long j4 = i5 + k4;
                char[] cArr = new char[i5];
                int i6 = 0;
                while (k4 < j4) {
                    byte x3 = UnsafeUtil.x(k4);
                    if (!DecodeUtil.n(x3)) {
                        break;
                    }
                    k4++;
                    DecodeUtil.i(x3, cArr, i6);
                    i6++;
                }
                while (true) {
                    int i7 = i6;
                    while (k4 < j4) {
                        long j5 = k4 + 1;
                        byte x4 = UnsafeUtil.x(k4);
                        if (DecodeUtil.n(x4)) {
                            int i8 = i7 + 1;
                            DecodeUtil.i(x4, cArr, i7);
                            while (j5 < j4) {
                                byte x5 = UnsafeUtil.x(j5);
                                if (!DecodeUtil.n(x5)) {
                                    break;
                                }
                                j5++;
                                DecodeUtil.i(x5, cArr, i8);
                                i8++;
                            }
                            i7 = i8;
                            k4 = j5;
                        } else if (DecodeUtil.p(x4)) {
                            if (j5 < j4) {
                                k4 = j5 + 1;
                                DecodeUtil.k(x4, UnsafeUtil.x(j5), cArr, i7);
                                i7++;
                            } else {
                                throw InvalidProtocolBufferException.e();
                            }
                        } else if (DecodeUtil.o(x4)) {
                            if (j5 < j4 - 1) {
                                long j6 = j5 + 1;
                                DecodeUtil.j(x4, UnsafeUtil.x(j5), UnsafeUtil.x(j6), cArr, i7);
                                i7++;
                                k4 = j6 + 1;
                            } else {
                                throw InvalidProtocolBufferException.e();
                            }
                        } else if (j5 < j4 - 2) {
                            long j7 = j5 + 1;
                            byte x6 = UnsafeUtil.x(j5);
                            long j8 = j7 + 1;
                            byte x7 = UnsafeUtil.x(j7);
                            k4 = j8 + 1;
                            DecodeUtil.h(x4, x6, x7, UnsafeUtil.x(j8), cArr, i7);
                            i6 = i7 + 1 + 1;
                        } else {
                            throw InvalidProtocolBufferException.e();
                        }
                    }
                    return new String(cArr, 0, i7);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i4), Integer.valueOf(i5)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        int e(CharSequence charSequence, byte[] bArr, int i4, int i5) {
            char c4;
            long j4;
            long j5;
            long j6;
            int i6;
            char charAt;
            long j7 = i4;
            long j8 = i5 + j7;
            int length = charSequence.length();
            if (length <= i5 && bArr.length - i5 >= i4) {
                int i7 = 0;
                while (true) {
                    c4 = 128;
                    j4 = 1;
                    if (i7 >= length || (charAt = charSequence.charAt(i7)) >= 128) {
                        break;
                    }
                    UnsafeUtil.R(bArr, j7, (byte) charAt);
                    i7++;
                    j7 = 1 + j7;
                }
                if (i7 == length) {
                    return (int) j7;
                }
                while (i7 < length) {
                    char charAt2 = charSequence.charAt(i7);
                    if (charAt2 < c4 && j7 < j8) {
                        long j9 = j7 + j4;
                        UnsafeUtil.R(bArr, j7, (byte) charAt2);
                        j6 = j4;
                        j5 = j9;
                    } else {
                        if (charAt2 < 2048 && j7 <= j8 - 2) {
                            long j10 = j7 + j4;
                            UnsafeUtil.R(bArr, j7, (byte) ((charAt2 >>> 6) | 960));
                            UnsafeUtil.R(bArr, j10, (byte) ((charAt2 & '?') | 128));
                            j5 = j10 + j4;
                            j6 = j4;
                        } else if ((charAt2 < 55296 || 57343 < charAt2) && j7 <= j8 - 3) {
                            long j11 = j7 + j4;
                            UnsafeUtil.R(bArr, j7, (byte) ((charAt2 >>> '\f') | DimensionsKt.XXHDPI));
                            long j12 = j11 + j4;
                            UnsafeUtil.R(bArr, j11, (byte) (((charAt2 >>> 6) & 63) | 128));
                            UnsafeUtil.R(bArr, j12, (byte) ((charAt2 & '?') | 128));
                            j5 = j12 + 1;
                            j6 = 1;
                        } else if (j7 <= j8 - 4) {
                            int i8 = i7 + 1;
                            if (i8 != length) {
                                char charAt3 = charSequence.charAt(i8);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j13 = j7 + 1;
                                    UnsafeUtil.R(bArr, j7, (byte) ((codePoint >>> 18) | 240));
                                    long j14 = j13 + 1;
                                    UnsafeUtil.R(bArr, j13, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j15 = j14 + 1;
                                    UnsafeUtil.R(bArr, j14, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j6 = 1;
                                    j5 = j15 + 1;
                                    UnsafeUtil.R(bArr, j15, (byte) ((codePoint & 63) | 128));
                                    i7 = i8;
                                } else {
                                    i7 = i8;
                                }
                            }
                            throw new UnpairedSurrogateException(i7 - 1, length);
                        } else if (55296 <= charAt2 && charAt2 <= 57343 && ((i6 = i7 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i6)))) {
                            throw new UnpairedSurrogateException(i7, length);
                        } else {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j7);
                        }
                        i7++;
                        c4 = 128;
                        long j16 = j6;
                        j7 = j5;
                        j4 = j16;
                    }
                    i7++;
                    c4 = 128;
                    long j162 = j6;
                    j7 = j5;
                    j4 = j162;
                }
                return (int) j7;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i4 + i5));
        }

        @Override // com.google.protobuf.Utf8.Processor
        void h(CharSequence charSequence, ByteBuffer byteBuffer) {
            char c4;
            long j4;
            int i4;
            char charAt;
            long k4 = UnsafeUtil.k(byteBuffer);
            long position = byteBuffer.position() + k4;
            long limit = byteBuffer.limit() + k4;
            int length = charSequence.length();
            if (length <= limit - position) {
                int i5 = 0;
                while (true) {
                    c4 = 128;
                    if (i5 >= length || (charAt = charSequence.charAt(i5)) >= 128) {
                        break;
                    }
                    UnsafeUtil.Q(position, (byte) charAt);
                    i5++;
                    position++;
                }
                if (i5 == length) {
                    byteBuffer.position((int) (position - k4));
                    return;
                }
                while (i5 < length) {
                    char charAt2 = charSequence.charAt(i5);
                    if (charAt2 < c4 && position < limit) {
                        UnsafeUtil.Q(position, (byte) charAt2);
                        position++;
                        j4 = k4;
                    } else if (charAt2 < 2048 && position <= limit - 2) {
                        j4 = k4;
                        long j5 = position + 1;
                        UnsafeUtil.Q(position, (byte) ((charAt2 >>> 6) | 960));
                        UnsafeUtil.Q(j5, (byte) ((charAt2 & '?') | 128));
                        position = j5 + 1;
                    } else {
                        j4 = k4;
                        if ((charAt2 < 55296 || 57343 < charAt2) && position <= limit - 3) {
                            long j6 = position + 1;
                            UnsafeUtil.Q(position, (byte) ((charAt2 >>> '\f') | DimensionsKt.XXHDPI));
                            long j7 = j6 + 1;
                            UnsafeUtil.Q(j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                            UnsafeUtil.Q(j7, (byte) ((charAt2 & '?') | 128));
                            position = j7 + 1;
                        } else if (position <= limit - 4) {
                            int i6 = i5 + 1;
                            if (i6 != length) {
                                char charAt3 = charSequence.charAt(i6);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j8 = position + 1;
                                    UnsafeUtil.Q(position, (byte) ((codePoint >>> 18) | 240));
                                    long j9 = j8 + 1;
                                    UnsafeUtil.Q(j8, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j10 = j9 + 1;
                                    UnsafeUtil.Q(j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                    long j11 = j10 + 1;
                                    UnsafeUtil.Q(j10, (byte) ((codePoint & 63) | 128));
                                    i5 = i6;
                                    position = j11;
                                } else {
                                    i5 = i6;
                                }
                            }
                            throw new UnpairedSurrogateException(i5 - 1, length);
                        } else if (55296 <= charAt2 && charAt2 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                            throw new UnpairedSurrogateException(i5, length);
                        } else {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                        }
                    }
                    i5++;
                    k4 = j4;
                    c4 = 128;
                }
                byteBuffer.position((int) (position - k4));
                return;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
            if (com.google.protobuf.UnsafeUtil.y(r13, r2) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
            if (com.google.protobuf.UnsafeUtil.y(r13, r2) > (-65)) goto L56;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int l(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.l(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
            if (com.google.protobuf.UnsafeUtil.x(r2) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
            if (com.google.protobuf.UnsafeUtil.x(r2) > (-65)) goto L56;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int o(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.o(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        Processor safeProcessor;
        if (UnsafeProcessor.p() && !Android.c()) {
            safeProcessor = new UnsafeProcessor();
        } else {
            safeProcessor = new SafeProcessor();
        }
        f33623a = safeProcessor;
    }

    private Utf8() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(ByteBuffer byteBuffer, int i4, int i5) throws InvalidProtocolBufferException {
        return f33623a.a(byteBuffer, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(byte[] bArr, int i4, int i5) throws InvalidProtocolBufferException {
        return f33623a.b(bArr, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(CharSequence charSequence, byte[] bArr, int i4, int i5) {
        return f33623a.e(charSequence, bArr, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(CharSequence charSequence, ByteBuffer byteBuffer) {
        f33623a.f(charSequence, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length && charSequence.charAt(i4) < 128) {
            i4++;
        }
        int i5 = length;
        while (true) {
            if (i4 < length) {
                char charAt = charSequence.charAt(i4);
                if (charAt < 2048) {
                    i5 += (127 - charAt) >>> 31;
                    i4++;
                } else {
                    i5 += l(charSequence, i4);
                    break;
                }
            } else {
                break;
            }
        }
        if (i5 >= length) {
            return i5;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i5 + 4294967296L));
    }

    private static int l(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        int i5 = 0;
        while (i4 < length) {
            char charAt = charSequence.charAt(i4);
            if (charAt < 2048) {
                i5 += (127 - charAt) >>> 31;
            } else {
                i5 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i4) >= 65536) {
                        i4++;
                    } else {
                        throw new UnpairedSurrogateException(i4, length);
                    }
                }
            }
            i4++;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(ByteBuffer byteBuffer, int i4, int i5) {
        int i6 = i5 - 7;
        int i7 = i4;
        while (i7 < i6 && (byteBuffer.getLong(i7) & (-9187201950435737472L)) == 0) {
            i7 += 8;
        }
        return i7 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int i4) {
        if (i4 > -12) {
            return -1;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(int i4, int i5) {
        if (i4 <= -12 && i5 <= -65) {
            return i4 ^ (i5 << 8);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(int i4, int i5, int i6) {
        if (i4 <= -12 && i5 <= -65 && i6 <= -65) {
            return (i4 ^ (i5 << 8)) ^ (i6 << 16);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(ByteBuffer byteBuffer, int i4, int i5, int i6) {
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return p(i4, byteBuffer.get(i5), byteBuffer.get(i5 + 1));
                }
                throw new AssertionError();
            }
            return o(i4, byteBuffer.get(i5));
        }
        return n(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(byte[] bArr, int i4, int i5) {
        byte b4 = bArr[i4 - 1];
        int i6 = i5 - i4;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return p(b4, bArr[i4], bArr[i4 + 1]);
                }
                throw new AssertionError();
            }
            return o(b4, bArr[i4]);
        }
        return n(b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s(ByteBuffer byteBuffer) {
        return f33623a.i(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(byte[] bArr) {
        return f33623a.j(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u(byte[] bArr, int i4, int i5) {
        return f33623a.j(bArr, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i4, ByteBuffer byteBuffer, int i5, int i6) {
        return f33623a.k(i4, byteBuffer, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(int i4, byte[] bArr, int i5, int i6) {
        return f33623a.l(i4, bArr, i5, i6);
    }
}
