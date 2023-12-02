package com.arlosoft.macrodroid.drawer.model;

import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class DrawerItemSeparator extends DrawerItem {
    public static final String ITEM_TYPE = "Seperator";

    public DrawerItemSeparator() {
        super(ITEM_TYPE);
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public int getLayoutResId() {
        return R.layout.drawer_item_seperator;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public String getName() {
        return "";
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public boolean isEditable() {
        return false;
    }
}
