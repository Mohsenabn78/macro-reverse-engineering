package android.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IBluetoothHeadset extends IInterface {
    boolean connectHeadset(BluetoothDevice bluetoothDevice) throws RemoteException;

    void disconnectHeadset() throws RemoteException;

    int getBatteryUsageHint() throws RemoteException;

    BluetoothDevice getCurrentHeadset() throws RemoteException;

    int getPriority(BluetoothDevice bluetoothDevice) throws RemoteException;

    int getState() throws RemoteException;

    boolean isConnected(BluetoothDevice bluetoothDevice) throws RemoteException;

    boolean setPriority(BluetoothDevice bluetoothDevice, int i4) throws RemoteException;

    boolean startVoiceRecognition() throws RemoteException;

    boolean stopVoiceRecognition() throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IBluetoothHeadset {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public boolean connectHeadset(BluetoothDevice bluetoothDevice) throws RemoteException {
            return false;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public int getBatteryUsageHint() throws RemoteException {
            return 0;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public BluetoothDevice getCurrentHeadset() throws RemoteException {
            return null;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public int getPriority(BluetoothDevice bluetoothDevice) throws RemoteException {
            return 0;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public int getState() throws RemoteException {
            return 0;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public boolean isConnected(BluetoothDevice bluetoothDevice) throws RemoteException {
            return false;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public boolean setPriority(BluetoothDevice bluetoothDevice, int i4) throws RemoteException {
            return false;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public boolean startVoiceRecognition() throws RemoteException {
            return false;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public boolean stopVoiceRecognition() throws RemoteException {
            return false;
        }

        @Override // android.bluetooth.IBluetoothHeadset
        public void disconnectHeadset() throws RemoteException {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IBluetoothHeadset {
        private static final String DESCRIPTOR = "android.bluetooth.IBluetoothHeadset";
        static final int TRANSACTION_connectHeadset = 3;
        static final int TRANSACTION_disconnectHeadset = 4;
        static final int TRANSACTION_getBatteryUsageHint = 10;
        static final int TRANSACTION_getCurrentHeadset = 2;
        static final int TRANSACTION_getPriority = 9;
        static final int TRANSACTION_getState = 1;
        static final int TRANSACTION_isConnected = 5;
        static final int TRANSACTION_setPriority = 8;
        static final int TRANSACTION_startVoiceRecognition = 6;
        static final int TRANSACTION_stopVoiceRecognition = 7;

        /* loaded from: classes.dex */
        public static class Proxy implements IBluetoothHeadset {
            public static IBluetoothHeadset sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.bluetooth.IBluetoothHeadset
            public boolean connectHeadset(BluetoothDevice bluetoothDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z3 = true;
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().connectHeadset(bluetoothDevice);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z3 = false;
                    }
                    return z3;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadset
            public void disconnectHeadset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().disconnectHeadset();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadset
            public int getBatteryUsageHint() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBatteryUsageHint();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadset
            public BluetoothDevice getCurrentHeadset() throws RemoteException {
                BluetoothDevice bluetoothDevice;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentHeadset();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(obtain2);
                    } else {
                        bluetoothDevice = null;
                    }
                    return bluetoothDevice;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.bluetooth.IBluetoothHeadset
            public int getPriority(BluetoothDevice bluetoothDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPriority(bluetoothDevice);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadset
            public int getState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getState();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadset
            public boolean isConnected(BluetoothDevice bluetoothDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z3 = true;
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isConnected(bluetoothDevice);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z3 = false;
                    }
                    return z3;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadset
            public boolean setPriority(BluetoothDevice bluetoothDevice, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z3 = true;
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setPriority(bluetoothDevice, i4);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z3 = false;
                    }
                    return z3;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadset
            public boolean startVoiceRecognition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z3 = false;
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startVoiceRecognition();
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

            @Override // android.bluetooth.IBluetoothHeadset
            public boolean stopVoiceRecognition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z3 = false;
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stopVoiceRecognition();
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBluetoothHeadset asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBluetoothHeadset)) {
                return (IBluetoothHeadset) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IBluetoothHeadset getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBluetoothHeadset iBluetoothHeadset) {
            if (Proxy.sDefaultImpl == null) {
                if (iBluetoothHeadset != null) {
                    Proxy.sDefaultImpl = iBluetoothHeadset;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1598968902) {
                BluetoothDevice bluetoothDevice = null;
                switch (i4) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int state = getState();
                        parcel2.writeNoException();
                        parcel2.writeInt(state);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        BluetoothDevice currentHeadset = getCurrentHeadset();
                        parcel2.writeNoException();
                        if (currentHeadset != null) {
                            parcel2.writeInt(1);
                            currentHeadset.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                        }
                        boolean connectHeadset = connectHeadset(bluetoothDevice);
                        parcel2.writeNoException();
                        parcel2.writeInt(connectHeadset ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        disconnectHeadset();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                        }
                        boolean isConnected = isConnected(bluetoothDevice);
                        parcel2.writeNoException();
                        parcel2.writeInt(isConnected ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean startVoiceRecognition = startVoiceRecognition();
                        parcel2.writeNoException();
                        parcel2.writeInt(startVoiceRecognition ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean stopVoiceRecognition = stopVoiceRecognition();
                        parcel2.writeNoException();
                        parcel2.writeInt(stopVoiceRecognition ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                        }
                        boolean priority = setPriority(bluetoothDevice, parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(priority ? 1 : 0);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                        }
                        int priority2 = getPriority(bluetoothDevice);
                        parcel2.writeNoException();
                        parcel2.writeInt(priority2);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        int batteryUsageHint = getBatteryUsageHint();
                        parcel2.writeNoException();
                        parcel2.writeInt(batteryUsageHint);
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
