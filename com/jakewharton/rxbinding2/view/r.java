package com.jakewharton.rxbinding2.view;

import android.view.KeyEvent;
import android.view.View;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* compiled from: ViewKeyObservable.java */
/* loaded from: classes6.dex */
final class r extends Observable<KeyEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34245a;

    /* renamed from: b  reason: collision with root package name */
    private final Predicate<? super KeyEvent> f34246b;

    /* compiled from: ViewKeyObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnKeyListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34247b;

        /* renamed from: c  reason: collision with root package name */
        private final Predicate<? super KeyEvent> f34248c;

        /* renamed from: d  reason: collision with root package name */
        private final Observer<? super KeyEvent> f34249d;

        a(View view, Predicate<? super KeyEvent> predicate, Observer<? super KeyEvent> observer) {
            this.f34247b = view;
            this.f34248c = predicate;
            this.f34249d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34247b.setOnKeyListener(null);
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i4, KeyEvent keyEvent) {
            if (!isDisposed()) {
                try {
                    if (this.f34248c.test(keyEvent)) {
                        this.f34249d.onNext(keyEvent);
                        return true;
                    }
                    return false;
                } catch (Exception e4) {
                    this.f34249d.onError(e4);
                    dispose();
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(View view, Predicate<? super KeyEvent> predicate) {
        this.f34245a = view;
        this.f34246b = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super KeyEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34245a, this.f34246b, observer);
        observer.onSubscribe(aVar);
        this.f34245a.setOnKeyListener(aVar);
    }
}
