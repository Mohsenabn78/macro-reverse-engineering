package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;

/* loaded from: classes3.dex */
public class ColorUtils {
    @ColorInt
    public static int darkenOrLightenBasedOnDarkMode(Context context, @ColorInt int i4) {
        int i5 = context.getResources().getConfiguration().uiMode & 48;
        if (i5 != 0) {
            if (i5 != 16) {
                if (i5 != 32) {
                    return lighter(i4, 0.4f);
                }
                return lighter(i4, 0.4f);
            }
            return darker(i4, 0.9f);
        } else if (Settings.getDarkMode(context).equals(ExifInterface.GPS_MEASUREMENT_2D)) {
            return lighter(i4, 0.4f);
        } else {
            return darker(i4, 0.9f);
        }
    }

    @ColorInt
    public static int darker(@ColorInt int i4, float f4) {
        return Color.argb(Color.alpha(i4), Math.max((int) (Color.red(i4) * f4), 0), Math.max((int) (Color.green(i4) * f4), 0), Math.max((int) (Color.blue(i4) * f4), 0));
    }

    @ColorRes
    public static int getDarkSelectableItemColor(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return R.color.constraints_primary_dark;
            }
            return R.color.actions_primary_dark;
        }
        return R.color.trigger_primary_dark;
    }

    public static int getItemType(SelectableItem selectableItem) {
        if (selectableItem instanceof Trigger) {
            return 0;
        }
        if (selectableItem instanceof Action) {
            return 1;
        }
        return 2;
    }

    @ColorRes
    public static int getSelectableItemColor(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return R.color.constraints_primary;
            }
            return R.color.actions_primary;
        }
        return R.color.trigger_primary;
    }

    @ColorRes
    public static int getSelectableItemColor50Percent(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return R.color.constraints_primary_50;
            }
            return R.color.actions_primary_50;
        }
        return R.color.trigger_primary_50;
    }

    @ColorInt
    public static int lighter(@ColorInt int i4, float f4) {
        float f5 = 1.0f - f4;
        return Color.argb(Color.alpha(i4), (int) ((((Color.red(i4) * f5) / 255.0f) + f4) * 255.0f), (int) ((((Color.green(i4) * f5) / 255.0f) + f4) * 255.0f), (int) ((((Color.blue(i4) * f5) / 255.0f) + f4) * 255.0f));
    }
}
