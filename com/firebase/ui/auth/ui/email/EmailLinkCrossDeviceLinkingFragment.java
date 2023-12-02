package com.firebase.ui.auth.ui.email;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.util.data.EmailLinkParser;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.util.ui.TextHelper;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailLinkCrossDeviceLinkingFragment extends FragmentBase implements View.OnClickListener {
    public static final String TAG = "CrossDeviceFragment";

    /* renamed from: c  reason: collision with root package name */
    private a f18064c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f18065d;

    /* renamed from: e  reason: collision with root package name */
    private Button f18066e;

    /* loaded from: classes3.dex */
    interface a {
        void completeCrossDeviceEmailLinkFlow();
    }

    public static EmailLinkCrossDeviceLinkingFragment newInstance() {
        return new EmailLinkCrossDeviceLinkingFragment();
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18065d.setVisibility(4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof a) {
            this.f18064c = (a) activity;
            return;
        }
        throw new IllegalStateException("Activity must implement EmailLinkPromptEmailListener");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_continue) {
            this.f18064c.completeCrossDeviceEmailLinkFlow();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_email_link_cross_device_linking, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"WrongConstant"})
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        this.f18065d = (ProgressBar) view.findViewById(R.id.top_progress_bar);
        Button button = (Button) view.findViewById(R.id.button_continue);
        this.f18066e = button;
        button.setOnClickListener(this);
        String providerIdToProviderName = ProviderUtils.providerIdToProviderName(new EmailLinkParser(getFlowParams().emailLink).getProviderId());
        TextView textView = (TextView) view.findViewById(R.id.cross_device_linking_body);
        String string = getString(R.string.fui_email_link_cross_device_linking_text, providerIdToProviderName);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        TextHelper.boldAllOccurencesOfText(spannableStringBuilder, string, providerIdToProviderName);
        textView.setText(spannableStringBuilder);
        if (Build.VERSION.SDK_INT >= 26) {
            textView.setJustificationMode(1);
        }
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(requireContext(), getFlowParams(), (TextView) view.findViewById(R.id.email_footer_tos_and_pp_text));
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18065d.setVisibility(0);
    }
}
