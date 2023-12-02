package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "ResolveAccountRequestCreator")
/* loaded from: classes4.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new zau();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20533a;
    @SafeParcelable.Field(getter = "getAccount", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final Account f20534b;
    @SafeParcelable.Field(getter = "getSessionId", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f20535c;
    @Nullable
    @SafeParcelable.Field(getter = "getSignInAccountHint", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final GoogleSignInAccount f20536d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zat(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) Account account, @SafeParcelable.Param(id = 3) int i5, @Nullable @SafeParcelable.Param(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.f20533a = i4;
        this.f20534b = account;
        this.f20535c = i5;
        this.f20536d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20533a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f20534b, i4, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f20535c);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f20536d, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zat(Account account, int i4, @Nullable GoogleSignInAccount googleSignInAccount) {
        this(2, account, i4, googleSignInAccount);
    }
}
