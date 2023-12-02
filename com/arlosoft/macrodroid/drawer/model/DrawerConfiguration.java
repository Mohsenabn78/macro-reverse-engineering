package com.arlosoft.macrodroid.drawer.model;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class DrawerConfiguration {
    public int backgroundColor;
    public List<DrawerItem> drawerItems = new ArrayList();
    public int headerColor;
    public boolean leftSide;
    public int swipeAreaColor;
    public int swipeAreaHeight;
    public int swipeAreaOffset;
    public int swipeAreaOpacity;
    public int swipeAreaWidth;
    public int visibleSwipeAreaWidth;

    public static DrawerConfiguration getDefaultConfiguration(Context context) {
        DrawerConfiguration drawerConfiguration = new DrawerConfiguration();
        drawerConfiguration.swipeAreaWidth = 14;
        drawerConfiguration.swipeAreaHeight = 20;
        drawerConfiguration.swipeAreaOffset = 40;
        drawerConfiguration.swipeAreaColor = -7829368;
        drawerConfiguration.swipeAreaOpacity = 80;
        drawerConfiguration.backgroundColor = -1;
        drawerConfiguration.headerColor = ContextCompat.getColor(context, R.color.primary);
        return drawerConfiguration;
    }

    @Nullable
    public DrawerItem getItemByGuid(long j4) {
        for (DrawerItem drawerItem : this.drawerItems) {
            if (drawerItem.getGuid() == j4) {
                return drawerItem;
            }
        }
        return null;
    }

    public int getVisibleWidth() {
        int i4 = this.visibleSwipeAreaWidth;
        if (i4 == 0) {
            return this.swipeAreaWidth;
        }
        return i4;
    }
}
