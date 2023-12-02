package com.arlosoft.macrodroid.selectableitemlist.classic;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener;
import java.util.List;

/* loaded from: classes3.dex */
public class SelectConditionAdapter extends SelectableItemAdapter {
    public SelectConditionAdapter(Activity activity, Macro macro, boolean z3, @NonNull SelectableItemChosenListener selectableItemChosenListener) {
        super(activity, macro, z3, selectableItemChosenListener, 2, true);
        refresh();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter
    protected List<SelectableItemInfo> f() {
        return Constraint.getAllConstraintsInfo(this.f13379h.getApplicationContext(), this.f13378g, false);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter
    protected int g() {
        return R.drawable.circular_icon_background_condition;
    }
}
