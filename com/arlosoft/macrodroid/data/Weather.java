package com.arlosoft.macrodroid.data;

import android.location.Location;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.getpebble.android.kit.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Weather {

    /* renamed from: b  reason: collision with root package name */
    private int f10722b;
    public int humidity;
    public Location location;
    public int windDirectionDegrees;
    public final List<CurrentCondition> currentConditions = new ArrayList();
    public final Temperature temperature = new Temperature();
    public final Wind wind = new Wind();
    public Rain rain = new Rain();
    public Snow snow = new Snow();

    /* renamed from: a  reason: collision with root package name */
    private final Clouds f10721a = new Clouds();

    /* loaded from: classes3.dex */
    public class Clouds {

        /* renamed from: a  reason: collision with root package name */
        private int f10723a;

        public Clouds() {
        }

        public int getPerc() {
            return this.f10723a;
        }

        public void setPerc(int i4) {
            this.f10723a = i4;
        }
    }

    /* loaded from: classes3.dex */
    public static class CurrentCondition {

        /* renamed from: a  reason: collision with root package name */
        private int f10725a;

        /* renamed from: b  reason: collision with root package name */
        private String f10726b;

        /* renamed from: c  reason: collision with root package name */
        private String f10727c;

        /* renamed from: d  reason: collision with root package name */
        private String f10728d;

        public String getCondition() {
            return this.f10726b;
        }

        public String getDescr() {
            return this.f10727c;
        }

        public String getIcon() {
            return this.f10728d;
        }

        public int getWeatherId() {
            return this.f10725a;
        }

        public void setCondition(String str) {
            this.f10726b = str;
        }

        public void setDescr(String str) {
            this.f10727c = str;
        }

        public void setIcon(String str) {
            this.f10728d = str;
        }

        public void setWeatherId(int i4) {
            this.f10725a = i4;
        }
    }

    /* loaded from: classes3.dex */
    public class Rain {

        /* renamed from: a  reason: collision with root package name */
        private String f10729a;

        /* renamed from: b  reason: collision with root package name */
        private float f10730b;

        public Rain() {
        }

        public float getAmmount() {
            return this.f10730b;
        }

        public String getTime() {
            return this.f10729a;
        }

        public void setAmmount(float f4) {
            this.f10730b = f4;
        }

        public void setTime(String str) {
            this.f10729a = str;
        }
    }

    /* loaded from: classes3.dex */
    public class Snow {

        /* renamed from: a  reason: collision with root package name */
        private String f10732a;

        /* renamed from: b  reason: collision with root package name */
        private float f10733b;

        public Snow() {
        }

        public float getAmmount() {
            return this.f10733b;
        }

        public String getTime() {
            return this.f10732a;
        }

        public void setAmmount(float f4) {
            this.f10733b = f4;
        }

        public void setTime(String str) {
            this.f10732a = str;
        }
    }

    /* loaded from: classes3.dex */
    public class Temperature {

        /* renamed from: a  reason: collision with root package name */
        private double f10735a;

        /* renamed from: b  reason: collision with root package name */
        private double f10736b;

        /* renamed from: c  reason: collision with root package name */
        private double f10737c;

        public Temperature() {
        }

        private double a(double d4) {
            return ((d4 * 9.0d) / 5.0d) + 32.0d;
        }

        public double getMaxTemp() {
            return this.f10737c;
        }

        public double getMinTemp() {
            return this.f10736b;
        }

        public double getTemp(boolean z3) {
            double d4 = this.f10735a - 273.15d;
            if (z3) {
                return d4;
            }
            return a(d4);
        }

        public void setMaxTemp(double d4) {
            this.f10737c = d4;
        }

        public void setMinTemp(double d4) {
            this.f10736b = d4;
        }

        public void setTemp(double d4) {
            this.f10735a = d4;
        }
    }

    /* loaded from: classes3.dex */
    public class Wind {

        /* renamed from: a  reason: collision with root package name */
        private double f10739a;

        /* renamed from: b  reason: collision with root package name */
        private double f10740b;

        public Wind() {
        }

        public double getDeg() {
            return this.f10740b;
        }

        public double getSpeed() {
            return this.f10739a;
        }

        public void setDeg(double d4) {
            this.f10740b = d4;
        }

        public void setSpeed(double d4) {
            this.f10739a = d4;
        }
    }

    public static Weather fromJSON(String str) {
        Weather weather = new Weather();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("weather");
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                CurrentCondition currentCondition = new CurrentCondition();
                currentCondition.setWeatherId(jSONObject2.getInt("id"));
                currentCondition.setDescr(jSONObject2.getString("description"));
                currentCondition.setCondition(jSONObject2.getString("main"));
                currentCondition.setIcon(jSONObject2.getString(Constants.CUST_ICON));
                weather.currentConditions.add(currentCondition);
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("main");
            weather.humidity = jSONObject3.getInt("humidity");
            weather.f10722b = jSONObject3.getInt("pressure");
            weather.temperature.setMaxTemp(jSONObject3.getDouble("temp_max"));
            weather.temperature.setMinTemp(jSONObject3.getDouble("temp_min"));
            weather.temperature.setTemp(jSONObject3.getDouble("temp"));
            JSONObject jSONObject4 = jSONObject.getJSONObject("wind");
            weather.wind.setSpeed(jSONObject4.getDouble("speed"));
            weather.windDirectionDegrees = jSONObject4.getInt("deg");
            if (jSONObject4.has("deg")) {
                weather.wind.setDeg(jSONObject4.getDouble("deg"));
            }
            weather.f10721a.setPerc(jSONObject.getJSONObject("clouds").getInt("all"));
            return weather;
        } catch (JSONException e4) {
            FirebaseAnalyticsEventLogger.log("JSON = " + str);
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Weather parse problem: " + e4.toString()));
            return null;
        }
    }

    public WeatherContextInfo getWeatherContextInfo() {
        return new WeatherContextInfo(this.temperature.getTemp(true), this.temperature.getTemp(false), this.wind.getSpeed(), this.humidity, this.windDirectionDegrees, this.currentConditions);
    }
}
