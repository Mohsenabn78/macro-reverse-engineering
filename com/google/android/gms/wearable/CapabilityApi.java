package com.google.android.gms.wearable;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface CapabilityApi {
    @NonNull
    public static final String ACTION_CAPABILITY_CHANGED = "com.google.android.gms.wearable.CAPABILITY_CHANGED";
    public static final int FILTER_ALL = 0;
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;
    public static final int FILTER_REACHABLE = 1;

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface AddLocalCapabilityResult extends Result {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface CapabilityFilterType {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface CapabilityListener {
        void onCapabilityChanged(@NonNull CapabilityInfo capabilityInfo);
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface GetAllCapabilitiesResult extends Result {
        @NonNull
        Map<String, CapabilityInfo> getAllCapabilities();
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface GetCapabilityResult extends Result {
        @NonNull
        CapabilityInfo getCapability();
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface NodeFilterType {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface RemoveLocalCapabilityResult extends Result {
    }

    @NonNull
    PendingResult<Status> addCapabilityListener(@NonNull GoogleApiClient googleApiClient, @NonNull CapabilityListener capabilityListener, @NonNull String str);

    @NonNull
    PendingResult<Status> addListener(@NonNull GoogleApiClient googleApiClient, @NonNull CapabilityListener capabilityListener, @NonNull Uri uri, int i4);

    @NonNull
    PendingResult<AddLocalCapabilityResult> addLocalCapability(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    PendingResult<GetAllCapabilitiesResult> getAllCapabilities(@NonNull GoogleApiClient googleApiClient, int i4);

    @NonNull
    PendingResult<GetCapabilityResult> getCapability(@NonNull GoogleApiClient googleApiClient, @NonNull String str, int i4);

    @NonNull
    PendingResult<Status> removeCapabilityListener(@NonNull GoogleApiClient googleApiClient, @NonNull CapabilityListener capabilityListener, @NonNull String str);

    @NonNull
    PendingResult<Status> removeListener(@NonNull GoogleApiClient googleApiClient, @NonNull CapabilityListener capabilityListener);

    @NonNull
    PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(@NonNull GoogleApiClient googleApiClient, @NonNull String str);
}
