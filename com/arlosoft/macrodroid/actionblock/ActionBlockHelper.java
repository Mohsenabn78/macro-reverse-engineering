package com.arlosoft.macrodroid.actionblock;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ActionBlockAction;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActionBlockHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nActionBlockHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockHelper.kt\ncom/arlosoft/macrodroid/actionblock/ActionBlockHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1855#2:90\n1855#2,2:91\n1855#2,2:93\n1856#2:95\n*S KotlinDebug\n*F\n+ 1 ActionBlockHelper.kt\ncom/arlosoft/macrodroid/actionblock/ActionBlockHelper\n*L\n12#1:90\n27#1:91,2\n34#1:93,2\n12#1:95\n*E\n"})
/* loaded from: classes.dex */
public final class ActionBlockHelper {
    public static final int $stable = 0;
    @NotNull
    public static final ActionBlockHelper INSTANCE = new ActionBlockHelper();

    private ActionBlockHelper() {
    }

    private final boolean a(ActionBlock actionBlock, ActionBlock actionBlock2) {
        if (actionBlock.getActions().size() != actionBlock2.getActions().size()) {
            return false;
        }
        int size = actionBlock.getActions().size();
        for (int i4 = 0; i4 < size; i4++) {
            if (actionBlock.getActions().get(i4).getClass() != actionBlock2.getActions().get(i4).getClass()) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final void addActionBlocks(@NotNull ActionBlockStore actionBlockStore, @NotNull Macro macro, @NotNull List<ActionBlock> actionBlocks, boolean z3) {
        Intrinsics.checkNotNullParameter(actionBlockStore, "actionBlockStore");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(actionBlocks, "actionBlocks");
        for (ActionBlock actionBlock : actionBlocks) {
            if (actionBlockStore.getActionBlockByGuid(actionBlock.getGUID()) != null) {
                if (z3) {
                    applyImport(actionBlock);
                }
                actionBlockStore.addActionBlock(actionBlock);
            } else {
                actionBlock.setIsBeingImported(true);
                String name = actionBlock.getName();
                Intrinsics.checkNotNullExpressionValue(name, "actionBlock.name");
                ActionBlock actionBlockByName = actionBlockStore.getActionBlockByName(name);
                if (actionBlockByName != null) {
                    if (INSTANCE.a(actionBlockByName, actionBlock)) {
                        ArrayList<Action> actions = macro.getActions();
                        Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
                        for (Action action : actions) {
                            if (action instanceof ActionBlockAction) {
                                ActionBlockAction actionBlockAction = (ActionBlockAction) action;
                                if (actionBlockAction.getActionBlockId() == actionBlock.getGUID()) {
                                    actionBlockAction.setActionBlockId(actionBlockByName.getGUID());
                                }
                            }
                        }
                    } else {
                        String name2 = actionBlock.getName();
                        actionBlock.setName(name2 + " 2");
                        ArrayList<Action> actions2 = macro.getActions();
                        Intrinsics.checkNotNullExpressionValue(actions2, "macro.actions");
                        for (Action action2 : actions2) {
                            if (action2 instanceof ActionBlockAction) {
                                ActionBlockAction actionBlockAction2 = (ActionBlockAction) action2;
                                if (actionBlockAction2.getActionBlockId() == actionBlock.getGUID()) {
                                    String name3 = actionBlock.getName();
                                    Intrinsics.checkNotNullExpressionValue(name3, "actionBlock.name");
                                    actionBlockAction2.setActionBlockName(name3);
                                }
                            }
                        }
                        if (z3) {
                            applyImport(actionBlock);
                        }
                        actionBlockStore.addActionBlock(actionBlock);
                    }
                } else {
                    if (z3) {
                        applyImport(actionBlock);
                    }
                    actionBlockStore.addActionBlock(actionBlock);
                }
            }
        }
    }

    @JvmStatic
    public static final void applyImport(@NotNull ActionBlock actionBlock) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        Iterator<Trigger> it = actionBlock.getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.applyImport();
            for (Constraint constraint : next.getConstraints()) {
                constraint.setMacro(actionBlock);
                constraint.applyImport();
            }
        }
        Iterator<Action> it2 = actionBlock.getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            next2.applyImport();
            for (Constraint constraint2 : next2.getConstraints()) {
                constraint2.setMacro(actionBlock);
                constraint2.applyImport();
            }
        }
        for (Constraint constraint3 : actionBlock.getConstraints()) {
            constraint3.setMacro(actionBlock);
            constraint3.applyImport();
        }
    }
}
