package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "SignInCredentialCreator")
/* loaded from: classes4.dex */
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInCredential> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f19777a;
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f19778b;
    @Nullable
    @SafeParcelable.Field(getter = "getGivenName", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f19779c;
    @Nullable
    @SafeParcelable.Field(getter = "getFamilyName", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f19780d;
    @Nullable
    @SafeParcelable.Field(getter = "getProfilePictureUri", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final Uri f19781e;
    @Nullable
    @SafeParcelable.Field(getter = "getPassword", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f19782f;
    @Nullable
    @SafeParcelable.Field(getter = "getGoogleIdToken", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final String f19783g;

    @SafeParcelable.Constructor
    public SignInCredential(@SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) String str4, @Nullable @SafeParcelable.Param(id = 5) Uri uri, @Nullable @SafeParcelable.Param(id = 6) String str5, @Nullable @SafeParcelable.Param(id = 7) String str6) {
        this.f19777a = Preconditions.checkNotEmpty(str);
        this.f19778b = str2;
        this.f19779c = str3;
        this.f19780d = str4;
        this.f19781e = uri;
        this.f19782f = str5;
        this.f19783g = str6;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        if (!Objects.equal(this.f19777a, signInCredential.f19777a) || !Objects.equal(this.f19778b, signInCredential.f19778b) || !Objects.equal(this.f19779c, signInCredential.f19779c) || !Objects.equal(this.f19780d, signInCredential.f19780d) || !Objects.equal(this.f19781e, signInCredential.f19781e) || !Objects.equal(this.f19782f, signInCredential.f19782f) || !Objects.equal(this.f19783g, signInCredential.f19783g)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final String getDisplayName() {
        return this.f19778b;
    }

    @Nullable
    public final String getFamilyName() {
        return this.f19780d;
    }

    @Nullable
    public final String getGivenName() {
        return this.f19779c;
    }

    @Nullable
    public final String getGoogleIdToken() {
        return this.f19783g;
    }

    public final String getId() {
        return this.f19777a;
    }

    @Nullable
    public final String getPassword() {
        return this.f19782f;
    }

    @Nullable
    public final Uri getProfilePictureUri() {
        return this.f19781e;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f19777a, this.f19778b, this.f19779c, this.f19780d, this.f19781e, this.f19782f, this.f19783g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 4, getFamilyName(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getProfilePictureUri(), i4, false);
        SafeParcelWriter.writeString(parcel, 6, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 7, getGoogleIdToken(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
