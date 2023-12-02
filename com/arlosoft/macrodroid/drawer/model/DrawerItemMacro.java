package com.arlosoft.macrodroid.drawer.model;

import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;

/* loaded from: classes3.dex */
public class DrawerItemMacro extends DrawerItem {
    public static final String ITEM_TYPE = "Macro";
    private boolean enforceConstraints;
    private boolean keepDrawerOpenOnPress;
    private long macroGuid;

    public DrawerItemMacro() {
        super("Macro");
        this.enforceConstraints = false;
        this.keepDrawerOpenOnPress = false;
    }

    public boolean getEnforceConstraints() {
        return this.enforceConstraints;
    }

    public boolean getKeepDrawerOpenOnPress() {
        return this.keepDrawerOpenOnPress;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public int getLayoutResId() {
        return R.layout.drawer_item_macro;
    }

    public long getMacroGuid() {
        return this.macroGuid;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public String getName() {
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(this.macroGuid);
        if (macroByGUID != null) {
            return macroByGUID.getName();
        }
        return "<" + MacroDroidApplication.getInstance().getString(R.string.macro_not_found) + ">";
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public boolean isValid() {
        if (MacroStore.getInstance().getMacroByGUID(this.macroGuid) != null) {
            return true;
        }
        return false;
    }

    public void setEnforceConstraints(boolean z3) {
        this.enforceConstraints = z3;
    }

    public void setKeepDrawerOpenOnPress(boolean z3) {
        this.keepDrawerOpenOnPress = z3;
    }

    public DrawerItemMacro(long j4) {
        super("Macro");
        this.enforceConstraints = false;
        this.keepDrawerOpenOnPress = false;
        this.macroGuid = j4;
    }
}
