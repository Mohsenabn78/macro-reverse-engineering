package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.GPSEnabledConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes3.dex */
public class GPSEnabledConstraint extends Constraint {
    public static final Parcelable.Creator<GPSEnabledConstraint> CREATOR = new a();
    private boolean m_enabled;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<GPSEnabledConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GPSEnabledConstraint createFromParcel(Parcel parcel) {
            return new GPSEnabledConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GPSEnabledConstraint[] newArray(int i4) {
            return new GPSEnabledConstraint[i4];
        }
    }

    /* synthetic */ GPSEnabledConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_gps_enabled_enabled), MacroDroidApplication.getInstance().getString(R.string.constraint_gps_enabled_disabled)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_enabled = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        if (this.m_enabled == ((LocationManager) getContext().getSystemService(FirebaseAnalytics.Param.LOCATION)).isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_enabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_enabled) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return GPSEnabledConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.constraint_gps_enabled_select_state);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_enabled ? 1 : 0);
    }

    public GPSEnabledConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private GPSEnabledConstraint() {
        this.m_enabled = true;
    }

    private GPSEnabledConstraint(Parcel parcel) {
        super(parcel);
        this.m_enabled = parcel.readInt() != 0;
    }
}
