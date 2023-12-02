package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewTreeObserver;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewTreeObserverGlobalLayoutObservable.java */
/* loaded from: classes6.dex */
final class z extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34275a;

    /* compiled from: ViewTreeObserverGlobalLayoutObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34276b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Object> f34277c;

        a(View view, Observer<? super Object> observer) {
            this.f34276b = view;
            this.f34277c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34276b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!isDisposed()) {
                this.f34277c.onNext(Notification.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(View view) {
        this.f34275a = view;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34275a, observer);
        observer.onSubscribe(aVar);
        this.f34275a.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
    }
}
