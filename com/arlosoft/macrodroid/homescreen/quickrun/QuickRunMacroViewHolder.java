package com.arlosoft.macrodroid.homescreen.quickrun;

import android.view.View;
import android.widget.ImageView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.databinding.ListItemQuickRunMacroBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;
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

/* compiled from: QuickRunMacroAdapter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nQuickRunMacroAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QuickRunMacroAdapter.kt\ncom/arlosoft/macrodroid/homescreen/quickrun/QuickRunMacroViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,117:1\n262#2,2:118\n*S KotlinDebug\n*F\n+ 1 QuickRunMacroAdapter.kt\ncom/arlosoft/macrodroid/homescreen/quickrun/QuickRunMacroViewHolder\n*L\n30#1:118,2\n*E\n"})
/* loaded from: classes3.dex */
public final class QuickRunMacroViewHolder extends AbstractDraggableItemViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ListItemQuickRunMacroBinding f12399b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final MacroSelectionListener f12400c;

    /* compiled from: QuickRunMacroAdapter.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Macro $macro;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Macro macro, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$macro = macro;
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
                MacroSelectionListener macroSelectionListener = QuickRunMacroViewHolder.this.f12400c;
                if (macroSelectionListener != null) {
                    macroSelectionListener.onMacroDeleted(this.$macro);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickRunMacroViewHolder(@NotNull ListItemQuickRunMacroBinding binding, @Nullable MacroSelectionListener macroSelectionListener) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.f12399b = binding;
        this.f12400c = macroSelectionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QuickRunMacroViewHolder this$0, Macro macro, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macro, "$macro");
        MacroSelectionListener macroSelectionListener = this$0.f12400c;
        if (macroSelectionListener != null) {
            macroSelectionListener.onMacroSelected(macro);
        }
    }

    public final void bind(@NotNull final Macro macro, boolean z3) {
        int i4;
        Intrinsics.checkNotNullParameter(macro, "macro");
        this.f12399b.macroName.setText(macro.getName());
        this.f12399b.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickRunMacroViewHolder.b(QuickRunMacroViewHolder.this, macro, view);
            }
        });
        ImageView imageView = this.f12399b.deleteButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.deleteButton");
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        ImageView imageView2 = this.f12399b.deleteButton;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.deleteButton");
        ViewExtensionsKt.onClick$default(imageView2, null, new a(macro, null), 1, null);
    }
}
