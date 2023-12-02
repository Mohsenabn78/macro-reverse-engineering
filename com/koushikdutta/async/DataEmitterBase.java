package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;

/* loaded from: classes6.dex */
public abstract class DataEmitterBase implements DataEmitter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f34768a;

    /* renamed from: b  reason: collision with root package name */
    CompletedCallback f34769b;

    /* renamed from: c  reason: collision with root package name */
    DataCallback f34770c;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Exception exc) {
        if (this.f34768a) {
            return;
        }
        this.f34768a = true;
        if (getEndCallback() != null) {
            getEndCallback().onCompleted(exc);
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return null;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.f34770c;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public final CompletedCallback getEndCallback() {
        return this.f34769b;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.f34770c = dataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public final void setEndCallback(CompletedCallback completedCallback) {
        this.f34769b = completedCallback;
    }
}
