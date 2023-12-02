package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfd extends zzdc {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final OnAdMetadataChangedListener f19195a;

    public zzfd(@Nullable OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.f19195a = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdd
    public final void zze() throws RemoteException {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.f19195a;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
