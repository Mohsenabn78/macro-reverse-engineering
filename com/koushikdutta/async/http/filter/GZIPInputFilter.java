package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.PushParser;
import com.koushikdutta.async.callback.DataCallback;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.UShort;

/* loaded from: classes6.dex */
public class GZIPInputFilter extends InflaterInputFilter {

    /* renamed from: j  reason: collision with root package name */
    boolean f35276j;

    /* renamed from: k  reason: collision with root package name */
    protected CRC32 f35277k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements PushParser.ParseCallback<byte[]> {

        /* renamed from: a  reason: collision with root package name */
        int f35278a;

        /* renamed from: b  reason: collision with root package name */
        boolean f35279b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DataEmitter f35280c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PushParser f35281d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.koushikdutta.async.http.filter.GZIPInputFilter$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0190a implements PushParser.ParseCallback<byte[]> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.koushikdutta.async.http.filter.GZIPInputFilter$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0191a implements PushParser.ParseCallback<byte[]> {
                C0191a() {
                }

                @Override // com.koushikdutta.async.PushParser.ParseCallback
                /* renamed from: a */
                public void parsed(byte[] bArr) {
                    a aVar = a.this;
                    if (aVar.f35279b) {
                        GZIPInputFilter.this.f35277k.update(bArr, 0, bArr.length);
                    }
                    a.this.d();
                }
            }

            C0190a() {
            }

            @Override // com.koushikdutta.async.PushParser.ParseCallback
            /* renamed from: a */
            public void parsed(byte[] bArr) {
                a aVar = a.this;
                if (aVar.f35279b) {
                    GZIPInputFilter.this.f35277k.update(bArr, 0, 2);
                }
                a.this.f35281d.readByteArray(GZIPInputFilter.b(bArr, 0, ByteOrder.LITTLE_ENDIAN) & UShort.MAX_VALUE, new C0191a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class b implements DataCallback {
            b() {
            }

            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                if (a.this.f35279b) {
                    while (byteBufferList.size() > 0) {
                        ByteBuffer remove = byteBufferList.remove();
                        GZIPInputFilter.this.f35277k.update(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                        ByteBufferList.reclaim(remove);
                    }
                }
                byteBufferList.recycle();
                a.this.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class c implements PushParser.ParseCallback<byte[]> {
            c() {
            }

            @Override // com.koushikdutta.async.PushParser.ParseCallback
            /* renamed from: a */
            public void parsed(byte[] bArr) {
                if (((short) GZIPInputFilter.this.f35277k.getValue()) != GZIPInputFilter.b(bArr, 0, ByteOrder.LITTLE_ENDIAN)) {
                    GZIPInputFilter.this.a(new IOException("CRC mismatch"));
                    return;
                }
                GZIPInputFilter.this.f35277k.reset();
                a aVar = a.this;
                GZIPInputFilter gZIPInputFilter = GZIPInputFilter.this;
                gZIPInputFilter.f35276j = false;
                gZIPInputFilter.setDataEmitter(aVar.f35280c);
            }
        }

        a(DataEmitter dataEmitter, PushParser pushParser) {
            this.f35280c = dataEmitter;
            this.f35281d = pushParser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (this.f35279b) {
                this.f35281d.readByteArray(2, new c());
                return;
            }
            GZIPInputFilter gZIPInputFilter = GZIPInputFilter.this;
            gZIPInputFilter.f35276j = false;
            gZIPInputFilter.setDataEmitter(this.f35280c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            PushParser pushParser = new PushParser(this.f35280c);
            b bVar = new b();
            int i4 = this.f35278a;
            if ((i4 & 8) != 0) {
                pushParser.until((byte) 0, bVar);
            } else if ((i4 & 16) != 0) {
                pushParser.until((byte) 0, bVar);
            } else {
                c();
            }
        }

        @Override // com.koushikdutta.async.PushParser.ParseCallback
        /* renamed from: e */
        public void parsed(byte[] bArr) {
            short b4 = GZIPInputFilter.b(bArr, 0, ByteOrder.LITTLE_ENDIAN);
            boolean z3 = true;
            if (b4 != -29921) {
                GZIPInputFilter.this.a(new IOException(String.format(Locale.ENGLISH, "unknown format (magic number %x)", Short.valueOf(b4))));
                this.f35280c.setDataCallback(new DataCallback.NullDataCallback());
                return;
            }
            byte b5 = bArr[3];
            this.f35278a = b5;
            if ((b5 & 2) == 0) {
                z3 = false;
            }
            this.f35279b = z3;
            if (z3) {
                GZIPInputFilter.this.f35277k.update(bArr, 0, bArr.length);
            }
            if ((this.f35278a & 4) != 0) {
                this.f35281d.readByteArray(2, new C0190a());
            } else {
                d();
            }
        }
    }

    public GZIPInputFilter() {
        super(new Inflater(true));
        this.f35276j = true;
        this.f35277k = new CRC32();
    }

    static short b(byte[] bArr, int i4, ByteOrder byteOrder) {
        int i5;
        byte b4;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i5 = bArr[i4] << 8;
            b4 = bArr[i4 + 1];
        } else {
            i5 = bArr[i4 + 1] << 8;
            b4 = bArr[i4];
        }
        return (short) ((b4 & 255) | i5);
    }

    public static int unsignedToBytes(byte b4) {
        return b4 & 255;
    }

    @Override // com.koushikdutta.async.http.filter.InflaterInputFilter, com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (this.f35276j) {
            PushParser pushParser = new PushParser(dataEmitter);
            pushParser.readByteArray(10, new a(dataEmitter, pushParser));
            return;
        }
        super.onDataAvailable(dataEmitter, byteBufferList);
    }
}
