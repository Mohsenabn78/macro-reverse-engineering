package com.arlosoft.macrodroid.editscreen;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstraintHeadingViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nConstraintHeadingViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstraintHeadingViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/ConstraintHeadingViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,63:1\n262#2,2:64\n262#2,2:66\n262#2,2:68\n*S KotlinDebug\n*F\n+ 1 ConstraintHeadingViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/ConstraintHeadingViewHolder\n*L\n44#1:64,2\n45#1:66,2\n46#1:68,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ConstraintHeadingViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final HeaderCallbackInternal f11732a;
    @BindView(R.id.edit_macro_addConstraintButton)
    public ImageButton addConstraintButton;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final HeaderCallbackConstraint f11733b;
    @BindView(R.id.constraintAndOrSpinner)
    public Spinner constraintAndOrSpinner;
    @BindView(R.id.pasteConstraintButton)
    public ImageButton pasteConstraintButton;
    @BindView(R.id.reorderConstraintsButton)
    public ImageButton reorderConstraintsButton;

    /* compiled from: ConstraintHeadingViewHolder.kt */
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
                ConstraintHeadingViewHolder.this.f11733b.onPaste();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ConstraintHeadingViewHolder.kt */
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
                ConstraintHeadingViewHolder.this.f11732a.onReorder();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ConstraintHeadingViewHolder.kt */
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
                ConstraintHeadingViewHolder.this.f11733b.onAdd();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ConstraintHeadingViewHolder.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<Integer, Unit> {
        final /* synthetic */ Ref.BooleanRef $ignoreConstraintSpinnerFirstTime;
        final /* synthetic */ ConstraintHeadingViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Ref.BooleanRef booleanRef, ConstraintHeadingViewHolder constraintHeadingViewHolder) {
            super(1);
            this.$ignoreConstraintSpinnerFirstTime = booleanRef;
            this.this$0 = constraintHeadingViewHolder;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i4) {
            if (!this.$ignoreConstraintSpinnerFirstTime.element) {
                this.this$0.f11733b.onLogicItemChanged(i4 == 0);
            }
            this.$ignoreConstraintSpinnerFirstTime.element = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintHeadingViewHolder(@NotNull View itemView, @NotNull HeaderCallbackInternal headerCallbackInternal, @NotNull HeaderCallbackConstraint headerCallback) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(headerCallbackInternal, "headerCallbackInternal");
        Intrinsics.checkNotNullParameter(headerCallback, "headerCallback");
        this.f11732a = headerCallbackInternal;
        this.f11733b = headerCallback;
        ButterKnife.bind(this, itemView);
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(getConstraintAndOrSpinner$app_standardRelease().getContext(), R.array.constraint_and_or_options, R.layout.simple_spinner_item_white_text);
        Intrinsics.checkNotNullExpressionValue(createFromResource, "createFromResource(const…_spinner_item_white_text)");
        createFromResource.setDropDownViewResource(17367049);
        getConstraintAndOrSpinner$app_standardRelease().setAdapter((SpinnerAdapter) createFromResource);
    }

    public final void bind(boolean z3, boolean z4, boolean z5, boolean z6) {
        int i4;
        int i5;
        ImageButton reorderConstraintsButton$app_standardRelease = getReorderConstraintsButton$app_standardRelease();
        int i6 = 0;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        reorderConstraintsButton$app_standardRelease.setVisibility(i4);
        ImageButton pasteConstraintButton$app_standardRelease = getPasteConstraintButton$app_standardRelease();
        if (z6) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        pasteConstraintButton$app_standardRelease.setVisibility(i5);
        Spinner constraintAndOrSpinner$app_standardRelease = getConstraintAndOrSpinner$app_standardRelease();
        if (!z4) {
            i6 = 8;
        }
        constraintAndOrSpinner$app_standardRelease.setVisibility(i6);
        ViewExtensionsKt.onClick$default(getPasteConstraintButton$app_standardRelease(), null, new a(null), 1, null);
        ViewExtensionsKt.onClick$default(getReorderConstraintsButton$app_standardRelease(), null, new b(null), 1, null);
        ViewExtensionsKt.onClick$default(getAddConstraintButton$app_standardRelease(), null, new c(null), 1, null);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        getConstraintAndOrSpinner$app_standardRelease().setOnItemSelectedListener(null);
        getConstraintAndOrSpinner$app_standardRelease().setSelection(!z5 ? 1 : 0);
        ViewExtensionsKt.itemSelected(getConstraintAndOrSpinner$app_standardRelease(), new d(booleanRef, this));
    }

    @NotNull
    public final ImageButton getAddConstraintButton$app_standardRelease() {
        ImageButton imageButton = this.addConstraintButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("addConstraintButton");
        return null;
    }

    @NotNull
    public final Spinner getConstraintAndOrSpinner$app_standardRelease() {
        Spinner spinner = this.constraintAndOrSpinner;
        if (spinner != null) {
            return spinner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("constraintAndOrSpinner");
        return null;
    }

    @NotNull
    public final ImageButton getPasteConstraintButton$app_standardRelease() {
        ImageButton imageButton = this.pasteConstraintButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pasteConstraintButton");
        return null;
    }

    @NotNull
    public final ImageButton getReorderConstraintsButton$app_standardRelease() {
        ImageButton imageButton = this.reorderConstraintsButton;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reorderConstraintsButton");
        return null;
    }

    public final void setAddConstraintButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.addConstraintButton = imageButton;
    }

    public final void setConstraintAndOrSpinner$app_standardRelease(@NotNull Spinner spinner) {
        Intrinsics.checkNotNullParameter(spinner, "<set-?>");
        this.constraintAndOrSpinner = spinner;
    }

    public final void setPasteConstraintButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.pasteConstraintButton = imageButton;
    }

    public final void setReorderConstraintsButton$app_standardRelease(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.reorderConstraintsButton = imageButton;
    }
}
