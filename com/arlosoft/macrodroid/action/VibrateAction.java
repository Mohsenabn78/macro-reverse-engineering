package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.VibrateActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.Vibrate;

/* loaded from: classes2.dex */
public class VibrateAction extends Action {
    public static final Parcelable.Creator<VibrateAction> CREATOR = new a();
    private int m_vibratePattern;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<VibrateAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VibrateAction createFromParcel(Parcel parcel) {
            return new VibrateAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VibrateAction[] newArray(int i4) {
            return new VibrateAction[i4];
        }
    }

    /* synthetic */ VibrateAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_vibratePattern = i4;
        Vibrate.vibrateDevice(getContext(), getCheckedItemIndex());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.m_vibratePattern >= Vibrate.getPatternNames().length || this.m_vibratePattern < 0) {
            this.m_vibratePattern = 0;
        }
        return this.m_vibratePattern;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.action_vibrate) + " (" + Vibrate.getPatternNames()[getCheckedItemIndex()] + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return VibrateActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Vibrate.vibrateDevice(getContext(), getCheckedItemIndex());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return Vibrate.getPatternNames();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_vibratePattern);
    }

    public VibrateAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private VibrateAction() {
        this.m_vibratePattern = 0;
    }

    private VibrateAction(Parcel parcel) {
        super(parcel);
        this.m_vibratePattern = parcel.readInt();
    }
}
