package com.arlosoft.macrodroid.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: HomeScreenTileConfig.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public abstract class HomeTile {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TILE_TYPE_BASIC = "basic";
    @NotNull
    public static final String TILE_TYPE_CUSTOM = "custom";
    @NotNull
    private final String tileType;

    /* compiled from: HomeScreenTileConfig.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HomeTile(@NotNull String tileType) {
        Intrinsics.checkNotNullParameter(tileType, "tileType");
        this.tileType = tileType;
    }

    public abstract long getTileId();
}
