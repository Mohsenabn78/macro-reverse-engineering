package com.jakewharton.rxbinding2;

import io.reactivex.Observable;
import io.reactivex.Observer;

/* loaded from: classes6.dex */
public abstract class InitialValueObservable<T> extends Observable<T> {

    /* loaded from: classes6.dex */
    private final class a extends Observable<T> {
        a() {
        }

        @Override // io.reactivex.Observable
        protected void subscribeActual(Observer<? super T> observer) {
            InitialValueObservable.this.e(observer);
        }
    }

    protected abstract T d();

    protected abstract void e(Observer<? super T> observer);

    public final Observable<T> skipInitialValue() {
        return new a();
    }

    @Override // io.reactivex.Observable
    protected final void subscribeActual(Observer<? super T> observer) {
        e(observer);
        observer.onNext(d());
    }
}
