package com.pollfish.internal;

import android.os.Handler;
import android.os.Looper;
import com.pollfish.internal.l4;
import com.pollfish.internal.o5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class o5 implements n5 {

    /* renamed from: a  reason: collision with root package name */
    public final int f37142a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final Handler f37143b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public volatile Future<?> f37144c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public volatile List<? extends Future<?>> f37145d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f37146e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public ExecutorService f37147f;

    public o5(@NotNull Looper looper, int i4) {
        this.f37142a = i4;
        this.f37143b = new Handler(looper);
        this.f37146e = Executors.newSingleThreadExecutor();
    }

    public static final void b(Function1 function1, l4 l4Var) {
        function1.invoke(l4Var);
    }

    @Override // com.pollfish.internal.n5
    public final void a(@NotNull f1 f1Var) {
        try {
            this.f37144c = this.f37146e.submit(f1Var);
        } catch (Exception unused) {
        }
    }

    @Override // com.pollfish.internal.n5
    public final void shutdown() {
        List<? extends Future<?>> list = this.f37145d;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(true);
            }
        }
        Future<?> future = this.f37144c;
        if (future != null) {
            future.cancel(true);
        }
        this.f37144c = null;
        this.f37145d = null;
    }

    @Override // com.pollfish.internal.n5
    @NotNull
    public final <R> l4<Unit> a(@NotNull List<? extends Callable<l4<R>>> list) {
        l4<Unit> lVar;
        boolean z3;
        List flatten;
        Object first;
        int coerceAtMost;
        if (this.f37147f == null) {
            coerceAtMost = kotlin.ranges.h.coerceAtMost(list.size(), this.f37142a);
            this.f37147f = Executors.newFixedThreadPool(coerceAtMost);
        }
        try {
            ExecutorService executorService = this.f37147f;
            this.f37145d = executorService != null ? executorService.invokeAll(list) : null;
            List<? extends Future<?>> list2 = this.f37145d;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                Object obj = ((Future) it.next()).get();
                l4 l4Var = obj instanceof l4 ? (l4) obj : null;
                if (l4Var != null) {
                    arrayList.add(l4Var);
                }
            }
            boolean z4 = false;
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    try {
                        z3 = ((l4) it2.next()) instanceof l4.a.p;
                        continue;
                    } catch (Exception unused) {
                        z3 = false;
                        continue;
                    }
                    if (z3) {
                        z4 = true;
                        break;
                    }
                }
            }
            if (z4) {
                return l4.a.p.f37055c;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Object next = it3.next();
                if (n4.b((l4) next)) {
                    arrayList2.add(next);
                } else {
                    arrayList3.add(next);
                }
            }
            List<l4> list3 = (List) new Pair(arrayList2, arrayList3).component2();
            if (list3.isEmpty()) {
                return new l4.b(Unit.INSTANCE);
            }
            ArrayList arrayList4 = new ArrayList();
            for (l4 l4Var2 : list3) {
                l4.a aVar = l4Var2 instanceof l4.a ? (l4.a) l4Var2 : null;
                if (aVar != null) {
                    arrayList4.add(aVar);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                Object next2 = it4.next();
                l4.a aVar2 = (l4.a) next2;
                Pair pair = new Pair(aVar2.c(), aVar2.d());
                Object obj2 = linkedHashMap.get(pair);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(pair, obj2);
                }
                ((List) obj2).add(next2);
            }
            flatten = kotlin.collections.f.flatten(linkedHashMap.values());
            if (linkedHashMap.keySet().size() == 1) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) flatten);
                return (l4.a) first;
            }
            return new l4.a.o(flatten);
        } catch (InterruptedException unused2) {
            lVar = l4.a.p.f37055c;
            this.f37145d = null;
            return lVar;
        } catch (Exception e4) {
            lVar = new l4.a.l(e4);
            this.f37145d = null;
            return lVar;
        }
    }

    public /* synthetic */ o5() {
        this(Looper.getMainLooper(), 10);
    }

    @Override // com.pollfish.internal.n5
    public final void a(@NotNull final Function1 function1, @NotNull final l4 l4Var) {
        this.f37143b.post(new Runnable() { // from class: k1.u
            @Override // java.lang.Runnable
            public final void run() {
                o5.b(Function1.this, l4Var);
            }
        });
    }
}
