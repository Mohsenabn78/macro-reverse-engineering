package com.koushikdutta.async.http.spdy;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.jcodings.Config;

/* compiled from: Huffman.java */
/* loaded from: classes6.dex */
class h {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f35586b = {Config.SpecialIndexMask, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f35587c = {Ascii.CR, Ascii.ETB, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.CAN, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, 6, 10, 10, Ascii.FF, Ascii.CR, 6, 8, Ascii.VT, 10, 10, 8, Ascii.VT, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, Ascii.SI, 6, Ascii.FF, 10, Ascii.CR, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, Ascii.CR, 19, Ascii.CR, Ascii.SO, 6, Ascii.SI, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, Ascii.SI, Ascii.VT, Ascii.SO, Ascii.CR, Ascii.FS, Ascii.DC4, 22, Ascii.DC4, Ascii.DC4, 22, 22, 22, Ascii.ETB, 22, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.CAN, Ascii.CAN, 22, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.NAK, 22, Ascii.ETB, 22, Ascii.ETB, Ascii.ETB, Ascii.CAN, 22, Ascii.NAK, Ascii.DC4, 22, 22, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.ETB, 22, 22, Ascii.CAN, Ascii.NAK, 22, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.NAK, 22, Ascii.NAK, Ascii.ETB, 22, Ascii.ETB, Ascii.ETB, Ascii.DC4, 22, 22, 22, Ascii.ETB, 22, 22, Ascii.ETB, Ascii.SUB, Ascii.SUB, Ascii.DC4, 19, 22, Ascii.ETB, 22, Ascii.EM, Ascii.SUB, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.CAN, Ascii.EM, 19, Ascii.NAK, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.ESC, Ascii.CAN, Ascii.NAK, Ascii.NAK, Ascii.SUB, Ascii.SUB, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.DC4, Ascii.CAN, Ascii.DC4, Ascii.NAK, 22, Ascii.NAK, Ascii.NAK, Ascii.ETB, 22, 22, Ascii.EM, Ascii.EM, Ascii.CAN, Ascii.CAN, Ascii.SUB, Ascii.ETB, Ascii.SUB, Ascii.ESC, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.SUB};

    /* renamed from: d  reason: collision with root package name */
    private static final h f35588d = new h();

    /* renamed from: a  reason: collision with root package name */
    private final a f35589a = new a();

    private h() {
        b();
    }

    private void a(int i4, int i5, byte b4) {
        a aVar = new a(i4, b4);
        a aVar2 = this.f35589a;
        while (b4 > 8) {
            b4 = (byte) (b4 - 8);
            int i6 = (i5 >>> b4) & 255;
            if (aVar2.f35590a != null) {
                if (aVar2.f35590a[i6] == null) {
                    aVar2.f35590a[i6] = new a();
                }
                aVar2 = aVar2.f35590a[i6];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i7 = 8 - b4;
        int i8 = (i5 << i7) & 255;
        int i9 = 1 << i7;
        for (int i10 = i8; i10 < i8 + i9; i10++) {
            aVar2.f35590a[i10] = aVar;
        }
    }

    private void b() {
        int i4 = 0;
        while (true) {
            byte[] bArr = f35587c;
            if (i4 < bArr.length) {
                a(i4, f35586b[i4], bArr[i4]);
                i4++;
            } else {
                return;
            }
        }
    }

    public static h d() {
        return f35588d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = this.f35589a;
        int i4 = 0;
        int i5 = 0;
        for (byte b4 : bArr) {
            i4 = (i4 << 8) | (b4 & 255);
            i5 += 8;
            while (i5 >= 8) {
                aVar = aVar.f35590a[(i4 >>> (i5 - 8)) & 255];
                if (aVar.f35590a == null) {
                    byteArrayOutputStream.write(aVar.f35591b);
                    i5 -= aVar.f35592c;
                    aVar = this.f35589a;
                } else {
                    i5 -= 8;
                }
            }
        }
        while (i5 > 0) {
            a aVar2 = aVar.f35590a[(i4 << (8 - i5)) & 255];
            if (aVar2.f35590a != null || aVar2.f35592c > i5) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f35591b);
            i5 -= aVar2.f35592c;
            aVar = this.f35589a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Huffman.java */
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final a[] f35590a;

        /* renamed from: b  reason: collision with root package name */
        private final int f35591b;

        /* renamed from: c  reason: collision with root package name */
        private final int f35592c;

        a() {
            this.f35590a = new a[256];
            this.f35591b = 0;
            this.f35592c = 0;
        }

        a(int i4, int i5) {
            this.f35590a = null;
            this.f35591b = i4;
            int i6 = i5 & 7;
            this.f35592c = i6 == 0 ? 8 : i6;
        }
    }
}
