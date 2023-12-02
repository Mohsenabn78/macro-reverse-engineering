package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.AutoRotateConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes3.dex */
public class AutoRotateConstraint extends Constraint {
    public static final Parcelable.Creator<AutoRotateConstraint> CREATOR = new a();
    private boolean m_enabled;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AutoRotateConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AutoRotateConstraint createFromParcel(Parcel parcel) {
            return new AutoRotateConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AutoRotateConstraint[] newArray(int i4) {
            return new AutoRotateConstraint[i4];
        }
    }

    /* synthetic */ AutoRotateConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.enabled), MacroDroidApplication.getInstance().getString(R.string.disabled)};
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
        try {
            if (Settings.System.getInt(getContext().getContentResolver(), "accelerometer_rotation") != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.m_enabled == z3) {
                return true;
            }
            return false;
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to get auto rotate setting: " + e4.getMessage()));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_enabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(SelectableItem.r(R.string.constraint_auto_rotate));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (this.m_enabled) {
            str = getOptions()[0];
        } else {
            str = getOptions()[1];
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AutoRotateConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_enabled ? 1 : 0);
    }

    public AutoRotateConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private AutoRotateConstraint() {
        this.m_enabled = true;
    }

    private AutoRotateConstraint(Parcel parcel) {
        super(parcel);
        this.m_enabled = parcel.readInt() != 0;
    }
}
