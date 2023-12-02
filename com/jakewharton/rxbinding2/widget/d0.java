package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: SearchViewQueryTextChangeEventsObservable.java */
/* loaded from: classes6.dex */
final class d0 extends InitialValueObservable<SearchViewQueryTextEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final SearchView f34334a;

    /* compiled from: SearchViewQueryTextChangeEventsObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements SearchView.OnQueryTextListener {

        /* renamed from: b  reason: collision with root package name */
        private final SearchView f34335b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super SearchViewQueryTextEvent> f34336c;

        a(SearchView searchView, Observer<? super SearchViewQueryTextEvent> observer) {
            this.f34335b = searchView;
            this.f34336c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34335b.setOnQueryTextListener(null);
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (isDisposed()) {
                return false;
            }
            this.f34336c.onNext(SearchViewQueryTextEvent.create(this.f34335b, str, false));
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            if (!isDisposed()) {
                this.f34336c.onNext(SearchViewQueryTextEvent.create(this.f34335b, str, true));
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(SearchView searchView) {
        this.f34334a = searchView;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super SearchViewQueryTextEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34334a, observer);
        this.f34334a.setOnQueryTextListener(aVar);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public SearchViewQueryTextEvent d() {
        SearchView searchView = this.f34334a;
        return SearchViewQueryTextEvent.create(searchView, searchView.getQuery(), false);
    }
}
