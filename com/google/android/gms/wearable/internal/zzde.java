package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzde implements DataItemAsset {

    /* renamed from: a  reason: collision with root package name */
    private final String f22747a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22748b;

    public zzde(DataItemAsset dataItemAsset) {
        this.f22747a = dataItemAsset.getId();
        this.f22748b = dataItemAsset.getDataItemKey();
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getDataItemKey() {
        return this.f22748b;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getId() {
        return this.f22747a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetEntity[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.f22747a == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.f22747a);
        }
        sb.append(", key=");
        sb.append(this.f22748b);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ DataItemAsset freeze() {
        return this;
    }
}
