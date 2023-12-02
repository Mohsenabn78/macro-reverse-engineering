package com.jakewharton.rxbinding2.widget;

import android.widget.TextSwitcher;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes6.dex */
public final class RxTextSwitcher {

    /* loaded from: classes6.dex */
    static class a implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextSwitcher f34295a;

        a(TextSwitcher textSwitcher) {
            this.f34295a = textSwitcher;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34295a.setText(charSequence);
        }
    }

    /* loaded from: classes6.dex */
    static class b implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextSwitcher f34296a;

        b(TextSwitcher textSwitcher) {
            this.f34296a = textSwitcher;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34296a.setCurrentText(charSequence);
        }
    }

    private RxTextSwitcher() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Consumer<? super CharSequence> currentText(@NonNull TextSwitcher textSwitcher) {
        Preconditions.checkNotNull(textSwitcher, "view == null");
        return new b(textSwitcher);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super CharSequence> text(@NonNull TextSwitcher textSwitcher) {
        Preconditions.checkNotNull(textSwitcher, "view == null");
        return new a(textSwitcher);
    }
}
