package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes3.dex */
public class IconTextView extends AppCompatTextView {
    public IconTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a();
    }

    private void a() {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/fontawesome.ttf"));
    }

    private void setBackgroundPressedColor(int i4) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(i4));
        stateListDrawable.addState(new int[0], new ColorDrawable(0));
        setBackgroundDrawable(stateListDrawable);
    }

    public void setTextColorAndBackground(int i4, int i5) {
        setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{i5, i4}));
    }

    public void setTextColorAndBackground(int i4) {
        setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{-1, i4}));
        setBackgroundPressedColor(i4);
    }

    public IconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public IconTextView(Context context) {
        super(context);
        a();
    }
}
