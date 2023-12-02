package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class IdManager implements InstallIdProvider {
    public static final String DEFAULT_VERSION_NAME = "0.0";

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f29527g = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: h  reason: collision with root package name */
    private static final String f29528h = Pattern.quote(RemoteSettings.FORWARD_SLASH_STRING);

    /* renamed from: a  reason: collision with root package name */
    private final InstallerPackageNameProvider f29529a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f29530b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29531c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseInstallationsApi f29532d;

    /* renamed from: e  reason: collision with root package name */
    private final DataCollectionArbiter f29533e;

    /* renamed from: f  reason: collision with root package name */
    private InstallIdProvider.InstallIds f29534f;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionArbiter dataCollectionArbiter) {
        if (context != null) {
            if (str != null) {
                this.f29530b = context;
                this.f29531c = str;
                this.f29532d = firebaseInstallationsApi;
                this.f29533e = dataCollectionArbiter;
                this.f29529a = new InstallerPackageNameProvider();
                return;
            }
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        throw new IllegalArgumentException("appContext must not be null");
    }

    @NonNull
    private synchronized String a(String str, SharedPreferences sharedPreferences) {
        String c4;
        c4 = c(UUID.randomUUID().toString());
        Logger logger = Logger.getLogger();
        logger.v("Created new Crashlytics installation ID: " + c4 + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", c4).putString("firebase.installation.id", str).apply();
        return c4;
    }

    static String b() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        return f29527g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    static boolean d(String str) {
        if (str != null && str.startsWith("SYN_")) {
            return true;
        }
        return false;
    }

    private String e(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    private String f(String str) {
        return str.replaceAll(f29528h, "");
    }

    private boolean g() {
        InstallIdProvider.InstallIds installIds = this.f29534f;
        if (installIds != null && (installIds.getFirebaseInstallationId() != null || !this.f29533e.isAutomaticDataCollectionEnabled())) {
            return false;
        }
        return true;
    }

    @Nullable
    @VisibleForTesting(otherwise = 3)
    public String fetchTrueFid() {
        try {
            return (String) Utils.awaitEvenIfOnMainThread(this.f29532d.getId());
        } catch (Exception e4) {
            Logger.getLogger().w("Failed to retrieve Firebase Installation ID.", e4);
            return null;
        }
    }

    public String getAppIdentifier() {
        return this.f29531c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    @NonNull
    public synchronized InstallIdProvider.InstallIds getInstallIds() {
        if (!g()) {
            return this.f29534f;
        }
        Logger.getLogger().v("Determining Crashlytics installation ID...");
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.f29530b);
        String string = sharedPrefs.getString("firebase.installation.id", null);
        Logger logger = Logger.getLogger();
        logger.v("Cached Firebase Installation ID: " + string);
        if (this.f29533e.isAutomaticDataCollectionEnabled()) {
            String fetchTrueFid = fetchTrueFid();
            Logger logger2 = Logger.getLogger();
            logger2.v("Fetched Firebase Installation ID: " + fetchTrueFid);
            if (fetchTrueFid == null) {
                if (string == null) {
                    fetchTrueFid = b();
                } else {
                    fetchTrueFid = string;
                }
            }
            if (fetchTrueFid.equals(string)) {
                this.f29534f = InstallIdProvider.InstallIds.a(e(sharedPrefs), fetchTrueFid);
            } else {
                this.f29534f = InstallIdProvider.InstallIds.a(a(fetchTrueFid, sharedPrefs), fetchTrueFid);
            }
        } else if (d(string)) {
            this.f29534f = InstallIdProvider.InstallIds.createWithoutFid(e(sharedPrefs));
        } else {
            this.f29534f = InstallIdProvider.InstallIds.createWithoutFid(a(b(), sharedPrefs));
        }
        Logger logger3 = Logger.getLogger();
        logger3.v("Install IDs: " + this.f29534f);
        return this.f29534f;
    }

    public String getInstallerPackageName() {
        return this.f29529a.a(this.f29530b);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", f(Build.MANUFACTURER), f(Build.MODEL));
    }

    public String getOsBuildVersionString() {
        return f(Build.VERSION.INCREMENTAL);
    }

    public String getOsDisplayVersionString() {
        return f(Build.VERSION.RELEASE);
    }
}
