package com.google.android.gms.nearby.messages;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class MessageListener {
    public void onFound(@NonNull Message message) {
    }

    public void onLost(@NonNull Message message) {
    }

    public void onBleSignalChanged(@NonNull Message message, @NonNull BleSignal bleSignal) {
    }

    public void onDistanceChanged(@NonNull Message message, @NonNull Distance distance) {
    }
}
