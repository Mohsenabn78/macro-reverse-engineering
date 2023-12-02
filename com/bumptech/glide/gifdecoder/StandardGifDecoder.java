package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class StandardGifDecoder implements GifDecoder {

    /* renamed from: v  reason: collision with root package name */
    private static final String f16703v = "StandardGifDecoder";
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    private int[] f16704a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    private final int[] f16705b;

    /* renamed from: c  reason: collision with root package name */
    private final GifDecoder.BitmapProvider f16706c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f16707d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f16708e;

    /* renamed from: f  reason: collision with root package name */
    private GifHeaderParser f16709f;

    /* renamed from: g  reason: collision with root package name */
    private short[] f16710g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f16711h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f16712i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f16713j;
    @ColorInt

    /* renamed from: k  reason: collision with root package name */
    private int[] f16714k;

    /* renamed from: l  reason: collision with root package name */
    private int f16715l;

    /* renamed from: m  reason: collision with root package name */
    private GifHeader f16716m;

    /* renamed from: n  reason: collision with root package name */
    private Bitmap f16717n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f16718o;

    /* renamed from: p  reason: collision with root package name */
    private int f16719p;

    /* renamed from: q  reason: collision with root package name */
    private int f16720q;

    /* renamed from: r  reason: collision with root package name */
    private int f16721r;

    /* renamed from: s  reason: collision with root package name */
    private int f16722s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private Boolean f16723t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    private Bitmap.Config f16724u;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    @ColorInt
    private int a(int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = i4; i12 < this.f16720q + i4; i12++) {
            byte[] bArr = this.f16713j;
            if (i12 >= bArr.length || i12 >= i5) {
                break;
            }
            int i13 = this.f16704a[bArr[i12] & 255];
            if (i13 != 0) {
                i7 += (i13 >> 24) & 255;
                i8 += (i13 >> 16) & 255;
                i9 += (i13 >> 8) & 255;
                i10 += i13 & 255;
                i11++;
            }
        }
        int i14 = i4 + i6;
        for (int i15 = i14; i15 < this.f16720q + i14; i15++) {
            byte[] bArr2 = this.f16713j;
            if (i15 >= bArr2.length || i15 >= i5) {
                break;
            }
            int i16 = this.f16704a[bArr2[i15] & 255];
            if (i16 != 0) {
                i7 += (i16 >> 24) & 255;
                i8 += (i16 >> 16) & 255;
                i9 += (i16 >> 8) & 255;
                i10 += i16 & 255;
                i11++;
            }
        }
        if (i11 == 0) {
            return 0;
        }
        return ((i7 / i11) << 24) | ((i8 / i11) << 16) | ((i9 / i11) << 8) | (i10 / i11);
    }

    private void b(a aVar) {
        boolean z3;
        boolean booleanValue;
        int i4;
        int i5;
        boolean z4;
        int i6;
        int i7;
        int i8;
        int[] iArr = this.f16714k;
        int i9 = aVar.f16728d;
        int i10 = this.f16720q;
        int i11 = i9 / i10;
        int i12 = aVar.f16726b / i10;
        int i13 = aVar.f16727c / i10;
        int i14 = aVar.f16725a / i10;
        if (this.f16715l == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i15 = this.f16722s;
        int i16 = this.f16721r;
        byte[] bArr = this.f16713j;
        int[] iArr2 = this.f16704a;
        Boolean bool = this.f16723t;
        int i17 = 8;
        int i18 = 0;
        int i19 = 0;
        int i20 = 1;
        while (i19 < i11) {
            Boolean bool2 = bool;
            if (aVar.f16729e) {
                if (i18 >= i11) {
                    int i21 = i20 + 1;
                    i4 = i11;
                    if (i21 != 2) {
                        if (i21 != 3) {
                            if (i21 != 4) {
                                i20 = i21;
                            } else {
                                i20 = i21;
                                i18 = 1;
                                i17 = 2;
                            }
                        } else {
                            i20 = i21;
                            i18 = 2;
                            i17 = 4;
                        }
                    } else {
                        i20 = i21;
                        i18 = 4;
                    }
                } else {
                    i4 = i11;
                }
                i5 = i18 + i17;
            } else {
                i4 = i11;
                i5 = i18;
                i18 = i19;
            }
            int i22 = i18 + i12;
            if (i10 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (i22 < i16) {
                int i23 = i22 * i15;
                int i24 = i23 + i14;
                int i25 = i24 + i13;
                int i26 = i23 + i15;
                if (i26 < i25) {
                    i25 = i26;
                }
                i6 = i5;
                int i27 = i19 * i10 * aVar.f16727c;
                if (z4) {
                    int i28 = i24;
                    while (i28 < i25) {
                        int i29 = i12;
                        int i30 = iArr2[bArr[i27] & 255];
                        if (i30 != 0) {
                            iArr[i28] = i30;
                        } else if (z3 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i27 += i10;
                        i28++;
                        i12 = i29;
                    }
                } else {
                    i8 = i12;
                    int i31 = ((i25 - i24) * i10) + i27;
                    int i32 = i24;
                    while (true) {
                        i7 = i13;
                        if (i32 < i25) {
                            int a4 = a(i27, i31, aVar.f16727c);
                            if (a4 != 0) {
                                iArr[i32] = a4;
                            } else if (z3 && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i27 += i10;
                            i32++;
                            i13 = i7;
                        }
                    }
                    bool = bool2;
                    i19++;
                    i12 = i8;
                    i11 = i4;
                    i13 = i7;
                    i18 = i6;
                }
            } else {
                i6 = i5;
            }
            i8 = i12;
            i7 = i13;
            bool = bool2;
            i19++;
            i12 = i8;
            i11 = i4;
            i13 = i7;
            i18 = i6;
        }
        Boolean bool3 = bool;
        if (this.f16723t == null) {
            if (bool3 == null) {
                booleanValue = false;
            } else {
                booleanValue = bool3.booleanValue();
            }
            this.f16723t = Boolean.valueOf(booleanValue);
        }
    }

    private void c(a aVar) {
        boolean z3;
        boolean z4;
        a aVar2 = aVar;
        int[] iArr = this.f16714k;
        int i4 = aVar2.f16728d;
        int i5 = aVar2.f16726b;
        int i6 = aVar2.f16727c;
        int i7 = aVar2.f16725a;
        if (this.f16715l == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i8 = this.f16722s;
        byte[] bArr = this.f16713j;
        int[] iArr2 = this.f16704a;
        int i9 = 0;
        byte b4 = -1;
        while (i9 < i4) {
            int i10 = (i9 + i5) * i8;
            int i11 = i10 + i7;
            int i12 = i11 + i6;
            int i13 = i10 + i8;
            if (i13 < i12) {
                i12 = i13;
            }
            int i14 = aVar2.f16727c * i9;
            int i15 = i11;
            while (i15 < i12) {
                byte b5 = bArr[i14];
                int i16 = i4;
                int i17 = b5 & 255;
                if (i17 != b4) {
                    int i18 = iArr2[i17];
                    if (i18 != 0) {
                        iArr[i15] = i18;
                    } else {
                        b4 = b5;
                    }
                }
                i14++;
                i15++;
                i4 = i16;
            }
            i9++;
            aVar2 = aVar;
        }
        if (this.f16723t == null && z3 && b4 != -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f16723t = Boolean.valueOf(z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(a aVar) {
        int i4;
        int i5;
        short s3;
        StandardGifDecoder standardGifDecoder = this;
        if (aVar != null) {
            standardGifDecoder.f16707d.position(aVar.f16734j);
        }
        if (aVar == null) {
            GifHeader gifHeader = standardGifDecoder.f16716m;
            i4 = gifHeader.f16691f;
            i5 = gifHeader.f16692g;
        } else {
            i4 = aVar.f16727c;
            i5 = aVar.f16728d;
        }
        int i6 = i4 * i5;
        byte[] bArr = standardGifDecoder.f16713j;
        if (bArr == null || bArr.length < i6) {
            standardGifDecoder.f16713j = standardGifDecoder.f16706c.obtainByteArray(i6);
        }
        byte[] bArr2 = standardGifDecoder.f16713j;
        if (standardGifDecoder.f16710g == null) {
            standardGifDecoder.f16710g = new short[4096];
        }
        short[] sArr = standardGifDecoder.f16710g;
        if (standardGifDecoder.f16711h == null) {
            standardGifDecoder.f16711h = new byte[4096];
        }
        byte[] bArr3 = standardGifDecoder.f16711h;
        if (standardGifDecoder.f16712i == null) {
            standardGifDecoder.f16712i = new byte[4097];
        }
        byte[] bArr4 = standardGifDecoder.f16712i;
        int h4 = h();
        int i7 = 1 << h4;
        int i8 = i7 + 1;
        int i9 = i7 + 2;
        int i10 = h4 + 1;
        int i11 = (1 << i10) - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < i7; i13++) {
            sArr[i13] = 0;
            bArr3[i13] = (byte) i13;
        }
        byte[] bArr5 = standardGifDecoder.f16708e;
        int i14 = i10;
        int i15 = i9;
        int i16 = i11;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        while (true) {
            if (i12 >= i6) {
                break;
            }
            if (i17 == 0) {
                i17 = g();
                if (i17 <= 0) {
                    standardGifDecoder.f16719p = 3;
                    break;
                }
                i18 = 0;
            }
            i20 += (bArr5[i18] & 255) << i19;
            i18++;
            i17--;
            int i25 = i19 + 8;
            int i26 = i15;
            int i27 = i14;
            int i28 = i22;
            int i29 = i10;
            int i30 = i23;
            while (true) {
                if (i25 >= i27) {
                    int i31 = i9;
                    int i32 = i20 & i16;
                    i20 >>= i27;
                    i25 -= i27;
                    if (i32 == i7) {
                        i16 = i11;
                        i27 = i29;
                        i26 = i31;
                        i9 = i26;
                        i28 = -1;
                    } else if (i32 == i8) {
                        i19 = i25;
                        i23 = i30;
                        i15 = i26;
                        i10 = i29;
                        i9 = i31;
                        i22 = i28;
                        i14 = i27;
                        standardGifDecoder = this;
                        break;
                    } else if (i28 == -1) {
                        bArr2[i21] = bArr3[i32];
                        i21++;
                        i12++;
                        i28 = i32;
                        i30 = i28;
                        i9 = i31;
                        i25 = i25;
                    } else {
                        if (i32 >= i26) {
                            bArr4[i24] = (byte) i30;
                            i24++;
                            s3 = i28;
                        } else {
                            s3 = i32;
                        }
                        while (s3 >= i7) {
                            bArr4[i24] = bArr3[s3];
                            i24++;
                            s3 = sArr[s3];
                        }
                        i30 = bArr3[s3] & 255;
                        byte b4 = (byte) i30;
                        bArr2[i21] = b4;
                        while (true) {
                            i21++;
                            i12++;
                            if (i24 <= 0) {
                                break;
                            }
                            i24--;
                            bArr2[i21] = bArr4[i24];
                        }
                        byte[] bArr6 = bArr4;
                        if (i26 < 4096) {
                            sArr[i26] = (short) i28;
                            bArr3[i26] = b4;
                            i26++;
                            if ((i26 & i16) == 0 && i26 < 4096) {
                                i27++;
                                i16 += i26;
                            }
                        }
                        i28 = i32;
                        i9 = i31;
                        i25 = i25;
                        bArr4 = bArr6;
                    }
                } else {
                    i22 = i28;
                    i15 = i26;
                    i19 = i25;
                    standardGifDecoder = this;
                    i23 = i30;
                    i10 = i29;
                    i14 = i27;
                    break;
                }
            }
        }
        Arrays.fill(bArr2, i21, i6, (byte) 0);
    }

    @NonNull
    private GifHeaderParser e() {
        if (this.f16709f == null) {
            this.f16709f = new GifHeaderParser();
        }
        return this.f16709f;
    }

    private Bitmap f() {
        Bitmap.Config config;
        Boolean bool = this.f16723t;
        if (bool != null && !bool.booleanValue()) {
            config = this.f16724u;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap obtain = this.f16706c.obtain(this.f16722s, this.f16721r, config);
        obtain.setHasAlpha(true);
        return obtain;
    }

    private int g() {
        int h4 = h();
        if (h4 <= 0) {
            return h4;
        }
        ByteBuffer byteBuffer = this.f16707d;
        byteBuffer.get(this.f16708e, 0, Math.min(h4, byteBuffer.remaining()));
        return h4;
    }

    private int h() {
        return this.f16707d.get() & 255;
    }

    private Bitmap i(a aVar, a aVar2) {
        int i4;
        int i5;
        Bitmap bitmap;
        int[] iArr = this.f16714k;
        int i6 = 0;
        if (aVar2 == null) {
            Bitmap bitmap2 = this.f16717n;
            if (bitmap2 != null) {
                this.f16706c.release(bitmap2);
            }
            this.f16717n = null;
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && aVar2.f16731g == 3 && this.f16717n == null) {
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && (i5 = aVar2.f16731g) > 0) {
            if (i5 == 2) {
                if (!aVar.f16730f) {
                    GifHeader gifHeader = this.f16716m;
                    int i7 = gifHeader.f16697l;
                    if (aVar.f16735k == null || gifHeader.f16695j != aVar.f16732h) {
                        i6 = i7;
                    }
                } else if (this.f16715l == 0) {
                    this.f16723t = Boolean.TRUE;
                }
                int i8 = aVar2.f16728d;
                int i9 = this.f16720q;
                int i10 = i8 / i9;
                int i11 = aVar2.f16726b / i9;
                int i12 = aVar2.f16727c / i9;
                int i13 = aVar2.f16725a / i9;
                int i14 = this.f16722s;
                int i15 = (i11 * i14) + i13;
                int i16 = (i10 * i14) + i15;
                while (i15 < i16) {
                    int i17 = i15 + i12;
                    for (int i18 = i15; i18 < i17; i18++) {
                        iArr[i18] = i6;
                    }
                    i15 += this.f16722s;
                }
            } else if (i5 == 3 && (bitmap = this.f16717n) != null) {
                int i19 = this.f16722s;
                bitmap.getPixels(iArr, 0, i19, 0, 0, i19, this.f16721r);
            }
        }
        d(aVar);
        if (!aVar.f16729e && this.f16720q == 1) {
            c(aVar);
        } else {
            b(aVar);
        }
        if (this.f16718o && ((i4 = aVar.f16731g) == 0 || i4 == 1)) {
            if (this.f16717n == null) {
                this.f16717n = f();
            }
            Bitmap bitmap3 = this.f16717n;
            int i20 = this.f16722s;
            bitmap3.setPixels(iArr, 0, i20, 0, 0, i20, this.f16721r);
        }
        Bitmap f4 = f();
        int i21 = this.f16722s;
        f4.setPixels(iArr, 0, i21, 0, 0, i21, this.f16721r);
        return f4;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.f16715l = (this.f16715l + 1) % this.f16716m.f16688c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.f16716m = null;
        byte[] bArr = this.f16713j;
        if (bArr != null) {
            this.f16706c.release(bArr);
        }
        int[] iArr = this.f16714k;
        if (iArr != null) {
            this.f16706c.release(iArr);
        }
        Bitmap bitmap = this.f16717n;
        if (bitmap != null) {
            this.f16706c.release(bitmap);
        }
        this.f16717n = null;
        this.f16707d = null;
        this.f16723t = null;
        byte[] bArr2 = this.f16708e;
        if (bArr2 != null) {
            this.f16706c.release(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return this.f16707d.limit() + this.f16713j.length + (this.f16714k.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.f16715l;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.f16707d;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int i4) {
        if (i4 >= 0) {
            GifHeader gifHeader = this.f16716m;
            if (i4 < gifHeader.f16688c) {
                return gifHeader.f16690e.get(i4).f16733i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.f16716m.f16688c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.f16716m.f16692g;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        int i4 = this.f16716m.f16698m;
        if (i4 == -1) {
            return 1;
        }
        return i4;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.f16716m.f16698m;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        int i4;
        if (this.f16716m.f16688c > 0 && (i4 = this.f16715l) >= 0) {
            return getDelay(i4);
        }
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap getNextFrame() {
        a aVar;
        if (this.f16716m.f16688c <= 0 || this.f16715l < 0) {
            if (Log.isLoggable(f16703v, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to decode frame, frameCount=");
                sb.append(this.f16716m.f16688c);
                sb.append(", framePointer=");
                sb.append(this.f16715l);
            }
            this.f16719p = 1;
        }
        int i4 = this.f16719p;
        if (i4 != 1 && i4 != 2) {
            this.f16719p = 0;
            if (this.f16708e == null) {
                this.f16708e = this.f16706c.obtainByteArray(255);
            }
            a aVar2 = this.f16716m.f16690e.get(this.f16715l);
            int i5 = this.f16715l - 1;
            if (i5 >= 0) {
                aVar = this.f16716m.f16690e.get(i5);
            } else {
                aVar = null;
            }
            int[] iArr = aVar2.f16735k;
            if (iArr == null) {
                iArr = this.f16716m.f16686a;
            }
            this.f16704a = iArr;
            if (iArr == null) {
                if (Log.isLoggable(f16703v, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("No valid color table found for frame #");
                    sb2.append(this.f16715l);
                }
                this.f16719p = 1;
                return null;
            }
            if (aVar2.f16730f) {
                System.arraycopy(iArr, 0, this.f16705b, 0, iArr.length);
                int[] iArr2 = this.f16705b;
                this.f16704a = iArr2;
                iArr2[aVar2.f16732h] = 0;
            }
            return i(aVar2, aVar);
        }
        if (Log.isLoggable(f16703v, 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to decode frame, status=");
            sb3.append(this.f16719p);
        }
        return null;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.f16719p;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int i4 = this.f16716m.f16698m;
        if (i4 == -1) {
            return 1;
        }
        if (i4 == 0) {
            return 0;
        }
        return i4 + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.f16716m.f16691f;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream inputStream, int i4) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i4 > 0 ? i4 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e4) {
                Log.w(f16703v, "Error reading data from stream", e4);
            }
        } else {
            this.f16719p = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                Log.w(f16703v, "Error closing stream", e5);
            }
        }
        return this.f16719p;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.f16715l = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.f16724u = config;
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i4) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.f16705b = new int[256];
        this.f16724u = Bitmap.Config.ARGB_8888;
        this.f16706c = bitmapProvider;
        this.f16716m = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i4) {
        if (i4 > 0) {
            int highestOneBit = Integer.highestOneBit(i4);
            this.f16719p = 0;
            this.f16716m = gifHeader;
            this.f16715l = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f16707d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f16707d.order(ByteOrder.LITTLE_ENDIAN);
            this.f16718o = false;
            Iterator<a> it = gifHeader.f16690e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f16731g == 3) {
                    this.f16718o = true;
                    break;
                }
            }
            this.f16720q = highestOneBit;
            int i5 = gifHeader.f16691f;
            this.f16722s = i5 / highestOneBit;
            int i6 = gifHeader.f16692g;
            this.f16721r = i6 / highestOneBit;
            this.f16713j = this.f16706c.obtainByteArray(i5 * i6);
            this.f16714k = this.f16706c.obtainIntArray(this.f16722s * this.f16721r);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i4);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        GifHeader parseHeader = e().setData(bArr).parseHeader();
        this.f16716m = parseHeader;
        if (bArr != null) {
            setData(parseHeader, bArr);
        }
        return this.f16719p;
    }
}
