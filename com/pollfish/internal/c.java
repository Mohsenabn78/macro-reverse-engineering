package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36711a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36712b;

    public c(@NotNull String str, boolean z3) {
        this.f36711a = str;
        this.f36712b = z3;
    }

    @NotNull
    public final String a() {
        return this.f36711a;
    }

    public final boolean b() {
        return this.f36712b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Intrinsics.areEqual(this.f36711a, cVar.f36711a) && this.f36712b == cVar.f36712b) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.f36711a.hashCode() * 31;
        boolean z3 = this.f36712b;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("AdvertisingInfo(id=");
        a4.append(this.f36711a);
        a4.append(", optOut=");
        a4.append(this.f36712b);
        a4.append(')');
        return a4.toString();
    }
}
