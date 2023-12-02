package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.List;

/* loaded from: classes5.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable {

    /* renamed from: r  reason: collision with root package name */
    private static final int f23288r = R.style.Widget_MaterialComponents_Chip_Action;

    /* renamed from: s  reason: collision with root package name */
    private static final Rect f23289s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    private static final int[] f23290t = {16842913};

    /* renamed from: u  reason: collision with root package name */
    private static final int[] f23291u = {16842911};
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private ChipDrawable f23292a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private InsetDrawable f23293b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private RippleDrawable f23294c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f23295d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f23296e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23297f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23298g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23299h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23300i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f23301j;

    /* renamed from: k  reason: collision with root package name */
    private int f23302k;
    @Dimension(unit = 1)

    /* renamed from: l  reason: collision with root package name */
    private int f23303l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ChipTouchHelper f23304m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f23305n;

    /* renamed from: o  reason: collision with root package name */
    private final Rect f23306o;

    /* renamed from: p  reason: collision with root package name */
    private final RectF f23307p;

    /* renamed from: q  reason: collision with root package name */
    private final TextAppearanceFontCallback f23308q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class ChipTouchHelper extends ExploreByTouchHelper {
        ChipTouchHelper(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f4, float f5) {
            if (Chip.this.k() && Chip.this.getCloseIconTouchBounds().contains(f4, f5)) {
                return 1;
            }
            return 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.k() && Chip.this.isCloseIconVisible() && Chip.this.f23295d != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i4, int i5, Bundle bundle) {
            if (i5 == 16) {
                if (i4 == 0) {
                    return Chip.this.performClick();
                }
                if (i4 == 1) {
                    return Chip.this.performCloseIconClick();
                }
                return false;
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.isCheckable());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            accessibilityNodeInfoCompat.setClassName(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.setText(text);
            } else {
                accessibilityNodeInfoCompat.setContentDescription(text);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i4, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str = "";
            if (i4 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i5 = R.string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        str = text;
                    }
                    objArr[0] = str;
                    accessibilityNodeInfoCompat.setContentDescription(context.getString(i5, objArr).trim());
                }
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.f23289s);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onVirtualViewKeyboardFocusChanged(int i4, boolean z3) {
            if (i4 == 1) {
                Chip.this.f23300i = z3;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.f23307p.setEmpty();
        if (k() && this.f23295d != null) {
            this.f23292a.getCloseIconTouchBounds(this.f23307p);
        }
        return this.f23307p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f23306o.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f23306o;
    }

    @Nullable
    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getTextAppearance();
        }
        return null;
    }

    private void h(@NonNull ChipDrawable chipDrawable) {
        chipDrawable.setDelegate(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    @NonNull
    private int[] i() {
        ?? isEnabled = isEnabled();
        int i4 = isEnabled;
        if (this.f23300i) {
            i4 = isEnabled + 1;
        }
        int i5 = i4;
        if (this.f23299h) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (this.f23298g) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (isChecked()) {
            i7 = i6 + 1;
        }
        int[] iArr = new int[i7];
        int i8 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i8 = 1;
        }
        if (this.f23300i) {
            iArr[i8] = 16842908;
            i8++;
        }
        if (this.f23299h) {
            iArr[i8] = 16843623;
            i8++;
        }
        if (this.f23298g) {
            iArr[i8] = 16842919;
            i8++;
        }
        if (isChecked()) {
            iArr[i8] = 16842913;
        }
        return iArr;
    }

    private void j() {
        if (getBackgroundDrawable() == this.f23293b && this.f23292a.getCallback() == null) {
            this.f23292a.setCallback(this.f23293b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null && chipDrawable.getCloseIcon() != null) {
            return true;
        }
        return false;
    }

    private void l(Context context, @Nullable AttributeSet attributeSet, int i4) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Chip, i4, f23288r, new int[0]);
        this.f23301j = obtainStyledAttributes.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.f23303l = (int) Math.ceil(obtainStyledAttributes.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        obtainStyledAttributes.recycle();
    }

    private void m() {
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.chip.Chip.2
            @Override // android.view.ViewOutlineProvider
            @TargetApi(21)
            public void getOutline(View view, @NonNull Outline outline) {
                if (Chip.this.f23292a != null) {
                    Chip.this.f23292a.getOutline(outline);
                } else {
                    outline.setAlpha(0.0f);
                }
            }
        });
    }

    private void n(int i4, int i5, int i6, int i7) {
        this.f23293b = new InsetDrawable((Drawable) this.f23292a, i4, i5, i6, i7);
    }

    private void o() {
        if (this.f23293b != null) {
            this.f23293b = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            r();
        }
    }

    private void p(@Nullable ChipDrawable chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.setDelegate(null);
        }
    }

    private void q() {
        if (k() && isCloseIconVisible() && this.f23295d != null) {
            ViewCompat.setAccessibilityDelegate(this, this.f23304m);
            this.f23305n = true;
            return;
        }
        ViewCompat.setAccessibilityDelegate(this, null);
        this.f23305n = false;
    }

    private void r() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            s();
            return;
        }
        this.f23292a.setUseCompatRipple(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        t();
        j();
    }

    private void s() {
        this.f23294c = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.f23292a.getRippleColor()), getBackgroundDrawable(), null);
        this.f23292a.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.f23294c);
        t();
    }

    private void setCloseIconHovered(boolean z3) {
        if (this.f23299h != z3) {
            this.f23299h = z3;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z3) {
        if (this.f23298g != z3) {
            this.f23298g = z3;
            refreshDrawableState();
        }
    }

    private void t() {
        ChipDrawable chipDrawable;
        if (!TextUtils.isEmpty(getText()) && (chipDrawable = this.f23292a) != null) {
            int chipEndPadding = (int) (chipDrawable.getChipEndPadding() + this.f23292a.getTextEndPadding() + this.f23292a.J());
            int chipStartPadding = (int) (this.f23292a.getChipStartPadding() + this.f23292a.getTextStartPadding() + this.f23292a.F());
            if (this.f23293b != null) {
                Rect rect = new Rect();
                this.f23293b.getPadding(rect);
                chipStartPadding += rect.left;
                chipEndPadding += rect.right;
            }
            ViewCompat.setPaddingRelative(this, chipStartPadding, getPaddingTop(), chipEndPadding, getPaddingBottom());
        }
    }

    private void u() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.updateDrawState(getContext(), paint, this.f23308q);
        }
    }

    private void v(@Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                                Log.w("Chip", "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.f23305n) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (!this.f23304m.dispatchHoverEvent(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f23305n) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.f23304m.dispatchKeyEvent(keyEvent) && this.f23304m.getKeyboardFocusedVirtualViewId() != Integer.MIN_VALUE) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        boolean z3;
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null && chipDrawable.isCloseIconStateful()) {
            z3 = this.f23292a.setCloseIconState(i());
        } else {
            z3 = false;
        }
        if (z3) {
            invalidate();
        }
    }

    public boolean ensureAccessibleTouchTarget(@Dimension int i4) {
        int i5;
        this.f23303l = i4;
        int i6 = 0;
        if (!shouldEnsureMinTouchTargetSize()) {
            if (this.f23293b != null) {
                o();
            } else {
                r();
            }
            return false;
        }
        int max = Math.max(0, i4 - this.f23292a.getIntrinsicHeight());
        int max2 = Math.max(0, i4 - this.f23292a.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f23293b != null) {
                o();
            } else {
                r();
            }
            return false;
        }
        if (max2 > 0) {
            i5 = max2 / 2;
        } else {
            i5 = 0;
        }
        if (max > 0) {
            i6 = max / 2;
        }
        if (this.f23293b != null) {
            Rect rect = new Rect();
            this.f23293b.getPadding(rect);
            if (rect.top == i6 && rect.bottom == i6 && rect.left == i5 && rect.right == i5) {
                r();
                return true;
            }
        }
        if (getMinHeight() != i4) {
            setMinHeight(i4);
        }
        if (getMinWidth() != i4) {
            setMinWidth(i4);
        }
        n(i5, i6, i5, i6);
        r();
        return true;
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (isCheckable()) {
            ViewParent parent = getParent();
            if ((parent instanceof ChipGroup) && ((ChipGroup) parent).isSingleSelection()) {
                return "android.widget.RadioButton";
            }
            return "android.widget.CompoundButton";
        } else if (isClickable()) {
            return "android.widget.Button";
        } else {
            return AndroidComposeViewAccessibilityDelegateCompat.ClassName;
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f23293b;
        if (insetDrawable == null) {
            return this.f23292a;
        }
        return insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getCheckedIcon();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getCheckedIconTint();
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getChipBackgroundColor();
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable == null) {
            return 0.0f;
        }
        return Math.max(0.0f, chipDrawable.getChipCornerRadius());
    }

    public Drawable getChipDrawable() {
        return this.f23292a;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getChipEndPadding();
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getChipIcon();
        }
        return null;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getChipIconSize();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getChipIconTint();
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getChipMinHeight();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getChipStartPadding();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getChipStrokeColor();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getChipStrokeWidth();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIcon();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconContentDescription();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconEndPadding();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconSize();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconStartPadding();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconTint();
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getEllipsize();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.f23305n && (this.f23304m.getKeyboardFocusedVirtualViewId() == 1 || this.f23304m.getAccessibilityFocusedVirtualViewId() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getHideMotionSpec();
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getIconEndPadding();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getIconStartPadding();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getRippleColor();
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f23292a.getShapeAppearanceModel();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getShowMotionSpec();
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getTextEndPadding();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            return chipDrawable.getTextStartPadding();
        }
        return 0.0f;
    }

    public boolean isCheckable() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null && chipDrawable.isCheckable()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null && chipDrawable.isCheckedIconVisible()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null && chipDrawable.isChipIconVisible()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null && chipDrawable.isCloseIconVisible()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.f23292a);
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.f23303l);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f23290t);
        }
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, f23291u);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z3, int i4, Rect rect) {
        super.onFocusChanged(z3, i4, rect);
        if (this.f23305n) {
            this.f23304m.onFocusChanged(z3, i4, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                setCloseIconHovered(false);
            }
        } else {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i4;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            if (chipGroup.isSingleLine()) {
                i4 = chipGroup.k(this);
            } else {
                i4 = -1;
            }
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(chipGroup.getRowIndex(this), 1, i4, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i4) {
        PointerIcon systemIcon;
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            systemIcon = PointerIcon.getSystemIcon(getContext(), 1002);
            return systemIcon;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        if (this.f23302k != i4) {
            this.f23302k = i4;
            t();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L39
            if (r0 == r2) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.f23298g
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r3)
            goto L3e
        L2b:
            boolean r0 = r5.f23298g
            if (r0 == 0) goto L34
            r5.performCloseIconClick()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r3)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r2)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L4b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
            goto L4b
        L4a:
            r2 = 0
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @CallSuper
    public boolean performCloseIconClick() {
        boolean z3 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f23295d;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z3 = true;
        }
        if (this.f23305n) {
            this.f23304m.sendEventForVirtualView(1, 1);
        }
        return z3;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f23294c) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f23294c) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i4) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z3) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCheckable(z3);
        }
    }

    public void setCheckableResource(@BoolRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCheckableResource(i4);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable == null) {
            this.f23297f = z3;
        } else if (chipDrawable.isCheckable()) {
            boolean isChecked = isChecked();
            super.setChecked(z3);
            if (isChecked != z3 && (onCheckedChangeListener = this.f23296e) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z3);
            }
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIcon(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z3) {
        setCheckedIconVisible(z3);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i4) {
        setCheckedIconVisible(i4);
    }

    public void setCheckedIconResource(@DrawableRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconResource(i4);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconTint(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconTintResource(i4);
        }
    }

    public void setCheckedIconVisible(@BoolRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconVisible(i4);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipBackgroundColor(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipBackgroundColorResource(i4);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipCornerRadius(f4);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipCornerRadiusResource(i4);
        }
    }

    public void setChipDrawable(@NonNull ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.f23292a;
        if (chipDrawable2 != chipDrawable) {
            p(chipDrawable2);
            this.f23292a = chipDrawable;
            chipDrawable.i0(false);
            h(this.f23292a);
            ensureAccessibleTouchTarget(this.f23303l);
        }
    }

    public void setChipEndPadding(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipEndPadding(f4);
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipEndPaddingResource(i4);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipIcon(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z3) {
        setChipIconVisible(z3);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i4) {
        setChipIconVisible(i4);
    }

    public void setChipIconResource(@DrawableRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipIconResource(i4);
        }
    }

    public void setChipIconSize(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipIconSize(f4);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipIconSizeResource(i4);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipIconTint(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipIconTintResource(i4);
        }
    }

    public void setChipIconVisible(@BoolRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipIconVisible(i4);
        }
    }

    public void setChipMinHeight(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipMinHeight(f4);
        }
    }

    public void setChipMinHeightResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipMinHeightResource(i4);
        }
    }

    public void setChipStartPadding(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipStartPadding(f4);
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipStartPaddingResource(i4);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeColor(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeColorResource(i4);
        }
    }

    public void setChipStrokeWidth(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeWidth(f4);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeWidthResource(i4);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i4) {
        setText(getResources().getString(i4));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIcon(drawable);
        }
        q();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconContentDescription(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z3) {
        setCloseIconVisible(z3);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i4) {
        setCloseIconVisible(i4);
    }

    public void setCloseIconEndPadding(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconEndPadding(f4);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconEndPaddingResource(i4);
        }
    }

    public void setCloseIconResource(@DrawableRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconResource(i4);
        }
        q();
    }

    public void setCloseIconSize(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconSize(f4);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconSizeResource(i4);
        }
    }

    public void setCloseIconStartPadding(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconStartPadding(f4);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconStartPaddingResource(i4);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconTint(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconTintResource(i4);
        }
    }

    public void setCloseIconVisible(@BoolRes int i4) {
        setCloseIconVisible(getResources().getBoolean(i4));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i4, i5, i6, i7);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i4, i5, i6, i7);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setElevation(f4);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f23292a == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            ChipDrawable chipDrawable = this.f23292a;
            if (chipDrawable != null) {
                chipDrawable.setEllipsize(truncateAt);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z3) {
        this.f23301j = z3;
        ensureAccessibleTouchTarget(this.f23303l);
    }

    @Override // android.widget.TextView
    public void setGravity(int i4) {
        if (i4 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i4);
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setHideMotionSpec(motionSpec);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setHideMotionSpecResource(i4);
        }
    }

    public void setIconEndPadding(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setIconEndPadding(f4);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setIconEndPaddingResource(i4);
        }
    }

    public void setIconStartPadding(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setIconStartPadding(f4);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setIconStartPaddingResource(i4);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i4) {
        if (this.f23292a == null) {
            return;
        }
        super.setLayoutDirection(i4);
    }

    @Override // android.widget.TextView
    public void setLines(int i4) {
        if (i4 <= 1) {
            super.setLines(i4);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i4) {
        if (i4 <= 1) {
            super.setMaxLines(i4);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i4) {
        super.setMaxWidth(i4);
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setMaxWidth(i4);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i4) {
        if (i4 <= 1) {
            super.setMinLines(i4);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f23296e = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f23295d = onClickListener;
        q();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setRippleColor(colorStateList);
        }
        if (!this.f23292a.getUseCompatRipple()) {
            s();
        }
    }

    public void setRippleColorResource(@ColorRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setRippleColorResource(i4);
            if (!this.f23292a.getUseCompatRipple()) {
                s();
            }
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f23292a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setShowMotionSpec(motionSpec);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setShowMotionSpecResource(i4);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z3) {
        if (z3) {
            super.setSingleLine(z3);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (chipDrawable.j0()) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        super.setText(charSequence2, bufferType);
        ChipDrawable chipDrawable2 = this.f23292a;
        if (chipDrawable2 != null) {
            chipDrawable2.setText(charSequence);
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearance(textAppearance);
        }
        u();
    }

    public void setTextAppearanceResource(@StyleRes int i4) {
        setTextAppearance(getContext(), i4);
    }

    public void setTextEndPadding(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setTextEndPadding(f4);
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setTextEndPaddingResource(i4);
        }
    }

    public void setTextStartPadding(float f4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setTextStartPadding(f4);
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i4) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setTextStartPaddingResource(i4);
        }
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.f23301j;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z3) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconVisible(z3);
        }
        q();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.Chip.f23288r
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.f23306o = r8
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.f23307p = r8
            com.google.android.material.chip.Chip$1 r8 = new com.google.android.material.chip.Chip$1
            r8.<init>()
            r7.f23308q = r8
            android.content.Context r8 = r7.getContext()
            r7.v(r9)
            com.google.android.material.chip.ChipDrawable r6 = com.google.android.material.chip.ChipDrawable.createFromAttributes(r8, r9, r10, r4)
            r7.l(r8, r9, r10)
            r7.setChipDrawable(r6)
            float r0 = androidx.core.view.ViewCompat.getElevation(r7)
            r6.setElevation(r0)
            int[] r2 = com.google.android.material.R.styleable.Chip
            r0 = 0
            int[] r5 = new int[r0]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r10 >= r0) goto L51
            int r10 = com.google.android.material.R.styleable.Chip_android_textColor
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.getColorStateList(r8, r9, r10)
            r7.setTextColor(r8)
        L51:
            int r8 = com.google.android.material.R.styleable.Chip_shapeAppearance
            boolean r8 = r9.hasValue(r8)
            r9.recycle()
            com.google.android.material.chip.Chip$ChipTouchHelper r9 = new com.google.android.material.chip.Chip$ChipTouchHelper
            r9.<init>(r7)
            r7.f23304m = r9
            r7.q()
            if (r8 != 0) goto L69
            r7.m()
        L69:
            boolean r8 = r7.f23297f
            r7.setChecked(r8)
            java.lang.CharSequence r8 = r6.getText()
            r7.setText(r8)
            android.text.TextUtils$TruncateAt r8 = r6.getEllipsize()
            r7.setEllipsize(r8)
            r7.u()
            com.google.android.material.chip.ChipDrawable r8 = r7.f23292a
            boolean r8 = r8.j0()
            if (r8 != 0) goto L8e
            r8 = 1
            r7.setLines(r8)
            r7.setHorizontallyScrolling(r8)
        L8e:
            r8 = 8388627(0x800013, float:1.175497E-38)
            r7.setGravity(r8)
            r7.t()
            boolean r8 = r7.shouldEnsureMinTouchTargetSize()
            if (r8 == 0) goto La2
            int r8 = r7.f23303l
            r7.setMinHeight(r8)
        La2:
            int r8 = androidx.core.view.ViewCompat.getLayoutDirection(r7)
            r7.f23302k = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedIconVisible(boolean z3) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconVisible(z3);
        }
    }

    public void setChipIconVisible(boolean z3) {
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setChipIconVisible(z3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(i4);
        }
        u();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i4) {
        super.setTextAppearance(i4);
        ChipDrawable chipDrawable = this.f23292a;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(i4);
        }
        u();
    }
}
