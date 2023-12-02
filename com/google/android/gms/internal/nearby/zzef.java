package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ProvideDiagnosisKeysParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzef extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzef> CREATOR = new zzeg();
    @Nullable
    @SafeParcelable.Field(getter = "getKeys", id = 1)
    private List zza;
    @SafeParcelable.Field(getter = "getStatusCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private IStatusCallback zzb;
    @SafeParcelable.Field(getter = "getKeyFiles", id = 3)
    private List zzc;
    @SafeParcelable.Field(getter = "getExposureConfiguration", id = 4)
    private ExposureConfiguration zzd;
    @SafeParcelable.Field(getter = "getToken", id = 5)
    private String zze;
    @Nullable
    @SafeParcelable.Field(getter = "getDiagnosisKeyFileSupplierAsBinder", id = 6, type = "android.os.IBinder")
    private zzcv zzf;

    private zzef() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzef) {
            zzef zzefVar = (zzef) obj;
            if (Objects.equal(this.zza, zzefVar.zza) && Objects.equal(this.zzb, zzefVar.zzb) && Objects.equal(this.zzc, zzefVar.zzc) && Objects.equal(this.zzd, zzefVar.zzd) && Objects.equal(this.zze, zzefVar.zze) && Objects.equal(this.zzf, zzefVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i4, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        zzcv zzcvVar = this.zzf;
        if (zzcvVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcvVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, asBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzef(zzee zzeeVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzef(@Nullable @SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) List list2, @SafeParcelable.Param(id = 4) ExposureConfiguration exposureConfiguration, @SafeParcelable.Param(id = 5) String str, @Nullable @SafeParcelable.Param(id = 6) IBinder iBinder2) {
        zzcv zzctVar;
        IStatusCallback asInterface = IStatusCallback.Stub.asInterface(iBinder);
        if (iBinder2 == null) {
            zzctVar = null;
        } else {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
            zzctVar = queryLocalInterface instanceof zzcv ? (zzcv) queryLocalInterface : new zzct(iBinder2);
        }
        this.zza = list;
        this.zzb = asInterface;
        this.zzc = list2;
        this.zzd = exposureConfiguration;
        this.zze = str;
        this.zzf = zzctVar;
    }
}
