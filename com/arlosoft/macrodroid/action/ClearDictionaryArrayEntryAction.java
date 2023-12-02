package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ClearDictionaryArrayEntryActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeyStrings;
import com.arlosoft.macrodroid.interfaces.HasDictionaryVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClearDictionaryArrayEntryAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nClearDictionaryArrayEntryAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClearDictionaryArrayEntryAction.kt\ncom/arlosoft/macrodroid/action/ClearDictionaryArrayEntryAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,214:1\n1549#2:215\n1620#2,3:216\n37#3,2:219\n37#3,2:221\n*S KotlinDebug\n*F\n+ 1 ClearDictionaryArrayEntryAction.kt\ncom/arlosoft/macrodroid/action/ClearDictionaryArrayEntryAction\n*L\n91#1:215\n91#1:216,3\n91#1:219,2\n176#1:221,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ClearDictionaryArrayEntryAction extends Action implements SupportsMagicText, HasDictionaryVariableName, HasDictionaryKeyStrings {
    public static final int CLEAR_OPTION_CLEAR_VALUE = 0;
    public static final int CLEAR_OPTION_DELETE_KEY = 1;
    private int clearOption;
    @NotNull
    private ArrayList<String> dictionaryKeys;
    @Nullable
    private String variableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ClearDictionaryArrayEntryAction> CREATOR = new Parcelable.Creator<ClearDictionaryArrayEntryAction>() { // from class: com.arlosoft.macrodroid.action.ClearDictionaryArrayEntryAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ClearDictionaryArrayEntryAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ClearDictionaryArrayEntryAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ClearDictionaryArrayEntryAction[] newArray(int i4) {
            return new ClearDictionaryArrayEntryAction[i4];
        }
    };

    public /* synthetic */ ClearDictionaryArrayEntryAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final int O() {
        int i4 = this.clearOption;
        if (i4 > 1) {
            return 0;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(ClearDictionaryArrayEntryAction this$0, ArrayList arrayList, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        Object obj = arrayList.get(checkedItemPosition);
        Intrinsics.checkNotNullExpressionValue(obj, "allVars[index]");
        this$0.S((MacroDroidVariable) obj, ((MacroDroidVariable) arrayList.get(checkedItemPosition)).getDictionary(), new ArrayList<>(), VariableHelper.ShowThisDictionaryOption.DONT_SHOW, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(final MacroDroidVariable macroDroidVariable, final ArrayList<String> arrayList) {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.action_clear_variables).setSingleChoiceItems(Companion.a(), O(), (DialogInterface.OnClickListener) null).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.o2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ClearDictionaryArrayEntryAction.R(ClearDictionaryArrayEntryAction.this, macroDroidVariable, arrayList, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(activity, alertD…rmed()\n                })");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ClearDictionaryArrayEntryAction this$0, MacroDroidVariable variable, ArrayList keyList, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(variable, "$variable");
        Intrinsics.checkNotNullParameter(keyList, "$keyList");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        this$0.clearOption = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        this$0.variableName = variable.getName();
        this$0.dictionaryKeys = keyList;
        this$0.secondaryItemConfirmed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(final MacroDroidVariable macroDroidVariable, final VariableValue.Dictionary dictionary, final ArrayList<String> arrayList, VariableHelper.ShowThisDictionaryOption showThisDictionaryOption, final int i4) {
        String str;
        if (this.dictionaryKeys.size() > i4) {
            str = this.dictionaryKeys.get(i4);
        } else {
            str = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        VariableHelper.showSelectKeyDialog(activity, R.style.Theme_App_Dialog_Action, dictionary, null, str, false, new VariableHelper.ManualKeyOption(true, this.dictionaryKeys), false, showThisDictionaryOption, true, new VariableHelper.KeyDialogOptionChosenCallback() { // from class: com.arlosoft.macrodroid.action.ClearDictionaryArrayEntryAction$showSelectKeyDialog$1

            /* compiled from: ClearDictionaryArrayEntryAction.kt */
            /* loaded from: classes2.dex */
            static final class a extends Lambda implements Function1<VariableHelper.ManualKeyData, Unit> {
                final /* synthetic */ ArrayList<String> $keyList;
                final /* synthetic */ MacroDroidVariable $variable;
                final /* synthetic */ ClearDictionaryArrayEntryAction this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(ArrayList<String> arrayList, ClearDictionaryArrayEntryAction clearDictionaryArrayEntryAction, MacroDroidVariable macroDroidVariable) {
                    super(1);
                    this.$keyList = arrayList;
                    this.this$0 = clearDictionaryArrayEntryAction;
                    this.$variable = macroDroidVariable;
                }

                public final void a(@NotNull VariableHelper.ManualKeyData manualKeyData) {
                    Intrinsics.checkNotNullParameter(manualKeyData, "<name for destructuring parameter 0>");
                    List<String> component1 = manualKeyData.component1();
                    manualKeyData.component2();
                    this.$keyList.clear();
                    this.$keyList.addAll(component1);
                    this.this$0.Q(this.$variable, this.$keyList);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(VariableHelper.ManualKeyData manualKeyData) {
                    a(manualKeyData);
                    return Unit.INSTANCE;
                }
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void keyChosen(@NotNull VariableValue.DictionaryEntry dictionaryEntry) {
                Intrinsics.checkNotNullParameter(dictionaryEntry, "dictionaryEntry");
                arrayList.add(dictionaryEntry.getKey());
                if (!(dictionaryEntry.getVariable() instanceof VariableValue.Dictionary)) {
                    ClearDictionaryArrayEntryAction.this.Q(macroDroidVariable, arrayList);
                    return;
                }
                ClearDictionaryArrayEntryAction clearDictionaryArrayEntryAction = ClearDictionaryArrayEntryAction.this;
                MacroDroidVariable macroDroidVariable2 = macroDroidVariable;
                VariableValue variable = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                clearDictionaryArrayEntryAction.S(macroDroidVariable2, (VariableValue.Dictionary) variable, arrayList, VariableHelper.ShowThisDictionaryOption.SHOW_DICTIONARIES_AND_ARRAYS, i4 + 1);
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void manualKeyEntryChosen(@Nullable List<String> list) {
                Macro macro;
                Activity activity2 = ClearDictionaryArrayEntryAction.this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                MacroDroidVariable macroDroidVariable2 = macroDroidVariable;
                VariableValue.Dictionary dictionary2 = dictionary;
                macro = ((SelectableItem) ClearDictionaryArrayEntryAction.this).m_macro;
                ArrayList<String> arrayList2 = arrayList;
                ClearDictionaryArrayEntryAction clearDictionaryArrayEntryAction = ClearDictionaryArrayEntryAction.this;
                VariableHelper.defineKeysManually(activity2, R.style.Theme_App_Dialog_Action, macroDroidVariable2, dictionary2, macro, arrayList2, list, false, clearDictionaryArrayEntryAction, false, new a(arrayList2, clearDictionaryArrayEntryAction, macroDroidVariable));
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void thisDictionaryChosen() {
                ClearDictionaryArrayEntryAction.this.Q(macroDroidVariable, arrayList);
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void addKeyChosen() {
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void copyAllChosen() {
            }
        });
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeyStrings
    @Nullable
    public List<String> getDictionaryKeyStrings() {
        return this.dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.variableName;
        if (str == null) {
            str = "";
        }
        String formattedDictionaryKeys = VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        String str2 = Companion.a()[O()];
        return str + formattedDictionaryKeys + ": " + str2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ClearDictionaryArrayEntryActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return (String[]) this.dictionaryKeys.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.variableName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int collectionSizeOrDefault;
        boolean z3;
        int indexOf;
        int coerceAtLeast;
        final ArrayList<MacroDroidVariable> allVars = getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allVars, "allVars");
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(allVars, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MacroDroidVariable macroDroidVariable : allVars) {
            arrayList.add(macroDroidVariable.getName());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        if (strArr.length == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            indexOf = ArraysKt___ArraysKt.indexOf(strArr, this.variableName);
            coerceAtLeast = kotlin.ranges.h.coerceAtLeast(indexOf, 0);
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.action_clear_variables).setSingleChoiceItems(strArr, coerceAtLeast, (DialogInterface.OnClickListener) null).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.n2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ClearDictionaryArrayEntryAction.P(ClearDictionaryArrayEntryAction.this, allVars, dialogInterface, i4);
                }
            });
            Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(activity, alertD…T_SHOW, 0)\n            })");
            AlertDialog create = positiveButton.create();
            Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
            create.show();
            return;
        }
        ToastCompat.makeText(getContext(), (int) R.string.no_variables, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        List dropLast;
        MacroDroidVariable variableByName = getVariableByName(this.variableName);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ArrayList<String> applyMagicTextToDictionaryKeys = VariableHelper.applyMagicTextToDictionaryKeys(context, this.dictionaryKeys, triggerContextInfo, getMacro());
        if (variableByName != null) {
            if (O() == 0) {
                variableClear(variableByName, applyMagicTextToDictionaryKeys);
                return;
            }
            VariableValue.DictionaryEntry targetDictionaryEntry = variableByName.getTargetDictionaryEntry(applyMagicTextToDictionaryKeys, false);
            if (targetDictionaryEntry != null) {
                dropLast = CollectionsKt___CollectionsKt.dropLast(applyMagicTextToDictionaryKeys, 1);
                VariableValue.Dictionary dictionaryFromKeyList$default = MacroDroidVariable.getDictionaryFromKeyList$default(variableByName, dropLast, false, false, 6, null);
                dictionaryFromKeyList$default.removeEntry(targetDictionaryEntry);
                getMacro().notifyVariableListenersOnCorrectThread(variableByName, dictionaryFromKeyList$default, dictionaryFromKeyList$default);
                return;
            }
            String str = this.variableName;
            if (str == null) {
                str = VariableHelper.getFormattedDictionaryKeys(applyMagicTextToDictionaryKeys);
            }
            String str2 = "Dictionary entry not found: " + str + " (Cannot delete)";
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logWarning(str2, macroGuid.longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeyStrings
    public void setDictionaryKeyStrings(@Nullable List<String> list) {
        if (list != null) {
            this.dictionaryKeys = new ArrayList<>(list);
        } else {
            this.dictionaryKeys = new ArrayList<>();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Collection collection;
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        collection = ArraysKt___ArraysKt.toCollection(magicText, new ArrayList());
        this.dictionaryKeys = (ArrayList) collection;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(@Nullable String str) {
        this.variableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.variableName);
        out.writeStringList(this.dictionaryKeys);
        out.writeInt(this.clearOption);
    }

    public ClearDictionaryArrayEntryAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ClearDictionaryArrayEntryAction() {
        this.dictionaryKeys = new ArrayList<>();
    }

    private ClearDictionaryArrayEntryAction(Parcel parcel) {
        super(parcel);
        this.dictionaryKeys = new ArrayList<>();
        this.variableName = parcel.readString();
        ArrayList<String> arrayList = new ArrayList<>();
        this.dictionaryKeys = arrayList;
        parcel.readStringList(arrayList);
        this.clearOption = parcel.readInt();
    }

    /* compiled from: ClearDictionaryArrayEntryAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] a() {
            return new String[]{SelectableItem.r(R.string.action_clear_dictionary_array_entry_option_clear_value), SelectableItem.r(R.string.action_clear_dictionary_array_entry_option_delete_key)};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
