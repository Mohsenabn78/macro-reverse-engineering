package com.google.firebase.storage.network;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.internal.StorageReferenceUri;
import com.google.firebase.storage.network.connection.HttpURLConnectionFactory;
import com.google.firebase.storage.network.connection.HttpURLConnectionFactoryImpl;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class NetworkRequest {
    public static final int INITIALIZATION_EXCEPTION = -1;
    public static final int NETWORK_UNAVAILABLE = -2;
    public static final Uri PROD_BASE_URL = Uri.parse("https://firebasestorage.googleapis.com/v0");

    /* renamed from: k  reason: collision with root package name */
    static HttpURLConnectionFactory f32379k = new HttpURLConnectionFactoryImpl();

    /* renamed from: l  reason: collision with root package name */
    private static String f32380l;

    /* renamed from: a  reason: collision with root package name */
    protected Exception f32381a;

    /* renamed from: b  reason: collision with root package name */
    private StorageReferenceUri f32382b;

    /* renamed from: c  reason: collision with root package name */
    private Context f32383c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, List<String>> f32384d;

    /* renamed from: e  reason: collision with root package name */
    private int f32385e;

    /* renamed from: f  reason: collision with root package name */
    private String f32386f;

    /* renamed from: g  reason: collision with root package name */
    private int f32387g;

    /* renamed from: h  reason: collision with root package name */
    private InputStream f32388h;

    /* renamed from: i  reason: collision with root package name */
    private HttpURLConnection f32389i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, String> f32390j = new HashMap();

    public NetworkRequest(@NonNull StorageReferenceUri storageReferenceUri, @NonNull FirebaseApp firebaseApp) {
        Preconditions.checkNotNull(storageReferenceUri);
        Preconditions.checkNotNull(firebaseApp);
        this.f32382b = storageReferenceUri;
        this.f32383c = firebaseApp.getApplicationContext();
        setCustomHeader("x-firebase-gmpid", firebaseApp.getOptions().getApplicationId());
    }

    private void a(@NonNull HttpURLConnection httpURLConnection, @Nullable String str, @Nullable String str2) throws IOException {
        byte[] g4;
        int h4;
        Preconditions.checkNotNull(httpURLConnection);
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("Authorization", "Firebase " + str);
        } else {
            Log.w("NetworkRequest", "no auth token for request");
        }
        if (!TextUtils.isEmpty(str2)) {
            httpURLConnection.setRequestProperty("x-firebase-appcheck", str2);
        } else {
            Log.w("NetworkRequest", "No App Check token for request.");
        }
        StringBuilder sb = new StringBuilder("Android/");
        String e4 = e(this.f32383c);
        if (!TextUtils.isEmpty(e4)) {
            sb.append(e4);
        }
        httpURLConnection.setRequestProperty("X-Firebase-Storage-Version", sb.toString());
        for (Map.Entry<String, String> entry : this.f32390j.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        JSONObject f4 = f();
        if (f4 != null) {
            g4 = f4.toString().getBytes("UTF-8");
            h4 = g4.length;
        } else {
            g4 = g();
            h4 = h();
            if (h4 == 0 && g4 != null) {
                h4 = g4.length;
            }
        }
        if (g4 != null && g4.length > 0) {
            if (f4 != null) {
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Length", Integer.toString(h4));
        } else {
            httpURLConnection.setRequestProperty("Content-Length", "0");
        }
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if (g4 != null && g4.length > 0) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            if (outputStream != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                try {
                    bufferedOutputStream.write(g4, 0, h4);
                    return;
                } finally {
                    bufferedOutputStream.close();
                }
            }
            Log.e("NetworkRequest", "Unable to write to the http request!");
        }
    }

    private HttpURLConnection b() throws IOException {
        Uri url = getURL();
        Map<String, String> k4 = k();
        if (k4 != null) {
            Uri.Builder buildUpon = url.buildUpon();
            for (Map.Entry<String, String> entry : k4.entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            url = buildUpon.build();
        }
        return f32379k.createInstance(new URL(url.toString()));
    }

    private boolean c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        this.f32381a = new SocketException("Network subsystem is unavailable");
        this.f32385e = -2;
        return false;
    }

    @NonNull
    private static String e(Context context) {
        if (f32380l == null) {
            try {
                f32380l = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionName;
            } catch (PackageManager.NameNotFoundException e4) {
                Log.e("NetworkRequest", "Unable to find gmscore in package manager", e4);
            }
            if (f32380l == null) {
                f32380l = "[No Gmscore]";
            }
        }
        return f32380l;
    }

    @NonNull
    public static Uri getBaseUrl(@Nullable EmulatedServiceSettings emulatedServiceSettings) {
        if (emulatedServiceSettings != null) {
            return Uri.parse("http://" + emulatedServiceSettings.getHost() + ":" + emulatedServiceSettings.getPort() + "/v0");
        }
        return PROD_BASE_URL;
    }

    private static String j(@NonNull Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return "";
        }
        if (path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return path.substring(1);
        }
        return path;
    }

    private void n(@Nullable InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } finally {
                    bufferedReader.close();
                }
            }
        }
        this.f32386f = sb.toString();
        if (!isResultSuccess()) {
            this.f32381a = new IOException(this.f32386f);
        }
    }

    private void o(@NonNull HttpURLConnection httpURLConnection) throws IOException {
        Preconditions.checkNotNull(httpURLConnection);
        this.f32385e = httpURLConnection.getResponseCode();
        this.f32384d = httpURLConnection.getHeaderFields();
        this.f32387g = httpURLConnection.getContentLength();
        if (isResultSuccess()) {
            this.f32388h = httpURLConnection.getInputStream();
        } else {
            this.f32388h = httpURLConnection.getErrorStream();
        }
    }

    private final void q(@Nullable String str, @Nullable String str2) {
        performRequestStart(str, str2);
        try {
            r();
        } catch (IOException e4) {
            Log.w("NetworkRequest", "error sending network request " + d() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getURL(), e4);
            this.f32381a = e4;
            this.f32385e = -2;
        }
        performRequestEnd();
    }

    private void r() throws IOException {
        if (isResultSuccess()) {
            p(this.f32388h);
        } else {
            m(this.f32388h);
        }
    }

    public <TResult> void completeTask(TaskCompletionSource<TResult> taskCompletionSource, TResult tresult) {
        Exception exception = getException();
        if (isResultSuccess() && exception == null) {
            taskCompletionSource.setResult(tresult);
        } else {
            taskCompletionSource.setException(StorageException.fromExceptionAndHttpCode(exception, getResultCode()));
        }
    }

    @NonNull
    protected abstract String d();

    @Nullable
    protected JSONObject f() {
        return null;
    }

    @Nullable
    protected byte[] g() {
        return null;
    }

    @Nullable
    public Exception getException() {
        return this.f32381a;
    }

    @Nullable
    public String getRawResult() {
        return this.f32386f;
    }

    public JSONObject getResultBody() {
        if (!TextUtils.isEmpty(this.f32386f)) {
            try {
                return new JSONObject(this.f32386f);
            } catch (JSONException e4) {
                Log.e("NetworkRequest", "error parsing result into JSON:" + this.f32386f, e4);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    public int getResultCode() {
        return this.f32385e;
    }

    @NonNull
    public Map<String, String> getResultHeaders() {
        return this.f32390j;
    }

    @Nullable
    public Map<String, List<String>> getResultHeadersImpl() {
        return this.f32384d;
    }

    @Nullable
    public String getResultString(String str) {
        List<String> list;
        Map<String, List<String>> resultHeadersImpl = getResultHeadersImpl();
        if (resultHeadersImpl != null && (list = resultHeadersImpl.get(str)) != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public int getResultingContentLength() {
        return this.f32387g;
    }

    public InputStream getStream() {
        return this.f32388h;
    }

    @NonNull
    @VisibleForTesting
    public Uri getURL() {
        return this.f32382b.getHttpUri();
    }

    protected int h() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return j(this.f32382b.getGsUri());
    }

    public boolean isResultSuccess() {
        int i4 = this.f32385e;
        if (i4 >= 200 && i4 < 300) {
            return true;
        }
        return false;
    }

    @Nullable
    protected Map<String, String> k() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public StorageReferenceUri l() {
        return this.f32382b;
    }

    protected void m(@Nullable InputStream inputStream) throws IOException {
        n(inputStream);
    }

    protected void p(@Nullable InputStream inputStream) throws IOException {
        n(inputStream);
    }

    public void performRequest(@Nullable String str, @Nullable String str2, @NonNull Context context) {
        if (!c(context)) {
            return;
        }
        q(str, str2);
    }

    public void performRequestEnd() {
        HttpURLConnection httpURLConnection = this.f32389i;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void performRequestStart(@Nullable String str, @Nullable String str2) {
        if (this.f32381a != null) {
            this.f32385e = -1;
            return;
        }
        if (Log.isLoggable("NetworkRequest", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("sending network request ");
            sb.append(d());
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(getURL());
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f32383c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            try {
                HttpURLConnection b4 = b();
                this.f32389i = b4;
                b4.setRequestMethod(d());
                a(this.f32389i, str, str2);
                o(this.f32389i);
                if (Log.isLoggable("NetworkRequest", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("network request result ");
                    sb2.append(this.f32385e);
                    return;
                }
                return;
            } catch (IOException e4) {
                Log.w("NetworkRequest", "error sending network request " + d() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getURL(), e4);
                this.f32381a = e4;
                this.f32385e = -2;
                return;
            }
        }
        this.f32385e = -2;
        this.f32381a = new SocketException("Network subsystem is unavailable");
    }

    public final void reset() {
        this.f32381a = null;
        this.f32385e = 0;
    }

    public void setCustomHeader(String str, String str2) {
        this.f32390j.put(str, str2);
    }
}
