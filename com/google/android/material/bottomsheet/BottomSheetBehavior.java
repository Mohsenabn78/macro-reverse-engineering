package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;

    /* renamed from: a0  reason: collision with root package name */
    private static final int f23128a0 = R.style.Widget_Design_BottomSheet_Modal;
    int A;
    float B;
    int C;
    float D;
    boolean E;
    private boolean F;
    private boolean G;
    int H;
    int I;
    @Nullable
    ViewDragHelper J;
    private boolean K;
    private int L;
    private boolean M;
    private int N;
    int O;
    int P;
    @Nullable
    WeakReference<V> Q;
    @Nullable
    WeakReference<View> R;
    @NonNull
    private final ArrayList<BottomSheetCallback> S;
    @Nullable
    private VelocityTracker T;
    int U;
    private int V;
    boolean W;
    @Nullable
    private Map<View, Integer> X;
    private int Y;
    private final ViewDragHelper.Callback Z;

    /* renamed from: a  reason: collision with root package name */
    private int f23129a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23130b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23131c;

    /* renamed from: d  reason: collision with root package name */
    private float f23132d;

    /* renamed from: e  reason: collision with root package name */
    private int f23133e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23134f;

    /* renamed from: g  reason: collision with root package name */
    private int f23135g;

    /* renamed from: h  reason: collision with root package name */
    private int f23136h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23137i;

    /* renamed from: j  reason: collision with root package name */
    private MaterialShapeDrawable f23138j;

    /* renamed from: k  reason: collision with root package name */
    private int f23139k;

    /* renamed from: l  reason: collision with root package name */
    private int f23140l;

    /* renamed from: m  reason: collision with root package name */
    private int f23141m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f23142n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f23143o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f23144p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f23145q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f23146r;

    /* renamed from: s  reason: collision with root package name */
    private int f23147s;

    /* renamed from: t  reason: collision with root package name */
    private int f23148t;

    /* renamed from: u  reason: collision with root package name */
    private ShapeAppearanceModel f23149u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f23150v;

    /* renamed from: w  reason: collision with root package name */
    private BottomSheetBehavior<V>.SettleRunnable f23151w;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    private ValueAnimator f23152x;

    /* renamed from: y  reason: collision with root package name */
    int f23153y;

    /* renamed from: z  reason: collision with root package name */
    int f23154z;

    /* loaded from: classes5.dex */
    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@NonNull View view, float f4);

        public abstract void onStateChanged(@NonNull View view, int i4);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface SaveFlags {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        final int f23165a;

        /* renamed from: b  reason: collision with root package name */
        int f23166b;

        /* renamed from: c  reason: collision with root package name */
        boolean f23167c;

        /* renamed from: d  reason: collision with root package name */
        boolean f23168d;

        /* renamed from: e  reason: collision with root package name */
        boolean f23169e;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f23165a);
            parcel.writeInt(this.f23166b);
            parcel.writeInt(this.f23167c ? 1 : 0);
            parcel.writeInt(this.f23168d ? 1 : 0);
            parcel.writeInt(this.f23169e ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f23165a = parcel.readInt();
            this.f23166b = parcel.readInt();
            this.f23167c = parcel.readInt() == 1;
            this.f23168d = parcel.readInt() == 1;
            this.f23169e = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f23165a = bottomSheetBehavior.H;
            this.f23166b = ((BottomSheetBehavior) bottomSheetBehavior).f23133e;
            this.f23167c = ((BottomSheetBehavior) bottomSheetBehavior).f23130b;
            this.f23168d = bottomSheetBehavior.E;
            this.f23169e = ((BottomSheetBehavior) bottomSheetBehavior).F;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i4) {
            super(parcelable);
            this.f23165a = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class SettleRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f23170a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f23171b;

        /* renamed from: c  reason: collision with root package name */
        int f23172c;

        SettleRunnable(View view, int i4) {
            this.f23170a = view;
            this.f23172c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.J;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f23170a, this);
            } else {
                BottomSheetBehavior.this.D(this.f23172c);
            }
            this.f23171b = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.f23129a = 0;
        this.f23130b = true;
        this.f23131c = false;
        this.f23139k = -1;
        this.f23140l = -1;
        this.f23151w = null;
        this.B = 0.5f;
        this.D = -1.0f;
        this.G = true;
        this.H = 4;
        this.I = 4;
        this.S = new ArrayList<>();
        this.Y = -1;
        this.Z = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4

            /* renamed from: a  reason: collision with root package name */
            private long f23161a;

            private boolean a(@NonNull View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (top > (bottomSheetBehavior.P + bottomSheetBehavior.getExpandedOffset()) / 2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i4, int i5) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i4, int i5) {
                int i6;
                int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.E) {
                    i6 = bottomSheetBehavior.P;
                } else {
                    i6 = bottomSheetBehavior.C;
                }
                return MathUtils.clamp(i4, expandedOffset, i6);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.E) {
                    return bottomSheetBehavior.P;
                }
                return bottomSheetBehavior.C;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i4) {
                if (i4 == 1 && BottomSheetBehavior.this.G) {
                    BottomSheetBehavior.this.D(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i4, int i5, int i6, int i7) {
                BottomSheetBehavior.this.v(i5);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f4, float f5) {
                int i4;
                int i5 = 6;
                if (f5 < 0.0f) {
                    if (BottomSheetBehavior.this.f23130b) {
                        i4 = BottomSheetBehavior.this.f23154z;
                    } else {
                        int top = view.getTop();
                        long currentTimeMillis = System.currentTimeMillis() - this.f23161a;
                        if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                            if (bottomSheetBehavior.shouldExpandOnUpwardDrag(currentTimeMillis, (top * 100.0f) / bottomSheetBehavior.P)) {
                                i4 = BottomSheetBehavior.this.f23153y;
                            } else {
                                i4 = BottomSheetBehavior.this.C;
                                i5 = 4;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                            int i6 = bottomSheetBehavior2.A;
                            if (top > i6) {
                                i4 = i6;
                            } else {
                                i4 = bottomSheetBehavior2.getExpandedOffset();
                            }
                        }
                    }
                    i5 = 3;
                } else {
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior3.E && bottomSheetBehavior3.I(view, f5)) {
                        if ((Math.abs(f4) < Math.abs(f5) && f5 > 500.0f) || a(view)) {
                            i4 = BottomSheetBehavior.this.P;
                            i5 = 5;
                        } else {
                            if (BottomSheetBehavior.this.f23130b) {
                                i4 = BottomSheetBehavior.this.f23154z;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.A)) {
                                i4 = BottomSheetBehavior.this.getExpandedOffset();
                            } else {
                                i4 = BottomSheetBehavior.this.A;
                            }
                            i5 = 3;
                        }
                    } else if (f5 != 0.0f && Math.abs(f4) <= Math.abs(f5)) {
                        if (BottomSheetBehavior.this.f23130b) {
                            i4 = BottomSheetBehavior.this.C;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - BottomSheetBehavior.this.A) < Math.abs(top2 - BottomSheetBehavior.this.C)) {
                                if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                    i4 = BottomSheetBehavior.this.C;
                                } else {
                                    i4 = BottomSheetBehavior.this.A;
                                }
                            } else {
                                i4 = BottomSheetBehavior.this.C;
                            }
                        }
                        i5 = 4;
                    } else {
                        int top3 = view.getTop();
                        if (BottomSheetBehavior.this.f23130b) {
                            if (Math.abs(top3 - BottomSheetBehavior.this.f23154z) < Math.abs(top3 - BottomSheetBehavior.this.C)) {
                                i4 = BottomSheetBehavior.this.f23154z;
                                i5 = 3;
                            } else {
                                i4 = BottomSheetBehavior.this.C;
                                i5 = 4;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                            int i7 = bottomSheetBehavior4.A;
                            if (top3 < i7) {
                                if (top3 < Math.abs(top3 - bottomSheetBehavior4.C)) {
                                    i4 = BottomSheetBehavior.this.getExpandedOffset();
                                    i5 = 3;
                                } else if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                    i4 = BottomSheetBehavior.this.C;
                                    i5 = 4;
                                } else {
                                    i4 = BottomSheetBehavior.this.A;
                                }
                            } else {
                                if (Math.abs(top3 - i7) < Math.abs(top3 - BottomSheetBehavior.this.C)) {
                                    if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                        i4 = BottomSheetBehavior.this.C;
                                    } else {
                                        i4 = BottomSheetBehavior.this.A;
                                    }
                                } else {
                                    i4 = BottomSheetBehavior.this.C;
                                }
                                i5 = 4;
                            }
                        }
                    }
                }
                BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                bottomSheetBehavior5.J(view, i5, i4, bottomSheetBehavior5.shouldSkipSmoothAnimation());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i4) {
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i5 = bottomSheetBehavior.H;
                if (i5 == 1 || bottomSheetBehavior.W) {
                    return false;
                }
                if (i5 == 3 && bottomSheetBehavior.U == i4) {
                    WeakReference<View> weakReference = bottomSheetBehavior.R;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                this.f23161a = System.currentTimeMillis();
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.Q;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
    }

    private void A(V v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i4) {
        ViewCompat.replaceAccessibilityAction(v3, accessibilityActionCompat, null, r(i4));
    }

    private void B() {
        this.U = -1;
        VelocityTracker velocityTracker = this.T;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.T = null;
        }
    }

    private void C(@NonNull SavedState savedState) {
        int i4 = this.f23129a;
        if (i4 == 0) {
            return;
        }
        if (i4 == -1 || (i4 & 1) == 1) {
            this.f23133e = savedState.f23166b;
        }
        if (i4 == -1 || (i4 & 2) == 2) {
            this.f23130b = savedState.f23167c;
        }
        if (i4 == -1 || (i4 & 4) == 4) {
            this.E = savedState.f23168d;
        }
        if (i4 == -1 || (i4 & 8) == 8) {
            this.F = savedState.f23169e;
        }
    }

    private void E(@NonNull View view) {
        final boolean z3;
        if (Build.VERSION.SDK_INT >= 29 && !isGestureInsetBottomIgnored() && !this.f23134f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!this.f23143o && !this.f23144p && !this.f23145q && !z3) {
            return;
        }
        ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                int i4;
                int i5;
                BottomSheetBehavior.this.f23148t = windowInsetsCompat.getSystemWindowInsetTop();
                boolean isLayoutRtl = ViewUtils.isLayoutRtl(view2);
                int paddingBottom = view2.getPaddingBottom();
                int paddingLeft = view2.getPaddingLeft();
                int paddingRight = view2.getPaddingRight();
                if (BottomSheetBehavior.this.f23143o) {
                    BottomSheetBehavior.this.f23147s = windowInsetsCompat.getSystemWindowInsetBottom();
                    paddingBottom = relativePadding.bottom + BottomSheetBehavior.this.f23147s;
                }
                if (BottomSheetBehavior.this.f23144p) {
                    if (isLayoutRtl) {
                        i5 = relativePadding.end;
                    } else {
                        i5 = relativePadding.start;
                    }
                    paddingLeft = i5 + windowInsetsCompat.getSystemWindowInsetLeft();
                }
                if (BottomSheetBehavior.this.f23145q) {
                    if (isLayoutRtl) {
                        i4 = relativePadding.start;
                    } else {
                        i4 = relativePadding.end;
                    }
                    paddingRight = i4 + windowInsetsCompat.getSystemWindowInsetRight();
                }
                view2.setPadding(paddingLeft, view2.getPaddingTop(), paddingRight, paddingBottom);
                if (z3) {
                    BottomSheetBehavior.this.f23141m = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
                }
                if (BottomSheetBehavior.this.f23143o || z3) {
                    BottomSheetBehavior.this.N(false);
                }
                return windowInsetsCompat;
            }
        });
    }

    private void G(final int i4) {
        final V v3 = this.Q.get();
        if (v3 == null) {
            return;
        }
        ViewParent parent = v3.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v3)) {
            v3.post(new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.F(v3, i4);
                }
            });
        } else {
            F(v3, i4);
        }
    }

    private boolean H() {
        if (this.J != null && (this.G || this.H == 1)) {
            return true;
        }
        return false;
    }

    private void K() {
        V v3;
        WeakReference<V> weakReference = this.Q;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v3, 524288);
        ViewCompat.removeAccessibilityAction(v3, 262144);
        ViewCompat.removeAccessibilityAction(v3, 1048576);
        int i4 = this.Y;
        if (i4 != -1) {
            ViewCompat.removeAccessibilityAction(v3, i4);
        }
        int i5 = 6;
        if (!this.f23130b && this.H != 6) {
            this.Y = n(v3, R.string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.E && this.H != 5) {
            A(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i6 = this.H;
        if (i6 != 3) {
            if (i6 != 4) {
                if (i6 == 6) {
                    A(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                    A(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
                    return;
                }
                return;
            }
            if (this.f23130b) {
                i5 = 3;
            }
            A(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i5);
            return;
        }
        if (this.f23130b) {
            i5 = 4;
        }
        A(v3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i5);
    }

    private void L(int i4) {
        boolean z3;
        ValueAnimator valueAnimator;
        float f4;
        if (i4 == 2) {
            return;
        }
        if (i4 == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f23150v != z3) {
            this.f23150v = z3;
            if (this.f23138j != null && (valueAnimator = this.f23152x) != null) {
                if (valueAnimator.isRunning()) {
                    this.f23152x.reverse();
                    return;
                }
                if (z3) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                this.f23152x.setFloatValues(1.0f - f4, f4);
                this.f23152x.start();
            }
        }
    }

    private void M(boolean z3) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.Q;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z3) {
            if (this.X == null) {
                this.X = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = coordinatorLayout.getChildAt(i4);
            if (childAt != this.Q.get()) {
                if (z3) {
                    this.X.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    if (this.f23131c) {
                        ViewCompat.setImportantForAccessibility(childAt, 4);
                    }
                } else if (this.f23131c && (map = this.X) != null && map.containsKey(childAt)) {
                    ViewCompat.setImportantForAccessibility(childAt, this.X.get(childAt).intValue());
                }
            }
        }
        if (!z3) {
            this.X = null;
        } else if (this.f23131c) {
            this.Q.get().sendAccessibilityEvent(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z3) {
        V v3;
        if (this.Q != null) {
            o();
            if (this.H == 4 && (v3 = this.Q.get()) != null) {
                if (z3) {
                    G(this.H);
                } else {
                    v3.requestLayout();
                }
            }
        }
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V v3) {
        ViewGroup.LayoutParams layoutParams = v3.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int n(V v3, @StringRes int i4, int i5) {
        return ViewCompat.addAccessibilityAction(v3, v3.getResources().getString(i4), r(i5));
    }

    private void o() {
        int q4 = q();
        if (this.f23130b) {
            this.C = Math.max(this.P - q4, this.f23154z);
        } else {
            this.C = this.P - q4;
        }
    }

    private void p() {
        this.A = (int) (this.P * (1.0f - this.B));
    }

    private int q() {
        int i4;
        if (this.f23134f) {
            return Math.min(Math.max(this.f23135g, this.P - ((this.O * 9) / 16)), this.N) + this.f23147s;
        }
        if (!this.f23142n && !this.f23143o && (i4 = this.f23141m) > 0) {
            return Math.max(this.f23133e, i4 + this.f23136h);
        }
        return this.f23133e + this.f23147s;
    }

    private AccessibilityViewCommand r(final int i4) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.setState(i4);
                return true;
            }
        };
    }

    private void s(@NonNull Context context, AttributeSet attributeSet, boolean z3) {
        t(context, attributeSet, z3, null);
    }

    private void t(@NonNull Context context, AttributeSet attributeSet, boolean z3, @Nullable ColorStateList colorStateList) {
        if (this.f23137i) {
            this.f23149u = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, f23128a0).build();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f23149u);
            this.f23138j = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            if (z3 && colorStateList != null) {
                this.f23138j.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.f23138j.setTint(typedValue.data);
        }
    }

    private void u() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f23152x = ofFloat;
        ofFloat.setDuration(500L);
        this.f23152x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.f23138j != null) {
                    BottomSheetBehavior.this.f23138j.setInterpolation(floatValue);
                }
            }
        });
    }

    private int x(int i4, int i5, int i6, int i7) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, i5, i7);
        if (i6 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i6 = Math.min(size, i6);
            }
            return View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i6), 1073741824);
    }

    private float z() {
        VelocityTracker velocityTracker = this.T;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f23132d);
        return this.T.getYVelocity(this.U);
    }

    void D(int i4) {
        V v3;
        if (this.H == i4) {
            return;
        }
        this.H = i4;
        if (i4 == 4 || i4 == 3 || i4 == 6 || (this.E && i4 == 5)) {
            this.I = i4;
        }
        WeakReference<V> weakReference = this.Q;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        if (i4 == 3) {
            M(true);
        } else if (i4 == 6 || i4 == 5 || i4 == 4) {
            M(false);
        }
        L(i4);
        for (int i5 = 0; i5 < this.S.size(); i5++) {
            this.S.get(i5).onStateChanged(v3, i4);
        }
        K();
    }

    void F(@NonNull View view, int i4) {
        int i5;
        int i6;
        if (i4 == 4) {
            i5 = this.C;
        } else if (i4 == 6) {
            i5 = this.A;
            if (this.f23130b && i5 <= (i6 = this.f23154z)) {
                i5 = i6;
                i4 = 3;
            }
        } else if (i4 == 3) {
            i5 = getExpandedOffset();
        } else if (this.E && i4 == 5) {
            i5 = this.P;
        } else {
            Log.w("BottomSheetBehavior", "The bottom sheet may be in an invalid state. Ensure `hideable` is true when using `STATE_HIDDEN`.");
            return;
        }
        J(view, i4, i5, false);
    }

    boolean I(@NonNull View view, float f4) {
        if (this.F) {
            return true;
        }
        if (view.getTop() < this.C) {
            return false;
        }
        if (Math.abs((view.getTop() + (f4 * 0.1f)) - this.C) / q() > 0.5f) {
            return true;
        }
        return false;
    }

    void J(View view, int i4, int i5, boolean z3) {
        boolean z4;
        ViewDragHelper viewDragHelper = this.J;
        if (viewDragHelper != null && (!z3 ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i5) : viewDragHelper.settleCapturedViewAt(view.getLeft(), i5))) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            D(2);
            L(i4);
            if (this.f23151w == null) {
                this.f23151w = new SettleRunnable(view, i4);
            }
            if (!((SettleRunnable) this.f23151w).f23171b) {
                BottomSheetBehavior<V>.SettleRunnable settleRunnable = this.f23151w;
                settleRunnable.f23172c = i4;
                ViewCompat.postOnAnimation(view, settleRunnable);
                ((SettleRunnable) this.f23151w).f23171b = true;
                return;
            }
            this.f23151w.f23172c = i4;
            return;
        }
        D(i4);
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        if (!this.S.contains(bottomSheetCallback)) {
            this.S.add(bottomSheetCallback);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        this.f23152x = null;
    }

    public int getExpandedOffset() {
        int i4;
        if (this.f23130b) {
            return this.f23154z;
        }
        int i5 = this.f23153y;
        if (this.f23146r) {
            i4 = 0;
        } else {
            i4 = this.f23148t;
        }
        return Math.max(i5, i4);
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.B;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.I;
    }

    @Px
    public int getMaxHeight() {
        return this.f23140l;
    }

    @Px
    public int getMaxWidth() {
        return this.f23139k;
    }

    public int getPeekHeight() {
        if (this.f23134f) {
            return -1;
        }
        return this.f23133e;
    }

    public int getSaveFlags() {
        return this.f23129a;
    }

    public boolean getSkipCollapsed() {
        return this.F;
    }

    public int getState() {
        return this.H;
    }

    public boolean isDraggable() {
        return this.G;
    }

    public boolean isFitToContents() {
        return this.f23130b;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.f23142n;
    }

    public boolean isHideable() {
        return this.E;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.Q = null;
        this.J = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.Q = null;
        this.J = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        boolean z3;
        View view;
        ViewDragHelper viewDragHelper;
        if (v3.isShown() && this.G) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                B();
            }
            if (this.T == null) {
                this.T = VelocityTracker.obtain();
            }
            this.T.addMovement(motionEvent);
            View view2 = null;
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.W = false;
                    this.U = -1;
                    if (this.K) {
                        this.K = false;
                        return false;
                    }
                }
            } else {
                int x3 = (int) motionEvent.getX();
                this.V = (int) motionEvent.getY();
                if (this.H != 2) {
                    WeakReference<View> weakReference = this.R;
                    if (weakReference != null) {
                        view = weakReference.get();
                    } else {
                        view = null;
                    }
                    if (view != null && coordinatorLayout.isPointInChildBounds(view, x3, this.V)) {
                        this.U = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.W = true;
                    }
                }
                if (this.U == -1 && !coordinatorLayout.isPointInChildBounds(v3, x3, this.V)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.K = z3;
            }
            if (!this.K && (viewDragHelper = this.J) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
            WeakReference<View> weakReference2 = this.R;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            if (actionMasked != 2 || view2 == null || this.K || this.H == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.J == null || Math.abs(this.V - motionEvent.getY()) <= this.J.getTouchSlop()) {
                return false;
            }
            return true;
        }
        this.K = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i4) {
        boolean z3;
        float f4;
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v3)) {
            v3.setFitsSystemWindows(true);
        }
        if (this.Q == null) {
            this.f23135g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            E(v3);
            this.Q = new WeakReference<>(v3);
            if (this.f23137i && (materialShapeDrawable = this.f23138j) != null) {
                ViewCompat.setBackground(v3, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.f23138j;
            if (materialShapeDrawable2 != null) {
                float f5 = this.D;
                if (f5 == -1.0f) {
                    f5 = ViewCompat.getElevation(v3);
                }
                materialShapeDrawable2.setElevation(f5);
                if (this.H == 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f23150v = z3;
                MaterialShapeDrawable materialShapeDrawable3 = this.f23138j;
                if (z3) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                materialShapeDrawable3.setInterpolation(f4);
            }
            K();
            if (ViewCompat.getImportantForAccessibility(v3) == 0) {
                ViewCompat.setImportantForAccessibility(v3, 1);
            }
        }
        if (this.J == null) {
            this.J = ViewDragHelper.create(coordinatorLayout, this.Z);
        }
        int top = v3.getTop();
        coordinatorLayout.onLayoutChild(v3, i4);
        this.O = coordinatorLayout.getWidth();
        this.P = coordinatorLayout.getHeight();
        int height = v3.getHeight();
        this.N = height;
        int i5 = this.P;
        int i6 = i5 - height;
        int i7 = this.f23148t;
        if (i6 < i7) {
            if (this.f23146r) {
                this.N = i5;
            } else {
                this.N = i5 - i7;
            }
        }
        this.f23154z = Math.max(0, i5 - this.N);
        p();
        o();
        int i8 = this.H;
        if (i8 == 3) {
            ViewCompat.offsetTopAndBottom(v3, getExpandedOffset());
        } else if (i8 == 6) {
            ViewCompat.offsetTopAndBottom(v3, this.A);
        } else if (this.E && i8 == 5) {
            ViewCompat.offsetTopAndBottom(v3, this.P);
        } else if (i8 == 4) {
            ViewCompat.offsetTopAndBottom(v3, this.C);
        } else if (i8 == 1 || i8 == 2) {
            ViewCompat.offsetTopAndBottom(v3, top - v3.getTop());
        }
        this.R = new WeakReference<>(w(v3));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v3.getLayoutParams();
        v3.measure(x(i4, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, this.f23139k, marginLayoutParams.width), x(i6, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, this.f23140l, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, float f4, float f5) {
        WeakReference<View> weakReference;
        if (!isNestedScrollingCheckEnabled() || (weakReference = this.R) == null || view != weakReference.get()) {
            return false;
        }
        if (this.H == 3 && !super.onNestedPreFling(coordinatorLayout, v3, view, f4, f5)) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i4, int i5, @NonNull int[] iArr, int i6) {
        View view2;
        if (i6 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.R;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (isNestedScrollingCheckEnabled() && view != view2) {
            return;
        }
        int top = v3.getTop();
        int i7 = top - i5;
        if (i5 > 0) {
            if (i7 < getExpandedOffset()) {
                int expandedOffset = top - getExpandedOffset();
                iArr[1] = expandedOffset;
                ViewCompat.offsetTopAndBottom(v3, -expandedOffset);
                D(3);
            } else if (!this.G) {
                return;
            } else {
                iArr[1] = i5;
                ViewCompat.offsetTopAndBottom(v3, -i5);
                D(1);
            }
        } else if (i5 < 0 && !view.canScrollVertically(-1)) {
            int i8 = this.C;
            if (i7 > i8 && !this.E) {
                int i9 = top - i8;
                iArr[1] = i9;
                ViewCompat.offsetTopAndBottom(v3, -i9);
                D(4);
            } else if (!this.G) {
                return;
            } else {
                iArr[1] = i5;
                ViewCompat.offsetTopAndBottom(v3, -i5);
                D(1);
            }
        }
        v(v3.getTop());
        this.L = i5;
        this.M = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v3, savedState.getSuperState());
        C(savedState);
        int i4 = savedState.f23165a;
        if (i4 != 1 && i4 != 2) {
            this.H = i4;
            this.I = i4;
            return;
        }
        this.H = 4;
        this.I = 4;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v3), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, @NonNull View view2, int i4, int i5) {
        this.L = 0;
        this.M = false;
        if ((i4 & 2) == 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i4) {
        int i5;
        WeakReference<View> weakReference;
        int i6 = 3;
        if (v3.getTop() == getExpandedOffset()) {
            D(3);
        } else if (isNestedScrollingCheckEnabled() && ((weakReference = this.R) == null || view != weakReference.get() || !this.M)) {
        } else {
            if (this.L > 0) {
                if (this.f23130b) {
                    i5 = this.f23154z;
                } else {
                    int top = v3.getTop();
                    int i7 = this.A;
                    if (top > i7) {
                        i5 = i7;
                        i6 = 6;
                    } else {
                        i5 = getExpandedOffset();
                    }
                }
            } else if (this.E && I(v3, z())) {
                i5 = this.P;
                i6 = 5;
            } else if (this.L == 0) {
                int top2 = v3.getTop();
                if (this.f23130b) {
                    if (Math.abs(top2 - this.f23154z) < Math.abs(top2 - this.C)) {
                        i5 = this.f23154z;
                    } else {
                        i5 = this.C;
                        i6 = 4;
                    }
                } else {
                    int i8 = this.A;
                    if (top2 < i8) {
                        if (top2 < Math.abs(top2 - this.C)) {
                            i5 = getExpandedOffset();
                        } else if (shouldSkipHalfExpandedStateWhenDragging()) {
                            i5 = this.C;
                            i6 = 4;
                        } else {
                            i5 = this.A;
                            i6 = 6;
                        }
                    } else if (Math.abs(top2 - i8) < Math.abs(top2 - this.C)) {
                        i5 = this.A;
                        i6 = 6;
                    } else {
                        i5 = this.C;
                        i6 = 4;
                    }
                }
            } else {
                if (this.f23130b) {
                    i5 = this.C;
                } else {
                    int top3 = v3.getTop();
                    if (Math.abs(top3 - this.A) < Math.abs(top3 - this.C)) {
                        i5 = this.A;
                        i6 = 6;
                    } else {
                        i5 = this.C;
                    }
                }
                i6 = 4;
            }
            J(v3, i6, i5, false);
            this.M = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        if (!v3.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.H == 1 && actionMasked == 0) {
            return true;
        }
        if (H()) {
            this.J.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            B();
        }
        if (this.T == null) {
            this.T = VelocityTracker.obtain();
        }
        this.T.addMovement(motionEvent);
        if (H() && actionMasked == 2 && !this.K && Math.abs(this.V - motionEvent.getY()) > this.J.getTouchSlop()) {
            this.J.captureChildView(v3, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.K;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        this.S.remove(bottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.S.clear();
        if (bottomSheetCallback != null) {
            this.S.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z3) {
        this.G = z3;
    }

    public void setExpandedOffset(int i4) {
        if (i4 >= 0) {
            this.f23153y = i4;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z3) {
        int i4;
        if (this.f23130b == z3) {
            return;
        }
        this.f23130b = z3;
        if (this.Q != null) {
            o();
        }
        if (this.f23130b && this.H == 6) {
            i4 = 3;
        } else {
            i4 = this.H;
        }
        D(i4);
        K();
    }

    public void setGestureInsetBottomIgnored(boolean z3) {
        this.f23142n = z3;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f4) {
        if (f4 > 0.0f && f4 < 1.0f) {
            this.B = f4;
            if (this.Q != null) {
                p();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideable(boolean z3) {
        if (this.E != z3) {
            this.E = z3;
            if (!z3 && this.H == 5) {
                setState(4);
            }
            K();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHideableInternal(boolean z3) {
        this.E = z3;
    }

    public void setMaxHeight(@Px int i4) {
        this.f23140l = i4;
    }

    public void setMaxWidth(@Px int i4) {
        this.f23139k = i4;
    }

    public void setPeekHeight(int i4) {
        setPeekHeight(i4, false);
    }

    public void setSaveFlags(int i4) {
        this.f23129a = i4;
    }

    public void setSkipCollapsed(boolean z3) {
        this.F = z3;
    }

    public void setState(int i4) {
        if (i4 == this.H) {
            return;
        }
        if (this.Q == null) {
            if (i4 == 4 || i4 == 3 || i4 == 6 || (this.E && i4 == 5)) {
                this.H = i4;
                this.I = i4;
                return;
            }
            return;
        }
        G(i4);
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z3) {
        this.f23131c = z3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldExpandOnUpwardDrag(long j4, @FloatRange(from = 0.0d, to = 100.0d) float f4) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    void v(int i4) {
        float f4;
        float f5;
        V v3 = this.Q.get();
        if (v3 != null && !this.S.isEmpty()) {
            int i5 = this.C;
            if (i4 <= i5 && i5 != getExpandedOffset()) {
                int i6 = this.C;
                f4 = i6 - i4;
                f5 = i6 - getExpandedOffset();
            } else {
                int i7 = this.C;
                f4 = i7 - i4;
                f5 = this.P - i7;
            }
            float f6 = f4 / f5;
            for (int i8 = 0; i8 < this.S.size(); i8++) {
                this.S.get(i8).onSlide(v3, f6);
            }
        }
    }

    @Nullable
    @VisibleForTesting
    View w(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View w3 = w(viewGroup.getChildAt(i4));
                if (w3 != null) {
                    return w3;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialShapeDrawable y() {
        return this.f23138j;
    }

    public final void setPeekHeight(int i4, boolean z3) {
        boolean z4 = true;
        if (i4 == -1) {
            if (!this.f23134f) {
                this.f23134f = true;
            }
            z4 = false;
        } else {
            if (this.f23134f || this.f23133e != i4) {
                this.f23134f = false;
                this.f23133e = Math.max(0, i4);
            }
            z4 = false;
        }
        if (z4) {
            N(z3);
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i4;
        this.f23129a = 0;
        this.f23130b = true;
        this.f23131c = false;
        this.f23139k = -1;
        this.f23140l = -1;
        this.f23151w = null;
        this.B = 0.5f;
        this.D = -1.0f;
        this.G = true;
        this.H = 4;
        this.I = 4;
        this.S = new ArrayList<>();
        this.Y = -1;
        this.Z = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4

            /* renamed from: a  reason: collision with root package name */
            private long f23161a;

            private boolean a(@NonNull View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (top > (bottomSheetBehavior.P + bottomSheetBehavior.getExpandedOffset()) / 2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i42, int i5) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i42, int i5) {
                int i6;
                int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.E) {
                    i6 = bottomSheetBehavior.P;
                } else {
                    i6 = bottomSheetBehavior.C;
                }
                return MathUtils.clamp(i42, expandedOffset, i6);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.E) {
                    return bottomSheetBehavior.P;
                }
                return bottomSheetBehavior.C;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i42) {
                if (i42 == 1 && BottomSheetBehavior.this.G) {
                    BottomSheetBehavior.this.D(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i42, int i5, int i6, int i7) {
                BottomSheetBehavior.this.v(i5);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f4, float f5) {
                int i42;
                int i5 = 6;
                if (f5 < 0.0f) {
                    if (BottomSheetBehavior.this.f23130b) {
                        i42 = BottomSheetBehavior.this.f23154z;
                    } else {
                        int top = view.getTop();
                        long currentTimeMillis = System.currentTimeMillis() - this.f23161a;
                        if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                            if (bottomSheetBehavior.shouldExpandOnUpwardDrag(currentTimeMillis, (top * 100.0f) / bottomSheetBehavior.P)) {
                                i42 = BottomSheetBehavior.this.f23153y;
                            } else {
                                i42 = BottomSheetBehavior.this.C;
                                i5 = 4;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                            int i6 = bottomSheetBehavior2.A;
                            if (top > i6) {
                                i42 = i6;
                            } else {
                                i42 = bottomSheetBehavior2.getExpandedOffset();
                            }
                        }
                    }
                    i5 = 3;
                } else {
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior3.E && bottomSheetBehavior3.I(view, f5)) {
                        if ((Math.abs(f4) < Math.abs(f5) && f5 > 500.0f) || a(view)) {
                            i42 = BottomSheetBehavior.this.P;
                            i5 = 5;
                        } else {
                            if (BottomSheetBehavior.this.f23130b) {
                                i42 = BottomSheetBehavior.this.f23154z;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.A)) {
                                i42 = BottomSheetBehavior.this.getExpandedOffset();
                            } else {
                                i42 = BottomSheetBehavior.this.A;
                            }
                            i5 = 3;
                        }
                    } else if (f5 != 0.0f && Math.abs(f4) <= Math.abs(f5)) {
                        if (BottomSheetBehavior.this.f23130b) {
                            i42 = BottomSheetBehavior.this.C;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - BottomSheetBehavior.this.A) < Math.abs(top2 - BottomSheetBehavior.this.C)) {
                                if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                    i42 = BottomSheetBehavior.this.C;
                                } else {
                                    i42 = BottomSheetBehavior.this.A;
                                }
                            } else {
                                i42 = BottomSheetBehavior.this.C;
                            }
                        }
                        i5 = 4;
                    } else {
                        int top3 = view.getTop();
                        if (BottomSheetBehavior.this.f23130b) {
                            if (Math.abs(top3 - BottomSheetBehavior.this.f23154z) < Math.abs(top3 - BottomSheetBehavior.this.C)) {
                                i42 = BottomSheetBehavior.this.f23154z;
                                i5 = 3;
                            } else {
                                i42 = BottomSheetBehavior.this.C;
                                i5 = 4;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                            int i7 = bottomSheetBehavior4.A;
                            if (top3 < i7) {
                                if (top3 < Math.abs(top3 - bottomSheetBehavior4.C)) {
                                    i42 = BottomSheetBehavior.this.getExpandedOffset();
                                    i5 = 3;
                                } else if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                    i42 = BottomSheetBehavior.this.C;
                                    i5 = 4;
                                } else {
                                    i42 = BottomSheetBehavior.this.A;
                                }
                            } else {
                                if (Math.abs(top3 - i7) < Math.abs(top3 - BottomSheetBehavior.this.C)) {
                                    if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                        i42 = BottomSheetBehavior.this.C;
                                    } else {
                                        i42 = BottomSheetBehavior.this.A;
                                    }
                                } else {
                                    i42 = BottomSheetBehavior.this.C;
                                }
                                i5 = 4;
                            }
                        }
                    }
                }
                BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                bottomSheetBehavior5.J(view, i5, i42, bottomSheetBehavior5.shouldSkipSmoothAnimation());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i42) {
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i5 = bottomSheetBehavior.H;
                if (i5 == 1 || bottomSheetBehavior.W) {
                    return false;
                }
                if (i5 == 3 && bottomSheetBehavior.U == i42) {
                    WeakReference<View> weakReference = bottomSheetBehavior.R;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                this.f23161a = System.currentTimeMillis();
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.Q;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
        this.f23136h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.f23137i = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i5 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i5);
        if (hasValue) {
            t(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, i5));
        } else {
            s(context, attributeSet, hasValue);
        }
        u();
        this.D = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i6 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i6)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        int i7 = R.styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (obtainStyledAttributes.hasValue(i7)) {
            setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(i7, -1));
        }
        int i8 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i8);
        if (peekValue != null && (i4 = peekValue.data) == -1) {
            setPeekHeight(i4);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i8, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i9 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i9);
        if (peekValue2 != null && peekValue2.type == 16) {
            setExpandedOffset(peekValue2.data);
        } else {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i9, 0));
        }
        this.f23143o = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f23144p = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f23145q = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f23146r = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        obtainStyledAttributes.recycle();
        this.f23132d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i4, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
    }
}
