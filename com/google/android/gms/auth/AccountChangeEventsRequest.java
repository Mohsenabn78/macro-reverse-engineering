package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AccountChangeEventsRequestCreator")
/* loaded from: classes4.dex */
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f19606a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private int f19607b;
    @SafeParcelable.Field(id = 3)
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private String f19608c;
    @SafeParcelable.Field(id = 4)

    /* renamed from: d  reason: collision with root package name */
    private Account f19609d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AccountChangeEventsRequest(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) Account account) {
        this.f19606a = i4;
        this.f19607b = i5;
        this.f19608c = str;
        if (account == null && !TextUtils.isEmpty(str)) {
            this.f19609d = new Account(str, "com.google");
        } else {
            this.f19609d = account;
        }
    }

    public Account getAccount() {
        return this.f19609d;
    }

    @Deprecated
    public String getAccountName() {
        return this.f19608c;
    }

    public int getEventIndex() {
        return this.f19607b;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.f19609d = account;
        return this;
    }

    @Deprecated
    public AccountChangeEventsRequest setAccountName(String str) {
        this.f19608c = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i4) {
        this.f19607b = i4;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f19606a);
        SafeParcelWriter.writeInt(parcel, 2, this.f19607b);
        SafeParcelWriter.writeString(parcel, 3, this.f19608c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f19609d, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AccountChangeEventsRequest() {
        this.f19606a = 1;
    }
}
