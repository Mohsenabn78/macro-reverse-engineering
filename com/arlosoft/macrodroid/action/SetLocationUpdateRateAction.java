package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetLocationUpdateRateActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class SetLocationUpdateRateAction extends Action {
    public static final Parcelable.Creator<SetLocationUpdateRateAction> CREATOR = new a();
    private transient String[] m_optionList;
    private transient String[] m_optionSecondValues;
    private int m_updateRate;
    private int m_updateRateSeconds;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetLocationUpdateRateAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetLocationUpdateRateAction createFromParcel(Parcel parcel) {
            return new SetLocationUpdateRateAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetLocationUpdateRateAction[] newArray(int i4) {
            return new SetLocationUpdateRateAction[i4];
        }
    }

    /* synthetic */ SetLocationUpdateRateAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void init() {
        this.m_optionList = getContext().getResources().getStringArray(R.array.location_trigger_update_rate_names);
        this.m_optionSecondValues = getContext().getResources().getStringArray(R.array.location_trigger_update_rates);
        this.m_updateRateSeconds = 600;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_updateRateSeconds = Integer.valueOf(this.m_optionSecondValues[i4]).intValue();
        this.m_updateRate = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int i4 = 0;
        while (true) {
            String[] strArr = this.m_optionSecondValues;
            if (i4 >= strArr.length) {
                return 0;
            }
            if (Integer.valueOf(strArr[i4]).intValue() == this.m_updateRateSeconds) {
                return i4;
            }
            i4++;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_optionList[getCheckedItemIndex()];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetLocationUpdateRateActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (this.m_updateRate != 0) {
            Settings.setLocationUpdateRateSeconds(getContext(), this.m_updateRate * 60);
        } else {
            Settings.setLocationUpdateRateSeconds(getContext(), this.m_updateRateSeconds);
        }
        LocationTrigger.forceUpdate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return this.m_optionList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.action_set_location_update_rate);
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_updateRate);
        parcel.writeInt(this.m_updateRateSeconds);
    }

    public SetLocationUpdateRateAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetLocationUpdateRateAction() {
        init();
    }

    private SetLocationUpdateRateAction(Parcel parcel) {
        super(parcel);
        init();
        this.m_updateRate = parcel.readInt();
        this.m_updateRateSeconds = parcel.readInt();
    }
}
