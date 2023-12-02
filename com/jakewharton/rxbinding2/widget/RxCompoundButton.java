package com.jakewharton.rxbinding2.widget;

import android.widget.CompoundButton;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes6.dex */
public final class RxCompoundButton {

    /* loaded from: classes6.dex */
    static class a implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompoundButton f34282a;

        a(CompoundButton compoundButton) {
            this.f34282a = compoundButton;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            this.f34282a.setChecked(bool.booleanValue());
        }
    }

    /* loaded from: classes6.dex */
    static class b implements Consumer<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompoundButton f34283a;

        b(CompoundButton compoundButton) {
            this.f34283a = compoundButton;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            this.f34283a.toggle();
        }
    }

    private RxCompoundButton() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Boolean> checked(@NonNull CompoundButton compoundButton) {
        Preconditions.checkNotNull(compoundButton, "view == null");
        return new a(compoundButton);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<Boolean> checkedChanges(@NonNull CompoundButton compoundButton) {
        Preconditions.checkNotNull(compoundButton, "view == null");
        return new x(compoundButton);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Object> toggle(@NonNull CompoundButton compoundButton) {
        Preconditions.checkNotNull(compoundButton, "view == null");
        return new b(compoundButton);
    }
}
