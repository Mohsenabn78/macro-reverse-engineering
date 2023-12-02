package com.koushikdutta.async.future;

/* loaded from: classes6.dex */
public interface DependentCancellable extends Cancellable {
    DependentCancellable setParent(Cancellable cancellable);
}
