package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzdk extends DataBufferRef implements DataItem {

    /* renamed from: d  reason: collision with root package name */
    private final int f22755d;

    public zzdk(DataHolder dataHolder, int i4, int i5) {
        super(dataHolder, i4);
        this.f22755d = i5;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ DataItem freeze() {
        return new zzdh(this);
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Map<String, DataItemAsset> getAssets() {
        HashMap hashMap = new HashMap(this.f22755d);
        for (int i4 = 0; i4 < this.f22755d; i4++) {
            zzdg zzdgVar = new zzdg(this.f20368a, this.f20369b + i4);
            if (zzdgVar.e("asset_key") != null) {
                hashMap.put(zzdgVar.e("asset_key"), zzdgVar);
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.wearable.DataItem
    @Nullable
    public final byte[] getData() {
        return b("data");
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Uri getUri() {
        return Uri.parse(e(ClientCookie.PATH_ATTR));
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final DataItem setData(@Nullable byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        Object valueOf;
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] b4 = b("data");
        Map<String, DataItemAsset> assets = getAssets();
        StringBuilder sb = new StringBuilder("DataItemRef{ ");
        sb.append("uri=".concat(String.valueOf(getUri())));
        if (b4 == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(b4.length);
        }
        sb.append(", dataSz=".concat(valueOf.toString()));
        int size = assets.size();
        sb.append(", numAssets=" + size);
        if (isLoggable && !assets.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            for (Map.Entry<String, DataItemAsset> entry : assets.entrySet()) {
                String id = entry.getValue().getId();
                sb.append(str + entry.getKey() + ": " + id);
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }
}
