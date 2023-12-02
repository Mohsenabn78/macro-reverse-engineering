package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.UiModeManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.CarModeActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class CarModeAction extends Action {
    private static final int CAR_MODE_OFF = 1;
    private static final int CAR_MODE_ON = 0;
    private static final int CAR_MODE_TOGGLE = 2;
    public static final Parcelable.Creator<CarModeAction> CREATOR = new a();
    private int m_option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<CarModeAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CarModeAction createFromParcel(Parcel parcel) {
            return new CarModeAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CarModeAction[] newArray(int i4) {
            return new CarModeAction[i4];
        }
    }

    /* synthetic */ CarModeAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.enable), SelectableItem.r(R.string.disable), SelectableItem.r(R.string.toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
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
        return CarModeActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        UiModeManager uiModeManager = (UiModeManager) getContext().getSystemService("uimode");
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    if (uiModeManager.getCurrentModeType() == 3) {
                        uiModeManager.disableCarMode(1);
                        return;
                    } else {
                        uiModeManager.enableCarMode(1);
                        return;
                    }
                }
                return;
            }
            uiModeManager.disableCarMode(1);
            return;
        }
        uiModeManager.enableCarMode(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public CarModeAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private CarModeAction() {
    }

    private CarModeAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
