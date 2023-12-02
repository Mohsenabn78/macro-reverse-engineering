package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzdh implements DataItem {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f22749a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22750b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f22751c;

    public zzdh(DataItem dataItem) {
        this.f22749a = dataItem.getUri();
        this.f22750b = dataItem.getData();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, DataItemAsset> entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), entry.getValue().freeze());
            }
        }
        this.f22751c = Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Map<String, DataItemAsset> getAssets() {
        return this.f22751c;
    }

    @Override // com.google.android.gms.wearable.DataItem
    @Nullable
    public final byte[] getData() {
        return this.f22750b;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Uri getUri() {
        return this.f22749a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final DataItem setData(@Nullable byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        Object valueOf;
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder sb = new StringBuilder("DataItemEntity{ ");
        sb.append("uri=".concat(String.valueOf(this.f22749a)));
        byte[] bArr = this.f22750b;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb.append(", dataSz=".concat(valueOf.toString()));
        int size = this.f22751c.size();
        sb.append(", numAssets=" + size);
        if (isLoggable && !this.f22751c.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            for (Map.Entry entry : this.f22751c.entrySet()) {
                String id = ((DataItemAsset) entry.getValue()).getId();
                sb.append(str + ((String) entry.getKey()) + ": " + id);
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ DataItem freeze() {
        return this;
    }
}
