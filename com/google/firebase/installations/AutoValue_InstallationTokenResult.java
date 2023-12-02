package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.installations.InstallationTokenResult;

/* loaded from: classes5.dex */
final class AutoValue_InstallationTokenResult extends InstallationTokenResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f31506a;

    /* renamed from: b  reason: collision with root package name */
    private final long f31507b;

    /* renamed from: c  reason: collision with root package name */
    private final long f31508c;

    /* loaded from: classes5.dex */
    static final class Builder extends InstallationTokenResult.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f31509a;

        /* renamed from: b  reason: collision with root package name */
        private Long f31510b;

        /* renamed from: c  reason: collision with root package name */
        private Long f31511c;

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult build() {
            String str = "";
            if (this.f31509a == null) {
                str = " token";
            }
            if (this.f31510b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f31511c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_InstallationTokenResult(this.f31509a, this.f31510b.longValue(), this.f31511c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder setToken(String str) {
            if (str != null) {
                this.f31509a = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder setTokenCreationTimestamp(long j4) {
            this.f31511c = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder setTokenExpirationTimestamp(long j4) {
            this.f31510b = Long.valueOf(j4);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(InstallationTokenResult installationTokenResult) {
            this.f31509a = installationTokenResult.getToken();
            this.f31510b = Long.valueOf(installationTokenResult.getTokenExpirationTimestamp());
            this.f31511c = Long.valueOf(installationTokenResult.getTokenCreationTimestamp());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        if (this.f31506a.equals(installationTokenResult.getToken()) && this.f31507b == installationTokenResult.getTokenExpirationTimestamp() && this.f31508c == installationTokenResult.getTokenCreationTimestamp()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    @NonNull
    public String getToken() {
        return this.f31506a;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    @NonNull
    public long getTokenCreationTimestamp() {
        return this.f31508c;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    @NonNull
    public long getTokenExpirationTimestamp() {
        return this.f31507b;
    }

    public int hashCode() {
        long j4 = this.f31507b;
        long j5 = this.f31508c;
        return ((((this.f31506a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public InstallationTokenResult.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f31506a + ", tokenExpirationTimestamp=" + this.f31507b + ", tokenCreationTimestamp=" + this.f31508c + "}";
    }

    private AutoValue_InstallationTokenResult(String str, long j4, long j5) {
        this.f31506a = str;
        this.f31507b = j4;
        this.f31508c = j5;
    }
}
