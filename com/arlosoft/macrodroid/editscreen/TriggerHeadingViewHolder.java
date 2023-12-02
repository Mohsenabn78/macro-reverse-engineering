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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TriggerHeadingViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTriggerHeadingViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TriggerHeadingViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/TriggerHeadingViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,41:1\n262#2,2:42\n262#2,2:44\n*S KotlinDebug\n*F\n+ 1 TriggerHeadingViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/TriggerHeadingViewHolder\n*L\n34#1:42,2\n35#1:44,2\n*E\n"})
/* loaded from: classes3.dex */
public final class TriggerHeadingViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final HeaderCallbackInternal f11869a;
    @BindView(R.id.edit_macro_addTriggerButton)
    public ImageButton addTriggerButton;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final HeaderCallback f11870b;
    @BindView(R.id.pasteTriggerButton)
    public ImageButton pasteTriggerButton;
    @BindView(R.id.reorderTriggersButton)
    public ImageButton reorderTriggersButton;

    /* compiled from: TriggerHeadingViewHolder.kt */
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
                TriggerHeadingViewHolder.this.f11870b.onPaste();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TriggerHeadingViewHolder.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TriggerHeadingViewHolder.this.f11869a.onReorder();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TriggerHeadingViewHolder.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TriggerHeadingViewHolder.this.f11870b.onAdd();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerHeadingViewHolder(@NotNull View itemView, @NotNull HeaderCallbackInternal headerCallbackInternal, @NotNull HeaderCallback headerCallback) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(headerCallbackInternal, "headerCallbackInternal");
        Intrinsics.checkNotNullParameter(headerCallback, "headerCallback");
        this.f11869a = headerCallbackInternal;
        this.f11870b = headerCallback;
        ButterKnife.bind(this, itemView);
    }

    public final void bind(boolean z3, boolean z4) {
        int i4;
        ImageButton reorderTriggersButton$app_standardRelease = getReorderTriggersButton$app_standardRelease();
        int i5 = 0;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        reorderTriggersButton$app_standardRelease.setVisibility(i4);
        ImageButton pasteTriggerButton$app_standardRelease = getPasteTriggerButton$app_standardRelease();
        if (!z4) {
            i5 = 8;
        }
        pasteTriggerButton$app_standardRelease.setVisibility(i5);
        ViewExtensionsKt.onClick$default(getPasteTriggerButton$app_standardRelease(), null, new a(null), 1, null);
        ViewExtensionsKt.onClick$default(getReorderTriggersButton$app_standardRelease(), null, new b(null), 1, null);
        ViewExtensionsKt.onClick$default(getAddTriggerButton$app_standardRelease(), null, new c(null), 1, null);
    }

    @NotNull
    public final ImageButton getAddTriggerButton$app_standardRelease() {
        ImageButton imageButton = this.addTriggerButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("addTriggerButton");
        return null;
    }

    @NotNull
    public final ImageButton getPasteTriggerButton$app_standardRelease() {
        ImageButton imageButton = this.pasteTriggerButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pasteTriggerButton");
        return null;
    }

    @NotNull
    public final ImageButton getReorderTriggersButton$app_standardRelease() {
        ImageButton imageButton = this.reorderTriggersButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reorderTriggersButton");
        return null;
    }

    public final void setAddTriggerButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.addTriggerButton = imageButton;
    }

    public final void setPasteTriggerButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.pasteTriggerButton = imageButton;
    }

    public final void setReorderTriggersButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.reorderTriggersButton = imageButton;
    }
}
