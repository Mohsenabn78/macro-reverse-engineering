package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Wearable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class NodeClient extends GoogleApi<Wearable.WearableOptions> {
    public NodeClient(@NonNull Activity activity, @NonNull GoogleApi.Settings settings) {
        super(activity, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }

    @NonNull
    public abstract Task<String> getCompanionPackageForNode(@NonNull String str);

    @NonNull
    public abstract Task<List<Node>> getConnectedNodes();

    @NonNull
    public abstract Task<Node> getLocalNode();

    @NonNull
    public abstract Task<String> getNodeId(@NonNull String str);

    public NodeClient(@NonNull Context context, @NonNull GoogleApi.Settings settings) {
        super(context, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }
}
