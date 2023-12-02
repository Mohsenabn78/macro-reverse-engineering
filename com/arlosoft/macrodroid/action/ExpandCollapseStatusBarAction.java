package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ExpandCollapseStatusBarActionInfo;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.MacroDroidAccessibilityServiceJellyBean;

/* loaded from: classes2.dex */
public class ExpandCollapseStatusBarAction extends Action {
    public static final Parcelable.Creator<ExpandCollapseStatusBarAction> CREATOR = new a();
    private static final int OPTION_COLLAPSE = 1;
    private static final int OPTION_EXPAND = 0;
    private int m_option;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ExpandCollapseStatusBarAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExpandCollapseStatusBarAction createFromParcel(Parcel parcel) {
            return new ExpandCollapseStatusBarAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ExpandCollapseStatusBarAction[] newArray(int i4) {
            return new ExpandCollapseStatusBarAction[i4];
        }
    }

    /* synthetic */ ExpandCollapseStatusBarAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.expand_status_bar), SelectableItem.r(R.string.collapse_status_bar)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ExpandCollapseStatusBarActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (this.m_option == 0) {
            Intent intent = new Intent(getContext(), MacroDroidAccessibilityServiceJellyBean.class);
            intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 4);
            getContext().startService(intent);
        } else if (Build.VERSION.SDK_INT >= 31) {
            Intent intent2 = new Intent(getContext(), MacroDroidAccessibilityServiceJellyBean.class);
            intent2.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 15);
            getContext().startService(intent2);
        } else {
            getContext().sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessibility() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public ExpandCollapseStatusBarAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ExpandCollapseStatusBarAction() {
    }

    private ExpandCollapseStatusBarAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
