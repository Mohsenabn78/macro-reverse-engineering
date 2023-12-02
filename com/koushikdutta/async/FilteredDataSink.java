package com.koushikdutta.async;

/* loaded from: classes6.dex */
public class FilteredDataSink extends BufferedDataSink {
    public FilteredDataSink(DataSink dataSink) {
        super(dataSink);
        setMaxBuffer(0);
    }

    @Override // com.koushikdutta.async.BufferedDataSink, com.koushikdutta.async.DataSink
    public final void write(ByteBufferList byteBufferList) {
        if (isBuffering() && getMaxBuffer() != Integer.MAX_VALUE) {
            return;
        }
        super.b(filter(byteBufferList), true);
        if (byteBufferList != null) {
            byteBufferList.recycle();
        }
    }

    public ByteBufferList filter(ByteBufferList byteBufferList) {
        return byteBufferList;
    }
}
