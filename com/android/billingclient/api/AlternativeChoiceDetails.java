package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
@zzd
/* loaded from: classes2.dex */
public final class AlternativeChoiceDetails {
    private final String zza;
    private final JSONObject zzb;
    private final List zzc;

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @zzd
    /* loaded from: classes2.dex */
    public static class Product {
        private final String zza;
        private final String zzb;
        @Nullable
        private final String zzc;

        /* synthetic */ Product(JSONObject jSONObject, zzc zzcVar) {
            this.zza = jSONObject.optString("productId");
            this.zzb = jSONObject.optString("productType");
            String optString = jSONObject.optString("offerToken");
            this.zzc = true == optString.isEmpty() ? null : optString;
        }

        public final boolean equals(@Nullable Object obj) {
            String str;
            String offerToken;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Product)) {
                return false;
            }
            Product product = (Product) obj;
            if (this.zza.equals(product.getId()) && this.zzb.equals(product.getType()) && ((str = this.zzc) == (offerToken = product.getOfferToken()) || (str != null && str.equals(offerToken)))) {
                return true;
            }
            return false;
        }

        @NonNull
        @zzd
        public String getId() {
            return this.zza;
        }

        @Nullable
        @zzd
        public String getOfferToken() {
            return this.zzc;
        }

        @NonNull
        @zzd
        public String getType() {
            return this.zzb;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
        }

        @NonNull
        public final String toString() {
            return String.format("{id: %s, type: %s, offer token: %s}", this.zza, this.zzb, this.zzc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlternativeChoiceDetails(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("products");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    arrayList.add(new Product(optJSONObject, null));
                }
            }
        }
        this.zzc = arrayList;
    }

    @NonNull
    @zzd
    public String getExternalTransactionToken() {
        return this.zzb.optString("externalTransactionToken");
    }

    @Nullable
    @zzd
    public String getOriginalExternalTransactionId() {
        String optString = this.zzb.optString("originalExternalTransactionId");
        if (optString.isEmpty()) {
            return null;
        }
        return optString;
    }

    @NonNull
    @zzd
    public List<Product> getProducts() {
        return this.zzc;
    }
}
