package com.arlosoft.macrodroid.geofences;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.geofences.ZonesAdapter;
import com.arlosoft.macrodroid.geofences.ui.ConfigureZoneActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.File;

/* loaded from: classes3.dex */
public class GeofenceListActivity extends MacroDroidBaseActivity implements ZonesAdapter.ZoneClickHandler {
    public static final String EXTRA_PICKER_MODE = "picker_mode";
    public static final String EXTRA_SELECTED_GEOFENCE_ID = "selected_geofence_id";
    public static final String EXTRA_THEME_TYPE = "ThemeType";
    public static final int THEME_TYPE_CONSTRAINT = 2;
    public static final int THEME_TYPE_TRIGGER = 1;
    @BindView(R.id.geofence_add_button)
    FloatingActionButton addGeofenceButton;
    @BindView(R.id.geofences_emptyView)
    View emptyView;

    /* renamed from: f  reason: collision with root package name */
    private int f12202f;

    /* renamed from: g  reason: collision with root package name */
    private final Cache f12203g = MacroDroidApplication.getInstance().getCache("GeofenceInfo");

    /* renamed from: h  reason: collision with root package name */
    private GeofenceStore f12204h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12205i;
    @BindView(R.id.infoCardDetail)
    TextView infoCardDetail;
    @BindView(R.id.infoCardGotIt)
    Button infoCardGotIt;
    @BindView(R.id.infoCardTitle)
    TextView infoCardTitle;
    @BindView(R.id.infoCardView)
    CardView infoCardView;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private void p() {
        if (Settings.shouldHideInfoCardGeofences(this)) {
            this.infoCardView.setVisibility(8);
            return;
        }
        int i4 = this.f12202f;
        if (i4 == 1) {
            this.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.trigger_primary));
        } else if (i4 == 2) {
            this.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.constraints_primary));
        } else {
            this.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.geofences_primary));
        }
        this.infoCardTitle.setText(R.string.geofences);
        this.infoCardDetail.setText(R.string.geofences_info_card);
        this.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.geofences.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeofenceListActivity.this.s(view);
            }
        });
    }

    private void q(@NonNull GeofenceInfo geofenceInfo) {
        File file = new File(getFilesDir().getAbsolutePath(), Constants.MAPS_IMAGE_DIR);
        File file2 = new File(file, geofenceInfo.getId() + ".png");
        if (file2.exists()) {
            file2.delete();
        }
    }

    private int r() {
        int i4 = this.f12202f;
        if (i4 != 1) {
            if (i4 != 2) {
                return ContextCompat.getColor(this, R.color.geofences_primary);
            }
            return ContextCompat.getColor(this, R.color.constraints_primary);
        }
        return ContextCompat.getColor(this, R.color.trigger_primary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        Settings.hideInfoCardGeofences(getApplicationContext());
        this.infoCardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(GeofenceInfo geofenceInfo, DialogInterface dialogInterface, int i4) {
        if (geofenceInfo != null) {
            SystemLog.logInfo("Geofence Deleted - " + geofenceInfo.getName());
            this.f12204h.removeGeofence(geofenceInfo.getId());
            this.f12203g.put("GeofenceInfo", this.f12204h);
            GeofenceHelper.clearAllGeoTriggersWithId(geofenceInfo.getId());
            q(geofenceInfo);
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(GeofenceInfo geofenceInfo, DialogInterface dialogInterface, int i4) {
        if (i4 == 0) {
            Intent intent = new Intent(this, ConfigureZoneActivity.class);
            intent.putExtra(ConfigureZoneActivity.EXTRA_GEOFENCE, geofenceInfo);
            startActivity(intent);
        } else if (i4 == 1) {
            v(geofenceInfo);
        }
    }

    private void v(@NonNull final GeofenceInfo geofenceInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.delete) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + geofenceInfo.getName());
        builder.setMessage(R.string.delete_zone_confirm);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.geofences.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                GeofenceListActivity.this.t(geofenceInfo, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    private void w() {
        int i4;
        GeofenceStore geofenceStore = (GeofenceStore) this.f12203g.get("GeofenceInfo", GeofenceStore.class);
        this.f12204h = geofenceStore;
        if (geofenceStore == null) {
            this.f12204h = new GeofenceStore(new ArrayMap());
        }
        if (this.f12204h.getGeofenceList().size() == 0) {
            this.emptyView.setVisibility(0);
            this.recyclerView.setVisibility(8);
            return;
        }
        int i5 = this.f12202f;
        if (i5 == 0) {
            i4 = R.color.geofences_primary_transparent;
        } else if (i5 == 1) {
            i4 = R.color.trigger_primary_transparent;
        } else {
            i4 = R.color.constraint_primary_transparent;
        }
        ZonesAdapter zonesAdapter = new ZonesAdapter(this.f12204h.getGeofenceList(), this, this, i4);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(zonesAdapter);
        this.recyclerView.setVisibility(0);
        this.emptyView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.geofence_add_button})
    public void addGeofenceButtonClick() {
        startActivityForResult(new Intent(this, ConfigureZoneActivity.class), 11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i5 == -1 && this.f12205i) {
            String stringExtra = intent.getStringExtra(EXTRA_SELECTED_GEOFENCE_ID);
            Intent intent2 = new Intent();
            intent2.putExtra(EXTRA_SELECTED_GEOFENCE_ID, stringExtra);
            setResult(-1, intent2);
            finish();
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i4;
        int intExtra = getIntent().getIntExtra("ThemeType", 0);
        this.f12202f = intExtra;
        if (intExtra != 0) {
            if (intExtra == 1) {
                i4 = R.style.Theme_App_Trigger_ColoredButton;
            } else {
                i4 = R.style.Theme_App_Constraint_ColoredButton;
            }
            setTheme(i4);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_geofences);
        ButterKnife.bind(this);
        this.addGeofenceButton.setBackgroundTintList(ColorStateList.valueOf(r()));
        this.f12205i = getIntent().getBooleanExtra(EXTRA_PICKER_MODE, false);
        p();
        if (this.f12205i) {
            setTitle(R.string.select_zone);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        EventBusUtils.getEventBus().unregister(this);
        super.onPause();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        w();
    }

    @Override // com.arlosoft.macrodroid.geofences.ZonesAdapter.ZoneClickHandler
    public void zoneClicked(@NonNull GeofenceInfo geofenceInfo) {
        if (this.f12205i) {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_SELECTED_GEOFENCE_ID, geofenceInfo.getId());
            setResult(-1, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent(this, ConfigureZoneActivity.class);
        intent2.putExtra(ConfigureZoneActivity.EXTRA_GEOFENCE, geofenceInfo);
        startActivity(intent2);
    }

    @Override // com.arlosoft.macrodroid.geofences.ZonesAdapter.ZoneClickHandler
    public void zoneLongClicked(@NonNull final GeofenceInfo geofenceInfo) {
        String[] strArr = {getString(R.string.edit), getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(geofenceInfo.getName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.geofences.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                GeofenceListActivity.this.u(geofenceInfo, dialogInterface, i4);
            }
        });
        builder.create().show();
    }
}
