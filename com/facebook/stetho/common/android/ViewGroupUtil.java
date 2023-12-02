package com.facebook.stetho.common.android;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public final class ViewGroupUtil {
    private ViewGroupUtil() {
    }

    public static int findChildIndex(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (viewGroup.getChildAt(i4) == view) {
                return i4;
            }
        }
        return -1;
    }
}
