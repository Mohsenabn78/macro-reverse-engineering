package com.koushikdutta.async.http.filter;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;

/* loaded from: classes6.dex */
public class ContentLengthFilter extends FilteredDataEmitter {

    /* renamed from: h  reason: collision with root package name */
    long f35273h;

    /* renamed from: i  reason: collision with root package name */
    long f35274i;

    /* renamed from: j  reason: collision with root package name */
    ByteBufferList f35275j = new ByteBufferList();

    public ContentLengthFilter(long j4) {
        this.f35273h = j4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.DataEmitterBase
    public void a(Exception exc) {
        if (exc == null && this.f35274i != this.f35273h) {
            exc = new PrematureDataEndException("End of data reached before content length was read: " + this.f35274i + RemoteSettings.FORWARD_SLASH_STRING + this.f35273h + " Paused: " + isPaused());
        }
        super.a(exc);
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        byteBufferList.get(this.f35275j, (int) Math.min(this.f35273h - this.f35274i, byteBufferList.remaining()));
        int remaining = this.f35275j.remaining();
        super.onDataAvailable(dataEmitter, this.f35275j);
        this.f35274i += remaining - this.f35275j.remaining();
        this.f35275j.get(byteBufferList);
        if (this.f35274i == this.f35273h) {
            a(null);
        }
    }
}
