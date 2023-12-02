package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzct implements DataApi {
    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener) {
        return zzc.a(googleApiClient, new zzco(new IntentFilter[]{zzhl.zza("com.google.android.gms.wearable.DATA_CHANGED")}), dataListener);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return deleteDataItems(googleApiClient, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.enqueue(new zzci(this, googleApiClient, uri));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzcj(this, googleApiClient));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, Asset asset) {
        if (asset != null) {
            if (asset.getDigest() != null) {
                if (asset.zza() == null) {
                    return googleApiClient.enqueue(new zzcm(this, googleApiClient, asset));
                }
                throw new IllegalArgumentException("invalid asset");
            }
            throw new IllegalArgumentException("invalid asset");
        }
        throw new IllegalArgumentException("asset is null");
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
        return googleApiClient.enqueue(new zzch(this, googleApiClient, putDataRequest));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener) {
        return googleApiClient.enqueue(new zzcp(this, googleApiClient, dataListener));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri, int i4) {
        Asserts.checkNotNull(uri, "uri must not be null");
        boolean z3 = true;
        if (i4 != 0) {
            if (i4 == 1) {
                i4 = 1;
            } else {
                z3 = false;
            }
        }
        Preconditions.checkArgument(z3, "invalid filter type");
        return googleApiClient.enqueue(new zzcl(this, googleApiClient, uri, i4));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return getDataItems(googleApiClient, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, Uri uri, int i4) {
        boolean z3;
        Asserts.checkNotNull(uri, "uri must not be null");
        if (i4 != 0) {
            if (i4 != 1) {
                z3 = false;
                Preconditions.checkArgument(z3, "invalid filter type");
                return zzc.a(googleApiClient, new zzco(new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.DATA_CHANGED", uri, i4)}), dataListener);
            }
            i4 = 1;
        }
        z3 = true;
        Preconditions.checkArgument(z3, "invalid filter type");
        return zzc.a(googleApiClient, new zzco(new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.DATA_CHANGED", uri, i4)}), dataListener);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri, int i4) {
        Asserts.checkNotNull(uri, "uri must not be null");
        boolean z3 = true;
        if (i4 != 0) {
            if (i4 == 1) {
                i4 = 1;
            } else {
                z3 = false;
            }
        }
        Preconditions.checkArgument(z3, "invalid filter type");
        return googleApiClient.enqueue(new zzck(this, googleApiClient, uri, i4));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
        return googleApiClient.enqueue(new zzcn(this, googleApiClient, dataItemAsset));
    }
}
