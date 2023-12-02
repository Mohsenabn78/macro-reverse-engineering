package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.ShortcutTriggerInfo;

/* loaded from: classes3.dex */
public class ShortcutTrigger extends Trigger {
    public static final Parcelable.Creator<ShortcutTrigger> CREATOR = new a();

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ShortcutTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShortcutTrigger createFromParcel(Parcel parcel) {
            return new ShortcutTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShortcutTrigger[] newArray(int i4) {
            return new ShortcutTrigger[i4];
        }
    }

    /* synthetic */ ShortcutTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ShortcutTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    public ShortcutTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ShortcutTrigger() {
    }

    private ShortcutTrigger(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
