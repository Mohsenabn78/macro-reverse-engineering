package com.tencent.soter.core.sotercore;

import android.os.Handler;
import android.os.Looper;
import com.tencent.soter.core.model.SLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class SyncJob {
    private static final String TAG = "Soter.SyncJob";
    private static Handler mMainLooperHandler;
    private CountDownLatch countDownWait = null;

    private static void postToMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (mMainLooperHandler == null) {
            mMainLooperHandler = new Handler(Looper.getMainLooper());
        }
        mMainLooperHandler.post(runnable);
    }

    public void countDown() {
        CountDownLatch countDownLatch = this.countDownWait;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public void doAsSyncJob(long j4, Runnable runnable) {
        SLogger.i(TAG, "doAsSyncJob", new Object[0]);
        if (runnable == null) {
            return;
        }
        this.countDownWait = new CountDownLatch(1);
        runnable.run();
        CountDownLatch countDownLatch = this.countDownWait;
        if (countDownLatch != null) {
            try {
                countDownLatch.await(j4, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e4) {
                SLogger.printErrStackTrace(TAG, e4, "");
            }
        }
    }
}
