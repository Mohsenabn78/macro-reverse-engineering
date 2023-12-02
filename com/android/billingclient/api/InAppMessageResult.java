package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
@zzf
/* loaded from: classes2.dex */
public final class InAppMessageResult {
    @Nullable
    private final String mPurchaseToken;
    private final int mResponseCode;

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface InAppMessageResponseCode {
        @zzf
        public static final int NO_ACTION_NEEDED = 0;
        @zzf
        public static final int SUBSCRIPTION_STATUS_UPDATED = 1;
    }

    public InAppMessageResult(int i4, @Nullable String str) {
        this.mResponseCode = i4;
        this.mPurchaseToken = str;
    }

    @Nullable
    public String getPurchaseToken() {
        return this.mPurchaseToken;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
