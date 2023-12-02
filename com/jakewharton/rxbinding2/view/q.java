package com.jakewharton.rxbinding2.view;

import android.view.MotionEvent;
import android.view.View;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* compiled from: ViewHoverObservable.java */
/* loaded from: classes6.dex */
final class q extends Observable<MotionEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34240a;

    /* renamed from: b  reason: collision with root package name */
    private final Predicate<? super MotionEvent> f34241b;

    /* compiled from: ViewHoverObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnHoverListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34242b;

        /* renamed from: c  reason: collision with root package name */
        private final Predicate<? super MotionEvent> f34243c;

        /* renamed from: d  reason: collision with root package name */
        private final Observer<? super MotionEvent> f34244d;

        a(View view, Predicate<? super MotionEvent> predicate, Observer<? super MotionEvent> observer) {
            this.f34242b = view;
            this.f34243c = predicate;
            this.f34244d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34242b.setOnHoverListener(null);
        }

        @Override // android.view.View.OnHoverListener
        public boolean onHover(View view, MotionEvent motionEvent) {
            if (!isDisposed()) {
                try {
                    if (this.f34243c.test(motionEvent)) {
                        this.f34244d.onNext(motionEvent);
                        return true;
                    }
                    return false;
                } catch (Exception e4) {
                    this.f34244d.onError(e4);
                    dispose();
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(View view, Predicate<? super MotionEvent> predicate) {
        this.f34240a = view;
        this.f34241b = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super MotionEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34240a, this.f34241b, observer);
        observer.onSubscribe(aVar);
        this.f34240a.setOnHoverListener(aVar);
    }
}
