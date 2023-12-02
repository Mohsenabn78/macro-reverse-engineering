package com.takisoft.preferencex;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.preference.EditTextPreference;

/* loaded from: classes6.dex */
public class EditTextPreference extends androidx.preference.EditTextPreference {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private EditTextPreference.OnBindEditTextListener f37961a;

    /* renamed from: b  reason: collision with root package name */
    private SparseArrayCompat<TypedValue> f37962b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37963c;

    /* loaded from: classes6.dex */
    class a implements EditTextPreference.OnBindEditTextListener {
        a() {
        }

        @Override // androidx.preference.EditTextPreference.OnBindEditTextListener
        public void onBindEditText(@NonNull EditText editText) {
            if (!EditTextPreference.this.f37963c) {
                EditTextPreference.this.e(editText);
            }
            int size = EditTextPreference.this.f37962b.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = EditTextPreference.this.f37962b.keyAt(i4);
                int i5 = ((TypedValue) EditTextPreference.this.f37962b.valueAt(i4)).data;
                switch (keyAt) {
                    case 16843091:
                        editText.setMaxLines(i5);
                        break;
                    case 16843092:
                        editText.setLines(i5);
                        break;
                    case 16843094:
                        editText.setMinLines(i5);
                        break;
                    case 16843095:
                        editText.setMaxEms(i5);
                        break;
                    case 16843096:
                        editText.setEms(i5);
                        break;
                    case 16843098:
                        editText.setMinEms(i5);
                        break;
                    case 16843296:
                        editText.setInputType(i5);
                        break;
                    case 16843660:
                        boolean z3 = true;
                        if (i5 != 1) {
                            z3 = false;
                        }
                        editText.setAllCaps(z3);
                        break;
                }
            }
            if (EditTextPreference.this.f37961a != null) {
                EditTextPreference.this.f37961a.onBindEditText(editText);
            }
        }
    }

    public EditTextPreference(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(@NonNull View view) {
        View findViewById;
        ViewParent parent = view.getParent();
        if ((parent instanceof ViewGroup) && (findViewById = ((ViewGroup) parent).findViewById(16908299)) != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = 0;
                findViewById.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private void f(AttributeSet attributeSet) {
        TypedValue typedValue;
        if (attributeSet == null) {
            return;
        }
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i4);
            int attributeResourceValue = attributeSet.getAttributeResourceValue(i4, 0);
            switch (attributeNameResource) {
                case 16843091:
                case 16843092:
                case 16843094:
                case 16843095:
                case 16843096:
                case 16843098:
                    typedValue = new TypedValue();
                    typedValue.resourceId = attributeResourceValue;
                    typedValue.data = attributeSet.getAttributeIntValue(i4, -1);
                    typedValue.type = 16;
                    break;
                case 16843296:
                    typedValue = new TypedValue();
                    typedValue.resourceId = attributeResourceValue;
                    typedValue.data = attributeSet.getAttributeIntValue(i4, 1);
                    typedValue.type = 17;
                    break;
                case 16843660:
                    typedValue = new TypedValue();
                    typedValue.resourceId = attributeResourceValue;
                    typedValue.data = attributeSet.getAttributeBooleanValue(i4, false) ? 1 : 0;
                    typedValue.type = 18;
                    break;
                default:
                    typedValue = null;
                    break;
            }
            if (typedValue != null) {
                this.f37962b.put(attributeNameResource, typedValue);
            }
        }
    }

    @Deprecated
    public EditText getEditText() {
        throw new UnsupportedOperationException("Use OnBindEditTextListener to modify the EditText");
    }

    @Nullable
    public EditTextPreference.OnBindEditTextListener getOnBindEditTextListener() {
        return this.f37961a;
    }

    @Override // androidx.preference.EditTextPreference
    public void setOnBindEditTextListener(@Nullable EditTextPreference.OnBindEditTextListener onBindEditTextListener) {
        this.f37961a = onBindEditTextListener;
    }

    @Override // androidx.preference.EditTextPreference
    public void setText(String str) {
        String text = getText();
        super.setText(str);
        if (!TextUtils.equals(str, text)) {
            notifyChanged();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextPreferenceStyle);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f37962b = new SparseArrayCompat<>();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.EditTextPreference, i4, i5);
        this.f37963c = obtainStyledAttributes.getBoolean(R.styleable.EditTextPreference_pref_disableMessagePaddingFix, false);
        obtainStyledAttributes.recycle();
        f(attributeSet);
        super.setOnBindEditTextListener(new a());
    }
}
