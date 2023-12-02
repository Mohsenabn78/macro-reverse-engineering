package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.DayOfMonthConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class DayOfMonthConstraint extends Constraint {
    public static final Parcelable.Creator<DayOfMonthConstraint> CREATOR = new a();
    private String[] m_dayNames;
    private boolean[] m_daysOfMonth;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DayOfMonthConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DayOfMonthConstraint createFromParcel(Parcel parcel) {
            return new DayOfMonthConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DayOfMonthConstraint[] newArray(int i4) {
            return new DayOfMonthConstraint[i4];
        }
    }

    /* synthetic */ DayOfMonthConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(DialogInterface dialogInterface, int i4, boolean z3) {
        this.m_daysOfMonth[i4] = z3;
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= 31) {
                break;
            } else if (this.m_daysOfMonth[i5]) {
                z4 = true;
                break;
            } else {
                i5++;
            }
        }
        ((AlertDialog) dialogInterface).getButton(-1).setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(DialogInterface dialogInterface, int i4) {
        secondaryItemConfirmed();
    }

    private void init() {
        this.m_dayNames = new String[31];
        int i4 = 0;
        while (i4 < 31) {
            int i5 = i4 + 1;
            this.m_dayNames[i4] = String.valueOf(i5);
            i4 = i5;
        }
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int i4 = Calendar.getInstance().get(5);
        if (i4 >= 1 && i4 <= 31) {
            return this.m_daysOfMonth[i4 - 1];
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("DayOfWeekConstraint: Invalid day value: " + i4));
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.m_daysOfMonth;
            if (i4 >= zArr.length) {
                break;
            }
            if (zArr[i4]) {
                sb.append(i4 + 1);
                sb.append(", ");
            }
            i4++;
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DayOfMonthConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        AlertDialog create = new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.constraint_day_of_month).setMultiChoiceItems(this.m_dayNames, this.m_daysOfMonth, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.u0
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i4, boolean z3) {
                DayOfMonthConstraint.this.Q(dialogInterface, i4, z3);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.v0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DayOfMonthConstraint.this.R(dialogInterface, i4);
            }
        }).create();
        create.show();
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= 31) {
                break;
            } else if (this.m_daysOfMonth[i4]) {
                z3 = true;
                break;
            } else {
                i4++;
            }
        }
        create.getButton(-1).setEnabled(z3);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeBooleanArray(this.m_daysOfMonth);
    }

    public DayOfMonthConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public DayOfMonthConstraint() {
        this.m_daysOfMonth = new boolean[31];
        init();
    }

    private DayOfMonthConstraint(Parcel parcel) {
        super(parcel);
        this.m_daysOfMonth = new boolean[31];
        init();
        parcel.readBooleanArray(this.m_daysOfMonth);
    }
}
