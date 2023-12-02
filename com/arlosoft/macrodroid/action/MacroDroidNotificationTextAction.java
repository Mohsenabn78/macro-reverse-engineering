package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.MacroDroidNotificationTextActionInfo;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
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
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroDroidNotificationTextAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nMacroDroidNotificationTextAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroDroidNotificationTextAction.kt\ncom/arlosoft/macrodroid/action/MacroDroidNotificationTextAction\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,154:1\n262#2,2:155\n*S KotlinDebug\n*F\n+ 1 MacroDroidNotificationTextAction.kt\ncom/arlosoft/macrodroid/action/MacroDroidNotificationTextAction\n*L\n97#1:155,2\n*E\n"})
/* loaded from: classes2.dex */
public final class MacroDroidNotificationTextAction extends Action implements SupportsMagicText {
    @NotNull
    private String body;
    private boolean showCustom;
    @NotNull
    private String title;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MacroDroidNotificationTextAction> CREATOR = new Parcelable.Creator<MacroDroidNotificationTextAction>() { // from class: com.arlosoft.macrodroid.action.MacroDroidNotificationTextAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroDroidNotificationTextAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MacroDroidNotificationTextAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroDroidNotificationTextAction[] newArray(int i4) {
            return new MacroDroidNotificationTextAction[i4];
        }
    };

    /* compiled from: MacroDroidNotificationTextAction.kt */
    @SourceDebugExtension({"SMAP\nMacroDroidNotificationTextAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroDroidNotificationTextAction.kt\ncom/arlosoft/macrodroid/action/MacroDroidNotificationTextAction$handleItemSelected$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,154:1\n262#2,2:155\n*S KotlinDebug\n*F\n+ 1 MacroDroidNotificationTextAction.kt\ncom/arlosoft/macrodroid/action/MacroDroidNotificationTextAction$handleItemSelected$1\n*L\n98#1:155,2\n*E\n"})
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $customLayout;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ViewGroup viewGroup, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$customLayout = viewGroup;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$customLayout, continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
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
                ViewGroup viewGroup = this.$customLayout;
                if (z3) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                viewGroup.setVisibility(i4);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: MacroDroidNotificationTextAction.kt */
    /* loaded from: classes2.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $titleMagicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MagicText.MagicTextListener magicTextListener, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$titleMagicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$titleMagicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(MacroDroidNotificationTextAction.this.getActivity(), this.$titleMagicTextListener, MacroDroidNotificationTextAction.this.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, MacroDroidNotificationTextAction.this.isChildOfIterateDictionary());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: MacroDroidNotificationTextAction.kt */
    /* loaded from: classes2.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $bodyMagicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(MagicText.MagicTextListener magicTextListener, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$bodyMagicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$bodyMagicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(MacroDroidNotificationTextAction.this.getActivity(), this.$bodyMagicTextListener, MacroDroidNotificationTextAction.this.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, MacroDroidNotificationTextAction.this.isChildOfIterateDictionary());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: MacroDroidNotificationTextAction.kt */
    /* loaded from: classes2.dex */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MacroDroidService.Companion companion = MacroDroidService.Companion;
                Context context = MacroDroidNotificationTextAction.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                MacroDroidService.Companion.updateNotification$default(companion, context, true, false, 4, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ MacroDroidNotificationTextAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(EditText titleText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(titleText, "$titleText");
        int max = Math.max(titleText.getSelectionStart(), 0);
        int max2 = Math.max(titleText.getSelectionEnd(), 0);
        Editable text = titleText.getText();
        if (text != null) {
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            String str = magicTextPair.magicText;
            text.replace(min, max3, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(EditText bodyText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(bodyText, "$bodyText");
        int max = Math.max(bodyText.getSelectionStart(), 0);
        int max2 = Math.max(bodyText.getSelectionEnd(), 0);
        Editable text = bodyText.getText();
        if (text != null) {
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            String str = magicTextPair.magicText;
            text.replace(min, max3, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(MacroDroidNotificationTextAction this$0, EditText titleText, EditText bodyText, RadioButton customRadioButton, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(titleText, "$titleText");
        Intrinsics.checkNotNullParameter(bodyText, "$bodyText");
        Intrinsics.checkNotNullParameter(customRadioButton, "$customRadioButton");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.title = titleText.getText().toString();
        this$0.body = bodyText.getText().toString();
        this$0.showCustom = customRadioButton.isChecked();
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        if (this.showCustom) {
            String str = this.title;
            String str2 = this.body;
            return str + " / " + str2;
        }
        String r4 = SelectableItem.r(R.string.macrodroid_default);
        Intrinsics.checkNotNullExpressionValue(r4, "{ getString(R.string.macrodroid_default) }");
        return r4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return MacroDroidNotificationTextActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.title, this.body};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getSystemLogEntryName(@Nullable TriggerContextInfo triggerContextInfo) {
        String name = getName();
        String g4 = g(this.title, triggerContextInfo);
        String g5 = g(this.body, triggerContextInfo);
        return name + ": " + g4 + " / " + g5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        WindowManager.LayoutParams layoutParams;
        int i4;
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_macrodroid_notification_text);
        appCompatDialog.setTitle(R.string.action_macrodroid_notification_text);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        View findViewById = appCompatDialog.findViewById(R.id.defaultRadioButton);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog.findViewById(R.id.customRadioButton);
        Intrinsics.checkNotNull(findViewById2);
        final RadioButton radioButton = (RadioButton) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.titleText);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText = (EditText) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.bodyText);
        Intrinsics.checkNotNull(findViewById4);
        final EditText editText2 = (EditText) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.titleMagicTextButton);
        Intrinsics.checkNotNull(findViewById5);
        Button button = (Button) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.bodyMagicTextButton);
        Intrinsics.checkNotNull(findViewById6);
        Button button2 = (Button) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.customLayout);
        Intrinsics.checkNotNull(findViewById7);
        ViewGroup viewGroup = (ViewGroup) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById8);
        Button button3 = (Button) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById9);
        Button button4 = (Button) findViewById9;
        editText.setText(this.title);
        editText2.setText(this.body);
        ((RadioButton) findViewById).setChecked(!this.showCustom);
        radioButton.setChecked(this.showCustom);
        if (this.showCustom) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton, (CoroutineContext) null, new a(viewGroup, null), 1, (Object) null);
        ViewExtensionsKt.onClick$default(button, null, new b(new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ha
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                MacroDroidNotificationTextAction.Q(editText, magicTextPair);
            }
        }, null), 1, null);
        ViewExtensionsKt.onClick$default(button2, null, new c(new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ia
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                MacroDroidNotificationTextAction.R(editText2, magicTextPair);
            }
        }, null), 1, null);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ja
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MacroDroidNotificationTextAction.S(MacroDroidNotificationTextAction.this, editText, editText2, radioButton, appCompatDialog, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ka
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MacroDroidNotificationTextAction.T(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        String replace$default;
        if (this.showCustom) {
            String g4 = g(this.title, triggerContextInfo);
            String g5 = g(this.body, triggerContextInfo);
            Intrinsics.checkNotNullExpressionValue(g5, "applyMagicText(body, contextInfo)");
            replace$default = kotlin.text.m.replace$default(g5, "\\n", "\n", false, 4, (Object) null);
            Settings.setMacroDroidNotificationTitle(getContext(), g4);
            Settings.setMacroDroidNotificationBody(getContext(), replace$default);
        } else {
            Settings.setMacroDroidNotificationTitle(getContext(), null);
            Settings.setMacroDroidNotificationBody(getContext(), null);
        }
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new d(null), 2, null);
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 2) {
            this.title = magicText[0];
            this.body = magicText[1];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.title);
        out.writeString(this.body);
        out.writeInt(this.showCustom ? 1 : 0);
    }

    public MacroDroidNotificationTextAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public MacroDroidNotificationTextAction() {
        this.title = "";
        this.body = "";
    }

    private MacroDroidNotificationTextAction(Parcel parcel) {
        super(parcel);
        this.title = "";
        this.body = "";
        String readString = parcel.readString();
        this.title = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.body = readString2 != null ? readString2 : "";
        this.showCustom = parcel.readInt() != 0;
    }

    /* compiled from: MacroDroidNotificationTextAction.kt */
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
