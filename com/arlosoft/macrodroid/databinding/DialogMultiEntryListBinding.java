package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class DialogMultiEntryListBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f11100a;
    @NonNull
    public final FloatingActionButton addEntryButton;
    @NonNull
    public final TextView arrayType;
    @NonNull
    public final ImageButton backButton;
    @NonNull
    public final ImageButton clearButton;
    @NonNull
    public final ImageButton clearSearchButton;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final ImageButton deleteButton;
    @NonNull
    public final TextView emptyView;
    @NonNull
    public final RecyclerView entriesRecyclerView;
    @NonNull
    public final ImageButton searchButton;
    @NonNull
    public final LinearLayout searchContainer;
    @NonNull
    public final EditText searchText;
    @NonNull
    public final TextView varName;

    private DialogMultiEntryListBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull TextView textView, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ImageButton imageButton4, @NonNull TextView textView2, @NonNull RecyclerView recyclerView, @NonNull ImageButton imageButton5, @NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull TextView textView3) {
        this.f11100a = coordinatorLayout;
        this.addEntryButton = floatingActionButton;
        this.arrayType = textView;
        this.backButton = imageButton;
        this.clearButton = imageButton2;
        this.clearSearchButton = imageButton3;
        this.coordinatorLayout = coordinatorLayout2;
        this.deleteButton = imageButton4;
        this.emptyView = textView2;
        this.entriesRecyclerView = recyclerView;
        this.searchButton = imageButton5;
        this.searchContainer = linearLayout;
        this.searchText = editText;
        this.varName = textView3;
    }

    @NonNull
    public static DialogMultiEntryListBinding bind(@NonNull View view) {
        int i4 = R.id.addEntryButton;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.addEntryButton);
        if (floatingActionButton != null) {
            i4 = R.id.arrayType;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.arrayType);
            if (textView != null) {
                i4 = R.id.backButton;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.backButton);
                if (imageButton != null) {
                    i4 = R.id.clearButton;
                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.clearButton);
                    if (imageButton2 != null) {
                        i4 = R.id.clearSearchButton;
                        ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.clearSearchButton);
                        if (imageButton3 != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                            i4 = R.id.deleteButton;
                            ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, R.id.deleteButton);
                            if (imageButton4 != null) {
                                i4 = R.id.emptyView;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.emptyView);
                                if (textView2 != null) {
                                    i4 = R.id.entriesRecyclerView;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.entriesRecyclerView);
                                    if (recyclerView != null) {
                                        i4 = R.id.searchButton;
                                        ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view, R.id.searchButton);
                                        if (imageButton5 != null) {
                                            i4 = R.id.searchContainer;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.searchContainer);
                                            if (linearLayout != null) {
                                                i4 = R.id.searchText;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.searchText);
                                                if (editText != null) {
                                                    i4 = R.id.varName;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.varName);
                                                    if (textView3 != null) {
                                                        return new DialogMultiEntryListBinding(coordinatorLayout, floatingActionButton, textView, imageButton, imageButton2, imageButton3, coordinatorLayout, imageButton4, textView2, recyclerView, imageButton5, linearLayout, editText, textView3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogMultiEntryListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogMultiEntryListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_multi_entry_list, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f11100a;
    }
}
