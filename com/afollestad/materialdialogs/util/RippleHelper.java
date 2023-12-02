package com.afollestad.materialdialogs.util;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.ColorInt;

@TargetApi(21)
/* loaded from: classes2.dex */
public class RippleHelper {
    public static void applyColor(Drawable drawable, @ColorInt int i4) {
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(ColorStateList.valueOf(i4));
        }
    }
}
