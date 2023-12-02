package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class EditModesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11195a;
    @NonNull
    public final ListView editModesList;
    @NonNull
    public final TextView editModesNoEntries;
    @NonNull
    public final FloatingActionButton fab;

    private EditModesBinding(@NonNull FrameLayout frameLayout, @NonNull ListView listView, @NonNull TextView textView, @NonNull FloatingActionButton floatingActionButton) {
        this.f11195a = frameLayout;
        this.editModesList = listView;
        this.editModesNoEntries = textView;
        this.fab = floatingActionButton;
    }

    @NonNull
    public static EditModesBinding bind(@NonNull View view) {
        int i4 = R.id.edit_modes_list;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.edit_modes_list);
        if (listView != null) {
            i4 = R.id.edit_modes_no_entries;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.edit_modes_no_entries);
            if (textView != null) {
                i4 = R.id.fab;
                FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.fab);
                if (floatingActionButton != null) {
                    return new EditModesBinding((FrameLayout) view, listView, textView, floatingActionButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EditModesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EditModesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.edit_modes, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11195a;
    }
}
