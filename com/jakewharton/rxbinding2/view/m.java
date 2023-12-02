package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewClickObservable.java */
/* loaded from: classes6.dex */
final class m extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34226a;

    /* compiled from: ViewClickObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34227b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Object> f34228c;

        a(View view, Observer<? super Object> observer) {
            this.f34227b = view;
            this.f34228c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34227b.setOnClickListener(null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!isDisposed()) {
                this.f34228c.onNext(Notification.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view) {
        this.f34226a = view;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34226a, observer);
        observer.onSubscribe(aVar);
        this.f34226a.setOnClickListener(aVar);
    }
}
