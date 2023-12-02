package com.arlosoft.macrodroid.troubleshooting.problem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.TroubleshootingProblemBinding;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.troubleshooting.problem.ProblemsListAdapter;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProblemsListAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ProblemsListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<Problem> f15845a;

    /* compiled from: ProblemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    @SourceDebugExtension({"SMAP\nProblemsListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProblemsListAdapter.kt\ncom/arlosoft/macrodroid/troubleshooting/problem/ProblemsListAdapter$ViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,87:1\n262#2,2:88\n262#2,2:90\n262#2,2:92\n262#2,2:94\n262#2,2:96\n262#2,2:98\n*S KotlinDebug\n*F\n+ 1 ProblemsListAdapter.kt\ncom/arlosoft/macrodroid/troubleshooting/problem/ProblemsListAdapter$ViewHolder\n*L\n33#1:88,2\n35#1:90,2\n39#1:92,2\n41#1:94,2\n49#1:96,2\n51#1:98,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final TroubleshootingProblemBinding f15846a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15847b;

        /* renamed from: c  reason: collision with root package name */
        private final int f15848c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ProblemsListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ Problem $problem;
            int label;
            final /* synthetic */ ViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Problem problem, ViewHolder viewHolder, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$problem = problem;
                this.this$0 = viewHolder;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$problem, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Problem problem = this.$problem;
                    Context context = this.this$0.itemView.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    problem.invokeConfigure((Activity) context);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ProblemsListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ Problem $problem;
            int label;
            final /* synthetic */ ViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Problem problem, ViewHolder viewHolder, Continuation<? super b> continuation) {
                super(3, continuation);
                this.$problem = problem;
                this.this$0 = viewHolder;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new b(this.$problem, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Problem problem = this.$problem;
                    Context context = this.this$0.itemView.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    problem.invokeConfigure2((Activity) context);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull TroubleshootingProblemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15846a = binding;
            this.f15847b = this.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small);
            this.f15848c = this.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_micro);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ViewHolder this$0, Macro macro, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(macro, "$macro");
            Intent intent = new Intent(this$0.itemView.getContext(), EditMacroActivity.class);
            intent.putExtra("MacroId", macro.getId());
            this$0.itemView.getContext().startActivity(intent);
        }

        public final void bind(@NotNull Problem problem) {
            Intrinsics.checkNotNullParameter(problem, "problem");
            TextView textView = this.f15846a.problemDescription;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            textView.setText(problem.getDescriptionText(context));
            Context context2 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            String titleText = problem.getTitleText(context2);
            if (titleText != null) {
                this.f15846a.problemTitle.setText(titleText);
                TextView textView2 = this.f15846a.problemTitle;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.problemTitle");
                textView2.setVisibility(0);
            } else {
                TextView textView3 = this.f15846a.problemTitle;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.problemTitle");
                textView3.setVisibility(8);
            }
            if (problem.getButtonText() == null) {
                Button button = this.f15846a.configureButton;
                Intrinsics.checkNotNullExpressionValue(button, "binding.configureButton");
                button.setVisibility(8);
            } else {
                Button button2 = this.f15846a.configureButton;
                Intrinsics.checkNotNullExpressionValue(button2, "binding.configureButton");
                button2.setVisibility(0);
                this.f15846a.configureButton.setText(this.itemView.getContext().getString(problem.getButtonText().intValue()));
                Button button3 = this.f15846a.configureButton;
                Intrinsics.checkNotNullExpressionValue(button3, "binding.configureButton");
                ViewExtensionsKt.onClick$default(button3, null, new a(problem, this, null), 1, null);
            }
            if (problem.getButton2Text() == null) {
                Button button4 = this.f15846a.configureButton2;
                Intrinsics.checkNotNullExpressionValue(button4, "binding.configureButton2");
                button4.setVisibility(8);
            } else {
                Button button5 = this.f15846a.configureButton2;
                Intrinsics.checkNotNullExpressionValue(button5, "binding.configureButton2");
                button5.setVisibility(0);
                this.f15846a.configureButton2.setText(this.itemView.getContext().getString(problem.getButton2Text().intValue()));
                Button button6 = this.f15846a.configureButton2;
                Intrinsics.checkNotNullExpressionValue(button6, "binding.configureButton2");
                ViewExtensionsKt.onClick$default(button6, null, new b(problem, this, null), 1, null);
            }
            for (final Macro macro : problem.getMacroList()) {
                TextView textView4 = new TextView(this.itemView.getContext());
                textView4.setText(macro.getName());
                textView4.setTextColor(-1);
                textView4.setTextSize(12.0f);
                textView4.setPaintFlags(textView4.getPaintFlags() | 8);
                int i4 = this.f15847b;
                int i5 = this.f15848c;
                textView4.setPadding(i4, i5, i4, i5);
                this.f15846a.macroList.addView(textView4, -2, -2);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.troubleshooting.problem.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProblemsListAdapter.ViewHolder.b(ProblemsListAdapter.ViewHolder.this, macro, view);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProblemsListAdapter(@NotNull List<? extends Problem> problemList) {
        Intrinsics.checkNotNullParameter(problemList, "problemList");
        this.f15845a = problemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15845a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f15845a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        TroubleshootingProblemBinding inflate = TroubleshootingProblemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate);
    }
}
