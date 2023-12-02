package com.google.firebase.remoteconfig.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.net.HttpHeaders;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.BuildConfig;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ConfigRealtimeHttpClient {
    @VisibleForTesting

    /* renamed from: q  reason: collision with root package name */
    static final int[] f31992q = {2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f31993r = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final Set<ConfigUpdateListener> f31994a;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private int f31996c;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledExecutorService f32000g;

    /* renamed from: h  reason: collision with root package name */
    private final ConfigFetchHandler f32001h;

    /* renamed from: i  reason: collision with root package name */
    private final FirebaseApp f32002i;

    /* renamed from: j  reason: collision with root package name */
    private final FirebaseInstallationsApi f32003j;

    /* renamed from: k  reason: collision with root package name */
    ConfigCacheClient f32004k;

    /* renamed from: l  reason: collision with root package name */
    private final Context f32005l;

    /* renamed from: m  reason: collision with root package name */
    private final String f32006m;

    /* renamed from: p  reason: collision with root package name */
    private final ConfigMetadataClient f32009p;

    /* renamed from: f  reason: collision with root package name */
    private final int f31999f = 8;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private boolean f31995b = false;

    /* renamed from: n  reason: collision with root package name */
    private final Random f32007n = new Random();

    /* renamed from: o  reason: collision with root package name */
    private final Clock f32008o = DefaultClock.getInstance();
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private boolean f31997d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31998e = false;

    public ConfigRealtimeHttpClient(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, Set<ConfigUpdateListener> set, ConfigMetadataClient configMetadataClient, ScheduledExecutorService scheduledExecutorService) {
        this.f31994a = set;
        this.f32000g = scheduledExecutorService;
        this.f31996c = Math.max(8 - configMetadataClient.e().b(), 1);
        this.f32002i = firebaseApp;
        this.f32001h = configFetchHandler;
        this.f32003j = firebaseInstallationsApi;
        this.f32004k = configCacheClient;
        this.f32005l = context;
        this.f32006m = str;
        this.f32009p = configMetadataClient;
    }

    private synchronized boolean e() {
        boolean z3;
        if (!this.f31994a.isEmpty() && !this.f31995b && !this.f31997d) {
            if (!this.f31998e) {
                z3 = true;
            }
        }
        z3 = false;
        return z3;
    }

    private JSONObject f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("project", h(this.f32002i.getOptions().getApplicationId()));
        hashMap.put("namespace", this.f32006m);
        hashMap.put("lastKnownVersionNumber", Long.toString(this.f32001h.getTemplateVersionNumber()));
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.f32002i.getOptions().getApplicationId());
        hashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, BuildConfig.VERSION_NAME);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, str);
        return new JSONObject(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        this.f31997d = true;
    }

    private static String h(String str) {
        Matcher matcher = f31993r.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private String i() {
        try {
            Context context = this.f32005l;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            if (packageCertificateHashBytes == null) {
                Log.e(FirebaseRemoteConfig.TAG, "Could not get fingerprint hash for package: " + this.f32005l.getPackageName());
                return null;
            }
            return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i(FirebaseRemoteConfig.TAG, "No such package: " + this.f32005l.getPackageName());
            return null;
        }
    }

    private long j(int i4) {
        int[] iArr = f31992q;
        int length = iArr.length;
        if (i4 >= length) {
            i4 = length;
        }
        long millis = TimeUnit.MINUTES.toMillis(iArr[i4 - 1]);
        return (millis / 2) + this.f32007n.nextInt((int) millis);
    }

    private String k(String str) {
        return String.format(RemoteConfigConstants.REALTIME_REGEX_URL, h(this.f32002i.getOptions().getApplicationId()), str);
    }

    private URL l() {
        try {
            return new URL(k(this.f32006m));
        } catch (MalformedURLException unused) {
            Log.e(FirebaseRemoteConfig.TAG, "URL is malformed");
            return null;
        }
    }

    private boolean m(int i4) {
        if (i4 != 408 && i4 != 429 && i4 != 502 && i4 != 503 && i4 != 504) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task n(Task task, Task task2) throws Exception {
        Integer num;
        Throwable th;
        HttpURLConnection httpURLConnection;
        boolean z3;
        boolean z4;
        FirebaseRemoteConfigServerException firebaseRemoteConfigServerException;
        boolean z5;
        try {
        } catch (IOException unused) {
            httpURLConnection = null;
            num = null;
        } catch (Throwable th2) {
            num = null;
            th = th2;
            httpURLConnection = null;
        }
        if (task.isSuccessful()) {
            u(true);
            httpURLConnection = (HttpURLConnection) task.getResult();
            try {
                num = Integer.valueOf(httpURLConnection.getResponseCode());
                try {
                    if (num.intValue() == 200) {
                        s();
                        this.f32009p.g();
                        startAutoFetch(httpURLConnection).listenForNotifications();
                    }
                    closeRealtimeHttpStream(httpURLConnection);
                    u(false);
                    if (m(num.intValue())) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        w(new Date(this.f32008o.currentTimeMillis()));
                    }
                } catch (IOException unused2) {
                    closeRealtimeHttpStream(httpURLConnection);
                    u(false);
                    if (num != null && !m(num.intValue())) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        w(new Date(this.f32008o.currentTimeMillis()));
                    }
                    if (!z4 && num.intValue() != 200) {
                        String format = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
                        if (num.intValue() == 403) {
                            format = q(httpURLConnection.getErrorStream());
                        }
                        firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(num.intValue(), format, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
                        r(firebaseRemoteConfigServerException);
                        return Tasks.forResult(null);
                    }
                    retryHttpConnectionWhenBackoffEnds();
                    return Tasks.forResult(null);
                } catch (Throwable th3) {
                    th = th3;
                    closeRealtimeHttpStream(httpURLConnection);
                    u(false);
                    if (num != null && !m(num.intValue())) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        w(new Date(this.f32008o.currentTimeMillis()));
                    }
                    if (!z3 && num.intValue() != 200) {
                        String format2 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
                        if (num.intValue() == 403) {
                            format2 = q(httpURLConnection.getErrorStream());
                        }
                        r(new FirebaseRemoteConfigServerException(num.intValue(), format2, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
                    } else {
                        retryHttpConnectionWhenBackoffEnds();
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                num = null;
            } catch (Throwable th4) {
                num = null;
                th = th4;
            }
            if (!z5 && num.intValue() != 200) {
                String format3 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
                if (num.intValue() == 403) {
                    format3 = q(httpURLConnection.getErrorStream());
                }
                firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(num.intValue(), format3, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
                r(firebaseRemoteConfigServerException);
                return Tasks.forResult(null);
            }
            retryHttpConnectionWhenBackoffEnds();
            return Tasks.forResult(null);
        }
        throw new IOException(task.getException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task o(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for config update listener connection.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for config update listener connection.", task2.getException()));
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) l().openConnection();
            setRequestParams(httpURLConnection, (String) task2.getResult(), ((InstallationTokenResult) task.getResult()).getToken());
            return Tasks.forResult(httpURLConnection);
        } catch (IOException e4) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to open HTTP stream connection", e4));
        }
    }

    private synchronized void p(long j4) {
        if (!e()) {
            return;
        }
        int i4 = this.f31996c;
        if (i4 > 0) {
            this.f31996c = i4 - 1;
            this.f32000g.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.1
                @Override // java.lang.Runnable
                public void run() {
                    ConfigRealtimeHttpClient.this.beginRealtimeHttpStream();
                }
            }, j4, TimeUnit.MILLISECONDS);
        } else if (!this.f31998e) {
            r(new FirebaseRemoteConfigClientException("Unable to connect to the server. Check your connection and try again.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
        }
    }

    private String q(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException unused) {
            if (sb.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        for (ConfigUpdateListener configUpdateListener : this.f31994a) {
            configUpdateListener.onError(firebaseRemoteConfigException);
        }
    }

    private synchronized void s() {
        this.f31996c = 8;
    }

    private void t(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty("X-Goog-Firebase-Installations-Auth", str);
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.f32002i.getOptions().getApiKey());
        httpURLConnection.setRequestProperty("X-Android-Package", this.f32005l.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", i());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty("X-Accept-Response-Streaming", "true");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
    }

    private synchronized void u(boolean z3) {
        this.f31995b = z3;
    }

    private void w(Date date) {
        int b4 = this.f32009p.e().b() + 1;
        this.f32009p.k(b4, new Date(date.getTime() + j(b4)));
    }

    @SuppressLint({"VisibleForTests", "DefaultLocale"})
    public void beginRealtimeHttpStream() {
        if (!e()) {
            return;
        }
        if (new Date(this.f32008o.currentTimeMillis()).before(this.f32009p.e().a())) {
            retryHttpConnectionWhenBackoffEnds();
            return;
        }
        final Task<HttpURLConnection> createRealtimeConnection = createRealtimeConnection();
        Tasks.whenAllComplete(createRealtimeConnection).continueWith(this.f32000g, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.k
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task n4;
                n4 = ConfigRealtimeHttpClient.this.n(createRealtimeConnection, task);
                return n4;
            }
        });
    }

    public void closeRealtimeHttpStream(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
                if (httpURLConnection.getErrorStream() != null) {
                    httpURLConnection.getErrorStream().close();
                }
            } catch (IOException unused) {
            }
        }
    }

    @SuppressLint({"VisibleForTests"})
    public Task<HttpURLConnection> createRealtimeConnection() {
        final Task<InstallationTokenResult> token = this.f32003j.getToken(false);
        final Task<String> id = this.f32003j.getId();
        return Tasks.whenAllComplete(token, id).continueWithTask(this.f32000g, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.l
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task o4;
                o4 = ConfigRealtimeHttpClient.this.o(token, id, task);
                return o4;
            }
        });
    }

    @SuppressLint({"VisibleForTests"})
    public Date getBackoffEndTime() {
        return this.f32009p.e().a();
    }

    @SuppressLint({"VisibleForTests"})
    public int getNumberOfFailedStreams() {
        return this.f32009p.e().b();
    }

    @SuppressLint({"VisibleForTests"})
    public synchronized void retryHttpConnectionWhenBackoffEnds() {
        p(Math.max(0L, this.f32009p.e().a().getTime() - new Date(this.f32008o.currentTimeMillis()).getTime()));
    }

    @SuppressLint({"VisibleForTests"})
    public void setRequestParams(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        t(httpURLConnection, str2);
        byte[] bytes = f(str).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    @SuppressLint({"VisibleForTests"})
    public synchronized ConfigAutoFetch startAutoFetch(HttpURLConnection httpURLConnection) {
        return new ConfigAutoFetch(httpURLConnection, this.f32001h, this.f32004k, this.f31994a, new ConfigUpdateListener() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.2
            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void onError(@NonNull FirebaseRemoteConfigException firebaseRemoteConfigException) {
                ConfigRealtimeHttpClient.this.g();
                ConfigRealtimeHttpClient.this.r(firebaseRemoteConfigException);
            }

            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void onUpdate(@NonNull ConfigUpdate configUpdate) {
            }
        }, this.f32000g);
    }

    public void startHttpConnection() {
        p(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(boolean z3) {
        this.f31998e = z3;
    }
}
