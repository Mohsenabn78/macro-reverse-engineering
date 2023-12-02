package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public class LineEmitter implements DataCallback {

    /* renamed from: a  reason: collision with root package name */
    Charset f34787a;

    /* renamed from: b  reason: collision with root package name */
    ByteBufferList f34788b;

    /* renamed from: c  reason: collision with root package name */
    StringCallback f34789c;

    /* loaded from: classes6.dex */
    public interface StringCallback {
        void onStringAvailable(String str);
    }

    public LineEmitter() {
        this(null);
    }

    public StringCallback getLineCallback() {
        return this.f34789c;
    }

    @Override // com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBufferList.remaining());
        while (byteBufferList.remaining() > 0) {
            byte b4 = byteBufferList.get();
            if (b4 == 10) {
                allocate.flip();
                this.f34788b.add(allocate);
                this.f34789c.onStringAvailable(this.f34788b.readString(this.f34787a));
                this.f34788b = new ByteBufferList();
                return;
            }
            allocate.put(b4);
        }
        allocate.flip();
        this.f34788b.add(allocate);
    }

    public void setLineCallback(StringCallback stringCallback) {
        this.f34789c = stringCallback;
    }

    public LineEmitter(Charset charset) {
        this.f34788b = new ByteBufferList();
        this.f34787a = charset;
    }
}
