package com.pollfish.internal;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class n implements m {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final e2 f37092a;

    public n(@NotNull e2 e2Var) {
        this.f37092a = e2Var;
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4<Uri> a(@NotNull k kVar, @NotNull byte[] bArr) {
        return this.f37092a.a(kVar.a(), bArr);
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4<Unit> clear() {
        return this.f37092a.clear();
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4<Unit> a(@NotNull String str) {
        return this.f37092a.a(str);
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4<byte[]> a(@NotNull k kVar) {
        return this.f37092a.b(kVar.a());
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4 a(@NotNull ArrayList arrayList) {
        int collectionSizeOrDefault;
        e2 e2Var = this.f37092a;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((k) it.next()).a());
        }
        return e2Var.a(arrayList2);
    }
}
