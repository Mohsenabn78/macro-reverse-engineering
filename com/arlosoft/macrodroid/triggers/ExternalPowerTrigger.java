package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.ExternalPowerTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.ExternalPowerTriggerReceiver;

/* loaded from: classes3.dex */
public class ExternalPowerTrigger extends Trigger {
    public static final int CONNECTED_OPTION_WIRED_FAST = 0;
    public static final int CONNECTED_OPTION_WIRED_SLOW = 2;
    public static final int CONNECTED_OPTION_WIRELESS = 1;
    public static final Parcelable.Creator<ExternalPowerTrigger> CREATOR = new a();
    private static ExternalPowerTriggerReceiver s_externalPowerConnectionTriggerReceiver;
    private static int s_triggerCounter;
    private boolean m_hasSetNewPowerConnectedOptions;
    private boolean m_hasSetUSBOption;
    private boolean m_powerConnected;
    private boolean[] m_powerConnectedOptions;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ExternalPowerTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExternalPowerTrigger createFromParcel(Parcel parcel) {
            return new ExternalPowerTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ExternalPowerTrigger[] newArray(int i4) {
            return new ExternalPowerTrigger[i4];
        }
    }

    /* synthetic */ ExternalPowerTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] Q() {
        return new String[]{SelectableItem.r(R.string.wired), SelectableItem.r(R.string.wireless), SelectableItem.r(R.string.wired_slow)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(DialogInterface dialogInterface, int i4, boolean z3) {
        this.m_powerConnectedOptions[i4] = z3;
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            boolean[] zArr = this.m_powerConnectedOptions;
            if (i5 >= zArr.length) {
                break;
            } else if (zArr[i5]) {
                z4 = true;
                break;
            } else {
                i5++;
            }
        }
        ((AlertDialog) dialogInterface).getButton(-1).setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(DialogInterface dialogInterface, int i4) {
        this.m_hasSetNewPowerConnectedOptions = true;
        this.m_hasSetUSBOption = true;
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_external_power_connected), MacroDroidApplication.getInstance().getString(R.string.trigger_external_power_disconnected)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_powerConnected = z3;
    }

    protected void P() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        this.m_powerConnectedOptions = getPowerConnectedOptions();
        builder.setMultiChoiceItems(Q(), this.m_powerConnectedOptions, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.triggers.p2
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i4, boolean z3) {
                ExternalPowerTrigger.this.R(dialogInterface, i4, z3);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.q2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ExternalPowerTrigger.this.S(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.r2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ExternalPowerTrigger.this.T(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.m_powerConnectedOptions;
            if (i4 >= zArr.length) {
                break;
            } else if (zArr[i4]) {
                z3 = true;
                break;
            } else {
                i4++;
            }
        }
        create.getButton(-1).setEnabled(z3);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_externalPowerConnectionTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_externalPowerConnectionTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_externalPowerConnectionTriggerReceiver = new ExternalPowerTriggerReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            intentFilter.setPriority(0);
            MacroDroidApplication.getInstance().registerReceiver(s_externalPowerConnectionTriggerReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_powerConnected ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_powerConnected) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        boolean[] powerConnectedOptions = getPowerConnectedOptions();
        this.m_powerConnectedOptions = powerConnectedOptions;
        String str = "";
        if (!this.m_powerConnected) {
            return "";
        }
        if (powerConnectedOptions[0] && powerConnectedOptions[2] && powerConnectedOptions[1]) {
            return SelectableItem.r(R.string.any);
        }
        boolean[] powerConnectedOptions2 = getPowerConnectedOptions();
        if (powerConnectedOptions2[0]) {
            str = "" + Q()[0];
            if (powerConnectedOptions2[1] || powerConnectedOptions2[2]) {
                str = str + " + ";
            }
        }
        if (powerConnectedOptions2[1]) {
            str = str + Q()[1];
            if (powerConnectedOptions2[2]) {
                str = str + " + ";
            }
        }
        if (powerConnectedOptions2[2]) {
            return str + Q()[2];
        }
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ExternalPowerTriggerInfo.getInstance();
    }

    public boolean getPowerConnected() {
        return this.m_powerConnected;
    }

    public boolean[] getPowerConnectedOptions() {
        if (!this.m_hasSetNewPowerConnectedOptions) {
            return new boolean[]{true, true, true};
        }
        if (!this.m_hasSetUSBOption) {
            boolean[] zArr = this.m_powerConnectedOptions;
            return new boolean[]{zArr[0], zArr[1], zArr[0]};
        }
        return this.m_powerConnectedOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_powerConnected) {
            P();
        } else {
            itemComplete();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_powerConnected ? 1 : 0);
        parcel.writeBooleanArray(this.m_powerConnectedOptions);
        parcel.writeInt(this.m_hasSetNewPowerConnectedOptions ? 1 : 0);
        parcel.writeInt(this.m_hasSetUSBOption ? 1 : 0);
    }

    public ExternalPowerTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ExternalPowerTrigger() {
        this.m_powerConnectedOptions = new boolean[3];
        this.m_powerConnected = true;
    }

    private ExternalPowerTrigger(Parcel parcel) {
        super(parcel);
        this.m_powerConnectedOptions = new boolean[3];
        this.m_powerConnected = parcel.readInt() != 0;
        this.m_powerConnectedOptions = parcel.createBooleanArray();
        this.m_hasSetNewPowerConnectedOptions = parcel.readInt() != 0;
        this.m_hasSetUSBOption = parcel.readInt() != 0;
    }
}
