package com.pollfish.internal;

import com.pollfish.internal.l4;
import com.pollfish.internal.o0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class o0 extends i5<List<? extends k>, Unit> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final o f37136a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final i5<List<k>, Unit> f37137b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final m5 f37138c;

    public o0(@NotNull o oVar, @NotNull w wVar, @NotNull m5 m5Var) {
        this.f37136a = oVar;
        this.f37137b = wVar;
        this.f37138c = m5Var;
    }

    @Override // com.pollfish.internal.i5
    public final /* bridge */ /* synthetic */ l4<Unit> a(List<? extends k> list) {
        return a2((List<k>) list);
    }

    @NotNull
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final l4<Unit> a2(@Nullable List<k> list) {
        int collectionSizeOrDefault;
        if (list != null) {
            m5 m5Var = this.f37138c;
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (final k kVar : list) {
                arrayList.add(new Callable() { // from class: k1.t
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return o0.a(o0.this, kVar);
                    }
                });
            }
            l4<Unit> a4 = m5Var.a(arrayList);
            if ((a4 instanceof l4.b ? (l4.b) a4 : null) != null) {
                return this.f37137b.a((i5<List<k>, Unit>) list);
            }
            return (l4.a) a4;
        }
        return l4.a.k0.f37041c;
    }

    public static final l4 a(o0 o0Var, k kVar) {
        return o0Var.f37136a.a(kVar);
    }
}
