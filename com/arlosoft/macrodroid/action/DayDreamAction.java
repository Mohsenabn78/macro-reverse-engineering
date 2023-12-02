package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.DayDreamActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class DayDreamAction extends Action {
    public static final Parcelable.Creator<DayDreamAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<DayDreamAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DayDreamAction createFromParcel(Parcel parcel) {
            return new DayDreamAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DayDreamAction[] newArray(int i4) {
            return new DayDreamAction[i4];
        }
    }

    /* synthetic */ DayDreamAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DayDreamActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setClassName("com.android.systemui", "com.android.systemui.Somnambulator");
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        } catch (Exception unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) SelectableItem.r(R.string.action_daydream_failed), 0).show();
        }
    }

    public DayDreamAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DayDreamAction() {
    }

    private DayDreamAction(Parcel parcel) {
        super(parcel);
    }
}
