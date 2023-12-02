package com.arlosoft.macrodroid.drawer.model;

import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class DrawerItemAppShortcut extends DrawerItem {
    public static final String ITEM_TYPE = "AppShortcut";
    private String appName;
    private String packageName;
    private String text;

    public DrawerItemAppShortcut() {
        super(ITEM_TYPE);
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public int getLayoutResId() {
        return R.layout.drawer_item_app_shortcut;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public String getName() {
        return this.appName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getText() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        return this.appName;
    }

    public void setText(String str) {
        this.text = str;
    }

    public DrawerItemAppShortcut(String str, String str2) {
        super(ITEM_TYPE);
        this.packageName = str;
        this.appName = str2;
    }
}
