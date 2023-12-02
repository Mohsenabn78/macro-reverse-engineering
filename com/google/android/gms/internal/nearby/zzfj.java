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
@SafeParcelable.Class(creator = "AcceptConnectionRequestParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzfj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfj> CREATOR = new zzfk();
    @Nullable
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzkk zza;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionEventListenerAsBinder", id = 2, type = "android.os.IBinder")
    private zzjt zzb;
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 3)
    private String zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getHandshakeData", id = 4)
    private byte[] zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getPayloadListenerAsBinder", id = 5, type = "android.os.IBinder")
    private zzkh zze;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 6)
    private final int zzf;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 7)
    private com.google.android.gms.nearby.presence.zzi zzg;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 8)
    private com.google.android.gms.nearby.connection.zzo zzh;

    private zzfj() {
        this.zzf = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfj) {
            zzfj zzfjVar = (zzfj) obj;
            if (Objects.equal(this.zza, zzfjVar.zza) && Objects.equal(this.zzb, zzfjVar.zzb) && Objects.equal(this.zzc, zzfjVar.zzc) && Arrays.equals(this.zzd, zzfjVar.zzd) && Objects.equal(this.zze, zzfjVar.zze) && Objects.equal(Integer.valueOf(this.zzf), Integer.valueOf(zzfjVar.zzf)) && Objects.equal(this.zzg, zzfjVar.zzg) && Objects.equal(this.zzh, zzfjVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Integer.valueOf(Arrays.hashCode(this.zzd)), this.zze, Integer.valueOf(this.zzf), this.zzg, this.zzh);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        IBinder asBinder2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkk zzkkVar = this.zza;
        IBinder iBinder = null;
        if (zzkkVar == null) {
            asBinder = null;
        } else {
            asBinder = zzkkVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        zzjt zzjtVar = this.zzb;
        if (zzjtVar == null) {
            asBinder2 = null;
        } else {
            asBinder2 = zzjtVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        zzkh zzkhVar = this.zze;
        if (zzkhVar != null) {
            iBinder = zzkhVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, iBinder, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzfj(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder2, @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 4) byte[] bArr, @Nullable @SafeParcelable.Param(id = 5) IBinder iBinder3, @SafeParcelable.Param(id = 6) int i4, @Nullable @SafeParcelable.Param(id = 7) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 8) com.google.android.gms.nearby.connection.zzo zzoVar) {
        zzkk zzkiVar;
        zzjt zzjrVar;
        zzkh zzkhVar = null;
        if (iBinder == null) {
            zzkiVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzkiVar = queryLocalInterface instanceof zzkk ? (zzkk) queryLocalInterface : new zzki(iBinder);
        }
        if (iBinder2 == null) {
            zzjrVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            zzjrVar = queryLocalInterface2 instanceof zzjt ? (zzjt) queryLocalInterface2 : new zzjr(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IPayloadListener");
            zzkhVar = queryLocalInterface3 instanceof zzkh ? (zzkh) queryLocalInterface3 : new zzkf(iBinder3);
        }
        this.zza = zzkiVar;
        this.zzb = zzjrVar;
        this.zzc = str;
        this.zzd = bArr;
        this.zze = zzkhVar;
        this.zzf = i4;
        this.zzg = zziVar;
        this.zzh = zzoVar;
    }
}
