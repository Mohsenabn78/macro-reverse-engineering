package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.QuickSettingsTilesUpdatedEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.quicksettings.QuickSettingButton;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsActivity;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsArrayAdapter;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsData;
import com.arlosoft.macrodroid.triggers.info.QuickSettingsTileTriggerInfo;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService1;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService10;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService11;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService12;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService13;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService14;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService15;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService16;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService2;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService3;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService4;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService5;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService6;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService7;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService8;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService9;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class QuickSettingsTileTrigger extends Trigger {
    public static final Parcelable.Creator<QuickSettingsTileTrigger> CREATOR = new a();
    public static final int OPTION_LONG_PRESS = 2;
    public static final int OPTION_TOGGLE_OFF = 1;
    public static final int OPTION_TOGGLE_ON = 0;
    private static final int REQUEST_CODE_QUICK_SETTINGS = 9212945;
    private transient ArrayAdapter itemsAdapter;
    private transient ListView listView;
    private int m_tileOption;
    private int m_toggleOption;
    private transient QuickSettingsData quickSettingCachedData;
    private String quickTileImageName;
    private boolean quickTileIsCollapseOnPress;
    private boolean quickTileIsToggle;
    private String quickTileLabel;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<QuickSettingsTileTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public QuickSettingsTileTrigger createFromParcel(Parcel parcel) {
            return new QuickSettingsTileTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public QuickSettingsTileTrigger[] newArray(int i4) {
            return new QuickSettingsTileTrigger[i4];
        }
    }

    /* synthetic */ QuickSettingsTileTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void S() {
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog_Trigger);
        appCompatDialog.setContentView(R.layout.dialog_quick_settings_trigger);
        appCompatDialog.setTitle(R.string.select_option);
        this.listView = (ListView) appCompatDialog.findViewById(R.id.list);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.configure_tiles);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.r6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickSettingsTileTrigger.X(activity, view);
            }
        });
        QuickSettingsArrayAdapter quickSettingsArrayAdapter = new QuickSettingsArrayAdapter(appCompatDialog.getContext(), U(), V());
        this.itemsAdapter = quickSettingsArrayAdapter;
        this.listView.setAdapter((ListAdapter) quickSettingsArrayAdapter);
        this.listView.setChoiceMode(1);
        this.listView.setSelection(this.m_tileOption);
        this.listView.setItemChecked(this.m_tileOption, true);
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.s6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickSettingsTileTrigger.this.Y(appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.t6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickSettingsTileTrigger.this.Z(appCompatDialog, view);
            }
        });
        appCompatDialog.show();
    }

    private String[] U() {
        String str;
        QuickSettingsData quickSettingsData = (QuickSettingsData) MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        int length = getOptions().length;
        String[] strArr = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            if (quickSettingsData != null) {
                str = quickSettingsData.getQSButtonList().get(i4).getLabel();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = getOptions()[i4];
            }
            strArr[i4] = str;
        }
        return strArr;
    }

    private boolean[] V() {
        QuickSettingsData quickSettingsData = (QuickSettingsData) MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        if (quickSettingsData == null) {
            quickSettingsData = QuickSettingsData.createDefault();
        }
        List<QuickSettingButton> qSButtonList = quickSettingsData.getQSButtonList();
        boolean[] zArr = new boolean[16];
        for (int i4 = 0; i4 < qSButtonList.size() && i4 < 16; i4++) {
            zArr[i4] = qSButtonList.get(i4).getEnabled();
        }
        return zArr;
    }

    private String[] W() {
        return new String[]{SelectableItem.r(R.string.trigger_quick_settings_option_toggle_on), SelectableItem.r(R.string.trigger_quick_settings_option_toggle_off), SelectableItem.r(R.string.trigger_media_button_pressed_long_press)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(Activity activity, View view) {
        activity.startActivityForResult(new Intent(activity, QuickSettingsActivity.class), REQUEST_CODE_QUICK_SETTINGS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(AppCompatDialog appCompatDialog, View view) {
        this.m_tileOption = this.listView.getCheckedItemPosition();
        appCompatDialog.dismiss();
        T();
        this.listView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(AppCompatDialog appCompatDialog, View view) {
        appCompatDialog.dismiss();
        this.listView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i4) {
        this.m_toggleOption = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.macrodroid_tile_1), SelectableItem.r(R.string.macrodroid_tile_2), SelectableItem.r(R.string.macrodroid_tile_3), SelectableItem.r(R.string.macrodroid_tile_4), SelectableItem.r(R.string.macrodroid_tile_5), SelectableItem.r(R.string.macrodroid_tile_6), SelectableItem.r(R.string.macrodroid_tile_7), SelectableItem.r(R.string.macrodroid_tile_8), SelectableItem.r(R.string.macrodroid_tile_9), SelectableItem.r(R.string.macrodroid_tile_10), SelectableItem.r(R.string.macrodroid_tile_11), SelectableItem.r(R.string.macrodroid_tile_12), SelectableItem.r(R.string.macrodroid_tile_13), SelectableItem.r(R.string.macrodroid_tile_14), SelectableItem.r(R.string.macrodroid_tile_15), SelectableItem.r(R.string.macrodroid_tile_16)};
    }

    protected void T() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setSingleChoiceItems(W(), this.m_toggleOption, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.u6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.v6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                QuickSettingsTileTrigger.this.b0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.w6
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                QuickSettingsTileTrigger.this.c0(dialogInterface);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void applyImport() {
        preApplyImport();
        postApplyImport();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void configureForExport() {
        QuickSettingsData quickSettingsData = (QuickSettingsData) MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        if (quickSettingsData != null) {
            try {
                QuickSettingButton quickSettingButton = quickSettingsData.getQSButtonList().get(this.m_tileOption);
                this.quickTileLabel = quickSettingButton.getLabel();
                this.quickTileImageName = quickSettingButton.getImageName();
                this.quickTileIsToggle = quickSettingButton.isToggle();
                this.quickTileIsCollapseOnPress = quickSettingButton.getCollapseOnPress();
            } catch (Exception e4) {
                SystemLog.logError("Failed to export quick tile data: " + e4);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean doesSupportPreApply() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        int i4 = this.m_toggleOption;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return "";
                }
                return SelectableItem.r(R.string.trigger_media_button_pressed_long_press);
            }
            return SelectableItem.r(R.string.quick_tile_off);
        }
        return SelectableItem.r(R.string.quick_tile_on_press);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        QuickSettingsData quickSettingsData = (QuickSettingsData) MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        if (quickSettingsData != null) {
            str = quickSettingsData.getQSButtonList().get(this.m_tileOption).getLabel();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return getOptions()[this.m_tileOption];
        }
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return QuickSettingsTileTriggerInfo.getInstance();
    }

    public int getTileNumber() {
        return this.m_tileOption + 1;
    }

    public int getToggleOption() {
        return this.m_toggleOption;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        if (i4 == REQUEST_CODE_QUICK_SETTINGS && i5 == -1 && this.itemsAdapter != null && this.listView != null) {
            QuickSettingsArrayAdapter quickSettingsArrayAdapter = new QuickSettingsArrayAdapter(new ContextThemeWrapper(activity, (int) R.style.Theme_App_Dialog_Trigger), U(), V());
            this.itemsAdapter = quickSettingsArrayAdapter;
            this.listView.setAdapter((ListAdapter) quickSettingsArrayAdapter);
            this.listView.setSelection(this.m_tileOption);
            this.listView.setItemChecked(this.m_tileOption, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Build.VERSION.SDK_INT < 24) {
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (SelectableItem.r(R.string.sorry_this_feature_requires_android_version) + "7.0+"), 0).show();
            return;
        }
        S();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void postApplyImport() {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        Cache cache = MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE);
        QuickSettingsData quickSettingsData = (QuickSettingsData) cache.get(QuickSettingsData.QUICK_SETTINGS_IMPORT_DATA_KEY, QuickSettingsData.class);
        if (quickSettingsData != null) {
            cache.put(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, quickSettingsData);
            cache.put(QuickSettingsData.QUICK_SETTINGS_IMPORT_DATA_KEY, null);
            EventBusUtils.getEventBus().post(new QuickSettingsTilesUpdatedEvent(quickSettingsData));
            Class[] clsArr = {MacroDroidTileService1.class, MacroDroidTileService2.class, MacroDroidTileService3.class, MacroDroidTileService4.class, MacroDroidTileService5.class, MacroDroidTileService6.class, MacroDroidTileService7.class, MacroDroidTileService8.class, MacroDroidTileService9.class, MacroDroidTileService10.class, MacroDroidTileService11.class, MacroDroidTileService12.class, MacroDroidTileService13.class, MacroDroidTileService14.class, MacroDroidTileService15.class, MacroDroidTileService16.class};
            for (int i4 = 0; i4 < 16; i4++) {
                PackageManager packageManager = getContext().getPackageManager();
                ComponentName componentName = new ComponentName(BuildConfig.APPLICATION_ID, clsArr[i4].getName());
                if (quickSettingsData.getQSButtonList().get(i4).getEnabled()) {
                    packageManager.setComponentEnabledSetting(componentName, 1, 1);
                } else {
                    packageManager.setComponentEnabledSetting(componentName, 2, 1);
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void preApplyImport() {
        if (this.quickTileLabel == null) {
            return;
        }
        Cache cache = MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE);
        QuickSettingsData quickSettingsData = (QuickSettingsData) cache.get(QuickSettingsData.QUICK_SETTINGS_IMPORT_DATA_KEY, QuickSettingsData.class);
        if (quickSettingsData == null && (quickSettingsData = (QuickSettingsData) cache.get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class)) == null) {
            quickSettingsData = QuickSettingsData.createDefault();
        }
        List<QuickSettingButton> qSButtonList = quickSettingsData.getQSButtonList();
        boolean z3 = false;
        for (int i4 = 0; i4 < qSButtonList.size(); i4++) {
            if (qSButtonList.get(i4).getLabel().equals(this.quickTileLabel)) {
                this.m_tileOption = i4;
                return;
            }
        }
        if (!qSButtonList.get(this.m_tileOption).getEnabled()) {
            quickSettingsData.replaceButtonAtIndex(this.m_tileOption, new QuickSettingButton(this.quickTileLabel, 0, true, this.quickTileIsToggle, false, this.quickTileIsCollapseOnPress, this.quickTileImageName));
            cache.put(QuickSettingsData.QUICK_SETTINGS_IMPORT_DATA_KEY, quickSettingsData);
            return;
        }
        int i5 = this.m_tileOption;
        int i6 = 0;
        while (true) {
            if (i6 >= qSButtonList.size()) {
                break;
            } else if (!qSButtonList.get(i6).getEnabled()) {
                qSButtonList.get(i6);
                this.m_tileOption = i6;
                z3 = true;
                break;
            } else {
                i6++;
            }
        }
        if (z3) {
            quickSettingsData.replaceButtonAtIndex(this.m_tileOption, new QuickSettingButton(this.quickTileLabel, 0, true, this.quickTileIsToggle, false, this.quickTileIsCollapseOnPress, this.quickTileImageName));
            cache.put(QuickSettingsData.QUICK_SETTINGS_IMPORT_DATA_KEY, quickSettingsData);
            SystemLog.logDebug("Tile " + i5 + " was already in use, so tile number " + this.m_tileOption + " was used instead");
            return;
        }
        SystemLog.logWarning("Could not find a free quick settings tile to use. Manual configuration will be required");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_tileOption);
        parcel.writeInt(this.m_toggleOption);
        parcel.writeString(this.quickTileLabel);
        parcel.writeString(this.quickTileImageName);
        parcel.writeInt(this.quickTileIsToggle ? 1 : 0);
        parcel.writeInt(this.quickTileIsCollapseOnPress ? 1 : 0);
    }

    public QuickSettingsTileTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public QuickSettingsTileTrigger() {
    }

    private QuickSettingsTileTrigger(Parcel parcel) {
        super(parcel);
        this.m_tileOption = parcel.readInt();
        this.m_toggleOption = parcel.readInt();
        this.quickTileLabel = parcel.readString();
        this.quickTileImageName = parcel.readString();
        this.quickTileIsToggle = parcel.readInt() != 0;
        this.quickTileIsCollapseOnPress = parcel.readInt() != 0;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
