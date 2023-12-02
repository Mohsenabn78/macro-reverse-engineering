package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.DisableCategoryActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.categories.HasCategoryName;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.events.CategoryEnabledStateChangeEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class DisableCategoryAction extends Action implements HasCategoryName {
    public static final Parcelable.Creator<DisableCategoryAction> CREATOR = new b();
    private String m_category;
    private transient List<String> m_categoryList;
    private final boolean m_enable;
    private int m_state;

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<DisableCategoryAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DisableCategoryAction createFromParcel(Parcel parcel) {
            return new DisableCategoryAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DisableCategoryAction[] newArray(int i4) {
            return new DisableCategoryAction[i4];
        }
    }

    /* synthetic */ DisableCategoryAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(DialogInterface dialogInterface, int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    private void R() {
        this.m_categoryList = new ArrayList();
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        HashSet hashSet = new HashSet();
        for (Macro macro : allCompletedMacros) {
            String category = macro.getCategory();
            if (category != null) {
                hashSet.add(category);
            } else {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ConfigureAppNotificationsAction: Macro has a null category"));
            }
        }
        this.m_categoryList.addAll(hashSet);
        Collections.sort(this.m_categoryList);
        this.m_categoryList.remove(SelectableItem.r(R.string.uncategorized));
        this.m_categoryList.add(0, SelectableItem.r(R.string.uncategorized));
        if (this.m_category == null) {
            if (this.m_categoryList.size() > 0) {
                this.m_category = this.m_categoryList.get(0);
            } else {
                this.m_category = SelectableItem.r(R.string.uncategorized);
            }
        }
    }

    private void S(Cache cache, String str) {
        new CategoryPasswordHelper(cache, null).promptForCategoryPassword(getActivity(), SelectableItem.r(R.string.enter_category_lock_password), str, Settings.getLockedCategoryPassword(getActivity()), 0, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        int i4 = this.m_state;
        if (i4 == -1) {
            i4 = !this.m_enable ? 1 : 0;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setSingleChoiceItems(getOptions(), i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.b5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DisableCategoryAction.this.P(dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.c5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DisableCategoryAction.this.Q(dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_disable_category_enable), SelectableItem.r(R.string.action_disable_category_disable), SelectableItem.r(R.string.action_disable_category_toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_category = this.m_categoryList.get(i4);
    }

    @Override // com.arlosoft.macrodroid.categories.HasCategoryName
    public String getCategory() {
        return this.m_category;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.m_category != null) {
            for (int i4 = 0; i4 < this.m_categoryList.size(); i4++) {
                if (this.m_category.equals(this.m_categoryList.get(i4))) {
                    return i4;
                }
            }
        }
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        Context context;
        int i4;
        if (this.m_state == -1) {
            StringBuilder sb = new StringBuilder();
            if (this.m_enable) {
                context = getContext();
                i4 = R.string.enable;
            } else {
                context = getContext();
                i4 = R.string.disable;
            }
            sb.append(context.getString(i4));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(getContext().getString(R.string.action_disable_category_category));
            return sb.toString();
        }
        return getOptions()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_category;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DisableCategoryActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Set<String> disabledCategories = Settings.getDisabledCategories(getContext());
        boolean z3 = this.m_enable;
        int i4 = this.m_state;
        if (i4 != -1) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        z3 = disabledCategories.contains(this.m_category);
                    }
                } else {
                    z3 = false;
                }
            } else {
                z3 = true;
            }
        }
        if (z3) {
            disabledCategories.remove(this.m_category);
        } else {
            disabledCategories.add(this.m_category);
        }
        Settings.setDisabledCategories(getContext(), disabledCategories);
        MacroStore.resetEnabledMacroList();
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            if (macro.getCategory().equals(this.m_category)) {
                boolean isEnabled = macro.isEnabled();
                if (z3 && isEnabled) {
                    MacroStore.getInstance().enableMacroAndUpdate(macro, true);
                } else if (!z3 && isEnabled) {
                    MacroStore.getInstance().disableMacroAndUpdate(macro, true);
                    macro.setEnabledFlag(true);
                }
            }
        }
        EventBusUtils.getEventBus().post(new CategoryEnabledStateChangeEvent(this.m_category, z3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        R();
        String[] strArr = new String[this.m_categoryList.size()];
        int i4 = 0;
        for (String str : this.m_categoryList) {
            strArr[i4] = str;
            i4++;
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.action_disable_category);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Category categoryByName;
        Cache cache = MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE);
        CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
        if (categoryList != null && (categoryByName = categoryList.getCategoryByName(this.m_category)) != null && categoryByName.isLocked()) {
            S(cache, this.m_category);
        } else {
            T();
        }
    }

    @Override // com.arlosoft.macrodroid.categories.HasCategoryName
    public void setCategory(String str) {
        this.m_category = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_category);
        parcel.writeInt(!this.m_enable ? 1 : 0);
        parcel.writeInt(this.m_state);
    }

    public DisableCategoryAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DisableCategoryAction() {
        this.m_enable = true;
        this.m_state = -1;
    }

    private DisableCategoryAction(Parcel parcel) {
        super(parcel);
        this.m_category = parcel.readString();
        this.m_enable = parcel.readInt() == 0;
        this.m_state = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements CategoryPasswordHelper.PasswordListener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            DisableCategoryAction.this.T();
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }
}
