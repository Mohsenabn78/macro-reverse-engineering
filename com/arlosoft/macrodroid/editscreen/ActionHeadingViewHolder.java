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

/* compiled from: ActionHeadingViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nActionHeadingViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionHeadingViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/ActionHeadingViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,41:1\n262#2,2:42\n262#2,2:44\n*S KotlinDebug\n*F\n+ 1 ActionHeadingViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/ActionHeadingViewHolder\n*L\n34#1:42,2\n35#1:44,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ActionHeadingViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final HeaderCallbackInternal f11678a;
    @BindView(R.id.edit_macro_addActionButton)
    public ImageButton addActionButton;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final HeaderCallback f11679b;
    @BindView(R.id.pasteActionButton)
    public ImageButton pasteActionButton;
    @BindView(R.id.reorderActionsButton)
    public ImageButton reorderActionsButton;

    /* compiled from: ActionHeadingViewHolder.kt */
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
                ActionHeadingViewHolder.this.f11679b.onPaste();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ActionHeadingViewHolder.kt */
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
                ActionHeadingViewHolder.this.f11678a.onReorder();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ActionHeadingViewHolder.kt */
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
                ActionHeadingViewHolder.this.f11679b.onAdd();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionHeadingViewHolder(@NotNull View itemView, @NotNull HeaderCallbackInternal headerCallbackInternal, @NotNull HeaderCallback headerCallback) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(headerCallbackInternal, "headerCallbackInternal");
        Intrinsics.checkNotNullParameter(headerCallback, "headerCallback");
        this.f11678a = headerCallbackInternal;
        this.f11679b = headerCallback;
        ButterKnife.bind(this, itemView);
    }

    public final void bind(boolean z3, boolean z4) {
        int i4;
        ImageButton reorderActionsButton$app_standardRelease = getReorderActionsButton$app_standardRelease();
        int i5 = 0;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        reorderActionsButton$app_standardRelease.setVisibility(i4);
        ImageButton pasteActionButton$app_standardRelease = getPasteActionButton$app_standardRelease();
        if (!z4) {
            i5 = 8;
        }
        pasteActionButton$app_standardRelease.setVisibility(i5);
        ViewExtensionsKt.onClick$default(getPasteActionButton$app_standardRelease(), null, new a(null), 1, null);
        ViewExtensionsKt.onClick$default(getReorderActionsButton$app_standardRelease(), null, new b(null), 1, null);
        ViewExtensionsKt.onClick$default(getAddActionButton$app_standardRelease(), null, new c(null), 1, null);
    }

    @NotNull
    public final ImageButton getAddActionButton$app_standardRelease() {
        ImageButton imageButton = this.addActionButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("addActionButton");
        return null;
    }

    @NotNull
    public final ImageButton getPasteActionButton$app_standardRelease() {
        ImageButton imageButton = this.pasteActionButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pasteActionButton");
        return null;
    }

    @NotNull
    public final ImageButton getReorderActionsButton$app_standardRelease() {
        ImageButton imageButton = this.reorderActionsButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reorderActionsButton");
        return null;
    }

    public final void setAddActionButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.addActionButton = imageButton;
    }

    public final void setPasteActionButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.pasteActionButton = imageButton;
    }

    public final void setReorderActionsButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.reorderActionsButton = imageButton;
    }
}
