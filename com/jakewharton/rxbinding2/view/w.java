package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewSystemUiVisibilityChangeObservable.java */
/* loaded from: classes6.dex */
final class w extends Observable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34264a;

    /* compiled from: ViewSystemUiVisibilityChangeObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34265b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Integer> f34266c;

        a(View view, Observer<? super Integer> observer) {
            this.f34265b = view;
            this.f34266c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34265b.setOnSystemUiVisibilityChangeListener(null);
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i4) {
            if (!isDisposed()) {
                this.f34266c.onNext(Integer.valueOf(i4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(View view) {
        this.f34264a = view;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Integer> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34264a, observer);
        observer.onSubscribe(aVar);
        this.f34264a.setOnSystemUiVisibilityChangeListener(aVar);
    }
}
