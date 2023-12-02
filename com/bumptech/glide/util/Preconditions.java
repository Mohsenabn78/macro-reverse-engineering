package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z3, @NonNull String str) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    @NonNull
    public static String checkNotEmpty(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t3) {
        return (T) checkNotNull(t3, "Argument must not be null");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t3, @NonNull String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T checkNotEmpty(@NonNull T t3) {
        if (t3.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t3;
    }
}
