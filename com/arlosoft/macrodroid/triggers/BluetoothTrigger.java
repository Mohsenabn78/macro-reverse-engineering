package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.BluetoothTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.BluetoothTriggerReceiver;
import java.util.Set;

/* loaded from: classes3.dex */
public class BluetoothTrigger extends Trigger {
    private static final int ENABLE_BT_REQUEST = 1010;
    private static BluetoothTriggerReceiver s_bluetoothReceiver;
    private static int s_triggerCounter;
    private boolean m_anyDevice;
    private int m_btState;
    private String m_deviceAddress;
    private String m_deviceName;
    private static final String SELECT_DEVICE = MacroDroidApplication.getInstance().getString(R.string.select_device);
    public static final Parcelable.Creator<BluetoothTrigger> CREATOR = new a();

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<BluetoothTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BluetoothTrigger createFromParcel(Parcel parcel) {
            return new BluetoothTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BluetoothTrigger[] newArray(int i4) {
            return new BluetoothTrigger[i4];
        }
    }

    /* synthetic */ BluetoothTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void O() {
        final String[] strArr;
        final String[] strArr2;
        CharSequence[] charSequenceArr;
        String str;
        int i4;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        int i5 = 1;
        int i6 = 0;
        if (!defaultAdapter.isEnabled()) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Bluetooth not enabled for device selection dialog"));
            strArr = new String[]{Util.ANY_BT_DEVICE_CONSTANT};
            strArr2 = new String[]{null};
            charSequenceArr = new CharSequence[]{Util.ANY_BT_DEVICE};
        } else {
            Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
            strArr = new String[bondedDevices.size() + 1];
            String[] strArr3 = new String[bondedDevices.size() + 1];
            CharSequence[] charSequenceArr2 = new CharSequence[bondedDevices.size() + 1];
            strArr[0] = Util.ANY_BT_DEVICE_CONSTANT;
            strArr3[0] = null;
            charSequenceArr2[0] = Util.ANY_BT_DEVICE;
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                strArr[i5] = bluetoothDevice.getName();
                strArr3[i5] = bluetoothDevice.getAddress();
                charSequenceArr2[i5] = Html.fromHtml(bluetoothDevice.getName() + "\n<small><font color='#999999'>" + bluetoothDevice.getAddress() + "</font></small>");
                if (this.m_deviceName.equals(bluetoothDevice.getName()) && ((str = this.m_deviceAddress) == null || str.equals(bluetoothDevice.getAddress()))) {
                    i6 = i5;
                }
                i5++;
            }
            strArr2 = strArr3;
            charSequenceArr = charSequenceArr2;
        }
        if (this.m_btState == 2) {
            i4 = R.string.trigger_bluetooth_device_connected;
        } else {
            i4 = R.string.trigger_bluetooth_device_disconnected;
        }
        String r4 = SelectableItem.r(i4);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(r4);
        builder.setSingleChoiceItems(charSequenceArr, i6, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.x0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                BluetoothTrigger.this.P(strArr, strArr2, dialogInterface, i7);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.y0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                BluetoothTrigger.this.Q(dialogInterface, i7);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(String[] strArr, String[] strArr2, DialogInterface dialogInterface, int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_anyDevice = z3;
        this.m_deviceName = strArr[i4];
        this.m_deviceAddress = strArr2[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_bluetooth_enabled), MacroDroidApplication.getInstance().getString(R.string.trigger_bluetooth_disabled), MacroDroidApplication.getInstance().getString(R.string.trigger_bluetooth_device_connected), MacroDroidApplication.getInstance().getString(R.string.trigger_bluetooth_device_disconnected)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_btState = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_bluetoothReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_bluetoothReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_bluetoothReceiver = new BluetoothTriggerReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_bluetoothReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            MacroDroidApplication.getInstance().registerReceiver(s_bluetoothReceiver, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
            MacroDroidApplication.getInstance().registerReceiver(s_bluetoothReceiver, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        }
        s_triggerCounter++;
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
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Invalid Bluetooth State"));
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

    public String getDeviceAddress() {
        return this.m_deviceAddress;
    }

    public String getDeviceName() {
        return this.m_deviceName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_btState;
        if (i4 == 0 || i4 == 1) {
            return "";
        }
        if (i4 != 2 && i4 != 3) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Invalid bluetooth option"));
            return "";
        } else if (this.m_deviceName.equals(Util.ANY_BT_DEVICE_CONSTANT)) {
            return Util.ANY_BT_DEVICE;
        } else {
            return this.m_deviceName;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BluetoothTriggerInfo.getInstance();
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

    public int getState() {
        return this.m_btState;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public TriggerContextInfo getTestTriggerContentInfo() {
        return new TriggerContextInfo(this, "test device name");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == 1010 && i5 == -1) {
            O();
        }
    }

    public boolean isAnyDevice() {
        return this.m_anyDevice;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        int i4;
        String str = this.m_deviceName;
        if (str != null && ((i4 = this.m_btState) == 0 || i4 == 1 || !str.equals(SELECT_DEVICE))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_btState;
        if (i4 != 0 && i4 != 1) {
            if (i4 == 2 || i4 == 3) {
                if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
                    O();
                    return;
                }
                getActivity().startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1010);
                return;
            }
            return;
        }
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_btState);
        parcel.writeString(this.m_deviceName);
        parcel.writeString(this.m_deviceAddress);
        parcel.writeInt(this.m_anyDevice ? 1 : 0);
    }

    public BluetoothTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private BluetoothTrigger() {
        this.m_btState = 0;
        this.m_deviceName = Util.ANY_BT_DEVICE_CONSTANT;
    }

    private BluetoothTrigger(Parcel parcel) {
        super(parcel);
        this.m_btState = parcel.readInt();
        this.m_deviceName = parcel.readString();
        this.m_deviceAddress = parcel.readString();
        this.m_anyDevice = parcel.readInt() != 0;
    }
}
