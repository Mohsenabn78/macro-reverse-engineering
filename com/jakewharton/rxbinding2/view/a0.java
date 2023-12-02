package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewTreeObserver;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import java.util.concurrent.Callable;

/* compiled from: ViewTreeObserverPreDrawObservable.java */
/* loaded from: classes6.dex */
final class a0 extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34182a;

    /* renamed from: b  reason: collision with root package name */
    private final Callable<Boolean> f34183b;

    /* compiled from: ViewTreeObserverPreDrawObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34184b;

        /* renamed from: c  reason: collision with root package name */
        private final Callable<Boolean> f34185c;

        /* renamed from: d  reason: collision with root package name */
        private final Observer<? super Object> f34186d;

        a(View view, Callable<Boolean> callable, Observer<? super Object> observer) {
            this.f34184b = view;
            this.f34185c = callable;
            this.f34186d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34184b.getViewTreeObserver().removeOnPreDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!isDisposed()) {
                this.f34186d.onNext(Notification.INSTANCE);
                try {
                    return this.f34185c.call().booleanValue();
                } catch (Exception e4) {
                    this.f34186d.onError(e4);
                    dispose();
                    return true;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(View view, Callable<Boolean> callable) {
        this.f34182a = view;
        this.f34183b = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34182a, this.f34183b, observer);
        observer.onSubscribe(aVar);
        this.f34182a.getViewTreeObserver().addOnPreDrawListener(aVar);
    }
}
