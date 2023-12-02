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
import com.arlosoft.macrodroid.constraint.info.DayOfWeekConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import java.text.DateFormatSymbols;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class DayOfWeekConstraint extends Constraint {
    public static final Parcelable.Creator<DayOfWeekConstraint> CREATOR = new a();
    private boolean[] m_daysOfWeek;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DayOfWeekConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DayOfWeekConstraint createFromParcel(Parcel parcel) {
            return new DayOfWeekConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DayOfWeekConstraint[] newArray(int i4) {
            return new DayOfWeekConstraint[i4];
        }
    }

    /* synthetic */ DayOfWeekConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static String[] Q() {
        return new String[]{R()[2], R()[3], R()[4], R()[5], R()[6], R()[7], R()[1]};
    }

    private static String[] R() {
        return new DateFormatSymbols().getWeekdays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(DialogInterface dialogInterface, int i4, boolean z3) {
        boolean z4 = true;
        this.m_daysOfWeek[(i4 + 1) % 7] = z3;
        int i5 = 0;
        while (true) {
            if (i5 < 7) {
                if (this.m_daysOfWeek[i5]) {
                    break;
                }
                i5++;
            } else {
                z4 = false;
                break;
            }
        }
        ((AlertDialog) dialogInterface).getButton(-1).setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(DialogInterface dialogInterface, int i4) {
        secondaryItemConfirmed();
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int i4 = Calendar.getInstance().get(7);
        if (i4 >= 1 && i4 <= 7) {
            return this.m_daysOfWeek[i4 - 1];
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("DayOfWeekConstraint: Invalid day value: " + i4));
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        StringBuilder sb = new StringBuilder();
        int i4 = 1;
        while (true) {
            boolean[] zArr = this.m_daysOfWeek;
            if (i4 >= zArr.length + 1) {
                break;
            }
            if (zArr[i4 % 7]) {
                sb.append(Q()[i4 - 1].substring(0, 3));
                sb.append(",");
            }
            i4++;
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        }
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DayOfWeekConstraintInfo.getInstance();
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
        boolean[] zArr = new boolean[7];
        boolean z3 = false;
        int i4 = 0;
        while (i4 < 7) {
            int i5 = i4 + 1;
            zArr[i4] = this.m_daysOfWeek[i5 % 7];
            i4 = i5;
        }
        AlertDialog create = new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.constraint_day_of_week_select_days).setMultiChoiceItems(Q(), zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.w0
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i6, boolean z4) {
                DayOfWeekConstraint.this.S(dialogInterface, i6, z4);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.x0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                DayOfWeekConstraint.this.T(dialogInterface, i6);
            }
        }).create();
        create.show();
        int i6 = 0;
        while (true) {
            if (i6 >= 7) {
                break;
            } else if (this.m_daysOfWeek[i6]) {
                z3 = true;
                break;
            } else {
                i6++;
            }
        }
        create.getButton(-1).setEnabled(z3);
    }

    public void setDaysOfWeek(boolean[] zArr) {
        this.m_daysOfWeek = zArr;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeBooleanArray(this.m_daysOfWeek);
    }

    public DayOfWeekConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public DayOfWeekConstraint() {
        this.m_daysOfWeek = new boolean[7];
    }

    private DayOfWeekConstraint(Parcel parcel) {
        super(parcel);
        boolean[] zArr = new boolean[7];
        this.m_daysOfWeek = zArr;
        parcel.readBooleanArray(zArr);
    }
}
