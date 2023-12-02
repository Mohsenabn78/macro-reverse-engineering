package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.ConfirmDialogActivity;
import com.arlosoft.macrodroid.action.helper.ConfirmNextHelperKt;
import com.arlosoft.macrodroid.action.info.ConfirmNextActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Stack;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConfirmNextAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class ConfirmNextAction extends Action implements SupportsMagicText, BlockingAction {
    private boolean cancelAfterTimeout;
    @Nullable
    private String m_message;
    @Nullable
    private String m_title;
    @Nullable
    private String negativeText;
    @Nullable
    private String positiveText;
    private int timeoutSeconds;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ConfirmNextAction> CREATOR = new Parcelable.Creator<ConfirmNextAction>() { // from class: com.arlosoft.macrodroid.action.ConfirmNextAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ConfirmNextAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ConfirmNextAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ConfirmNextAction[] newArray(int i4) {
            return new ConfirmNextAction[i4];
        }
    };

    /* compiled from: ConfirmNextAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function7<String, String, String, String, Boolean, Boolean, Integer, Unit> {
        a() {
            super(7);
        }

        public final void a(@NotNull String title, @NotNull String text, @NotNull String positiveText, @NotNull String negativeText, boolean z3, boolean z4, int i4) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(positiveText, "positiveText");
            Intrinsics.checkNotNullParameter(negativeText, "negativeText");
            ConfirmNextAction.this.m_title = title;
            ConfirmNextAction.this.m_message = text;
            ConfirmNextAction.this.positiveText = positiveText;
            ConfirmNextAction.this.negativeText = negativeText;
            ConfirmNextAction.this.cancelAfterTimeout = z4;
            ConfirmNextAction.this.timeoutSeconds = i4;
            ConfirmNextAction.this.itemComplete();
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Integer num) {
            a(str, str2, str3, str4, bool.booleanValue(), bool2.booleanValue(), num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ConfirmNextAction.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function0<Unit> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ConfirmNextAction.this.handleItemCancel();
        }
    }

    public /* synthetic */ ConfirmNextAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String M(String str, TriggerContextInfo triggerContextInfo) {
        String replace$default;
        String replaceMagicText = MagicText.replaceMagicText(getContext(), str, triggerContextInfo, getMacro());
        Intrinsics.checkNotNullExpressionValue(replaceMagicText, "replaceMagicText(context…text, contextInfo, macro)");
        replace$default = kotlin.text.m.replace$default(replaceMagicText, "\\n", "\n", false, 4, (Object) null);
        return replace$default;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.m_title;
        String str2 = this.m_message;
        return str + ": " + str2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        SelectableItemInfo confirmNextActionInfo = ConfirmNextActionInfo.getInstance();
        Intrinsics.checkNotNullExpressionValue(confirmNextActionInfo, "getInstance()");
        return confirmNextActionInfo;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.m_title, this.m_message, this.positiveText, this.negativeText};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String r4 = SelectableItem.r(R.string.action_confirm_next);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.action_confirm_next)");
        Macro macro = getMacro();
        Intrinsics.checkNotNullExpressionValue(macro, "macro");
        int dialogTheme = getDialogTheme();
        String str = this.m_title;
        String str2 = this.m_message;
        String str3 = this.positiveText;
        String str4 = this.negativeText;
        String r5 = SelectableItem.r(R.string.action_confirm_default_title);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.action_confirm_default_title)");
        String r6 = SelectableItem.r(R.string.action_confirm_default_message);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.action_confirm_default_message)");
        ConfirmNextHelperKt.showConfirmNextConfigDialog(activity, r4, macro, dialogTheme, str, str2, str3, str4, r5, r6, false, false, this.cancelAfterTimeout, this.timeoutSeconds, new a(), new b());
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 4) {
            this.m_title = magicText[0];
            this.m_message = magicText[1];
            this.positiveText = magicText[2];
            this.negativeText = magicText[3];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void testActionWithPermissionCheck(@Nullable TriggerContextInfo triggerContextInfo) {
        if (checkAllPermissions()) {
            invokeAction(triggerContextInfo, 0, true, new Stack<>(), null, true);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.m_title);
        out.writeString(this.m_message);
        out.writeString(this.positiveText);
        out.writeString(this.negativeText);
        out.writeInt(this.cancelAfterTimeout ? 1 : 0);
        out.writeInt(this.timeoutSeconds);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConfirmNextAction(@NotNull Activity activity, @NotNull Macro macro) {
        this();
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(macro, "macro");
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        String str = this.positiveText;
        if (str == null) {
            str = SelectableItem.r(17039370);
            Intrinsics.checkNotNullExpressionValue(str, "getString(android.R.string.ok)");
        }
        String str2 = this.negativeText;
        if (str2 == null) {
            str2 = SelectableItem.r(17039360);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(android.R.string.cancel)");
        }
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        Intent intent = new Intent(companion.getInstance(), ConfirmDialogActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("Title", M(this.m_title, triggerContextInfo));
        intent.putExtra("Message", M(this.m_message, triggerContextInfo));
        intent.putExtra(Util.EXTRA_GUID, getMacro().getGUID());
        intent.putExtra(Constants.POSITIVE_TEXT_EXTRA, M(str, triggerContextInfo));
        intent.putExtra(Constants.NEGATIVE_TEXT_EXTRA, M(str2, triggerContextInfo));
        intent.putExtra(Constants.EXTRA_TRIGGER_THAT_INVOKED, this.m_macro.getTriggerThatInvoked());
        intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
        intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
        intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, skipEndifIndexStack);
        intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, z3);
        intent.putExtra(Constants.EXTRA_IS_TEST, z4);
        intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
        intent.putExtra(ConfirmNextHelperKt.EXTRA_CANCEL_AFTER_TIMEOUT, this.cancelAfterTimeout);
        intent.putExtra(ConfirmNextHelperKt.EXTRA_TIMEOUT_SECONDS, this.timeoutSeconds);
        companion.getInstance().startActivity(intent);
    }

    private ConfirmNextAction() {
        this.timeoutSeconds = 30;
    }

    private ConfirmNextAction(Parcel parcel) {
        super(parcel);
        this.timeoutSeconds = 30;
        this.m_title = parcel.readString();
        this.m_message = parcel.readString();
        this.positiveText = parcel.readString();
        this.negativeText = parcel.readString();
        this.cancelAfterTimeout = parcel.readInt() != 0;
        this.timeoutSeconds = parcel.readInt();
    }

    /* compiled from: ConfirmNextAction.kt */
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
