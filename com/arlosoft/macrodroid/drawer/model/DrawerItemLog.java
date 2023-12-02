package com.arlosoft.macrodroid.drawer.model;

import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;

/* loaded from: classes3.dex */
public class DrawerItemLog extends DrawerItem implements RefreshableDrawerItem {
    public static final String ITEM_TYPE = "Log";
    private boolean isUserLog;
    private int maxLines;

    public DrawerItemLog(boolean z3, int i4) {
        super(ITEM_TYPE);
        this.isUserLog = z3;
        this.maxLines = i4;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public int getLayoutResId() {
        return R.layout.drawer_item_log;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public String getName() {
        MacroDroidApplication macroDroidApplication;
        int i4;
        if (this.isUserLog) {
            macroDroidApplication = MacroDroidApplication.getInstance();
            i4 = R.string.user_log;
        } else {
            macroDroidApplication = MacroDroidApplication.getInstance();
            i4 = R.string.system_log;
        }
        return macroDroidApplication.getString(i4);
    }

    public boolean isUserLog() {
        return this.isUserLog;
    }

    public void setMaxLines(int i4) {
        this.maxLines = i4;
    }

    public DrawerItemLog() {
        super(ITEM_TYPE);
    }
}
