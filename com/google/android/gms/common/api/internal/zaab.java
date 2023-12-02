package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaab implements PendingResult.StatusListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BasePendingResult f20127a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zaad f20128b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaab(zaad zaadVar, BasePendingResult basePendingResult) {
        this.f20128b = zaadVar;
        this.f20127a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Map map;
        map = this.f20128b.f20131a;
        map.remove(this.f20127a);
    }
}
