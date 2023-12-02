package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public interface zzbrt extends IInterface {
    boolean zzG() throws RemoteException;

    void zzh(int i4, int i5, Intent intent) throws RemoteException;

    void zzi() throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(@Nullable Bundle bundle) throws RemoteException;

    void zzm() throws RemoteException;

    void zzo() throws RemoteException;

    void zzp(int i4, String[] strArr, int[] iArr) throws RemoteException;

    void zzq() throws RemoteException;

    void zzr() throws RemoteException;

    void zzs(Bundle bundle) throws RemoteException;

    void zzt() throws RemoteException;

    void zzu() throws RemoteException;

    void zzv() throws RemoteException;

    void zzx() throws RemoteException;
}
