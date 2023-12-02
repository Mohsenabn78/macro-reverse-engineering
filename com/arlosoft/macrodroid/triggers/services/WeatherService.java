package com.arlosoft.macrodroid.triggers.services;

import android.app.IntentService;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.arlosoft.macrodroid.data.Weather;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.WeatherTrigger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class WeatherService extends IntentService {

    /* renamed from: a  reason: collision with root package name */
    private static Weather f15564a;

    public WeatherService() {
        super("WeatherService");
    }

    private String a() {
        return Settings.getLocale(this).getLanguage();
    }

    private String b(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        StringBuilder sb;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://api.openweathermap.org/data/2.5/weather?APPID=d8cabbe23fb9ee0f252a4c87380216c8&units=units=metric&lang=" + a() + "&" + str).openConnection();
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();
                sb = new StringBuilder();
                inputStream = httpURLConnection.getInputStream();
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\r\n");
                }
                inputStream.close();
                httpURLConnection.disconnect();
                String sb2 = sb.toString();
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused) {
                }
                return sb2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (Throwable unused2) {
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                    return null;
                } finally {
                    try {
                        inputStream.close();
                    } catch (Throwable unused4) {
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused5) {
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String b4 = b(Settings.getWeatherLatLon(this));
        if (b4 == null) {
            SystemLog.logInfo("Failed to obtain weather data");
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
            return;
        }
        Weather fromJSON = Weather.fromJSON(b4);
        if (fromJSON == null) {
            SystemLog.logInfo("Failed to obtain weather data");
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof WeatherTrigger) && ((WeatherTrigger) next).shouldTrigger(f15564a, fromJSON)) {
                        TriggerContextInfo triggerContextInfo = new TriggerContextInfo(next, fromJSON.getWeatherContextInfo());
                        if (next.constraintsMet(triggerContextInfo)) {
                            macro.setTriggerThatInvoked(next);
                            macro.setTriggerContextInfo(triggerContextInfo);
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                            }
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
        f15564a = fromJSON;
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
