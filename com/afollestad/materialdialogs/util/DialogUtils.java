package com.afollestad.materialdialogs.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

/* loaded from: classes2.dex */
public class DialogUtils {

    /* loaded from: classes2.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MaterialDialog f1203a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MaterialDialog.Builder f1204b;

        a(MaterialDialog materialDialog, MaterialDialog.Builder builder) {
            this.f1203a = materialDialog;
            this.f1204b = builder;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1203a.getInputEditText().requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1204b.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f1203a.getInputEditText(), 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1205a;

        static {
            int[] iArr = new int[GravityEnum.values().length];
            f1205a = iArr;
            try {
                iArr[GravityEnum.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1205a[GravityEnum.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static int a(GravityEnum gravityEnum) {
        int i4 = b.f1205a[gravityEnum.ordinal()];
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            if (i4 != 2) {
                return 0;
            }
        }
        return i5;
    }

    @ColorInt
    public static int adjustAlpha(@ColorInt int i4, float f4) {
        return Color.argb(Math.round(Color.alpha(i4) * f4), Color.red(i4), Color.green(i4), Color.blue(i4));
    }

    private static int b(Context context, @AttrRes int i4, int i5) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i4});
        try {
            return obtainStyledAttributes.getDimensionPixelSize(0, i5);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static Drawable c(Context context, @AttrRes int i4, Drawable drawable) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i4});
        try {
            Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
            if (drawable2 != null || drawable == null) {
                drawable = drawable2;
            }
            return drawable;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getActionTextColorStateList(Context context, @ColorRes int i4) {
        ColorStateList colorStateList;
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i4, typedValue, true);
        int i5 = typedValue.type;
        if (i5 >= 28 && i5 <= 31) {
            return getActionTextStateList(context, typedValue.data);
        }
        if (Build.VERSION.SDK_INT > 22) {
            colorStateList = context.getColorStateList(i4);
            return colorStateList;
        }
        return context.getResources().getColorStateList(i4);
    }

    public static ColorStateList getActionTextStateList(Context context, int i4) {
        int resolveColor = resolveColor(context, 16842806);
        if (i4 == 0) {
            i4 = resolveColor;
        }
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[0]}, new int[]{adjustAlpha(i4, 0.4f), i4});
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int i4) {
        return ContextCompat.getColor(context, i4);
    }

    public static int[] getColorArray(@NonNull Context context, @ArrayRes int i4) {
        if (i4 == 0) {
            return null;
        }
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i4);
        int[] iArr = new int[obtainTypedArray.length()];
        for (int i5 = 0; i5 < obtainTypedArray.length(); i5++) {
            iArr[i5] = obtainTypedArray.getColor(i5, 0);
        }
        obtainTypedArray.recycle();
        return iArr;
    }

    @ColorInt
    public static int getDisabledColor(Context context) {
        int i4;
        if (isColorDark(resolveColor(context, 16842806))) {
            i4 = -16777216;
        } else {
            i4 = -1;
        }
        return adjustAlpha(i4, 0.3f);
    }

    public static void hideKeyboard(@NonNull DialogInterface dialogInterface, @NonNull MaterialDialog.Builder builder) {
        InputMethodManager inputMethodManager;
        IBinder iBinder;
        MaterialDialog materialDialog = (MaterialDialog) dialogInterface;
        if (materialDialog.getInputEditText() != null && (inputMethodManager = (InputMethodManager) builder.getContext().getSystemService("input_method")) != null) {
            View currentFocus = materialDialog.getCurrentFocus();
            if (currentFocus != null) {
                iBinder = currentFocus.getWindowToken();
            } else if (materialDialog.getView() != null) {
                iBinder = materialDialog.getView().getWindowToken();
            } else {
                iBinder = null;
            }
            if (iBinder != null) {
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            }
        }
    }

    public static boolean isColorDark(@ColorInt int i4) {
        if (1.0d - ((((Color.red(i4) * 0.299d) + (Color.green(i4) * 0.587d)) + (Color.blue(i4) * 0.114d)) / 255.0d) >= 0.5d) {
            return true;
        }
        return false;
    }

    public static <T> boolean isIn(@NonNull T t3, @Nullable T[] tArr) {
        if (tArr != null && tArr.length != 0) {
            for (T t4 : tArr) {
                if (t4.equals(t3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ColorStateList resolveActionTextColorStateList(Context context, @AttrRes int i4, ColorStateList colorStateList) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i4});
        try {
            TypedValue peekValue = obtainStyledAttributes.peekValue(0);
            if (peekValue == null) {
                return colorStateList;
            }
            int i5 = peekValue.type;
            if (i5 >= 28 && i5 <= 31) {
                return getActionTextStateList(context, peekValue.data);
            }
            ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(0);
            if (colorStateList2 != null) {
                return colorStateList2;
            }
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static boolean resolveBoolean(Context context, @AttrRes int i4, boolean z3) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i4});
        try {
            return obtainStyledAttributes.getBoolean(0, z3);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @ColorInt
    public static int resolveColor(Context context, @AttrRes int i4) {
        return resolveColor(context, i4, 0);
    }

    public static int resolveDimension(Context context, @AttrRes int i4) {
        return b(context, i4, -1);
    }

    public static Drawable resolveDrawable(Context context, @AttrRes int i4) {
        return c(context, i4, null);
    }

    public static GravityEnum resolveGravityEnum(Context context, @AttrRes int i4, GravityEnum gravityEnum) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i4});
        try {
            int i5 = obtainStyledAttributes.getInt(0, a(gravityEnum));
            if (i5 != 1) {
                if (i5 != 2) {
                    return GravityEnum.START;
                }
                return GravityEnum.END;
            }
            return GravityEnum.CENTER;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static String resolveString(Context context, @AttrRes int i4) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i4, typedValue, true);
        return (String) typedValue.string;
    }

    public static void setBackgroundCompat(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void showKeyboard(@NonNull DialogInterface dialogInterface, @NonNull MaterialDialog.Builder builder) {
        MaterialDialog materialDialog = (MaterialDialog) dialogInterface;
        if (materialDialog.getInputEditText() == null) {
            return;
        }
        materialDialog.getInputEditText().post(new a(materialDialog, builder));
    }

    @ColorInt
    public static int resolveColor(Context context, @AttrRes int i4, int i5) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i4});
        try {
            return obtainStyledAttributes.getColor(0, i5);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static boolean resolveBoolean(Context context, @AttrRes int i4) {
        return resolveBoolean(context, i4, false);
    }
}
