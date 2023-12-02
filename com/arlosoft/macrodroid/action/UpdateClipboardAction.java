package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.UpdateClipboardAction;
import com.arlosoft.macrodroid.action.info.UpdateClipboardActionInfo;
import com.arlosoft.macrodroid.clipboard.ClipboardReadActivity;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UpdateClipboardAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class UpdateClipboardAction extends Action implements BlockingAction {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final Parcelable.Creator<UpdateClipboardAction> CREATOR = new Parcelable.Creator<UpdateClipboardAction>() { // from class: com.arlosoft.macrodroid.action.UpdateClipboardAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public UpdateClipboardAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UpdateClipboardAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public UpdateClipboardAction[] newArray(int i4) {
            return new UpdateClipboardAction[i4];
        }
    };

    /* compiled from: UpdateClipboardAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ boolean $isTest;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
        int label;
        final /* synthetic */ UpdateClipboardAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z3, UpdateClipboardAction updateClipboardAction, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$isTest = z3;
            this.this$0 = updateClipboardAction;
            this.$nextAction = i4;
            this.$contextInfo = triggerContextInfo;
            this.$forceEvenIfNotEnabled = z4;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(UpdateClipboardAction updateClipboardAction, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack stack, ResumeMacroInfo resumeMacroInfo) {
            updateClipboardAction.getMacro().invokeActions(updateClipboardAction.getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$isTest, this.this$0, this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(2500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!this.$isTest) {
                Handler handler = new Handler(Looper.getMainLooper());
                final UpdateClipboardAction updateClipboardAction = this.this$0;
                final int i5 = this.$nextAction;
                final TriggerContextInfo triggerContextInfo = this.$contextInfo;
                final boolean z3 = this.$forceEvenIfNotEnabled;
                final Stack<Integer> stack = this.$skipEndifIndexStack;
                final ResumeMacroInfo resumeMacroInfo = this.$resumeMacroInfo;
                handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.tt
                    @Override // java.lang.Runnable
                    public final void run() {
                        UpdateClipboardAction.a.b(UpdateClipboardAction.this, i5, triggerContextInfo, z3, stack, resumeMacroInfo);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ UpdateClipboardAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return UpdateClipboardActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
    }

    public UpdateClipboardAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        Intent intent = new Intent(getContext(), ClipboardReadActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("do_not_trigger", true);
        getContext().startActivity(intent);
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, null, null, new a(z4, this, i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo, null), 3, null);
    }

    public UpdateClipboardAction() {
    }

    private UpdateClipboardAction(Parcel parcel) {
        super(parcel);
    }

    /* compiled from: UpdateClipboardAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
