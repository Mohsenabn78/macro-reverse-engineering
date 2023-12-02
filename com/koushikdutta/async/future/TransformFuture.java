package com.koushikdutta.async.future;

/* loaded from: classes6.dex */
public abstract class TransformFuture<T, F> extends SimpleFuture<T> implements FutureCallback<F> {
    /* JADX INFO: Access modifiers changed from: protected */
    public void j(Exception exc) {
        setComplete(exc);
    }

    protected abstract void k(F f4) throws Exception;

    @Override // com.koushikdutta.async.future.FutureCallback
    public void onCompleted(Exception exc, F f4) {
        if (isCancelled()) {
            return;
        }
        if (exc != null) {
            j(exc);
            return;
        }
        try {
            k(f4);
        } catch (Exception e4) {
            j(e4);
        }
    }
}
