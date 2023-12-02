package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.VolumeConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class VolumeConstraint extends Constraint {
    public static final Parcelable.Creator<VolumeConstraint> CREATOR = new a();
    private int m_option;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<VolumeConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VolumeConstraint createFromParcel(Parcel parcel) {
            return new VolumeConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VolumeConstraint[] newArray(int i4) {
            return new VolumeConstraint[i4];
        }
    }

    /* synthetic */ VolumeConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_volume_on), MacroDroidApplication.getInstance().getString(R.string.constraint_volume_vibrate_only), MacroDroidApplication.getInstance().getString(R.string.constraint_volume_silent), MacroDroidApplication.getInstance().getString(R.string.constraint_volume_vibrate_or_silent)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int i4;
        int i5;
        int ringerMode = ((AudioManager) getContext().getSystemService("audio")).getRingerMode();
        if (ringerMode == 2 && this.m_option == 0) {
            return true;
        }
        if (ringerMode == 1 && ((i5 = this.m_option) == 1 || i5 == 3)) {
            return true;
        }
        if (ringerMode == 0 && ((i4 = this.m_option) == 2 || i4 == 3)) {
            return true;
        }
        return false;
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
        return VolumeConstraintInfo.getInstance();
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

    public VolumeConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private VolumeConstraint() {
        this.m_option = 0;
    }

    private VolumeConstraint(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
