package com.firebase.ui.auth.ui.email;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.ui.fieldvalidators.EmailFieldValidator;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.email.EmailLinkSignInHandler;
import com.google.android.material.textfield.TextInputLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailLinkPromptEmailFragment extends FragmentBase implements View.OnClickListener {
    public static final String TAG = "EmailLinkPromptEmailFragment";

    /* renamed from: c  reason: collision with root package name */
    private Button f18075c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f18076d;

    /* renamed from: e  reason: collision with root package name */
    private EditText f18077e;

    /* renamed from: f  reason: collision with root package name */
    private TextInputLayout f18078f;

    /* renamed from: g  reason: collision with root package name */
    private EmailFieldValidator f18079g;

    /* renamed from: h  reason: collision with root package name */
    private EmailLinkSignInHandler f18080h;

    /* renamed from: i  reason: collision with root package name */
    private b f18081i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends ResourceObserver<IdpResponse> {
        a(FragmentBase fragmentBase) {
            super(fragmentBase);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            EmailLinkPromptEmailFragment.this.f18078f.setError(exc.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            EmailLinkPromptEmailFragment.this.f18081i.onEmailPromptSuccess(idpResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void onEmailPromptSuccess(IdpResponse idpResponse);
    }

    private void d() {
        EmailLinkSignInHandler emailLinkSignInHandler = (EmailLinkSignInHandler) new ViewModelProvider(this).get(EmailLinkSignInHandler.class);
        this.f18080h = emailLinkSignInHandler;
        emailLinkSignInHandler.init(getFlowParams());
        this.f18080h.getOperation().observe(getViewLifecycleOwner(), new a(this));
    }

    private void e() {
        String obj = this.f18077e.getText().toString();
        if (this.f18079g.validate(obj)) {
            this.f18080h.finishSignIn(obj);
        }
    }

    public static EmailLinkPromptEmailFragment newInstance() {
        return new EmailLinkPromptEmailFragment();
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18075c.setEnabled(true);
        this.f18076d.setVisibility(4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof b) {
            this.f18081i = (b) activity;
            d();
            return;
        }
        throw new IllegalStateException("Activity must implement EmailLinkPromptEmailListener");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_next) {
            e();
        } else if (id == R.id.email_layout || id == R.id.email) {
            this.f18078f.setError(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_check_email_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        this.f18075c = (Button) view.findViewById(R.id.button_next);
        this.f18076d = (ProgressBar) view.findViewById(R.id.top_progress_bar);
        this.f18075c.setOnClickListener(this);
        this.f18078f = (TextInputLayout) view.findViewById(R.id.email_layout);
        this.f18077e = (EditText) view.findViewById(R.id.email);
        this.f18079g = new EmailFieldValidator(this.f18078f);
        this.f18078f.setOnClickListener(this);
        this.f18077e.setOnClickListener(this);
        getActivity().setTitle(R.string.fui_email_link_confirm_email_header);
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(requireContext(), getFlowParams(), (TextView) view.findViewById(R.id.email_footer_tos_and_pp_text));
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18075c.setEnabled(false);
        this.f18076d.setVisibility(0);
    }
}
