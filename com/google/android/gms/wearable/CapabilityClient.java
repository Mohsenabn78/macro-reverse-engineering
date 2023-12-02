package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.Wearable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class CapabilityClient extends GoogleApi<Wearable.WearableOptions> {
    @NonNull
    public static final String ACTION_CAPABILITY_CHANGED = "com.google.android.gms.wearable.CAPABILITY_CHANGED";
    public static final int FILTER_ALL = 0;
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;
    public static final int FILTER_REACHABLE = 1;

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface CapabilityFilterType {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface NodeFilterType {
    }

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    /* loaded from: classes4.dex */
    public interface OnCapabilityChangedListener extends CapabilityApi.CapabilityListener {
        @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
        void onCapabilityChanged(@NonNull CapabilityInfo capabilityInfo);
    }

    public CapabilityClient(@NonNull Activity activity, @NonNull GoogleApi.Settings settings) {
        super(activity, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }

    @NonNull
    public abstract Task<Void> addListener(@NonNull OnCapabilityChangedListener onCapabilityChangedListener, @NonNull Uri uri, int i4);

    @NonNull
    public abstract Task<Void> addListener(@NonNull OnCapabilityChangedListener onCapabilityChangedListener, @NonNull String str);

    @NonNull
    public abstract Task<Void> addLocalCapability(@NonNull String str);

    @NonNull
    public abstract Task<Map<String, CapabilityInfo>> getAllCapabilities(int i4);

    @NonNull
    public abstract Task<CapabilityInfo> getCapability(@NonNull String str, int i4);

    @NonNull
    public abstract Task<Boolean> removeListener(@NonNull OnCapabilityChangedListener onCapabilityChangedListener);

    @NonNull
    public abstract Task<Boolean> removeListener(@NonNull OnCapabilityChangedListener onCapabilityChangedListener, @NonNull String str);

    @NonNull
    public abstract Task<Void> removeLocalCapability(@NonNull String str);

    public CapabilityClient(@NonNull Context context, @NonNull GoogleApi.Settings settings) {
        super(context, Wearable.API, Wearable.WearableOptions.f22646b, settings);
    }
}
