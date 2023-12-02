package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DeviceMetaDataCreator")
/* loaded from: classes4.dex */
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzv();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f19645a;
    @SafeParcelable.Field(getter = "isLockScreenSolved", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private boolean f19646b;
    @SafeParcelable.Field(getter = "getMinAgeOfLockScreen", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private long f19647c;
    @SafeParcelable.Field(getter = "isChallengeAllowed", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f19648d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DeviceMetaData(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) boolean z3, @SafeParcelable.Param(id = 3) long j4, @SafeParcelable.Param(id = 4) boolean z4) {
        this.f19645a = i4;
        this.f19646b = z3;
        this.f19647c = j4;
        this.f19648d = z4;
    }

    public long getMinAgeOfLockScreen() {
        return this.f19647c;
    }

    public boolean isChallengeAllowed() {
        return this.f19648d;
    }

    public boolean isLockScreenSolved() {
        return this.f19646b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f19645a);
        SafeParcelWriter.writeBoolean(parcel, 2, isLockScreenSolved());
        SafeParcelWriter.writeLong(parcel, 3, getMinAgeOfLockScreen());
        SafeParcelWriter.writeBoolean(parcel, 4, isChallengeAllowed());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
