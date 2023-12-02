package com.arlosoft.macrodroid.confirmation;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: PremiumStatus.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class PremiumStatus {
    public static final int $stable = 0;

    /* compiled from: PremiumStatus.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ActiveSubscription extends PremiumStatus {
        public static final int $stable = 0;
        @NotNull
        public static final ActiveSubscription INSTANCE = new ActiveSubscription();

        private ActiveSubscription() {
            super(null);
        }
    }

    /* compiled from: PremiumStatus.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Free extends PremiumStatus {
        public static final int $stable = 0;
        @NotNull
        public static final Free INSTANCE = new Free();

        private Free() {
            super(null);
        }
    }

    /* compiled from: PremiumStatus.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Pro extends PremiumStatus {
        public static final int $stable = 0;
        @NotNull
        public static final Pro INSTANCE = new Pro();

        private Pro() {
            super(null);
        }
    }

    private PremiumStatus() {
    }

    public /* synthetic */ PremiumStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean hasActiveSubscription() {
        return this instanceof ActiveSubscription;
    }

    public final boolean isPro() {
        return this instanceof Pro;
    }
}
