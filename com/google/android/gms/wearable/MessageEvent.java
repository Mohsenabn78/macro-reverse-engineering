package com.google.android.gms.wearable;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public interface MessageEvent {
    @NonNull
    byte[] getData();

    @NonNull
    String getPath();

    int getRequestId();

    @NonNull
    String getSourceNodeId();
}
