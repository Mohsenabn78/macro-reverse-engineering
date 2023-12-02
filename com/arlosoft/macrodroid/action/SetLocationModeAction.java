package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetLocationModeActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes2.dex */
public class SetLocationModeAction extends Action {
    public static final Parcelable.Creator<SetLocationModeAction> CREATOR = new a();
    private static final int OPTION_BATTERY_SAVING = 2;
    private static final int OPTION_DEVICE_ONLY = 3;
    private static final int OPTION_HIGH_ACCURACY = 1;
    private static final int OPTION_LOCATION_SERVICES_OFF = 0;
    private int m_state;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetLocationModeAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetLocationModeAction createFromParcel(Parcel parcel) {
            return new SetLocationModeAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetLocationModeAction[] newArray(int i4) {
            return new SetLocationModeAction[i4];
        }
    }

    /* synthetic */ SetLocationModeAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] M() {
        return new String[]{SelectableItem.r(R.string.action_set_location_mode_off), SelectableItem.r(R.string.action_set_location_mode_high_accuracy), SelectableItem.r(R.string.action_set_location_mode_battery_saving), SelectableItem.r(R.string.action_set_location_mode_device_only)};
    }

    private String[] N() {
        return new String[]{SelectableItem.r(R.string.action_set_location_mode_off), SelectableItem.r(R.string.action_set_location_mode_on)};
    }

    private int getState() {
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.m_state > 0) {
                return 1;
            }
            return 0;
        }
        return this.m_state;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return getState();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return o()[getState()];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetLocationModeActionInfo.getInstance();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:3|(5:(1:(1:(1:8))(1:9))|10|11|(2:13|14)|(2:17|18)(1:20))|22|10|11|(0)|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:12:0x001d, B:14:0x002f), top: B:48:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo r13) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SetLocationModeAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        if (Build.VERSION.SDK_INT >= 29) {
            return N();
        }
        return M();
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
    }

    public SetLocationModeAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetLocationModeAction() {
        this.m_state = 0;
    }

    private SetLocationModeAction(Parcel parcel) {
        super(parcel);
        this.m_state = parcel.readInt();
    }
}
