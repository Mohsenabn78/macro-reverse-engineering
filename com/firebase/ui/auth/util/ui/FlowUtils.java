package com.firebase.ui.auth.util.ui;

import android.app.PendingIntent;
import android.content.IntentSender;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.IntentRequiredException;
import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.ui.HelperActivityBase;

/* loaded from: classes3.dex */
public final class FlowUtils {
    private FlowUtils() {
        throw new AssertionError("No instance for you!");
    }

    private static void a(FragmentBase fragmentBase, PendingIntent pendingIntent, int i4) {
        try {
            fragmentBase.startIntentSenderForResult(pendingIntent.getIntentSender(), i4, null, 0, 0, 0, null);
        } catch (IntentSender.SendIntentException e4) {
            ((HelperActivityBase) fragmentBase.requireActivity()).finish(0, IdpResponse.getErrorIntent(e4));
        }
    }

    private static void b(HelperActivityBase helperActivityBase, PendingIntent pendingIntent, int i4) {
        try {
            helperActivityBase.startIntentSenderForResult(pendingIntent.getIntentSender(), i4, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e4) {
            helperActivityBase.finish(0, IdpResponse.getErrorIntent(e4));
        }
    }

    public static boolean unhandled(@NonNull HelperActivityBase helperActivityBase, @Nullable Exception exc) {
        if (exc instanceof IntentRequiredException) {
            IntentRequiredException intentRequiredException = (IntentRequiredException) exc;
            helperActivityBase.startActivityForResult(intentRequiredException.getIntent(), intentRequiredException.getRequestCode());
            return false;
        } else if (exc instanceof PendingIntentRequiredException) {
            PendingIntentRequiredException pendingIntentRequiredException = (PendingIntentRequiredException) exc;
            b(helperActivityBase, pendingIntentRequiredException.getPendingIntent(), pendingIntentRequiredException.getRequestCode());
            return false;
        } else {
            return true;
        }
    }

    public static boolean unhandled(@NonNull FragmentBase fragmentBase, @Nullable Exception exc) {
        if (exc instanceof IntentRequiredException) {
            IntentRequiredException intentRequiredException = (IntentRequiredException) exc;
            fragmentBase.startActivityForResult(intentRequiredException.getIntent(), intentRequiredException.getRequestCode());
            return false;
        } else if (exc instanceof PendingIntentRequiredException) {
            PendingIntentRequiredException pendingIntentRequiredException = (PendingIntentRequiredException) exc;
            a(fragmentBase, pendingIntentRequiredException.getPendingIntent(), pendingIntentRequiredException.getRequestCode());
            return false;
        } else {
            return true;
        }
    }
}
