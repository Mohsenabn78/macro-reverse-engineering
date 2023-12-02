package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes5.dex */
public interface ConnectivityMonitor {

    /* loaded from: classes5.dex */
    public enum NetworkStatus {
        UNREACHABLE,
        REACHABLE
    }

    void addCallback(Consumer<NetworkStatus> consumer);

    void shutdown();
}
