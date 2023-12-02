package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.widget.Toast;
import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/* loaded from: classes3.dex */
public class PwdEditTextPreference extends EditTextPreference {
    public PwdEditTextPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }

    @Override // android.preference.EditTextPreference
    public void setText(String str) {
        String text = super.getText();
        if (str != null && str.trim().length() >= 4) {
            if (text != null && text.trim().length() != 0 && !text.equals(str)) {
                if (!text.equals(str)) {
                    HashFunction md5 = Hashing.md5();
                    super.setText(md5.hashString(str + "8L9f7BL5Ot5jCJ0Hu7iO", Charsets.UTF_8).toString());
                    return;
                }
                return;
            }
            super.setText(str);
            return;
        }
        Toast.makeText(getContext(), "Le mot de passe doit être composé d'un minimum de 4 caractères", 1).show();
    }

    public PwdEditTextPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public PwdEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PwdEditTextPreference(Context context) {
        super(context);
    }
}
