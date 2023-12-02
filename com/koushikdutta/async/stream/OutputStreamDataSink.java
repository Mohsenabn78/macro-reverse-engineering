package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class OutputStreamDataSink implements DataSink {

    /* renamed from: a  reason: collision with root package name */
    AsyncServer f35659a;

    /* renamed from: b  reason: collision with root package name */
    OutputStream f35660b;

    /* renamed from: c  reason: collision with root package name */
    WritableCallback f35661c;

    /* renamed from: d  reason: collision with root package name */
    boolean f35662d;

    /* renamed from: e  reason: collision with root package name */
    Exception f35663e;

    /* renamed from: f  reason: collision with root package name */
    CompletedCallback f35664f;

    /* renamed from: g  reason: collision with root package name */
    WritableCallback f35665g;

    public OutputStreamDataSink(AsyncServer asyncServer) {
        this(asyncServer, null);
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        try {
            OutputStream outputStream = this.f35660b;
            if (outputStream != null) {
                outputStream.close();
            }
            reportClose(null);
        } catch (IOException e4) {
            reportClose(e4);
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.f35664f;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f35660b;
    }

    @Override // com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f35659a;
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.f35661c;
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        return this.f35662d;
    }

    public void reportClose(Exception exc) {
        if (this.f35662d) {
            return;
        }
        this.f35662d = true;
        this.f35663e = exc;
        CompletedCallback completedCallback = this.f35664f;
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f35664f = completedCallback;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.f35660b = outputStream;
    }

    public void setOutputStreamWritableCallback(WritableCallback writableCallback) {
        this.f35665g = writableCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f35661c = writableCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        while (byteBufferList.size() > 0) {
            try {
                try {
                    ByteBuffer remove = byteBufferList.remove();
                    getOutputStream().write(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                    ByteBufferList.reclaim(remove);
                } catch (IOException e4) {
                    reportClose(e4);
                }
            } finally {
                byteBufferList.recycle();
            }
        }
    }

    public OutputStreamDataSink(AsyncServer asyncServer, OutputStream outputStream) {
        this.f35659a = asyncServer;
        setOutputStream(outputStream);
    }
}
