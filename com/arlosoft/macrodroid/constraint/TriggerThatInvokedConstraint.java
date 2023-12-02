package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.TriggerThatInvokedConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Iterator;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class TriggerThatInvokedConstraint extends Constraint {
    public static final Parcelable.Creator<TriggerThatInvokedConstraint> CREATOR = new b();
    private boolean m_not;
    private long m_siGuidThatInvoked;
    private String m_triggerName;
    private transient boolean notSetting;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends ArrayAdapter<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10239a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10240b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, int i4, int i5, String[] strArr, int i6, int i7) {
            super(context, i4, i5, strArr);
            this.f10239a = i6;
            this.f10240b = i7;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i4, view, viewGroup);
            CheckedTextView checkedTextView = (CheckedTextView) view2.findViewById(16908308);
            String str = (String) getItem(i4);
            SpannableString spannableString = new SpannableString((CharSequence) getItem(i4));
            if (str.contains("\n")) {
                spannableString.setSpan(new RelativeSizeSpan(0.7f), str.indexOf("\n"), str.length(), 33);
            }
            checkedTextView.setText(spannableString);
            int i5 = this.f10239a;
            int i6 = this.f10240b;
            checkedTextView.setPadding(i5, i6, i5, i6);
            checkedTextView.setTextSize(18.0f);
            return view2;
        }
    }

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<TriggerThatInvokedConstraint> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TriggerThatInvokedConstraint createFromParcel(Parcel parcel) {
            return new TriggerThatInvokedConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TriggerThatInvokedConstraint[] newArray(int i4) {
            return new TriggerThatInvokedConstraint[i4];
        }
    }

    /* synthetic */ TriggerThatInvokedConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(DialogInterface dialogInterface, int i4) {
        String str;
        Trigger trigger = getMacro().getTriggerList().get(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
        this.m_siGuidThatInvoked = trigger.getSIGUID();
        String extendedDetail = trigger.getExtendedDetail();
        StringBuilder sb = new StringBuilder();
        sb.append(trigger.getConfiguredName());
        if (TextUtils.isEmpty(extendedDetail)) {
            str = "";
        } else {
            str = ": " + extendedDetail;
        }
        sb.append(str);
        this.m_triggerName = sb.toString();
        this.m_not = this.notSetting;
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_trigger_that_invoked), MacroDroidApplication.getInstance().getString(R.string.constraint_trigger_that_invoked_not)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3 = true;
        if (i4 != 1) {
            z3 = false;
        }
        this.notSetting = z3;
    }

    protected AlertDialog P() {
        String str;
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.margin_medium);
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.margin_tiny);
        ArrayList<Trigger> triggerList = getMacro().getTriggerList();
        int size = triggerList.size();
        String[] strArr = new String[size];
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Trigger trigger = triggerList.get(i5);
            String extendedDetail = trigger.getExtendedDetail();
            StringBuilder sb = new StringBuilder();
            sb.append(trigger.getConfiguredName());
            if (TextUtils.isEmpty(extendedDetail)) {
                str = "";
            } else {
                str = "\n" + trigger.getExtendedDetail();
            }
            sb.append(str);
            strArr[i5] = sb.toString();
            if (triggerList.get(i5).getSIGUID() == this.m_siGuidThatInvoked) {
                i4 = i5;
            }
        }
        if (size == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.please_add_a_trigger, 1).show();
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(strArr, i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.u4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                TriggerThatInvokedConstraint.this.Q(dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        ListView listView = create.getListView();
        listView.setAdapter((ListAdapter) new a(new ContextThemeWrapper(getActivity(), m()), R.layout.single_choice_list_item, 16908308, strArr, dimensionPixelOffset, dimensionPixelOffset2));
        listView.setItemChecked(i4, true);
        return create;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        boolean z4;
        boolean z5;
        if (triggerContextInfo != null && triggerContextInfo.getTriggerGuid() != 0) {
            if (triggerContextInfo.getTriggerGuid() == this.m_siGuidThatInvoked) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (triggerContextInfo.getNestedTriggerContextInfo() != null && triggerContextInfo.getTriggerGuid() == this.m_siGuidThatInvoked) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z3 && !z4) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5 != this.m_not) {
                return true;
            }
            return false;
        }
        return this.m_not;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_not ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        int i4;
        if (this.m_not) {
            i4 = R.string.constraint_trigger_that_invoked_not;
        } else {
            i4 = R.string.constraint_trigger_that_invoked;
        }
        return SelectableItem.r(i4);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        try {
            Iterator<Trigger> it = getMacro().getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next.getSIGUID() == this.m_siGuidThatInvoked) {
                    String extendedDetail = next.getExtendedDetail();
                    StringBuilder sb = new StringBuilder();
                    sb.append(next.getConfiguredName());
                    if (TextUtils.isEmpty(extendedDetail)) {
                        str = "";
                    } else {
                        str = ": " + extendedDetail;
                    }
                    sb.append(str);
                    return sb.toString();
                }
            }
        } catch (Exception unused) {
        }
        return this.m_triggerName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return TriggerThatInvokedConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + ": " + getExtendedDetail();
    }

    public long getTriggerGuid() {
        return this.m_siGuidThatInvoked;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        this.notSetting = this.m_not;
        super.handleItemSelected();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        Macro macro = getMacro();
        if (macro == null) {
            return true;
        }
        Iterator<Trigger> it = macro.getTriggerList().iterator();
        while (it.hasNext()) {
            if (it.next().getSIGUID() == this.m_siGuidThatInvoked) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        P();
    }

    public void setGuid(long j4) {
        this.m_siGuidThatInvoked = j4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeLong(this.m_siGuidThatInvoked);
        parcel.writeString(this.m_triggerName);
        parcel.writeInt(this.m_not ? 1 : 0);
    }

    public TriggerThatInvokedConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private TriggerThatInvokedConstraint() {
    }

    private TriggerThatInvokedConstraint(Parcel parcel) {
        super(parcel);
        this.m_siGuidThatInvoked = parcel.readLong();
        this.m_triggerName = parcel.readString();
        this.m_not = parcel.readInt() != 0;
    }
}
