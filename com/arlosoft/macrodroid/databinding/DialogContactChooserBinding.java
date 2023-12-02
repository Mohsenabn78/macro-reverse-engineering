package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogContactChooserBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11042a;
    @NonNull
    public final ListView contactsList;
    @NonNull
    public final LinearLayout includeExcludeOptions;
    @NonNull
    public final RadioButton radioExclude;
    @NonNull
    public final RadioButton radioInclude;
    @NonNull
    public final RadioGroup radioOptions;
    @NonNull
    public final SearchView searchView;

    private DialogContactChooserBinding(@NonNull LinearLayout linearLayout, @NonNull ListView listView, @NonNull LinearLayout linearLayout2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioGroup radioGroup, @NonNull SearchView searchView) {
        this.f11042a = linearLayout;
        this.contactsList = listView;
        this.includeExcludeOptions = linearLayout2;
        this.radioExclude = radioButton;
        this.radioInclude = radioButton2;
        this.radioOptions = radioGroup;
        this.searchView = searchView;
    }

    @NonNull
    public static DialogContactChooserBinding bind(@NonNull View view) {
        int i4 = R.id.contacts_list;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.contacts_list);
        if (listView != null) {
            i4 = R.id.include_exclude_options;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.include_exclude_options);
            if (linearLayout != null) {
                i4 = R.id.radio_exclude;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_exclude);
                if (radioButton != null) {
                    i4 = R.id.radio_include;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_include);
                    if (radioButton2 != null) {
                        i4 = R.id.radio_options;
                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.radio_options);
                        if (radioGroup != null) {
                            i4 = R.id.searchView;
                            SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, R.id.searchView);
                            if (searchView != null) {
                                return new DialogContactChooserBinding((LinearLayout) view, listView, linearLayout, radioButton, radioButton2, radioGroup, searchView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogContactChooserBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogContactChooserBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_contact_chooser, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11042a;
    }
}
