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
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "StartAdvertisingParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmt> CREATOR = new zzmu();
    @Nullable
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzkn zza;
    @Nullable
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private zzjq zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getName", id = 3)
    private String zzc;
    @SafeParcelable.Field(getter = "getServiceId", id = 4)
    private String zzd;
    @SafeParcelable.Field(getter = "getDurationMillis", id = 5)
    private long zze;
    @SafeParcelable.Field(getter = "getOptions", id = 6)
    private AdvertisingOptions zzf;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionLifecycleListenerAsBinder", id = 7, type = "android.os.IBinder")
    private zzjw zzg;
    @Nullable
    @SafeParcelable.Field(getter = "getEndpointInfo", id = 8)
    private byte[] zzh;

    private zzmt() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmt) {
            zzmt zzmtVar = (zzmt) obj;
            if (Objects.equal(this.zza, zzmtVar.zza) && Objects.equal(this.zzb, zzmtVar.zzb) && Objects.equal(this.zzc, zzmtVar.zzc) && Objects.equal(this.zzd, zzmtVar.zzd) && Objects.equal(Long.valueOf(this.zze), Long.valueOf(zzmtVar.zze)) && Objects.equal(this.zzf, zzmtVar.zzf) && Objects.equal(this.zzg, zzmtVar.zzg) && Arrays.equals(this.zzh, zzmtVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Long.valueOf(this.zze), this.zzf, this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        IBinder asBinder2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkn zzknVar = this.zza;
        IBinder iBinder = null;
        if (zzknVar == null) {
            asBinder = null;
        } else {
            asBinder = zzknVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        zzjq zzjqVar = this.zzb;
        if (zzjqVar == null) {
            asBinder2 = null;
        } else {
            asBinder2 = zzjqVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i4, false);
        zzjw zzjwVar = this.zzg;
        if (zzjwVar != null) {
            iBinder = zzjwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 7, iBinder, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzmt(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder2, @Nullable @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) long j4, @SafeParcelable.Param(id = 6) AdvertisingOptions advertisingOptions, @Nullable @SafeParcelable.Param(id = 7) IBinder iBinder3, @Nullable @SafeParcelable.Param(id = 8) byte[] bArr) {
        zzkn zzklVar;
        zzjq zzjoVar;
        zzjw zzjwVar = null;
        if (iBinder == null) {
            zzklVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
            zzklVar = queryLocalInterface instanceof zzkn ? (zzkn) queryLocalInterface : new zzkl(iBinder);
        }
        if (iBinder2 == null) {
            zzjoVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
            zzjoVar = queryLocalInterface2 instanceof zzjq ? (zzjq) queryLocalInterface2 : new zzjo(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzjwVar = queryLocalInterface3 instanceof zzjw ? (zzjw) queryLocalInterface3 : new zzju(iBinder3);
        }
        this.zza = zzklVar;
        this.zzb = zzjoVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = j4;
        this.zzf = advertisingOptions;
        this.zzg = zzjwVar;
        this.zzh = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmt(zzms zzmsVar) {
    }
}
