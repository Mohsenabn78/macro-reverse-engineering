package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbps extends zzatr implements zzbpt {
    public zzbps() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbpt zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzbpt) {
            return (zzbpt) queryLocalInterface;
        }
        return new zzbpr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzatr
    protected final boolean zzbE(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        zzbpw zzbpwVar = null;
        zzbpe zzbpcVar = null;
        zzbpn zzbplVar = null;
        zzbph zzbpfVar = null;
        zzbpq zzbpoVar = null;
        zzbpn zzbplVar2 = null;
        zzbpq zzbpoVar2 = null;
        zzbpk zzbpiVar = null;
        zzbph zzbpfVar2 = null;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 5) {
                        if (i4 != 10) {
                            if (i4 != 11) {
                                switch (i4) {
                                    case 13:
                                        String readString = parcel.readString();
                                        String readString2 = parcel.readString();
                                        com.google.android.gms.ads.internal.client.zzl zzlVar = (com.google.android.gms.ads.internal.client.zzl) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                                        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        IBinder readStrongBinder = parcel.readStrongBinder();
                                        if (readStrongBinder != null) {
                                            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                                            if (queryLocalInterface instanceof zzbph) {
                                                zzbpfVar2 = (zzbph) queryLocalInterface;
                                            } else {
                                                zzbpfVar2 = new zzbpf(readStrongBinder);
                                            }
                                        }
                                        zzbph zzbphVar = zzbpfVar2;
                                        zzats.zzc(parcel);
                                        zzj(readString, readString2, zzlVar, asInterface, zzbphVar, zzbob.zzb(parcel.readStrongBinder()), (com.google.android.gms.ads.internal.client.zzq) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR));
                                        parcel2.writeNoException();
                                        break;
                                    case 14:
                                        String readString3 = parcel.readString();
                                        String readString4 = parcel.readString();
                                        com.google.android.gms.ads.internal.client.zzl zzlVar2 = (com.google.android.gms.ads.internal.client.zzl) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                                        IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        IBinder readStrongBinder2 = parcel.readStrongBinder();
                                        if (readStrongBinder2 != null) {
                                            IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                                            if (queryLocalInterface2 instanceof zzbpk) {
                                                zzbpiVar = (zzbpk) queryLocalInterface2;
                                            } else {
                                                zzbpiVar = new zzbpi(readStrongBinder2);
                                            }
                                        }
                                        zzbpk zzbpkVar = zzbpiVar;
                                        zzboc zzb = zzbob.zzb(parcel.readStrongBinder());
                                        zzats.zzc(parcel);
                                        zzl(readString3, readString4, zzlVar2, asInterface2, zzbpkVar, zzb);
                                        parcel2.writeNoException();
                                        break;
                                    case 15:
                                        IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        zzats.zzc(parcel);
                                        boolean zzs = zzs(asInterface3);
                                        parcel2.writeNoException();
                                        parcel2.writeInt(zzs ? 1 : 0);
                                        break;
                                    case 16:
                                        String readString5 = parcel.readString();
                                        String readString6 = parcel.readString();
                                        com.google.android.gms.ads.internal.client.zzl zzlVar3 = (com.google.android.gms.ads.internal.client.zzl) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                                        IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        IBinder readStrongBinder3 = parcel.readStrongBinder();
                                        if (readStrongBinder3 != null) {
                                            IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                                            if (queryLocalInterface3 instanceof zzbpq) {
                                                zzbpoVar2 = (zzbpq) queryLocalInterface3;
                                            } else {
                                                zzbpoVar2 = new zzbpo(readStrongBinder3);
                                            }
                                        }
                                        zzbpq zzbpqVar = zzbpoVar2;
                                        zzboc zzb2 = zzbob.zzb(parcel.readStrongBinder());
                                        zzats.zzc(parcel);
                                        zzp(readString5, readString6, zzlVar3, asInterface4, zzbpqVar, zzb2);
                                        parcel2.writeNoException();
                                        break;
                                    case 17:
                                        IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        zzats.zzc(parcel);
                                        boolean zzt = zzt(asInterface5);
                                        parcel2.writeNoException();
                                        parcel2.writeInt(zzt ? 1 : 0);
                                        break;
                                    case 18:
                                        String readString7 = parcel.readString();
                                        String readString8 = parcel.readString();
                                        com.google.android.gms.ads.internal.client.zzl zzlVar4 = (com.google.android.gms.ads.internal.client.zzl) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                                        IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        IBinder readStrongBinder4 = parcel.readStrongBinder();
                                        if (readStrongBinder4 != null) {
                                            IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                                            if (queryLocalInterface4 instanceof zzbpn) {
                                                zzbplVar2 = (zzbpn) queryLocalInterface4;
                                            } else {
                                                zzbplVar2 = new zzbpl(readStrongBinder4);
                                            }
                                        }
                                        zzbpn zzbpnVar = zzbplVar2;
                                        zzboc zzb3 = zzbob.zzb(parcel.readStrongBinder());
                                        zzats.zzc(parcel);
                                        zzm(readString7, readString8, zzlVar4, asInterface6, zzbpnVar, zzb3);
                                        parcel2.writeNoException();
                                        break;
                                    case 19:
                                        String readString9 = parcel.readString();
                                        zzats.zzc(parcel);
                                        zzq(readString9);
                                        parcel2.writeNoException();
                                        break;
                                    case 20:
                                        String readString10 = parcel.readString();
                                        String readString11 = parcel.readString();
                                        com.google.android.gms.ads.internal.client.zzl zzlVar5 = (com.google.android.gms.ads.internal.client.zzl) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                                        IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        IBinder readStrongBinder5 = parcel.readStrongBinder();
                                        if (readStrongBinder5 != null) {
                                            IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                                            if (queryLocalInterface5 instanceof zzbpq) {
                                                zzbpoVar = (zzbpq) queryLocalInterface5;
                                            } else {
                                                zzbpoVar = new zzbpo(readStrongBinder5);
                                            }
                                        }
                                        zzbpq zzbpqVar2 = zzbpoVar;
                                        zzboc zzb4 = zzbob.zzb(parcel.readStrongBinder());
                                        zzats.zzc(parcel);
                                        zzo(readString10, readString11, zzlVar5, asInterface7, zzbpqVar2, zzb4);
                                        parcel2.writeNoException();
                                        break;
                                    case 21:
                                        String readString12 = parcel.readString();
                                        String readString13 = parcel.readString();
                                        com.google.android.gms.ads.internal.client.zzl zzlVar6 = (com.google.android.gms.ads.internal.client.zzl) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                                        IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        IBinder readStrongBinder6 = parcel.readStrongBinder();
                                        if (readStrongBinder6 != null) {
                                            IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                                            if (queryLocalInterface6 instanceof zzbph) {
                                                zzbpfVar = (zzbph) queryLocalInterface6;
                                            } else {
                                                zzbpfVar = new zzbpf(readStrongBinder6);
                                            }
                                        }
                                        zzbph zzbphVar2 = zzbpfVar;
                                        zzats.zzc(parcel);
                                        zzk(readString12, readString13, zzlVar6, asInterface8, zzbphVar2, zzbob.zzb(parcel.readStrongBinder()), (com.google.android.gms.ads.internal.client.zzq) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR));
                                        parcel2.writeNoException();
                                        break;
                                    case 22:
                                        String readString14 = parcel.readString();
                                        String readString15 = parcel.readString();
                                        com.google.android.gms.ads.internal.client.zzl zzlVar7 = (com.google.android.gms.ads.internal.client.zzl) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                                        IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        IBinder readStrongBinder7 = parcel.readStrongBinder();
                                        if (readStrongBinder7 != null) {
                                            IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                                            if (queryLocalInterface7 instanceof zzbpn) {
                                                zzbplVar = (zzbpn) queryLocalInterface7;
                                            } else {
                                                zzbplVar = new zzbpl(readStrongBinder7);
                                            }
                                        }
                                        zzbpn zzbpnVar2 = zzbplVar;
                                        zzats.zzc(parcel);
                                        zzn(readString14, readString15, zzlVar7, asInterface9, zzbpnVar2, zzbob.zzb(parcel.readStrongBinder()), (zzbef) zzats.zza(parcel, zzbef.CREATOR));
                                        parcel2.writeNoException();
                                        break;
                                    case 23:
                                        String readString16 = parcel.readString();
                                        String readString17 = parcel.readString();
                                        com.google.android.gms.ads.internal.client.zzl zzlVar8 = (com.google.android.gms.ads.internal.client.zzl) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                                        IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        IBinder readStrongBinder8 = parcel.readStrongBinder();
                                        if (readStrongBinder8 != null) {
                                            IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                                            if (queryLocalInterface8 instanceof zzbpe) {
                                                zzbpcVar = (zzbpe) queryLocalInterface8;
                                            } else {
                                                zzbpcVar = new zzbpc(readStrongBinder8);
                                            }
                                        }
                                        zzbpe zzbpeVar = zzbpcVar;
                                        zzboc zzb5 = zzbob.zzb(parcel.readStrongBinder());
                                        zzats.zzc(parcel);
                                        zzi(readString16, readString17, zzlVar8, asInterface10, zzbpeVar, zzb5);
                                        parcel2.writeNoException();
                                        break;
                                    case 24:
                                        IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                                        zzats.zzc(parcel);
                                        boolean zzr = zzr(asInterface11);
                                        parcel2.writeNoException();
                                        parcel2.writeInt(zzr ? 1 : 0);
                                        break;
                                    default:
                                        return false;
                                }
                            } else {
                                parcel.createStringArray();
                                Bundle[] bundleArr = (Bundle[]) parcel.createTypedArray(Bundle.CREATOR);
                                zzats.zzc(parcel);
                                parcel2.writeNoException();
                            }
                        } else {
                            IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                            zzats.zzc(parcel);
                            parcel2.writeNoException();
                        }
                    } else {
                        com.google.android.gms.ads.internal.client.zzdq zze = zze();
                        parcel2.writeNoException();
                        zzats.zzf(parcel2, zze);
                    }
                } else {
                    zzbqh zzg = zzg();
                    parcel2.writeNoException();
                    zzats.zze(parcel2, zzg);
                }
            } else {
                zzbqh zzf = zzf();
                parcel2.writeNoException();
                zzats.zze(parcel2, zzf);
            }
        } else {
            IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String readString18 = parcel.readString();
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) zzats.zza(parcel, creator);
            Bundle bundle2 = (Bundle) zzats.zza(parcel, creator);
            com.google.android.gms.ads.internal.client.zzq zzqVar = (com.google.android.gms.ads.internal.client.zzq) zzats.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
            IBinder readStrongBinder9 = parcel.readStrongBinder();
            if (readStrongBinder9 != null) {
                IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                if (queryLocalInterface9 instanceof zzbpw) {
                    zzbpwVar = (zzbpw) queryLocalInterface9;
                } else {
                    zzbpwVar = new zzbpu(readStrongBinder9);
                }
            }
            zzbpw zzbpwVar2 = zzbpwVar;
            zzats.zzc(parcel);
            zzh(asInterface12, readString18, bundle, bundle2, zzqVar, zzbpwVar2);
            parcel2.writeNoException();
        }
        return true;
    }
}
