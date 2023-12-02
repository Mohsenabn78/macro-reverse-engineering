package com.arlosoft.macrodroid.constraint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.BatterySaverStateConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

@TargetApi(21)
/* loaded from: classes3.dex */
public class BatterySaverStateConstraint extends Constraint {
    public static final Parcelable.Creator<BatterySaverStateConstraint> CREATOR = new a();
    private int m_option;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<BatterySaverStateConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BatterySaverStateConstraint createFromParcel(Parcel parcel) {
            return new BatterySaverStateConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BatterySaverStateConstraint[] newArray(int i4) {
            return new BatterySaverStateConstraint[i4];
        }
    }

    /* synthetic */ BatterySaverStateConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.enabled), MacroDroidApplication.getInstance().getString(R.string.disabled)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        boolean isPowerSaveMode = ((PowerManager) getContext().getSystemService("power")).isPowerSaveMode();
        if (this.m_option != 0) {
            return !isPowerSaveMode;
        }
        return isPowerSaveMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BatterySaverStateConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public BatterySaverStateConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private BatterySaverStateConstraint() {
    }

    private BatterySaverStateConstraint(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
