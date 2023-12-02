package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class i {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36910a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36911b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f36912c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final String f36913d;

    public i(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        this.f36910a = str;
        this.f36911b = str2;
        this.f36912c = str3;
        this.f36913d = str4;
    }

    @NotNull
    public final String a() {
        return this.f36913d;
    }

    @NotNull
    public final String b() {
        return this.f36911b;
    }

    @NotNull
    public final String c() {
        return this.f36910a;
    }

    @NotNull
    public final String d() {
        return this.f36912c;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (Intrinsics.areEqual(this.f36910a, iVar.f36910a) && Intrinsics.areEqual(this.f36911b, iVar.f36911b) && Intrinsics.areEqual(this.f36912c, iVar.f36912c) && Intrinsics.areEqual(this.f36913d, iVar.f36913d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36913d.hashCode() + m4.a(this.f36912c, m4.a(this.f36911b, this.f36910a.hashCode() * 31, 31), 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("App(name=");
        a4.append(this.f36910a);
        a4.append(", identifier=");
        a4.append(this.f36911b);
        a4.append(", version=");
        a4.append(this.f36912c);
        a4.append(", build=");
        return g5.a(a4, this.f36913d, ')');
    }
}
