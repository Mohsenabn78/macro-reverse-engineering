package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.arlosoft.macrodroid.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.SnackbarManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public final class SnackbarAnimate {
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;

    /* renamed from: h  reason: collision with root package name */
    static final Handler f24423h = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarAnimate.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 != 0) {
                if (i4 != 1) {
                    return false;
                }
                ((SnackbarAnimate) message.obj).e(message.arg1);
                return true;
            }
            ((SnackbarAnimate) message.obj).i();
            return true;
        }
    });

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f24424a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f24425b;

    /* renamed from: c  reason: collision with root package name */
    final SnackbarLayout f24426c;

    /* renamed from: d  reason: collision with root package name */
    private int f24427d;

    /* renamed from: e  reason: collision with root package name */
    private Callback f24428e;

    /* renamed from: f  reason: collision with root package name */
    private final AccessibilityManager f24429f;

    /* renamed from: g  reason: collision with root package name */
    final SnackbarManager.Callback f24430g = new SnackbarManager.Callback() { // from class: com.google.android.material.snackbar.SnackbarAnimate.3
        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void a(int i4) {
            Handler handler = SnackbarAnimate.f24423h;
            handler.sendMessage(handler.obtainMessage(1, i4, 0, SnackbarAnimate.this));
        }

        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void show() {
            Handler handler = SnackbarAnimate.f24423h;
            handler.sendMessage(handler.obtainMessage(0, SnackbarAnimate.this));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class Behavior extends SwipeDismissBehavior<SnackbarLayout> {
        Behavior() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarLayout;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: f */
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.isPointInChildBounds(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        SnackbarManager.c().l(SnackbarAnimate.this.f24430g);
                    }
                } else {
                    SnackbarManager.c().k(SnackbarAnimate.this.f24430g);
                }
            }
            return super.onInterceptTouchEvent(coordinatorLayout, snackbarLayout, motionEvent);
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface Duration {
    }

    /* loaded from: classes5.dex */
    public static class SnackbarLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private TextView f24442a;

        /* renamed from: b  reason: collision with root package name */
        private Button f24443b;

        /* renamed from: c  reason: collision with root package name */
        private int f24444c;

        /* renamed from: d  reason: collision with root package name */
        private int f24445d;

        /* renamed from: e  reason: collision with root package name */
        private OnLayoutChangeListener f24446e;

        /* renamed from: f  reason: collision with root package name */
        private OnAttachStateChangeListener f24447f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public interface OnAttachStateChangeListener {
            void onViewAttachedToWindow(View view);

            void onViewDetachedFromWindow(View view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public interface OnLayoutChangeListener {
            void onLayoutChange(View view, int i4, int i5, int i6, int i7);
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        private static void c(View view, int i4, int i5) {
            if (ViewCompat.isPaddingRelative(view)) {
                ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i4, ViewCompat.getPaddingEnd(view), i5);
            } else {
                view.setPadding(view.getPaddingLeft(), i4, view.getPaddingRight(), i5);
            }
        }

        private boolean d(int i4, int i5, int i6) {
            boolean z3;
            if (i4 != getOrientation()) {
                setOrientation(i4);
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.f24442a.getPaddingTop() == i5 && this.f24442a.getPaddingBottom() == i6) {
                return z3;
            }
            c(this.f24442a, i5, i6);
            return true;
        }

        void a(int i4, int i5) {
            ViewCompat.setAlpha(this.f24442a, 0.0f);
            long j4 = i5;
            long j5 = i4;
            ViewCompat.animate(this.f24442a).alpha(1.0f).setDuration(j4).setStartDelay(j5).start();
            if (this.f24443b.getVisibility() == 0) {
                ViewCompat.setAlpha(this.f24443b, 0.0f);
                ViewCompat.animate(this.f24443b).alpha(1.0f).setDuration(j4).setStartDelay(j5).start();
            }
        }

        void b(int i4, int i5) {
            ViewCompat.setAlpha(this.f24442a, 1.0f);
            long j4 = i5;
            long j5 = i4;
            ViewCompat.animate(this.f24442a).alpha(0.0f).setDuration(j4).setStartDelay(j5).start();
            if (this.f24443b.getVisibility() == 0) {
                ViewCompat.setAlpha(this.f24443b, 1.0f);
                ViewCompat.animate(this.f24443b).alpha(0.0f).setDuration(j4).setStartDelay(j5).start();
            }
        }

        Button getActionView() {
            return this.f24443b;
        }

        TextView getMessageView() {
            return this.f24442a;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.f24447f;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.f24447f;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f24442a = (TextView) findViewById(R.id.snackbar_text);
            this.f24443b = (Button) findViewById(R.id.snackbar_action);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
            super.onLayout(z3, i4, i5, i6, i7);
            OnLayoutChangeListener onLayoutChangeListener = this.f24446e;
            if (onLayoutChangeListener != null) {
                onLayoutChangeListener.onLayoutChange(this, i4, i5, i6, i7);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
            if (d(1, r0, r0 - r1) != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
            if (d(0, r0, r0) != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
            r3 = true;
         */
        @Override // android.widget.LinearLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void onMeasure(int r8, int r9) {
            /*
                r7 = this;
                super.onMeasure(r8, r9)
                int r0 = r7.f24444c
                if (r0 <= 0) goto L18
                int r0 = r7.getMeasuredWidth()
                int r1 = r7.f24444c
                if (r0 <= r1) goto L18
                r8 = 1073741824(0x40000000, float:2.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
                super.onMeasure(r8, r9)
            L18:
                android.content.res.Resources r0 = r7.getResources()
                r1 = 2131165351(0x7f0700a7, float:1.7944917E38)
                int r0 = r0.getDimensionPixelSize(r1)
                android.content.res.Resources r1 = r7.getResources()
                r2 = 2131165350(0x7f0700a6, float:1.7944915E38)
                int r1 = r1.getDimensionPixelSize(r2)
                android.widget.TextView r2 = r7.f24442a
                android.text.Layout r2 = r2.getLayout()
                int r2 = r2.getLineCount()
                r3 = 0
                r4 = 1
                if (r2 <= r4) goto L3e
                r2 = 1
                goto L3f
            L3e:
                r2 = 0
            L3f:
                if (r2 == 0) goto L58
                int r5 = r7.f24445d
                if (r5 <= 0) goto L58
                android.widget.Button r5 = r7.f24443b
                int r5 = r5.getMeasuredWidth()
                int r6 = r7.f24445d
                if (r5 <= r6) goto L58
                int r1 = r0 - r1
                boolean r0 = r7.d(r4, r0, r1)
                if (r0 == 0) goto L63
                goto L62
            L58:
                if (r2 == 0) goto L5b
                goto L5c
            L5b:
                r0 = r1
            L5c:
                boolean r0 = r7.d(r3, r0, r0)
                if (r0 == 0) goto L63
            L62:
                r3 = 1
            L63:
                if (r3 == 0) goto L68
                super.onMeasure(r8, r9)
            L68:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarAnimate.SnackbarLayout.onMeasure(int, int):void");
        }

        void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f24447f = onAttachStateChangeListener;
        }

        void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.f24446e = onLayoutChangeListener;
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            this.f24444c = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            this.f24445d = obtainStyledAttributes.getDimensionPixelSize(7, -1);
            if (obtainStyledAttributes.hasValue(6)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(6, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(R.layout.design_layout_snackbar_include, this);
            ViewCompat.setAccessibilityLiveRegion(this, 1);
            ViewCompat.setImportantForAccessibility(this, 1);
            ViewCompat.setFitsSystemWindows(this, true);
            ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.snackbar.SnackbarAnimate.SnackbarLayout.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    return windowInsetsCompat;
                }
            });
        }
    }

    private SnackbarAnimate(ViewGroup viewGroup) {
        this.f24424a = viewGroup;
        Context context = viewGroup.getContext();
        this.f24425b = context;
        this.f24426c = (SnackbarLayout) LayoutInflater.from(context).inflate(R.layout.snackbar_animate, viewGroup, false);
        this.f24429f = (AccessibilityManager) context.getSystemService("accessibility");
    }

    private void b(final int i4) {
        ViewCompat.animate(this.f24426c).translationY(this.f24426c.getHeight()).setInterpolator(new FastOutSlowInInterpolator()).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.SnackbarAnimate.8
            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                SnackbarAnimate.this.f(i4);
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                SnackbarAnimate.this.f24426c.b(0, 180);
            }
        }).start();
    }

    private static ViewGroup d(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    @NonNull
    public static SnackbarAnimate make(@NonNull View view, @NonNull CharSequence charSequence, int i4) {
        SnackbarAnimate snackbarAnimate = new SnackbarAnimate(d(view));
        snackbarAnimate.setText(charSequence);
        snackbarAnimate.setDuration(i4);
        return snackbarAnimate;
    }

    void a() {
        SnackbarLayout snackbarLayout = this.f24426c;
        ViewCompat.setTranslationY(snackbarLayout, snackbarLayout.getHeight());
        ViewCompat.animate(this.f24426c).translationY(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.SnackbarAnimate.7
            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                SnackbarAnimate.this.g();
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                SnackbarAnimate.this.f24426c.a(70, 180);
            }
        }).start();
    }

    void c(int i4) {
        SnackbarManager.c().b(this.f24430g, i4);
    }

    public void dismiss() {
        c(3);
    }

    final void e(int i4) {
        if (h() && this.f24426c.getVisibility() == 0) {
            b(i4);
        } else {
            f(i4);
        }
    }

    void f(int i4) {
        SnackbarManager.c().i(this.f24430g);
        Callback callback = this.f24428e;
        if (callback != null) {
            callback.onDismissed(this, i4);
        }
        ViewParent parent = this.f24426c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f24426c);
        }
    }

    void g() {
        SnackbarManager.c().j(this.f24430g);
        Callback callback = this.f24428e;
        if (callback != null) {
            callback.onShown(this);
        }
    }

    public int getDuration() {
        return this.f24427d;
    }

    @NonNull
    public View getView() {
        return this.f24426c;
    }

    boolean h() {
        return true;
    }

    final void i() {
        if (this.f24426c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f24426c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                Behavior behavior = new Behavior();
                behavior.setStartAlphaSwipeDistance(0.1f);
                behavior.setEndAlphaSwipeDistance(0.6f);
                behavior.setSwipeDirection(0);
                behavior.setListener(new SwipeDismissBehavior.OnDismissListener() { // from class: com.google.android.material.snackbar.SnackbarAnimate.4
                    @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
                    public void onDismiss(View view) {
                        view.setVisibility(8);
                        SnackbarAnimate.this.c(0);
                    }

                    @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
                    public void onDragStateChanged(int i4) {
                        if (i4 != 0) {
                            if (i4 == 1 || i4 == 2) {
                                SnackbarManager.c().k(SnackbarAnimate.this.f24430g);
                                return;
                            }
                            return;
                        }
                        SnackbarManager.c().l(SnackbarAnimate.this.f24430g);
                    }
                });
                layoutParams2.setBehavior(behavior);
                layoutParams2.insetEdge = 80;
            }
            this.f24424a.addView(this.f24426c);
        }
        this.f24426c.setOnAttachStateChangeListener(new SnackbarLayout.OnAttachStateChangeListener() { // from class: com.google.android.material.snackbar.SnackbarAnimate.5
            @Override // com.google.android.material.snackbar.SnackbarAnimate.SnackbarLayout.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (SnackbarAnimate.this.isShownOrQueued()) {
                    SnackbarAnimate.f24423h.post(new Runnable() { // from class: com.google.android.material.snackbar.SnackbarAnimate.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SnackbarAnimate.this.f(3);
                        }
                    });
                }
            }

            @Override // com.google.android.material.snackbar.SnackbarAnimate.SnackbarLayout.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }
        });
        if (ViewCompat.isLaidOut(this.f24426c)) {
            if (h()) {
                a();
                return;
            } else {
                g();
                return;
            }
        }
        this.f24426c.setOnLayoutChangeListener(new SnackbarLayout.OnLayoutChangeListener() { // from class: com.google.android.material.snackbar.SnackbarAnimate.6
            @Override // com.google.android.material.snackbar.SnackbarAnimate.SnackbarLayout.OnLayoutChangeListener
            public void onLayoutChange(View view, int i4, int i5, int i6, int i7) {
                SnackbarAnimate.this.f24426c.setOnLayoutChangeListener(null);
                if (SnackbarAnimate.this.h()) {
                    SnackbarAnimate.this.a();
                } else {
                    SnackbarAnimate.this.g();
                }
            }
        });
    }

    public boolean isShown() {
        return SnackbarManager.c().e(this.f24430g);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.c().f(this.f24430g);
    }

    @NonNull
    public SnackbarAnimate setAction(@StringRes int i4, View.OnClickListener onClickListener) {
        return setAction(this.f24425b.getText(i4), onClickListener);
    }

    @NonNull
    public SnackbarAnimate setActionTextColor(ColorStateList colorStateList) {
        this.f24426c.getActionView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    public SnackbarAnimate setCallback(Callback callback) {
        this.f24428e = callback;
        return this;
    }

    @NonNull
    public SnackbarAnimate setDuration(int i4) {
        this.f24427d = i4;
        return this;
    }

    @NonNull
    public SnackbarAnimate setText(@NonNull CharSequence charSequence) {
        this.f24426c.getMessageView().setText(charSequence);
        return this;
    }

    public void show() {
        SnackbarManager.c().n(this.f24427d, this.f24430g);
    }

    @NonNull
    public SnackbarAnimate setAction(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = this.f24426c.getActionView();
        if (!TextUtils.isEmpty(charSequence) && onClickListener != null) {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.snackbar.SnackbarAnimate.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    SnackbarAnimate.this.c(1);
                }
            });
        } else {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        }
        return this;
    }

    @NonNull
    public SnackbarAnimate setActionTextColor(@ColorInt int i4) {
        this.f24426c.getActionView().setTextColor(i4);
        return this;
    }

    @NonNull
    public SnackbarAnimate setText(@StringRes int i4) {
        return setText(this.f24425b.getText(i4));
    }

    @NonNull
    public static SnackbarAnimate make(@NonNull View view, @StringRes int i4, int i5) {
        return make(view, view.getResources().getText(i4), i5);
    }

    /* loaded from: classes5.dex */
    public static abstract class Callback {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes5.dex */
        public @interface DismissEvent {
        }

        public void onShown(SnackbarAnimate snackbarAnimate) {
        }

        public void onDismissed(SnackbarAnimate snackbarAnimate, int i4) {
        }
    }
}
