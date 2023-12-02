package com.firebase.ui.auth.ui.phone;

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
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.data.model.PhoneNumber;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PhoneNumberUtils;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.ui.ImeHelper;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class CheckPhoneNumberFragment extends FragmentBase implements View.OnClickListener {
    public static final String TAG = "VerifyPhoneFragment";

    /* renamed from: c  reason: collision with root package name */
    private PhoneNumberVerificationHandler f18145c;

    /* renamed from: d  reason: collision with root package name */
    private CheckPhoneHandler f18146d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18147e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f18148f;

    /* renamed from: g  reason: collision with root package name */
    private Button f18149g;

    /* renamed from: h  reason: collision with root package name */
    private CountryListSpinner f18150h;

    /* renamed from: i  reason: collision with root package name */
    private TextInputLayout f18151i;

    /* renamed from: j  reason: collision with root package name */
    private EditText f18152j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f18153k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f18154l;

    /* loaded from: classes3.dex */
    class a implements ImeHelper.DonePressedListener {
        a() {
        }

        @Override // com.firebase.ui.auth.util.ui.ImeHelper.DonePressedListener
        public void onDonePressed() {
            CheckPhoneNumberFragment.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CheckPhoneNumberFragment.this.f18151i.setError(null);
        }
    }

    @Nullable
    private String e() {
        String obj = this.f18152j.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            return null;
        }
        return PhoneNumberUtils.format(obj, this.f18150h.getSelectedCountryInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String e4 = e();
        if (e4 == null) {
            this.f18151i.setError(getString(R.string.fui_invalid_phone_number));
        } else {
            this.f18145c.verifyPhoneNumber(requireActivity(), e4, false);
        }
    }

    private void g(PhoneNumber phoneNumber) {
        this.f18150h.setSelectedForCountry(new Locale("", phoneNumber.getCountryIso()), phoneNumber.getCountryCode());
    }

    private void h() {
        String str;
        String str2;
        String str3;
        Bundle bundle = getArguments().getBundle(ExtraConstants.PARAMS);
        if (bundle != null) {
            str = bundle.getString(ExtraConstants.PHONE);
            str3 = bundle.getString(ExtraConstants.COUNTRY_ISO);
            str2 = bundle.getString(ExtraConstants.NATIONAL_NUMBER);
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        if (!TextUtils.isEmpty(str)) {
            k(PhoneNumberUtils.getPhoneNumber(str));
        } else if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            k(PhoneNumberUtils.getPhoneNumber(str3, str2));
        } else if (!TextUtils.isEmpty(str3)) {
            g(new PhoneNumber("", str3, String.valueOf(PhoneNumberUtils.getCountryCode(str3))));
        } else if (getFlowParams().enableHints) {
            this.f18146d.fetchCredential();
        }
    }

    private void i() {
        this.f18150h.init(getArguments().getBundle(ExtraConstants.PARAMS));
        this.f18150h.setOnClickListener(new c());
    }

    private void j() {
        boolean z3;
        FlowParameters flowParams = getFlowParams();
        if (flowParams.isTermsOfServiceUrlProvided() && flowParams.isPrivacyPolicyUrlProvided()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!flowParams.shouldShowProviderChoice() && z3) {
            PrivacyDisclosureUtils.setupTermsOfServiceAndPrivacyPolicySmsText(requireContext(), flowParams, this.f18153k);
            return;
        }
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(requireContext(), flowParams, this.f18154l);
        this.f18153k.setText(getString(R.string.fui_sms_terms_of_service, getString(R.string.fui_verify_phone_number)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PhoneNumber phoneNumber) {
        if (!PhoneNumber.isValid(phoneNumber)) {
            this.f18151i.setError(getString(R.string.fui_invalid_phone_number));
            return;
        }
        this.f18152j.setText(phoneNumber.getPhoneNumber());
        this.f18152j.setSelection(phoneNumber.getPhoneNumber().length());
        String countryIso = phoneNumber.getCountryIso();
        if (PhoneNumber.isCountryValid(phoneNumber) && this.f18150h.isValidIso(countryIso)) {
            g(phoneNumber);
            f();
        }
    }

    public static CheckPhoneNumberFragment newInstance(Bundle bundle) {
        CheckPhoneNumberFragment checkPhoneNumberFragment = new CheckPhoneNumberFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(ExtraConstants.PARAMS, bundle);
        checkPhoneNumberFragment.setArguments(bundle2);
        return checkPhoneNumberFragment;
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18149g.setEnabled(true);
        this.f18148f.setVisibility(4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f18146d.getOperation().observe(getViewLifecycleOwner(), new b(this));
        if (bundle == null && !this.f18147e) {
            this.f18147e = true;
            h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        this.f18146d.onActivityResult(i4, i5, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
    }

    @Override // com.firebase.ui.auth.ui.FragmentBase, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f18145c = (PhoneNumberVerificationHandler) new ViewModelProvider(requireActivity()).get(PhoneNumberVerificationHandler.class);
        this.f18146d = (CheckPhoneHandler) new ViewModelProvider(this).get(CheckPhoneHandler.class);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_phone_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        this.f18148f = (ProgressBar) view.findViewById(R.id.top_progress_bar);
        this.f18149g = (Button) view.findViewById(R.id.send_code);
        this.f18150h = (CountryListSpinner) view.findViewById(R.id.country_list);
        this.f18151i = (TextInputLayout) view.findViewById(R.id.phone_layout);
        this.f18152j = (EditText) view.findViewById(R.id.phone_number);
        this.f18153k = (TextView) view.findViewById(R.id.send_sms_tos);
        this.f18154l = (TextView) view.findViewById(R.id.email_footer_tos_and_pp_text);
        this.f18153k.setText(getString(R.string.fui_sms_terms_of_service, getString(R.string.fui_verify_phone_number)));
        if (Build.VERSION.SDK_INT >= 26 && getFlowParams().enableHints) {
            this.f18152j.setImportantForAutofill(2);
        }
        requireActivity().setTitle(getString(R.string.fui_verify_phone_number_title));
        ImeHelper.setImeOnDoneListener(this.f18152j, new a());
        this.f18149g.setOnClickListener(this);
        j();
        i();
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18149g.setEnabled(false);
        this.f18148f.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    class b extends ResourceObserver<PhoneNumber> {
        b(FragmentBase fragmentBase) {
            super(fragmentBase);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        /* renamed from: c */
        public void b(@NonNull PhoneNumber phoneNumber) {
            CheckPhoneNumberFragment.this.k(phoneNumber);
        }

        @Override // com.firebase.ui.auth.viewmodel.ResourceObserver
        protected void a(@NonNull Exception exc) {
        }
    }
}
