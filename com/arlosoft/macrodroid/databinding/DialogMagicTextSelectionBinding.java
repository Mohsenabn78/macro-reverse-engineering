package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogMagicTextSelectionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11095a;
    @NonNull
    public final ListView listView;
    @NonNull
    public final TextView multiTriggerWarning;
    @NonNull
    public final EditText searchText;

    private DialogMagicTextSelectionBinding(@NonNull LinearLayout linearLayout, @NonNull ListView listView, @NonNull TextView textView, @NonNull EditText editText) {
        this.f11095a = linearLayout;
        this.listView = listView;
        this.multiTriggerWarning = textView;
        this.searchText = editText;
    }

    @NonNull
    public static DialogMagicTextSelectionBinding bind(@NonNull View view) {
        int i4 = R.id.listView;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.listView);
        if (listView != null) {
            i4 = R.id.multiTriggerWarning;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.multiTriggerWarning);
            if (textView != null) {
                i4 = R.id.searchText;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.searchText);
                if (editText != null) {
                    return new DialogMagicTextSelectionBinding((LinearLayout) view, listView, textView, editText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogMagicTextSelectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogMagicTextSelectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_magic_text_selection, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11095a;
    }
}
