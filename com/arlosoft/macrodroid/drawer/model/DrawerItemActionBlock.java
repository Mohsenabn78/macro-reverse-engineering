package com.arlosoft.macrodroid.drawer.model;

import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockData;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.macro.MacroStore;

/* loaded from: classes3.dex */
public class DrawerItemActionBlock extends DrawerItem {
    public static final String ITEM_TYPE = "ActionBlock";
    private ActionBlockData actionBlockData;

    public DrawerItemActionBlock() {
        super(ITEM_TYPE);
    }

    public ActionBlockData getActionBlockData() {
        return this.actionBlockData;
    }

    public long getActionBlockGuid() {
        return this.actionBlockData.getActionBlockGuid();
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public int getLayoutResId() {
        return R.layout.drawer_item_action_block;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public String getName() {
        ActionBlock actionBlockByGuid = MacroStore.getInstance().getActionBlockByGuid(this.actionBlockData.getActionBlockGuid());
        if (actionBlockByGuid != null) {
            return actionBlockByGuid.getName();
        }
        return "<" + MacroDroidApplication.getInstance().getString(R.string.action_block_not_found) + ">";
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public boolean isValid() {
        if (MacroStore.getInstance().getActionBlockByGuid(this.actionBlockData.getActionBlockGuid()) != null) {
            return true;
        }
        return false;
    }

    public void setActionBlockData(ActionBlockData actionBlockData) {
        this.actionBlockData = actionBlockData;
    }

    public DrawerItemActionBlock(ActionBlockData actionBlockData) {
        super(ITEM_TYPE);
        this.actionBlockData = actionBlockData;
    }
}
