package com.google.android.gms.wearable;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public interface Node {
    @NonNull
    String getDisplayName();

    @NonNull
    String getId();

    boolean isNearby();
}
