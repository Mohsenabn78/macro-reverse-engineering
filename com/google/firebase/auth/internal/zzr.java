package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "DefaultAuthResultCreator")
/* loaded from: classes5.dex */
public final class zzr implements AuthResult {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @NonNull
    @SafeParcelable.Field(getter = "getUser", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private zzx f29084a;
    @Nullable
    @SafeParcelable.Field(getter = "getAdditionalUserInfo", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private zzp f29085b;
    @Nullable
    @SafeParcelable.Field(getter = "getOAuthCredential", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private com.google.firebase.auth.zze f29086c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzr(@NonNull @SafeParcelable.Param(id = 1) zzx zzxVar, @Nullable @SafeParcelable.Param(id = 2) zzp zzpVar, @Nullable @SafeParcelable.Param(id = 3) com.google.firebase.auth.zze zzeVar) {
        this.f29084a = zzxVar;
        this.f29085b = zzpVar;
        this.f29086c = zzeVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AuthResult
    @Nullable
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.f29085b;
    }

    @Override // com.google.firebase.auth.AuthResult
    @Nullable
    public final AuthCredential getCredential() {
        return this.f29086c;
    }

    @Override // com.google.firebase.auth.AuthResult
    @Nullable
    public final FirebaseUser getUser() {
        return this.f29084a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f29084a, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f29085b, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f29086c, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzr(zzx zzxVar) {
        zzx zzxVar2 = (zzx) Preconditions.checkNotNull(zzxVar);
        this.f29084a = zzxVar2;
        List zzo = zzxVar2.zzo();
        this.f29085b = null;
        for (int i4 = 0; i4 < zzo.size(); i4++) {
            if (!TextUtils.isEmpty(((zzt) zzo.get(i4)).zza())) {
                this.f29085b = new zzp(((zzt) zzo.get(i4)).getProviderId(), ((zzt) zzo.get(i4)).zza(), zzxVar.zzs());
            }
        }
        if (this.f29085b == null) {
            this.f29085b = new zzp(zzxVar.zzs());
        }
        this.f29086c = zzxVar.zzj();
    }
}
