package com.afollestad.materialdialogs.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.afollestad.materialdialogs.GravityEnum;

/* loaded from: classes2.dex */
public class ThemeSingleton {

    /* renamed from: a  reason: collision with root package name */
    private static ThemeSingleton f1161a;
    public GravityEnum btnStackedGravity;
    public GravityEnum buttonsGravity;
    public GravityEnum contentGravity;
    public GravityEnum itemsGravity;
    public GravityEnum titleGravity;
    public boolean darkTheme = false;
    @ColorInt
    public int titleColor = 0;
    @ColorInt
    public int contentColor = 0;
    public ColorStateList positiveColor = null;
    public ColorStateList neutralColor = null;
    public ColorStateList negativeColor = null;
    @ColorInt
    public int widgetColor = 0;
    @ColorInt
    public int itemColor = 0;
    public Drawable icon = null;
    @ColorInt
    public int backgroundColor = 0;
    @ColorInt
    public int dividerColor = 0;
    public ColorStateList linkColor = null;
    @DrawableRes
    public int listSelector = 0;
    @DrawableRes
    public int btnSelectorStacked = 0;
    @DrawableRes
    public int btnSelectorPositive = 0;
    @DrawableRes
    public int btnSelectorNeutral = 0;
    @DrawableRes
    public int btnSelectorNegative = 0;

    public ThemeSingleton() {
        GravityEnum gravityEnum = GravityEnum.START;
        this.titleGravity = gravityEnum;
        this.contentGravity = gravityEnum;
        this.btnStackedGravity = GravityEnum.END;
        this.itemsGravity = gravityEnum;
        this.buttonsGravity = gravityEnum;
    }

    public static ThemeSingleton get(boolean z3) {
        if (f1161a == null && z3) {
            f1161a = new ThemeSingleton();
        }
        return f1161a;
    }

    public static ThemeSingleton get() {
        return get(true);
    }
}
