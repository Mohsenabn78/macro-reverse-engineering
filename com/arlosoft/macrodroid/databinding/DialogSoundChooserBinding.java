package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogSoundChooserBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11132a;
    @NonNull
    public final Spinner audioStream;
    @NonNull
    public final ListView soundList;
    @NonNull
    public final CheckBox waitToCompleteCheckbox;

    private DialogSoundChooserBinding(@NonNull LinearLayout linearLayout, @NonNull Spinner spinner, @NonNull ListView listView, @NonNull CheckBox checkBox) {
        this.f11132a = linearLayout;
        this.audioStream = spinner;
        this.soundList = listView;
        this.waitToCompleteCheckbox = checkBox;
    }

    @NonNull
    public static DialogSoundChooserBinding bind(@NonNull View view) {
        int i4 = R.id.audio_stream;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.audio_stream);
        if (spinner != null) {
            i4 = R.id.sound_list;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.sound_list);
            if (listView != null) {
                i4 = R.id.wait_to_complete_checkbox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.wait_to_complete_checkbox);
                if (checkBox != null) {
                    return new DialogSoundChooserBinding((LinearLayout) view, spinner, listView, checkBox);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogSoundChooserBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSoundChooserBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sound_chooser, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11132a;
    }
}
