package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class IncludeButtonBarBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11253a;
    @NonNull
    public final ImageView button1;
    @NonNull
    public final ImageView button2;
    @NonNull
    public final ImageView button3;
    @NonNull
    public final ImageView button4;
    @NonNull
    public final ImageView button5;
    @NonNull
    public final ImageView button6;
    @NonNull
    public final ImageView button7;
    @NonNull
    public final FrameLayout buttonFrame1;
    @NonNull
    public final FrameLayout buttonFrame2;
    @NonNull
    public final FrameLayout buttonFrame3;
    @NonNull
    public final FrameLayout buttonFrame4;
    @NonNull
    public final FrameLayout buttonFrame5;
    @NonNull
    public final FrameLayout buttonFrame6;
    @NonNull
    public final FrameLayout buttonFrame7;
    @NonNull
    public final LinearLayout buttonLayout;

    private IncludeButtonBarBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull FrameLayout frameLayout5, @NonNull FrameLayout frameLayout6, @NonNull FrameLayout frameLayout7, @NonNull LinearLayout linearLayout2) {
        this.f11253a = linearLayout;
        this.button1 = imageView;
        this.button2 = imageView2;
        this.button3 = imageView3;
        this.button4 = imageView4;
        this.button5 = imageView5;
        this.button6 = imageView6;
        this.button7 = imageView7;
        this.buttonFrame1 = frameLayout;
        this.buttonFrame2 = frameLayout2;
        this.buttonFrame3 = frameLayout3;
        this.buttonFrame4 = frameLayout4;
        this.buttonFrame5 = frameLayout5;
        this.buttonFrame6 = frameLayout6;
        this.buttonFrame7 = frameLayout7;
        this.buttonLayout = linearLayout2;
    }

    @NonNull
    public static IncludeButtonBarBinding bind(@NonNull View view) {
        int i4 = R.id.button1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.button1);
        if (imageView != null) {
            i4 = R.id.button2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.button2);
            if (imageView2 != null) {
                i4 = R.id.button3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.button3);
                if (imageView3 != null) {
                    i4 = R.id.button4;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.button4);
                    if (imageView4 != null) {
                        i4 = R.id.button5;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.button5);
                        if (imageView5 != null) {
                            i4 = R.id.button6;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.button6);
                            if (imageView6 != null) {
                                i4 = R.id.button7;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.button7);
                                if (imageView7 != null) {
                                    i4 = R.id.button_frame_1;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.button_frame_1);
                                    if (frameLayout != null) {
                                        i4 = R.id.button_frame_2;
                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.button_frame_2);
                                        if (frameLayout2 != null) {
                                            i4 = R.id.button_frame_3;
                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.button_frame_3);
                                            if (frameLayout3 != null) {
                                                i4 = R.id.button_frame_4;
                                                FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.button_frame_4);
                                                if (frameLayout4 != null) {
                                                    i4 = R.id.button_frame_5;
                                                    FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.button_frame_5);
                                                    if (frameLayout5 != null) {
                                                        i4 = R.id.button_frame_6;
                                                        FrameLayout frameLayout6 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.button_frame_6);
                                                        if (frameLayout6 != null) {
                                                            i4 = R.id.button_frame_7;
                                                            FrameLayout frameLayout7 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.button_frame_7);
                                                            if (frameLayout7 != null) {
                                                                LinearLayout linearLayout = (LinearLayout) view;
                                                                return new IncludeButtonBarBinding(linearLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5, frameLayout6, frameLayout7, linearLayout);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeButtonBarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeButtonBarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_button_bar, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11253a;
    }
}
