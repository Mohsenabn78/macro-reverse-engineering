package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "BeginSignInRequestCreator")
/* loaded from: classes4.dex */
public final class BeginSignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getPasswordRequestOptions", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final PasswordRequestOptions f19743a;
    @SafeParcelable.Field(getter = "getGoogleIdTokenRequestOptions", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final GoogleIdTokenRequestOptions f19744b;
    @Nullable
    @SafeParcelable.Field(getter = "getSessionId", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f19745c;
    @SafeParcelable.Field(getter = "isAutoSelectEnabled", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f19746d;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private PasswordRequestOptions f19747a = PasswordRequestOptions.builder().setSupported(false).build();

        /* renamed from: b  reason: collision with root package name */
        private GoogleIdTokenRequestOptions f19748b = GoogleIdTokenRequestOptions.builder().setSupported(false).build();
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f19749c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19750d;

        public final BeginSignInRequest build() {
            return new BeginSignInRequest(this.f19747a, this.f19748b, this.f19749c, this.f19750d);
        }

        public final Builder setAutoSelectEnabled(boolean z3) {
            this.f19750d = z3;
            return this;
        }

        public final Builder setGoogleIdTokenRequestOptions(@NonNull GoogleIdTokenRequestOptions googleIdTokenRequestOptions) {
            this.f19748b = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
            return this;
        }

        public final Builder setPasswordRequestOptions(@NonNull PasswordRequestOptions passwordRequestOptions) {
            this.f19747a = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
            return this;
        }

        public final Builder zzd(@NonNull String str) {
            this.f19749c = str;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    @SafeParcelable.Class(creator = "GoogleIdTokenRequestOptionsCreator")
    /* loaded from: classes4.dex */
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new zzh();
        @SafeParcelable.Field(getter = "isSupported", id = 1)

        /* renamed from: a  reason: collision with root package name */
        private final boolean f19751a;
        @Nullable
        @SafeParcelable.Field(getter = "getServerClientId", id = 2)

        /* renamed from: b  reason: collision with root package name */
        private final String f19752b;
        @Nullable
        @SafeParcelable.Field(getter = "getNonce", id = 3)

        /* renamed from: c  reason: collision with root package name */
        private final String f19753c;
        @SafeParcelable.Field(getter = "filterByAuthorizedAccounts", id = 4)

        /* renamed from: d  reason: collision with root package name */
        private final boolean f19754d;
        @Nullable
        @SafeParcelable.Field(getter = "getLinkedServiceId", id = 5)

        /* renamed from: e  reason: collision with root package name */
        private final String f19755e;
        @Nullable
        @SafeParcelable.Field(getter = "getIdTokenDepositionScopes", id = 6)

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f19756f;

        /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
        /* loaded from: classes4.dex */
        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private boolean f19757a = false;
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            private String f19758b = null;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private String f19759c = null;

            /* renamed from: d  reason: collision with root package name */
            private boolean f19760d = true;
            @Nullable

            /* renamed from: e  reason: collision with root package name */
            private String f19761e = null;
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            private List<String> f19762f = null;

            public final GoogleIdTokenRequestOptions build() {
                return new GoogleIdTokenRequestOptions(this.f19757a, this.f19758b, this.f19759c, this.f19760d, null, null);
            }

            public final Builder setFilterByAuthorizedAccounts(boolean z3) {
                this.f19760d = z3;
                return this;
            }

            public final Builder setNonce(@Nullable String str) {
                this.f19759c = str;
                return this;
            }

            public final Builder setServerClientId(@NonNull String str) {
                this.f19758b = Preconditions.checkNotEmpty(str);
                return this;
            }

            public final Builder setSupported(boolean z3) {
                this.f19757a = z3;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public GoogleIdTokenRequestOptions(@SafeParcelable.Param(id = 1) boolean z3, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z4, @Nullable @SafeParcelable.Param(id = 5) String str3, @Nullable @SafeParcelable.Param(id = 6) List<String> list) {
            this.f19751a = z3;
            if (z3) {
                Preconditions.checkNotNull(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f19752b = str;
            this.f19753c = str2;
            this.f19754d = z4;
            this.f19756f = BeginSignInRequest.b(list);
            this.f19755e = str3;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            if (this.f19751a != googleIdTokenRequestOptions.f19751a || !Objects.equal(this.f19752b, googleIdTokenRequestOptions.f19752b) || !Objects.equal(this.f19753c, googleIdTokenRequestOptions.f19753c) || this.f19754d != googleIdTokenRequestOptions.f19754d || !Objects.equal(this.f19755e, googleIdTokenRequestOptions.f19755e) || !Objects.equal(this.f19756f, googleIdTokenRequestOptions.f19756f)) {
                return false;
            }
            return true;
        }

        public final boolean filterByAuthorizedAccounts() {
            return this.f19754d;
        }

        @Nullable
        public final String getNonce() {
            return this.f19753c;
        }

        @Nullable
        public final String getServerClientId() {
            return this.f19752b;
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.f19751a), this.f19752b, this.f19753c, Boolean.valueOf(this.f19754d), this.f19755e, this.f19756f);
        }

        public final boolean isSupported() {
            return this.f19751a;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.writeString(parcel, 2, getServerClientId(), false);
            SafeParcelWriter.writeString(parcel, 3, getNonce(), false);
            SafeParcelWriter.writeBoolean(parcel, 4, filterByAuthorizedAccounts());
            SafeParcelWriter.writeString(parcel, 5, this.f19755e, false);
            SafeParcelWriter.writeStringList(parcel, 6, this.f19756f, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    @SafeParcelable.Class(creator = "PasswordRequestOptionsCreator")
    /* loaded from: classes4.dex */
    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new zzi();
        @SafeParcelable.Field(getter = "isSupported", id = 1)

        /* renamed from: a  reason: collision with root package name */
        private final boolean f19763a;

        /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
        /* loaded from: classes4.dex */
        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private boolean f19764a = false;

            public final PasswordRequestOptions build() {
                return new PasswordRequestOptions(this.f19764a);
            }

            public final Builder setSupported(boolean z3) {
                this.f19764a = z3;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public PasswordRequestOptions(@SafeParcelable.Param(id = 1) boolean z3) {
            this.f19763a = z3;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof PasswordRequestOptions) || this.f19763a != ((PasswordRequestOptions) obj).f19763a) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.f19763a));
        }

        public final boolean isSupported() {
            return this.f19763a;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public BeginSignInRequest(@SafeParcelable.Param(id = 1) PasswordRequestOptions passwordRequestOptions, @SafeParcelable.Param(id = 2) GoogleIdTokenRequestOptions googleIdTokenRequestOptions, @Nullable @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) boolean z3) {
        this.f19743a = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
        this.f19744b = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
        this.f19745c = str;
        this.f19746d = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static List<String> b(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList);
            return arrayList;
        }
        return null;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zzc(BeginSignInRequest beginSignInRequest) {
        Preconditions.checkNotNull(beginSignInRequest);
        Builder autoSelectEnabled = builder().setGoogleIdTokenRequestOptions(beginSignInRequest.getGoogleIdTokenRequestOptions()).setPasswordRequestOptions(beginSignInRequest.getPasswordRequestOptions()).setAutoSelectEnabled(beginSignInRequest.f19746d);
        String str = beginSignInRequest.f19745c;
        if (str != null) {
            autoSelectEnabled.zzd(str);
        }
        return autoSelectEnabled;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        if (!Objects.equal(this.f19743a, beginSignInRequest.f19743a) || !Objects.equal(this.f19744b, beginSignInRequest.f19744b) || !Objects.equal(this.f19745c, beginSignInRequest.f19745c) || this.f19746d != beginSignInRequest.f19746d) {
            return false;
        }
        return true;
    }

    public final GoogleIdTokenRequestOptions getGoogleIdTokenRequestOptions() {
        return this.f19744b;
    }

    public final PasswordRequestOptions getPasswordRequestOptions() {
        return this.f19743a;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f19743a, this.f19744b, this.f19745c, Boolean.valueOf(this.f19746d));
    }

    public final boolean isAutoSelectEnabled() {
        return this.f19746d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getPasswordRequestOptions(), i4, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getGoogleIdTokenRequestOptions(), i4, false);
        SafeParcelWriter.writeString(parcel, 3, this.f19745c, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isAutoSelectEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
