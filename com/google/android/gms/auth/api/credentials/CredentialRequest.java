package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "CredentialRequestCreator")
/* loaded from: classes4.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzg();
    @SafeParcelable.Field(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    private final int f19709a;
    @SafeParcelable.Field(getter = "isPasswordLoginSupported", id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f19710b;
    @SafeParcelable.Field(getter = "getAccountTypes", id = 2)

    /* renamed from: c  reason: collision with root package name */
    private final String[] f19711c;
    @SafeParcelable.Field(getter = "getCredentialPickerConfig", id = 3)

    /* renamed from: d  reason: collision with root package name */
    private final CredentialPickerConfig f19712d;
    @SafeParcelable.Field(getter = "getCredentialHintPickerConfig", id = 4)

    /* renamed from: e  reason: collision with root package name */
    private final CredentialPickerConfig f19713e;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 5)

    /* renamed from: f  reason: collision with root package name */
    private final boolean f19714f;
    @Nullable
    @SafeParcelable.Field(getter = "getServerClientId", id = 6)

    /* renamed from: g  reason: collision with root package name */
    private final String f19715g;
    @Nullable
    @SafeParcelable.Field(getter = "getIdTokenNonce", id = 7)

    /* renamed from: h  reason: collision with root package name */
    private final String f19716h;
    @SafeParcelable.Field(getter = "getRequireUserMediation", id = 8)

    /* renamed from: i  reason: collision with root package name */
    private final boolean f19717i;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19718a;

        /* renamed from: b  reason: collision with root package name */
        private String[] f19719b;

        /* renamed from: c  reason: collision with root package name */
        private CredentialPickerConfig f19720c;

        /* renamed from: d  reason: collision with root package name */
        private CredentialPickerConfig f19721d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f19722e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f19723f = false;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private String f19724g = null;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private String f19725h;

        public final CredentialRequest build() {
            if (this.f19719b == null) {
                this.f19719b = new String[0];
            }
            if (!this.f19718a && this.f19719b.length == 0) {
                throw new IllegalStateException("At least one authentication method must be specified");
            }
            return new CredentialRequest(this);
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.f19719b = strArr;
            return this;
        }

        public final Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.f19721d = credentialPickerConfig;
            return this;
        }

        public final Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.f19720c = credentialPickerConfig;
            return this;
        }

        public final Builder setIdTokenNonce(@Nullable String str) {
            this.f19725h = str;
            return this;
        }

        public final Builder setIdTokenRequested(boolean z3) {
            this.f19722e = z3;
            return this;
        }

        public final Builder setPasswordLoginSupported(boolean z3) {
            this.f19718a = z3;
            return this;
        }

        public final Builder setServerClientId(@Nullable String str) {
            this.f19724g = str;
            return this;
        }

        @Deprecated
        public final Builder setSupportsPasswordLogin(boolean z3) {
            return setPasswordLoginSupported(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public CredentialRequest(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) boolean z3, @SafeParcelable.Param(id = 2) String[] strArr, @Nullable @SafeParcelable.Param(id = 3) CredentialPickerConfig credentialPickerConfig, @Nullable @SafeParcelable.Param(id = 4) CredentialPickerConfig credentialPickerConfig2, @SafeParcelable.Param(id = 5) boolean z4, @Nullable @SafeParcelable.Param(id = 6) String str, @Nullable @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z5) {
        this.f19709a = i4;
        this.f19710b = z3;
        this.f19711c = (String[]) Preconditions.checkNotNull(strArr);
        this.f19712d = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.f19713e = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig2;
        if (i4 < 3) {
            this.f19714f = true;
            this.f19715g = null;
            this.f19716h = null;
        } else {
            this.f19714f = z4;
            this.f19715g = str;
            this.f19716h = str2;
        }
        this.f19717i = z5;
    }

    @NonNull
    public final String[] getAccountTypes() {
        return this.f19711c;
    }

    @NonNull
    public final Set<String> getAccountTypesSet() {
        return new HashSet(Arrays.asList(this.f19711c));
    }

    @NonNull
    public final CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.f19713e;
    }

    @NonNull
    public final CredentialPickerConfig getCredentialPickerConfig() {
        return this.f19712d;
    }

    @Nullable
    public final String getIdTokenNonce() {
        return this.f19716h;
    }

    @Nullable
    public final String getServerClientId() {
        return this.f19715g;
    }

    @Deprecated
    public final boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public final boolean isIdTokenRequested() {
        return this.f19714f;
    }

    public final boolean isPasswordLoginSupported() {
        return this.f19710b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isPasswordLoginSupported());
        SafeParcelWriter.writeStringArray(parcel, 2, getAccountTypes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getCredentialPickerConfig(), i4, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getCredentialHintPickerConfig(), i4, false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f19717i);
        SafeParcelWriter.writeInt(parcel, 1000, this.f19709a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private CredentialRequest(Builder builder) {
        this(4, builder.f19718a, builder.f19719b, builder.f19720c, builder.f19721d, builder.f19722e, builder.f19724g, builder.f19725h, false);
    }
}
