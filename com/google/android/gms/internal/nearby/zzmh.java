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
@SafeParcelable.Class(creator = "RejectConnectionRequestParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmh> CREATOR = new zzmi();
    @Nullable
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzkk zza;
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 2)
    private String zzb;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 3)
    private final int zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 4)
    private com.google.android.gms.nearby.presence.zzi zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 5)
    private com.google.android.gms.nearby.connection.zzo zze;

    private zzmh() {
        this.zzc = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmh) {
            zzmh zzmhVar = (zzmh) obj;
            if (Objects.equal(this.zza, zzmhVar.zza) && Objects.equal(this.zzb, zzmhVar.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzmhVar.zzc)) && Objects.equal(this.zzd, zzmhVar.zzd) && Objects.equal(this.zze, zzmhVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkk zzkkVar = this.zza;
        if (zzkkVar == null) {
            asBinder = null;
        } else {
            asBinder = zzkkVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzmh(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i4, @Nullable @SafeParcelable.Param(id = 4) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 5) com.google.android.gms.nearby.connection.zzo zzoVar) {
        zzkk zzkiVar;
        if (iBinder == null) {
            zzkiVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzkiVar = queryLocalInterface instanceof zzkk ? (zzkk) queryLocalInterface : new zzki(iBinder);
        }
        this.zza = zzkiVar;
        this.zzb = str;
        this.zzc = i4;
        this.zzd = zziVar;
        this.zze = zzoVar;
    }
}
