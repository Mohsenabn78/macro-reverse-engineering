package com.arlosoft.macrodroid.accessibility;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AccessibilityServiceKeepRunningState.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AccessibilityServiceKeepRunningState {
    public static final int $stable = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f2042a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f2043b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2044c;

    public AccessibilityServiceKeepRunningState(@NotNull String name, @NotNull String id, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        this.f2042a = name;
        this.f2043b = id;
        this.f2044c = z3;
    }

    public static /* synthetic */ AccessibilityServiceKeepRunningState copy$default(AccessibilityServiceKeepRunningState accessibilityServiceKeepRunningState, String str, String str2, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = accessibilityServiceKeepRunningState.f2042a;
        }
        if ((i4 & 2) != 0) {
            str2 = accessibilityServiceKeepRunningState.f2043b;
        }
        if ((i4 & 4) != 0) {
            z3 = accessibilityServiceKeepRunningState.f2044c;
        }
        return accessibilityServiceKeepRunningState.copy(str, str2, z3);
    }

    @NotNull
    public final String component1() {
        return this.f2042a;
    }

    @NotNull
    public final String component2() {
        return this.f2043b;
    }

    public final boolean component3() {
        return this.f2044c;
    }

    @NotNull
    public final AccessibilityServiceKeepRunningState copy(@NotNull String name, @NotNull String id, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        return new AccessibilityServiceKeepRunningState(name, id, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityServiceKeepRunningState)) {
            return false;
        }
        AccessibilityServiceKeepRunningState accessibilityServiceKeepRunningState = (AccessibilityServiceKeepRunningState) obj;
        if (Intrinsics.areEqual(this.f2042a, accessibilityServiceKeepRunningState.f2042a) && Intrinsics.areEqual(this.f2043b, accessibilityServiceKeepRunningState.f2043b) && this.f2044c == accessibilityServiceKeepRunningState.f2044c) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getId() {
        return this.f2043b;
    }

    public final boolean getKeepRunning() {
        return this.f2044c;
    }

    @NotNull
    public final String getName() {
        return this.f2042a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f2042a.hashCode() * 31) + this.f2043b.hashCode()) * 31;
        boolean z3 = this.f2044c;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    @NotNull
    public String toString() {
        String str = this.f2042a;
        String str2 = this.f2043b;
        boolean z3 = this.f2044c;
        return "AccessibilityServiceKeepRunningState(name=" + str + ", id=" + str2 + ", keepRunning=" + z3 + ")";
    }
}
