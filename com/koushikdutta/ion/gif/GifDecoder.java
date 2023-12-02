package com.koushikdutta.ion.gif;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class GifDecoder implements Cloneable {
    public static final int STATUS_FINISH = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARSING = 0;
    private boolean A;
    private int B;
    private int C;
    private short[] D;
    private byte[] E;
    private byte[] F;
    private byte[] G;
    private byte[] H;
    private int I;
    private int J;
    private int K;
    private int L;
    GifFrame M;
    GifFrame N;
    int[] O;
    private int P;

    /* renamed from: a  reason: collision with root package name */
    private int f35844a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f35845b;

    /* renamed from: c  reason: collision with root package name */
    private int f35846c;

    /* renamed from: d  reason: collision with root package name */
    private int f35847d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f35848e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f35849f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f35850g;

    /* renamed from: h  reason: collision with root package name */
    private int f35851h;
    public int height;

    /* renamed from: i  reason: collision with root package name */
    private int f35852i;

    /* renamed from: j  reason: collision with root package name */
    private int f35853j;

    /* renamed from: k  reason: collision with root package name */
    private int f35854k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f35855l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f35856m;

    /* renamed from: n  reason: collision with root package name */
    private int f35857n;

    /* renamed from: o  reason: collision with root package name */
    private int f35858o;

    /* renamed from: p  reason: collision with root package name */
    private int f35859p;

    /* renamed from: q  reason: collision with root package name */
    private int f35860q;

    /* renamed from: r  reason: collision with root package name */
    private int f35861r;

    /* renamed from: s  reason: collision with root package name */
    private int f35862s;

    /* renamed from: t  reason: collision with root package name */
    private int f35863t;

    /* renamed from: u  reason: collision with root package name */
    private int f35864u;

    /* renamed from: v  reason: collision with root package name */
    private int f35865v;

    /* renamed from: w  reason: collision with root package name */
    private byte[] f35866w;
    public int width;

    /* renamed from: x  reason: collision with root package name */
    private int f35867x;

    /* renamed from: y  reason: collision with root package name */
    private int f35868y;

    /* renamed from: z  reason: collision with root package name */
    private int f35869z;

    public GifDecoder(ByteBuffer byteBuffer) {
        this(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        int i4;
        int i5;
        int i6;
        short s3;
        int i7 = this.f35860q * this.f35861r;
        byte[] bArr = this.G;
        if (bArr == null || bArr.length < i7) {
            this.G = new byte[i7];
        }
        if (this.D == null) {
            this.D = new short[4096];
        }
        if (this.E == null) {
            this.E = new byte[4096];
        }
        if (this.F == null) {
            this.F = new byte[4097];
        }
        int c4 = c();
        int i8 = 1 << c4;
        int i9 = i8 + 1;
        int i10 = i8 + 2;
        int i11 = c4 + 1;
        int i12 = (1 << i11) - 1;
        for (int i13 = 0; i13 < i8; i13++) {
            this.D[i13] = 0;
            this.E[i13] = (byte) i13;
        }
        int i14 = i11;
        int i15 = i10;
        int i16 = i12;
        int i17 = -1;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i18 < i7) {
            if (i19 == 0) {
                if (i20 < i14) {
                    if (i22 == 0) {
                        i22 = f();
                        if (i22 <= 0) {
                            break;
                        }
                        i23 = 0;
                    }
                    i21 += (this.f35866w[i23] & 255) << i20;
                    i20 += 8;
                    i23++;
                    i22--;
                } else {
                    int i26 = i21 & i16;
                    i21 >>= i14;
                    i20 -= i14;
                    if (i26 > i15 || i26 == i9) {
                        break;
                    } else if (i26 == i8) {
                        i14 = i11;
                        i15 = i10;
                        i16 = i12;
                        i17 = -1;
                    } else if (i17 == -1) {
                        this.F[i19] = this.E[i26];
                        i17 = i26;
                        i24 = i17;
                        i19++;
                        i7 = i7;
                    } else {
                        i4 = i7;
                        if (i26 == i15) {
                            i5 = i11;
                            this.F[i19] = (byte) i24;
                            s3 = i17;
                            i19++;
                        } else {
                            i5 = i11;
                            s3 = i26;
                        }
                        while (s3 > i8) {
                            this.F[i19] = this.E[s3];
                            s3 = this.D[s3];
                            i19++;
                            i26 = i26;
                        }
                        int i27 = i26;
                        byte[] bArr2 = this.E;
                        int i28 = bArr2[s3] & 255;
                        if (i15 >= 4096) {
                            break;
                        }
                        int i29 = i19 + 1;
                        i6 = i8;
                        byte b4 = (byte) i28;
                        this.F[i19] = b4;
                        this.D[i15] = (short) i17;
                        bArr2[i15] = b4;
                        i15++;
                        if ((i15 & i16) == 0 && i15 < 4096) {
                            i14++;
                            i16 += i15;
                        }
                        i19 = i29;
                        i17 = i27;
                        i24 = i28;
                    }
                }
            } else {
                i4 = i7;
                i5 = i11;
                i6 = i8;
            }
            i19--;
            int i30 = i25;
            i25 = i30 + 1;
            this.G[i30] = this.F[i19];
            i18++;
            i7 = i4;
            i11 = i5;
            i8 = i6;
        }
        this.P = i25;
    }

    private boolean b() {
        if (this.f35844a != 0) {
            return true;
        }
        return false;
    }

    private int c() {
        int i4 = this.K;
        if (i4 >= this.J) {
            return 0;
        }
        byte[] bArr = this.H;
        int i5 = this.I;
        this.K = i4 + 1;
        return bArr[i5 + i4] & 255;
    }

    private int d(byte[] bArr) throws IOException {
        return e(bArr, 0, bArr.length);
    }

    private int e(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = this.K;
        int i7 = this.J;
        if (i6 >= i7) {
            return -1;
        }
        int min = Math.min(i7 - i6, i5);
        System.arraycopy(this.H, this.I + this.K, bArr, i4, min);
        this.K += min;
        return min;
    }

    private int f() {
        int c4 = c();
        this.f35867x = c4;
        int i4 = 0;
        if (c4 > 0) {
            while (true) {
                try {
                    int i5 = this.f35867x;
                    if (i4 >= i5) {
                        break;
                    }
                    int e4 = e(this.f35866w, i4, i5 - i4);
                    if (e4 == -1) {
                        break;
                    }
                    i4 += e4;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (i4 < this.f35867x) {
                this.f35844a = 1;
            }
        }
        return i4;
    }

    private int[] g(int i4) {
        int i5;
        int i6 = i4 * 3;
        byte[] bArr = new byte[i6];
        try {
            i5 = d(bArr);
        } catch (Exception e4) {
            e4.printStackTrace();
            i5 = 0;
        }
        if (i5 < i6) {
            this.f35844a = 1;
            return null;
        }
        int[] iArr = new int[256];
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = i7 + 1;
            int i10 = i9 + 1;
            iArr[i8] = ((bArr[i7] & 255) << 16) | (-16777216) | ((bArr[i9] & 255) << 8) | (bArr[i10] & 255);
            i7 = i10 + 1;
        }
        return iArr;
    }

    private void h() {
        c();
        int c4 = c();
        int i4 = (c4 & 28) >> 2;
        this.f35868y = i4;
        boolean z3 = true;
        if (i4 == 0) {
            this.f35868y = 1;
        }
        if ((c4 & 1) == 0) {
            z3 = false;
        }
        this.A = z3;
        this.B = m() * 10;
        this.C = c();
        c();
    }

    private void i() {
        String str = "";
        for (int i4 = 0; i4 < 6; i4++) {
            str = str + ((char) c());
        }
        if (!str.startsWith("GIF")) {
            this.f35844a = 1;
            return;
        }
        k();
        if (this.f35845b && !b()) {
            int[] g4 = g(this.f35846c);
            this.f35848e = g4;
            this.f35852i = g4[this.f35851h];
        }
    }

    private GifFrame j() {
        boolean z3;
        boolean z4;
        this.f35858o = m();
        this.f35859p = m();
        this.f35860q = m();
        this.f35861r = m();
        int c4 = c();
        if ((c4 & 128) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f35855l = z3;
        if ((c4 & 64) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f35856m = z4;
        int i4 = 2 << (c4 & 7);
        this.f35857n = i4;
        if (z3) {
            int[] g4 = g(i4);
            this.f35849f = g4;
            this.f35850g = g4;
        } else {
            this.f35850g = this.f35848e;
            if (this.f35851h == this.C) {
                this.f35852i = 0;
            }
        }
        if (this.f35850g == null) {
            this.f35844a = 1;
        }
        if (b()) {
            return null;
        }
        a();
        p();
        if (b()) {
            return null;
        }
        this.L++;
        GifFrame gifFrame = new GifFrame(o(), this.B);
        n(gifFrame);
        return gifFrame;
    }

    private void k() {
        boolean z3;
        this.width = m();
        this.height = m();
        int c4 = c();
        if ((c4 & 128) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f35845b = z3;
        this.f35846c = 2 << (c4 & 7);
        this.f35851h = c();
        this.f35854k = c();
    }

    private void l() {
        do {
            f();
            byte[] bArr = this.f35866w;
            if (bArr[0] == 1) {
                this.f35847d = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f35867x <= 0) {
                return;
            }
        } while (!b());
    }

    private int m() {
        return c() | (c() << 8);
    }

    private void n(GifFrame gifFrame) {
        int i4 = this.f35868y;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        Log.w("Ion", "Unknown gif dispose code: " + this.f35869z);
                    }
                } else {
                    this.N = null;
                }
            } else {
                this.N = gifFrame;
            }
        } else {
            this.N = gifFrame;
        }
        this.f35869z = this.f35868y;
        this.f35862s = this.f35858o;
        this.f35863t = this.f35859p;
        this.f35864u = this.f35860q;
        this.f35865v = this.f35861r;
        this.f35853j = this.f35852i;
        this.f35868y = 0;
        this.A = false;
        this.B = 0;
        this.f35849f = null;
        this.P = Integer.MAX_VALUE;
    }

    private Bitmap o() {
        int i4;
        int i5;
        int i6 = this.f35869z;
        int i7 = 0;
        if (i6 == 2) {
            if (this.O == null) {
                this.O = new int[this.width * this.height];
            }
            if (!this.A) {
                i5 = this.f35853j;
            } else {
                i5 = 0;
            }
            Arrays.fill(this.O, i5);
        } else {
            int[] iArr = this.O;
            if (iArr == null) {
                int i8 = this.width;
                int i9 = this.height;
                int[] iArr2 = new int[i8 * i9];
                this.O = iArr2;
                GifFrame gifFrame = this.N;
                if (gifFrame != null) {
                    gifFrame.image.getPixels(iArr2, 0, i8, 0, 0, i8, i9);
                } else {
                    Arrays.fill(iArr2, 0);
                }
            } else if (i6 == 3) {
                GifFrame gifFrame2 = this.N;
                if (gifFrame2 != null) {
                    Bitmap bitmap = gifFrame2.image;
                    int i10 = this.width;
                    bitmap.getPixels(iArr, 0, i10, 0, 0, i10, this.height);
                } else {
                    Arrays.fill(iArr, 0);
                }
            }
        }
        int i11 = 0;
        int i12 = 8;
        int i13 = 1;
        while (true) {
            int i14 = this.f35861r;
            if (i7 < i14) {
                if (this.f35856m) {
                    if (i11 >= i14) {
                        i13++;
                        if (i13 != 2) {
                            if (i13 != 3) {
                                if (i13 == 4) {
                                    i11 = 1;
                                    i12 = 2;
                                }
                            } else {
                                i11 = 2;
                                i12 = 4;
                            }
                        } else {
                            i11 = 4;
                        }
                    }
                    i4 = i11 + i12;
                } else {
                    i4 = i11;
                    i11 = i7;
                }
                int i15 = i11 + this.f35859p;
                if (i15 < this.height) {
                    int i16 = this.width;
                    int i17 = i15 * i16;
                    int i18 = this.f35858o + i17;
                    int i19 = this.f35860q;
                    int i20 = i18 + i19;
                    if (i17 + i16 < i20) {
                        i20 = i17 + i16;
                    }
                    int i21 = i19 * i7;
                    while (i18 < i20 && i21 < this.P) {
                        int i22 = i21 + 1;
                        int i23 = this.G[i21] & 255;
                        if (!this.A || i23 != this.C) {
                            this.O[i18] = this.f35850g[i23];
                        }
                        i18++;
                        i21 = i22;
                    }
                }
                i7++;
                i11 = i4;
            } else {
                return Bitmap.createBitmap(this.O, this.width, this.height, Bitmap.Config.ARGB_4444);
            }
        }
    }

    private void p() {
        do {
            f();
            if (this.f35867x <= 0) {
                return;
            }
        } while (!b());
    }

    public ByteBuffer getByteBuffer() {
        return ByteBuffer.wrap(this.H, this.I, this.J);
    }

    public int getGifDataLength() {
        return this.J;
    }

    public int getHeight() {
        return this.height;
    }

    public GifFrame getLastFrame() {
        return this.M;
    }

    public int getLoopCount() {
        return this.f35847d;
    }

    public int getStatus() {
        return this.f35844a;
    }

    public int getWidth() {
        return this.width;
    }

    public GifDecoder mutate() {
        try {
            GifDecoder gifDecoder = (GifDecoder) clone();
            this.f35866w = new byte[256];
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
            this.O = null;
            return gifDecoder;
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    public synchronized GifFrame nextFrame() {
        while (!b() && this.f35844a == 0) {
            int c4 = c();
            if (c4 != 0) {
                if (c4 != 33) {
                    if (c4 != 44) {
                        if (c4 != 59) {
                            this.f35844a = 1;
                        } else {
                            this.f35844a = -1;
                            return null;
                        }
                    } else {
                        GifFrame j4 = j();
                        this.M = j4;
                        return j4;
                    }
                } else {
                    int c5 = c();
                    if (c5 != 249) {
                        if (c5 != 255) {
                            p();
                        } else {
                            f();
                            String str = "";
                            for (int i4 = 0; i4 < 11; i4++) {
                                str = str + ((char) this.f35866w[i4]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                l();
                            } else {
                                p();
                            }
                        }
                    } else {
                        h();
                    }
                }
            }
        }
        this.f35844a = 1;
        return null;
    }

    public boolean parseOk() {
        if (this.f35844a == -1) {
            return true;
        }
        return false;
    }

    public void restart() {
        this.K = 0;
        this.f35844a = 0;
        this.f35848e = null;
        this.f35849f = null;
        i();
    }

    public GifDecoder(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public GifDecoder(byte[] bArr, int i4, int i5) {
        this.f35847d = 1;
        this.f35866w = new byte[256];
        this.f35867x = 0;
        this.f35868y = 0;
        this.f35869z = 0;
        this.A = false;
        this.B = 0;
        this.P = Integer.MAX_VALUE;
        this.H = bArr;
        this.I = i4;
        this.J = i5;
        restart();
    }
}
