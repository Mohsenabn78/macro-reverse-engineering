package com.arlosoft.macrodroid.drawer.model;

import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.stopwatch.StopWatch;

/* loaded from: classes3.dex */
public class DrawerItemStopwatch extends DrawerItem implements RefreshableDrawerItem {
    public static final String ITEM_TYPE = "Stopwatch";
    private boolean hideName;
    private String stopwatchName;

    public DrawerItemStopwatch() {
        super(ITEM_TYPE);
    }

    public boolean getHideName() {
        return this.hideName;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public int getLayoutResId() {
        return R.layout.drawer_item_stopwatch;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public String getName() {
        if (isValid()) {
            return getStopwatchName();
        }
        return "<" + MacroDroidApplication.getInstance().getString(R.string.stopwatch_not_found) + ">";
    }

    public String getStopwatchName() {
        return this.stopwatchName;
    }

    @Override // com.arlosoft.macrodroid.drawer.model.DrawerItem
    public boolean isValid() {
        return StopWatch.getStopWatches(MacroDroidApplication.getInstance()).contains(this.stopwatchName);
    }

    public void setHideName(boolean z3) {
        this.hideName = z3;
    }

    public String setStopwatchName(String str) {
        this.stopwatchName = str;
        return str;
    }

    public DrawerItemStopwatch(String str) {
        super(ITEM_TYPE);
        this.stopwatchName = str;
    }
}
