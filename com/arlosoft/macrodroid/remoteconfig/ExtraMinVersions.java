package com.arlosoft.macrodroid.remoteconfig;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraMinVersions.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class ExtraMinVersions {
    public static final int $stable = 8;
    @NotNull
    private final Map<String, ExtraMinVersion> minVersions;

    public ExtraMinVersions(@NotNull Map<String, ExtraMinVersion> minVersions) {
        Intrinsics.checkNotNullParameter(minVersions, "minVersions");
        this.minVersions = minVersions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraMinVersions copy$default(ExtraMinVersions extraMinVersions, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            map = extraMinVersions.minVersions;
        }
        return extraMinVersions.copy(map);
    }

    @NotNull
    public final Map<String, ExtraMinVersion> component1() {
        return this.minVersions;
    }

    @NotNull
    public final ExtraMinVersions copy(@NotNull Map<String, ExtraMinVersion> minVersions) {
        Intrinsics.checkNotNullParameter(minVersions, "minVersions");
        return new ExtraMinVersions(minVersions);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ExtraMinVersions) && Intrinsics.areEqual(this.minVersions, ((ExtraMinVersions) obj).minVersions)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Map<String, ExtraMinVersion> getMinVersions() {
        return this.minVersions;
    }

    public int hashCode() {
        return this.minVersions.hashCode();
    }

    @NotNull
    public String toString() {
        Map<String, ExtraMinVersion> map = this.minVersions;
        return "ExtraMinVersions(minVersions=" + map + ")";
    }
}
