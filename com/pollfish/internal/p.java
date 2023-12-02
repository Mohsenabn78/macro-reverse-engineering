package com.pollfish.internal;

import android.net.Uri;
import com.pollfish.internal.l4;
import java.util.ArrayList;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class p implements o {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final m f37148a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final m f37149b;

    public p(@NotNull m mVar, @NotNull m mVar2) {
        this.f37148a = mVar;
        this.f37149b = mVar2;
    }

    @Override // com.pollfish.internal.o
    @NotNull
    public final l4<Unit> a(@NotNull k kVar) {
        l4<byte[]> a4 = this.f37148a.a(kVar);
        if (!(a4 instanceof l4.a.d)) {
            return a4 instanceof l4.b ? new l4.b(Unit.INSTANCE) : (l4.a) a4;
        }
        l4<byte[]> a5 = this.f37149b.a(kVar);
        if (a5 instanceof l4.b) {
            l4<Uri> a6 = this.f37148a.a(kVar, (byte[]) ((l4.b) a5).a());
            return a6 instanceof l4.b ? new l4.b(Unit.INSTANCE) : (l4.a) a6;
        }
        return (l4.a) a5;
    }

    @Override // com.pollfish.internal.o
    @NotNull
    public final l4<Unit> a(@NotNull String str) {
        return this.f37148a.a(str);
    }

    @Override // com.pollfish.internal.o
    @NotNull
    public final l4<Unit> a() {
        return this.f37148a.clear();
    }

    @Override // com.pollfish.internal.o
    @NotNull
    public final l4 a(@NotNull ArrayList arrayList) {
        return this.f37148a.a(arrayList);
    }
}
