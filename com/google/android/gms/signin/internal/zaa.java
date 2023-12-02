package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "AuthAccountResultCreator")
/* loaded from: classes4.dex */
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22583a;
    @SafeParcelable.Field(getter = "getConnectionResultCode", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private int f22584b;
    @Nullable
    @SafeParcelable.Field(getter = "getRawAuthResolutionIntent", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private Intent f22585c;

    public zaa() {
        this(2, 0, null);
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        if (this.f22584b == 0) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22583a);
        SafeParcelWriter.writeInt(parcel, 2, this.f22584b);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f22585c, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zaa(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @Nullable @SafeParcelable.Param(id = 3) Intent intent) {
        this.f22583a = i4;
        this.f22584b = i5;
        this.f22585c = intent;
    }
}
