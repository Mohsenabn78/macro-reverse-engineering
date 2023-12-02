package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.InCallConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class InCallConstraint extends Constraint {
    public static final Parcelable.Creator<InCallConstraint> CREATOR = new a();
    private boolean m_inCall;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<InCallConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InCallConstraint createFromParcel(Parcel parcel) {
            return new InCallConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InCallConstraint[] newArray(int i4) {
            return new InCallConstraint[i4];
        }
    }

    /* synthetic */ InCallConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_in_call_in_call), MacroDroidApplication.getInstance().getString(R.string.constraint_in_call_not_in_call)};
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
        this.m_inCall = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        try {
            if (((TelephonyManager) getContext().getSystemService("phone")).getCallState() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.m_inCall == z3) {
                return true;
            }
            return false;
        } catch (SecurityException unused) {
            SystemLog.logError("In Call Constraint failed - missing READ_PHONE_STATE permission", getMacroGuid().longValue());
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", getName(), true, false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_inCall ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_inCall) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return InCallConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_PHONE_STATE"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_inCall ? 1 : 0);
    }

    public InCallConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private InCallConstraint() {
        this.m_inCall = true;
    }

    private InCallConstraint(Parcel parcel) {
        super(parcel);
        this.m_inCall = parcel.readInt() != 0;
    }
}
