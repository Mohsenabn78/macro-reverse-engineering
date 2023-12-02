package com.google.firebase.remoteconfig.internal;

import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class ConfigAutoFetch {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final Set<ConfigUpdateListener> f31913a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpURLConnection f31914b;

    /* renamed from: c  reason: collision with root package name */
    private final ConfigFetchHandler f31915c;

    /* renamed from: d  reason: collision with root package name */
    private final ConfigCacheClient f31916d;

    /* renamed from: e  reason: collision with root package name */
    private final ConfigUpdateListener f31917e;

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f31918f;

    /* renamed from: g  reason: collision with root package name */
    private final Random f31919g = new Random();

    public ConfigAutoFetch(HttpURLConnection httpURLConnection, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Set<ConfigUpdateListener> set, ConfigUpdateListener configUpdateListener, ScheduledExecutorService scheduledExecutorService) {
        this.f31914b = httpURLConnection;
        this.f31915c = configFetchHandler;
        this.f31916d = configCacheClient;
        this.f31913a = set;
        this.f31917e = configUpdateListener;
        this.f31918f = scheduledExecutorService;
    }

    private void b(final int i4, final long j4) {
        if (i4 == 0) {
            i(new FirebaseRemoteConfigServerException("Unable to fetch the latest version of the template.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_NOT_FETCHED));
            return;
        }
        this.f31918f.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.1
            @Override // java.lang.Runnable
            public void run() {
                ConfigAutoFetch.this.fetchLatestConfig(i4, j4);
            }
        }, this.f31919g.nextInt(4), TimeUnit.SECONDS);
    }

    private synchronized void c(ConfigUpdate configUpdate) {
        for (ConfigUpdateListener configUpdateListener : this.f31913a) {
            configUpdateListener.onUpdate(configUpdate);
        }
    }

    private static Boolean d(ConfigFetchHandler.FetchResponse fetchResponse, long j4) {
        boolean z3 = false;
        if (fetchResponse.getFetchedConfigs() != null) {
            if (fetchResponse.getFetchedConfigs().getTemplateVersionNumber() >= j4) {
                z3 = true;
            }
            return Boolean.valueOf(z3);
        }
        if (fetchResponse.b() == 1) {
            z3 = true;
        }
        return Boolean.valueOf(z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        r5 = new org.json.JSONObject(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        if (r5.has("featureDisabled") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        if (r5.getBoolean("featureDisabled") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
        r9.f31917e.onError(new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException("The server is temporarily unavailable. Try again in a few minutes.", com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
        if (f() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
        if (r5.has("latestTemplateVersionNumber") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
        r6 = r9.f31915c.getTemplateVersionNumber();
        r4 = r5.getLong("latestTemplateVersionNumber");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
        if (r4 <= r6) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
        b(3, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(java.io.InputStream r10) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "latestTemplateVersionNumber"
            java.lang.String r1 = "featureDisabled"
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            java.lang.String r4 = "utf-8"
            r3.<init>(r10, r4)
            r2.<init>(r3)
            java.lang.String r3 = ""
        L12:
            r4 = r3
        L13:
            java.lang.String r5 = r2.readLine()
            if (r5 == 0) goto L95
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "}"
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L13
            java.lang.String r4 = r9.h(r4)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L3b
            goto L13
        L3b:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L7b
            r5.<init>(r4)     // Catch: org.json.JSONException -> L7b
            boolean r4 = r5.has(r1)     // Catch: org.json.JSONException -> L7b
            if (r4 == 0) goto L5b
            boolean r4 = r5.getBoolean(r1)     // Catch: org.json.JSONException -> L7b
            if (r4 == 0) goto L5b
            com.google.firebase.remoteconfig.ConfigUpdateListener r4 = r9.f31917e     // Catch: org.json.JSONException -> L7b
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException     // Catch: org.json.JSONException -> L7b
            java.lang.String r6 = "The server is temporarily unavailable. Try again in a few minutes."
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r7 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE     // Catch: org.json.JSONException -> L7b
            r5.<init>(r6, r7)     // Catch: org.json.JSONException -> L7b
            r4.onError(r5)     // Catch: org.json.JSONException -> L7b
            goto L95
        L5b:
            boolean r4 = r9.f()     // Catch: org.json.JSONException -> L7b
            if (r4 == 0) goto L62
            goto L95
        L62:
            boolean r4 = r5.has(r0)     // Catch: org.json.JSONException -> L7b
            if (r4 == 0) goto L12
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler r4 = r9.f31915c     // Catch: org.json.JSONException -> L7b
            long r6 = r4.getTemplateVersionNumber()     // Catch: org.json.JSONException -> L7b
            long r4 = r5.getLong(r0)     // Catch: org.json.JSONException -> L7b
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L12
            r6 = 3
            r9.b(r6, r4)     // Catch: org.json.JSONException -> L7b
            goto L12
        L7b:
            r4 = move-exception
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException
            java.lang.Throwable r6 = r4.getCause()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r7 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_MESSAGE_INVALID
            java.lang.String r8 = "Unable to parse config update message."
            r5.<init>(r8, r6, r7)
            r9.i(r5)
            java.lang.String r5 = "FirebaseRemoteConfig"
            java.lang.String r6 = "Unable to parse latest config update message."
            android.util.Log.e(r5, r6, r4)
            goto L12
        L95:
            r2.close()
            r10.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.e(java.io.InputStream):void");
    }

    private synchronized boolean f() {
        return this.f31913a.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task g(Task task, Task task2, long j4, int i4, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to auto-fetch config update.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to get activated config for auto-fetch", task2.getException()));
        }
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) task.getResult();
        ConfigContainer configContainer = (ConfigContainer) task2.getResult();
        if (!d(fetchResponse, j4).booleanValue()) {
            b(i4, j4);
            return Tasks.forResult(null);
        } else if (fetchResponse.getFetchedConfigs() == null) {
            return Tasks.forResult(null);
        } else {
            if (configContainer == null) {
                configContainer = ConfigContainer.newBuilder().build();
            }
            Set<String> changedParams = configContainer.getChangedParams(fetchResponse.getFetchedConfigs());
            if (changedParams.isEmpty()) {
                return Tasks.forResult(null);
            }
            c(ConfigUpdate.create(changedParams));
            return Tasks.forResult(null);
        }
    }

    private String h(String str) {
        int indexOf = str.indexOf(123);
        int lastIndexOf = str.lastIndexOf(125);
        if (indexOf < 0 || lastIndexOf < 0 || indexOf >= lastIndexOf) {
            return "";
        }
        return str.substring(indexOf, lastIndexOf + 1);
    }

    private synchronized void i(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        for (ConfigUpdateListener configUpdateListener : this.f31913a) {
            configUpdateListener.onError(firebaseRemoteConfigException);
        }
    }

    @VisibleForTesting
    public synchronized Task<Void> fetchLatestConfig(int i4, final long j4) {
        final int i5;
        final Task<ConfigFetchHandler.FetchResponse> fetchNowWithTypeAndAttemptNumber;
        final Task<ConfigContainer> task;
        i5 = i4 - 1;
        fetchNowWithTypeAndAttemptNumber = this.f31915c.fetchNowWithTypeAndAttemptNumber(ConfigFetchHandler.FetchType.REALTIME, 3 - i5);
        task = this.f31916d.get();
        return Tasks.whenAllComplete(fetchNowWithTypeAndAttemptNumber, task).continueWithTask(this.f31918f, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.a
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                Task g4;
                g4 = ConfigAutoFetch.this.g(fetchNowWithTypeAndAttemptNumber, task, j4, i5, task2);
                return g4;
            }
        });
    }

    @VisibleForTesting
    public void listenForNotifications() {
        HttpURLConnection httpURLConnection = this.f31914b;
        if (httpURLConnection == null) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            e(inputStream);
            inputStream.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.f31914b.disconnect();
            throw th;
        }
        this.f31914b.disconnect();
    }
}
