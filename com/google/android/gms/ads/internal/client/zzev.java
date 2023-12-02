package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzev implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzew f19192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzev(zzew zzewVar) {
        this.f19192a = zzewVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbh zzbhVar;
        zzbh zzbhVar2;
        zzew zzewVar = this.f19192a;
        zzbhVar = zzewVar.f19193a;
        if (zzbhVar != null) {
            try {
                zzbhVar2 = zzewVar.f19193a;
                zzbhVar2.zze(1);
            } catch (RemoteException e4) {
                zzbzr.zzk("Could not notify onAdFailedToLoad event.", e4);
            }
        }
    }
}
