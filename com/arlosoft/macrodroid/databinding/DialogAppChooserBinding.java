package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
public final class DialogAppChooserBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11024a;
    @NonNull
    public final Button allAppsButton;
    @NonNull
    public final ListView applicationList;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final LinearLayout includeExcludeOptions;
    @NonNull
    public final CheckBox nonLaunchableCheckbox;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton radioExclude;
    @NonNull
    public final RadioButton radioInclude;
    @NonNull
    public final RadioGroup radioOptions;
    @NonNull
    public final SearchView searchView;

    private DialogAppChooserBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull ListView listView, @NonNull LinearLayout linearLayout2, @NonNull Button button2, @NonNull LinearLayout linearLayout3, @NonNull CheckBox checkBox, @NonNull Button button3, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioGroup radioGroup, @NonNull SearchView searchView) {
        this.f11024a = linearLayout;
        this.allAppsButton = button;
        this.applicationList = listView;
        this.buttonBar = linearLayout2;
        this.cancelButton = button2;
        this.includeExcludeOptions = linearLayout3;
        this.nonLaunchableCheckbox = checkBox;
        this.okButton = button3;
        this.radioExclude = radioButton;
        this.radioInclude = radioButton2;
        this.radioOptions = radioGroup;
        this.searchView = searchView;
    }

    @NonNull
    public static DialogAppChooserBinding bind(@NonNull View view) {
        int i4 = R.id.allAppsButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.allAppsButton);
        if (button != null) {
            i4 = R.id.application_list;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.application_list);
            if (listView != null) {
                i4 = R.id.button_bar;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                if (linearLayout != null) {
                    i4 = R.id.cancelButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                    if (button2 != null) {
                        i4 = R.id.include_exclude_options;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.include_exclude_options);
                        if (linearLayout2 != null) {
                            i4 = R.id.non_launchable_checkbox;
                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.non_launchable_checkbox);
                            if (checkBox != null) {
                                i4 = R.id.okButton;
                                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button3 != null) {
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
                                                    return new DialogAppChooserBinding((LinearLayout) view, button, listView, linearLayout, button2, linearLayout2, checkBox, button3, radioButton, radioButton2, radioGroup, searchView);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogAppChooserBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAppChooserBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_app_chooser, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11024a;
    }
}
