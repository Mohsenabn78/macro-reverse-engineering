package com.firebase.ui.auth.ui.email;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.ui.ImeHelper;
import com.firebase.ui.auth.util.ui.fieldvalidators.EmailFieldValidator;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseNetworkException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class CheckEmailFragment extends FragmentBase implements View.OnClickListener, ImeHelper.DonePressedListener {
    public static final String TAG = "CheckEmailFragment";

    /* renamed from: c  reason: collision with root package name */
    private CheckEmailHandler f18047c;

    /* renamed from: d  reason: collision with root package name */
    private Button f18048d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f18049e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f18050f;

    /* renamed from: g  reason: collision with root package name */
    private TextInputLayout f18051g;

    /* renamed from: h  reason: collision with root package name */
    private EmailFieldValidator f18052h;

    /* renamed from: i  reason: collision with root package name */
    private b f18053i;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<User> {
        a(FragmentBase fragmentBase, int i4) {
            super(fragmentBase, i4);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if ((exc instanceof FirebaseUiException) && ((FirebaseUiException) exc).getErrorCode() == 3) {
                CheckEmailFragment.this.f18053i.onDeveloperFailure(exc);
            }
            if (exc instanceof FirebaseNetworkException) {
                Snackbar.make(CheckEmailFragment.this.getView(), CheckEmailFragment.this.getString(R.string.fui_no_internet), -1).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull User user) {
            String email = user.getEmail();
            String providerId = user.getProviderId();
            CheckEmailFragment.this.f18050f.setText(email);
            if (providerId == null) {
                CheckEmailFragment.this.f18053i.onNewUser(new User.Builder("password", email).setName(user.getName()).setPhotoUri(user.getPhotoUri()).build());
            } else if (!providerId.equals("password") && !providerId.equals("emailLink")) {
                CheckEmailFragment.this.f18053i.onExistingIdpUser(user);
            } else {
                CheckEmailFragment.this.f18053i.onExistingEmailUser(user);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void onDeveloperFailure(Exception exc);

        void onExistingEmailUser(User user);

        void onExistingIdpUser(User user);

        void onNewUser(User user);
    }

    private void d() {
        String obj = this.f18050f.getText().toString();
        if (this.f18052h.validate(obj)) {
            this.f18047c.fetchProvider(obj);
        }
    }

    public static CheckEmailFragment newInstance(@Nullable String str) {
        CheckEmailFragment checkEmailFragment = new CheckEmailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ExtraConstants.EMAIL, str);
        checkEmailFragment.setArguments(bundle);
        return checkEmailFragment;
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18048d.setEnabled(true);
        this.f18049e.setVisibility(4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        CheckEmailHandler checkEmailHandler = (CheckEmailHandler) new ViewModelProvider(this).get(CheckEmailHandler.class);
        this.f18047c = checkEmailHandler;
        checkEmailHandler.init(getFlowParams());
        FragmentActivity activity = getActivity();
        if (activity instanceof b) {
            this.f18053i = (b) activity;
            this.f18047c.getOperation().observe(getViewLifecycleOwner(), new a(this, R.string.fui_progress_dialog_checking_accounts));
            if (bundle != null) {
                return;
            }
            String string = getArguments().getString(ExtraConstants.EMAIL);
            if (!TextUtils.isEmpty(string)) {
                this.f18050f.setText(string);
                d();
                return;
            } else if (getFlowParams().enableHints) {
                this.f18047c.fetchCredential();
                return;
            } else {
                return;
            }
        }
        throw new IllegalStateException("Activity must implement CheckEmailListener");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        this.f18047c.onActivityResult(i4, i5, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_next) {
            d();
        } else if (id == R.id.email_layout || id == R.id.email) {
            this.f18051g.setError(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_check_email_layout, viewGroup, false);
    }

    @Override // com.firebase.ui.auth.util.ui.ImeHelper.DonePressedListener
    public void onDonePressed() {
        d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        this.f18048d = (Button) view.findViewById(R.id.button_next);
        this.f18049e = (ProgressBar) view.findViewById(R.id.top_progress_bar);
        this.f18051g = (TextInputLayout) view.findViewById(R.id.email_layout);
        this.f18050f = (EditText) view.findViewById(R.id.email);
        this.f18052h = new EmailFieldValidator(this.f18051g);
        this.f18051g.setOnClickListener(this);
        this.f18050f.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.header_text);
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImeHelper.setImeOnDoneListener(this.f18050f, this);
        if (Build.VERSION.SDK_INT >= 26 && getFlowParams().enableHints) {
            this.f18050f.setImportantForAutofill(2);
        }
        this.f18048d.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(R.id.email_tos_and_pp_text);
        TextView textView3 = (TextView) view.findViewById(R.id.email_footer_tos_and_pp_text);
        FlowParameters flowParams = getFlowParams();
        if (!flowParams.shouldShowProviderChoice()) {
            PrivacyDisclosureUtils.setupTermsOfServiceAndPrivacyPolicyText(requireContext(), flowParams, textView2);
            return;
        }
        textView2.setVisibility(8);
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(requireContext(), flowParams, textView3);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18048d.setEnabled(false);
        this.f18049e.setVisibility(0);
    }
}
