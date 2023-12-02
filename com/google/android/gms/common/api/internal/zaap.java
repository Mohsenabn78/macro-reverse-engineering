package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaap extends zaav {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f20151b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zaaw f20152c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaap(zaaw zaawVar, ArrayList arrayList) {
        super(zaawVar, null);
        this.f20152c = zaawVar;
        this.f20151b = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    @WorkerThread
    public final void a() {
        zabi zabiVar;
        IAccountAccessor iAccountAccessor;
        zabi zabiVar2;
        zaaw zaawVar = this.f20152c;
        zabiVar = zaawVar.f20158a;
        zabiVar.f20231n.f20206p = zaaw.q(zaawVar);
        ArrayList arrayList = this.f20151b;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            zaaw zaawVar2 = this.f20152c;
            iAccountAccessor = zaawVar2.f20172o;
            zabiVar2 = zaawVar2.f20158a;
            ((Api.Client) arrayList.get(i4)).getRemoteService(iAccountAccessor, zabiVar2.f20231n.f20206p);
        }
    }
}
