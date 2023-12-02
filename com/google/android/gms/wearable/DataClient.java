package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.Wearable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class DataClient extends GoogleApi<Wearable.WearableOptions> {
    @NonNull
    public static final String ACTION_DATA_CHANGED = "com.google.android.gms.wearable.DATA_CHANGED";
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface FilterType {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    /* loaded from: classes4.dex */
    public static abstract class GetFdForAssetResponse implements Releasable {
        @NonNull
        public abstract ParcelFileDescriptor getFdForAsset();

        @NonNull
        public abstract InputStream getInputStream();
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    /* loaded from: classes4.dex */
    public interface OnDataChangedListener extends DataApi.DataListener {
        @Override // com.google.android.gms.wearable.DataApi.DataListener
        void onDataChanged(@NonNull DataEventBuffer dataEventBuffer);
    }

    public DataClient(@NonNull Activity activity, @NonNull GoogleApi.Settings settings) {
        super(activity, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }

    @NonNull
    public abstract Task<Void> addListener(@NonNull OnDataChangedListener onDataChangedListener);

    @NonNull
    public abstract Task<Void> addListener(@NonNull OnDataChangedListener onDataChangedListener, @NonNull Uri uri, int i4);

    @NonNull
    public abstract Task<Integer> deleteDataItems(@NonNull Uri uri);

    @NonNull
    public abstract Task<Integer> deleteDataItems(@NonNull Uri uri, int i4);

    @NonNull
    public abstract Task<DataItem> getDataItem(@NonNull Uri uri);

    @NonNull
    public abstract Task<DataItemBuffer> getDataItems();

    @NonNull
    public abstract Task<DataItemBuffer> getDataItems(@NonNull Uri uri);

    @NonNull
    public abstract Task<DataItemBuffer> getDataItems(@NonNull Uri uri, int i4);

    @NonNull
    public abstract Task<GetFdForAssetResponse> getFdForAsset(@NonNull Asset asset);

    @NonNull
    public abstract Task<GetFdForAssetResponse> getFdForAsset(@NonNull DataItemAsset dataItemAsset);

    @NonNull
    public abstract Task<DataItem> putDataItem(@NonNull PutDataRequest putDataRequest);

    @NonNull
    public abstract Task<Boolean> removeListener(@NonNull OnDataChangedListener onDataChangedListener);

    public DataClient(@NonNull Context context, @NonNull GoogleApi.Settings settings) {
        super(context, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }
}
