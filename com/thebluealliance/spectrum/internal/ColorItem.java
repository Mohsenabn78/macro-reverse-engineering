package com.thebluealliance.spectrum.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import com.thebluealliance.spectrum.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* loaded from: classes6.dex */
public class ColorItem extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private EventBus f38068a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f38069b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    private int f38070c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f38071d;

    /* renamed from: e  reason: collision with root package name */
    private int f38072e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ColorItem.this.setItemCheckmarkAttributes(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ColorItem.this.f38069b.setVisibility(4);
            ColorItem.this.setItemCheckmarkAttributes(0.0f);
        }
    }

    public ColorItem(Context context, @ColorInt int i4, boolean z3, EventBus eventBus) {
        super(context);
        this.f38072e = 0;
        this.f38070c = i4;
        this.f38071d = z3;
        this.f38068a = eventBus;
        e();
        setChecked(this.f38071d);
    }

    private Drawable c() {
        int i4;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        int i5 = this.f38072e;
        if (i5 != 0) {
            if (ColorUtil.isColorDark(this.f38070c)) {
                i4 = -1;
            } else {
                i4 = -16777216;
            }
            gradientDrawable.setStroke(i5, i4);
        }
        gradientDrawable.setColor(this.f38070c);
        return gradientDrawable;
    }

    private Drawable d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-16777216);
        return new RippleDrawable(ColorStateList.valueOf(ColorUtil.getRippleColor(this.f38070c)), null, gradientDrawable);
    }

    private void e() {
        int i4;
        g();
        this.f38068a.register(this);
        setOnClickListener(this);
        LayoutInflater.from(getContext()).inflate(R.layout.color_item, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.selected_checkmark);
        this.f38069b = imageView;
        if (ColorUtil.isColorDark(this.f38070c)) {
            i4 = -1;
        } else {
            i4 = -16777216;
        }
        imageView.setColorFilter(i4);
    }

    private void f() {
        int i4;
        ImageView imageView = this.f38069b;
        if (this.f38071d) {
            i4 = 0;
        } else {
            i4 = 4;
        }
        imageView.setVisibility(i4);
        setItemCheckmarkAttributes(1.0f);
    }

    private void g() {
        setForeground(d());
        setBackground(c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemCheckmarkAttributes(float f4) {
        this.f38069b.setAlpha(f4);
        this.f38069b.setScaleX(f4);
        this.f38069b.setScaleY(f4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f38068a.post(new SelectedColorChangedEvent(this.f38070c));
    }

    @Subscribe
    public void onSelectedColorChanged(SelectedColorChangedEvent selectedColorChangedEvent) {
        boolean z3;
        if (selectedColorChangedEvent.getSelectedColor() == this.f38070c) {
            z3 = true;
        } else {
            z3 = false;
        }
        setChecked(z3);
    }

    public void setChecked(boolean z3) {
        boolean z4 = this.f38071d;
        this.f38071d = z3;
        if (!z4 && z3) {
            setItemCheckmarkAttributes(0.0f);
            this.f38069b.setVisibility(0);
            this.f38069b.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(250L).setListener(new a()).start();
        } else if (z4 && !z3) {
            this.f38069b.setVisibility(0);
            setItemCheckmarkAttributes(1.0f);
            this.f38069b.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setDuration(250L).setListener(new b()).start();
        } else {
            f();
        }
    }

    public void setOutlineWidth(int i4) {
        this.f38072e = i4;
        g();
    }

    public ColorItem(Context context) {
        super(context);
        this.f38071d = false;
        this.f38072e = 0;
        e();
    }

    public ColorItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38071d = false;
        this.f38072e = 0;
        e();
    }
}
