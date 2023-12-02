package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.OpenMacroDroidLogActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.LogActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class OpenMacroDroidLogAction extends Action {
    public static final Parcelable.Creator<OpenMacroDroidLogAction> CREATOR = new a();
    private static final int LOG_TYPE_SYSTEM = 0;
    private static final int LOG_TYPE_USER = 1;
    private int m_logType;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<OpenMacroDroidLogAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OpenMacroDroidLogAction createFromParcel(Parcel parcel) {
            return new OpenMacroDroidLogAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public OpenMacroDroidLogAction[] newArray(int i4) {
            return new OpenMacroDroidLogAction[i4];
        }
    }

    /* synthetic */ OpenMacroDroidLogAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.system_log), SelectableItem.r(R.string.user_log)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_logType = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_logType;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[this.m_logType];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return OpenMacroDroidLogActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4 = this.m_logType;
        if (i4 != 0) {
            if (i4 == 1) {
                Intent intent = new Intent(getContext(), LogActivity.class);
                intent.putExtra(LogActivity.EXTRA_IS_USER_LOG, true);
                intent.addFlags(268435456);
                getContext().startActivity(intent);
                return;
            }
            return;
        }
        Intent intent2 = new Intent(getContext(), SystemLogActivity.class);
        intent2.addFlags(268435456);
        getContext().startActivity(intent2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_logType);
    }

    public OpenMacroDroidLogAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private OpenMacroDroidLogAction() {
        this.m_logType = 0;
    }

    private OpenMacroDroidLogAction(Parcel parcel) {
        super(parcel);
        this.m_logType = parcel.readInt();
    }
}
