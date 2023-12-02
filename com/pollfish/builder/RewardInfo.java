package com.pollfish.builder;

import androidx.compose.animation.core.b;
import com.pollfish.internal.u4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.m;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/pollfish/builder/RewardInfo;", "", "", "component1", "", "component2", "rewardName", "rewardConversion", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getRewardName", "()Ljava/lang/String;", "b", "D", "getRewardConversion", "()D", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;D)V", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class RewardInfo {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f36631a;

    /* renamed from: b  reason: collision with root package name */
    private final double f36632b;

    public RewardInfo(@NotNull String str, double d4) {
        boolean isBlank;
        this.f36631a = str;
        this.f36632b = d4;
        isBlank = m.isBlank(str);
        if (!isBlank) {
            return;
        }
        throw new IllegalArgumentException("`Reward name can't be empty`");
    }

    public static /* synthetic */ RewardInfo copy$default(RewardInfo rewardInfo, String str, double d4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = rewardInfo.f36631a;
        }
        if ((i4 & 2) != 0) {
            d4 = rewardInfo.f36632b;
        }
        return rewardInfo.copy(str, d4);
    }

    @NotNull
    public final String component1() {
        return this.f36631a;
    }

    public final double component2() {
        return this.f36632b;
    }

    @NotNull
    public final RewardInfo copy(@NotNull String str, double d4) {
        return new RewardInfo(str, d4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardInfo)) {
            return false;
        }
        RewardInfo rewardInfo = (RewardInfo) obj;
        if (Intrinsics.areEqual(this.f36631a, rewardInfo.f36631a) && Double.compare(this.f36632b, rewardInfo.f36632b) == 0) {
            return true;
        }
        return false;
    }

    public final double getRewardConversion() {
        return this.f36632b;
    }

    @NotNull
    public final String getRewardName() {
        return this.f36631a;
    }

    public int hashCode() {
        return b.a(this.f36632b) + (this.f36631a.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder a4 = u4.a("RewardInfo(rewardName=");
        a4.append(this.f36631a);
        a4.append(", rewardConversion=");
        a4.append(this.f36632b);
        a4.append(')');
        return a4.toString();
    }
}
