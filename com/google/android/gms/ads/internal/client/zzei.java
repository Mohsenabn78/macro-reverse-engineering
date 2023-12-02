package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbkl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzei extends zzbkl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzej f19168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzei(zzej zzejVar, zzeh zzehVar) {
        this.f19168a = zzejVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkm
    public final void zzb(List list) throws RemoteException {
        int i4;
        ArrayList arrayList;
        synchronized (zzej.e(this.f19168a)) {
            zzej.h(this.f19168a, false);
            zzej.g(this.f19168a, true);
            arrayList = new ArrayList(zzej.f(this.f19168a));
            zzej.f(this.f19168a).clear();
        }
        InitializationStatus d4 = zzej.d(list);
        int size = arrayList.size();
        for (i4 = 0; i4 < size; i4++) {
            ((OnInitializationCompleteListener) arrayList.get(i4)).onInitializationComplete(d4);
        }
    }
}
