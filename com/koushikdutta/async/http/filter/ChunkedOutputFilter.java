package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.FilteredDataSink;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class ChunkedOutputFilter extends FilteredDataSink {
    public ChunkedOutputFilter(DataSink dataSink) {
        super(dataSink);
    }

    @Override // com.koushikdutta.async.BufferedDataSink, com.koushikdutta.async.DataSink
    public void end() {
        setMaxBuffer(Integer.MAX_VALUE);
        write(new ByteBufferList());
        setMaxBuffer(0);
    }

    @Override // com.koushikdutta.async.FilteredDataSink
    public ByteBufferList filter(ByteBufferList byteBufferList) {
        byteBufferList.addFirst(ByteBuffer.wrap((Integer.toString(byteBufferList.remaining(), 16) + "\r\n").getBytes()));
        byteBufferList.add(ByteBuffer.wrap("\r\n".getBytes()));
        return byteBufferList;
    }
}
