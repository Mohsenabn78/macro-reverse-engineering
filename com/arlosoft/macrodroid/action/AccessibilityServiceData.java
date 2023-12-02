package com.arlosoft.macrodroid.action;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AccessibilityServiceAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AccessibilityServiceData {
    public static final int $stable = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f2061a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f2062b;

    public AccessibilityServiceData(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f2061a = id;
        this.f2062b = name;
    }

    public static /* synthetic */ AccessibilityServiceData copy$default(AccessibilityServiceData accessibilityServiceData, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = accessibilityServiceData.f2061a;
        }
        if ((i4 & 2) != 0) {
            str2 = accessibilityServiceData.f2062b;
        }
        return accessibilityServiceData.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f2061a;
    }

    @NotNull
    public final String component2() {
        return this.f2062b;
    }

    @NotNull
    public final AccessibilityServiceData copy(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new AccessibilityServiceData(id, name);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityServiceData)) {
            return false;
        }
        AccessibilityServiceData accessibilityServiceData = (AccessibilityServiceData) obj;
        if (Intrinsics.areEqual(this.f2061a, accessibilityServiceData.f2061a) && Intrinsics.areEqual(this.f2062b, accessibilityServiceData.f2062b)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getId() {
        return this.f2061a;
    }

    @NotNull
    public final String getName() {
        return this.f2062b;
    }

    public int hashCode() {
        return (this.f2061a.hashCode() * 31) + this.f2062b.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f2061a;
        String str2 = this.f2062b;
        return "AccessibilityServiceData(id=" + str + ", name=" + str2 + ")";
    }
}
