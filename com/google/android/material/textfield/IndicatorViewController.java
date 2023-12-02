package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class IndicatorViewController {

    /* renamed from: a  reason: collision with root package name */
    private final Context f24599a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f24600b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f24601c;

    /* renamed from: d  reason: collision with root package name */
    private int f24602d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f24603e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Animator f24604f;

    /* renamed from: g  reason: collision with root package name */
    private final float f24605g;

    /* renamed from: h  reason: collision with root package name */
    private int f24606h;

    /* renamed from: i  reason: collision with root package name */
    private int f24607i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f24608j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24609k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private TextView f24610l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f24611m;

    /* renamed from: n  reason: collision with root package name */
    private int f24612n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f24613o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f24614p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f24615q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private TextView f24616r;

    /* renamed from: s  reason: collision with root package name */
    private int f24617s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f24618t;

    /* renamed from: u  reason: collision with root package name */
    private Typeface f24619u;

    public IndicatorViewController(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f24599a = context;
        this.f24600b = textInputLayout;
        this.f24605g = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    private void A(int i4, int i5) {
        TextView l4;
        TextView l5;
        if (i4 == i5) {
            return;
        }
        if (i5 != 0 && (l5 = l(i5)) != null) {
            l5.setVisibility(0);
            l5.setAlpha(1.0f);
        }
        if (i4 != 0 && (l4 = l(i4)) != null) {
            l4.setVisibility(4);
            if (i4 == 1) {
                l4.setText((CharSequence) null);
            }
        }
        this.f24606h = i5;
    }

    private void I(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void K(@NonNull ViewGroup viewGroup, int i4) {
        if (i4 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean L(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        if (ViewCompat.isLaidOut(this.f24600b) && this.f24600b.isEnabled() && (this.f24607i != this.f24606h || textView == null || !TextUtils.equals(textView.getText(), charSequence))) {
            return true;
        }
        return false;
    }

    private void O(final int i4, final int i5, boolean z3) {
        if (i4 == i5) {
            return;
        }
        if (z3) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f24604f = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.f24615q, this.f24616r, 2, i4, i5);
            h(arrayList, this.f24609k, this.f24610l, 1, i4, i5);
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            final TextView l4 = l(i4);
            final TextView l5 = l(i5);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.IndicatorViewController.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IndicatorViewController.this.f24606h = i5;
                    IndicatorViewController.this.f24604f = null;
                    TextView textView = l4;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (i4 == 1 && IndicatorViewController.this.f24610l != null) {
                            IndicatorViewController.this.f24610l.setText((CharSequence) null);
                        }
                    }
                    TextView textView2 = l5;
                    if (textView2 != null) {
                        textView2.setTranslationY(0.0f);
                        l5.setAlpha(1.0f);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    TextView textView = l5;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else {
            A(i4, i5);
        }
        this.f24600b.k0();
        this.f24600b.n0(z3);
        this.f24600b.x0();
    }

    private boolean f() {
        if (this.f24601c != null && this.f24600b.getEditText() != null) {
            return true;
        }
        return false;
    }

    private void h(@NonNull List<Animator> list, boolean z3, @Nullable TextView textView, int i4, int i5, int i6) {
        boolean z4;
        if (textView != null && z3) {
            if (i4 == i6 || i4 == i5) {
                if (i6 == i4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                list.add(i(textView, z4));
                if (i6 == i4) {
                    list.add(j(textView));
                }
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z3) {
        float f4;
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, f4);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f24605g, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return ofFloat;
    }

    @Nullable
    private TextView l(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return null;
            }
            return this.f24616r;
        }
        return this.f24610l;
    }

    private int s(boolean z3, @DimenRes int i4, int i5) {
        if (z3) {
            return this.f24599a.getResources().getDimensionPixelSize(i4);
        }
        return i5;
    }

    private boolean v(int i4) {
        if (i4 == 1 && this.f24610l != null && !TextUtils.isEmpty(this.f24608j)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(@Nullable CharSequence charSequence) {
        this.f24611m = charSequence;
        TextView textView = this.f24610l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(boolean z3) {
        if (this.f24609k == z3) {
            return;
        }
        g();
        if (z3) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f24599a);
            this.f24610l = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            this.f24610l.setTextAlignment(5);
            Typeface typeface = this.f24619u;
            if (typeface != null) {
                this.f24610l.setTypeface(typeface);
            }
            D(this.f24612n);
            E(this.f24613o);
            B(this.f24611m);
            this.f24610l.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f24610l, 1);
            d(this.f24610l, 0);
        } else {
            t();
            z(this.f24610l, 0);
            this.f24610l = null;
            this.f24600b.k0();
            this.f24600b.x0();
        }
        this.f24609k = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(@StyleRes int i4) {
        this.f24612n = i4;
        TextView textView = this.f24610l;
        if (textView != null) {
            this.f24600b.X(textView, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(@Nullable ColorStateList colorStateList) {
        this.f24613o = colorStateList;
        TextView textView = this.f24610l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(@StyleRes int i4) {
        this.f24617s = i4;
        TextView textView = this.f24616r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z3) {
        if (this.f24615q == z3) {
            return;
        }
        g();
        if (z3) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f24599a);
            this.f24616r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            this.f24616r.setTextAlignment(5);
            Typeface typeface = this.f24619u;
            if (typeface != null) {
                this.f24616r.setTypeface(typeface);
            }
            this.f24616r.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f24616r, 1);
            F(this.f24617s);
            H(this.f24618t);
            d(this.f24616r, 1);
        } else {
            u();
            z(this.f24616r, 1);
            this.f24616r = null;
            this.f24600b.k0();
            this.f24600b.x0();
        }
        this.f24615q = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(@Nullable ColorStateList colorStateList) {
        this.f24618t = colorStateList;
        TextView textView = this.f24616r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(Typeface typeface) {
        if (typeface != this.f24619u) {
            this.f24619u = typeface;
            I(this.f24610l, typeface);
            I(this.f24616r, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(CharSequence charSequence) {
        g();
        this.f24608j = charSequence;
        this.f24610l.setText(charSequence);
        int i4 = this.f24606h;
        if (i4 != 1) {
            this.f24607i = 1;
        }
        O(i4, this.f24607i, L(this.f24610l, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(CharSequence charSequence) {
        g();
        this.f24614p = charSequence;
        this.f24616r.setText(charSequence);
        int i4 = this.f24606h;
        if (i4 != 2) {
            this.f24607i = 2;
        }
        O(i4, this.f24607i, L(this.f24616r, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView, int i4) {
        if (this.f24601c == null && this.f24603e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f24599a);
            this.f24601c = linearLayout;
            linearLayout.setOrientation(0);
            this.f24600b.addView(this.f24601c, -1, -2);
            this.f24603e = new FrameLayout(this.f24599a);
            this.f24601c.addView(this.f24603e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f24600b.getEditText() != null) {
                e();
            }
        }
        if (w(i4)) {
            this.f24603e.setVisibility(0);
            this.f24603e.addView(textView);
        } else {
            this.f24601c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f24601c.setVisibility(0);
        this.f24602d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            EditText editText = this.f24600b.getEditText();
            boolean isFontScaleAtLeast1_3 = MaterialResources.isFontScaleAtLeast1_3(this.f24599a);
            LinearLayout linearLayout = this.f24601c;
            int i4 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
            ViewCompat.setPaddingRelative(linearLayout, s(isFontScaleAtLeast1_3, i4, ViewCompat.getPaddingStart(editText)), s(isFontScaleAtLeast1_3, R.dimen.material_helper_text_font_1_3_padding_top, this.f24599a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), s(isFontScaleAtLeast1_3, i4, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    void g() {
        Animator animator = this.f24604f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return v(this.f24607i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CharSequence m() {
        return this.f24611m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CharSequence n() {
        return this.f24608j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public int o() {
        TextView textView = this.f24610l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList p() {
        TextView textView = this.f24610l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence q() {
        return this.f24614p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public int r() {
        TextView textView = this.f24616r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.f24608j = null;
        g();
        if (this.f24606h == 1) {
            if (this.f24615q && !TextUtils.isEmpty(this.f24614p)) {
                this.f24607i = 2;
            } else {
                this.f24607i = 0;
            }
        }
        O(this.f24606h, this.f24607i, L(this.f24610l, null));
    }

    void u() {
        g();
        int i4 = this.f24606h;
        if (i4 == 2) {
            this.f24607i = 0;
        }
        O(i4, this.f24607i, L(this.f24616r, null));
    }

    boolean w(int i4) {
        if (i4 == 0 || i4 == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.f24609k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.f24615q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(TextView textView, int i4) {
        FrameLayout frameLayout;
        if (this.f24601c == null) {
            return;
        }
        if (w(i4) && (frameLayout = this.f24603e) != null) {
            frameLayout.removeView(textView);
        } else {
            this.f24601c.removeView(textView);
        }
        int i5 = this.f24602d - 1;
        this.f24602d = i5;
        K(this.f24601c, i5);
    }
}
