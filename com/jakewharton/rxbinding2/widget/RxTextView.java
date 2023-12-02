package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/* loaded from: classes6.dex */
public final class RxTextView {

    /* loaded from: classes6.dex */
    static class a implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f34297a;

        a(TextView textView) {
            this.f34297a = textView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34297a.setText(charSequence);
        }
    }

    /* loaded from: classes6.dex */
    static class b implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f34298a;

        b(TextView textView) {
            this.f34298a = textView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34298a.setText(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    static class c implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f34299a;

        c(TextView textView) {
            this.f34299a = textView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34299a.setError(charSequence);
        }
    }

    /* loaded from: classes6.dex */
    static class d implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f34300a;

        d(TextView textView) {
            this.f34300a = textView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            TextView textView = this.f34300a;
            textView.setError(textView.getContext().getResources().getText(num.intValue()));
        }
    }

    /* loaded from: classes6.dex */
    static class e implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f34301a;

        e(TextView textView) {
            this.f34301a = textView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34301a.setHint(charSequence);
        }
    }

    /* loaded from: classes6.dex */
    static class f implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f34302a;

        f(TextView textView) {
            this.f34302a = textView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34302a.setHint(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    static class g implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f34303a;

        g(TextView textView) {
            this.f34303a = textView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) throws Exception {
            this.f34303a.setTextColor(num.intValue());
        }
    }

    private RxTextView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<TextViewAfterTextChangeEvent> afterTextChangeEvents(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new h0(textView);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<TextViewBeforeTextChangeEvent> beforeTextChangeEvents(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new i0(textView);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> color(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new g(textView);
    }

    @NonNull
    @CheckResult
    public static Observable<TextViewEditorActionEvent> editorActionEvents(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return editorActionEvents(textView, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> editorActions(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return editorActions(textView, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super CharSequence> error(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new c(textView);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> errorRes(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new d(textView);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super CharSequence> hint(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new e(textView);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> hintRes(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new f(textView);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super CharSequence> text(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new a(textView);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<TextViewTextChangeEvent> textChangeEvents(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new l0(textView);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<CharSequence> textChanges(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new m0(textView);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> textRes(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new b(textView);
    }

    @NonNull
    @CheckResult
    public static Observable<TextViewEditorActionEvent> editorActionEvents(@NonNull TextView textView, @NonNull Predicate<? super TextViewEditorActionEvent> predicate) {
        Preconditions.checkNotNull(textView, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new j0(textView, predicate);
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> editorActions(@NonNull TextView textView, @NonNull Predicate<? super Integer> predicate) {
        Preconditions.checkNotNull(textView, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new k0(textView, predicate);
    }
}
