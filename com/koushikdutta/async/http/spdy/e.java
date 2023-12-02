package com.koushikdutta.async.http.spdy;

import com.koushikdutta.async.ByteBufferList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: HeaderReader.java */
/* loaded from: classes6.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    Inflater f35544a = new a();

    /* compiled from: HeaderReader.java */
    /* loaded from: classes6.dex */
    class a extends Inflater {
        a() {
        }

        @Override // java.util.zip.Inflater
        public int inflate(byte[] bArr, int i4, int i5) throws DataFormatException {
            int inflate = super.inflate(bArr, i4, i5);
            if (inflate == 0 && needsDictionary()) {
                setDictionary(k.f35600a);
                return super.inflate(bArr, i4, i5);
            }
            return inflate;
        }
    }

    private static com.koushikdutta.async.http.spdy.a a(ByteBufferList byteBufferList) {
        return com.koushikdutta.async.http.spdy.a.e(byteBufferList.getBytes(byteBufferList.getInt()));
    }

    public List<d> b(ByteBufferList byteBufferList, int i4) throws IOException {
        byte[] bArr = new byte[i4];
        byteBufferList.get(bArr);
        this.f35544a.setInput(bArr);
        ByteBufferList order = new ByteBufferList().order(ByteOrder.BIG_ENDIAN);
        while (!this.f35544a.needsInput()) {
            ByteBuffer obtain = ByteBufferList.obtain(8192);
            try {
                obtain.limit(this.f35544a.inflate(obtain.array()));
                order.add(obtain);
            } catch (DataFormatException e4) {
                throw new IOException(e4);
            }
        }
        int i5 = order.getInt();
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            com.koushikdutta.async.http.spdy.a h4 = a(order).h();
            com.koushikdutta.async.http.spdy.a a4 = a(order);
            if (h4.g() != 0) {
                arrayList.add(new d(h4, a4));
            } else {
                throw new IOException("name.size == 0");
            }
        }
        return arrayList;
    }
}
