package com.arlosoft.macrodroid.triggers.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import me.drakeet.support.toast.ToastCompat;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* loaded from: classes3.dex */
public class LocationChooserActivity extends MacroDroidBaseActivity {
    public static final String EXTRA_LAT = "lat";
    public static final String EXTRA_LON = "lon";
    public static final String EXTRA_TITLE = "title";

    /* renamed from: f  reason: collision with root package name */
    private LocationManager f14499f;

    /* renamed from: g  reason: collision with root package name */
    private MaterialDialog f14500g;

    /* renamed from: h  reason: collision with root package name */
    private GoogleMap f14501h;

    /* renamed from: i  reason: collision with root package name */
    private LatLng f14502i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14503j;

    /* renamed from: k  reason: collision with root package name */
    private Marker f14504k;

    /* renamed from: l  reason: collision with root package name */
    private FloatingActionButton f14505l;

    /* renamed from: m  reason: collision with root package name */
    private SearchView f14506m;

    /* renamed from: n  reason: collision with root package name */
    private Subscription f14507n;

    /* renamed from: o  reason: collision with root package name */
    private final LocationListener f14508o = new a();

    /* loaded from: classes3.dex */
    class b implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MenuItem f14510a;

        b(MenuItem menuItem) {
            this.f14510a = menuItem;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            LocationChooserActivity.this.O(str);
            LocationChooserActivity.this.f14506m.clearFocus();
            this.f14510a.collapseActionView();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    class c implements MenuItemCompat.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Menu f14512a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MenuItem f14513b;

        c(Menu menu, MenuItem menuItem) {
            this.f14512a = menu;
            this.f14513b = menuItem;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            for (int i4 = 0; i4 < this.f14512a.size(); i4++) {
                MenuItem item = this.f14512a.getItem(i4);
                if (item != this.f14513b) {
                    item.setVisible(true);
                }
            }
            return true;
        }

        @Override // androidx.core.view.MenuItemCompat.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return true;
        }
    }

    private void C() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.trigger_weather_set_location);
        builder.setMessage(R.string.trigger_weather_usage_instructions);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private Observable<Address> D(String str) throws IOException {
        return Observable.from(new Geocoder(this).getFromLocationName(str, 1));
    }

    private void E() {
        Location location;
        ((ViewGroup) findViewById(R.id.activity_location_trigger_v2_radius_container)).setVisibility(8);
        LocationManager locationManager = (LocationManager) getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (Settings.getMapSatellite(this)) {
            this.f14501h.setMapType(2);
        }
        double doubleExtra = getIntent().getDoubleExtra(EXTRA_LAT, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        double doubleExtra2 = getIntent().getDoubleExtra(EXTRA_LON, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        if (doubleExtra != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && doubleExtra2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.f14501h.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(doubleExtra, doubleExtra2), 13.0f));
        } else {
            if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                location = locationManager.getLastKnownLocation("gps");
                if (location == null) {
                    location = locationManager.getLastKnownLocation("network");
                }
            } else {
                location = null;
            }
            if (location != null) {
                this.f14501h.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 13.0f));
            }
        }
        this.f14501h.setOnMapClickListener(new GoogleMap.OnMapClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.i
            @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                LocationChooserActivity.this.G(latLng);
            }
        });
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(LatLng latLng) {
        if (this.f14503j) {
            P(latLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        this.f14505l.setVisibility(8);
        GoogleMap googleMap = this.f14501h;
        if (googleMap != null && googleMap.getUiSettings() != null) {
            this.f14501h.getUiSettings().setScrollGesturesEnabled(false);
        }
        Marker marker = this.f14504k;
        if (marker != null) {
            marker.remove();
            this.f14504k = null;
        }
        this.f14503j = true;
        getSupportActionBar().setCustomView(R.layout.activity_location_trigger_action_bar_set_location);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(Menu menu, MenuItem menuItem, View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        boolean isIconified = this.f14506m.isIconified();
        for (int i12 = 0; i12 < menu.size(); i12++) {
            MenuItem item = menu.getItem(i12);
            if (item != menuItem) {
                item.setVisible(isIconified);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(GoogleMap googleMap) {
        this.f14501h = googleMap;
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(DialogInterface dialogInterface) {
        this.f14499f.removeUpdates(this.f14508o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(Address address) {
        if (address != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Search Location: ");
            sb.append(address.getLatitude());
            sb.append(",");
            sb.append(address.getLongitude());
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            GoogleMap googleMap = this.f14501h;
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, googleMap.getCameraPosition().zoom));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(Throwable th) {
        ToastCompat.makeText(getApplicationContext(), (int) R.string.no_location_found, 0).show();
    }

    private void N() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            return;
        }
        this.f14499f.requestLocationUpdates("network", 0L, 0.0f, this.f14508o);
        try {
            this.f14499f.requestLocationUpdates("gps", 0L, 0.0f, this.f14508o);
        } catch (Exception unused) {
        }
        MaterialDialog show = new MaterialDialog.Builder(this).title(R.string.please_wait).content(R.string.obtaining_location).progress(true, 0).cancelable(true).show();
        this.f14500g = show;
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.activities.e
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LocationChooserActivity.this.K(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str) {
        try {
            this.f14507n = D(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).first().subscribe(new Action1() { // from class: com.arlosoft.macrodroid.triggers.activities.j
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    LocationChooserActivity.this.L((Address) obj);
                }
            }, new Action1() { // from class: com.arlosoft.macrodroid.triggers.activities.k
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    LocationChooserActivity.this.M((Throwable) obj);
                }
            });
        } catch (IOException e4) {
            Log.e("LocationChooserActivity", "Search exception: " + e4.toString());
            ToastCompat.makeText(getApplicationContext(), (int) R.string.no_location_found, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(LatLng latLng) {
        this.f14502i = new LatLng(latLng.latitude, latLng.longitude);
        MarkerOptions icon = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
        icon.position(this.f14502i);
        this.f14504k = this.f14501h.addMarker(icon);
        this.f14503j = false;
        getSupportActionBar().setDisplayShowCustomEnabled(false);
        invalidateOptionsMenu();
        this.f14505l.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(9);
        super.onCreate(bundle);
        setContentView(R.layout.activity_location_trigger_v2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            getSupportActionBar().setTitle(stringExtra);
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.activity_location_trigger_v2_set_location_button);
        this.f14505l = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocationChooserActivity.this.H(view);
            }
        });
        MapsInitializer.initialize(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(final Menu menu) {
        if (this.f14503j) {
            return true;
        }
        getMenuInflater().inflate(R.menu.location_trigger_menu, menu);
        menu.findItem(R.id.menu_satellite_view).setChecked(Settings.getMapSatellite(this));
        final MenuItem findItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(findItem);
        this.f14506m = searchView;
        searchView.setOnQueryTextListener(new b(findItem));
        this.f14506m.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arlosoft.macrodroid.triggers.activities.h
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                LocationChooserActivity.this.I(menu, findItem, view, i4, i5, i6, i7, i8, i9, i10, i11);
            }
        });
        MenuItemCompat.setOnActionExpandListener(findItem, new c(menu, findItem));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.f14507n;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int i4;
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                break;
            case R.id.menu_current_location /* 2131363385 */:
                if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 34);
                    return true;
                }
                N();
                break;
            case R.id.menu_done /* 2131363391 */:
                LatLng latLng = this.f14502i;
                if (latLng == null) {
                    ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.please_set_location), 0).show();
                    break;
                } else {
                    Settings.setLastLocation(this, latLng);
                    Intent intent = new Intent();
                    intent.putExtra(LocationTrigger.LATITUDE_EXTRA, this.f14502i.latitude);
                    intent.putExtra(LocationTrigger.LONGITUDE_EXTRA, this.f14502i.longitude);
                    setResult(-1, intent);
                    finish();
                    break;
                }
            case R.id.menu_satellite_view /* 2131363419 */:
                boolean z3 = !Settings.getMapSatellite(this);
                Settings.setMapSatellite(this, z3);
                menuItem.setChecked(z3);
                GoogleMap googleMap = this.f14501h;
                if (z3) {
                    i4 = 2;
                } else {
                    i4 = 1;
                }
                googleMap.setMapType(i4);
                return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i4 != 34) {
            super.onRequestPermissionsResult(i4, strArr, iArr);
        } else if (iArr[0] == 0) {
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f14499f = (LocationManager) getSystemService(FirebaseAnalytics.Param.LOCATION);
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(new OnMapReadyCallback() { // from class: com.arlosoft.macrodroid.triggers.activities.f
            @Override // com.google.android.gms.maps.OnMapReadyCallback
            public final void onMapReady(GoogleMap googleMap) {
                LocationChooserActivity.this.J(googleMap);
            }
        });
    }

    /* loaded from: classes3.dex */
    class a implements LocationListener {
        a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                LocationChooserActivity.this.f14499f.removeUpdates(this);
            } catch (SecurityException unused) {
            }
            if (!LocationChooserActivity.this.isDestroyedOrFinishing()) {
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                LocationChooserActivity.this.f14501h.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));
                if (LocationChooserActivity.this.f14504k != null) {
                    LocationChooserActivity.this.f14504k.remove();
                    LocationChooserActivity.this.f14504k = null;
                }
                LocationChooserActivity.this.P(latLng);
                if (LocationChooserActivity.this.f14500g != null && LocationChooserActivity.this.f14500g.isShowing()) {
                    LocationChooserActivity.this.f14500g.dismiss();
                }
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
