package com.arlosoft.macrodroid.remoteconfig;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraMinVersions.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class ExtraMinVersion {
    public static final int $stable = 0;
    private final int versionCode;
    @NotNull
    private final String versionName;

    public ExtraMinVersion(@NotNull String versionName, int i4) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        this.versionName = versionName;
        this.versionCode = i4;
    }

    public static /* synthetic */ ExtraMinVersion copy$default(ExtraMinVersion extraMinVersion, String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = extraMinVersion.versionName;
        }
        if ((i5 & 2) != 0) {
            i4 = extraMinVersion.versionCode;
        }
        return extraMinVersion.copy(str, i4);
    }

    @NotNull
    public final String component1() {
        return this.versionName;
    }

    public final int component2() {
        return this.versionCode;
    }

    @NotNull
    public final ExtraMinVersion copy(@NotNull String versionName, int i4) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        return new ExtraMinVersion(versionName, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraMinVersion)) {
            return false;
        }
        ExtraMinVersion extraMinVersion = (ExtraMinVersion) obj;
        if (Intrinsics.areEqual(this.versionName, extraMinVersion.versionName) && this.versionCode == extraMinVersion.versionCode) {
            return true;
        }
        return false;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        return (this.versionName.hashCode() * 31) + this.versionCode;
    }

    @NotNull
    public String toString() {
        String str = this.versionName;
        int i4 = this.versionCode;
        return "ExtraMinVersion(versionName=" + str + ", versionCode=" + i4 + ")";
    }
}
