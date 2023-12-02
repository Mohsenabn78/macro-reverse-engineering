package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.jcodings.exception.ErrorCodes;

/* loaded from: classes5.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int N0 = R.style.Widget_Design_TextInputLayout;
    @Nullable
    private CharSequence A;
    private ColorStateList A0;
    @NonNull
    private final TextView B;
    @ColorInt
    private int B0;
    private boolean C;
    @ColorInt
    private int C0;
    private CharSequence D;
    @ColorInt
    private int D0;
    private boolean E;
    @ColorInt
    private int E0;
    @Nullable
    private MaterialShapeDrawable F;
    @ColorInt
    private int F0;
    @Nullable
    private MaterialShapeDrawable G;
    private boolean G0;
    @NonNull
    private ShapeAppearanceModel H;
    final CollapsingTextHelper H0;
    private final int I;
    private boolean I0;
    private int J;
    private boolean J0;
    private int K;
    private ValueAnimator K0;
    private int L;
    private boolean L0;
    private int M;
    private boolean M0;
    private int N;
    @ColorInt
    private int O;
    @ColorInt
    private int P;
    private final Rect Q;
    private final Rect R;
    private final RectF S;
    private Typeface T;
    @NonNull
    private final CheckableImageButton U;
    private ColorStateList V;
    private boolean W;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f24640a;

    /* renamed from: a0  reason: collision with root package name */
    private PorterDuff.Mode f24641a0;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final LinearLayout f24642b;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f24643b0;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f24644c;
    @Nullable

    /* renamed from: c0  reason: collision with root package name */
    private Drawable f24645c0;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f24646d;

    /* renamed from: d0  reason: collision with root package name */
    private int f24647d0;

    /* renamed from: e  reason: collision with root package name */
    EditText f24648e;

    /* renamed from: e0  reason: collision with root package name */
    private View.OnLongClickListener f24649e0;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f24650f;

    /* renamed from: f0  reason: collision with root package name */
    private final LinkedHashSet<OnEditTextAttachedListener> f24651f0;

    /* renamed from: g  reason: collision with root package name */
    private int f24652g;

    /* renamed from: g0  reason: collision with root package name */
    private int f24653g0;

    /* renamed from: h  reason: collision with root package name */
    private int f24654h;

    /* renamed from: h0  reason: collision with root package name */
    private final SparseArray<EndIconDelegate> f24655h0;

    /* renamed from: i  reason: collision with root package name */
    private final IndicatorViewController f24656i;
    @NonNull

    /* renamed from: i0  reason: collision with root package name */
    private final CheckableImageButton f24657i0;

    /* renamed from: j  reason: collision with root package name */
    boolean f24658j;

    /* renamed from: j0  reason: collision with root package name */
    private final LinkedHashSet<OnEndIconChangedListener> f24659j0;

    /* renamed from: k  reason: collision with root package name */
    private int f24660k;

    /* renamed from: k0  reason: collision with root package name */
    private ColorStateList f24661k0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24662l;

    /* renamed from: l0  reason: collision with root package name */
    private boolean f24663l0;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private TextView f24664m;

    /* renamed from: m0  reason: collision with root package name */
    private PorterDuff.Mode f24665m0;

    /* renamed from: n  reason: collision with root package name */
    private int f24666n;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f24667n0;

    /* renamed from: o  reason: collision with root package name */
    private int f24668o;
    @Nullable

    /* renamed from: o0  reason: collision with root package name */
    private Drawable f24669o0;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f24670p;

    /* renamed from: p0  reason: collision with root package name */
    private int f24671p0;

    /* renamed from: q  reason: collision with root package name */
    private boolean f24672q;

    /* renamed from: q0  reason: collision with root package name */
    private Drawable f24673q0;

    /* renamed from: r  reason: collision with root package name */
    private TextView f24674r;

    /* renamed from: r0  reason: collision with root package name */
    private View.OnLongClickListener f24675r0;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private ColorStateList f24676s;

    /* renamed from: s0  reason: collision with root package name */
    private View.OnLongClickListener f24677s0;

    /* renamed from: t  reason: collision with root package name */
    private int f24678t;
    @NonNull

    /* renamed from: t0  reason: collision with root package name */
    private final CheckableImageButton f24679t0;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private Fade f24680u;

    /* renamed from: u0  reason: collision with root package name */
    private ColorStateList f24681u0;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    private Fade f24682v;

    /* renamed from: v0  reason: collision with root package name */
    private ColorStateList f24683v0;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    private ColorStateList f24684w;

    /* renamed from: w0  reason: collision with root package name */
    private ColorStateList f24685w0;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    private ColorStateList f24686x;
    @ColorInt

    /* renamed from: x0  reason: collision with root package name */
    private int f24687x0;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private CharSequence f24688y;
    @ColorInt

    /* renamed from: y0  reason: collision with root package name */
    private int f24689y0;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    private final TextView f24690z;
    @ColorInt

    /* renamed from: z0  reason: collision with root package name */
    private int f24691z0;

    /* loaded from: classes5.dex */
    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        private final TextInputLayout f24696a;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.f24696a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence;
            boolean z3;
            String str;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.f24696a.getEditText();
            if (editText != null) {
                charSequence = editText.getText();
            } else {
                charSequence = null;
            }
            CharSequence hint = this.f24696a.getHint();
            CharSequence error = this.f24696a.getError();
            CharSequence placeholderText = this.f24696a.getPlaceholderText();
            int counterMaxLength = this.f24696a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f24696a.getCounterOverflowDescription();
            boolean z4 = !TextUtils.isEmpty(charSequence);
            boolean z5 = !TextUtils.isEmpty(hint);
            boolean z6 = !this.f24696a.K();
            boolean z7 = !TextUtils.isEmpty(error);
            if (!z7 && TextUtils.isEmpty(counterOverflowDescription)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z5) {
                str = hint.toString();
            } else {
                str = "";
            }
            if (z4) {
                accessibilityNodeInfoCompat.setText(charSequence);
            } else if (!TextUtils.isEmpty(str)) {
                accessibilityNodeInfoCompat.setText(str);
                if (z6 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(str + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(str);
                } else {
                    if (z4) {
                        str = ((Object) charSequence) + ", " + str;
                    }
                    accessibilityNodeInfoCompat.setText(str);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z4);
            }
            accessibilityNodeInfoCompat.setMaxTextLength((charSequence == null || charSequence.length() != counterMaxLength) ? -1 : -1);
            if (z3) {
                if (!z7) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(R.id.textinput_helper_text);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface EndIconMode {
    }

    /* loaded from: classes5.dex */
    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout textInputLayout);
    }

    /* loaded from: classes5.dex */
    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.textfield.TextInputLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            @Nullable
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
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        CharSequence f24697a;

        /* renamed from: b  reason: collision with root package name */
        boolean f24698b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        CharSequence f24699c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        CharSequence f24700d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        CharSequence f24701e;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f24697a) + " hint=" + ((Object) this.f24699c) + " helperText=" + ((Object) this.f24700d) + " placeholderText=" + ((Object) this.f24701e) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            TextUtils.writeToParcel(this.f24697a, parcel, i4);
            parcel.writeInt(this.f24698b ? 1 : 0);
            TextUtils.writeToParcel(this.f24699c, parcel, i4);
            TextUtils.writeToParcel(this.f24700d, parcel, i4);
            TextUtils.writeToParcel(this.f24701e, parcel, i4);
        }

        SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f24697a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f24698b = parcel.readInt() == 1;
            this.f24699c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f24700d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f24701e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    private void A() {
        Iterator<OnEditTextAttachedListener> it = this.f24651f0.iterator();
        while (it.hasNext()) {
            it.next().onEditTextAttached(this);
        }
    }

    private void B(int i4) {
        Iterator<OnEndIconChangedListener> it = this.f24659j0.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this, i4);
        }
    }

    private void C(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable = this.G;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.L;
            this.G.draw(canvas);
        }
    }

    private void D(@NonNull Canvas canvas) {
        if (this.C) {
            this.H0.draw(canvas);
        }
    }

    private void E(boolean z3) {
        ValueAnimator valueAnimator = this.K0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K0.cancel();
        }
        if (z3 && this.J0) {
            g(0.0f);
        } else {
            this.H0.setExpansionFraction(0.0f);
        }
        if (z() && ((CutoutDrawable) this.F).D()) {
            w();
        }
        this.G0 = true;
        I();
        t0();
        w0();
    }

    private int F(int i4, boolean z3) {
        int compoundPaddingLeft = i4 + this.f24648e.getCompoundPaddingLeft();
        if (this.f24688y != null && !z3) {
            return (compoundPaddingLeft - this.f24690z.getMeasuredWidth()) + this.f24690z.getPaddingLeft();
        }
        return compoundPaddingLeft;
    }

    private int G(int i4, boolean z3) {
        int compoundPaddingRight = i4 - this.f24648e.getCompoundPaddingRight();
        if (this.f24688y != null && z3) {
            return compoundPaddingRight + (this.f24690z.getMeasuredWidth() - this.f24690z.getPaddingRight());
        }
        return compoundPaddingRight;
    }

    private boolean H() {
        if (this.f24653g0 != 0) {
            return true;
        }
        return false;
    }

    private void I() {
        TextView textView = this.f24674r;
        if (textView != null && this.f24672q) {
            textView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(this.f24640a, this.f24682v);
            this.f24674r.setVisibility(4);
        }
    }

    private boolean J() {
        if (this.f24679t0.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private boolean L() {
        if (this.J == 1 && this.f24648e.getMinLines() <= 1) {
            return true;
        }
        return false;
    }

    private int[] M(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private void N() {
        n();
        T();
        x0();
        d0();
        f();
        if (this.J != 0) {
            m0();
        }
    }

    private void O() {
        if (!z()) {
            return;
        }
        RectF rectF = this.S;
        this.H0.getCollapsedTextActualBounds(rectF, this.f24648e.getWidth(), this.f24648e.getGravity());
        j(rectF);
        rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.L);
        ((CutoutDrawable) this.F).J(rectF);
    }

    private void P() {
        if (z() && !this.G0) {
            w();
            O();
        }
    }

    private static void Q(@NonNull ViewGroup viewGroup, boolean z3) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            childAt.setEnabled(z3);
            if (childAt instanceof ViewGroup) {
                Q((ViewGroup) childAt, z3);
            }
        }
    }

    private void R(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(M(checkableImageButton), colorStateList.getDefaultColor());
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    private void S() {
        TextView textView = this.f24674r;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void T() {
        if (a0()) {
            ViewCompat.setBackground(this.f24648e, this.F);
        }
    }

    private static void U(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean z3;
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z4 = false;
        int i4 = 1;
        if (onLongClickListener != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        z4 = (hasOnClickListeners || z3) ? true : true;
        checkableImageButton.setFocusable(z4);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z3);
        if (!z4) {
            i4 = 2;
        }
        ViewCompat.setImportantForAccessibility(checkableImageButton, i4);
    }

    private static void V(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        U(checkableImageButton, onLongClickListener);
    }

    private static void W(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        U(checkableImageButton, onLongClickListener);
    }

    private boolean Y() {
        if ((this.f24679t0.getVisibility() == 0 || ((H() && isEndIconVisible()) || this.A != null)) && this.f24644c.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private boolean Z() {
        if ((getStartIconDrawable() != null || this.f24688y != null) && this.f24642b.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private boolean a0() {
        EditText editText = this.f24648e;
        if (editText != null && this.F != null && editText.getBackground() == null && this.J != 0) {
            return true;
        }
        return false;
    }

    private void b0() {
        TextView textView = this.f24674r;
        if (textView != null && this.f24672q) {
            textView.setText(this.f24670p);
            TransitionManager.beginDelayedTransition(this.f24640a, this.f24680u);
            this.f24674r.setVisibility(0);
            this.f24674r.bringToFront();
        }
    }

    private void c0(boolean z3) {
        if (z3 && getEndIconDrawable() != null) {
            Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
            DrawableCompat.setTint(mutate, this.f24656i.o());
            this.f24657i0.setImageDrawable(mutate);
            return;
        }
        k();
    }

    private void d0() {
        if (this.J == 1) {
            if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                this.K = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                this.K = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void e() {
        TextView textView = this.f24674r;
        if (textView != null) {
            this.f24640a.addView(textView);
            this.f24674r.setVisibility(0);
        }
    }

    private void e0(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.G;
        if (materialShapeDrawable != null) {
            int i4 = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i4 - this.N, rect.right, i4);
        }
    }

    private void f() {
        if (this.f24648e != null && this.J == 1) {
            if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                EditText editText = this.f24648e;
                ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.f24648e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                EditText editText2 = this.f24648e;
                ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.f24648e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    private void f0() {
        int length;
        if (this.f24664m != null) {
            EditText editText = this.f24648e;
            if (editText == null) {
                length = 0;
            } else {
                length = editText.getText().length();
            }
            g0(length);
        }
    }

    private EndIconDelegate getEndIconDelegate() {
        EndIconDelegate endIconDelegate = this.f24655h0.get(this.f24653g0);
        if (endIconDelegate == null) {
            return this.f24655h0.get(0);
        }
        return endIconDelegate;
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f24679t0.getVisibility() == 0) {
            return this.f24679t0;
        }
        if (H() && isEndIconVisible()) {
            return this.f24657i0;
        }
        return null;
    }

    private void h() {
        MaterialShapeDrawable materialShapeDrawable = this.F;
        if (materialShapeDrawable == null) {
            return;
        }
        materialShapeDrawable.setShapeAppearanceModel(this.H);
        if (u()) {
            this.F.setStroke(this.L, this.O);
        }
        int o4 = o();
        this.P = o4;
        this.F.setFillColor(ColorStateList.valueOf(o4));
        if (this.f24653g0 == 3) {
            this.f24648e.getBackground().invalidateSelf();
        }
        i();
        invalidate();
    }

    private static void h0(@NonNull Context context, @NonNull TextView textView, int i4, int i5, boolean z3) {
        int i6;
        if (z3) {
            i6 = R.string.character_counter_overflowed_content_description;
        } else {
            i6 = R.string.character_counter_content_description;
        }
        textView.setContentDescription(context.getString(i6, Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    private void i() {
        if (this.G == null) {
            return;
        }
        if (v()) {
            this.G.setFillColor(ColorStateList.valueOf(this.O));
        }
        invalidate();
    }

    private void i0() {
        int i4;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f24664m;
        if (textView != null) {
            if (this.f24662l) {
                i4 = this.f24666n;
            } else {
                i4 = this.f24668o;
            }
            X(textView, i4);
            if (!this.f24662l && (colorStateList2 = this.f24684w) != null) {
                this.f24664m.setTextColor(colorStateList2);
            }
            if (this.f24662l && (colorStateList = this.f24686x) != null) {
                this.f24664m.setTextColor(colorStateList);
            }
        }
    }

    private void j(@NonNull RectF rectF) {
        float f4 = rectF.left;
        int i4 = this.I;
        rectF.left = f4 - i4;
        rectF.right += i4;
    }

    private boolean j0() {
        boolean z3;
        if (this.f24648e == null) {
            return false;
        }
        boolean z4 = true;
        if (Z()) {
            int measuredWidth = this.f24642b.getMeasuredWidth() - this.f24648e.getPaddingLeft();
            if (this.f24645c0 == null || this.f24647d0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f24645c0 = colorDrawable;
                this.f24647d0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f24648e);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.f24645c0;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.f24648e, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z3 = true;
            }
            z3 = false;
        } else {
            if (this.f24645c0 != null) {
                Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f24648e);
                TextViewCompat.setCompoundDrawablesRelative(this.f24648e, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.f24645c0 = null;
                z3 = true;
            }
            z3 = false;
        }
        if (Y()) {
            int measuredWidth2 = this.B.getMeasuredWidth() - this.f24648e.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.f24648e);
            Drawable drawable3 = this.f24669o0;
            if (drawable3 != null && this.f24671p0 != measuredWidth2) {
                this.f24671p0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.f24648e, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.f24669o0, compoundDrawablesRelative3[3]);
            } else {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f24669o0 = colorDrawable2;
                    this.f24671p0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.f24669o0;
                if (drawable4 != drawable5) {
                    this.f24673q0 = drawable4;
                    TextViewCompat.setCompoundDrawablesRelative(this.f24648e, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z4 = z3;
                }
            }
        } else if (this.f24669o0 != null) {
            Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.f24648e);
            if (compoundDrawablesRelative4[2] == this.f24669o0) {
                TextViewCompat.setCompoundDrawablesRelative(this.f24648e, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.f24673q0, compoundDrawablesRelative4[3]);
            } else {
                z4 = z3;
            }
            this.f24669o0 = null;
        } else {
            return z3;
        }
        return z4;
    }

    private void k() {
        l(this.f24657i0, this.f24663l0, this.f24661k0, this.f24667n0, this.f24665m0);
    }

    private void l(@NonNull CheckableImageButton checkableImageButton, boolean z3, ColorStateList colorStateList, boolean z4, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z3 || z4)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z3) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z4) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private boolean l0() {
        int max;
        if (this.f24648e == null || this.f24648e.getMeasuredHeight() >= (max = Math.max(this.f24644c.getMeasuredHeight(), this.f24642b.getMeasuredHeight()))) {
            return false;
        }
        this.f24648e.setMinimumHeight(max);
        return true;
    }

    private void m() {
        l(this.U, this.W, this.V, this.f24643b0, this.f24641a0);
    }

    private void m0() {
        if (this.J != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24640a.getLayoutParams();
            int t3 = t();
            if (t3 != layoutParams.topMargin) {
                layoutParams.topMargin = t3;
                this.f24640a.requestLayout();
            }
        }
    }

    private void n() {
        int i4 = this.J;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    if (this.C && !(this.F instanceof CutoutDrawable)) {
                        this.F = new CutoutDrawable(this.H);
                    } else {
                        this.F = new MaterialShapeDrawable(this.H);
                    }
                    this.G = null;
                    return;
                }
                throw new IllegalArgumentException(this.J + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.F = new MaterialShapeDrawable(this.H);
            this.G = new MaterialShapeDrawable();
            return;
        }
        this.F = null;
        this.G = null;
    }

    private int o() {
        int i4 = this.P;
        if (this.J == 1) {
            return MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface, 0), this.P);
        }
        return i4;
    }

    private void o0(boolean z3, boolean z4) {
        boolean z5;
        boolean z6;
        ColorStateList colorStateList;
        TextView textView;
        int i4;
        boolean isEnabled = isEnabled();
        EditText editText = this.f24648e;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            z5 = true;
        } else {
            z5 = false;
        }
        EditText editText2 = this.f24648e;
        if (editText2 != null && editText2.hasFocus()) {
            z6 = true;
        } else {
            z6 = false;
        }
        boolean k4 = this.f24656i.k();
        ColorStateList colorStateList2 = this.f24683v0;
        if (colorStateList2 != null) {
            this.H0.setCollapsedTextColor(colorStateList2);
            this.H0.setExpandedTextColor(this.f24683v0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f24683v0;
            if (colorStateList3 != null) {
                i4 = colorStateList3.getColorForState(new int[]{-16842910}, this.F0);
            } else {
                i4 = this.F0;
            }
            this.H0.setCollapsedTextColor(ColorStateList.valueOf(i4));
            this.H0.setExpandedTextColor(ColorStateList.valueOf(i4));
        } else if (k4) {
            this.H0.setCollapsedTextColor(this.f24656i.p());
        } else if (this.f24662l && (textView = this.f24664m) != null) {
            this.H0.setCollapsedTextColor(textView.getTextColors());
        } else if (z6 && (colorStateList = this.f24685w0) != null) {
            this.H0.setCollapsedTextColor(colorStateList);
        }
        if (!z5 && this.I0 && (!isEnabled() || !z6)) {
            if (z4 || !this.G0) {
                E(z3);
            }
        } else if (z4 || this.G0) {
            x(z3);
        }
    }

    @NonNull
    private Rect p(@NonNull Rect rect) {
        boolean z3;
        if (this.f24648e != null) {
            Rect rect2 = this.R;
            if (ViewCompat.getLayoutDirection(this) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            rect2.bottom = rect.bottom;
            int i4 = this.J;
            if (i4 != 1) {
                if (i4 != 2) {
                    rect2.left = F(rect.left, z3);
                    rect2.top = getPaddingTop();
                    rect2.right = G(rect.right, z3);
                    return rect2;
                }
                rect2.left = rect.left + this.f24648e.getPaddingLeft();
                rect2.top = rect.top - t();
                rect2.right = rect.right - this.f24648e.getPaddingRight();
                return rect2;
            }
            rect2.left = F(rect.left, z3);
            rect2.top = rect.top + this.K;
            rect2.right = G(rect.right, z3);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void p0() {
        EditText editText;
        if (this.f24674r != null && (editText = this.f24648e) != null) {
            this.f24674r.setGravity(editText.getGravity());
            this.f24674r.setPadding(this.f24648e.getCompoundPaddingLeft(), this.f24648e.getCompoundPaddingTop(), this.f24648e.getCompoundPaddingRight(), this.f24648e.getCompoundPaddingBottom());
        }
    }

    private int q(@NonNull Rect rect, @NonNull Rect rect2, float f4) {
        if (L()) {
            return (int) (rect2.top + f4);
        }
        return rect.bottom - this.f24648e.getCompoundPaddingBottom();
    }

    private void q0() {
        int length;
        EditText editText = this.f24648e;
        if (editText == null) {
            length = 0;
        } else {
            length = editText.getText().length();
        }
        r0(length);
    }

    private int r(@NonNull Rect rect, float f4) {
        if (L()) {
            return (int) (rect.centerY() - (f4 / 2.0f));
        }
        return rect.top + this.f24648e.getCompoundPaddingTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(int i4) {
        if (i4 == 0 && !this.G0) {
            b0();
        } else {
            I();
        }
    }

    @NonNull
    private Rect s(@NonNull Rect rect) {
        if (this.f24648e != null) {
            Rect rect2 = this.R;
            float expandedTextHeight = this.H0.getExpandedTextHeight();
            rect2.left = rect.left + this.f24648e.getCompoundPaddingLeft();
            rect2.top = r(rect, expandedTextHeight);
            rect2.right = rect.right - this.f24648e.getCompoundPaddingRight();
            rect2.bottom = q(rect, rect2, expandedTextHeight);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void s0() {
        int paddingStart;
        if (this.f24648e == null) {
            return;
        }
        if (isStartIconVisible()) {
            paddingStart = 0;
        } else {
            paddingStart = ViewCompat.getPaddingStart(this.f24648e);
        }
        ViewCompat.setPaddingRelative(this.f24690z, paddingStart, this.f24648e.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f24648e.getCompoundPaddingBottom());
    }

    private void setEditText(EditText editText) {
        if (this.f24648e == null) {
            if (this.f24653g0 != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f24648e = editText;
            setMinWidth(this.f24652g);
            setMaxWidth(this.f24654h);
            N();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.H0.setTypefaces(this.f24648e.getTypeface());
            this.H0.setExpandedTextSize(this.f24648e.getTextSize());
            int gravity = this.f24648e.getGravity();
            this.H0.setCollapsedTextGravity((gravity & ErrorCodes.ERR_TARGET_OF_REPEAT_OPERATOR_NOT_SPECIFIED) | 48);
            this.H0.setExpandedTextGravity(gravity);
            this.f24648e.addTextChangedListener(new TextWatcher() { // from class: com.google.android.material.textfield.TextInputLayout.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(@NonNull Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.n0(!textInputLayout.M0);
                    TextInputLayout textInputLayout2 = TextInputLayout.this;
                    if (textInputLayout2.f24658j) {
                        textInputLayout2.g0(editable.length());
                    }
                    if (TextInputLayout.this.f24672q) {
                        TextInputLayout.this.r0(editable.length());
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }
            });
            if (this.f24683v0 == null) {
                this.f24683v0 = this.f24648e.getHintTextColors();
            }
            if (this.C) {
                if (TextUtils.isEmpty(this.D)) {
                    CharSequence hint = this.f24648e.getHint();
                    this.f24650f = hint;
                    setHint(hint);
                    this.f24648e.setHint((CharSequence) null);
                }
                this.E = true;
            }
            if (this.f24664m != null) {
                g0(this.f24648e.getText().length());
            }
            k0();
            this.f24656i.e();
            this.f24642b.bringToFront();
            this.f24644c.bringToFront();
            this.f24646d.bringToFront();
            this.f24679t0.bringToFront();
            A();
            s0();
            v0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            o0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z3) {
        int i4;
        CheckableImageButton checkableImageButton = this.f24679t0;
        int i5 = 0;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        checkableImageButton.setVisibility(i4);
        FrameLayout frameLayout = this.f24646d;
        if (z3) {
            i5 = 8;
        }
        frameLayout.setVisibility(i5);
        v0();
        if (!H()) {
            j0();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.D)) {
            this.D = charSequence;
            this.H0.setText(charSequence);
            if (!this.G0) {
                O();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z3) {
        if (this.f24672q == z3) {
            return;
        }
        if (z3) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f24674r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            Fade y3 = y();
            this.f24680u = y3;
            y3.setStartDelay(67L);
            this.f24682v = y();
            ViewCompat.setAccessibilityLiveRegion(this.f24674r, 1);
            setPlaceholderTextAppearance(this.f24678t);
            setPlaceholderTextColor(this.f24676s);
            e();
        } else {
            S();
            this.f24674r = null;
        }
        this.f24672q = z3;
    }

    private int t() {
        float collapsedTextHeight;
        if (!this.C) {
            return 0;
        }
        int i4 = this.J;
        if (i4 != 0 && i4 != 1) {
            if (i4 != 2) {
                return 0;
            }
            collapsedTextHeight = this.H0.getCollapsedTextHeight() / 2.0f;
        } else {
            collapsedTextHeight = this.H0.getCollapsedTextHeight();
        }
        return (int) collapsedTextHeight;
    }

    private void t0() {
        int i4;
        TextView textView = this.f24690z;
        if (this.f24688y != null && !K()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
        j0();
    }

    private boolean u() {
        if (this.J == 2 && v()) {
            return true;
        }
        return false;
    }

    private void u0(boolean z3, boolean z4) {
        int defaultColor = this.A0.getDefaultColor();
        int colorForState = this.A0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.A0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z3) {
            this.O = colorForState2;
        } else if (z4) {
            this.O = colorForState;
        } else {
            this.O = defaultColor;
        }
    }

    private boolean v() {
        if (this.L > -1 && this.O != 0) {
            return true;
        }
        return false;
    }

    private void v0() {
        int i4;
        if (this.f24648e == null) {
            return;
        }
        if (!isEndIconVisible() && !J()) {
            i4 = ViewCompat.getPaddingEnd(this.f24648e);
        } else {
            i4 = 0;
        }
        ViewCompat.setPaddingRelative(this.B, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f24648e.getPaddingTop(), i4, this.f24648e.getPaddingBottom());
    }

    private void w() {
        if (z()) {
            ((CutoutDrawable) this.F).G();
        }
    }

    private void w0() {
        boolean z3;
        int visibility = this.B.getVisibility();
        int i4 = 0;
        if (this.A != null && !K()) {
            z3 = true;
        } else {
            z3 = false;
        }
        TextView textView = this.B;
        if (!z3) {
            i4 = 8;
        }
        textView.setVisibility(i4);
        if (visibility != this.B.getVisibility()) {
            getEndIconDelegate().c(z3);
        }
        j0();
    }

    private void x(boolean z3) {
        ValueAnimator valueAnimator = this.K0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K0.cancel();
        }
        if (z3 && this.J0) {
            g(1.0f);
        } else {
            this.H0.setExpansionFraction(1.0f);
        }
        this.G0 = false;
        if (z()) {
            O();
        }
        q0();
        t0();
        w0();
    }

    private Fade y() {
        Fade fade = new Fade();
        fade.setDuration(87L);
        fade.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return fade;
    }

    private boolean z() {
        if (this.C && !TextUtils.isEmpty(this.D) && (this.F instanceof CutoutDrawable)) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    final boolean K() {
        return this.G0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void X(@androidx.annotation.NonNull android.widget.TextView r3, @androidx.annotation.StyleRes int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R.style.TextAppearance_AppCompat_Caption
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R.color.design_error
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.X(android.widget.TextView, int):void");
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.f24651f0.add(onEditTextAttachedListener);
        if (this.f24648e != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.f24659j0.add(onEndIconChangedListener);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i4, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & ErrorCodes.ERR_TARGET_OF_REPEAT_OPERATOR_NOT_SPECIFIED) | 16;
            this.f24640a.addView(view, layoutParams2);
            this.f24640a.setLayoutParams(layoutParams);
            m0();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i4, layoutParams);
    }

    public void clearOnEditTextAttachedListeners() {
        this.f24651f0.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.f24659j0.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i4) {
        ViewStructure newChild;
        EditText editText = this.f24648e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i4);
            return;
        }
        if (this.f24650f == null) {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i4);
            onProvideAutofillVirtualStructure(viewStructure, i4);
            viewStructure.setChildCount(this.f24640a.getChildCount());
            for (int i5 = 0; i5 < this.f24640a.getChildCount(); i5++) {
                View childAt = this.f24640a.getChildAt(i5);
                newChild = viewStructure.newChild(i5);
                childAt.dispatchProvideAutofillStructure(newChild, i4);
                if (childAt == this.f24648e) {
                    newChild.setHint(getHint());
                }
            }
            return;
        }
        boolean z3 = this.E;
        this.E = false;
        CharSequence hint = editText.getHint();
        this.f24648e.setHint(this.f24650f);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i4);
        } finally {
            this.f24648e.setHint(hint);
            this.E = z3;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.M0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.M0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        D(canvas);
        C(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        boolean z3;
        if (this.L0) {
            return;
        }
        boolean z4 = true;
        this.L0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.H0;
        if (collapsingTextHelper != null) {
            z3 = collapsingTextHelper.setState(drawableState) | false;
        } else {
            z3 = false;
        }
        if (this.f24648e != null) {
            n0((ViewCompat.isLaidOut(this) && isEnabled()) ? false : false);
        }
        k0();
        x0();
        if (z3) {
            invalidate();
        }
        this.L0 = false;
    }

    @VisibleForTesting
    void g(float f4) {
        if (this.H0.getExpansionFraction() == f4) {
            return;
        }
        if (this.K0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.K0 = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.K0.setDuration(167L);
            this.K0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    TextInputLayout.this.H0.setExpansionFraction(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
        }
        this.K0.setFloatValues(this.H0.getExpansionFraction(), f4);
        this.K0.start();
    }

    void g0(int i4) {
        boolean z3;
        boolean z4 = this.f24662l;
        int i5 = this.f24660k;
        if (i5 == -1) {
            this.f24664m.setText(String.valueOf(i4));
            this.f24664m.setContentDescription(null);
            this.f24662l = false;
        } else {
            if (i4 > i5) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f24662l = z3;
            h0(getContext(), this.f24664m, i4, this.f24660k, this.f24662l);
            if (z4 != this.f24662l) {
                i0();
            }
            this.f24664m.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i4), Integer.valueOf(this.f24660k))));
        }
        if (this.f24648e != null && z4 != this.f24662l) {
            n0(false);
            x0();
            k0();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f24648e;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + t();
        }
        return super.getBaseline();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i4 = this.J;
        if (i4 != 1 && i4 != 2) {
            throw new IllegalStateException();
        }
        return this.F;
    }

    public int getBoxBackgroundColor() {
        return this.P;
    }

    public int getBoxBackgroundMode() {
        return this.J;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.K;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.F.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.F.getBottomRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.F.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.F.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.f24691z0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.A0;
    }

    public int getBoxStrokeWidth() {
        return this.M;
    }

    public int getBoxStrokeWidthFocused() {
        return this.N;
    }

    public int getCounterMaxLength() {
        return this.f24660k;
    }

    @Nullable
    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f24658j && this.f24662l && (textView = this.f24664m) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.f24684w;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f24684w;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f24683v0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f24648e;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f24657i0.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f24657i0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f24653g0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f24657i0;
    }

    @Nullable
    public CharSequence getError() {
        if (this.f24656i.x()) {
            return this.f24656i.n();
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f24656i.m();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.f24656i.o();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f24679t0.getDrawable();
    }

    @VisibleForTesting
    final int getErrorTextCurrentColor() {
        return this.f24656i.o();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.f24656i.y()) {
            return this.f24656i.q();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.f24656i.r();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.C) {
            return this.D;
        }
        return null;
    }

    @VisibleForTesting
    final float getHintCollapsedTextHeight() {
        return this.H0.getCollapsedTextHeight();
    }

    @VisibleForTesting
    final int getHintCurrentCollapsedTextColor() {
        return this.H0.getCurrentCollapsedTextColor();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f24685w0;
    }

    @Px
    public int getMaxWidth() {
        return this.f24654h;
    }

    @Px
    public int getMinWidth() {
        return this.f24652g;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f24657i0.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f24657i0.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f24672q) {
            return this.f24670p;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.f24678t;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f24676s;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f24688y;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f24690z.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f24690z;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.U.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.U.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.A;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.B.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.B;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.T;
    }

    public boolean isCounterEnabled() {
        return this.f24658j;
    }

    public boolean isEndIconCheckable() {
        return this.f24657i0.isCheckable();
    }

    public boolean isEndIconVisible() {
        if (this.f24646d.getVisibility() == 0 && this.f24657i0.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean isErrorEnabled() {
        return this.f24656i.x();
    }

    public boolean isExpandedHintEnabled() {
        return this.I0;
    }

    public boolean isHelperTextEnabled() {
        return this.f24656i.y();
    }

    public boolean isHintAnimationEnabled() {
        return this.J0;
    }

    public boolean isHintEnabled() {
        return this.C;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        if (this.f24653g0 == 1) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.E;
    }

    public boolean isStartIconCheckable() {
        return this.U.isCheckable();
    }

    public boolean isStartIconVisible() {
        if (this.U.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f24648e;
        if (editText == null || this.J != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.f24656i.k()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.f24656i.o(), PorterDuff.Mode.SRC_IN));
        } else if (this.f24662l && (textView = this.f24664m) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.f24648e.refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n0(boolean z3) {
        o0(z3, false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        EditText editText = this.f24648e;
        if (editText != null) {
            Rect rect = this.Q;
            DescendantOffsetUtils.getDescendantRect(this, editText, rect);
            e0(rect);
            if (this.C) {
                this.H0.setExpandedTextSize(this.f24648e.getTextSize());
                int gravity = this.f24648e.getGravity();
                this.H0.setCollapsedTextGravity((gravity & ErrorCodes.ERR_TARGET_OF_REPEAT_OPERATOR_NOT_SPECIFIED) | 48);
                this.H0.setExpandedTextGravity(gravity);
                this.H0.setCollapsedBounds(p(rect));
                this.H0.setExpandedBounds(s(rect));
                this.H0.recalculate();
                if (z() && !this.G0) {
                    O();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        boolean l02 = l0();
        boolean j02 = j0();
        if (l02 || j02) {
            this.f24648e.post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    TextInputLayout.this.f24648e.requestLayout();
                }
            });
        }
        p0();
        s0();
        v0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f24697a);
        if (savedState.f24698b) {
            this.f24657i0.post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    TextInputLayout.this.f24657i0.performClick();
                    TextInputLayout.this.f24657i0.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.f24699c);
        setHelperText(savedState.f24700d);
        setPlaceholderText(savedState.f24701e);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        boolean z3;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f24656i.k()) {
            savedState.f24697a = getError();
        }
        if (H() && this.f24657i0.isChecked()) {
            z3 = true;
        } else {
            z3 = false;
        }
        savedState.f24698b = z3;
        savedState.f24699c = getHint();
        savedState.f24700d = getHelperText();
        savedState.f24701e = getPlaceholderText();
        return savedState;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z3) {
        if (this.f24653g0 == 1) {
            this.f24657i0.performClick();
            if (z3) {
                this.f24657i0.jumpDrawablesToCurrentState();
            }
        }
    }

    public void refreshEndIconDrawableState() {
        R(this.f24657i0, this.f24661k0);
    }

    public void refreshErrorIconDrawableState() {
        R(this.f24679t0, this.f24681u0);
    }

    public void refreshStartIconDrawableState() {
        R(this.U, this.V);
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.f24651f0.remove(onEditTextAttachedListener);
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.f24659j0.remove(onEndIconChangedListener);
    }

    public void setBoxBackgroundColor(@ColorInt int i4) {
        if (this.P != i4) {
            this.P = i4;
            this.B0 = i4;
            this.D0 = i4;
            this.E0 = i4;
            h();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i4) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i4));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.B0 = defaultColor;
        this.P = defaultColor;
        this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.D0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.E0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        h();
    }

    public void setBoxBackgroundMode(int i4) {
        if (i4 == this.J) {
            return;
        }
        this.J = i4;
        if (this.f24648e != null) {
            N();
        }
    }

    public void setBoxCollapsedPaddingTop(int i4) {
        this.K = i4;
    }

    public void setBoxCornerRadii(float f4, float f5, float f6, float f7) {
        MaterialShapeDrawable materialShapeDrawable = this.F;
        if (materialShapeDrawable == null || materialShapeDrawable.getTopLeftCornerResolvedSize() != f4 || this.F.getTopRightCornerResolvedSize() != f5 || this.F.getBottomRightCornerResolvedSize() != f7 || this.F.getBottomLeftCornerResolvedSize() != f6) {
            this.H = this.H.toBuilder().setTopLeftCornerSize(f4).setTopRightCornerSize(f5).setBottomRightCornerSize(f7).setBottomLeftCornerSize(f6).build();
            h();
        }
    }

    public void setBoxCornerRadiiResources(@DimenRes int i4, @DimenRes int i5, @DimenRes int i6, @DimenRes int i7) {
        setBoxCornerRadii(getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i7), getContext().getResources().getDimension(i6));
    }

    public void setBoxStrokeColor(@ColorInt int i4) {
        if (this.f24691z0 != i4) {
            this.f24691z0 = i4;
            x0();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f24687x0 = colorStateList.getDefaultColor();
            this.F0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f24689y0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.f24691z0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.f24691z0 != colorStateList.getDefaultColor()) {
            this.f24691z0 = colorStateList.getDefaultColor();
        }
        x0();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            x0();
        }
    }

    public void setBoxStrokeWidth(int i4) {
        this.M = i4;
        x0();
    }

    public void setBoxStrokeWidthFocused(int i4) {
        this.N = i4;
        x0();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i4) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i4));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i4) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i4));
    }

    public void setCounterEnabled(boolean z3) {
        if (this.f24658j != z3) {
            if (z3) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f24664m = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.T;
                if (typeface != null) {
                    this.f24664m.setTypeface(typeface);
                }
                this.f24664m.setMaxLines(1);
                this.f24656i.d(this.f24664m, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f24664m.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                i0();
                f0();
            } else {
                this.f24656i.z(this.f24664m, 2);
                this.f24664m = null;
            }
            this.f24658j = z3;
        }
    }

    public void setCounterMaxLength(int i4) {
        if (this.f24660k != i4) {
            if (i4 > 0) {
                this.f24660k = i4;
            } else {
                this.f24660k = -1;
            }
            if (this.f24658j) {
                f0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i4) {
        if (this.f24666n != i4) {
            this.f24666n = i4;
            i0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f24686x != colorStateList) {
            this.f24686x = colorStateList;
            i0();
        }
    }

    public void setCounterTextAppearance(int i4) {
        if (this.f24668o != i4) {
            this.f24668o = i4;
            i0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f24684w != colorStateList) {
            this.f24684w = colorStateList;
            i0();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.f24683v0 = colorStateList;
        this.f24685w0 = colorStateList;
        if (this.f24648e != null) {
            n0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        Q(this, z3);
        super.setEnabled(z3);
    }

    public void setEndIconActivated(boolean z3) {
        this.f24657i0.setActivated(z3);
    }

    public void setEndIconCheckable(boolean z3) {
        this.f24657i0.setCheckable(z3);
    }

    public void setEndIconContentDescription(@StringRes int i4) {
        setEndIconContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i4) {
        setEndIconDrawable(i4 != 0 ? AppCompatResources.getDrawable(getContext(), i4) : null);
    }

    public void setEndIconMode(int i4) {
        boolean z3;
        int i5 = this.f24653g0;
        this.f24653g0 = i4;
        B(i5);
        if (i4 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        setEndIconVisible(z3);
        if (getEndIconDelegate().b(this.J)) {
            getEndIconDelegate().a();
            k();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.J + " is not supported by the end icon mode " + i4);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        V(this.f24657i0, onClickListener, this.f24675r0);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f24675r0 = onLongClickListener;
        W(this.f24657i0, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.f24661k0 != colorStateList) {
            this.f24661k0 = colorStateList;
            this.f24663l0 = true;
            k();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f24665m0 != mode) {
            this.f24665m0 = mode;
            this.f24667n0 = true;
            k();
        }
    }

    public void setEndIconVisible(boolean z3) {
        int i4;
        if (isEndIconVisible() != z3) {
            CheckableImageButton checkableImageButton = this.f24657i0;
            if (z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            checkableImageButton.setVisibility(i4);
            v0();
            j0();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f24656i.x()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f24656i.M(charSequence);
        } else {
            this.f24656i.t();
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.f24656i.B(charSequence);
    }

    public void setErrorEnabled(boolean z3) {
        this.f24656i.C(z3);
    }

    public void setErrorIconDrawable(@DrawableRes int i4) {
        setErrorIconDrawable(i4 != 0 ? AppCompatResources.getDrawable(getContext(), i4) : null);
        refreshErrorIconDrawableState();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        V(this.f24679t0, onClickListener, this.f24677s0);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f24677s0 = onLongClickListener;
        W(this.f24679t0, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.f24681u0 = colorStateList;
        Drawable drawable = this.f24679t0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.f24679t0.getDrawable() != drawable) {
            this.f24679t0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.f24679t0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.f24679t0.getDrawable() != drawable) {
            this.f24679t0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i4) {
        this.f24656i.D(i4);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.f24656i.E(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z3) {
        if (this.I0 != z3) {
            this.I0 = z3;
            n0(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!isHelperTextEnabled()) {
            setHelperTextEnabled(true);
        }
        this.f24656i.N(charSequence);
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.f24656i.H(colorStateList);
    }

    public void setHelperTextEnabled(boolean z3) {
        this.f24656i.G(z3);
    }

    public void setHelperTextTextAppearance(@StyleRes int i4) {
        this.f24656i.F(i4);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z3) {
        this.J0 = z3;
    }

    public void setHintEnabled(boolean z3) {
        if (z3 != this.C) {
            this.C = z3;
            if (!z3) {
                this.E = false;
                if (!TextUtils.isEmpty(this.D) && TextUtils.isEmpty(this.f24648e.getHint())) {
                    this.f24648e.setHint(this.D);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f24648e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.D)) {
                        setHint(hint);
                    }
                    this.f24648e.setHint((CharSequence) null);
                }
                this.E = true;
            }
            if (this.f24648e != null) {
                m0();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i4) {
        this.H0.setCollapsedTextAppearance(i4);
        this.f24685w0 = this.H0.getCollapsedTextColor();
        if (this.f24648e != null) {
            n0(false);
            m0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f24685w0 != colorStateList) {
            if (this.f24683v0 == null) {
                this.H0.setCollapsedTextColor(colorStateList);
            }
            this.f24685w0 = colorStateList;
            if (this.f24648e != null) {
                n0(false);
            }
        }
    }

    public void setMaxWidth(@Px int i4) {
        this.f24654h = i4;
        EditText editText = this.f24648e;
        if (editText != null && i4 != -1) {
            editText.setMaxWidth(i4);
        }
    }

    public void setMaxWidthResource(@DimenRes int i4) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i4));
    }

    public void setMinWidth(@Px int i4) {
        this.f24652g = i4;
        EditText editText = this.f24648e;
        if (editText != null && i4 != -1) {
            editText.setMinWidth(i4);
        }
    }

    public void setMinWidthResource(@DimenRes int i4) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i4));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i4) {
        setPasswordVisibilityToggleContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i4) {
        setPasswordVisibilityToggleDrawable(i4 != 0 ? AppCompatResources.getDrawable(getContext(), i4) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z3) {
        if (z3 && this.f24653g0 != 1) {
            setEndIconMode(1);
        } else if (!z3) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.f24661k0 = colorStateList;
        this.f24663l0 = true;
        k();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.f24665m0 = mode;
        this.f24667n0 = true;
        k();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.f24672q && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f24672q) {
                setPlaceholderTextEnabled(true);
            }
            this.f24670p = charSequence;
        }
        q0();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i4) {
        this.f24678t = i4;
        TextView textView = this.f24674r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i4);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f24676s != colorStateList) {
            this.f24676s = colorStateList;
            TextView textView = this.f24674r;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f24688y = charSequence2;
        this.f24690z.setText(charSequence);
        t0();
    }

    public void setPrefixTextAppearance(@StyleRes int i4) {
        TextViewCompat.setTextAppearance(this.f24690z, i4);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f24690z.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z3) {
        this.U.setCheckable(z3);
    }

    public void setStartIconContentDescription(@StringRes int i4) {
        setStartIconContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i4) {
        setStartIconDrawable(i4 != 0 ? AppCompatResources.getDrawable(getContext(), i4) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        V(this.U, onClickListener, this.f24649e0);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f24649e0 = onLongClickListener;
        W(this.U, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            this.W = true;
            m();
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f24641a0 != mode) {
            this.f24641a0 = mode;
            this.f24643b0 = true;
            m();
        }
    }

    public void setStartIconVisible(boolean z3) {
        int i4;
        if (isStartIconVisible() != z3) {
            CheckableImageButton checkableImageButton = this.U;
            if (z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            checkableImageButton.setVisibility(i4);
            s0();
            j0();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.A = charSequence2;
        this.B.setText(charSequence);
        w0();
    }

    public void setSuffixTextAppearance(@StyleRes int i4) {
        TextViewCompat.setTextAppearance(this.B, i4);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.B.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.f24648e;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.T) {
            this.T = typeface;
            this.H0.setTypefaces(typeface);
            this.f24656i.J(typeface);
            TextView textView = this.f24664m;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x0() {
        boolean z3;
        boolean z4;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.F != null && this.J != 0) {
            boolean z5 = false;
            if (!isFocused() && ((editText2 = this.f24648e) == null || !editText2.hasFocus())) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!isHovered() && ((editText = this.f24648e) == null || !editText.isHovered())) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!isEnabled()) {
                this.O = this.F0;
            } else if (this.f24656i.k()) {
                if (this.A0 != null) {
                    u0(z3, z4);
                } else {
                    this.O = this.f24656i.o();
                }
            } else if (this.f24662l && (textView = this.f24664m) != null) {
                if (this.A0 != null) {
                    u0(z3, z4);
                } else {
                    this.O = textView.getCurrentTextColor();
                }
            } else if (z3) {
                this.O = this.f24691z0;
            } else if (z4) {
                this.O = this.f24689y0;
            } else {
                this.O = this.f24687x0;
            }
            if (getErrorIconDrawable() != null && this.f24656i.x() && this.f24656i.k()) {
                z5 = true;
            }
            setErrorIconVisible(z5);
            refreshErrorIconDrawableState();
            refreshStartIconDrawableState();
            refreshEndIconDrawableState();
            if (getEndIconDelegate().d()) {
                c0(this.f24656i.k());
            }
            int i4 = this.L;
            if (z3 && isEnabled()) {
                this.L = this.N;
            } else {
                this.L = this.M;
            }
            if (this.L != i4 && this.J == 2) {
                P();
            }
            if (this.J == 1) {
                if (!isEnabled()) {
                    this.P = this.C0;
                } else if (z4 && !z3) {
                    this.P = this.E0;
                } else if (z3) {
                    this.P = this.D0;
                } else {
                    this.P = this.B0;
                }
            }
            h();
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f24657i0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.f24657i0.setImageDrawable(drawable);
        if (drawable != null) {
            k();
            refreshEndIconDrawableState();
        }
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.U.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.U.setImageDrawable(drawable);
        if (drawable != null) {
            m();
            setStartIconVisible(true);
            refreshStartIconDrawableState();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v146 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r27, @androidx.annotation.Nullable android.util.AttributeSet r28, int r29) {
        /*
            Method dump skipped, instructions count: 1570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.f24679t0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f24656i.x());
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f24657i0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f24657i0.setImageDrawable(drawable);
    }

    public void setHint(@StringRes int i4) {
        setHint(i4 != 0 ? getResources().getText(i4) : null);
    }
}
