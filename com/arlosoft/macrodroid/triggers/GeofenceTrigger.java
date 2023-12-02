package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.geofences.GeofenceListActivity;
import com.arlosoft.macrodroid.geofences.GeofenceManager;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.GeofenceTriggerInfo;
import com.arlosoft.macrodroid.triggers.interfaces.HasGeofence;
import javax.inject.Inject;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class GeofenceTrigger extends Trigger implements HasGeofence {
    public static final Parcelable.Creator<GeofenceTrigger> CREATOR = new c();
    private static final int SELECT_GEOFENCE = 878;
    private static int s_triggerCounter;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    transient GeofenceManager f14366c;
    private boolean m_enterArea;
    private String m_geofenceId;
    private int m_geofenceUpdateRateMinutes;
    private transient PendingIntent m_pendingIntent;
    private boolean m_triggerFromUnknown;
    private String m_updateRateText;
    private transient String oldGeofenceId;
    private transient TextView zoneNameButton;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GeofenceTrigger.this.b0();
        }
    }

    /* loaded from: classes3.dex */
    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            GeofenceTrigger.this.zoneNameButton = null;
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<GeofenceTrigger> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GeofenceTrigger createFromParcel(Parcel parcel) {
            return new GeofenceTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GeofenceTrigger[] newArray(int i4) {
            return new GeofenceTrigger[i4];
        }
    }

    /* synthetic */ GeofenceTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String T() {
        return this.f14366c.getGeofenceName(this.m_geofenceId);
    }

    private int U() {
        int i4 = this.m_geofenceUpdateRateMinutes;
        if (i4 == 0) {
            return 30000;
        }
        return i4 * 60 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(TextView textView, View view) {
        a0(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(RadioButton radioButton, CheckBox checkBox, AppCompatDialog appCompatDialog, View view) {
        if (this.m_geofenceId != null) {
            String str = this.oldGeofenceId;
            if (str != null) {
                this.f14366c.removeGeofenceSubscription(str, getSIGUID(), getMacro().getName(), getMacroGuid().longValue());
            }
            this.m_enterArea = radioButton.isChecked();
            this.m_triggerFromUnknown = checkBox.isChecked();
            appCompatDialog.dismiss();
            itemComplete();
            return;
        }
        ToastCompat.makeText(getContext(), (int) R.string.select_zone, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface, int i4) {
        C(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(String[] strArr, int[] iArr, TextView textView, DialogInterface dialogInterface, int i4) {
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        String str = strArr[checkedItemPosition];
        this.m_updateRateText = str;
        this.m_geofenceUpdateRateMinutes = iArr[checkedItemPosition];
        textView.setText(str);
    }

    private void a0(final TextView textView) {
        final String[] stringArray = getContext().getResources().getStringArray(R.array.geofence_trigger_update_rate_names);
        final int[] intArray = getContext().getResources().getIntArray(R.array.geofence_trigger_update_rates_int);
        int length = intArray.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (intArray[i5] == this.m_geofenceUpdateRateMinutes) {
                i4 = i6;
                break;
            } else {
                i6++;
                i5++;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(stringArray, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.i3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                GeofenceTrigger.this.Y(dialogInterface, i7);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.j3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                GeofenceTrigger.this.Z(stringArray, intArray, textView, dialogInterface, i7);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, GeofenceListActivity.class);
        intent.putExtra("ThemeType", 1);
        intent.putExtra(GeofenceListActivity.EXTRA_PICKER_MODE, true);
        activity.startActivityForResult(intent, SELECT_GEOFENCE);
    }

    private void init() {
        MacroDroidApplication.appComponentInstance.inject(this);
        this.m_enterArea = true;
        this.m_geofenceUpdateRateMinutes = 5;
        this.m_updateRateText = SelectableItem.r(R.string.minutes_5);
    }

    @Override // com.arlosoft.macrodroid.triggers.interfaces.HasGeofence
    public void clearGeofenceId() {
        this.m_geofenceId = null;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        String str = this.m_geofenceId;
        if (str != null) {
            this.f14366c.removeGeofenceSubscription(str, getSIGUID(), getMacro().getName(), getMacroGuid().longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        String str = this.m_geofenceId;
        if (str != null) {
            this.f14366c.addGeofenceSubscription(str, getSIGUID(), U(), getMacro().getName(), getMacroGuid().longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        int i4;
        if (this.m_enterArea) {
            i4 = R.string.trigger_geofence_enter;
        } else {
            i4 = R.string.trigger_geofence_exited;
        }
        return SelectableItem.r(i4);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return T();
    }

    @Override // com.arlosoft.macrodroid.triggers.interfaces.HasGeofence
    public String getGeofenceId() {
        return this.m_geofenceId;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return GeofenceTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public TriggerContextInfo getTestTriggerContentInfo() {
        return new TriggerContextInfo(this, "Testing: lat?,lon?");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == SELECT_GEOFENCE && i5 == -1 && this.zoneNameButton != null) {
            this.oldGeofenceId = this.m_geofenceId;
            this.m_geofenceId = intent.getStringExtra(GeofenceListActivity.EXTRA_SELECTED_GEOFENCE_ID);
            this.zoneNameButton.setText(T());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_geofence_configure);
        appCompatDialog.setTitle(R.string.select_option);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.area_enter_option);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.area_exit_option);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.location_unknown_checkbox);
        final TextView textView = (TextView) appCompatDialog.findViewById(R.id.update_frequency_link);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        this.zoneNameButton = (TextView) appCompatDialog.findViewById(R.id.zone_name_button);
        ((ViewGroup) appCompatDialog.findViewById(R.id.update_rate_container)).setVisibility(0);
        ((TextView) appCompatDialog.findViewById(R.id.update_rate_description)).setVisibility(0);
        textView.setText(this.m_updateRateText);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.f3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeofenceTrigger.this.V(textView, view);
            }
        });
        String T = T();
        TextView textView2 = this.zoneNameButton;
        if (TextUtils.isEmpty(T)) {
            T = "<" + SelectableItem.r(R.string.select_zone) + ">";
        }
        textView2.setText(T);
        TextView textView3 = this.zoneNameButton;
        textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        this.zoneNameButton.setOnClickListener(new a());
        if (this.m_enterArea) {
            radioButton.setChecked(true);
        } else {
            radioButton2.setChecked(true);
        }
        checkBox.setChecked(this.m_triggerFromUnknown);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.g3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeofenceTrigger.this.W(radioButton, checkBox, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.h3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
        appCompatDialog.setOnDismissListener(new b());
    }

    public boolean isEnter() {
        return this.m_enterArea;
    }

    public boolean isTriggerFromUnknown() {
        return this.m_enterArea;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLocationServicesEnabled() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(!this.m_enterArea ? 1 : 0);
        parcel.writeInt(!this.m_triggerFromUnknown ? 1 : 0);
        parcel.writeString(this.m_geofenceId);
        parcel.writeInt(this.m_geofenceUpdateRateMinutes);
        parcel.writeString(this.m_updateRateText);
    }

    public GeofenceTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public GeofenceTrigger() {
        this.oldGeofenceId = null;
        this.zoneNameButton = null;
        init();
    }

    private GeofenceTrigger(Parcel parcel) {
        super(parcel);
        this.oldGeofenceId = null;
        this.zoneNameButton = null;
        init();
        this.m_enterArea = parcel.readInt() == 0;
        this.m_triggerFromUnknown = parcel.readInt() == 0;
        this.m_geofenceId = parcel.readString();
        this.m_geofenceUpdateRateMinutes = parcel.readInt();
        this.m_updateRateText = parcel.readString();
    }
}
