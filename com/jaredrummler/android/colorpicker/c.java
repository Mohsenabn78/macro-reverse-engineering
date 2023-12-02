package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: DrawingUtils.java */
/* loaded from: classes6.dex */
final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, float f4) {
        float applyDimension = TypedValue.applyDimension(1, f4, context.getResources().getDisplayMetrics());
        int i4 = (int) (applyDimension + 0.5d);
        if (i4 == 0 && applyDimension > 0.0f) {
            return 1;
        }
        return i4;
    }
}
