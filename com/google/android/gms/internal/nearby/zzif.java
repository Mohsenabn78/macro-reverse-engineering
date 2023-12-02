package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.BandwidthInfo;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzif extends ConnectionLifecycleCallback {
    final /* synthetic */ zzii zza;
    private final ConnectionLifecycleCallback zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzif(zzii zziiVar, ConnectionLifecycleCallback connectionLifecycleCallback) {
        this.zza = zziiVar;
        this.zzb = connectionLifecycleCallback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onBandwidthChanged(String str, BandwidthInfo bandwidthInfo) {
        this.zzb.onBandwidthChanged(str, bandwidthInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        if (connectionInfo.isIncomingConnection()) {
            this.zza.zzj(str);
        }
        this.zzb.onConnectionInitiated(str, connectionInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        if (!connectionResolution.getStatus().isSuccess()) {
            this.zza.zzk(str);
        }
        this.zzb.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onDisconnected(String str) {
        this.zza.zzk(str);
        this.zzb.onDisconnected(str);
    }
}
