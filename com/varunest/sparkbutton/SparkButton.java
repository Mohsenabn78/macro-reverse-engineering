package com.varunest.sparkbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.varunest.sparkbutton.helpers.CircleView;
import com.varunest.sparkbutton.helpers.DotsView;
import com.varunest.sparkbutton.helpers.Utils;

/* loaded from: classes6.dex */
public class SparkButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: r  reason: collision with root package name */
    private static final DecelerateInterpolator f38292r = new DecelerateInterpolator();

    /* renamed from: s  reason: collision with root package name */
    private static final AccelerateDecelerateInterpolator f38293s = new AccelerateDecelerateInterpolator();

    /* renamed from: t  reason: collision with root package name */
    private static final OvershootInterpolator f38294t = new OvershootInterpolator(4.0f);

    /* renamed from: a  reason: collision with root package name */
    int f38295a;

    /* renamed from: b  reason: collision with root package name */
    int f38296b;

    /* renamed from: c  reason: collision with root package name */
    int f38297c;

    /* renamed from: d  reason: collision with root package name */
    int f38298d;

    /* renamed from: e  reason: collision with root package name */
    int f38299e;

    /* renamed from: f  reason: collision with root package name */
    int f38300f;

    /* renamed from: g  reason: collision with root package name */
    int f38301g;

    /* renamed from: h  reason: collision with root package name */
    int f38302h;

    /* renamed from: i  reason: collision with root package name */
    int f38303i;

    /* renamed from: j  reason: collision with root package name */
    DotsView f38304j;

    /* renamed from: k  reason: collision with root package name */
    CircleView f38305k;

    /* renamed from: l  reason: collision with root package name */
    ImageView f38306l;

    /* renamed from: m  reason: collision with root package name */
    boolean f38307m;

    /* renamed from: n  reason: collision with root package name */
    float f38308n;

    /* renamed from: o  reason: collision with root package name */
    boolean f38309o;

    /* renamed from: p  reason: collision with root package name */
    private AnimatorSet f38310p;

    /* renamed from: q  reason: collision with root package name */
    private SparkEventListener f38311q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            SparkButton.this.f38305k.setInnerCircleRadiusProgress(0.0f);
            SparkButton.this.f38305k.setOuterCircleRadiusProgress(0.0f);
            SparkButton.this.f38304j.setCurrentProgress(0.0f);
            SparkButton.this.f38306l.setScaleX(1.0f);
            SparkButton.this.f38306l.setScaleY(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (SparkButton.this.f38311q != null) {
                SparkEventListener sparkEventListener = SparkButton.this.f38311q;
                SparkButton sparkButton = SparkButton.this;
                sparkEventListener.onEventAnimationEnd(sparkButton.f38306l, sparkButton.f38309o);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationEnd(animator);
            if (SparkButton.this.f38311q != null) {
                SparkEventListener sparkEventListener = SparkButton.this.f38311q;
                SparkButton sparkButton = SparkButton.this;
                sparkEventListener.onEventAnimationStart(sparkButton.f38306l, sparkButton.f38309o);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        SparkButton.this.f38306l.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(SparkButton.f38292r);
                    }
                } else {
                    SparkButton.this.f38306l.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(SparkButton.f38292r);
                    if (SparkButton.this.isPressed()) {
                        SparkButton.this.performClick();
                        SparkButton.this.setPressed(false);
                    }
                }
            } else {
                SparkButton.this.f38306l.animate().scaleX(0.8f).scaleY(0.8f).setDuration(150L).setInterpolator(SparkButton.f38292r);
                SparkButton.this.setPressed(true);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparkButton(Context context) {
        super(context);
        this.f38295a = -1;
        this.f38296b = -1;
        this.f38307m = true;
        this.f38308n = 1.0f;
        this.f38309o = false;
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.sparkbutton);
        this.f38297c = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.sparkbutton_sparkbutton_iconSize, Utils.dpToPx(getContext(), 50));
        this.f38295a = obtainStyledAttributes.getResourceId(R.styleable.sparkbutton_sparkbutton_activeImage, -1);
        this.f38296b = obtainStyledAttributes.getResourceId(R.styleable.sparkbutton_sparkbutton_inActiveImage, -1);
        this.f38301g = ContextCompat.getColor(getContext(), obtainStyledAttributes.getResourceId(R.styleable.sparkbutton_sparkbutton_primaryColor, R.color.spark_primary_color));
        this.f38300f = ContextCompat.getColor(getContext(), obtainStyledAttributes.getResourceId(R.styleable.sparkbutton_sparkbutton_secondaryColor, R.color.spark_secondary_color));
        Context context = getContext();
        int i4 = R.styleable.sparkbutton_sparkbutton_activeImageTint;
        int i5 = R.color.spark_image_tint;
        this.f38302h = ContextCompat.getColor(context, obtainStyledAttributes.getResourceId(i4, i5));
        this.f38303i = ContextCompat.getColor(getContext(), obtainStyledAttributes.getResourceId(R.styleable.sparkbutton_sparkbutton_inActiveImageTint, i5));
        this.f38307m = obtainStyledAttributes.getBoolean(R.styleable.sparkbutton_sparkbutton_pressOnTouch, true);
        this.f38308n = obtainStyledAttributes.getFloat(R.styleable.sparkbutton_sparkbutton_animationSpeed, 1.0f);
        obtainStyledAttributes.recycle();
    }

    private void e() {
        if (this.f38307m) {
            setOnTouchListener(new b());
        } else {
            setOnTouchListener(null);
        }
    }

    private void f() {
        this.f38305k.setColors(this.f38300f, this.f38301g);
        this.f38304j.setColors(this.f38300f, this.f38301g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        int i4 = this.f38297c;
        this.f38299e = (int) (i4 * 1.4f);
        this.f38298d = (int) (i4 * 3.0f);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_spark_button, (ViewGroup) this, true);
        CircleView circleView = (CircleView) findViewById(R.id.vCircle);
        this.f38305k = circleView;
        circleView.setColors(this.f38300f, this.f38301g);
        this.f38305k.getLayoutParams().height = this.f38299e;
        this.f38305k.getLayoutParams().width = this.f38299e;
        DotsView dotsView = (DotsView) findViewById(R.id.vDotsView);
        this.f38304j = dotsView;
        dotsView.getLayoutParams().width = this.f38298d;
        this.f38304j.getLayoutParams().height = this.f38298d;
        this.f38304j.setColors(this.f38300f, this.f38301g);
        this.f38304j.setMaxDotSize((int) (this.f38297c * 0.08f));
        ImageView imageView = (ImageView) findViewById(R.id.ivImage);
        this.f38306l = imageView;
        imageView.getLayoutParams().height = this.f38297c;
        this.f38306l.getLayoutParams().width = this.f38297c;
        int i5 = this.f38296b;
        if (i5 != -1) {
            this.f38306l.setImageResource(i5);
            this.f38306l.setColorFilter(this.f38303i, PorterDuff.Mode.SRC_ATOP);
        } else {
            int i6 = this.f38295a;
            if (i6 != -1) {
                this.f38306l.setImageResource(i6);
                this.f38306l.setColorFilter(this.f38302h, PorterDuff.Mode.SRC_ATOP);
            } else {
                throw new IllegalArgumentException("One of Inactive/Active Image Resources are required!!");
            }
        }
        e();
        setOnClickListener(this);
    }

    public boolean isChecked() {
        return this.f38309o;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i4;
        int i5 = this.f38296b;
        if (i5 != -1) {
            boolean z3 = !this.f38309o;
            this.f38309o = z3;
            ImageView imageView = this.f38306l;
            if (z3) {
                i5 = this.f38295a;
            }
            imageView.setImageResource(i5);
            ImageView imageView2 = this.f38306l;
            if (this.f38309o) {
                i4 = this.f38302h;
            } else {
                i4 = this.f38303i;
            }
            imageView2.setColorFilter(i4, PorterDuff.Mode.SRC_ATOP);
            AnimatorSet animatorSet = this.f38310p;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (this.f38309o) {
                this.f38305k.setVisibility(0);
                this.f38304j.setVisibility(0);
                playAnimation();
            } else {
                this.f38304j.setVisibility(4);
                this.f38305k.setVisibility(8);
            }
        } else {
            playAnimation();
        }
        SparkEventListener sparkEventListener = this.f38311q;
        if (sparkEventListener != null) {
            sparkEventListener.onEvent(this.f38306l, this.f38309o);
        }
    }

    public void playAnimation() {
        AnimatorSet animatorSet = this.f38310p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f38306l.animate().cancel();
        this.f38306l.setScaleX(0.0f);
        this.f38306l.setScaleY(0.0f);
        this.f38305k.setInnerCircleRadiusProgress(0.0f);
        this.f38305k.setOuterCircleRadiusProgress(0.0f);
        this.f38304j.setCurrentProgress(0.0f);
        this.f38310p = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f38305k, CircleView.OUTER_CIRCLE_RADIUS_PROGRESS, 0.1f, 1.0f);
        ofFloat.setDuration(250.0f / this.f38308n);
        DecelerateInterpolator decelerateInterpolator = f38292r;
        ofFloat.setInterpolator(decelerateInterpolator);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f38305k, CircleView.INNER_CIRCLE_RADIUS_PROGRESS, 0.1f, 1.0f);
        ofFloat2.setDuration(200.0f / this.f38308n);
        ofFloat2.setStartDelay(200.0f / this.f38308n);
        ofFloat2.setInterpolator(decelerateInterpolator);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f38306l, ImageView.SCALE_Y, 0.2f, 1.0f);
        ofFloat3.setDuration(350.0f / this.f38308n);
        ofFloat3.setStartDelay(250.0f / this.f38308n);
        OvershootInterpolator overshootInterpolator = f38294t;
        ofFloat3.setInterpolator(overshootInterpolator);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f38306l, ImageView.SCALE_X, 0.2f, 1.0f);
        ofFloat4.setDuration(350.0f / this.f38308n);
        ofFloat4.setStartDelay(250.0f / this.f38308n);
        ofFloat4.setInterpolator(overshootInterpolator);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f38304j, DotsView.DOTS_PROGRESS, 0.0f, 1.0f);
        ofFloat5.setDuration(900.0f / this.f38308n);
        ofFloat5.setStartDelay(50.0f / this.f38308n);
        ofFloat5.setInterpolator(f38293s);
        this.f38310p.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        this.f38310p.addListener(new a());
        this.f38310p.start();
    }

    public void pressOnTouch(boolean z3) {
        this.f38307m = z3;
        d();
    }

    public void setActiveImage(int i4) {
        this.f38295a = i4;
        ImageView imageView = this.f38306l;
        if (!this.f38309o) {
            i4 = this.f38296b;
        }
        imageView.setImageResource(i4);
    }

    public void setAnimationSpeed(float f4) {
        this.f38308n = f4;
    }

    public void setChecked(boolean z3) {
        int i4;
        int i5;
        this.f38309o = z3;
        ImageView imageView = this.f38306l;
        if (z3) {
            i4 = this.f38295a;
        } else {
            i4 = this.f38296b;
        }
        imageView.setImageResource(i4);
        ImageView imageView2 = this.f38306l;
        if (this.f38309o) {
            i5 = this.f38302h;
        } else {
            i5 = this.f38303i;
        }
        imageView2.setColorFilter(i5, PorterDuff.Mode.SRC_ATOP);
    }

    public void setColors(int i4, int i5) {
        this.f38300f = i4;
        this.f38301g = i5;
        f();
    }

    public void setEventListener(SparkEventListener sparkEventListener) {
        this.f38311q = sparkEventListener;
    }

    public void setInactiveImage(int i4) {
        this.f38296b = i4;
        ImageView imageView = this.f38306l;
        if (this.f38309o) {
            i4 = this.f38295a;
        }
        imageView.setImageResource(i4);
    }

    public SparkButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38295a = -1;
        this.f38296b = -1;
        this.f38307m = true;
        this.f38308n = 1.0f;
        this.f38309o = false;
        c(attributeSet);
        d();
    }

    public SparkButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f38295a = -1;
        this.f38296b = -1;
        this.f38307m = true;
        this.f38308n = 1.0f;
        this.f38309o = false;
        c(attributeSet);
        d();
    }

    @TargetApi(21)
    public SparkButton(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f38295a = -1;
        this.f38296b = -1;
        this.f38307m = true;
        this.f38308n = 1.0f;
        this.f38309o = false;
        c(attributeSet);
        d();
    }
}
