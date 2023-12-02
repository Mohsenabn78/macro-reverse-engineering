package com.koushikdutta.async.callback;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;

/* loaded from: classes6.dex */
public interface DataCallback {

    /* loaded from: classes6.dex */
    public static class NullDataCallback implements DataCallback {
        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byteBufferList.recycle();
        }
    }

    void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList);
}
