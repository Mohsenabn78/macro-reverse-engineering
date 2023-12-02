package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzah implements CapabilityApi {
    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<Status> addCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        Asserts.checkNotNull(str, "capability must not be null");
        zzab zzabVar = new zzab(capabilityListener, str);
        IntentFilter zza = zzhl.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED");
        if (!str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str = RemoteSettings.FORWARD_SLASH_STRING.concat(str);
        }
        zza.addDataPath(str, 0);
        return zzc.a(googleApiClient, new zzz(new IntentFilter[]{zza}), zzabVar);
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, Uri uri, int i4) {
        boolean z3;
        Asserts.checkNotNull(uri, "uri must not be null");
        if (i4 != 0) {
            if (i4 == 1) {
                i4 = 1;
            } else {
                z3 = false;
                Preconditions.checkArgument(z3, "invalid filter type");
                return zzc.a(googleApiClient, new zzz(new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.CAPABILITY_CHANGED", uri, i4)}), capabilityListener);
            }
        }
        z3 = true;
        Preconditions.checkArgument(z3, "invalid filter type");
        return zzc.a(googleApiClient, new zzz(new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.CAPABILITY_CHANGED", uri, i4)}), capabilityListener);
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new zzx(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient googleApiClient, int i4) {
        boolean z3 = true;
        if (i4 != 0) {
            if (i4 == 1) {
                i4 = 1;
            } else {
                z3 = false;
            }
        }
        Preconditions.checkArgument(z3);
        return googleApiClient.enqueue(new zzw(this, googleApiClient, i4));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient googleApiClient, String str, int i4) {
        boolean z3 = true;
        if (i4 != 0) {
            if (i4 == 1) {
                i4 = 1;
            } else {
                z3 = false;
            }
        }
        Preconditions.checkArgument(z3);
        return googleApiClient.enqueue(new zzv(this, googleApiClient, str, i4));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<Status> removeCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        return googleApiClient.enqueue(new zzag(googleApiClient, new zzab(capabilityListener, str), null));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener) {
        return googleApiClient.enqueue(new zzag(googleApiClient, capabilityListener, null));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new zzy(this, googleApiClient, str));
    }
}
