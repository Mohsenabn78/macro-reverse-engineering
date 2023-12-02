package com.takisoft.preferencex;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.android.dex.DexFormat;
import com.android.dx.io.Opcodes;

@Deprecated
/* loaded from: classes6.dex */
public class AutoSummaryEditTextPreference extends EditTextPreference {

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f37956d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f37957e;

    /* renamed from: f  reason: collision with root package name */
    private String f37958f;

    /* renamed from: g  reason: collision with root package name */
    private int f37959g;

    /* renamed from: h  reason: collision with root package name */
    private int f37960h;

    public AutoSummaryEditTextPreference(Context context) {
        this(context, null);
    }

    public CharSequence getPasswordSubstitute() {
        return this.f37958f;
    }

    public int getPasswordSubstituteLength() {
        return this.f37959g;
    }

    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        String text = getText();
        if (!(!TextUtils.isEmpty(text))) {
            return this.f37957e;
        }
        int i4 = this.f37960h;
        if ((i4 & 16) == 16 || (i4 & 128) == 128 || (i4 & Opcodes.SHL_INT_LIT8) == 224) {
            int i5 = this.f37959g;
            if (i5 <= 0) {
                i5 = text.length();
            }
            text = new String(new char[i5]).replaceAll(DexFormat.MAGIC_SUFFIX, this.f37958f);
        }
        CharSequence charSequence = this.f37956d;
        if (charSequence != null) {
            return String.format(charSequence.toString(), text);
        }
        return text;
    }

    @Nullable
    public CharSequence getSummaryHasText() {
        return this.f37956d;
    }

    public void setPasswordSubstitute(@StringRes int i4) {
        setPasswordSubstitute(getContext().getString(i4));
    }

    public void setPasswordSubstituteLength(int i4) {
        this.f37959g = i4;
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.f37957e != null) {
            this.f37957e = null;
        } else if (charSequence != null && !charSequence.equals(this.f37957e)) {
            this.f37957e = charSequence.toString();
        }
    }

    public void setSummaryHasText(@StringRes int i4) {
        setSummaryHasText(getContext().getString(i4));
    }

    public AutoSummaryEditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextPreferenceStyle);
    }

    public void setPasswordSubstitute(String str) {
        this.f37958f = str;
    }

    public void setSummaryHasText(@Nullable CharSequence charSequence) {
        if (charSequence == null && this.f37956d != null) {
            this.f37956d = null;
        } else if (charSequence != null && !charSequence.equals(this.f37956d)) {
            this.f37956d = charSequence.toString();
        }
        notifyChanged();
    }

    public AutoSummaryEditTextPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public AutoSummaryEditTextPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f37960h = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoSummaryEditTextPreference, i4, 0);
        this.f37956d = obtainStyledAttributes.getText(R.styleable.AutoSummaryEditTextPreference_pref_summaryHasText);
        this.f37958f = obtainStyledAttributes.getString(R.styleable.AutoSummaryEditTextPreference_pref_summaryPasswordSubstitute);
        this.f37959g = obtainStyledAttributes.getInt(R.styleable.AutoSummaryEditTextPreference_pref_summaryPasswordSubstituteLength, 5);
        if (this.f37958f == null) {
            this.f37958f = "•";
        }
        obtainStyledAttributes.recycle();
        this.f37957e = super.getSummary();
        for (int i6 = 0; i6 < attributeSet.getAttributeCount(); i6++) {
            if (16843296 == attributeSet.getAttributeNameResource(i6)) {
                this.f37960h = attributeSet.getAttributeIntValue(i6, 1);
                return;
            }
        }
    }
}
