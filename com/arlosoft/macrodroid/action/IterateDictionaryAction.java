package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.IterateDictionaryActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasDictionaryVariableName;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import me.drakeet.support.toast.ToastCompat;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IterateDictionaryAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nIterateDictionaryAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IterateDictionaryAction.kt\ncom/arlosoft/macrodroid/action/IterateDictionaryAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,262:1\n1549#2:263\n1620#2,3:264\n1549#2:269\n1620#2,3:270\n37#3,2:267\n*S KotlinDebug\n*F\n+ 1 IterateDictionaryAction.kt\ncom/arlosoft/macrodroid/action/IterateDictionaryAction\n*L\n82#1:263\n82#1:264,3\n95#1:269\n95#1:270,3\n82#1:267,2\n*E\n"})
/* loaded from: classes2.dex */
public final class IterateDictionaryAction extends LoopAction implements HasDictionaryVariableName {
    public static final int OPTION_LOOP_ITERATE_DICTIONARY = 100;
    private transient int arrayIndex;
    @Nullable
    private transient String currentKey;
    @Nullable
    private DictionaryKeys dictionaryKeys;
    private transient int elementIndex;
    private boolean isArray;
    private transient int selectedIndex;
    @NotNull
    private transient ArrayList<VariableValue.DictionaryEntry> sortedEntries;
    @Nullable
    private String variableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<IterateDictionaryAction> CREATOR = new Parcelable.Creator<IterateDictionaryAction>() { // from class: com.arlosoft.macrodroid.action.IterateDictionaryAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IterateDictionaryAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IterateDictionaryAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IterateDictionaryAction[] newArray(int i4) {
            return new IterateDictionaryAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IterateDictionaryAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<VariableValue, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f2256d = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull VariableValue variableValue) {
            Intrinsics.checkNotNullParameter(variableValue, "variableValue");
            return Boolean.valueOf(variableValue instanceof VariableValue.Dictionary);
        }
    }

    public /* synthetic */ IterateDictionaryAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(final MacroDroidVariable macroDroidVariable, final VariableValue.Dictionary dictionary, final ArrayList<String> arrayList, final int i4) {
        String str;
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        List<String> list = null;
        if (dictionaryKeys != null && dictionaryKeys.getKeys().size() > i4) {
            str = dictionaryKeys.getKeys().get(i4);
        } else {
            str = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        a aVar = a.f2256d;
        String str2 = str;
        DictionaryKeys dictionaryKeys2 = this.dictionaryKeys;
        if (dictionaryKeys2 != null) {
            list = dictionaryKeys2.getKeys();
        }
        VariableHelper.showSelectKeyDialog(activity, R.style.Theme_App_Dialog_Action, dictionary, aVar, str2, false, new VariableHelper.ManualKeyOption(true, list), false, VariableHelper.ShowThisDictionaryOption.SHOW_DICTIONARIES_AND_ARRAYS, true, new VariableHelper.KeyDialogOptionChosenCallback() { // from class: com.arlosoft.macrodroid.action.IterateDictionaryAction$showSelectKeyDialog$3

            /* compiled from: IterateDictionaryAction.kt */
            /* loaded from: classes2.dex */
            static final class a extends Lambda implements Function1<VariableHelper.ManualKeyData, Unit> {
                final /* synthetic */ MacroDroidVariable $variable;
                final /* synthetic */ IterateDictionaryAction this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(IterateDictionaryAction iterateDictionaryAction, MacroDroidVariable macroDroidVariable) {
                    super(1);
                    this.this$0 = iterateDictionaryAction;
                    this.$variable = macroDroidVariable;
                }

                public final void a(@NotNull VariableHelper.ManualKeyData manualKeyData) {
                    Intrinsics.checkNotNullParameter(manualKeyData, "<name for destructuring parameter 0>");
                    List<String> component1 = manualKeyData.component1();
                    manualKeyData.component2();
                    this.this$0.variableName = this.$variable.getName();
                    this.this$0.dictionaryKeys = new DictionaryKeys(component1);
                    this.this$0.itemComplete();
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
                if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                    VariableValue variable = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    VariableValue variable2 = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    if (((VariableValue.Dictionary) variable).hasDictionaryOrArrayChildren((VariableValue.Dictionary) variable2)) {
                        IterateDictionaryAction iterateDictionaryAction = this;
                        MacroDroidVariable macroDroidVariable2 = macroDroidVariable;
                        VariableValue variable3 = dictionaryEntry.getVariable();
                        Intrinsics.checkNotNull(variable3, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                        iterateDictionaryAction.r0(macroDroidVariable2, (VariableValue.Dictionary) variable3, arrayList, i4 + 1);
                        return;
                    }
                }
                IterateDictionaryAction iterateDictionaryAction2 = this;
                VariableValue variable4 = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable4, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                iterateDictionaryAction2.isArray = ((VariableValue.Dictionary) variable4).isArray();
                this.variableName = macroDroidVariable.getName();
                this.dictionaryKeys = new DictionaryKeys(arrayList);
                this.itemComplete();
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void manualKeyEntryChosen(@Nullable List<String> list2) {
                Macro macro;
                Activity activity2 = this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                MacroDroidVariable macroDroidVariable2 = macroDroidVariable;
                VariableValue.Dictionary dictionary2 = dictionary;
                macro = ((SelectableItem) this).m_macro;
                ArrayList<String> arrayList2 = arrayList;
                IterateDictionaryAction iterateDictionaryAction = this;
                VariableHelper.defineKeysManually(activity2, R.style.Theme_App_Dialog_Action, macroDroidVariable2, dictionary2, macro, arrayList2, list2, false, iterateDictionaryAction, false, new a(iterateDictionaryAction, macroDroidVariable));
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void thisDictionaryChosen() {
                this.variableName = macroDroidVariable.getName();
                this.dictionaryKeys = new DictionaryKeys(arrayList);
                this.isArray = dictionary.isArray();
                this.itemComplete();
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void addKeyChosen() {
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void copyAllChosen() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.selectedIndex = i4;
    }

    public final int getArrayIndex() {
        return this.arrayIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int collectionSizeOrDefault;
        int indexOf;
        ArrayList<MacroDroidVariable> variables = getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(variables, "variables");
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(variables, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MacroDroidVariable macroDroidVariable : variables) {
            arrayList.add(macroDroidVariable.getName());
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends String>) ((List<? extends Object>) arrayList), this.variableName);
        if (indexOf < 0) {
            indexOf = 0;
        }
        this.selectedIndex = indexOf;
        return indexOf;
    }

    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        String name = getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return name;
    }

    @Nullable
    public final String getCurrentKey() {
        return this.currentKey;
    }

    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.variableName;
        if (str == null) {
            str = "";
        }
        String formattedDictionaryKeys = VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        return str + formattedDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        SelectableItemInfo iterateDictionaryActionInfo = IterateDictionaryActionInfo.getInstance();
        Intrinsics.checkNotNullExpressionValue(iterateDictionaryActionInfo, "getInstance()");
        return iterateDictionaryActionInfo;
    }

    public final boolean getIsArray() {
        return this.isArray;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.variableName;
    }

    @NotNull
    public final String getVariableValue(@Nullable TriggerContextInfo triggerContextInfo) {
        List<String> emptyList;
        MacroDroidVariable variable = getVariableByName(this.variableName);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<String> applyMagicTextToDictionaryKeys = VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro());
        Intrinsics.checkNotNullExpressionValue(variable, "variable");
        VariableValue.Dictionary dictionaryFromKeyList$default = MacroDroidVariable.getDictionaryFromKeyList$default(variable, applyMagicTextToDictionaryKeys, false, false, 6, null);
        if (this.elementIndex >= dictionaryFromKeyList$default.getEntries().size()) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
        try {
            return dictionaryFromKeyList$default.getEntriesSorted().get(this.elementIndex).getVariable().getValueAsText();
        } catch (Exception unused) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return true;
    }

    public final void init() {
        this.m_option = 100;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        int collectionSizeOrDefault;
        ArrayList<MacroDroidVariable> variables = getAllDictionaryAndArrayVariables();
        if (variables.isEmpty()) {
            ToastCompat.makeText(getContext(), (int) R.string.no_variables_configured, 0).show();
        }
        Intrinsics.checkNotNullExpressionValue(variables, "variables");
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(variables, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MacroDroidVariable macroDroidVariable : variables) {
            arrayList.add(macroDroidVariable.getName());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String p() {
        String string = getContext().getString(R.string.action_set_variable_select);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…tion_set_variable_select)");
        return string;
    }

    public final void resetElementIterator() {
        this.elementIndex = -1;
        this.arrayIndex = -1;
        this.currentKey = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = getAllDictionaryAndArrayVariables();
        MacroDroidVariable macroDroidVariable = allDictionaryAndArrayVariables.get(this.selectedIndex);
        Intrinsics.checkNotNullExpressionValue(macroDroidVariable, "variables[selectedIndex]");
        r0(macroDroidVariable, allDictionaryAndArrayVariables.get(this.selectedIndex).getDictionary(), new ArrayList<>(), 0);
    }

    public final boolean selectNextElement(@Nullable TriggerContextInfo triggerContextInfo) {
        List<String> emptyList;
        MacroDroidVariable variableByName = getVariableByName(this.variableName);
        if (variableByName == null) {
            String str = this.variableName;
            SystemLog.logError("No variable found with name " + str);
            return false;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        VariableValue.Dictionary dictionaryFromKeyList$default = MacroDroidVariable.getDictionaryFromKeyList$default(variableByName, VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro()), false, false, 6, null);
        int i4 = -1;
        if (this.elementIndex == -1) {
            this.sortedEntries = new ArrayList<>(dictionaryFromKeyList$default.getEntriesSorted());
        }
        int i5 = this.elementIndex + 1;
        this.elementIndex = i5;
        if (i5 >= this.sortedEntries.size()) {
            return false;
        }
        if (dictionaryFromKeyList$default.isArray()) {
            try {
                i4 = Integer.parseInt(this.sortedEntries.get(this.elementIndex).getKey());
            } catch (Exception unused) {
            }
            this.arrayIndex = i4;
        } else {
            this.currentKey = this.sortedEntries.get(this.elementIndex).getKey();
        }
        this.sortedEntries.get(this.elementIndex);
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.dictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(@Nullable String str) {
        this.variableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.action.ParentAction, com.arlosoft.macrodroid.action.ConditionAction, com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.variableName);
        out.writeParcelable(this.dictionaryKeys, i4);
        out.writeInt(this.isArray ? 1 : 0);
        out.writeList(this.sortedEntries);
    }

    public IterateDictionaryAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        init();
        this.m_macro = macro;
    }

    public IterateDictionaryAction() {
        this.elementIndex = -1;
        this.arrayIndex = -1;
        this.sortedEntries = new ArrayList<>();
        init();
    }

    private IterateDictionaryAction(Parcel parcel) {
        super(parcel);
        this.elementIndex = -1;
        this.arrayIndex = -1;
        this.sortedEntries = new ArrayList<>();
        init();
        this.variableName = parcel.readString();
        this.dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.isArray = parcel.readInt() != 0;
        ArrayList<VariableValue.DictionaryEntry> readArrayList = parcel.readArrayList(VariableValue.DictionaryEntry.class.getClassLoader());
        Intrinsics.checkNotNull(readArrayList, "null cannot be cast to non-null type java.util.ArrayList<com.arlosoft.macrodroid.variables.VariableValue.DictionaryEntry>");
        this.sortedEntries = readArrayList;
    }

    /* compiled from: IterateDictionaryAction.kt */
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

    @Override // com.arlosoft.macrodroid.action.LoopAction, com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }
}
