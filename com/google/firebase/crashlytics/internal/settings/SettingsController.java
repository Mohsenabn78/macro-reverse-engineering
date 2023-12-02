package com.google.firebase.crashlytics.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class SettingsController implements SettingsProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30013a;

    /* renamed from: b  reason: collision with root package name */
    private final SettingsRequest f30014b;

    /* renamed from: c  reason: collision with root package name */
    private final SettingsJsonParser f30015c;

    /* renamed from: d  reason: collision with root package name */
    private final CurrentTimeProvider f30016d;

    /* renamed from: e  reason: collision with root package name */
    private final CachedSettingsIo f30017e;

    /* renamed from: f  reason: collision with root package name */
    private final SettingsSpiCall f30018f;

    /* renamed from: g  reason: collision with root package name */
    private final DataCollectionArbiter f30019g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicReference<Settings> f30020h;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicReference<TaskCompletionSource<Settings>> f30021i;

    SettingsController(Context context, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.f30020h = atomicReference;
        this.f30021i = new AtomicReference<>(new TaskCompletionSource());
        this.f30013a = context;
        this.f30014b = settingsRequest;
        this.f30016d = currentTimeProvider;
        this.f30015c = settingsJsonParser;
        this.f30017e = cachedSettingsIo;
        this.f30018f = settingsSpiCall;
        this.f30019g = dataCollectionArbiter;
        atomicReference.set(DefaultSettingsJsonTransform.b(currentTimeProvider));
    }

    public static SettingsController create(Context context, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, FileStore fileStore, DataCollectionArbiter dataCollectionArbiter) {
        String installerPackageName = idManager.getInstallerPackageName();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        return new SettingsController(context, new SettingsRequest(str, idManager.getModelName(), idManager.getOsBuildVersionString(), idManager.getOsDisplayVersionString(), idManager, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(context), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(installerPackageName).getId()), systemCurrentTimeProvider, new SettingsJsonParser(systemCurrentTimeProvider), new CachedSettingsIo(fileStore), new DefaultSettingsSpiCall(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), httpRequestFactory), dataCollectionArbiter);
    }

    private Settings j(SettingsCacheBehavior settingsCacheBehavior) {
        Settings settings = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject readCachedSettings = this.f30017e.readCachedSettings();
                if (readCachedSettings != null) {
                    Settings parseSettingsJson = this.f30015c.parseSettingsJson(readCachedSettings);
                    if (parseSettingsJson != null) {
                        l(readCachedSettings, "Loaded cached settings: ");
                        long currentTimeMillis = this.f30016d.getCurrentTimeMillis();
                        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && parseSettingsJson.isExpired(currentTimeMillis)) {
                            Logger.getLogger().v("Cached settings have expired.");
                        }
                        try {
                            Logger.getLogger().v("Returning cached settings.");
                            settings = parseSettingsJson;
                        } catch (Exception e4) {
                            e = e4;
                            settings = parseSettingsJson;
                            Logger.getLogger().e("Failed to get cached settings", e);
                            return settings;
                        }
                    } else {
                        Logger.getLogger().e("Failed to parse cached settings data.", null);
                    }
                } else {
                    Logger.getLogger().d("No cached settings data found.");
                }
            }
        } catch (Exception e5) {
            e = e5;
        }
        return settings;
    }

    private String k() {
        return CommonUtils.getSharedPrefs(this.f30013a).getString("existing_instance_identifier", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(JSONObject jSONObject, String str) throws JSONException {
        Logger logger = Logger.getLogger();
        logger.d(str + jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public boolean m(String str) {
        SharedPreferences.Editor edit = CommonUtils.getSharedPrefs(this.f30013a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsProvider
    public Task<Settings> getSettingsAsync() {
        return this.f30021i.get().getTask();
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsProvider
    public Settings getSettingsSync() {
        return this.f30020h.get();
    }

    boolean i() {
        return !k().equals(this.f30014b.f30029f);
    }

    public Task<Void> loadSettingsData(Executor executor) {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public Task<Void> loadSettingsData(SettingsCacheBehavior settingsCacheBehavior, Executor executor) {
        Settings j4;
        if (!i() && (j4 = j(settingsCacheBehavior)) != null) {
            this.f30020h.set(j4);
            this.f30021i.get().trySetResult(j4);
            return Tasks.forResult(null);
        }
        Settings j5 = j(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (j5 != null) {
            this.f30020h.set(j5);
            this.f30021i.get().trySetResult(j5);
        }
        return this.f30019g.waitForDataCollectionPermission(executor).onSuccessTask(executor, new SuccessContinuation<Void, Void>() { // from class: com.google.firebase.crashlytics.internal.settings.SettingsController.1
            @Override // com.google.android.gms.tasks.SuccessContinuation
            @NonNull
            /* renamed from: a */
            public Task<Void> then(@Nullable Void r5) throws Exception {
                JSONObject a4 = SettingsController.this.f30018f.a(SettingsController.this.f30014b, true);
                if (a4 != null) {
                    Settings parseSettingsJson = SettingsController.this.f30015c.parseSettingsJson(a4);
                    SettingsController.this.f30017e.writeCachedSettings(parseSettingsJson.expiresAtMillis, a4);
                    SettingsController.this.l(a4, "Loaded settings: ");
                    SettingsController settingsController = SettingsController.this;
                    settingsController.m(settingsController.f30014b.f30029f);
                    SettingsController.this.f30020h.set(parseSettingsJson);
                    ((TaskCompletionSource) SettingsController.this.f30021i.get()).trySetResult(parseSettingsJson);
                }
                return Tasks.forResult(null);
            }
        });
    }
}
