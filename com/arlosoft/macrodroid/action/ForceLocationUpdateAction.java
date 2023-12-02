package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.location.Location;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.action.info.ForceLocationUpdateActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ForceLocationUpdateAction extends Action {
    public static final Parcelable.Creator<ForceLocationUpdateAction> CREATOR = new b();
    private transient FusedLocationProviderClient fusedLocationClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LocationRequest f2242a;

        a(LocationRequest locationRequest) {
            this.f2242a = locationRequest;
        }

        @Override // com.google.android.gms.location.LocationListener
        public void onLocationChanged(@NonNull Location location) {
            if (location != null) {
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');
                DecimalFormat decimalFormat = new DecimalFormat("#.#######", decimalFormatSymbols);
                String str = Util.GOOGLE_MAPS_HEADING + location.getLatitude() + "," + location.getLongitude() + "&center=" + decimalFormat.format(location.getLatitude()) + "," + decimalFormat.format(location.getLongitude());
                SystemLog.logInfo("Forced Location Update: <a href=\"" + str + "\">" + str + " (Uncertainty=" + location.getAccuracy() + "m)</a>", ForceLocationUpdateAction.this.getMacroGuid().longValue());
            } else {
                SystemLog.logError("Force location update failed (location is null)", ForceLocationUpdateAction.this.getMacroGuid().longValue());
            }
            ForceLocationUpdateAction.this.fusedLocationClient.requestLocationUpdates(this.f2242a, this, (Looper) null);
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<ForceLocationUpdateAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ForceLocationUpdateAction createFromParcel(Parcel parcel) {
            return new ForceLocationUpdateAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ForceLocationUpdateAction[] newArray(int i4) {
            return new ForceLocationUpdateAction[i4];
        }
    }

    /* synthetic */ ForceLocationUpdateAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void init() {
        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ForceLocationUpdateActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        LocationTrigger.forceUpdate();
        LocationRequest interval = LocationRequest.create().setPriority(102).setSmallestDisplacement(0.0f).setExpirationDuration(TimeUnit.SECONDS.toMillis(5L)).setNumUpdates(1).setInterval(ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
        this.fusedLocationClient.requestLocationUpdates(interval, new a(interval), (Looper) null);
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
    }

    public ForceLocationUpdateAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ForceLocationUpdateAction() {
        this.fusedLocationClient = null;
        init();
    }

    private ForceLocationUpdateAction(Parcel parcel) {
        super(parcel);
        this.fusedLocationClient = null;
        init();
    }
}
