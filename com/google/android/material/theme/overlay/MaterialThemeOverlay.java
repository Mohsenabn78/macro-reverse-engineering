package com.google.android.material.theme.overlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.R;

/* loaded from: classes5.dex */
public class MaterialThemeOverlay {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f24702a = {16842752, R.attr.theme};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f24703b = {R.attr.materialThemeOverlay};

    private MaterialThemeOverlay() {
    }

    @StyleRes
    private static int a(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f24702a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0) {
            return resourceId2;
        }
        return resourceId;
    }

    @StyleRes
    private static int b(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f24703b, i4, i5);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @NonNull
    public static Context wrap(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        boolean z3;
        int b4 = b(context, attributeSet, i4, i5);
        if ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == b4) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (b4 != 0 && !z3) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, b4);
            int a4 = a(context, attributeSet);
            if (a4 != 0) {
                contextThemeWrapper.getTheme().applyStyle(a4, true);
            }
            return contextThemeWrapper;
        }
        return context;
    }
}
