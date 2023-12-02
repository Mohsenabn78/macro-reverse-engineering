package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public final class RootTelemetryConfigManager {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static RootTelemetryConfigManager f20485b;

    /* renamed from: c  reason: collision with root package name */
    private static final RootTelemetryConfiguration f20486c = new RootTelemetryConfiguration(0, false, false, 0, 0);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private RootTelemetryConfiguration f20487a;

    private RootTelemetryConfigManager() {
    }

    @NonNull
    @KeepForSdk
    public static synchronized RootTelemetryConfigManager getInstance() {
        RootTelemetryConfigManager rootTelemetryConfigManager;
        synchronized (RootTelemetryConfigManager.class) {
            if (f20485b == null) {
                f20485b = new RootTelemetryConfigManager();
            }
            rootTelemetryConfigManager = f20485b;
        }
        return rootTelemetryConfigManager;
    }

    @Nullable
    @KeepForSdk
    public RootTelemetryConfiguration getConfig() {
        return this.f20487a;
    }

    @VisibleForTesting
    public final synchronized void zza(@Nullable RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f20487a = f20486c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f20487a;
        if (rootTelemetryConfiguration2 != null && rootTelemetryConfiguration2.getVersion() >= rootTelemetryConfiguration.getVersion()) {
            return;
        }
        this.f20487a = rootTelemetryConfiguration;
    }
}
