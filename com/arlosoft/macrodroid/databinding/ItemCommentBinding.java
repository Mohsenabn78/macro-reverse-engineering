package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public final class ItemCommentBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11277a;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final LinearLayout chatLine;
    @NonNull
    public final LinearLayout commentContainer;
    @NonNull
    public final TextView date;
    @NonNull
    public final LinearLayout dateLayout;
    @NonNull
    public final TextView editButton;
    @NonNull
    public final TextView editedDate;
    @NonNull
    public final ImageView expandButton;
    @NonNull
    public final LinearLayout expandContainer;
    @NonNull
    public final TextView text;
    @NonNull
    public final TextView usernameEdit;

    private ItemCommentBinding(@NonNull LinearLayout linearLayout, @NonNull AvatarView avatarView, @NonNull CardView cardView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull LinearLayout linearLayout4, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout5, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f11277a = linearLayout;
        this.avatarImage = avatarView;
        this.cardView = cardView;
        this.chatLine = linearLayout2;
        this.commentContainer = linearLayout3;
        this.date = textView;
        this.dateLayout = linearLayout4;
        this.editButton = textView2;
        this.editedDate = textView3;
        this.expandButton = imageView;
        this.expandContainer = linearLayout5;
        this.text = textView4;
        this.usernameEdit = textView5;
    }

    @NonNull
    public static ItemCommentBinding bind(@NonNull View view) {
        int i4 = R.id.avatarImage;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
        if (avatarView != null) {
            i4 = R.id.cardView;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.cardView);
            if (cardView != null) {
                i4 = R.id.chatLine;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.chatLine);
                if (linearLayout != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view;
                    i4 = R.id.date;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.date);
                    if (textView != null) {
                        i4 = R.id.dateLayout;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.dateLayout);
                        if (linearLayout3 != null) {
                            i4 = R.id.editButton;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.editButton);
                            if (textView2 != null) {
                                i4 = R.id.editedDate;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.editedDate);
                                if (textView3 != null) {
                                    i4 = R.id.expandButton;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.expandButton);
                                    if (imageView != null) {
                                        i4 = R.id.expandContainer;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.expandContainer);
                                        if (linearLayout4 != null) {
                                            i4 = R.id.text;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.text);
                                            if (textView4 != null) {
                                                i4 = R.id.usernameEdit;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.usernameEdit);
                                                if (textView5 != null) {
                                                    return new ItemCommentBinding(linearLayout2, avatarView, cardView, linearLayout, linearLayout2, textView, linearLayout3, textView2, textView3, imageView, linearLayout4, textView4, textView5);
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
    public static ItemCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.item_comment, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11277a;
    }
}
