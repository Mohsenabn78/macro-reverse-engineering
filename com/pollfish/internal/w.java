package com.pollfish.internal;

import com.pollfish.internal.l4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class w extends i5<List<? extends k>, Unit> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final o f37279a;

    public w(@NotNull o oVar) {
        this.f37279a = oVar;
    }

    @Override // com.pollfish.internal.i5
    public final l4<Unit> a(List<? extends k> list) {
        List<? extends k> list2 = list;
        if (list2 == null) {
            return l4.a.k0.f37041c;
        }
        o oVar = this.f37279a;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        arrayList.add(new k("/index.html", "", r.WEB_ASSET));
        return oVar.a(arrayList);
    }
}
