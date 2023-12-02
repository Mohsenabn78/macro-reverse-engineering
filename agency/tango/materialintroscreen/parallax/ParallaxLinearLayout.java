package agency.tango.materialintroscreen.parallax;

import agency.tango.materialintroscreen.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.FloatRange;

/* loaded from: classes.dex */
public class ParallaxLinearLayout extends LinearLayout implements Parallaxable {
    public ParallaxLinearLayout(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // agency.tango.materialintroscreen.parallax.Parallaxable
    public void setOffset(@FloatRange(from = -1.0d, to = 1.0d) float f4) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f127a != 0.0f) {
                childAt.setTranslationX(getWidth() * (-f4) * layoutParams.f127a);
            }
        }
    }

    public ParallaxLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParallaxLinearLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        float f127a;

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f127a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ParallaxLayout_Layout);
            this.f127a = obtainStyledAttributes.getFloat(R.styleable.ParallaxLayout_Layout_layout_parallaxFactor, this.f127a);
            obtainStyledAttributes.recycle();
        }

        LayoutParams(int i4, int i5) {
            super(i4, i5);
            this.f127a = 0.0f;
        }

        LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f127a = 0.0f;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
