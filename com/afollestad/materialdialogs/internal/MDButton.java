package com.afollestad.materialdialogs.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.util.DialogUtils;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class MDButton extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1123a;

    /* renamed from: b  reason: collision with root package name */
    private GravityEnum f1124b;

    /* renamed from: c  reason: collision with root package name */
    private int f1125c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f1126d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1127e;

    public MDButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1123a = false;
        a(context);
    }

    private void a(Context context) {
        this.f1125c = context.getResources().getDimensionPixelSize(R.dimen.md_dialog_frame_margin);
        this.f1124b = GravityEnum.END;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z3, boolean z4) {
        int i4;
        int i5;
        Drawable drawable;
        if (this.f1123a != z3 || z4) {
            if (z3) {
                i4 = this.f1124b.getGravityInt() | 16;
            } else {
                i4 = 17;
            }
            setGravity(i4);
            if (z3) {
                i5 = this.f1124b.getTextAlignment();
            } else {
                i5 = 4;
            }
            setTextAlignment(i5);
            if (z3) {
                drawable = this.f1126d;
            } else {
                drawable = this.f1127e;
            }
            DialogUtils.setBackgroundCompat(this, drawable);
            if (z3) {
                setPadding(this.f1125c, getPaddingTop(), this.f1125c, getPaddingBottom());
            }
            this.f1123a = z3;
        }
    }

    public void setAllCapsCompat(boolean z3) {
        setAllCaps(z3);
    }

    public void setDefaultSelector(Drawable drawable) {
        this.f1127e = drawable;
        if (!this.f1123a) {
            b(false, true);
        }
    }

    public void setStackedGravity(GravityEnum gravityEnum) {
        this.f1124b = gravityEnum;
    }

    public void setStackedSelector(Drawable drawable) {
        this.f1126d = drawable;
        if (this.f1123a) {
            b(true, true);
        }
    }

    public MDButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1123a = false;
        a(context);
    }
}
