package com.jakewharton.rxbinding2.widget;

import android.widget.RadioGroup;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes6.dex */
public final class RxRadioGroup {

    /* loaded from: classes6.dex */
    static class a implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RadioGroup f34290a;

        a(RadioGroup radioGroup) {
            this.f34290a = radioGroup;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            if (num.intValue() == -1) {
                this.f34290a.clearCheck();
            } else {
                this.f34290a.check(num.intValue());
            }
        }
    }

    private RxRadioGroup() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> checked(@NonNull RadioGroup radioGroup) {
        Preconditions.checkNotNull(radioGroup, "view == null");
        return new a(radioGroup);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<Integer> checkedChanges(@NonNull RadioGroup radioGroup) {
        Preconditions.checkNotNull(radioGroup, "view == null");
        return new a0(radioGroup);
    }
}
