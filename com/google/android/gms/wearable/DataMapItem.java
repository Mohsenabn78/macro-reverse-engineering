package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zzbj;
import com.google.android.gms.internal.wearable.zzcf;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public class DataMapItem {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f22633a;

    /* renamed from: b  reason: collision with root package name */
    private final DataMap f22634b;

    private DataMapItem(DataItem dataItem) {
        DataMap zza;
        this.f22633a = dataItem.getUri();
        DataItem freeze = dataItem.freeze();
        byte[] data = freeze.getData();
        if (data == null && !freeze.getAssets().isEmpty()) {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        }
        if (data == null) {
            zza = new DataMap();
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                int size = freeze.getAssets().size();
                for (int i4 = 0; i4 < size; i4++) {
                    DataItemAsset dataItemAsset = freeze.getAssets().get(Integer.toString(i4));
                    if (dataItemAsset != null) {
                        arrayList.add(Asset.createFromRef(dataItemAsset.getId()));
                    } else {
                        String obj = freeze.toString();
                        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i4 + " for " + obj);
                    }
                }
                zza = com.google.android.gms.internal.wearable.zzl.zza(new com.google.android.gms.internal.wearable.zzk(com.google.android.gms.internal.wearable.zzx.zzd(data, zzbj.zza()), arrayList));
            } catch (zzcf | NullPointerException e4) {
                String valueOf = String.valueOf(freeze.getUri());
                String encodeToString = Base64.encodeToString(data, 0);
                Log.w("DataItem", "Unable to parse datamap from dataItem. uri=" + valueOf + ", data=" + encodeToString);
                throw new IllegalStateException("Unable to parse datamap from dataItem.  uri=".concat(String.valueOf(freeze.getUri())), e4);
            }
        }
        this.f22634b = zza;
    }

    @NonNull
    public static DataMapItem fromDataItem(@NonNull DataItem dataItem) {
        Asserts.checkNotNull(dataItem, "dataItem must not be null");
        return new DataMapItem(dataItem);
    }

    @NonNull
    public DataMap getDataMap() {
        return this.f22634b;
    }

    @NonNull
    public Uri getUri() {
        return this.f22633a;
    }
}
