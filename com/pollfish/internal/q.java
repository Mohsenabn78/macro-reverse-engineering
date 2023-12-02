package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class q {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37157a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37158b;

    /* renamed from: c  reason: collision with root package name */
    public final int f37159c;

    /* loaded from: classes6.dex */
    public static final class a {
        @NotNull
        public static q a(@NotNull JSONObject jSONObject) {
            return new q(jSONObject.getString("cache_path"), jSONObject.getInt("file_type"), jSONObject.getString("url_path"));
        }
    }

    public q(@NotNull String str, int i4, @NotNull String str2) {
        this.f37157a = str;
        this.f37158b = str2;
        this.f37159c = i4;
    }

    @NotNull
    public final String a() {
        return this.f37157a;
    }

    @NotNull
    public final k b() {
        r rVar;
        boolean z3;
        String str = this.f37157a;
        String str2 = this.f37158b;
        r[] rVarArr = r.f37179b;
        int i4 = this.f37159c;
        r[] rVarArr2 = r.f37179b;
        int length = rVarArr2.length;
        int i5 = 0;
        while (true) {
            if (i5 < length) {
                rVar = rVarArr2[i5];
                if (rVar.f37184a == i4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    break;
                }
                i5++;
            } else {
                rVar = null;
                break;
            }
        }
        if (rVar == null) {
            rVar = r.UNKNOWN;
        }
        return new k(str, str2, rVar);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (Intrinsics.areEqual(this.f37157a, qVar.f37157a) && Intrinsics.areEqual(this.f37158b, qVar.f37158b) && this.f37159c == qVar.f37159c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37159c + m4.a(this.f37158b, this.f37157a.hashCode() * 31, 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("AssetResponseSchema(cachePath=");
        a4.append(this.f37157a);
        a4.append(", urlPath=");
        a4.append(this.f37158b);
        a4.append(", fileType=");
        a4.append(this.f37159c);
        a4.append(')');
        return a4.toString();
    }
}
