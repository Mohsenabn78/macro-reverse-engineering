package com.arlosoft.macrodroid.upgrade.base;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BasePurchaseActivity.kt */
/* loaded from: classes3.dex */
public final class BasePurchaseActivityKt {

    /* compiled from: BasePurchaseActivity.kt */
    /* loaded from: classes3.dex */
    static final class a implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f15909a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f15909a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f15909a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f15909a.invoke(obj);
        }
    }
}
