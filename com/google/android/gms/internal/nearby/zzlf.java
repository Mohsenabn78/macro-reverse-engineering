package com.google.android.gms.internal.nearby;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnEndpointFoundParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzlf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlf> CREATOR = new zzlg();
    @SafeParcelable.Field(getter = "getEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getServiceId", id = 2)
    private String zzb;
    @SafeParcelable.Field(getter = "getEndpointName", id = 3)
    private String zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getBluetoothDevice", id = 4)
    private BluetoothDevice zzd;
    @SafeParcelable.Field(getter = "getEndpointInfo", id = 5)
    private byte[] zze;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 6)
    private final int zzf;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 7)
    private com.google.android.gms.nearby.connection.zzo zzg;

    private zzlf() {
        this.zzf = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlf) {
            zzlf zzlfVar = (zzlf) obj;
            if (Objects.equal(this.zza, zzlfVar.zza) && Objects.equal(this.zzb, zzlfVar.zzb) && Objects.equal(this.zzc, zzlfVar.zzc) && Objects.equal(this.zzd, zzlfVar.zzd) && Arrays.equals(this.zze, zzlfVar.zze) && Objects.equal(Integer.valueOf(this.zzf), Integer.valueOf(zzlfVar.zzf)) && Objects.equal(this.zzg, zzlfVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(Arrays.hashCode(this.zze)), Integer.valueOf(this.zzf), this.zzg);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i4, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final BluetoothDevice zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final byte[] zze() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzlf(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) BluetoothDevice bluetoothDevice, @SafeParcelable.Param(id = 5) byte[] bArr, @SafeParcelable.Param(id = 6) int i4, @Nullable @SafeParcelable.Param(id = 7) com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bluetoothDevice;
        this.zze = bArr;
        this.zzf = i4;
        this.zzg = zzoVar;
    }
}
