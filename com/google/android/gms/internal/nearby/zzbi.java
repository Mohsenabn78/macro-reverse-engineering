package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "GetDiagnosisKeysDataMappingParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzbi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbi> CREATOR = new zzbj();
    @SafeParcelable.Field(getter = "getDiagnosisKeysDataMappingCallbackAsBinder", id = 1, type = "android.os.IBinder")
    private zzcy zza;

    private zzbi() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbi) {
            return Objects.equal(this.zza, ((zzbi) obj).zza);
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
    public zzbi(@SafeParcelable.Param(id = 1) IBinder iBinder) {
        zzcy zzcwVar;
        if (iBinder == null) {
            zzcwVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
            zzcwVar = queryLocalInterface instanceof zzcy ? (zzcy) queryLocalInterface : new zzcw(iBinder);
        }
        this.zza = zzcwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbi(zzbh zzbhVar) {
    }
}
