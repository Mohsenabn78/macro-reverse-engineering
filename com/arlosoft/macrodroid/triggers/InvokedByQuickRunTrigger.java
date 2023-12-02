package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.EmptyTriggerInfo;

/* loaded from: classes3.dex */
public class InvokedByQuickRunTrigger extends Trigger implements InvocationTypeTrigger {
    public static final Parcelable.Creator<InvokedByQuickRunTrigger> CREATOR = new a();
    private static InvokedByQuickRunTrigger instance;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<InvokedByQuickRunTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InvokedByQuickRunTrigger createFromParcel(Parcel parcel) {
            return new InvokedByQuickRunTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InvokedByQuickRunTrigger[] newArray(int i4) {
            return new InvokedByQuickRunTrigger[i4];
        }
    }

    /* synthetic */ InvokedByQuickRunTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static InvokedByQuickRunTrigger getInstance() {
        if (instance == null) {
            instance = new InvokedByQuickRunTrigger();
        }
        return instance;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getHelpInfo() {
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getIcon() {
        return R.drawable.ic_crop_square_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return EmptyTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getName() {
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    public InvokedByQuickRunTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public InvokedByQuickRunTrigger() {
    }

    private InvokedByQuickRunTrigger(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
