package com.google.android.gms.nearby.connection;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class ConnectionResolution {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22176a;

    @Deprecated
    public ConnectionResolution(@NonNull Status status) {
        this.f22176a = status;
    }

    @NonNull
    public Status getStatus() {
        return this.f22176a;
    }
}
