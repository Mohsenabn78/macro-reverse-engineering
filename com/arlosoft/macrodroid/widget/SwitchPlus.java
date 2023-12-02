package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class SwitchPlus extends SwitchCompat {

    /* renamed from: a  reason: collision with root package name */
    private int f16493a;

    /* renamed from: b  reason: collision with root package name */
    private int f16494b;

    public SwitchPlus(Context context) {
        super(context);
        this.f16494b = Color.argb(255, 128, 128, 128);
        b(context);
    }

    private void a(boolean z3) {
        int i4;
        if (z3) {
            i4 = this.f16493a;
        } else {
            i4 = this.f16494b;
        }
        try {
            Drawable thumbDrawable = getThumbDrawable();
            if (thumbDrawable != null) {
                thumbDrawable.setColorFilter(i4, PorterDuff.Mode.MULTIPLY);
            }
        } catch (NullPointerException e4) {
            e4.printStackTrace();
        }
    }

    private void b(Context context) {
        this.f16493a = ContextCompat.getColor(context, R.color.macro_list_switch_on_thumb);
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        super.setChecked(z3);
        a(z3);
    }

    public void setOffColor(@ColorInt int i4) {
        this.f16494b = i4;
    }

    public SwitchPlus(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16494b = Color.argb(255, 128, 128, 128);
        b(context);
    }

    public SwitchPlus(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f16494b = Color.argb(255, 128, 128, 128);
        b(context);
    }
}
