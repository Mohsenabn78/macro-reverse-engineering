package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public final class ContactListItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11010a;
    @NonNull
    public final CheckBox checkbox;
    @NonNull
    public final AvatarView contactAvatar;
    @NonNull
    public final TextView contactName;
    @NonNull
    public final ViewFlipper imageViewFlipper;
    @NonNull
    public final ImageView standardImage;

    private ContactListItemBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull AvatarView avatarView, @NonNull TextView textView, @NonNull ViewFlipper viewFlipper, @NonNull ImageView imageView) {
        this.f11010a = linearLayout;
        this.checkbox = checkBox;
        this.contactAvatar = avatarView;
        this.contactName = textView;
        this.imageViewFlipper = viewFlipper;
        this.standardImage = imageView;
    }

    @NonNull
    public static ContactListItemBinding bind(@NonNull View view) {
        int i4 = R.id.checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.checkbox);
        if (checkBox != null) {
            i4 = R.id.contactAvatar;
            AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.contactAvatar);
            if (avatarView != null) {
                i4 = R.id.contact_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.contact_name);
                if (textView != null) {
                    i4 = R.id.imageViewFlipper;
                    ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.imageViewFlipper);
                    if (viewFlipper != null) {
                        i4 = R.id.standardImage;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.standardImage);
                        if (imageView != null) {
                            return new ContactListItemBinding((LinearLayout) view, checkBox, avatarView, textView, viewFlipper, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ContactListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ContactListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.contact_list_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11010a;
    }
}
