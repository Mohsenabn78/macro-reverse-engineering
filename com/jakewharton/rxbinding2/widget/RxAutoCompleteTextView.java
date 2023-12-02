package com.jakewharton.rxbinding2.widget;

import android.widget.AutoCompleteTextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/* loaded from: classes6.dex */
public final class RxAutoCompleteTextView {

    /* loaded from: classes6.dex */
    static class a implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f34279a;

        a(AutoCompleteTextView autoCompleteTextView) {
            this.f34279a = autoCompleteTextView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34279a.setCompletionHint(charSequence);
        }
    }

    /* loaded from: classes6.dex */
    static class b implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f34280a;

        b(AutoCompleteTextView autoCompleteTextView) {
            this.f34280a = autoCompleteTextView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34280a.setThreshold(num.intValue());
        }
    }

    private RxAutoCompleteTextView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Consumer<? super CharSequence> completionHint(@NonNull AutoCompleteTextView autoCompleteTextView) {
        Preconditions.checkNotNull(autoCompleteTextView, "view == null");
        return new a(autoCompleteTextView);
    }

    @NonNull
    @CheckResult
    public static Observable<AdapterViewItemClickEvent> itemClickEvents(@NonNull AutoCompleteTextView autoCompleteTextView) {
        Preconditions.checkNotNull(autoCompleteTextView, "view == null");
        return new i(autoCompleteTextView);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> threshold(@NonNull AutoCompleteTextView autoCompleteTextView) {
        Preconditions.checkNotNull(autoCompleteTextView, "view == null");
        return new b(autoCompleteTextView);
    }
}
