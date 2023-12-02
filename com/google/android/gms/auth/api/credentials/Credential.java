package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "CredentialCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zzc();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    @Nonnull
    @SafeParcelable.Field(getter = "getId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f19685a;
    @Nullable
    @SafeParcelable.Field(getter = "getName", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f19686b;
    @Nullable
    @SafeParcelable.Field(getter = "getProfilePictureUri", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final Uri f19687c;
    @Nonnull
    @SafeParcelable.Field(getter = "getIdTokens", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final List<IdToken> f19688d;
    @Nullable
    @SafeParcelable.Field(getter = "getPassword", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final String f19689e;
    @Nullable
    @SafeParcelable.Field(getter = "getAccountType", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f19690f;
    @Nullable
    @SafeParcelable.Field(getter = "getGivenName", id = 9)

    /* renamed from: g  reason: collision with root package name */
    private final String f19691g;
    @Nullable
    @SafeParcelable.Field(getter = "getFamilyName", id = 10)

    /* renamed from: h  reason: collision with root package name */
    private final String f19692h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Credential(@SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) Uri uri, @SafeParcelable.Param(id = 4) List<IdToken> list, @Nullable @SafeParcelable.Param(id = 5) String str3, @Nullable @SafeParcelable.Param(id = 6) String str4, @Nullable @SafeParcelable.Param(id = 9) String str5, @Nullable @SafeParcelable.Param(id = 10) String str6) {
        List<IdToken> unmodifiableList;
        String trim = ((String) Preconditions.checkNotNull(str, "credential identifier cannot be null")).trim();
        Preconditions.checkNotEmpty(trim, "credential identifier cannot be empty");
        if (str3 != null && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password must not be empty if set");
        }
        if (str4 != null) {
            boolean z3 = false;
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(str4);
                if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && ("http".equalsIgnoreCase(parse.getScheme()) || ProxyConfig.MATCH_HTTPS.equalsIgnoreCase(parse.getScheme()))) {
                    z3 = true;
                }
            }
            if (!Boolean.valueOf(z3).booleanValue()) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.f19686b = str2;
        this.f19687c = uri;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.f19688d = unmodifiableList;
        this.f19685a = trim;
        this.f19689e = str3;
        this.f19690f = str4;
        this.f19691g = str5;
        this.f19692h = str6;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        if (TextUtils.equals(this.f19685a, credential.f19685a) && TextUtils.equals(this.f19686b, credential.f19686b) && Objects.equal(this.f19687c, credential.f19687c) && TextUtils.equals(this.f19689e, credential.f19689e) && TextUtils.equals(this.f19690f, credential.f19690f)) {
            return true;
        }
        return false;
    }

    @Nullable
    public String getAccountType() {
        return this.f19690f;
    }

    @Nullable
    public String getFamilyName() {
        return this.f19692h;
    }

    @Nullable
    public String getGivenName() {
        return this.f19691g;
    }

    @Nonnull
    public String getId() {
        return this.f19685a;
    }

    @Nonnull
    public List<IdToken> getIdTokens() {
        return this.f19688d;
    }

    @Nullable
    public String getName() {
        return this.f19686b;
    }

    @Nullable
    public String getPassword() {
        return this.f19689e;
    }

    @Nullable
    public Uri getProfilePictureUri() {
        return this.f19687c;
    }

    public int hashCode() {
        return Objects.hashCode(this.f19685a, this.f19686b, this.f19687c, this.f19689e, this.f19690f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getProfilePictureUri(), i4, false);
        SafeParcelWriter.writeTypedList(parcel, 4, getIdTokens(), false);
        SafeParcelWriter.writeString(parcel, 5, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 6, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 9, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 10, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f19693a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private String f19694b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Uri f19695c;

        /* renamed from: d  reason: collision with root package name */
        private List<IdToken> f19696d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private String f19697e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private String f19698f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private String f19699g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private String f19700h;

        public Builder(String str) {
            this.f19693a = str;
        }

        public Credential build() {
            return new Credential(this.f19693a, this.f19694b, this.f19695c, this.f19696d, this.f19697e, this.f19698f, this.f19699g, this.f19700h);
        }

        public Builder setAccountType(String str) {
            this.f19698f = str;
            return this;
        }

        public Builder setName(String str) {
            this.f19694b = str;
            return this;
        }

        public Builder setPassword(@Nullable String str) {
            this.f19697e = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.f19695c = uri;
            return this;
        }

        public Builder(Credential credential) {
            this.f19693a = credential.f19685a;
            this.f19694b = credential.f19686b;
            this.f19695c = credential.f19687c;
            this.f19696d = credential.f19688d;
            this.f19697e = credential.f19689e;
            this.f19698f = credential.f19690f;
            this.f19699g = credential.f19691g;
            this.f19700h = credential.f19692h;
        }
    }
}
