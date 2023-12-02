package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtrasViewState.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class ExtrasViewState {
    public static final int $stable = 0;

    /* compiled from: ExtrasViewState.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Error extends ExtrasViewState {
        public static final int $stable = 0;
        @NotNull
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }

    /* compiled from: ExtrasViewState.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Loaded extends ExtrasViewState {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ExtraPackageWithPriceAndState f12010a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loaded(@NotNull ExtraPackageWithPriceAndState extra) {
            super(null);
            Intrinsics.checkNotNullParameter(extra, "extra");
            this.f12010a = extra;
        }

        public static /* synthetic */ Loaded copy$default(Loaded loaded, ExtraPackageWithPriceAndState extraPackageWithPriceAndState, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                extraPackageWithPriceAndState = loaded.f12010a;
            }
            return loaded.copy(extraPackageWithPriceAndState);
        }

        @NotNull
        public final ExtraPackageWithPriceAndState component1() {
            return this.f12010a;
        }

        @NotNull
        public final Loaded copy(@NotNull ExtraPackageWithPriceAndState extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            return new Loaded(extra);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Loaded) && Intrinsics.areEqual(this.f12010a, ((Loaded) obj).f12010a)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final ExtraPackageWithPriceAndState getExtra() {
            return this.f12010a;
        }

        public int hashCode() {
            return this.f12010a.hashCode();
        }

        @NotNull
        public String toString() {
            ExtraPackageWithPriceAndState extraPackageWithPriceAndState = this.f12010a;
            return "Loaded(extra=" + extraPackageWithPriceAndState + ")";
        }
    }

    /* compiled from: ExtrasViewState.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Loading extends ExtrasViewState {
        public static final int $stable = 0;
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private ExtrasViewState() {
    }

    public /* synthetic */ ExtrasViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
