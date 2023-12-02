package com.firebase.ui.auth.ui.email;

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
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.util.ui.ImeHelper;
import com.firebase.ui.auth.util.ui.fieldvalidators.BaseValidator;
import com.firebase.ui.auth.util.ui.fieldvalidators.EmailFieldValidator;
import com.firebase.ui.auth.util.ui.fieldvalidators.NoOpValidator;
import com.firebase.ui.auth.util.ui.fieldvalidators.PasswordFieldValidator;
import com.firebase.ui.auth.util.ui.fieldvalidators.RequiredFieldValidator;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.viewmodel.email.EmailProviderResponseHandler;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class RegisterEmailFragment extends FragmentBase implements View.OnClickListener, View.OnFocusChangeListener, ImeHelper.DonePressedListener {
    public static final String TAG = "RegisterEmailFragment";

    /* renamed from: c  reason: collision with root package name */
    private EmailProviderResponseHandler f18091c;

    /* renamed from: d  reason: collision with root package name */
    private Button f18092d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f18093e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f18094f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f18095g;

    /* renamed from: h  reason: collision with root package name */
    private EditText f18096h;

    /* renamed from: i  reason: collision with root package name */
    private TextInputLayout f18097i;

    /* renamed from: j  reason: collision with root package name */
    private TextInputLayout f18098j;

    /* renamed from: k  reason: collision with root package name */
    private EmailFieldValidator f18099k;

    /* renamed from: l  reason: collision with root package name */
    private PasswordFieldValidator f18100l;

    /* renamed from: m  reason: collision with root package name */
    private BaseValidator f18101m;

    /* renamed from: n  reason: collision with root package name */
    private c f18102n;

    /* renamed from: o  reason: collision with root package name */
    private User f18103o;

    /* loaded from: classes3.dex */
    class a extends ResourceObserver<IdpResponse> {
        a(FragmentBase fragmentBase, int i4) {
            super(fragmentBase, i4);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
            if (exc instanceof FirebaseAuthWeakPasswordException) {
                RegisterEmailFragment.this.f18098j.setError(RegisterEmailFragment.this.getResources().getQuantityString(R.plurals.fui_error_weak_password, R.integer.fui_min_password_length));
            } else if (exc instanceof FirebaseAuthInvalidCredentialsException) {
                RegisterEmailFragment.this.f18097i.setError(RegisterEmailFragment.this.getString(R.string.fui_invalid_email_address));
            } else if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
                RegisterEmailFragment.this.f18102n.onMergeFailure(((FirebaseAuthAnonymousUpgradeException) exc).getResponse());
            } else {
                RegisterEmailFragment.this.f18097i.setError(RegisterEmailFragment.this.getString(R.string.fui_email_account_creation_error));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull IdpResponse idpResponse) {
            RegisterEmailFragment registerEmailFragment = RegisterEmailFragment.this;
            registerEmailFragment.startSaveCredentials(registerEmailFragment.f18091c.getCurrentUser(), idpResponse, RegisterEmailFragment.this.f18096h.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f18105a;

        b(View view) {
            this.f18105a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18105a.requestFocus();
        }
    }

    /* loaded from: classes3.dex */
    interface c {
        void onMergeFailure(IdpResponse idpResponse);
    }

    private void g(View view) {
        view.post(new b(view));
    }

    private void h() {
        String obj = this.f18094f.getText().toString();
        String obj2 = this.f18096h.getText().toString();
        String obj3 = this.f18095g.getText().toString();
        boolean validate = this.f18099k.validate(obj);
        boolean validate2 = this.f18100l.validate(obj2);
        boolean validate3 = this.f18101m.validate(obj3);
        if (validate && validate2 && validate3) {
            this.f18091c.startSignIn(new IdpResponse.Builder(new User.Builder("password", obj).setName(obj3).setPhotoUri(this.f18103o.getPhotoUri()).build()).build(), obj2);
        }
    }

    public static RegisterEmailFragment newInstance(User user) {
        RegisterEmailFragment registerEmailFragment = new RegisterEmailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ExtraConstants.USER, user);
        registerEmailFragment.setArguments(bundle);
        return registerEmailFragment;
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18092d.setEnabled(true);
        this.f18093e.setVisibility(4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        requireActivity.setTitle(R.string.fui_title_register_email);
        if (requireActivity instanceof c) {
            this.f18102n = (c) requireActivity;
            return;
        }
        throw new IllegalStateException("Activity must implement CheckEmailListener");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_create) {
            h();
        }
    }

    @Override // com.firebase.ui.auth.ui.FragmentBase, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f18103o = User.getUser(getArguments());
        } else {
            this.f18103o = User.getUser(bundle);
        }
        EmailProviderResponseHandler emailProviderResponseHandler = (EmailProviderResponseHandler) new ViewModelProvider(this).get(EmailProviderResponseHandler.class);
        this.f18091c = emailProviderResponseHandler;
        emailProviderResponseHandler.init(getFlowParams());
        this.f18091c.getOperation().observe(this, new a(this, R.string.fui_progress_dialog_signing_up));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_register_email_layout, viewGroup, false);
    }

    @Override // com.firebase.ui.auth.util.ui.ImeHelper.DonePressedListener
    public void onDonePressed() {
        h();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z3) {
        if (z3) {
            return;
        }
        int id = view.getId();
        if (id == R.id.email) {
            this.f18099k.validate(this.f18094f.getText());
        } else if (id == R.id.name) {
            this.f18101m.validate(this.f18095g.getText());
        } else if (id == R.id.password) {
            this.f18100l.validate(this.f18096h.getText());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putParcelable(ExtraConstants.USER, new User.Builder("password", this.f18094f.getText().toString()).setName(this.f18095g.getText().toString()).setPhotoUri(this.f18103o.getPhotoUri()).build());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        BaseValidator noOpValidator;
        int i4;
        this.f18092d = (Button) view.findViewById(R.id.button_create);
        this.f18093e = (ProgressBar) view.findViewById(R.id.top_progress_bar);
        this.f18094f = (EditText) view.findViewById(R.id.email);
        this.f18095g = (EditText) view.findViewById(R.id.name);
        this.f18096h = (EditText) view.findViewById(R.id.password);
        this.f18097i = (TextInputLayout) view.findViewById(R.id.email_layout);
        this.f18098j = (TextInputLayout) view.findViewById(R.id.password_layout);
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.name_layout);
        boolean z3 = ProviderUtils.getConfigFromIdpsOrThrow(getFlowParams().providers, "password").getParams().getBoolean(ExtraConstants.REQUIRE_NAME, true);
        this.f18100l = new PasswordFieldValidator(this.f18098j, getResources().getInteger(R.integer.fui_min_password_length));
        if (z3) {
            noOpValidator = new RequiredFieldValidator(textInputLayout, getResources().getString(R.string.fui_missing_first_and_last_name));
        } else {
            noOpValidator = new NoOpValidator(textInputLayout);
        }
        this.f18101m = noOpValidator;
        this.f18099k = new EmailFieldValidator(this.f18097i);
        ImeHelper.setImeOnDoneListener(this.f18096h, this);
        this.f18094f.setOnFocusChangeListener(this);
        this.f18095g.setOnFocusChangeListener(this);
        this.f18096h.setOnFocusChangeListener(this);
        this.f18092d.setOnClickListener(this);
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textInputLayout.setVisibility(i4);
        if (Build.VERSION.SDK_INT >= 26 && getFlowParams().enableCredentials) {
            this.f18094f.setImportantForAutofill(2);
        }
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(requireContext(), getFlowParams(), (TextView) view.findViewById(R.id.email_footer_tos_and_pp_text));
        if (bundle != null) {
            return;
        }
        String email = this.f18103o.getEmail();
        if (!TextUtils.isEmpty(email)) {
            this.f18094f.setText(email);
        }
        String name = this.f18103o.getName();
        if (!TextUtils.isEmpty(name)) {
            this.f18095g.setText(name);
        }
        if (z3 && TextUtils.isEmpty(this.f18095g.getText())) {
            if (!TextUtils.isEmpty(this.f18094f.getText())) {
                g(this.f18095g);
                return;
            } else {
                g(this.f18094f);
                return;
            }
        }
        g(this.f18096h);
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18092d.setEnabled(false);
        this.f18093e.setVisibility(0);
    }
}
