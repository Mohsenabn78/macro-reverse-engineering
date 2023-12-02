package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.PhoneRingingConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class PhoneRingingConstraint extends Constraint {
    public static final Parcelable.Creator<PhoneRingingConstraint> CREATOR = new a();
    private boolean m_ringing;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<PhoneRingingConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PhoneRingingConstraint createFromParcel(Parcel parcel) {
            return new PhoneRingingConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PhoneRingingConstraint[] newArray(int i4) {
            return new PhoneRingingConstraint[i4];
        }
    }

    /* synthetic */ PhoneRingingConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_phone_ringing), MacroDroidApplication.getInstance().getString(R.string.constraint_phone_ringing_not_ringing)};
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
        this.m_ringing = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        try {
            if (((TelephonyManager) getContext().getSystemService("phone")).getCallState() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.m_ringing != z3) {
                return false;
            }
            return true;
        } catch (SecurityException unused) {
            SystemLog.logError("Phone Ringing Constraint failed - missing READ_PHONE_STATE permission", getMacroGuid().longValue());
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", getName(), true, false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_ringing ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_ringing) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return PhoneRingingConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new String[]{"android.permission.READ_PHONE_STATE"};
        }
        return new String[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_ringing ? 1 : 0);
    }

    public PhoneRingingConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public PhoneRingingConstraint() {
        this.m_ringing = true;
    }

    private PhoneRingingConstraint(Parcel parcel) {
        super(parcel);
        this.m_ringing = parcel.readInt() != 0;
    }
}
