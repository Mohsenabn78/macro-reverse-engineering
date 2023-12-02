package com.arlosoft.macrodroid.drawer.model;

import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class DrawerItemOpenShortcut extends DrawerItem {
    public static final String ITEM_TYPE = "LaunchShortcut";
    private String encodedIntent;
    private String packageName;
    private String shortcutName;
    private String text;

    public DrawerItemOpenShortcut() {
        super(ITEM_TYPE);
    }

    public String getIntent() {
        return this.encodedIntent;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public int getLayoutResId() {
        return R.layout.drawer_item_open_shortcut;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public String getName() {
        return this.shortcutName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getText() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        return this.shortcutName;
    }

    public void setIntent(String str) {
        this.encodedIntent = str;
    }

    public void setShortcutName(String str) {
        this.shortcutName = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public DrawerItemOpenShortcut(String str, String str2) {
        super(ITEM_TYPE);
        this.packageName = str;
        this.shortcutName = str2;
    }
}
