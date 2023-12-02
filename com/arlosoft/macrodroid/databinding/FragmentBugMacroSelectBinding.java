package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentBugMacroSelectBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11221a;
    @NonNull
    public final Button continueButton;
    @NonNull
    public final ListView macroList;
    @NonNull
    public final SearchView searchView;

    private FragmentBugMacroSelectBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull ListView listView, @NonNull SearchView searchView) {
        this.f11221a = linearLayout;
        this.continueButton = button;
        this.macroList = listView;
        this.searchView = searchView;
    }

    @NonNull
    public static FragmentBugMacroSelectBinding bind(@NonNull View view) {
        int i4 = R.id.continueButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.continueButton);
        if (button != null) {
            i4 = R.id.macro_list;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.macro_list);
            if (listView != null) {
                i4 = R.id.searchView;
                SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, R.id.searchView);
                if (searchView != null) {
                    return new FragmentBugMacroSelectBinding((LinearLayout) view, button, listView, searchView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentBugMacroSelectBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBugMacroSelectBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bug_macro_select, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11221a;
    }
}
