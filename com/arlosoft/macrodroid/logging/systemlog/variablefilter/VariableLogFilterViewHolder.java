package com.arlosoft.macrodroid.logging.systemlog.variablefilter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ViewVariableFilterEntryBinding;
import com.arlosoft.macrodroid.logging.systemlog.variablefilter.VariableLogFilterAdapter;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableLogFilterAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VariableLogFilterViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewVariableFilterEntryBinding f12794a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableLogFilterAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ VariableLogFilterAdapter.OnFilterChangeListener $filterChangeListener;
        final /* synthetic */ VariableWithFilteredState $variableWithFilteredState;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(VariableLogFilterAdapter.OnFilterChangeListener onFilterChangeListener, VariableWithFilteredState variableWithFilteredState, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$filterChangeListener = onFilterChangeListener;
            this.$variableWithFilteredState = variableWithFilteredState;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$filterChangeListener, this.$variableWithFilteredState, continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$filterChangeListener.filterStateChanged(this.$variableWithFilteredState.getVariable().getName(), this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableLogFilterViewHolder(@NotNull ViewVariableFilterEntryBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.f12794a = binding;
    }

    public final void bind(@NotNull VariableWithFilteredState variableWithFilteredState, @NotNull VariableLogFilterAdapter.OnFilterChangeListener filterChangeListener) {
        Intrinsics.checkNotNullParameter(variableWithFilteredState, "variableWithFilteredState");
        Intrinsics.checkNotNullParameter(filterChangeListener, "filterChangeListener");
        this.f12794a.variableName.setText(variableWithFilteredState.getVariable().getName());
        this.f12794a.filterEnabledCheckbox.setOnCheckedChangeListener(null);
        this.f12794a.filterEnabledCheckbox.setChecked(variableWithFilteredState.isEnabled());
        CheckBox checkBox = this.f12794a.filterEnabledCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.filterEnabledCheckbox");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox, (CoroutineContext) null, new a(filterChangeListener, variableWithFilteredState, null), 1, (Object) null);
    }
}
