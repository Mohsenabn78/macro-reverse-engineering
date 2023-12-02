package com.arlosoft.macrodroid.macro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ActionBlockAction;
import com.arlosoft.macrodroid.action.ElseAction;
import com.arlosoft.macrodroid.action.ElseIfConditionAction;
import com.arlosoft.macrodroid.action.EndParentAction;
import com.arlosoft.macrodroid.action.IfConditionAction;
import com.arlosoft.macrodroid.action.IfConfirmedThenAction;
import com.arlosoft.macrodroid.action.LoopAction;
import com.arlosoft.macrodroid.action.ParentAction;
import com.arlosoft.macrodroid.action.ShellScriptAction;
import com.arlosoft.macrodroid.action.WaitUntilTriggerAction;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.VariableUpdatedListener;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.data.UserIconData;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.ShowActionBlockTestSummaryEvent;
import com.arlosoft.macrodroid.interfaces.ReferenceSelfGUIDs;
import com.arlosoft.macrodroid.interfaces.SupportsUserImages;
import com.arlosoft.macrodroid.interfaces.UsesActionBlocks;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.RemovedItem;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.MacroFinishedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.CopyHelper;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes3.dex */
public class Macro implements Parcelable {
    public static final Parcelable.Creator<Macro> CREATOR = new a();
    private static final int MAX_INVOCATIONS_PER_SECOND = 500;
    private static long macroDroidDisabledTimeStamp;
    private static boolean sMacroDroidEnabled;
    private static int s_idCounter;
    private transient List<ActionBlock> actionBlocksToImport;
    private transient WaitUntilTriggerAction actionWaitingForTriggerActive;
    @Nullable
    private transient ShellScriptAction activeShellScriptAction;
    private long disabledTimestamp;
    private transient boolean enabledStateDuringLoad;
    private List<ActionBlock> exportedActionBlocks;
    private long forceEvenIfNotEnabledTimestamp;
    public boolean isActionBlock;
    private boolean isBeingImported;
    private boolean isClonedInstance;
    private boolean isExtra;
    private boolean isFavourite;
    private transient boolean isRunning;
    private long lastEditedTimestamp;
    private transient Set<VariableUpdatedListener> localVariableUpdatedListeners;
    private ArrayList<MacroDroidVariable> localVariables;
    private long m_GUID;
    private transient Action m_actionBeingConfigured;
    protected ArrayList<Action> m_actionList;
    private transient boolean m_cancelFlag;
    private String m_category;
    private transient boolean m_completed;
    private transient boolean m_configuringShortcut;
    private List<Constraint> m_constraintList;
    private String m_description;
    private boolean m_descriptionOpen;
    private boolean m_enabled;
    private boolean m_excludeLog;
    @ColorInt
    private int m_headingColor;
    private transient int m_invokeCount;
    private transient long m_invokeStart;
    private boolean m_isOrCondition;
    private String m_name;
    private transient boolean m_resetLoopCount;
    private transient Object m_tag;
    private Trigger m_trigger;
    private ArrayList<Trigger> m_triggerList;
    private transient int m_uniqueId;
    private transient long originalMacroGuid;
    private transient TriggerContextInfo originalTriggerContextInfo;
    private transient TriggerContextInfo triggerContextInfo;
    private transient Trigger triggerThatInvoked;
    private transient boolean wasEnabledIncludingCategory;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<Macro> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Macro createFromParcel(Parcel parcel) {
            return new Macro(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Macro[] newArray(int i4) {
            return new Macro[i4];
        }
    }

    public Macro() {
        this.m_enabled = false;
        this.wasEnabledIncludingCategory = false;
        this.enabledStateDuringLoad = false;
        this.m_descriptionOpen = false;
        this.m_completed = true;
        this.isActionBlock = false;
        this.isBeingImported = false;
        this.isClonedInstance = false;
        this.isFavourite = false;
        this.localVariableUpdatedListeners = Collections.synchronizedSet(new HashSet());
        this.actionWaitingForTriggerActive = null;
        this.originalTriggerContextInfo = null;
        this.isRunning = false;
        this.originalMacroGuid = 0L;
        this.exportedActionBlocks = new ArrayList();
        this.actionBlocksToImport = new ArrayList();
        this.forceEvenIfNotEnabledTimestamp = 0L;
        this.disabledTimestamp = 0L;
        this.isExtra = false;
        this.activeShellScriptAction = null;
        if (this.m_GUID == 0) {
            this.m_GUID = UUID.randomUUID().getLeastSignificantBits();
        }
        this.m_name = "";
        int i4 = s_idCounter + 1;
        s_idCounter = i4;
        this.m_uniqueId = i4;
        this.m_triggerList = new ArrayList<>();
        this.m_actionList = new ArrayList<>();
        this.m_constraintList = new ArrayList();
        this.localVariables = new ArrayList<>();
    }

    @Nullable
    private RemovedItem.ChildConstraint deleteChildConstraint(SelectableItem selectableItem, SelectableItem selectableItem2) {
        if (selectableItem.getConstraints() != null) {
            for (int i4 = 0; i4 < selectableItem.getConstraints().size(); i4++) {
                Constraint constraint = selectableItem.getConstraints().get(i4);
                if (selectableItem2 == constraint) {
                    selectableItem.removeConstraint(constraint);
                    return new RemovedItem.ChildConstraint(selectableItem, i4, constraint);
                }
                RemovedItem.ChildConstraint deleteChildConstraint = deleteChildConstraint(constraint, selectableItem2);
                if (deleteChildConstraint != null) {
                    return deleteChildConstraint;
                }
            }
            return null;
        }
        return null;
    }

    private void displayOutputVarSummary(ResumeMacroInfo resumeMacroInfo) {
        ActionBlock actionBlock = (ActionBlock) this;
        actionBlock.getParentMacro();
        EventBusUtils.getEventBus().post(new ShowActionBlockTestSummaryEvent(actionBlock, getOutputOnlyActionBlockVariables(false)));
    }

    private SelectableItem findSelectableItemFromChildren(SelectableItem selectableItem, long j4) {
        if (selectableItem.getSIGUID() == j4) {
            return selectableItem;
        }
        if (selectableItem instanceof WaitUntilTriggerAction) {
            Iterator<Trigger> it = ((WaitUntilTriggerAction) selectableItem).getTriggersToWaitFor().iterator();
            while (it.hasNext()) {
                SelectableItem findSelectableItemFromChildren = findSelectableItemFromChildren(it.next(), j4);
                if (findSelectableItemFromChildren != null) {
                    return findSelectableItemFromChildren;
                }
            }
        }
        if (selectableItem.getConstraints() != null) {
            for (Constraint constraint : selectableItem.getConstraints()) {
                SelectableItem findSelectableItemFromChildren2 = findSelectableItemFromChildren(constraint, j4);
                if (findSelectableItemFromChildren2 != null) {
                    return findSelectableItemFromChildren2;
                }
            }
            return null;
        }
        return null;
    }

    private boolean isCategoryDisabled() {
        if (this.isExtra || !Settings.getDisabledCategories(MacroDroidApplication.getInstance()).contains(getCategory())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getLocalVariablesSorted$2(Locale locale, MacroDroidVariable macroDroidVariable, MacroDroidVariable macroDroidVariable2) {
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(macroDroidVariable.getName(), macroDroidVariable2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$removeItem$1(RemovedItem removedItem, RemovedItem removedItem2) {
        return removedItem.getIndex() - removedItem2.getIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$removeItemAndChildren$0(RemovedItem removedItem, RemovedItem removedItem2) {
        return removedItem.getIndex() - removedItem2.getIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortVariables$3(Locale locale, MacroDroidVariable macroDroidVariable, MacroDroidVariable macroDroidVariable2) {
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(macroDroidVariable.getName(), macroDroidVariable2.getName());
    }

    private void logAction(Action action, TriggerContextInfo triggerContextInfo) {
        if (!this.m_excludeLog) {
            SystemLog.logAction(action.getSystemLogEntryName(triggerContextInfo), getGUID());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: notifyVariableListeners */
    public void lambda$notifyVariableListenersOnCorrectThread$4(MacroDroidVariable macroDroidVariable, VariableValue variableValue, VariableValue variableValue2) {
        synchronized (this.localVariableUpdatedListeners) {
            for (VariableUpdatedListener variableUpdatedListener : new HashSet(this.localVariableUpdatedListeners)) {
                variableUpdatedListener.variableValueUpdated(macroDroidVariable, variableValue, variableValue2, getGUID());
            }
        }
    }

    public static void setMacroDroidEnabledState(boolean z3) {
        long currentTimeMillis;
        sMacroDroidEnabled = z3;
        if (z3) {
            currentTimeMillis = 0;
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        macroDroidDisabledTimeStamp = currentTimeMillis;
    }

    private void setOriginalMacroGuid(long j4) {
        this.originalMacroGuid = j4;
    }

    private void updateActionBlockOutputVariables(ResumeMacroInfo resumeMacroInfo) {
        ArrayList<String> applyMagicTextToDictionaryKeys;
        MacroDroidVariable variableByName;
        if (this.isActionBlock) {
            ActionBlock actionBlock = (ActionBlock) this;
            ActionBlockAction actionThatInvoked = actionBlock.getActionThatInvoked();
            if (actionThatInvoked != null) {
                List<MacroDroidVariable> outputOnlyActionBlockVariables = getOutputOnlyActionBlockVariables(true);
                Map<String, String> outputVarsMap = actionThatInvoked.getOutputVarsMap();
                Map<String, DictionaryKeys> outputDictionaryMap = actionThatInvoked.getOutputDictionaryMap();
                for (MacroDroidVariable macroDroidVariable : outputOnlyActionBlockVariables) {
                    String str = outputVarsMap.get(macroDroidVariable.getName());
                    DictionaryKeys dictionaryKeys = outputDictionaryMap.get(macroDroidVariable.getName());
                    if (dictionaryKeys == null) {
                        applyMagicTextToDictionaryKeys = null;
                    } else {
                        applyMagicTextToDictionaryKeys = VariableHelper.applyMagicTextToDictionaryKeys(MacroDroidApplication.getInstance(), dictionaryKeys.getKeys(), this.triggerContextInfo, actionBlock.getParentMacro());
                    }
                    if (str != null && (variableByName = actionThatInvoked.getVariableByName(str)) != null) {
                        VariableValue variableValue = macroDroidVariable.getVariableValue();
                        if (applyMagicTextToDictionaryKeys != null) {
                            variableValue.setParentKeys(applyMagicTextToDictionaryKeys);
                        }
                        actionThatInvoked.variableUpdate(variableByName, variableValue);
                    }
                }
                return;
            }
            Macro parentMacro = actionBlock.getParentMacro();
            List<MacroDroidVariable> outputOnlyActionBlockVariables2 = getOutputOnlyActionBlockVariables(true);
            Map<String, String> actionBlockOutputParameters = resumeMacroInfo.getActionBlockOutputParameters();
            if (actionBlockOutputParameters != null) {
                for (MacroDroidVariable macroDroidVariable2 : outputOnlyActionBlockVariables2) {
                    String str2 = actionBlockOutputParameters.get(macroDroidVariable2.getName());
                    if (str2 != null) {
                        if (parentMacro != null) {
                            MacroDroidVariable variableByName2 = parentMacro.getVariableByName(str2);
                            if (variableByName2 != null) {
                                parentMacro.variableUpdate(variableByName2, macroDroidVariable2.getVariableValue());
                            }
                        } else {
                            MacroDroidVariable variableByName3 = MacroDroidVariableStore.getInstance().getVariableByName(str2);
                            if (variableByName3 != null) {
                                MacroDroidVariableStore.getInstance().variableUpdate(variableByName3, macroDroidVariable2.getVariableValue(), true, null);
                            }
                        }
                    }
                }
            }
        }
    }

    private void updateGUIDRefsIfRequired(long j4, long j5, SelectableItem selectableItem) {
        if (selectableItem instanceof ReferenceSelfGUIDs) {
            ReferenceSelfGUIDs referenceSelfGUIDs = (ReferenceSelfGUIDs) selectableItem;
            ArrayList<Long> gUIDs = referenceSelfGUIDs.getGUIDs();
            for (int i4 = 0; i4 < gUIDs.size(); i4++) {
                if (gUIDs.get(i4).longValue() == j4) {
                    gUIDs.set(i4, Long.valueOf(j5));
                }
            }
            referenceSelfGUIDs.setGUIDs(gUIDs);
        }
    }

    public void addAction(Action action) {
        this.m_actionList.add(action);
        action.setMacro(this);
    }

    public void addActionAtIndex(Action action, int i4) {
        if (i4 >= this.m_actionList.size()) {
            i4 = Math.max(this.m_actionList.size() - 1, 0);
        }
        this.m_actionList.add(i4, action);
    }

    public void addActionBlocksToList(ActionBlockStore actionBlockStore, ArrayList<ActionBlock> arrayList, Action action) {
        if (action instanceof ActionBlockAction) {
            ActionBlock actionBlockByGuid = actionBlockStore.getActionBlockByGuid(((ActionBlockAction) action).getActionBlockId());
            if (actionBlockByGuid != null && actionBlockByGuid.getGUID() != getGUID() && !arrayList.contains(actionBlockByGuid)) {
                arrayList.add(actionBlockByGuid);
                Iterator<Action> it = actionBlockByGuid.getActions().iterator();
                while (it.hasNext()) {
                    addActionBlocksToList(actionBlockStore, arrayList, it.next());
                }
            }
        } else if (action instanceof UsesActionBlocks) {
            for (String str : ((UsesActionBlocks) action).getActionBlockNames()) {
                ActionBlock actionBlockByName = actionBlockStore.getActionBlockByName(str);
                if (actionBlockByName != null && actionBlockByName.getGUID() != getGUID() && !arrayList.contains(actionBlockByName)) {
                    arrayList.add(actionBlockByName);
                    Iterator<Action> it2 = actionBlockByName.getActions().iterator();
                    while (it2.hasNext()) {
                        addActionBlocksToList(actionBlockStore, arrayList, it2.next());
                    }
                }
            }
        }
    }

    public void addConstraint(Constraint constraint) {
        if (isEnabled()) {
            constraint.enableConstraintCheckingThreadSafe();
        }
        this.m_constraintList.add(constraint);
        constraint.setMacro(this);
    }

    public void addConstraintsToList(List<Constraint> list, Constraint constraint) {
        list.add(constraint);
        for (Constraint constraint2 : constraint.getConstraints()) {
            addConstraintsToList(list, constraint2);
        }
    }

    public void addLocalVariableUpdatedListener(VariableUpdatedListener variableUpdatedListener) {
        synchronized (this.localVariableUpdatedListeners) {
            this.localVariableUpdatedListeners.add(variableUpdatedListener);
        }
    }

    public void addTrigger(Trigger trigger) {
        this.m_triggerList.add(trigger);
        trigger.setMacro(this);
    }

    public boolean canInvoke(TriggerContextInfo triggerContextInfo) {
        WaitUntilTriggerAction waitUntilTriggerAction;
        if (triggerContextInfo == null || (waitUntilTriggerAction = this.actionWaitingForTriggerActive) == null || !waitUntilTriggerAction.getTriggersToWaitFor().contains(triggerContextInfo.getTrigger())) {
            return canInvoke(triggerContextInfo, false);
        }
        return true;
    }

    public void cancelActiveMacro(Context context) {
        this.m_cancelFlag = true;
        ContinuePausedActionsHandler.cancelAlarmsForMacro(context, this);
        for (Macro macro : MacroStore.getInstance().getActiveActionBlockInstances()) {
            if (((ActionBlock) macro).getTopLevelParentMacro() == this) {
                ContinuePausedActionsHandler.cancelAlarmsForMacro(context, macro);
            }
        }
        ShellScriptAction shellScriptAction = this.activeShellScriptAction;
        if (shellScriptAction != null) {
            shellScriptAction.cancelShellCommand();
        }
        WaitUntilTriggerAction waitUntilTriggerAction = this.actionWaitingForTriggerActive;
        if (waitUntilTriggerAction != null) {
            waitUntilTriggerAction.disableTriggers();
            this.actionWaitingForTriggerActive = null;
        }
    }

    public void clearExportedActionBlocks() {
        this.exportedActionBlocks = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Macro clone(Macro macro, boolean z3, boolean z4, boolean z5) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        if (z3) {
            str = " 2";
        } else {
            str = "";
        }
        sb.append(str);
        macro.setName(sb.toString());
        macro.setDescription(getDescription());
        macro.setConstraintIsOrCondition(isConstraintOrCondition());
        macro.setExcludeFromLog(isExcludedFromLog());
        macro.setOriginalMacroGuid(macro.getGUID());
        ArrayList<Trigger> triggerList = getTriggerList();
        for (MacroDroidVariable macroDroidVariable : getLocalVariables()) {
            macro.getLocalVariables().add(CopyHelper.copyVariable(macroDroidVariable));
        }
        for (Trigger trigger : triggerList) {
            Trigger trigger2 = (Trigger) CopyHelper.copyItem(trigger, triggerList, macro.getTriggerList());
            trigger2.setMacro(macro);
            macro.addTrigger(trigger2);
        }
        Iterator<Action> it = getActions().iterator();
        while (it.hasNext()) {
            Action action = (Action) CopyHelper.copyItem(it.next(), triggerList, macro.getTriggerList());
            action.setMacro(macro, this, z5);
            macro.addAction(action);
        }
        for (Constraint constraint : getConstraints()) {
            macro.addConstraint((Constraint) CopyHelper.copyItem(constraint, triggerList, macro.getTriggerList()));
        }
        for (Constraint constraint2 : macro.getAllConstraints()) {
            constraint2.setMacro(macro);
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (ActionBlock actionBlock : this.actionBlocksToImport) {
            ActionBlock actionBlock2 = new ActionBlock();
            actionBlock.clone(actionBlock2, false, false, z5);
            actionBlock2.setGUID(actionBlock.getGUID());
            arrayList.add(actionBlock2);
        }
        macro.setActionBlocksToImport(arrayList);
        if (z4) {
            for (ActionBlock actionBlock3 : macro.actionBlocksToImport) {
                long guid = actionBlock3.getGUID();
                actionBlock3.setGUID(UUID.randomUUID().getLeastSignificantBits());
                hashMap.put(Long.valueOf(guid), Long.valueOf(actionBlock3.getGUID()));
            }
            for (Long l4 : hashMap.keySet()) {
                Iterator<Action> it2 = macro.getActions().iterator();
                while (it2.hasNext()) {
                    Action next = it2.next();
                    if (next instanceof ActionBlockAction) {
                        ActionBlockAction actionBlockAction = (ActionBlockAction) next;
                        if (actionBlockAction.getActionBlockId() == l4.longValue()) {
                            actionBlockAction.setActionBlockId(((Long) hashMap.get(l4)).longValue());
                        }
                    }
                }
                for (ActionBlock actionBlock4 : macro.actionBlocksToImport) {
                    Iterator<Action> it3 = actionBlock4.getActions().iterator();
                    while (it3.hasNext()) {
                        Action next2 = it3.next();
                        if (next2 instanceof ActionBlockAction) {
                            ActionBlockAction actionBlockAction2 = (ActionBlockAction) next2;
                            if (actionBlockAction2.getActionBlockId() == l4.longValue()) {
                                actionBlockAction2.setActionBlockId(((Long) hashMap.get(l4)).longValue());
                            }
                        }
                    }
                }
            }
        }
        macro.setCategory(getCategory());
        macro.setIsBeingImported(getIsBeingImported());
        macro.setCompleted(true);
        if (z3) {
            SystemLog.logInfo("Add cloned macro to JSON with id: " + macro.getGUID(), getGUID());
            MacroStore.getInstance().addClonedMacroToJSON(macro);
            macro.setTemplateSelected();
            macro.setEnabled(isEnabled());
        }
        return macro;
    }

    public Macro cloneMacro(boolean z3, boolean z4) {
        return clone(new Macro(), z3, z4, false);
    }

    public void configureForExport() {
        Iterator<Trigger> it = getTriggerList().iterator();
        while (it.hasNext()) {
            it.next().configureForExport();
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            it2.next().configureForExport();
        }
        for (Constraint constraint : this.m_constraintList) {
            constraint.configureForExport();
        }
    }

    public Macro createExactClone() {
        Parcel obtain = Parcel.obtain();
        obtain.writeParcelable(this, 0);
        obtain.setDataPosition(0);
        Macro macro = (Macro) obtain.readParcelable(getClass().getClassLoader());
        obtain.recycle();
        return macro;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void enableOrDisableItem(SelectableItem selectableItem, boolean z3) {
        if (selectableItem instanceof ParentAction) {
            int parentEndIndex = MacroListUtils.getParentEndIndex(getActions(), getActions().indexOf(selectableItem));
            if (parentEndIndex > 0) {
                getActions().get(parentEndIndex).setEnabled(z3);
            }
            selectableItem.setEnabled(z3);
            return;
        }
        selectableItem.setEnabled(z3);
    }

    public void enableOrDisableItemAndChildren(Action action, boolean z3) {
        int i4;
        ArrayList<Action> actions = getActions();
        int indexOf = getActions().indexOf(action);
        if (action instanceof ElseIfConditionAction) {
            i4 = MacroListUtils.getNextElseOrElseIforEndParentIndex(actions, indexOf) - 1;
        } else {
            int parentEndIndex = MacroListUtils.getParentEndIndex(actions, indexOf);
            if (action instanceof ElseAction) {
                i4 = parentEndIndex - 1;
            } else {
                i4 = parentEndIndex;
            }
        }
        while (indexOf <= i4) {
            actions.get(indexOf).setEnabled(z3);
            indexOf++;
        }
    }

    @Nullable
    public SelectableItem findChildByGUID(long j4) {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            SelectableItem findSelectableItemFromChildren = findSelectableItemFromChildren(it.next(), j4);
            if (findSelectableItemFromChildren != null) {
                return findSelectableItemFromChildren;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            SelectableItem findSelectableItemFromChildren2 = findSelectableItemFromChildren(it2.next(), j4);
            if (findSelectableItemFromChildren2 != null) {
                return findSelectableItemFromChildren2;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            SelectableItem findSelectableItemFromChildren3 = findSelectableItemFromChildren(constraint, j4);
            if (findSelectableItemFromChildren3 != null) {
                return findSelectableItemFromChildren3;
            }
        }
        Action action = this.m_actionBeingConfigured;
        if (action != null) {
            if (action.getSIGUID() == j4) {
                return this.m_actionBeingConfigured;
            }
            if (this.m_actionBeingConfigured.getConstraints() != null) {
                return findChildByGUID(j4, this.m_actionBeingConfigured.getConstraints());
            }
            return null;
        }
        return null;
    }

    @Nullable
    public MacroDroidVariable findLocalVariableByName(String str) {
        Iterator<MacroDroidVariable> it = this.localVariables.iterator();
        while (it.hasNext()) {
            MacroDroidVariable next = it.next();
            if (next.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Action getActionBeingConfigured() {
        return this.m_actionBeingConfigured;
    }

    public List<MacroDroidVariable> getActionBlockWorkingVariables(boolean z3) {
        ArrayList arrayList = new ArrayList();
        Iterator<MacroDroidVariable> it = this.localVariables.iterator();
        while (it.hasNext()) {
            MacroDroidVariable next = it.next();
            if (next.isActionBlockWorkingVar()) {
                arrayList.add(next);
            }
        }
        if (z3) {
            return sortVariables(arrayList);
        }
        return arrayList;
    }

    public List<ActionBlock> getActionBlocksToImport() {
        return this.actionBlocksToImport;
    }

    @Nullable
    public Action getActionByGuid(long j4) {
        Iterator<Action> it = getActions().iterator();
        while (it.hasNext()) {
            Action next = it.next();
            if (next.getSIGUID() == j4) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<Action> getActions() {
        return this.m_actionList;
    }

    public List<Constraint> getAllConstraints() {
        ArrayList arrayList = new ArrayList();
        Iterator<Trigger> it = getTriggerList().iterator();
        while (it.hasNext()) {
            for (Constraint constraint : it.next().getConstraints()) {
                addConstraintsToList(arrayList, constraint);
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            for (Constraint constraint2 : it2.next().getConstraints()) {
                addConstraintsToList(arrayList, constraint2);
            }
        }
        for (Constraint constraint3 : this.m_constraintList) {
            addConstraintsToList(arrayList, constraint3);
        }
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllNumericalVariables() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        for (MacroDroidVariable macroDroidVariable : getLocalVariablesSorted()) {
            if (macroDroidVariable.isInt() || macroDroidVariable.isDecimal()) {
                arrayList.add(macroDroidVariable);
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllNumericalVariables());
        return arrayList;
    }

    public ArrayList<MacroDroidVariable> getAllNumericalVariablesIncludingWithChildren() {
        ArrayList<MacroDroidVariable> arrayList = new ArrayList<>();
        for (MacroDroidVariable macroDroidVariable : getLocalVariablesSorted()) {
            if (macroDroidVariable.isInt() || macroDroidVariable.isDecimal()) {
                arrayList.add(macroDroidVariable);
            }
            if (macroDroidVariable.getHasNumericalChildren()) {
                arrayList.add(macroDroidVariable);
            }
        }
        arrayList.addAll(MacroDroidVariableStore.getInstance().getAllNumericalVariablesWithChildren());
        return arrayList;
    }

    public String getCategory() {
        if (this.m_category == null) {
            this.m_category = MacroDroidApplication.getInstance().getString(R.string.uncategorized);
        }
        return this.m_category;
    }

    public List<Constraint> getConstraints() {
        return this.m_constraintList;
    }

    public String getDescription() {
        return this.m_description;
    }

    public List<Constraint> getEnabledConstraints() {
        ArrayList arrayList = new ArrayList();
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.isEnabled()) {
                arrayList.add(constraint);
            }
        }
        return arrayList;
    }

    public boolean getEnabledStateDuringLoad() {
        return this.enabledStateDuringLoad;
    }

    public List<ActionBlock> getExportedActionBlocks() {
        return this.exportedActionBlocks;
    }

    public long getGUID() {
        return this.m_GUID;
    }

    @ColorInt
    public int getHeadingColor() {
        return this.m_headingColor;
    }

    public int getId() {
        return this.m_uniqueId;
    }

    public List<MacroDroidVariable> getInputOnlyActionBlockVariables(boolean z3) {
        ArrayList arrayList = new ArrayList();
        Iterator<MacroDroidVariable> it = this.localVariables.iterator();
        while (it.hasNext()) {
            MacroDroidVariable next = it.next();
            if (!next.isActionBlockWorkingVar() && next.getSupportsInput()) {
                arrayList.add(next);
            }
        }
        if (z3) {
            return sortVariables(arrayList);
        }
        return arrayList;
    }

    public boolean getIsBeingImported() {
        return this.isBeingImported;
    }

    public boolean getIsFavourite() {
        return this.isFavourite;
    }

    public long getLastEditedTimestamp() {
        return this.lastEditedTimestamp;
    }

    @Nullable
    public MacroDroidVariable getLocalVariableByName(String str) {
        for (MacroDroidVariable macroDroidVariable : getLocalVariables()) {
            if (macroDroidVariable.getName().equals(str)) {
                return macroDroidVariable;
            }
        }
        return null;
    }

    public Set<VariableUpdatedListener> getLocalVariableUpdatedListeners() {
        return this.localVariableUpdatedListeners;
    }

    public List<MacroDroidVariable> getLocalVariables() {
        return this.localVariables;
    }

    public List<MacroDroidVariable> getLocalVariablesForDirection(boolean z3) {
        ArrayList arrayList = new ArrayList();
        Iterator<MacroDroidVariable> it = this.localVariables.iterator();
        while (it.hasNext()) {
            MacroDroidVariable next = it.next();
            if ((z3 && next.getSupportsInput() && !next.isActionBlockWorkingVar()) || (!z3 && next.getSupportsOutput())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<MacroDroidVariable> getLocalVariablesSorted() {
        ArrayList arrayList = new ArrayList(this.localVariables);
        final Locale locale = Settings.getLocale(MacroDroidApplication.getInstance());
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.macro.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$getLocalVariablesSorted$2;
                lambda$getLocalVariablesSorted$2 = Macro.lambda$getLocalVariablesSorted$2(locale, (MacroDroidVariable) obj, (MacroDroidVariable) obj2);
                return lambda$getLocalVariablesSorted$2;
            }
        });
        return arrayList;
    }

    public List<MacroDroidVariable> getLocalVariablesSortedForDirection(boolean z3) {
        return sortVariables(getLocalVariablesForDirection(z3));
    }

    public int getMinSdk() {
        Iterator<Trigger> it = getTriggerList().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Trigger next = it.next();
            if (next.getInfo().minSDKVersion() > i4) {
                i4 = next.getInfo().minSDKVersion();
            }
            for (Constraint constraint : next.getConstraints()) {
                if (constraint.getInfo().minSDKVersion() > i4) {
                    i4 = constraint.getInfo().minSDKVersion();
                }
            }
        }
        Iterator<Action> it2 = getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            if (next2.getInfo().minSDKVersion() > i4) {
                i4 = next2.getInfo().minSDKVersion();
            }
            for (Constraint constraint2 : next2.getConstraints()) {
                if (constraint2.getInfo().minSDKVersion() > i4) {
                    i4 = constraint2.getInfo().minSDKVersion();
                }
            }
        }
        for (Constraint constraint3 : getConstraints()) {
            if (constraint3.getInfo().minSDKVersion() > i4) {
                i4 = constraint3.getInfo().minSDKVersion();
            }
        }
        return i4;
    }

    public String getName() {
        return this.m_name;
    }

    public long getOriginalMacroGuid() {
        long j4 = this.originalMacroGuid;
        if (j4 >= 0) {
            return j4;
        }
        return getGUID();
    }

    public List<MacroDroidVariable> getOutputOnlyActionBlockVariables(boolean z3) {
        ArrayList arrayList = new ArrayList();
        Iterator<MacroDroidVariable> it = this.localVariables.iterator();
        while (it.hasNext()) {
            MacroDroidVariable next = it.next();
            if (!next.isActionBlockWorkingVar() && next.getSupportsOutput()) {
                arrayList.add(next);
            }
        }
        if (z3) {
            return sortVariables(arrayList);
        }
        return arrayList;
    }

    @Nullable
    public ParentAction getParentAction(Action action) {
        int i4 = 0;
        for (int indexOf = getActions().indexOf(action); indexOf >= 0; indexOf--) {
            Action action2 = getActions().get(indexOf);
            if (action2 instanceof EndParentAction) {
                i4--;
            } else if ((action2 instanceof ParentAction) && (i4 = i4 + 1) == 1) {
                return (ParentAction) action2;
            }
        }
        return null;
    }

    public String[] getRequiredPermissions() {
        String[] requiredPermissions;
        String[] requiredPermissions2;
        String[] requiredPermissions3;
        ArrayList arrayList = new ArrayList();
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Trigger next = it.next();
            if (next.isEnabled()) {
                for (String str : next.getRequiredPermissions()) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            if (next2.isEnabled()) {
                for (String str2 : next2.getRequiredPermissions()) {
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.isEnabled()) {
                for (String str3 : constraint.getRequiredPermissions()) {
                    if (!arrayList.contains(str3)) {
                        arrayList.add(str3);
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String[] getRequiredPermissionsOnImport() {
        String[] permissionsOnImport;
        String[] permissionsOnImport2;
        String[] permissionsOnImport3;
        ArrayList arrayList = new ArrayList();
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            for (String str : it.next().getPermissionsOnImport()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            for (String str2 : it2.next().getPermissionsOnImport()) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            for (String str3 : constraint.getPermissionsOnImport()) {
                if (!arrayList.contains(str3)) {
                    arrayList.add(str3);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public int getRootVersion() {
        Iterator<Trigger> it = getTriggerList().iterator();
        int i4 = 9999;
        while (it.hasNext()) {
            i4 = Math.min(i4, it.next().getInfo().getRootLevel());
        }
        Iterator<Action> it2 = getActions().iterator();
        while (it2.hasNext()) {
            i4 = Math.min(i4, it2.next().getInfo().getRootLevel());
        }
        for (Constraint constraint : getConstraints()) {
            i4 = Math.min(i4, constraint.getInfo().getRootLevel());
        }
        return i4;
    }

    public Object getTag() {
        return this.m_tag;
    }

    public TriggerContextInfo getTriggerContextInfo() {
        return this.triggerContextInfo;
    }

    public ArrayList<Trigger> getTriggerList() {
        return getTriggerList(false);
    }

    public ArrayList<Trigger> getTriggerListWithAwaitingActions() {
        ArrayList<Trigger> triggerList = getTriggerList(true);
        ArrayList<Trigger> arrayList = new ArrayList<>();
        Iterator<Trigger> it = triggerList.iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            if (next.isEnabled()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Trigger getTriggerThatInvoked() {
        return this.triggerThatInvoked;
    }

    public List<UserIconData> getUserIconData() {
        List<String> imagePaths;
        List<String> imagePaths2;
        List<String> imagePaths3;
        ArrayList arrayList = new ArrayList();
        HashSet<String> hashSet = new HashSet();
        Iterator<Trigger> it = getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            if ((next instanceof SupportsUserImages) && (imagePaths3 = ((SupportsUserImages) next).getImagePaths()) != null) {
                hashSet.addAll(imagePaths3);
            }
        }
        Iterator<Action> it2 = getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            if ((next2 instanceof SupportsUserImages) && (imagePaths2 = ((SupportsUserImages) next2).getImagePaths()) != null) {
                hashSet.addAll(imagePaths2);
            }
        }
        for (Constraint constraint : getAllConstraints()) {
            if ((constraint instanceof SupportsUserImages) && (imagePaths = ((SupportsUserImages) constraint).getImagePaths()) != null) {
                hashSet.addAll(imagePaths);
            }
        }
        for (String str : hashSet) {
            File file = new File(str);
            if (file.exists()) {
                UserIconData userIconData = new UserIconData();
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (decodeFile != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    userIconData.fileName = file.getName();
                    userIconData.data = Base64.encodeToString(byteArray, 0);
                    arrayList.add(userIconData);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public MacroDroidVariable getVariableByName(String str) {
        MacroDroidVariable localVariableByName = getLocalVariableByName(str);
        if (localVariableByName == null) {
            return MacroDroidVariableStore.getInstance().getVariableByName(str);
        }
        return localVariableByName;
    }

    public WaitUntilTriggerAction getWaitForTriggerActive() {
        return this.actionWaitingForTriggerActive;
    }

    public boolean hasOnlyTrigger(Class cls) {
        ArrayList<Trigger> triggerList = getTriggerList();
        if (triggerList.size() == 0) {
            return false;
        }
        for (Trigger trigger : triggerList) {
            if (!cls.isInstance(trigger)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasUserIconData() {
        List<String> imagePaths;
        List<String> imagePaths2;
        List<String> imagePaths3;
        Iterator<Trigger> it = getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            if ((next instanceof SupportsUserImages) && (imagePaths3 = ((SupportsUserImages) next).getImagePaths()) != null && imagePaths3.size() > 0) {
                return true;
            }
        }
        Iterator<Action> it2 = getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            if ((next2 instanceof SupportsUserImages) && (imagePaths2 = ((SupportsUserImages) next2).getImagePaths()) != null && imagePaths2.size() > 0) {
                return true;
            }
        }
        for (Constraint constraint : getAllConstraints()) {
            if ((constraint instanceof SupportsUserImages) && (imagePaths = ((SupportsUserImages) constraint).getImagePaths()) != null && imagePaths.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public void initialiseExportedActionBlocks(ActionBlockStore actionBlockStore) {
        ArrayList<ActionBlock> arrayList = new ArrayList<>();
        Iterator<Action> it = getActions().iterator();
        while (it.hasNext()) {
            addActionBlocksToList(actionBlockStore, arrayList, it.next());
        }
        this.exportedActionBlocks = arrayList;
    }

    public void invokeActions(TriggerContextInfo triggerContextInfo) {
        invokeActionsInternal(triggerContextInfo, false, null);
    }

    public void invokeActionsDontResetCount(TriggerContextInfo triggerContextInfo, boolean z3) {
        if (z3) {
            this.forceEvenIfNotEnabledTimestamp = System.currentTimeMillis();
        } else {
            this.forceEvenIfNotEnabledTimestamp = 0L;
        }
        invokeActionsInternal(triggerContextInfo, z3, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeActionsInternal(TriggerContextInfo triggerContextInfo, boolean z3, @Nullable ResumeMacroInfo resumeMacroInfo) {
        if (z3) {
            this.forceEvenIfNotEnabledTimestamp = System.currentTimeMillis();
        } else {
            this.forceEvenIfNotEnabledTimestamp = 0L;
        }
        invokeActionsInternal(triggerContextInfo, z3, resumeMacroInfo, true);
    }

    public void invokeActionsPreventInfiniteLoop(TriggerContextInfo triggerContextInfo) {
        invokeActionsInternal(triggerContextInfo, false, null);
    }

    public boolean isCancelled() {
        return this.m_cancelFlag;
    }

    public boolean isClonedInstance() {
        return this.isClonedInstance;
    }

    public boolean isCompleted() {
        return this.m_completed;
    }

    public boolean isConfiguringShortcut() {
        return this.m_configuringShortcut;
    }

    public boolean isConstraintOrCondition() {
        return this.m_isOrCondition;
    }

    public boolean isDescriptionOpen() {
        return this.m_descriptionOpen;
    }

    public boolean isEnabled() {
        if (!this.m_enabled && !this.isActionBlock) {
            return false;
        }
        return true;
    }

    public boolean isExcludedFromLog() {
        return this.m_excludeLog;
    }

    public boolean isExtra() {
        return this.isExtra;
    }

    public boolean isRootOnlyWithNoAdbHack() {
        Iterator<Trigger> it = getTriggerList().iterator();
        while (it.hasNext()) {
            if (it.next().isRootOnlyWithNoAdbHack()) {
                return true;
            }
        }
        Iterator<Action> it2 = getActions().iterator();
        while (it2.hasNext()) {
            if (it2.next().isRootOnlyWithNoAdbHack()) {
                return true;
            }
        }
        for (Constraint constraint : getConstraints()) {
            if (constraint.isRootOnlyWithNoAdbHack()) {
                return true;
            }
        }
        return false;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public boolean isValid() {
        if (this.m_actionList.size() < 1 || getTriggerList().size() < 1) {
            return false;
        }
        Iterator<Trigger> it = getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            if (next.isEnabled() && !next.isValid()) {
                return false;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            if (next2.isEnabled() && !next2.isValid()) {
                return false;
            }
        }
        for (Constraint constraint : getAllConstraints()) {
            if (constraint.isEnabled() && !constraint.isValid()) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidForRun() {
        if (this.m_actionList.size() < 1) {
            return false;
        }
        if (getTriggerList().size() < 1 && !this.isActionBlock) {
            SystemLog.logWarning("Not valid for running. Trigger list is empty", getGUID());
            return false;
        }
        Iterator<Trigger> it = getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            if (next.isEnabled() && !next.isValid() && !next.canRunWhenInvalid()) {
                SystemLog.logWarning("Invalid trigger: " + next.getConfiguredName(), getGUID());
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            if (next2.isEnabled() && !next2.isValid() && !next2.canRunWhenInvalid()) {
                SystemLog.logWarning("Invalid action within macro: " + next2.getConfiguredName(), getGUID());
            }
        }
        for (Constraint constraint : getAllConstraints()) {
            if (constraint.isEnabled() && !constraint.isValid() && !constraint.canRunWhenInvalid()) {
                SystemLog.logWarning("Invalid constraint within macro: " + constraint.getConfiguredName(), getGUID());
            }
        }
        return true;
    }

    public void notifyVariableListenersOnCorrectThread(final MacroDroidVariable macroDroidVariable, final VariableValue variableValue, final VariableValue variableValue2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            lambda$notifyVariableListenersOnCorrectThread$4(macroDroidVariable, variableValue, variableValue2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.macro.e
                @Override // java.lang.Runnable
                public final void run() {
                    Macro.this.lambda$notifyVariableListenersOnCorrectThread$4(macroDroidVariable, variableValue, variableValue2);
                }
            });
        }
    }

    public void onEditScreenClosed() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            it.next().onEditScreenClosed();
        }
    }

    public void persistMacro() {
        MacroStore.getInstance().updateMacro(this);
    }

    public void removeAction(Action action) {
        this.m_actionList.remove(action);
        action.disableActionThreadSafe();
    }

    public void removeConstraint(Constraint constraint) {
        constraint.disableConstraintCheckingThreadSafe();
        this.m_constraintList.remove(constraint);
    }

    public List<RemovedItem> removeItem(SelectableItem selectableItem) {
        ArrayList arrayList = new ArrayList();
        if (selectableItem instanceof Trigger) {
            arrayList.add(new RemovedItem.StandardItem(getTriggerList().indexOf(selectableItem), selectableItem));
            removeTrigger((Trigger) selectableItem);
        } else if (selectableItem instanceof Action) {
            if (selectableItem instanceof LoopAction) {
                int endLoopIndex = MacroListUtils.getEndLoopIndex(getActions(), getActions().indexOf(selectableItem));
                if (endLoopIndex >= 0) {
                    Action action = getActions().get(endLoopIndex);
                    removeAction(action);
                    arrayList.add(new RemovedItem.StandardItem(endLoopIndex, action));
                }
            } else if ((selectableItem instanceof IfConditionAction) || (selectableItem instanceof IfConfirmedThenAction)) {
                ArrayList<Action> actions = getActions();
                int indexOf = actions.indexOf(selectableItem);
                int endIfIndex = MacroListUtils.getEndIfIndex(actions, indexOf);
                ArrayList<Integer> arrayList2 = new ArrayList();
                int i4 = indexOf;
                do {
                    i4 = MacroListUtils.getNextElseIfIndex(actions, i4);
                    if (i4 >= 0) {
                        arrayList2.add(0, Integer.valueOf(i4));
                        continue;
                    }
                } while (i4 >= 0);
                int elseIndex = MacroListUtils.getElseIndex(actions, indexOf);
                if (endIfIndex >= 0) {
                    Action action2 = getActions().get(endIfIndex);
                    removeAction(action2);
                    arrayList.add(new RemovedItem.StandardItem(endIfIndex, action2));
                }
                if (elseIndex >= 0 && elseIndex < endIfIndex) {
                    Action action3 = getActions().get(elseIndex);
                    removeAction(action3);
                    arrayList.add(new RemovedItem.StandardItem(elseIndex, action3));
                }
                for (Integer num : arrayList2) {
                    int intValue = num.intValue();
                    if (intValue >= 0 && intValue < endIfIndex) {
                        Action action4 = getActions().get(intValue);
                        removeAction(action4);
                        arrayList.add(new RemovedItem.StandardItem(intValue, action4));
                    }
                }
            }
            arrayList.add(new RemovedItem.StandardItem(getActions().indexOf(selectableItem), selectableItem));
            removeAction((Action) selectableItem);
        } else {
            findChildByGUID(selectableItem.getSIGUID());
            Iterator<Action> it = getActions().iterator();
            RemovedItem.ChildConstraint childConstraint = null;
            while (it.hasNext() && (childConstraint = deleteChildConstraint(it.next(), selectableItem)) == null) {
            }
            if (childConstraint == null) {
                Iterator<Trigger> it2 = getTriggerList().iterator();
                while (it2.hasNext() && (childConstraint = deleteChildConstraint(it2.next(), selectableItem)) == null) {
                }
            }
            if (childConstraint == null) {
                Iterator<Constraint> it3 = getConstraints().iterator();
                while (it3.hasNext() && (childConstraint = deleteChildConstraint(it3.next(), selectableItem)) == null) {
                }
                if (childConstraint == null) {
                    arrayList.add(new RemovedItem.StandardItem(getConstraints().indexOf(selectableItem), selectableItem));
                    removeConstraint((Constraint) selectableItem);
                }
            }
            if (childConstraint != null) {
                arrayList.add(childConstraint);
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.macro.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$removeItem$1;
                lambda$removeItem$1 = Macro.lambda$removeItem$1((RemovedItem) obj, (RemovedItem) obj2);
                return lambda$removeItem$1;
            }
        });
        return arrayList;
    }

    public List<RemovedItem> removeItemAndChildren(ParentAction parentAction) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Action> actions = getActions();
        int indexOf = getActions().indexOf(parentAction);
        for (int parentEndIndex = MacroListUtils.getParentEndIndex(actions, indexOf); parentEndIndex >= indexOf; parentEndIndex--) {
            arrayList.add(new RemovedItem.StandardItem(parentEndIndex, actions.get(parentEndIndex)));
            actions.remove(parentEndIndex);
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.macro.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$removeItemAndChildren$0;
                lambda$removeItemAndChildren$0 = Macro.lambda$removeItemAndChildren$0((RemovedItem) obj, (RemovedItem) obj2);
                return lambda$removeItemAndChildren$0;
            }
        });
        return arrayList;
    }

    public void removeLocalVariableUpdatedListener(VariableUpdatedListener variableUpdatedListener) {
        synchronized (this.localVariableUpdatedListeners) {
            this.localVariableUpdatedListeners.remove(variableUpdatedListener);
        }
    }

    public void removeTrigger(Trigger trigger) {
        this.m_triggerList.remove(trigger);
        trigger.disableTriggerThreadSafe();
    }

    public void renameLocalVariable(MacroDroidVariable macroDroidVariable, String str) {
        macroDroidVariable.setName(str);
        persistMacro();
    }

    public boolean requiresAccessibity() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresAccessibility()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresAccessibility()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresAccessibility()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresCanDrawOverlays() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresCanDrawOverlays()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresCanDrawOverlays()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresCanDrawOverlays()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresDefaultAssist() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresDefaultAssist()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresDefaultAssist()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresDefaultAssist()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresDeviceAdmin() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresDeviceAdmin()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresDeviceAdmin()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresDeviceAdmin()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresFingerprintAccessibility() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresFingerprintGestureAccessibility()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresFingerprintGestureAccessibility()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresFingerprintGestureAccessibility()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresLocationServicesEnabled() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresLocationServicesEnabled()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresLocationServicesEnabled()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresLocationServicesEnabled()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresNewHelperFileVersion() {
        int macroDroidHelperVersionCode = ApplicationChecker.getMacroDroidHelperVersionCode();
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresNewHelperFile(macroDroidHelperVersionCode)) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresNewHelperFile(macroDroidHelperVersionCode)) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresNewHelperFile(macroDroidHelperVersionCode)) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresNotificationAccess() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresNotificationAccess()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresNotificationAccess()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresNotificationAccess()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresUiInteractionAccessibility() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresUIInteractionAccessibility()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresUIInteractionAccessibility()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresUIInteractionAccessibility()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresUsageAccess() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresUsageAccess()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresUsageAccess()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresUsageAccess()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresVolumeAccessibility() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresVolumeButtonAccessibility()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresVolumeButtonAccessibility()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresVolumeButtonAccessibility()) {
                return true;
            }
        }
        return false;
    }

    public boolean requiresWriteSettings() {
        Iterator<Trigger> it = this.m_triggerList.iterator();
        while (it.hasNext()) {
            if (it.next().requiresWriteSettings()) {
                return true;
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            if (it2.next().requiresWriteSettings()) {
                return true;
            }
        }
        for (Constraint constraint : this.m_constraintList) {
            if (constraint.requiresWriteSettings()) {
                return true;
            }
        }
        return false;
    }

    public void restoreItems(List<RemovedItem> list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            RemovedItem removedItem = list.get(i4);
            if (removedItem.getItem() instanceof Trigger) {
                this.m_triggerList.add(removedItem.getIndex(), (Trigger) removedItem.getItem());
            } else if (removedItem.getItem() instanceof Action) {
                int index = removedItem.getIndex();
                if (index > this.m_actionList.size()) {
                    index = this.m_actionList.size();
                }
                this.m_actionList.add(index, (Action) removedItem.getItem());
            } else if (removedItem.getItem() instanceof Constraint) {
                if (removedItem instanceof RemovedItem.ChildConstraint) {
                    SelectableItem findChildByGUID = findChildByGUID(((RemovedItem.ChildConstraint) removedItem).getParent().getSIGUID());
                    if (findChildByGUID != null) {
                        findChildByGUID.getConstraints().add(removedItem.getIndex(), (Constraint) removedItem.getItem());
                    }
                } else {
                    this.m_constraintList.add(removedItem.getIndex(), (Constraint) removedItem.getItem());
                }
            }
        }
    }

    public void setActionBeingConfigured(Action action) {
        this.m_actionBeingConfigured = action;
    }

    public void setActionBlocksToImport(List<ActionBlock> list) {
        this.actionBlocksToImport = list;
    }

    public void setActions(ArrayList<Action> arrayList) {
        this.m_actionList = arrayList;
    }

    public void setCategory(String str) {
        this.m_category = str;
    }

    public void setCompleted(boolean z3) {
        this.m_completed = z3;
    }

    public void setConfiguringShortcut(boolean z3) {
        this.m_configuringShortcut = z3;
    }

    public void setConstraintIsOrCondition(boolean z3) {
        this.m_isOrCondition = z3;
    }

    public void setConstraints(List<Constraint> list) {
        this.m_constraintList = list;
    }

    public void setDescription(String str) {
        this.m_description = str;
    }

    public void setDescriptionOpen(boolean z3) {
        this.m_descriptionOpen = z3;
    }

    public void setEnabled(boolean z3) {
        setEnabled(z3, true);
    }

    public void setEnabledFlag(boolean z3) {
        this.m_enabled = z3;
    }

    public void setEnabledStateDuringLoad(boolean z3) {
        this.enabledStateDuringLoad = z3;
    }

    public void setExcludeFromLog(boolean z3) {
        this.m_excludeLog = z3;
    }

    public void setExportedActionBlocks(List<ActionBlock> list) {
        this.exportedActionBlocks = list;
    }

    public void setGUID(long j4) {
        this.m_GUID = j4;
    }

    public void setHeadingColor(@ColorInt int i4) {
        this.m_headingColor = i4;
    }

    public void setId(int i4) {
        this.m_uniqueId = i4;
    }

    public void setIsBeingImported(boolean z3) {
        this.isBeingImported = z3;
    }

    public void setIsClonedInstance(boolean z3) {
        this.isClonedInstance = z3;
    }

    public void setIsExtra(boolean z3) {
        this.isExtra = z3;
    }

    public void setIsFavourite(boolean z3) {
        this.isFavourite = z3;
    }

    public void setIsRunning(boolean z3) {
        this.isRunning = z3;
    }

    public void setLastEditedTimestamp(long j4) {
        this.lastEditedTimestamp = j4;
    }

    public void setName(String str) {
        this.m_name = str;
    }

    public void setNewRandomGUID() {
        long j4 = this.m_GUID;
        this.m_GUID = UUID.randomUUID().getLeastSignificantBits();
        Iterator<Trigger> it = getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            updateGUIDRefsIfRequired(j4, this.m_GUID, next);
            for (Constraint constraint : next.getConstraints()) {
                updateGUIDRefsIfRequired(j4, this.m_GUID, constraint);
                constraint.disableConstraintCheckingThreadSafe();
            }
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            updateGUIDRefsIfRequired(j4, this.m_GUID, next2);
            next2.disableActionThreadSafe();
            for (Constraint constraint2 : next2.getConstraints()) {
                updateGUIDRefsIfRequired(j4, this.m_GUID, constraint2);
                constraint2.disableConstraintCheckingThreadSafe();
            }
        }
        for (Constraint constraint3 : this.m_constraintList) {
            updateGUIDRefsIfRequired(j4, this.m_GUID, constraint3);
            constraint3.disableConstraintCheckingThreadSafe();
        }
    }

    public void setOriginalTriggerContextInfo(@Nullable TriggerContextInfo triggerContextInfo) {
        this.originalTriggerContextInfo = triggerContextInfo;
    }

    public void setTag(Object obj) {
        this.m_tag = obj;
    }

    public void setTemplateSelected() {
        Iterator<Trigger> it = getTriggerList().iterator();
        while (it.hasNext()) {
            it.next().templateSelected();
        }
        Iterator<Action> it2 = this.m_actionList.iterator();
        while (it2.hasNext()) {
            it2.next().templateSelected();
        }
        for (Constraint constraint : getAllConstraints()) {
            constraint.templateSelected();
        }
    }

    public void setTrigger(Trigger trigger) {
        this.m_trigger = trigger;
    }

    public void setTriggerContextInfo(TriggerContextInfo triggerContextInfo) {
        this.triggerContextInfo = triggerContextInfo;
    }

    public void setTriggerList(ArrayList<Trigger> arrayList) {
        this.m_triggerList = arrayList;
    }

    public void setTriggerThatInvoked(Trigger trigger) {
        this.triggerThatInvoked = trigger;
        if (trigger != null) {
            setTriggerContextInfo(new TriggerContextInfo(this.triggerThatInvoked));
        } else {
            setTriggerContextInfo(null);
        }
    }

    public void setWaitForTriggerActive(WaitUntilTriggerAction waitUntilTriggerAction) {
        this.actionWaitingForTriggerActive = waitUntilTriggerAction;
    }

    public List<MacroDroidVariable> sortVariables(List<MacroDroidVariable> list) {
        final Locale locale = Settings.getLocale(MacroDroidApplication.getInstance());
        Collections.sort(list, new Comparator() { // from class: com.arlosoft.macrodroid.macro.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$sortVariables$3;
                lambda$sortVariables$3 = Macro.lambda$sortVariables$3(locale, (MacroDroidVariable) obj, (MacroDroidVariable) obj2);
                return lambda$sortVariables$3;
            }
        });
        return list;
    }

    public void startMacro() {
        if (!this.isRunning) {
            this.isRunning = true;
        }
    }

    public void terminateMacro() {
        if (this.isRunning) {
            this.isRunning = false;
            ArrayList arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof MacroFinishedTrigger) && ((MacroFinishedTrigger) next).getSelectedMacroGuid() == getGUID() && next.constraintsMet()) {
                            macro.setTriggerThatInvoked(next);
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                            }
                        }
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Macro macro2 = (Macro) it2.next();
                macro2.invokeActions(macro2.getTriggerContextInfo());
            }
        }
    }

    public String toString() {
        return this.m_name + ":" + this.m_description;
    }

    public void updateEnabledStateBasedOnGlobalState(Set<String> set) {
        if (sMacroDroidEnabled && isEnabled() && !set.contains(getCategory())) {
            for (Constraint constraint : this.m_constraintList) {
                if (constraint.isEnabled()) {
                    constraint.enableConstraintCheckingThreadSafe();
                }
            }
            Iterator<Action> it = this.m_actionList.iterator();
            while (it.hasNext()) {
                Action next = it.next();
                for (Constraint constraint2 : next.getConstraints()) {
                    if (constraint2.isEnabled()) {
                        constraint2.enableConstraintCheckingThreadSafe();
                    }
                }
                next.enableActionThreadSafe();
            }
            Iterator<Trigger> it2 = getTriggerList().iterator();
            while (it2.hasNext()) {
                Trigger next2 = it2.next();
                for (Constraint constraint3 : next2.getConstraints()) {
                    if (constraint3.isEnabled()) {
                        constraint3.enableConstraintCheckingThreadSafe();
                    }
                }
                next2.checkPermissionsAndEnableTrigger();
            }
            return;
        }
        Iterator<Trigger> it3 = getTriggerList().iterator();
        while (it3.hasNext()) {
            Trigger next3 = it3.next();
            next3.disableTriggerThreadSafe();
            for (Constraint constraint4 : next3.getConstraints()) {
                constraint4.disableConstraintCheckingThreadSafe();
            }
        }
        Iterator<Action> it4 = this.m_actionList.iterator();
        while (it4.hasNext()) {
            Action next4 = it4.next();
            next4.disableActionThreadSafe();
            for (Constraint constraint5 : next4.getConstraints()) {
                constraint5.disableConstraintCheckingThreadSafe();
            }
        }
        for (Constraint constraint6 : this.m_constraintList) {
            constraint6.disableConstraintCheckingThreadSafe();
        }
    }

    public synchronized void variableUpdate(MacroDroidVariable macroDroidVariable, VariableValue variableValue) {
        VariableValue variableValueNoMagicText;
        MacroDroidVariable findLocalVariableByName = findLocalVariableByName(macroDroidVariable.getName());
        boolean z3 = false;
        if (findLocalVariableByName != null) {
            VariableValue.DictionaryEntry targetDictionaryEntry = findLocalVariableByName.getTargetDictionaryEntry(variableValue.getParentKeys(), true);
            if (targetDictionaryEntry != null) {
                variableValueNoMagicText = targetDictionaryEntry.getVariable();
            } else {
                variableValueNoMagicText = findLocalVariableByName.getVariableValueNoMagicText();
            }
            if (variableValueNoMagicText.equals(variableValue)) {
                return;
            }
            if (!this.m_excludeLog) {
                z3 = true;
            }
            findLocalVariableByName.setVariableValue(variableValue, z3, variableValueNoMagicText, this);
            MacroStore.getInstance().persistMacro(this);
            notifyVariableListenersOnCorrectThread(findLocalVariableByName, variableValue, variableValueNoMagicText);
        } else {
            MacroDroidVariableStore macroDroidVariableStore = MacroDroidVariableStore.getInstance();
            if (!this.m_excludeLog) {
                z3 = true;
            }
            macroDroidVariableStore.variableUpdate(macroDroidVariable, variableValue, z3, this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.m_trigger, i4);
        parcel.writeList(this.m_triggerList);
        parcel.writeList(this.m_actionList);
        parcel.writeList(this.m_constraintList);
        parcel.writeList(this.localVariables);
        parcel.writeString(this.m_name);
        parcel.writeInt(this.m_enabled ? 1 : 0);
        parcel.writeInt(this.m_isOrCondition ? 1 : 0);
        parcel.writeInt(this.m_configuringShortcut ? 1 : 0);
        parcel.writeInt(this.m_uniqueId);
        parcel.writeString(this.m_category);
        if (this.m_GUID == 0) {
            this.m_GUID = UUID.randomUUID().getLeastSignificantBits();
        }
        parcel.writeLong(this.m_GUID);
        parcel.writeString(this.m_description);
        parcel.writeInt(this.m_descriptionOpen ? 1 : 0);
        parcel.writeInt(this.m_excludeLog ? 1 : 0);
        parcel.writeInt(this.m_headingColor);
        parcel.writeInt(this.isActionBlock ? 1 : 0);
        parcel.writeInt(this.isBeingImported ? 1 : 0);
        parcel.writeInt(this.isClonedInstance ? 1 : 0);
        parcel.writeInt(this.isFavourite ? 1 : 0);
        parcel.writeLong(this.lastEditedTimestamp);
        parcel.writeList(this.exportedActionBlocks);
    }

    private ArrayList<Trigger> getTriggerList(boolean z3) {
        if (this.m_triggerList == null) {
            this.m_triggerList = new ArrayList<>();
        }
        if (this.m_triggerList.size() == 0) {
            Trigger trigger = this.m_trigger;
            if (trigger != null) {
                this.m_triggerList.add(trigger);
            }
            this.m_trigger = null;
        }
        if (z3 && this.actionWaitingForTriggerActive != null) {
            ArrayList<Trigger> arrayList = new ArrayList<>();
            arrayList.addAll(this.actionWaitingForTriggerActive.getTriggersToWaitFor());
            arrayList.addAll(this.m_triggerList);
            return arrayList;
        }
        return this.m_triggerList;
    }

    public void invokeActions(TriggerContextInfo triggerContextInfo, boolean z3) {
        if (z3) {
            this.forceEvenIfNotEnabledTimestamp = System.currentTimeMillis();
        } else {
            this.forceEvenIfNotEnabledTimestamp = 0L;
        }
        invokeActionsInternal(triggerContextInfo, z3, null);
    }

    public void setEnabled(boolean z3, boolean z4) {
        boolean z5;
        if (this.isActionBlock) {
            return;
        }
        if (this.m_enabled != z3) {
            this.m_enabled = z3;
            MacroStore.resetEnabledMacroList();
            z5 = true;
        } else {
            z5 = false;
        }
        Set<String> emptySet = this.isExtra ? Collections.emptySet() : Settings.getDisabledCategories(MacroDroidApplication.getInstance());
        if (z3) {
            this.disabledTimestamp = 0L;
            if (!sMacroDroidEnabled || emptySet.contains(getCategory()) || this.m_triggerList.isEmpty()) {
                return;
            }
            this.wasEnabledIncludingCategory = true;
            if (!this.isActionBlock) {
                SystemLog.logVerbose("Enabling macro: " + getName(), getGUID());
            }
            for (Constraint constraint : this.m_constraintList) {
                if (constraint.isEnabled()) {
                    constraint.checkAllPermissions();
                    constraint.enableConstraintCheckingThreadSafe();
                }
            }
            Iterator<Action> it = this.m_actionList.iterator();
            while (it.hasNext()) {
                Action next = it.next();
                for (Constraint constraint2 : next.getConstraints()) {
                    if (constraint2.isEnabled()) {
                        constraint2.checkAllPermissions();
                        constraint2.enableConstraintCheckingThreadSafe();
                    }
                }
                next.checkAllPermissions();
                next.enableActionThreadSafe();
            }
            Iterator<Trigger> it2 = getTriggerList().iterator();
            while (it2.hasNext()) {
                Trigger next2 = it2.next();
                for (Constraint constraint3 : next2.getConstraints()) {
                    if (constraint3.isEnabled()) {
                        constraint3.checkAllPermissions();
                        constraint3.enableConstraintCheckingThreadSafe();
                    }
                }
                next2.checkPermissionsAndEnableTrigger();
            }
            return;
        }
        if (z5) {
            this.disabledTimestamp = System.currentTimeMillis();
            Iterator<Trigger> it3 = getTriggerList().iterator();
            while (it3.hasNext()) {
                Trigger next3 = it3.next();
                next3.disableTriggerThreadSafe();
                for (Constraint constraint4 : next3.getConstraints()) {
                    constraint4.disableConstraintCheckingThreadSafe();
                }
            }
            Iterator<Action> it4 = this.m_actionList.iterator();
            while (it4.hasNext()) {
                Action next4 = it4.next();
                next4.disableActionThreadSafe();
                for (Constraint constraint5 : next4.getConstraints()) {
                    constraint5.disableConstraintCheckingThreadSafe();
                }
            }
            for (Constraint constraint6 : this.m_constraintList) {
                constraint6.disableConstraintCheckingThreadSafe();
            }
            if (z4 && this.wasEnabledIncludingCategory && !this.isActionBlock) {
                SystemLog.logVerbose("Disabling macro: " + getName(), getGUID());
            }
            this.wasEnabledIncludingCategory = false;
        }
        ContinuePausedActionsHandler.cancelAlarmsForMacro(MacroDroidApplication.getInstance(), this);
    }

    public boolean canInvoke(@Nullable TriggerContextInfo triggerContextInfo, boolean z3) {
        boolean z4;
        int i4;
        if (this.isActionBlock) {
            return true;
        }
        if ((z3 || sMacroDroidEnabled) && !isCategoryDisabled()) {
            Trigger trigger = triggerContextInfo != null ? triggerContextInfo.getTrigger() : null;
            if (this.m_constraintList.size() <= 0) {
                z4 = true;
                i4 = 0;
            } else if (isConstraintOrCondition()) {
                Iterator<Constraint> it = this.m_constraintList.iterator();
                String str = "";
                i4 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        z4 = false;
                        break;
                    }
                    Constraint next = it.next();
                    if (next.isEnabled()) {
                        i4++;
                        if (next.constraintMet(triggerContextInfo)) {
                            z4 = true;
                            break;
                        } else if (str.isEmpty()) {
                            str = next.getConfiguredName();
                        }
                    }
                }
                if (!z4 && !this.m_excludeLog && i4 > 0) {
                    if (trigger != null) {
                        if (this.m_constraintList.size() > 1) {
                            SystemLog.logConstraint(trigger.getConfiguredName() + " did not fire because no constraints were true (" + str + ")", getGUID());
                        } else if (this.m_constraintList.size() == 1) {
                            SystemLog.logConstraint(trigger.getConfiguredName() + " did not fire because constraint failed: " + this.m_constraintList.get(0).getConfiguredName() + " (" + getName() + ")", getGUID());
                        }
                    } else {
                        SystemLog.logConstraint(getName() + " did not fire because no constraints were true (" + str + ")", getGUID());
                    }
                }
            } else {
                Iterator<Constraint> it2 = this.m_constraintList.iterator();
                i4 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        z4 = true;
                        break;
                    }
                    Constraint next2 = it2.next();
                    if (next2.isEnabled()) {
                        i4++;
                        if (!next2.constraintMet(triggerContextInfo)) {
                            if (this.m_excludeLog && i4 > 0) {
                                if (trigger != null) {
                                    SystemLog.logConstraint(trigger.getSystemLogEntryName(triggerContextInfo) + " did not fire because constraint failed: " + next2.getSystemLogEntryName(triggerContextInfo) + " (" + getName() + ")", getGUID());
                                } else {
                                    SystemLog.logConstraint(getName() + " did not invoke because constraint failed: " + next2.getSystemLogEntryName(triggerContextInfo) + " (" + getName() + ")", getGUID());
                                }
                            }
                            z4 = false;
                        }
                    }
                }
            }
            return i4 == 0 || z4;
        }
        return false;
    }

    public void invokeActionsDontResetCount(TriggerContextInfo triggerContextInfo, boolean z3, ResumeMacroInfo resumeMacroInfo) {
        if (z3) {
            this.forceEvenIfNotEnabledTimestamp = System.currentTimeMillis();
        } else {
            this.forceEvenIfNotEnabledTimestamp = 0L;
        }
        invokeActionsInternal(triggerContextInfo, z3, resumeMacroInfo, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b A[Catch: StackOverflowError -> 0x0171, TryCatch #0 {StackOverflowError -> 0x0171, blocks: (B:15:0x0057, B:17:0x005d, B:27:0x008b, B:28:0x009e, B:30:0x00a4, B:32:0x00ac, B:36:0x00b5, B:39:0x00bc, B:41:0x00c0, B:43:0x00c4, B:44:0x00e0, B:46:0x00f6, B:47:0x00f9, B:48:0x010e, B:50:0x0117, B:51:0x011f, B:53:0x0123, B:54:0x0128, B:56:0x012e, B:58:0x0132, B:59:0x014e, B:19:0x0068, B:21:0x006e, B:22:0x0078, B:24:0x007e), top: B:63:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void invokeActionsInternal(com.arlosoft.macrodroid.triggers.TriggerContextInfo r13, boolean r14, @androidx.annotation.Nullable com.arlosoft.macrodroid.data.ResumeMacroInfo r15, boolean r16) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.macro.Macro.invokeActionsInternal(com.arlosoft.macrodroid.triggers.TriggerContextInfo, boolean, com.arlosoft.macrodroid.data.ResumeMacroInfo, boolean):void");
    }

    public void invokeActions(TriggerContextInfo triggerContextInfo, boolean z3, ResumeMacroInfo resumeMacroInfo) {
        if (z3) {
            this.forceEvenIfNotEnabledTimestamp = System.currentTimeMillis();
        } else {
            this.forceEvenIfNotEnabledTimestamp = 0L;
        }
        invokeActionsInternal(triggerContextInfo, z3, resumeMacroInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
        if (com.arlosoft.macrodroid.macro.Macro.macroDroidDisabledTimeStamp <= r12) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeActions(java.util.List<com.arlosoft.macrodroid.action.Action> r18, int r19, com.arlosoft.macrodroid.triggers.TriggerContextInfo r20, boolean r21, java.util.Stack<java.lang.Integer> r22, @androidx.annotation.Nullable com.arlosoft.macrodroid.data.ResumeMacroInfo r23) {
        /*
            Method dump skipped, instructions count: 1263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.macro.Macro.invokeActions(java.util.List, int, com.arlosoft.macrodroid.triggers.TriggerContextInfo, boolean, java.util.Stack, com.arlosoft.macrodroid.data.ResumeMacroInfo):void");
    }

    private SelectableItem findChildByGUID(long j4, List<Constraint> list) {
        SelectableItem findChildByGUID;
        if (list != null && list.size() != 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (list.get(i4).getSIGUID() == j4) {
                    return list.get(i4);
                }
                if ((list.get(i4) instanceof LogicConstraint) && (findChildByGUID = findChildByGUID(j4, list.get(i4).getConstraints())) != null) {
                    return findChildByGUID;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Macro(Parcel parcel) {
        this.m_enabled = false;
        this.wasEnabledIncludingCategory = false;
        this.enabledStateDuringLoad = false;
        this.m_descriptionOpen = false;
        this.m_completed = true;
        this.isActionBlock = false;
        this.isBeingImported = false;
        this.isClonedInstance = false;
        this.isFavourite = false;
        this.localVariableUpdatedListeners = Collections.synchronizedSet(new HashSet());
        this.actionWaitingForTriggerActive = null;
        this.originalTriggerContextInfo = null;
        this.isRunning = false;
        this.originalMacroGuid = 0L;
        this.exportedActionBlocks = new ArrayList();
        this.actionBlocksToImport = new ArrayList();
        this.forceEvenIfNotEnabledTimestamp = 0L;
        this.disabledTimestamp = 0L;
        this.isExtra = false;
        this.activeShellScriptAction = null;
        this.m_trigger = (Trigger) parcel.readParcelable(Trigger.class.getClassLoader());
        this.m_triggerList = parcel.readArrayList(Trigger.class.getClassLoader());
        this.m_actionList = parcel.readArrayList(Action.class.getClassLoader());
        this.m_constraintList = parcel.readArrayList(Constraint.class.getClassLoader());
        this.localVariables = parcel.readArrayList(MacroDroidVariable.class.getClassLoader());
        this.m_name = parcel.readString();
        this.m_enabled = parcel.readInt() != 0;
        this.m_isOrCondition = parcel.readInt() != 0;
        this.m_configuringShortcut = parcel.readInt() != 0;
        this.m_uniqueId = parcel.readInt();
        this.m_category = parcel.readString();
        this.m_GUID = parcel.readLong();
        this.m_description = parcel.readString();
        this.m_descriptionOpen = parcel.readInt() != 0;
        this.m_excludeLog = parcel.readInt() != 0;
        this.m_headingColor = parcel.readInt();
        this.isActionBlock = parcel.readInt() != 0;
        this.isBeingImported = parcel.readInt() != 0;
        this.isClonedInstance = parcel.readInt() != 0;
        this.isFavourite = parcel.readInt() != 0;
        this.lastEditedTimestamp = parcel.readLong();
        this.exportedActionBlocks = parcel.readArrayList(ActionBlock.class.getClassLoader());
    }
}
