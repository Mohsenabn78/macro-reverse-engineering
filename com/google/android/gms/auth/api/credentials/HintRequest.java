package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "HintRequestCreator")
/* loaded from: classes4.dex */
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzj();
    @SafeParcelable.Field(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    private final int f19726a;
    @SafeParcelable.Field(getter = "getHintPickerConfig", id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final CredentialPickerConfig f19727b;
    @SafeParcelable.Field(getter = "isEmailAddressIdentifierSupported", id = 2)

    /* renamed from: c  reason: collision with root package name */
    private final boolean f19728c;
    @SafeParcelable.Field(getter = "isPhoneNumberIdentifierSupported", id = 3)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f19729d;
    @SafeParcelable.Field(getter = "getAccountTypes", id = 4)

    /* renamed from: e  reason: collision with root package name */
    private final String[] f19730e;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 5)

    /* renamed from: f  reason: collision with root package name */
    private final boolean f19731f;
    @Nullable
    @SafeParcelable.Field(getter = "getServerClientId", id = 6)

    /* renamed from: g  reason: collision with root package name */
    private final String f19732g;
    @Nullable
    @SafeParcelable.Field(getter = "getIdTokenNonce", id = 7)

    /* renamed from: h  reason: collision with root package name */
    private final String f19733h;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19734a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f19735b;

        /* renamed from: c  reason: collision with root package name */
        private String[] f19736c;

        /* renamed from: d  reason: collision with root package name */
        private CredentialPickerConfig f19737d = new CredentialPickerConfig.Builder().build();

        /* renamed from: e  reason: collision with root package name */
        private boolean f19738e = false;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private String f19739f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private String f19740g;

        public final HintRequest build() {
            if (this.f19736c == null) {
                this.f19736c = new String[0];
            }
            if (!this.f19734a && !this.f19735b && this.f19736c.length == 0) {
                throw new IllegalStateException("At least one authentication method must be specified");
            }
            return new HintRequest(this);
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.f19736c = strArr;
            return this;
        }

        public final Builder setEmailAddressIdentifierSupported(boolean z3) {
            this.f19734a = z3;
            return this;
        }

        public final Builder setHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.f19737d = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
            return this;
        }

        public final Builder setIdTokenNonce(@Nullable String str) {
            this.f19740g = str;
            return this;
        }

        public final Builder setIdTokenRequested(boolean z3) {
            this.f19738e = z3;
            return this;
        }

        public final Builder setPhoneNumberIdentifierSupported(boolean z3) {
            this.f19735b = z3;
            return this;
        }

        public final Builder setServerClientId(@Nullable String str) {
            this.f19739f = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public HintRequest(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 2) boolean z3, @SafeParcelable.Param(id = 3) boolean z4, @SafeParcelable.Param(id = 4) String[] strArr, @SafeParcelable.Param(id = 5) boolean z5, @Nullable @SafeParcelable.Param(id = 6) String str, @Nullable @SafeParcelable.Param(id = 7) String str2) {
        this.f19726a = i4;
        this.f19727b = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
        this.f19728c = z3;
        this.f19729d = z4;
        this.f19730e = (String[]) Preconditions.checkNotNull(strArr);
        if (i4 < 2) {
            this.f19731f = true;
            this.f19732g = null;
            this.f19733h = null;
            return;
        }
        this.f19731f = z5;
        this.f19732g = str;
        this.f19733h = str2;
    }

    @NonNull
    public final String[] getAccountTypes() {
        return this.f19730e;
    }

    @NonNull
    public final CredentialPickerConfig getHintPickerConfig() {
        return this.f19727b;
    }

    @Nullable
    public final String getIdTokenNonce() {
        return this.f19733h;
    }

    @Nullable
    public final String getServerClientId() {
        return this.f19732g;
    }

    public final boolean isEmailAddressIdentifierSupported() {
        return this.f19728c;
    }

    public final boolean isIdTokenRequested() {
        return this.f19731f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getHintPickerConfig(), i4, false);
        SafeParcelWriter.writeBoolean(parcel, 2, isEmailAddressIdentifierSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, this.f19729d);
        SafeParcelWriter.writeStringArray(parcel, 4, getAccountTypes(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f19726a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private HintRequest(Builder builder) {
        this(2, builder.f19737d, builder.f19734a, builder.f19735b, builder.f19736c, builder.f19738e, builder.f19739f, builder.f19740g);
    }
}
