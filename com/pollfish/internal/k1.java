package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class k1 implements a5 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36974a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36975b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final x4 f36976c;

    public k1(@NotNull String str, @NotNull String str2, @NotNull x4 x4Var) {
        this.f36974a = str;
        this.f36975b = str2;
        this.f36976c = x4Var;
    }

    @Override // com.pollfish.internal.a5
    @NotNull
    public final String a() {
        return this.f36975b;
    }

    @Override // com.pollfish.internal.a5
    @NotNull
    public final String b() {
        return this.f36974a;
    }

    @Override // com.pollfish.internal.a5
    @NotNull
    public final x4 c() {
        return this.f36976c;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k1)) {
            return false;
        }
        k1 k1Var = (k1) obj;
        if (Intrinsics.areEqual(this.f36974a, k1Var.f36974a) && Intrinsics.areEqual(this.f36975b, k1Var.f36975b) && Intrinsics.areEqual(this.f36976c, k1Var.f36976c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36976c.hashCode() + m4.a(this.f36975b, this.f36974a.hashCode() * 31, 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("GenericSendToServerParams(endpoint=");
        a4.append(this.f36974a);
        a4.append(", params=");
        a4.append(this.f36975b);
        a4.append(", configuration=");
        a4.append(this.f36976c);
        a4.append(')');
        return a4.toString();
    }
}
