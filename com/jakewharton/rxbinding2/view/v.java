package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewScrollChangeEventObservable.java */
@RequiresApi(23)
/* loaded from: classes6.dex */
final class v extends Observable<ViewScrollChangeEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34261a;

    /* compiled from: ViewScrollChangeEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnScrollChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34262b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super ViewScrollChangeEvent> f34263c;

        a(View view, Observer<? super ViewScrollChangeEvent> observer) {
            this.f34262b = view;
            this.f34263c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34262b.setOnScrollChangeListener(null);
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i4, int i5, int i6, int i7) {
            if (!isDisposed()) {
                this.f34263c.onNext(ViewScrollChangeEvent.create(view, i4, i5, i6, i7));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(View view) {
        this.f34261a = view;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super ViewScrollChangeEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34261a, observer);
        observer.onSubscribe(aVar);
        this.f34261a.setOnScrollChangeListener(aVar);
    }
}
