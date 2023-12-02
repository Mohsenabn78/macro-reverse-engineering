package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
@SafeParcelable.Class(creator = "UserAddressCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class UserAddress extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<UserAddress> CREATOR = new zzb();
    @SafeParcelable.Field(id = 2)

    /* renamed from: a  reason: collision with root package name */
    String f20850a;
    @SafeParcelable.Field(id = 3)

    /* renamed from: b  reason: collision with root package name */
    String f20851b;
    @SafeParcelable.Field(id = 4)

    /* renamed from: c  reason: collision with root package name */
    String f20852c;
    @SafeParcelable.Field(id = 5)

    /* renamed from: d  reason: collision with root package name */
    String f20853d;
    @SafeParcelable.Field(id = 6)

    /* renamed from: e  reason: collision with root package name */
    String f20854e;
    @SafeParcelable.Field(id = 7)

    /* renamed from: f  reason: collision with root package name */
    String f20855f;
    @SafeParcelable.Field(id = 8)

    /* renamed from: g  reason: collision with root package name */
    String f20856g;
    @SafeParcelable.Field(id = 9)

    /* renamed from: h  reason: collision with root package name */
    String f20857h;
    @SafeParcelable.Field(id = 10)

    /* renamed from: i  reason: collision with root package name */
    String f20858i;
    @SafeParcelable.Field(id = 11)

    /* renamed from: j  reason: collision with root package name */
    String f20859j;
    @SafeParcelable.Field(id = 12)

    /* renamed from: k  reason: collision with root package name */
    String f20860k;
    @SafeParcelable.Field(id = 13)

    /* renamed from: l  reason: collision with root package name */
    String f20861l;
    @SafeParcelable.Field(id = 14)

    /* renamed from: m  reason: collision with root package name */
    boolean f20862m;
    @SafeParcelable.Field(id = 15)

    /* renamed from: n  reason: collision with root package name */
    String f20863n;
    @SafeParcelable.Field(id = 16)

    /* renamed from: o  reason: collision with root package name */
    String f20864o;

    UserAddress() {
    }

    @Nullable
    public static UserAddress fromIntent(@NonNull Intent intent) {
        if (intent != null && intent.hasExtra(AddressConstants.Extras.EXTRA_ADDRESS)) {
            return (UserAddress) intent.getParcelableExtra(AddressConstants.Extras.EXTRA_ADDRESS);
        }
        return null;
    }

    @NonNull
    public String getAddress1() {
        return this.f20851b;
    }

    @NonNull
    public String getAddress2() {
        return this.f20852c;
    }

    @NonNull
    public String getAddress3() {
        return this.f20853d;
    }

    @NonNull
    public String getAddress4() {
        return this.f20854e;
    }

    @NonNull
    public String getAddress5() {
        return this.f20855f;
    }

    @NonNull
    public String getAdministrativeArea() {
        return this.f20856g;
    }

    @NonNull
    public String getCompanyName() {
        return this.f20863n;
    }

    @NonNull
    public String getCountryCode() {
        return this.f20858i;
    }

    @NonNull
    public String getEmailAddress() {
        return this.f20864o;
    }

    @NonNull
    public String getLocality() {
        return this.f20857h;
    }

    @NonNull
    public String getName() {
        return this.f20850a;
    }

    @NonNull
    public String getPhoneNumber() {
        return this.f20861l;
    }

    @NonNull
    public String getPostalCode() {
        return this.f20859j;
    }

    @NonNull
    public String getSortingCode() {
        return this.f20860k;
    }

    public boolean isPostBox() {
        return this.f20862m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f20850a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f20851b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f20852c, false);
        SafeParcelWriter.writeString(parcel, 5, this.f20853d, false);
        SafeParcelWriter.writeString(parcel, 6, this.f20854e, false);
        SafeParcelWriter.writeString(parcel, 7, this.f20855f, false);
        SafeParcelWriter.writeString(parcel, 8, this.f20856g, false);
        SafeParcelWriter.writeString(parcel, 9, this.f20857h, false);
        SafeParcelWriter.writeString(parcel, 10, this.f20858i, false);
        SafeParcelWriter.writeString(parcel, 11, this.f20859j, false);
        SafeParcelWriter.writeString(parcel, 12, this.f20860k, false);
        SafeParcelWriter.writeString(parcel, 13, this.f20861l, false);
        SafeParcelWriter.writeBoolean(parcel, 14, this.f20862m);
        SafeParcelWriter.writeString(parcel, 15, this.f20863n, false);
        SafeParcelWriter.writeString(parcel, 16, this.f20864o, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public UserAddress(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7, @SafeParcelable.Param(id = 9) String str8, @SafeParcelable.Param(id = 10) String str9, @SafeParcelable.Param(id = 11) String str10, @SafeParcelable.Param(id = 12) String str11, @SafeParcelable.Param(id = 13) String str12, @SafeParcelable.Param(id = 14) boolean z3, @SafeParcelable.Param(id = 15) String str13, @SafeParcelable.Param(id = 16) String str14) {
        this.f20850a = str;
        this.f20851b = str2;
        this.f20852c = str3;
        this.f20853d = str4;
        this.f20854e = str5;
        this.f20855f = str6;
        this.f20856g = str7;
        this.f20857h = str8;
        this.f20858i = str9;
        this.f20859j = str10;
        this.f20860k = str11;
        this.f20861l = str12;
        this.f20862m = z3;
        this.f20863n = str13;
        this.f20864o = str14;
    }
}
