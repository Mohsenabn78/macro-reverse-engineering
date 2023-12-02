package com.google.android.gms.wearable;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface NodeApi {

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface GetConnectedNodesResult extends Result {
        @NonNull
        List<Node> getNodes();
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface GetLocalNodeResult extends Result {
        @NonNull
        Node getNode();
    }

    @NonNull
    PendingResult<GetConnectedNodesResult> getConnectedNodes(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    PendingResult<GetLocalNodeResult> getLocalNode(@NonNull GoogleApiClient googleApiClient);
}
