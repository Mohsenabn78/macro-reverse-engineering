package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.widget.EmojiTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FloatingTextBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11218a;
    @NonNull
    public final EmojiTextView floatingText;

    private FloatingTextBinding(@NonNull FrameLayout frameLayout, @NonNull EmojiTextView emojiTextView) {
        this.f11218a = frameLayout;
        this.floatingText = emojiTextView;
    }

    @NonNull
    public static FloatingTextBinding bind(@NonNull View view) {
        EmojiTextView emojiTextView = (EmojiTextView) ViewBindings.findChildViewById(view, R.id.floatingText);
        if (emojiTextView != null) {
            return new FloatingTextBinding((FrameLayout) view, emojiTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.floatingText)));
    }

    @NonNull
    public static FloatingTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FloatingTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.floating_text, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11218a;
    }
}
