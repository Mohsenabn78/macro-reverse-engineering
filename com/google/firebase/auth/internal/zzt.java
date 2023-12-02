package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzadl;
import com.google.android.gms.internal.p002firebaseauthapi.zzadz;
import com.google.android.gms.internal.p002firebaseauthapi.zzwk;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "DefaultAuthUserInfoCreator")
/* loaded from: classes5.dex */
public final class zzt extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    @NonNull
    @SafeParcelable.Field(getter = "getUid", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f29087a;
    @NonNull
    @SafeParcelable.Field(getter = "getProviderId", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f29088b;
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f29089c;
    @Nullable
    @SafeParcelable.Field(getter = "getPhotoUrlString", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private String f29090d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Uri f29091e;
    @Nullable
    @SafeParcelable.Field(getter = "getEmail", id = 5)

    /* renamed from: f  reason: collision with root package name */
    private final String f29092f;
    @Nullable
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 6)

    /* renamed from: g  reason: collision with root package name */
    private final String f29093g;
    @SafeParcelable.Field(getter = "isEmailVerified", id = 7)

    /* renamed from: h  reason: collision with root package name */
    private final boolean f29094h;
    @Nullable
    @SafeParcelable.Field(getter = "getRawUserInfo", id = 8)

    /* renamed from: i  reason: collision with root package name */
    private final String f29095i;

    public zzt(zzadl zzadlVar, String str) {
        Preconditions.checkNotNull(zzadlVar);
        Preconditions.checkNotEmpty("firebase");
        this.f29087a = Preconditions.checkNotEmpty(zzadlVar.zzo());
        this.f29088b = "firebase";
        this.f29092f = zzadlVar.zzn();
        this.f29089c = zzadlVar.zzm();
        Uri zzc = zzadlVar.zzc();
        if (zzc != null) {
            this.f29090d = zzc.toString();
            this.f29091e = zzc;
        }
        this.f29094h = zzadlVar.zzs();
        this.f29095i = null;
        this.f29093g = zzadlVar.zzp();
    }

    @Override // com.google.firebase.auth.UserInfo
    @Nullable
    public final String getDisplayName() {
        return this.f29089c;
    }

    @Override // com.google.firebase.auth.UserInfo
    @Nullable
    public final String getEmail() {
        return this.f29092f;
    }

    @Override // com.google.firebase.auth.UserInfo
    @Nullable
    public final String getPhoneNumber() {
        return this.f29093g;
    }

    @Override // com.google.firebase.auth.UserInfo
    @Nullable
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.f29090d) && this.f29091e == null) {
            this.f29091e = Uri.parse(this.f29090d);
        }
        return this.f29091e;
    }

    @Override // com.google.firebase.auth.UserInfo
    @NonNull
    public final String getProviderId() {
        return this.f29088b;
    }

    @Override // com.google.firebase.auth.UserInfo
    @NonNull
    public final String getUid() {
        return this.f29087a;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.f29094h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f29087a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f29088b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f29089c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f29090d, false);
        SafeParcelWriter.writeString(parcel, 5, this.f29092f, false);
        SafeParcelWriter.writeString(parcel, 6, this.f29093g, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.f29094h);
        SafeParcelWriter.writeString(parcel, 8, this.f29095i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final String zza() {
        return this.f29095i;
    }

    @Nullable
    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f29087a);
            jSONObject.putOpt("providerId", this.f29088b);
            jSONObject.putOpt("displayName", this.f29089c);
            jSONObject.putOpt("photoUrl", this.f29090d);
            jSONObject.putOpt("email", this.f29092f);
            jSONObject.putOpt(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.f29093g);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.f29094h));
            jSONObject.putOpt("rawUserInfo", this.f29095i);
            return jSONObject.toString();
        } catch (JSONException e4) {
            throw new zzwk(e4);
        }
    }

    public zzt(zzadz zzadzVar) {
        Preconditions.checkNotNull(zzadzVar);
        this.f29087a = zzadzVar.zzd();
        this.f29088b = Preconditions.checkNotEmpty(zzadzVar.zzf());
        this.f29089c = zzadzVar.zzb();
        Uri zza = zzadzVar.zza();
        if (zza != null) {
            this.f29090d = zza.toString();
            this.f29091e = zza;
        }
        this.f29092f = zzadzVar.zzc();
        this.f29093g = zzadzVar.zze();
        this.f29094h = false;
        this.f29095i = zzadzVar.zzg();
    }

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzt(@NonNull @SafeParcelable.Param(id = 1) String str, @NonNull @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 5) String str3, @Nullable @SafeParcelable.Param(id = 4) String str4, @Nullable @SafeParcelable.Param(id = 3) String str5, @Nullable @SafeParcelable.Param(id = 6) String str6, @SafeParcelable.Param(id = 7) boolean z3, @Nullable @SafeParcelable.Param(id = 8) String str7) {
        this.f29087a = str;
        this.f29088b = str2;
        this.f29092f = str3;
        this.f29093g = str4;
        this.f29089c = str5;
        this.f29090d = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.f29091e = Uri.parse(this.f29090d);
        }
        this.f29094h = z3;
        this.f29095i = str7;
    }
}
