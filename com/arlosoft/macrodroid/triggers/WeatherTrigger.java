package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.Weather;
import com.arlosoft.macrodroid.data.WeatherContextInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.activities.LocationChooserActivity;
import com.arlosoft.macrodroid.triggers.info.WeatherTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.RequestWeatherReceiver;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.text.Typography;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class WeatherTrigger extends Trigger {
    private static final int ANY_WEATHER_UPDATE = 4;
    private static final int CONDITIONS = 3;
    public static final Parcelable.Creator<WeatherTrigger> CREATOR = new d();
    private static final int HUMIDITY = 2;
    private static final int SET_LOCATION = 33;
    private static final int TEMPERATURE = 0;
    private static final int WEATHER_CONDITION_CLEAR = 0;
    private static final int WEATHER_CONDITION_CLOUDY = 1;
    private static final int WEATHER_CONDITION_RAIN = 2;
    private static final int WEATHER_CONDITION_SNOW = 4;
    private static final int WEATHER_CONDITION_THUNDER = 3;
    private static final int WIND_DIRECTION = 5;
    private static final int WIND_SPEED = 1;
    private static PendingIntent s_pendingIntent;
    private static int s_triggerCounter;
    private static e s_updateRateReceiver;
    private boolean m_humidityAbove;
    private int m_humidityValue;
    private int m_option;
    private boolean m_tempBelow;
    private boolean m_tempCelcius;
    private int m_temperature;
    private int m_weatherCondition;
    private boolean m_windSpeedAbove;
    private int m_windSpeedValue;
    private int m_windSpeedValueMph;

    /* loaded from: classes3.dex */
    class d implements Parcelable.Creator<WeatherTrigger> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WeatherTrigger createFromParcel(Parcel parcel) {
            return new WeatherTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WeatherTrigger[] newArray(int i4) {
            return new WeatherTrigger[i4];
        }
    }

    /* loaded from: classes3.dex */
    private class e extends BroadcastReceiver {
        private e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (WeatherTrigger.s_pendingIntent != null) {
                PendingIntent unused = WeatherTrigger.s_pendingIntent = PendingIntent.getBroadcast(WeatherTrigger.this.getContext(), 0, new Intent(WeatherTrigger.this.getContext(), RequestWeatherReceiver.class), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
                ((AlarmManager) WeatherTrigger.this.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, System.currentTimeMillis(), Settings.getWeatherUpdateRate(WeatherTrigger.this.getContext()) * 60 * 1000, WeatherTrigger.s_pendingIntent);
            }
        }

        /* synthetic */ e(WeatherTrigger weatherTrigger, a aVar) {
            this();
        }
    }

    /* synthetic */ WeatherTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void X() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.weather_humidity_dialog);
        appCompatDialog.setTitle(R.string.trigger_weather_humidity);
        final SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.weather_dialog_value);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.weather_dialog_above_radio_button);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.weather_dialog_percentage_value);
        seekBar.setProgress(this.m_humidityValue);
        textView.setText(this.m_humidityValue + "%");
        ((RadioButton) appCompatDialog.findViewById(R.id.weather_dialog_below_radio_button)).setChecked(this.m_humidityAbove ^ true);
        radioButton.setChecked(this.m_humidityAbove);
        seekBar.setOnSeekBarChangeListener(new c(textView));
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.v9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeatherTrigger.this.b0(radioButton, seekBar, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.w9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private void Y() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.weather_temperature_dialog);
        appCompatDialog.setTitle(R.string.trigger_weather_temperature);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.weather_dialog_text_value);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.weather_dialog_temperature_unit);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.weather_dialog_below_radio_button);
        editText.setText("" + this.m_temperature);
        editText.setSelection(editText.getText().length());
        spinner.setSelection(!this.m_tempCelcius ? 1 : 0);
        radioButton.setChecked(this.m_tempBelow);
        ((RadioButton) appCompatDialog.findViewById(R.id.weather_dialog_above_radio_button)).setChecked(!this.m_tempBelow);
        editText.addTextChangedListener(new a(button));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.r9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeatherTrigger.this.d0(radioButton, spinner, editText, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.s9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private void Z() {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.weather_conditions_dialog);
        appCompatDialog.setTitle(R.string.trigger_weather_conditions);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.weather_conditions_dialog_clear);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.weather_conditions_dialog_cloudy);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.weather_conditions_dialog_rain);
        final RadioButton radioButton4 = (RadioButton) appCompatDialog.findViewById(R.id.weather_conditions_dialog_thunder);
        final RadioButton radioButton5 = (RadioButton) appCompatDialog.findViewById(R.id.weather_conditions_dialog_snow);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        boolean z7 = false;
        if (this.m_weatherCondition == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton.setChecked(z3);
        if (this.m_weatherCondition == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        radioButton2.setChecked(z4);
        if (this.m_weatherCondition == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        radioButton3.setChecked(z5);
        if (this.m_weatherCondition == 3) {
            z6 = true;
        } else {
            z6 = false;
        }
        radioButton4.setChecked(z6);
        if (this.m_weatherCondition == 4) {
            z7 = true;
        }
        radioButton5.setChecked(z7);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.t9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeatherTrigger.this.f0(radioButton, radioButton2, radioButton3, radioButton4, radioButton5, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.u9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private void a0() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.weather_wind_speed_dialog);
        appCompatDialog.setTitle(R.string.trigger_weather_wind_speed);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.weather_dialog_text_value);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.weather_dialog_below_radio_button);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.weather_dialog_above_radio_button);
        int i4 = this.m_windSpeedValueMph;
        if (i4 == 0) {
            editText.setText(String.valueOf((int) (this.m_windSpeedValue * 2.23694d)));
        } else {
            editText.setText(String.valueOf(i4));
        }
        editText.setSelection(editText.getText().length());
        radioButton.setChecked(!this.m_windSpeedAbove);
        radioButton2.setChecked(this.m_windSpeedAbove);
        editText.addTextChangedListener(new b(button));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.x9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeatherTrigger.this.h0(radioButton2, editText, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.y9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(RadioButton radioButton, SeekBar seekBar, AppCompatDialog appCompatDialog, View view) {
        this.m_humidityAbove = radioButton.isChecked();
        this.m_humidityValue = seekBar.getProgress();
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(RadioButton radioButton, Spinner spinner, EditText editText, AppCompatDialog appCompatDialog, View view) {
        boolean z3;
        this.m_tempBelow = radioButton.isChecked();
        if (spinner.getSelectedItemPosition() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_tempCelcius = z3;
        try {
            this.m_temperature = Integer.valueOf(editText.getText().toString()).intValue();
        } catch (NumberFormatException unused) {
            this.m_temperature = 0;
        }
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, AppCompatDialog appCompatDialog, View view) {
        if (radioButton.isChecked()) {
            this.m_weatherCondition = 0;
        } else if (radioButton2.isChecked()) {
            this.m_weatherCondition = 1;
        } else if (radioButton3.isChecked()) {
            this.m_weatherCondition = 2;
        } else if (radioButton4.isChecked()) {
            this.m_weatherCondition = 3;
        } else if (radioButton5.isChecked()) {
            this.m_weatherCondition = 4;
        }
        itemComplete();
        appCompatDialog.cancel();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_weather_temperature), SelectableItem.r(R.string.trigger_weather_wind_direction), SelectableItem.r(R.string.trigger_weather_wind_speed), SelectableItem.r(R.string.trigger_weather_humidity), SelectableItem.r(R.string.trigger_weather_conditions), SelectableItem.r(R.string.trigger_weather_any)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(RadioButton radioButton, EditText editText, AppCompatDialog appCompatDialog, View view) {
        this.m_windSpeedAbove = radioButton.isChecked();
        try {
            int intValue = Integer.valueOf(editText.getText().toString()).intValue();
            this.m_windSpeedValueMph = intValue;
            this.m_windSpeedValue = (int) (intValue / 2.23694d);
        } catch (NumberFormatException unused) {
            this.m_windSpeedValueMph = 0;
            this.m_windSpeedValue = 0;
        }
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Activity activity, DialogInterface dialogInterface, int i4) {
        try {
            Intent intent = new Intent(activity, LocationChooserActivity.class);
            intent.putExtra("title", SelectableItem.r(R.string.weather_location));
            activity.startActivityForResult(intent, 33);
        } catch (NoClassDefFoundError unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) getContext().getString(R.string.toast_broken_map_activity), 0).show();
        }
        dialogInterface.dismiss();
    }

    private int k0(int i4) {
        if (i4 >= 200 && i4 <= 232) {
            return 3;
        }
        if (i4 >= 300 && i4 <= 531) {
            return 2;
        }
        if (i4 >= 600 && i4 <= 622) {
            return 4;
        }
        if (i4 >= 800 && i4 <= 801) {
            return 0;
        }
        if (i4 >= 802 && i4 <= 804) {
            return 1;
        }
        return -1;
    }

    private void l0(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(R.string.trigger_weather_set_location);
        builder.setMessage(R.string.trigger_weather_location_info).setCancelable(true).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.q9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                WeatherTrigger.this.j0(activity, dialogInterface, i4);
            }
        });
        builder.show();
    }

    private boolean m0(Weather weather, Weather weather2) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        if (weather != null) {
            for (Weather.CurrentCondition currentCondition : weather.currentConditions) {
                hashSet.add(Integer.valueOf(k0(currentCondition.getWeatherId())));
            }
        }
        for (Weather.CurrentCondition currentCondition2 : weather2.currentConditions) {
            hashSet2.add(Integer.valueOf(k0(currentCondition2.getWeatherId())));
        }
        if (!hashSet.contains(Integer.valueOf(this.m_weatherCondition)) && hashSet2.contains(Integer.valueOf(this.m_weatherCondition))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            this.m_option = 0;
                            return;
                        } else {
                            this.m_option = 4;
                            return;
                        }
                    }
                    this.m_option = 3;
                    return;
                }
                this.m_option = 2;
                return;
            }
            this.m_option = 1;
            return;
        }
        this.m_option = 5;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(s_pendingIntent);
            if (s_updateRateReceiver != null) {
                try {
                    s_pendingIntent = null;
                    getContext().unregisterReceiver(s_updateRateReceiver);
                } catch (Exception e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(e4);
                }
                s_pendingIntent = null;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_pendingIntent = PendingIntent.getBroadcast(getContext(), 0, new Intent(getContext(), RequestWeatherReceiver.class), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
            ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, System.currentTimeMillis(), Settings.getWeatherUpdateRate(getContext()) * 60 * 1000, s_pendingIntent);
            IntentFilter intentFilter = new IntentFilter(Util.WEATHER_UPDATE_RATE_INTENT);
            s_updateRateReceiver = new e(this, null);
            getContext().registerReceiver(s_updateRateReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int i4 = this.m_option;
        if (i4 == 1) {
            return 2;
        }
        if (i4 == 2) {
            return 3;
        }
        if (i4 == 3) {
            return 4;
        }
        if (i4 == 4) {
            return 5;
        }
        if (i4 == 5) {
            return 1;
        }
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        int checkedItemIndex = getCheckedItemIndex();
        int i4 = this.m_option;
        String str2 = " < ";
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return getOptions()[checkedItemIndex];
                    }
                    int i5 = this.m_weatherCondition;
                    if (i5 != 0) {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 != 3) {
                                    if (i5 != 4) {
                                        return getOptions()[checkedItemIndex];
                                    }
                                    return getOptions()[checkedItemIndex] + ": " + SelectableItem.r(R.string.trigger_weather_snow);
                                }
                                return getOptions()[checkedItemIndex] + ": " + SelectableItem.r(R.string.trigger_weather_thunder);
                            }
                            return getOptions()[checkedItemIndex] + ": " + SelectableItem.r(R.string.trigger_weather_rain);
                        }
                        return getOptions()[checkedItemIndex] + ": " + SelectableItem.r(R.string.trigger_weather_cloudy);
                    }
                    return getOptions()[checkedItemIndex] + ": " + SelectableItem.r(R.string.trigger_weather_clear);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(getOptions()[checkedItemIndex]);
                if (this.m_humidityAbove) {
                    str2 = " > ";
                }
                sb.append(str2);
                sb.append(this.m_humidityValue);
                sb.append("%");
                return sb.toString();
            }
            int i6 = this.m_windSpeedValueMph;
            if (i6 <= 0) {
                i6 = (int) (this.m_windSpeedValue * 2.23694d);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getOptions()[checkedItemIndex]);
            if (this.m_windSpeedAbove) {
                str2 = " > ";
            }
            sb2.append(str2);
            sb2.append(i6);
            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb2.append(SelectableItem.r(R.string.trigger_weather_miles_per_hour));
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getOptions()[checkedItemIndex]);
        if (!this.m_tempBelow) {
            str2 = " > ";
        }
        sb3.append(str2);
        sb3.append(this.m_temperature);
        sb3.append(Typography.degree);
        if (this.m_tempCelcius) {
            str = "C";
        } else {
            str = "F";
        }
        sb3.append(str);
        return sb3.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return WeatherTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public TriggerContextInfo getTestTriggerContentInfo() {
        return new TriggerContextInfo(this, new WeatherContextInfo(1.1d, 2.1d, 3.1d, 4, 120, new ArrayList()));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == 33 && i5 == -1) {
            double doubleExtra = intent.getDoubleExtra(LocationTrigger.LATITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double doubleExtra2 = intent.getDoubleExtra(LocationTrigger.LONGITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            Settings.setWeatherLatLon(activity, "lat=" + doubleExtra + "&lon=" + doubleExtra2);
            super.itemComplete();
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        if (Settings.getWeatherLatLon(getContext()).length() == 0) {
            l0(getActivity());
        } else {
            super.itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                super.secondaryItemConfirmed();
                                return;
                            }
                            return;
                        }
                        super.secondaryItemConfirmed();
                        return;
                    }
                    Z();
                    return;
                }
                X();
                return;
            }
            a0();
            return;
        }
        Y();
    }

    public boolean shouldTrigger(Weather weather, Weather weather2) {
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 5 && weather != null && weather2.windDirectionDegrees == weather.windDirectionDegrees) {
                            return false;
                        }
                        return true;
                    }
                } else if (this.m_humidityAbove) {
                    int i5 = weather2.humidity;
                    int i6 = this.m_humidityValue;
                    if (i5 >= i6 && (weather == null || weather.humidity < i6)) {
                        return true;
                    }
                } else {
                    int i7 = weather2.humidity;
                    int i8 = this.m_humidityValue;
                    if (i7 <= i8) {
                        if (weather != null && weather.humidity <= i8) {
                            return false;
                        }
                        return true;
                    }
                }
                return m0(weather, weather2);
            }
            double d4 = this.m_windSpeedValue;
            int i9 = this.m_windSpeedValueMph;
            if (i9 > 0) {
                d4 = i9 / 2.23694d;
            }
            if (this.m_windSpeedAbove) {
                if (weather2.wind.getSpeed() < d4) {
                    return false;
                }
                if (weather != null && weather.wind.getSpeed() >= d4) {
                    return false;
                }
                return true;
            } else if (weather2.wind.getSpeed() > d4) {
                return false;
            } else {
                if (weather != null && weather.wind.getSpeed() <= d4) {
                    return false;
                }
                return true;
            }
        } else if (this.m_tempBelow) {
            if (weather2.temperature.getTemp(this.m_tempCelcius) > this.m_temperature) {
                return false;
            }
            if (weather != null && weather.temperature.getTemp(this.m_tempCelcius) <= this.m_temperature) {
                return false;
            }
            return true;
        } else if (weather2.temperature.getTemp(this.m_tempCelcius) < this.m_temperature) {
            return false;
        } else {
            if (weather != null && weather.temperature.getTemp(this.m_tempCelcius) >= this.m_temperature) {
                return false;
            }
            return true;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(!this.m_tempBelow ? 1 : 0);
        parcel.writeInt(this.m_temperature);
        parcel.writeInt(!this.m_tempCelcius ? 1 : 0);
        parcel.writeInt(!this.m_windSpeedAbove ? 1 : 0);
        parcel.writeInt(this.m_windSpeedValue);
        parcel.writeInt(!this.m_humidityAbove ? 1 : 0);
        parcel.writeInt(this.m_humidityValue);
        parcel.writeInt(this.m_weatherCondition);
        parcel.writeInt(this.m_windSpeedValueMph);
    }

    public WeatherTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private WeatherTrigger() {
        this.m_option = 0;
        this.m_tempBelow = true;
        this.m_temperature = 0;
        this.m_tempCelcius = true;
        this.m_windSpeedAbove = true;
        this.m_humidityAbove = true;
        this.m_humidityValue = 50;
    }

    private WeatherTrigger(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.m_tempBelow = parcel.readInt() == 0;
        this.m_temperature = parcel.readInt();
        this.m_tempCelcius = parcel.readInt() == 0;
        this.m_windSpeedAbove = parcel.readInt() == 0;
        this.m_windSpeedValue = parcel.readInt();
        this.m_humidityAbove = parcel.readInt() == 0;
        this.m_humidityValue = parcel.readInt();
        this.m_weatherCondition = parcel.readInt();
        this.m_windSpeedValueMph = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14452a;

        c(TextView textView) {
            this.f14452a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            TextView textView = this.f14452a;
            textView.setText(i4 + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14448a;

        a(Button button) {
            this.f14448a = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14448a;
            if (editable.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14450a;

        b(Button button) {
            this.f14450a = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14450a;
            if (editable.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
