package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* loaded from: classes5.dex */
public final class FirebaseOptions {

    /* renamed from: a  reason: collision with root package name */
    private final String f28711a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28712b;

    /* renamed from: c  reason: collision with root package name */
    private final String f28713c;

    /* renamed from: d  reason: collision with root package name */
    private final String f28714d;

    /* renamed from: e  reason: collision with root package name */
    private final String f28715e;

    /* renamed from: f  reason: collision with root package name */
    private final String f28716f;

    /* renamed from: g  reason: collision with root package name */
    private final String f28717g;

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f28718a;

        /* renamed from: b  reason: collision with root package name */
        private String f28719b;

        /* renamed from: c  reason: collision with root package name */
        private String f28720c;

        /* renamed from: d  reason: collision with root package name */
        private String f28721d;

        /* renamed from: e  reason: collision with root package name */
        private String f28722e;

        /* renamed from: f  reason: collision with root package name */
        private String f28723f;

        /* renamed from: g  reason: collision with root package name */
        private String f28724g;

        public Builder() {
        }

        public Builder(@NonNull FirebaseOptions firebaseOptions) {
            this.f28719b = firebaseOptions.f28712b;
            this.f28718a = firebaseOptions.f28711a;
            this.f28720c = firebaseOptions.f28713c;
            this.f28721d = firebaseOptions.f28714d;
            this.f28722e = firebaseOptions.f28715e;
            this.f28723f = firebaseOptions.f28716f;
            this.f28724g = firebaseOptions.f28717g;
        }

        @NonNull
        public FirebaseOptions build() {
            return new FirebaseOptions(this.f28719b, this.f28718a, this.f28720c, this.f28721d, this.f28722e, this.f28723f, this.f28724g);
        }

        @NonNull
        public Builder setApiKey(@NonNull String str) {
            this.f28718a = Preconditions.checkNotEmpty(str, "ApiKey must be set.");
            return this;
        }

        @NonNull
        public Builder setApplicationId(@NonNull String str) {
            this.f28719b = Preconditions.checkNotEmpty(str, "ApplicationId must be set.");
            return this;
        }

        @NonNull
        public Builder setDatabaseUrl(@Nullable String str) {
            this.f28720c = str;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder setGaTrackingId(@Nullable String str) {
            this.f28721d = str;
            return this;
        }

        @NonNull
        public Builder setGcmSenderId(@Nullable String str) {
            this.f28722e = str;
            return this;
        }

        @NonNull
        public Builder setProjectId(@Nullable String str) {
            this.f28724g = str;
            return this;
        }

        @NonNull
        public Builder setStorageBucket(@Nullable String str) {
            this.f28723f = str;
            return this;
        }
    }

    @Nullable
    public static FirebaseOptions fromResource(@NonNull Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        if (!Objects.equal(this.f28712b, firebaseOptions.f28712b) || !Objects.equal(this.f28711a, firebaseOptions.f28711a) || !Objects.equal(this.f28713c, firebaseOptions.f28713c) || !Objects.equal(this.f28714d, firebaseOptions.f28714d) || !Objects.equal(this.f28715e, firebaseOptions.f28715e) || !Objects.equal(this.f28716f, firebaseOptions.f28716f) || !Objects.equal(this.f28717g, firebaseOptions.f28717g)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getApiKey() {
        return this.f28711a;
    }

    @NonNull
    public String getApplicationId() {
        return this.f28712b;
    }

    @Nullable
    public String getDatabaseUrl() {
        return this.f28713c;
    }

    @Nullable
    @KeepForSdk
    public String getGaTrackingId() {
        return this.f28714d;
    }

    @Nullable
    public String getGcmSenderId() {
        return this.f28715e;
    }

    @Nullable
    public String getProjectId() {
        return this.f28717g;
    }

    @Nullable
    public String getStorageBucket() {
        return this.f28716f;
    }

    public int hashCode() {
        return Objects.hashCode(this.f28712b, this.f28711a, this.f28713c, this.f28714d, this.f28715e, this.f28716f, this.f28717g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f28712b).add("apiKey", this.f28711a).add("databaseUrl", this.f28713c).add("gcmSenderId", this.f28715e).add("storageBucket", this.f28716f).add("projectId", this.f28717g).toString();
    }

    private FirebaseOptions(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f28712b = str;
        this.f28711a = str2;
        this.f28713c = str3;
        this.f28714d = str4;
        this.f28715e = str5;
        this.f28716f = str6;
        this.f28717g = str7;
    }
}
