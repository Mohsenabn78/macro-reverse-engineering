package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.info.BluetoothConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class BluetoothConstraint extends Constraint {
    private static final int ENABLE_BT_REQUEST = 1010;
    private static int s_constraintCounter;
    private static BroadcastReceiver s_receiver;
    private boolean m_anyDevice;
    private transient BluetoothAdapter m_btAdapter;
    private int m_btState;
    private final transient BroadcastReceiver m_connectReceiver;
    private transient boolean m_constraintCheckingEnabled;
    private String m_deviceAddress;
    private String m_deviceName;
    private static final Set<e> s_connectedDevices = new HashSet();
    private static final Object s_connectedDevicesLock = new Object();
    public static final Parcelable.Creator<BluetoothConstraint> CREATOR = new c();

    /* loaded from: classes3.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED") && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) == 12) {
                BluetoothConstraint.this.T();
                try {
                    MacroDroidApplication.getInstance().unregisterReceiver(BluetoothConstraint.this.m_connectReceiver);
                } catch (Exception e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(e4);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<BluetoothConstraint> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BluetoothConstraint createFromParcel(Parcel parcel) {
            return new BluetoothConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BluetoothConstraint[] newArray(int i4) {
            return new BluetoothConstraint[i4];
        }
    }

    /* loaded from: classes3.dex */
    private class d extends BroadcastReceiver {
        private d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0028 A[Catch: all -> 0x006a, TryCatch #0 {, blocks: (B:4:0x0011, B:12:0x0028, B:14:0x003f, B:21:0x0068, B:15:0x0047, B:17:0x004f, B:18:0x0057, B:20:0x0061, B:7:0x001b), top: B:26:0x0011 }] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0057 A[Catch: all -> 0x006a, TryCatch #0 {, blocks: (B:4:0x0011, B:12:0x0028, B:14:0x003f, B:21:0x0068, B:15:0x0047, B:17:0x004f, B:18:0x0057, B:20:0x0061, B:7:0x001b), top: B:26:0x0011 }] */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r5, android.content.Intent r6) {
            /*
                r4 = this;
                java.lang.String r5 = r6.getAction()
                java.lang.String r0 = "android.bluetooth.device.extra.DEVICE"
                android.os.Parcelable r0 = r6.getParcelableExtra(r0)
                android.bluetooth.BluetoothDevice r0 = (android.bluetooth.BluetoothDevice) r0
                java.lang.Object r1 = com.arlosoft.macrodroid.constraint.BluetoothConstraint.P()
                monitor-enter(r1)
                int r2 = r5.hashCode()     // Catch: java.lang.Throwable -> L6a
                r3 = -1530327060(0xffffffffa4c90fec, float:-8.719683E-17)
                if (r2 == r3) goto L1b
                goto L25
            L1b:
                java.lang.String r2 = "android.bluetooth.adapter.action.STATE_CHANGED"
                boolean r2 = r5.equals(r2)     // Catch: java.lang.Throwable -> L6a
                if (r2 == 0) goto L25
                r2 = 0
                goto L26
            L25:
                r2 = -1
            L26:
                if (r2 == 0) goto L57
                com.arlosoft.macrodroid.constraint.BluetoothConstraint$e r6 = new com.arlosoft.macrodroid.constraint.BluetoothConstraint$e     // Catch: java.lang.Throwable -> L6a
                com.arlosoft.macrodroid.constraint.BluetoothConstraint r2 = com.arlosoft.macrodroid.constraint.BluetoothConstraint.this     // Catch: java.lang.Throwable -> L6a
                java.lang.String r3 = r0.getName()     // Catch: java.lang.Throwable -> L6a
                java.lang.String r0 = r0.getAddress()     // Catch: java.lang.Throwable -> L6a
                r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L6a
                java.lang.String r0 = "android.bluetooth.device.action.ACL_CONNECTED"
                boolean r0 = r0.equals(r5)     // Catch: java.lang.Throwable -> L6a
                if (r0 == 0) goto L47
                java.util.Set r5 = com.arlosoft.macrodroid.constraint.BluetoothConstraint.Q()     // Catch: java.lang.Throwable -> L6a
                r5.add(r6)     // Catch: java.lang.Throwable -> L6a
                goto L68
            L47:
                java.lang.String r0 = "android.bluetooth.device.action.ACL_DISCONNECTED"
                boolean r5 = r0.equals(r5)     // Catch: java.lang.Throwable -> L6a
                if (r5 == 0) goto L68
                java.util.Set r5 = com.arlosoft.macrodroid.constraint.BluetoothConstraint.Q()     // Catch: java.lang.Throwable -> L6a
                r5.remove(r6)     // Catch: java.lang.Throwable -> L6a
                goto L68
            L57:
                java.lang.String r5 = "android.bluetooth.adapter.extra.STATE"
                r0 = 10
                int r5 = r6.getIntExtra(r5, r0)     // Catch: java.lang.Throwable -> L6a
                if (r5 != r0) goto L68
                java.util.Set r5 = com.arlosoft.macrodroid.constraint.BluetoothConstraint.Q()     // Catch: java.lang.Throwable -> L6a
                r5.clear()     // Catch: java.lang.Throwable -> L6a
            L68:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L6a
                return
            L6a:
                r5 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L6a
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.BluetoothConstraint.d.onReceive(android.content.Context, android.content.Intent):void");
        }

        /* synthetic */ d(BluetoothConstraint bluetoothConstraint, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    private class e {

        /* renamed from: a  reason: collision with root package name */
        public String f10162a;

        /* renamed from: b  reason: collision with root package name */
        public String f10163b;

        public e(String str, String str2) {
            this.f10162a = str;
            this.f10163b = str2;
        }

        private boolean a(String str, String str2) {
            if (str == null) {
                if (str2 == null) {
                    return true;
                }
                return false;
            }
            return str.equals(str2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (!a(eVar.f10162a, this.f10162a) || !a(eVar.f10163b, this.f10163b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i4;
            String str = this.f10162a;
            int i5 = 0;
            if (str != null) {
                i4 = str.hashCode();
            } else {
                i4 = 0;
            }
            int i6 = (i4 + 31) * 31;
            String str2 = this.f10163b;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            return i6 + i5;
        }

        public String toString() {
            return this.f10162a + " (" + this.f10163b + ")";
        }
    }

    /* synthetic */ BluetoothConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        String str;
        final String[] strArr;
        final String[] strArr2;
        String[] strArr3;
        String str2;
        String string;
        String str3;
        if (!checkActivityAlive()) {
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = defaultAdapter.isEnabled();
        String str4 = Util.ANY_BT_DEVICE_CONSTANT;
        int i4 = 0;
        if (!isEnabled) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("BluetoothConstraint: Bluetooth not enabled for device selection dialog"));
            strArr = new String[1];
            strArr3 = new String[1];
            int i5 = this.m_btState;
            if (i5 != 2) {
                str4 = Util.ALL_BT_DEVICES_CONSTANT;
            }
            strArr[0] = str4;
            if (i5 == 2) {
                str3 = Util.ANY_BT_DEVICE;
            } else {
                str3 = Util.ALL_BT_DEVICES;
            }
            strArr3[0] = str3;
            strArr2 = new String[]{null};
        } else {
            try {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                String[] strArr4 = new String[bondedDevices.size() + 1];
                String[] strArr5 = new String[bondedDevices.size() + 1];
                String[] strArr6 = new String[bondedDevices.size() + 1];
                int i6 = this.m_btState;
                if (i6 != 2) {
                    str4 = Util.ALL_BT_DEVICES_CONSTANT;
                }
                strArr4[0] = str4;
                strArr5[0] = null;
                if (i6 == 2) {
                    str = Util.ANY_BT_DEVICE;
                } else {
                    str = Util.ALL_BT_DEVICES;
                }
                strArr6[0] = str;
                int i7 = 0;
                int i8 = 1;
                for (BluetoothDevice bluetoothDevice : bondedDevices) {
                    strArr4[i8] = bluetoothDevice.getName();
                    strArr5[i8] = bluetoothDevice.getAddress();
                    strArr6[i8] = bluetoothDevice.getName() + "\n(" + bluetoothDevice.getAddress() + ")";
                    if (this.m_deviceName.equals(strArr4[i8]) && ((str2 = this.m_deviceAddress) == null || str2.equals(strArr5[i8]))) {
                        i7 = i8;
                    }
                    i8++;
                }
                strArr = strArr4;
                i4 = i7;
                strArr2 = strArr5;
                strArr3 = strArr6;
            } catch (SecurityException e4) {
                if (Build.VERSION.SDK_INT >= 31) {
                    SystemLog.logError("Could not detect bluetooth devices: " + e4.toString());
                    PermissionsHelper.showNeedsPermission(getContext(), "android.permission.BLUETOOTH_CONNECT", getName(), true, false);
                    return;
                }
                return;
            }
        }
        if (this.m_btState == 2) {
            string = getContext().getString(R.string.constraint_bluetooth_option_connected);
        } else {
            string = getContext().getString(R.string.constraint_bluetooth_option_not_connected);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(string);
        builder.setSingleChoiceItems(strArr3, i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i9) {
                BluetoothConstraint.this.W(strArr, strArr2, dialogInterface, i9);
            }
        });
        try {
            builder.create().show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    private void U() {
        MacroDroidApplication.getInstance().registerReceiver(this.m_connectReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        getActivity().startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1010);
    }

    private void V() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        a aVar = new a(defaultAdapter);
        if (defaultAdapter != null) {
            defaultAdapter.getProfileProxy(getContext(), aVar, 2);
            defaultAdapter.getProfileProxy(getContext(), aVar, 7);
            defaultAdapter.getProfileProxy(getContext(), aVar, 8);
            defaultAdapter.getProfileProxy(getContext(), aVar, 3);
            try {
                defaultAdapter.getProfileProxy(getContext(), aVar, 1);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(String[] strArr, String[] strArr2, DialogInterface dialogInterface, int i4) {
        boolean z3;
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (checkedItemPosition == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_anyDevice = z3;
        this.m_deviceName = strArr[checkedItemPosition];
        this.m_deviceAddress = strArr2[checkedItemPosition];
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_bluetooth_option_enabled), MacroDroidApplication.getInstance().getString(R.string.constraint_bluetooth_option_disabled), MacroDroidApplication.getInstance().getString(R.string.constraint_bluetooth_option_connected), MacroDroidApplication.getInstance().getString(R.string.constraint_bluetooth_option_not_connected)};
    }

    public static boolean isConnected(BluetoothDevice bluetoothDevice) {
        try {
            return ((Boolean) bluetoothDevice.getClass().getMethod("isConnected", null).invoke(bluetoothDevice, null)).booleanValue();
        } catch (Exception e4) {
            throw new IllegalStateException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_btState = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00df  */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkOK(com.arlosoft.macrodroid.triggers.TriggerContextInfo r9) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.BluetoothConstraint.checkOK(com.arlosoft.macrodroid.triggers.TriggerContextInfo):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void disableConstraintChecking() {
        if (!this.m_constraintCheckingEnabled) {
            return;
        }
        this.m_constraintCheckingEnabled = false;
        int i4 = s_constraintCounter - 1;
        s_constraintCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_receiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_receiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void enableConstraintChecking(boolean z3) {
        if (!z3 && this.m_constraintCheckingEnabled) {
            return;
        }
        this.m_constraintCheckingEnabled = true;
        if (s_constraintCounter == 0) {
            s_receiver = new d(this, null);
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter.setPriority(1000);
            MacroDroidApplication.getInstance().registerReceiver(s_receiver, intentFilter);
            V();
        }
        s_constraintCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_btState;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        int i4 = this.m_btState;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("BluetoothConstraint Invalid Bluetooth State"));
                        return "Error";
                    }
                    return getOptions()[3];
                }
                return getOptions()[2];
            }
            return getOptions()[1];
        }
        return getOptions()[0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_btState;
        if (i4 != 0 && i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("BluetoothConstraint: Invalid bluetooth option"));
                return "";
            }
            String str = this.m_deviceName;
            if (str != null) {
                if (str.equals(Util.ALL_BT_DEVICES_CONSTANT)) {
                    return Util.ALL_BT_DEVICES;
                }
                if (this.m_deviceName.equals(Util.ANY_BT_DEVICE_CONSTANT)) {
                    return Util.ANY_BT_DEVICE;
                }
                return this.m_deviceName;
            }
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BluetoothConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String str;
        String extendedDetail = getExtendedDetail();
        StringBuilder sb = new StringBuilder();
        sb.append(getConfiguredName());
        if (TextUtils.isEmpty(extendedDetail)) {
            str = "";
        } else {
            str = " (" + extendedDetail + ")";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new String[]{"android.permission.BLUETOOTH_CONNECT"};
        }
        return new String[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_btState;
        if (i4 != 0 && i4 != 1) {
            if (i4 == 2 || i4 == 3) {
                if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
                    T();
                    return;
                } else {
                    U();
                    return;
                }
            }
            return;
        }
        itemComplete();
    }

    public void setBluetoothState(int i4) {
        this.m_btState = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_btState);
        parcel.writeString(this.m_deviceName);
        parcel.writeInt(this.m_anyDevice ? 1 : 0);
        parcel.writeInt(this.m_constraintCheckingEnabled ? 1 : 0);
    }

    public BluetoothConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public BluetoothConstraint() {
        this.m_connectReceiver = new b();
        this.m_btState = 0;
        this.m_deviceName = Util.ANY_BT_DEVICE_CONSTANT;
    }

    private BluetoothConstraint(Parcel parcel) {
        super(parcel);
        this.m_connectReceiver = new b();
        this.m_btState = parcel.readInt();
        this.m_deviceName = parcel.readString();
        this.m_anyDevice = parcel.readInt() != 0;
        this.m_constraintCheckingEnabled = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements BluetoothProfile.ServiceListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluetoothAdapter f10158a;

        a(BluetoothAdapter bluetoothAdapter) {
            this.f10158a = bluetoothAdapter;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i4, BluetoothProfile bluetoothProfile) {
            synchronized (BluetoothConstraint.s_connectedDevicesLock) {
                try {
                    List<BluetoothDevice> connectedDevices = bluetoothProfile.getConnectedDevices();
                    if (connectedDevices != null && connectedDevices.size() != 0) {
                        for (BluetoothDevice bluetoothDevice : connectedDevices) {
                            BluetoothConstraint.s_connectedDevices.add(new e(bluetoothDevice.getName(), bluetoothDevice.getAddress()));
                        }
                    }
                } catch (SecurityException e4) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        SystemLog.logError("Could not detect bluetooth devices: " + e4.toString());
                        PermissionsHelper.showNeedsPermission(BluetoothConstraint.this.getContext(), "android.permission.BLUETOOTH_CONNECT", BluetoothConstraint.this.getName(), true, false);
                    }
                }
            }
            this.f10158a.closeProfileProxy(i4, bluetoothProfile);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i4) {
        }
    }
}
