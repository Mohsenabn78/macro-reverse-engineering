package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class TextAppearance {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private ColorStateList f24126a;

    /* renamed from: b  reason: collision with root package name */
    private float f24127b;
    @FontRes

    /* renamed from: c  reason: collision with root package name */
    private final int f24128c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24129d = false;

    /* renamed from: e  reason: collision with root package name */
    private Typeface f24130e;
    @Nullable
    public final String fontFamily;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    @Nullable
    public final ColorStateList textColorHint;
    @Nullable
    public final ColorStateList textColorLink;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(@NonNull Context context, @StyleRes int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, R.styleable.TextAppearance);
        setTextSize(obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        setTextColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int a4 = MaterialResources.a(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.f24128c = obtainStyledAttributes.getResourceId(a4, 0);
        this.fontFamily = obtainStyledAttributes.getString(a4);
        this.textAllCaps = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i4, R.styleable.MaterialTextAppearance);
        int i5 = R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(i5);
        this.letterSpacing = obtainStyledAttributes2.getFloat(i5, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f24130e == null && (str = this.fontFamily) != null) {
            this.f24130e = Typeface.create(str, this.textStyle);
        }
        if (this.f24130e == null) {
            int i4 = this.typeface;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        this.f24130e = Typeface.DEFAULT;
                    } else {
                        this.f24130e = Typeface.MONOSPACE;
                    }
                } else {
                    this.f24130e = Typeface.SERIF;
                }
            } else {
                this.f24130e = Typeface.SANS_SERIF;
            }
            this.f24130e = Typeface.create(this.f24130e, this.textStyle);
        }
    }

    private boolean e(Context context) {
        Typeface typeface;
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            return true;
        }
        int i4 = this.f24128c;
        if (i4 != 0) {
            typeface = ResourcesCompat.getCachedFont(context, i4);
        } else {
            typeface = null;
        }
        if (typeface != null) {
            return true;
        }
        return false;
    }

    public Typeface getFallbackFont() {
        d();
        return this.f24130e;
    }

    @NonNull
    @VisibleForTesting
    public Typeface getFont(@NonNull Context context) {
        if (this.f24129d) {
            return this.f24130e;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.f24128c);
                this.f24130e = font;
                if (font != null) {
                    this.f24130e = Typeface.create(font, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error loading font ");
                sb.append(this.fontFamily);
            }
        }
        d();
        this.f24129d = true;
        return this.f24130e;
    }

    public void getFontAsync(@NonNull Context context, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (e(context)) {
            getFont(context);
        } else {
            d();
        }
        int i4 = this.f24128c;
        if (i4 == 0) {
            this.f24129d = true;
        }
        if (this.f24129d) {
            textAppearanceFontCallback.onFontRetrieved(this.f24130e, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i4, new ResourcesCompat.FontCallback() { // from class: com.google.android.material.resources.TextAppearance.1
                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public void onFontRetrievalFailed(int i5) {
                    TextAppearance.this.f24129d = true;
                    textAppearanceFontCallback.onFontRetrievalFailed(i5);
                }

                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public void onFontRetrieved(@NonNull Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.f24130e = Typeface.create(typeface, textAppearance.textStyle);
                    TextAppearance.this.f24129d = true;
                    textAppearanceFontCallback.onFontRetrieved(TextAppearance.this.f24130e, false);
                }
            }, null);
        } catch (Resources.NotFoundException unused) {
            this.f24129d = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error loading font ");
            sb.append(this.fontFamily);
            this.f24129d = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    @Nullable
    public ColorStateList getTextColor() {
        return this.f24126a;
    }

    public float getTextSize() {
        return this.f24127b;
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        this.f24126a = colorStateList;
    }

    public void setTextSize(float f4) {
        this.f24127b = f4;
    }

    public void updateDrawState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        int i4;
        int i5;
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.f24126a;
        if (colorStateList != null) {
            i4 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i4 = -16777216;
        }
        textPaint.setColor(i4);
        float f4 = this.shadowRadius;
        float f5 = this.shadowDx;
        float f6 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        if (colorStateList2 != null) {
            i5 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i5 = 0;
        }
        textPaint.setShadowLayer(f4, f5, f6, i5);
    }

    public void updateMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        if (e(context)) {
            updateTextPaintMeasureState(textPaint, getFont(context));
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        boolean z3;
        float f4;
        textPaint.setTypeface(typeface);
        int i4 = (~typeface.getStyle()) & this.textStyle;
        if ((i4 & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        textPaint.setFakeBoldText(z3);
        if ((i4 & 2) != 0) {
            f4 = -0.25f;
        } else {
            f4 = 0.0f;
        }
        textPaint.setTextSkewX(f4);
        textPaint.setTextSize(this.f24127b);
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }

    public void getFontAsync(@NonNull Context context, @NonNull final TextPaint textPaint, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(textPaint, getFallbackFont());
        getFontAsync(context, new TextAppearanceFontCallback() { // from class: com.google.android.material.resources.TextAppearance.2
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrievalFailed(int i4) {
                textAppearanceFontCallback.onFontRetrievalFailed(i4);
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrieved(@NonNull Typeface typeface, boolean z3) {
                TextAppearance.this.updateTextPaintMeasureState(textPaint, typeface);
                textAppearanceFontCallback.onFontRetrieved(typeface, z3);
            }
        });
    }
}
