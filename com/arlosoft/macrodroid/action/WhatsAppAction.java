package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.UiInteractionConfiguration;
import com.arlosoft.macrodroid.action.info.WhatsAppActionInfo;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityServiceKt;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WhatsAppAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nWhatsAppAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhatsAppAction.kt\ncom/arlosoft/macrodroid/action/WhatsAppAction\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,330:1\n262#2,2:331\n262#2,2:333\n*S KotlinDebug\n*F\n+ 1 WhatsAppAction.kt\ncom/arlosoft/macrodroid/action/WhatsAppAction\n*L\n202#1:331,2\n203#1:333,2\n*E\n"})
/* loaded from: classes2.dex */
public final class WhatsAppAction extends Action implements BlockingAction, SupportsMagicText {
    private static final int PICK_CONTACT_REQUEST_CODE = 99;
    private static final int SEND_BUTTON_PRESS_DELAY_MS = 2000;
    private boolean exitAppAfter;
    private boolean isBusiness;
    @NotNull
    private String messageText;
    @NotNull
    private String number;
    @Nullable
    private transient WeakReference<EditText> phoneNumberRef;
    private boolean prepopulateOnly;
    private int sendButtonPressDelayMs;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<WhatsAppAction> CREATOR = new Parcelable.Creator<WhatsAppAction>() { // from class: com.arlosoft.macrodroid.action.WhatsAppAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WhatsAppAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WhatsAppAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WhatsAppAction[] newArray(int i4) {
            return new WhatsAppAction[i4];
        }
    };

    /* compiled from: WhatsAppAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $magicTextListenerNumber;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(MagicText.MagicTextListener magicTextListener, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$magicTextListenerNumber = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$magicTextListenerNumber, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(WhatsAppAction.this.getActivity(), this.$magicTextListenerNumber, WhatsAppAction.this.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, WhatsAppAction.this.isChildOfIterateDictionary());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: WhatsAppAction.kt */
    /* loaded from: classes2.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $textMagicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MagicText.MagicTextListener magicTextListener, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$textMagicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$textMagicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(WhatsAppAction.this.getActivity(), this.$textMagicTextListener, WhatsAppAction.this.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, WhatsAppAction.this.isChildOfIterateDictionary());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: WhatsAppAction.kt */
    @SourceDebugExtension({"SMAP\nWhatsAppAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhatsAppAction.kt\ncom/arlosoft/macrodroid/action/WhatsAppAction$handleItemSelected$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,330:1\n262#2,2:331\n262#2,2:333\n*S KotlinDebug\n*F\n+ 1 WhatsAppAction.kt\ncom/arlosoft/macrodroid/action/WhatsAppAction$handleItemSelected$3\n*L\n226#1:331,2\n227#1:333,2\n*E\n"})
    /* loaded from: classes2.dex */
    static final class c extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $delayBeforeSendDescription;
        final /* synthetic */ View $delayBeforeSendLayout;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(View view, TextView textView, Continuation<? super c> continuation) {
            super(4, continuation);
            this.$delayBeforeSendLayout = view;
            this.$delayBeforeSendDescription = textView;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            c cVar = new c(this.$delayBeforeSendLayout, this.$delayBeforeSendDescription, continuation);
            cVar.Z$0 = z3;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z3 = this.Z$0;
                View view = this.$delayBeforeSendLayout;
                int i5 = 0;
                if (!z3) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                view.setVisibility(i4);
                TextView textView = this.$delayBeforeSendDescription;
                if (!(!z3)) {
                    i5 = 8;
                }
                textView.setVisibility(i5);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: WhatsAppAction.kt */
    /* loaded from: classes2.dex */
    static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
                intent.setType("vnd.android.cursor.dir/phone_v2");
                WhatsAppAction.this.getActivity().startActivityForResult(intent, 99);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: WhatsAppAction.kt */
    /* loaded from: classes2.dex */
    static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ RadioButton $businessRadioButton;
        final /* synthetic */ EditText $delayBeforeSend;
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ CheckBox $exitAfterSendCheckbox;
        final /* synthetic */ EditText $messageTextField;
        final /* synthetic */ EditText $phoneNumberField;
        final /* synthetic */ CheckBox $prePopulateCheckbox;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(RadioButton radioButton, EditText editText, EditText editText2, CheckBox checkBox, CheckBox checkBox2, EditText editText3, AppCompatDialog appCompatDialog, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$businessRadioButton = radioButton;
            this.$messageTextField = editText;
            this.$phoneNumberField = editText2;
            this.$exitAfterSendCheckbox = checkBox;
            this.$prePopulateCheckbox = checkBox2;
            this.$delayBeforeSend = editText3;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$businessRadioButton, this.$messageTextField, this.$phoneNumberField, this.$exitAfterSendCheckbox, this.$prePopulateCheckbox, this.$delayBeforeSend, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WhatsAppAction.this.isBusiness = this.$businessRadioButton.isChecked();
                WhatsAppAction.this.messageText = this.$messageTextField.getText().toString();
                WhatsAppAction.this.number = this.$phoneNumberField.getText().toString();
                WhatsAppAction whatsAppAction = WhatsAppAction.this;
                CheckBox checkBox = this.$exitAfterSendCheckbox;
                boolean z4 = true;
                int i4 = 0;
                if (checkBox != null && checkBox.isChecked()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                whatsAppAction.exitAppAfter = z3;
                WhatsAppAction whatsAppAction2 = WhatsAppAction.this;
                CheckBox checkBox2 = this.$prePopulateCheckbox;
                whatsAppAction2.prepopulateOnly = (checkBox2 == null || !checkBox2.isChecked()) ? false : false;
                WhatsAppAction whatsAppAction3 = WhatsAppAction.this;
                try {
                    Integer valueOf = Integer.valueOf(this.$delayBeforeSend.getText().toString());
                    Intrinsics.checkNotNullExpressionValue(valueOf, "{\n                Intege…toString())\n            }");
                    i4 = valueOf.intValue();
                } catch (Exception unused) {
                }
                whatsAppAction3.sendButtonPressDelayMs = i4;
                this.$dialog.dismiss();
                WhatsAppAction.this.itemComplete();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: WhatsAppAction.kt */
    /* loaded from: classes2.dex */
    static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AppCompatDialog appCompatDialog, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: WhatsAppAction.kt */
    /* loaded from: classes2.dex */
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ boolean $isTest;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(TriggerContextInfo triggerContextInfo, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super g> continuation) {
            super(2, continuation);
            this.$contextInfo = triggerContextInfo;
            this.$isTest = z3;
            this.$nextAction = i4;
            this.$forceEvenIfNotEnabled = z4;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new g(this.$contextInfo, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00bb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c5  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L23
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r9)
                goto Lbc
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1e:
                kotlin.ResultKt.throwOnFailure(r9)
                goto Lac
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L8a
            L27:
                kotlin.ResultKt.throwOnFailure(r9)
                com.arlosoft.macrodroid.action.WhatsAppAction r9 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                android.content.Context r9 = r9.getContext()
                com.arlosoft.macrodroid.action.WhatsAppAction r1 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                java.lang.String r1 = com.arlosoft.macrodroid.action.WhatsAppAction.access$getNumber$p(r1)
                com.arlosoft.macrodroid.triggers.TriggerContextInfo r5 = r8.$contextInfo
                com.arlosoft.macrodroid.action.WhatsAppAction r6 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                com.arlosoft.macrodroid.macro.Macro r6 = r6.getMacro()
                r7 = 0
                java.lang.String r9 = com.arlosoft.macrodroid.common.MagicText.replaceMagicText(r9, r1, r5, r7, r6)
                if (r9 == 0) goto L4d
                java.lang.String r1 = "[sms_number]"
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r1)
                if (r1 == 0) goto L61
            L4d:
                com.arlosoft.macrodroid.action.WhatsAppAction r1 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                java.lang.Long r1 = r1.getMacroGuid()
                java.lang.String r5 = "macroGuid"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
                long r5 = r1.longValue()
                java.lang.String r1 = "No number available to send SMS to - [sms_number] must be set by the trigger"
                com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r1, r5)
            L61:
                if (r9 == 0) goto Le2
                com.arlosoft.macrodroid.action.WhatsAppAction r1 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                java.lang.String r5 = com.arlosoft.macrodroid.action.WhatsAppAction.access$getMessageText$p(r1)
                com.arlosoft.macrodroid.triggers.TriggerContextInfo r6 = r8.$contextInfo
                java.lang.String r1 = com.arlosoft.macrodroid.action.WhatsAppAction.access$applyMagicText(r1, r5, r6)
                com.arlosoft.macrodroid.action.WhatsAppAction r5 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                java.lang.String r6 = "textWithNewlines"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
                com.arlosoft.macrodroid.action.WhatsAppAction.access$launchWhatsAppAndSendText(r5, r9, r1)
                com.arlosoft.macrodroid.action.WhatsAppAction r9 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                int r9 = com.arlosoft.macrodroid.action.WhatsAppAction.access$getSendButtonPressDelayMs$p(r9)
                long r5 = (long) r9
                r8.label = r4
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r8)
                if (r9 != r0) goto L8a
                return r0
            L8a:
                com.arlosoft.macrodroid.action.WhatsAppAction r9 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                boolean r9 = com.arlosoft.macrodroid.action.WhatsAppAction.access$getPrepopulateOnly$p(r9)
                if (r9 != 0) goto L99
                com.arlosoft.macrodroid.action.WhatsAppAction r9 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                com.arlosoft.macrodroid.triggers.TriggerContextInfo r1 = r8.$contextInfo
                com.arlosoft.macrodroid.action.WhatsAppAction.access$clickSendButton(r9, r1)
            L99:
                com.arlosoft.macrodroid.action.WhatsAppAction r9 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                boolean r9 = com.arlosoft.macrodroid.action.WhatsAppAction.access$getExitAppAfter$p(r9)
                if (r9 == 0) goto Lc1
                r8.label = r3
                r3 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r3, r8)
                if (r9 != r0) goto Lac
                return r0
            Lac:
                com.arlosoft.macrodroid.action.WhatsAppAction r9 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                com.arlosoft.macrodroid.action.WhatsAppAction.access$goBack(r9)
                r8.label = r2
                r1 = 100
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r1, r8)
                if (r9 != r0) goto Lbc
                return r0
            Lbc:
                com.arlosoft.macrodroid.action.WhatsAppAction r9 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                com.arlosoft.macrodroid.action.WhatsAppAction.access$goBack(r9)
            Lc1:
                boolean r9 = r8.$isTest
                if (r9 != 0) goto Le2
                com.arlosoft.macrodroid.action.WhatsAppAction r9 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                com.arlosoft.macrodroid.macro.Macro r0 = r9.getMacro()
                com.arlosoft.macrodroid.action.WhatsAppAction r9 = com.arlosoft.macrodroid.action.WhatsAppAction.this
                com.arlosoft.macrodroid.macro.Macro r9 = r9.getMacro()
                java.util.ArrayList r1 = r9.getActions()
                int r2 = r8.$nextAction
                com.arlosoft.macrodroid.triggers.TriggerContextInfo r3 = r8.$contextInfo
                boolean r4 = r8.$forceEvenIfNotEnabled
                java.util.Stack<java.lang.Integer> r5 = r8.$skipEndifIndexStack
                com.arlosoft.macrodroid.data.ResumeMacroInfo r6 = r8.$resumeMacroInfo
                r0.invokeActions(r1, r2, r3, r4, r5, r6)
            Le2:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.WhatsAppAction.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ WhatsAppAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(TriggerContextInfo triggerContextInfo) {
        Point point = new Point(94, 94);
        String Q = Q();
        UiInteractionConfiguration.Click click = new UiInteractionConfiguration.Click(3, false, point, true, null, null, null, 1, null, Q + ":id/send", false, null, false, 4096, null);
        Intent intent = new Intent(getContext(), UIInteractionAccessibilityService.class);
        intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
        intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_MACRO_GUID, getMacro().getGUID());
        intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_UI_INTERACTION_CONFIG, click);
        getContext().startService(intent);
    }

    private final String Q() {
        if (this.isBusiness) {
            return "com.whatsapp.w4b";
        }
        return "com.whatsapp";
    }

    private final String R(String str) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        String format = phoneNumberUtil.format(phoneNumberUtil.parse(str, "GB"), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
        Intrinsics.checkNotNullExpressionValue(format, "phoneUtil.format(gbNumbe…mberFormat.INTERNATIONAL)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        UiInteractionConfiguration.PressBack pressBack = UiInteractionConfiguration.PressBack.INSTANCE;
        Intent intent = new Intent(getContext(), UIInteractionAccessibilityService.class);
        intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_UI_INTERACTION_CONFIG, pressBack);
        getContext().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(EditText phoneNumberField, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(phoneNumberField, "$phoneNumberField");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(phoneNumberField.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(phoneNumberField.getSelectionEnd(), 0);
        Editable text = phoneNumberField.getText();
        Intrinsics.checkNotNull(text);
        coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
        coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
        String str = magicTextPair.magicText;
        text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(EditText messageTextField, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(messageTextField, "$messageTextField");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(messageTextField.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(messageTextField.getSelectionEnd(), 0);
        Editable text = messageTextField.getText();
        coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
        coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
        String str = magicTextPair.magicText;
        text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(Q());
            intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + str + "&text=" + URLEncoder.encode(str2, "UTF-8")));
            intent.addFlags(268435456);
            intent.addFlags(32768);
            getContext().startActivity(intent);
        } catch (Exception e4) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Contact via app failed: " + e4, macroGuid.longValue());
            ToastCompat.makeText(getContext(), (CharSequence) (SelectableItem.r(R.string.error) + ": " + e4), 0).show();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.number;
        String str2 = this.messageText;
        return str + ": " + str2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return WhatsAppActionInfo.Companion.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_CONTACTS"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.number, this.messageText};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        EditText editText;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (i4 == 99 && i5 == -1) {
            Intrinsics.checkNotNull(intent);
            Uri data = intent.getData();
            Intrinsics.checkNotNull(data);
            Cursor query = getContext().getContentResolver().query(data, new String[]{"data1"}, null, null, null);
            if (query != null && query.getCount() > 0) {
                query.moveToFirst();
                String number = query.getString(query.getColumnIndex("data1"));
                Intrinsics.checkNotNullExpressionValue(number, "number");
                String R = R(number);
                WeakReference<EditText> weakReference = this.phoneNumberRef;
                if (weakReference != null && (editText = weakReference.get()) != null) {
                    editText.setText(R);
                }
            }
            if (query != null) {
                query.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int i4;
        int i5;
        int i6;
        int i7;
        Button button;
        final AppCompatDialog appCompatDialog;
        AppCompatDialog appCompatDialog2 = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog2.setContentView(R.layout.dialog_whatsapp_configure);
        appCompatDialog2.setTitle(R.string.action_whats_app);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog2.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog2.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        Button button2 = (Button) appCompatDialog2.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog2.findViewById(R.id.cancelButton);
        View findViewById = appCompatDialog2.findViewById(R.id.messageText);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog2.findViewById(R.id.phoneNumber);
        Intrinsics.checkNotNull(findViewById2);
        final EditText editText2 = (EditText) findViewById2;
        View findViewById3 = appCompatDialog2.findViewById(R.id.magicTextButtonNumber);
        Intrinsics.checkNotNull(findViewById3);
        Button button4 = (Button) findViewById3;
        View findViewById4 = appCompatDialog2.findViewById(R.id.magicTextButtonMessage);
        Intrinsics.checkNotNull(findViewById4);
        Button button5 = (Button) findViewById4;
        ImageButton imageButton = (ImageButton) appCompatDialog2.findViewById(R.id.selectContactButton);
        CheckBox checkBox = (CheckBox) appCompatDialog2.findViewById(R.id.exitAfterSendCheckbox);
        CheckBox checkBox2 = (CheckBox) appCompatDialog2.findViewById(R.id.prePopulateCheckbox);
        View findViewById5 = appCompatDialog2.findViewById(R.id.standardRadioButton);
        Intrinsics.checkNotNull(findViewById5);
        View findViewById6 = appCompatDialog2.findViewById(R.id.businessRadioButton);
        Intrinsics.checkNotNull(findViewById6);
        RadioButton radioButton = (RadioButton) findViewById6;
        View findViewById7 = appCompatDialog2.findViewById(R.id.delayBeforeSendLayout);
        Intrinsics.checkNotNull(findViewById7);
        View findViewById8 = appCompatDialog2.findViewById(R.id.delayBeforeSendMs);
        Intrinsics.checkNotNull(findViewById8);
        EditText editText3 = (EditText) findViewById8;
        View findViewById9 = appCompatDialog2.findViewById(R.id.delayBeforeSendDescription);
        Intrinsics.checkNotNull(findViewById9);
        TextView textView = (TextView) findViewById9;
        this.phoneNumberRef = new WeakReference<>(editText2);
        ((RadioButton) findViewById5).setChecked(!this.isBusiness);
        radioButton.setChecked(this.isBusiness);
        editText3.setText(String.valueOf(this.sendButtonPressDelayMs));
        if (!this.prepopulateOnly) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        findViewById7.setVisibility(i4);
        if (!this.prepopulateOnly) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        textView.setVisibility(i5);
        MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.gu
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                WhatsAppAction.T(editText2, magicTextPair);
            }
        };
        MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.hu
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                WhatsAppAction.U(editText, magicTextPair);
            }
        };
        ViewExtensionsKt.onClick$default(button4, null, new a(magicTextListener, null), 1, null);
        ViewExtensionsKt.onClick$default(button5, null, new b(magicTextListener2, null), 1, null);
        editText.setText(this.messageText);
        editText2.setText(this.number);
        if (checkBox != null) {
            checkBox.setChecked(this.exitAppAfter);
        }
        if (checkBox2 != null) {
            checkBox2.setChecked(this.prepopulateOnly);
        }
        if (checkBox2 != null) {
            i6 = 1;
            Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox2, (CoroutineContext) null, new c(findViewById7, textView, null), 1, (Object) null);
        } else {
            i6 = 1;
        }
        if (imageButton != null) {
            try {
                ViewExtensionsKt.onClick$default(imageButton, null, new d(null), i6, null);
            } catch (Exception unused) {
                ToastCompat.makeText(getContext(), (int) R.string.no_app_available, 0).show();
            }
        }
        if (button2 != null) {
            i7 = 1;
            ViewExtensionsKt.onClick$default(button2, null, new e(radioButton, editText, editText2, checkBox, checkBox2, editText3, appCompatDialog2, null), 1, null);
        } else {
            i7 = 1;
        }
        if (button3 != null) {
            appCompatDialog = appCompatDialog2;
            button = button3;
            ViewExtensionsKt.onClick$default(button, null, new f(appCompatDialog, null), i7, null);
        } else {
            button = button3;
            appCompatDialog = appCompatDialog2;
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.iu
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WhatsAppAction.V(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresUIInteractionAccessibility() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@Nullable String[] strArr) {
        Intrinsics.checkNotNull(strArr);
        if (strArr.length == 2) {
            this.number = strArr[0];
            this.messageText = strArr[1];
            return;
        }
        String str = this.m_classType;
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.number);
        out.writeString(this.messageText);
        out.writeInt(this.prepopulateOnly ? 1 : 0);
        out.writeInt(this.exitAppAfter ? 1 : 0);
        out.writeInt(this.isBusiness ? 1 : 0);
        out.writeInt(this.sendButtonPressDelayMs);
    }

    public WhatsAppAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new g(triggerContextInfo, z4, i4, z3, skipEndifIndexStack, resumeMacroInfo, null), 2, null);
    }

    public WhatsAppAction() {
        this.number = "";
        this.messageText = "";
        this.exitAppAfter = true;
        this.sendButtonPressDelayMs = 2000;
    }

    private WhatsAppAction(Parcel parcel) {
        super(parcel);
        this.number = "";
        this.messageText = "";
        this.exitAppAfter = true;
        this.sendButtonPressDelayMs = 2000;
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        this.number = readString;
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        this.messageText = readString2;
        this.prepopulateOnly = parcel.readInt() != 0;
        this.exitAppAfter = parcel.readInt() != 0;
        this.isBusiness = parcel.readInt() != 0;
        this.sendButtonPressDelayMs = parcel.readInt();
    }

    /* compiled from: WhatsAppAction.kt */
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
