package com.arlosoft.macrodroid.data;

import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HomeScreenTileConfig.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class BasicTile extends HomeTile {
    public static final int $stable = 0;
    private final long tileId;

    public BasicTile() {
        this(0L, 1, null);
    }

    public static /* synthetic */ BasicTile copy$default(BasicTile basicTile, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = basicTile.getTileId();
        }
        return basicTile.copy(j4);
    }

    public final long component1() {
        return getTileId();
    }

    @NotNull
    public final BasicTile copy(long j4) {
        return new BasicTile(j4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof BasicTile) && getTileId() == ((BasicTile) obj).getTileId()) {
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
        return "BasicTile(tileId=" + tileId + ")";
    }

    public BasicTile(long j4) {
        super(HomeTile.TILE_TYPE_BASIC);
        this.tileId = j4;
    }

    public /* synthetic */ BasicTile(long j4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j4);
    }
}
