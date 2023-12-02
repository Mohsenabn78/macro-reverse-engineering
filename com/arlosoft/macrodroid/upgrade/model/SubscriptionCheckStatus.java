package com.arlosoft.macrodroid.upgrade.model;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ProUserStatus.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class SubscriptionCheckStatus {
    public static final int $stable = 0;

    /* compiled from: ProUserStatus.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Expired extends SubscriptionCheckStatus {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f15985a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Expired(@NotNull String expiryTime) {
            super(null);
            Intrinsics.checkNotNullParameter(expiryTime, "expiryTime");
            this.f15985a = expiryTime;
        }

        @NotNull
        public final String getExpiryTime() {
            return this.f15985a;
        }
    }

    /* compiled from: ProUserStatus.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class SubscriptionValid extends SubscriptionCheckStatus {
        public static final int $stable = 0;
        @NotNull
        public static final SubscriptionValid INSTANCE = new SubscriptionValid();

        private SubscriptionValid() {
            super(null);
        }
    }

    /* compiled from: ProUserStatus.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Unavailable extends SubscriptionCheckStatus {
        public static final int $stable = 0;
        @NotNull
        public static final Unavailable INSTANCE = new Unavailable();

        private Unavailable() {
            super(null);
        }
    }

    /* compiled from: ProUserStatus.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ValidationFailed extends SubscriptionCheckStatus {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f15986a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValidationFailed(@NotNull String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f15986a = message;
        }

        @NotNull
        public final String getMessage() {
            return this.f15986a;
        }
    }

    private SubscriptionCheckStatus() {
    }

    public /* synthetic */ SubscriptionCheckStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
