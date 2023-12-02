package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.AirplaneModeConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class AirplaneModeConstraint extends Constraint {
    public static final Parcelable.Creator<AirplaneModeConstraint> CREATOR = new a();
    private boolean m_enabled;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AirplaneModeConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AirplaneModeConstraint createFromParcel(Parcel parcel) {
            return new AirplaneModeConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AirplaneModeConstraint[] newArray(int i4) {
            return new AirplaneModeConstraint[i4];
        }
    }

    /* synthetic */ AirplaneModeConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_airplane_mode_enabled), MacroDroidApplication.getInstance().getString(R.string.constraint_airplane_mode_disabled)};
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
        boolean z3;
        if (Settings.Global.getInt(getContext().getContentResolver(), "airplane_mode_on", 0) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.m_enabled != z3) {
            return false;
        }
        return true;
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
        return AirplaneModeConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.constraint_airplane_mode_select_option);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_enabled ? 1 : 0);
    }

    public AirplaneModeConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private AirplaneModeConstraint() {
        this.m_enabled = true;
    }

    private AirplaneModeConstraint(Parcel parcel) {
        super(parcel);
        this.m_enabled = parcel.readInt() != 0;
    }
}
