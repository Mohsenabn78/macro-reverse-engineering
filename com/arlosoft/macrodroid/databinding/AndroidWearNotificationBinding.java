package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class AndroidWearNotificationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10984a;
    @NonNull
    public final ImageView androidWearNotificationAction1;
    @NonNull
    public final ImageView androidWearNotificationAction2;
    @NonNull
    public final ImageView androidWearNotificationAction3;
    @NonNull
    public final ImageView androidWearNotificationAction4;
    @NonNull
    public final Button androidWearNotificationChangeIconButton;
    @NonNull
    public final ImageView androidWearNotificationIconAction1;
    @NonNull
    public final ImageView androidWearNotificationIconAction2;
    @NonNull
    public final ImageView androidWearNotificationIconAction3;
    @NonNull
    public final ImageView androidWearNotificationIconAction4;
    @NonNull
    public final TextView androidWearNotificationIconLabel;
    @NonNull
    public final Button androidWearNotificationMagicSubjectButton;
    @NonNull
    public final Button androidWearNotificationMagicTextButton;
    @NonNull
    public final AppCompatEditText androidWearNotificationNotificationText;
    @NonNull
    public final ImageView androidWearNotificationPreviewImage;
    @NonNull
    public final AppCompatEditText androidWearNotificationSubjectText;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;

    private AndroidWearNotificationBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull Button button, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull ImageView imageView8, @NonNull TextView textView, @NonNull Button button2, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText, @NonNull ImageView imageView9, @NonNull AppCompatEditText appCompatEditText2, @NonNull LinearLayout linearLayout2, @NonNull Button button4, @NonNull Button button5) {
        this.f10984a = linearLayout;
        this.androidWearNotificationAction1 = imageView;
        this.androidWearNotificationAction2 = imageView2;
        this.androidWearNotificationAction3 = imageView3;
        this.androidWearNotificationAction4 = imageView4;
        this.androidWearNotificationChangeIconButton = button;
        this.androidWearNotificationIconAction1 = imageView5;
        this.androidWearNotificationIconAction2 = imageView6;
        this.androidWearNotificationIconAction3 = imageView7;
        this.androidWearNotificationIconAction4 = imageView8;
        this.androidWearNotificationIconLabel = textView;
        this.androidWearNotificationMagicSubjectButton = button2;
        this.androidWearNotificationMagicTextButton = button3;
        this.androidWearNotificationNotificationText = appCompatEditText;
        this.androidWearNotificationPreviewImage = imageView9;
        this.androidWearNotificationSubjectText = appCompatEditText2;
        this.buttonBar = linearLayout2;
        this.cancelButton = button4;
        this.okButton = button5;
    }

    @NonNull
    public static AndroidWearNotificationBinding bind(@NonNull View view) {
        int i4 = R.id.android_wear_notification_action_1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_1);
        if (imageView != null) {
            i4 = R.id.android_wear_notification_action_2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_2);
            if (imageView2 != null) {
                i4 = R.id.android_wear_notification_action_3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_3);
                if (imageView3 != null) {
                    i4 = R.id.android_wear_notification_action_4;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_4);
                    if (imageView4 != null) {
                        i4 = R.id.android_wear_notification_change_icon_button;
                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.android_wear_notification_change_icon_button);
                        if (button != null) {
                            i4 = R.id.android_wear_notification_icon_action_1;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_icon_action_1);
                            if (imageView5 != null) {
                                i4 = R.id.android_wear_notification_icon_action_2;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_icon_action_2);
                                if (imageView6 != null) {
                                    i4 = R.id.android_wear_notification_icon_action_3;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_icon_action_3);
                                    if (imageView7 != null) {
                                        i4 = R.id.android_wear_notification_icon_action_4;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_icon_action_4);
                                        if (imageView8 != null) {
                                            i4 = R.id.android_wear_notification_icon_label;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_icon_label);
                                            if (textView != null) {
                                                i4 = R.id.android_wear_notification_magic_subject_button;
                                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.android_wear_notification_magic_subject_button);
                                                if (button2 != null) {
                                                    i4 = R.id.android_wear_notification_magic_text_button;
                                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.android_wear_notification_magic_text_button);
                                                    if (button3 != null) {
                                                        i4 = R.id.android_wear_notification_notification_text;
                                                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.android_wear_notification_notification_text);
                                                        if (appCompatEditText != null) {
                                                            i4 = R.id.android_wear_notification_preview_image;
                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_preview_image);
                                                            if (imageView9 != null) {
                                                                i4 = R.id.android_wear_notification_subject_text;
                                                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.android_wear_notification_subject_text);
                                                                if (appCompatEditText2 != null) {
                                                                    i4 = R.id.button_bar;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                                                                    if (linearLayout != null) {
                                                                        i4 = R.id.cancelButton;
                                                                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                                                                        if (button4 != null) {
                                                                            i4 = R.id.okButton;
                                                                            Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                                            if (button5 != null) {
                                                                                return new AndroidWearNotificationBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, button, imageView5, imageView6, imageView7, imageView8, textView, button2, button3, appCompatEditText, imageView9, appCompatEditText2, linearLayout, button4, button5);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static AndroidWearNotificationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AndroidWearNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.android_wear_notification, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10984a;
    }
}
