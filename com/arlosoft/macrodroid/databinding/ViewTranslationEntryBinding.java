package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ViewTranslationEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11417a;
    @NonNull
    public final FrameLayout flagContainer;
    @NonNull
    public final ImageView flagImage;
    @NonNull
    public final ConstraintLayout languageContainer;
    @NonNull
    public final TextView languageEnglish;
    @NonNull
    public final TextView languageName;
    @NonNull
    public final TextView percentComplete;

    private ViewTranslationEntryBinding(@NonNull CardView cardView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f11417a = cardView;
        this.flagContainer = frameLayout;
        this.flagImage = imageView;
        this.languageContainer = constraintLayout;
        this.languageEnglish = textView;
        this.languageName = textView2;
        this.percentComplete = textView3;
    }

    @NonNull
    public static ViewTranslationEntryBinding bind(@NonNull View view) {
        int i4 = R.id.flagContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.flagContainer);
        if (frameLayout != null) {
            i4 = R.id.flagImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.flagImage);
            if (imageView != null) {
                i4 = R.id.languageContainer;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.languageContainer);
                if (constraintLayout != null) {
                    i4 = R.id.languageEnglish;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.languageEnglish);
                    if (textView != null) {
                        i4 = R.id.languageName;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.languageName);
                        if (textView2 != null) {
                            i4 = R.id.percentComplete;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.percentComplete);
                            if (textView3 != null) {
                                return new ViewTranslationEntryBinding((CardView) view, frameLayout, imageView, constraintLayout, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewTranslationEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewTranslationEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_translation_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11417a;
    }
}
