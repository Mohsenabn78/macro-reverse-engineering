package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcx implements MuteThisAdReason {

    /* renamed from: a  reason: collision with root package name */
    private final String f19116a;

    /* renamed from: b  reason: collision with root package name */
    private final zzcw f19117b;

    public zzcx(zzcw zzcwVar) {
        String str;
        this.f19117b = zzcwVar;
        try {
            str = zzcwVar.zze();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            str = null;
        }
        this.f19116a = str;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.f19116a;
    }

    public final String toString() {
        return this.f19116a;
    }

    public final zzcw zza() {
        return this.f19117b;
    }
}
