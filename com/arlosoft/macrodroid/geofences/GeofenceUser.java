package com.arlosoft.macrodroid.geofences;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GeofenceManager.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class GeofenceUser {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final long f12215a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12216b;

    public GeofenceUser(long j4, int i4) {
        this.f12215a = j4;
        this.f12216b = i4;
    }

    public static /* synthetic */ GeofenceUser copy$default(GeofenceUser geofenceUser, long j4, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j4 = geofenceUser.f12215a;
        }
        if ((i5 & 2) != 0) {
            i4 = geofenceUser.f12216b;
        }
        return geofenceUser.copy(j4, i4);
    }

    public final long component1() {
        return this.f12215a;
    }

    public final int component2() {
        return this.f12216b;
    }

    @NotNull
    public final GeofenceUser copy(long j4, int i4) {
        return new GeofenceUser(j4, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeofenceUser)) {
            return false;
        }
        GeofenceUser geofenceUser = (GeofenceUser) obj;
        if (this.f12215a == geofenceUser.f12215a && this.f12216b == geofenceUser.f12216b) {
            return true;
        }
        return false;
    }

    public final long getSelectableItemId() {
        return this.f12215a;
    }

    public final int getUpdateRateMs() {
        return this.f12216b;
    }

    public int hashCode() {
        return (androidx.compose.animation.a.a(this.f12215a) * 31) + this.f12216b;
    }

    @NotNull
    public String toString() {
        long j4 = this.f12215a;
        int i4 = this.f12216b;
        return "GeofenceUser(selectableItemId=" + j4 + ", updateRateMs=" + i4 + ")";
    }
}
