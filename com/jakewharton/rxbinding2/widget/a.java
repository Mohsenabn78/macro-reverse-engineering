package com.jakewharton.rxbinding2.widget;

import android.widget.AbsListView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: AbsListViewScrollEventObservable.java */
/* loaded from: classes6.dex */
final class a extends Observable<AbsListViewScrollEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final AbsListView f34308a;

    /* compiled from: AbsListViewScrollEventObservable.java */
    /* renamed from: com.jakewharton.rxbinding2.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0176a extends MainThreadDisposable implements AbsListView.OnScrollListener {

        /* renamed from: b  reason: collision with root package name */
        private final AbsListView f34309b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super AbsListViewScrollEvent> f34310c;

        /* renamed from: d  reason: collision with root package name */
        private int f34311d = 0;

        C0176a(AbsListView absListView, Observer<? super AbsListViewScrollEvent> observer) {
            this.f34309b = absListView;
            this.f34310c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34309b.setOnScrollListener(null);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
            if (!isDisposed()) {
                this.f34310c.onNext(AbsListViewScrollEvent.create(this.f34309b, this.f34311d, i4, i5, i6));
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i4) {
            this.f34311d = i4;
            if (!isDisposed()) {
                AbsListView absListView2 = this.f34309b;
                this.f34310c.onNext(AbsListViewScrollEvent.create(absListView2, i4, absListView2.getFirstVisiblePosition(), this.f34309b.getChildCount(), this.f34309b.getCount()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsListView absListView) {
        this.f34308a = absListView;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super AbsListViewScrollEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        C0176a c0176a = new C0176a(this.f34308a, observer);
        observer.onSubscribe(c0176a);
        this.f34308a.setOnScrollListener(c0176a);
    }
}
