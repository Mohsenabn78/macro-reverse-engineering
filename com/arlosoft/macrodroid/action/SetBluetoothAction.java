package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetBluetoothActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.BluetoothA2DPRequester;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import me.drakeet.support.toast.ToastCompat;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: classes2.dex */
public class SetBluetoothAction extends Action implements BluetoothA2DPRequester.Callback {
    public static final Parcelable.Creator<SetBluetoothAction> CREATOR = new b();
    private static final int STATE_CONNECT_TO_AUDIO_DEVICE = 3;
    private static final int STATE_DISCONNECT_AUDIO_DEVICE = 4;
    private static final String TAG = "TAG";
    private transient BluetoothAdapter mAdapter;
    private final transient BroadcastReceiver m_connectReceiver;
    private transient boolean m_connectToDevice;
    private String m_deviceAddress;
    private String m_deviceName;
    private int m_state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED") && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) == 12) {
                try {
                    MacroDroidApplication.getInstance().unregisterReceiver(SetBluetoothAction.this.m_connectReceiver);
                } catch (Exception unused) {
                }
                if (!SetBluetoothAction.this.m_connectToDevice) {
                    SetBluetoothAction.this.T();
                } else {
                    new BluetoothA2DPRequester(SetBluetoothAction.this).request(SetBluetoothAction.this.getContext(), SetBluetoothAction.this.getDefaultAdapter());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<SetBluetoothAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetBluetoothAction createFromParcel(Parcel parcel) {
            return new SetBluetoothAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetBluetoothAction[] newArray(int i4) {
            return new SetBluetoothAction[i4];
        }
    }

    /* synthetic */ SetBluetoothAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        AlertDialog.Builder builder;
        int i4;
        String str;
        String str2;
        if (!checkActivityAlive()) {
            return;
        }
        Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        ArrayList arrayList = new ArrayList();
        ArrayList<BluetoothDevice> arrayList2 = new ArrayList();
        SystemLog.logVerbose("** CHECKING BT DEVICES **", getMacroGuid().longValue());
        for (BluetoothDevice bluetoothDevice : bondedDevices) {
            if (bluetoothDevice != null) {
                SystemLog.logVerbose("FOUND BT Device - " + bluetoothDevice.getName() + " (" + bluetoothDevice.getAddress() + ")", getMacroGuid().longValue());
                if (bluetoothDevice.getBluetoothClass() != null) {
                    SystemLog.logVerbose("MAJOR CLASS = " + bluetoothDevice.getBluetoothClass().getMajorDeviceClass(), getMacroGuid().longValue());
                    SystemLog.logVerbose("DEVICE CLASS = " + bluetoothDevice.getBluetoothClass().getDeviceClass(), getMacroGuid().longValue());
                }
                if (bluetoothDevice.getBluetoothClass() != null && bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == 1024) {
                    arrayList.add(bluetoothDevice);
                    SystemLog.logVerbose("ADDING audio device as option", getMacroGuid().longValue());
                } else {
                    SystemLog.logVerbose("ADDING other device as possible option", getMacroGuid().longValue());
                    arrayList2.add(bluetoothDevice);
                }
            }
        }
        final String[] strArr = new String[arrayList.size() + arrayList2.size()];
        final String[] strArr2 = new String[arrayList.size() + arrayList2.size()];
        CharSequence[] charSequenceArr = new CharSequence[arrayList.size() + arrayList2.size()];
        Iterator it = arrayList.iterator();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean hasNext = it.hasNext();
            String str3 = TypeDescription.Generic.OfWildcardType.SYMBOL;
            if (!hasNext) {
                break;
            }
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) it.next();
            String name = bluetoothDevice2.getName();
            if (name != null) {
                str3 = name;
            }
            strArr[i5] = str3;
            strArr[i5] = bluetoothDevice2.getName();
            strArr2[i5] = bluetoothDevice2.getAddress();
            charSequenceArr[i5] = Html.fromHtml(bluetoothDevice2.getName() + "\n<small><font color='#999999'>" + bluetoothDevice2.getAddress() + "</font></small>");
            if (this.m_deviceName.equals(strArr[i5]) && ((str2 = this.m_deviceAddress) == null || str2.equals(strArr2[i5]))) {
                i6 = i5;
            }
            i5++;
        }
        for (BluetoothDevice bluetoothDevice3 : arrayList2) {
            String name2 = bluetoothDevice3.getName();
            if (name2 == null) {
                name2 = TypeDescription.Generic.OfWildcardType.SYMBOL;
            }
            strArr[i5] = name2;
            strArr[i5] = bluetoothDevice3.getName();
            strArr2[i5] = bluetoothDevice3.getAddress();
            charSequenceArr[i5] = Html.fromHtml("* " + bluetoothDevice3.getName() + "\n<small><font color='#999999'>" + bluetoothDevice3.getAddress() + "</font></small>");
            if (this.m_deviceName.equals(strArr[i5]) && ((str = this.m_deviceAddress) == null || str.equals(strArr2[i5]))) {
                i6 = i5;
            }
            i5++;
        }
        if (arrayList.size() > 0) {
            this.m_deviceName = strArr[i6];
            this.m_deviceAddress = strArr2[i6];
        }
        Activity activity = getActivity();
        if (arrayList.size() > 0) {
            builder = new AlertDialog.Builder(activity, m());
            if (this.m_state == 3) {
                i4 = R.string.connect_to;
            } else {
                i4 = R.string.disconnect_from;
            }
            builder.setTitle(i4);
            builder.setSingleChoiceItems(charSequenceArr, i6, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.vi
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i7) {
                    SetBluetoothAction.this.b0(strArr, strArr2, dialogInterface, i7);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.wi
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i7) {
                    SetBluetoothAction.this.c0(dialogInterface, i7);
                }
            });
        } else {
            builder = new AlertDialog.Builder(activity, m());
            builder.setTitle(R.string.action_set_bluetooth_no_devices);
            builder.setMessage(R.string.action_set_bluetooth_none_paired);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xi
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i7) {
                    dialogInterface.dismiss();
                }
            });
        }
        builder.create().show();
        if (!arrayList2.isEmpty()) {
            ToastCompat.makeText(getContext(), (int) R.string.bluetooth_audio_device_warning, 1).show();
        }
    }

    private void U() {
        BluetoothAdapter defaultAdapter = getDefaultAdapter();
        if (!defaultAdapter.isEnabled()) {
            this.m_connectToDevice = true;
            MacroDroidApplication.getInstance().registerReceiver(this.m_connectReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            defaultAdapter.enable();
            return;
        }
        new BluetoothA2DPRequester(this).request(getContext(), defaultAdapter);
    }

    private void V() {
        try {
            try {
                MacroDroidApplication.getInstance().registerReceiver(this.m_connectReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                this.m_connectToDevice = false;
                Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
                intent.addFlags(268435456);
                getContext().startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                MacroDroidApplication.getInstance().unregisterReceiver(this.m_connectReceiver);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.macrodroid_error);
                builder.setMessage(R.string.enable_bluetooth_manually);
                builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.yi
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        } catch (Exception unused2) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
            builder2.setTitle(R.string.macrodroid_error);
            builder2.setMessage(R.string.enable_bluetooth_manually);
            builder2.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.yi
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    dialogInterface.dismiss();
                }
            });
            builder2.show();
        }
    }

    private static BluetoothDevice W(BluetoothAdapter bluetoothAdapter, String str, String str2) {
        for (BluetoothDevice bluetoothDevice : Y(bluetoothAdapter)) {
            if (str != null && bluetoothDevice.getName() != null && str.equals(bluetoothDevice.getName()) && (str2 == null || str2.equals(bluetoothDevice.getAddress()))) {
                String.format("Found device with name %s and address %s.", bluetoothDevice.getName(), bluetoothDevice.getAddress());
                return bluetoothDevice;
            }
        }
        Log.w(TAG, String.format("Unable to find device with name %s.", str));
        return null;
    }

    private String[] X() {
        return new String[]{SelectableItem.r(R.string.action_set_bluetooth_enable), SelectableItem.r(R.string.action_set_bluetooth_bluetooth), SelectableItem.r(R.string.action_set_bluetooth_toggle), SelectableItem.r(R.string.action_set_bluetooth_connect), SelectableItem.r(R.string.action_set_bluetooth_disconnect)};
    }

    private static Set<BluetoothDevice> Y(BluetoothAdapter bluetoothAdapter) {
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        if (bondedDevices == null) {
            return new HashSet();
        }
        return bondedDevices;
    }

    private Method Z() {
        try {
            return BluetoothA2dp.class.getDeclaredMethod("connect", BluetoothDevice.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private Method a0() {
        try {
            return BluetoothA2dp.class.getDeclaredMethod("disconnect", BluetoothDevice.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(String[] strArr, String[] strArr2, DialogInterface dialogInterface, int i4) {
        this.m_deviceName = strArr[i4];
        this.m_deviceAddress = strArr2[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_state;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_state >= X().length) {
            return SelectableItem.r(R.string.action_set_bluetooth_invalid);
        }
        return X()[this.m_state];
    }

    public BluetoothAdapter getDefaultAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        return this.mAdapter;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_state;
        if (i4 != 3 && i4 != 4) {
            return "";
        }
        return this.m_deviceName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetBluetoothActionInfo.getInstance();
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

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (Build.VERSION.SDK_INT < 33) {
            invokeActionLegacy(triggerContextInfo);
        } else {
            invokeActionViaHelperApp(triggerContextInfo);
        }
    }

    public void invokeActionLegacy(TriggerContextInfo triggerContextInfo) {
        BluetoothAdapter defaultAdapter = getDefaultAdapter();
        if (defaultAdapter == null) {
            return;
        }
        try {
            int i4 = this.m_state;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 4 && this.mAdapter.isEnabled()) {
                                new BluetoothA2DPRequester(this).request(getContext(), defaultAdapter);
                            }
                        } else {
                            U();
                        }
                    } else if (!this.mAdapter.isEnabled()) {
                        this.mAdapter.enable();
                    } else {
                        this.mAdapter.disable();
                    }
                } else {
                    this.mAdapter.disable();
                }
            } else {
                this.mAdapter.enable();
            }
        } catch (NullPointerException unused) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Null pointer in SetBluetooth action - invoke action"));
        } catch (SecurityException e4) {
            if (Build.VERSION.SDK_INT >= 31) {
                SystemLog.logError("Could not perform bluetooth action: " + e4.toString());
                PermissionsHelper.showNeedsPermission(getContext(), "android.permission.BLUETOOTH_CONNECT", getName(), true, false);
            }
        }
    }

    public void invokeActionViaHelperApp(TriggerContextInfo triggerContextInfo) {
        if (ApplicationChecker.getMacroDroidHelperVersionCode() >= 9) {
            SystemLog.logInfo("Sending request to helper file for Bluetooth action");
            HelperSystemCommands.sendBluetoothRequest(getContext(), this.m_state, this.m_deviceName, this.m_deviceAddress);
            return;
        }
        SystemLog.logError("Cannot set wifi, Helper App (V1.9+) is not installed. Please see: https://macrodroidforum.com/index.php?threads/macrodroid-helper-apk.1/", getMacroGuid().longValue());
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (this.m_state < X().length) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return X();
    }

    @Override // com.arlosoft.macrodroid.utils.BluetoothA2DPRequester.Callback
    public void onA2DPProxyReceived(BluetoothA2dp bluetoothA2dp) {
        BluetoothAdapter defaultAdapter = getDefaultAdapter();
        int i4 = this.m_state;
        if (i4 == 3) {
            Method Z = Z();
            BluetoothDevice W = W(defaultAdapter, this.m_deviceName, this.m_deviceAddress);
            if (Z != null && W != null) {
                try {
                    Z.setAccessible(true);
                    Z.invoke(bluetoothA2dp, W);
                    return;
                } catch (IllegalAccessException e4) {
                    SystemLog.logError("Illegal Access! %s", e4.toString());
                    return;
                } catch (InvocationTargetException e5) {
                    SystemLog.logError("Unable to invoke connect(BluetoothDevice) method on proxy. %s", e5.toString());
                    return;
                }
            }
            SystemLog.logError("Could not connect to audio device. Bluetooth device was null");
        } else if (i4 == 4) {
            Method a02 = a0();
            BluetoothDevice W2 = W(defaultAdapter, this.m_deviceName, this.m_deviceAddress);
            if (a02 != null && W2 != null) {
                try {
                    a02.setAccessible(true);
                    a02.invoke(bluetoothA2dp, W2);
                    return;
                } catch (IllegalAccessException e6) {
                    SystemLog.logError("Illegal Access! %s", e6.toString());
                    return;
                } catch (InvocationTargetException e7) {
                    SystemLog.logError("Unable to invoke connect(BluetoothDevice) method on proxy. %s", e7.toString());
                    return;
                }
            }
            SystemLog.logError("Could not connect to audio device. Bluetooth device was null");
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public Pair<Integer, String> requiresNewHelperFileVersion() {
        if (Build.VERSION.SDK_INT >= 33) {
            return new Pair<>(9, "1.9");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_state;
        if (i4 != 3 && i4 != 4) {
            itemComplete();
        } else if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            T();
        } else {
            V();
        }
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
        parcel.writeString(this.m_deviceName);
        parcel.writeString(this.m_deviceAddress);
    }

    public SetBluetoothAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetBluetoothAction() {
        this.m_connectReceiver = new a();
        this.m_state = 0;
        this.m_deviceName = "";
        this.m_connectToDevice = false;
    }

    private SetBluetoothAction(Parcel parcel) {
        super(parcel);
        this.m_connectReceiver = new a();
        this.m_state = parcel.readInt();
        this.m_deviceName = parcel.readString();
        this.m_deviceAddress = parcel.readString();
    }
}
