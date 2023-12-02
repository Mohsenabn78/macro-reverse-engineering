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
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "SendPayloadParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmp> CREATOR = new zzmq();
    @Nullable
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzkk zza;
    @SafeParcelable.Field(getter = "getRemoteEndpointIds", id = 2)
    private String[] zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getPayload", id = 3)
    private zzmc zzc;
    @SafeParcelable.Field(getter = "getSendReliably", id = 4)
    private boolean zzd;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 5)
    private final int zze;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 6)
    private com.google.android.gms.nearby.presence.zzi zzf;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 7)
    private com.google.android.gms.nearby.connection.zzo zzg;

    private zzmp() {
        this.zze = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmp) {
            zzmp zzmpVar = (zzmp) obj;
            if (Objects.equal(this.zza, zzmpVar.zza) && Arrays.equals(this.zzb, zzmpVar.zzb) && Objects.equal(this.zzc, zzmpVar.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzmpVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzmpVar.zze)) && Objects.equal(this.zzf, zzmpVar.zzf) && Objects.equal(this.zzg, zzmpVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(Arrays.hashCode(this.zzb)), this.zzc, Boolean.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf, this.zzg);
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
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzmp(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) String[] strArr, @Nullable @SafeParcelable.Param(id = 3) zzmc zzmcVar, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) int i4, @Nullable @SafeParcelable.Param(id = 6) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 7) com.google.android.gms.nearby.connection.zzo zzoVar) {
        zzkk zzkiVar;
        if (iBinder == null) {
            zzkiVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzkiVar = queryLocalInterface instanceof zzkk ? (zzkk) queryLocalInterface : new zzki(iBinder);
        }
        this.zza = zzkiVar;
        this.zzb = strArr;
        this.zzc = zzmcVar;
        this.zzd = z3;
        this.zze = i4;
        this.zzf = zziVar;
        this.zzg = zzoVar;
    }
}
