package com.arlosoft.macrodroid.triggers.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes3.dex */
public class LocationTriggerService extends Service {

    /* renamed from: g  reason: collision with root package name */
    private static Location f15491g;

    /* renamed from: a  reason: collision with root package name */
    private PowerManager.WakeLock f15492a;

    /* renamed from: b  reason: collision with root package name */
    private PendingIntent f15493b;

    /* renamed from: c  reason: collision with root package name */
    private b f15494c;

    /* renamed from: d  reason: collision with root package name */
    private LocationManager f15495d;

    /* renamed from: e  reason: collision with root package name */
    private Location f15496e;

    /* renamed from: f  reason: collision with root package name */
    private final LocationListener f15497f = new a();

    /* loaded from: classes3.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (LocationTriggerService.this.f15496e == null) {
                SystemLog.logVerbose("LOC UPDATE FAILED - Could not obtain a good location fix.");
            } else {
                SystemLog.logVerbose("LOC UPDATE FAILED - Fix not good enough (Accuracy: " + LocationTriggerService.this.f15496e.getAccuracy() + "m)");
            }
            try {
                if (LocationTriggerService.this.f15495d != null) {
                    LocationTriggerService.this.f15495d.removeUpdates(LocationTriggerService.this.f15497f);
                }
            } catch (SecurityException unused) {
            }
            if (LocationTriggerService.this.f15492a.isHeld()) {
                LocationTriggerService.this.f15492a.release();
            }
            LocationTriggerService.this.stopSelf();
        }

        /* synthetic */ b(LocationTriggerService locationTriggerService, a aVar) {
            this();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            PermissionsHelper.showNeedsPermission(this, "android.permission.ACCESS_COARSE_LOCATION", getString(R.string.location_trigger), true, false);
            stopSelf();
            return;
        }
        SystemLog.logVerbose("LocationTrigger: Obtaining a location fix");
        PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "macrodorid:locationtriggerservice");
        this.f15492a = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        this.f15495d = (LocationManager) getSystemService(FirebaseAnalytics.Param.LOCATION);
        IntentFilter intentFilter = new IntentFilter("Timeout");
        b bVar = new b(this, null);
        this.f15494c = bVar;
        registerReceiver(bVar, intentFilter);
        this.f15492a.acquire(40500L);
        this.f15495d.removeUpdates(this.f15497f);
        try {
            this.f15495d.requestLocationUpdates("network", 0L, 0.0f, this.f15497f);
        } catch (Exception unused) {
        }
        try {
            this.f15495d.requestLocationUpdates("gps", 0L, 0.0f, this.f15497f);
        } catch (Exception unused2) {
        }
        this.f15493b = PendingIntent.getBroadcast(this, 0, new Intent("Timeout"), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, System.currentTimeMillis() + 40000, this.f15493b);
        this.f15496e = null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        PowerManager.WakeLock wakeLock = this.f15492a;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f15492a.release();
        }
        this.f15492a = null;
        if (this.f15493b != null) {
            ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f15493b);
        }
        b bVar = this.f15494c;
        if (bVar != null) {
            unregisterReceiver(bVar);
        }
        super.onDestroy();
    }

    /* loaded from: classes3.dex */
    class a implements LocationListener {
        a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location.getProvider().equals("network")) {
                if (LocationTriggerService.f15491g == null || location.distanceTo(LocationTriggerService.f15491g) >= 1.0E-8d) {
                    Location unused = LocationTriggerService.f15491g = location;
                } else {
                    return;
                }
            }
            if (LocationTriggerService.this.f15496e == null) {
                LocationTriggerService.this.f15496e = location;
            } else if (location.getAccuracy() < LocationTriggerService.this.f15496e.getAccuracy()) {
                LocationTriggerService.this.f15496e = location;
            }
            if (LocationTriggerAreaChecker.checkLocationTriggers(location)) {
                ((AlarmManager) LocationTriggerService.this.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(LocationTriggerService.this.f15493b);
                SystemLog.logVerbose("LocationTrigger: Good location obtained");
                try {
                    LocationTriggerService.this.f15495d.removeUpdates(LocationTriggerService.this.f15497f);
                } catch (SecurityException unused2) {
                }
                if (LocationTriggerService.this.f15492a != null && LocationTriggerService.this.f15492a.isHeld()) {
                    LocationTriggerService.this.f15492a.release();
                }
                LocationTriggerService.this.stopSelf();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i4, Bundle bundle) {
        }
    }
}
