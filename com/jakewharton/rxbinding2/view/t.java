package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Notification;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewLayoutChangeObservable.java */
/* loaded from: classes6.dex */
final class t extends Observable<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34253a;

    /* compiled from: ViewLayoutChangeObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnLayoutChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34254b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Object> f34255c;

        a(View view, Observer<? super Object> observer) {
            this.f34254b = view;
            this.f34255c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34254b.removeOnLayoutChangeListener(this);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            if (!isDisposed()) {
                this.f34255c.onNext(Notification.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(View view) {
        this.f34253a = view;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34253a, observer);
        observer.onSubscribe(aVar);
        this.f34253a.addOnLayoutChangeListener(aVar);
    }
}
