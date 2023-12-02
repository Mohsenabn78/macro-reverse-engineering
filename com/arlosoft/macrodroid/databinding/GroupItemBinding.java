package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.SwitchPlus;

/* loaded from: classes3.dex */
public final class GroupItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11244a;
    @NonNull
    public final LinearLayout categoryContainer;
    @NonNull
    public final View dividerBottom;
    @NonNull
    public final LinearLayout groupCickableArea;
    @NonNull
    public final SwitchPlus groupOnOffButton;
    @NonNull
    public final TextView groupTitle;
    @NonNull
    public final ImageView lockImage;

    private GroupItemBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull View view, @NonNull LinearLayout linearLayout3, @NonNull SwitchPlus switchPlus, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.f11244a = linearLayout;
        this.categoryContainer = linearLayout2;
        this.dividerBottom = view;
        this.groupCickableArea = linearLayout3;
        this.groupOnOffButton = switchPlus;
        this.groupTitle = textView;
        this.lockImage = imageView;
    }

    @NonNull
    public static GroupItemBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i4 = R.id.divider_bottom;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.divider_bottom);
        if (findChildViewById != null) {
            i4 = R.id.group_cickable_area;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.group_cickable_area);
            if (linearLayout2 != null) {
                i4 = R.id.group_on_off_button;
                SwitchPlus switchPlus = (SwitchPlus) ViewBindings.findChildViewById(view, R.id.group_on_off_button);
                if (switchPlus != null) {
                    i4 = R.id.group_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.group_title);
                    if (textView != null) {
                        i4 = R.id.lockImage;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.lockImage);
                        if (imageView != null) {
                            return new GroupItemBinding(linearLayout, linearLayout, findChildViewById, linearLayout2, switchPlus, textView, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static GroupItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static GroupItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.group_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11244a;
    }
}
