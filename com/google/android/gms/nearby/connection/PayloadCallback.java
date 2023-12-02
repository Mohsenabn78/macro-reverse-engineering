package com.google.android.gms.nearby.connection;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class PayloadCallback {
    public abstract void onPayloadReceived(@NonNull String str, @NonNull Payload payload);

    public abstract void onPayloadTransferUpdate(@NonNull String str, @NonNull PayloadTransferUpdate payloadTransferUpdate);
}
