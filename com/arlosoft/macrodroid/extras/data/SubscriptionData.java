package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SubscriptionData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class SubscriptionData {
    public static final int $stable = 8;
    private final int freeTrialDays;
    @Nullable
    private final StringWithLanguages label;
    @Nullable
    private final String monthlySubscriptionId;
    @Nullable
    private final String monthlySubscriptionIdNoTrial;
    @Nullable
    private final String monthlySubscriptionIdPrePaid;
    @Nullable
    private final PromotionData promotionData;
    @Nullable
    private final String weeklySubscriptionId;
    @Nullable
    private final String weeklySubscriptionIdNoTrial;
    @Nullable
    private final String weeklySubscriptionIdPrePaid;
    @Nullable
    private final String yearlySubscriptionId;
    @Nullable
    private final String yearlySubscriptionIdNoTrial;
    @Nullable
    private final String yearlySubscriptionIdPrePaid;

    public SubscriptionData(@Nullable StringWithLanguages stringWithLanguages, @Nullable PromotionData promotionData, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, int i4) {
        this.label = stringWithLanguages;
        this.promotionData = promotionData;
        this.weeklySubscriptionId = str;
        this.weeklySubscriptionIdNoTrial = str2;
        this.weeklySubscriptionIdPrePaid = str3;
        this.monthlySubscriptionId = str4;
        this.monthlySubscriptionIdNoTrial = str5;
        this.monthlySubscriptionIdPrePaid = str6;
        this.yearlySubscriptionId = str7;
        this.yearlySubscriptionIdNoTrial = str8;
        this.yearlySubscriptionIdPrePaid = str9;
        this.freeTrialDays = i4;
    }

    public static /* synthetic */ SubscriptionData copy$default(SubscriptionData subscriptionData, StringWithLanguages stringWithLanguages, PromotionData promotionData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i4, int i5, Object obj) {
        StringWithLanguages stringWithLanguages2;
        PromotionData promotionData2;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        int i6;
        if ((i5 & 1) != 0) {
            stringWithLanguages2 = subscriptionData.label;
        } else {
            stringWithLanguages2 = stringWithLanguages;
        }
        if ((i5 & 2) != 0) {
            promotionData2 = subscriptionData.promotionData;
        } else {
            promotionData2 = promotionData;
        }
        if ((i5 & 4) != 0) {
            str10 = subscriptionData.weeklySubscriptionId;
        } else {
            str10 = str;
        }
        if ((i5 & 8) != 0) {
            str11 = subscriptionData.weeklySubscriptionIdNoTrial;
        } else {
            str11 = str2;
        }
        if ((i5 & 16) != 0) {
            str12 = subscriptionData.weeklySubscriptionIdPrePaid;
        } else {
            str12 = str3;
        }
        if ((i5 & 32) != 0) {
            str13 = subscriptionData.monthlySubscriptionId;
        } else {
            str13 = str4;
        }
        if ((i5 & 64) != 0) {
            str14 = subscriptionData.monthlySubscriptionIdNoTrial;
        } else {
            str14 = str5;
        }
        if ((i5 & 128) != 0) {
            str15 = subscriptionData.monthlySubscriptionIdPrePaid;
        } else {
            str15 = str6;
        }
        if ((i5 & 256) != 0) {
            str16 = subscriptionData.yearlySubscriptionId;
        } else {
            str16 = str7;
        }
        if ((i5 & 512) != 0) {
            str17 = subscriptionData.yearlySubscriptionIdNoTrial;
        } else {
            str17 = str8;
        }
        if ((i5 & 1024) != 0) {
            str18 = subscriptionData.yearlySubscriptionIdPrePaid;
        } else {
            str18 = str9;
        }
        if ((i5 & 2048) != 0) {
            i6 = subscriptionData.freeTrialDays;
        } else {
            i6 = i4;
        }
        return subscriptionData.copy(stringWithLanguages2, promotionData2, str10, str11, str12, str13, str14, str15, str16, str17, str18, i6);
    }

    @Nullable
    public final StringWithLanguages component1() {
        return this.label;
    }

    @Nullable
    public final String component10() {
        return this.yearlySubscriptionIdNoTrial;
    }

    @Nullable
    public final String component11() {
        return this.yearlySubscriptionIdPrePaid;
    }

    public final int component12() {
        return this.freeTrialDays;
    }

    @Nullable
    public final PromotionData component2() {
        return this.promotionData;
    }

    @Nullable
    public final String component3() {
        return this.weeklySubscriptionId;
    }

    @Nullable
    public final String component4() {
        return this.weeklySubscriptionIdNoTrial;
    }

    @Nullable
    public final String component5() {
        return this.weeklySubscriptionIdPrePaid;
    }

    @Nullable
    public final String component6() {
        return this.monthlySubscriptionId;
    }

    @Nullable
    public final String component7() {
        return this.monthlySubscriptionIdNoTrial;
    }

    @Nullable
    public final String component8() {
        return this.monthlySubscriptionIdPrePaid;
    }

    @Nullable
    public final String component9() {
        return this.yearlySubscriptionId;
    }

    @NotNull
    public final SubscriptionData copy(@Nullable StringWithLanguages stringWithLanguages, @Nullable PromotionData promotionData, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, int i4) {
        return new SubscriptionData(stringWithLanguages, promotionData, str, str2, str3, str4, str5, str6, str7, str8, str9, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionData)) {
            return false;
        }
        SubscriptionData subscriptionData = (SubscriptionData) obj;
        if (Intrinsics.areEqual(this.label, subscriptionData.label) && Intrinsics.areEqual(this.promotionData, subscriptionData.promotionData) && Intrinsics.areEqual(this.weeklySubscriptionId, subscriptionData.weeklySubscriptionId) && Intrinsics.areEqual(this.weeklySubscriptionIdNoTrial, subscriptionData.weeklySubscriptionIdNoTrial) && Intrinsics.areEqual(this.weeklySubscriptionIdPrePaid, subscriptionData.weeklySubscriptionIdPrePaid) && Intrinsics.areEqual(this.monthlySubscriptionId, subscriptionData.monthlySubscriptionId) && Intrinsics.areEqual(this.monthlySubscriptionIdNoTrial, subscriptionData.monthlySubscriptionIdNoTrial) && Intrinsics.areEqual(this.monthlySubscriptionIdPrePaid, subscriptionData.monthlySubscriptionIdPrePaid) && Intrinsics.areEqual(this.yearlySubscriptionId, subscriptionData.yearlySubscriptionId) && Intrinsics.areEqual(this.yearlySubscriptionIdNoTrial, subscriptionData.yearlySubscriptionIdNoTrial) && Intrinsics.areEqual(this.yearlySubscriptionIdPrePaid, subscriptionData.yearlySubscriptionIdPrePaid) && this.freeTrialDays == subscriptionData.freeTrialDays) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> getAllSubscriptionIds() {
        List<String> listOfNotNull;
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new String[]{this.weeklySubscriptionId, this.weeklySubscriptionIdNoTrial, this.weeklySubscriptionIdPrePaid, this.monthlySubscriptionId, this.monthlySubscriptionIdNoTrial, this.monthlySubscriptionIdPrePaid, this.yearlySubscriptionId, this.yearlySubscriptionIdNoTrial, this.yearlySubscriptionIdPrePaid});
        return listOfNotNull;
    }

    public final int getFreeTrialDays() {
        return this.freeTrialDays;
    }

    @Nullable
    public final StringWithLanguages getLabel() {
        return this.label;
    }

    @Nullable
    public final String getMonthlySubscriptionId() {
        return this.monthlySubscriptionId;
    }

    @Nullable
    public final String getMonthlySubscriptionIdNoTrial() {
        return this.monthlySubscriptionIdNoTrial;
    }

    @Nullable
    public final String getMonthlySubscriptionIdPrePaid() {
        return this.monthlySubscriptionIdPrePaid;
    }

    @Nullable
    public final PromotionData getPromotionData() {
        return this.promotionData;
    }

    @Nullable
    public final String getWeeklySubscriptionId() {
        return this.weeklySubscriptionId;
    }

    @Nullable
    public final String getWeeklySubscriptionIdNoTrial() {
        return this.weeklySubscriptionIdNoTrial;
    }

    @Nullable
    public final String getWeeklySubscriptionIdPrePaid() {
        return this.weeklySubscriptionIdPrePaid;
    }

    @Nullable
    public final String getYearlySubscriptionId() {
        return this.yearlySubscriptionId;
    }

    @Nullable
    public final String getYearlySubscriptionIdNoTrial() {
        return this.yearlySubscriptionIdNoTrial;
    }

    @Nullable
    public final String getYearlySubscriptionIdPrePaid() {
        return this.yearlySubscriptionIdPrePaid;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        StringWithLanguages stringWithLanguages = this.label;
        int i4 = 0;
        if (stringWithLanguages == null) {
            hashCode = 0;
        } else {
            hashCode = stringWithLanguages.hashCode();
        }
        int i5 = hashCode * 31;
        PromotionData promotionData = this.promotionData;
        if (promotionData == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = promotionData.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str = this.weeklySubscriptionId;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        String str2 = this.weeklySubscriptionIdNoTrial;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i8 = (i7 + hashCode4) * 31;
        String str3 = this.weeklySubscriptionIdPrePaid;
        if (str3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str3.hashCode();
        }
        int i9 = (i8 + hashCode5) * 31;
        String str4 = this.monthlySubscriptionId;
        if (str4 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str4.hashCode();
        }
        int i10 = (i9 + hashCode6) * 31;
        String str5 = this.monthlySubscriptionIdNoTrial;
        if (str5 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str5.hashCode();
        }
        int i11 = (i10 + hashCode7) * 31;
        String str6 = this.monthlySubscriptionIdPrePaid;
        if (str6 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str6.hashCode();
        }
        int i12 = (i11 + hashCode8) * 31;
        String str7 = this.yearlySubscriptionId;
        if (str7 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str7.hashCode();
        }
        int i13 = (i12 + hashCode9) * 31;
        String str8 = this.yearlySubscriptionIdNoTrial;
        if (str8 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str8.hashCode();
        }
        int i14 = (i13 + hashCode10) * 31;
        String str9 = this.yearlySubscriptionIdPrePaid;
        if (str9 != null) {
            i4 = str9.hashCode();
        }
        return ((i14 + i4) * 31) + this.freeTrialDays;
    }

    @NotNull
    public String toString() {
        StringWithLanguages stringWithLanguages = this.label;
        PromotionData promotionData = this.promotionData;
        String str = this.weeklySubscriptionId;
        String str2 = this.weeklySubscriptionIdNoTrial;
        String str3 = this.weeklySubscriptionIdPrePaid;
        String str4 = this.monthlySubscriptionId;
        String str5 = this.monthlySubscriptionIdNoTrial;
        String str6 = this.monthlySubscriptionIdPrePaid;
        String str7 = this.yearlySubscriptionId;
        String str8 = this.yearlySubscriptionIdNoTrial;
        String str9 = this.yearlySubscriptionIdPrePaid;
        int i4 = this.freeTrialDays;
        return "SubscriptionData(label=" + stringWithLanguages + ", promotionData=" + promotionData + ", weeklySubscriptionId=" + str + ", weeklySubscriptionIdNoTrial=" + str2 + ", weeklySubscriptionIdPrePaid=" + str3 + ", monthlySubscriptionId=" + str4 + ", monthlySubscriptionIdNoTrial=" + str5 + ", monthlySubscriptionIdPrePaid=" + str6 + ", yearlySubscriptionId=" + str7 + ", yearlySubscriptionIdNoTrial=" + str8 + ", yearlySubscriptionIdPrePaid=" + str9 + ", freeTrialDays=" + i4 + ")";
    }

    public /* synthetic */ SubscriptionData(StringWithLanguages stringWithLanguages, PromotionData promotionData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(stringWithLanguages, (i5 & 2) != 0 ? null : promotionData, (i5 & 4) != 0 ? null : str, (i5 & 8) != 0 ? null : str2, (i5 & 16) != 0 ? null : str3, (i5 & 32) != 0 ? null : str4, (i5 & 64) != 0 ? null : str5, (i5 & 128) != 0 ? null : str6, (i5 & 256) != 0 ? null : str7, (i5 & 512) != 0 ? null : str8, (i5 & 1024) == 0 ? str9 : null, (i5 & 2048) != 0 ? 0 : i4);
    }
}
