package com.google.firebase.installations.remote;

import androidx.annotation.Nullable;
import com.google.firebase.installations.remote.InstallationResponse;

/* loaded from: classes5.dex */
final class AutoValue_InstallationResponse extends InstallationResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f31570a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31571b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31572c;

    /* renamed from: d  reason: collision with root package name */
    private final TokenResult f31573d;

    /* renamed from: e  reason: collision with root package name */
    private final InstallationResponse.ResponseCode f31574e;

    /* loaded from: classes5.dex */
    static final class Builder extends InstallationResponse.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f31575a;

        /* renamed from: b  reason: collision with root package name */
        private String f31576b;

        /* renamed from: c  reason: collision with root package name */
        private String f31577c;

        /* renamed from: d  reason: collision with root package name */
        private TokenResult f31578d;

        /* renamed from: e  reason: collision with root package name */
        private InstallationResponse.ResponseCode f31579e;

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse build() {
            return new AutoValue_InstallationResponse(this.f31575a, this.f31576b, this.f31577c, this.f31578d, this.f31579e);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setAuthToken(TokenResult tokenResult) {
            this.f31578d = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setFid(String str) {
            this.f31576b = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setRefreshToken(String str) {
            this.f31577c = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode responseCode) {
            this.f31579e = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder setUri(String str) {
            this.f31575a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(InstallationResponse installationResponse) {
            this.f31575a = installationResponse.getUri();
            this.f31576b = installationResponse.getFid();
            this.f31577c = installationResponse.getRefreshToken();
            this.f31578d = installationResponse.getAuthToken();
            this.f31579e = installationResponse.getResponseCode();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f31570a;
        if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
            String str2 = this.f31571b;
            if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                String str3 = this.f31572c;
                if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                    TokenResult tokenResult = this.f31573d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                        InstallationResponse.ResponseCode responseCode = this.f31574e;
                        if (responseCode == null) {
                            if (installationResponse.getResponseCode() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.getResponseCode())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public TokenResult getAuthToken() {
        return this.f31573d;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public String getFid() {
        return this.f31571b;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public String getRefreshToken() {
        return this.f31572c;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public InstallationResponse.ResponseCode getResponseCode() {
        return this.f31574e;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public String getUri() {
        return this.f31570a;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        String str = this.f31570a;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode ^ 1000003) * 1000003;
        String str2 = this.f31571b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 ^ hashCode2) * 1000003;
        String str3 = this.f31572c;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i7 = (i6 ^ hashCode3) * 1000003;
        TokenResult tokenResult = this.f31573d;
        if (tokenResult == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = tokenResult.hashCode();
        }
        int i8 = (i7 ^ hashCode4) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f31574e;
        if (responseCode != null) {
            i4 = responseCode.hashCode();
        }
        return i8 ^ i4;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public InstallationResponse.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f31570a + ", fid=" + this.f31571b + ", refreshToken=" + this.f31572c + ", authToken=" + this.f31573d + ", responseCode=" + this.f31574e + "}";
    }

    private AutoValue_InstallationResponse(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable TokenResult tokenResult, @Nullable InstallationResponse.ResponseCode responseCode) {
        this.f31570a = str;
        this.f31571b = str2;
        this.f31572c = str3;
        this.f31573d = tokenResult;
        this.f31574e = responseCode;
    }
}
