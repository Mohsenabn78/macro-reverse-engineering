package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

/* loaded from: classes5.dex */
public class FirebaseRemoteConfigInfoImpl implements FirebaseRemoteConfigInfo {

    /* renamed from: a  reason: collision with root package name */
    private final long f32015a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32016b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseRemoteConfigSettings f32017c;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f32018a;

        /* renamed from: b  reason: collision with root package name */
        private int f32019b;

        /* renamed from: c  reason: collision with root package name */
        private FirebaseRemoteConfigSettings f32020c;

        private Builder() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder a(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
            this.f32020c = firebaseRemoteConfigSettings;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder b(int i4) {
            this.f32019b = i4;
            return this;
        }

        public FirebaseRemoteConfigInfoImpl build() {
            return new FirebaseRemoteConfigInfoImpl(this.f32018a, this.f32019b, this.f32020c);
        }

        public Builder withLastSuccessfulFetchTimeInMillis(long j4) {
            this.f32018a = j4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Builder a() {
        return new Builder();
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public FirebaseRemoteConfigSettings getConfigSettings() {
        return this.f32017c;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public long getFetchTimeMillis() {
        return this.f32015a;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public int getLastFetchStatus() {
        return this.f32016b;
    }

    private FirebaseRemoteConfigInfoImpl(long j4, int i4, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f32015a = j4;
        this.f32016b = i4;
        this.f32017c = firebaseRemoteConfigSettings;
    }
}
