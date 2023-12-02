package com.koushikdutta.async.future;

/* loaded from: classes6.dex */
public interface Future<T> extends Cancellable, java.util.concurrent.Future<T> {
    Future<T> setCallback(FutureCallback<T> futureCallback);

    <C extends FutureCallback<T>> C then(C c4);

    T tryGet();

    Exception tryGetException();
}
