package com.jakewharton.rxbinding2.view;

import android.view.MotionEvent;
import android.view.View;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* compiled from: ViewTouchObservable.java */
/* loaded from: classes6.dex */
final class x extends Observable<MotionEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34267a;

    /* renamed from: b  reason: collision with root package name */
    private final Predicate<? super MotionEvent> f34268b;

    /* compiled from: ViewTouchObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34269b;

        /* renamed from: c  reason: collision with root package name */
        private final Predicate<? super MotionEvent> f34270c;

        /* renamed from: d  reason: collision with root package name */
        private final Observer<? super MotionEvent> f34271d;

        a(View view, Predicate<? super MotionEvent> predicate, Observer<? super MotionEvent> observer) {
            this.f34269b = view;
            this.f34270c = predicate;
            this.f34271d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34269b.setOnTouchListener(null);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!isDisposed()) {
                try {
                    if (this.f34270c.test(motionEvent)) {
                        this.f34271d.onNext(motionEvent);
                        return true;
                    }
                    return false;
                } catch (Exception e4) {
                    this.f34271d.onError(e4);
                    dispose();
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(View view, Predicate<? super MotionEvent> predicate) {
        this.f34267a = view;
        this.f34268b = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super MotionEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34267a, this.f34268b, observer);
        observer.onSubscribe(aVar);
        this.f34267a.setOnTouchListener(aVar);
    }
}
