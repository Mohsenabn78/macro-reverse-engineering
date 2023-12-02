package com.firebase.ui.auth.util.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.TextViewCompat;
import com.firebase.ui.auth.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class SupportVectorDrawablesButton extends AppCompatButton {
    public SupportVectorDrawablesButton(Context context) {
        super(context);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SupportVectorDrawablesButton);
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this, obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableStartCompat), obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableTopCompat), obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableEndCompat), obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableBottomCompat));
        obtainStyledAttributes.recycle();
    }

    public SupportVectorDrawablesButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public SupportVectorDrawablesButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a(attributeSet);
    }
}
