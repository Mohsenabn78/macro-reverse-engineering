package com.arlosoft.macrodroid.actionblock.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ActionBlockAction;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlock.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@SourceDebugExtension({"SMAP\nActionBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlock.kt\ncom/arlosoft/macrodroid/actionblock/data/ActionBlock\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,184:1\n1855#2,2:185\n288#2,2:187\n*S KotlinDebug\n*F\n+ 1 ActionBlock.kt\ncom/arlosoft/macrodroid/actionblock/data/ActionBlock\n*L\n143#1:185,2\n170#1:187,2\n*E\n"})
/* loaded from: classes.dex */
public final class ActionBlock extends Macro {
    @Nullable
    private transient ActionBlockAction actionThatInvoked;
    private boolean isInputExpanded;
    private boolean isLocalExpanded;
    private boolean isOutputExpanded;
    private boolean isTestMode;
    @Nullable
    private transient Macro parentMacro;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ActionBlock> CREATOR = new Parcelable.Creator<ActionBlock>() { // from class: com.arlosoft.macrodroid.actionblock.data.ActionBlock$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ActionBlock createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ActionBlock(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ActionBlock[] newArray(int i4) {
            return new ActionBlock[i4];
        }
    };

    public ActionBlock() {
        this.isActionBlock = true;
    }

    public static /* synthetic */ ActionBlock cloneActionBlock$default(ActionBlock actionBlock, boolean z3, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = true;
        }
        return actionBlock.cloneActionBlock(z3, z4);
    }

    private final String getDefaultValueAsText(String str) {
        Object obj;
        List<MacroDroidVariable> inputOnlyActionBlockVariables = getInputOnlyActionBlockVariables(false);
        Intrinsics.checkNotNullExpressionValue(inputOnlyActionBlockVariables, "getInputOnlyActionBlockVariables(false)");
        Iterator<T> it = inputOnlyActionBlockVariables.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((MacroDroidVariable) obj).getName(), str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MacroDroidVariable macroDroidVariable = (MacroDroidVariable) obj;
        if (macroDroidVariable != null) {
            int type = macroDroidVariable.getType();
            if (type != 0) {
                if (type != 1) {
                    if (type != 2) {
                        if (type != 3) {
                            return macroDroidVariable.getStringValue();
                        }
                        return String.valueOf(macroDroidVariable.getDecimalValue());
                    }
                    return macroDroidVariable.getStringValue();
                }
                return String.valueOf(macroDroidVariable.getValueAsInt());
            }
            return String.valueOf(macroDroidVariable.getBooleanValue());
        }
        return "";
    }

    @NotNull
    public final ActionBlock cloneActionBlock(boolean z3, boolean z4) {
        Macro clone = clone(new ActionBlock(), z3, true, z4);
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.arlosoft.macrodroid.actionblock.data.ActionBlock");
        ActionBlock actionBlock = (ActionBlock) clone;
        actionBlock.setIsClonedInstance(!z3);
        return actionBlock;
    }

    @NotNull
    public final ActionBlock exactClone() {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        obtain.writeParcelable(this, 0);
        obtain.setDataPosition(0);
        ActionBlock actionBlock = (ActionBlock) obtain.readParcelable(ActionBlock.class.getClassLoader());
        obtain.recycle();
        Intrinsics.checkNotNull(actionBlock);
        return actionBlock;
    }

    @Nullable
    public final MacroDroidVariable findLocalVariableByName(@NotNull String variableName, boolean z3) {
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        for (MacroDroidVariable macroDroidVariable : getLocalVariables()) {
            if (Intrinsics.areEqual(macroDroidVariable.getName(), variableName) && ((z3 && macroDroidVariable.getSupportsInput()) || (!z3 && macroDroidVariable.getSupportsOutput()))) {
                return macroDroidVariable;
            }
        }
        return null;
    }

    @Nullable
    public final ActionBlockAction getActionThatInvoked() {
        return this.actionThatInvoked;
    }

    @Override // com.arlosoft.macrodroid.macro.Macro
    @NotNull
    public List<Constraint> getConstraints() {
        return new ArrayList();
    }

    @Nullable
    public final Macro getParentMacro() {
        return this.parentMacro;
    }

    @Nullable
    public final Macro getTopLevelParentMacro() {
        Macro macro = this.parentMacro;
        while (macro != null && (macro instanceof ActionBlock)) {
            macro = ((ActionBlock) macro).parentMacro;
        }
        return macro;
    }

    @Override // com.arlosoft.macrodroid.macro.Macro
    @NotNull
    public ArrayList<Trigger> getTriggerList() {
        return new ArrayList<>();
    }

    public final void invokeActions(@Nullable TriggerContextInfo triggerContextInfo, boolean z3, @Nullable ResumeMacroInfo resumeMacroInfo, @NotNull Map<String, String> inputValues, @NotNull Map<String, DictionaryKeys> inputKeys, @Nullable Macro macro) {
        List<String> emptyList;
        String defaultValueAsText;
        Intrinsics.checkNotNullParameter(inputValues, "inputValues");
        Intrinsics.checkNotNullParameter(inputKeys, "inputKeys");
        List<MacroDroidVariable> inputVariables = getInputOnlyActionBlockVariables(false);
        this.parentMacro = macro;
        Intrinsics.checkNotNullExpressionValue(inputVariables, "inputVariables");
        for (MacroDroidVariable macroDroidVariable : inputVariables) {
            String str = inputValues.get(macroDroidVariable.getName());
            DictionaryKeys dictionaryKeys = inputKeys.get(macroDroidVariable.getName());
            MacroDroidVariable macroDroidVariable2 = null;
            if (macroDroidVariable.getType() != 4 && macroDroidVariable.getType() != 5) {
                if (str != null) {
                    defaultValueAsText = MagicText.replaceMagicText(MacroDroidApplication.Companion.getInstance(), str, triggerContextInfo, macro);
                } else {
                    defaultValueAsText = getDefaultValueAsText(macroDroidVariable.getName());
                }
                String value = defaultValueAsText;
                if (value != null) {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    macroDroidVariable.setVariableValue(VariableValue.Companion.fromTextValueForType$default(VariableValue.Companion, value, macroDroidVariable.getType(), null, 4, null), false, null, this);
                }
            } else {
                if (macro != null) {
                    macroDroidVariable2 = macro.getVariableByName(str);
                }
                MacroDroidVariable macroDroidVariable3 = macroDroidVariable2;
                if (macroDroidVariable3 != null) {
                    if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    macroDroidVariable.setDictionary(MacroDroidVariable.getDictionaryFromKeyList$default(macroDroidVariable3, emptyList, false, false, 6, null));
                }
            }
        }
        invokeActionsInternal(triggerContextInfo, z3, resumeMacroInfo);
    }

    public final boolean isInputExpanded() {
        return this.isInputExpanded;
    }

    public final boolean isLocalExpanded() {
        return this.isLocalExpanded;
    }

    public final boolean isOutputExpanded() {
        return this.isOutputExpanded;
    }

    public final boolean isTestMode() {
        return this.isTestMode;
    }

    @Override // com.arlosoft.macrodroid.macro.Macro
    public boolean isValid() {
        if (this.m_actionList.size() < 1) {
            return false;
        }
        Iterator<Action> it = this.m_actionList.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                return false;
            }
        }
        return true;
    }

    public final void setActionThatInvoked(@Nullable ActionBlockAction actionBlockAction) {
        this.actionThatInvoked = actionBlockAction;
    }

    public final void setInputExpanded(boolean z3) {
        this.isInputExpanded = z3;
    }

    public final void setLocalExpanded(boolean z3) {
        this.isLocalExpanded = z3;
    }

    public final void setOutputExpanded(boolean z3) {
        this.isOutputExpanded = z3;
    }

    public final void setParentMacro(@Nullable Macro macro) {
        this.parentMacro = macro;
    }

    public final void setTestMode(boolean z3) {
        this.isTestMode = z3;
    }

    @Override // com.arlosoft.macrodroid.macro.Macro, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.isInputExpanded ? 1 : 0);
        out.writeInt(this.isOutputExpanded ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBlock(@NotNull Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.isActionBlock = true;
        this.isInputExpanded = parcel.readInt() != 0;
        this.isOutputExpanded = parcel.readInt() != 0;
    }

    /* compiled from: ActionBlock.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ActionBlock createEmpty() {
            ActionBlock actionBlock = new ActionBlock();
            actionBlock.setCompleted(false);
            actionBlock.setDescriptionOpen(true);
            return actionBlock;
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
