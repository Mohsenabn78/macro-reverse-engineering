package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;

/* loaded from: classes6.dex */
public class DataEmitterReader implements DataCallback {

    /* renamed from: a  reason: collision with root package name */
    DataCallback f34771a;

    /* renamed from: b  reason: collision with root package name */
    int f34772b;

    /* renamed from: c  reason: collision with root package name */
    ByteBufferList f34773c = new ByteBufferList();

    private boolean a(DataEmitter dataEmitter) {
        if (this.f34772b > this.f34773c.remaining()) {
            return false;
        }
        DataCallback dataCallback = this.f34771a;
        this.f34771a = null;
        dataCallback.onDataAvailable(dataEmitter, this.f34773c);
        return true;
    }

    @Override // com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        do {
            byteBufferList.get(this.f34773c, Math.min(byteBufferList.remaining(), this.f34772b - this.f34773c.remaining()));
            byteBufferList.remaining();
            if (!a(dataEmitter)) {
                break;
            }
        } while (this.f34771a != null);
        byteBufferList.remaining();
    }

    public void read(int i4, DataCallback dataCallback) {
        this.f34772b = i4;
        this.f34771a = dataCallback;
        this.f34773c.recycle();
    }
}
