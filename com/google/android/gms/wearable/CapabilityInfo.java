package com.google.android.gms.wearable;

import androidx.annotation.NonNull;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public interface CapabilityInfo {
    @NonNull
    String getName();

    @NonNull
    Set<Node> getNodes();
}
