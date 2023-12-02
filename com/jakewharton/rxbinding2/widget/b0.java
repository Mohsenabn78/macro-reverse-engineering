package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: RatingBarRatingChangeEventObservable.java */
/* loaded from: classes6.dex */
final class b0 extends InitialValueObservable<RatingBarChangeEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final RatingBar f34322a;

    /* compiled from: RatingBarRatingChangeEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements RatingBar.OnRatingBarChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final RatingBar f34323b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super RatingBarChangeEvent> f34324c;

        a(RatingBar ratingBar, Observer<? super RatingBarChangeEvent> observer) {
            this.f34323b = ratingBar;
            this.f34324c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34323b.setOnRatingBarChangeListener(null);
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public void onRatingChanged(RatingBar ratingBar, float f4, boolean z3) {
            if (!isDisposed()) {
                this.f34324c.onNext(RatingBarChangeEvent.create(ratingBar, f4, z3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(RatingBar ratingBar) {
        this.f34322a = ratingBar;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super RatingBarChangeEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34322a, observer);
        this.f34322a.setOnRatingBarChangeListener(aVar);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public RatingBarChangeEvent d() {
        RatingBar ratingBar = this.f34322a;
        return RatingBarChangeEvent.create(ratingBar, ratingBar.getRating(), false);
    }
}
