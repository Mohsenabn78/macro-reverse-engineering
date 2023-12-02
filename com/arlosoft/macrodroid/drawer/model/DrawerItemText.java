package com.arlosoft.macrodroid.drawer.model;

import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class DrawerItemText extends DrawerItem {
    public static final String ITEM_TYPE = "Text";
    private boolean enforceConstraints;
    private long macroGuid;
    private int maxLines;
    private String text;

    public DrawerItemText(String str, long j4) {
        super(ITEM_TYPE);
        this.enforceConstraints = false;
        this.maxLines = 2;
        this.text = str;
        this.macroGuid = j4;
    }

    public boolean getEnforceConstraints() {
        return this.enforceConstraints;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public int getLayoutResId() {
        return R.layout.drawer_item_text;
    }

    public long getMacroGuid() {
        return this.macroGuid;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public String getName() {
        return this.text;
    }

    public String getText() {
        return this.text;
    }

    public void setEnforceConstraints(boolean z3) {
        this.enforceConstraints = z3;
    }

    public void setMacroGuid(long j4) {
        this.macroGuid = j4;
    }

    public void setMaxLines(int i4) {
        this.maxLines = i4;
    }

    public void setText(String str) {
        this.text = str;
    }

    public DrawerItemText() {
        super(ITEM_TYPE);
        this.enforceConstraints = false;
        this.maxLines = 2;
    }
}
