package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SwipeDescriptionOverlayBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f11381a;
    @NonNull
    public final ImageView swipeDescriptionOverlayLeftArrow;
    @NonNull
    public final ImageView swipeDescriptionOverlayLeftDiagonalArrow;
    @NonNull
    public final ImageView swipeDescriptionOverlayLeftDownArrow;
    @NonNull
    public final ImageView swipeDescriptionOverlayRightArrow;
    @NonNull
    public final ImageView swipeDescriptionOverlayRightDiagonalArrow;
    @NonNull
    public final ImageView swipeDescriptionOverlayRightDownArrow;
    @NonNull
    public final View swipeDescriptionOverlayTouchAreaTopLeft;
    @NonNull
    public final View swipeDescriptionOverlayTouchAreaTopRight;

    private SwipeDescriptionOverlayBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull View view, @NonNull View view2) {
        this.f11381a = relativeLayout;
        this.swipeDescriptionOverlayLeftArrow = imageView;
        this.swipeDescriptionOverlayLeftDiagonalArrow = imageView2;
        this.swipeDescriptionOverlayLeftDownArrow = imageView3;
        this.swipeDescriptionOverlayRightArrow = imageView4;
        this.swipeDescriptionOverlayRightDiagonalArrow = imageView5;
        this.swipeDescriptionOverlayRightDownArrow = imageView6;
        this.swipeDescriptionOverlayTouchAreaTopLeft = view;
        this.swipeDescriptionOverlayTouchAreaTopRight = view2;
    }

    @NonNull
    public static SwipeDescriptionOverlayBinding bind(@NonNull View view) {
        int i4 = R.id.swipe_description_overlay_left_arrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.swipe_description_overlay_left_arrow);
        if (imageView != null) {
            i4 = R.id.swipe_description_overlay_left_diagonal_arrow;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.swipe_description_overlay_left_diagonal_arrow);
            if (imageView2 != null) {
                i4 = R.id.swipe_description_overlay_left_down_arrow;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.swipe_description_overlay_left_down_arrow);
                if (imageView3 != null) {
                    i4 = R.id.swipe_description_overlay_right_arrow;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.swipe_description_overlay_right_arrow);
                    if (imageView4 != null) {
                        i4 = R.id.swipe_description_overlay_right_diagonal_arrow;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.swipe_description_overlay_right_diagonal_arrow);
                        if (imageView5 != null) {
                            i4 = R.id.swipe_description_overlay_right_down_arrow;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.swipe_description_overlay_right_down_arrow);
                            if (imageView6 != null) {
                                i4 = R.id.swipe_description_overlay_touch_area_top_left;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.swipe_description_overlay_touch_area_top_left);
                                if (findChildViewById != null) {
                                    i4 = R.id.swipe_description_overlay_touch_area_top_right;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.swipe_description_overlay_touch_area_top_right);
                                    if (findChildViewById2 != null) {
                                        return new SwipeDescriptionOverlayBinding((RelativeLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, findChildViewById, findChildViewById2);
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
    public static SwipeDescriptionOverlayBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SwipeDescriptionOverlayBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.swipe_description_overlay, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.f11381a;
    }
}
