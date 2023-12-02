package com.jakewharton.rxbinding2.view;

import android.view.DragEvent;
import android.view.View;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* compiled from: ViewDragObservable.java */
/* loaded from: classes6.dex */
final class n extends Observable<DragEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34229a;

    /* renamed from: b  reason: collision with root package name */
    private final Predicate<? super DragEvent> f34230b;

    /* compiled from: ViewDragObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnDragListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34231b;

        /* renamed from: c  reason: collision with root package name */
        private final Predicate<? super DragEvent> f34232c;

        /* renamed from: d  reason: collision with root package name */
        private final Observer<? super DragEvent> f34233d;

        a(View view, Predicate<? super DragEvent> predicate, Observer<? super DragEvent> observer) {
            this.f34231b = view;
            this.f34232c = predicate;
            this.f34233d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34231b.setOnDragListener(null);
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(View view, DragEvent dragEvent) {
            if (!isDisposed()) {
                try {
                    if (this.f34232c.test(dragEvent)) {
                        this.f34233d.onNext(dragEvent);
                        return true;
                    }
                    return false;
                } catch (Exception e4) {
                    this.f34233d.onError(e4);
                    dispose();
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(View view, Predicate<? super DragEvent> predicate) {
        this.f34229a = view;
        this.f34230b = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super DragEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34229a, this.f34230b, observer);
        observer.onSubscribe(aVar);
        this.f34229a.setOnDragListener(aVar);
    }
}
