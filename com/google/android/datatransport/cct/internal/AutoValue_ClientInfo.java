package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ClientInfo;

/* loaded from: classes.dex */
final class AutoValue_ClientInfo extends ClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ClientInfo.ClientType f18565a;

    /* renamed from: b  reason: collision with root package name */
    private final AndroidClientInfo f18566b;

    /* loaded from: classes.dex */
    static final class Builder extends ClientInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ClientInfo.ClientType f18567a;

        /* renamed from: b  reason: collision with root package name */
        private AndroidClientInfo f18568b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo build() {
            return new AutoValue_ClientInfo(this.f18567a, this.f18568b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder setAndroidClientInfo(@Nullable AndroidClientInfo androidClientInfo) {
            this.f18568b = androidClientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder setClientType(@Nullable ClientInfo.ClientType clientType) {
            this.f18567a = clientType;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f18565a;
        if (clientType != null ? clientType.equals(clientInfo.getClientType()) : clientInfo.getClientType() == null) {
            AndroidClientInfo androidClientInfo = this.f18566b;
            if (androidClientInfo == null) {
                if (clientInfo.getAndroidClientInfo() == null) {
                    return true;
                }
            } else if (androidClientInfo.equals(clientInfo.getAndroidClientInfo())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public AndroidClientInfo getAndroidClientInfo() {
        return this.f18566b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public ClientInfo.ClientType getClientType() {
        return this.f18565a;
    }

    public int hashCode() {
        int hashCode;
        ClientInfo.ClientType clientType = this.f18565a;
        int i4 = 0;
        if (clientType == null) {
            hashCode = 0;
        } else {
            hashCode = clientType.hashCode();
        }
        int i5 = (hashCode ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f18566b;
        if (androidClientInfo != null) {
            i4 = androidClientInfo.hashCode();
        }
        return i5 ^ i4;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f18565a + ", androidClientInfo=" + this.f18566b + "}";
    }

    private AutoValue_ClientInfo(@Nullable ClientInfo.ClientType clientType, @Nullable AndroidClientInfo androidClientInfo) {
        this.f18565a = clientType;
        this.f18566b = androidClientInfo;
    }
}
