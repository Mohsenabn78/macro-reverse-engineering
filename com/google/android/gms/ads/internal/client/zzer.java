package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzer implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzet f19189a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzer(zzet zzetVar) {
        this.f19189a = zzetVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeu zzeuVar = this.f19189a.f19190a;
        if (zzeu.a(zzeuVar) != null) {
            try {
                zzeu.a(zzeuVar).zze(1);
            } catch (RemoteException e4) {
                zzbzr.zzk("Could not notify onAdFailedToLoad event.", e4);
            }
        }
    }
}
