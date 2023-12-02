package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class DropdownMenuEndIconDelegate extends EndIconDelegate {

    /* renamed from: r  reason: collision with root package name */
    private static final boolean f24566r = true;

    /* renamed from: e  reason: collision with root package name */
    private final TextWatcher f24567e;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnFocusChangeListener f24568f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.AccessibilityDelegate f24569g;

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.OnEditTextAttachedListener f24570h;
    @SuppressLint({"ClickableViewAccessibility"})

    /* renamed from: i  reason: collision with root package name */
    private final TextInputLayout.OnEndIconChangedListener f24571i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24572j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24573k;

    /* renamed from: l  reason: collision with root package name */
    private long f24574l;

    /* renamed from: m  reason: collision with root package name */
    private StateListDrawable f24575m;

    /* renamed from: n  reason: collision with root package name */
    private MaterialShapeDrawable f24576n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private AccessibilityManager f24577o;

    /* renamed from: p  reason: collision with root package name */
    private ValueAnimator f24578p;

    /* renamed from: q  reason: collision with root package name */
    private ValueAnimator f24579q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropdownMenuEndIconDelegate(@NonNull TextInputLayout textInputLayout, @DrawableRes int i4) {
        super(textInputLayout, i4);
        this.f24567e = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                final AutoCompleteTextView y3 = DropdownMenuEndIconDelegate.y(DropdownMenuEndIconDelegate.this.f24595a.getEditText());
                if (DropdownMenuEndIconDelegate.this.f24577o.isTouchExplorationEnabled() && DropdownMenuEndIconDelegate.D(y3) && !DropdownMenuEndIconDelegate.this.f24597c.hasFocus()) {
                    y3.dismissDropDown();
                }
                y3.post(new Runnable() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean isPopupShowing = y3.isPopupShowing();
                        DropdownMenuEndIconDelegate.this.E(isPopupShowing);
                        DropdownMenuEndIconDelegate.this.f24572j = isPopupShowing;
                    }
                });
            }
        };
        this.f24568f = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z3) {
                DropdownMenuEndIconDelegate.this.f24595a.setEndIconActivated(z3);
                if (!z3) {
                    DropdownMenuEndIconDelegate.this.E(false);
                    DropdownMenuEndIconDelegate.this.f24572j = false;
                }
            }
        };
        this.f24569g = new TextInputLayout.AccessibilityDelegate(this.f24595a) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (!DropdownMenuEndIconDelegate.D(DropdownMenuEndIconDelegate.this.f24595a.getEditText())) {
                    accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
                }
                if (accessibilityNodeInfoCompat.isShowingHintText()) {
                    accessibilityNodeInfoCompat.setHintText(null);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                AutoCompleteTextView y3 = DropdownMenuEndIconDelegate.y(DropdownMenuEndIconDelegate.this.f24595a.getEditText());
                if (accessibilityEvent.getEventType() == 1 && DropdownMenuEndIconDelegate.this.f24577o.isTouchExplorationEnabled() && !DropdownMenuEndIconDelegate.D(DropdownMenuEndIconDelegate.this.f24595a.getEditText())) {
                    DropdownMenuEndIconDelegate.this.H(y3);
                }
            }
        };
        this.f24570h = new TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.4
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout2) {
                AutoCompleteTextView y3 = DropdownMenuEndIconDelegate.y(textInputLayout2.getEditText());
                DropdownMenuEndIconDelegate.this.F(y3);
                DropdownMenuEndIconDelegate.this.v(y3);
                DropdownMenuEndIconDelegate.this.G(y3);
                y3.setThreshold(0);
                y3.removeTextChangedListener(DropdownMenuEndIconDelegate.this.f24567e);
                y3.addTextChangedListener(DropdownMenuEndIconDelegate.this.f24567e);
                textInputLayout2.setEndIconCheckable(true);
                textInputLayout2.setErrorIconDrawable((Drawable) null);
                if (!DropdownMenuEndIconDelegate.D(y3)) {
                    ViewCompat.setImportantForAccessibility(DropdownMenuEndIconDelegate.this.f24597c, 2);
                }
                textInputLayout2.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.this.f24569g);
                textInputLayout2.setEndIconVisible(true);
            }
        };
        this.f24571i = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public void onEndIconChanged(@NonNull TextInputLayout textInputLayout2, int i5) {
                final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout2.getEditText();
                if (autoCompleteTextView != null && i5 == 3) {
                    autoCompleteTextView.post(new Runnable() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            autoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.this.f24567e);
                        }
                    });
                    if (autoCompleteTextView.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.this.f24568f) {
                        autoCompleteTextView.setOnFocusChangeListener(null);
                    }
                    autoCompleteTextView.setOnTouchListener(null);
                    if (DropdownMenuEndIconDelegate.f24566r) {
                        autoCompleteTextView.setOnDismissListener(null);
                    }
                }
            }
        };
        this.f24572j = false;
        this.f24573k = false;
        this.f24574l = Long.MAX_VALUE;
    }

    private MaterialShapeDrawable A(float f4, float f5, float f6, int i4) {
        ShapeAppearanceModel build = ShapeAppearanceModel.builder().setTopLeftCornerSize(f4).setTopRightCornerSize(f4).setBottomLeftCornerSize(f5).setBottomRightCornerSize(f5).build();
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.f24596b, f6);
        createWithElevationOverlay.setShapeAppearanceModel(build);
        createWithElevationOverlay.setPadding(0, i4, 0, i4);
        return createWithElevationOverlay;
    }

    private void B() {
        this.f24579q = z(67, 0.0f, 1.0f);
        ValueAnimator z3 = z(50, 1.0f, 0.0f);
        this.f24578p = z3;
        z3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                dropdownMenuEndIconDelegate.f24597c.setChecked(dropdownMenuEndIconDelegate.f24573k);
                DropdownMenuEndIconDelegate.this.f24579q.start();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        long currentTimeMillis = System.currentTimeMillis() - this.f24574l;
        if (currentTimeMillis >= 0 && currentTimeMillis <= 300) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(@NonNull EditText editText) {
        if (editText.getKeyListener() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z3) {
        if (this.f24573k != z3) {
            this.f24573k = z3;
            this.f24579q.cancel();
            this.f24578p.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (f24566r) {
            int boxBackgroundMode = this.f24595a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f24576n);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f24575m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void G(@NonNull final AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (DropdownMenuEndIconDelegate.this.C()) {
                        DropdownMenuEndIconDelegate.this.f24572j = false;
                    }
                    DropdownMenuEndIconDelegate.this.H(autoCompleteTextView);
                }
                return false;
            }
        });
        autoCompleteTextView.setOnFocusChangeListener(this.f24568f);
        if (f24566r) {
            autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.8
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public void onDismiss() {
                    DropdownMenuEndIconDelegate.this.f24572j = true;
                    DropdownMenuEndIconDelegate.this.f24574l = System.currentTimeMillis();
                    DropdownMenuEndIconDelegate.this.E(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(@Nullable AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (C()) {
            this.f24572j = false;
        }
        if (!this.f24572j) {
            if (f24566r) {
                E(!this.f24573k);
            } else {
                this.f24573k = !this.f24573k;
                this.f24597c.toggle();
            }
            if (this.f24573k) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            }
            autoCompleteTextView.dismissDropDown();
            return;
        }
        this.f24572j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (D(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.f24595a.getBoxBackgroundMode();
        MaterialShapeDrawable boxBackground = this.f24595a.getBoxBackground();
        int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorControlHighlight);
        int[][] iArr = {new int[]{16842919}, new int[0]};
        if (boxBackgroundMode == 2) {
            x(autoCompleteTextView, color, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            w(autoCompleteTextView, color, iArr, boxBackground);
        }
    }

    private void w(@NonNull AutoCompleteTextView autoCompleteTextView, int i4, int[][] iArr, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        int boxBackgroundColor = this.f24595a.getBoxBackgroundColor();
        int[] iArr2 = {MaterialColors.layer(i4, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f24566r) {
            ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), materialShapeDrawable, materialShapeDrawable));
            return;
        }
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable, materialShapeDrawable2});
        int paddingStart = ViewCompat.getPaddingStart(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    private void x(@NonNull AutoCompleteTextView autoCompleteTextView, int i4, int[][] iArr, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        LayerDrawable layerDrawable;
        int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorSurface);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        int layer = MaterialColors.layer(i4, color, 0.1f);
        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, new int[]{layer, 0}));
        if (f24566r) {
            materialShapeDrawable2.setTint(color);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{layer, color});
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
            materialShapeDrawable3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable});
        }
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int i4, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(i4);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.f24597c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void a() {
        float dimensionPixelOffset = this.f24596b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f24596b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f24596b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable A = A(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable A2 = A(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f24576n = A;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f24575m = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, A);
        this.f24575m.addState(new int[0], A2);
        int i4 = this.f24598d;
        if (i4 == 0) {
            if (f24566r) {
                i4 = R.drawable.mtrl_dropdown_arrow;
            } else {
                i4 = R.drawable.mtrl_ic_arrow_drop_down;
            }
        }
        this.f24595a.setEndIconDrawable(i4);
        TextInputLayout textInputLayout = this.f24595a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.f24595a.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DropdownMenuEndIconDelegate.this.H((AutoCompleteTextView) DropdownMenuEndIconDelegate.this.f24595a.getEditText());
            }
        });
        this.f24595a.addOnEditTextAttachedListener(this.f24570h);
        this.f24595a.addOnEndIconChangedListener(this.f24571i);
        B();
        this.f24577o = (AccessibilityManager) this.f24596b.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean b(int i4) {
        if (i4 != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean d() {
        return true;
    }
}
