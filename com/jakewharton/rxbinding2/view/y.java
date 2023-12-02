package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewTreeObserverDrawObservable.java */
@RequiresApi(16)
/* loaded from: classes6.dex */
final class y extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34272a;

    /* compiled from: ViewTreeObserverDrawObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements ViewTreeObserver.OnDrawListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34273b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Object> f34274c;

        a(View view, Observer<? super Object> observer) {
            this.f34273b = view;
            this.f34274c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34273b.getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            if (!isDisposed()) {
                this.f34274c.onNext(Notification.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(View view) {
        this.f34272a = view;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34272a, observer);
        observer.onSubscribe(aVar);
        this.f34272a.getViewTreeObserver().addOnDrawListener(aVar);
    }
}
