package com.arlosoft.macrodroid.triggers.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.databinding.DialogLogcatTextToMatchBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logcat.LogcatButtonService;
import com.arlosoft.macrodroid.logcat.LogcatMessage;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.LogcatTrigger;
import com.arlosoft.macrodroid.triggers.info.LogcatTriggerInfo;
import com.arlosoft.macrodroid.utils.AdbHelperUtil;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import splitties.alertdialog.AlertDialogKt;

/* compiled from: LogcatConfigActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nLogcatConfigActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogcatConfigActivity.kt\ncom/arlosoft/macrodroid/triggers/activities/LogcatConfigActivity\n+ 2 AlertDialog.kt\nsplitties/alertdialog/AlertDialogKt\n*L\n1#1,246:1\n28#2,3:247\n167#2,2:250\n185#2,2:252\n31#2:254\n*S KotlinDebug\n*F\n+ 1 LogcatConfigActivity.kt\ncom/arlosoft/macrodroid/triggers/activities/LogcatConfigActivity\n*L\n226#1:247,3\n229#1:250,2\n240#1:252,2\n226#1:254\n*E\n"})
/* loaded from: classes3.dex */
public final class LogcatConfigActivity extends MacroDroidBaseActivity {
    @NotNull
    public static final String EXTRA_ENABLED_BUFFERS = "enabled_buffers";
    @NotNull
    public static final String EXTRA_IGNORE_CASE = "ignore_case";
    @NotNull
    public static final String EXTRA_LOGCAT_MESSAGE = "logcat_message";
    @NotNull
    public static final String EXTRA_TRIGGER = "trigger";
    public static final int REQUEST_CODE = 1;

    /* renamed from: f  reason: collision with root package name */
    private DialogLogcatTextToMatchBinding f14515f;

    /* renamed from: g  reason: collision with root package name */
    private Macro f14516g;

    /* renamed from: h  reason: collision with root package name */
    private LogcatTrigger f14517h;

    /* renamed from: i  reason: collision with root package name */
    private int f14518i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14519j;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: LogcatConfigActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launchActivity(@NotNull Activity activity, @NotNull Macro macro, @NotNull LogcatTrigger trigger, @Nullable LogcatMessage logcatMessage, int i4, boolean z3) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(macro, "macro");
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            Intent intent = new Intent(activity, LogcatConfigActivity.class);
            intent.putExtra("Macro", macro);
            intent.putExtra("trigger", trigger);
            intent.putExtra(LogcatConfigActivity.EXTRA_LOGCAT_MESSAGE, logcatMessage);
            intent.putExtra("enabled_buffers", i4);
            intent.putExtra(LogcatConfigActivity.EXTRA_IGNORE_CASE, z3);
            activity.startActivityForResult(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogcatConfigActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(MagicText.MagicTextListener magicTextListener, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$magicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$magicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LogcatConfigActivity logcatConfigActivity = LogcatConfigActivity.this;
                MagicText.MagicTextListener magicTextListener = this.$magicTextListener;
                Macro macro = logcatConfigActivity.f14516g;
                if (macro == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro = null;
                }
                MagicText.displaySelectionDialog(logcatConfigActivity, magicTextListener, macro, R.style.Theme_App_Dialog_Action_SmallText, true, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogcatConfigActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $magicTextListenerComponent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MagicText.MagicTextListener magicTextListener, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$magicTextListenerComponent = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$magicTextListenerComponent, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LogcatConfigActivity logcatConfigActivity = LogcatConfigActivity.this;
                MagicText.MagicTextListener magicTextListener = this.$magicTextListenerComponent;
                Macro macro = logcatConfigActivity.f14516g;
                if (macro == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro = null;
                }
                MagicText.displaySelectionDialog(logcatConfigActivity, magicTextListener, macro, R.style.Theme_App_Dialog_Action_SmallText, true, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogcatConfigActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                if (ContextCompat.checkSelfPermission(Gradients.INSTANCE.getContext(), "android.permission.READ_LOGS") != 0) {
                    LogcatConfigActivity.this.w();
                } else {
                    LogcatConfigActivity.this.r();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogcatConfigActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding = LogcatConfigActivity.this.f14515f;
                DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding2 = null;
                if (dialogLogcatTextToMatchBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogLogcatTextToMatchBinding = null;
                }
                Editable text = dialogLogcatTextToMatchBinding.textToMatch.getText();
                if (text != null && text.length() != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!z3) {
                    int t3 = LogcatConfigActivity.this.t();
                    if (t3 == 0) {
                        ToastCompat.makeText(LogcatConfigActivity.this, (int) R.string.action_set_bluetooth_invalid, 1).show();
                    } else {
                        Intent intent = new Intent();
                        LogcatConfigActivity logcatConfigActivity = LogcatConfigActivity.this;
                        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding3 = logcatConfigActivity.f14515f;
                        if (dialogLogcatTextToMatchBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            dialogLogcatTextToMatchBinding3 = null;
                        }
                        String valueOf = String.valueOf(dialogLogcatTextToMatchBinding3.componentName.getText());
                        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding4 = logcatConfigActivity.f14515f;
                        if (dialogLogcatTextToMatchBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            dialogLogcatTextToMatchBinding4 = null;
                        }
                        intent.putExtra(LogcatConfigActivity.EXTRA_LOGCAT_MESSAGE, new LogcatMessage(valueOf, String.valueOf(dialogLogcatTextToMatchBinding4.textToMatch.getText())));
                        intent.putExtra("enabled_buffers", t3);
                        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding5 = logcatConfigActivity.f14515f;
                        if (dialogLogcatTextToMatchBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            dialogLogcatTextToMatchBinding2 = dialogLogcatTextToMatchBinding5;
                        }
                        intent.putExtra(LogcatConfigActivity.EXTRA_IGNORE_CASE, dialogLogcatTextToMatchBinding2.ignoreCase.isChecked());
                        LogcatConfigActivity.this.setResult(-1, intent);
                        LogcatConfigActivity.this.finish();
                    }
                } else {
                    ToastCompat.makeText(LogcatConfigActivity.this, (int) R.string.enter_text, 1).show();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogcatConfigActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        e(Continuation<? super e> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LogcatConfigActivity.this.setResult(0);
                LogcatConfigActivity.this.finish();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void o(LogcatMessage logcatMessage) {
        boolean z3;
        String componentName;
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding = this.f14515f;
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding2 = null;
        if (dialogLogcatTextToMatchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding = null;
        }
        AppCompatEditText appCompatEditText = dialogLogcatTextToMatchBinding.textToMatch;
        LogcatTrigger logcatTrigger = this.f14517h;
        if (logcatTrigger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trigger");
            logcatTrigger = null;
        }
        appCompatEditText.setText(logcatTrigger.getTextToMatch());
        MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.activities.m
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                LogcatConfigActivity.p(LogcatConfigActivity.this, magicTextPair);
            }
        };
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding3 = this.f14515f;
        if (dialogLogcatTextToMatchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding3 = null;
        }
        AppCompatEditText appCompatEditText2 = dialogLogcatTextToMatchBinding3.componentName;
        LogcatTrigger logcatTrigger2 = this.f14517h;
        if (logcatTrigger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trigger");
            logcatTrigger2 = null;
        }
        if (logcatTrigger2.getComponentName().length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            componentName = "*";
        } else {
            LogcatTrigger logcatTrigger3 = this.f14517h;
            if (logcatTrigger3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("trigger");
                logcatTrigger3 = null;
            }
            componentName = logcatTrigger3.getComponentName();
        }
        appCompatEditText2.setText(componentName);
        MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.activities.n
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                LogcatConfigActivity.q(LogcatConfigActivity.this, magicTextPair);
            }
        };
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding4 = this.f14515f;
        if (dialogLogcatTextToMatchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding4 = null;
        }
        dialogLogcatTextToMatchBinding4.bufferMainCheckbox.setChecked(v(1));
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding5 = this.f14515f;
        if (dialogLogcatTextToMatchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding5 = null;
        }
        dialogLogcatTextToMatchBinding5.bufferSystemCheckbox.setChecked(v(2));
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding6 = this.f14515f;
        if (dialogLogcatTextToMatchBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding6 = null;
        }
        dialogLogcatTextToMatchBinding6.bufferCrashCheckbox.setChecked(v(4));
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding7 = this.f14515f;
        if (dialogLogcatTextToMatchBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding7 = null;
        }
        dialogLogcatTextToMatchBinding7.bufferKernelCheckbox.setChecked(v(8));
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding8 = this.f14515f;
        if (dialogLogcatTextToMatchBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding8 = null;
        }
        dialogLogcatTextToMatchBinding8.bufferRadioCheckbox.setChecked(v(16));
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding9 = this.f14515f;
        if (dialogLogcatTextToMatchBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding9 = null;
        }
        dialogLogcatTextToMatchBinding9.bufferEventsCheckbox.setChecked(v(32));
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding10 = this.f14515f;
        if (dialogLogcatTextToMatchBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding10 = null;
        }
        dialogLogcatTextToMatchBinding10.ignoreCase.setChecked(this.f14519j);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding11 = this.f14515f;
        if (dialogLogcatTextToMatchBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding11 = null;
        }
        Button button = dialogLogcatTextToMatchBinding11.magicTextButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.magicTextButton");
        ViewExtensionsKt.onClick$default(button, null, new a(magicTextListener, null), 1, null);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding12 = this.f14515f;
        if (dialogLogcatTextToMatchBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding12 = null;
        }
        Button button2 = dialogLogcatTextToMatchBinding12.componentMagicTextButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.componentMagicTextButton");
        ViewExtensionsKt.onClick$default(button2, null, new b(magicTextListener2, null), 1, null);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding13 = this.f14515f;
        if (dialogLogcatTextToMatchBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding13 = null;
        }
        Button button3 = dialogLogcatTextToMatchBinding13.captureMessagesButton;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.captureMessagesButton");
        ViewExtensionsKt.onClick$default(button3, null, new c(null), 1, null);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding14 = this.f14515f;
        if (dialogLogcatTextToMatchBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding14 = null;
        }
        Button button4 = dialogLogcatTextToMatchBinding14.buttonBar.okButton;
        Intrinsics.checkNotNullExpressionValue(button4, "binding.buttonBar.okButton");
        ViewExtensionsKt.onClick$default(button4, null, new d(null), 1, null);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding15 = this.f14515f;
        if (dialogLogcatTextToMatchBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding15 = null;
        }
        Button button5 = dialogLogcatTextToMatchBinding15.buttonBar.cancelButton;
        Intrinsics.checkNotNullExpressionValue(button5, "binding.buttonBar.cancelButton");
        ViewExtensionsKt.onClick$default(button5, null, new e(null), 1, null);
        if (logcatMessage != null) {
            DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding16 = this.f14515f;
            if (dialogLogcatTextToMatchBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogLogcatTextToMatchBinding16 = null;
            }
            dialogLogcatTextToMatchBinding16.componentName.setText(logcatMessage.getComponent());
            DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding17 = this.f14515f;
            if (dialogLogcatTextToMatchBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogLogcatTextToMatchBinding2 = dialogLogcatTextToMatchBinding17;
            }
            dialogLogcatTextToMatchBinding2.textToMatch.setText(logcatMessage.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(LogcatConfigActivity this$0, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding = this$0.f14515f;
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding2 = null;
        if (dialogLogcatTextToMatchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding = null;
        }
        int max = Math.max(dialogLogcatTextToMatchBinding.textToMatch.getSelectionStart(), 0);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding3 = this$0.f14515f;
        if (dialogLogcatTextToMatchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding3 = null;
        }
        int max2 = Math.max(dialogLogcatTextToMatchBinding3.textToMatch.getSelectionEnd(), 0);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding4 = this$0.f14515f;
        if (dialogLogcatTextToMatchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogLogcatTextToMatchBinding2 = dialogLogcatTextToMatchBinding4;
        }
        Editable text = dialogLogcatTextToMatchBinding2.textToMatch.getText();
        Intrinsics.checkNotNull(text);
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(LogcatConfigActivity this$0, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding = this$0.f14515f;
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding2 = null;
        if (dialogLogcatTextToMatchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding = null;
        }
        AppCompatEditText appCompatEditText = dialogLogcatTextToMatchBinding.componentName;
        Intrinsics.checkNotNull(appCompatEditText);
        int max = Math.max(appCompatEditText.getSelectionStart(), 0);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding3 = this$0.f14515f;
        if (dialogLogcatTextToMatchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding3 = null;
        }
        int max2 = Math.max(dialogLogcatTextToMatchBinding3.componentName.getSelectionEnd(), 0);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding4 = this$0.f14515f;
        if (dialogLogcatTextToMatchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogLogcatTextToMatchBinding2 = dialogLogcatTextToMatchBinding4;
        }
        Editable text = dialogLogcatTextToMatchBinding2.componentName.getText();
        if (text != null) {
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            String str = magicTextPair.magicText;
            text.replace(min, max3, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        boolean canDrawOverlays;
        if (Build.VERSION.SDK_INT >= 23) {
            canDrawOverlays = Settings.canDrawOverlays(this);
            if (!canDrawOverlays) {
                PermissionsHelper.showCanDrawOverlaysRequiredDialog(this, false, false);
                return;
            }
        }
        final int t3 = t();
        if (t3 == 0) {
            ToastCompat.makeText(this, (int) R.string.action_set_bluetooth_invalid, 1).show();
            return;
        }
        com.arlosoft.macrodroid.settings.Settings.setLogcatEnabledBuffers(Gradients.INSTANCE.getContext(), t3);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialogKt.setTitleResource(builder, R.string.trigger_logcat_capture_messages);
        AlertDialogKt.setMessageResource(builder, R.string.trigger_logcat_capture_messages_detail);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.LogcatConfigActivity$enableDrawOverlaysAndShowDialog$lambda$7$$inlined$okButton$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(@NotNull DialogInterface dialog, int i4) {
                LogcatTrigger logcatTrigger;
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                LogcatButtonService.Companion companion = LogcatButtonService.Companion;
                LogcatConfigActivity logcatConfigActivity = LogcatConfigActivity.this;
                Macro macro = logcatConfigActivity.f14516g;
                LogcatTrigger logcatTrigger2 = null;
                if (macro == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro = null;
                }
                logcatTrigger = LogcatConfigActivity.this.f14517h;
                if (logcatTrigger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("trigger");
                } else {
                    logcatTrigger2 = logcatTrigger;
                }
                companion.createService(logcatConfigActivity, macro, logcatTrigger2, t3);
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.HOME");
                    intent.setFlags(268435456);
                    LogcatConfigActivity.this.startActivity(intent);
                } catch (Exception unused) {
                }
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.LogcatConfigActivity$enableDrawOverlaysAndShowDialog$lambda$7$$inlined$cancelButton$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(@NotNull DialogInterface dialog, int i4) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(this)\n        .apply(dialogConfig)\n        .create()");
        create.show();
    }

    private final int s(int i4, CheckBox checkBox) {
        if (!checkBox.isChecked()) {
            return 0;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t() {
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding = this.f14515f;
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding2 = null;
        if (dialogLogcatTextToMatchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding = null;
        }
        CheckBox checkBox = dialogLogcatTextToMatchBinding.bufferMainCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.bufferMainCheckbox");
        int s3 = s(1, checkBox);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding3 = this.f14515f;
        if (dialogLogcatTextToMatchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding3 = null;
        }
        CheckBox checkBox2 = dialogLogcatTextToMatchBinding3.bufferSystemCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.bufferSystemCheckbox");
        int s4 = s3 + s(2, checkBox2);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding4 = this.f14515f;
        if (dialogLogcatTextToMatchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding4 = null;
        }
        CheckBox checkBox3 = dialogLogcatTextToMatchBinding4.bufferCrashCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox3, "binding.bufferCrashCheckbox");
        int s5 = s4 + s(4, checkBox3);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding5 = this.f14515f;
        if (dialogLogcatTextToMatchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding5 = null;
        }
        CheckBox checkBox4 = dialogLogcatTextToMatchBinding5.bufferKernelCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox4, "binding.bufferKernelCheckbox");
        int s6 = s5 + s(8, checkBox4);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding6 = this.f14515f;
        if (dialogLogcatTextToMatchBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogLogcatTextToMatchBinding6 = null;
        }
        CheckBox checkBox5 = dialogLogcatTextToMatchBinding6.bufferRadioCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox5, "binding.bufferRadioCheckbox");
        int s7 = s6 + s(16, checkBox5);
        DialogLogcatTextToMatchBinding dialogLogcatTextToMatchBinding7 = this.f14515f;
        if (dialogLogcatTextToMatchBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogLogcatTextToMatchBinding2 = dialogLogcatTextToMatchBinding7;
        }
        CheckBox checkBox6 = dialogLogcatTextToMatchBinding2.bufferEventsCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox6, "binding.bufferEventsCheckbox");
        return s7 + s(32, checkBox6);
    }

    private final void u(Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("Macro");
            Intrinsics.checkNotNull(parcelableExtra);
            this.f14516g = (Macro) parcelableExtra;
            Parcelable parcelableExtra2 = intent.getParcelableExtra("trigger");
            Intrinsics.checkNotNull(parcelableExtra2);
            this.f14517h = (LogcatTrigger) parcelableExtra2;
            this.f14518i = intent.getIntExtra("enabled_buffers", 0);
            this.f14519j = intent.getBooleanExtra(EXTRA_IGNORE_CASE, false);
            o((LogcatMessage) intent.getParcelableExtra(EXTRA_LOGCAT_MESSAGE));
        }
    }

    private final boolean v(int i4) {
        if ((this.f14518i & i4) == i4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        AdbHelperUtil.showAdbHackDetails(this, LogcatTriggerInfo.Companion.getInstance().getAdbHackPermissionRequired());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DialogLogcatTextToMatchBinding inflate = DialogLogcatTextToMatchBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f14515f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        u(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        u(intent);
    }
}
