package com.google.android.gms.internal.nearby;

import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public interface zzcv extends IInterface {
    @Nullable
    ParcelFileDescriptor zzb() throws RemoteException;

    boolean zzc() throws RemoteException;
}
