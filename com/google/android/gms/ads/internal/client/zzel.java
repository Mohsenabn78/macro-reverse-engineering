package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzel extends zzcv {

    /* renamed from: a  reason: collision with root package name */
    private final String f19178a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19179b;

    public zzel(String str, String str2) {
        this.f19178a = str;
        this.f19179b = str2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcw
    public final String zze() throws RemoteException {
        return this.f19178a;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcw
    public final String zzf() throws RemoteException {
        return this.f19179b;
    }
}
