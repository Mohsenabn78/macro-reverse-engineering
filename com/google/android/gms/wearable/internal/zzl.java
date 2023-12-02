package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "AncsNotificationParcelableCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzl extends AbstractSafeParcelable implements com.google.android.gms.wearable.zzb {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getId", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final int f22847a;
    @SafeParcelable.Field(getter = "getAppId", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final String f22848b;
    @Nullable
    @SafeParcelable.Field(getter = "getDateTime", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final String f22849c;
    @SafeParcelable.Field(getter = "getNotificationText", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private final String f22850d;
    @SafeParcelable.Field(getter = "getTitle", id = 6)

    /* renamed from: e  reason: collision with root package name */
    private final String f22851e;
    @SafeParcelable.Field(getter = "getSubtitle", id = 7)

    /* renamed from: f  reason: collision with root package name */
    private final String f22852f;
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 8)

    /* renamed from: g  reason: collision with root package name */
    private final String f22853g;
    @SafeParcelable.Field(getter = "getEventId", id = 9)

    /* renamed from: h  reason: collision with root package name */
    private final byte f22854h;
    @SafeParcelable.Field(getter = "getEventFlags", id = 10)

    /* renamed from: i  reason: collision with root package name */
    private final byte f22855i;
    @SafeParcelable.Field(getter = "getCategoryId", id = 11)

    /* renamed from: j  reason: collision with root package name */
    private final byte f22856j;
    @SafeParcelable.Field(getter = "getCategoryCount", id = 12)

    /* renamed from: k  reason: collision with root package name */
    private final byte f22857k;
    @Nullable
    @SafeParcelable.Field(getter = "getPackageName", id = 13)

    /* renamed from: l  reason: collision with root package name */
    private final String f22858l;

    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) @Nullable String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) @Nullable String str6, @SafeParcelable.Param(id = 9) byte b4, @SafeParcelable.Param(id = 10) byte b5, @SafeParcelable.Param(id = 11) byte b6, @SafeParcelable.Param(id = 12) byte b7, @SafeParcelable.Param(id = 13) @Nullable String str7) {
        this.f22847a = i4;
        this.f22848b = str;
        this.f22849c = str2;
        this.f22850d = str3;
        this.f22851e = str4;
        this.f22852f = str5;
        this.f22853g = str6;
        this.f22854h = b4;
        this.f22855i = b5;
        this.f22856j = b6;
        this.f22857k = b7;
        this.f22858l = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzl.class != obj.getClass()) {
            return false;
        }
        zzl zzlVar = (zzl) obj;
        if (this.f22847a != zzlVar.f22847a || this.f22854h != zzlVar.f22854h || this.f22855i != zzlVar.f22855i || this.f22856j != zzlVar.f22856j || this.f22857k != zzlVar.f22857k || !this.f22848b.equals(zzlVar.f22848b)) {
            return false;
        }
        String str = this.f22849c;
        if (str == null ? zzlVar.f22849c != null : !str.equals(zzlVar.f22849c)) {
            return false;
        }
        if (!this.f22850d.equals(zzlVar.f22850d) || !this.f22851e.equals(zzlVar.f22851e) || !this.f22852f.equals(zzlVar.f22852f)) {
            return false;
        }
        String str2 = this.f22853g;
        if (str2 == null ? zzlVar.f22853g != null : !str2.equals(zzlVar.f22853g)) {
            return false;
        }
        String str3 = this.f22858l;
        if (str3 != null) {
            return str3.equals(zzlVar.f22858l);
        }
        if (zzlVar.f22858l == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5;
        int hashCode = (((this.f22847a + 31) * 31) + this.f22848b.hashCode()) * 31;
        String str = this.f22849c;
        int i6 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int hashCode2 = (((((((hashCode + i4) * 31) + this.f22850d.hashCode()) * 31) + this.f22851e.hashCode()) * 31) + this.f22852f.hashCode()) * 31;
        String str2 = this.f22853g;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i7 = (((((((((hashCode2 + i5) * 31) + this.f22854h) * 31) + this.f22855i) * 31) + this.f22856j) * 31) + this.f22857k) * 31;
        String str3 = this.f22858l;
        if (str3 != null) {
            i6 = str3.hashCode();
        }
        return i7 + i6;
    }

    public final String toString() {
        int i4 = this.f22847a;
        String str = this.f22848b;
        String str2 = this.f22849c;
        byte b4 = this.f22854h;
        byte b5 = this.f22855i;
        byte b6 = this.f22856j;
        byte b7 = this.f22857k;
        String str3 = this.f22858l;
        return "AncsNotificationParcelable{, id=" + i4 + ", appId='" + str + "', dateTime='" + str2 + "', eventId=" + ((int) b4) + ", eventFlags=" + ((int) b5) + ", categoryId=" + ((int) b6) + ", categoryCount=" + ((int) b7) + ", packageName='" + str3 + "'}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f22847a);
        SafeParcelWriter.writeString(parcel, 3, this.f22848b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22849c, false);
        SafeParcelWriter.writeString(parcel, 5, this.f22850d, false);
        SafeParcelWriter.writeString(parcel, 6, this.f22851e, false);
        SafeParcelWriter.writeString(parcel, 7, this.f22852f, false);
        String str = this.f22853g;
        if (str == null) {
            str = this.f22848b;
        }
        SafeParcelWriter.writeString(parcel, 8, str, false);
        SafeParcelWriter.writeByte(parcel, 9, this.f22854h);
        SafeParcelWriter.writeByte(parcel, 10, this.f22855i);
        SafeParcelWriter.writeByte(parcel, 11, this.f22856j);
        SafeParcelWriter.writeByte(parcel, 12, this.f22857k);
        SafeParcelWriter.writeString(parcel, 13, this.f22858l, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
