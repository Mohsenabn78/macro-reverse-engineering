package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.ui.InvisibleFragmentBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.ui.TextHelper;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.email.EmailLinkSendEmailHandler;
import com.google.firebase.auth.ActionCodeSettings;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailLinkFragment extends InvisibleFragmentBase {
    public static final String TAG = "EmailLinkFragment";

    /* renamed from: g  reason: collision with root package name */
    private EmailLinkSendEmailHandler f18067g;

    /* renamed from: h  reason: collision with root package name */
    private c f18068h;

    /* renamed from: i  reason: collision with root package name */
    private ScrollView f18069i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18070j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends ResourceObserver<String> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.firebase.ui.auth.ui.email.EmailLinkFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0147a implements Runnable {
            RunnableC0147a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                EmailLinkFragment.this.f18069i.setVisibility(0);
            }
        }

        a(FragmentBase fragmentBase, int i4) {
            super(fragmentBase, i4);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            EmailLinkFragment.this.f18068h.onSendEmailFailure(exc);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull String str) {
            Log.w(EmailLinkFragment.TAG, "Email for email link sign in sent successfully.");
            EmailLinkFragment.this.d(new RunnableC0147a());
            EmailLinkFragment.this.f18070j = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18073a;

        b(String str) {
            this.f18073a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EmailLinkFragment.this.f18068h.onTroubleSigningIn(this.f18073a);
        }
    }

    /* loaded from: classes3.dex */
    interface c {
        void onSendEmailFailure(Exception exc);

        void onTroubleSigningIn(String str);
    }

    private void i() {
        EmailLinkSendEmailHandler emailLinkSendEmailHandler = (EmailLinkSendEmailHandler) new ViewModelProvider(this).get(EmailLinkSendEmailHandler.class);
        this.f18067g = emailLinkSendEmailHandler;
        emailLinkSendEmailHandler.init(getFlowParams());
        this.f18067g.getOperation().observe(getViewLifecycleOwner(), new a(this, R.string.fui_progress_dialog_sending));
    }

    private void j(View view, String str) {
        String string = getString(R.string.fui_email_link_email_sent, str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        TextHelper.boldAllOccurencesOfText(spannableStringBuilder, string, str);
        ((TextView) view.findViewById(R.id.sign_in_email_sent_text)).setText(spannableStringBuilder);
    }

    private void k(View view, String str) {
        view.findViewById(R.id.trouble_signing_in).setOnClickListener(new b(str));
    }

    private void l(View view) {
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(requireContext(), getFlowParams(), (TextView) view.findViewById(R.id.email_footer_tos_and_pp_text));
    }

    public static EmailLinkFragment newInstance(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        return newInstance(str, actionCodeSettings, null, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        i();
        String string = getArguments().getString(ExtraConstants.EMAIL);
        ActionCodeSettings actionCodeSettings = (ActionCodeSettings) getArguments().getParcelable(ExtraConstants.ACTION_CODE_SETTINGS);
        IdpResponse idpResponse = (IdpResponse) getArguments().getParcelable(ExtraConstants.IDP_RESPONSE);
        boolean z3 = getArguments().getBoolean(ExtraConstants.FORCE_SAME_DEVICE);
        if (!this.f18070j) {
            this.f18067g.sendSignInLinkToEmail(string, actionCodeSettings, idpResponse, z3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity instanceof c) {
            this.f18068h = (c) activity;
            return;
        }
        throw new IllegalStateException("Activity must implement TroubleSigningInListener");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_email_link_sign_in_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("emailSent", this.f18070j);
    }

    @Override // com.firebase.ui.auth.ui.InvisibleFragmentBase, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.f18070j = bundle.getBoolean("emailSent");
        }
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.top_level_view);
        this.f18069i = scrollView;
        if (!this.f18070j) {
            scrollView.setVisibility(8);
        }
        String string = getArguments().getString(ExtraConstants.EMAIL);
        j(view, string);
        k(view, string);
        l(view);
    }

    public static EmailLinkFragment newInstance(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings, @Nullable IdpResponse idpResponse, boolean z3) {
        EmailLinkFragment emailLinkFragment = new EmailLinkFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ExtraConstants.EMAIL, str);
        bundle.putParcelable(ExtraConstants.ACTION_CODE_SETTINGS, actionCodeSettings);
        bundle.putParcelable(ExtraConstants.IDP_RESPONSE, idpResponse);
        bundle.putBoolean(ExtraConstants.FORCE_SAME_DEVICE, z3);
        emailLinkFragment.setArguments(bundle);
        return emailLinkFragment;
    }
}
