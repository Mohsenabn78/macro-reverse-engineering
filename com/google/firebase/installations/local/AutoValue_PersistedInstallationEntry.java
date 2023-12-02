package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes5.dex */
final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {

    /* renamed from: a  reason: collision with root package name */
    private final String f31550a;

    /* renamed from: b  reason: collision with root package name */
    private final PersistedInstallation.RegistrationStatus f31551b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31552c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31553d;

    /* renamed from: e  reason: collision with root package name */
    private final long f31554e;

    /* renamed from: f  reason: collision with root package name */
    private final long f31555f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31556g;

    /* loaded from: classes5.dex */
    static final class Builder extends PersistedInstallationEntry.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f31557a;

        /* renamed from: b  reason: collision with root package name */
        private PersistedInstallation.RegistrationStatus f31558b;

        /* renamed from: c  reason: collision with root package name */
        private String f31559c;

        /* renamed from: d  reason: collision with root package name */
        private String f31560d;

        /* renamed from: e  reason: collision with root package name */
        private Long f31561e;

        /* renamed from: f  reason: collision with root package name */
        private Long f31562f;

        /* renamed from: g  reason: collision with root package name */
        private String f31563g;

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry build() {
            String str = "";
            if (this.f31558b == null) {
                str = " registrationStatus";
            }
            if (this.f31561e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f31562f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new AutoValue_PersistedInstallationEntry(this.f31557a, this.f31558b, this.f31559c, this.f31560d, this.f31561e.longValue(), this.f31562f.longValue(), this.f31563g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setAuthToken(@Nullable String str) {
            this.f31559c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setExpiresInSecs(long j4) {
            this.f31561e = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setFirebaseInstallationId(String str) {
            this.f31557a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setFisError(@Nullable String str) {
            this.f31563g = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setRefreshToken(@Nullable String str) {
            this.f31560d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus != null) {
                this.f31558b = registrationStatus;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long j4) {
            this.f31562f = Long.valueOf(j4);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(PersistedInstallationEntry persistedInstallationEntry) {
            this.f31557a = persistedInstallationEntry.getFirebaseInstallationId();
            this.f31558b = persistedInstallationEntry.getRegistrationStatus();
            this.f31559c = persistedInstallationEntry.getAuthToken();
            this.f31560d = persistedInstallationEntry.getRefreshToken();
            this.f31561e = Long.valueOf(persistedInstallationEntry.getExpiresInSecs());
            this.f31562f = Long.valueOf(persistedInstallationEntry.getTokenCreationEpochInSecs());
            this.f31563g = persistedInstallationEntry.getFisError();
        }
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.f31550a;
        if (str3 != null ? str3.equals(persistedInstallationEntry.getFirebaseInstallationId()) : persistedInstallationEntry.getFirebaseInstallationId() == null) {
            if (this.f31551b.equals(persistedInstallationEntry.getRegistrationStatus()) && ((str = this.f31552c) != null ? str.equals(persistedInstallationEntry.getAuthToken()) : persistedInstallationEntry.getAuthToken() == null) && ((str2 = this.f31553d) != null ? str2.equals(persistedInstallationEntry.getRefreshToken()) : persistedInstallationEntry.getRefreshToken() == null) && this.f31554e == persistedInstallationEntry.getExpiresInSecs() && this.f31555f == persistedInstallationEntry.getTokenCreationEpochInSecs()) {
                String str4 = this.f31556g;
                if (str4 == null) {
                    if (persistedInstallationEntry.getFisError() == null) {
                        return true;
                    }
                } else if (str4.equals(persistedInstallationEntry.getFisError())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @Nullable
    public String getAuthToken() {
        return this.f31552c;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long getExpiresInSecs() {
        return this.f31554e;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @Nullable
    public String getFirebaseInstallationId() {
        return this.f31550a;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @Nullable
    public String getFisError() {
        return this.f31556g;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @Nullable
    public String getRefreshToken() {
        return this.f31553d;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @NonNull
    public PersistedInstallation.RegistrationStatus getRegistrationStatus() {
        return this.f31551b;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long getTokenCreationEpochInSecs() {
        return this.f31555f;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.f31550a;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode4 = (((hashCode ^ 1000003) * 1000003) ^ this.f31551b.hashCode()) * 1000003;
        String str2 = this.f31552c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i5 = (hashCode4 ^ hashCode2) * 1000003;
        String str3 = this.f31553d;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        long j4 = this.f31554e;
        long j5 = this.f31555f;
        int i6 = (((((i5 ^ hashCode3) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        String str4 = this.f31556g;
        if (str4 != null) {
            i4 = str4.hashCode();
        }
        return i6 ^ i4;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public PersistedInstallationEntry.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f31550a + ", registrationStatus=" + this.f31551b + ", authToken=" + this.f31552c + ", refreshToken=" + this.f31553d + ", expiresInSecs=" + this.f31554e + ", tokenCreationEpochInSecs=" + this.f31555f + ", fisError=" + this.f31556g + "}";
    }

    private AutoValue_PersistedInstallationEntry(@Nullable String str, PersistedInstallation.RegistrationStatus registrationStatus, @Nullable String str2, @Nullable String str3, long j4, long j5, @Nullable String str4) {
        this.f31550a = str;
        this.f31551b = registrationStatus;
        this.f31552c = str2;
        this.f31553d = str3;
        this.f31554e = j4;
        this.f31555f = j5;
        this.f31556g = str4;
    }
}
