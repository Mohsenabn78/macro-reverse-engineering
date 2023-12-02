package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class GifHeaderParser {

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f16700b;

    /* renamed from: c  reason: collision with root package name */
    private GifHeader f16701c;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f16699a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    private int f16702d = 0;

    private boolean a() {
        if (this.f16701c.f16687b != 0) {
            return true;
        }
        return false;
    }

    private int b() {
        try {
            return this.f16700b.get() & 255;
        } catch (Exception unused) {
            this.f16701c.f16687b = 1;
            return 0;
        }
    }

    private void c() {
        boolean z3;
        this.f16701c.f16689d.f16725a = l();
        this.f16701c.f16689d.f16726b = l();
        this.f16701c.f16689d.f16727c = l();
        this.f16701c.f16689d.f16728d = l();
        int b4 = b();
        boolean z4 = false;
        if ((b4 & 128) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int pow = (int) Math.pow(2.0d, (b4 & 7) + 1);
        a aVar = this.f16701c.f16689d;
        if ((b4 & 64) != 0) {
            z4 = true;
        }
        aVar.f16729e = z4;
        if (z3) {
            aVar.f16735k = e(pow);
        } else {
            aVar.f16735k = null;
        }
        this.f16701c.f16689d.f16734j = this.f16700b.position();
        o();
        if (a()) {
            return;
        }
        GifHeader gifHeader = this.f16701c;
        gifHeader.f16688c++;
        gifHeader.f16690e.add(gifHeader.f16689d);
    }

    private void d() {
        int b4 = b();
        this.f16702d = b4;
        if (b4 > 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                try {
                    i5 = this.f16702d;
                    if (i4 < i5) {
                        i5 -= i4;
                        this.f16700b.get(this.f16699a, i4, i5);
                        i4 += i5;
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error Reading Block n: ");
                        sb.append(i4);
                        sb.append(" count: ");
                        sb.append(i5);
                        sb.append(" blockSize: ");
                        sb.append(this.f16702d);
                    }
                    this.f16701c.f16687b = 1;
                    return;
                }
            }
        }
    }

    @Nullable
    private int[] e(int i4) {
        byte[] bArr = new byte[i4 * 3];
        int[] iArr = null;
        try {
            this.f16700b.get(bArr);
            iArr = new int[256];
            int i5 = 0;
            int i6 = 0;
            while (i5 < i4) {
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int i9 = i8 + 1;
                int i10 = i5 + 1;
                iArr[i5] = ((bArr[i6] & 255) << 16) | (-16777216) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
                i6 = i9;
                i5 = i10;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.f16701c.f16687b = 1;
        }
        return iArr;
    }

    private void f() {
        g(Integer.MAX_VALUE);
    }

    private void g(int i4) {
        boolean z3 = false;
        while (!z3 && !a() && this.f16701c.f16688c <= i4) {
            int b4 = b();
            if (b4 != 33) {
                if (b4 != 44) {
                    if (b4 != 59) {
                        this.f16701c.f16687b = 1;
                    } else {
                        z3 = true;
                    }
                } else {
                    GifHeader gifHeader = this.f16701c;
                    if (gifHeader.f16689d == null) {
                        gifHeader.f16689d = new a();
                    }
                    c();
                }
            } else {
                int b5 = b();
                if (b5 != 1) {
                    if (b5 != 249) {
                        if (b5 != 254) {
                            if (b5 != 255) {
                                n();
                            } else {
                                d();
                                StringBuilder sb = new StringBuilder();
                                for (int i5 = 0; i5 < 11; i5++) {
                                    sb.append((char) this.f16699a[i5]);
                                }
                                if (sb.toString().equals("NETSCAPE2.0")) {
                                    k();
                                } else {
                                    n();
                                }
                            }
                        } else {
                            n();
                        }
                    } else {
                        this.f16701c.f16689d = new a();
                        h();
                    }
                } else {
                    n();
                }
            }
        }
    }

    private void h() {
        b();
        int b4 = b();
        a aVar = this.f16701c.f16689d;
        int i4 = (b4 & 28) >> 2;
        aVar.f16731g = i4;
        boolean z3 = true;
        if (i4 == 0) {
            aVar.f16731g = 1;
        }
        if ((b4 & 1) == 0) {
            z3 = false;
        }
        aVar.f16730f = z3;
        int l4 = l();
        if (l4 < 2) {
            l4 = 10;
        }
        a aVar2 = this.f16701c.f16689d;
        aVar2.f16733i = l4 * 10;
        aVar2.f16732h = b();
        b();
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 6; i4++) {
            sb.append((char) b());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f16701c.f16687b = 1;
            return;
        }
        j();
        if (this.f16701c.f16693h && !a()) {
            GifHeader gifHeader = this.f16701c;
            gifHeader.f16686a = e(gifHeader.f16694i);
            GifHeader gifHeader2 = this.f16701c;
            gifHeader2.f16697l = gifHeader2.f16686a[gifHeader2.f16695j];
        }
    }

    private void j() {
        boolean z3;
        this.f16701c.f16691f = l();
        this.f16701c.f16692g = l();
        int b4 = b();
        GifHeader gifHeader = this.f16701c;
        if ((b4 & 128) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        gifHeader.f16693h = z3;
        gifHeader.f16694i = (int) Math.pow(2.0d, (b4 & 7) + 1);
        this.f16701c.f16695j = b();
        this.f16701c.f16696k = b();
    }

    private void k() {
        do {
            d();
            byte[] bArr = this.f16699a;
            if (bArr[0] == 1) {
                this.f16701c.f16698m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f16702d <= 0) {
                return;
            }
        } while (!a());
    }

    private int l() {
        return this.f16700b.getShort();
    }

    private void m() {
        this.f16700b = null;
        Arrays.fill(this.f16699a, (byte) 0);
        this.f16701c = new GifHeader();
        this.f16702d = 0;
    }

    private void n() {
        int b4;
        do {
            b4 = b();
            this.f16700b.position(Math.min(this.f16700b.position() + b4, this.f16700b.limit()));
        } while (b4 > 0);
    }

    private void o() {
        b();
        n();
    }

    public void clear() {
        this.f16700b = null;
        this.f16701c = null;
    }

    public boolean isAnimated() {
        i();
        if (!a()) {
            g(2);
        }
        if (this.f16701c.f16688c > 1) {
            return true;
        }
        return false;
    }

    @NonNull
    public GifHeader parseHeader() {
        if (this.f16700b != null) {
            if (a()) {
                return this.f16701c;
            }
            i();
            if (!a()) {
                f();
                GifHeader gifHeader = this.f16701c;
                if (gifHeader.f16688c < 0) {
                    gifHeader.f16687b = 1;
                }
            }
            return this.f16701c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public GifHeaderParser setData(@NonNull ByteBuffer byteBuffer) {
        m();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f16700b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f16700b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser setData(@Nullable byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
        } else {
            this.f16700b = null;
            this.f16701c.f16687b = 2;
        }
        return this;
    }
}
