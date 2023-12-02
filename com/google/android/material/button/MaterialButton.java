package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes5.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f23195n = {16842911};

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f23196o = {16842912};

    /* renamed from: p  reason: collision with root package name */
    private static final int f23197p = R.style.Widget_MaterialComponents_Button;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButtonHelper f23198a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final LinkedHashSet<OnCheckedChangeListener> f23199b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private OnPressedChangeListener f23200c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f23201d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f23202e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Drawable f23203f;
    @Px

    /* renamed from: g  reason: collision with root package name */
    private int f23204g;
    @Px

    /* renamed from: h  reason: collision with root package name */
    private int f23205h;
    @Px

    /* renamed from: i  reason: collision with root package name */
    private int f23206i;
    @Px

    /* renamed from: j  reason: collision with root package name */
    private int f23207j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23208k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f23209l;

    /* renamed from: m  reason: collision with root package name */
    private int f23210m;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface IconGravity {
    }

    /* loaded from: classes5.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z3);
    }

    /* loaded from: classes5.dex */
    interface OnPressedChangeListener {
        void a(MaterialButton materialButton, boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.button.MaterialButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
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
        boolean f23211a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel) {
            boolean z3 = true;
            if (parcel.readInt() != 1) {
                z3 = false;
            }
            this.f23211a = z3;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f23211a ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    private boolean a() {
        int i4 = this.f23210m;
        if (i4 != 3 && i4 != 4) {
            return false;
        }
        return true;
    }

    private boolean b() {
        int i4 = this.f23210m;
        if (i4 == 1 || i4 == 2) {
            return true;
        }
        return false;
    }

    private boolean c() {
        int i4 = this.f23210m;
        if (i4 != 16 && i4 != 32) {
            return false;
        }
        return true;
    }

    private boolean d() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    private boolean e() {
        MaterialButtonHelper materialButtonHelper = this.f23198a;
        if (materialButtonHelper != null && !materialButtonHelper.o()) {
            return true;
        }
        return false;
    }

    private void f() {
        if (b()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.f23203f, null, null, null);
        } else if (a()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.f23203f, null);
        } else if (c()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.f23203f, null, null);
        }
    }

    private void g(boolean z3) {
        Drawable drawable = this.f23203f;
        boolean z4 = true;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.f23203f = mutate;
            DrawableCompat.setTintList(mutate, this.f23202e);
            PorterDuff.Mode mode = this.f23201d;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f23203f, mode);
            }
            int i4 = this.f23204g;
            if (i4 == 0) {
                i4 = this.f23203f.getIntrinsicWidth();
            }
            int i5 = this.f23204g;
            if (i5 == 0) {
                i5 = this.f23203f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f23203f;
            int i6 = this.f23205h;
            int i7 = this.f23206i;
            drawable2.setBounds(i6, i7, i4 + i6, i5 + i7);
            this.f23203f.setVisible(true, z3);
        }
        if (z3) {
            f();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((!b() || drawable3 == this.f23203f) && ((!a() || drawable5 == this.f23203f) && (!c() || drawable4 == this.f23203f))) {
            z4 = false;
        }
        if (z4) {
            f();
        }
    }

    @NonNull
    private String getA11yClassName() {
        Class cls;
        if (isCheckable()) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    private void h(int i4, int i5) {
        if (this.f23203f != null && getLayout() != null) {
            if (!b() && !a()) {
                if (c()) {
                    this.f23205h = 0;
                    if (this.f23210m == 16) {
                        this.f23206i = 0;
                        g(false);
                        return;
                    }
                    int i6 = this.f23204g;
                    if (i6 == 0) {
                        i6 = this.f23203f.getIntrinsicHeight();
                    }
                    int textHeight = (((((i5 - getTextHeight()) - getPaddingTop()) - i6) - this.f23207j) - getPaddingBottom()) / 2;
                    if (this.f23206i != textHeight) {
                        this.f23206i = textHeight;
                        g(false);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f23206i = 0;
            int i7 = this.f23210m;
            boolean z3 = true;
            if (i7 != 1 && i7 != 3) {
                int i8 = this.f23204g;
                if (i8 == 0) {
                    i8 = this.f23203f.getIntrinsicWidth();
                }
                int textWidth = (((((i4 - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - i8) - this.f23207j) - ViewCompat.getPaddingStart(this)) / 2;
                boolean d4 = d();
                if (this.f23210m != 4) {
                    z3 = false;
                }
                if (d4 != z3) {
                    textWidth = -textWidth;
                }
                if (this.f23205h != textWidth) {
                    this.f23205h = textWidth;
                    g(false);
                    return;
                }
                return;
            }
            this.f23205h = 0;
            g(false);
        }
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.f23199b.add(onCheckedChangeListener);
    }

    public void clearOnCheckedChangeListeners() {
        this.f23199b.clear();
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (e()) {
            return this.f23198a.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f23203f;
    }

    public int getIconGravity() {
        return this.f23210m;
    }

    @Px
    public int getIconPadding() {
        return this.f23207j;
    }

    @Px
    public int getIconSize() {
        return this.f23204g;
    }

    public ColorStateList getIconTint() {
        return this.f23202e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f23201d;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f23198a.c();
    }

    @Dimension
    public int getInsetTop() {
        return this.f23198a.d();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f23198a.h();
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (e()) {
            return this.f23198a.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f23198a.j();
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (e()) {
            return this.f23198a.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (e()) {
            return this.f23198a.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (e()) {
            return this.f23198a.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        MaterialButtonHelper materialButtonHelper = this.f23198a;
        if (materialButtonHelper != null && materialButtonHelper.p()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f23208k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.f23198a.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, f23195n);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f23196o);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        MaterialButtonHelper materialButtonHelper;
        super.onLayout(z3, i4, i5, i6, i7);
        if (Build.VERSION.SDK_INT == 21 && (materialButtonHelper = this.f23198a) != null) {
            materialButtonHelper.H(i7 - i5, i6 - i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f23211a);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f23211a = this.f23208k;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        h(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f23203f != null) {
            if (this.f23203f.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.f23199b.remove(onCheckedChangeListener);
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i4) {
        if (e()) {
            this.f23198a.r(i4);
        } else {
            super.setBackgroundColor(i4);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (e()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.f23198a.s();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        Drawable drawable;
        if (i4 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), i4);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z3) {
        if (e()) {
            this.f23198a.t(z3);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        if (isCheckable() && isEnabled() && this.f23208k != z3) {
            this.f23208k = z3;
            refreshDrawableState();
            if (this.f23209l) {
                return;
            }
            this.f23209l = true;
            Iterator<OnCheckedChangeListener> it = this.f23199b.iterator();
            while (it.hasNext()) {
                it.next().onCheckedChanged(this, this.f23208k);
            }
            this.f23209l = false;
        }
    }

    public void setCornerRadius(@Px int i4) {
        if (e()) {
            this.f23198a.u(i4);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i4) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i4));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        if (e()) {
            this.f23198a.f().setElevation(f4);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f23203f != drawable) {
            this.f23203f = drawable;
            g(true);
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i4) {
        if (this.f23210m != i4) {
            this.f23210m = i4;
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i4) {
        if (this.f23207j != i4) {
            this.f23207j = i4;
            setCompoundDrawablePadding(i4);
        }
    }

    public void setIconResource(@DrawableRes int i4) {
        Drawable drawable;
        if (i4 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), i4);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(@Px int i4) {
        if (i4 >= 0) {
            if (this.f23204g != i4) {
                this.f23204g = i4;
                g(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f23202e != colorStateList) {
            this.f23202e = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f23201d != mode) {
            this.f23201d = mode;
            g(false);
        }
    }

    public void setIconTintResource(@ColorRes int i4) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i4));
    }

    public void setInsetBottom(@Dimension int i4) {
        this.f23198a.v(i4);
    }

    public void setInsetTop(@Dimension int i4) {
        this.f23198a.w(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(@Nullable OnPressedChangeListener onPressedChangeListener) {
        this.f23200c = onPressedChangeListener;
    }

    @Override // android.view.View
    public void setPressed(boolean z3) {
        OnPressedChangeListener onPressedChangeListener = this.f23200c;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.a(this, z3);
        }
        super.setPressed(z3);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.f23198a.x(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i4) {
        if (e()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i4));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (e()) {
            this.f23198a.y(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z3) {
        if (e()) {
            this.f23198a.z(z3);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.f23198a.A(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i4) {
        if (e()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i4));
        }
    }

    public void setStrokeWidth(@Px int i4) {
        if (e()) {
            this.f23198a.B(i4);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i4) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i4));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.f23198a.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (e()) {
            this.f23198a.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f23208k);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.f23197p
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f23199b = r9
            r9 = 0
            r8.f23208k = r9
            r8.f23209l = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButton
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconPadding
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f23207j = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.parseTintMode(r1, r2)
            r8.f23201d = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.getColorStateList(r1, r0, r2)
            r8.f23202e = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r1 = com.google.android.material.resources.MaterialResources.getDrawable(r1, r0, r2)
            r8.f23203f = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconGravity
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f23210m = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconSize
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f23204g = r1
            com.google.android.material.shape.ShapeAppearanceModel$Builder r10 = com.google.android.material.shape.ShapeAppearanceModel.builder(r7, r10, r11, r6)
            com.google.android.material.shape.ShapeAppearanceModel r10 = r10.build()
            com.google.android.material.button.MaterialButtonHelper r11 = new com.google.android.material.button.MaterialButtonHelper
            r11.<init>(r8, r10)
            r8.f23198a = r11
            r11.q(r0)
            r0.recycle()
            int r10 = r8.f23207j
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f23203f
            if (r10 == 0) goto L84
            r9 = 1
        L84:
            r8.g(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
