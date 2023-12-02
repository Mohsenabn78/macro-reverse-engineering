package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AccountChangeEventCreator")
/* loaded from: classes4.dex */
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f19600a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final long f19601b;
    @SafeParcelable.Field(id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f19602c;
    @SafeParcelable.Field(id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final int f19603d;
    @SafeParcelable.Field(id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int f19604e;
    @SafeParcelable.Field(id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f19605f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AccountChangeEvent(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) long j4, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) int i5, @SafeParcelable.Param(id = 5) int i6, @SafeParcelable.Param(id = 6) String str2) {
        this.f19600a = i4;
        this.f19601b = j4;
        this.f19602c = (String) Preconditions.checkNotNull(str);
        this.f19603d = i5;
        this.f19604e = i6;
        this.f19605f = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.f19600a == accountChangeEvent.f19600a && this.f19601b == accountChangeEvent.f19601b && Objects.equal(this.f19602c, accountChangeEvent.f19602c) && this.f19603d == accountChangeEvent.f19603d && this.f19604e == accountChangeEvent.f19604e && Objects.equal(this.f19605f, accountChangeEvent.f19605f)) {
                return true;
            }
        }
        return false;
    }

    public String getAccountName() {
        return this.f19602c;
    }

    public String getChangeData() {
        return this.f19605f;
    }

    public int getChangeType() {
        return this.f19603d;
    }

    public int getEventIndex() {
        return this.f19604e;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f19600a), Long.valueOf(this.f19601b), this.f19602c, Integer.valueOf(this.f19603d), Integer.valueOf(this.f19604e), this.f19605f);
    }

    public String toString() {
        String str;
        int i4 = this.f19603d;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        str = "UNKNOWN";
                    } else {
                        str = "RENAMED_TO";
                    }
                } else {
                    str = "RENAMED_FROM";
                }
            } else {
                str = "REMOVED";
            }
        } else {
            str = "ADDED";
        }
        String str2 = this.f19602c;
        String str3 = this.f19605f;
        int i5 = this.f19604e;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 91 + str.length() + String.valueOf(str3).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(str2);
        sb.append(", changeType = ");
        sb.append(str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(i5);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f19600a);
        SafeParcelWriter.writeLong(parcel, 2, this.f19601b);
        SafeParcelWriter.writeString(parcel, 3, this.f19602c, false);
        SafeParcelWriter.writeInt(parcel, 4, this.f19603d);
        SafeParcelWriter.writeInt(parcel, 5, this.f19604e);
        SafeParcelWriter.writeString(parcel, 6, this.f19605f, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AccountChangeEvent(long j4, String str, int i4, int i5, String str2) {
        this.f19600a = 1;
        this.f19601b = j4;
        this.f19602c = (String) Preconditions.checkNotNull(str);
        this.f19603d = i4;
        this.f19604e = i5;
        this.f19605f = str2;
    }
}
