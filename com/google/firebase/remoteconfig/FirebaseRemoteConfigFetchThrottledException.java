package com.google.firebase.remoteconfig;

/* loaded from: classes5.dex */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigException {
    private final long throttleEndTimeMillis;

    public FirebaseRemoteConfigFetchThrottledException(long j4) {
        this("Fetch was throttled.", j4);
    }

    public long getThrottleEndTimeMillis() {
        return this.throttleEndTimeMillis;
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j4) {
        super(str);
        this.throttleEndTimeMillis = j4;
    }
}
