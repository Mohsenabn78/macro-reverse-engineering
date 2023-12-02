package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.SelectForceRunMacroActivity;
import com.arlosoft.macrodroid.action.info.ForceMacroRunActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.categories.HasCategoryName;
import com.arlosoft.macrodroid.categories.HasMacroNames;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.InvokedByRunMacroTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class ForceMacroRunAction extends Action implements SupportsMagicText, BlockingAction, HasCategoryName, HasMacroNames {
    public static final Parcelable.Creator<ForceMacroRunAction> CREATOR = new c();
    private static final int GUID_THIS_MACRO = -1;
    private boolean getByName;
    private boolean isCategoryLocked;
    private long m_GUID;
    private String m_category;
    private boolean m_ignoreConstraints;
    private transient List<Macro> m_macroList;
    private String m_macroName;
    private boolean m_useOffStatus;
    private String m_userPromptTitle;
    private boolean m_waitToComplete;
    private transient boolean tempGetByName;
    private transient long tempGuid;
    private transient String tempMacroName;

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<ForceMacroRunAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ForceMacroRunAction createFromParcel(Parcel parcel) {
            return new ForceMacroRunAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ForceMacroRunAction[] newArray(int i4) {
            return new ForceMacroRunAction[i4];
        }
    }

    /* synthetic */ ForceMacroRunAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void a0() {
        if (!checkActivityAlive()) {
            return;
        }
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        HashSet hashSet = new HashSet();
        for (Macro macro : allCompletedMacrosSorted) {
            String category = macro.getCategory();
            if (category != null) {
                hashSet.add(category);
            } else {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("DisableCategoryAction: Macro has a null category"));
            }
        }
        final ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        arrayList.add(0, SelectableItem.r(R.string.uncategorized));
        arrayList.add(0, "[" + SelectableItem.r(R.string.all_categories) + "]");
        if (this.m_category == null) {
            this.m_category = "[" + SelectableItem.r(R.string.all_categories) + "]";
        }
        int i4 = 0;
        while (true) {
            if (i4 < arrayList.size()) {
                if (this.m_category.equals(arrayList.get(i4))) {
                    break;
                }
                i4++;
            } else {
                i4 = 0;
                break;
            }
        }
        if (this.m_category == null) {
            this.m_category = (String) arrayList.get(0);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_category);
        builder.setSingleChoiceItems((String[]) arrayList.toArray(new String[0]), i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.q7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ForceMacroRunAction.this.h0(arrayList, dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ForceMacroRunAction.this.i0(dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_macro_run_options);
        appCompatDialog.setTitle(R.string.action_force_macro_run);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.ignoreConstraintsCheckBox);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.alwaysRunCheckBox);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.waitToCompleteCheckBox);
        Button button = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        checkBox.setChecked(this.m_ignoreConstraints);
        checkBox2.setChecked(!this.m_useOffStatus);
        checkBox3.setChecked(this.m_waitToComplete);
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.o7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceMacroRunAction.this.j0(checkBox, checkBox2, checkBox3, appCompatDialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.p7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private void c0() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_enter_macro_name);
        appCompatDialog.setTitle(R.string.enter_macro_name);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.text);
        Button button = (Button) appCompatDialog.findViewById(R.id.magic_text_button);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.i7
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ForceMacroRunAction.l0(editText, magicTextPair);
            }
        };
        String str = this.tempMacroName;
        if (str != null && !str.equals(e0()) && !this.tempMacroName.equals(f0()) && !this.tempMacroName.equals(g0())) {
            editText.setText(this.tempMacroName);
        }
        button2.setEnabled(!TextUtils.isEmpty(this.m_macroName));
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.l7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceMacroRunAction.this.m0(editText, appCompatDialog, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.m7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.n7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceMacroRunAction.this.o0(magicTextListener, view);
            }
        });
        editText.addTextChangedListener(new b(button2, editText));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        appCompatDialog.show();
    }

    private void d0() {
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_run_macro_title);
        appCompatDialog.setTitle(R.string.enter_title);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.text_content);
        editText.setText(this.m_userPromptTitle);
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.s7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceMacroRunAction.this.r0(editText, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.t7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.j7
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ForceMacroRunAction.p0(editText, magicTextPair);
            }
        };
        ((Button) appCompatDialog.findViewById(R.id.magic_text_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.k7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceMacroRunAction.this.q0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private static final String e0() {
        return "[" + MacroDroidApplication.getInstance().getString(R.string.enter_macro_name) + "]";
    }

    private static final String f0() {
        return MacroDroidApplication.getInstance().getString(R.string.constraint_last_run_time_this_macro);
    }

    private static final String g0() {
        return MacroDroidApplication.getInstance().getString(R.string.user_prompt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(ArrayList arrayList, DialogInterface dialogInterface, int i4) {
        this.m_category = (String) arrayList.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(DialogInterface dialogInterface, int i4) {
        d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, AppCompatDialog appCompatDialog, View view) {
        this.m_ignoreConstraints = checkBox.isChecked();
        this.m_useOffStatus = !checkBox2.isChecked();
        this.m_waitToComplete = checkBox3.isChecked();
        if (!this.tempGetByName && this.tempGuid == 0 && !this.tempMacroName.equals(f0())) {
            a0();
        } else {
            this.getByName = this.tempGetByName;
            this.m_macroName = this.tempMacroName;
            this.m_GUID = this.tempGuid;
            itemComplete();
        }
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(EditText editText, AppCompatDialog appCompatDialog, View view) {
        this.tempMacroName = editText.getText().toString();
        this.tempGetByName = true;
        b0();
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(getActivity(), magicTextListener, getMacro(), false, true, false, R.style.Theme_App_Dialog_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(EditText editText, AppCompatDialog appCompatDialog, View view) {
        this.getByName = this.tempGetByName;
        this.m_macroName = this.tempMacroName;
        this.m_userPromptTitle = editText.getText().toString();
        this.m_GUID = this.tempGuid;
        appCompatDialog.dismiss();
        itemComplete();
    }

    private void t0(Cache cache, String str) {
        new CategoryPasswordHelper(cache, null).promptForCategoryPassword(getActivity(), SelectableItem.r(R.string.enter_category_lock_password), str, Settings.getLockedCategoryPassword(getActivity()), 0, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.tempGetByName = false;
        if (i4 > 2) {
            int i5 = i4 - 2;
            this.tempGuid = this.m_macroList.get(i5).getGUID();
            this.tempMacroName = this.m_macroList.get(i5).getName();
        } else if (i4 == 2) {
            this.tempMacroName = e0();
            this.tempGuid = -1L;
        } else if (i4 == 1) {
            this.tempGetByName = true;
        } else {
            this.tempMacroName = g0();
            this.tempGuid = 0L;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void configureOnImport() {
        Macro macroByName;
        if (this.m_macroName.equals(f0())) {
            this.m_GUID = -1L;
        } else if (this.m_macroName.startsWith("[") && this.m_GUID != 0) {
            this.m_GUID = -1L;
        } else if (MacroStore.getInstance().getMacroByGUID(this.m_GUID) == null && (macroByName = MacroStore.getInstance().getMacroByName(this.m_macroName)) != null) {
            this.m_GUID = macroByName.getGUID();
        }
    }

    @Override // com.arlosoft.macrodroid.categories.HasCategoryName
    public String getCategory() {
        return this.m_category;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.getByName) {
            return 1;
        }
        long j4 = this.m_GUID;
        if (j4 == 0) {
            return 0;
        }
        if (j4 == -1) {
            return 2;
        }
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        this.m_macroList = allCompletedMacrosSorted;
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (it.hasNext()) {
            if (getMacro().getGUID() == it.next().getGUID()) {
                it.remove();
            }
        }
        this.m_macroList.add(0, getMacro());
        for (int i4 = 0; i4 < this.m_macroList.size(); i4++) {
            if (this.m_GUID == this.m_macroList.get(i4).getGUID()) {
                return i4 + 2;
            }
        }
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        try {
            if (!this.getByName && this.m_GUID == -1) {
                return f0();
            }
            long j4 = this.m_GUID;
            if (j4 != 0 && j4 != getMacro().getGUID() && !this.isCategoryLocked) {
                return "<a href=\"macrodroid://www.macrodroid.com/macro/" + URLEncoder.encode(this.m_macroName, "UTF-8") + "?showtoast=true\">" + this.m_macroName + "</a>";
            }
            return this.m_macroName;
        } catch (Exception unused) {
            return this.m_macroName;
        }
    }

    public long getGUID() {
        return this.m_GUID;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ForceMacroRunActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" (");
        if (!this.getByName && this.m_GUID == -1) {
            str = f0();
        } else {
            str = this.m_macroName;
        }
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getMacroName() {
        return this.m_macroName;
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    @NonNull
    public List<String> getMacroNames() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.m_macroName);
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        String[] strArr = new String[2];
        String str = this.m_userPromptTitle;
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        strArr[1] = this.m_macroName;
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        this.tempMacroName = this.m_macroName;
        this.tempGuid = this.m_GUID;
        String[] o4 = o();
        this.tempGetByName = this.getByName;
        if (o4 != null && o4.length > 0) {
            k();
        } else {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) getContext().getString(R.string.toast_no_macros_defined), 0).show();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isExtendedHtml() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        long j4 = this.m_GUID;
        if (j4 == 0 || j4 == -1) {
            return true;
        }
        List<Macro> allCompletedMacrosIncludingExtras = MacroStore.getInstance().getAllCompletedMacrosIncludingExtras();
        Iterator<Macro> it = allCompletedMacrosIncludingExtras.iterator();
        while (it.hasNext()) {
            if (it.next().getGUID() == this.m_GUID) {
                return true;
            }
        }
        for (Macro macro : allCompletedMacrosIncludingExtras) {
            if (macro.getName() == this.m_macroName) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        this.m_macroList = allCompletedMacrosSorted;
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (it.hasNext()) {
            if (getMacro().getGUID() == it.next().getGUID()) {
                it.remove();
            }
        }
        this.m_macroList.add(0, getMacro());
        String[] strArr = new String[this.m_macroList.size() + 2];
        strArr[0] = g0();
        strArr[1] = e0();
        for (int i4 = 2; i4 < this.m_macroList.size() + 2; i4++) {
            int i5 = i4 - 2;
            if (getMacro().getGUID() == this.m_macroList.get(i5).getGUID()) {
                strArr[i4] = f0();
            } else {
                strArr[i4] = this.m_macroList.get(i5).getName();
                if (this.m_macroList.get(i5).getIsFavourite()) {
                    strArr[i4] = "⭐ " + strArr[i4];
                }
            }
        }
        if (this.tempGuid == 0 && !this.getByName) {
            this.tempMacroName = g0();
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.select_macro);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Category categoryByName;
        if (this.tempGetByName) {
            c0();
            return;
        }
        this.tempGetByName = false;
        Macro macroByName = MacroStore.getInstance().getMacroByName(this.tempMacroName);
        if (macroByName != null) {
            Cache cache = MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE);
            CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
            if (categoryList != null && (categoryByName = categoryList.getCategoryByName(macroByName.getCategory())) != null && categoryByName.isLocked()) {
                t0(cache, macroByName.getCategory());
                return;
            }
        }
        this.isCategoryLocked = false;
        b0();
    }

    @Override // com.arlosoft.macrodroid.categories.HasCategoryName
    public void setCategory(String str) {
        this.m_category = str;
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    public void setMacroNames(@NonNull List<String> list) {
        try {
            this.m_macroName = list.get(0);
        } catch (Exception e4) {
            SystemLog.logError("Failed to set macro names: " + e4.toString());
        }
    }

    public void setName(String str) {
        long j4 = this.m_GUID;
        if (j4 != 0 && j4 != getMacro().getGUID()) {
            this.m_macroName = str;
        } else {
            this.m_macroName = f0();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_userPromptTitle = strArr[0];
            this.m_macroName = strArr[1];
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_macroName);
        parcel.writeLong(this.m_GUID);
        parcel.writeInt(this.m_ignoreConstraints ? 1 : 0);
        parcel.writeInt(this.m_useOffStatus ? 1 : 0);
        parcel.writeString(this.m_category);
        parcel.writeString(this.m_userPromptTitle);
        parcel.writeInt(this.m_waitToComplete ? 1 : 0);
        parcel.writeInt(this.isCategoryLocked ? 1 : 0);
        parcel.writeInt(this.getByName ? 1 : 0);
    }

    public ForceMacroRunAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> stack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Macro macroByGUID;
        long j4 = this.m_GUID;
        if (j4 == 0 && !this.getByName) {
            String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_userPromptTitle, triggerContextInfo, getMacro());
            Intent intent = new Intent(getContext(), SelectForceRunMacroActivity.class);
            intent.addFlags(268435456);
            if (triggerContextInfo != null) {
                intent.putExtra("Trigger", triggerContextInfo.getTriggerClass());
            }
            intent.putExtra(SelectForceRunMacroActivity.EXTRA_IGNORE_CONSTRAINTS, this.m_ignoreConstraints);
            intent.putExtra(SelectForceRunMacroActivity.EXTRA_CATEGORY, this.m_category);
            intent.putExtra(SelectForceRunMacroActivity.EXTRA_HIDE_IF_OFF, this.m_useOffStatus);
            intent.putExtra("Title", replaceMagicText);
            intent.putExtra(Util.EXTRA_GUID, this.f2063b);
            if (this.m_waitToComplete) {
                intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, new ResumeMacroInfo(getMacro().getGUID(), i4, triggerContextInfo, false, stack, resumeMacroInfo, null));
            }
            try {
                getContext().startActivity(intent);
            } catch (Exception e4) {
                SystemLog.logError("Failed to run display macro selection dialog: " + e4.toString());
            }
        } else if (j4 == -1 && !this.getByName) {
            Macro macro = getMacro();
            if (macro != null && (this.m_ignoreConstraints || macro.canInvoke(null))) {
                macro.setTriggerThatInvoked(InvokedByRunMacroTrigger.getInstance());
                triggerContextInfo.setTrigger(InvokedByRunMacroTrigger.getInstance());
                macro.invokeActionsDontResetCount(triggerContextInfo, !this.m_useOffStatus);
            }
        } else {
            if (this.getByName) {
                macroByGUID = MacroStore.getInstance().getMacroByName(MagicText.replaceMagicText(getContext(), this.m_macroName, triggerContextInfo, getMacro()));
            } else {
                macroByGUID = MacroStore.getInstance().getMacroByGUID(this.m_GUID);
            }
            if (macroByGUID == null) {
                macroByGUID = MacroStore.getInstance().getMacroByName(this.m_macroName);
            }
            Macro macro2 = macroByGUID;
            if (macro2 != null) {
                if (!this.m_ignoreConstraints && !macro2.canInvoke(null)) {
                    if (this.m_waitToComplete) {
                        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, true, stack, resumeMacroInfo);
                    }
                } else {
                    macro2.setTriggerThatInvoked(InvokedByRunMacroTrigger.getInstance());
                    if (this.m_waitToComplete && !z4) {
                        macro2.invokeActions(triggerContextInfo, !this.m_useOffStatus, new ResumeMacroInfo(getMacro().getGUID(), i4, triggerContextInfo, z3, stack, resumeMacroInfo, null));
                    } else {
                        macro2.invokeActions(triggerContextInfo, !this.m_useOffStatus);
                    }
                }
            } else {
                SystemLog.logError("Could not find macro with name: " + this.m_macroName, getMacroGuid().longValue());
            }
        }
        if (this.m_waitToComplete || z4) {
            return;
        }
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
    }

    private ForceMacroRunAction() {
        this.isCategoryLocked = false;
        this.getByName = false;
        this.tempGetByName = false;
        this.m_ignoreConstraints = true;
        this.m_useOffStatus = false;
        this.m_GUID = 0L;
        this.m_userPromptTitle = SelectableItem.r(R.string.select_force_run_macro_activity_run_macro);
    }

    private ForceMacroRunAction(Parcel parcel) {
        super(parcel);
        this.isCategoryLocked = false;
        this.getByName = false;
        this.tempGetByName = false;
        this.m_macroName = parcel.readString();
        this.m_GUID = parcel.readLong();
        this.m_ignoreConstraints = parcel.readInt() != 0;
        this.m_useOffStatus = parcel.readInt() != 0;
        this.m_category = parcel.readString();
        this.m_userPromptTitle = parcel.readString();
        this.m_waitToComplete = parcel.readInt() != 0;
        this.isCategoryLocked = parcel.readInt() != 0;
        this.getByName = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements CategoryPasswordHelper.PasswordListener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            ForceMacroRunAction.this.isCategoryLocked = true;
            ForceMacroRunAction.this.b0();
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2245a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2246b;

        b(Button button, EditText editText) {
            this.f2245a = button;
            this.f2246b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2245a;
            if (this.f2246b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
