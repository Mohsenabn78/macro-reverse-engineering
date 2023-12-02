package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "RequestPreAuthorizedTemporaryExposureKeyReleaseParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzen extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzen> CREATOR = new zzeo();
    @SafeParcelable.Field(getter = "getStatusCallbackAsBinder", id = 1, type = "android.os.IBinder")
    private IStatusCallback zza;

    private zzen() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzen) {
            return Objects.equal(this.zza, ((zzen) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzen(@SafeParcelable.Param(id = 1) IBinder iBinder) {
        this.zza = IStatusCallback.Stub.asInterface(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzen(zzem zzemVar) {
    }
}
