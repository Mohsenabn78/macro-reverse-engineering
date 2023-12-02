package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.ExternalPowerConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class ExternalPowerConstraint extends Constraint {
    private static final int CONNECTED_OPTION_WIRED_FAST = 0;
    private static final int CONNECTED_OPTION_WIRED_SLOW = 1;
    private static final int CONNECTED_OPTION_WIRELESS = 2;
    public static final Parcelable.Creator<ExternalPowerConstraint> CREATOR = new a();
    private boolean m_externalPower;
    private boolean[] m_powerConnectedOptions;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ExternalPowerConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExternalPowerConstraint createFromParcel(Parcel parcel) {
            return new ExternalPowerConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ExternalPowerConstraint[] newArray(int i4) {
            return new ExternalPowerConstraint[i4];
        }
    }

    /* synthetic */ ExternalPowerConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] S() {
        return new String[]{SelectableItem.r(R.string.wired), SelectableItem.r(R.string.wired_slow), SelectableItem.r(R.string.wireless)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(DialogInterface dialogInterface, int i4, boolean z3) {
        this.m_powerConnectedOptions[i4] = z3;
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            boolean[] zArr = this.m_powerConnectedOptions;
            if (i5 >= zArr.length) {
                break;
            } else if (zArr[i5]) {
                z4 = true;
                break;
            } else {
                i5++;
            }
        }
        ((AlertDialog) dialogInterface).getButton(-1).setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_external_power_connected), MacroDroidApplication.getInstance().getString(R.string.constraint_external_power_disconnected)};
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
        this.m_externalPower = z3;
    }

    protected void R() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setMultiChoiceItems(S(), this.m_powerConnectedOptions, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.y0
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i4, boolean z3) {
                ExternalPowerConstraint.this.T(dialogInterface, i4, z3);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.z0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ExternalPowerConstraint.this.U(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.a1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ExternalPowerConstraint.this.V(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.m_powerConnectedOptions;
            if (i4 >= zArr.length) {
                break;
            } else if (zArr[i4]) {
                z3 = true;
                break;
            } else {
                i4++;
            }
        }
        create.getButton(-1).setEnabled(z3);
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        int intExtra = getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
        if (intExtra != 1 && intExtra != 2 && intExtra != 4) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!this.m_externalPower) {
            return !z3;
        }
        boolean[] zArr = this.m_powerConnectedOptions;
        if (zArr[0] && intExtra == 1) {
            return true;
        }
        if (zArr[1] && intExtra == 2) {
            return true;
        }
        if (!zArr[2] || intExtra != 4) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_externalPower ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_externalPower) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = "";
        if (!this.m_externalPower) {
            return "";
        }
        boolean[] zArr = this.m_powerConnectedOptions;
        boolean z3 = zArr[0];
        if (z3 && zArr[1] && zArr[2]) {
            return SelectableItem.r(R.string.any);
        }
        if (z3) {
            str = "" + S()[0];
            boolean[] zArr2 = this.m_powerConnectedOptions;
            if (zArr2[2] || zArr2[1]) {
                str = str + " + ";
            }
        }
        if (this.m_powerConnectedOptions[1]) {
            str = str + S()[1];
            if (this.m_powerConnectedOptions[2]) {
                str = str + " + ";
            }
        }
        if (this.m_powerConnectedOptions[2]) {
            return str + S()[2];
        }
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ExternalPowerConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (!this.m_externalPower) {
            super.secondaryItemConfirmed();
        } else {
            R();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_externalPower ? 1 : 0);
        parcel.writeBooleanArray(this.m_powerConnectedOptions);
    }

    public ExternalPowerConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ExternalPowerConstraint() {
        this.m_powerConnectedOptions = new boolean[]{true, true, true};
        this.m_externalPower = true;
    }

    private ExternalPowerConstraint(Parcel parcel) {
        super(parcel);
        this.m_powerConnectedOptions = new boolean[]{true, true, true};
        this.m_externalPower = parcel.readInt() != 0;
        parcel.readBooleanArray(this.m_powerConnectedOptions);
    }
}
