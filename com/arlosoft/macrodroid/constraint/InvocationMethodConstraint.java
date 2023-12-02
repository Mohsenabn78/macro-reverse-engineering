package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.InvocationMethodConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.GoogleAssistantTrigger;
import com.arlosoft.macrodroid.triggers.InvocationTypeTrigger;
import com.arlosoft.macrodroid.triggers.InvokedByDrawerTrigger;
import com.arlosoft.macrodroid.triggers.InvokedByNotificationTrigger;
import com.arlosoft.macrodroid.triggers.InvokedByOptionDialogTrigger;
import com.arlosoft.macrodroid.triggers.InvokedByPowerMenuTrigger;
import com.arlosoft.macrodroid.triggers.InvokedByQuickRunTrigger;
import com.arlosoft.macrodroid.triggers.InvokedByRunMacroTrigger;
import com.arlosoft.macrodroid.triggers.ShortcutTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InvocationMethodConstraint.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nInvocationMethodConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvocationMethodConstraint.kt\ncom/arlosoft/macrodroid/constraint/InvocationMethodConstraint\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,209:1\n12544#2,2:210\n12544#2,2:212\n*S KotlinDebug\n*F\n+ 1 InvocationMethodConstraint.kt\ncom/arlosoft/macrodroid/constraint/InvocationMethodConstraint\n*L\n186#1:210,2\n173#1:212,2\n*E\n"})
/* loaded from: classes3.dex */
public final class InvocationMethodConstraint extends Constraint {
    public static final int OPTIONS_SIZE = 9;
    public static final int OPTION_GOOGLE_ASSISTANT = 5;
    public static final int OPTION_MACRODROID_DRAWER = 0;
    public static final int OPTION_MACRODROID_SHORTCUT = 4;
    public static final int OPTION_NOTIFICATION_ACTION_BUTTON = 1;
    public static final int OPTION_OPTION_DIALOG = 2;
    public static final int OPTION_OTHER_STANDARD_TRIGGER = 8;
    public static final int OPTION_POWER_MENU = 7;
    public static final int OPTION_QUICK_RUN = 6;
    public static final int OPTION_RUN_MACRO_ACTION = 3;
    private boolean notInvokedBy;
    private int option;
    @NotNull
    private boolean[] selectedOptions;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<InvocationMethodConstraint> CREATOR = new Parcelable.Creator<InvocationMethodConstraint>() { // from class: com.arlosoft.macrodroid.constraint.InvocationMethodConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InvocationMethodConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new InvocationMethodConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InvocationMethodConstraint[] newArray(int i4) {
            return new InvocationMethodConstraint[i4];
        }
    };

    public /* synthetic */ InvocationMethodConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void Q() {
        boolean[] T = T();
        final boolean[] copyOf = Arrays.copyOf(T, T.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        AlertDialog create = new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.constrant_invocation_method).setMultiChoiceItems(getOptions(), copyOf, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.t1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i4, boolean z3) {
                InvocationMethodConstraint.R(copyOf, dialogInterface, i4, z3);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.u1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                InvocationMethodConstraint.S(InvocationMethodConstraint.this, copyOf, dialogInterface, i4);
            }
        }).create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        int length = copyOf.length;
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            } else if (copyOf[i4]) {
                z3 = true;
                break;
            } else {
                i4++;
            }
        }
        create.getButton(-1).setEnabled(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(boolean[] localSelections, DialogInterface dialog, int i4, boolean z3) {
        Intrinsics.checkNotNullParameter(localSelections, "$localSelections");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        localSelections[i4] = z3;
        int length = localSelections.length;
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (localSelections[i5]) {
                z4 = true;
                break;
            } else {
                i5++;
            }
        }
        ((AlertDialog) dialog).getButton(-1).setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(InvocationMethodConstraint this$0, boolean[] localSelections, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(localSelections, "$localSelections");
        this$0.option = -1;
        boolean[] copyOf = Arrays.copyOf(localSelections, localSelections.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        this$0.selectedOptions = copyOf;
        this$0.itemComplete();
    }

    private final boolean[] T() {
        int i4 = this.option;
        if (i4 >= 0) {
            boolean[] zArr = new boolean[9];
            zArr[i4] = true;
            return zArr;
        }
        return this.selectedOptions;
    }

    private final String[] U() {
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        String string = companion.getInstance().getString(R.string.constrant_invocation_method_invoked_by);
        Intrinsics.checkNotNullExpressionValue(string, "MacroDroidApplication.in…cation_method_invoked_by)");
        String string2 = companion.getInstance().getString(R.string.constrant_invocation_method_not_invoked_by);
        Intrinsics.checkNotNullExpressionValue(string2, "MacroDroidApplication.in…on_method_not_invoked_by)");
        return new String[]{string, string2};
    }

    private final String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_macrodroid_drawer), SelectableItem.r(R.string.notification), SelectableItem.r(R.string.action_option_dialog), SelectableItem.r(R.string.constrant_invocation_method_macro_run_action), SelectableItem.r(R.string.shortcut_name), SelectableItem.r(R.string.trigger_google_assistant), SelectableItem.r(R.string.home_screen_tile_quick_run_macro), SelectableItem.r(R.string.constrant_invocation_method_option_power_menu), SelectableItem.r(R.string.constrant_invocation_method_option_other_standard_trigger)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3 = true;
        if (i4 != 1) {
            z3 = false;
        }
        this.notInvokedBy = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        Iterable<IndexedValue> withIndex;
        boolean areEqual;
        withIndex = ArraysKt___ArraysKt.withIndex(T());
        for (IndexedValue indexedValue : withIndex) {
            if (((Boolean) indexedValue.getValue()).booleanValue()) {
                switch (indexedValue.getIndex()) {
                    case 0:
                        areEqual = Intrinsics.areEqual(getMacro().getTriggerThatInvoked(), InvokedByDrawerTrigger.getInstance());
                        break;
                    case 1:
                        areEqual = Intrinsics.areEqual(getMacro().getTriggerThatInvoked(), InvokedByNotificationTrigger.getInstance());
                        break;
                    case 2:
                        areEqual = Intrinsics.areEqual(getMacro().getTriggerThatInvoked(), InvokedByOptionDialogTrigger.getInstance());
                        break;
                    case 3:
                        areEqual = Intrinsics.areEqual(getMacro().getTriggerThatInvoked(), InvokedByRunMacroTrigger.getInstance());
                        break;
                    case 4:
                        areEqual = getMacro().getTriggerThatInvoked() instanceof ShortcutTrigger;
                        break;
                    case 5:
                        areEqual = getMacro().getTriggerThatInvoked() instanceof GoogleAssistantTrigger;
                        break;
                    case 6:
                        areEqual = Intrinsics.areEqual(getMacro().getTriggerThatInvoked(), InvokedByQuickRunTrigger.getInstance());
                        break;
                    case 7:
                        areEqual = Intrinsics.areEqual(getMacro().getTriggerThatInvoked(), InvokedByPowerMenuTrigger.getInstance());
                        break;
                    default:
                        if (!(getMacro().getTriggerThatInvoked() instanceof InvocationTypeTrigger) && !(getMacro().getTriggerThatInvoked() instanceof ShortcutTrigger) && !(getMacro().getTriggerThatInvoked() instanceof GoogleAssistantTrigger)) {
                            areEqual = true;
                            break;
                        } else {
                            areEqual = false;
                            break;
                        }
                        break;
                }
                if (areEqual) {
                    return !this.notInvokedBy;
                }
            }
        }
        return this.notInvokedBy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.notInvokedBy ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        return U()[this.notInvokedBy ? 1 : 0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        boolean[] T = T();
        String[] options = getOptions();
        StringBuilder sb = new StringBuilder();
        int length = T.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (T[i4]) {
                sb.append(options[i4]);
                sb.append(", ");
            }
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "extendedDetail.toString()");
        return sb2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return InvocationMethodConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return U();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String p() {
        String r4 = SelectableItem.r(R.string.select_option);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.select_option)");
        return r4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Q();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        out.writeBooleanArray(this.selectedOptions);
        out.writeInt(this.notInvokedBy ? 1 : 0);
    }

    public InvocationMethodConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public InvocationMethodConstraint() {
        this.option = -1;
        this.selectedOptions = new boolean[9];
    }

    private InvocationMethodConstraint(Parcel parcel) {
        super(parcel);
        this.option = -1;
        this.selectedOptions = new boolean[9];
        this.option = parcel.readInt();
        boolean[] zArr = new boolean[9];
        this.selectedOptions = zArr;
        parcel.readBooleanArray(zArr);
        this.notInvokedBy = parcel.readInt() != 0;
    }

    /* compiled from: InvocationMethodConstraint.kt */
    /* loaded from: classes3.dex */
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
