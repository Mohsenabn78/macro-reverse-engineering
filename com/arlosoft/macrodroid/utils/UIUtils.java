package com.arlosoft.macrodroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes3.dex */
public class UIUtils {
    public static int getMaximumScreenBrightnessSetting(Context context) {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
        if (identifier != 0) {
            return system.getInteger(identifier);
        }
        return 255;
    }

    public static int getMinimumScreenBrightnessSetting(Context context) {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("config_screenBrightnessSettingMinimum", "integer", "android");
        if (identifier == 0) {
            identifier = system.getIdentifier("config_screenBrightnessDim", "integer", "android");
        }
        if (identifier != 0) {
            try {
                return system.getInteger(identifier);
            } catch (Resources.NotFoundException unused) {
                return 0;
            }
        }
        return 0;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }
}
