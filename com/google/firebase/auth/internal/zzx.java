package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzadu;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "DefaultFirebaseUserCreator")
/* loaded from: classes5.dex */
public final class zzx extends FirebaseUser {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    @SafeParcelable.Field(getter = "getCachedTokenState", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private zzadu f29100a;
    @SafeParcelable.Field(getter = "getDefaultAuthUserInfo", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private zzt f29101b;
    @SafeParcelable.Field(getter = "getFirebaseAppName", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f29102c;
    @SafeParcelable.Field(getter = "getUserType", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private String f29103d;
    @SafeParcelable.Field(getter = "getUserInfos", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private List f29104e;
    @SafeParcelable.Field(getter = "getProviders", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private List f29105f;
    @SafeParcelable.Field(getter = "getCurrentVersion", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private String f29106g;
    @SafeParcelable.Field(getter = "isAnonymous", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private Boolean f29107h;
    @SafeParcelable.Field(getter = "getMetadata", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private zzz f29108i;
    @SafeParcelable.Field(getter = "isNewUser", id = 10)

    /* renamed from: j  reason: collision with root package name */
    private boolean f29109j;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 11)

    /* renamed from: k  reason: collision with root package name */
    private com.google.firebase.auth.zze f29110k;
    @SafeParcelable.Field(getter = "getMultiFactorInfoList", id = 12)

    /* renamed from: l  reason: collision with root package name */
    private zzbd f29111l;

    public zzx(FirebaseApp firebaseApp, List list) {
        Preconditions.checkNotNull(firebaseApp);
        this.f29102c = firebaseApp.getName();
        this.f29103d = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.f29106g = ExifInterface.GPS_MEASUREMENT_2D;
        zzc(list);
    }

    public static FirebaseUser zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzx zzxVar = new zzx(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzx) {
            zzx zzxVar2 = (zzx) firebaseUser;
            zzxVar.f29106g = zzxVar2.f29106g;
            zzxVar.f29103d = zzxVar2.f29103d;
            zzxVar.f29108i = zzxVar2.f29108i;
        } else {
            zzxVar.f29108i = null;
        }
        if (firebaseUser.zzd() != null) {
            zzxVar.zzh(firebaseUser.zzd());
        }
        if (!firebaseUser.isAnonymous()) {
            zzxVar.zzm();
        }
        return zzxVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @Nullable
    public final String getDisplayName() {
        return this.f29101b.getDisplayName();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @Nullable
    public final String getEmail() {
        return this.f29101b.getEmail();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUserMetadata getMetadata() {
        return this.f29108i;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* synthetic */ MultiFactor getMultiFactor() {
        return new zzac(this);
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @Nullable
    public final String getPhoneNumber() {
        return this.f29101b.getPhoneNumber();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @Nullable
    public final Uri getPhotoUrl() {
        return this.f29101b.getPhotoUrl();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final List<? extends UserInfo> getProviderData() {
        return this.f29104e;
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @NonNull
    public final String getProviderId() {
        return this.f29101b.getProviderId();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @Nullable
    public final String getTenantId() {
        Map map;
        zzadu zzaduVar = this.f29100a;
        if (zzaduVar == null || zzaduVar.zze() == null || (map = (Map) zzba.zza(zzaduVar.zze()).getClaims().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    @NonNull
    public final String getUid() {
        return this.f29101b.getUid();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final boolean isAnonymous() {
        String str;
        Boolean bool = this.f29107h;
        if (bool == null || bool.booleanValue()) {
            zzadu zzaduVar = this.f29100a;
            if (zzaduVar != null) {
                str = zzba.zza(zzaduVar.zze()).getSignInProvider();
            } else {
                str = "";
            }
            boolean z3 = false;
            if (this.f29104e.size() <= 1 && (str == null || !str.equals("custom"))) {
                z3 = true;
            }
            this.f29107h = Boolean.valueOf(z3);
        }
        return this.f29107h.booleanValue();
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.f29101b.isEmailVerified();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f29100a, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f29101b, i4, false);
        SafeParcelWriter.writeString(parcel, 3, this.f29102c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f29103d, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.f29104e, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.f29105f, false);
        SafeParcelWriter.writeString(parcel, 7, this.f29106g, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f29108i, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f29109j);
        SafeParcelWriter.writeParcelable(parcel, 11, this.f29110k, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.f29111l, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.f29102c);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* bridge */ /* synthetic */ FirebaseUser zzb() {
        zzm();
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final synchronized FirebaseUser zzc(List list) {
        Preconditions.checkNotNull(list);
        this.f29104e = new ArrayList(list.size());
        this.f29105f = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            UserInfo userInfo = (UserInfo) list.get(i4);
            if (userInfo.getProviderId().equals("firebase")) {
                this.f29101b = (zzt) userInfo;
            } else {
                this.f29105f.add(userInfo.getProviderId());
            }
            this.f29104e.add((zzt) userInfo);
        }
        if (this.f29101b == null) {
            this.f29101b = (zzt) this.f29104e.get(0);
        }
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final zzadu zzd() {
        return this.f29100a;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final String zze() {
        return this.f29100a.zze();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @NonNull
    public final String zzf() {
        return this.f29100a.zzh();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    @Nullable
    public final List zzg() {
        return this.f29105f;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzh(zzadu zzaduVar) {
        this.f29100a = (zzadu) Preconditions.checkNotNull(zzaduVar);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzi(List list) {
        Parcelable.Creator<zzbd> creator = zzbd.CREATOR;
        zzbd zzbdVar = null;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
                if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                    arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                } else if (multiFactorInfo instanceof TotpMultiFactorInfo) {
                    arrayList2.add((TotpMultiFactorInfo) multiFactorInfo);
                }
            }
            zzbdVar = new zzbd(arrayList, arrayList2);
        }
        this.f29111l = zzbdVar;
    }

    @Nullable
    public final com.google.firebase.auth.zze zzj() {
        return this.f29110k;
    }

    public final zzx zzl(String str) {
        this.f29106g = str;
        return this;
    }

    public final zzx zzm() {
        this.f29107h = Boolean.FALSE;
        return this;
    }

    @Nullable
    public final List zzn() {
        zzbd zzbdVar = this.f29111l;
        if (zzbdVar != null) {
            return zzbdVar.zza();
        }
        return new ArrayList();
    }

    public final List zzo() {
        return this.f29104e;
    }

    public final void zzp(@Nullable com.google.firebase.auth.zze zzeVar) {
        this.f29110k = zzeVar;
    }

    public final void zzq(boolean z3) {
        this.f29109j = z3;
    }

    public final void zzr(zzz zzzVar) {
        this.f29108i = zzzVar;
    }

    public final boolean zzs() {
        return this.f29109j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(id = 1) zzadu zzaduVar, @SafeParcelable.Param(id = 2) zzt zztVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) List list2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Boolean bool, @SafeParcelable.Param(id = 9) zzz zzzVar, @SafeParcelable.Param(id = 10) boolean z3, @SafeParcelable.Param(id = 11) com.google.firebase.auth.zze zzeVar, @SafeParcelable.Param(id = 12) zzbd zzbdVar) {
        this.f29100a = zzaduVar;
        this.f29101b = zztVar;
        this.f29102c = str;
        this.f29103d = str2;
        this.f29104e = list;
        this.f29105f = list2;
        this.f29106g = str3;
        this.f29107h = bool;
        this.f29108i = zzzVar;
        this.f29109j = z3;
        this.f29110k = zzeVar;
        this.f29111l = zzbdVar;
    }
}
