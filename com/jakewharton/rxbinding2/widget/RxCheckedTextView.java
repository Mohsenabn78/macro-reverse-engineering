package com.jakewharton.rxbinding2.widget;

import android.widget.CheckedTextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes6.dex */
public final class RxCheckedTextView {

    /* loaded from: classes6.dex */
    static class a implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CheckedTextView f34281a;

        a(CheckedTextView checkedTextView) {
            this.f34281a = checkedTextView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34281a.setChecked(bool.booleanValue());
        }
    }

    private RxCheckedTextView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Boolean> check(@NonNull CheckedTextView checkedTextView) {
        Preconditions.checkNotNull(checkedTextView, "view == null");
        return new a(checkedTextView);
    }
}
