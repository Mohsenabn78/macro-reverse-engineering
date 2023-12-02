package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
/* loaded from: classes4.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzm();

    /* renamed from: o  reason: collision with root package name */
    static final Scope[] f20446o = new Scope[0];

    /* renamed from: p  reason: collision with root package name */
    static final Feature[] f20447p = new Feature[0];
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20448a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int f20449b;
    @SafeParcelable.Field(id = 3)

    /* renamed from: c  reason: collision with root package name */
    int f20450c;
    @SafeParcelable.Field(id = 4)

    /* renamed from: d  reason: collision with root package name */
    String f20451d;
    @Nullable
    @SafeParcelable.Field(id = 5)

    /* renamed from: e  reason: collision with root package name */
    IBinder f20452e;
    @SafeParcelable.Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_SCOPES", id = 6)

    /* renamed from: f  reason: collision with root package name */
    Scope[] f20453f;
    @SafeParcelable.Field(defaultValueUnchecked = "new android.os.Bundle()", id = 7)

    /* renamed from: g  reason: collision with root package name */
    Bundle f20454g;
    @Nullable
    @SafeParcelable.Field(id = 8)

    /* renamed from: h  reason: collision with root package name */
    Account f20455h;
    @SafeParcelable.Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 10)

    /* renamed from: i  reason: collision with root package name */
    Feature[] f20456i;
    @SafeParcelable.Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 11)

    /* renamed from: j  reason: collision with root package name */
    Feature[] f20457j;
    @SafeParcelable.Field(id = 12)

    /* renamed from: k  reason: collision with root package name */
    boolean f20458k;
    @SafeParcelable.Field(defaultValue = "0", id = 13)

    /* renamed from: l  reason: collision with root package name */
    int f20459l;
    @SafeParcelable.Field(getter = "isRequestingTelemetryConfiguration", id = 14)

    /* renamed from: m  reason: collision with root package name */
    boolean f20460m;
    @Nullable
    @SafeParcelable.Field(getter = "getAttributionTag", id = 15)

    /* renamed from: n  reason: collision with root package name */
    private String f20461n;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GetServiceRequest(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) String str, @Nullable @SafeParcelable.Param(id = 5) IBinder iBinder, @SafeParcelable.Param(id = 6) Scope[] scopeArr, @SafeParcelable.Param(id = 7) Bundle bundle, @Nullable @SafeParcelable.Param(id = 8) Account account, @SafeParcelable.Param(id = 10) Feature[] featureArr, @SafeParcelable.Param(id = 11) Feature[] featureArr2, @SafeParcelable.Param(id = 12) boolean z3, @SafeParcelable.Param(id = 13) int i7, @SafeParcelable.Param(id = 14) boolean z4, @Nullable @SafeParcelable.Param(id = 15) String str2) {
        Account account2;
        scopeArr = scopeArr == null ? f20446o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? f20447p : featureArr;
        featureArr2 = featureArr2 == null ? f20447p : featureArr2;
        this.f20448a = i4;
        this.f20449b = i5;
        this.f20450c = i6;
        if ("com.google.android.gms".equals(str)) {
            this.f20451d = "com.google.android.gms";
        } else {
            this.f20451d = str;
        }
        if (i4 < 2) {
            if (iBinder != null) {
                account2 = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder));
            } else {
                account2 = null;
            }
            this.f20455h = account2;
        } else {
            this.f20452e = iBinder;
            this.f20455h = account;
        }
        this.f20453f = scopeArr;
        this.f20454g = bundle;
        this.f20456i = featureArr;
        this.f20457j = featureArr2;
        this.f20458k = z3;
        this.f20459l = i7;
        this.f20460m = z4;
        this.f20461n = str2;
    }

    @NonNull
    @KeepForSdk
    public Bundle getExtraArgs() {
        return this.f20454g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        zzm.a(this, parcel, i4);
    }

    @Nullable
    public final String zza() {
        return this.f20461n;
    }
}
