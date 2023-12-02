package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.NotificationVolumeConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class NotificationVolumeConstraint extends Constraint {
    public static final Parcelable.Creator<NotificationVolumeConstraint> CREATOR = new a();
    private static final int OPTION_VOLUME_ON = 0;
    private static final int OPTION_VOLUME_SILENT = 1;
    private int m_option;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<NotificationVolumeConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NotificationVolumeConstraint createFromParcel(Parcel parcel) {
            return new NotificationVolumeConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NotificationVolumeConstraint[] newArray(int i4) {
            return new NotificationVolumeConstraint[i4];
        }
    }

    /* synthetic */ NotificationVolumeConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_volume_on), MacroDroidApplication.getInstance().getString(R.string.constraint_volume_silent)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int streamVolume = ((AudioManager) getContext().getSystemService("audio")).getStreamVolume(5);
        if (this.m_option == 0) {
            if (streamVolume > 0) {
                return true;
            }
            return false;
        } else if (streamVolume == 0) {
            return true;
        } else {
            return false;
        }
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
        return NotificationVolumeConstraintInfo.getInstance();
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

    public NotificationVolumeConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private NotificationVolumeConstraint() {
        this.m_option = 0;
    }

    private NotificationVolumeConstraint(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
