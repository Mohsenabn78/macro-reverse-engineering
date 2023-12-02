package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public interface zzcgq extends IInterface {
    int zzb(String str) throws RemoteException;

    long zzc() throws RemoteException;

    Bundle zzd(Bundle bundle) throws RemoteException;

    String zze() throws RemoteException;

    String zzf() throws RemoteException;

    String zzg() throws RemoteException;

    String zzh() throws RemoteException;

    String zzi() throws RemoteException;

    List zzj(String str, String str2) throws RemoteException;

    Map zzk(String str, String str2, boolean z3) throws RemoteException;

    void zzl(String str) throws RemoteException;

    void zzm(String str, String str2, Bundle bundle) throws RemoteException;

    void zzn(String str) throws RemoteException;

    void zzo(String str, String str2, Bundle bundle) throws RemoteException;

    void zzp(Bundle bundle) throws RemoteException;

    void zzq(Bundle bundle) throws RemoteException;

    void zzr(Bundle bundle) throws RemoteException;

    void zzs(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException;

    void zzt(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException;
}
