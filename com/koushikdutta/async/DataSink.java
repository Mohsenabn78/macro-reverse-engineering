package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;

/* loaded from: classes6.dex */
public interface DataSink {
    void end();

    CompletedCallback getClosedCallback();

    AsyncServer getServer();

    WritableCallback getWriteableCallback();

    boolean isOpen();

    void setClosedCallback(CompletedCallback completedCallback);

    void setWriteableCallback(WritableCallback writableCallback);

    void write(ByteBufferList byteBufferList);
}
