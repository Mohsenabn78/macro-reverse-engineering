package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.Util;
import java.nio.ByteBuffer;
import java.util.zip.Inflater;

/* loaded from: classes6.dex */
public class InflaterInputFilter extends FilteredDataEmitter {

    /* renamed from: h  reason: collision with root package name */
    private Inflater f35287h;

    /* renamed from: i  reason: collision with root package name */
    ByteBufferList f35288i;

    public InflaterInputFilter() {
        this(new Inflater());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.DataEmitterBase
    public void a(Exception exc) {
        this.f35287h.end();
        if (exc != null && this.f35287h.getRemaining() > 0) {
            exc = new DataRemainingException("data still remaining in inflater", exc);
        }
        super.a(exc);
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        try {
            ByteBuffer obtain = ByteBufferList.obtain(byteBufferList.remaining() * 2);
            while (byteBufferList.size() > 0) {
                ByteBuffer remove = byteBufferList.remove();
                if (remove.hasRemaining()) {
                    remove.remaining();
                    this.f35287h.setInput(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                    do {
                        obtain.position(obtain.position() + this.f35287h.inflate(obtain.array(), obtain.arrayOffset() + obtain.position(), obtain.remaining()));
                        if (!obtain.hasRemaining()) {
                            obtain.flip();
                            this.f35288i.add(obtain);
                            obtain = ByteBufferList.obtain(obtain.capacity() * 2);
                        }
                        if (!this.f35287h.needsInput()) {
                        }
                    } while (!this.f35287h.finished());
                }
                ByteBufferList.reclaim(remove);
            }
            obtain.flip();
            this.f35288i.add(obtain);
            Util.emitAllData(this, this.f35288i);
        } catch (Exception e4) {
            a(e4);
        }
    }

    public InflaterInputFilter(Inflater inflater) {
        this.f35288i = new ByteBufferList();
        this.f35287h = inflater;
    }
}
