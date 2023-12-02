package com.arlosoft.macrodroid.utils.transformations;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class CubeInRotationTransformation implements ViewPager.PageTransformer {
    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f4) {
        if (f4 < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f4 <= 1.0f) {
            float abs = ((1.0f - Math.abs(f4)) * 0.100000024f) + 0.9f;
            view.setScaleX(abs);
            view.setScaleY(abs);
            view.setAlpha(Math.max(0.98f, 1.0f - Math.abs(f4)));
        } else {
            view.setAlpha(0.0f);
        }
    }
}
