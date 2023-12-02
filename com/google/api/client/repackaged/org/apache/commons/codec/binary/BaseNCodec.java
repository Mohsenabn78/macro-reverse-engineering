package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import com.google.api.client.repackaged.org.apache.commons.codec.BinaryDecoder;
import com.google.api.client.repackaged.org.apache.commons.codec.BinaryEncoder;
import com.google.api.client.repackaged.org.apache.commons.codec.DecoderException;
import com.google.api.client.repackaged.org.apache.commons.codec.EncoderException;

/* loaded from: classes5.dex */
public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
    public static final int MIME_CHUNK_SIZE = 76;
    public static final int PEM_CHUNK_SIZE = 64;

    /* renamed from: a  reason: collision with root package name */
    protected final byte f26002a = kotlin.io.encoding.Base64.padSymbol;

    /* renamed from: b  reason: collision with root package name */
    private final int f26003b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26004c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f26005d;

    /* renamed from: e  reason: collision with root package name */
    private final int f26006e;

    /* renamed from: f  reason: collision with root package name */
    protected byte[] f26007f;

    /* renamed from: g  reason: collision with root package name */
    protected int f26008g;

    /* renamed from: h  reason: collision with root package name */
    private int f26009h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f26010i;

    /* renamed from: j  reason: collision with root package name */
    protected int f26011j;

    /* renamed from: k  reason: collision with root package name */
    protected int f26012k;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseNCodec(int i4, int i5, int i6, int i7) {
        int i8;
        this.f26003b = i4;
        this.f26004c = i5;
        if (i6 > 0 && i7 > 0) {
            i8 = (i6 / i5) * i5;
        } else {
            i8 = 0;
        }
        this.f26005d = i8;
        this.f26006e = i7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean h(byte b4) {
        if (b4 != 9 && b4 != 10 && b4 != 13 && b4 != 32) {
            return false;
        }
        return true;
    }

    private void j() {
        this.f26007f = null;
        this.f26008g = 0;
        this.f26009h = 0;
        this.f26011j = 0;
        this.f26012k = 0;
        this.f26010i = false;
    }

    private void k() {
        byte[] bArr = this.f26007f;
        if (bArr == null) {
            this.f26007f = new byte[f()];
            this.f26008g = 0;
            this.f26009h = 0;
            return;
        }
        byte[] bArr2 = new byte[bArr.length * 2];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f26007f = bArr2;
    }

    int a() {
        if (this.f26007f != null) {
            return this.f26008g - this.f26009h;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b4 : bArr) {
            if (61 == b4 || g(b4)) {
                return true;
            }
        }
        return false;
    }

    abstract void c(byte[] bArr, int i4, int i5);

    abstract void d(byte[] bArr, int i4, int i5);

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i4) {
        byte[] bArr = this.f26007f;
        if (bArr == null || bArr.length < this.f26008g + i4) {
            k();
        }
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public String encodeAsString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    protected int f() {
        return 8192;
    }

    protected abstract boolean g(byte b4);

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i4 = this.f26003b;
        long j4 = (((length + i4) - 1) / i4) * this.f26004c;
        int i5 = this.f26005d;
        if (i5 > 0) {
            return j4 + ((((i5 + j4) - 1) / i5) * this.f26006e);
        }
        return j4;
    }

    int i(byte[] bArr, int i4, int i5) {
        if (this.f26007f != null) {
            int min = Math.min(a(), i5);
            System.arraycopy(this.f26007f, this.f26009h, bArr, i4, min);
            int i6 = this.f26009h + min;
            this.f26009h = i6;
            if (i6 >= this.f26008g) {
                this.f26007f = null;
            }
            return min;
        } else if (this.f26010i) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean isInAlphabet(byte[] bArr, boolean z3) {
        byte b4;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            if (!g(bArr[i4]) && (!z3 || ((b4 = bArr[i4]) != 61 && !h(b4)))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(StringUtils.getBytesUtf8(str), true);
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        j();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        d(bArr, 0, bArr.length);
        d(bArr, 0, -1);
        int i4 = this.f26008g - this.f26009h;
        byte[] bArr2 = new byte[i4];
        i(bArr2, 0, i4);
        return bArr2;
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        j();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        c(bArr, 0, bArr.length);
        c(bArr, 0, -1);
        int i4 = this.f26008g;
        byte[] bArr2 = new byte[i4];
        i(bArr2, 0, i4);
        return bArr2;
    }
}
