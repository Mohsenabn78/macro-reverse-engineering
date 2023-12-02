package com.arlosoft.macrodroid.drawer.model;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class DrawerItem {
    public static final String PACKAGE_FILE_URI = "FROM_FILE";
    @ColorInt
    private int color;
    private long guid;
    private boolean hideIcon;
    private String imagePackageName;
    private String imageResourceName;
    private String type;

    public DrawerItem() {
        this.guid = UUID.randomUUID().getLeastSignificantBits();
        this.color = Color.rgb(117, 117, 117);
    }

    public int getColor() {
        return this.color;
    }

    public long getGuid() {
        return this.guid;
    }

    public String getImagePackageName() {
        return this.imagePackageName;
    }

    public String getImageResourceName() {
        return this.imageResourceName;
    }

    public abstract int getLayoutResId();

    public abstract String getName();

    public boolean hideIcon() {
        return this.hideIcon;
    }

    public boolean isEditable() {
        return true;
    }

    public boolean isValid() {
        return true;
    }

    public void setColor(@ColorInt int i4) {
        this.color = i4;
    }

    public void setHideIcon(boolean z3) {
        this.hideIcon = z3;
    }

    public void setIcon(String str, String str2) {
        this.imagePackageName = str;
        this.imageResourceName = str2;
    }

    public void setImageFile(String str) {
        this.imagePackageName = PACKAGE_FILE_URI;
        this.imageResourceName = str;
    }

    public DrawerItem(String str) {
        this();
        this.type = str;
    }
}
