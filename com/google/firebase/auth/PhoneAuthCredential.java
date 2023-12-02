package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "PhoneAuthCredentialCreator")
/* loaded from: classes5.dex */
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    @NonNull
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzaq();
    @Nullable
    @SafeParcelable.Field(getter = "getSessionInfo", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f28908a;
    @Nullable
    @SafeParcelable.Field(getter = "getSmsCode", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f28909b;
    @Nullable
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final String f28910c;
    @SafeParcelable.Field(getter = "getAutoCreate", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private boolean f28911d;
    @Nullable
    @SafeParcelable.Field(getter = "getTemporaryProof", id = 6)

    /* renamed from: e  reason: collision with root package name */
    private final String f28912e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PhoneAuthCredential(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) boolean z3, @Nullable @SafeParcelable.Param(id = 6) String str4) {
        boolean z4 = true;
        if ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.f28908a = str;
        this.f28909b = str2;
        this.f28910c = str3;
        this.f28911d = z3;
        this.f28912e = str4;
    }

    @NonNull
    public static PhoneAuthCredential zzc(@NonNull String str, @NonNull String str2) {
        return new PhoneAuthCredential(str, str2, null, true, null);
    }

    @NonNull
    public static PhoneAuthCredential zzd(@NonNull String str, @NonNull String str2) {
        return new PhoneAuthCredential(null, null, str, true, str2);
    }

    @Override // com.google.firebase.auth.AuthCredential
    @NonNull
    public String getProvider() {
        return "phone";
    }

    @Override // com.google.firebase.auth.AuthCredential
    @NonNull
    public String getSignInMethod() {
        return "phone";
    }

    @Nullable
    public String getSmsCode() {
        return this.f28909b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f28908a, false);
        SafeParcelWriter.writeString(parcel, 2, getSmsCode(), false);
        SafeParcelWriter.writeString(parcel, 4, this.f28910c, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f28911d);
        SafeParcelWriter.writeString(parcel, 6, this.f28912e, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.firebase.auth.AuthCredential
    @NonNull
    public final AuthCredential zza() {
        return clone();
    }

    @NonNull
    /* renamed from: zzb */
    public final PhoneAuthCredential clone() {
        return new PhoneAuthCredential(this.f28908a, getSmsCode(), this.f28910c, this.f28911d, this.f28912e);
    }

    @NonNull
    public final PhoneAuthCredential zze(boolean z3) {
        this.f28911d = false;
        return this;
    }

    @Nullable
    public final String zzf() {
        return this.f28910c;
    }

    @Nullable
    public final String zzg() {
        return this.f28908a;
    }

    @Nullable
    public final String zzh() {
        return this.f28912e;
    }

    public final boolean zzi() {
        return this.f28911d;
    }
}
