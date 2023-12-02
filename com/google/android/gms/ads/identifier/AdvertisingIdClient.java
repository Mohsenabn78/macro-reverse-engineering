package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
@KeepForSdk
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public class AdvertisingIdClient {
    @Nullable
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    BlockingServiceConnection f19027a;
    @Nullable
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    zzf f19028b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    boolean f19029c;

    /* renamed from: d  reason: collision with root package name */
    final Object f19030d;
    @Nullable
    @GuardedBy("mAutoDisconnectTaskLock")

    /* renamed from: e  reason: collision with root package name */
    zzb f19031e;
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private final Context f19032f;

    /* renamed from: g  reason: collision with root package name */
    final long f19033g;

    /* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
    @KeepForSdkWithMembers
    /* loaded from: classes4.dex */
    public static final class Info {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final String f19034a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f19035b;

        @Deprecated
        public Info(@Nullable String str, boolean z3) {
            this.f19034a = str;
            this.f19035b = z3;
        }

        @Nullable
        public String getId() {
            return this.f19034a;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f19035b;
        }

        @NonNull
        public String toString() {
            String str = this.f19034a;
            boolean z3 = this.f19035b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z3);
            return sb.toString();
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(@NonNull Context context) {
        this(context, 30000L, false, false);
    }

    private final Info c(int i4) throws IOException {
        Info info;
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f19029c) {
                synchronized (this.f19030d) {
                    zzb zzbVar = this.f19031e;
                    if (zzbVar == null || !zzbVar.f19040d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    a(false);
                    if (!this.f19029c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e4) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e4);
                }
            }
            Preconditions.checkNotNull(this.f19027a);
            Preconditions.checkNotNull(this.f19028b);
            try {
                info = new Info(this.f19028b.zzc(), this.f19028b.zze(true));
            } catch (RemoteException e5) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e5);
                throw new IOException("Remote exception");
            }
        }
        d();
        return info;
    }

    private final void d() {
        synchronized (this.f19030d) {
            zzb zzbVar = this.f19031e;
            if (zzbVar != null) {
                zzbVar.f19039c.countDown();
                try {
                    this.f19031e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j4 = this.f19033g;
            if (j4 > 0) {
                this.f19031e = new zzb(this, j4);
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static Info getAdvertisingIdInfo(@NonNull Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.a(false);
            Info c4 = advertisingIdClient.c(-1);
            advertisingIdClient.b(c4, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", null);
            return c4;
        } finally {
        }
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(@NonNull Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        boolean zzd;
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, false, false);
        try {
            advertisingIdClient.a(false);
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized (advertisingIdClient) {
                if (!advertisingIdClient.f19029c) {
                    synchronized (advertisingIdClient.f19030d) {
                        zzb zzbVar = advertisingIdClient.f19031e;
                        if (zzbVar == null || !zzbVar.f19040d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        advertisingIdClient.a(false);
                        if (!advertisingIdClient.f19029c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e4) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e4);
                    }
                }
                Preconditions.checkNotNull(advertisingIdClient.f19027a);
                Preconditions.checkNotNull(advertisingIdClient.f19028b);
                try {
                    zzd = advertisingIdClient.f19028b.zzd();
                } catch (RemoteException e5) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e5);
                    throw new IOException("Remote exception");
                }
            }
            advertisingIdClient.d();
            return zzd;
        } finally {
            advertisingIdClient.zza();
        }
    }

    @VisibleForTesting
    protected final void a(boolean z3) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f19029c) {
                zza();
            }
            Context context = this.f19032f;
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                if (isGooglePlayServicesAvailable != 0 && isGooglePlayServicesAvailable != 2) {
                    throw new IOException("Google Play services not available");
                }
                BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                    this.f19027a = blockingServiceConnection;
                    try {
                        this.f19028b = zze.zza(blockingServiceConnection.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
                        this.f19029c = true;
                        if (z3) {
                            d();
                        }
                    } catch (InterruptedException unused) {
                        throw new IOException("Interrupted exception");
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                } else {
                    throw new IOException("Connection failure");
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new GooglePlayServicesNotAvailableException(9);
            }
        }
    }

    @VisibleForTesting
    final boolean b(@Nullable Info info, boolean z3, float f4, long j4, String str, @Nullable Throwable th) {
        if (Math.random() <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            HashMap hashMap = new HashMap();
            String str2 = "1";
            hashMap.put("app_context", "1");
            if (info != null) {
                if (true != info.isLimitAdTrackingEnabled()) {
                    str2 = "0";
                }
                hashMap.put("limit_ad_tracking", str2);
                String id = info.getId();
                if (id != null) {
                    hashMap.put("ad_id_size", Integer.toString(id.length()));
                }
            }
            if (th != null) {
                hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, th.getClass().getName());
            }
            hashMap.put("tag", "AdvertisingIdClient");
            hashMap.put("time_spent", Long.toString(j4));
            new zza(this, hashMap).start();
            return true;
        }
        return false;
    }

    protected final void finalize() throws Throwable {
        zza();
        super.finalize();
    }

    @NonNull
    @KeepForSdk
    public Info getInfo() throws IOException {
        return c(-1);
    }

    @KeepForSdk
    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        a(true);
    }

    public final void zza() {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f19032f != null && this.f19027a != null) {
                if (this.f19029c) {
                    ConnectionTracker.getInstance().unbindService(this.f19032f, this.f19027a);
                }
                this.f19029c = false;
                this.f19028b = null;
                this.f19027a = null;
            }
        }
    }

    @VisibleForTesting
    public AdvertisingIdClient(@NonNull Context context, long j4, boolean z3, boolean z4) {
        Context applicationContext;
        this.f19030d = new Object();
        Preconditions.checkNotNull(context);
        if (z3 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f19032f = context;
        this.f19029c = false;
        this.f19033g = j4;
    }

    @ShowFirstParty
    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z3) {
    }
}
