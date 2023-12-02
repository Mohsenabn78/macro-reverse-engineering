package com.pollfish.internal;

import com.pollfish.internal.d5;
import com.pollfish.internal.l4;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class d5 extends s<x4, y2> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final i5<x4, y2> f36771b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final i5<List<k>, Unit> f36772c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final i5<String, Unit> f36773d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final i5<Boolean, Unit> f36774e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final m5 f36775f;

    public d5(@NotNull g1 g1Var, @NotNull o0 o0Var, @NotNull w4 w4Var, @NotNull x xVar, @NotNull m5 m5Var) {
        super(m5Var);
        this.f36771b = g1Var;
        this.f36772c = o0Var;
        this.f36773d = w4Var;
        this.f36774e = xVar;
        this.f36775f = m5Var;
    }

    public static final l4 b(d5 d5Var, y2 y2Var) {
        return d5Var.f36772c.a((i5<List<k>, Unit>) y2Var.a().a());
    }

    @Override // com.pollfish.internal.s
    @NotNull
    public final l4<y2> a(@Nullable x4 x4Var) {
        List listOf;
        if (x4Var != null) {
            l4<y2> a4 = this.f36771b.a((i5<x4, y2>) x4Var);
            if (a4 instanceof l4.b) {
                final y2 y2Var = (y2) ((l4.b) a4).a();
                l4<Unit> a5 = this.f36774e.a((i5<Boolean, Unit>) Boolean.valueOf(y2Var.a().c()));
                if (n4.a(a5)) {
                    return (l4.a) a5;
                }
                m5 m5Var = this.f36775f;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Callable[]{new Callable() { // from class: k1.k
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return d5.a(d5.this, y2Var);
                    }
                }, new Callable() { // from class: k1.l
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return d5.b(d5.this, y2Var);
                    }
                }});
                l4<Unit> a6 = m5Var.a(listOf);
                if ((a6 instanceof l4.b ? (l4.b) a6 : null) != null) {
                    return new l4.b(y2Var);
                }
                return (l4.a) a6;
            }
            return (l4.a) a4;
        }
        return l4.a.k0.f37041c;
    }

    public static final l4 a(d5 d5Var, y2 y2Var) {
        return d5Var.f36773d.a((i5<String, Unit>) y2Var.a().e());
    }
}
