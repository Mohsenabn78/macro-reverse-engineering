package com.fingerprints.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fingerprints.service.IFingerprintClient;

/* loaded from: classes3.dex */
public interface IFingerprintService extends IInterface {
    void cancel(IFingerprintClient iFingerprintClient) throws RemoteException;

    int[] getIds(IFingerprintClient iFingerprintClient) throws RemoteException;

    boolean isFingerEnable() throws RemoteException;

    boolean isSurpport() throws RemoteException;

    void notifyScreenOff() throws RemoteException;

    void notifyScreenOn() throws RemoteException;

    boolean open(IFingerprintClient iFingerprintClient) throws RemoteException;

    void release(IFingerprintClient iFingerprintClient) throws RemoteException;

    boolean removeData(IFingerprintClient iFingerprintClient, int[] iArr) throws RemoteException;

    void shouldRestartByScreenOn(IFingerprintClient iFingerprintClient) throws RemoteException;

    void startEnrol(IFingerprintClient iFingerprintClient, int i4) throws RemoteException;

    void startGuidedEnrol(IFingerprintClient iFingerprintClient, int i4) throws RemoteException;

    void startIdentify(IFingerprintClient iFingerprintClient, int[] iArr) throws RemoteException;

    boolean updateTA(String str) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IFingerprintService {
        private static final String DESCRIPTOR = "com.fingerprints.service.IFingerprintService";
        static final int TRANSACTION_cancel = 6;
        static final int TRANSACTION_getIds = 8;
        static final int TRANSACTION_isFingerEnable = 10;
        static final int TRANSACTION_isSurpport = 11;
        static final int TRANSACTION_notifyScreenOff = 13;
        static final int TRANSACTION_notifyScreenOn = 12;
        static final int TRANSACTION_open = 1;
        static final int TRANSACTION_release = 7;
        static final int TRANSACTION_removeData = 5;
        static final int TRANSACTION_shouldRestartByScreenOn = 14;
        static final int TRANSACTION_startEnrol = 2;
        static final int TRANSACTION_startGuidedEnrol = 3;
        static final int TRANSACTION_startIdentify = 4;
        static final int TRANSACTION_updateTA = 9;

        /* loaded from: classes3.dex */
        private static class Proxy implements IFingerprintService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.fingerprints.service.IFingerprintService
            public void cancel(IFingerprintClient iFingerprintClient) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iFingerprintClient != null) {
                        iBinder = iFingerprintClient.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public int[] getIds(IFingerprintClient iFingerprintClient) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iFingerprintClient != null) {
                        iBinder = iFingerprintClient.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.fingerprints.service.IFingerprintService
            public boolean isFingerEnable() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z3 = false;
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z3 = true;
                    }
                    return z3;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public boolean isSurpport() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z3 = false;
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z3 = true;
                    }
                    return z3;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public void notifyScreenOff() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public void notifyScreenOn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public boolean open(IFingerprintClient iFingerprintClient) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iFingerprintClient != null) {
                        iBinder = iFingerprintClient.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z3 = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z3 = true;
                    }
                    return z3;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public void release(IFingerprintClient iFingerprintClient) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iFingerprintClient != null) {
                        iBinder = iFingerprintClient.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public boolean removeData(IFingerprintClient iFingerprintClient, int[] iArr) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iFingerprintClient != null) {
                        iBinder = iFingerprintClient.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeIntArray(iArr);
                    boolean z3 = false;
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z3 = true;
                    }
                    return z3;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public void shouldRestartByScreenOn(IFingerprintClient iFingerprintClient) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iFingerprintClient != null) {
                        iBinder = iFingerprintClient.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public void startEnrol(IFingerprintClient iFingerprintClient, int i4) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iFingerprintClient != null) {
                        iBinder = iFingerprintClient.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i4);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public void startGuidedEnrol(IFingerprintClient iFingerprintClient, int i4) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iFingerprintClient != null) {
                        iBinder = iFingerprintClient.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i4);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public void startIdentify(IFingerprintClient iFingerprintClient, int[] iArr) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iFingerprintClient != null) {
                        iBinder = iFingerprintClient.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeIntArray(iArr);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fingerprints.service.IFingerprintService
            public boolean updateTA(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z3 = false;
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z3 = true;
                    }
                    return z3;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFingerprintService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IFingerprintService)) {
                return (IFingerprintService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean open = open(IFingerprintClient.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(open ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        startEnrol(IFingerprintClient.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        startGuidedEnrol(IFingerprintClient.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        startIdentify(IFingerprintClient.Stub.asInterface(parcel.readStrongBinder()), parcel.createIntArray());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean removeData = removeData(IFingerprintClient.Stub.asInterface(parcel.readStrongBinder()), parcel.createIntArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(removeData ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancel(IFingerprintClient.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        release(IFingerprintClient.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        int[] ids = getIds(IFingerprintClient.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeIntArray(ids);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean updateTA = updateTA(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(updateTA ? 1 : 0);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isFingerEnable = isFingerEnable();
                        parcel2.writeNoException();
                        parcel2.writeInt(isFingerEnable ? 1 : 0);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isSurpport = isSurpport();
                        parcel2.writeNoException();
                        parcel2.writeInt(isSurpport ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        notifyScreenOn();
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        notifyScreenOff();
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        shouldRestartByScreenOn(IFingerprintClient.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
