package com.arlosoft.macrodroid.actionblock.common;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RunnableItem.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class RunnableItem {
    public static final int $stable = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f5505a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5506b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5507c;

    public RunnableItem(@NotNull String name, long j4, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f5505a = name;
        this.f5506b = j4;
        this.f5507c = z3;
    }

    public static /* synthetic */ RunnableItem copy$default(RunnableItem runnableItem, String str, long j4, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = runnableItem.f5505a;
        }
        if ((i4 & 2) != 0) {
            j4 = runnableItem.f5506b;
        }
        if ((i4 & 4) != 0) {
            z3 = runnableItem.f5507c;
        }
        return runnableItem.copy(str, j4, z3);
    }

    @NotNull
    public final String component1() {
        return this.f5505a;
    }

    public final long component2() {
        return this.f5506b;
    }

    public final boolean component3() {
        return this.f5507c;
    }

    @NotNull
    public final RunnableItem copy(@NotNull String name, long j4, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new RunnableItem(name, j4, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RunnableItem)) {
            return false;
        }
        RunnableItem runnableItem = (RunnableItem) obj;
        if (Intrinsics.areEqual(this.f5505a, runnableItem.f5505a) && this.f5506b == runnableItem.f5506b && this.f5507c == runnableItem.f5507c) {
            return true;
        }
        return false;
    }

    public final long getGuid() {
        return this.f5506b;
    }

    @NotNull
    public final String getName() {
        return this.f5505a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f5505a.hashCode() * 31) + androidx.compose.animation.a.a(this.f5506b)) * 31;
        boolean z3 = this.f5507c;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    public final boolean isActionBlock() {
        return this.f5507c;
    }

    @NotNull
    public String toString() {
        String str = this.f5505a;
        long j4 = this.f5506b;
        boolean z3 = this.f5507c;
        return "RunnableItem(name=" + str + ", guid=" + j4 + ", isActionBlock=" + z3 + ")";
    }
}
