package com.arlosoft.macrodroid.geofences.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.GeofenceConstraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.geofences.GeofenceHelper;
import com.arlosoft.macrodroid.geofences.GeofenceInfo;
import com.arlosoft.macrodroid.geofences.GeofenceStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ConfigureZonePresenter {

    /* renamed from: a  reason: collision with root package name */
    private ConfigureZoneView f12263a;

    /* renamed from: b  reason: collision with root package name */
    private GeofenceInfo f12264b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12265c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12266d;

    /* renamed from: e  reason: collision with root package name */
    private GeofenceStore f12267e;

    /* renamed from: f  reason: collision with root package name */
    private final Cache f12268f;

    /* renamed from: g  reason: collision with root package name */
    private final String f12269g;

    public ConfigureZonePresenter(@NonNull Cache cache, @Nullable String str) {
        this.f12268f = cache;
        this.f12269g = str;
        GeofenceStore geofenceStore = (GeofenceStore) cache.get("GeofenceInfo", GeofenceStore.class);
        this.f12267e = geofenceStore;
        if (geofenceStore == null) {
            this.f12267e = new GeofenceStore();
        }
    }

    private void a(Constraint constraint, String str, String str2) {
        if (constraint instanceof GeofenceConstraint) {
            GeofenceConstraint geofenceConstraint = (GeofenceConstraint) constraint;
            if (geofenceConstraint.getZoneName() != null && geofenceConstraint.getZoneName().equals(str)) {
                geofenceConstraint.setZoneName(str2);
            }
        }
        if (constraint instanceof LogicConstraint) {
            for (Constraint constraint2 : ((LogicConstraint) constraint).getConstraints()) {
                a(constraint2, str, str2);
            }
        }
    }

    public void cameraMoved() {
        this.f12263a.setAreaRadius(this.f12264b.getRadius());
    }

    public void delete() {
        String str = this.f12269g;
        if (str != null) {
            this.f12267e.removeGeofence(str);
            this.f12268f.put("GeofenceInfo", this.f12267e);
            GeofenceHelper.clearAllGeoTriggersWithId(this.f12264b.getId());
        }
        this.f12263a.closeView(true);
    }

    public void handleExitAttempt() {
        if (!this.f12265c) {
            this.f12263a.closeView(true);
        } else {
            this.f12263a.promptSaveOnExit();
        }
    }

    public void nameUpdated(String str) {
        this.f12264b = new GeofenceInfo(this.f12264b.getId(), str, this.f12264b.getLatitude(), this.f12264b.getLongitude(), this.f12264b.getRadius(), 0);
        this.f12265c = true;
        setSaveButtonEnabledState();
    }

    public void radiusTextClicked() {
        this.f12263a.showRadiusValueDialog(this.f12264b.getRadius());
    }

    public void radiusValueChanged(int i4) {
        this.f12264b = new GeofenceInfo(this.f12264b.getId(), this.f12264b.getName(), this.f12264b.getLatitude(), this.f12264b.getLongitude(), i4, 0);
        this.f12263a.setRadiusText(i4);
        this.f12263a.setAreaRadius(i4);
        this.f12265c = true;
        setSaveButtonEnabledState();
    }

    public void requestDelete() {
        this.f12263a.showConfirmDelete();
    }

    public void saveSettings(String str, String str2) {
        List<GeofenceInfo> geofenceList = this.f12267e.getGeofenceList();
        if (str2.length() == 0) {
            this.f12263a.showNameWarning();
            return;
        }
        for (GeofenceInfo geofenceInfo : geofenceList) {
            if (!geofenceInfo.getId().equals(this.f12269g) && geofenceInfo.getName().equals(str2)) {
                this.f12263a.showAlreadyExistsWarning();
                return;
            }
        }
        GeofenceInfo geofenceInfo2 = new GeofenceInfo(this.f12264b.getId(), str2, this.f12264b.getLatitude(), this.f12264b.getLongitude(), this.f12264b.getRadius(), 0);
        this.f12264b = geofenceInfo2;
        this.f12267e.setGeofence(geofenceInfo2.getId(), this.f12264b);
        this.f12268f.put("GeofenceInfo", this.f12267e);
        this.f12263a.saveImageOfMapAndClose();
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosWithActionBlocks(false)) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof LocationTrigger) {
                    ((LocationTrigger) next).updateGeofenceStore();
                }
                for (Constraint constraint : next.getConstraints()) {
                    a(constraint, str, str2);
                }
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (it2.hasNext()) {
                for (Constraint constraint2 : it2.next().getConstraints()) {
                    a(constraint2, str, str2);
                }
            }
            for (Constraint constraint3 : macro.getConstraints()) {
                a(constraint3, str, str2);
            }
        }
    }

    public void setLatLong(double d4, double d5) {
        GeofenceInfo geofenceInfo = new GeofenceInfo(this.f12264b.getId(), this.f12264b.getName(), d4, d5, this.f12264b.getRadius(), 0);
        this.f12264b = geofenceInfo;
        this.f12263a.setAreaRadius(geofenceInfo.getRadius());
        if (this.f12266d) {
            this.f12265c = true;
        } else {
            this.f12266d = true;
        }
        setSaveButtonEnabledState();
    }

    public void setRadius(int i4) {
        this.f12264b = new GeofenceInfo(this.f12264b.getId(), this.f12264b.getName(), this.f12264b.getLatitude(), this.f12264b.getLongitude(), i4, 0);
        this.f12263a.setRadiusText(i4);
        this.f12263a.setAreaRadius(i4);
        this.f12263a.setRadiusBarValue(Math.min(5000, i4));
    }

    public void setSaveButtonEnabledState() {
        if (this.f12265c && this.f12264b.getName().length() > 0) {
            this.f12263a.setSaveEnabled(true);
        } else {
            this.f12263a.setSaveEnabled(false);
        }
    }

    public void setView(ConfigureZoneView configureZoneView, GeofenceInfo geofenceInfo) {
        this.f12263a = configureZoneView;
        this.f12264b = geofenceInfo;
        configureZoneView.setRadiusText(geofenceInfo.getRadius());
    }
}
