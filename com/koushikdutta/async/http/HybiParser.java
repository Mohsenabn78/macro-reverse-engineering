package com.koushikdutta.async.http;

import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataEmitterReader;
import com.koushikdutta.async.callback.DataCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes6.dex */
abstract class HybiParser {

    /* renamed from: w  reason: collision with root package name */
    private static final List<Integer> f35039w = Arrays.asList(0, 1, 2, 8, 9, 10);

    /* renamed from: x  reason: collision with root package name */
    private static final List<Integer> f35040x = Arrays.asList(0, 1, 2);

    /* renamed from: c  reason: collision with root package name */
    private int f35043c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f35044d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f35045e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f35046f;

    /* renamed from: g  reason: collision with root package name */
    private int f35047g;

    /* renamed from: h  reason: collision with root package name */
    private int f35048h;

    /* renamed from: i  reason: collision with root package name */
    private int f35049i;

    /* renamed from: j  reason: collision with root package name */
    private int f35050j;

    /* renamed from: v  reason: collision with root package name */
    private DataEmitterReader f35062v;

    /* renamed from: a  reason: collision with root package name */
    private boolean f35041a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f35042b = false;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f35051k = new byte[0];

    /* renamed from: l  reason: collision with root package name */
    private byte[] f35052l = new byte[0];

    /* renamed from: m  reason: collision with root package name */
    private boolean f35053m = false;

    /* renamed from: n  reason: collision with root package name */
    private ByteArrayOutputStream f35054n = new ByteArrayOutputStream();

    /* renamed from: o  reason: collision with root package name */
    private Inflater f35055o = new Inflater(true);

    /* renamed from: p  reason: collision with root package name */
    private byte[] f35056p = new byte[4096];

    /* renamed from: q  reason: collision with root package name */
    DataCallback f35057q = new a();

    /* renamed from: r  reason: collision with root package name */
    DataCallback f35058r = new b();

    /* renamed from: s  reason: collision with root package name */
    DataCallback f35059s = new c();

    /* renamed from: t  reason: collision with root package name */
    DataCallback f35060t = new d();

    /* renamed from: u  reason: collision with root package name */
    DataCallback f35061u = new e();

    /* loaded from: classes6.dex */
    public static class ProtocolError extends IOException {
        public ProtocolError(String str) {
            super(str);
        }
    }

    /* loaded from: classes6.dex */
    class a implements DataCallback {
        a() {
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            try {
                HybiParser.this.G(byteBufferList.get());
            } catch (ProtocolError e4) {
                HybiParser.this.J(e4);
                e4.printStackTrace();
            }
            HybiParser.this.D();
        }
    }

    /* loaded from: classes6.dex */
    class b implements DataCallback {
        b() {
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            HybiParser.this.F(byteBufferList.get());
            HybiParser.this.D();
        }
    }

    /* loaded from: classes6.dex */
    class c implements DataCallback {
        c() {
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[HybiParser.this.f35048h];
            byteBufferList.get(bArr);
            try {
                HybiParser.this.E(bArr);
            } catch (ProtocolError e4) {
                HybiParser.this.J(e4);
                e4.printStackTrace();
            }
            HybiParser.this.D();
        }
    }

    /* loaded from: classes6.dex */
    class d implements DataCallback {
        d() {
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            HybiParser.this.f35051k = new byte[4];
            byteBufferList.get(HybiParser.this.f35051k);
            HybiParser.this.f35043c = 4;
            HybiParser.this.D();
        }
    }

    /* loaded from: classes6.dex */
    class e implements DataCallback {
        e() {
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            HybiParser hybiParser = HybiParser.this;
            hybiParser.f35052l = new byte[hybiParser.f35049i];
            byteBufferList.get(HybiParser.this.f35052l);
            try {
                HybiParser.this.n();
            } catch (IOException e4) {
                HybiParser.this.J(e4);
                e4.printStackTrace();
            }
            HybiParser.this.f35043c = 0;
            HybiParser.this.D();
        }
    }

    public HybiParser(DataEmitter dataEmitter) {
        DataEmitterReader dataEmitterReader = new DataEmitterReader();
        this.f35062v = dataEmitterReader;
        dataEmitter.setDataCallback(dataEmitterReader);
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(byte[] bArr) throws ProtocolError {
        int i4;
        this.f35049i = v(bArr);
        if (this.f35045e) {
            i4 = 3;
        } else {
            i4 = 4;
        }
        this.f35043c = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(byte b4) {
        boolean z3;
        int i4;
        int i5;
        if ((b4 & 128) == 128) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f35045e = z3;
        int i6 = b4 & Byte.MAX_VALUE;
        this.f35049i = i6;
        if (i6 >= 0 && i6 <= 125) {
            if (z3) {
                i5 = 3;
            } else {
                i5 = 4;
            }
            this.f35043c = i5;
            return;
        }
        if (i6 == 126) {
            i4 = 2;
        } else {
            i4 = 8;
        }
        this.f35048h = i4;
        this.f35043c = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(byte b4) throws ProtocolError {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if ((b4 & SignedBytes.MAX_POWER_OF_TWO) == 64) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((b4 & 32) == 32) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((b4 & Ascii.DLE) == 16) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((this.f35042b || !z3) && !z4 && !z5) {
            if ((b4 & 128) == 128) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f35044d = z6;
            int i4 = b4 & Ascii.SI;
            this.f35047g = i4;
            this.f35046f = z3;
            this.f35051k = new byte[0];
            this.f35052l = new byte[0];
            if (f35039w.contains(Integer.valueOf(i4))) {
                if (!f35040x.contains(Integer.valueOf(this.f35047g)) && !this.f35044d) {
                    throw new ProtocolError("Expected non-final packet");
                }
                this.f35043c = 1;
                return;
            }
            throw new ProtocolError("Bad opcode");
        }
        throw new ProtocolError("RSV not zero");
    }

    private void K() {
        this.f35050j = 0;
        this.f35054n.reset();
    }

    private byte[] O(byte[] bArr, int i4) {
        byte[] bArr2 = new byte[bArr.length - i4];
        System.arraycopy(bArr, i4, bArr2, 0, bArr.length - i4);
        return bArr2;
    }

    private static long l(byte[] bArr, int i4, int i5) {
        if (bArr.length >= i5) {
            long j4 = 0;
            for (int i6 = 0; i6 < i5; i6++) {
                j4 += (bArr[i6 + i4] & 255) << (((i5 - 1) - i6) * 8);
            }
            return j4;
        }
        throw new IllegalArgumentException("length must be less than or equal to b.length");
    }

    private byte[] m(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() throws IOException {
        String str;
        int i4 = 0;
        byte[] x3 = x(this.f35052l, this.f35051k, 0);
        if (this.f35046f) {
            try {
                x3 = w(x3);
            } catch (DataFormatException unused) {
                throw new IOException("Invalid deflated data");
            }
        }
        int i5 = this.f35047g;
        if (i5 == 0) {
            if (this.f35050j != 0) {
                this.f35054n.write(x3);
                if (this.f35044d) {
                    byte[] byteArray = this.f35054n.toByteArray();
                    if (this.f35050j == 1) {
                        z(o(byteArray));
                    } else {
                        A(byteArray);
                    }
                    K();
                    return;
                }
                return;
            }
            throw new ProtocolError("Mode was not set.");
        } else if (i5 == 1) {
            if (this.f35044d) {
                z(o(x3));
                return;
            }
            this.f35050j = 1;
            this.f35054n.write(x3);
        } else if (i5 == 2) {
            if (this.f35044d) {
                A(x3);
                return;
            }
            this.f35050j = 2;
            this.f35054n.write(x3);
        } else if (i5 == 8) {
            if (x3.length >= 2) {
                i4 = (x3[1] & 255) + ((x3[0] & 255) * 256);
            }
            if (x3.length > 2) {
                str = o(O(x3, 2));
            } else {
                str = null;
            }
            y(i4, str);
        } else if (i5 == 9) {
            if (x3.length <= 125) {
                String o4 = o(x3);
                L(q(10, x3, -1));
                B(o4);
                return;
            }
            throw new ProtocolError("Ping payload too large");
        } else if (i5 == 10) {
            C(o(x3));
        }
    }

    private String o(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException(e4);
        }
    }

    private byte[] p(int i4, String str, int i5) {
        return q(i4, m(str), i5);
    }

    private byte[] q(int i4, byte[] bArr, int i5) {
        return r(i4, bArr, i5, 0, bArr.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] r(int r22, byte[] r23, int r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.HybiParser.r(int, byte[], int, int, int):byte[]");
    }

    private int v(byte[] bArr) throws ProtocolError {
        long l4 = l(bArr, 0, bArr.length);
        if (l4 >= 0 && l4 <= 2147483647L) {
            return (int) l4;
        }
        throw new ProtocolError("Bad integer: " + l4);
    }

    private byte[] w(byte[] bArr) throws DataFormatException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f35055o.setInput(bArr);
        while (!this.f35055o.needsInput()) {
            byteArrayOutputStream.write(this.f35056p, 0, this.f35055o.inflate(this.f35056p));
        }
        this.f35055o.setInput(new byte[]{0, 0, -1, -1});
        while (!this.f35055o.needsInput()) {
            byteArrayOutputStream.write(this.f35056p, 0, this.f35055o.inflate(this.f35056p));
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] x(byte[] bArr, byte[] bArr2, int i4) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i5 = 0; i5 < bArr.length - i4; i5++) {
            int i6 = i4 + i5;
            bArr[i6] = (byte) (bArr[i6] ^ bArr2[i5 % 4]);
        }
        return bArr;
    }

    protected abstract void A(byte[] bArr);

    protected abstract void B(String str);

    protected abstract void C(String str);

    void D() {
        int i4 = this.f35043c;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            this.f35062v.read(this.f35049i, this.f35061u);
                            return;
                        }
                        return;
                    }
                    this.f35062v.read(4, this.f35060t);
                    return;
                }
                this.f35062v.read(this.f35048h, this.f35059s);
                return;
            }
            this.f35062v.read(1, this.f35058r);
            return;
        }
        this.f35062v.read(1, this.f35057q);
    }

    public byte[] H(String str) {
        return p(9, str, -1);
    }

    public byte[] I(String str) {
        return p(10, str, -1);
    }

    protected abstract void J(Exception exc);

    protected abstract void L(byte[] bArr);

    public void M(boolean z3) {
        this.f35042b = z3;
    }

    public void N(boolean z3) {
        this.f35041a = z3;
    }

    protected void finalize() throws Throwable {
        Inflater inflater = this.f35055o;
        if (inflater != null) {
            try {
                inflater.end();
            } catch (Exception e4) {
                Log.e("HybiParser", "inflater.end failed", e4);
            }
        }
        super.finalize();
    }

    public byte[] s(String str) {
        return p(1, str, -1);
    }

    public byte[] t(byte[] bArr) {
        return q(2, bArr, -1);
    }

    public byte[] u(byte[] bArr, int i4, int i5) {
        return r(2, bArr, -1, i4, i5);
    }

    protected abstract void y(int i4, String str);

    protected abstract void z(String str);
}
