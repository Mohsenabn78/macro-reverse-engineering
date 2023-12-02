package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
@zzi
@Deprecated
/* loaded from: classes2.dex */
public class PriceChangeFlowParams {
    private SkuDetails skuDetails;

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @zzi
    @Deprecated
    /* loaded from: classes2.dex */
    public static class Builder {
        private SkuDetails skuDetails;

        @NonNull
        public PriceChangeFlowParams build() {
            SkuDetails skuDetails = this.skuDetails;
            if (skuDetails != null) {
                PriceChangeFlowParams priceChangeFlowParams = new PriceChangeFlowParams();
                priceChangeFlowParams.skuDetails = skuDetails;
                return priceChangeFlowParams;
            }
            throw new IllegalArgumentException("SkuDetails must be set");
        }

        @NonNull
        public Builder setSkuDetails(@NonNull SkuDetails skuDetails) {
            this.skuDetails = skuDetails;
            return this;
        }

        private Builder setSkuDetails(String str) {
            try {
                this.skuDetails = new SkuDetails(str);
                return this;
            } catch (JSONException e4) {
                throw new IllegalArgumentException("Incorrect skuDetails JSON object!", e4);
            }
        }
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @NonNull
    public SkuDetails getSkuDetails() {
        return this.skuDetails;
    }
}
