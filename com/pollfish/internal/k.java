package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36945a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36946b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final r f36947c;

    public k(@NotNull String str, @NotNull String str2, @NotNull r rVar) {
        this.f36945a = str;
        this.f36946b = str2;
        this.f36947c = rVar;
    }

    @NotNull
    public final String a() {
        return this.f36945a;
    }

    @NotNull
    public final r b() {
        return this.f36947c;
    }

    @NotNull
    public final String c() {
        return this.f36946b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (Intrinsics.areEqual(this.f36945a, kVar.f36945a) && Intrinsics.areEqual(this.f36946b, kVar.f36946b) && this.f36947c == kVar.f36947c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36947c.hashCode() + m4.a(this.f36946b, this.f36945a.hashCode() * 31, 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("Asset(cachePath=");
        a4.append(this.f36945a);
        a4.append(", urlPath=");
        a4.append(this.f36946b);
        a4.append(", fileType=");
        a4.append(this.f36947c);
        a4.append(')');
        return a4.toString();
    }
}
