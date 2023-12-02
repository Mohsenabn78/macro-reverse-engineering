package com.google.android.ump;

import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes5.dex */
public class FormError {

    /* renamed from: a  reason: collision with root package name */
    private final int f25380a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25381b;

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface ErrorCode {
        public static final int INTERNAL_ERROR = 1;
        public static final int INTERNET_ERROR = 2;
        public static final int INVALID_OPERATION = 3;
        public static final int TIME_OUT = 4;
    }

    public FormError(int i4, @RecentlyNonNull String str) {
        this.f25380a = i4;
        this.f25381b = str;
    }

    public int getErrorCode() {
        return this.f25380a;
    }

    @RecentlyNonNull
    public String getMessage() {
        return this.f25381b;
    }
}
