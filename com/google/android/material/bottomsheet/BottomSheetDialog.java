package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;

/* loaded from: classes5.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* renamed from: a  reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f23174a;

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f23175b;

    /* renamed from: c  reason: collision with root package name */
    private CoordinatorLayout f23176c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f23177d;

    /* renamed from: e  reason: collision with root package name */
    boolean f23178e;

    /* renamed from: f  reason: collision with root package name */
    boolean f23179f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23180g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23181h;

    /* renamed from: i  reason: collision with root package name */
    private BottomSheetBehavior.BottomSheetCallback f23182i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f23183j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private BottomSheetBehavior.BottomSheetCallback f23184k;

    /* loaded from: classes5.dex */
    private static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f23190a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f23191b;

        /* renamed from: c  reason: collision with root package name */
        private final WindowInsetsCompat f23192c;

        private void a(View view) {
            if (view.getTop() < this.f23192c.getSystemWindowInsetTop()) {
                BottomSheetDialog.setLightStatusBar(view, this.f23190a);
                view.setPadding(view.getPaddingLeft(), this.f23192c.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                BottomSheetDialog.setLightStatusBar(view, this.f23191b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View view, float f4) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View view, int i4) {
            a(view);
        }

        private EdgeToEdgeCallback(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ColorStateList backgroundTintList;
            this.f23192c = windowInsetsCompat;
            boolean z3 = Build.VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & 8192) != 0;
            this.f23191b = z3;
            MaterialShapeDrawable y3 = BottomSheetBehavior.from(view).y();
            if (y3 != null) {
                backgroundTintList = y3.getFillColor();
            } else {
                backgroundTintList = ViewCompat.getBackgroundTintList(view);
            }
            if (backgroundTintList != null) {
                this.f23190a = MaterialColors.isColorLight(backgroundTintList.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f23190a = MaterialColors.isColorLight(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.f23190a = z3;
            }
        }
    }

    public BottomSheetDialog(@NonNull Context context) {
        this(context, 0);
        this.f23183j = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private FrameLayout f() {
        if (this.f23175b == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.f23175b = frameLayout;
            this.f23176c = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f23175b.findViewById(R.id.design_bottom_sheet);
            this.f23177d = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.f23174a = from;
            from.addBottomSheetCallback(this.f23184k);
            this.f23174a.setHideable(this.f23179f);
        }
        return this.f23175b;
    }

    private static int getThemeResId(@NonNull Context context, int i4) {
        if (i4 == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
                return typedValue.resourceId;
            }
            return R.style.Theme_Design_Light_BottomSheetDialog;
        }
        return i4;
    }

    private View i(int i4, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        f();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f23175b.findViewById(R.id.coordinator);
        if (i4 != 0 && view == null) {
            view = getLayoutInflater().inflate(i4, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f23183j) {
            ViewCompat.setOnApplyWindowInsetsListener(this.f23177d, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    if (BottomSheetDialog.this.f23182i != null) {
                        BottomSheetDialog.this.f23174a.removeBottomSheetCallback(BottomSheetDialog.this.f23182i);
                    }
                    if (windowInsetsCompat != null) {
                        BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                        bottomSheetDialog.f23182i = new EdgeToEdgeCallback(bottomSheetDialog.f23177d, windowInsetsCompat);
                        BottomSheetDialog.this.f23174a.addBottomSheetCallback(BottomSheetDialog.this.f23182i);
                    }
                    return windowInsetsCompat;
                }
            });
        }
        this.f23177d.removeAllViews();
        if (layoutParams == null) {
            this.f23177d.addView(view);
        } else {
            this.f23177d.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f23179f && bottomSheetDialog.isShowing() && BottomSheetDialog.this.h()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.setAccessibilityDelegate(this.f23177d, new AccessibilityDelegateCompat() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.3
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                if (BottomSheetDialog.this.f23179f) {
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                    return;
                }
                accessibilityNodeInfoCompat.setDismissable(false);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view2, int i5, Bundle bundle) {
                if (i5 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.f23179f) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view2, i5, bundle);
            }
        });
        this.f23177d.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.f23175b;
    }

    public static void setLightStatusBar(@NonNull View view, boolean z3) {
        int i4;
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            if (z3) {
                i4 = systemUiVisibility | 8192;
            } else {
                i4 = systemUiVisibility & (-8193);
            }
            view.setSystemUiVisibility(i4);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        if (this.f23178e && behavior.getState() != 5) {
            behavior.setState(5);
        } else {
            super.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f23174a.removeBottomSheetCallback(this.f23184k);
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.f23174a == null) {
            f();
        }
        return this.f23174a;
    }

    public boolean getDismissWithAnimation() {
        return this.f23178e;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.f23183j;
    }

    boolean h() {
        if (!this.f23181h) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f23180g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f23181h = true;
        }
        return this.f23180g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        boolean z3;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            if (this.f23183j && Color.alpha(window.getNavigationBarColor()) < 255) {
                z3 = true;
            } else {
                z3 = false;
            }
            FrameLayout frameLayout = this.f23175b;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z3);
            }
            CoordinatorLayout coordinatorLayout = this.f23176c;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z3);
            }
            if (z3) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i4 = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (i4 < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f23174a;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5) {
            this.f23174a.setState(4);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z3) {
        super.setCancelable(z3);
        if (this.f23179f != z3) {
            this.f23179f = z3;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f23174a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z3);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z3) {
        super.setCanceledOnTouchOutside(z3);
        if (z3 && !this.f23179f) {
            this.f23179f = true;
        }
        this.f23180g = z3;
        this.f23181h = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i4) {
        super.setContentView(i(i4, null, null));
    }

    public void setDismissWithAnimation(boolean z3) {
        this.f23178e = z3;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(i(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(i(0, view, layoutParams));
    }

    public BottomSheetDialog(@NonNull Context context, @StyleRes int i4) {
        super(context, getThemeResId(context, i4));
        this.f23179f = true;
        this.f23180g = true;
        this.f23184k = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.5
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NonNull View view, int i5) {
                if (i5 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NonNull View view, float f4) {
            }
        };
        supportRequestWindowFeature(1);
        this.f23183j = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
