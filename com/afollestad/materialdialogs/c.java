package com.afollestad.materialdialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.MDAdapter;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.util.DialogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import me.zhanghai.android.materialprogressbar.HorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateCircularProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DialogInit.java */
/* loaded from: classes2.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    @LayoutRes
    public static int b(MaterialDialog.Builder builder) {
        if (builder.f1032s != null) {
            return R.layout.md_dialog_custom;
        }
        if (builder.f1018l == null && builder.X == null) {
            if (builder.f1017k0 > -2) {
                return R.layout.md_dialog_progress;
            }
            if (builder.f1013i0) {
                if (builder.B0) {
                    return R.layout.md_dialog_progress_indeterminate_horizontal;
                }
                return R.layout.md_dialog_progress_indeterminate;
            } else if (builder.f1025o0 != null) {
                if (builder.f1041w0 != null) {
                    return R.layout.md_dialog_input_check;
                }
                return R.layout.md_dialog_input;
            } else if (builder.f1041w0 != null) {
                return R.layout.md_dialog_basic_check;
            } else {
                return R.layout.md_dialog_basic;
            }
        } else if (builder.f1041w0 != null) {
            return R.layout.md_dialog_list_check;
        } else {
            return R.layout.md_dialog_list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @StyleRes
    public static int c(@NonNull MaterialDialog.Builder builder) {
        boolean z3;
        Context context = builder.f996a;
        int i4 = R.attr.md_dark_theme;
        Theme theme = builder.K;
        Theme theme2 = Theme.DARK;
        if (theme == theme2) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean resolveBoolean = DialogUtils.resolveBoolean(context, i4, z3);
        if (!resolveBoolean) {
            theme2 = Theme.LIGHT;
        }
        builder.K = theme2;
        if (resolveBoolean) {
            return R.style.MD_Dark;
        }
        return R.style.MD_Light;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public static void d(MaterialDialog materialDialog) {
        int i4;
        int i5;
        int i6;
        MaterialDialog.Builder builder = materialDialog.f977c;
        materialDialog.setCancelable(builder.L);
        materialDialog.setCanceledOnTouchOutside(builder.M);
        if (builder.f1009g0 == 0) {
            builder.f1009g0 = DialogUtils.resolveColor(builder.f996a, R.attr.md_background_color, DialogUtils.resolveColor(materialDialog.getContext(), R.attr.colorBackgroundFloating));
        }
        if (builder.f1009g0 != 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(builder.f996a.getResources().getDimension(R.dimen.md_bg_corner_radius));
            gradientDrawable.setColor(builder.f1009g0);
            materialDialog.getWindow().setBackgroundDrawable(gradientDrawable);
        }
        if (!builder.F0) {
            builder.f1038v = DialogUtils.resolveActionTextColorStateList(builder.f996a, R.attr.md_positive_color, builder.f1038v);
        }
        if (!builder.G0) {
            builder.f1042x = DialogUtils.resolveActionTextColorStateList(builder.f996a, R.attr.md_neutral_color, builder.f1042x);
        }
        if (!builder.H0) {
            builder.f1040w = DialogUtils.resolveActionTextColorStateList(builder.f996a, R.attr.md_negative_color, builder.f1040w);
        }
        if (!builder.I0) {
            builder.f1034t = DialogUtils.resolveColor(builder.f996a, R.attr.md_widget_color, builder.f1034t);
        }
        if (!builder.C0) {
            builder.f1012i = DialogUtils.resolveColor(builder.f996a, R.attr.md_title_color, DialogUtils.resolveColor(materialDialog.getContext(), 16842806));
        }
        if (!builder.D0) {
            builder.f1014j = DialogUtils.resolveColor(builder.f996a, R.attr.md_content_color, DialogUtils.resolveColor(materialDialog.getContext(), 16842808));
        }
        if (!builder.E0) {
            builder.f1011h0 = DialogUtils.resolveColor(builder.f996a, R.attr.md_item_color, builder.f1014j);
        }
        materialDialog.f980f = (TextView) materialDialog.f1069a.findViewById(R.id.md_title);
        materialDialog.f979e = (ImageView) materialDialog.f1069a.findViewById(R.id.md_icon);
        materialDialog.f984j = materialDialog.f1069a.findViewById(R.id.md_titleFrame);
        materialDialog.f981g = (TextView) materialDialog.f1069a.findViewById(R.id.md_content);
        materialDialog.f983i = (RecyclerView) materialDialog.f1069a.findViewById(R.id.md_contentRecyclerView);
        materialDialog.f990p = (CheckBox) materialDialog.f1069a.findViewById(R.id.md_promptCheckbox);
        materialDialog.f991q = (MDButton) materialDialog.f1069a.findViewById(R.id.md_buttonDefaultPositive);
        materialDialog.f992r = (MDButton) materialDialog.f1069a.findViewById(R.id.md_buttonDefaultNeutral);
        materialDialog.f993s = (MDButton) materialDialog.f1069a.findViewById(R.id.md_buttonDefaultNegative);
        if (builder.f1025o0 != null && builder.f1020m == null) {
            builder.f1020m = builder.f996a.getText(17039370);
        }
        MDButton mDButton = materialDialog.f991q;
        if (builder.f1020m != null) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        mDButton.setVisibility(i4);
        MDButton mDButton2 = materialDialog.f992r;
        if (builder.f1022n != null) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        mDButton2.setVisibility(i5);
        MDButton mDButton3 = materialDialog.f993s;
        if (builder.f1024o != null) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        mDButton3.setVisibility(i6);
        materialDialog.f991q.setFocusable(true);
        materialDialog.f992r.setFocusable(true);
        materialDialog.f993s.setFocusable(true);
        if (builder.f1026p) {
            materialDialog.f991q.requestFocus();
        }
        if (builder.f1028q) {
            materialDialog.f992r.requestFocus();
        }
        if (builder.f1030r) {
            materialDialog.f993s.requestFocus();
        }
        if (builder.U != null) {
            materialDialog.f979e.setVisibility(0);
            materialDialog.f979e.setImageDrawable(builder.U);
        } else {
            Drawable resolveDrawable = DialogUtils.resolveDrawable(builder.f996a, R.attr.md_icon);
            if (resolveDrawable != null) {
                materialDialog.f979e.setVisibility(0);
                materialDialog.f979e.setImageDrawable(resolveDrawable);
            } else {
                materialDialog.f979e.setVisibility(8);
            }
        }
        int i7 = builder.W;
        if (i7 == -1) {
            i7 = DialogUtils.resolveDimension(builder.f996a, R.attr.md_icon_max_size);
        }
        if (builder.V || DialogUtils.resolveBoolean(builder.f996a, R.attr.md_icon_limit_icon_to_default_size)) {
            i7 = builder.f996a.getResources().getDimensionPixelSize(R.dimen.md_icon_max_size);
        }
        if (i7 > -1) {
            materialDialog.f979e.setAdjustViewBounds(true);
            materialDialog.f979e.setMaxHeight(i7);
            materialDialog.f979e.setMaxWidth(i7);
            materialDialog.f979e.requestLayout();
        }
        if (!builder.J0) {
            builder.f1007f0 = DialogUtils.resolveColor(builder.f996a, R.attr.md_divider_color, DialogUtils.resolveColor(materialDialog.getContext(), R.attr.md_divider));
        }
        materialDialog.f1069a.setDividerColor(builder.f1007f0);
        TextView textView = materialDialog.f980f;
        if (textView != null) {
            materialDialog.setTypeface(textView, builder.T);
            materialDialog.f980f.setTextColor(builder.f1012i);
            materialDialog.f980f.setGravity(builder.f1000c.getGravityInt());
            materialDialog.f980f.setTextAlignment(builder.f1000c.getTextAlignment());
            CharSequence charSequence = builder.f998b;
            if (charSequence == null) {
                materialDialog.f984j.setVisibility(8);
            } else {
                materialDialog.f980f.setText(charSequence);
                materialDialog.f984j.setVisibility(0);
            }
        }
        TextView textView2 = materialDialog.f981g;
        if (textView2 != null) {
            textView2.setMovementMethod(new LinkMovementMethod());
            materialDialog.setTypeface(materialDialog.f981g, builder.S);
            materialDialog.f981g.setLineSpacing(0.0f, builder.N);
            ColorStateList colorStateList = builder.f1044y;
            if (colorStateList == null) {
                materialDialog.f981g.setLinkTextColor(DialogUtils.resolveColor(materialDialog.getContext(), 16842806));
            } else {
                materialDialog.f981g.setLinkTextColor(colorStateList);
            }
            materialDialog.f981g.setTextColor(builder.f1014j);
            materialDialog.f981g.setGravity(builder.f1002d.getGravityInt());
            materialDialog.f981g.setTextAlignment(builder.f1002d.getTextAlignment());
            CharSequence charSequence2 = builder.f1016k;
            if (charSequence2 != null) {
                materialDialog.f981g.setText(charSequence2);
                materialDialog.f981g.setVisibility(0);
            } else {
                materialDialog.f981g.setVisibility(8);
            }
        }
        CheckBox checkBox = materialDialog.f990p;
        if (checkBox != null) {
            checkBox.setText(builder.f1041w0);
            materialDialog.f990p.setChecked(builder.f1043x0);
            materialDialog.f990p.setOnCheckedChangeListener(builder.f1045y0);
            materialDialog.setTypeface(materialDialog.f990p, builder.S);
            materialDialog.f990p.setTextColor(builder.f1014j);
            MDTintHelper.setTint(materialDialog.f990p, builder.f1034t);
        }
        materialDialog.f1069a.setButtonGravity(builder.f1008g);
        materialDialog.f1069a.setButtonStackedGravity(builder.f1004e);
        materialDialog.f1069a.setStackingBehavior(builder.f1003d0);
        boolean resolveBoolean = DialogUtils.resolveBoolean(builder.f996a, 16843660, true);
        if (resolveBoolean) {
            resolveBoolean = DialogUtils.resolveBoolean(builder.f996a, R.attr.textAllCaps, true);
        }
        MDButton mDButton4 = materialDialog.f991q;
        materialDialog.setTypeface(mDButton4, builder.T);
        mDButton4.setAllCapsCompat(resolveBoolean);
        mDButton4.setText(builder.f1020m);
        mDButton4.setTextColor(builder.f1038v);
        MDButton mDButton5 = materialDialog.f991q;
        DialogAction dialogAction = DialogAction.POSITIVE;
        mDButton5.setStackedSelector(materialDialog.d(dialogAction, true));
        materialDialog.f991q.setDefaultSelector(materialDialog.d(dialogAction, false));
        materialDialog.f991q.setTag(dialogAction);
        materialDialog.f991q.setOnClickListener(materialDialog);
        MDButton mDButton6 = materialDialog.f993s;
        materialDialog.setTypeface(mDButton6, builder.T);
        mDButton6.setAllCapsCompat(resolveBoolean);
        mDButton6.setText(builder.f1024o);
        mDButton6.setTextColor(builder.f1040w);
        MDButton mDButton7 = materialDialog.f993s;
        DialogAction dialogAction2 = DialogAction.NEGATIVE;
        mDButton7.setStackedSelector(materialDialog.d(dialogAction2, true));
        materialDialog.f993s.setDefaultSelector(materialDialog.d(dialogAction2, false));
        materialDialog.f993s.setTag(dialogAction2);
        materialDialog.f993s.setOnClickListener(materialDialog);
        MDButton mDButton8 = materialDialog.f992r;
        materialDialog.setTypeface(mDButton8, builder.T);
        mDButton8.setAllCapsCompat(resolveBoolean);
        mDButton8.setText(builder.f1022n);
        mDButton8.setTextColor(builder.f1042x);
        MDButton mDButton9 = materialDialog.f992r;
        DialogAction dialogAction3 = DialogAction.NEUTRAL;
        mDButton9.setStackedSelector(materialDialog.d(dialogAction3, true));
        materialDialog.f992r.setDefaultSelector(materialDialog.d(dialogAction3, false));
        materialDialog.f992r.setTag(dialogAction3);
        materialDialog.f992r.setOnClickListener(materialDialog);
        if (builder.H != null) {
            materialDialog.f995u = new ArrayList();
        }
        if (materialDialog.f983i != null) {
            RecyclerView.Adapter<?> adapter = builder.X;
            if (adapter == null) {
                if (builder.G != null) {
                    materialDialog.f994t = MaterialDialog.f.SINGLE;
                } else if (builder.H != null) {
                    materialDialog.f994t = MaterialDialog.f.MULTI;
                    if (builder.P != null) {
                        materialDialog.f995u = new ArrayList(Arrays.asList(builder.P));
                        builder.P = null;
                    }
                } else {
                    materialDialog.f994t = MaterialDialog.f.REGULAR;
                }
                builder.X = new a(materialDialog, MaterialDialog.f.a(materialDialog.f994t));
            } else if (adapter instanceof MDAdapter) {
                ((MDAdapter) adapter).setDialog(materialDialog);
            }
        }
        f(materialDialog);
        e(materialDialog);
        if (builder.f1032s != null) {
            ((MDRootLayout) materialDialog.f1069a.findViewById(R.id.md_root)).noTitleNoPadding();
            FrameLayout frameLayout = (FrameLayout) materialDialog.f1069a.findViewById(R.id.md_customViewFrame);
            materialDialog.f985k = frameLayout;
            View view = builder.f1032s;
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (builder.f1005e0) {
                Resources resources = materialDialog.getContext().getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.md_dialog_frame_margin);
                ScrollView scrollView = new ScrollView(materialDialog.getContext());
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.md_content_padding_top);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.md_content_padding_bottom);
                scrollView.setClipToPadding(false);
                if (view instanceof EditText) {
                    scrollView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3);
                } else {
                    scrollView.setPadding(0, dimensionPixelSize2, 0, dimensionPixelSize3);
                    view.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                }
                scrollView.addView(view, new FrameLayout.LayoutParams(-1, -2));
                view = scrollView;
            }
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }
        DialogInterface.OnShowListener onShowListener = builder.f1001c0;
        if (onShowListener != null) {
            materialDialog.setOnShowListener(onShowListener);
        }
        DialogInterface.OnCancelListener onCancelListener = builder.f997a0;
        if (onCancelListener != null) {
            materialDialog.setOnCancelListener(onCancelListener);
        }
        DialogInterface.OnDismissListener onDismissListener = builder.Z;
        if (onDismissListener != null) {
            materialDialog.setOnDismissListener(onDismissListener);
        }
        DialogInterface.OnKeyListener onKeyListener = builder.f999b0;
        if (onKeyListener != null) {
            materialDialog.setOnKeyListener(onKeyListener);
        }
        materialDialog.a();
        materialDialog.g();
        materialDialog.b(materialDialog.f1069a);
        materialDialog.c();
        Display defaultDisplay = materialDialog.getWindow().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i8 = point.x;
        int i9 = point.y;
        int dimensionPixelSize4 = builder.f996a.getResources().getDimensionPixelSize(R.dimen.md_dialog_vertical_margin);
        int dimensionPixelSize5 = builder.f996a.getResources().getDimensionPixelSize(R.dimen.md_dialog_horizontal_margin);
        materialDialog.f1069a.setMaxHeight(i9 - (dimensionPixelSize4 * 2));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(materialDialog.getWindow().getAttributes());
        layoutParams.width = Math.min(builder.f996a.getResources().getDimensionPixelSize(R.dimen.md_dialog_max_width), i8 - (dimensionPixelSize5 * 2));
        materialDialog.getWindow().setAttributes(layoutParams);
    }

    private static void e(MaterialDialog materialDialog) {
        MaterialDialog.Builder builder = materialDialog.f977c;
        EditText editText = (EditText) materialDialog.f1069a.findViewById(16908297);
        materialDialog.f982h = editText;
        if (editText == null) {
            return;
        }
        materialDialog.setTypeface(editText, builder.S);
        CharSequence charSequence = builder.f1021m0;
        if (charSequence != null) {
            materialDialog.f982h.setText(charSequence);
        }
        materialDialog.j();
        materialDialog.f982h.setHint(builder.f1023n0);
        materialDialog.f982h.setSingleLine();
        materialDialog.f982h.setTextColor(builder.f1014j);
        materialDialog.f982h.setHintTextColor(DialogUtils.adjustAlpha(builder.f1014j, 0.3f));
        MDTintHelper.setTint(materialDialog.f982h, materialDialog.f977c.f1034t);
        int i4 = builder.f1029q0;
        if (i4 != -1) {
            materialDialog.f982h.setInputType(i4);
            int i5 = builder.f1029q0;
            if (i5 != 144 && (i5 & 128) == 128) {
                materialDialog.f982h.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
        TextView textView = (TextView) materialDialog.f1069a.findViewById(R.id.md_minMax);
        materialDialog.f989o = textView;
        if (builder.f1033s0 <= 0 && builder.f1035t0 <= -1) {
            textView.setVisibility(8);
            materialDialog.f989o = null;
            return;
        }
        materialDialog.f(materialDialog.f982h.getText().toString().length(), !builder.f1027p0);
    }

    private static void f(MaterialDialog materialDialog) {
        boolean z3;
        MaterialDialog.Builder builder = materialDialog.f977c;
        if (builder.f1013i0 || builder.f1017k0 > -2) {
            ProgressBar progressBar = (ProgressBar) materialDialog.f1069a.findViewById(16908301);
            materialDialog.f986l = progressBar;
            if (progressBar == null) {
                return;
            }
            if (builder.f1013i0) {
                if (builder.B0) {
                    IndeterminateHorizontalProgressDrawable indeterminateHorizontalProgressDrawable = new IndeterminateHorizontalProgressDrawable(builder.getContext());
                    indeterminateHorizontalProgressDrawable.setTint(builder.f1034t);
                    materialDialog.f986l.setProgressDrawable(indeterminateHorizontalProgressDrawable);
                    materialDialog.f986l.setIndeterminateDrawable(indeterminateHorizontalProgressDrawable);
                } else {
                    IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = new IndeterminateCircularProgressDrawable(builder.getContext());
                    indeterminateCircularProgressDrawable.setTint(builder.f1034t);
                    materialDialog.f986l.setProgressDrawable(indeterminateCircularProgressDrawable);
                    materialDialog.f986l.setIndeterminateDrawable(indeterminateCircularProgressDrawable);
                }
            } else {
                HorizontalProgressDrawable horizontalProgressDrawable = new HorizontalProgressDrawable(builder.getContext());
                horizontalProgressDrawable.setTint(builder.f1034t);
                materialDialog.f986l.setProgressDrawable(horizontalProgressDrawable);
                materialDialog.f986l.setIndeterminateDrawable(horizontalProgressDrawable);
            }
            boolean z4 = builder.f1013i0;
            if (!z4 || builder.B0) {
                ProgressBar progressBar2 = materialDialog.f986l;
                if (z4 && builder.B0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                progressBar2.setIndeterminate(z3);
                materialDialog.f986l.setProgress(0);
                materialDialog.f986l.setMax(builder.f1019l0);
                TextView textView = (TextView) materialDialog.f1069a.findViewById(R.id.md_label);
                materialDialog.f987m = textView;
                if (textView != null) {
                    textView.setTextColor(builder.f1014j);
                    materialDialog.setTypeface(materialDialog.f987m, builder.T);
                    materialDialog.f987m.setText(builder.A0.format(0L));
                }
                TextView textView2 = (TextView) materialDialog.f1069a.findViewById(R.id.md_minMax);
                materialDialog.f988n = textView2;
                if (textView2 != null) {
                    textView2.setTextColor(builder.f1014j);
                    materialDialog.setTypeface(materialDialog.f988n, builder.S);
                    if (builder.f1015j0) {
                        materialDialog.f988n.setVisibility(0);
                        materialDialog.f988n.setText(String.format(builder.f1047z0, 0, Integer.valueOf(builder.f1019l0)));
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) materialDialog.f986l.getLayoutParams();
                        marginLayoutParams.leftMargin = 0;
                        marginLayoutParams.rightMargin = 0;
                    } else {
                        materialDialog.f988n.setVisibility(8);
                    }
                } else {
                    builder.f1015j0 = false;
                }
            }
        }
        ProgressBar progressBar3 = materialDialog.f986l;
        if (progressBar3 != null) {
            a(progressBar3);
        }
    }

    private static void a(ProgressBar progressBar) {
    }
}
