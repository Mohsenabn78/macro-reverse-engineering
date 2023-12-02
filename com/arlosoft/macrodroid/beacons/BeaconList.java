package com.arlosoft.macrodroid.beacons;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BeaconWithName.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class BeaconList {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<BeaconWithName> f9456a;

    public BeaconList() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeaconList copy$default(BeaconList beaconList, ArrayList arrayList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            arrayList = beaconList.f9456a;
        }
        return beaconList.copy(arrayList);
    }

    @NotNull
    public final ArrayList<BeaconWithName> component1() {
        return this.f9456a;
    }

    @NotNull
    public final BeaconList copy(@NotNull ArrayList<BeaconWithName> beacons) {
        Intrinsics.checkNotNullParameter(beacons, "beacons");
        return new BeaconList(beacons);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof BeaconList) && Intrinsics.areEqual(this.f9456a, ((BeaconList) obj).f9456a)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<BeaconWithName> getBeacons() {
        return this.f9456a;
    }

    public int hashCode() {
        return this.f9456a.hashCode();
    }

    @NotNull
    public String toString() {
        ArrayList<BeaconWithName> arrayList = this.f9456a;
        return "BeaconList(beacons=" + arrayList + ")";
    }

    public BeaconList(@NotNull ArrayList<BeaconWithName> beacons) {
        Intrinsics.checkNotNullParameter(beacons, "beacons");
        this.f9456a = beacons;
    }

    public /* synthetic */ BeaconList(ArrayList arrayList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? new ArrayList() : arrayList);
    }
}
