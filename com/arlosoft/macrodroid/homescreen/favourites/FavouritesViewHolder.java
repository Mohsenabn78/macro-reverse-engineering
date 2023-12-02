package com.arlosoft.macrodroid.homescreen.favourites;

import android.view.View;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.databinding.ListItemFavouritesBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FavouritesAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FavouritesViewHolder extends AbstractDraggableItemViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ListItemFavouritesBinding f12347b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final MacroSelectionListener f12348c;

    /* compiled from: FavouritesAdapter.kt */
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
                MacroSelectionListener macroSelectionListener = FavouritesViewHolder.this.f12348c;
                if (macroSelectionListener != null) {
                    macroSelectionListener.onMacroSelected(this.$macro);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavouritesViewHolder(@NotNull ListItemFavouritesBinding binding, @Nullable MacroSelectionListener macroSelectionListener) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.f12347b = binding;
        this.f12348c = macroSelectionListener;
    }

    public final void bind(@NotNull Macro macro, boolean z3) {
        float f4;
        Intrinsics.checkNotNullParameter(macro, "macro");
        this.f12347b.macroName.setText(macro.getName());
        TextView textView = this.f12347b.macroName;
        float f5 = 0.5f;
        if (!macro.isEnabled()) {
            f4 = 0.5f;
        } else {
            f4 = 1.0f;
        }
        textView.setAlpha(f4);
        TextView textView2 = this.f12347b.macroName;
        if (macro.isEnabled()) {
            f5 = 1.0f;
        }
        textView2.setAlpha(f5);
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ViewExtensionsKt.onClick$default(itemView, null, new a(macro, null), 1, null);
    }
}
