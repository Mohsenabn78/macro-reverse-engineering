package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.RoamingOnOffConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes3.dex */
public class RoamingOnOffConstraint extends Constraint {
    public static final Parcelable.Creator<RoamingOnOffConstraint> CREATOR = new a();
    private boolean m_roamingOn;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<RoamingOnOffConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RoamingOnOffConstraint createFromParcel(Parcel parcel) {
            return new RoamingOnOffConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RoamingOnOffConstraint[] newArray(int i4) {
            return new RoamingOnOffConstraint[i4];
        }
    }

    /* synthetic */ RoamingOnOffConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_roaming_on_off_option_on), MacroDroidApplication.getInstance().getString(R.string.constraint_roaming_on_off_option_off)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_roamingOn = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkOK(com.arlosoft.macrodroid.triggers.TriggerContextInfo r4) {
        /*
            r3 = this;
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 29
            r1 = 1
            r2 = 0
            if (r4 < r0) goto L1f
            android.content.Context r4 = r3.getContext()
            java.lang.String r0 = "phone"
            java.lang.Object r4 = r4.getSystemService(r0)
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4
            boolean r0 = r3.m_roamingOn
            boolean r4 = com.arlosoft.macrodroid.constraint.c4.a(r4)
            if (r0 != r4) goto L1d
            goto L1e
        L1d:
            r1 = 0
        L1e:
            return r1
        L1f:
            android.content.Context r4 = r3.getContext()     // Catch: android.provider.Settings.SettingNotFoundException -> L31
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: android.provider.Settings.SettingNotFoundException -> L31
            java.lang.String r0 = "data_roaming"
            int r4 = android.provider.Settings.Secure.getInt(r4, r0)     // Catch: android.provider.Settings.SettingNotFoundException -> L31
            if (r4 != r1) goto L32
            r4 = 1
            goto L33
        L31:
        L32:
            r4 = 0
        L33:
            boolean r0 = r3.m_roamingOn
            if (r0 != r4) goto L38
            goto L39
        L38:
            r1 = 0
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.RoamingOnOffConstraint.checkOK(com.arlosoft.macrodroid.triggers.TriggerContextInfo):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_roamingOn ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_roamingOn) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return RoamingOnOffConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_roamingOn ? 1 : 0);
    }

    public RoamingOnOffConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private RoamingOnOffConstraint() {
        this.m_roamingOn = true;
    }

    private RoamingOnOffConstraint(Parcel parcel) {
        super(parcel);
        this.m_roamingOn = parcel.readInt() != 0;
    }
}
