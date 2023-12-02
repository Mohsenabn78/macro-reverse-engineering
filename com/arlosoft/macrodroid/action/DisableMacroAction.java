package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.DisableMacroActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroEnabledStateChangeEvent;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DisableMacroAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<DisableMacroAction> CREATOR = new c();
    private static final long THIS_MACRO_GUID = 111;
    private boolean getByName;
    private long m_GUID;
    private final boolean m_enable;
    private transient List<Macro> m_macroList;
    private String m_macroName;
    private int m_state;
    private transient boolean tempGetByName;

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<DisableMacroAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DisableMacroAction createFromParcel(Parcel parcel) {
            return new DisableMacroAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DisableMacroAction[] newArray(int i4) {
            return new DisableMacroAction[i4];
        }
    }

    /* synthetic */ DisableMacroAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void T() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_enter_macro_name);
        appCompatDialog.setTitle(R.string.enter_macro_name);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.text);
        Button button = (Button) appCompatDialog.findViewById(R.id.magic_text_button);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.f5
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                DisableMacroAction.W(editText, magicTextPair);
            }
        };
        String str = this.m_macroName;
        if (str != null && !str.equals(U())) {
            editText.setText(this.m_macroName);
        }
        button2.setEnabled(!TextUtils.isEmpty(this.m_macroName));
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.g5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DisableMacroAction.this.X(editText, appCompatDialog, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.h5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.i5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DisableMacroAction.this.Z(magicTextListener, view);
            }
        });
        editText.addTextChangedListener(new a(button2, editText));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        appCompatDialog.show();
    }

    private static final String U() {
        return "[" + MacroDroidApplication.getInstance().getString(R.string.enter_macro_name) + "]";
    }

    private static final String V() {
        return MacroDroidApplication.getInstance().getString(R.string.constraint_last_run_time_this_macro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(EditText editText, AppCompatDialog appCompatDialog, View view) {
        this.m_macroName = editText.getText().toString();
        this.getByName = true;
        d0();
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(getActivity(), magicTextListener, getMacro(), false, true, false, R.style.Theme_App_Dialog_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i4) {
        this.getByName = this.tempGetByName;
        itemComplete();
    }

    private void c0(Cache cache, String str) {
        new CategoryPasswordHelper(cache, null).promptForCategoryPassword(getActivity(), SelectableItem.r(R.string.enter_category_lock_password), str, Settings.getLockedCategoryPassword(getActivity()), 0, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        int i4 = this.m_state;
        if (i4 == -1) {
            i4 = !this.m_enable ? 1 : 0;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setSingleChoiceItems(getOptions(), i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.d5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DisableMacroAction.this.a0(dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.e5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DisableMacroAction.this.b0(dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_disable_macro_enable), SelectableItem.r(R.string.action_disable_macro_disable), SelectableItem.r(R.string.action_disable_macro_toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.tempGetByName = false;
        int i5 = 1;
        if (i4 == 0) {
            this.tempGetByName = true;
        } else if (i4 == 1 && !this.m_macro.isActionBlock) {
            this.m_GUID = THIS_MACRO_GUID;
        } else if (this.m_macroList.size() == 0) {
            this.tempGetByName = true;
        } else {
            this.tempGetByName = false;
            if (!this.m_macro.isActionBlock) {
                i5 = 2;
            }
            int i6 = i4 - i5;
            this.m_GUID = this.m_macroList.get(i6).getGUID();
            this.m_macroName = this.m_macroList.get(i6).getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.tempGetByName) {
            return 0;
        }
        List<Macro> allCompletedMacrosSortedExcludingOne = MacroStore.getInstance().getAllCompletedMacrosSortedExcludingOne(getMacro(), true);
        this.m_macroList = allCompletedMacrosSortedExcludingOne;
        if (allCompletedMacrosSortedExcludingOne.size() == 0) {
            this.tempGetByName = true;
            return 0;
        } else if ((!this.m_macro.isActionBlock && this.m_GUID == THIS_MACRO_GUID) || this.m_GUID == getMacroGuid().longValue()) {
            return 1;
        } else {
            if (this.m_GUID != 0) {
                for (int i4 = 0; i4 < this.m_macroList.size(); i4++) {
                    if (this.m_GUID == this.m_macroList.get(i4).getGUID()) {
                        if (!this.m_macro.isActionBlock) {
                            return i4 + 2;
                        }
                        return i4 + 1;
                    }
                }
            }
            C(1);
            return 1;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        Context context;
        int i4;
        if (this.m_state == -1) {
            if (this.m_enable) {
                context = getContext();
                i4 = R.string.action_disable_macro_enable;
            } else {
                context = getContext();
                i4 = R.string.action_disable_macro_disable;
            }
            return context.getString(i4);
        }
        return getOptions()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_GUID == THIS_MACRO_GUID) {
            return V();
        }
        return this.m_macroName;
    }

    public long getGUID() {
        return this.m_GUID;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DisableMacroActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getMacroName() {
        return this.m_macroName;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_macroName};
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Macro macroByGUID;
        if (this.getByName) {
            macroByGUID = MacroStore.getInstance().getMacroByName(MagicText.replaceMagicText(getContext(), this.m_macroName, triggerContextInfo, getMacro()));
        } else if (this.m_GUID == THIS_MACRO_GUID) {
            macroByGUID = getMacro();
        } else {
            macroByGUID = MacroStore.getInstance().getMacroByGUID(this.m_GUID);
        }
        if (macroByGUID != null) {
            boolean z3 = this.m_enable;
            int i4 = this.m_state;
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 == 2) {
                            z3 = !macroByGUID.isEnabled();
                        }
                    } else {
                        z3 = false;
                    }
                } else {
                    z3 = true;
                }
            }
            if (z3 && !macroByGUID.isEnabled()) {
                MacroStore.getInstance().enableMacroAndUpdate(macroByGUID, true);
                EventBusUtils.getEventBus().post(new MacroEnabledStateChangeEvent(macroByGUID, true));
                return;
            } else if (!z3 && macroByGUID.isEnabled()) {
                MacroStore.getInstance().disableMacroAndUpdate(macroByGUID, true);
                EventBusUtils.getEventBus().post(new MacroEnabledStateChangeEvent(macroByGUID, false));
                return;
            } else {
                return;
            }
        }
        SystemLog.logError("Enable/Disable macro failed: " + this.m_macroName + " with id " + this.m_GUID + " not found", getMacroGuid().longValue());
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (this.m_GUID != getMacroGuid().longValue()) {
            long j4 = this.m_GUID;
            if (j4 != THIS_MACRO_GUID && j4 != getMacroGuid().longValue()) {
                if (this.getByName && this.m_macroName != null) {
                    return true;
                }
                Iterator<Macro> it = MacroStore.getInstance().getAllCompletedMacrosIncludingExtras().iterator();
                while (it.hasNext()) {
                    if (it.next().getGUID() == this.m_GUID) {
                        return true;
                    }
                }
                String str = this.m_macroName;
                if (str != null && str.equals(V())) {
                    this.m_macroName = V();
                    this.m_GUID = THIS_MACRO_GUID;
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        int i4;
        String name;
        this.tempGetByName = this.getByName;
        int i5 = 1;
        List<Macro> allCompletedMacrosSortedExcludingOne = MacroStore.getInstance().getAllCompletedMacrosSortedExcludingOne(getMacro(), true);
        this.m_macroList = allCompletedMacrosSortedExcludingOne;
        int size = allCompletedMacrosSortedExcludingOne.size();
        if (!this.m_macro.isActionBlock) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        String[] strArr = new String[size + i4];
        strArr[0] = U();
        if (!this.m_macro.isActionBlock) {
            strArr[1] = V();
            i5 = 2;
        }
        for (int i6 = 0; i6 < this.m_macroList.size(); i6++) {
            int i7 = i6 + i5;
            if (this.m_macroList.get(i6).getIsFavourite()) {
                name = "⭐ " + this.m_macroList.get(i6).getName();
            } else {
                name = this.m_macroList.get(i6).getName();
            }
            strArr[i7] = name;
        }
        if (this.m_macroList.size() > 0 && this.m_GUID == 0) {
            this.m_GUID = THIS_MACRO_GUID;
            this.m_macroName = V();
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.action_disable_macro);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Macro macroByGUID;
        Category categoryByName;
        if (this.tempGetByName) {
            T();
            return;
        }
        this.tempGetByName = false;
        if (this.m_GUID == THIS_MACRO_GUID) {
            macroByGUID = getMacro();
        } else {
            macroByGUID = MacroStore.getInstance().getMacroByGUID(this.m_GUID);
        }
        if (macroByGUID != null) {
            Cache cache = MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE);
            CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
            if (categoryList != null && (categoryByName = categoryList.getCategoryByName(macroByGUID.getCategory())) != null && categoryByName.isLocked()) {
                c0(cache, macroByGUID.getCategory());
                return;
            }
        }
        d0();
    }

    public void setMacroName(String str) {
        this.m_macroName = str;
    }

    public void setName(String str) {
        this.m_macroName = str;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_macroName = strArr[0];
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void templateSelected() {
        if (!isValid() && this.m_macroName.equals(getMacro().getName())) {
            this.m_GUID = getMacro().getGUID();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_macroName);
        parcel.writeLong(this.m_GUID);
        parcel.writeInt(!this.m_enable ? 1 : 0);
        parcel.writeInt(this.m_state);
        parcel.writeInt(this.getByName ? 1 : 0);
    }

    public DisableMacroAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DisableMacroAction() {
        this.getByName = false;
        this.tempGetByName = false;
        this.m_enable = true;
        this.m_state = -1;
    }

    private DisableMacroAction(Parcel parcel) {
        super(parcel);
        this.getByName = false;
        this.tempGetByName = false;
        this.m_macroName = parcel.readString();
        this.m_GUID = parcel.readLong();
        this.m_enable = parcel.readInt() == 0;
        this.m_state = parcel.readInt();
        this.getByName = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements CategoryPasswordHelper.PasswordListener {
        b() {
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            DisableMacroAction.this.d0();
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2169a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2170b;

        a(Button button, EditText editText) {
            this.f2169a = button;
            this.f2170b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2169a;
            if (this.f2170b.getText().length() > 0) {
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
