package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.view.Display;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.ScreenOnActivity;
import com.arlosoft.macrodroid.action.info.ScreenOnActionInfo;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver;
import com.arlosoft.macrodroid.triggers.services.MacroDroidAccessibilityServiceJellyBean;
import com.google.firebase.messaging.Constants;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class ScreenOnAction extends Action {
    public static final Parcelable.Creator<ScreenOnAction> CREATOR = new b();
    private boolean m_pieLockScreen;
    private boolean m_screenOff;
    private boolean m_screenOffNoLock;
    private boolean m_screenOnAlternative;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            ScreenOnAction.super.handleItemSelected();
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<ScreenOnAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ScreenOnAction createFromParcel(Parcel parcel) {
            return new ScreenOnAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ScreenOnAction[] newArray(int i4) {
            return new ScreenOnAction[i4];
        }
    }

    /* synthetic */ ScreenOnAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] P() {
        return new String[]{SelectableItem.r(R.string.trigger_screen_on_off_pie_do_not_lock_screen), SelectableItem.r(R.string.trigger_screen_on_off_pie_lock_the_screen)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(DialogInterface dialogInterface, int i4) {
        boolean z3 = true;
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() != 1) {
            z3 = false;
        }
        this.m_pieLockScreen = z3;
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_screen_on_on), SelectableItem.r(R.string.action_screen_on_off), SelectableItem.r(R.string.action_screen_on_off_no_lock), SelectableItem.r(R.string.action_screen_on_alternative)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (i4 != 0 && i4 != 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_screenOff = z3;
        if (z3 && i4 == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.m_screenOffNoLock = z4;
        this.m_screenOnAlternative = (z3 || i4 != 3) ? false : false;
    }

    protected AlertDialog O() {
        if (getActivity() == null) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(P(), this.m_pieLockScreen ? 1 : 0, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ch
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ScreenOnAction.this.Q(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        return create;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.m_screenOff) {
            if (this.m_screenOffNoLock) {
                return 2;
            }
            return 1;
        } else if (this.m_screenOnAlternative) {
            return 3;
        } else {
            return 0;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_screenOff) {
            if (this.m_screenOffNoLock) {
                return getOptions()[2];
            }
            return getOptions()[1];
        }
        return getOptions()[0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        if (Build.VERSION.SDK_INT >= 28 && this.m_screenOff && !this.m_pieLockScreen && !Util.isMacroDroidAccessibilityEnabled(getContext())) {
            return SelectableItem.r(R.string.accessibility_description);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ScreenOnActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Settings.getShowScreenOnOffHelpPopup(getContext())) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(getName());
            builder.setMessage(getHelpInfo());
            builder.setPositiveButton(17039370, new a());
            builder.show();
            Settings.setShowScreenOnOffHelpPopup(getContext(), false);
            return;
        }
        super.handleItemSelected();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        try {
            getActivity().startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
        } catch (ActivityNotFoundException unused) {
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        PowerManager powerManager = (PowerManager) getContext().getSystemService("power");
        if (this.m_screenOff) {
            if (powerManager.isScreenOn()) {
                if (Build.VERSION.SDK_INT >= 28 && !this.m_pieLockScreen) {
                    Intent intent = new Intent(getContext(), MacroDroidAccessibilityServiceJellyBean.class);
                    intent.setAction(MacroDroidAccessibilityServiceJellyBean.ACTION_GLOBAL_CONTROL);
                    intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 8);
                    getContext().startService(intent);
                    return;
                } else if (this.m_screenOffNoLock) {
                    try {
                        Util.runAsRoot(new String[]{"input keyevent 26"});
                        return;
                    } catch (Exception e4) {
                        SystemLog.logError("Failed to run root command to turn off screen: " + e4.toString());
                        return;
                    }
                } else {
                    ComponentName componentName = new ComponentName(getContext(), MacroDroidDeviceAdminReceiver.class);
                    DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getContext().getSystemService("device_policy");
                    if (devicePolicyManager.isAdminActive(componentName)) {
                        try {
                            devicePolicyManager.lockNow();
                            return;
                        } catch (SecurityException unused) {
                            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) SelectableItem.r(R.string.action_screen_on_failed), 0).show();
                            return;
                        }
                    }
                    return;
                }
            }
            return;
        }
        powerManager.newWakeLock(805306378, "macrodroid:screenonaction").acquire(10000L);
        if (this.m_screenOnAlternative) {
            boolean z3 = false;
            for (Display display : ((DisplayManager) getContext().getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)).getDisplays()) {
                if (display.getState() != 1) {
                    z3 = true;
                }
            }
            if (!z3) {
                Intent intent2 = new Intent(getContext(), ScreenOnActivity.class);
                intent2.addFlags(268435456);
                getContext().startActivity(intent2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        t();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessibility() {
        if (Build.VERSION.SDK_INT >= 28 && this.m_screenOff && !this.m_pieLockScreen) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (this.m_screenOnAlternative && Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresDeviceAdmin() {
        if (Build.VERSION.SDK_INT >= 28 && !this.m_pieLockScreen) {
            return false;
        }
        return this.m_screenOff;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_screenOff) {
            if (Build.VERSION.SDK_INT >= 28) {
                O();
                return;
            } else {
                itemComplete();
                return;
            }
        }
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_screenOff ? 1 : 0);
        parcel.writeInt(this.m_screenOffNoLock ? 1 : 0);
        parcel.writeInt(this.m_screenOnAlternative ? 1 : 0);
        parcel.writeInt(this.m_pieLockScreen ? 1 : 0);
    }

    public ScreenOnAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ScreenOnAction() {
        this.m_pieLockScreen = false;
    }

    private ScreenOnAction(Parcel parcel) {
        super(parcel);
        this.m_pieLockScreen = false;
        this.m_screenOff = parcel.readInt() != 0;
        this.m_screenOffNoLock = parcel.readInt() != 0;
        this.m_screenOnAlternative = parcel.readInt() != 0;
        this.m_pieLockScreen = parcel.readInt() != 0;
    }
}
