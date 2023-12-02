package com.arlosoft.macrodroid.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.SerialCalculator;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import java.util.ArrayList;
import java.util.Iterator;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class CategoryPasswordHelper {

    /* renamed from: a  reason: collision with root package name */
    private Cache f16009a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private CategoriesUpdatedListener f16010b;

    /* loaded from: classes3.dex */
    public interface CategoriesUpdatedListener {
        void categoriesUpdated();
    }

    /* loaded from: classes3.dex */
    public interface PasswordListener {
        void passwordCancelled();

        void passwordCorrect();
    }

    public CategoryPasswordHelper(Cache cache, @Nullable CategoriesUpdatedListener categoriesUpdatedListener) {
        this.f16009a = cache;
        this.f16010b = categoriesUpdatedListener;
    }

    private String j(String str) {
        return SerialCalculator.calculateSerialCode(str, 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(EditText editText, Activity activity, String str, String str2, Dialog dialog, View view) {
        String obj = editText.getText().toString();
        if (obj.length() < 3) {
            ToastCompat.makeText(activity, (int) R.string.invalid_password, 1).show();
        } else if (str == null) {
            promptForCategoryPassword(activity, activity.getString(R.string.confirm_password), str2, j(obj), 0, new a(activity, str2, obj));
            dialog.dismiss();
        } else if (j(editText.getText().toString()).equals(str)) {
            r(activity, str2, obj);
            CategoriesUpdatedListener categoriesUpdatedListener = this.f16010b;
            if (categoriesUpdatedListener != null) {
                categoriesUpdatedListener.categoriesUpdated();
            }
            dialog.dismiss();
        } else {
            ToastCompat.makeText(activity, (int) R.string.invalid_password, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(EditText editText, String str, PasswordListener passwordListener, Dialog dialog, Activity activity, View view) {
        if (j(editText.getText().toString()).equals(str)) {
            passwordListener.passwordCorrect();
            dialog.dismiss();
            return;
        }
        ToastCompat.makeText(activity, (int) R.string.invalid_password, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(EditText editText, Activity activity, Dialog dialog, String str, View view) {
        if (j(editText.getText().toString()).equals(Settings.getLockedCategoryPassword(activity))) {
            dialog.dismiss();
            r(activity, str, null);
            CategoriesUpdatedListener categoriesUpdatedListener = this.f16010b;
            if (categoriesUpdatedListener != null) {
                categoriesUpdatedListener.categoriesUpdated();
                return;
            }
            return;
        }
        ToastCompat.makeText(activity, (int) R.string.invalid_password, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(@NonNull Activity activity, @NonNull String str, @Nullable String str2) {
        String j4;
        CategoryList categoryList = getCategoryList();
        Category categoryByName = categoryList.getCategoryByName(str);
        if (str2 == null) {
            j4 = null;
        } else {
            j4 = j(str2);
        }
        if (str2 != null) {
            Settings.setLockedCategoryPassword(activity, j4);
        }
        if (categoryByName != null) {
            categoryList.getCategories().remove(categoryByName);
            if (str2 != null) {
                categoryList.getCategories().add(new Category(categoryByName.getName(), categoryByName.getColor(), categoryByName.isExpanded(), true));
            } else {
                categoryList.getCategories().add(new Category(str, categoryByName.getColor(), categoryByName.isExpanded(), false));
            }
        } else {
            categoryList.getCategories().add(new Category(str, ContextCompat.getColor(activity, R.color.default_macro_tile_color), false, true));
        }
        this.f16009a.put(Category.CATEGORIES_KEY, categoryList);
        if (str2 == null) {
            deletePasswordLockIfRequired(activity);
        }
    }

    public void deletePasswordLockIfRequired(Context context) {
        boolean z3;
        Iterator<Category> it = getCategoryList().getCategories().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().isLocked()) {
                    z3 = true;
                    break;
                }
            } else {
                z3 = false;
                break;
            }
        }
        if (!z3) {
            Settings.setLockedCategoryPassword(context, null);
        }
    }

    public CategoryList getCategoryList() {
        CategoryList categoryList = (CategoryList) this.f16009a.get(Category.CATEGORIES_KEY, CategoryList.class);
        if (categoryList == null || categoryList.getCategories() == null) {
            return new CategoryList(new ArrayList());
        }
        return categoryList;
    }

    public void lockCategory(@NonNull final Activity activity, @NonNull final String str) {
        int i4;
        final String lockedCategoryPassword = Settings.getLockedCategoryPassword(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_lock_category, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.passwordEntry);
        Button button = (Button) inflate.findViewById(R.id.lockCateogryButton);
        Button button2 = (Button) inflate.findViewById(R.id.cancelButton);
        TextView textView = (TextView) inflate.findViewById(R.id.lockCategoryInfo);
        if (lockedCategoryPassword != null) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        textView.setVisibility(i4);
        builder.setTitle(R.string.lock_category);
        builder.setView(inflate);
        final AlertDialog create = builder.create();
        create.getWindow().clearFlags(131080);
        create.getWindow().setSoftInputMode(5);
        create.show();
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryPasswordHelper.this.k(editText, activity, lockedCategoryPassword, str, create, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                create.dismiss();
            }
        });
        editText.requestFocus();
    }

    public void promptForCategoryPassword(@NonNull final Activity activity, @NonNull String str, @NonNull String str2, final String str3, @Nullable int i4, final PasswordListener passwordListener) {
        View inflate;
        AlertDialog.Builder builder;
        if (i4 > 0) {
            inflate = LayoutInflater.from(new ContextThemeWrapper(activity, i4)).inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
            builder = new AlertDialog.Builder(activity, i4);
        } else {
            inflate = activity.getLayoutInflater().inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
            builder = new AlertDialog.Builder(activity);
        }
        final EditText editText = (EditText) inflate.findViewById(R.id.passwordEntry);
        Button button = (Button) inflate.findViewById(R.id.okButton);
        Button button2 = (Button) inflate.findViewById(R.id.cancelButton);
        builder.setTitle(str);
        builder.setView(inflate);
        final AlertDialog create = builder.create();
        create.getWindow().clearFlags(131080);
        create.getWindow().setSoftInputMode(5);
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.utils.g
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                CategoryPasswordHelper.PasswordListener.this.passwordCancelled();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryPasswordHelper.this.n(editText, str3, passwordListener, create, activity, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                create.cancel();
            }
        });
        editText.requestFocus();
    }

    public void removeCategoryLock(@NonNull final Activity activity, @NonNull final String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.passwordEntry);
        Button button = (Button) inflate.findViewById(R.id.okButton);
        builder.setTitle(R.string.remove_category_lock);
        builder.setView(inflate);
        final AlertDialog create = builder.create();
        create.getWindow().clearFlags(131080);
        create.getWindow().setSoftInputMode(5);
        create.show();
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryPasswordHelper.this.p(editText, activity, create, str, view);
            }
        });
        ((Button) inflate.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                create.dismiss();
            }
        });
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements PasswordListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f16011a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16012b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f16013c;

        a(Activity activity, String str, String str2) {
            this.f16011a = activity;
            this.f16012b = str;
            this.f16013c = str2;
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            CategoryPasswordHelper.this.r(this.f16011a, this.f16012b, this.f16013c);
            if (CategoryPasswordHelper.this.f16010b != null) {
                CategoryPasswordHelper.this.f16010b.categoriesUpdated();
            }
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }
}
