package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.IsRoamingConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class IsRoamingConstraint extends Constraint {
    public static final Parcelable.Creator<IsRoamingConstraint> CREATOR = new a();
    private boolean m_isRoaming;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<IsRoamingConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IsRoamingConstraint createFromParcel(Parcel parcel) {
            return new IsRoamingConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public IsRoamingConstraint[] newArray(int i4) {
            return new IsRoamingConstraint[i4];
        }
    }

    /* synthetic */ IsRoamingConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_is_roaming_option_roaming), MacroDroidApplication.getInstance().getString(R.string.constraint_is_roaming_option_not_roaming)};
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
        this.m_isRoaming = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            z3 = activeNetworkInfo.isRoaming();
        } else {
            SystemLog.logDebug("No network info IsRoamingConstraint check failed");
            z3 = false;
        }
        if (this.m_isRoaming != z3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_isRoaming ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_isRoaming) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return IsRoamingConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(!this.m_isRoaming ? 1 : 0);
    }

    public IsRoamingConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private IsRoamingConstraint() {
        this.m_isRoaming = true;
    }

    private IsRoamingConstraint(Parcel parcel) {
        super(parcel);
        this.m_isRoaming = parcel.readInt() != 0;
    }
}
