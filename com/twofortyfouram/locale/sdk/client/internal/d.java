package com.twofortyfouram.locale.sdk.client.internal;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import com.twofortyfouram.spackle.ThreadUtil;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public abstract class d extends BroadcastReceiver {

    /* loaded from: classes6.dex */
    public interface a {
        int a();
    }

    @TargetApi(11)
    /* loaded from: classes6.dex */
    static final class b implements Handler.Callback {
        private b() {
        }

        /* synthetic */ b(byte b4) {
            this();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            Assertions.assertNotNull(message, NotificationCompat.CATEGORY_MESSAGE);
            if (message.what == 0) {
                Assertions.assertNotNull(message.obj, "msg.obj");
                boolean z3 = false;
                Assertions.assertInRangeInclusive(message.arg1, 0, 1, "msg.arg1");
                Pair pair = (Pair) message.obj;
                if (message.arg1 != 0) {
                    z3 = true;
                }
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) pair.first;
                try {
                    int a4 = ((a) pair.second).a();
                    if (z3) {
                        pendingResult.setResultCode(a4);
                    }
                    pendingResult.finish();
                    if (AndroidSdkVersion.isAtLeastSdk(18)) {
                        Looper.myLooper().quitSafely();
                    } else {
                        Looper.myLooper().quit();
                    }
                } catch (Throwable th) {
                    pendingResult.finish();
                    throw th;
                }
            }
            return true;
        }
    }

    @TargetApi(11)
    public final void a(@NonNull a aVar, boolean z3) {
        Assertions.assertNotNull(aVar, "callback");
        BroadcastReceiver.PendingResult goAsync = goAsync();
        if (goAsync != null) {
            Handler handler = new Handler(ThreadUtil.newHandlerThread(getClass().getName(), ThreadUtil.ThreadPriority.BACKGROUND).getLooper(), new b((byte) 0));
            if (handler.sendMessage(handler.obtainMessage(0, z3 ? 1 : 0, 0, new Pair(goAsync, aVar)))) {
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError("PendingResult was null.  Was goAsync() called previously?");
    }
}
