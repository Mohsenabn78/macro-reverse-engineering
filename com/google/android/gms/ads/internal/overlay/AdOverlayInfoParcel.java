package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhe;
import com.google.android.gms.internal.ads.zzbrm;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcvt;
import com.google.android.gms.internal.ads.zzdcu;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    @SafeParcelable.Field(id = 2)
    public final zzc zza;
    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", id = 3, type = "android.os.IBinder")
    public final com.google.android.gms.ads.internal.client.zza zzb;
    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", id = 4, type = "android.os.IBinder")
    public final zzo zzc;
    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", id = 5, type = "android.os.IBinder")
    public final zzcez zzd;
    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", id = 6, type = "android.os.IBinder")
    public final zzbhe zze;
    @NonNull
    @SafeParcelable.Field(id = 7)
    public final String zzf;
    @SafeParcelable.Field(id = 8)
    public final boolean zzg;
    @NonNull
    @SafeParcelable.Field(id = 9)
    public final String zzh;
    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", id = 10, type = "android.os.IBinder")
    public final zzz zzi;
    @SafeParcelable.Field(id = 11)
    public final int zzj;
    @SafeParcelable.Field(id = 12)
    public final int zzk;
    @NonNull
    @SafeParcelable.Field(id = 13)
    public final String zzl;
    @SafeParcelable.Field(id = 14)
    public final zzbzx zzm;
    @NonNull
    @SafeParcelable.Field(id = 16)
    public final String zzn;
    @SafeParcelable.Field(id = 17)
    public final com.google.android.gms.ads.internal.zzj zzo;
    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", id = 18, type = "android.os.IBinder")
    public final zzbhc zzp;
    @NonNull
    @SafeParcelable.Field(id = 19)
    public final String zzq;
    @SafeParcelable.Field(getter = "getWorkManagerUtilAsBinder", id = 23, type = "android.os.IBinder")
    public final zzbr zzr;
    @NonNull
    @SafeParcelable.Field(id = 24)
    public final String zzs;
    @NonNull
    @SafeParcelable.Field(id = 25)
    public final String zzt;
    @SafeParcelable.Field(getter = "getAdFailedToShowEventEmitterAsBinder", id = 26, type = "android.os.IBinder")
    public final zzcvt zzu;
    @SafeParcelable.Field(getter = "getPhysicalClickListenerAsBinder", id = 27, type = "android.os.IBinder")
    public final zzdcu zzv;
    @SafeParcelable.Field(getter = "getOfflineUtilsAsBinder", id = 28, type = "android.os.IBinder")
    public final zzbrm zzw;

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzo zzoVar, zzbhc zzbhcVar, zzbhe zzbheVar, zzz zzzVar, zzcez zzcezVar, boolean z3, int i4, String str, zzbzx zzbzxVar, zzdcu zzdcuVar, zzbrm zzbrmVar) {
        this.zza = null;
        this.zzb = zzaVar;
        this.zzc = zzoVar;
        this.zzd = zzcezVar;
        this.zzp = zzbhcVar;
        this.zze = zzbheVar;
        this.zzf = null;
        this.zzg = z3;
        this.zzh = null;
        this.zzi = zzzVar;
        this.zzj = i4;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = zzbzxVar;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzdcuVar;
        this.zzw = zzbrmVar;
    }

    @Nullable
    public static AdOverlayInfoParcel zza(@NonNull Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i4, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzb).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzc).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzd).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zze).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzi).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i4, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i4, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeIBinder(parcel, 23, ObjectWrapper.wrap(this.zzr).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 24, this.zzs, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzt, false);
        SafeParcelWriter.writeIBinder(parcel, 26, ObjectWrapper.wrap(this.zzu).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 27, ObjectWrapper.wrap(this.zzv).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 28, ObjectWrapper.wrap(this.zzw).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzo zzoVar, zzbhc zzbhcVar, zzbhe zzbheVar, zzz zzzVar, zzcez zzcezVar, boolean z3, int i4, String str, String str2, zzbzx zzbzxVar, zzdcu zzdcuVar, zzbrm zzbrmVar) {
        this.zza = null;
        this.zzb = zzaVar;
        this.zzc = zzoVar;
        this.zzd = zzcezVar;
        this.zzp = zzbhcVar;
        this.zze = zzbheVar;
        this.zzf = str2;
        this.zzg = z3;
        this.zzh = str;
        this.zzi = zzzVar;
        this.zzj = i4;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = zzbzxVar;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzdcuVar;
        this.zzw = zzbrmVar;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzo zzoVar, zzz zzzVar, zzcez zzcezVar, int i4, zzbzx zzbzxVar, String str, com.google.android.gms.ads.internal.zzj zzjVar, String str2, String str3, String str4, zzcvt zzcvtVar, zzbrm zzbrmVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzoVar;
        this.zzd = zzcezVar;
        this.zzp = null;
        this.zze = null;
        this.zzg = false;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzaF)).booleanValue()) {
            this.zzf = null;
            this.zzh = null;
        } else {
            this.zzf = str2;
            this.zzh = str3;
        }
        this.zzi = null;
        this.zzj = i4;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = zzbzxVar;
        this.zzn = str;
        this.zzo = zzjVar;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = str4;
        this.zzu = zzcvtVar;
        this.zzv = null;
        this.zzw = zzbrmVar;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzo zzoVar, zzz zzzVar, zzcez zzcezVar, boolean z3, int i4, zzbzx zzbzxVar, zzdcu zzdcuVar, zzbrm zzbrmVar) {
        this.zza = null;
        this.zzb = zzaVar;
        this.zzc = zzoVar;
        this.zzd = zzcezVar;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z3;
        this.zzh = null;
        this.zzi = zzzVar;
        this.zzj = i4;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = zzbzxVar;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzdcuVar;
        this.zzw = zzbrmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AdOverlayInfoParcel(@SafeParcelable.Param(id = 2) zzc zzcVar, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2, @SafeParcelable.Param(id = 5) IBinder iBinder3, @SafeParcelable.Param(id = 6) IBinder iBinder4, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) boolean z3, @SafeParcelable.Param(id = 9) String str2, @SafeParcelable.Param(id = 10) IBinder iBinder5, @SafeParcelable.Param(id = 11) int i4, @SafeParcelable.Param(id = 12) int i5, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) zzbzx zzbzxVar, @SafeParcelable.Param(id = 16) String str4, @SafeParcelable.Param(id = 17) com.google.android.gms.ads.internal.zzj zzjVar, @SafeParcelable.Param(id = 18) IBinder iBinder6, @SafeParcelable.Param(id = 19) String str5, @SafeParcelable.Param(id = 23) IBinder iBinder7, @SafeParcelable.Param(id = 24) String str6, @SafeParcelable.Param(id = 25) String str7, @SafeParcelable.Param(id = 26) IBinder iBinder8, @SafeParcelable.Param(id = 27) IBinder iBinder9, @SafeParcelable.Param(id = 28) IBinder iBinder10) {
        this.zza = zzcVar;
        this.zzb = (com.google.android.gms.ads.internal.client.zza) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzc = (zzo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzd = (zzcez) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzp = (zzbhc) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zze = (zzbhe) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzf = str;
        this.zzg = z3;
        this.zzh = str2;
        this.zzi = (zzz) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.zzj = i4;
        this.zzk = i5;
        this.zzl = str3;
        this.zzm = zzbzxVar;
        this.zzn = str4;
        this.zzo = zzjVar;
        this.zzq = str5;
        this.zzs = str6;
        this.zzr = (zzbr) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzt = str7;
        this.zzu = (zzcvt) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzv = (zzdcu) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
        this.zzw = (zzbrm) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder10));
    }

    public AdOverlayInfoParcel(zzc zzcVar, com.google.android.gms.ads.internal.client.zza zzaVar, zzo zzoVar, zzz zzzVar, zzbzx zzbzxVar, zzcez zzcezVar, zzdcu zzdcuVar) {
        this.zza = zzcVar;
        this.zzb = zzaVar;
        this.zzc = zzoVar;
        this.zzd = zzcezVar;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzzVar;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = zzbzxVar;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzdcuVar;
        this.zzw = null;
    }

    public AdOverlayInfoParcel(zzo zzoVar, zzcez zzcezVar, int i4, zzbzx zzbzxVar) {
        this.zzc = zzoVar;
        this.zzd = zzcezVar;
        this.zzj = 1;
        this.zzm = zzbzxVar;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzs = null;
        this.zzr = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = null;
    }

    public AdOverlayInfoParcel(zzcez zzcezVar, zzbzx zzbzxVar, zzbr zzbrVar, String str, String str2, int i4, zzbrm zzbrmVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcezVar;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = 14;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = zzbzxVar;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzs = str2;
        this.zzr = zzbrVar;
        this.zzt = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = zzbrmVar;
    }
}
