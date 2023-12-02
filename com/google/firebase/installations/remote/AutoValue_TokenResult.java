package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.remote.TokenResult;

/* loaded from: classes5.dex */
final class AutoValue_TokenResult extends TokenResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f31580a;

    /* renamed from: b  reason: collision with root package name */
    private final long f31581b;

    /* renamed from: c  reason: collision with root package name */
    private final TokenResult.ResponseCode f31582c;

    /* loaded from: classes5.dex */
    static final class Builder extends TokenResult.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f31583a;

        /* renamed from: b  reason: collision with root package name */
        private Long f31584b;

        /* renamed from: c  reason: collision with root package name */
        private TokenResult.ResponseCode f31585c;

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult build() {
            String str = "";
            if (this.f31584b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.f31583a, this.f31584b.longValue(), this.f31585c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode) {
            this.f31585c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setToken(String str) {
            this.f31583a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder setTokenExpirationTimestamp(long j4) {
            this.f31584b = Long.valueOf(j4);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(TokenResult tokenResult) {
            this.f31583a = tokenResult.getToken();
            this.f31584b = Long.valueOf(tokenResult.getTokenExpirationTimestamp());
            this.f31585c = tokenResult.getResponseCode();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f31580a;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.f31581b == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode = this.f31582c;
                if (responseCode == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @Nullable
    public TokenResult.ResponseCode getResponseCode() {
        return this.f31582c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @Nullable
    public String getToken() {
        return this.f31580a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @NonNull
    public long getTokenExpirationTimestamp() {
        return this.f31581b;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f31580a;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j4 = this.f31581b;
        int i5 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f31582c;
        if (responseCode != null) {
            i4 = responseCode.hashCode();
        }
        return i5 ^ i4;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "TokenResult{token=" + this.f31580a + ", tokenExpirationTimestamp=" + this.f31581b + ", responseCode=" + this.f31582c + "}";
    }

    private AutoValue_TokenResult(@Nullable String str, long j4, @Nullable TokenResult.ResponseCode responseCode) {
        this.f31580a = str;
        this.f31581b = j4;
        this.f31582c = responseCode;
    }
}
