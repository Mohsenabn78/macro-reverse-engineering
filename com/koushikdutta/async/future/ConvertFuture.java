package com.koushikdutta.async.future;

/* loaded from: classes6.dex */
public abstract class ConvertFuture<T, F> extends TransformFuture<T, F> {
    @Override // com.koushikdutta.async.future.TransformFuture
    protected final void k(F f4) throws Exception {
        setComplete((Future) l(f4));
    }

    protected abstract Future<T> l(F f4) throws Exception;
}
