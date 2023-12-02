package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.EmptyTriggerInfo;

/* loaded from: classes3.dex */
public class InvokedByRunMacroTrigger extends Trigger implements InvocationTypeTrigger {
    public static final Parcelable.Creator<InvokedByRunMacroTrigger> CREATOR = new a();
    private static InvokedByRunMacroTrigger instance;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<InvokedByRunMacroTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InvokedByRunMacroTrigger createFromParcel(Parcel parcel) {
            return new InvokedByRunMacroTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InvokedByRunMacroTrigger[] newArray(int i4) {
            return new InvokedByRunMacroTrigger[i4];
        }
    }

    /* synthetic */ InvokedByRunMacroTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static InvokedByRunMacroTrigger getInstance() {
        if (instance == null) {
            instance = new InvokedByRunMacroTrigger();
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

    public InvokedByRunMacroTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public InvokedByRunMacroTrigger() {
    }

    private InvokedByRunMacroTrigger(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
