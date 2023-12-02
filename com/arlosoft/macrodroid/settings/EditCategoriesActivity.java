package com.arlosoft.macrodroid.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class EditCategoriesActivity extends MacroDroidDaggerBaseActivity implements CategoryPasswordHelper.CategoriesUpdatedListener {

    /* renamed from: f  reason: collision with root package name */
    private List<String> f13394f;

    /* renamed from: g  reason: collision with root package name */
    private CategoryList f13395g;

    /* renamed from: h  reason: collision with root package name */
    private CategoryPasswordHelper f13396h;

    /* renamed from: i  reason: collision with root package name */
    private ListView f13397i;
    @BindView(R.id.infoCardDetail)
    TextView infoCardDetail;
    @BindView(R.id.infoCardGotIt)
    Button infoCardGotIt;
    @BindView(R.id.infoCardTitle)
    TextView infoCardTitle;
    @BindView(R.id.infoCardView)
    CardView infoCardView;

    /* renamed from: j  reason: collision with root package name */
    private Cache f13398j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    CategoriesHelper f13399k;
    @BindView(R.id.fab)
    FloatingActionButton plusButton;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends ArrayAdapter<String> {
        a(Context context, int i4, String[] strArr) {
            super(context, i4, strArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) EditCategoriesActivity.this.getSystemService("layout_inflater")).inflate(R.layout.list_item_category, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.lockImage);
            ((TextView) view.findViewById(R.id.categoryName)).setText((String) getItem(i4));
            EditCategoriesActivity editCategoriesActivity = EditCategoriesActivity.this;
            if (editCategoriesActivity.C((String) editCategoriesActivity.f13394f.get(i4 + 1))) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i4) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this);
        appCompatDialog.setContentView(R.layout.mode_name_dialog);
        appCompatDialog.setTitle(R.string.rename_category);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.mode_name_dialog_mode_name);
        editText.setHint(R.string.enter_category_name);
        final String str = this.f13394f.get(i4);
        editText.setText(str);
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditCategoriesActivity.this.G(editText, str, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final int i4, boolean z3) {
        if (i4 >= this.f13394f.size()) {
            return;
        }
        final String str = this.f13394f.get(i4);
        final ArrayList arrayList = new ArrayList();
        Iterator<Macro> it = MacroStore.getInstance().getAllCompletedMacros().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Macro next = it.next();
            if (next.getCategory().equals(str)) {
                arrayList.add(next);
                break;
            }
        }
        if (arrayList.size() > 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.delete_category);
            builder.setMessage(R.string.are_you_sure_delete_category);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    EditCategoriesActivity.this.I(str, i4, arrayList, dialogInterface, i5);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.show();
        } else {
            this.f13394f.remove(i4);
            Settings.setCategories(this, this.f13394f);
            M();
        }
        CategoryList categoryList = this.f13396h.getCategoryList();
        categoryList.deleteCategory(str);
        this.f13398j.put(Category.CATEGORIES_KEY, categoryList);
        if (z3) {
            this.f13396h.deletePasswordLockIfRequired(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(String str) {
        Category categoryByName = this.f13395g.getCategoryByName(str);
        if (categoryByName != null && categoryByName.isLocked()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        Settings.hideInfoCardCategories(getApplicationContext());
        this.infoCardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(AppCompatDialog appCompatDialog, EditText editText, View view) {
        appCompatDialog.cancel();
        this.f13394f.add(editText.getText().toString());
        Settings.setCategories(this, this.f13394f);
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(EditText editText, String str, AppCompatDialog appCompatDialog, View view) {
        this.f13399k.renameCategory(this, str, editText.getText().toString());
        appCompatDialog.dismiss();
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str, int i4, List list, DialogInterface dialogInterface, int i5) {
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            if (macro.getCategory().equals(str)) {
                macro.setCategory(this.f13394f.get(0));
            }
        }
        dialogInterface.dismiss();
        this.f13394f.remove(i4);
        Settings.setCategories(this, this.f13394f);
        M();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Macro macro2 = (Macro) it.next();
            macro2.setCategory(getString(R.string.uncategorized));
            MacroStore.getInstance().updateMacro(macro2, false);
        }
        MacroStore.getInstance().writeToJSON();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(AdapterView adapterView, View view, int i4, long j4) {
        L(i4 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(boolean z3, String str, int i4, DialogInterface dialogInterface, int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    if (z3) {
                        this.f13396h.removeCategoryLock(this, str);
                    } else {
                        this.f13396h.lockCategory(this, str);
                    }
                }
            } else if (z3) {
                this.f13396h.promptForCategoryPassword(this, getString(R.string.delete_category), str, Settings.getLockedCategoryPassword(this), 0, new e(i4));
            } else {
                B(i4, false);
            }
        } else if (z3) {
            this.f13396h.promptForCategoryPassword(this, getString(R.string.rename_category), str, Settings.getLockedCategoryPassword(this), 0, new d(i4));
        } else {
            A(i4);
        }
    }

    private void L(final int i4) {
        int i5;
        final String str = this.f13394f.get(i4);
        final boolean C = C(str);
        String[] strArr = new String[3];
        strArr[0] = getString(R.string.rename_category);
        strArr[1] = getString(R.string.delete_category);
        if (C) {
            i5 = R.string.remove_category_lock;
        } else {
            i5 = R.string.lock_category;
        }
        strArr[2] = getString(i5);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(this.f13394f.get(i4)).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                EditCategoriesActivity.this.K(C, str, i4, dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void M() {
        refresh();
    }

    private void refresh() {
        int i4;
        int i5;
        HashMap hashMap = new HashMap();
        Iterator<Macro> it = MacroStore.getInstance().getAllCompletedMacrosSorted(false).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String category = it.next().getCategory();
            if (category == null) {
                category = getString(R.string.uncategorized);
            }
            Integer num = (Integer) hashMap.get(category);
            if (num != null) {
                hashMap.put(category, Integer.valueOf(num.intValue() + 1));
            } else {
                hashMap.put(category, 1);
            }
        }
        CategoryList categoryList = (CategoryList) this.f13398j.get(Category.CATEGORIES_KEY, CategoryList.class);
        this.f13395g = categoryList;
        if (categoryList == null) {
            this.f13395g = new CategoryList(new ArrayList());
        }
        List<String> categories = Util.getCategories(this);
        this.f13394f = categories;
        String[] strArr = new String[categories.size() - 1];
        for (i4 = 1; i4 < this.f13394f.size(); i4++) {
            Integer num2 = (Integer) hashMap.get(this.f13394f.get(i4));
            int i6 = i4 - 1;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f13394f.get(i4));
            sb.append(" (");
            if (num2 != null) {
                i5 = num2.intValue();
            } else {
                i5 = 0;
            }
            sb.append(i5);
            sb.append(")");
            strArr[i6] = sb.toString();
        }
        this.f13394f.toArray(strArr);
        a aVar = new a(this, R.layout.list_item_category, strArr);
        this.f13397i.setDivider(null);
        this.f13397i.setAdapter((ListAdapter) aVar);
        this.f13397i.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.arlosoft.macrodroid.settings.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i7, long j4) {
                EditCategoriesActivity.this.J(adapterView, view, i7, j4);
            }
        });
    }

    private void y() {
        if (Settings.shouldHideInfoCardCategories(this)) {
            this.infoCardView.setVisibility(8);
            return;
        }
        this.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.categories_primary));
        this.infoCardTitle.setText(R.string.categories);
        this.infoCardDetail.setText(R.string.categories_info_card_help);
        this.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditCategoriesActivity.this.D(view);
            }
        });
    }

    private void z() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this);
        appCompatDialog.setContentView(R.layout.mode_name_dialog);
        appCompatDialog.setTitle(R.string.add_category);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.mode_name_dialog_mode_name);
        editText.setHint(R.string.enter_category_name);
        editText.addTextChangedListener(new c(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditCategoriesActivity.this.E(appCompatDialog, editText, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
        ViewExtensionsKt.focusAndShowKeyboard(editText);
    }

    @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.CategoriesUpdatedListener
    public void categoriesUpdated() {
        refresh();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_categories);
        ButterKnife.bind(this);
        setTitle(R.string.categories);
        this.f13397i = (ListView) findViewById(R.id.edit_categories_list);
        Cache cache = MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE);
        this.f13398j = cache;
        this.f13396h = new CategoryPasswordHelper(cache, this);
        refresh();
        ViewCompat.setNestedScrollingEnabled(this.f13397i, true);
        y();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.fab})
    public void onPlusButtonClicked() {
        z();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements CategoryPasswordHelper.PasswordListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f13407a;

        d(int i4) {
            this.f13407a = i4;
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            EditCategoriesActivity.this.A(this.f13407a);
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements CategoryPasswordHelper.PasswordListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f13409a;

        e(int i4) {
            this.f13409a = i4;
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            EditCategoriesActivity.this.B(this.f13409a, true);
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f13401a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f13402b;

        b(Button button, EditText editText) {
            this.f13401a = button;
            this.f13402b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f13401a;
            if (this.f13402b.getText().length() > 0) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f13404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f13405b;

        c(Button button, EditText editText) {
            this.f13404a = button;
            this.f13405b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f13404a;
            if (this.f13405b.getText().length() > 0) {
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
