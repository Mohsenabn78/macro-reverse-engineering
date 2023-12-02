package com.arlosoft.macrodroid.actionblock.list;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.IfConditionAction;
import com.arlosoft.macrodroid.action.LoopAction;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.databinding.ViewActionBlockListItemBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.apmem.tools.layouts.FlowLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlockAdapter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nActionBlockAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockAdapter.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,246:1\n262#2,2:247\n262#2,2:249\n262#2,2:251\n262#2,2:253\n262#2,2:255\n*S KotlinDebug\n*F\n+ 1 ActionBlockAdapter.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockViewHolder\n*L\n52#1:247,2\n63#1:249,2\n64#1:251,2\n67#1:253,2\n68#1:255,2\n*E\n"})
/* loaded from: classes.dex */
public final class ActionBlockViewHolder extends RecyclerView.ViewHolder {
    public static final int MAX_NUM_SHOWN = 99;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewActionBlockListItemBinding f5612a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5613b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ActionBlockClickListener f5614c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5615d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5616e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5617f;

    /* renamed from: g  reason: collision with root package name */
    private final int f5618g;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ActionBlockAdapter.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockAdapter.kt */
    /* loaded from: classes.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ActionBlock $actionBlock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ActionBlock actionBlock, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$actionBlock = actionBlock;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$actionBlock, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlockViewHolder.this.f5614c.onActionBlockClicked(this.$actionBlock);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockAdapter.kt */
    /* loaded from: classes.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ActionBlock $actionBlock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ActionBlock actionBlock, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$actionBlock = actionBlock;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$actionBlock, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlockViewHolder.this.f5614c.onActionBlockLongClicked(this.$actionBlock);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBlockViewHolder(@NotNull ViewActionBlockListItemBinding binding, boolean z3, @NotNull ActionBlockClickListener actionBlockClickListener) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(actionBlockClickListener, "actionBlockClickListener");
        this.f5612a = binding;
        this.f5613b = z3;
        this.f5614c = actionBlockClickListener;
        this.f5615d = binding.actionBlockContainer.getResources().getColor(R.color.white);
        this.f5616e = binding.actionBlockContainer.getResources().getColor(R.color.action_block_link);
        this.f5617f = binding.actionBlockContainer.getResources().getDimensionPixelSize(R.dimen.margin_small);
        this.f5618g = binding.actionBlockContainer.getResources().getDimensionPixelSize(R.dimen.margin_micro);
    }

    private final void b(ActionBlock actionBlock, TextView textView) {
        int endLoopIndex;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        textView.setMaxLines(Settings.getListViewNumLines(this.itemView.getContext()));
        ArrayList<Action> actions = actionBlock.getActions();
        if (actionBlock.getActions().size() > 0) {
            int i4 = 0;
            while (i4 < 99) {
                if (actions.size() > i4) {
                    Action action = actions.get(i4);
                    CharSequence listModeNameCharSequence = action.getListModeNameCharSequence();
                    if (action.isEnabled()) {
                        spannableStringBuilder.append(listModeNameCharSequence);
                    } else {
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append(listModeNameCharSequence);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.itemView.getContext(), R.color.disabled_action_color)), length, spannableStringBuilder.length(), 33);
                    }
                    if (!(action instanceof IfConditionAction) ? !(!(action instanceof LoopAction) || (endLoopIndex = MacroListUtils.getEndLoopIndex(actions, i4)) < 0) : (endLoopIndex = MacroListUtils.getEndIfIndex(actions, i4)) >= 0) {
                        i4 = endLoopIndex;
                    }
                    if (i4 < actionBlock.getActions().size() - 1 && i4 < 98) {
                        spannableStringBuilder.append((CharSequence) ", ");
                    }
                }
                i4++;
            }
            textView.setText(spannableStringBuilder);
            return;
        }
        textView.setText(R.string.none);
    }

    private final void c(ActionBlock actionBlock, FlowLayout flowLayout, Map<String, ? extends ArrayList<Macro>> map) {
        int i4;
        flowLayout.removeAllViews();
        ArrayList<Macro> arrayList = map.get(actionBlock.getName());
        if (arrayList != null) {
            Iterator<Macro> it = arrayList.iterator();
            while (it.hasNext()) {
                final Macro next = it.next();
                TextView textView = new TextView(flowLayout.getContext());
                textView.setText(next.getName());
                if (next.isActionBlock) {
                    i4 = this.f5616e;
                } else {
                    i4 = this.f5615d;
                }
                textView.setTextColor(i4);
                textView.setTextSize(12.0f);
                textView.setPaintFlags(textView.getPaintFlags() | 8);
                int i5 = this.f5617f;
                int i6 = this.f5618g;
                textView.setPadding(i5, i6, i5, i6);
                flowLayout.addView(textView, -2, -2);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ActionBlockViewHolder.d(ActionBlockViewHolder.this, next, view);
                    }
                });
            }
            return;
        }
        TextView textView2 = new TextView(flowLayout.getContext());
        String string = flowLayout.getContext().getString(R.string.not_used);
        textView2.setText("(" + string + ")");
        textView2.setTextSize(12.0f);
        textView2.setTextColor(this.f5615d);
        int i7 = this.f5617f;
        int i8 = this.f5618g;
        textView2.setPadding(i7, i8, i7, i8);
        flowLayout.addView(textView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ActionBlockViewHolder this$0, Macro macro, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macro, "$macro");
        this$0.f5614c.onActionBlockNavigateToClicked(macro);
    }

    public final void bind(@NotNull ActionBlock actionBlock, @NotNull Map<String, ? extends ArrayList<Macro>> actionBlockMacroMap) {
        boolean z3;
        int i4;
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        Intrinsics.checkNotNullParameter(actionBlockMacroMap, "actionBlockMacroMap");
        this.f5612a.name.setText(actionBlock.getName());
        TextView textView = this.f5612a.description;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.description");
        String description = actionBlock.getDescription();
        if (description != null && description.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
        this.f5612a.description.setText(actionBlock.getDescription());
        LinearLayout linearLayout = this.f5612a.actionBlockContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.actionBlockContainer");
        ViewExtensionsKt.onClick$default(linearLayout, null, new a(actionBlock, null), 1, null);
        LinearLayout linearLayout2 = this.f5612a.actionBlockContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.actionBlockContainer");
        ViewExtensionsKt.onLongClick$default(linearLayout2, null, false, new b(actionBlock, null), 3, null);
        TextView textView2 = this.f5612a.actionsList;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionsList");
        b(actionBlock, textView2);
        if (this.f5613b) {
            FlowLayout flowLayout = this.f5612a.usedInList;
            Intrinsics.checkNotNullExpressionValue(flowLayout, "binding.usedInList");
            flowLayout.setVisibility(0);
            View view = this.f5612a.bottomSpace;
            Intrinsics.checkNotNullExpressionValue(view, "binding.bottomSpace");
            view.setVisibility(8);
            FlowLayout flowLayout2 = this.f5612a.usedInList;
            Intrinsics.checkNotNullExpressionValue(flowLayout2, "binding.usedInList");
            c(actionBlock, flowLayout2, actionBlockMacroMap);
            return;
        }
        FlowLayout flowLayout3 = this.f5612a.usedInList;
        Intrinsics.checkNotNullExpressionValue(flowLayout3, "binding.usedInList");
        flowLayout3.setVisibility(8);
        View view2 = this.f5612a.bottomSpace;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.bottomSpace");
        view2.setVisibility(0);
    }
}
