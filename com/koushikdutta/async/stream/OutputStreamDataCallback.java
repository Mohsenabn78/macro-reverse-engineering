package com.koushikdutta.async.stream;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class OutputStreamDataCallback implements DataCallback, CompletedCallback {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f35658a;

    public OutputStreamDataCallback(OutputStream outputStream) {
        this.f35658a = outputStream;
    }

    public void close() {
        try {
            this.f35658a.close();
        } catch (IOException e4) {
            onCompleted(e4);
        }
    }

    public OutputStream getOutputStream() {
        return this.f35658a;
    }

    @Override // com.koushikdutta.async.callback.CompletedCallback
    public void onCompleted(Exception exc) {
        exc.printStackTrace();
    }

    @Override // com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        while (byteBufferList.size() > 0) {
            try {
                try {
                    ByteBuffer remove = byteBufferList.remove();
                    this.f35658a.write(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                    ByteBufferList.reclaim(remove);
                } catch (Exception e4) {
                    onCompleted(e4);
                }
            } finally {
                byteBufferList.recycle();
            }
        }
    }
}
