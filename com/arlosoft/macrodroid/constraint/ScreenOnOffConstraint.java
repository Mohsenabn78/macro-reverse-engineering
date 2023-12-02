package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.ScreenOnOffConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class ScreenOnOffConstraint extends Constraint {
    public static final Parcelable.Creator<ScreenOnOffConstraint> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f10222a;
    private boolean m_screenOn;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ScreenOnOffConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ScreenOnOffConstraint createFromParcel(Parcel parcel) {
            return new ScreenOnOffConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ScreenOnOffConstraint[] newArray(int i4) {
            return new ScreenOnOffConstraint[i4];
        }
    }

    /* synthetic */ ScreenOnOffConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_screen_on_off_screen_on), MacroDroidApplication.getInstance().getString(R.string.constraint_screen_on_off_screen_off)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3 = true;
        this.f10222a = true;
        if (i4 != 0) {
            z3 = false;
        }
        this.m_screenOn = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        if (!this.f10222a) {
            this.m_screenOn = false;
        }
        if (this.m_screenOn != ((PowerManager) getContext().getSystemService("power")).isInteractive()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (!this.f10222a) {
            this.m_screenOn = false;
        }
        return !this.m_screenOn ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (!this.f10222a) {
            this.m_screenOn = false;
        }
        return getOptions()[!this.m_screenOn ? 1 : 0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ScreenOnOffConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_screenOn ? 1 : 0);
    }

    public ScreenOnOffConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ScreenOnOffConstraint() {
        this.f10222a = true;
        this.m_screenOn = true;
    }

    private ScreenOnOffConstraint(Parcel parcel) {
        super(parcel);
        this.f10222a = true;
        this.m_screenOn = parcel.readInt() != 0;
    }
}
