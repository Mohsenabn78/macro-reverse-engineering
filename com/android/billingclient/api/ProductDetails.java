package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
@zzj
/* loaded from: classes2.dex */
public final class ProductDetails {
    private final String zza;
    private final JSONObject zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    @Nullable
    private final String zzk;
    @Nullable
    private final List zzl;
    @Nullable
    private final List zzm;
    @Nullable
    private final zzbj zzn;

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @zzg
    /* loaded from: classes2.dex */
    public static final class OneTimePurchaseOfferDetails {
        private final String zza;
        private final long zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final com.google.android.gms.internal.play_billing.zzu zzf;

        OneTimePurchaseOfferDetails(JSONObject jSONObject) throws JSONException {
            this.zza = jSONObject.optString("formattedPrice");
            this.zzb = jSONObject.optLong("priceAmountMicros");
            this.zzc = jSONObject.optString("priceCurrencyCode");
            this.zzd = jSONObject.optString("offerIdToken");
            this.zze = jSONObject.optString("offerId");
            jSONObject.optInt("offerType");
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    arrayList.add(optJSONArray.getString(i4));
                }
            }
            this.zzf = com.google.android.gms.internal.play_billing.zzu.zzj(arrayList);
        }

        @NonNull
        @zzg
        public String getFormattedPrice() {
            return this.zza;
        }

        @zzg
        public long getPriceAmountMicros() {
            return this.zzb;
        }

        @NonNull
        @zzg
        public String getPriceCurrencyCode() {
            return this.zzc;
        }

        @NonNull
        public final String zza() {
            return this.zzd;
        }
    }

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @zzj
    /* loaded from: classes2.dex */
    public static final class PricingPhase {
        private final int billingCycleCount;
        private final String billingPeriod;
        private final String formattedPrice;
        private final long priceAmountMicros;
        private final String priceCurrencyCode;
        private final int recurrenceMode;

        PricingPhase(JSONObject jSONObject) {
            this.billingPeriod = jSONObject.optString("billingPeriod");
            this.priceCurrencyCode = jSONObject.optString("priceCurrencyCode");
            this.formattedPrice = jSONObject.optString("formattedPrice");
            this.priceAmountMicros = jSONObject.optLong("priceAmountMicros");
            this.recurrenceMode = jSONObject.optInt("recurrenceMode");
            this.billingCycleCount = jSONObject.optInt("billingCycleCount");
        }

        public int getBillingCycleCount() {
            return this.billingCycleCount;
        }

        @NonNull
        public String getBillingPeriod() {
            return this.billingPeriod;
        }

        @NonNull
        public String getFormattedPrice() {
            return this.formattedPrice;
        }

        public long getPriceAmountMicros() {
            return this.priceAmountMicros;
        }

        @NonNull
        public String getPriceCurrencyCode() {
            return this.priceCurrencyCode;
        }

        public int getRecurrenceMode() {
            return this.recurrenceMode;
        }
    }

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @zzj
    /* loaded from: classes2.dex */
    public static class PricingPhases {
        private final List<PricingPhase> pricingPhaseList;

        PricingPhases(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        arrayList.add(new PricingPhase(optJSONObject));
                    }
                }
            }
            this.pricingPhaseList = arrayList;
        }

        @NonNull
        public List<PricingPhase> getPricingPhaseList() {
            return this.pricingPhaseList;
        }
    }

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @zzj
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface RecurrenceMode {
        @zzj
        public static final int FINITE_RECURRING = 2;
        @zzj
        public static final int INFINITE_RECURRING = 1;
        @zzj
        public static final int NON_RECURRING = 3;
    }

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @zzj
    /* loaded from: classes2.dex */
    public static final class SubscriptionOfferDetails {
        private final String zza;
        @Nullable
        private final String zzb;
        private final String zzc;
        private final PricingPhases zzd;
        private final List zze;
        @Nullable
        private final zzbi zzf;

        SubscriptionOfferDetails(JSONObject jSONObject) throws JSONException {
            this.zza = jSONObject.optString("basePlanId");
            String optString = jSONObject.optString("offerId");
            this.zzb = true == optString.isEmpty() ? null : optString;
            this.zzc = jSONObject.getString("offerIdToken");
            this.zzd = new PricingPhases(jSONObject.getJSONArray("pricingPhases"));
            JSONObject optJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.zzf = optJSONObject != null ? new zzbi(optJSONObject) : null;
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    arrayList.add(optJSONArray.getString(i4));
                }
            }
            this.zze = arrayList;
        }

        @NonNull
        @zze
        public String getBasePlanId() {
            return this.zza;
        }

        @Nullable
        @zze
        public String getOfferId() {
            return this.zzb;
        }

        @NonNull
        public List<String> getOfferTags() {
            return this.zze;
        }

        @NonNull
        public String getOfferToken() {
            return this.zzc;
        }

        @NonNull
        public PricingPhases getPricingPhases() {
            return this.zzd;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProductDetails(String str) throws JSONException {
        ArrayList arrayList;
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        String optString = jSONObject.optString("productId");
        this.zzc = optString;
        String optString2 = jSONObject.optString("type");
        this.zzd = optString2;
        if (!TextUtils.isEmpty(optString)) {
            if (!TextUtils.isEmpty(optString2)) {
                this.zze = jSONObject.optString("title");
                this.zzf = jSONObject.optString("name");
                this.zzg = jSONObject.optString("description");
                this.zzi = jSONObject.optString("packageDisplayName");
                this.zzj = jSONObject.optString("iconUrl");
                this.zzh = jSONObject.optString("skuDetailsToken");
                this.zzk = jSONObject.optString("serializedDocid");
                JSONArray optJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        arrayList2.add(new SubscriptionOfferDetails(optJSONArray.getJSONObject(i4)));
                    }
                    this.zzl = arrayList2;
                } else {
                    if (!optString2.equals("subs") && !optString2.equals("play_pass_subs")) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                    }
                    this.zzl = arrayList;
                }
                JSONObject optJSONObject = this.zzb.optJSONObject("oneTimePurchaseOfferDetails");
                JSONArray optJSONArray2 = this.zzb.optJSONArray("oneTimePurchaseOfferDetailsList");
                ArrayList arrayList3 = new ArrayList();
                if (optJSONArray2 != null) {
                    for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                        arrayList3.add(new OneTimePurchaseOfferDetails(optJSONArray2.getJSONObject(i5)));
                    }
                    this.zzm = arrayList3;
                } else if (optJSONObject != null) {
                    arrayList3.add(new OneTimePurchaseOfferDetails(optJSONObject));
                    this.zzm = arrayList3;
                } else {
                    this.zzm = null;
                }
                JSONObject optJSONObject2 = this.zzb.optJSONObject("limitedQuantityInfo");
                if (optJSONObject2 != null) {
                    this.zzn = new zzbj(optJSONObject2);
                    return;
                } else {
                    this.zzn = null;
                    return;
                }
            }
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        throw new IllegalArgumentException("Product id cannot be empty.");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetails)) {
            return false;
        }
        return TextUtils.equals(this.zza, ((ProductDetails) obj).zza);
    }

    @NonNull
    @zzj
    public String getDescription() {
        return this.zzg;
    }

    @NonNull
    @zzj
    public String getName() {
        return this.zzf;
    }

    @Nullable
    @zzg
    public OneTimePurchaseOfferDetails getOneTimePurchaseOfferDetails() {
        List list = this.zzm;
        if (list != null && !list.isEmpty()) {
            return (OneTimePurchaseOfferDetails) this.zzm.get(0);
        }
        return null;
    }

    @NonNull
    @zzj
    public String getProductId() {
        return this.zzc;
    }

    @NonNull
    @zzj
    public String getProductType() {
        return this.zzd;
    }

    @Nullable
    @zzj
    public List<SubscriptionOfferDetails> getSubscriptionOfferDetails() {
        return this.zzl;
    }

    @NonNull
    @zzj
    public String getTitle() {
        return this.zze;
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @NonNull
    public String toString() {
        String str = this.zza;
        String obj = this.zzb.toString();
        String str2 = this.zzc;
        String str3 = this.zzd;
        String str4 = this.zze;
        String str5 = this.zzh;
        String valueOf = String.valueOf(this.zzl);
        return "ProductDetails{jsonString='" + str + "', parsedJson=" + obj + ", productId='" + str2 + "', productType='" + str3 + "', title='" + str4 + "', productDetailsToken='" + str5 + "', subscriptionOfferDetails=" + valueOf + "}";
    }

    @NonNull
    public final String zza() {
        return this.zzb.optString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzh;
    }

    @Nullable
    public String zzc() {
        return this.zzk;
    }
}
