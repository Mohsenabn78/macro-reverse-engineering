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
import com.google.android.gms.nearby.connection.ConnectionOptions;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "SendConnectionRequestParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzml extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzml> CREATOR = new zzmm();
    @Nullable
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzkk zza;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionEventListenerAsBinder", id = 2, type = "android.os.IBinder")
    private zzjt zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionResponseListenerAsBinder", id = 3, type = "android.os.IBinder")
    private zzjz zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getName", id = 4)
    private String zzd;
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 5)
    private String zze;
    @Nullable
    @SafeParcelable.Field(getter = "getHandshakeData", id = 6)
    private byte[] zzf;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionLifecycleListenerAsBinder", id = 7, type = "android.os.IBinder")
    private zzjw zzg;
    @Nullable
    @SafeParcelable.Field(getter = "getEndpointInfo", id = 8)
    private byte[] zzh;
    @Nullable
    @SafeParcelable.Field(getter = "getOptions", id = 9)
    private ConnectionOptions zzi;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 10)
    private final int zzj;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 11)
    private com.google.android.gms.nearby.presence.zzi zzk;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 14)
    private com.google.android.gms.nearby.connection.zzo zzl;
    @Nullable
    @SafeParcelable.Field(getter = "getLocalDeviceInfo", id = 12)
    private byte[] zzm;
    @Nullable
    @SafeParcelable.Field(getter = "getServiceId", id = 13)
    private String zzn;

    private zzml() {
        this.zzj = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzml) {
            zzml zzmlVar = (zzml) obj;
            if (Objects.equal(this.zza, zzmlVar.zza) && Objects.equal(this.zzb, zzmlVar.zzb) && Objects.equal(this.zzc, zzmlVar.zzc) && Objects.equal(this.zzd, zzmlVar.zzd) && Objects.equal(this.zze, zzmlVar.zze) && Arrays.equals(this.zzf, zzmlVar.zzf) && Objects.equal(this.zzg, zzmlVar.zzg) && Arrays.equals(this.zzh, zzmlVar.zzh) && Objects.equal(this.zzi, zzmlVar.zzi) && Objects.equal(Integer.valueOf(this.zzj), Integer.valueOf(zzmlVar.zzj)) && Objects.equal(this.zzk, zzmlVar.zzk) && Objects.equal(this.zzl, zzmlVar.zzl) && Arrays.equals(this.zzm, zzmlVar.zzm) && Objects.equal(this.zzn, zzmlVar.zzn)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, Integer.valueOf(Arrays.hashCode(this.zzf)), this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi, Integer.valueOf(this.zzj), this.zzk, this.zzl, Integer.valueOf(Arrays.hashCode(this.zzm)), this.zzn);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        IBinder asBinder2;
        IBinder asBinder3;
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
        zzjz zzjzVar = this.zzc;
        if (zzjzVar == null) {
            asBinder3 = null;
        } else {
            asBinder3 = zzjzVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder3, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        zzjw zzjwVar = this.zzg;
        if (zzjwVar != null) {
            iBinder = zzjwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 7, iBinder, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i4, false);
        SafeParcelWriter.writeInt(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i4, false);
        SafeParcelWriter.writeByteArray(parcel, 12, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzl, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzml(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder2, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder3, @Nullable @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) String str2, @Nullable @SafeParcelable.Param(id = 6) byte[] bArr, @Nullable @SafeParcelable.Param(id = 7) IBinder iBinder4, @Nullable @SafeParcelable.Param(id = 8) byte[] bArr2, @Nullable @SafeParcelable.Param(id = 9) ConnectionOptions connectionOptions, @SafeParcelable.Param(id = 10) int i4, @Nullable @SafeParcelable.Param(id = 11) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 14) com.google.android.gms.nearby.connection.zzo zzoVar, @Nullable @SafeParcelable.Param(id = 12) byte[] bArr3, @Nullable @SafeParcelable.Param(id = 13) String str3) {
        zzkk zzkiVar;
        zzjt zzjrVar;
        zzjz zzjxVar;
        zzjw zzjwVar = null;
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
        if (iBinder3 == null) {
            zzjxVar = null;
        } else {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
            zzjxVar = queryLocalInterface3 instanceof zzjz ? (zzjz) queryLocalInterface3 : new zzjx(iBinder3);
        }
        if (iBinder4 != null) {
            IInterface queryLocalInterface4 = iBinder4.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzjwVar = queryLocalInterface4 instanceof zzjw ? (zzjw) queryLocalInterface4 : new zzju(iBinder4);
        }
        this.zza = zzkiVar;
        this.zzb = zzjrVar;
        this.zzc = zzjxVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bArr;
        this.zzg = zzjwVar;
        this.zzh = bArr2;
        this.zzi = connectionOptions;
        this.zzj = i4;
        this.zzk = zziVar;
        this.zzl = zzoVar;
        this.zzm = bArr3;
        this.zzn = str3;
    }
}
