package com.arlosoft.macrodroid.constraint.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.ConstraintInfo;
import com.arlosoft.macrodroid.constraint.LocationModeConstraint;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class LocationModeConstraintInfo extends ConstraintInfo {

    /* renamed from: g  reason: collision with root package name */
    private static SelectableItemInfo f10404g;

    public static SelectableItemInfo getInstance() {
        if (f10404g == null) {
            f10404g = new LocationModeConstraintInfo();
        }
        return f10404g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public SelectableItem constructItem(Activity activity, Macro macro) {
        return new LocationModeConstraint(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public List<Integer> getAdditionalSearchTerms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf((int) R.string.constraint_gps_enabled));
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getHelpInfo() {
        return R.string.constraint_location_mode_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_edit_location_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @StringRes
    public int getName() {
        return R.string.constraint_location_mode;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int minSDKVersion() {
        return 19;
    }
}
