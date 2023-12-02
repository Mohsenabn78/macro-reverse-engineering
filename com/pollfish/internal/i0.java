package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f36914a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f36915b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f36916c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final int f36917d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f36918e = false;

    /* renamed from: f  reason: collision with root package name */
    public final int f36919f;

    public i0(int i4, @Nullable String str, @NotNull String str2, @NotNull int i5, int i6) {
        this.f36914a = i4;
        this.f36915b = str;
        this.f36916c = str2;
        this.f36917d = i5;
        this.f36919f = i6;
    }

    @NotNull
    public final String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        String str2 = this.f36915b;
        if (str2 != null) {
            str = "\"language\": \"" + str2 + "\",";
        } else {
            str = null;
        }
        sb.append(str);
        sb.append("\"language\": \"");
        sb.append(this.f36916c);
        sb.append("\",\"position\": \"");
        sb.append(v0.a(this.f36917d));
        sb.append("\",\"hasaccepted\": \"");
        sb.append(this.f36918e);
        sb.append("\",\"sdk_ver\": \"");
        sb.append(this.f36919f);
        sb.append("\"}");
        return sb.toString();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        if (this.f36914a == i0Var.f36914a && Intrinsics.areEqual(this.f36915b, i0Var.f36915b) && Intrinsics.areEqual(this.f36916c, i0Var.f36916c) && this.f36917d == i0Var.f36917d && this.f36918e == i0Var.f36918e && this.f36919f == i0Var.f36919f) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode;
        int i4 = this.f36914a * 31;
        String str = this.f36915b;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int a4 = (v0.a(this.f36917d) + m4.a(this.f36916c, (i4 + hashCode) * 31, 31)) * 31;
        boolean z3 = this.f36918e;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        return this.f36919f + ((a4 + i5) * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("DeviceInfo(version=");
        a4.append(this.f36914a);
        a4.append(", language=");
        a4.append(this.f36915b);
        a4.append(", host=");
        a4.append(this.f36916c);
        a4.append(", position=");
        a4.append(q3.b(this.f36917d));
        a4.append(", hasAcceptedTerms=");
        a4.append(this.f36918e);
        a4.append(", sdkVersion=");
        a4.append(this.f36919f);
        a4.append(')');
        return a4.toString();
    }
}
