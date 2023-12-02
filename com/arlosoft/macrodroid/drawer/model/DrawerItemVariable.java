package com.arlosoft.macrodroid.drawer.model;

import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;

/* loaded from: classes3.dex */
public class DrawerItemVariable extends DrawerItem implements RefreshableDrawerItem {
    public static final String ITEM_TYPE = "Variable";
    private DictionaryKeys dictionaryKeys;
    private boolean hideVariableName;
    private String variableName;

    public DrawerItemVariable() {
        super("Variable");
    }

    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.dictionaryKeys;
    }

    public boolean getHideName() {
        return this.hideVariableName;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public int getLayoutResId() {
        return R.layout.drawer_item_variable;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public String getName() {
        if (isValid()) {
            return getVariableName() + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        }
        return "<" + MacroDroidApplication.getInstance().getString(R.string.variable_does_not_exit) + ">";
    }

    public String getVariableName() {
        return this.variableName;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public boolean isValid() {
        if (MacroDroidVariableStore.getInstance().getVariableByName(this.variableName) != null) {
            return true;
        }
        return false;
    }

    public void setHideVariableName(boolean z3) {
        this.hideVariableName = z3;
    }

    public void setVariableName(String str) {
        this.variableName = str;
    }

    public DrawerItemVariable(String str, @Nullable DictionaryKeys dictionaryKeys) {
        super("Variable");
        this.variableName = str;
        this.dictionaryKeys = dictionaryKeys;
        this.hideVariableName = true;
    }
}
