package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzbzr;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class RequestConfiguration {
    @NonNull
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    @NonNull
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;

    /* renamed from: a  reason: collision with root package name */
    private final int f18978a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18979b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f18980c;

    /* renamed from: d  reason: collision with root package name */
    private final List f18981d;
    @NonNull
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    @NonNull
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    @NonNull
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    @NonNull
    public static final List zza = Arrays.asList(MAX_AD_CONTENT_RATING_MA, "T", MAX_AD_CONTENT_RATING_PG, MAX_AD_CONTENT_RATING_G);

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f18982a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f18983b = -1;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f18984c = null;

        /* renamed from: d  reason: collision with root package name */
        private final List f18985d = new ArrayList();

        @NonNull
        public RequestConfiguration build() {
            return new RequestConfiguration(this.f18982a, this.f18983b, this.f18984c, this.f18985d, null);
        }

        @NonNull
        public Builder setMaxAdContentRating(@Nullable String str) {
            if (str != null && !"".equals(str)) {
                if (!RequestConfiguration.MAX_AD_CONTENT_RATING_G.equals(str) && !RequestConfiguration.MAX_AD_CONTENT_RATING_PG.equals(str) && !"T".equals(str) && !RequestConfiguration.MAX_AD_CONTENT_RATING_MA.equals(str)) {
                    zzbzr.zzj("Invalid value passed to setMaxAdContentRating: ".concat(str));
                } else {
                    this.f18984c = str;
                }
            } else {
                this.f18984c = null;
            }
            return this;
        }

        @NonNull
        public Builder setTagForChildDirectedTreatment(int i4) {
            if (i4 != -1 && i4 != 0 && i4 != 1) {
                zzbzr.zzj("Invalid value passed to setTagForChildDirectedTreatment: " + i4);
            } else {
                this.f18982a = i4;
            }
            return this;
        }

        @NonNull
        public Builder setTagForUnderAgeOfConsent(int i4) {
            if (i4 != -1 && i4 != 0 && i4 != 1) {
                zzbzr.zzj("Invalid value passed to setTagForUnderAgeOfConsent: " + i4);
            } else {
                this.f18983b = i4;
            }
            return this;
        }

        @NonNull
        public Builder setTestDeviceIds(@Nullable List<String> list) {
            this.f18985d.clear();
            if (list != null) {
                this.f18985d.addAll(list);
            }
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface MaxAdContentRating {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface TagForChildDirectedTreatment {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface TagForUnderAgeOfConsent {
    }

    /* synthetic */ RequestConfiguration(int i4, int i5, String str, List list, zzh zzhVar) {
        this.f18978a = i4;
        this.f18979b = i5;
        this.f18980c = str;
        this.f18981d = list;
    }

    @NonNull
    public String getMaxAdContentRating() {
        String str = this.f18980c;
        if (str == null) {
            return "";
        }
        return str;
    }

    public int getTagForChildDirectedTreatment() {
        return this.f18978a;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.f18979b;
    }

    @NonNull
    public List<String> getTestDeviceIds() {
        return new ArrayList(this.f18981d);
    }

    @NonNull
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setTagForChildDirectedTreatment(this.f18978a);
        builder.setTagForUnderAgeOfConsent(this.f18979b);
        builder.setMaxAdContentRating(this.f18980c);
        builder.setTestDeviceIds(this.f18981d);
        return builder;
    }
}
