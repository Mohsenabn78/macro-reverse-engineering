package com.arlosoft.macrodroid.beacons;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.altbeacon.beacon.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RxBeaconMonitor.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class RxBeaconMonitor {
    public static final int $stable = 8;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final State f9466a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Region f9467b;

    /* compiled from: RxBeaconMonitor.kt */
    /* loaded from: classes3.dex */
    public enum State {
        ENTER,
        EXIT
    }

    public RxBeaconMonitor(@Nullable State state, @NotNull Region region) {
        Intrinsics.checkNotNullParameter(region, "region");
        this.f9466a = state;
        this.f9467b = region;
    }

    @NotNull
    public final Region getRegion() {
        return this.f9467b;
    }

    @Nullable
    public final State getState() {
        return this.f9466a;
    }

    @NotNull
    public String toString() {
        Region region = this.f9467b;
        State state = this.f9466a;
        return "RxBeaconMonitor{region=" + region + ", state=" + state + "}";
    }
}
