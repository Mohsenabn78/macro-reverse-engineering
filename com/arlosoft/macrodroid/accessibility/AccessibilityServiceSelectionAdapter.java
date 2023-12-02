package com.arlosoft.macrodroid.accessibility;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ListItemKeepAccessibilityRunningBinding;
import java.util.List;
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

/* compiled from: AccessibilityServiceSelectionAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AccessibilityServiceSelectionAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<AccessibilityServiceKeepRunningState> f2048a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ServiceStateChangedListener f2049b;

    /* compiled from: AccessibilityServiceSelectionAdapter.kt */
    /* loaded from: classes2.dex */
    public interface ServiceStateChangedListener {
        void onServiceStateChanged(@NotNull String str, boolean z3, int i4);
    }

    /* compiled from: AccessibilityServiceSelectionAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemKeepAccessibilityRunningBinding f2050a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final ServiceStateChangedListener f2051b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AccessibilityServiceSelectionAdapter.kt */
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
            final /* synthetic */ AccessibilityServiceKeepRunningState $item;
            final /* synthetic */ int $position;
            /* synthetic */ boolean Z$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AccessibilityServiceKeepRunningState accessibilityServiceKeepRunningState, int i4, Continuation<? super a> continuation) {
                super(4, continuation);
                this.$item = accessibilityServiceKeepRunningState;
                this.$position = i4;
            }

            @Nullable
            public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
                a aVar = new a(this.$item, this.$position, continuation);
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
                    ViewHolder.this.f2051b.onServiceStateChanged(this.$item.getId(), this.Z$0, this.$position);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ListItemKeepAccessibilityRunningBinding binding, @NotNull ServiceStateChangedListener changeListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(changeListener, "changeListener");
            this.f2050a = binding;
            this.f2051b = changeListener;
        }

        public final void bind(@NotNull AccessibilityServiceKeepRunningState item, int i4) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.f2050a.name.setText(item.getName());
            this.f2050a.enabledState.setChecked(item.getKeepRunning());
            CheckBox checkBox = this.f2050a.enabledState;
            Intrinsics.checkNotNullExpressionValue(checkBox, "binding.enabledState");
            Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox, (CoroutineContext) null, new a(item, i4, null), 1, (Object) null);
        }
    }

    public AccessibilityServiceSelectionAdapter(@NotNull List<AccessibilityServiceKeepRunningState> items, @NotNull ServiceStateChangedListener changeListener) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(changeListener, "changeListener");
        this.f2048a = items;
        this.f2049b = changeListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f2048a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f2048a.get(i4), i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemKeepAccessibilityRunningBinding inflate = ListItemKeepAccessibilityRunningBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate, this.f2049b);
    }
}
