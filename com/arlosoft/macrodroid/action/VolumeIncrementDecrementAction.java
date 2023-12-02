package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.VolumeIncrementDecrementActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class VolumeIncrementDecrementAction extends Action {
    public static final Parcelable.Creator<VolumeIncrementDecrementAction> CREATOR = new a();
    private boolean m_volumeUp;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<VolumeIncrementDecrementAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VolumeIncrementDecrementAction createFromParcel(Parcel parcel) {
            return new VolumeIncrementDecrementAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VolumeIncrementDecrementAction[] newArray(int i4) {
            return new VolumeIncrementDecrementAction[i4];
        }
    }

    /* synthetic */ VolumeIncrementDecrementAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_volume_increment_decrement_volume_up), SelectableItem.r(R.string.action_volume_increment_decrement_volume_down)};
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
        this.m_volumeUp = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_volumeUp ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[!this.m_volumeUp ? 1 : 0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return VolumeIncrementDecrementActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4;
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.m_volumeUp) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        audioManager.adjustVolume(i4, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(!this.m_volumeUp ? 1 : 0);
    }

    public VolumeIncrementDecrementAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private VolumeIncrementDecrementAction() {
        this.m_volumeUp = true;
    }

    private VolumeIncrementDecrementAction(Parcel parcel) {
        super(parcel);
        this.m_volumeUp = parcel.readInt() == 0;
    }
}
