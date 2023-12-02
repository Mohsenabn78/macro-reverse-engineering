package com.arlosoft.macrodroid.beacons;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Region;
import org.jetbrains.annotations.NotNull;

/* compiled from: RxBeaconRange.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class RxBeaconRange {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Collection<Beacon> f9469a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Region f9470b;

    /* JADX WARN: Multi-variable type inference failed */
    public RxBeaconRange(@NotNull Collection<? extends Beacon> beacons, @NotNull Region region) {
        Intrinsics.checkNotNullParameter(beacons, "beacons");
        Intrinsics.checkNotNullParameter(region, "region");
        this.f9469a = beacons;
        this.f9470b = region;
    }

    @NotNull
    public final Collection<Beacon> getBeacons() {
        return this.f9469a;
    }

    @NotNull
    public String toString() {
        Collection<Beacon> collection = this.f9469a;
        Region region = this.f9470b;
        return "RxBeaconRange{beacons=" + collection + ", region=" + region + "}";
    }
}
