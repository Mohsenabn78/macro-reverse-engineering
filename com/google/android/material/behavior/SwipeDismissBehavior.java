package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* loaded from: classes5.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;

    /* renamed from: a  reason: collision with root package name */
    ViewDragHelper f23056a;

    /* renamed from: b  reason: collision with root package name */
    OnDismissListener f23057b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23058c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f23060e;

    /* renamed from: d  reason: collision with root package name */
    private float f23059d = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    int f23061f = 2;

    /* renamed from: g  reason: collision with root package name */
    float f23062g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    float f23063h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    float f23064i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    private final ViewDragHelper.Callback f23065j = new ViewDragHelper.Callback() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1

        /* renamed from: a  reason: collision with root package name */
        private int f23066a;

        /* renamed from: b  reason: collision with root package name */
        private int f23067b = -1;

        private boolean a(@NonNull View view, float f4) {
            boolean z3;
            int i4 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
            if (i4 != 0) {
                if (ViewCompat.getLayoutDirection(view) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                int i5 = SwipeDismissBehavior.this.f23061f;
                if (i5 == 2) {
                    return true;
                }
                if (i5 == 0) {
                    if (z3) {
                        if (f4 >= 0.0f) {
                            return false;
                        }
                    } else if (i4 <= 0) {
                        return false;
                    }
                    return true;
                } else if (i5 != 1) {
                    return false;
                } else {
                    if (z3) {
                        if (i4 <= 0) {
                            return false;
                        }
                    } else if (f4 >= 0.0f) {
                        return false;
                    }
                    return true;
                }
            }
            int left = view.getLeft() - this.f23066a;
            if (Math.abs(left) < Math.round(view.getWidth() * SwipeDismissBehavior.this.f23062g)) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i4, int i5) {
            boolean z3;
            int width;
            int width2;
            int width3;
            if (ViewCompat.getLayoutDirection(view) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i6 = SwipeDismissBehavior.this.f23061f;
            if (i6 == 0) {
                if (z3) {
                    width = this.f23066a - view.getWidth();
                    width2 = this.f23066a;
                } else {
                    width = this.f23066a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i6 == 1) {
                if (z3) {
                    width = this.f23066a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                } else {
                    width = this.f23066a - view.getWidth();
                    width2 = this.f23066a;
                }
            } else {
                width = this.f23066a - view.getWidth();
                width2 = view.getWidth() + this.f23066a;
            }
            return SwipeDismissBehavior.b(width, i4, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i4, int i5) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@NonNull View view, int i4) {
            this.f23067b = i4;
            this.f23066a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i4) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.f23057b;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i4);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i4, int i5, int i6, int i7) {
            float width = this.f23066a + (view.getWidth() * SwipeDismissBehavior.this.f23063h);
            float width2 = this.f23066a + (view.getWidth() * SwipeDismissBehavior.this.f23064i);
            float f4 = i4;
            if (f4 <= width) {
                view.setAlpha(1.0f);
            } else if (f4 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.d(width, width2, f4), 1.0f));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f4, float f5) {
            int i4;
            boolean z3;
            OnDismissListener onDismissListener;
            this.f23067b = -1;
            int width = view.getWidth();
            if (a(view, f4)) {
                int left = view.getLeft();
                int i5 = this.f23066a;
                if (left < i5) {
                    i4 = i5 - width;
                } else {
                    i4 = i5 + width;
                }
                z3 = true;
            } else {
                i4 = this.f23066a;
                z3 = false;
            }
            if (SwipeDismissBehavior.this.f23056a.settleCapturedViewAt(i4, view.getTop())) {
                ViewCompat.postOnAnimation(view, new SettleRunnable(view, z3));
            } else if (z3 && (onDismissListener = SwipeDismissBehavior.this.f23057b) != null) {
                onDismissListener.onDismiss(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i4) {
            int i5 = this.f23067b;
            if ((i5 == -1 || i5 == i4) && SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return true;
            }
            return false;
        }
    };

    /* loaded from: classes5.dex */
    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i4);
    }

    /* loaded from: classes5.dex */
    private class SettleRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f23070a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f23071b;

        SettleRunnable(View view, boolean z3) {
            this.f23070a = view;
            this.f23071b = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f23056a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f23070a, this);
            } else if (this.f23071b && (onDismissListener = SwipeDismissBehavior.this.f23057b) != null) {
                onDismissListener.onDismiss(this.f23070a);
            }
        }
    }

    static float a(float f4, float f5, float f6) {
        return Math.min(Math.max(f4, f5), f6);
    }

    static int b(int i4, int i5, int i6) {
        return Math.min(Math.max(i4, i5), i6);
    }

    private void c(ViewGroup viewGroup) {
        ViewDragHelper create;
        if (this.f23056a == null) {
            if (this.f23060e) {
                create = ViewDragHelper.create(viewGroup, this.f23059d, this.f23065j);
            } else {
                create = ViewDragHelper.create(viewGroup, this.f23065j);
            }
            this.f23056a = create;
        }
    }

    static float d(float f4, float f5, float f6) {
        return (f6 - f4) / (f5 - f4);
    }

    private void e(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (canSwipeDismissView(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AccessibilityViewCommand() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean perform(@NonNull View view2, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    boolean z3;
                    boolean z4 = false;
                    if (!SwipeDismissBehavior.this.canSwipeDismissView(view2)) {
                        return false;
                    }
                    if (ViewCompat.getLayoutDirection(view2) == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    int i4 = SwipeDismissBehavior.this.f23061f;
                    if ((i4 == 0 && z3) || (i4 == 1 && !z3)) {
                        z4 = true;
                    }
                    int width = view2.getWidth();
                    if (z4) {
                        width = -width;
                    }
                    ViewCompat.offsetLeftAndRight(view2, width);
                    view2.setAlpha(0.0f);
                    OnDismissListener onDismissListener = SwipeDismissBehavior.this.f23057b;
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(view2);
                    }
                    return true;
                }
            });
        }
    }

    public boolean canSwipeDismissView(@NonNull View view) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper viewDragHelper = this.f23056a;
        if (viewDragHelper != null) {
            return viewDragHelper.getViewDragState();
        }
        return 0;
    }

    @Nullable
    @VisibleForTesting
    public OnDismissListener getListener() {
        return this.f23057b;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        boolean z3 = this.f23058c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f23058c = false;
            }
        } else {
            z3 = coordinatorLayout.isPointInChildBounds(v3, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f23058c = z3;
        }
        if (!z3) {
            return false;
        }
        c(coordinatorLayout);
        return this.f23056a.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i4) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v3, i4);
        if (ViewCompat.getImportantForAccessibility(v3) == 0) {
            ViewCompat.setImportantForAccessibility(v3, 1);
            e(v3);
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.f23056a;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public void setDragDismissDistance(float f4) {
        this.f23062g = a(0.0f, f4, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f4) {
        this.f23064i = a(0.0f, f4, 1.0f);
    }

    public void setListener(@Nullable OnDismissListener onDismissListener) {
        this.f23057b = onDismissListener;
    }

    public void setSensitivity(float f4) {
        this.f23059d = f4;
        this.f23060e = true;
    }

    public void setStartAlphaSwipeDistance(float f4) {
        this.f23063h = a(0.0f, f4, 1.0f);
    }

    public void setSwipeDirection(int i4) {
        this.f23061f = i4;
    }
}
