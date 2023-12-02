package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataClient;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzda extends DataClient.GetFdForAssetResponse {

    /* renamed from: a  reason: collision with root package name */
    private final DataApi.GetFdForAssetResult f22742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzda(DataApi.GetFdForAssetResult getFdForAssetResult) {
        this.f22742a = getFdForAssetResult;
    }

    @Override // com.google.android.gms.wearable.DataClient.GetFdForAssetResponse
    public final ParcelFileDescriptor getFdForAsset() {
        return this.f22742a.getFd();
    }

    @Override // com.google.android.gms.wearable.DataClient.GetFdForAssetResponse
    public final InputStream getInputStream() {
        return this.f22742a.getInputStream();
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        this.f22742a.release();
    }
}
