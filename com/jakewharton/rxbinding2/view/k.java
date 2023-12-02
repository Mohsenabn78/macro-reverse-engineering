package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewAttachEventObservable.java */
/* loaded from: classes6.dex */
final class k extends Observable<ViewAttachEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34218a;

    /* compiled from: ViewAttachEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34219b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super ViewAttachEvent> f34220c;

        a(View view, Observer<? super ViewAttachEvent> observer) {
            this.f34219b = view;
            this.f34220c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34219b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (!isDisposed()) {
                this.f34220c.onNext(ViewAttachAttachedEvent.create(this.f34219b));
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (!isDisposed()) {
                this.f34220c.onNext(ViewAttachDetachedEvent.create(this.f34219b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(View view) {
        this.f34218a = view;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super ViewAttachEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34218a, observer);
        observer.onSubscribe(aVar);
        this.f34218a.addOnAttachStateChangeListener(aVar);
    }
}
