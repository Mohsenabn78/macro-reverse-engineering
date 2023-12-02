package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes6.dex */
public final class RxRatingBar {

    /* loaded from: classes6.dex */
    static class a implements Consumer<Float> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RatingBar f34291a;

        a(RatingBar ratingBar) {
            this.f34291a = ratingBar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Float f4) {
            this.f34291a.setRating(f4.floatValue());
        }
    }

    /* loaded from: classes6.dex */
    static class b implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RatingBar f34292a;

        b(RatingBar ratingBar) {
            this.f34292a = ratingBar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34292a.setIsIndicator(bool.booleanValue());
        }
    }

    private RxRatingBar() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Boolean> isIndicator(@NonNull RatingBar ratingBar) {
        Preconditions.checkNotNull(ratingBar, "view == null");
        return new b(ratingBar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Float> rating(@NonNull RatingBar ratingBar) {
        Preconditions.checkNotNull(ratingBar, "view == null");
        return new a(ratingBar);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<RatingBarChangeEvent> ratingChangeEvents(@NonNull RatingBar ratingBar) {
        Preconditions.checkNotNull(ratingBar, "view == null");
        return new b0(ratingBar);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<Float> ratingChanges(@NonNull RatingBar ratingBar) {
        Preconditions.checkNotNull(ratingBar, "view == null");
        return new c0(ratingBar);
    }
}
