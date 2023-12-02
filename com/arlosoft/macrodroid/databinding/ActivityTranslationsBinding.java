package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityTranslationsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10971a;
    @NonNull
    public final RecyclerView languageEntries;
    @NonNull
    public final FrameLayout loadingView;
    @NonNull
    public final Button requestTranslationAccessButton;
    @NonNull
    public final TextView requestTranslationText;
    @NonNull
    public final NestedScrollView scrollView;
    @NonNull
    public final Toolbar toolbar;

    private ActivityTranslationsBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull TextView textView, @NonNull NestedScrollView nestedScrollView, @NonNull Toolbar toolbar) {
        this.f10971a = linearLayout;
        this.languageEntries = recyclerView;
        this.loadingView = frameLayout;
        this.requestTranslationAccessButton = button;
        this.requestTranslationText = textView;
        this.scrollView = nestedScrollView;
        this.toolbar = toolbar;
    }

    @NonNull
    public static ActivityTranslationsBinding bind(@NonNull View view) {
        int i4 = R.id.languageEntries;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.languageEntries);
        if (recyclerView != null) {
            i4 = R.id.loadingView;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingView);
            if (frameLayout != null) {
                i4 = R.id.requestTranslationAccessButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.requestTranslationAccessButton);
                if (button != null) {
                    i4 = R.id.requestTranslationText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.requestTranslationText);
                    if (textView != null) {
                        i4 = R.id.scrollView;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scrollView);
                        if (nestedScrollView != null) {
                            i4 = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                            if (toolbar != null) {
                                return new ActivityTranslationsBinding((LinearLayout) view, recyclerView, frameLayout, button, textView, nestedScrollView, toolbar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityTranslationsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTranslationsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_translations, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10971a;
    }
}
