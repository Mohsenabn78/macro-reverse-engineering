package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewLayoutChangeEventObservable.java */
/* loaded from: classes6.dex */
final class s extends Observable<ViewLayoutChangeEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34250a;

    /* compiled from: ViewLayoutChangeEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnLayoutChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34251b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super ViewLayoutChangeEvent> f34252c;

        a(View view, Observer<? super ViewLayoutChangeEvent> observer) {
            this.f34251b = view;
            this.f34252c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34251b.removeOnLayoutChangeListener(this);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            if (!isDisposed()) {
                this.f34252c.onNext(ViewLayoutChangeEvent.create(view, i4, i5, i6, i7, i8, i9, i10, i11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(View view) {
        this.f34250a = view;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super ViewLayoutChangeEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34250a, observer);
        observer.onSubscribe(aVar);
        this.f34250a.addOnLayoutChangeListener(aVar);
    }
}
