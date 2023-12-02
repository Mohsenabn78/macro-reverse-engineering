package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.IsAdbHackedConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IsAdbHackedConstraint.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nIsAdbHackedConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IsAdbHackedConstraint.kt\ncom/arlosoft/macrodroid/constraint/IsAdbHackedConstraint\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,135:1\n13444#2,3:136\n3855#2:139\n4377#2,2:140\n3855#2:142\n4377#2,2:143\n13444#2,3:145\n*S KotlinDebug\n*F\n+ 1 IsAdbHackedConstraint.kt\ncom/arlosoft/macrodroid/constraint/IsAdbHackedConstraint\n*L\n50#1:136,3\n80#1:139\n80#1:140,2\n89#1:142\n89#1:143,2\n95#1:145,3\n*E\n"})
/* loaded from: classes3.dex */
public final class IsAdbHackedConstraint extends Constraint {
    @NotNull
    private final boolean[] adbOptionStates;
    private boolean isAdbHacked;
    private transient boolean[] tempAdbOptionStates;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<IsAdbHackedConstraint> CREATOR = new Parcelable.Creator<IsAdbHackedConstraint>() { // from class: com.arlosoft.macrodroid.constraint.IsAdbHackedConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IsAdbHackedConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IsAdbHackedConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IsAdbHackedConstraint[] newArray(int i4) {
            return new IsAdbHackedConstraint[i4];
        }
    };

    public /* synthetic */ IsAdbHackedConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] Q() {
        return new String[]{"WRITE_SECURE_SETTINGS", "READ_LOGS", "SET_VOLUME_KEY_LONG_PRESS_LISTENER", "CHANGE_CONFIGURATION", "DUMP"};
    }

    private final String[] R() {
        return new String[]{"android.permission.WRITE_SECURE_SETTINGS", "android.permission.READ_LOGS", "android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER", "android.permission.CHANGE_CONFIGURATION", "android.permission.DUMP"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(IsAdbHackedConstraint this$0, Ref.BooleanRef anyChecked, DialogInterface dialog, int i4, boolean z3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(anyChecked, "$anyChecked");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        boolean[] zArr = this$0.tempAdbOptionStates;
        boolean[] zArr2 = null;
        if (zArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tempAdbOptionStates");
            zArr = null;
        }
        zArr[i4] = z3;
        boolean[] zArr3 = this$0.tempAdbOptionStates;
        if (zArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tempAdbOptionStates");
        } else {
            zArr2 = zArr3;
        }
        ArrayList arrayList = new ArrayList();
        int length = zArr2.length;
        int i5 = 0;
        while (true) {
            boolean z4 = true;
            if (i5 < length) {
                boolean z5 = zArr2[i5];
                if (!z5) {
                    z4 = false;
                }
                if (z4) {
                    arrayList.add(Boolean.valueOf(z5));
                }
                i5++;
            } else {
                anyChecked.element = !arrayList.isEmpty();
                ((AlertDialog) dialog).getButton(-1).setEnabled(anyChecked.element);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(IsAdbHackedConstraint this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean[] zArr = this$0.tempAdbOptionStates;
        if (zArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tempAdbOptionStates");
            zArr = null;
        }
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            this$0.adbOptionStates[i6] = zArr[i5];
            i5++;
            i6++;
        }
        this$0.itemComplete();
    }

    private final String[] getOptions() {
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        String string = companion.getInstance().getString(R.string.constraint_is_adb_hacked_option_hacked);
        Intrinsics.checkNotNullExpressionValue(string, "MacroDroidApplication.in…adb_hacked_option_hacked)");
        String string2 = companion.getInstance().getString(R.string.constraint_is_adb_hacked_option_not_hacked);
        Intrinsics.checkNotNullExpressionValue(string2, "MacroDroidApplication.in…hacked_option_not_hacked)");
        return new String[]{string, string2};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.isAdbHacked = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        boolean[] zArr = this.adbOptionStates;
        int length = zArr.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z3 = true;
            if (i4 >= length) {
                return true;
            }
            int i6 = i5 + 1;
            if (zArr[i4]) {
                if (ContextCompat.checkSelfPermission(getContext(), R()[i5]) != 0) {
                    z3 = false;
                }
                boolean z4 = this.isAdbHacked;
                if (!z4 && z3) {
                    return false;
                }
                if (z4 && !z3) {
                    return false;
                }
            }
            i4++;
            i5 = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.isAdbHacked ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        if (this.isAdbHacked) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        SelectableItemInfo isAdbHackedConstraintInfo = IsAdbHackedConstraintInfo.getInstance();
        Intrinsics.checkNotNullExpressionValue(isAdbHackedConstraintInfo, "getInstance()");
        return isAdbHackedConstraintInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean[] zArr = this.adbOptionStates;
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i4 = 0;
        while (true) {
            boolean z3 = true;
            if (i4 >= length) {
                break;
            }
            boolean z4 = zArr[i4];
            if (!z4) {
                z3 = false;
            }
            if (z3) {
                arrayList.add(Boolean.valueOf(z4));
            }
            i4++;
        }
        booleanRef.element = !arrayList.isEmpty();
        this.tempAdbOptionStates = (boolean[]) this.adbOptionStates.clone();
        AlertDialog.Builder title = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog_Constraint_SmallerText).setTitle(getConfiguredName());
        String[] Q = Q();
        boolean[] zArr2 = this.tempAdbOptionStates;
        if (zArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tempAdbOptionStates");
            zArr2 = null;
        }
        AlertDialog.Builder positiveButton = title.setMultiChoiceItems(Q, zArr2, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.z1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i5, boolean z5) {
                IsAdbHackedConstraint.S(IsAdbHackedConstraint.this, booleanRef, dialogInterface, i5, z5);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.a2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                IsAdbHackedConstraint.T(IsAdbHackedConstraint.this, dialogInterface, i5);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(activity, R.styl…lete()\n                })");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        create.getButton(-1).setEnabled(booleanRef.element);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.isAdbHacked ? 1 : 0);
        out.writeBooleanArray(this.adbOptionStates);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IsAdbHackedConstraint(@Nullable Activity activity, @NotNull Macro macro) {
        this();
        Intrinsics.checkNotNullParameter(macro, "macro");
        setActivity(activity);
        this.m_macro = macro;
    }

    private IsAdbHackedConstraint() {
        this.adbOptionStates = new boolean[]{true, true, true, true, true};
        this.isAdbHacked = true;
    }

    private IsAdbHackedConstraint(Parcel parcel) {
        super(parcel);
        boolean[] zArr = {true, true, true, true, true};
        this.adbOptionStates = zArr;
        this.isAdbHacked = parcel.readInt() != 0;
        parcel.readBooleanArray(zArr);
    }

    /* compiled from: IsAdbHackedConstraint.kt */
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
