package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgh;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfj extends zzbgh {

    /* renamed from: a  reason: collision with root package name */
    private final ShouldDelayBannerRenderingListener f19197a;

    public zzfj(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.f19197a = shouldDelayBannerRenderingListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final boolean zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        return this.f19197a.shouldDelayBannerRendering((Runnable) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
