package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public class PutDataMapRequest {

    /* renamed from: a  reason: collision with root package name */
    private final PutDataRequest f22636a;

    /* renamed from: b  reason: collision with root package name */
    private final DataMap f22637b;

    private PutDataMapRequest(PutDataRequest putDataRequest, @Nullable DataMap dataMap) {
        this.f22636a = putDataRequest;
        DataMap dataMap2 = new DataMap();
        this.f22637b = dataMap2;
        if (dataMap != null) {
            dataMap2.putAll(dataMap);
        }
    }

    @NonNull
    public static PutDataMapRequest create(@NonNull String str) {
        Asserts.checkNotNull(str, "path must not be null");
        return new PutDataMapRequest(PutDataRequest.create(str), null);
    }

    @NonNull
    public static PutDataMapRequest createFromDataMapItem(@NonNull DataMapItem dataMapItem) {
        Asserts.checkNotNull(dataMapItem, "source must not be null");
        return new PutDataMapRequest(PutDataRequest.zza(dataMapItem.getUri()), dataMapItem.getDataMap());
    }

    @NonNull
    public static PutDataMapRequest createWithAutoAppendedId(@NonNull String str) {
        Asserts.checkNotNull(str, "pathPrefix must not be null");
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(str), null);
    }

    @NonNull
    public PutDataRequest asPutDataRequest() {
        com.google.android.gms.internal.wearable.zzk zzb = com.google.android.gms.internal.wearable.zzl.zzb(this.f22637b);
        this.f22636a.setData(zzb.zza.zzL());
        int size = zzb.zzb.size();
        for (int i4 = 0; i4 < size; i4++) {
            String num = Integer.toString(i4);
            Asset asset = (Asset) zzb.zzb.get(i4);
            if (num != null) {
                if (asset != null) {
                    if (Log.isLoggable(DataMap.TAG, 3)) {
                        String obj = asset.toString();
                        StringBuilder sb = new StringBuilder();
                        sb.append("asPutDataRequest: adding asset: ");
                        sb.append(num);
                        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        sb.append(obj);
                    }
                    this.f22636a.putAsset(num, asset);
                } else {
                    throw new IllegalStateException("asset cannot be null: key=".concat(num));
                }
            } else {
                throw new IllegalStateException("asset key cannot be null: ".concat(String.valueOf(asset)));
            }
        }
        return this.f22636a;
    }

    @NonNull
    public DataMap getDataMap() {
        return this.f22637b;
    }

    @NonNull
    public Uri getUri() {
        return this.f22636a.getUri();
    }

    public boolean isUrgent() {
        return this.f22636a.isUrgent();
    }

    @NonNull
    public PutDataMapRequest setUrgent() {
        this.f22636a.setUrgent();
        return this;
    }
}
