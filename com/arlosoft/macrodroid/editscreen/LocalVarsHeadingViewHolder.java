package com.arlosoft.macrodroid.editscreen;

import android.view.View;
import android.widget.ImageButton;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalVarsHeadingViewHolder.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LocalVarsHeadingViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final HeaderCallback f11819a;
    @BindView(R.id.addVariableButton)
    public ImageButton addVariableButton;

    /* compiled from: LocalVarsHeadingViewHolder.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LocalVarsHeadingViewHolder.this.f11819a.onAdd();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVarsHeadingViewHolder(@NotNull View itemView, @NotNull HeaderCallback headerCallback) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(headerCallback, "headerCallback");
        this.f11819a = headerCallback;
        ButterKnife.bind(this, itemView);
    }

    public final void bind() {
        ViewExtensionsKt.onClick$default(getAddVariableButton$app_standardRelease(), null, new a(null), 1, null);
    }

    @NotNull
    public final ImageButton getAddVariableButton$app_standardRelease() {
        ImageButton imageButton = this.addVariableButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("addVariableButton");
        return null;
    }

    public final void setAddVariableButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.addVariableButton = imageButton;
    }
}
