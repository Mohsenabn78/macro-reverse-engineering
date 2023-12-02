package com.arlosoft.macrodroid.upgrade.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UpgradeResponse.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class UpgradeResponse {
    public static final int $stable = 0;
    @NotNull
    private final String upgradeAuth;

    public UpgradeResponse(@NotNull String upgradeAuth) {
        Intrinsics.checkNotNullParameter(upgradeAuth, "upgradeAuth");
        this.upgradeAuth = upgradeAuth;
    }

    public static /* synthetic */ UpgradeResponse copy$default(UpgradeResponse upgradeResponse, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = upgradeResponse.upgradeAuth;
        }
        return upgradeResponse.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.upgradeAuth;
    }

    @NotNull
    public final UpgradeResponse copy(@NotNull String upgradeAuth) {
        Intrinsics.checkNotNullParameter(upgradeAuth, "upgradeAuth");
        return new UpgradeResponse(upgradeAuth);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UpgradeResponse) && Intrinsics.areEqual(this.upgradeAuth, ((UpgradeResponse) obj).upgradeAuth)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getUpgradeAuth() {
        return this.upgradeAuth;
    }

    public int hashCode() {
        return this.upgradeAuth.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.upgradeAuth;
        return "UpgradeResponse(upgradeAuth=" + str + ")";
    }
}
