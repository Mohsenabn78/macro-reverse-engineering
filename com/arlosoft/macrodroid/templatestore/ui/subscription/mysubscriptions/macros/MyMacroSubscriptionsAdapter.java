package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.database.room.MacroSubscription;
import com.arlosoft.macrodroid.databinding.ListItemMyMacroSubscriptionBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MyMacroSubscriptionsAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MyMacroSubscriptionsAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<MacroSubscription> f13880a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function2<MacroSubscription, Boolean, Unit> f13881b;

    /* compiled from: MyMacroSubscriptionsAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemMyMacroSubscriptionBinding f13882a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final Function2<MacroSubscription, Boolean, Unit> f13883b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MyMacroSubscriptionsAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ MacroSubscription $macro;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MacroSubscription macroSubscription, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$macro = macroSubscription;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$macro, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f13883b.mo1invoke(this.$macro, Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MyMacroSubscriptionsAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ MacroSubscription $macro;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(MacroSubscription macroSubscription, Continuation<? super b> continuation) {
                super(3, continuation);
                this.$macro = macroSubscription;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new b(this.$macro, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f13883b.mo1invoke(this.$macro, Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(@NotNull ListItemMyMacroSubscriptionBinding binding, @NotNull Function2<? super MacroSubscription, ? super Boolean, Unit> macroClickListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(macroClickListener, "macroClickListener");
            this.f13882a = binding;
            this.f13883b = macroClickListener;
        }

        public final void bind(@NotNull MacroSubscription macro, boolean z3) {
            int i4;
            Intrinsics.checkNotNullParameter(macro, "macro");
            Context context = this.f13882a.cardView.getContext();
            if (z3) {
                i4 = R.color.card_bg_2;
            } else {
                i4 = R.color.card_bg_1;
            }
            int color = ContextCompat.getColor(context, i4);
            this.f13882a.maroName.setText(macro.getMacroName());
            this.f13882a.cardView.setCardBackgroundColor(color);
            CardView cardView = this.f13882a.cardView;
            Intrinsics.checkNotNullExpressionValue(cardView, "binding.cardView");
            ViewExtensionsKt.onClick$default(cardView, null, new a(macro, null), 1, null);
            CardView cardView2 = this.f13882a.cardView;
            Intrinsics.checkNotNullExpressionValue(cardView2, "binding.cardView");
            ViewExtensionsKt.onLongClick$default(cardView2, null, false, new b(macro, null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MyMacroSubscriptionsAdapter(@NotNull List<MacroSubscription> updateItems, @NotNull Function2<? super MacroSubscription, ? super Boolean, Unit> macroClickListener) {
        Intrinsics.checkNotNullParameter(updateItems, "updateItems");
        Intrinsics.checkNotNullParameter(macroClickListener, "macroClickListener");
        this.f13880a = updateItems;
        this.f13881b = macroClickListener;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13880a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f13880a.get(i4).getMacroId();
    }

    public final void updateItems(@NotNull List<MacroSubscription> updateItems) {
        Intrinsics.checkNotNullParameter(updateItems, "updateItems");
        this.f13880a = updateItems;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f13880a.get(i4), i4 % 2 == 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemMyMacroSubscriptionBinding inflate = ListItemMyMacroSubscriptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate, this.f13881b);
    }
}
