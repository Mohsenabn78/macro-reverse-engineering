package com.tencent.soter.soterserver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes6.dex */
public interface ISoterService extends IInterface {

    /* loaded from: classes6.dex */
    public static class Default implements ISoterService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterSignResult finishSign(long j4) throws RemoteException {
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int generateAppSecureKey(int i4) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int generateAuthKey(int i4, String str) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterExportResult getAppSecureKey(int i4) throws RemoteException {
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterExportResult getAuthKey(int i4, String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterDeviceResult getDeviceId() throws RemoteException {
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterExtraParam getExtraParam(String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public boolean hasAskAlready(int i4) throws RemoteException {
            return false;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public boolean hasAuthKey(int i4, String str) throws RemoteException {
            return false;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterSessionResult initSigh(int i4, String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int removeAllAuthKey(int i4) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int removeAuthKey(int i4, String str) throws RemoteException {
            return 0;
        }
    }

    SoterSignResult finishSign(long j4) throws RemoteException;

    int generateAppSecureKey(int i4) throws RemoteException;

    int generateAuthKey(int i4, String str) throws RemoteException;

    SoterExportResult getAppSecureKey(int i4) throws RemoteException;

    SoterExportResult getAuthKey(int i4, String str) throws RemoteException;

    SoterDeviceResult getDeviceId() throws RemoteException;

    SoterExtraParam getExtraParam(String str) throws RemoteException;

    int getVersion() throws RemoteException;

    boolean hasAskAlready(int i4) throws RemoteException;

    boolean hasAuthKey(int i4, String str) throws RemoteException;

    SoterSessionResult initSigh(int i4, String str, String str2) throws RemoteException;

    int removeAllAuthKey(int i4) throws RemoteException;

    int removeAuthKey(int i4, String str) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class Stub extends Binder implements ISoterService {
        private static final String DESCRIPTOR = "com.tencent.soter.soterserver.ISoterService";
        static final int TRANSACTION_finishSign = 10;
        static final int TRANSACTION_generateAppSecureKey = 1;
        static final int TRANSACTION_generateAuthKey = 4;
        static final int TRANSACTION_getAppSecureKey = 2;
        static final int TRANSACTION_getAuthKey = 6;
        static final int TRANSACTION_getDeviceId = 11;
        static final int TRANSACTION_getExtraParam = 13;
        static final int TRANSACTION_getVersion = 12;
        static final int TRANSACTION_hasAskAlready = 3;
        static final int TRANSACTION_hasAuthKey = 8;
        static final int TRANSACTION_initSigh = 9;
        static final int TRANSACTION_removeAllAuthKey = 7;
        static final int TRANSACTION_removeAuthKey = 5;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes6.dex */
        public static class Proxy implements ISoterService {
            public static ISoterService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterSignResult finishSign(long j4) throws RemoteException {
                SoterSignResult soterSignResult;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j4);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().finishSign(j4);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterSignResult = SoterSignResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterSignResult = null;
                    }
                    return soterSignResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int generateAppSecureKey(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().generateAppSecureKey(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int generateAuthKey(int i4, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().generateAuthKey(i4, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterExportResult getAppSecureKey(int i4) throws RemoteException {
                SoterExportResult soterExportResult;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppSecureKey(i4);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExportResult = SoterExportResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExportResult = null;
                    }
                    return soterExportResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterExportResult getAuthKey(int i4, String str) throws RemoteException {
                SoterExportResult soterExportResult;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAuthKey(i4, str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExportResult = SoterExportResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExportResult = null;
                    }
                    return soterExportResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterDeviceResult getDeviceId() throws RemoteException {
                SoterDeviceResult soterDeviceResult;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDeviceId();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterDeviceResult = SoterDeviceResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterDeviceResult = null;
                    }
                    return soterDeviceResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterExtraParam getExtraParam(String str) throws RemoteException {
                SoterExtraParam soterExtraParam;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getExtraParam(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExtraParam = SoterExtraParam.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExtraParam = null;
                    }
                    return soterExtraParam;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int getVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVersion();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public boolean hasAskAlready(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    boolean z3 = false;
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasAskAlready(i4);
                    }
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

            @Override // com.tencent.soter.soterserver.ISoterService
            public boolean hasAuthKey(int i4, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    obtain.writeString(str);
                    boolean z3 = false;
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasAuthKey(i4, str);
                    }
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

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterSessionResult initSigh(int i4, String str, String str2) throws RemoteException {
                SoterSessionResult soterSessionResult;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().initSigh(i4, str, str2);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterSessionResult = SoterSessionResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterSessionResult = null;
                    }
                    return soterSessionResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int removeAllAuthKey(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeAllAuthKey(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int removeAuthKey(int i4, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeAuthKey(i4, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISoterService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ISoterService)) {
                return (ISoterService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ISoterService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISoterService iSoterService) {
            if (Proxy.sDefaultImpl == null) {
                if (iSoterService != null) {
                    Proxy.sDefaultImpl = iSoterService;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int generateAppSecureKey = generateAppSecureKey(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(generateAppSecureKey);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterExportResult appSecureKey = getAppSecureKey(parcel.readInt());
                        parcel2.writeNoException();
                        if (appSecureKey != null) {
                            parcel2.writeInt(1);
                            appSecureKey.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean hasAskAlready = hasAskAlready(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(hasAskAlready ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int generateAuthKey = generateAuthKey(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(generateAuthKey);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        int removeAuthKey = removeAuthKey(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(removeAuthKey);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterExportResult authKey = getAuthKey(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        if (authKey != null) {
                            parcel2.writeInt(1);
                            authKey.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        int removeAllAuthKey = removeAllAuthKey(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(removeAllAuthKey);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean hasAuthKey = hasAuthKey(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(hasAuthKey ? 1 : 0);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterSessionResult initSigh = initSigh(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (initSigh != null) {
                            parcel2.writeInt(1);
                            initSigh.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterSignResult finishSign = finishSign(parcel.readLong());
                        parcel2.writeNoException();
                        if (finishSign != null) {
                            parcel2.writeInt(1);
                            finishSign.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterDeviceResult deviceId = getDeviceId();
                        parcel2.writeNoException();
                        if (deviceId != null) {
                            parcel2.writeInt(1);
                            deviceId.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        int version = getVersion();
                        parcel2.writeNoException();
                        parcel2.writeInt(version);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterExtraParam extraParam = getExtraParam(parcel.readString());
                        parcel2.writeNoException();
                        if (extraParam != null) {
                            parcel2.writeInt(1);
                            extraParam.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
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
