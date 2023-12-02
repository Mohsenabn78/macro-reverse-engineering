package com.arlosoft.macrodroid.troubleshooting.help;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.TroubleshootingHelpItemBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import java.util.Arrays;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HelpListAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class HelpListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<HelpItem> f15820a;

    /* compiled from: HelpListAdapter.kt */
    @StabilityInferred(parameters = 0)
    @SourceDebugExtension({"SMAP\nHelpListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HelpListAdapter.kt\ncom/arlosoft/macrodroid/troubleshooting/help/HelpListAdapter$ViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n262#2,2:62\n262#2,2:65\n262#2,2:67\n262#2,2:69\n262#2,2:71\n1#3:64\n*S KotlinDebug\n*F\n+ 1 HelpListAdapter.kt\ncom/arlosoft/macrodroid/troubleshooting/help/HelpListAdapter$ViewHolder\n*L\n18#1:62,2\n33#1:65,2\n39#1:67,2\n41#1:69,2\n43#1:71,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final TroubleshootingHelpItemBinding f15821a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HelpListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;

            a(Continuation<? super a> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                float f4;
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean isExpanded = ViewHolder.this.f15821a.expandableLayout.isExpanded();
                    ViewHolder.this.f15821a.expandableLayout.setExpanded(!ViewHolder.this.f15821a.expandableLayout.isExpanded());
                    ViewPropertyAnimator animate = ViewHolder.this.f15821a.chevron.animate();
                    animate.setDuration(400L);
                    if (isExpanded) {
                        f4 = 0.0f;
                    } else {
                        f4 = 90.0f;
                    }
                    animate.rotation(f4);
                    animate.start();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HelpListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ HelpItem $helpItem;
            int label;
            final /* synthetic */ ViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(HelpItem helpItem, ViewHolder viewHolder, Continuation<? super b> continuation) {
                super(3, continuation);
                this.$helpItem = helpItem;
                this.this$0 = viewHolder;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new b(this.$helpItem, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    HelpItem helpItem = this.$helpItem;
                    Context context = this.this$0.f15821a.getRoot().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
                    helpItem.performAction(context);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HelpListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ HelpItem $helpItem;
            int label;
            final /* synthetic */ ViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(HelpItem helpItem, ViewHolder viewHolder, Continuation<? super c> continuation) {
                super(3, continuation);
                this.$helpItem = helpItem;
                this.this$0 = viewHolder;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new c(this.$helpItem, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    HelpItem helpItem = this.$helpItem;
                    Context context = this.this$0.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                    helpItem.performOptionalAction(context, 0);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HelpListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ HelpItem $helpItem;
            int label;
            final /* synthetic */ ViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(HelpItem helpItem, ViewHolder viewHolder, Continuation<? super d> continuation) {
                super(3, continuation);
                this.$helpItem = helpItem;
                this.this$0 = viewHolder;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new d(this.$helpItem, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    HelpItem helpItem = this.$helpItem;
                    Context context = this.this$0.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                    helpItem.performOptionalAction(context, 1);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HelpListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ HelpItem $helpItem;
            int label;
            final /* synthetic */ ViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(HelpItem helpItem, ViewHolder viewHolder, Continuation<? super e> continuation) {
                super(3, continuation);
                this.$helpItem = helpItem;
                this.this$0 = viewHolder;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new e(this.$helpItem, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    HelpItem helpItem = this.$helpItem;
                    Context context = this.this$0.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                    helpItem.performOptionalAction(context, 2);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull TroubleshootingHelpItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15821a = binding;
        }

        public final void bind(@NotNull HelpItem helpItem) {
            boolean z3;
            int i4;
            boolean z4;
            int i5;
            String format;
            boolean z5;
            int i6;
            boolean z6;
            int i7;
            boolean z7;
            Intrinsics.checkNotNullParameter(helpItem, "helpItem");
            this.f15821a.helpDescription.setText(this.itemView.getContext().getString(helpItem.getDescription()));
            this.f15821a.helpTitle.setText(this.itemView.getContext().getString(helpItem.getTitle()));
            Button button = this.f15821a.actionButton;
            Intrinsics.checkNotNullExpressionValue(button, "binding.actionButton");
            int i8 = 0;
            if (helpItem.getButtonText() != null && helpItem.shouldShowConfigureButton()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            button.setVisibility(i4);
            Integer buttonText = helpItem.getButtonText();
            if (buttonText != null) {
                this.f15821a.actionButton.setText(this.itemView.getContext().getString(buttonText.intValue()));
            }
            LinearLayout linearLayout = this.f15821a.helpHeader;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.helpHeader");
            ViewExtensionsKt.onClick$default(linearLayout, null, new a(null), 1, null);
            Button button2 = this.f15821a.actionButton;
            Intrinsics.checkNotNullExpressionValue(button2, "binding.actionButton");
            ViewExtensionsKt.onClick$default(button2, null, new b(helpItem, this, null), 1, null);
            Context context = this.f15821a.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            int optionalButtonCount = helpItem.getOptionalButtonCount(context);
            TextView textView = this.f15821a.optionalLinksDescription;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.optionalLinksDescription");
            if (optionalButtonCount > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            textView.setVisibility(i5);
            Button button3 = this.f15821a.optionalButton1;
            if (optionalButtonCount == 1) {
                format = this.itemView.getContext().getString(R.string.troubleshoot_configuration_screen);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = this.itemView.getContext().getString(R.string.troubleshoot_configuration_screen_n);
                Intrinsics.checkNotNullExpressionValue(string, "itemView.context.getStri…t_configuration_screen_n)");
                format = String.format(string, Arrays.copyOf(new Object[]{1}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            button3.setText(format);
            Button button4 = this.f15821a.optionalButton1;
            Intrinsics.checkNotNullExpressionValue(button4, "binding.optionalButton1");
            if (optionalButtonCount > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            button4.setVisibility(i6);
            Button button5 = this.f15821a.optionalButton2;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = this.itemView.getContext().getString(R.string.troubleshoot_configuration_screen_n);
            Intrinsics.checkNotNullExpressionValue(string2, "itemView.context.getStri…t_configuration_screen_n)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{2}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            button5.setText(format2);
            Button button6 = this.f15821a.optionalButton2;
            Intrinsics.checkNotNullExpressionValue(button6, "binding.optionalButton2");
            if (optionalButtonCount > 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            button6.setVisibility(i7);
            Button button7 = this.f15821a.optionalButton3;
            String string3 = this.itemView.getContext().getString(R.string.troubleshoot_configuration_screen_n);
            Intrinsics.checkNotNullExpressionValue(string3, "itemView.context.getStri…t_configuration_screen_n)");
            String format3 = String.format(string3, Arrays.copyOf(new Object[]{3}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            button7.setText(format3);
            Button button8 = this.f15821a.optionalButton3;
            Intrinsics.checkNotNullExpressionValue(button8, "binding.optionalButton3");
            if (optionalButtonCount > 2) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                i8 = 8;
            }
            button8.setVisibility(i8);
            Button button9 = this.f15821a.optionalButton1;
            Intrinsics.checkNotNullExpressionValue(button9, "binding.optionalButton1");
            ViewExtensionsKt.onClick$default(button9, null, new c(helpItem, this, null), 1, null);
            Button button10 = this.f15821a.optionalButton2;
            Intrinsics.checkNotNullExpressionValue(button10, "binding.optionalButton2");
            ViewExtensionsKt.onClick$default(button10, null, new d(helpItem, this, null), 1, null);
            Button button11 = this.f15821a.optionalButton3;
            Intrinsics.checkNotNullExpressionValue(button11, "binding.optionalButton3");
            ViewExtensionsKt.onClick$default(button11, null, new e(helpItem, this, null), 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HelpListAdapter(@NotNull List<? extends HelpItem> helpItemList) {
        Intrinsics.checkNotNullParameter(helpItemList, "helpItemList");
        this.f15820a = helpItemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15820a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f15820a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        TroubleshootingHelpItemBinding inflate = TroubleshootingHelpItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate);
    }
}
