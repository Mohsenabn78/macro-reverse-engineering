package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.ChannelApi;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface Channel extends Parcelable {

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface GetInputStreamResult extends Releasable, Result {
        @Nullable
        InputStream getInputStream();
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface GetOutputStreamResult extends Releasable, Result {
        @Nullable
        OutputStream getOutputStream();
    }

    @NonNull
    PendingResult<Status> addListener(@NonNull GoogleApiClient googleApiClient, @NonNull ChannelApi.ChannelListener channelListener);

    @NonNull
    PendingResult<Status> close(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    PendingResult<Status> close(@NonNull GoogleApiClient googleApiClient, int i4);

    @NonNull
    PendingResult<GetInputStreamResult> getInputStream(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    String getNodeId();

    @NonNull
    PendingResult<GetOutputStreamResult> getOutputStream(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    String getPath();

    @NonNull
    PendingResult<Status> receiveFile(@NonNull GoogleApiClient googleApiClient, @NonNull Uri uri, boolean z3);

    @NonNull
    PendingResult<Status> removeListener(@NonNull GoogleApiClient googleApiClient, @NonNull ChannelApi.ChannelListener channelListener);

    @NonNull
    PendingResult<Status> sendFile(@NonNull GoogleApiClient googleApiClient, @NonNull Uri uri);

    @NonNull
    PendingResult<Status> sendFile(@NonNull GoogleApiClient googleApiClient, @NonNull Uri uri, long j4, long j5);
}
