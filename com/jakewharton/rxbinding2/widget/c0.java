package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: RatingBarRatingChangeObservable.java */
/* loaded from: classes6.dex */
final class c0 extends InitialValueObservable<Float> {

    /* renamed from: a  reason: collision with root package name */
    private final RatingBar f34328a;

    /* compiled from: RatingBarRatingChangeObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements RatingBar.OnRatingBarChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final RatingBar f34329b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Float> f34330c;

        a(RatingBar ratingBar, Observer<? super Float> observer) {
            this.f34329b = ratingBar;
            this.f34330c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34329b.setOnRatingBarChangeListener(null);
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public void onRatingChanged(RatingBar ratingBar, float f4, boolean z3) {
            if (!isDisposed()) {
                this.f34330c.onNext(Float.valueOf(f4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(RatingBar ratingBar) {
        this.f34328a = ratingBar;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super Float> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34328a, observer);
        this.f34328a.setOnRatingBarChangeListener(aVar);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public Float d() {
        return Float.valueOf(this.f34328a.getRating());
    }
}
