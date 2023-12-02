package com.arlosoft.macrodroid.nearby;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearbyHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class NearbyDevice {
    public static final int $stable = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f12990a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f12991b;

    public NearbyDevice(@NotNull String endPointId, @NotNull String deviceName) {
        Intrinsics.checkNotNullParameter(endPointId, "endPointId");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.f12990a = endPointId;
        this.f12991b = deviceName;
    }

    public static /* synthetic */ NearbyDevice copy$default(NearbyDevice nearbyDevice, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = nearbyDevice.f12990a;
        }
        if ((i4 & 2) != 0) {
            str2 = nearbyDevice.f12991b;
        }
        return nearbyDevice.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f12990a;
    }

    @NotNull
    public final String component2() {
        return this.f12991b;
    }

    @NotNull
    public final NearbyDevice copy(@NotNull String endPointId, @NotNull String deviceName) {
        Intrinsics.checkNotNullParameter(endPointId, "endPointId");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        return new NearbyDevice(endPointId, deviceName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyDevice)) {
            return false;
        }
        NearbyDevice nearbyDevice = (NearbyDevice) obj;
        if (Intrinsics.areEqual(this.f12990a, nearbyDevice.f12990a) && Intrinsics.areEqual(this.f12991b, nearbyDevice.f12991b)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDeviceName() {
        return this.f12991b;
    }

    @NotNull
    public final String getEndPointId() {
        return this.f12990a;
    }

    public int hashCode() {
        return (this.f12990a.hashCode() * 31) + this.f12991b.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f12990a;
        String str2 = this.f12991b;
        return "NearbyDevice(endPointId=" + str + ", deviceName=" + str2 + ")";
    }
}
