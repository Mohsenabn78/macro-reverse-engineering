package com.firebase.ui.auth.util.ui;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class TextHelper {
    public static void boldAllOccurencesOfText(@NonNull SpannableStringBuilder spannableStringBuilder, @NonNull String str, @NonNull String str2) {
        int i4 = 0;
        while (i4 < str.length()) {
            int indexOf = str.indexOf(str2, i4);
            int length = str2.length() + indexOf;
            if (indexOf != -1 && length <= str.length()) {
                spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, length, 17);
                i4 = length + 1;
            } else {
                return;
            }
        }
    }
}
