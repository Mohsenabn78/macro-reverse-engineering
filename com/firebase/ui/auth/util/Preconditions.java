package com.firebase.ui.auth.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import com.firebase.ui.auth.AuthUI;

/* loaded from: classes3.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z3, String str) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void checkConfigured(@NonNull Context context, @Nullable String str, @StringRes int... iArr) {
        for (int i4 : iArr) {
            if (context.getString(i4).equals(AuthUI.UNCONFIGURED_CONFIG_VALUE)) {
                throw new IllegalStateException(str);
            }
        }
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t3, @NonNull String str, @Nullable Object... objArr) {
        if (t3 == null) {
            if (objArr == null) {
                throw new NullPointerException(str);
            }
            throw new NullPointerException(String.format(str, objArr));
        }
        return t3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void checkUnset(@NonNull Bundle bundle, @Nullable String str, @NonNull String... strArr) {
        for (String str2 : strArr) {
            if (bundle.containsKey(str2)) {
                throw new IllegalStateException(str);
            }
        }
    }

    @StyleRes
    public static int checkValidStyle(@NonNull Context context, int i4, @NonNull String str, @Nullable Object... objArr) {
        try {
            if ("style".equals(context.getResources().getResourceTypeName(i4))) {
                return i4;
            }
            throw new IllegalArgumentException(String.format(str, objArr));
        } catch (Resources.NotFoundException unused) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
