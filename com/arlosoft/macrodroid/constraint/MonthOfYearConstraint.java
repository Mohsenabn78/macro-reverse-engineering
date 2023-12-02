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
import com.arlosoft.macrodroid.constraint.info.MonthOfYearConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.DateTimeUtils;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class MonthOfYearConstraint extends Constraint {
    public static final Parcelable.Creator<MonthOfYearConstraint> CREATOR = new a();
    private boolean[] m_months;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<MonthOfYearConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MonthOfYearConstraint createFromParcel(Parcel parcel) {
            return new MonthOfYearConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MonthOfYearConstraint[] newArray(int i4) {
            return new MonthOfYearConstraint[i4];
        }
    }

    /* synthetic */ MonthOfYearConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(DialogInterface dialogInterface, int i4, boolean z3) {
        this.m_months[i4] = z3;
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= 12) {
                break;
            } else if (this.m_months[i5]) {
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

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int i4 = Calendar.getInstance().get(2);
        if (i4 >= 0 && i4 < 12) {
            return this.m_months[i4];
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("DayOfWeekConstraint: Invalid month value: " + i4));
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        StringBuilder sb = new StringBuilder();
        String[] monthNames = DateTimeUtils.getMonthNames();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.m_months;
            if (i4 >= zArr.length) {
                break;
            }
            if (zArr[i4]) {
                sb.append(monthNames[i4]);
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
        return MonthOfYearConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        AlertDialog create = new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.constraint_month_of_year).setMultiChoiceItems(DateTimeUtils.getMonthNames(), this.m_months, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.g3
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i4, boolean z3) {
                MonthOfYearConstraint.this.Q(dialogInterface, i4, z3);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.h3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MonthOfYearConstraint.this.R(dialogInterface, i4);
            }
        }).create();
        create.show();
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= 12) {
                break;
            } else if (this.m_months[i4]) {
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
        parcel.writeBooleanArray(this.m_months);
    }

    public MonthOfYearConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public MonthOfYearConstraint() {
        this.m_months = new boolean[12];
    }

    private MonthOfYearConstraint(Parcel parcel) {
        super(parcel);
        boolean[] zArr = new boolean[12];
        this.m_months = zArr;
        parcel.readBooleanArray(zArr);
    }
}
