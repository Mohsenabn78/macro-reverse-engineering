package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R;
import com.google.android.gms.common.util.DeviceProperties;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaaa extends Button {
    public zaaa(Context context, @Nullable AttributeSet attributeSet) {
        super(context, null, 16842824);
    }

    private static final int a(int i4, int i5, int i6, int i7) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return i7;
                }
                throw new IllegalStateException("Unknown color scheme: " + i4);
            }
            return i6;
        }
        return i5;
    }

    public final void zaa(Resources resources, int i4, int i5) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i6 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i6);
        setMinWidth(i6);
        int i7 = R.drawable.common_google_signin_btn_icon_dark;
        int i8 = R.drawable.common_google_signin_btn_icon_light;
        int a4 = a(i5, i7, i8, i8);
        int i9 = R.drawable.common_google_signin_btn_text_dark;
        int i10 = R.drawable.common_google_signin_btn_text_light;
        int a5 = a(i5, i9, i10, i10);
        if (i4 != 0 && i4 != 1) {
            if (i4 != 2) {
                throw new IllegalStateException("Unknown button size: " + i4);
            }
        } else {
            a4 = a5;
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(a4));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        int i11 = R.color.common_google_signin_btn_text_dark;
        int i12 = R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(a(i5, i11, i12, i12))));
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    setText((CharSequence) null);
                } else {
                    throw new IllegalStateException("Unknown button size: " + i4);
                }
            } else {
                setText(resources.getString(R.string.common_signin_button_text_long));
            }
        } else {
            setText(resources.getString(R.string.common_signin_button_text));
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
