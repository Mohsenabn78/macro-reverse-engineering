package com.arlosoft.macrodroid.confirmation;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PurchaseCheckResult.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class PurchaseCheckResult {
    public static final int $stable = 0;
    private final int status;

    public PurchaseCheckResult(int i4) {
        this.status = i4;
    }

    public static /* synthetic */ PurchaseCheckResult copy$default(PurchaseCheckResult purchaseCheckResult, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = purchaseCheckResult.status;
        }
        return purchaseCheckResult.copy(i4);
    }

    public final int component1() {
        return this.status;
    }

    @NotNull
    public final PurchaseCheckResult copy(int i4) {
        return new PurchaseCheckResult(i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof PurchaseCheckResult) && this.status == ((PurchaseCheckResult) obj).status) {
            return true;
        }
        return false;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status;
    }

    @NotNull
    public String toString() {
        int i4 = this.status;
        return "PurchaseCheckResult(status=" + i4 + ")";
    }
}
