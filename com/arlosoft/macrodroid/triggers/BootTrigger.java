package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.BootTriggerInfo;

/* loaded from: classes3.dex */
public class BootTrigger extends Trigger {
    public static final Parcelable.Creator<BootTrigger> CREATOR = new a();

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<BootTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BootTrigger createFromParcel(Parcel parcel) {
            return new BootTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BootTrigger[] newArray(int i4) {
            return new BootTrigger[i4];
        }
    }

    /* synthetic */ BootTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BootTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    public BootTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private BootTrigger() {
    }

    private BootTrigger(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
