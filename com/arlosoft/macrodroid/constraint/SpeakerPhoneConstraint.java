package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.SpeakerPhoneConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;

/* loaded from: classes3.dex */
public class SpeakerPhoneConstraint extends Constraint {
    public static final Parcelable.Creator<SpeakerPhoneConstraint> CREATOR = new a();
    private boolean m_enabled;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<SpeakerPhoneConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpeakerPhoneConstraint createFromParcel(Parcel parcel) {
            return new SpeakerPhoneConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SpeakerPhoneConstraint[] newArray(int i4) {
            return new SpeakerPhoneConstraint[i4];
        }
    }

    /* synthetic */ SpeakerPhoneConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_speaker_phone_on), MacroDroidApplication.getInstance().getString(R.string.constraint_speaker_phone_off)};
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
        this.m_enabled = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkOK(com.arlosoft.macrodroid.triggers.TriggerContextInfo r5) {
        /*
            r4 = this;
            android.content.Context r5 = r4.getContext()
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            android.content.Context r0 = r4.getContext()
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            r1 = 1
            r2 = 0
            boolean r3 = r4.m_enabled     // Catch: java.lang.SecurityException -> L30
            int r0 = r0.getCallState()     // Catch: java.lang.SecurityException -> L30
            if (r0 == 0) goto L2a
            boolean r5 = r5.isSpeakerphoneOn()     // Catch: java.lang.SecurityException -> L30
            if (r5 == 0) goto L2a
            r5 = 1
            goto L2b
        L2a:
            r5 = 0
        L2b:
            if (r3 != r5) goto L2e
            goto L2f
        L2e:
            r1 = 0
        L2f:
            return r1
        L30:
            android.content.Context r5 = r4.getContext()
            r0 = 2131952997(0x7f130565, float:1.9542453E38)
            java.lang.String r0 = com.arlosoft.macrodroid.common.SelectableItem.r(r0)
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            com.arlosoft.macrodroid.permissions.PermissionsHelper.showNeedsPermission(r5, r3, r0, r1, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.SpeakerPhoneConstraint.checkOK(com.arlosoft.macrodroid.triggers.TriggerContextInfo):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_enabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_enabled) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SpeakerPhoneConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_PHONE_STATE"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.select_option);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_enabled ? 1 : 0);
    }

    public SpeakerPhoneConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SpeakerPhoneConstraint() {
        this.m_enabled = true;
    }

    private SpeakerPhoneConstraint(Parcel parcel) {
        super(parcel);
        this.m_enabled = parcel.readInt() != 0;
    }
}
