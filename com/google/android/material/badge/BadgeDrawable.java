package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    @StyleRes

    /* renamed from: q  reason: collision with root package name */
    private static final int f23010q = R.style.Widget_MaterialComponents_Badge;
    @AttrRes

    /* renamed from: r  reason: collision with root package name */
    private static final int f23011r = R.attr.badgeStyle;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f23012a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final MaterialShapeDrawable f23013b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextDrawableHelper f23014c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Rect f23015d;

    /* renamed from: e  reason: collision with root package name */
    private float f23016e;

    /* renamed from: f  reason: collision with root package name */
    private float f23017f;

    /* renamed from: g  reason: collision with root package name */
    private float f23018g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final SavedState f23019h;

    /* renamed from: i  reason: collision with root package name */
    private float f23020i;

    /* renamed from: j  reason: collision with root package name */
    private float f23021j;

    /* renamed from: k  reason: collision with root package name */
    private int f23022k;

    /* renamed from: l  reason: collision with root package name */
    private float f23023l;

    /* renamed from: m  reason: collision with root package name */
    private float f23024m;

    /* renamed from: n  reason: collision with root package name */
    private float f23025n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private WeakReference<View> f23026o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private WeakReference<FrameLayout> f23027p;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface BadgeGravity {
    }

    private BadgeDrawable(@NonNull Context context) {
        this.f23012a = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        Resources resources = context.getResources();
        this.f23015d = new Rect();
        this.f23013b = new MaterialShapeDrawable();
        this.f23016e = resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.f23018g = resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.f23017f = resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f23014c = textDrawableHelper;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.f23019h = new SavedState(context);
        n(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private void a(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i4;
        float f4;
        float f5;
        float f6;
        int g4 = g();
        int i5 = this.f23019h.f23039i;
        if (i5 != 8388691 && i5 != 8388693) {
            this.f23021j = rect.top + g4;
        } else {
            this.f23021j = rect.bottom - g4;
        }
        if (getNumber() <= 9) {
            if (!hasNumber()) {
                f6 = this.f23016e;
            } else {
                f6 = this.f23017f;
            }
            this.f23023l = f6;
            this.f23025n = f6;
            this.f23024m = f6;
        } else {
            float f7 = this.f23017f;
            this.f23023l = f7;
            this.f23025n = f7;
            this.f23024m = (this.f23014c.getTextWidth(e()) / 2.0f) + this.f23018g;
        }
        Resources resources = context.getResources();
        if (hasNumber()) {
            i4 = R.dimen.mtrl_badge_text_horizontal_edge_offset;
        } else {
            i4 = R.dimen.mtrl_badge_horizontal_edge_offset;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i4);
        int f8 = f();
        int i6 = this.f23019h.f23039i;
        if (i6 != 8388659 && i6 != 8388691) {
            if (ViewCompat.getLayoutDirection(view) == 0) {
                f5 = ((rect.right + this.f23024m) - dimensionPixelSize) - f8;
            } else {
                f5 = (rect.left - this.f23024m) + dimensionPixelSize + f8;
            }
            this.f23020i = f5;
            return;
        }
        if (ViewCompat.getLayoutDirection(view) == 0) {
            f4 = (rect.left - this.f23024m) + dimensionPixelSize + f8;
        } else {
            f4 = ((rect.right + this.f23024m) - dimensionPixelSize) - f8;
        }
        this.f23020i = f4;
    }

    @NonNull
    private static BadgeDrawable b(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.h(context, attributeSet, i4, i5);
        return badgeDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static BadgeDrawable c(@NonNull Context context, @NonNull SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.j(savedState);
        return badgeDrawable;
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context context) {
        return b(context, null, f23011r, f23010q);
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context context, @XmlRes int i4) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i4, "badge");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = f23010q;
        }
        return b(context, parseDrawableXml, f23011r, styleAttribute);
    }

    private void d(Canvas canvas) {
        Rect rect = new Rect();
        String e4 = e();
        this.f23014c.getTextPaint().getTextBounds(e4, 0, e4.length(), rect);
        canvas.drawText(e4, this.f23020i, this.f23021j + (rect.height() / 2), this.f23014c.getTextPaint());
    }

    @NonNull
    private String e() {
        if (getNumber() <= this.f23022k) {
            return NumberFormat.getInstance().format(getNumber());
        }
        Context context = this.f23012a.get();
        if (context == null) {
            return "";
        }
        return context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.f23022k), Marker.ANY_NON_NULL_MARKER);
    }

    private int f() {
        return (hasNumber() ? this.f23019h.f23043m : this.f23019h.f23041k) + this.f23019h.f23045o;
    }

    private int g() {
        return (hasNumber() ? this.f23019h.f23044n : this.f23019h.f23042l) + this.f23019h.f23046p;
    }

    private void h(Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Badge, i4, i5, new int[0]);
        setMaxCharacterCount(obtainStyledAttributes.getInt(R.styleable.Badge_maxCharacterCount, 4));
        int i6 = R.styleable.Badge_number;
        if (obtainStyledAttributes.hasValue(i6)) {
            setNumber(obtainStyledAttributes.getInt(i6, 0));
        }
        setBackgroundColor(i(context, obtainStyledAttributes, R.styleable.Badge_backgroundColor));
        int i7 = R.styleable.Badge_badgeTextColor;
        if (obtainStyledAttributes.hasValue(i7)) {
            setBadgeTextColor(i(context, obtainStyledAttributes, i7));
        }
        setBadgeGravity(obtainStyledAttributes.getInt(R.styleable.Badge_badgeGravity, TOP_END));
        setHorizontalOffsetWithoutText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        setVerticalOffsetWithoutText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        setHorizontalOffsetWithText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, getHorizontalOffsetWithoutText()));
        setVerticalOffsetWithText(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, getVerticalOffsetWithoutText()));
        int i8 = R.styleable.Badge_badgeRadius;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.f23016e = obtainStyledAttributes.getDimensionPixelSize(i8, (int) this.f23016e);
        }
        int i9 = R.styleable.Badge_badgeWidePadding;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.f23018g = obtainStyledAttributes.getDimensionPixelSize(i9, (int) this.f23018g);
        }
        int i10 = R.styleable.Badge_badgeWithTextRadius;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f23017f = obtainStyledAttributes.getDimensionPixelSize(i10, (int) this.f23017f);
        }
        obtainStyledAttributes.recycle();
    }

    private static int i(Context context, @NonNull TypedArray typedArray, @StyleableRes int i4) {
        return MaterialResources.getColorStateList(context, typedArray, i4).getDefaultColor();
    }

    private void j(@NonNull SavedState savedState) {
        setMaxCharacterCount(savedState.f23035e);
        if (savedState.f23034d != -1) {
            setNumber(savedState.f23034d);
        }
        setBackgroundColor(savedState.f23031a);
        setBadgeTextColor(savedState.f23032b);
        setBadgeGravity(savedState.f23039i);
        setHorizontalOffsetWithoutText(savedState.f23041k);
        setVerticalOffsetWithoutText(savedState.f23042l);
        setHorizontalOffsetWithText(savedState.f23043m);
        setVerticalOffsetWithText(savedState.f23044n);
        k(savedState.f23045o);
        l(savedState.f23046p);
        setVisible(savedState.f23040j);
    }

    private void m(@Nullable TextAppearance textAppearance) {
        Context context;
        if (this.f23014c.getTextAppearance() == textAppearance || (context = this.f23012a.get()) == null) {
            return;
        }
        this.f23014c.setTextAppearance(textAppearance, context);
        q();
    }

    private void n(@StyleRes int i4) {
        Context context = this.f23012a.get();
        if (context == null) {
            return;
        }
        m(new TextAppearance(context, i4));
    }

    private void o(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f23027p;
            if (weakReference != null && weakReference.get() == viewGroup) {
                return;
            }
            p(view);
            final FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setId(R.id.mtrl_anchor_parent);
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            frameLayout.setLayoutParams(view.getLayoutParams());
            frameLayout.setMinimumWidth(view.getWidth());
            frameLayout.setMinimumHeight(view.getHeight());
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeViewAt(indexOfChild);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(view);
            viewGroup.addView(frameLayout, indexOfChild);
            this.f23027p = new WeakReference<>(frameLayout);
            frameLayout.post(new Runnable() { // from class: com.google.android.material.badge.BadgeDrawable.1
                @Override // java.lang.Runnable
                public void run() {
                    BadgeDrawable.this.updateBadgeCoordinates(view, frameLayout);
                }
            });
        }
    }

    private static void p(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void q() {
        View view;
        Context context = this.f23012a.get();
        WeakReference<View> weakReference = this.f23026o;
        FrameLayout frameLayout = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f23015d);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.f23027p;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null || BadgeUtils.USE_COMPAT_PARENT) {
                if (frameLayout == null) {
                    frameLayout = (ViewGroup) view.getParent();
                }
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            a(context, rect2, view);
            BadgeUtils.updateBadgeBounds(this.f23015d, this.f23020i, this.f23021j, this.f23024m, this.f23025n);
            this.f23013b.setCornerSize(this.f23023l);
            if (!rect.equals(this.f23015d)) {
                this.f23013b.setBounds(this.f23015d);
            }
        }
    }

    private void r() {
        this.f23022k = ((int) Math.pow(10.0d, getMaxCharacterCount() - 1.0d)) - 1;
    }

    public void clearNumber() {
        this.f23019h.f23034d = -1;
        q();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f23013b.draw(canvas);
            if (hasNumber()) {
                d(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f23019h.f23033c;
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.f23013b.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return this.f23019h.f23039i;
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.f23014c.getTextPaint().getColor();
    }

    @Nullable
    public CharSequence getContentDescription() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!hasNumber()) {
            return this.f23019h.f23036f;
        }
        if (this.f23019h.f23037g <= 0 || (context = this.f23012a.get()) == null) {
            return null;
        }
        if (getNumber() <= this.f23022k) {
            return context.getResources().getQuantityString(this.f23019h.f23037g, getNumber(), Integer.valueOf(getNumber()));
        }
        return context.getString(this.f23019h.f23038h, Integer.valueOf(this.f23022k));
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.f23027p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getHorizontalOffset() {
        return this.f23019h.f23041k;
    }

    @Px
    public int getHorizontalOffsetWithText() {
        return this.f23019h.f23043m;
    }

    @Px
    public int getHorizontalOffsetWithoutText() {
        return this.f23019h.f23041k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f23015d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f23015d.width();
    }

    public int getMaxCharacterCount() {
        return this.f23019h.f23035e;
    }

    public int getNumber() {
        if (hasNumber()) {
            return this.f23019h.f23034d;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @NonNull
    public SavedState getSavedState() {
        return this.f23019h;
    }

    public int getVerticalOffset() {
        return this.f23019h.f23042l;
    }

    @Px
    public int getVerticalOffsetWithText() {
        return this.f23019h.f23044n;
    }

    @Px
    public int getVerticalOffsetWithoutText() {
        return this.f23019h.f23042l;
    }

    public boolean hasNumber() {
        if (this.f23019h.f23034d != -1) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i4) {
        this.f23019h.f23045o = i4;
        q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(int i4) {
        this.f23019h.f23046p = i4;
        q();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f23019h.f23033c = i4;
        this.f23014c.getTextPaint().setAlpha(i4);
        invalidateSelf();
    }

    public void setBackgroundColor(@ColorInt int i4) {
        this.f23019h.f23031a = i4;
        ColorStateList valueOf = ColorStateList.valueOf(i4);
        if (this.f23013b.getFillColor() != valueOf) {
            this.f23013b.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    public void setBadgeGravity(int i4) {
        FrameLayout frameLayout;
        if (this.f23019h.f23039i != i4) {
            this.f23019h.f23039i = i4;
            WeakReference<View> weakReference = this.f23026o;
            if (weakReference != null && weakReference.get() != null) {
                View view = this.f23026o.get();
                WeakReference<FrameLayout> weakReference2 = this.f23027p;
                if (weakReference2 != null) {
                    frameLayout = weakReference2.get();
                } else {
                    frameLayout = null;
                }
                updateBadgeCoordinates(view, frameLayout);
            }
        }
    }

    public void setBadgeTextColor(@ColorInt int i4) {
        this.f23019h.f23032b = i4;
        if (this.f23014c.getTextPaint().getColor() != i4) {
            this.f23014c.getTextPaint().setColor(i4);
            invalidateSelf();
        }
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i4) {
        this.f23019h.f23038h = i4;
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        this.f23019h.f23036f = charSequence;
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int i4) {
        this.f23019h.f23037g = i4;
    }

    public void setHorizontalOffset(int i4) {
        setHorizontalOffsetWithoutText(i4);
        setHorizontalOffsetWithText(i4);
    }

    public void setHorizontalOffsetWithText(@Px int i4) {
        this.f23019h.f23043m = i4;
        q();
    }

    public void setHorizontalOffsetWithoutText(@Px int i4) {
        this.f23019h.f23041k = i4;
        q();
    }

    public void setMaxCharacterCount(int i4) {
        if (this.f23019h.f23035e != i4) {
            this.f23019h.f23035e = i4;
            r();
            this.f23014c.setTextWidthDirty(true);
            q();
            invalidateSelf();
        }
    }

    public void setNumber(int i4) {
        int max = Math.max(0, i4);
        if (this.f23019h.f23034d != max) {
            this.f23019h.f23034d = max;
            this.f23014c.setTextWidthDirty(true);
            q();
            invalidateSelf();
        }
    }

    public void setVerticalOffset(int i4) {
        setVerticalOffsetWithoutText(i4);
        setVerticalOffsetWithText(i4);
    }

    public void setVerticalOffsetWithText(@Px int i4) {
        this.f23019h.f23044n = i4;
        q();
    }

    public void setVerticalOffsetWithoutText(@Px int i4) {
        this.f23019h.f23042l = i4;
        q();
    }

    public void setVisible(boolean z3) {
        setVisible(z3, false);
        this.f23019h.f23040j = z3;
        if (BadgeUtils.USE_COMPAT_PARENT && getCustomBadgeParent() != null && !z3) {
            ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        }
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View view, @Nullable ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            updateBadgeCoordinates(view, (FrameLayout) viewGroup);
            return;
        }
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(@NonNull View view) {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    public void updateBadgeCoordinates(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.f23026o = new WeakReference<>(view);
        boolean z3 = BadgeUtils.USE_COMPAT_PARENT;
        if (z3 && frameLayout == null) {
            o(view);
        } else {
            this.f23027p = new WeakReference<>(frameLayout);
        }
        if (!z3) {
            p(view);
        }
        q();
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.badge.BadgeDrawable.SavedState.1
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        };
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        private int f23031a;
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        private int f23032b;

        /* renamed from: c  reason: collision with root package name */
        private int f23033c;

        /* renamed from: d  reason: collision with root package name */
        private int f23034d;

        /* renamed from: e  reason: collision with root package name */
        private int f23035e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private CharSequence f23036f;
        @PluralsRes

        /* renamed from: g  reason: collision with root package name */
        private int f23037g;
        @StringRes

        /* renamed from: h  reason: collision with root package name */
        private int f23038h;

        /* renamed from: i  reason: collision with root package name */
        private int f23039i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f23040j;
        @Dimension(unit = 1)

        /* renamed from: k  reason: collision with root package name */
        private int f23041k;
        @Dimension(unit = 1)

        /* renamed from: l  reason: collision with root package name */
        private int f23042l;
        @Dimension(unit = 1)

        /* renamed from: m  reason: collision with root package name */
        private int f23043m;
        @Dimension(unit = 1)

        /* renamed from: n  reason: collision with root package name */
        private int f23044n;
        @Dimension(unit = 1)

        /* renamed from: o  reason: collision with root package name */
        private int f23045o;
        @Dimension(unit = 1)

        /* renamed from: p  reason: collision with root package name */
        private int f23046p;

        public SavedState(@NonNull Context context) {
            this.f23033c = 255;
            this.f23034d = -1;
            this.f23032b = new TextAppearance(context, R.style.TextAppearance_MaterialComponents_Badge).getTextColor().getDefaultColor();
            this.f23036f = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.f23037g = R.plurals.mtrl_badge_content_description;
            this.f23038h = R.string.mtrl_exceed_max_badge_number_content_description;
            this.f23040j = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            parcel.writeInt(this.f23031a);
            parcel.writeInt(this.f23032b);
            parcel.writeInt(this.f23033c);
            parcel.writeInt(this.f23034d);
            parcel.writeInt(this.f23035e);
            parcel.writeString(this.f23036f.toString());
            parcel.writeInt(this.f23037g);
            parcel.writeInt(this.f23039i);
            parcel.writeInt(this.f23041k);
            parcel.writeInt(this.f23042l);
            parcel.writeInt(this.f23043m);
            parcel.writeInt(this.f23044n);
            parcel.writeInt(this.f23045o);
            parcel.writeInt(this.f23046p);
            parcel.writeInt(this.f23040j ? 1 : 0);
        }

        protected SavedState(@NonNull Parcel parcel) {
            this.f23033c = 255;
            this.f23034d = -1;
            this.f23031a = parcel.readInt();
            this.f23032b = parcel.readInt();
            this.f23033c = parcel.readInt();
            this.f23034d = parcel.readInt();
            this.f23035e = parcel.readInt();
            this.f23036f = parcel.readString();
            this.f23037g = parcel.readInt();
            this.f23039i = parcel.readInt();
            this.f23041k = parcel.readInt();
            this.f23042l = parcel.readInt();
            this.f23043m = parcel.readInt();
            this.f23044n = parcel.readInt();
            this.f23045o = parcel.readInt();
            this.f23046p = parcel.readInt();
            this.f23040j = parcel.readInt() != 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
