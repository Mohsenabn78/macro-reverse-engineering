package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.SignalOnOffConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class SignalOnOffConstraint extends Constraint {
    public static final Parcelable.Creator<SignalOnOffConstraint> CREATOR = new a();
    private static int s_constraintCounter;
    private static boolean s_hasService;
    private static b s_serviceStateListener;
    private transient boolean m_constraintCheckingEnabled;
    private int m_option;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<SignalOnOffConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SignalOnOffConstraint createFromParcel(Parcel parcel) {
            return new SignalOnOffConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SignalOnOffConstraint[] newArray(int i4) {
            return new SignalOnOffConstraint[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends PhoneStateListener {
        private b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            if (serviceState.getState() != 0) {
                boolean unused = SignalOnOffConstraint.s_hasService = false;
            } else {
                boolean unused2 = SignalOnOffConstraint.s_hasService = true;
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* synthetic */ SignalOnOffConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        try {
            ((TelephonyManager) getContext().getSystemService("phone")).listen(s_serviceStateListener, 0);
        } catch (SecurityException unused) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.constraint_signal_on_off), true, false);
        }
        s_serviceStateListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        s_serviceStateListener = new b(null);
        try {
            ((TelephonyManager) getContext().getSystemService("phone")).listen(s_serviceStateListener, 1);
        } catch (SecurityException unused) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.constraint_signal_on_off), true, false);
        }
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_signal_on_off_service_available), MacroDroidApplication.getInstance().getString(R.string.constraint_signal_on_off_service_unavailable)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        if (s_hasService) {
            if (Settings.System.getInt(getContext().getContentResolver(), "airplane_mode_on", 0) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                if (this.m_option == 0) {
                    return true;
                }
                return false;
            } else if (this.m_option != 0) {
                return true;
            } else {
                return false;
            }
        } else if (this.m_option != 0) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void disableConstraintChecking() {
        if (!this.m_constraintCheckingEnabled) {
            return;
        }
        this.m_constraintCheckingEnabled = false;
        int i4 = s_constraintCounter - 1;
        s_constraintCounter = i4;
        if (i4 == 0) {
            new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.constraint.d4
                @Override // java.lang.Runnable
                public final void run() {
                    SignalOnOffConstraint.this.R();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void enableConstraintChecking(boolean z3) {
        if (!z3 && this.m_constraintCheckingEnabled) {
            return;
        }
        this.m_constraintCheckingEnabled = true;
        if (s_constraintCounter == 0) {
            new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.constraint.e4
                @Override // java.lang.Runnable
                public final void run() {
                    SignalOnOffConstraint.this.S();
                }
            });
        }
        s_constraintCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredNameFlowControl() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SignalOnOffConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.constraint_signal_on_off);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public SignalOnOffConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SignalOnOffConstraint() {
        this.m_option = 0;
    }

    private SignalOnOffConstraint(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
