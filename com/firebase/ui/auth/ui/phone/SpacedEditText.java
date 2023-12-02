package com.firebase.ui.auth.ui.phone;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes3.dex */
public final class SpacedEditText extends TextInputEditText {

    /* renamed from: c  reason: collision with root package name */
    private float f18185c;

    /* renamed from: d  reason: collision with root package name */
    private SpannableStringBuilder f18186d;

    public SpacedEditText(Context context) {
        super(context);
        this.f18186d = new SpannableStringBuilder("");
    }

    private SpannableStringBuilder b(CharSequence charSequence) {
        int i4;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int length = charSequence.length();
        int i5 = -1;
        int i6 = 0;
        while (true) {
            i4 = length - 1;
            if (i6 >= i4) {
                break;
            }
            spannableStringBuilder.append(charSequence.charAt(i6));
            spannableStringBuilder.append((CharSequence) MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            i5 += 2;
            spannableStringBuilder.setSpan(new ScaleXSpan(this.f18185c), i5, i5 + 1, 33);
            i6++;
        }
        if (length != 0) {
            spannableStringBuilder.append(charSequence.charAt(i4));
        }
        return spannableStringBuilder;
    }

    void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SpacedEditText);
        this.f18185c = obtainStyledAttributes.getFloat(R.styleable.SpacedEditText_spacingProportion, 1.0f);
        obtainStyledAttributes.recycle();
    }

    public Editable getUnspacedText() {
        return this.f18186d;
    }

    @Override // android.widget.EditText
    public void setSelection(int i4) {
        int min = Math.min(Math.max((i4 * 2) - 1, 0), (this.f18186d.length() * 2) - 1);
        try {
            super.setSelection(min);
        } catch (IndexOutOfBoundsException e4) {
            throw new IndexOutOfBoundsException(e4.getMessage() + ", requestedIndex=" + i4 + ", newIndex= " + min + ", originalText=" + ((Object) this.f18186d));
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f18186d = new SpannableStringBuilder(charSequence);
        super.setText(b(charSequence), TextView.BufferType.SPANNABLE);
    }

    public SpacedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18186d = new SpannableStringBuilder("");
        c(context, attributeSet);
    }
}
