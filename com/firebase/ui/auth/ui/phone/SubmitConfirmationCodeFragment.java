package com.firebase.ui.auth.ui.phone;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.State;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.ui.BucketedTextChangeListener;
import com.firebase.ui.auth.viewmodel.phone.PhoneProviderResponseHandler;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class SubmitConfirmationCodeFragment extends FragmentBase {
    public static final String TAG = "SubmitConfirmationCodeFragment";

    /* renamed from: e  reason: collision with root package name */
    private PhoneNumberVerificationHandler f18189e;

    /* renamed from: f  reason: collision with root package name */
    private String f18190f;

    /* renamed from: g  reason: collision with root package name */
    private ProgressBar f18191g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f18192h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f18193i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f18194j;

    /* renamed from: k  reason: collision with root package name */
    private SpacedEditText f18195k;

    /* renamed from: m  reason: collision with root package name */
    private boolean f18197m;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f18187c = new Handler();

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f18188d = new a();

    /* renamed from: l  reason: collision with root package name */
    private long f18196l = ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SubmitConfirmationCodeFragment.this.l();
        }
    }

    /* loaded from: classes3.dex */
    class b implements Observer<Resource<IdpResponse>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Resource<IdpResponse> resource) {
            if (resource.getState() == State.FAILURE) {
                SubmitConfirmationCodeFragment.this.f18195k.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SubmitConfirmationCodeFragment.this.requireActivity().getSupportFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SubmitConfirmationCodeFragment.this.f18189e.verifyPhoneNumber(SubmitConfirmationCodeFragment.this.requireActivity(), SubmitConfirmationCodeFragment.this.f18190f, true);
            SubmitConfirmationCodeFragment.this.f18193i.setVisibility(8);
            SubmitConfirmationCodeFragment.this.f18194j.setVisibility(0);
            SubmitConfirmationCodeFragment.this.f18194j.setText(String.format(SubmitConfirmationCodeFragment.this.getString(R.string.fui_resend_code_in), 60L));
            SubmitConfirmationCodeFragment.this.f18196l = ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
            SubmitConfirmationCodeFragment.this.f18187c.postDelayed(SubmitConfirmationCodeFragment.this.f18188d, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        long j4 = this.f18196l - 500;
        this.f18196l = j4;
        if (j4 <= 0) {
            this.f18194j.setText("");
            this.f18194j.setVisibility(8);
            this.f18193i.setVisibility(0);
            return;
        }
        this.f18194j.setText(String.format(getString(R.string.fui_resend_code_in), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.f18196l) + 1)));
        this.f18187c.postDelayed(this.f18188d, 500L);
    }

    private void m() {
        this.f18195k.setText("------");
        SpacedEditText spacedEditText = this.f18195k;
        spacedEditText.addTextChangedListener(new BucketedTextChangeListener(spacedEditText, 6, "-", new c()));
    }

    private void n() {
        this.f18192h.setText(this.f18190f);
        this.f18192h.setOnClickListener(new d());
    }

    public static SubmitConfirmationCodeFragment newInstance(String str) {
        SubmitConfirmationCodeFragment submitConfirmationCodeFragment = new SubmitConfirmationCodeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ExtraConstants.PHONE, str);
        submitConfirmationCodeFragment.setArguments(bundle);
        return submitConfirmationCodeFragment;
    }

    private void o() {
        this.f18193i.setOnClickListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f18189e.submitVerificationCode(this.f18190f, this.f18195k.getUnspacedText().toString());
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void hideProgress() {
        this.f18191g.setVisibility(4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ((PhoneProviderResponseHandler) new ViewModelProvider(requireActivity()).get(PhoneProviderResponseHandler.class)).getOperation().observe(getViewLifecycleOwner(), new b());
    }

    @Override // com.firebase.ui.auth.ui.FragmentBase, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f18189e = (PhoneNumberVerificationHandler) new ViewModelProvider(requireActivity()).get(PhoneNumberVerificationHandler.class);
        this.f18190f = getArguments().getString(ExtraConstants.PHONE);
        if (bundle != null) {
            this.f18196l = bundle.getLong("millis_until_finished");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_confirmation_code_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f18187c.removeCallbacks(this.f18188d);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        CharSequence text;
        super.onResume();
        if (!this.f18197m) {
            this.f18197m = true;
            return;
        }
        ClipData primaryClip = ((ClipboardManager) ContextCompat.getSystemService(requireContext(), ClipboardManager.class)).getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() == 1 && (text = primaryClip.getItemAt(0).getText()) != null && text.length() == 6) {
            try {
                Integer.parseInt(text.toString());
                this.f18195k.setText(text);
            } catch (NumberFormatException unused) {
            }
        }
        this.f18187c.removeCallbacks(this.f18188d);
        this.f18187c.postDelayed(this.f18188d, 500L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        this.f18187c.removeCallbacks(this.f18188d);
        bundle.putLong("millis_until_finished", this.f18196l);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f18195k.requestFocus();
        ((InputMethodManager) requireActivity().getSystemService("input_method")).showSoftInput(this.f18195k, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        this.f18191g = (ProgressBar) view.findViewById(R.id.top_progress_bar);
        this.f18192h = (TextView) view.findViewById(R.id.edit_phone_number);
        this.f18194j = (TextView) view.findViewById(R.id.ticker);
        this.f18193i = (TextView) view.findViewById(R.id.resend_code);
        this.f18195k = (SpacedEditText) view.findViewById(R.id.confirmation_code);
        requireActivity().setTitle(getString(R.string.fui_verify_your_phone_title));
        l();
        m();
        n();
        o();
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(requireContext(), getFlowParams(), (TextView) view.findViewById(R.id.email_footer_tos_and_pp_text));
    }

    @Override // com.firebase.ui.auth.ui.ProgressView
    public void showProgress(int i4) {
        this.f18191g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements BucketedTextChangeListener.ContentChangeCallback {
        c() {
        }

        @Override // com.firebase.ui.auth.util.ui.BucketedTextChangeListener.ContentChangeCallback
        public void whenComplete() {
            SubmitConfirmationCodeFragment.this.p();
        }

        @Override // com.firebase.ui.auth.util.ui.BucketedTextChangeListener.ContentChangeCallback
        public void whileIncomplete() {
        }
    }
}
