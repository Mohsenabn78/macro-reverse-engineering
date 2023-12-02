package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.OpenCallLogActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class OpenCallLogAction extends Action {
    public static final Parcelable.Creator<OpenCallLogAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<OpenCallLogAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OpenCallLogAction createFromParcel(Parcel parcel) {
            return new OpenCallLogAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public OpenCallLogAction[] newArray(int i4) {
            return new OpenCallLogAction[i4];
        }
    }

    /* synthetic */ OpenCallLogAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return OpenCallLogActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setType("vnd.android.cursor.dir/calls");
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) SelectableItem.r(R.string.no_app_available), 0).show();
            SystemLog.logWarning("No app found to display call log", getMacroGuid().longValue());
        }
    }

    public OpenCallLogAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private OpenCallLogAction() {
    }

    private OpenCallLogAction(Parcel parcel) {
        super(parcel);
    }
}
