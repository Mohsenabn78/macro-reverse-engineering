package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.MacroDroidInitialisedTriggerInfo;

/* loaded from: classes3.dex */
public class MacroDroidInitialisedTrigger extends Trigger {
    public static final Parcelable.Creator<MacroDroidInitialisedTrigger> CREATOR = new a();

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<MacroDroidInitialisedTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MacroDroidInitialisedTrigger createFromParcel(Parcel parcel) {
            return new MacroDroidInitialisedTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MacroDroidInitialisedTrigger[] newArray(int i4) {
            return new MacroDroidInitialisedTrigger[i4];
        }
    }

    /* synthetic */ MacroDroidInitialisedTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MacroDroidInitialisedTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    public MacroDroidInitialisedTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private MacroDroidInitialisedTrigger() {
    }

    private MacroDroidInitialisedTrigger(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
