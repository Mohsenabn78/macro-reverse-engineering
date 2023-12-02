package agency.tango.materialintroscreen.parallax;

import agency.tango.materialintroscreen.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.FloatRange;

/* loaded from: classes.dex */
public class ParallaxRelativeLayout extends RelativeLayout implements Parallaxable {
    public ParallaxRelativeLayout(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // agency.tango.materialintroscreen.parallax.Parallaxable
    public void setOffset(@FloatRange(from = -1.0d, to = 1.0d) float f4) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f128a != 0.0f) {
                childAt.setTranslationX(getWidth() * (-f4) * layoutParams.f128a);
            }
        }
    }

    public ParallaxRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParallaxRelativeLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RelativeLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        float f128a;

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f128a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ParallaxLayout_Layout);
            this.f128a = obtainStyledAttributes.getFloat(R.styleable.ParallaxLayout_Layout_layout_parallaxFactor, this.f128a);
            obtainStyledAttributes.recycle();
        }

        LayoutParams(int i4, int i5) {
            super(i4, i5);
            this.f128a = 0.0f;
        }

        LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f128a = 0.0f;
        }
    }
}
