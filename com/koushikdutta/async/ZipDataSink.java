package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes6.dex */
public class ZipDataSink extends FilteredDataSink {

    /* renamed from: g  reason: collision with root package name */
    ByteArrayOutputStream f34847g;

    /* renamed from: h  reason: collision with root package name */
    ZipOutputStream f34848h;

    public ZipDataSink(DataSink dataSink) {
        super(dataSink);
        this.f34847g = new ByteArrayOutputStream();
        this.f34848h = new ZipOutputStream(this.f34847g);
    }

    public void closeEntry() throws IOException {
        this.f34848h.closeEntry();
    }

    protected void d(Exception exc) {
        CompletedCallback closedCallback = getClosedCallback();
        if (closedCallback != null) {
            closedCallback.onCompleted(exc);
        }
    }

    @Override // com.koushikdutta.async.BufferedDataSink, com.koushikdutta.async.DataSink
    public void end() {
        try {
            this.f34848h.close();
            setMaxBuffer(Integer.MAX_VALUE);
            write(new ByteBufferList());
            super.end();
        } catch (IOException e4) {
            d(e4);
        }
    }

    @Override // com.koushikdutta.async.FilteredDataSink
    public ByteBufferList filter(ByteBufferList byteBufferList) {
        if (byteBufferList != null) {
            while (byteBufferList.size() > 0) {
                try {
                    try {
                        ByteBuffer remove = byteBufferList.remove();
                        ByteBufferList.writeOutputStream(this.f34848h, remove);
                        ByteBufferList.reclaim(remove);
                    } catch (IOException e4) {
                        d(e4);
                        if (byteBufferList != null) {
                            byteBufferList.recycle();
                            return null;
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    if (byteBufferList != null) {
                        byteBufferList.recycle();
                    }
                    throw th;
                }
            }
        }
        ByteBufferList byteBufferList2 = new ByteBufferList(this.f34847g.toByteArray());
        this.f34847g.reset();
        if (byteBufferList != null) {
            byteBufferList.recycle();
        }
        return byteBufferList2;
    }

    public void putNextEntry(ZipEntry zipEntry) throws IOException {
        this.f34848h.putNextEntry(zipEntry);
    }
}
