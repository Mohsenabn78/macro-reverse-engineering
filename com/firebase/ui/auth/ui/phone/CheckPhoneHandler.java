package com.firebase.ui.auth.ui.phone;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.firebase.ui.auth.data.model.PhoneNumber;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.util.data.PhoneNumberUtils;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.HintRequest;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class CheckPhoneHandler extends AuthViewModelBase<PhoneNumber> {
    public CheckPhoneHandler(Application application) {
        super(application);
    }

    public void fetchCredential() {
        d(Resource.forFailure(new PendingIntentRequiredException(Credentials.getClient(getApplication()).getHintPickerIntent(new HintRequest.Builder().setPhoneNumberIdentifierSupported(true).build()), 101)));
    }

    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        String formatUsingCurrentCountry;
        if (i4 == 101 && i5 == -1 && (formatUsingCurrentCountry = PhoneNumberUtils.formatUsingCurrentCountry(((Credential) intent.getParcelableExtra(Credential.EXTRA_KEY)).getId(), getApplication())) != null) {
            d(Resource.forSuccess(PhoneNumberUtils.getPhoneNumber(formatUsingCurrentCountry)));
        }
    }
}
