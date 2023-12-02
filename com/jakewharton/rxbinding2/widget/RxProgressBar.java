package com.jakewharton.rxbinding2.widget;

import android.widget.ProgressBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes6.dex */
public final class RxProgressBar {

    /* loaded from: classes6.dex */
    static class a implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f34284a;

        a(ProgressBar progressBar) {
            this.f34284a = progressBar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34284a.incrementProgressBy(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    static class b implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f34285a;

        b(ProgressBar progressBar) {
            this.f34285a = progressBar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34285a.incrementSecondaryProgressBy(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    static class c implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f34286a;

        c(ProgressBar progressBar) {
            this.f34286a = progressBar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34286a.setIndeterminate(bool.booleanValue());
        }
    }

    /* loaded from: classes6.dex */
    static class d implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f34287a;

        d(ProgressBar progressBar) {
            this.f34287a = progressBar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34287a.setMax(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    static class e implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f34288a;

        e(ProgressBar progressBar) {
            this.f34288a = progressBar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34288a.setProgress(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    static class f implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f34289a;

        f(ProgressBar progressBar) {
            this.f34289a = progressBar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34289a.setSecondaryProgress(num.intValue());
        }
    }

    private RxProgressBar() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> incrementProgressBy(@NonNull ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        return new a(progressBar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> incrementSecondaryProgressBy(@NonNull ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        return new b(progressBar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Boolean> indeterminate(@NonNull ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        return new c(progressBar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> max(@NonNull ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        return new d(progressBar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> progress(@NonNull ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        return new e(progressBar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> secondaryProgress(@NonNull ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        return new f(progressBar);
    }
}
