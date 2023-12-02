package com.arlosoft.macrodroid.upgrade.billing;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SubscriptionPrice.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public abstract class SubscriptionPrice {
    public static final int $stable = 0;
    private final boolean isProOnlyOffer;

    /* compiled from: SubscriptionPrice.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    /* loaded from: classes3.dex */
    public static final class DiscountedPrice extends SubscriptionPrice {
        public static final int $stable = 0;
        private final int discountPercent;
        @NotNull
        private final String discountPrice;
        @NotNull
        private final String price;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DiscountedPrice(@NotNull String price, @NotNull String discountPrice, int i4, boolean z3) {
            super(z3, null);
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(discountPrice, "discountPrice");
            this.price = price;
            this.discountPrice = discountPrice;
            this.discountPercent = i4;
        }

        public final int getDiscountPercent() {
            return this.discountPercent;
        }

        @NotNull
        public final String getDiscountPrice() {
            return this.discountPrice;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        public /* synthetic */ DiscountedPrice(String str, String str2, int i4, boolean z3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i4, (i5 & 8) != 0 ? false : z3);
        }
    }

    /* compiled from: SubscriptionPrice.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    /* loaded from: classes3.dex */
    public static final class FreeTrialStandardPrice extends SubscriptionPrice {
        public static final int $stable = 0;
        private final int freeDays;
        private final int freeMonths;
        @NotNull
        private final String price;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FreeTrialStandardPrice(@NotNull String price, int i4, int i5, boolean z3) {
            super(z3, null);
            Intrinsics.checkNotNullParameter(price, "price");
            this.price = price;
            this.freeDays = i4;
            this.freeMonths = i5;
        }

        public final int getFreeDays() {
            return this.freeDays;
        }

        public final int getFreeMonths() {
            return this.freeMonths;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        public /* synthetic */ FreeTrialStandardPrice(String str, int i4, int i5, boolean z3, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i4, i5, (i6 & 8) != 0 ? false : z3);
        }
    }

    /* compiled from: SubscriptionPrice.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    /* loaded from: classes3.dex */
    public static final class FreeTrialWithDiscount extends SubscriptionPrice {
        public static final int $stable = 0;
        private final int discountPercent;
        @NotNull
        private final String discountPrice;
        private final int freeDays;
        private final int freeMonths;
        @NotNull
        private final String price;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FreeTrialWithDiscount(@NotNull String price, @NotNull String discountPrice, int i4, int i5, int i6, boolean z3) {
            super(z3, null);
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(discountPrice, "discountPrice");
            this.price = price;
            this.discountPrice = discountPrice;
            this.discountPercent = i4;
            this.freeDays = i5;
            this.freeMonths = i6;
        }

        public final int getDiscountPercent() {
            return this.discountPercent;
        }

        @NotNull
        public final String getDiscountPrice() {
            return this.discountPrice;
        }

        public final int getFreeDays() {
            return this.freeDays;
        }

        public final int getFreeMonths() {
            return this.freeMonths;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        public /* synthetic */ FreeTrialWithDiscount(String str, String str2, int i4, int i5, int i6, boolean z3, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i4, i5, i6, (i7 & 32) != 0 ? false : z3);
        }
    }

    /* compiled from: SubscriptionPrice.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    /* loaded from: classes3.dex */
    public static final class StandardPrice extends SubscriptionPrice {
        public static final int $stable = 0;
        @NotNull
        private final String price;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StandardPrice(@NotNull String price, boolean z3) {
            super(z3, null);
            Intrinsics.checkNotNullParameter(price, "price");
            this.price = price;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        public /* synthetic */ StandardPrice(String str, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i4 & 2) != 0 ? false : z3);
        }
    }

    public /* synthetic */ SubscriptionPrice(boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z3);
    }

    public final boolean isProOnlyOffer() {
        return this.isProOnlyOffer;
    }

    private SubscriptionPrice(boolean z3) {
        this.isProOnlyOffer = z3;
    }

    public /* synthetic */ SubscriptionPrice(boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z3, null);
    }
}
