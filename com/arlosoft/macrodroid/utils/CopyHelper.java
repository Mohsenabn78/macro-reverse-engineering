package com.arlosoft.macrodroid.utils;

import android.os.Parcel;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.constraint.TriggerThatInvokedConstraint;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CopyHelper {

    /* renamed from: a  reason: collision with root package name */
    private static SelectableItem f16016a;

    /* renamed from: b  reason: collision with root package name */
    private static List<SelectableItem> f16017b;

    private static void a(List<Constraint> list, List<Trigger> list2, List<Trigger> list3) {
        if (list != null && list.size() != 0) {
            for (Constraint constraint : list) {
                constraint.setNewGUID();
                if (constraint instanceof LogicConstraint) {
                    a(constraint.getConstraints(), list2, list3);
                }
                if (list2 != null && (constraint instanceof TriggerThatInvokedConstraint)) {
                    TriggerThatInvokedConstraint triggerThatInvokedConstraint = (TriggerThatInvokedConstraint) constraint;
                    for (int i4 = 0; i4 < list3.size(); i4++) {
                        if (triggerThatInvokedConstraint.getTriggerGuid() == list2.get(i4).getSIGUID()) {
                            triggerThatInvokedConstraint.setGuid(list3.get(i4).getSIGUID());
                        }
                    }
                }
            }
        }
    }

    public static SelectableItem copyItem(SelectableItem selectableItem, List<Trigger> list, List<Trigger> list2) {
        Parcel obtain = Parcel.obtain();
        obtain.writeParcelable(selectableItem, 0);
        obtain.setDataPosition(0);
        SelectableItem selectableItem2 = (SelectableItem) obtain.readParcelable(selectableItem.getClass().getClassLoader());
        selectableItem2.setNewGUID();
        a(selectableItem2.getConstraints(), list, list2);
        if (list != null && (selectableItem instanceof TriggerThatInvokedConstraint)) {
            TriggerThatInvokedConstraint triggerThatInvokedConstraint = (TriggerThatInvokedConstraint) selectableItem;
            for (int i4 = 0; i4 < list2.size(); i4++) {
                if (triggerThatInvokedConstraint.getTriggerGuid() == list.get(i4).getSIGUID()) {
                    ((TriggerThatInvokedConstraint) selectableItem2).setGuid(list2.get(i4).getSIGUID());
                }
            }
        }
        obtain.recycle();
        return selectableItem2;
    }

    public static List<SelectableItem> copyItemList() {
        return f16017b;
    }

    public static MacroDroidVariable copyVariable(MacroDroidVariable macroDroidVariable) {
        Parcel obtain = Parcel.obtain();
        obtain.writeParcelable(macroDroidVariable, 0);
        obtain.setDataPosition(0);
        MacroDroidVariable macroDroidVariable2 = (MacroDroidVariable) obtain.readParcelable(MacroDroidVariable.class.getClassLoader());
        obtain.recycle();
        return macroDroidVariable2;
    }

    public static void refreshCopiedItem() {
        SelectableItem selectableItem = f16016a;
        if (selectableItem != null) {
            f16016a = copyItem(selectableItem, null, null);
        } else if (f16017b != null) {
            ArrayList arrayList = new ArrayList();
            for (SelectableItem selectableItem2 : f16017b) {
                arrayList.add(copyItem(selectableItem2, null, null));
            }
            f16017b = arrayList;
        }
    }

    public static void setCopiedItem(SelectableItem selectableItem) {
        if (selectableItem != null) {
            f16016a = copyItem(selectableItem, null, null);
            f16017b = null;
            return;
        }
        f16016a = null;
        f16017b = null;
    }

    public static void setCopiedItemList(List<SelectableItem> list) {
        if (list != null) {
            f16016a = null;
            f16017b = new ArrayList();
            for (SelectableItem selectableItem : list) {
                f16017b.add(copyItem(selectableItem, null, null));
            }
            return;
        }
        f16016a = null;
        f16017b = null;
    }

    public static SelectableItem copyItem() {
        return f16016a;
    }
}
