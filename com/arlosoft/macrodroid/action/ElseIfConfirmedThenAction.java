package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.helper.ConfirmNextHelperKt;
import com.arlosoft.macrodroid.action.info.ElseIfConfirmedThenActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
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

/* compiled from: ElseIfConfirmedThenAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class ElseIfConfirmedThenAction extends ElseParentAction implements SupportsMagicText {
    private boolean cancelAfterTimeout;
    @Nullable
    private String negativeText;
    @Nullable
    private String positiveText;
    private boolean quitOnBackPressed;
    @Nullable
    private String text;
    private int timeoutSeconds;
    @Nullable
    private String title;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ElseIfConfirmedThenAction> CREATOR = new Parcelable.Creator<ElseIfConfirmedThenAction>() { // from class: com.arlosoft.macrodroid.action.ElseIfConfirmedThenAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ElseIfConfirmedThenAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ElseIfConfirmedThenAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ElseIfConfirmedThenAction[] newArray(int i4) {
            return new ElseIfConfirmedThenAction[i4];
        }
    };

    /* compiled from: ElseIfConfirmedThenAction.kt */
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
            ElseIfConfirmedThenAction.this.title = title;
            ElseIfConfirmedThenAction.this.text = text;
            ElseIfConfirmedThenAction.this.positiveText = positiveText;
            ElseIfConfirmedThenAction.this.negativeText = negativeText;
            ElseIfConfirmedThenAction.this.quitOnBackPressed = z3;
            ElseIfConfirmedThenAction.this.cancelAfterTimeout = z4;
            ElseIfConfirmedThenAction.this.timeoutSeconds = i4;
            ElseIfConfirmedThenAction.this.itemComplete();
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Integer num) {
            a(str, str2, str3, str4, bool.booleanValue(), bool2.booleanValue(), num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ElseIfConfirmedThenAction.kt */
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
            ElseIfConfirmedThenAction.this.handleOptionsDialogCancelled();
        }
    }

    public /* synthetic */ ElseIfConfirmedThenAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.ElseParentAction, com.arlosoft.macrodroid.action.ConditionAction
    @NotNull
    protected String X() {
        return "";
    }

    @Override // com.arlosoft.macrodroid.action.ElseParentAction, com.arlosoft.macrodroid.action.ConditionAction
    @NotNull
    protected String Y() {
        String configuredName = getConfiguredName();
        return configuredName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        String r4 = SelectableItem.r(R.string.action_else_if_confirmed_then);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.action_else_if_confirmed_then)");
        return r4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.title;
        String str2 = this.text;
        return str + ": " + str2;
    }

    @Override // com.arlosoft.macrodroid.action.ElseParentAction, com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ElseIfConfirmedThenActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.title, this.text, this.positiveText, this.negativeText};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String r4 = SelectableItem.r(R.string.action_else_if_confirmed_then);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.action_else_if_confirmed_then)");
        Macro macro = getMacro();
        Intrinsics.checkNotNullExpressionValue(macro, "macro");
        int dialogTheme = getDialogTheme();
        String str = this.title;
        String str2 = this.text;
        String str3 = this.positiveText;
        String str4 = this.negativeText;
        String r5 = SelectableItem.r(R.string.action_confirm_actions_default_title);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.actio…rm_actions_default_title)");
        String r6 = SelectableItem.r(R.string.action_confirm_actions_default_message);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.actio…_actions_default_message)");
        ConfirmNextHelperKt.showConfirmNextConfigDialog(activity, r4, macro, dialogTheme, str, str2, str3, str4, r5, r6, true, this.quitOnBackPressed, this.cancelAfterTimeout, this.timeoutSeconds, new a(), new b());
    }

    @Override // com.arlosoft.macrodroid.action.ElseParentAction, com.arlosoft.macrodroid.action.Action
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
            this.title = magicText[0];
            this.text = magicText[1];
            this.positiveText = magicText[2];
            this.negativeText = magicText[3];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.ConditionAction, com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.title);
        out.writeString(this.text);
        out.writeString(this.positiveText);
        out.writeString(this.negativeText);
        out.writeInt(this.quitOnBackPressed ? 1 : 0);
        out.writeInt(this.cancelAfterTimeout ? 1 : 0);
        out.writeInt(this.timeoutSeconds);
    }

    public ElseIfConfirmedThenAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public final void invokeAction(@NotNull TriggerContextInfo contextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Macro macro = getMacro();
        Intrinsics.checkNotNullExpressionValue(macro, "macro");
        ConfirmNextHelperKt.showIfThenConfirmNextDialog(context, macro, contextInfo, this.title, this.text, this.positiveText, this.negativeText, i4, z3, skipEndifIndexStack, resumeMacroInfo, z4, this.quitOnBackPressed, this.cancelAfterTimeout, this.timeoutSeconds);
    }

    public ElseIfConfirmedThenAction() {
        this.timeoutSeconds = 30;
    }

    private ElseIfConfirmedThenAction(Parcel parcel) {
        super(parcel);
        this.timeoutSeconds = 30;
        this.title = parcel.readString();
        this.text = parcel.readString();
        this.positiveText = parcel.readString();
        this.negativeText = parcel.readString();
        this.quitOnBackPressed = parcel.readInt() != 0;
        this.cancelAfterTimeout = parcel.readInt() != 0;
        this.timeoutSeconds = parcel.readInt();
    }

    /* compiled from: ElseIfConfirmedThenAction.kt */
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
