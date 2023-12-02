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
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "SetDiagnosisKeysDataMappingParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzer extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzer> CREATOR = new zzes();
    @SafeParcelable.Field(getter = "getStatusCallbackAsBinder", id = 1, type = "android.os.IBinder")
    private IStatusCallback zza;
    @SafeParcelable.Field(getter = "getDiagnosisKeysDataMapping", id = 2)
    private DiagnosisKeysDataMapping zzb;

    private zzer() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzer) {
            zzer zzerVar = (zzer) obj;
            if (Objects.equal(this.zza, zzerVar.zza) && Objects.equal(this.zzb, zzerVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzer(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        this.zza = IStatusCallback.Stub.asInterface(iBinder);
        this.zzb = diagnosisKeysDataMapping;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzer(zzeq zzeqVar) {
    }
}
