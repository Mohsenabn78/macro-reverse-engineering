package com.arlosoft.macrodroid.common;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.EditTextPreference;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;

/* loaded from: classes3.dex */
public class EncryptedEditTextPreference extends EditTextPreference {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleEncryption f9856a;

    public EncryptedEditTextPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f9856a = new SimpleEncryption();
    }

    @Override // androidx.preference.EditTextPreference
    public String getText() {
        String text = super.getText();
        if (text != null) {
            try {
                if (text.length() > 0) {
                    return this.f9856a.decrypt(text);
                }
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("EncryptedTextPreference: Failed to decrypt: " + e4.getMessage()));
            }
        }
        return text;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(boolean z3, Object obj) {
        String str;
        if (z3) {
            str = getPersistedString(null);
        } else {
            str = (String) obj;
        }
        super.setText(str);
    }

    @Override // androidx.preference.EditTextPreference
    public void setText(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    super.setText(this.f9856a.encrypt(str));
                }
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("EncryptedTextPreference: Failed to encrypt: " + e4.getMessage()));
            }
        }
    }

    public EncryptedEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9856a = new SimpleEncryption();
    }

    public EncryptedEditTextPreference(Context context) {
        super(context);
        this.f9856a = new SimpleEncryption();
    }
}
