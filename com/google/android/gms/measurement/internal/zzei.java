package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzei extends com.google.android.gms.internal.measurement.zzbn implements zzej {
    public zzei() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        switch (i4) {
            case 1:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzk((zzau) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzau.CREATOR), (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzt((zzlk) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzlk.CREATOR), (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzj((zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzl((zzau) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzau.CREATOR), readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzs((zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                boolean zzf = com.google.android.gms.internal.measurement.zzbo.zzf(parcel);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zze = zze((zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR), zzf);
                parcel2.writeNoException();
                parcel2.writeTypedList(zze);
                return true;
            case 9:
                String readString3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                byte[] zzu = zzu((zzau) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzau.CREATOR), readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zzu);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzq(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                String zzd = zzd((zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzd);
                return true;
            case 12:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzn((zzac) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzac.CREATOR), (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzo((zzac) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzac.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzh = zzh(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzbo.zzf(parcel), (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzh);
                return true;
            case 15:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                boolean zzf2 = com.google.android.gms.internal.measurement.zzbo.zzf(parcel);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzi = zzi(readString7, readString8, readString9, zzf2);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzi);
                return true;
            case 16:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzf3 = zzf(parcel.readString(), parcel.readString(), (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zzf3);
                return true;
            case 17:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzg = zzg(readString10, readString11, readString12);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzg);
                return true;
            case 18:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzm((zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 19:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzr((Bundle) com.google.android.gms.internal.measurement.zzbo.zza(parcel, Bundle.CREATOR), (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzp((zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
