package com.arlosoft.macrodroid.bugreporting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import java.text.DateFormat;
import java.util.Locale;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class SubmitBugFragment extends MacroDroidDaggerBaseFragment {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    RemoteConfig f9580b;
    @BindView(R.id.email_address)
    EditText emailAddress;
    @BindView(R.id.holiday_warning)
    TextView holidayWarning;

    public static SubmitBugFragment newInstance() {
        return new SubmitBugFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_submit_bug, viewGroup, false);
        ButterKnife.bind(this, inflate);
        long holidayReturnTimestamp = this.f9580b.getHolidayReturnTimestamp() * 1000;
        if (System.currentTimeMillis() < holidayReturnTimestamp) {
            this.holidayWarning.setText(String.format(getString(R.string.report_bug_developer_holiday_warning), DateFormat.getDateInstance(3, Locale.getDefault()).format(Long.valueOf(holidayReturnTimestamp))));
            this.holidayWarning.setVisibility(0);
        }
        String emailGmailAddress = Settings.getEmailGmailAddress(getActivity());
        if (emailGmailAddress != null) {
            this.emailAddress.setText(emailGmailAddress);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.submit_bug})
    public void onFabClicked() {
        ((ReportBugActivity) getActivity()).submitBug(this.emailAddress.getText().toString());
    }
}
