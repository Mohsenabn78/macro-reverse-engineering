package com.arlosoft.macrodroid.geofences.ui;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.geofences.GeofenceInfo;
import com.arlosoft.macrodroid.geofences.GeofenceListActivity;
import com.arlosoft.macrodroid.geofences.LocationHelper;
import com.arlosoft.macrodroid.geofences.ui.ConfigureZoneActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details.PlaceDetails;
import com.oneclickaway.opensource.placeautocomplete.utils.SearchPlacesStatusCodes;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class ConfigureZoneActivity extends MacroDroidBaseActivity implements ConfigureZoneView {
    public static final String EXTRA_GEOFENCE = "geofence";
    @BindView(R.id.area_radius)
    View areaRadius;
    @BindView(R.id.area_seek_bar)
    SeekBar areaSeekBar;

    /* renamed from: f  reason: collision with root package name */
    private ConfigureZonePresenter f12240f;

    /* renamed from: g  reason: collision with root package name */
    private String f12241g;

    /* renamed from: h  reason: collision with root package name */
    private SupportMapFragment f12242h;

    /* renamed from: i  reason: collision with root package name */
    private GoogleMap f12243i;

    /* renamed from: j  reason: collision with root package name */
    private GeofenceInfo f12244j;

    /* renamed from: k  reason: collision with root package name */
    private LocationManager f12245k;

    /* renamed from: l  reason: collision with root package name */
    private MaterialDialog f12246l;

    /* renamed from: m  reason: collision with root package name */
    private final LocationListener f12247m = new a();
    @BindView(R.id.radius_value_text)
    TextView radiusValueText;
    @BindView(R.id.search_box)
    TextView searchBox;
    @BindView(R.id.zone_name)
    EditText zoneName;

    /* loaded from: classes3.dex */
    class d extends OnBackPressedCallback {
        d(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            ConfigureZoneActivity.this.f12240f.handleExitAttempt();
        }
    }

    /* loaded from: classes3.dex */
    class e implements GoogleMap.SnapshotReadyCallback {
        e() {
        }

        @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
        public void onSnapshotReady(Bitmap bitmap) {
            File file = new File(ConfigureZoneActivity.this.getFilesDir().getAbsolutePath(), Constants.MAPS_IMAGE_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + ConfigureZoneActivity.this.f12244j.getId() + ".png");
                bitmap.compress(Bitmap.CompressFormat.PNG, 95, fileOutputStream);
                fileOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            ConfigureZoneActivity.this.closeView(true);
        }
    }

    private void B() {
        getWindow().setSoftInputMode(3);
    }

    private void C(GeofenceInfo geofenceInfo, float f4) {
        if (Settings.getMapSatellite(this)) {
            this.f12243i.setMapType(2);
        }
        if (geofenceInfo.getLatitude() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || geofenceInfo.getLongitude() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.f12243i.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(geofenceInfo.getLatitude(), geofenceInfo.getLongitude()), f4));
            setAreaRadius(geofenceInfo.getRadius());
        }
        this.f12243i.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() { // from class: a0.h
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraChangeListener
            public final void onCameraChange(CameraPosition cameraPosition) {
                ConfigureZoneActivity.this.D(cameraPosition);
            }
        });
        this.f12243i.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: a0.i
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public final void onCameraMove() {
                ConfigureZoneActivity.this.E();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(CameraPosition cameraPosition) {
        ConfigureZonePresenter configureZonePresenter = this.f12240f;
        LatLng latLng = cameraPosition.target;
        configureZonePresenter.setLatLong(latLng.latitude, latLng.longitude);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.f12240f.cameraMoved();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(Intent intent, View view) {
        startActivityForResult(intent, 700, ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(this.searchBox, SearchPlacesStatusCodes.INSTANCE.getPLACEHOLDER_TRANSITION())).toBundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(float f4, GoogleMap googleMap) {
        this.f12243i = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        this.f12243i.setPadding(0, getResources().getDimensionPixelOffset(R.dimen.zoom_controls_padding_bottom), 0, getResources().getDimensionPixelOffset(R.dimen.zoom_controls_padding_bottom));
        C(this.f12244j, f4);
        this.areaSeekBar.setOnSeekBarChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        this.f12240f.saveSettings(this.f12241g, this.zoneName.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(DialogInterface dialogInterface, int i4) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(DialogInterface dialogInterface) {
        this.f12245k.removeUpdates(this.f12247m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(DialogInterface dialogInterface, int i4) {
        this.f12240f.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(EditText editText, DialogInterface dialogInterface, int i4) {
        if (editText.length() > 0) {
            this.f12240f.setRadius(Integer.valueOf(editText.getText().toString()).intValue());
        }
    }

    private void N() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return;
        }
        try {
            this.f12245k.requestLocationUpdates("network", 0L, 0.0f, this.f12247m);
        } catch (Exception unused) {
        }
        try {
            this.f12245k.requestLocationUpdates("gps", 0L, 0.0f, this.f12247m);
        } catch (Exception unused2) {
        }
        MaterialDialog show = new MaterialDialog.Builder(this).title(R.string.please_wait).content(R.string.obtaining_location).progress(true, 0).cancelable(true).show();
        this.f12246l = show;
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: a0.j
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ConfigureZoneActivity.this.K(dialogInterface);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void closeView(boolean z3) {
        Intent intent = new Intent();
        if (z3) {
            setResult(0);
        } else {
            intent.putExtra(GeofenceListActivity.EXTRA_SELECTED_GEOFENCE_ID, this.f12244j.getId());
            setResult(-1, intent);
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 700 && i5 == -1 && intent != null) {
            PlaceDetails placeDetails = (PlaceDetails) intent.getParcelableExtra(SearchPlacesStatusCodes.INSTANCE.getPLACE_DATA());
            this.searchBox.setText(placeDetails.getName());
            if (placeDetails.getGeometry() != null && placeDetails.getGeometry().getLocation() != null && placeDetails.getGeometry().getLocation().getLat() != null && placeDetails.getGeometry().getLocation().getLng() != null && this.f12243i != null && placeDetails.getGeometry() != null && placeDetails.getGeometry().getLocation() != null) {
                this.f12243i.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(placeDetails.getGeometry().getLocation().getLat().doubleValue(), placeDetails.getGeometry().getLocation().getLng().doubleValue()), 13.0f));
                this.f12240f.setLatLong(placeDetails.getGeometry().getLocation().getLat().doubleValue(), placeDetails.getGeometry().getLocation().getLat().doubleValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012d  */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r27) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.geofences.ui.ConfigureZoneActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.configure_zone, menu);
        menu.findItem(R.id.menu_satellite_view).setChecked(Settings.getMapSatellite(this));
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int i4;
        switch (menuItem.getItemId()) {
            case 16908332:
                this.f12240f.handleExitAttempt();
                return true;
            case R.id.menu_delete /* 2131363387 */:
                this.f12240f.requestDelete();
                return true;
            case R.id.menu_satellite_view /* 2131363419 */:
                boolean z3 = !Settings.getMapSatellite(this);
                Settings.setMapSatellite(this, z3);
                menuItem.setChecked(z3);
                GoogleMap googleMap = this.f12243i;
                if (z3) {
                    i4 = 2;
                } else {
                    i4 = 1;
                }
                googleMap.setMapType(i4);
                return true;
            case R.id.menu_user_location /* 2131363445 */:
                new RxPermissions(this).request("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION").observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: a0.a
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ConfigureZoneActivity.this.H((Boolean) obj);
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.radius_value_text})
    public void onRadiusTextClicked() {
        this.f12240f.radiusTextClicked();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.save_button})
    public void onSaveClicked() {
        this.f12240f.saveSettings(this.f12241g, this.zoneName.getText().toString());
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void promptSaveOnExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.save_changes);
        builder.setMessage(R.string.do_you_wish_to_save_changes_generic);
        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: a0.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ConfigureZoneActivity.this.I(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: a0.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ConfigureZoneActivity.this.J(dialogInterface, i4);
            }
        });
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void saveImageOfMapAndClose() {
        GoogleMap googleMap = this.f12243i;
        if (googleMap == null) {
            closeView(true);
        } else {
            googleMap.snapshot(new e());
        }
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void setAreaRadius(int i4) {
        int metersToEquatorPixels = LocationHelper.metersToEquatorPixels(this.f12243i, new LatLng(this.f12243i.getCameraPosition().target.latitude, this.f12243i.getCameraPosition().target.longitude), i4) * 2;
        this.areaRadius.setLayoutParams(new FrameLayout.LayoutParams(metersToEquatorPixels, metersToEquatorPixels, 17));
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void setRadiusBarValue(int i4) {
        this.areaSeekBar.setProgress(i4 - 30);
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void setRadiusText(int i4) {
        TextView textView = this.radiusValueText;
        textView.setText(i4 + getString(R.string.meters).substring(0, 1));
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void showAlreadyExistsWarning() {
        ToastCompat.makeText(getApplicationContext(), (int) R.string.geofence_zone_name_already_exists, 0).show();
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void showConfirmDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.delete_zone);
        builder.setMessage(R.string.delete_zone_confirm);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: a0.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ConfigureZoneActivity.this.L(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void showNameWarning() {
        ToastCompat.makeText(getApplicationContext(), (int) R.string.please_enter_a_name, 0).show();
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void showRadiusValueDialog(int i4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.radius);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.dialog_geofence_radius, (ViewGroup) null);
        final EditText editText = (EditText) viewGroup.findViewById(R.id.radius_value);
        editText.setText(String.valueOf(i4));
        builder.setView(viewGroup);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: a0.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ConfigureZoneActivity.this.M(editText, dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        editText.addTextChangedListener(new f(editText, builder.show().getButton(-1)));
    }

    /* loaded from: classes3.dex */
    class a implements LocationListener {
        a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                ConfigureZoneActivity.this.f12245k.removeUpdates(this);
            } catch (SecurityException unused) {
            }
            try {
                ConfigureZoneActivity.this.f12243i.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 15.0f));
                if (ConfigureZoneActivity.this.f12246l != null && ConfigureZoneActivity.this.f12246l.isShowing()) {
                    ConfigureZoneActivity.this.f12246l.dismiss();
                }
            } catch (Exception unused2) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            ConfigureZoneActivity.this.f12240f.radiusValueChanged(i4 + 30);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    @Override // com.arlosoft.macrodroid.geofences.ui.ConfigureZoneView
    public void setSaveEnabled(boolean z3) {
    }

    /* loaded from: classes3.dex */
    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ConfigureZoneActivity.this.f12240f.nameUpdated(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* loaded from: classes3.dex */
    class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f12253a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f12254b;

        f(EditText editText, Button button) {
            this.f12253a = editText;
            this.f12254b = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                int intValue = Integer.valueOf(this.f12253a.getText().toString()).intValue();
                if (intValue >= 30 && intValue <= 100000) {
                    this.f12254b.setEnabled(true);
                } else {
                    this.f12254b.setEnabled(false);
                }
            } catch (Exception unused) {
                this.f12254b.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
