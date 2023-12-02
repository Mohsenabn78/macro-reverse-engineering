package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetHotspotActionInfo;
import com.arlosoft.macrodroid.action.services.WifiHotspotService;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class SetHotspotAction extends Action {
    public static final Parcelable.Creator<SetHotspotAction> CREATOR = new a();
    private int m_state;
    private boolean m_turnWifiOn;
    private boolean m_useLegacyMechanism;
    private int mechanism;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetHotspotAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetHotspotAction createFromParcel(Parcel parcel) {
            return new SetHotspotAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetHotspotAction[] newArray(int i4) {
            return new SetHotspotAction[i4];
        }
    }

    /* synthetic */ SetHotspotAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] T() {
        return new String[]{SelectableItem.r(R.string.action_set_hotspot_enable), SelectableItem.r(R.string.action_set_hotspot_disable), SelectableItem.r(R.string.action_set_hotspot_toggle)};
    }

    private String[] U() {
        return new String[]{SelectableItem.r(R.string.action_set_hotspot_enable_wifi), SelectableItem.r(R.string.action_set_hotspot_disable_wifi)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(CheckBox checkBox, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            checkBox.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(CheckBox checkBox, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            checkBox.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(CheckBox checkBox, CheckBox checkBox2, AppCompatDialog appCompatDialog, RadioButton radioButton, RadioButton radioButton2, Activity activity, View view) {
        int i4;
        this.m_useLegacyMechanism = checkBox.isChecked();
        this.mechanism = checkBox2.isChecked() ? 1 : 0;
        appCompatDialog.dismiss();
        if (radioButton.isChecked()) {
            i4 = 0;
        } else if (radioButton2.isChecked()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        this.m_state = i4;
        if (i4 > 0) {
            c0(activity);
        } else {
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(DialogInterface dialogInterface, int i4) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_turnWifiOn = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    private void c0(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(R.string.action_set_hotspot_when_ap_disabled);
        builder.setSingleChoiceItems(U(), !this.m_turnWifiOn ? 1 : 0, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.nj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetHotspotAction.this.a0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.oj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetHotspotAction.this.b0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return T()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_state == 1) {
            return U()[1 ^ (this.m_turnWifiOn ? 1 : 0)];
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetHotspotActionInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_hotspot);
        builder.setMessage(R.string.hotspot_warning);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ij
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetHotspotAction.this.Z(dialogInterface, i4);
            }
        });
        builder.show();
        Settings.setShownNotificationLightWarning(getContext(), true);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            Intent intent = new Intent(getContext(), WifiHotspotService.class);
            intent.putExtra(WifiHotspotService.FORCE_LEGACY_MECHANISM_EXTRA, this.m_useLegacyMechanism);
            intent.putExtra(WifiHotspotService.WIFI_AP_STATE_EXTRA, this.m_state);
            intent.putExtra(WifiHotspotService.TURN_ON_WIFI_EXTRA, this.m_turnWifiOn);
            intent.putExtra(WifiHotspotService.MECHANISM, this.mechanism);
            intent.putExtra("com.arlosoft.macrodroid.MACRO_NAME", getMacro().getName());
            getContext().startService(intent);
        } catch (IllegalStateException e4) {
            SystemLog.logError("Could not start hotspot service - foreground service not enabled? " + e4.toString(), getMacroGuid().longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected AlertDialog l() {
        boolean z3;
        boolean z4;
        boolean z5;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_hotspot_options);
        appCompatDialog.setTitle(R.string.action_set_hotspot);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.enable_hotspot);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.disable_hotspot);
        RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.toggle_hotspot);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.force_legacy_setting);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.alternative_mechanism);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 25) {
            checkBox.setVisibility(8);
        }
        checkBox.setChecked(this.m_useLegacyMechanism);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.jj
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                SetHotspotAction.V(checkBox2, compoundButton, z6);
            }
        });
        if (i4 < 26) {
            checkBox2.setVisibility(8);
        }
        boolean z6 = false;
        if (this.mechanism == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        checkBox2.setChecked(z3);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.kj
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                SetHotspotAction.W(checkBox, compoundButton, z7);
            }
        });
        if (this.m_state == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        radioButton.setChecked(z4);
        if (this.m_state == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        radioButton2.setChecked(z5);
        if (this.m_state == 2) {
            z6 = true;
        }
        radioButton3.setChecked(z6);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.lj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetHotspotAction.this.X(checkBox, checkBox2, appCompatDialog, radioButton, radioButton2, activity, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.mj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public Pair<Integer, String> requiresNewHelperFileVersion() {
        Pair<Integer, String> pair;
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi") && Build.VERSION.SDK_INT >= 31) {
            pair = new Pair<>(8, "1.8");
        } else {
            pair = new Pair<>(2, "1.2");
        }
        if (Build.VERSION.SDK_INT < 29 || RootToolsHelper.isAccessGiven() || !this.m_turnWifiOn || this.m_state == 0) {
            return null;
        }
        return pair;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresWriteSettings() {
        return true;
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
        parcel.writeInt(this.m_turnWifiOn ? 1 : 0);
        parcel.writeInt(this.m_useLegacyMechanism ? 1 : 0);
        parcel.writeInt(this.mechanism);
    }

    public SetHotspotAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetHotspotAction() {
        this.mechanism = 0;
        this.m_state = 0;
        this.m_turnWifiOn = true;
    }

    private SetHotspotAction(Parcel parcel) {
        super(parcel);
        this.mechanism = 0;
        this.m_state = parcel.readInt();
        this.m_turnWifiOn = parcel.readInt() != 0;
        this.m_useLegacyMechanism = parcel.readInt() != 0;
        this.mechanism = parcel.readInt();
    }
}
