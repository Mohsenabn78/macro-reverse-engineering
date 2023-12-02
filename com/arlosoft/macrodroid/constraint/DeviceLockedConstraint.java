package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.app.KeyguardManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.DeviceLockedConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class DeviceLockedConstraint extends Constraint {
    public static final Parcelable.Creator<DeviceLockedConstraint> CREATOR = new a();
    private boolean m_locked;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DeviceLockedConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DeviceLockedConstraint createFromParcel(Parcel parcel) {
            return new DeviceLockedConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DeviceLockedConstraint[] newArray(int i4) {
            return new DeviceLockedConstraint[i4];
        }
    }

    /* synthetic */ DeviceLockedConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_device_locked_option_locked), MacroDroidApplication.getInstance().getString(R.string.constraint_device_locked_option_unlocked)};
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
        this.m_locked = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        if (this.m_locked == ((KeyguardManager) getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_locked ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[!this.m_locked ? 1 : 0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DeviceLockedConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_locked ? 1 : 0);
    }

    public DeviceLockedConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DeviceLockedConstraint() {
        this.m_locked = true;
    }

    private DeviceLockedConstraint(Parcel parcel) {
        super(parcel);
        this.m_locked = parcel.readInt() != 0;
    }
}
