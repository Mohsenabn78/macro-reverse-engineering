package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeClient;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzgl extends NodeClient {

    /* renamed from: a  reason: collision with root package name */
    final NodeApi f22787a;

    public zzgl(@NonNull Activity activity, @NonNull GoogleApi.Settings settings) {
        super(activity, settings);
        this.f22787a = new zzgd();
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<String> getCompanionPackageForNode(final String str) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzge
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzgl zzglVar = zzgl.this;
                ((zzfb) ((zzim) obj).getService()).zzm(new zzhv(new zzgi(zzglVar, (TaskCompletionSource) obj2)), str);
            }
        }).setFeatures(com.google.android.gms.wearable.zze.zzc).setMethodKey(24023).build());
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<List<Node>> getConnectedNodes() {
        NodeApi nodeApi = this.f22787a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzga((zzgd) nodeApi, asGoogleApiClient)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzgf
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((NodeApi.GetConnectedNodesResult) result).getNodes();
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<Node> getLocalNode() {
        NodeApi nodeApi = this.f22787a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzfz((zzgd) nodeApi, asGoogleApiClient)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzgh
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((NodeApi.GetLocalNodeResult) result).getNode();
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<String> getNodeId(@NonNull final String str) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzgg
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzgl zzglVar = zzgl.this;
                String str2 = str;
                ((zzfb) ((zzim) obj).getService()).zzt(new zzgj(zzglVar, (TaskCompletionSource) obj2), str2);
            }
        }).setFeatures(com.google.android.gms.wearable.zze.zzi).setMethodKey(24025).build());
    }

    public zzgl(@NonNull Context context, @NonNull GoogleApi.Settings settings) {
        super(context, settings);
        this.f22787a = new zzgd();
    }
}
