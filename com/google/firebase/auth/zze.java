package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaev;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "DefaultOAuthCredentialCreator")
/* loaded from: classes5.dex */
public final class zze extends OAuthCredential {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getProvider", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f29130a;
    @Nullable
    @SafeParcelable.Field(getter = "getIdToken", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f29131b;
    @Nullable
    @SafeParcelable.Field(getter = "getAccessToken", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f29132c;
    @Nullable
    @SafeParcelable.Field(getter = "getWebSignInCredential", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final zzaev f29133d;
    @Nullable
    @SafeParcelable.Field(getter = "getPendingToken", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final String f29134e;
    @Nullable
    @SafeParcelable.Field(getter = "getSecret", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f29135f;
    @Nullable
    @SafeParcelable.Field(getter = "getRawNonce", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final String f29136g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zze(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) zzaev zzaevVar, @Nullable @SafeParcelable.Param(id = 5) String str4, @Nullable @SafeParcelable.Param(id = 6) String str5, @Nullable @SafeParcelable.Param(id = 7) String str6) {
        this.f29130a = com.google.android.gms.internal.p002firebaseauthapi.zzac.zzc(str);
        this.f29131b = str2;
        this.f29132c = str3;
        this.f29133d = zzaevVar;
        this.f29134e = str4;
        this.f29135f = str5;
        this.f29136g = str6;
    }

    public static zze zzb(zzaev zzaevVar) {
        Preconditions.checkNotNull(zzaevVar, "Must specify a non-null webSignInCredential");
        return new zze(null, null, null, zzaevVar, null, null, null);
    }

    public static zze zzc(String str, String str2, String str3, @Nullable String str4, @Nullable String str5) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zze(str, str2, str3, null, str4, str5, null);
    }

    public static zzaev zzd(zze zzeVar, @Nullable String str) {
        Preconditions.checkNotNull(zzeVar);
        zzaev zzaevVar = zzeVar.f29133d;
        if (zzaevVar != null) {
            return zzaevVar;
        }
        return new zzaev(zzeVar.f29131b, zzeVar.f29132c, zzeVar.f29130a, null, zzeVar.f29135f, null, str, zzeVar.f29134e, zzeVar.f29136g);
    }

    @Override // com.google.firebase.auth.OAuthCredential
    @Nullable
    public final String getAccessToken() {
        return this.f29132c;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    @Nullable
    public final String getIdToken() {
        return this.f29131b;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String getProvider() {
        return this.f29130a;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    @Nullable
    public final String getSecret() {
        return this.f29135f;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String getSignInMethod() {
        return this.f29130a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f29130a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f29131b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f29132c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f29133d, i4, false);
        SafeParcelWriter.writeString(parcel, 5, this.f29134e, false);
        SafeParcelWriter.writeString(parcel, 6, this.f29135f, false);
        SafeParcelWriter.writeString(parcel, 7, this.f29136g, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new zze(this.f29130a, this.f29131b, this.f29132c, this.f29133d, this.f29134e, this.f29135f, this.f29136g);
    }
}
