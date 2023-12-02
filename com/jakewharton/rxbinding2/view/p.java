package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewGroupHierarchyChangeEventObservable.java */
/* loaded from: classes6.dex */
final class p extends Observable<ViewGroupHierarchyChangeEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f34237a;

    /* compiled from: ViewGroupHierarchyChangeEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final ViewGroup f34238b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super ViewGroupHierarchyChangeEvent> f34239c;

        a(ViewGroup viewGroup, Observer<? super ViewGroupHierarchyChangeEvent> observer) {
            this.f34238b = viewGroup;
            this.f34239c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34238b.setOnHierarchyChangeListener(null);
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (!isDisposed()) {
                this.f34239c.onNext(ViewGroupHierarchyChildViewAddEvent.create(this.f34238b, view2));
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!isDisposed()) {
                this.f34239c.onNext(ViewGroupHierarchyChildViewRemoveEvent.create(this.f34238b, view2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ViewGroup viewGroup) {
        this.f34237a = viewGroup;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super ViewGroupHierarchyChangeEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34237a, observer);
        observer.onSubscribe(aVar);
        this.f34237a.setOnHierarchyChangeListener(aVar);
    }
}
