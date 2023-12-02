package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class TextDrawableHelper {

    /* renamed from: c  reason: collision with root package name */
    private float f23904c;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private TextAppearance f23907f;

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f23902a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final TextAppearanceFontCallback f23903b = new TextAppearanceFontCallback() { // from class: com.google.android.material.internal.TextDrawableHelper.1
        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrievalFailed(int i4) {
            TextDrawableHelper.this.f23905d = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.f23906e.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrieved(@NonNull Typeface typeface, boolean z3) {
            if (!z3) {
                TextDrawableHelper.this.f23905d = true;
                TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.f23906e.get();
                if (textDrawableDelegate != null) {
                    textDrawableDelegate.onTextSizeChange();
                }
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private boolean f23905d = true;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<TextDrawableDelegate> f23906e = new WeakReference<>(null);

    /* loaded from: classes5.dex */
    public interface TextDrawableDelegate {
        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);

        void onTextSizeChange();
    }

    public TextDrawableHelper(@Nullable TextDrawableDelegate textDrawableDelegate) {
        setDelegate(textDrawableDelegate);
    }

    private float c(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f23902a.measureText(charSequence, 0, charSequence.length());
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.f23907f;
    }

    @NonNull
    public TextPaint getTextPaint() {
        return this.f23902a;
    }

    public float getTextWidth(String str) {
        if (!this.f23905d) {
            return this.f23904c;
        }
        float c4 = c(str);
        this.f23904c = c4;
        this.f23905d = false;
        return c4;
    }

    public boolean isTextWidthDirty() {
        return this.f23905d;
    }

    public void setDelegate(@Nullable TextDrawableDelegate textDrawableDelegate) {
        this.f23906e = new WeakReference<>(textDrawableDelegate);
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance, Context context) {
        if (this.f23907f != textAppearance) {
            this.f23907f = textAppearance;
            if (textAppearance != null) {
                textAppearance.updateMeasureState(context, this.f23902a, this.f23903b);
                TextDrawableDelegate textDrawableDelegate = this.f23906e.get();
                if (textDrawableDelegate != null) {
                    this.f23902a.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.updateDrawState(context, this.f23902a, this.f23903b);
                this.f23905d = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = this.f23906e.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.onTextSizeChange();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void setTextWidthDirty(boolean z3) {
        this.f23905d = z3;
    }

    public void updateTextPaintDrawState(Context context) {
        this.f23907f.updateDrawState(context, this.f23902a, this.f23903b);
    }
}
