package com.arlosoft.macrodroid.data;

import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HomeScreenTileConfig.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class HomeScreenTileConfig {
    @NotNull
    public static final String HOME_SCREEN_TILES_CACHE = "HomeScreenTiles";
    @NotNull
    public static final String HOME_SCREEN_TILES_KEY = "HomeScreenTiles";
    @NotNull
    private final List<HomeTile> tiles;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HomeScreenTileConfig.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HomeScreenTileConfig getDefaultConfig() {
            long j4;
            List listOf;
            BasicTile[] basicTileArr = new BasicTile[21];
            basicTileArr[0] = new BasicTile(2L);
            basicTileArr[1] = new BasicTile(18L);
            basicTileArr[2] = new BasicTile(5L);
            basicTileArr[3] = new BasicTile(23L);
            basicTileArr[4] = new BasicTile(6L);
            basicTileArr[5] = new BasicTile(7L);
            basicTileArr[6] = new BasicTile(8L);
            basicTileArr[7] = new BasicTile(9L);
            basicTileArr[8] = new BasicTile(10L);
            basicTileArr[9] = new BasicTile(11L);
            basicTileArr[10] = new BasicTile(24L);
            basicTileArr[11] = new BasicTile(20L);
            basicTileArr[12] = new BasicTile(21L);
            basicTileArr[13] = new BasicTile(25L);
            basicTileArr[14] = new BasicTile(22L);
            basicTileArr[15] = new BasicTile(12L);
            basicTileArr[16] = new BasicTile(13L);
            basicTileArr[17] = new BasicTile(14L);
            if (Build.VERSION.SDK_INT >= 24) {
                j4 = 15;
            } else {
                j4 = 19;
            }
            basicTileArr[18] = new BasicTile(j4);
            basicTileArr[19] = new BasicTile(16L);
            basicTileArr[20] = new BasicTile(17L);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) basicTileArr);
            return new HomeScreenTileConfig(listOf);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HomeScreenTileConfig(@NotNull List<? extends HomeTile> tiles) {
        Intrinsics.checkNotNullParameter(tiles, "tiles");
        this.tiles = tiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeScreenTileConfig copy$default(HomeScreenTileConfig homeScreenTileConfig, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = homeScreenTileConfig.tiles;
        }
        return homeScreenTileConfig.copy(list);
    }

    @NotNull
    public final List<HomeTile> component1() {
        return this.tiles;
    }

    @NotNull
    public final HomeScreenTileConfig copy(@NotNull List<? extends HomeTile> tiles) {
        Intrinsics.checkNotNullParameter(tiles, "tiles");
        return new HomeScreenTileConfig(tiles);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof HomeScreenTileConfig) && Intrinsics.areEqual(this.tiles, ((HomeScreenTileConfig) obj).tiles)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<HomeTile> getTiles() {
        return this.tiles;
    }

    public int hashCode() {
        return this.tiles.hashCode();
    }

    @NotNull
    public String toString() {
        List<HomeTile> list = this.tiles;
        return "HomeScreenTileConfig(tiles=" + list + ")";
    }
}
