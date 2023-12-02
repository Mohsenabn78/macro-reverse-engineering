package com.arlosoft.macrodroid.upgrade.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProUserStatus.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class ProUserStatus {
    public static final int $stable = 0;
    private final int statusCode;

    public ProUserStatus(int i4) {
        this.statusCode = i4;
    }

    public static /* synthetic */ ProUserStatus copy$default(ProUserStatus proUserStatus, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = proUserStatus.statusCode;
        }
        return proUserStatus.copy(i4);
    }

    public final int component1() {
        return this.statusCode;
    }

    @NotNull
    public final ProUserStatus copy(int i4) {
        return new ProUserStatus(i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ProUserStatus) && this.statusCode == ((ProUserStatus) obj).statusCode) {
            return true;
        }
        return false;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        return this.statusCode;
    }

    @NotNull
    public String toString() {
        int i4 = this.statusCode;
        return "ProUserStatus(statusCode=" + i4 + ")";
    }
}
