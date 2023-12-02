package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewAttachesObservable.java */
/* loaded from: classes6.dex */
final class l extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f34221a;

    /* renamed from: b  reason: collision with root package name */
    private final View f34222b;

    /* compiled from: ViewAttachesObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34223b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f34224c;

        /* renamed from: d  reason: collision with root package name */
        private final Observer<? super Object> f34225d;

        a(View view, boolean z3, Observer<? super Object> observer) {
            this.f34223b = view;
            this.f34224c = z3;
            this.f34225d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34223b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (this.f34224c && !isDisposed()) {
                this.f34225d.onNext(Notification.INSTANCE);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (!this.f34224c && !isDisposed()) {
                this.f34225d.onNext(Notification.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(View view, boolean z3) {
        this.f34222b = view;
        this.f34221a = z3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34222b, this.f34221a, observer);
        observer.onSubscribe(aVar);
        this.f34222b.addOnAttachStateChangeListener(aVar);
    }
}
