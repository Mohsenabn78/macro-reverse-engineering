package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

@AutoValue
/* loaded from: classes5.dex */
public abstract class PersistedInstallationEntry {
    @NonNull
    public static PersistedInstallationEntry INSTANCE = builder().build();

    @AutoValue.Builder
    /* loaded from: classes5.dex */
    public static abstract class Builder {
        @NonNull
        public abstract PersistedInstallationEntry build();

        @NonNull
        public abstract Builder setAuthToken(@Nullable String str);

        @NonNull
        public abstract Builder setExpiresInSecs(long j4);

        @NonNull
        public abstract Builder setFirebaseInstallationId(@NonNull String str);

        @NonNull
        public abstract Builder setFisError(@Nullable String str);

        @NonNull
        public abstract Builder setRefreshToken(@Nullable String str);

        @NonNull
        public abstract Builder setRegistrationStatus(@NonNull PersistedInstallation.RegistrationStatus registrationStatus);

        @NonNull
        public abstract Builder setTokenCreationEpochInSecs(long j4);
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_PersistedInstallationEntry.Builder().setTokenCreationEpochInSecs(0L).setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).setExpiresInSecs(0L);
    }

    @Nullable
    public abstract String getAuthToken();

    public abstract long getExpiresInSecs();

    @Nullable
    public abstract String getFirebaseInstallationId();

    @Nullable
    public abstract String getFisError();

    @Nullable
    public abstract String getRefreshToken();

    @NonNull
    public abstract PersistedInstallation.RegistrationStatus getRegistrationStatus();

    public abstract long getTokenCreationEpochInSecs();

    public boolean isErrored() {
        if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR) {
            return true;
        }
        return false;
    }

    public boolean isNotGenerated() {
        if (getRegistrationStatus() != PersistedInstallation.RegistrationStatus.NOT_GENERATED && getRegistrationStatus() != PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION) {
            return false;
        }
        return true;
    }

    public boolean isRegistered() {
        if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED) {
            return true;
        }
        return false;
    }

    public boolean isUnregistered() {
        if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED) {
            return true;
        }
        return false;
    }

    public boolean shouldAttemptMigration() {
        if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION) {
            return true;
        }
        return false;
    }

    @NonNull
    public abstract Builder toBuilder();

    @NonNull
    public PersistedInstallationEntry withAuthToken(@NonNull String str, long j4, long j5) {
        return toBuilder().setAuthToken(str).setExpiresInSecs(j4).setTokenCreationEpochInSecs(j5).build();
    }

    @NonNull
    public PersistedInstallationEntry withClearedAuthToken() {
        return toBuilder().setAuthToken(null).build();
    }

    @NonNull
    public PersistedInstallationEntry withFisError(@NonNull String str) {
        return toBuilder().setFisError(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).build();
    }

    @NonNull
    public PersistedInstallationEntry withNoGeneratedFid() {
        return toBuilder().setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED).build();
    }

    @NonNull
    public PersistedInstallationEntry withRegisteredFid(@NonNull String str, @NonNull String str2, long j4, @Nullable String str3, long j5) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED).setAuthToken(str3).setRefreshToken(str2).setExpiresInSecs(j5).setTokenCreationEpochInSecs(j4).build();
    }

    @NonNull
    public PersistedInstallationEntry withUnregisteredFid(@NonNull String str) {
        return toBuilder().setFirebaseInstallationId(str).setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED).build();
    }
}
