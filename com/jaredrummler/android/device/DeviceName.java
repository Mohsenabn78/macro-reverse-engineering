package com.jaredrummler.android.device;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class DeviceName {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Context f34586a;

    /* loaded from: classes6.dex */
    public interface Callback {
        void onFinished(DeviceInfo deviceInfo, Exception exc);
    }

    /* loaded from: classes6.dex */
    public static final class DeviceInfo {
        public final String codename;
        @Deprecated
        public final String manufacturer;
        public final String marketName;

        /* renamed from: model  reason: collision with root package name */
        public final String f34587model;

        public String getName() {
            if (TextUtils.isEmpty(this.marketName)) {
                return DeviceName.b(this.f34587model);
            }
            return this.marketName;
        }

        public DeviceInfo(String str, String str2, String str3) {
            this(null, str, str2, str3);
        }

        public DeviceInfo(String str, String str2, String str3, String str4) {
            this.manufacturer = str;
            this.marketName = str2;
            this.codename = str3;
            this.f34587model = str4;
        }

        private DeviceInfo(JSONObject jSONObject) throws JSONException {
            this.manufacturer = jSONObject.getString("manufacturer");
            this.marketName = jSONObject.getString("market_name");
            this.codename = jSONObject.getString("codename");
            this.f34587model = jSONObject.getString("model");
        }
    }

    /* loaded from: classes6.dex */
    public static final class Request {

        /* renamed from: a  reason: collision with root package name */
        final Context f34588a;

        /* renamed from: b  reason: collision with root package name */
        final Handler f34589b;

        /* renamed from: c  reason: collision with root package name */
        String f34590c;

        /* renamed from: d  reason: collision with root package name */
        String f34591d;

        /* loaded from: classes6.dex */
        private final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final Callback f34592a;

            /* renamed from: b  reason: collision with root package name */
            DeviceInfo f34593b;

            /* renamed from: c  reason: collision with root package name */
            Exception f34594c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.jaredrummler.android.device.DeviceName$Request$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0180a implements Runnable {
                RunnableC0180a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.f34592a.onFinished(aVar.f34593b, aVar.f34594c);
                }
            }

            a(Callback callback) {
                this.f34592a = callback;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Request request = Request.this;
                    this.f34593b = DeviceName.getDeviceInfo(request.f34588a, request.f34590c, request.f34591d);
                } catch (Exception e4) {
                    this.f34594c = e4;
                }
                Request.this.f34589b.post(new RunnableC0180a());
            }
        }

        public void request(Callback callback) {
            if (this.f34590c == null && this.f34591d == null) {
                this.f34590c = Build.DEVICE;
                this.f34591d = Build.MODEL;
            }
            a aVar = new a(callback);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(aVar).start();
            } else {
                aVar.run();
            }
        }

        public Request setCodename(String str) {
            this.f34590c = str;
            return this;
        }

        public Request setModel(String str) {
            this.f34591d = str;
            return this;
        }

        private Request(Context context) {
            this.f34588a = context;
            this.f34589b = new Handler(context.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (char c4 : charArray) {
            if (z3 && Character.isLetter(c4)) {
                sb.append(Character.toUpperCase(c4));
                z3 = false;
            } else {
                if (Character.isWhitespace(c4)) {
                    z3 = true;
                }
                sb.append(c4);
            }
        }
        return sb.toString();
    }

    @SuppressLint({"PrivateApi"})
    private static Context c() {
        Context context = f34586a;
        if (context != null) {
            return context;
        }
        try {
            try {
                return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
            } catch (Exception unused) {
                throw new RuntimeException("DeviceName must be initialized before usage.");
            }
        } catch (Exception unused2) {
            return (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, null);
        }
    }

    @WorkerThread
    public static DeviceInfo getDeviceInfo(Context context) {
        return getDeviceInfo(context.getApplicationContext(), Build.DEVICE, Build.MODEL);
    }

    public static String getDeviceName() {
        String str = Build.DEVICE;
        String str2 = Build.MODEL;
        return getDeviceName(str, str2, b(str2));
    }

    public static void init(Context context) {
        f34586a = context.getApplicationContext();
    }

    public static Request with(Context context) {
        return new Request(context.getApplicationContext());
    }

    @WorkerThread
    public static DeviceInfo getDeviceInfo(Context context, String str) {
        return getDeviceInfo(context, str, null);
    }

    public static String getDeviceName(String str, String str2) {
        return getDeviceName(str, str, str2);
    }

    @WorkerThread
    public static DeviceInfo getDeviceInfo(Context context, String str, String str2) {
        DeviceDatabase deviceDatabase;
        DeviceInfo queryToDevice;
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_names", 0);
        String format = String.format("%s:%s", str, str2);
        String string = sharedPreferences.getString(format, null);
        if (string != null) {
            try {
                return new DeviceInfo(new JSONObject(string));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        try {
            deviceDatabase = new DeviceDatabase(context);
            queryToDevice = deviceDatabase.queryToDevice(str, str2);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (queryToDevice != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("manufacturer", queryToDevice.manufacturer);
            jSONObject.put("codename", queryToDevice.codename);
            jSONObject.put("model", queryToDevice.f34587model);
            jSONObject.put("market_name", queryToDevice.marketName);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(format, jSONObject.toString());
            edit.apply();
            deviceDatabase.close();
            return queryToDevice;
        }
        deviceDatabase.close();
        if (str.equals(Build.DEVICE) && Build.MODEL.equals(str2)) {
            return new DeviceInfo(Build.MANUFACTURER, str, str, str2);
        }
        return new DeviceInfo(null, null, str, str2);
    }

    public static String getDeviceName(String str, String str2, String str3) {
        String str4 = getDeviceInfo(c(), str, str2).marketName;
        return str4 == null ? str3 : str4;
    }
}
