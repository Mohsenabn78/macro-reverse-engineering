package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PromotionData.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PromotionData {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final StringWithLanguages f12011a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12012b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f12013c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f12014d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f12015e;

    public PromotionData(@NotNull StringWithLanguages promotionText, int i4, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(promotionText, "promotionText");
        this.f12011a = promotionText;
        this.f12012b = i4;
        this.f12013c = str;
        this.f12014d = str2;
        this.f12015e = str3;
    }

    public static /* synthetic */ PromotionData copy$default(PromotionData promotionData, StringWithLanguages stringWithLanguages, int i4, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            stringWithLanguages = promotionData.f12011a;
        }
        if ((i5 & 2) != 0) {
            i4 = promotionData.f12012b;
        }
        int i6 = i4;
        if ((i5 & 4) != 0) {
            str = promotionData.f12013c;
        }
        String str4 = str;
        if ((i5 & 8) != 0) {
            str2 = promotionData.f12014d;
        }
        String str5 = str2;
        if ((i5 & 16) != 0) {
            str3 = promotionData.f12015e;
        }
        return promotionData.copy(stringWithLanguages, i6, str4, str5, str3);
    }

    @NotNull
    public final StringWithLanguages component1() {
        return this.f12011a;
    }

    public final int component2() {
        return this.f12012b;
    }

    @Nullable
    public final String component3() {
        return this.f12013c;
    }

    @Nullable
    public final String component4() {
        return this.f12014d;
    }

    @Nullable
    public final String component5() {
        return this.f12015e;
    }

    @NotNull
    public final PromotionData copy(@NotNull StringWithLanguages promotionText, int i4, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(promotionText, "promotionText");
        return new PromotionData(promotionText, i4, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromotionData)) {
            return false;
        }
        PromotionData promotionData = (PromotionData) obj;
        if (Intrinsics.areEqual(this.f12011a, promotionData.f12011a) && this.f12012b == promotionData.f12012b && Intrinsics.areEqual(this.f12013c, promotionData.f12013c) && Intrinsics.areEqual(this.f12014d, promotionData.f12014d) && Intrinsics.areEqual(this.f12015e, promotionData.f12015e)) {
            return true;
        }
        return false;
    }

    public final int getOfferPercent() {
        return this.f12012b;
    }

    @Nullable
    public final String getOriginalPriceMonthly() {
        return this.f12014d;
    }

    @Nullable
    public final String getOriginalPriceWeekly() {
        return this.f12013c;
    }

    @Nullable
    public final String getOriginalPriceYearly() {
        return this.f12015e;
    }

    @NotNull
    public final StringWithLanguages getPromotionText() {
        return this.f12011a;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((this.f12011a.hashCode() * 31) + this.f12012b) * 31;
        String str = this.f12013c;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode3 + hashCode) * 31;
        String str2 = this.f12014d;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str3 = this.f12015e;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return i6 + i4;
    }

    @NotNull
    public String toString() {
        StringWithLanguages stringWithLanguages = this.f12011a;
        int i4 = this.f12012b;
        String str = this.f12013c;
        String str2 = this.f12014d;
        String str3 = this.f12015e;
        return "PromotionData(promotionText=" + stringWithLanguages + ", offerPercent=" + i4 + ", originalPriceWeekly=" + str + ", originalPriceMonthly=" + str2 + ", originalPriceYearly=" + str3 + ")";
    }
}
