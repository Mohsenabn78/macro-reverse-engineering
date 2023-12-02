package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.geofences.GeofenceInfo;
import com.arlosoft.macrodroid.geofences.GeofenceListActivity;
import com.arlosoft.macrodroid.geofences.GeofenceStore;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.LocationTriggerInfo;
import com.arlosoft.macrodroid.triggers.interfaces.HasGeofence;
import com.arlosoft.macrodroid.triggers.receivers.RequestLocationReceiver;
import com.arlosoft.macrodroid.triggers.services.LocationTriggerAreaChecker;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public class LocationTrigger extends Trigger implements HasGeofence {
    public static final String LATITUDE_EXTRA = "Latitude";
    public static final String LONGITUDE_EXTRA = "Longitude";
    private static final int MIN_UPDATE_DISTANCE_M = 3;
    private static final int MIN_UPDATE_RATE_MS = 1000;
    private static final int SELECT_GEOFENCE = 878;
    private static final int TRIGGER_FROM_UNKNOWN_DISABLED = 2;
    private static final int TRIGGER_FROM_UNKNOWN_ENABLED = 1;
    private static final int TRIGGER_FROM_UNKNOWN_NOT_SET = 0;
    private static int s_triggerCounter;
    private static c s_updateRateReceiver;
    private transient Cache m_cache;
    private boolean m_dontTriggerFromUnknownEnter;
    private boolean m_enterArea;
    private String m_geofenceId;
    private transient GeofenceInfo m_geofenceInfo;
    private transient GeofenceStore m_geofenceStore;
    private double m_latitude;
    private transient LocationManager m_locationManager;
    private double m_longitude;
    private int m_newTriggerFromUnknown;
    private int m_radius;
    private boolean m_triggerFromUnknown;
    private static final LocationListener locationUpdateListenerLocal = new a();
    public static final Parcelable.Creator<LocationTrigger> CREATOR = new b();

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<LocationTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LocationTrigger createFromParcel(Parcel parcel) {
            return new LocationTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LocationTrigger[] newArray(int i4) {
            return new LocationTrigger[i4];
        }
    }

    /* loaded from: classes3.dex */
    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LocationTrigger.scheduleNextWakeup(context, true);
        }

        /* synthetic */ c(LocationTrigger locationTrigger, a aVar) {
            this();
        }
    }

    /* synthetic */ LocationTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void P() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.trigger_location);
        builder.setMessage(R.string.location_trigger_legacy_warning);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.x4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                LocationTrigger.this.Q(dialogInterface, i4);
            }
        });
        builder.show();
        Settings.setShownNotificationLightWarning(getContext(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(DialogInterface dialogInterface, int i4) {
        T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(RadioButton radioButton, CheckBox checkBox, AppCompatDialog appCompatDialog, View view) {
        int i4;
        this.m_enterArea = radioButton.isChecked();
        if (checkBox.isChecked()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        this.m_newTriggerFromUnknown = i4;
        appCompatDialog.dismiss();
        U();
    }

    private void U() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, GeofenceListActivity.class);
        intent.putExtra("ThemeType", 1);
        intent.putExtra(GeofenceListActivity.EXTRA_PICKER_MODE, true);
        activity.startActivityForResult(intent, SELECT_GEOFENCE);
    }

    public static void forceUpdate() {
        MacroDroidApplication.getInstance().sendBroadcast(new Intent(Util.LOC_UPDATE_RATE_INTENT));
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_location_area_entered), MacroDroidApplication.getInstance().getString(R.string.trigger_location_area_exited)};
    }

    private void init() {
        this.m_newTriggerFromUnknown = 0;
        this.m_cache = MacroDroidApplication.getInstance().getCache("GeofenceInfo");
        this.m_enterArea = true;
        this.m_locationManager = (LocationManager) getContext().getSystemService(FirebaseAnalytics.Param.LOCATION);
        updateGeofenceStore();
        this.m_geofenceInfo = this.m_geofenceStore.getGeofenceMap().get(this.m_geofenceId);
    }

    public static void scheduleNextWakeup(Context context, boolean z3) {
        int locationUpdateRateSeconds;
        if (z3) {
            locationUpdateRateSeconds = 1;
        } else {
            locationUpdateRateSeconds = Settings.getLocationUpdateRateSeconds(context);
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        AlarmHelper.scheduleExactAlarmWithInexactFallback(0, System.currentTimeMillis() + (locationUpdateRateSeconds * 1000), PendingIntent.getBroadcast(context, 0, new Intent(context, RequestLocationReceiver.class), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE), true);
    }

    protected void T() {
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
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        if (this.m_enterArea) {
            radioButton.setChecked(true);
        } else {
            radioButton2.setChecked(true);
        }
        checkBox.setChecked(getTriggerFromUnknown());
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.y4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocationTrigger.this.R(radioButton, checkBox, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.z4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.triggers.interfaces.HasGeofence
    public void clearGeofenceId() {
        this.m_geofenceId = null;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                this.m_locationManager.removeUpdates(locationUpdateListenerLocal);
            } catch (Throwable unused) {
                SystemLog.logError("Failed to remove passive location listener");
            }
            if (s_updateRateReceiver != null) {
                try {
                    getContext().unregisterReceiver(s_updateRateReceiver);
                } catch (Exception e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(e4);
                }
                s_updateRateReceiver = null;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        updateGeofenceStore();
        this.m_geofenceInfo = this.m_geofenceStore.getGeofenceMap().get(this.m_geofenceId);
        if (s_triggerCounter == 0) {
            scheduleNextWakeup(getContext(), true);
            IntentFilter intentFilter = new IntentFilter(Util.LOC_UPDATE_RATE_INTENT);
            s_updateRateReceiver = new c(this, null);
            getContext().registerReceiver(s_updateRateReceiver, intentFilter);
            try {
                if (this.m_locationManager.isProviderEnabled("passive")) {
                    this.m_locationManager.requestLocationUpdates("passive", 1000L, 3.0f, locationUpdateListenerLocal);
                }
            } catch (Throwable th) {
                if (!(th instanceof SecurityException)) {
                    FirebaseAnalyticsEventLogger.logHandledException(th);
                }
            }
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_enterArea) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_latitude == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && this.m_longitude == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            GeofenceInfo geofenceInfo = this.m_geofenceStore.getGeofenceMap().get(this.m_geofenceId);
            if (geofenceInfo != null) {
                return geofenceInfo.getName();
            }
            return "<" + SelectableItem.r(R.string.select_zone) + ">";
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.triggers.interfaces.HasGeofence
    public String getGeofenceId() {
        return this.m_geofenceId;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LocationTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public Location getLocation() {
        Location location = new Location("");
        if (this.m_longitude == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && this.m_latitude == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            GeofenceInfo geofenceInfo = this.m_geofenceInfo;
            if (geofenceInfo != null) {
                location.setLatitude(geofenceInfo.getLatitude());
                location.setLongitude(this.m_geofenceInfo.getLongitude());
                location.setAccuracy(this.m_geofenceInfo.getRadius());
            } else {
                SystemLog.logError("Geofence not found for macro: " + getMacro().getName());
                location.setAccuracy(0.0f);
            }
        } else {
            location.setLatitude(this.m_latitude);
            location.setLongitude(this.m_longitude);
            location.setAccuracy(this.m_radius);
        }
        return location;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public TriggerContextInfo getTestTriggerContentInfo() {
        return new TriggerContextInfo(this, "Testing: lat?,lon?");
    }

    public boolean getTriggerFromUnknown() {
        int i4 = this.m_newTriggerFromUnknown;
        if (i4 != 0) {
            if (i4 != 1) {
                return false;
            }
            return true;
        } else if (this.m_enterArea) {
            if (this.m_dontTriggerFromUnknownEnter) {
                return false;
            }
            return true;
        } else {
            return this.m_triggerFromUnknown;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == SELECT_GEOFENCE && i5 == -1) {
            this.m_latitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.m_longitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.m_radius = 0;
            updateGeofenceStore();
            this.m_geofenceId = intent.getStringExtra(GeofenceListActivity.EXTRA_SELECTED_GEOFENCE_ID);
            this.m_geofenceInfo = this.m_geofenceStore.getGeofenceMap().get(this.m_geofenceId);
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        P();
    }

    public boolean isEnterTrigger() {
        return this.m_enterArea;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        super.itemComplete();
        Settings.setLocationInfo(MacroDroidApplication.getInstance(), this, LocationTriggerAreaChecker.LocationInfo.UNKNOWN);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLocationServicesEnabled() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    public void updateGeofenceStore() {
        GeofenceStore geofenceStore = (GeofenceStore) this.m_cache.get("GeofenceInfo", GeofenceStore.class);
        this.m_geofenceStore = geofenceStore;
        if (geofenceStore == null) {
            this.m_geofenceStore = new GeofenceStore();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeDouble(this.m_latitude);
        parcel.writeDouble(this.m_longitude);
        parcel.writeInt(this.m_radius);
        parcel.writeInt(this.m_enterArea ? 1 : 0);
        parcel.writeInt(this.m_triggerFromUnknown ? 1 : 0);
        parcel.writeInt(this.m_dontTriggerFromUnknownEnter ? 1 : 0);
        parcel.writeInt(this.m_newTriggerFromUnknown);
        parcel.writeString(this.m_geofenceId);
    }

    public LocationTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public LocationTrigger() {
        init();
    }

    private LocationTrigger(Parcel parcel) {
        super(parcel);
        init();
        this.m_latitude = parcel.readDouble();
        this.m_longitude = parcel.readDouble();
        this.m_radius = parcel.readInt();
        this.m_enterArea = parcel.readInt() != 0;
        this.m_triggerFromUnknown = parcel.readInt() != 0;
        this.m_dontTriggerFromUnknownEnter = parcel.readInt() != 0;
        this.m_newTriggerFromUnknown = parcel.readInt();
        this.m_geofenceId = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements LocationListener {
        a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (Settings.getMacroDroidEnabled(MacroDroidApplication.getInstance())) {
                SystemLog.logVerbose("LocationTrigger: Passive location obtained");
                LocationTriggerAreaChecker.checkLocationTriggers(location);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i4, Bundle bundle) {
        }
    }
}
