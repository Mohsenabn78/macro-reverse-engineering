package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogWebUrlTriggerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11163a;
    @NonNull
    public final Button addStringVariableButton;
    @NonNull
    public final NDSpinner bodyVariableSpinner;
    @NonNull
    public final ImageView editwhiteListButton;
    @NonNull
    public final AppCompatEditText identifier;
    @NonNull
    public final TextView importFromDeviceButton;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final TextView newDeviceIdButton;
    @NonNull
    public final TextView portToNewDeviceButton;
    @NonNull
    public final Button tinyUrlButton;
    @NonNull
    public final TextView tinyUrlLinkText;
    @NonNull
    public final ImageView urlCopyButton;
    @NonNull
    public final ImageView urlCopyButtonTinyUrl;
    @NonNull
    public final TextView urlLinkText;
    @NonNull
    public final ImageView urlShareButton;
    @NonNull
    public final ImageView urlShareButtonTinyUrl;
    @NonNull
    public final TextView whiteListEntriesText;

    private DialogWebUrlTriggerBinding(@NonNull ScrollView scrollView, @NonNull Button button, @NonNull NDSpinner nDSpinner, @NonNull ImageView imageView, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView, @NonNull Button button2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull Button button3, @NonNull TextView textView4, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView5, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull TextView textView6) {
        this.f11163a = scrollView;
        this.addStringVariableButton = button;
        this.bodyVariableSpinner = nDSpinner;
        this.editwhiteListButton = imageView;
        this.identifier = appCompatEditText;
        this.importFromDeviceButton = textView;
        this.magicTextButton = button2;
        this.newDeviceIdButton = textView2;
        this.portToNewDeviceButton = textView3;
        this.tinyUrlButton = button3;
        this.tinyUrlLinkText = textView4;
        this.urlCopyButton = imageView2;
        this.urlCopyButtonTinyUrl = imageView3;
        this.urlLinkText = textView5;
        this.urlShareButton = imageView4;
        this.urlShareButtonTinyUrl = imageView5;
        this.whiteListEntriesText = textView6;
    }

    @NonNull
    public static DialogWebUrlTriggerBinding bind(@NonNull View view) {
        int i4 = R.id.addStringVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addStringVariableButton);
        if (button != null) {
            i4 = R.id.bodyVariableSpinner;
            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.bodyVariableSpinner);
            if (nDSpinner != null) {
                i4 = R.id.editwhiteListButton;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.editwhiteListButton);
                if (imageView != null) {
                    i4 = R.id.identifier;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.identifier);
                    if (appCompatEditText != null) {
                        i4 = R.id.importFromDeviceButton;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.importFromDeviceButton);
                        if (textView != null) {
                            i4 = R.id.magicTextButton;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
                            if (button2 != null) {
                                i4 = R.id.newDeviceIdButton;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.newDeviceIdButton);
                                if (textView2 != null) {
                                    i4 = R.id.portToNewDeviceButton;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.portToNewDeviceButton);
                                    if (textView3 != null) {
                                        i4 = R.id.tinyUrlButton;
                                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.tinyUrlButton);
                                        if (button3 != null) {
                                            i4 = R.id.tinyUrlLinkText;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tinyUrlLinkText);
                                            if (textView4 != null) {
                                                i4 = R.id.urlCopyButton;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.urlCopyButton);
                                                if (imageView2 != null) {
                                                    i4 = R.id.urlCopyButtonTinyUrl;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.urlCopyButtonTinyUrl);
                                                    if (imageView3 != null) {
                                                        i4 = R.id.urlLinkText;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.urlLinkText);
                                                        if (textView5 != null) {
                                                            i4 = R.id.urlShareButton;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.urlShareButton);
                                                            if (imageView4 != null) {
                                                                i4 = R.id.urlShareButtonTinyUrl;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.urlShareButtonTinyUrl);
                                                                if (imageView5 != null) {
                                                                    i4 = R.id.whiteListEntriesText;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.whiteListEntriesText);
                                                                    if (textView6 != null) {
                                                                        return new DialogWebUrlTriggerBinding((ScrollView) view, button, nDSpinner, imageView, appCompatEditText, textView, button2, textView2, textView3, button3, textView4, imageView2, imageView3, textView5, imageView4, imageView5, textView6);
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
    public static DialogWebUrlTriggerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogWebUrlTriggerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_web_url_trigger, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11163a;
    }
}
