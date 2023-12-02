package com.arlosoft.macrodroid.triggers;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.altbeacon.beacon.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BluetoothBeaconTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class RegionWithCount {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Region f14407a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14408b;

    public RegionWithCount(@NotNull Region region, int i4) {
        Intrinsics.checkNotNullParameter(region, "region");
        this.f14407a = region;
        this.f14408b = i4;
    }

    public static /* synthetic */ RegionWithCount copy$default(RegionWithCount regionWithCount, Region region, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            region = regionWithCount.f14407a;
        }
        if ((i5 & 2) != 0) {
            i4 = regionWithCount.f14408b;
        }
        return regionWithCount.copy(region, i4);
    }

    @NotNull
    public final Region component1() {
        return this.f14407a;
    }

    public final int component2() {
        return this.f14408b;
    }

    @NotNull
    public final RegionWithCount copy(@NotNull Region region, int i4) {
        Intrinsics.checkNotNullParameter(region, "region");
        return new RegionWithCount(region, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegionWithCount)) {
            return false;
        }
        RegionWithCount regionWithCount = (RegionWithCount) obj;
        if (Intrinsics.areEqual(this.f14407a, regionWithCount.f14407a) && this.f14408b == regionWithCount.f14408b) {
            return true;
        }
        return false;
    }

    public final int getCount() {
        return this.f14408b;
    }

    @NotNull
    public final Region getRegion() {
        return this.f14407a;
    }

    public int hashCode() {
        return (this.f14407a.hashCode() * 31) + this.f14408b;
    }

    @NotNull
    public String toString() {
        Region region = this.f14407a;
        int i4 = this.f14408b;
        return "RegionWithCount(region=" + region + ", count=" + i4 + ")";
    }
}
