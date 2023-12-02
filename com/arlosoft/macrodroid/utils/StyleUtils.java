package com.arlosoft.macrodroid.utils;

import androidx.annotation.StyleRes;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class StyleUtils {
    @StyleRes
    public static int getAlertDialogStyle(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return R.style.Theme_App_Dialog_Constraint;
            }
            return R.style.Theme_App_Dialog_Action;
        }
        return R.style.Theme_App_Dialog_Trigger;
    }
}
