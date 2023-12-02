package com.firebase.ui.auth.util.data;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.ui.PreambleHandler;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class PrivacyDisclosureUtils {
    @StringRes
    private static int a(FlowParameters flowParameters) {
        boolean isTermsOfServiceUrlProvided = flowParameters.isTermsOfServiceUrlProvided();
        boolean isPrivacyPolicyUrlProvided = flowParameters.isPrivacyPolicyUrlProvided();
        if (isTermsOfServiceUrlProvided && isPrivacyPolicyUrlProvided) {
            return R.string.fui_tos_and_pp_footer;
        }
        return -1;
    }

    @StringRes
    private static int b(FlowParameters flowParameters) {
        boolean isTermsOfServiceUrlProvided = flowParameters.isTermsOfServiceUrlProvided();
        boolean isPrivacyPolicyUrlProvided = flowParameters.isPrivacyPolicyUrlProvided();
        if (isTermsOfServiceUrlProvided && isPrivacyPolicyUrlProvided) {
            return R.string.fui_tos_and_pp;
        }
        return -1;
    }

    @StringRes
    private static int c(FlowParameters flowParameters) {
        boolean isTermsOfServiceUrlProvided = flowParameters.isTermsOfServiceUrlProvided();
        boolean isPrivacyPolicyUrlProvided = flowParameters.isPrivacyPolicyUrlProvided();
        if (isTermsOfServiceUrlProvided && isPrivacyPolicyUrlProvided) {
            return R.string.fui_sms_terms_of_service_and_privacy_policy_extended;
        }
        return -1;
    }

    public static void setupTermsOfServiceAndPrivacyPolicySmsText(Context context, FlowParameters flowParameters, TextView textView) {
        PreambleHandler.setup(context, flowParameters, R.string.fui_verify_phone_number, c(flowParameters), textView);
    }

    public static void setupTermsOfServiceAndPrivacyPolicyText(Context context, FlowParameters flowParameters, TextView textView) {
        PreambleHandler.setup(context, flowParameters, b(flowParameters), textView);
    }

    public static void setupTermsOfServiceFooter(Context context, FlowParameters flowParameters, TextView textView) {
        PreambleHandler.setup(context, flowParameters, a(flowParameters), textView);
    }
}
