package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class NotificationStandardBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11338a;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final TextView info;
    @NonNull
    public final LinearLayout line1;
    @NonNull
    public final LinearLayout line3;
    @NonNull
    public final FrameLayout statusBarLatestEventContent;
    @NonNull
    public final TextView text;
    @NonNull
    public final TextView text2;
    @NonNull
    public final TextView title;

    private NotificationStandardBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f11338a = frameLayout;
        this.icon = imageView;
        this.info = textView;
        this.line1 = linearLayout;
        this.line3 = linearLayout2;
        this.statusBarLatestEventContent = frameLayout2;
        this.text = textView2;
        this.text2 = textView3;
        this.title = textView4;
    }

    @NonNull
    public static NotificationStandardBinding bind(@NonNull View view) {
        int i4 = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
        if (imageView != null) {
            i4 = R.id.info;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.info);
            if (textView != null) {
                i4 = R.id.line1;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.line1);
                if (linearLayout != null) {
                    i4 = R.id.line3;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.line3);
                    if (linearLayout2 != null) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        i4 = R.id.text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.text);
                        if (textView2 != null) {
                            i4 = R.id.text2;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.text2);
                            if (textView3 != null) {
                                i4 = R.id.title;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                if (textView4 != null) {
                                    return new NotificationStandardBinding(frameLayout, imageView, textView, linearLayout, linearLayout2, frameLayout, textView2, textView3, textView4);
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
    public static NotificationStandardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static NotificationStandardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.notification_standard, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11338a;
    }
}
