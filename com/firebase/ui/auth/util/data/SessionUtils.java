package com.firebase.ui.auth.util.data;

import androidx.annotation.RestrictTo;
import java.util.Random;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class SessionUtils {
    public static String generateRandomAlphaNumericString(int i4) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(i4)));
        }
        return sb.toString();
    }
}
