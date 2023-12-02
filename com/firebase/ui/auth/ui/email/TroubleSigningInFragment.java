package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class TroubleSigningInFragment extends FragmentBase implements View.OnClickListener {
    public static final String TAG = "TroubleSigningInFragment";

    /* renamed from: c  reason: collision with root package name */
    private a f18107c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f18108d;

    /* renamed from: e  reason: collision with root package name */
    private String f18109e;

    /* loaded from: classes3.dex */
    interface a {
        void onClickResendEmail(String str);
    }

    private void b(View view) {
        view.findViewById(R.id.button_resend_email).setOnClickListener(this);
    }

    private void c(View view) {
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(requireContext(), getFlowParams(), (TextView) view.findViewById(R.id.email_footer_tos_and_pp_text));
    }

    public static TroubleSigningInFragment newInstance(@NonNull String str) {
        TroubleSigningInFragment troubleSigningInFragment = new TroubleSigningInFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ExtraConstants.EMAIL, str);
        troubleSigningInFragment.setArguments(bundle);
        return troubleSigningInFragment;
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18108d.setVisibility(4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity instanceof a) {
            this.f18107c = (a) activity;
            return;
        }
        throw new IllegalStateException("Activity must implement ResendEmailListener");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_resend_email) {
            this.f18107c.onClickResendEmail(this.f18109e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_email_link_trouble_signing_in_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        this.f18108d = (ProgressBar) view.findViewById(R.id.top_progress_bar);
        this.f18109e = getArguments().getString(ExtraConstants.EMAIL);
        b(view);
        c(view);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18108d.setVisibility(0);
    }
}
