package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    private static float e(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return (float) (1.0d - Math.cos((f4 * 3.141592653589793d) / 2.0d));
    }

    private static float f(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return (float) Math.sin((f4 * 3.141592653589793d) / 2.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public void c(TabLayout tabLayout, View view, View view2, float f4, @NonNull Drawable drawable) {
        boolean z3;
        float f5;
        float e4;
        RectF a4 = TabIndicatorInterpolator.a(tabLayout, view);
        RectF a5 = TabIndicatorInterpolator.a(tabLayout, view2);
        if (a4.left < a5.left) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            f5 = e(f4);
            e4 = f(f4);
        } else {
            f5 = f(f4);
            e4 = e(f4);
        }
        drawable.setBounds(AnimationUtils.lerp((int) a4.left, (int) a5.left, f5), drawable.getBounds().top, AnimationUtils.lerp((int) a4.right, (int) a5.right, e4), drawable.getBounds().bottom);
    }
}
