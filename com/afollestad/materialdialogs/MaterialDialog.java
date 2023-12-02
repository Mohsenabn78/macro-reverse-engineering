package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.a;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.internal.ThemeSingleton;
import com.afollestad.materialdialogs.util.DialogUtils;
import com.afollestad.materialdialogs.util.RippleHelper;
import com.afollestad.materialdialogs.util.TypefaceHelper;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class MaterialDialog extends com.afollestad.materialdialogs.b implements View.OnClickListener, a.c {

    /* renamed from: c  reason: collision with root package name */
    protected final Builder f977c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f978d;

    /* renamed from: e  reason: collision with root package name */
    protected ImageView f979e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f980f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f981g;

    /* renamed from: h  reason: collision with root package name */
    EditText f982h;

    /* renamed from: i  reason: collision with root package name */
    RecyclerView f983i;

    /* renamed from: j  reason: collision with root package name */
    View f984j;

    /* renamed from: k  reason: collision with root package name */
    FrameLayout f985k;

    /* renamed from: l  reason: collision with root package name */
    ProgressBar f986l;

    /* renamed from: m  reason: collision with root package name */
    TextView f987m;

    /* renamed from: n  reason: collision with root package name */
    TextView f988n;

    /* renamed from: o  reason: collision with root package name */
    TextView f989o;

    /* renamed from: p  reason: collision with root package name */
    CheckBox f990p;

    /* renamed from: q  reason: collision with root package name */
    MDButton f991q;

    /* renamed from: r  reason: collision with root package name */
    MDButton f992r;

    /* renamed from: s  reason: collision with root package name */
    MDButton f993s;

    /* renamed from: t  reason: collision with root package name */
    f f994t;

    /* renamed from: u  reason: collision with root package name */
    List<Integer> f995u;

    /* loaded from: classes2.dex */
    public static class Builder {
        protected SingleButtonCallback A;
        protected NumberFormat A0;
        protected SingleButtonCallback B;
        protected boolean B0;
        protected SingleButtonCallback C;
        protected boolean C0;
        protected SingleButtonCallback D;
        protected boolean D0;
        protected ListCallback E;
        protected boolean E0;
        protected ListLongCallback F;
        protected boolean F0;
        protected ListCallbackSingleChoice G;
        protected boolean G0;
        protected ListCallbackMultiChoice H;
        protected boolean H0;
        protected boolean I;
        protected boolean I0;
        protected boolean J;
        protected boolean J0;
        protected Theme K;
        @DrawableRes
        protected int K0;
        protected boolean L;
        @DrawableRes
        protected int L0;
        protected boolean M;
        @DrawableRes
        protected int M0;
        protected float N;
        @DrawableRes
        protected int N0;
        protected int O;
        @DrawableRes
        protected int O0;
        protected Integer[] P;
        protected Object P0;
        protected Integer[] Q;
        protected boolean R;
        protected Typeface S;
        protected Typeface T;
        protected Drawable U;
        protected boolean V;
        protected int W;
        protected RecyclerView.Adapter<?> X;
        protected RecyclerView.LayoutManager Y;
        protected DialogInterface.OnDismissListener Z;

        /* renamed from: a  reason: collision with root package name */
        protected final Context f996a;

        /* renamed from: a0  reason: collision with root package name */
        protected DialogInterface.OnCancelListener f997a0;

        /* renamed from: b  reason: collision with root package name */
        protected CharSequence f998b;

        /* renamed from: b0  reason: collision with root package name */
        protected DialogInterface.OnKeyListener f999b0;

        /* renamed from: c  reason: collision with root package name */
        protected GravityEnum f1000c;

        /* renamed from: c0  reason: collision with root package name */
        protected DialogInterface.OnShowListener f1001c0;

        /* renamed from: d  reason: collision with root package name */
        protected GravityEnum f1002d;

        /* renamed from: d0  reason: collision with root package name */
        protected StackingBehavior f1003d0;

        /* renamed from: e  reason: collision with root package name */
        protected GravityEnum f1004e;

        /* renamed from: e0  reason: collision with root package name */
        protected boolean f1005e0;

        /* renamed from: f  reason: collision with root package name */
        protected GravityEnum f1006f;

        /* renamed from: f0  reason: collision with root package name */
        protected int f1007f0;

        /* renamed from: g  reason: collision with root package name */
        protected GravityEnum f1008g;

        /* renamed from: g0  reason: collision with root package name */
        protected int f1009g0;

        /* renamed from: h  reason: collision with root package name */
        protected int f1010h;

        /* renamed from: h0  reason: collision with root package name */
        protected int f1011h0;

        /* renamed from: i  reason: collision with root package name */
        protected int f1012i;

        /* renamed from: i0  reason: collision with root package name */
        protected boolean f1013i0;

        /* renamed from: j  reason: collision with root package name */
        protected int f1014j;

        /* renamed from: j0  reason: collision with root package name */
        protected boolean f1015j0;

        /* renamed from: k  reason: collision with root package name */
        protected CharSequence f1016k;

        /* renamed from: k0  reason: collision with root package name */
        protected int f1017k0;

        /* renamed from: l  reason: collision with root package name */
        protected ArrayList<CharSequence> f1018l;

        /* renamed from: l0  reason: collision with root package name */
        protected int f1019l0;

        /* renamed from: m  reason: collision with root package name */
        protected CharSequence f1020m;

        /* renamed from: m0  reason: collision with root package name */
        protected CharSequence f1021m0;

        /* renamed from: n  reason: collision with root package name */
        protected CharSequence f1022n;

        /* renamed from: n0  reason: collision with root package name */
        protected CharSequence f1023n0;

        /* renamed from: o  reason: collision with root package name */
        protected CharSequence f1024o;

        /* renamed from: o0  reason: collision with root package name */
        protected InputCallback f1025o0;

        /* renamed from: p  reason: collision with root package name */
        protected boolean f1026p;

        /* renamed from: p0  reason: collision with root package name */
        protected boolean f1027p0;

        /* renamed from: q  reason: collision with root package name */
        protected boolean f1028q;

        /* renamed from: q0  reason: collision with root package name */
        protected int f1029q0;

        /* renamed from: r  reason: collision with root package name */
        protected boolean f1030r;

        /* renamed from: r0  reason: collision with root package name */
        protected boolean f1031r0;

        /* renamed from: s  reason: collision with root package name */
        protected View f1032s;

        /* renamed from: s0  reason: collision with root package name */
        protected int f1033s0;

        /* renamed from: t  reason: collision with root package name */
        protected int f1034t;

        /* renamed from: t0  reason: collision with root package name */
        protected int f1035t0;

        /* renamed from: u  reason: collision with root package name */
        protected ColorStateList f1036u;

        /* renamed from: u0  reason: collision with root package name */
        protected int f1037u0;

        /* renamed from: v  reason: collision with root package name */
        protected ColorStateList f1038v;

        /* renamed from: v0  reason: collision with root package name */
        protected int[] f1039v0;

        /* renamed from: w  reason: collision with root package name */
        protected ColorStateList f1040w;

        /* renamed from: w0  reason: collision with root package name */
        protected CharSequence f1041w0;

        /* renamed from: x  reason: collision with root package name */
        protected ColorStateList f1042x;

        /* renamed from: x0  reason: collision with root package name */
        protected boolean f1043x0;

        /* renamed from: y  reason: collision with root package name */
        protected ColorStateList f1044y;

        /* renamed from: y0  reason: collision with root package name */
        protected CompoundButton.OnCheckedChangeListener f1045y0;

        /* renamed from: z  reason: collision with root package name */
        protected ButtonCallback f1046z;

        /* renamed from: z0  reason: collision with root package name */
        protected String f1047z0;

        public Builder(@NonNull Context context) {
            GravityEnum gravityEnum = GravityEnum.START;
            this.f1000c = gravityEnum;
            this.f1002d = gravityEnum;
            this.f1004e = GravityEnum.END;
            this.f1006f = gravityEnum;
            this.f1008g = gravityEnum;
            this.f1010h = 0;
            this.f1012i = -1;
            this.f1014j = -1;
            this.I = false;
            this.J = false;
            Theme theme = Theme.LIGHT;
            this.K = theme;
            this.L = true;
            this.M = true;
            this.N = 1.2f;
            this.O = -1;
            this.P = null;
            this.Q = null;
            this.R = true;
            this.W = -1;
            this.f1017k0 = -2;
            this.f1019l0 = 0;
            this.f1029q0 = -1;
            this.f1033s0 = -1;
            this.f1035t0 = -1;
            this.f1037u0 = 0;
            this.C0 = false;
            this.D0 = false;
            this.E0 = false;
            this.F0 = false;
            this.G0 = false;
            this.H0 = false;
            this.I0 = false;
            this.J0 = false;
            this.f996a = context;
            int resolveColor = DialogUtils.resolveColor(context, R.attr.colorAccent, DialogUtils.getColor(context, R.color.md_material_blue_600));
            this.f1034t = resolveColor;
            int resolveColor2 = DialogUtils.resolveColor(context, 16843829, resolveColor);
            this.f1034t = resolveColor2;
            this.f1038v = DialogUtils.getActionTextStateList(context, resolveColor2);
            this.f1040w = DialogUtils.getActionTextStateList(context, this.f1034t);
            this.f1042x = DialogUtils.getActionTextStateList(context, this.f1034t);
            this.f1044y = DialogUtils.getActionTextStateList(context, DialogUtils.resolveColor(context, R.attr.md_link_color, this.f1034t));
            this.f1010h = DialogUtils.resolveColor(context, R.attr.md_btn_ripple_color, DialogUtils.resolveColor(context, R.attr.colorControlHighlight, DialogUtils.resolveColor(context, 16843820)));
            this.A0 = NumberFormat.getPercentInstance();
            this.f1047z0 = "%1d/%2d";
            this.K = DialogUtils.isColorDark(DialogUtils.resolveColor(context, 16842806)) ? theme : Theme.DARK;
            a();
            this.f1000c = DialogUtils.resolveGravityEnum(context, R.attr.md_title_gravity, this.f1000c);
            this.f1002d = DialogUtils.resolveGravityEnum(context, R.attr.md_content_gravity, this.f1002d);
            this.f1004e = DialogUtils.resolveGravityEnum(context, R.attr.md_btnstacked_gravity, this.f1004e);
            this.f1006f = DialogUtils.resolveGravityEnum(context, R.attr.md_items_gravity, this.f1006f);
            this.f1008g = DialogUtils.resolveGravityEnum(context, R.attr.md_buttons_gravity, this.f1008g);
            try {
                typeface(DialogUtils.resolveString(context, R.attr.md_medium_font), DialogUtils.resolveString(context, R.attr.md_regular_font));
            } catch (Throwable unused) {
            }
            if (this.T == null) {
                try {
                    this.T = Typeface.create("sans-serif-medium", 0);
                } catch (Throwable unused2) {
                    this.T = Typeface.DEFAULT_BOLD;
                }
            }
            if (this.S == null) {
                try {
                    this.S = Typeface.create("sans-serif", 0);
                } catch (Throwable unused3) {
                    Typeface typeface = Typeface.SANS_SERIF;
                    this.S = typeface;
                    if (typeface == null) {
                        this.S = Typeface.DEFAULT;
                    }
                }
            }
        }

        private void a() {
            if (ThemeSingleton.get(false) == null) {
                return;
            }
            ThemeSingleton themeSingleton = ThemeSingleton.get();
            if (themeSingleton.darkTheme) {
                this.K = Theme.DARK;
            }
            int i4 = themeSingleton.titleColor;
            if (i4 != 0) {
                this.f1012i = i4;
            }
            int i5 = themeSingleton.contentColor;
            if (i5 != 0) {
                this.f1014j = i5;
            }
            ColorStateList colorStateList = themeSingleton.positiveColor;
            if (colorStateList != null) {
                this.f1038v = colorStateList;
            }
            ColorStateList colorStateList2 = themeSingleton.neutralColor;
            if (colorStateList2 != null) {
                this.f1042x = colorStateList2;
            }
            ColorStateList colorStateList3 = themeSingleton.negativeColor;
            if (colorStateList3 != null) {
                this.f1040w = colorStateList3;
            }
            int i6 = themeSingleton.itemColor;
            if (i6 != 0) {
                this.f1011h0 = i6;
            }
            Drawable drawable = themeSingleton.icon;
            if (drawable != null) {
                this.U = drawable;
            }
            int i7 = themeSingleton.backgroundColor;
            if (i7 != 0) {
                this.f1009g0 = i7;
            }
            int i8 = themeSingleton.dividerColor;
            if (i8 != 0) {
                this.f1007f0 = i8;
            }
            int i9 = themeSingleton.btnSelectorStacked;
            if (i9 != 0) {
                this.L0 = i9;
            }
            int i10 = themeSingleton.listSelector;
            if (i10 != 0) {
                this.K0 = i10;
            }
            int i11 = themeSingleton.btnSelectorPositive;
            if (i11 != 0) {
                this.M0 = i11;
            }
            int i12 = themeSingleton.btnSelectorNeutral;
            if (i12 != 0) {
                this.N0 = i12;
            }
            int i13 = themeSingleton.btnSelectorNegative;
            if (i13 != 0) {
                this.O0 = i13;
            }
            int i14 = themeSingleton.widgetColor;
            if (i14 != 0) {
                this.f1034t = i14;
            }
            ColorStateList colorStateList4 = themeSingleton.linkColor;
            if (colorStateList4 != null) {
                this.f1044y = colorStateList4;
            }
            this.f1000c = themeSingleton.titleGravity;
            this.f1002d = themeSingleton.contentGravity;
            this.f1004e = themeSingleton.btnStackedGravity;
            this.f1006f = themeSingleton.itemsGravity;
            this.f1008g = themeSingleton.buttonsGravity;
        }

        public Builder adapter(@NonNull RecyclerView.Adapter<?> adapter, @Nullable RecyclerView.LayoutManager layoutManager) {
            if (this.f1032s == null) {
                if (layoutManager != null && !(layoutManager instanceof LinearLayoutManager) && !(layoutManager instanceof GridLayoutManager)) {
                    throw new IllegalStateException("You can currently only use LinearLayoutManager and GridLayoutManager with this library.");
                }
                this.X = adapter;
                this.Y = layoutManager;
                return this;
            }
            throw new IllegalStateException("You cannot set adapter() when you're using a custom view.");
        }

        public Builder alwaysCallInputCallback() {
            this.f1031r0 = true;
            return this;
        }

        public Builder alwaysCallMultiChoiceCallback() {
            this.I = true;
            return this;
        }

        public Builder alwaysCallSingleChoiceCallback() {
            this.J = true;
            return this;
        }

        public Builder autoDismiss(boolean z3) {
            this.R = z3;
            return this;
        }

        public Builder backgroundColor(@ColorInt int i4) {
            this.f1009g0 = i4;
            return this;
        }

        public Builder backgroundColorAttr(@AttrRes int i4) {
            return backgroundColor(DialogUtils.resolveColor(this.f996a, i4));
        }

        public Builder backgroundColorRes(@ColorRes int i4) {
            return backgroundColor(DialogUtils.getColor(this.f996a, i4));
        }

        public Builder btnSelector(@DrawableRes int i4) {
            this.M0 = i4;
            this.N0 = i4;
            this.O0 = i4;
            return this;
        }

        public Builder btnSelectorStacked(@DrawableRes int i4) {
            this.L0 = i4;
            return this;
        }

        public Builder btnStackedGravity(@NonNull GravityEnum gravityEnum) {
            this.f1004e = gravityEnum;
            return this;
        }

        @UiThread
        public MaterialDialog build() {
            return new MaterialDialog(this);
        }

        public Builder buttonRippleColor(@ColorInt int i4) {
            this.f1010h = i4;
            return this;
        }

        public Builder buttonRippleColorAttr(@AttrRes int i4) {
            return buttonRippleColor(DialogUtils.resolveColor(this.f996a, i4));
        }

        public Builder buttonRippleColorRes(@ColorRes int i4) {
            return buttonRippleColor(DialogUtils.getColor(this.f996a, i4));
        }

        public Builder buttonsGravity(@NonNull GravityEnum gravityEnum) {
            this.f1008g = gravityEnum;
            return this;
        }

        public Builder callback(@NonNull ButtonCallback buttonCallback) {
            this.f1046z = buttonCallback;
            return this;
        }

        public Builder cancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
            this.f997a0 = onCancelListener;
            return this;
        }

        public Builder cancelable(boolean z3) {
            this.L = z3;
            this.M = z3;
            return this;
        }

        public Builder canceledOnTouchOutside(boolean z3) {
            this.M = z3;
            return this;
        }

        public Builder checkBoxPrompt(@NonNull CharSequence charSequence, boolean z3, @Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            this.f1041w0 = charSequence;
            this.f1043x0 = z3;
            this.f1045y0 = onCheckedChangeListener;
            return this;
        }

        public Builder checkBoxPromptRes(@StringRes int i4, boolean z3, @Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            return checkBoxPrompt(this.f996a.getResources().getText(i4), z3, onCheckedChangeListener);
        }

        public Builder choiceWidgetColor(@Nullable ColorStateList colorStateList) {
            this.f1036u = colorStateList;
            return this;
        }

        public Builder content(@StringRes int i4) {
            return content(i4, false);
        }

        public Builder contentColor(@ColorInt int i4) {
            this.f1014j = i4;
            this.D0 = true;
            return this;
        }

        public Builder contentColorAttr(@AttrRes int i4) {
            contentColor(DialogUtils.resolveColor(this.f996a, i4));
            return this;
        }

        public Builder contentColorRes(@ColorRes int i4) {
            contentColor(DialogUtils.getColor(this.f996a, i4));
            return this;
        }

        public Builder contentGravity(@NonNull GravityEnum gravityEnum) {
            this.f1002d = gravityEnum;
            return this;
        }

        public Builder contentLineSpacing(float f4) {
            this.N = f4;
            return this;
        }

        public Builder customView(@LayoutRes int i4, boolean z3) {
            return customView(LayoutInflater.from(this.f996a).inflate(i4, (ViewGroup) null), z3);
        }

        public Builder dismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
            this.Z = onDismissListener;
            return this;
        }

        public Builder dividerColor(@ColorInt int i4) {
            this.f1007f0 = i4;
            this.J0 = true;
            return this;
        }

        public Builder dividerColorAttr(@AttrRes int i4) {
            return dividerColor(DialogUtils.resolveColor(this.f996a, i4));
        }

        public Builder dividerColorRes(@ColorRes int i4) {
            return dividerColor(DialogUtils.getColor(this.f996a, i4));
        }

        public final Context getContext() {
            return this.f996a;
        }

        public final int getItemColor() {
            return this.f1011h0;
        }

        public final Typeface getRegularFont() {
            return this.S;
        }

        public Builder icon(@NonNull Drawable drawable) {
            this.U = drawable;
            return this;
        }

        public Builder iconAttr(@AttrRes int i4) {
            this.U = DialogUtils.resolveDrawable(this.f996a, i4);
            return this;
        }

        public Builder iconRes(@DrawableRes int i4) {
            this.U = ResourcesCompat.getDrawable(this.f996a.getResources(), i4, null);
            return this;
        }

        public Builder input(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z3, @NonNull InputCallback inputCallback) {
            if (this.f1032s == null) {
                this.f1025o0 = inputCallback;
                this.f1023n0 = charSequence;
                this.f1021m0 = charSequence2;
                this.f1027p0 = z3;
                return this;
            }
            throw new IllegalStateException("You cannot set content() when you're using a custom view.");
        }

        public Builder inputRange(@IntRange(from = 0, to = 2147483647L) int i4, @IntRange(from = -1, to = 2147483647L) int i5) {
            return inputRange(i4, i5, 0);
        }

        public Builder inputRangeRes(@IntRange(from = 0, to = 2147483647L) int i4, @IntRange(from = -1, to = 2147483647L) int i5, @ColorRes int i6) {
            return inputRange(i4, i5, DialogUtils.getColor(this.f996a, i6));
        }

        public Builder inputType(int i4) {
            this.f1029q0 = i4;
            return this;
        }

        public Builder items(@NonNull Collection collection) {
            if (collection.size() > 0) {
                CharSequence[] charSequenceArr = new CharSequence[collection.size()];
                int i4 = 0;
                for (Object obj : collection) {
                    charSequenceArr[i4] = obj.toString();
                    i4++;
                }
                items(charSequenceArr);
            } else if (collection.size() == 0) {
                this.f1018l = new ArrayList<>();
            }
            return this;
        }

        public Builder itemsCallback(@NonNull ListCallback listCallback) {
            this.E = listCallback;
            this.G = null;
            this.H = null;
            return this;
        }

        public Builder itemsCallbackMultiChoice(@Nullable Integer[] numArr, @NonNull ListCallbackMultiChoice listCallbackMultiChoice) {
            this.P = numArr;
            this.E = null;
            this.G = null;
            this.H = listCallbackMultiChoice;
            return this;
        }

        public Builder itemsCallbackSingleChoice(int i4, @NonNull ListCallbackSingleChoice listCallbackSingleChoice) {
            this.O = i4;
            this.E = null;
            this.G = listCallbackSingleChoice;
            this.H = null;
            return this;
        }

        public Builder itemsColor(@ColorInt int i4) {
            this.f1011h0 = i4;
            this.E0 = true;
            return this;
        }

        public Builder itemsColorAttr(@AttrRes int i4) {
            return itemsColor(DialogUtils.resolveColor(this.f996a, i4));
        }

        public Builder itemsColorRes(@ColorRes int i4) {
            return itemsColor(DialogUtils.getColor(this.f996a, i4));
        }

        public Builder itemsDisabledIndices(@Nullable Integer... numArr) {
            this.Q = numArr;
            return this;
        }

        public Builder itemsGravity(@NonNull GravityEnum gravityEnum) {
            this.f1006f = gravityEnum;
            return this;
        }

        public Builder itemsIds(@NonNull int[] iArr) {
            this.f1039v0 = iArr;
            return this;
        }

        public Builder itemsLongCallback(@NonNull ListLongCallback listLongCallback) {
            this.F = listLongCallback;
            this.G = null;
            this.H = null;
            return this;
        }

        public Builder keyListener(@NonNull DialogInterface.OnKeyListener onKeyListener) {
            this.f999b0 = onKeyListener;
            return this;
        }

        public Builder limitIconToDefaultSize() {
            this.V = true;
            return this;
        }

        public Builder linkColor(@ColorInt int i4) {
            return linkColor(DialogUtils.getActionTextStateList(this.f996a, i4));
        }

        public Builder linkColorAttr(@AttrRes int i4) {
            return linkColor(DialogUtils.resolveActionTextColorStateList(this.f996a, i4, null));
        }

        public Builder linkColorRes(@ColorRes int i4) {
            return linkColor(DialogUtils.getActionTextColorStateList(this.f996a, i4));
        }

        public Builder listSelector(@DrawableRes int i4) {
            this.K0 = i4;
            return this;
        }

        public Builder maxIconSize(int i4) {
            this.W = i4;
            return this;
        }

        public Builder maxIconSizeRes(@DimenRes int i4) {
            return maxIconSize((int) this.f996a.getResources().getDimension(i4));
        }

        public Builder negativeColor(@ColorInt int i4) {
            return negativeColor(DialogUtils.getActionTextStateList(this.f996a, i4));
        }

        public Builder negativeColorAttr(@AttrRes int i4) {
            return negativeColor(DialogUtils.resolveActionTextColorStateList(this.f996a, i4, null));
        }

        public Builder negativeColorRes(@ColorRes int i4) {
            return negativeColor(DialogUtils.getActionTextColorStateList(this.f996a, i4));
        }

        public Builder negativeFocus(boolean z3) {
            this.f1030r = z3;
            return this;
        }

        public Builder negativeText(@StringRes int i4) {
            return i4 == 0 ? this : negativeText(this.f996a.getText(i4));
        }

        public Builder neutralColor(@ColorInt int i4) {
            return neutralColor(DialogUtils.getActionTextStateList(this.f996a, i4));
        }

        public Builder neutralColorAttr(@AttrRes int i4) {
            return neutralColor(DialogUtils.resolveActionTextColorStateList(this.f996a, i4, null));
        }

        public Builder neutralColorRes(@ColorRes int i4) {
            return neutralColor(DialogUtils.getActionTextColorStateList(this.f996a, i4));
        }

        public Builder neutralFocus(boolean z3) {
            this.f1028q = z3;
            return this;
        }

        public Builder neutralText(@StringRes int i4) {
            return i4 == 0 ? this : neutralText(this.f996a.getText(i4));
        }

        public Builder onAny(@NonNull SingleButtonCallback singleButtonCallback) {
            this.D = singleButtonCallback;
            return this;
        }

        public Builder onNegative(@NonNull SingleButtonCallback singleButtonCallback) {
            this.B = singleButtonCallback;
            return this;
        }

        public Builder onNeutral(@NonNull SingleButtonCallback singleButtonCallback) {
            this.C = singleButtonCallback;
            return this;
        }

        public Builder onPositive(@NonNull SingleButtonCallback singleButtonCallback) {
            this.A = singleButtonCallback;
            return this;
        }

        public Builder positiveColor(@ColorInt int i4) {
            return positiveColor(DialogUtils.getActionTextStateList(this.f996a, i4));
        }

        public Builder positiveColorAttr(@AttrRes int i4) {
            return positiveColor(DialogUtils.resolveActionTextColorStateList(this.f996a, i4, null));
        }

        public Builder positiveColorRes(@ColorRes int i4) {
            return positiveColor(DialogUtils.getActionTextColorStateList(this.f996a, i4));
        }

        public Builder positiveFocus(boolean z3) {
            this.f1026p = z3;
            return this;
        }

        public Builder positiveText(@StringRes int i4) {
            if (i4 == 0) {
                return this;
            }
            positiveText(this.f996a.getText(i4));
            return this;
        }

        public Builder progress(boolean z3, int i4) {
            if (this.f1032s == null) {
                if (z3) {
                    this.f1013i0 = true;
                    this.f1017k0 = -2;
                } else {
                    this.B0 = false;
                    this.f1013i0 = false;
                    this.f1017k0 = -1;
                    this.f1019l0 = i4;
                }
                return this;
            }
            throw new IllegalStateException("You cannot set progress() when you're using a custom view.");
        }

        public Builder progressIndeterminateStyle(boolean z3) {
            this.B0 = z3;
            return this;
        }

        public Builder progressNumberFormat(@NonNull String str) {
            this.f1047z0 = str;
            return this;
        }

        public Builder progressPercentFormat(@NonNull NumberFormat numberFormat) {
            this.A0 = numberFormat;
            return this;
        }

        @UiThread
        public MaterialDialog show() {
            MaterialDialog build = build();
            build.show();
            return build;
        }

        public Builder showListener(@NonNull DialogInterface.OnShowListener onShowListener) {
            this.f1001c0 = onShowListener;
            return this;
        }

        public Builder stackingBehavior(@NonNull StackingBehavior stackingBehavior) {
            this.f1003d0 = stackingBehavior;
            return this;
        }

        public Builder tag(@Nullable Object obj) {
            this.P0 = obj;
            return this;
        }

        public Builder theme(@NonNull Theme theme) {
            this.K = theme;
            return this;
        }

        public Builder title(@StringRes int i4) {
            title(this.f996a.getText(i4));
            return this;
        }

        public Builder titleColor(@ColorInt int i4) {
            this.f1012i = i4;
            this.C0 = true;
            return this;
        }

        public Builder titleColorAttr(@AttrRes int i4) {
            return titleColor(DialogUtils.resolveColor(this.f996a, i4));
        }

        public Builder titleColorRes(@ColorRes int i4) {
            return titleColor(DialogUtils.getColor(this.f996a, i4));
        }

        public Builder titleGravity(@NonNull GravityEnum gravityEnum) {
            this.f1000c = gravityEnum;
            return this;
        }

        public Builder typeface(@Nullable Typeface typeface, @Nullable Typeface typeface2) {
            this.T = typeface;
            this.S = typeface2;
            return this;
        }

        public Builder widgetColor(@ColorInt int i4) {
            this.f1034t = i4;
            this.I0 = true;
            return this;
        }

        public Builder widgetColorAttr(@AttrRes int i4) {
            return widgetColor(DialogUtils.resolveColor(this.f996a, i4));
        }

        public Builder widgetColorRes(@ColorRes int i4) {
            return widgetColor(DialogUtils.getColor(this.f996a, i4));
        }

        public Builder content(@StringRes int i4, boolean z3) {
            CharSequence text = this.f996a.getText(i4);
            if (z3) {
                text = Html.fromHtml(text.toString().replace("\n", "<br/>"));
            }
            return content(text);
        }

        public Builder inputRange(@IntRange(from = 0, to = 2147483647L) int i4, @IntRange(from = -1, to = 2147483647L) int i5, @ColorInt int i6) {
            if (i4 >= 0) {
                this.f1033s0 = i4;
                this.f1035t0 = i5;
                if (i6 == 0) {
                    this.f1037u0 = DialogUtils.getColor(this.f996a, R.color.md_edittext_error);
                } else {
                    this.f1037u0 = i6;
                }
                if (this.f1033s0 > 0) {
                    this.f1027p0 = false;
                }
                return this;
            }
            throw new IllegalArgumentException("Min length for input dialogs cannot be less than 0.");
        }

        public Builder itemsIds(@ArrayRes int i4) {
            return itemsIds(this.f996a.getResources().getIntArray(i4));
        }

        public Builder linkColor(@NonNull ColorStateList colorStateList) {
            this.f1044y = colorStateList;
            return this;
        }

        public Builder negativeColor(@NonNull ColorStateList colorStateList) {
            this.f1040w = colorStateList;
            this.H0 = true;
            return this;
        }

        public Builder negativeText(@NonNull CharSequence charSequence) {
            this.f1024o = charSequence;
            return this;
        }

        public Builder neutralColor(@NonNull ColorStateList colorStateList) {
            this.f1042x = colorStateList;
            this.G0 = true;
            return this;
        }

        public Builder neutralText(@NonNull CharSequence charSequence) {
            this.f1022n = charSequence;
            return this;
        }

        public Builder positiveColor(@NonNull ColorStateList colorStateList) {
            this.f1038v = colorStateList;
            this.F0 = true;
            return this;
        }

        public Builder positiveText(@NonNull CharSequence charSequence) {
            this.f1020m = charSequence;
            return this;
        }

        public Builder title(@NonNull CharSequence charSequence) {
            this.f998b = charSequence;
            return this;
        }

        public Builder customView(@NonNull View view, boolean z3) {
            if (this.f1016k == null) {
                if (this.f1018l == null) {
                    if (this.f1025o0 == null) {
                        if (this.f1017k0 <= -2 && !this.f1013i0) {
                            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) view.getParent()).removeView(view);
                            }
                            this.f1032s = view;
                            this.f1005e0 = z3;
                            return this;
                        }
                        throw new IllegalStateException("You cannot use customView() with a progress dialog");
                    }
                    throw new IllegalStateException("You cannot use customView() with an input dialog");
                }
                throw new IllegalStateException("You cannot use customView() when you have items set.");
            }
            throw new IllegalStateException("You cannot use customView() when you have content set.");
        }

        public Builder typeface(@Nullable String str, @Nullable String str2) {
            if (str != null && !str.trim().isEmpty()) {
                Typeface typeface = TypefaceHelper.get(this.f996a, str);
                this.T = typeface;
                if (typeface == null) {
                    throw new IllegalArgumentException("No font asset found for \"" + str + "\"");
                }
            }
            if (str2 != null && !str2.trim().isEmpty()) {
                Typeface typeface2 = TypefaceHelper.get(this.f996a, str2);
                this.S = typeface2;
                if (typeface2 == null) {
                    throw new IllegalArgumentException("No font asset found for \"" + str2 + "\"");
                }
            }
            return this;
        }

        public Builder btnSelector(@DrawableRes int i4, @NonNull DialogAction dialogAction) {
            int i5 = d.f1053a[dialogAction.ordinal()];
            if (i5 == 1) {
                this.N0 = i4;
            } else if (i5 != 2) {
                this.M0 = i4;
            } else {
                this.O0 = i4;
            }
            return this;
        }

        public Builder content(@NonNull CharSequence charSequence) {
            if (this.f1032s == null) {
                this.f1016k = charSequence;
                return this;
            }
            throw new IllegalStateException("You cannot set content() when you're using a custom view.");
        }

        public Builder input(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @NonNull InputCallback inputCallback) {
            return input(charSequence, charSequence2, true, inputCallback);
        }

        public Builder content(@StringRes int i4, Object... objArr) {
            return content(Html.fromHtml(String.format(this.f996a.getString(i4), objArr).replace("\n", "<br/>")));
        }

        public Builder input(@StringRes int i4, @StringRes int i5, boolean z3, @NonNull InputCallback inputCallback) {
            return input(i4 == 0 ? null : this.f996a.getText(i4), i5 != 0 ? this.f996a.getText(i5) : null, z3, inputCallback);
        }

        public Builder items(@ArrayRes int i4) {
            items(this.f996a.getResources().getTextArray(i4));
            return this;
        }

        public Builder items(@NonNull CharSequence... charSequenceArr) {
            if (this.f1032s == null) {
                ArrayList<CharSequence> arrayList = new ArrayList<>();
                this.f1018l = arrayList;
                Collections.addAll(arrayList, charSequenceArr);
                return this;
            }
            throw new IllegalStateException("You cannot set items() when you're using a custom view.");
        }

        public Builder progress(boolean z3, int i4, boolean z4) {
            this.f1015j0 = z4;
            return progress(z3, i4);
        }

        public Builder input(@StringRes int i4, @StringRes int i5, @NonNull InputCallback inputCallback) {
            return input(i4, i5, true, inputCallback);
        }
    }

    /* loaded from: classes2.dex */
    public interface InputCallback {
        void onInput(@NonNull MaterialDialog materialDialog, CharSequence charSequence);
    }

    /* loaded from: classes2.dex */
    public interface ListCallback {
        void onSelection(MaterialDialog materialDialog, View view, int i4, CharSequence charSequence);
    }

    /* loaded from: classes2.dex */
    public interface ListCallbackMultiChoice {
        boolean onSelection(MaterialDialog materialDialog, Integer[] numArr, CharSequence[] charSequenceArr);
    }

    /* loaded from: classes2.dex */
    public interface ListCallbackSingleChoice {
        boolean onSelection(MaterialDialog materialDialog, View view, int i4, CharSequence charSequence);
    }

    /* loaded from: classes2.dex */
    public interface ListLongCallback {
        boolean onLongSelection(MaterialDialog materialDialog, View view, int i4, CharSequence charSequence);
    }

    /* loaded from: classes2.dex */
    public interface SingleButtonCallback {
        void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction);
    }

    /* loaded from: classes2.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: com.afollestad.materialdialogs.MaterialDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0062a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f1049a;

            RunnableC0062a(int i4) {
                this.f1049a = i4;
            }

            @Override // java.lang.Runnable
            public void run() {
                MaterialDialog.this.f983i.requestFocus();
                MaterialDialog.this.f977c.Y.scrollToPosition(this.f1049a);
            }
        }

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int intValue;
            MaterialDialog.this.f983i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            MaterialDialog materialDialog = MaterialDialog.this;
            f fVar = materialDialog.f994t;
            f fVar2 = f.SINGLE;
            if (fVar == fVar2 || fVar == f.MULTI) {
                if (fVar == fVar2) {
                    intValue = materialDialog.f977c.O;
                    if (intValue < 0) {
                        return;
                    }
                } else {
                    List<Integer> list = materialDialog.f995u;
                    if (list != null && list.size() != 0) {
                        Collections.sort(MaterialDialog.this.f995u);
                        intValue = MaterialDialog.this.f995u.get(0).intValue();
                    } else {
                        return;
                    }
                }
                MaterialDialog.this.f983i.post(new RunnableC0062a(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialDialog materialDialog = MaterialDialog.this;
            TextView textView = materialDialog.f987m;
            if (textView != null) {
                textView.setText(materialDialog.f977c.A0.format(materialDialog.getCurrentProgress() / MaterialDialog.this.getMaxProgress()));
            }
            MaterialDialog materialDialog2 = MaterialDialog.this;
            TextView textView2 = materialDialog2.f988n;
            if (textView2 != null) {
                textView2.setText(String.format(materialDialog2.f977c.f1047z0, Integer.valueOf(materialDialog2.getCurrentProgress()), Integer.valueOf(MaterialDialog.this.getMaxProgress())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1053a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1054b;

        static {
            int[] iArr = new int[f.values().length];
            f1054b = iArr;
            try {
                iArr[f.REGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1054b[f.SINGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1054b[f.MULTI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[DialogAction.values().length];
            f1053a = iArr2;
            try {
                iArr2[DialogAction.NEUTRAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1053a[DialogAction.NEGATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1053a[DialogAction.POSITIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e extends WindowManager.BadTokenException {
        e(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum f {
        REGULAR,
        SINGLE,
        MULTI;

        public static int a(f fVar) {
            int i4 = d.f1054b[fVar.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        return R.layout.md_listitem_multichoice;
                    }
                    throw new IllegalArgumentException("Not a valid list type");
                }
                return R.layout.md_listitem_singlechoice;
            }
            return R.layout.md_listitem;
        }
    }

    @SuppressLint({"InflateParams"})
    protected MaterialDialog(Builder builder) {
        super(builder.f996a, com.afollestad.materialdialogs.c.c(builder));
        this.f978d = new Handler();
        this.f977c = builder;
        this.f1069a = (MDRootLayout) LayoutInflater.from(builder.f996a).inflate(com.afollestad.materialdialogs.c.b(builder), (ViewGroup) null);
        com.afollestad.materialdialogs.c.d(this);
    }

    private boolean h() {
        if (this.f977c.H == null) {
            return false;
        }
        Collections.sort(this.f995u);
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.f995u) {
            if (num.intValue() >= 0 && num.intValue() <= this.f977c.f1018l.size() - 1) {
                arrayList.add(this.f977c.f1018l.get(num.intValue()));
            }
        }
        ListCallbackMultiChoice listCallbackMultiChoice = this.f977c.H;
        List<Integer> list = this.f995u;
        return listCallbackMultiChoice.onSelection(this, (Integer[]) list.toArray(new Integer[list.size()]), (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
    }

    private boolean i(View view) {
        CharSequence charSequence;
        Builder builder = this.f977c;
        if (builder.G == null) {
            return false;
        }
        int i4 = builder.O;
        if (i4 >= 0 && i4 < builder.f1018l.size()) {
            Builder builder2 = this.f977c;
            charSequence = builder2.f1018l.get(builder2.O);
        } else {
            charSequence = null;
        }
        Builder builder3 = this.f977c;
        return builder3.G.onSelection(this, view, builder3.O, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        RecyclerView recyclerView = this.f983i;
        if (recyclerView == null) {
            return;
        }
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void clearSelectedIndices() {
        clearSelectedIndices(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable d(DialogAction dialogAction, boolean z3) {
        if (z3) {
            Builder builder = this.f977c;
            if (builder.L0 != 0) {
                return ResourcesCompat.getDrawable(builder.f996a.getResources(), this.f977c.L0, null);
            }
            Context context = builder.f996a;
            int i4 = R.attr.md_btn_stacked_selector;
            Drawable resolveDrawable = DialogUtils.resolveDrawable(context, i4);
            if (resolveDrawable != null) {
                return resolveDrawable;
            }
            return DialogUtils.resolveDrawable(getContext(), i4);
        }
        int i5 = d.f1053a[dialogAction.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                Builder builder2 = this.f977c;
                if (builder2.M0 != 0) {
                    return ResourcesCompat.getDrawable(builder2.f996a.getResources(), this.f977c.M0, null);
                }
                Context context2 = builder2.f996a;
                int i6 = R.attr.md_btn_positive_selector;
                Drawable resolveDrawable2 = DialogUtils.resolveDrawable(context2, i6);
                if (resolveDrawable2 != null) {
                    return resolveDrawable2;
                }
                Drawable resolveDrawable3 = DialogUtils.resolveDrawable(getContext(), i6);
                RippleHelper.applyColor(resolveDrawable3, this.f977c.f1010h);
                return resolveDrawable3;
            }
            Builder builder3 = this.f977c;
            if (builder3.O0 != 0) {
                return ResourcesCompat.getDrawable(builder3.f996a.getResources(), this.f977c.O0, null);
            }
            Context context3 = builder3.f996a;
            int i7 = R.attr.md_btn_negative_selector;
            Drawable resolveDrawable4 = DialogUtils.resolveDrawable(context3, i7);
            if (resolveDrawable4 != null) {
                return resolveDrawable4;
            }
            Drawable resolveDrawable5 = DialogUtils.resolveDrawable(getContext(), i7);
            RippleHelper.applyColor(resolveDrawable5, this.f977c.f1010h);
            return resolveDrawable5;
        }
        Builder builder4 = this.f977c;
        if (builder4.N0 != 0) {
            return ResourcesCompat.getDrawable(builder4.f996a.getResources(), this.f977c.N0, null);
        }
        Context context4 = builder4.f996a;
        int i8 = R.attr.md_btn_neutral_selector;
        Drawable resolveDrawable6 = DialogUtils.resolveDrawable(context4, i8);
        if (resolveDrawable6 != null) {
            return resolveDrawable6;
        }
        Drawable resolveDrawable7 = DialogUtils.resolveDrawable(getContext(), i8);
        RippleHelper.applyColor(resolveDrawable7, this.f977c.f1010h);
        return resolveDrawable7;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f982h != null) {
            DialogUtils.hideKeyboard(this, this.f977c);
        }
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable e() {
        Builder builder = this.f977c;
        if (builder.K0 != 0) {
            return ResourcesCompat.getDrawable(builder.f996a.getResources(), this.f977c.K0, null);
        }
        Context context = builder.f996a;
        int i4 = R.attr.md_list_selector;
        Drawable resolveDrawable = DialogUtils.resolveDrawable(context, i4);
        if (resolveDrawable != null) {
            return resolveDrawable;
        }
        return DialogUtils.resolveDrawable(getContext(), i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i4, boolean z3) {
        Builder builder;
        int i5;
        int i6;
        int i7;
        TextView textView = this.f989o;
        if (textView != null) {
            boolean z4 = false;
            if (this.f977c.f1035t0 > 0) {
                textView.setText(String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(i4), Integer.valueOf(this.f977c.f1035t0)));
                this.f989o.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            if ((z3 && i4 == 0) || (((i5 = (builder = this.f977c).f1035t0) > 0 && i4 > i5) || i4 < builder.f1033s0)) {
                z4 = true;
            }
            Builder builder2 = this.f977c;
            if (z4) {
                i6 = builder2.f1037u0;
            } else {
                i6 = builder2.f1014j;
            }
            Builder builder3 = this.f977c;
            if (z4) {
                i7 = builder3.f1037u0;
            } else {
                i7 = builder3.f1034t;
            }
            if (this.f977c.f1035t0 > 0) {
                this.f989o.setTextColor(i6);
            }
            MDTintHelper.setTint(this.f982h, i7);
            getActionButton(DialogAction.POSITIVE).setEnabled(!z4);
        }
    }

    @Override // com.afollestad.materialdialogs.b, android.app.Dialog
    public /* bridge */ /* synthetic */ View findViewById(int i4) {
        return super.findViewById(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        if (this.f983i == null) {
            return;
        }
        ArrayList<CharSequence> arrayList = this.f977c.f1018l;
        if ((arrayList == null || arrayList.size() == 0) && this.f977c.X == null) {
            return;
        }
        Builder builder = this.f977c;
        if (builder.Y == null) {
            builder.Y = new LinearLayoutManager(getContext());
        }
        if (this.f983i.getLayoutManager() == null) {
            this.f983i.setLayoutManager(this.f977c.Y);
        }
        this.f983i.setAdapter(this.f977c.X);
        if (this.f994t != null) {
            ((com.afollestad.materialdialogs.a) this.f977c.X).f(this);
        }
    }

    public final MDButton getActionButton(@NonNull DialogAction dialogAction) {
        int i4 = d.f1053a[dialogAction.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return this.f991q;
            }
            return this.f993s;
        }
        return this.f992r;
    }

    public final Builder getBuilder() {
        return this.f977c;
    }

    @Nullable
    public final TextView getContentView() {
        return this.f981g;
    }

    public final int getCurrentProgress() {
        ProgressBar progressBar = this.f986l;
        if (progressBar == null) {
            return -1;
        }
        return progressBar.getProgress();
    }

    @Nullable
    public final View getCustomView() {
        return this.f977c.f1032s;
    }

    public ImageView getIconView() {
        return this.f979e;
    }

    @Nullable
    public final EditText getInputEditText() {
        return this.f982h;
    }

    @Nullable
    public final ArrayList<CharSequence> getItems() {
        return this.f977c.f1018l;
    }

    public final int getMaxProgress() {
        ProgressBar progressBar = this.f986l;
        if (progressBar == null) {
            return -1;
        }
        return progressBar.getMax();
    }

    public ProgressBar getProgressBar() {
        return this.f986l;
    }

    public RecyclerView getRecyclerView() {
        return this.f983i;
    }

    public int getSelectedIndex() {
        Builder builder = this.f977c;
        if (builder.G != null) {
            return builder.O;
        }
        return -1;
    }

    @Nullable
    public Integer[] getSelectedIndices() {
        if (this.f977c.H != null) {
            List<Integer> list = this.f995u;
            return (Integer[]) list.toArray(new Integer[list.size()]);
        }
        return null;
    }

    @Nullable
    public Object getTag() {
        return this.f977c.P0;
    }

    public final TextView getTitleView() {
        return this.f980f;
    }

    public final View getView() {
        return this.f1069a;
    }

    public final boolean hasActionButtons() {
        if (numberOfActionButtons() > 0) {
            return true;
        }
        return false;
    }

    public final void incrementProgress(int i4) {
        setProgress(getCurrentProgress() + i4);
    }

    public final boolean isCancelled() {
        return !isShowing();
    }

    public final boolean isIndeterminateProgress() {
        return this.f977c.f1013i0;
    }

    public boolean isPromptCheckBoxChecked() {
        CheckBox checkBox = this.f990p;
        if (checkBox != null && checkBox.isChecked()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        EditText editText = this.f982h;
        if (editText == null) {
            return;
        }
        editText.addTextChangedListener(new c());
    }

    @UiThread
    public final void notifyItemChanged(@IntRange(from = 0, to = 2147483647L) int i4) {
        this.f977c.X.notifyItemChanged(i4);
    }

    @UiThread
    public final void notifyItemInserted(@IntRange(from = 0, to = 2147483647L) int i4) {
        this.f977c.X.notifyItemInserted(i4);
    }

    @UiThread
    public final void notifyItemsChanged() {
        this.f977c.X.notifyDataSetChanged();
    }

    public final int numberOfActionButtons() {
        int i4;
        if (this.f991q.getVisibility() == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (this.f992r.getVisibility() == 0) {
            i4++;
        }
        if (this.f993s.getVisibility() == 0) {
            return i4 + 1;
        }
        return i4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        DialogAction dialogAction = (DialogAction) view.getTag();
        int i4 = d.f1053a[dialogAction.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    ButtonCallback buttonCallback = this.f977c.f1046z;
                    if (buttonCallback != null) {
                        buttonCallback.onAny(this);
                        this.f977c.f1046z.onPositive(this);
                    }
                    SingleButtonCallback singleButtonCallback = this.f977c.A;
                    if (singleButtonCallback != null) {
                        singleButtonCallback.onClick(this, dialogAction);
                    }
                    if (!this.f977c.J) {
                        i(view);
                    }
                    if (!this.f977c.I) {
                        h();
                    }
                    Builder builder = this.f977c;
                    InputCallback inputCallback = builder.f1025o0;
                    if (inputCallback != null && (editText = this.f982h) != null && !builder.f1031r0) {
                        inputCallback.onInput(this, editText.getText());
                    }
                    if (this.f977c.R) {
                        dismiss();
                    }
                }
            } else {
                ButtonCallback buttonCallback2 = this.f977c.f1046z;
                if (buttonCallback2 != null) {
                    buttonCallback2.onAny(this);
                    this.f977c.f1046z.onNegative(this);
                }
                SingleButtonCallback singleButtonCallback2 = this.f977c.B;
                if (singleButtonCallback2 != null) {
                    singleButtonCallback2.onClick(this, dialogAction);
                }
                if (this.f977c.R) {
                    cancel();
                }
            }
        } else {
            ButtonCallback buttonCallback3 = this.f977c.f1046z;
            if (buttonCallback3 != null) {
                buttonCallback3.onAny(this);
                this.f977c.f1046z.onNeutral(this);
            }
            SingleButtonCallback singleButtonCallback3 = this.f977c.C;
            if (singleButtonCallback3 != null) {
                singleButtonCallback3.onClick(this, dialogAction);
            }
            if (this.f977c.R) {
                dismiss();
            }
        }
        SingleButtonCallback singleButtonCallback4 = this.f977c.D;
        if (singleButtonCallback4 != null) {
            singleButtonCallback4.onClick(this, dialogAction);
        }
    }

    @Override // com.afollestad.materialdialogs.a.c
    public boolean onItemSelected(MaterialDialog materialDialog, View view, int i4, CharSequence charSequence, boolean z3) {
        Builder builder;
        ListLongCallback listLongCallback;
        Builder builder2;
        ListCallback listCallback;
        boolean z4 = false;
        if (!view.isEnabled()) {
            return false;
        }
        f fVar = this.f994t;
        if (fVar != null && fVar != f.REGULAR) {
            if (fVar == f.MULTI) {
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.md_control);
                if (!checkBox.isEnabled()) {
                    return false;
                }
                if (!this.f995u.contains(Integer.valueOf(i4))) {
                    this.f995u.add(Integer.valueOf(i4));
                    if (this.f977c.I) {
                        if (h()) {
                            checkBox.setChecked(true);
                        } else {
                            this.f995u.remove(Integer.valueOf(i4));
                        }
                    } else {
                        checkBox.setChecked(true);
                    }
                } else {
                    this.f995u.remove(Integer.valueOf(i4));
                    if (this.f977c.I) {
                        if (h()) {
                            checkBox.setChecked(false);
                        } else {
                            this.f995u.add(Integer.valueOf(i4));
                        }
                    } else {
                        checkBox.setChecked(false);
                    }
                }
            } else if (fVar == f.SINGLE) {
                RadioButton radioButton = (RadioButton) view.findViewById(R.id.md_control);
                if (!radioButton.isEnabled()) {
                    return false;
                }
                Builder builder3 = this.f977c;
                int i5 = builder3.O;
                if (builder3.R && builder3.f1020m == null) {
                    dismiss();
                    this.f977c.O = i4;
                    i(view);
                } else if (builder3.J) {
                    builder3.O = i4;
                    z4 = i(view);
                    this.f977c.O = i5;
                } else {
                    z4 = true;
                }
                if (z4) {
                    this.f977c.O = i4;
                    radioButton.setChecked(true);
                    this.f977c.X.notifyItemChanged(i5);
                    this.f977c.X.notifyItemChanged(i4);
                }
            }
        } else {
            if (this.f977c.R) {
                dismiss();
            }
            if (!z3 && (listCallback = (builder2 = this.f977c).E) != null) {
                listCallback.onSelection(this, view, i4, builder2.f1018l.get(i4));
            }
            if (z3 && (listLongCallback = (builder = this.f977c).F) != null) {
                return listLongCallback.onLongSelection(this, view, i4, builder.f1018l.get(i4));
            }
        }
        return true;
    }

    @Override // com.afollestad.materialdialogs.b, android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        if (this.f982h != null) {
            DialogUtils.showKeyboard(this, this.f977c);
            if (this.f982h.getText().length() > 0) {
                EditText editText = this.f982h;
                editText.setSelection(editText.getText().length());
            }
        }
        super.onShow(dialogInterface);
    }

    public void selectAllIndices() {
        selectAllIndices(true);
    }

    @UiThread
    public final void setActionButton(@NonNull DialogAction dialogAction, CharSequence charSequence) {
        int i4 = d.f1053a[dialogAction.ordinal()];
        if (i4 == 1) {
            this.f977c.f1022n = charSequence;
            this.f992r.setText(charSequence);
            this.f992r.setVisibility(charSequence != null ? 0 : 8);
        } else if (i4 != 2) {
            this.f977c.f1020m = charSequence;
            this.f991q.setText(charSequence);
            this.f991q.setVisibility(charSequence != null ? 0 : 8);
        } else {
            this.f977c.f1024o = charSequence;
            this.f993s.setText(charSequence);
            this.f993s.setVisibility(charSequence != null ? 0 : 8);
        }
    }

    @UiThread
    public final void setContent(CharSequence charSequence) {
        this.f981g.setText(charSequence);
        this.f981g.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @Override // com.afollestad.materialdialogs.b, android.app.Dialog
    @Deprecated
    public /* bridge */ /* synthetic */ void setContentView(int i4) throws IllegalAccessError {
        super.setContentView(i4);
    }

    @UiThread
    public void setIcon(@DrawableRes int i4) {
        this.f979e.setImageResource(i4);
        this.f979e.setVisibility(i4 != 0 ? 0 : 8);
    }

    @UiThread
    public void setIconAttribute(@AttrRes int i4) {
        setIcon(DialogUtils.resolveDrawable(this.f977c.f996a, i4));
    }

    @UiThread
    public final void setItems(CharSequence... charSequenceArr) {
        Builder builder = this.f977c;
        if (builder.X != null) {
            if (charSequenceArr != null) {
                builder.f1018l = new ArrayList<>(charSequenceArr.length);
                Collections.addAll(this.f977c.f1018l, charSequenceArr);
            } else {
                builder.f1018l = null;
            }
            if (this.f977c.X instanceof com.afollestad.materialdialogs.a) {
                notifyItemsChanged();
                return;
            }
            throw new IllegalStateException("When using a custom adapter, setItems() cannot be used. Set items through the adapter instead.");
        }
        throw new IllegalStateException("This MaterialDialog instance does not yet have an adapter set to it. You cannot use setItems().");
    }

    public final void setMaxProgress(int i4) {
        if (this.f977c.f1017k0 > -2) {
            this.f986l.setMax(i4);
            return;
        }
        throw new IllegalStateException("Cannot use setMaxProgress() on this dialog.");
    }

    public final void setProgress(int i4) {
        if (this.f977c.f1017k0 <= -2) {
            Log.w("MaterialDialog", "Calling setProgress(int) on an indeterminate progress dialog has no effect!");
            return;
        }
        this.f986l.setProgress(i4);
        this.f978d.post(new b());
    }

    public final void setProgressNumberFormat(String str) {
        this.f977c.f1047z0 = str;
        setProgress(getCurrentProgress());
    }

    public final void setProgressPercentFormat(NumberFormat numberFormat) {
        this.f977c.A0 = numberFormat;
        setProgress(getCurrentProgress());
    }

    public void setPromptCheckBoxChecked(boolean z3) {
        CheckBox checkBox = this.f990p;
        if (checkBox != null) {
            checkBox.setChecked(z3);
        }
    }

    @UiThread
    public void setSelectedIndex(int i4) {
        Builder builder = this.f977c;
        builder.O = i4;
        RecyclerView.Adapter<?> adapter = builder.X;
        if (adapter != null && (adapter instanceof com.afollestad.materialdialogs.a)) {
            adapter.notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("You can only use setSelectedIndex() with the default adapter implementation.");
    }

    @UiThread
    public void setSelectedIndices(@NonNull Integer[] numArr) {
        this.f995u = new ArrayList(Arrays.asList(numArr));
        RecyclerView.Adapter<?> adapter = this.f977c.X;
        if (adapter != null && (adapter instanceof com.afollestad.materialdialogs.a)) {
            adapter.notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("You can only use setSelectedIndices() with the default adapter implementation.");
    }

    @Override // android.app.Dialog
    @UiThread
    public final void setTitle(CharSequence charSequence) {
        this.f980f.setText(charSequence);
    }

    public final void setTypeface(TextView textView, Typeface typeface) {
        if (typeface == null) {
            return;
        }
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        textView.setTypeface(typeface);
    }

    @Override // android.app.Dialog
    @UiThread
    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException unused) {
            throw new e("Bad window token, you cannot show a dialog before an Activity is created or after it's hidden.");
        }
    }

    public void clearSelectedIndices(boolean z3) {
        f fVar = this.f994t;
        if (fVar != null && fVar == f.MULTI) {
            RecyclerView.Adapter<?> adapter = this.f977c.X;
            if (adapter != null && (adapter instanceof com.afollestad.materialdialogs.a)) {
                List<Integer> list = this.f995u;
                if (list != null) {
                    list.clear();
                }
                this.f977c.X.notifyDataSetChanged();
                if (!z3 || this.f977c.H == null) {
                    return;
                }
                h();
                return;
            }
            throw new IllegalStateException("You can only use clearSelectedIndices() with the default adapter implementation.");
        }
        throw new IllegalStateException("You can only use clearSelectedIndices() with multi choice list dialogs.");
    }

    public void selectAllIndices(boolean z3) {
        f fVar = this.f994t;
        if (fVar != null && fVar == f.MULTI) {
            RecyclerView.Adapter<?> adapter = this.f977c.X;
            if (adapter != null && (adapter instanceof com.afollestad.materialdialogs.a)) {
                if (this.f995u == null) {
                    this.f995u = new ArrayList();
                }
                for (int i4 = 0; i4 < this.f977c.X.getItemCount(); i4++) {
                    if (!this.f995u.contains(Integer.valueOf(i4))) {
                        this.f995u.add(Integer.valueOf(i4));
                    }
                }
                this.f977c.X.notifyDataSetChanged();
                if (!z3 || this.f977c.H == null) {
                    return;
                }
                h();
                return;
            }
            throw new IllegalStateException("You can only use selectAllIndices() with the default adapter implementation.");
        }
        throw new IllegalStateException("You can only use selectAllIndices() with multi choice list dialogs.");
    }

    @Override // com.afollestad.materialdialogs.b, android.app.Dialog
    @Deprecated
    public /* bridge */ /* synthetic */ void setContentView(@NonNull View view) throws IllegalAccessError {
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    @UiThread
    public final void setTitle(@StringRes int i4) {
        setTitle(this.f977c.f996a.getString(i4));
    }

    @UiThread
    public final void setContent(@StringRes int i4) {
        setContent(this.f977c.f996a.getString(i4));
    }

    @Override // com.afollestad.materialdialogs.b, android.app.Dialog
    @Deprecated
    public /* bridge */ /* synthetic */ void setContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessError {
        super.setContentView(view, layoutParams);
    }

    @UiThread
    public void setIcon(Drawable drawable) {
        this.f979e.setImageDrawable(drawable);
        this.f979e.setVisibility(drawable != null ? 0 : 8);
    }

    @UiThread
    public final void setTitle(@StringRes int i4, @Nullable Object... objArr) {
        setTitle(this.f977c.f996a.getString(i4, objArr));
    }

    @UiThread
    public final void setContent(@StringRes int i4, @Nullable Object... objArr) {
        setContent(this.f977c.f996a.getString(i4, objArr));
    }

    public final void setActionButton(DialogAction dialogAction, @StringRes int i4) {
        setActionButton(dialogAction, getContext().getText(i4));
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public static abstract class ButtonCallback {
        protected final Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public final boolean equals(Object obj) {
            return super.equals(obj);
        }

        protected final void finalize() throws Throwable {
            super.finalize();
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String toString() {
            return super.toString();
        }

        @Deprecated
        public void onAny(MaterialDialog materialDialog) {
        }

        @Deprecated
        public void onNegative(MaterialDialog materialDialog) {
        }

        @Deprecated
        public void onNeutral(MaterialDialog materialDialog) {
        }

        @Deprecated
        public void onPositive(MaterialDialog materialDialog) {
        }
    }

    /* loaded from: classes2.dex */
    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            int length = charSequence.toString().length();
            MaterialDialog materialDialog = MaterialDialog.this;
            boolean z3 = false;
            if (!materialDialog.f977c.f1027p0) {
                if (length == 0) {
                    z3 = true;
                }
                materialDialog.getActionButton(DialogAction.POSITIVE).setEnabled(!z3);
            }
            MaterialDialog.this.f(length, z3);
            MaterialDialog materialDialog2 = MaterialDialog.this;
            Builder builder = materialDialog2.f977c;
            if (builder.f1031r0) {
                builder.f1025o0.onInput(materialDialog2, charSequence);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
