package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbtp extends zzatr implements zzbtq {
    public zzbtp() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzatr
    protected final boolean zzbE(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        zzbua zzbuaVar = null;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 != 5) {
                        if (i4 != 6) {
                            if (i4 != 7) {
                                return false;
                            }
                            String readString = parcel.readString();
                            IBinder readStrongBinder = parcel.readStrongBinder();
                            if (readStrongBinder != null) {
                                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                                if (queryLocalInterface instanceof zzbua) {
                                    zzbuaVar = (zzbua) queryLocalInterface;
                                } else {
                                    zzbuaVar = new zzbty(readStrongBinder);
                                }
                            }
                            zzats.zzc(parcel);
                            zzh(readString, zzbuaVar);
                            parcel2.writeNoException();
                        } else {
                            zzbue zzbueVar = (zzbue) zzats.zza(parcel, zzbue.CREATOR);
                            IBinder readStrongBinder2 = parcel.readStrongBinder();
                            if (readStrongBinder2 != null) {
                                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                                if (queryLocalInterface2 instanceof zzbua) {
                                    zzbuaVar = (zzbua) queryLocalInterface2;
                                } else {
                                    zzbuaVar = new zzbty(readStrongBinder2);
                                }
                            }
                            zzats.zzc(parcel);
                            zze(zzbueVar, zzbuaVar);
                            parcel2.writeNoException();
                        }
                    } else {
                        zzbue zzbueVar2 = (zzbue) zzats.zza(parcel, zzbue.CREATOR);
                        IBinder readStrongBinder3 = parcel.readStrongBinder();
                        if (readStrongBinder3 != null) {
                            IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                            if (queryLocalInterface3 instanceof zzbua) {
                                zzbuaVar = (zzbua) queryLocalInterface3;
                            } else {
                                zzbuaVar = new zzbty(readStrongBinder3);
                            }
                        }
                        zzats.zzc(parcel);
                        zzf(zzbueVar2, zzbuaVar);
                        parcel2.writeNoException();
                    }
                } else {
                    zzbue zzbueVar3 = (zzbue) zzats.zza(parcel, zzbue.CREATOR);
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 != null) {
                        IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                        if (queryLocalInterface4 instanceof zzbua) {
                            zzbuaVar = (zzbua) queryLocalInterface4;
                        } else {
                            zzbuaVar = new zzbty(readStrongBinder4);
                        }
                    }
                    zzats.zzc(parcel);
                    zzg(zzbueVar3, zzbuaVar);
                    parcel2.writeNoException();
                }
            } else {
                zzbtf zzbtfVar = (zzbtf) zzats.zza(parcel, zzbtf.CREATOR);
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface5 instanceof zzbtr) {
                        zzbtr zzbtrVar = (zzbtr) queryLocalInterface5;
                    }
                }
                zzats.zzc(parcel);
                parcel2.writeNoException();
            }
        } else {
            zzbtf zzbtfVar2 = (zzbtf) zzats.zza(parcel, zzbtf.CREATOR);
            zzats.zzc(parcel);
            parcel2.writeNoException();
            zzats.zze(parcel2, null);
        }
        return true;
    }
}
