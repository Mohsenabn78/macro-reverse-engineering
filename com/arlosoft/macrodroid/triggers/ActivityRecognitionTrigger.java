package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.ActivityRecognitionTriggerInfo;
import com.arlosoft.macrodroid.triggers.services.DetectedActivitiesService;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;

/* loaded from: classes3.dex */
public class ActivityRecognitionTrigger extends Trigger implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResultCallback<Status> {
    private static GoogleApiClient s_GoogleApiClient;
    private static int s_triggerCounter;
    private static c s_updateRateReceiver;
    private boolean lessThan;
    private int m_confidenceLevel;
    private int m_selectedIndex;
    private transient int m_transientConfidenceLevel;
    private static final int[] s_activityTypes = {0, 1, 8, 7, 3};
    public static final Parcelable.Creator<ActivityRecognitionTrigger> CREATOR = new b();

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<ActivityRecognitionTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActivityRecognitionTrigger createFromParcel(Parcel parcel) {
            return new ActivityRecognitionTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ActivityRecognitionTrigger[] newArray(int i4) {
            return new ActivityRecognitionTrigger[i4];
        }
    }

    /* loaded from: classes3.dex */
    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ActivityRecognitionTrigger.s_GoogleApiClient.disconnect();
            ActivityRecognitionTrigger.this.S();
        }

        /* synthetic */ c(ActivityRecognitionTrigger activityRecognitionTrigger, a aVar) {
            this();
        }
    }

    /* synthetic */ ActivityRecognitionTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void S() {
        GoogleApiClient build = new GoogleApiClient.Builder(getContext()).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(ActivityRecognition.API).build();
        s_GoogleApiClient = build;
        build.connect();
    }

    private void T() {
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_activity_recognition_confidence);
        appCompatDialog.setTitle(getOptions()[this.m_selectedIndex]);
        SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.dialog_activity_recognition_confidence_seek_bar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.dialog_activity_recognition_confidence_percent_label);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.less_than_radio_button);
        ((RadioButton) appCompatDialog.findViewById(R.id.greater_than_radio_button)).setChecked(!this.lessThan);
        radioButton.setChecked(this.lessThan);
        this.m_transientConfidenceLevel = Math.max(10, this.m_confidenceLevel);
        seekBar.setMax(90);
        seekBar.setProgress(this.m_transientConfidenceLevel - 10);
        textView.setText(this.m_transientConfidenceLevel + "%");
        seekBar.setOnSeekBarChangeListener(new a(textView));
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityRecognitionTrigger.this.V(appCompatDialog, radioButton, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private PendingIntent U() {
        return PendingIntent.getService(getContext(), 0, new Intent(getContext(), DetectedActivitiesService.class), 134217728 | PendingIntentHelper.FLAG_MUTABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(AppCompatDialog appCompatDialog, RadioButton radioButton, View view) {
        appCompatDialog.cancel();
        this.m_confidenceLevel = this.m_transientConfidenceLevel;
        this.lessThan = radioButton.isChecked();
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_activity_recognition_option_in_vehicle), MacroDroidApplication.getInstance().getString(R.string.trigger_activity_recognition_option_on_bicycle), MacroDroidApplication.getInstance().getString(R.string.trigger_activity_recognition_option_running), MacroDroidApplication.getInstance().getString(R.string.trigger_activity_recognition_option_walking), MacroDroidApplication.getInstance().getString(R.string.trigger_activity_recognition_option_still)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_selectedIndex = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                GoogleApiClient googleApiClient = s_GoogleApiClient;
                if (googleApiClient != null && googleApiClient.isConnected()) {
                    ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(s_GoogleApiClient, U());
                }
                GoogleApiClient googleApiClient2 = s_GoogleApiClient;
                if (googleApiClient2 != null && (googleApiClient2.isConnected() || s_GoogleApiClient.isConnecting())) {
                    s_GoogleApiClient.disconnect();
                }
            } catch (Exception unused) {
            }
            if (s_updateRateReceiver != null) {
                try {
                    getContext().unregisterReceiver(s_updateRateReceiver);
                } catch (Exception e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(e4);
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        DetectedActivitiesService.clearOldTrigger(this);
        if (s_triggerCounter == 0) {
            S();
            IntentFilter intentFilter = new IntentFilter(Util.ACTIVITY_RECOGNITION_UPDATE_RATE_INTENT);
            s_updateRateReceiver = new c(this, null);
            getContext().registerReceiver(s_updateRateReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    public int getActivityType() {
        return s_activityTypes[this.m_selectedIndex];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_selectedIndex;
    }

    public int getConfidenceLevel() {
        return this.m_confidenceLevel;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.trigger_activity_activity) + " - " + getOptions()[this.m_selectedIndex];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(SelectableItem.r(R.string.trigger_activity_recognition_confidence));
        if (this.lessThan) {
            str = " < ";
        } else {
            str = " >= ";
        }
        sb.append(str);
        sb.append(this.m_confidenceLevel);
        sb.append("%");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ActivityRecognitionTriggerInfo.getInstance();
    }

    public boolean getLessThan() {
        return this.lessThan;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getConfiguredName());
        if (this.lessThan) {
            str = " < ";
        } else {
            str = " >= ";
        }
        sb.append(str);
        sb.append(this.m_confidenceLevel);
        sb.append("%");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 29) {
            return new String[]{"android.permission.ACTIVITY_RECOGNITION"};
        }
        return super.getPermissions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        try {
            ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(s_GoogleApiClient, Settings.getActivityRecognitionUpdateRate(getContext()) * 1000, U()).setResultCallback(this);
        } catch (SecurityException unused) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.ACTIVITY_RECOGNITION", getName(), true, false);
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(@NonNull Status status) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.trigger_activity_recognition);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        T();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_selectedIndex);
        parcel.writeInt(this.m_confidenceLevel);
        parcel.writeInt(this.lessThan ? 1 : 0);
    }

    public ActivityRecognitionTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ActivityRecognitionTrigger() {
        this.m_selectedIndex = 0;
        this.m_confidenceLevel = 50;
    }

    private ActivityRecognitionTrigger(Parcel parcel) {
        super(parcel);
        this.m_selectedIndex = parcel.readInt();
        this.m_confidenceLevel = parcel.readInt();
        this.lessThan = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14309a;

        a(TextView textView) {
            this.f14309a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            ActivityRecognitionTrigger.this.m_transientConfidenceLevel = i4 + 10;
            TextView textView = this.f14309a;
            textView.setText(ActivityRecognitionTrigger.this.m_transientConfidenceLevel + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnectionSuspended(int i4) {
    }
}
