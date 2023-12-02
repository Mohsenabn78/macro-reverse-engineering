package com.arlosoft.macrodroid.triggers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.VolumeButtonTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.VolumeReceiver;

/* loaded from: classes3.dex */
public class VolumeButtonTrigger extends Trigger {
    public static final int MONITOR_ACCESSIBILITY = 0;
    public static final int MONITOR_VOLUME_CHANGES = 1;
    private boolean m_dontChangeVolume;
    private int m_monitorOption;
    private boolean m_notConfigured;
    private int m_option;
    private transient int m_selectedMonitorOption;
    private transient int m_selectedOption;
    private static final VolumeReceiver s_volumeChangeReceiver = new VolumeReceiver();
    private static int s_triggerCounter = 0;
    public static final Parcelable.Creator<VolumeButtonTrigger> CREATOR = new a();

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<VolumeButtonTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VolumeButtonTrigger createFromParcel(Parcel parcel) {
            return new VolumeButtonTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VolumeButtonTrigger[] newArray(int i4) {
            return new VolumeButtonTrigger[i4];
        }
    }

    /* synthetic */ VolumeButtonTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void V() {
        String[] options;
        int i4;
        if (this.m_selectedMonitorOption == 1) {
            options = Y();
        } else {
            options = getOptions();
        }
        if (this.m_selectedMonitorOption == 1) {
            i4 = this.m_option % 2;
        } else {
            i4 = this.m_option;
        }
        this.m_selectedOption = i4;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setSingleChoiceItems(options, this.m_selectedOption, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.i9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                VolumeButtonTrigger.this.a0(dialogInterface, i5);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.j9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                VolumeButtonTrigger.this.b0(dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.k9
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                VolumeButtonTrigger.this.c0(dialogInterface);
            }
        });
    }

    @SuppressLint({"NewApi"})
    private void W() {
        String[] Z = Z();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setSingleChoiceItems(Z, !this.m_dontChangeVolume ? 1 : 0, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.l9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                VolumeButtonTrigger.this.d0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.m9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                VolumeButtonTrigger.this.e0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.n9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                VolumeButtonTrigger.this.f0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.o9
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                VolumeButtonTrigger.this.g0(dialogInterface);
            }
        });
    }

    private String[] X() {
        return new String[]{SelectableItem.r(R.string.trigger_volume_use_accessibility_service), SelectableItem.r(R.string.trigger_volume_monitor_volume_changes)};
    }

    private String[] Y() {
        return new String[]{SelectableItem.r(R.string.trigger_volume_button_up), SelectableItem.r(R.string.trigger_volume_button_down)};
    }

    private static final String[] Z() {
        return new String[]{SelectableItem.r(R.string.trigger_volume_button_retain), SelectableItem.r(R.string.trigger_volume_button_update)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i4) {
        this.m_selectedOption = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(DialogInterface dialogInterface, int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_dontChangeVolume = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(DialogInterface dialogInterface, int i4) {
        boolean isNotificationPolicyAccessGranted;
        this.m_monitorOption = this.m_selectedMonitorOption;
        this.m_option = this.m_selectedOption;
        this.m_notConfigured = false;
        itemComplete();
        int i5 = this.m_monitorOption;
        if (i5 == 0) {
            if (!Util.isMacroDroidVolumeAccessibilityEnabled(getContext())) {
                PermissionsHelper.showNeedsSpecialPermission(getContext(), getName(), 8);
            }
        } else if (Build.VERSION.SDK_INT >= 24 && i5 == 1) {
            isNotificationPolicyAccessGranted = ((NotificationManager) getContext().getSystemService("notification")).isNotificationPolicyAccessGranted();
            if (!isNotificationPolicyAccessGranted) {
                PermissionsHelper.showNeedsSpecialPermission(getContext(), getName(), 7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_volume_button_up), SelectableItem.r(R.string.trigger_volume_button_down), SelectableItem.r(R.string.trigger_volume_button_up) + " - " + SelectableItem.r(R.string.trigger_media_button_pressed_long_press), SelectableItem.r(R.string.trigger_volume_button_down) + " - " + SelectableItem.r(R.string.trigger_media_button_pressed_long_press)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(DialogInterface dialogInterface, int i4) {
        super.handleItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_selectedMonitorOption = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            MacroDroidApplication.getInstance().unregisterReceiver(s_volumeChangeReceiver);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            intentFilter.setPriority(1000);
            MacroDroidApplication.getInstance().registerReceiver(s_volumeChangeReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_monitorOption;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String[] Z = Z();
        if (this.m_dontChangeVolume) {
            return Z[0];
        }
        return Z[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return VolumeButtonTriggerInfo.getInstance();
    }

    public int getMonitorOption() {
        return this.m_monitorOption;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Settings.getShownVolumeButtonWarning(getContext())) {
            super.handleItemSelected();
            return;
        }
        String r4 = SelectableItem.r(R.string.trigger_volume_button_help);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.trigger_volume_button);
        builder.setMessage(r4);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.h9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                VolumeButtonTrigger.this.h0(dialogInterface, i4);
            }
        });
        builder.show();
        Settings.setShownVolumeButtonWarning(getContext(), true);
    }

    public boolean isDontChangeVolume() {
        return this.m_dontChangeVolume;
    }

    public boolean isLongPress() {
        int i4 = this.m_option;
        if (i4 != 2 && i4 != 3) {
            return false;
        }
        return true;
    }

    public boolean isVolumeUp() {
        int i4 = this.m_option;
        if (i4 != 0 && i4 != 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return X();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessNotificationPolicy() {
        if (Settings.getIgnoreDoNotDisturb(getContext()) || Build.VERSION.SDK_INT < 24 || this.m_monitorOption != 1 || this.m_notConfigured) {
            return false;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresVolumeButtonAccessibility() {
        if (this.m_monitorOption == 0 && !this.m_notConfigured) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        V();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_monitorOption);
        parcel.writeInt(this.m_option);
        parcel.writeInt(!this.m_dontChangeVolume ? 1 : 0);
    }

    public VolumeButtonTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_notConfigured = true;
    }

    private VolumeButtonTrigger() {
        this.m_dontChangeVolume = true;
    }

    private VolumeButtonTrigger(Parcel parcel) {
        super(parcel);
        this.m_monitorOption = parcel.readInt();
        this.m_option = parcel.readInt();
        this.m_dontChangeVolume = parcel.readInt() == 0;
    }
}
