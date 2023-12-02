package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ClearVariablesActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClearVariablesAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nClearVariablesAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClearVariablesAction.kt\ncom/arlosoft/macrodroid/action/ClearVariablesAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,119:1\n1855#2,2:120\n1549#2:122\n1620#2,3:123\n1549#2:137\n1620#2,3:138\n37#3,2:126\n37#3,2:135\n37#3,2:141\n11065#4:128\n11400#4,3:129\n3855#4:132\n4377#4,2:133\n3855#4:143\n4377#4,2:144\n*S KotlinDebug\n*F\n+ 1 ClearVariablesAction.kt\ncom/arlosoft/macrodroid/action/ClearVariablesAction\n*L\n40#1:120,2\n54#1:122\n54#1:123,3\n98#1:137\n98#1:138,3\n54#1:126,2\n94#1:135,2\n98#1:141,2\n55#1:128\n55#1:129,3\n56#1:132\n56#1:133,2\n65#1:143\n65#1:144,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ClearVariablesAction extends Action implements HasVariableNames {
    @NotNull
    private List<String> variableNames;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ClearVariablesAction> CREATOR = new Parcelable.Creator<ClearVariablesAction>() { // from class: com.arlosoft.macrodroid.action.ClearVariablesAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ClearVariablesAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ClearVariablesAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ClearVariablesAction[] newArray(int i4) {
            return new ClearVariablesAction[i4];
        }
    };

    public /* synthetic */ ClearVariablesAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(boolean[] selections, Ref.BooleanRef anyChecked, DialogInterface dialog, int i4, boolean z3) {
        Intrinsics.checkNotNullParameter(selections, "$selections");
        Intrinsics.checkNotNullParameter(anyChecked, "$anyChecked");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        selections[i4] = z3;
        ArrayList arrayList = new ArrayList();
        int length = selections.length;
        int i5 = 0;
        while (true) {
            boolean z4 = true;
            if (i5 < length) {
                boolean z5 = selections[i5];
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
    public static final void P(String[] allVarNames, ClearVariablesAction this$0, DialogInterface dialogInterface, int i4) {
        List<String> list;
        Intrinsics.checkNotNullParameter(allVarNames, "$allVarNames");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        alertDialog.getListView().getCheckedItemPositions();
        SparseBooleanArray checkedItemPositions = alertDialog.getListView().getCheckedItemPositions();
        ArrayList arrayList = new ArrayList();
        int size = checkedItemPositions.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (checkedItemPositions.valueAt(i5)) {
                arrayList.add(allVarNames[checkedItemPositions.keyAt(i5)]);
            }
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        this$0.variableNames = list;
        this$0.secondaryItemConfirmed();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.variableNames, ", ", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ClearVariablesActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public String[] getVariableNames() {
        return (String[]) this.variableNames.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public Integer[] getVariableTypes() {
        int collectionSizeOrDefault;
        int i4;
        List<String> list = this.variableNames;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : list) {
            MacroDroidVariable variableByName = getVariableByName(str);
            if (variableByName != null) {
                i4 = variableByName.getType();
            } else {
                i4 = 2;
            }
            arrayList.add(Integer.valueOf(i4));
        }
        return (Integer[]) arrayList.toArray(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int collectionSizeOrDefault;
        final boolean[] booleanArray;
        ArrayList<MacroDroidVariable> allVariables = getAllVariables();
        Intrinsics.checkNotNullExpressionValue(allVariables, "allVariables");
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(allVariables, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MacroDroidVariable macroDroidVariable : allVariables) {
            arrayList.add(macroDroidVariable.getName());
        }
        final String[] strArr = (String[]) arrayList.toArray(new String[0]);
        ArrayList arrayList2 = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList2.add(Boolean.valueOf(this.variableNames.contains(str)));
        }
        booleanArray = CollectionsKt___CollectionsKt.toBooleanArray(arrayList2);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ArrayList arrayList3 = new ArrayList();
        int length = booleanArray.length;
        int i4 = 0;
        while (true) {
            boolean z3 = true;
            if (i4 < length) {
                boolean z4 = booleanArray[i4];
                if (!z4) {
                    z3 = false;
                }
                if (z3) {
                    arrayList3.add(Boolean.valueOf(z4));
                }
                i4++;
            } else {
                booleanRef.element = !arrayList3.isEmpty();
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.action_clear_variables).setMultiChoiceItems(strArr, booleanArray, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.action.a3
                    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5, boolean z5) {
                        ClearVariablesAction.O(booleanArray, booleanRef, dialogInterface, i5, z5);
                    }
                }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.b3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        ClearVariablesAction.P(strArr, this, dialogInterface, i5);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(activity, alertD…onfirmed()\n            })");
                AlertDialog create = positiveButton.create();
                Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
                create.show();
                create.getButton(-1).setEnabled(booleanRef.element);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        for (String str : this.variableNames) {
            MacroDroidVariable variable = getVariableByName(str);
            if (variable != null) {
                Intrinsics.checkNotNullExpressionValue(variable, "variable");
                variableClear(variable);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(@NotNull String[] varNames) {
        List<String> list;
        Intrinsics.checkNotNullParameter(varNames, "varNames");
        list = ArraysKt___ArraysKt.toList(varNames);
        this.variableNames = list;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeStringList(this.variableNames);
    }

    public ClearVariablesAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ClearVariablesAction() {
        this.variableNames = new ArrayList();
    }

    private ClearVariablesAction(Parcel parcel) {
        super(parcel);
        this.variableNames = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.variableNames = arrayList;
        parcel.readStringList(arrayList);
    }

    /* compiled from: ClearVariablesAction.kt */
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
