package com.afollestad.materialdialogs.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.util.DialogUtils;
import java.lang.reflect.Field;

@SuppressLint({"PrivateResource"})
/* loaded from: classes2.dex */
public class MDTintHelper {
    private static ColorStateList a(@NonNull Context context, @ColorInt int i4) {
        int i5 = R.attr.colorControlNormal;
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{-16842919, -16842908}, new int[0]}, new int[]{DialogUtils.resolveColor(context, i5), DialogUtils.resolveColor(context, i5), i4});
    }

    private static void b(@NonNull EditText editText, @ColorInt int i4) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i5 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable[] drawableArr = {ContextCompat.getDrawable(editText.getContext(), i5), ContextCompat.getDrawable(editText.getContext(), i5)};
            drawableArr[0].setColorFilter(i4, PorterDuff.Mode.SRC_IN);
            drawableArr[1].setColorFilter(i4, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, drawableArr);
        } catch (NoSuchFieldException e4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Device issue with cursor tinting: ");
            sb.append(e4.getMessage());
            e4.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private static void c(@NonNull ProgressBar progressBar, @ColorInt int i4, boolean z3) {
        ColorStateList valueOf = ColorStateList.valueOf(i4);
        progressBar.setProgressTintList(valueOf);
        progressBar.setSecondaryProgressTintList(valueOf);
        if (!z3) {
            progressBar.setIndeterminateTintList(valueOf);
        }
    }

    public static void setTint(@NonNull RadioButton radioButton, @NonNull ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 22) {
            radioButton.setButtonTintList(colorStateList);
            return;
        }
        Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(radioButton.getContext(), R.drawable.abc_btn_radio_material));
        DrawableCompat.setTintList(wrap, colorStateList);
        radioButton.setButtonDrawable(wrap);
    }

    public static void setTint(@NonNull RadioButton radioButton, @ColorInt int i4) {
        int disabledColor = DialogUtils.getDisabledColor(radioButton.getContext());
        setTint(radioButton, new ColorStateList(new int[][]{new int[]{16842910, -16842912}, new int[]{16842910, 16842912}, new int[]{-16842910, -16842912}, new int[]{-16842910, 16842912}}, new int[]{DialogUtils.resolveColor(radioButton.getContext(), R.attr.colorControlNormal), i4, disabledColor, disabledColor}));
    }

    public static void setTint(@NonNull CheckBox checkBox, @NonNull ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 22) {
            checkBox.setButtonTintList(colorStateList);
            return;
        }
        Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(checkBox.getContext(), R.drawable.abc_btn_check_material));
        DrawableCompat.setTintList(wrap, colorStateList);
        checkBox.setButtonDrawable(wrap);
    }

    public static void setTint(@NonNull CheckBox checkBox, @ColorInt int i4) {
        int disabledColor = DialogUtils.getDisabledColor(checkBox.getContext());
        setTint(checkBox, new ColorStateList(new int[][]{new int[]{16842910, -16842912}, new int[]{16842910, 16842912}, new int[]{-16842910, -16842912}, new int[]{-16842910, 16842912}}, new int[]{DialogUtils.resolveColor(checkBox.getContext(), R.attr.colorControlNormal), i4, disabledColor, disabledColor}));
    }

    public static void setTint(@NonNull SeekBar seekBar, @ColorInt int i4) {
        ColorStateList valueOf = ColorStateList.valueOf(i4);
        seekBar.setThumbTintList(valueOf);
        seekBar.setProgressTintList(valueOf);
    }

    public static void setTint(@NonNull ProgressBar progressBar, @ColorInt int i4) {
        c(progressBar, i4, false);
    }

    public static void setTint(@NonNull EditText editText, @ColorInt int i4) {
        ColorStateList a4 = a(editText.getContext(), i4);
        if (editText instanceof AppCompatEditText) {
            ((AppCompatEditText) editText).setSupportBackgroundTintList(a4);
        } else {
            editText.setBackgroundTintList(a4);
        }
        b(editText, i4);
    }
}
