package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: SearchViewQueryTextChangesObservable.java */
/* loaded from: classes6.dex */
final class e0 extends InitialValueObservable<CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    private final SearchView f34342a;

    /* compiled from: SearchViewQueryTextChangesObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements SearchView.OnQueryTextListener {

        /* renamed from: b  reason: collision with root package name */
        private final SearchView f34343b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super CharSequence> f34344c;

        a(SearchView searchView, Observer<? super CharSequence> observer) {
            this.f34343b = searchView;
            this.f34344c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34343b.setOnQueryTextListener(null);
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (!isDisposed()) {
                this.f34344c.onNext(str);
                return true;
            }
            return false;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(SearchView searchView) {
        this.f34342a = searchView;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super CharSequence> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34342a, observer);
        this.f34342a.setOnQueryTextListener(aVar);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public CharSequence d() {
        return this.f34342a.getQuery();
    }
}
