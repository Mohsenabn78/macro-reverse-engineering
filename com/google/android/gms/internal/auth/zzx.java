package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
public interface zzx extends IInterface {
    void onFailure(Status status) throws RemoteException;

    void zza(DeviceMetaData deviceMetaData) throws RemoteException;

    void zza(Status status, com.google.android.gms.auth.api.accounttransfer.zzl zzlVar) throws RemoteException;

    void zza(Status status, com.google.android.gms.auth.api.accounttransfer.zzt zztVar) throws RemoteException;

    void zza(byte[] bArr) throws RemoteException;

    void zzb(Status status) throws RemoteException;

    void zzd() throws RemoteException;
}
