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
public class SparkButton2 extends FrameLayout implements View.OnClickListener {

    /* renamed from: r  reason: collision with root package name */
    private static final DecelerateInterpolator f38314r = new DecelerateInterpolator();

    /* renamed from: s  reason: collision with root package name */
    private static final AccelerateDecelerateInterpolator f38315s = new AccelerateDecelerateInterpolator();

    /* renamed from: t  reason: collision with root package name */
    private static final OvershootInterpolator f38316t = new OvershootInterpolator(4.0f);

    /* renamed from: a  reason: collision with root package name */
    int f38317a;

    /* renamed from: b  reason: collision with root package name */
    int f38318b;

    /* renamed from: c  reason: collision with root package name */
    int f38319c;

    /* renamed from: d  reason: collision with root package name */
    int f38320d;

    /* renamed from: e  reason: collision with root package name */
    int f38321e;

    /* renamed from: f  reason: collision with root package name */
    int f38322f;

    /* renamed from: g  reason: collision with root package name */
    int f38323g;

    /* renamed from: h  reason: collision with root package name */
    int f38324h;

    /* renamed from: i  reason: collision with root package name */
    int f38325i;

    /* renamed from: j  reason: collision with root package name */
    DotsView f38326j;

    /* renamed from: k  reason: collision with root package name */
    CircleView f38327k;

    /* renamed from: l  reason: collision with root package name */
    ImageView f38328l;

    /* renamed from: m  reason: collision with root package name */
    boolean f38329m;

    /* renamed from: n  reason: collision with root package name */
    float f38330n;

    /* renamed from: o  reason: collision with root package name */
    boolean f38331o;

    /* renamed from: p  reason: collision with root package name */
    private AnimatorSet f38332p;

    /* renamed from: q  reason: collision with root package name */
    private SparkEventListener f38333q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            SparkButton2.this.f38327k.setInnerCircleRadiusProgress(0.0f);
            SparkButton2.this.f38327k.setOuterCircleRadiusProgress(0.0f);
            SparkButton2.this.f38326j.setCurrentProgress(0.0f);
            SparkButton2.this.f38328l.setScaleX(1.0f);
            SparkButton2.this.f38328l.setScaleY(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (SparkButton2.this.f38333q != null) {
                SparkEventListener sparkEventListener = SparkButton2.this.f38333q;
                SparkButton2 sparkButton2 = SparkButton2.this;
                sparkEventListener.onEventAnimationEnd(sparkButton2.f38328l, sparkButton2.f38331o);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationEnd(animator);
            if (SparkButton2.this.f38333q != null) {
                SparkEventListener sparkEventListener = SparkButton2.this.f38333q;
                SparkButton2 sparkButton2 = SparkButton2.this;
                sparkEventListener.onEventAnimationStart(sparkButton2.f38328l, sparkButton2.f38331o);
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
                        SparkButton2.this.f38328l.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(SparkButton2.f38314r);
                    }
                } else {
                    SparkButton2.this.f38328l.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(SparkButton2.f38314r);
                    if (SparkButton2.this.isPressed()) {
                        SparkButton2.this.performClick();
                        SparkButton2.this.setPressed(false);
                    }
                }
            } else {
                SparkButton2.this.f38328l.animate().scaleX(0.8f).scaleY(0.8f).setDuration(150L).setInterpolator(SparkButton2.f38314r);
                SparkButton2.this.setPressed(true);
            }
            return true;
        }
    }

    public SparkButton2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38317a = -1;
        this.f38318b = -1;
        this.f38329m = true;
        this.f38330n = 1.0f;
        this.f38331o = false;
        c(attributeSet);
        d();
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.sparkbutton);
        this.f38319c = obtainStyledAttributes.getDimensionPixelOffset(3, Utils.dpToPx(getContext(), 50));
        this.f38317a = obtainStyledAttributes.getResourceId(0, -1);
        this.f38318b = obtainStyledAttributes.getResourceId(4, -1);
        this.f38323g = ContextCompat.getColor(getContext(), obtainStyledAttributes.getResourceId(7, com.arlosoft.macrodroid.R.color.spark_primary_color));
        this.f38322f = ContextCompat.getColor(getContext(), obtainStyledAttributes.getResourceId(8, com.arlosoft.macrodroid.R.color.spark_secondary_color));
        this.f38324h = ContextCompat.getColor(getContext(), obtainStyledAttributes.getResourceId(1, com.arlosoft.macrodroid.R.color.spark_image_tint));
        this.f38325i = ContextCompat.getColor(getContext(), obtainStyledAttributes.getResourceId(5, com.arlosoft.macrodroid.R.color.spark_image_tint));
        this.f38329m = obtainStyledAttributes.getBoolean(6, true);
        this.f38330n = obtainStyledAttributes.getFloat(2, 1.0f);
        obtainStyledAttributes.recycle();
    }

    private void e() {
        if (this.f38329m) {
            setOnTouchListener(new b());
        } else {
            setOnTouchListener(null);
        }
    }

    private void f() {
        this.f38327k.setColors(this.f38322f, this.f38323g);
        this.f38326j.setColors(this.f38322f, this.f38323g);
    }

    void d() {
        int i4 = this.f38319c;
        this.f38321e = (int) (i4 * 1.4f);
        this.f38320d = (int) (i4 * 3.0f);
        LayoutInflater.from(getContext()).inflate(com.arlosoft.macrodroid.R.layout.layout_spark_button, (ViewGroup) this, true);
        CircleView circleView = (CircleView) findViewById(com.arlosoft.macrodroid.R.id.vCircle);
        this.f38327k = circleView;
        circleView.setColors(this.f38322f, this.f38323g);
        this.f38327k.getLayoutParams().height = this.f38321e;
        this.f38327k.getLayoutParams().width = this.f38321e;
        DotsView dotsView = (DotsView) findViewById(com.arlosoft.macrodroid.R.id.vDotsView);
        this.f38326j = dotsView;
        dotsView.getLayoutParams().width = this.f38320d;
        this.f38326j.getLayoutParams().height = this.f38320d;
        this.f38326j.setColors(this.f38322f, this.f38323g);
        this.f38326j.setMaxDotSize((int) (this.f38319c * 0.08f));
        ImageView imageView = (ImageView) findViewById(com.arlosoft.macrodroid.R.id.ivImage);
        this.f38328l = imageView;
        imageView.getLayoutParams().height = this.f38319c;
        this.f38328l.getLayoutParams().width = this.f38319c;
        int i5 = this.f38318b;
        if (i5 != -1) {
            this.f38328l.setImageResource(i5);
            this.f38328l.setColorFilter(this.f38325i, PorterDuff.Mode.SRC_ATOP);
        } else {
            int i6 = this.f38317a;
            if (i6 != -1) {
                this.f38328l.setImageResource(i6);
                this.f38328l.setColorFilter(this.f38324h, PorterDuff.Mode.SRC_ATOP);
            } else {
                throw new IllegalArgumentException("One of Inactive/Active Image Resources are required!!");
            }
        }
        e();
        setOnClickListener(this);
    }

    public boolean isChecked() {
        return this.f38331o;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i4;
        int i5 = this.f38318b;
        if (i5 != -1) {
            boolean z3 = !this.f38331o;
            this.f38331o = z3;
            ImageView imageView = this.f38328l;
            if (z3) {
                i5 = this.f38317a;
            }
            imageView.setImageResource(i5);
            ImageView imageView2 = this.f38328l;
            if (this.f38331o) {
                i4 = this.f38324h;
            } else {
                i4 = this.f38325i;
            }
            imageView2.setColorFilter(i4, PorterDuff.Mode.SRC_ATOP);
            AnimatorSet animatorSet = this.f38332p;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (this.f38331o) {
                this.f38327k.setVisibility(0);
                this.f38326j.setVisibility(0);
                playAnimation();
            } else {
                this.f38326j.setVisibility(4);
                this.f38327k.setVisibility(8);
            }
        } else {
            playAnimation();
        }
        SparkEventListener sparkEventListener = this.f38333q;
        if (sparkEventListener != null) {
            sparkEventListener.onEvent(this.f38328l, this.f38331o);
        }
    }

    public void playAnimation() {
        AnimatorSet animatorSet = this.f38332p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f38328l.animate().cancel();
        this.f38328l.setScaleX(0.0f);
        this.f38328l.setScaleY(0.0f);
        this.f38327k.setInnerCircleRadiusProgress(0.0f);
        this.f38327k.setOuterCircleRadiusProgress(0.0f);
        this.f38326j.setCurrentProgress(0.0f);
        this.f38332p = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f38327k, CircleView.OUTER_CIRCLE_RADIUS_PROGRESS, 0.1f, 1.0f);
        ofFloat.setDuration(250.0f / this.f38330n);
        DecelerateInterpolator decelerateInterpolator = f38314r;
        ofFloat.setInterpolator(decelerateInterpolator);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f38327k, CircleView.INNER_CIRCLE_RADIUS_PROGRESS, 0.1f, 1.0f);
        ofFloat2.setDuration(200.0f / this.f38330n);
        ofFloat2.setStartDelay(200.0f / this.f38330n);
        ofFloat2.setInterpolator(decelerateInterpolator);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f38328l, ImageView.SCALE_Y, 0.2f, 1.0f);
        ofFloat3.setDuration(350.0f / this.f38330n);
        ofFloat3.setStartDelay(250.0f / this.f38330n);
        OvershootInterpolator overshootInterpolator = f38316t;
        ofFloat3.setInterpolator(overshootInterpolator);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f38328l, ImageView.SCALE_X, 0.2f, 1.0f);
        ofFloat4.setDuration(350.0f / this.f38330n);
        ofFloat4.setStartDelay(250.0f / this.f38330n);
        ofFloat4.setInterpolator(overshootInterpolator);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f38326j, DotsView.DOTS_PROGRESS, 0.0f, 1.0f);
        ofFloat5.setDuration(900.0f / this.f38330n);
        ofFloat5.setStartDelay(50.0f / this.f38330n);
        ofFloat5.setInterpolator(f38315s);
        this.f38332p.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        this.f38327k.setVisibility(8);
        this.f38332p.addListener(new a());
        this.f38332p.start();
    }

    public void pressOnTouch(boolean z3) {
        this.f38329m = z3;
        d();
    }

    public void setActiveImage(int i4) {
        this.f38317a = i4;
        ImageView imageView = this.f38328l;
        if (!this.f38331o) {
            i4 = this.f38318b;
        }
        imageView.setImageResource(i4);
    }

    public void setAnimationSpeed(float f4) {
        this.f38330n = f4;
    }

    public void setChecked(boolean z3) {
        int i4;
        int i5;
        this.f38331o = z3;
        ImageView imageView = this.f38328l;
        if (z3) {
            i4 = this.f38317a;
        } else {
            i4 = this.f38318b;
        }
        imageView.setImageResource(i4);
        ImageView imageView2 = this.f38328l;
        if (this.f38331o) {
            i5 = this.f38324h;
        } else {
            i5 = this.f38325i;
        }
        imageView2.setColorFilter(i5, PorterDuff.Mode.SRC_ATOP);
    }

    public void setColors(int i4, int i5) {
        this.f38322f = i4;
        this.f38323g = i5;
        f();
    }

    public void setEventListener(SparkEventListener sparkEventListener) {
        this.f38333q = sparkEventListener;
    }

    public void setInactiveImage(int i4) {
        this.f38318b = i4;
        ImageView imageView = this.f38328l;
        if (this.f38331o) {
            i4 = this.f38317a;
        }
        imageView.setImageResource(i4);
    }

    public SparkButton2(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f38317a = -1;
        this.f38318b = -1;
        this.f38329m = true;
        this.f38330n = 1.0f;
        this.f38331o = false;
        c(attributeSet);
        d();
    }

    @TargetApi(21)
    public SparkButton2(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f38317a = -1;
        this.f38318b = -1;
        this.f38329m = true;
        this.f38330n = 1.0f;
        this.f38331o = false;
        c(attributeSet);
        d();
    }
}
