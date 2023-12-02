package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f24363a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f24364b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    protected final SnackbarBaseLayout f24365c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.snackbar.ContentViewCallback f24366d;

    /* renamed from: e  reason: collision with root package name */
    private int f24367e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24368f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Anchor f24369g;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Rect f24372j;

    /* renamed from: k  reason: collision with root package name */
    private int f24373k;

    /* renamed from: l  reason: collision with root package name */
    private int f24374l;

    /* renamed from: m  reason: collision with root package name */
    private int f24375m;

    /* renamed from: n  reason: collision with root package name */
    private int f24376n;

    /* renamed from: o  reason: collision with root package name */
    private int f24377o;

    /* renamed from: p  reason: collision with root package name */
    private List<BaseCallback<B>> f24378p;

    /* renamed from: q  reason: collision with root package name */
    private Behavior f24379q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private final AccessibilityManager f24380r;

    /* renamed from: u  reason: collision with root package name */
    private static final boolean f24360u = false;

    /* renamed from: v  reason: collision with root package name */
    private static final int[] f24361v = {R.attr.snackbarStyle};

    /* renamed from: w  reason: collision with root package name */
    private static final String f24362w = BaseTransientBottomBar.class.getSimpleName();
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    static final Handler f24359t = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i4 = message.what;
            if (i4 != 0) {
                if (i4 != 1) {
                    return false;
                }
                ((BaseTransientBottomBar) message.obj).D(message.arg1);
                return true;
            }
            ((BaseTransientBottomBar) message.obj).L();
            return true;
        }
    });

    /* renamed from: h  reason: collision with root package name */
    private boolean f24370h = false;
    @RequiresApi(29)

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f24371i = new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
        @Override // java.lang.Runnable
        public void run() {
            int y3;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f24365c == null || baseTransientBottomBar.f24364b == null || (y3 = (BaseTransientBottomBar.this.y() - BaseTransientBottomBar.this.B()) + ((int) BaseTransientBottomBar.this.f24365c.getTranslationY())) >= BaseTransientBottomBar.this.f24376n) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f24365c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.f24362w, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f24376n - y3;
            BaseTransientBottomBar.this.f24365c.requestLayout();
        }
    };
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    SnackbarManager.Callback f24381s = new SnackbarManager.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void a(int i4) {
            Handler handler = BaseTransientBottomBar.f24359t;
            handler.sendMessage(handler.obtainMessage(1, i4, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void show() {
            Handler handler = BaseTransientBottomBar.f24359t;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<BaseTransientBottomBar> f24404a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<View> f24405b;

        private Anchor(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            this.f24404a = new WeakReference<>(baseTransientBottomBar);
            this.f24405b = new WeakReference<>(view);
        }

        static Anchor a(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            Anchor anchor = new Anchor(baseTransientBottomBar, view);
            if (ViewCompat.isAttachedToWindow(view)) {
                ViewUtils.addOnGlobalLayoutListener(view, anchor);
            }
            view.addOnAttachStateChangeListener(anchor);
            return anchor;
        }

        private boolean d() {
            if (this.f24404a.get() == null) {
                c();
                return true;
            }
            return false;
        }

        @Nullable
        View b() {
            return this.f24405b.get();
        }

        void c() {
            if (this.f24405b.get() != null) {
                this.f24405b.get().removeOnAttachStateChangeListener(this);
                ViewUtils.removeOnGlobalLayoutListener(this.f24405b.get(), this);
            }
            this.f24405b.clear();
            this.f24404a.clear();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d() && this.f24404a.get().f24370h) {
                this.f24404a.get().H();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (d()) {
                return;
            }
            ViewUtils.addOnGlobalLayoutListener(view, this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (d()) {
                return;
            }
            ViewUtils.removeOnGlobalLayoutListener(view, this);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface AnimationMode {
    }

    /* loaded from: classes5.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull

        /* renamed from: k  reason: collision with root package name */
        private final BehaviorDelegate f24406k = new BehaviorDelegate(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void g(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f24406k.setBaseTransientBottomBar(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return this.f24406k.canSwipeDismissView(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.f24406k.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public static class BehaviorDelegate {

        /* renamed from: a  reason: collision with root package name */
        private SnackbarManager.Callback f24407a;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
            swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
            swipeDismissBehavior.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.c().l(this.f24407a);
                }
            } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                SnackbarManager.c().k(this.f24407a);
            }
        }

        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f24407a = baseTransientBottomBar.f24381s;
        }
    }

    @Deprecated
    /* loaded from: classes5.dex */
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface Duration {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public interface OnLayoutChangeListener {
        void onLayoutChange(View view, int i4, int i5, int i6, int i7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: j  reason: collision with root package name */
        private static final View.OnTouchListener f24408j = new View.OnTouchListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private OnLayoutChangeListener f24409a;

        /* renamed from: b  reason: collision with root package name */
        private OnAttachStateChangeListener f24410b;

        /* renamed from: c  reason: collision with root package name */
        private int f24411c;

        /* renamed from: d  reason: collision with root package name */
        private final float f24412d;

        /* renamed from: e  reason: collision with root package name */
        private final float f24413e;

        /* renamed from: f  reason: collision with root package name */
        private final int f24414f;

        /* renamed from: g  reason: collision with root package name */
        private final int f24415g;

        /* renamed from: h  reason: collision with root package name */
        private ColorStateList f24416h;

        /* renamed from: i  reason: collision with root package name */
        private PorterDuff.Mode f24417i;

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(@NonNull Context context) {
            this(context, null);
        }

        @NonNull
        private Drawable a() {
            float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(MaterialColors.layer(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f24416h != null) {
                Drawable wrap = DrawableCompat.wrap(gradientDrawable);
                DrawableCompat.setTintList(wrap, this.f24416h);
                return wrap;
            }
            return DrawableCompat.wrap(gradientDrawable);
        }

        float getActionTextColorAlpha() {
            return this.f24413e;
        }

        int getAnimationMode() {
            return this.f24411c;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f24412d;
        }

        int getMaxInlineActionWidth() {
            return this.f24415g;
        }

        int getMaxWidth() {
            return this.f24414f;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.f24410b;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.f24410b;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
            super.onLayout(z3, i4, i5, i6, i7);
            OnLayoutChangeListener onLayoutChangeListener = this.f24409a;
            if (onLayoutChangeListener != null) {
                onLayoutChangeListener.onLayoutChange(this, i4, i5, i6, i7);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i4, int i5) {
            super.onMeasure(i4, i5);
            if (this.f24414f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i6 = this.f24414f;
                if (measuredWidth > i6) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i5);
                }
            }
        }

        void setAnimationMode(int i4) {
            this.f24411c = i4;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f24416h != null) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.f24416h);
                DrawableCompat.setTintMode(drawable, this.f24417i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f24416h = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(wrap, colorStateList);
                DrawableCompat.setTintMode(wrap, this.f24417i);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f24417i = mode;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(wrap, mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f24410b = onAttachStateChangeListener;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            View.OnTouchListener onTouchListener;
            if (onClickListener != null) {
                onTouchListener = null;
            } else {
                onTouchListener = f24408j;
            }
            setOnTouchListener(onTouchListener);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.f24409a = onLayoutChangeListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            int i4 = R.styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i4)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(i4, 0));
            }
            this.f24411c = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.f24412d = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f24413e = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f24414f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.f24415g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f24408j);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        if (viewGroup != null) {
            if (view != null) {
                if (contentViewCallback != null) {
                    this.f24363a = viewGroup;
                    this.f24366d = contentViewCallback;
                    this.f24364b = context;
                    ThemeEnforcement.checkAppCompatTheme(context);
                    SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(z(), viewGroup, false);
                    this.f24365c = snackbarBaseLayout;
                    if (view instanceof SnackbarContentLayout) {
                        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                        snackbarContentLayout.a(snackbarBaseLayout.getActionTextColorAlpha());
                        snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
                    }
                    snackbarBaseLayout.addView(view);
                    ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        this.f24372j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    }
                    ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
                    ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
                    ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
                    ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3
                        @Override // androidx.core.view.OnApplyWindowInsetsListener
                        @NonNull
                        public WindowInsetsCompat onApplyWindowInsets(View view2, @NonNull WindowInsetsCompat windowInsetsCompat) {
                            BaseTransientBottomBar.this.f24373k = windowInsetsCompat.getSystemWindowInsetBottom();
                            BaseTransientBottomBar.this.f24374l = windowInsetsCompat.getSystemWindowInsetLeft();
                            BaseTransientBottomBar.this.f24375m = windowInsetsCompat.getSystemWindowInsetRight();
                            BaseTransientBottomBar.this.R();
                            return windowInsetsCompat;
                        }
                    });
                    ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new AccessibilityDelegateCompat() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
                        @Override // androidx.core.view.AccessibilityDelegateCompat
                        public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                            super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                            accessibilityNodeInfoCompat.addAction(1048576);
                            accessibilityNodeInfoCompat.setDismissable(true);
                        }

                        @Override // androidx.core.view.AccessibilityDelegateCompat
                        public boolean performAccessibilityAction(View view2, int i4, Bundle bundle) {
                            if (i4 == 1048576) {
                                BaseTransientBottomBar.this.dismiss();
                                return true;
                            }
                            return super.performAccessibilityAction(view2, i4, bundle);
                        }
                    });
                    this.f24380r = (AccessibilityManager) context.getSystemService("accessibility");
                    return;
                }
                throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
            }
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }

    private int A() {
        int height = this.f24365c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f24365c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B() {
        int[] iArr = new int[2];
        this.f24365c.getLocationOnScreen(iArr);
        return iArr[1] + this.f24365c.getHeight();
    }

    private boolean E() {
        ViewGroup.LayoutParams layoutParams = this.f24365c.getLayoutParams();
        if ((layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f24377o = t();
        R();
    }

    private void I(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.f24379q;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = w();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).g(this);
        }
        swipeDismissBehavior.setListener(new SwipeDismissBehavior.OnDismissListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
            public void onDismiss(@NonNull View view) {
                if (view.getParent() != null) {
                    view.setVisibility(8);
                }
                BaseTransientBottomBar.this.u(0);
            }

            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
            public void onDragStateChanged(int i4) {
                if (i4 != 0) {
                    if (i4 == 1 || i4 == 2) {
                        SnackbarManager.c().k(BaseTransientBottomBar.this.f24381s);
                        return;
                    }
                    return;
                }
                SnackbarManager.c().l(BaseTransientBottomBar.this.f24381s);
            }
        });
        layoutParams.setBehavior(swipeDismissBehavior);
        if (getAnchorView() == null) {
            layoutParams.insetEdge = 80;
        }
    }

    private boolean K() {
        if (this.f24376n > 0 && !this.f24368f && E()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (J()) {
            r();
            return;
        }
        if (this.f24365c.getParent() != null) {
            this.f24365c.setVisibility(0);
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        ValueAnimator v3 = v(0.0f, 1.0f);
        ValueAnimator x3 = x(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(v3, x3);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.G();
            }
        });
        animatorSet.start();
    }

    private void O(final int i4) {
        ValueAnimator v3 = v(1.0f, 0.0f);
        v3.setDuration(75L);
        v3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.F(i4);
            }
        });
        v3.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        int A = A();
        if (f24360u) {
            ViewCompat.offsetTopAndBottom(this.f24365c, A);
        } else {
            this.f24365c.setTranslationY(A);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(A, 0);
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.14
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.G();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f24366d.animateContentIn(70, 180);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(A) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.15

            /* renamed from: a  reason: collision with root package name */
            private int f24388a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f24389b;

            {
                this.f24389b = A;
                this.f24388a = A;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f24360u) {
                    ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f24365c, intValue - this.f24388a);
                } else {
                    BaseTransientBottomBar.this.f24365c.setTranslationY(intValue);
                }
                this.f24388a = intValue;
            }
        });
        valueAnimator.start();
    }

    private void Q(final int i4) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, A());
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.16
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.F(i4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f24366d.animateContentOut(0, 180);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.17

            /* renamed from: a  reason: collision with root package name */
            private int f24393a = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f24360u) {
                    ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f24365c, intValue - this.f24393a);
                } else {
                    BaseTransientBottomBar.this.f24365c.setTranslationY(intValue);
                }
                this.f24393a = intValue;
            }
        });
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        int i4;
        ViewGroup.LayoutParams layoutParams = this.f24365c.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && this.f24372j != null) {
            if (getAnchorView() != null) {
                i4 = this.f24377o;
            } else {
                i4 = this.f24373k;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            Rect rect = this.f24372j;
            marginLayoutParams.bottomMargin = rect.bottom + i4;
            marginLayoutParams.leftMargin = rect.left + this.f24374l;
            marginLayoutParams.rightMargin = rect.right + this.f24375m;
            this.f24365c.requestLayout();
            if (Build.VERSION.SDK_INT >= 29 && K()) {
                this.f24365c.removeCallbacks(this.f24371i);
                this.f24365c.post(this.f24371i);
                return;
            }
            return;
        }
        Log.w(f24362w, "Unable to update margins because layout params are not MarginLayoutParams");
    }

    private void s(int i4) {
        if (this.f24365c.getAnimationMode() == 1) {
            O(i4);
        } else {
            Q(i4);
        }
    }

    private int t() {
        if (getAnchorView() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        getAnchorView().getLocationOnScreen(iArr);
        int i4 = iArr[1];
        int[] iArr2 = new int[2];
        this.f24363a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f24363a.getHeight()) - i4;
    }

    private ValueAnimator v(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.f24365c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator x(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BaseTransientBottomBar.this.f24365c.setScaleX(floatValue);
                BaseTransientBottomBar.this.f24365c.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(17)
    public int y() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f24364b.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    protected boolean C() {
        TypedArray obtainStyledAttributes = this.f24364b.obtainStyledAttributes(f24361v);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            return false;
        }
        return true;
    }

    final void D(int i4) {
        if (J() && this.f24365c.getVisibility() == 0) {
            s(i4);
        } else {
            F(i4);
        }
    }

    void F(int i4) {
        SnackbarManager.c().i(this.f24381s);
        List<BaseCallback<B>> list = this.f24378p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f24378p.get(size).onDismissed(this, i4);
            }
        }
        ViewParent parent = this.f24365c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f24365c);
        }
    }

    void G() {
        SnackbarManager.c().j(this.f24381s);
        List<BaseCallback<B>> list = this.f24378p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f24378p.get(size).onShown(this);
            }
        }
    }

    boolean J() {
        AccessibilityManager accessibilityManager = this.f24380r;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty()) {
            return true;
        }
        return false;
    }

    final void L() {
        this.f24365c.setOnAttachStateChangeListener(new OnAttachStateChangeListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                WindowInsets rootWindowInsets;
                Insets mandatorySystemGestureInsets;
                int i4;
                if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = BaseTransientBottomBar.this.f24365c.getRootWindowInsets()) != null) {
                    BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                    mandatorySystemGestureInsets = rootWindowInsets.getMandatorySystemGestureInsets();
                    i4 = mandatorySystemGestureInsets.bottom;
                    baseTransientBottomBar.f24376n = i4;
                    BaseTransientBottomBar.this.R();
                }
            }

            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (BaseTransientBottomBar.this.isShownOrQueued()) {
                    BaseTransientBottomBar.f24359t.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseTransientBottomBar.this.F(3);
                        }
                    });
                }
            }
        });
        if (this.f24365c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f24365c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                I((CoordinatorLayout.LayoutParams) layoutParams);
            }
            H();
            this.f24365c.setVisibility(4);
            this.f24363a.addView(this.f24365c);
        }
        if (ViewCompat.isLaidOut(this.f24365c)) {
            M();
        } else {
            this.f24365c.setOnLayoutChangeListener(new OnLayoutChangeListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.7
                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener
                public void onLayoutChange(View view, int i4, int i5, int i6, int i7) {
                    BaseTransientBottomBar.this.f24365c.setOnLayoutChangeListener(null);
                    BaseTransientBottomBar.this.M();
                }
            });
        }
    }

    @NonNull
    public B addCallback(@Nullable BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.f24378p == null) {
            this.f24378p = new ArrayList();
        }
        this.f24378p.add(baseCallback);
        return this;
    }

    public void dismiss() {
        u(3);
    }

    @Nullable
    public View getAnchorView() {
        Anchor anchor = this.f24369g;
        if (anchor == null) {
            return null;
        }
        return anchor.b();
    }

    public int getAnimationMode() {
        return this.f24365c.getAnimationMode();
    }

    public Behavior getBehavior() {
        return this.f24379q;
    }

    @NonNull
    public Context getContext() {
        return this.f24364b;
    }

    public int getDuration() {
        return this.f24367e;
    }

    @NonNull
    public View getView() {
        return this.f24365c;
    }

    public boolean isAnchorViewLayoutListenerEnabled() {
        return this.f24370h;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.f24368f;
    }

    public boolean isShown() {
        return SnackbarManager.c().e(this.f24381s);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.c().f(this.f24381s);
    }

    void r() {
        this.f24365c.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.9
            @Override // java.lang.Runnable
            public void run() {
                SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f24365c;
                if (snackbarBaseLayout == null) {
                    return;
                }
                if (snackbarBaseLayout.getParent() != null) {
                    BaseTransientBottomBar.this.f24365c.setVisibility(0);
                }
                if (BaseTransientBottomBar.this.f24365c.getAnimationMode() == 1) {
                    BaseTransientBottomBar.this.N();
                } else {
                    BaseTransientBottomBar.this.P();
                }
            }
        });
    }

    @NonNull
    public B removeCallback(@Nullable BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        List<BaseCallback<B>> list = this.f24378p;
        if (list == null) {
            return this;
        }
        list.remove(baseCallback);
        return this;
    }

    @NonNull
    public B setAnchorView(@Nullable View view) {
        Anchor anchor = this.f24369g;
        if (anchor != null) {
            anchor.c();
        }
        this.f24369g = view == null ? null : Anchor.a(this, view);
        return this;
    }

    public void setAnchorViewLayoutListenerEnabled(boolean z3) {
        this.f24370h = z3;
    }

    @NonNull
    public B setAnimationMode(int i4) {
        this.f24365c.setAnimationMode(i4);
        return this;
    }

    @NonNull
    public B setBehavior(Behavior behavior) {
        this.f24379q = behavior;
        return this;
    }

    @NonNull
    public B setDuration(int i4) {
        this.f24367e = i4;
        return this;
    }

    @NonNull
    public B setGestureInsetBottomIgnored(boolean z3) {
        this.f24368f = z3;
        return this;
    }

    public void show() {
        SnackbarManager.c().n(getDuration(), this.f24381s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i4) {
        SnackbarManager.c().b(this.f24381s, i4);
    }

    @NonNull
    protected SwipeDismissBehavior<? extends View> w() {
        return new Behavior();
    }

    @LayoutRes
    protected int z() {
        if (C()) {
            return R.layout.mtrl_layout_snackbar;
        }
        return R.layout.design_layout_snackbar;
    }

    @NonNull
    public B setAnchorView(@IdRes int i4) {
        View findViewById = this.f24363a.findViewById(i4);
        if (findViewById != null) {
            return setAnchorView(findViewById);
        }
        throw new IllegalArgumentException("Unable to find anchor view with id: " + i4);
    }

    /* loaded from: classes5.dex */
    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes5.dex */
        public @interface DismissEvent {
        }

        public void onShown(B b4) {
        }

        public void onDismissed(B b4, int i4) {
        }
    }
}
