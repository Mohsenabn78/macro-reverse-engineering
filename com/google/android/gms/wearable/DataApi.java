package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface DataApi {
    @NonNull
    public static final String ACTION_DATA_CHANGED = "com.google.android.gms.wearable.DATA_CHANGED";
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface DataItemResult extends Result {
        @NonNull
        DataItem getDataItem();
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface DataListener {
        void onDataChanged(@NonNull DataEventBuffer dataEventBuffer);
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface DeleteDataItemsResult extends Result {
        int getNumDeleted();
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface FilterType {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface GetFdForAssetResult extends Result, Releasable {
        @NonNull
        ParcelFileDescriptor getFd();

        @NonNull
        InputStream getInputStream();
    }

    @NonNull
    PendingResult<Status> addListener(@NonNull GoogleApiClient googleApiClient, @NonNull DataListener dataListener);

    @NonNull
    PendingResult<Status> addListener(@NonNull GoogleApiClient googleApiClient, @NonNull DataListener dataListener, @NonNull Uri uri, int i4);

    @NonNull
    PendingResult<DeleteDataItemsResult> deleteDataItems(@NonNull GoogleApiClient googleApiClient, @NonNull Uri uri);

    @NonNull
    PendingResult<DeleteDataItemsResult> deleteDataItems(@NonNull GoogleApiClient googleApiClient, @NonNull Uri uri, int i4);

    @NonNull
    PendingResult<DataItemResult> getDataItem(@NonNull GoogleApiClient googleApiClient, @NonNull Uri uri);

    @NonNull
    PendingResult<DataItemBuffer> getDataItems(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    PendingResult<DataItemBuffer> getDataItems(@NonNull GoogleApiClient googleApiClient, @NonNull Uri uri);

    @NonNull
    PendingResult<DataItemBuffer> getDataItems(@NonNull GoogleApiClient googleApiClient, @NonNull Uri uri, int i4);

    @NonNull
    PendingResult<GetFdForAssetResult> getFdForAsset(@NonNull GoogleApiClient googleApiClient, @NonNull Asset asset);

    @NonNull
    PendingResult<GetFdForAssetResult> getFdForAsset(@NonNull GoogleApiClient googleApiClient, @NonNull DataItemAsset dataItemAsset);

    @NonNull
    PendingResult<DataItemResult> putDataItem(@NonNull GoogleApiClient googleApiClient, @NonNull PutDataRequest putDataRequest);

    @NonNull
    PendingResult<Status> removeListener(@NonNull GoogleApiClient googleApiClient, @NonNull DataListener dataListener);
}
