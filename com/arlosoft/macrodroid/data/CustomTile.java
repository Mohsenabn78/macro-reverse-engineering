package com.arlosoft.macrodroid.data;

import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HomeScreenTileConfig.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class CustomTile extends HomeTile {
    public static final int $stable = 0;
    private final long tileId;

    public CustomTile(long j4) {
        super("custom");
        this.tileId = j4;
    }

    public static /* synthetic */ CustomTile copy$default(CustomTile customTile, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = customTile.getTileId();
        }
        return customTile.copy(j4);
    }

    public final long component1() {
        return getTileId();
    }

    @NotNull
    public final CustomTile copy(long j4) {
        return new CustomTile(j4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof CustomTile) && getTileId() == ((CustomTile) obj).getTileId()) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.data.HomeTile
    public long getTileId() {
        return this.tileId;
    }

    public int hashCode() {
        return a.a(getTileId());
    }

    @NotNull
    public String toString() {
        long tileId = getTileId();
        return "CustomTile(tileId=" + tileId + ")";
    }
}
