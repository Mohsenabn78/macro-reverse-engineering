package com.fingerprints.service;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.fingerprints.service.IFingerprintClient;
import com.fingerprints.service.IFingerprintService;
import com.tencent.soter.core.model.ConstantsSoter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FingerprintManager {
    static final int ARG_IDENTIFY_UPDATED = 1;
    public static final int CAPTURE_FAILED_TOO_FAST = 1;
    public static final int DELETE_TEMPLATES_SUCCESS = 1;
    static final int FPC_GUIDE_DATA_INVALID = Integer.MIN_VALUE;
    static final int FPC_GUIDE_DIRECTION_E = 7;
    static final int FPC_GUIDE_DIRECTION_N = 5;
    static final int FPC_GUIDE_DIRECTION_NA = 0;
    static final int FPC_GUIDE_DIRECTION_NE = 6;
    static final int FPC_GUIDE_DIRECTION_NW = 4;
    static final int FPC_GUIDE_DIRECTION_S = 2;
    static final int FPC_GUIDE_DIRECTION_SE = 3;
    static final int FPC_GUIDE_DIRECTION_SW = 1;
    static final int FPC_GUIDE_DIRECTION_W = 8;
    static final int INTERNEL_FINGERDOWN_TIMEOUT = 3000;
    static final int MEG_FINGERDOWN_TIMEOUT = 26;
    public static final int MEG_WAIT_FINGERDOWN_TIMEOUT = 21;
    public static final int MSG_CAPTURE_FAILED = 19;
    public static final int MSG_DELETE_RESULT = 30;
    static final int MSG_ENROLMENT_DATA_IMAGE_QUALITY = 14;
    static final int MSG_ENROLMENT_DATA_IMAGE_STITCHED = 18;
    static final int MSG_ENROLMENT_DATA_IMMOBILE = 15;
    static final int MSG_ENROLMENT_DATA_NEXT_DIRECTION = 16;
    static final int MSG_ENROLMENT_DATA_PROGRESS = 17;
    static final int MSG_ENROLMENT_DONE = 5;
    static final int MSG_ENROLMENT_FAILED = 8;
    static final int MSG_ENROLMENT_LAST_TOUCH = 11;
    static final int MSG_ENROLMENT_MASK_LIST = 13;
    static final int MSG_ENROLMENT_NEXT_TOUCH = 12;
    static final int MSG_ENROLMENT_SEND_GUIDE_DATA = 10;
    static final int MSG_ENROLMENT_TOUCHES_QUALITY = 9;
    static final int MSG_ENROL_PROGRESS = 4;
    public static final int MSG_FINGER_PRESENT = 2;
    public static final int MSG_FINGER_UP = 3;
    public static final int MSG_IDENTIFY_MATCH = 6;
    public static final int MSG_IDENTIFY_NO_MATCH = 7;
    public static final int MSG_NOT_ENABLED = 22;
    public static final int MSG_NOT_ENROLLED = 20;
    public static final int MSG_SENSOR_ERROR = 25;
    public static final int MSG_UNKNOWN = 23;
    public static final int MSG_USER_CANCEL = 24;
    public static final int MSG_WAITING_FINGER = 1;
    private static String TAG = "MzFingerManager";
    private static Bundle mBundle;
    private static Bundle mGuidedDataBundle;
    private CaptureCallback mCaptureCallback;
    private IFingerprintClient mClient;
    private DeleteTemplateCallback mDeleteTemplateCallback;
    private EnrolCallback mEnrolCallback;
    private EventHandler mEventhHandler;
    private GuidedDataCallback mGuidedDataCallback;
    private IdentifyCallback mIdentifyCallback;
    private IdentifyListener mIdentifyListener;
    private IFingerprintService mService;
    HandlerThread mzHanderThread;
    private int mUserdata = Integer.MIN_VALUE;
    private boolean mReadyToStore = false;

    /* loaded from: classes3.dex */
    public interface AlipayIdentifyCallback extends IdentifyCallback {
        void onCancel();
    }

    /* loaded from: classes3.dex */
    public interface CaptureCallback {
        void onCaptureCompleted();

        void onCaptureFailed(int i4);

        void onInput();

        void onWaitingForInput();
    }

    /* loaded from: classes3.dex */
    public interface DeleteTemplateCallback {
        void onDeleteResult(boolean z3);
    }

    /* loaded from: classes3.dex */
    public interface EnrolCallback {
        void onEnrolled(int i4);

        void onEnrollmentFailed();

        void onFingerDownTimeOut();

        void onProgress(GuidedData guidedData);
    }

    /* loaded from: classes3.dex */
    private class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = FingerprintManager.TAG;
            Log.i(str, "Message     what  " + message.what);
            boolean z3 = false;
            switch (message.what) {
                case 1:
                    if (FingerprintManager.this.mCaptureCallback != null) {
                        FingerprintManager.this.mCaptureCallback.onWaitingForInput();
                    }
                    if (FingerprintManager.this.mIdentifyListener != null) {
                        FingerprintManager.this.mIdentifyListener.onStatus(1, FingerprintManager.this.mUserdata);
                        return;
                    }
                    return;
                case 2:
                    if (FingerprintManager.this.mCaptureCallback != null) {
                        FingerprintManager.this.mCaptureCallback.onInput();
                    }
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        sendMessageDelayed(obtainMessage(26), ConstantsSoter.FACEID_AUTH_CHECK_TIME);
                    }
                    if (FingerprintManager.this.mIdentifyListener != null) {
                        FingerprintManager.this.mIdentifyListener.onStatus(2, FingerprintManager.this.mUserdata);
                        removeMessages(21);
                        return;
                    }
                    return;
                case 3:
                    if (FingerprintManager.this.mCaptureCallback != null) {
                        FingerprintManager.this.mCaptureCallback.onCaptureCompleted();
                    }
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        removeMessages(26);
                    }
                    if (FingerprintManager.this.mIdentifyListener != null) {
                        FingerprintManager.this.mIdentifyListener.onStatus(3, FingerprintManager.this.mUserdata);
                        return;
                    }
                    return;
                case 4:
                    EnrolCallback unused = FingerprintManager.this.mEnrolCallback;
                    return;
                case 5:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.this.mEnrolCallback.onEnrolled(message.arg1);
                        if (FingerprintManager.this.mReadyToStore) {
                            FingerprintManager.this.mReadyToStore = false;
                            FingerprintManager.this.mEnrolCallback = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 6:
                    if (FingerprintManager.this.mIdentifyCallback != null) {
                        IdentifyCallback identifyCallback = FingerprintManager.this.mIdentifyCallback;
                        int i4 = message.arg1;
                        if (message.arg2 == 1) {
                            z3 = true;
                        }
                        identifyCallback.onIdentified(i4, z3);
                    }
                    if (FingerprintManager.this.mIdentifyListener != null) {
                        FingerprintManager.this.mIdentifyListener.onResult(6, message.arg1, FingerprintManager.this.mUserdata);
                        return;
                    }
                    return;
                case 7:
                    if (FingerprintManager.this.mIdentifyCallback != null) {
                        FingerprintManager.this.mIdentifyCallback.onNoMatch();
                    }
                    if (FingerprintManager.this.mIdentifyListener != null) {
                        FingerprintManager.this.mIdentifyListener.onResult(7, message.arg1, FingerprintManager.this.mUserdata);
                        return;
                    }
                    return;
                case 8:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.this.mEnrolCallback.onEnrollmentFailed();
                        return;
                    }
                    return;
                case 9:
                case 20:
                case 22:
                case 23:
                case 25:
                case 27:
                case 28:
                case 29:
                default:
                    return;
                case 10:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.this.PackGuidedData();
                        return;
                    }
                    return;
                case 11:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.mGuidedDataBundle.putIntArray("lastTouch", message.getData().getIntArray("lastTouch"));
                        return;
                    }
                    return;
                case 12:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.mGuidedDataBundle.putIntArray("nextTouch", message.getData().getIntArray("nextTouch"));
                        return;
                    }
                    return;
                case 13:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.mGuidedDataBundle.putIntArray("maskList", message.getData().getIntArray("maskList"));
                        FingerprintManager.mGuidedDataBundle.putInt("maskNumber", message.arg1);
                        return;
                    }
                    return;
                case 14:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.mGuidedDataBundle.putInt("acceptance", message.arg1);
                        FingerprintManager.mGuidedDataBundle.putInt("reject_reason", message.arg2);
                        return;
                    }
                    return;
                case 15:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.mGuidedDataBundle.putInt("immobile", message.arg1);
                        return;
                    }
                    return;
                case 16:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.mGuidedDataBundle.putInt("next_direction", message.arg1);
                        return;
                    }
                    return;
                case 17:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.mGuidedDataBundle.putInt("progress", message.arg1);
                        if (message.arg1 == 100) {
                            FingerprintManager.this.mReadyToStore = true;
                            return;
                        }
                        return;
                    }
                    return;
                case 18:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.mGuidedDataBundle.putInt("stitched", message.arg1);
                        return;
                    }
                    return;
                case 19:
                    if (FingerprintManager.this.mCaptureCallback != null) {
                        FingerprintManager.this.mCaptureCallback.onCaptureFailed(message.arg1);
                    }
                    if (FingerprintManager.this.mIdentifyListener != null) {
                        FingerprintManager.this.mIdentifyListener.onResult(19, message.arg1, FingerprintManager.this.mUserdata);
                        return;
                    }
                    return;
                case 21:
                    if (FingerprintManager.this.mIdentifyListener != null) {
                        FingerprintManager.this.mIdentifyListener.onResult(21, message.arg1, FingerprintManager.this.mUserdata);
                        return;
                    }
                    return;
                case 24:
                    if (FingerprintManager.this.mIdentifyListener != null) {
                        FingerprintManager.this.mIdentifyListener.onResult(24, message.arg1, FingerprintManager.this.mUserdata);
                        return;
                    }
                    return;
                case 26:
                    if (FingerprintManager.this.mEnrolCallback != null) {
                        FingerprintManager.this.mEnrolCallback.onFingerDownTimeOut();
                        return;
                    }
                    return;
                case 30:
                    if (FingerprintManager.this.mDeleteTemplateCallback != null) {
                        String unused2 = FingerprintManager.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(" MSG_DELETE_RESULT    msg.arg1:  ");
                        sb.append(message.arg1);
                        DeleteTemplateCallback deleteTemplateCallback = FingerprintManager.this.mDeleteTemplateCallback;
                        if (message.arg1 == 1) {
                            z3 = true;
                        }
                        deleteTemplateCallback.onDeleteResult(z3);
                        return;
                    }
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class GuidedData {
        public GuidedRect guidedLastTouch;
        public GuidedMaskList guidedMaskList;
        public int guidedNextDirection;
        public GuidedRect guidedNextTouch;
        public int guidedProgress;
        public GuidedResult guidedResult;

        public GuidedData(int i4, int i5, GuidedResult guidedResult, GuidedRect guidedRect, GuidedRect guidedRect2, GuidedMaskList guidedMaskList) {
            this.guidedProgress = i4;
            this.guidedNextDirection = i5;
            this.guidedResult = guidedResult;
            this.guidedLastTouch = guidedRect;
            this.guidedNextTouch = guidedRect2;
            this.guidedMaskList = guidedMaskList;
        }
    }

    /* loaded from: classes3.dex */
    public interface GuidedDataCallback {
        void onImageQuality(int i4, int i5);

        void onImageStitched(int i4);

        void onImmobile(int i4);

        void onLastTouch(int[] iArr);

        void onMaskList(int i4, int[] iArr);

        void onNextDirection(int i4);

        void onNextTouch(int[] iArr);

        void onProgressPercentage(int i4);

        void onSendGuideData();
    }

    /* loaded from: classes3.dex */
    public class GuidedMaskList {
        public ArrayList<GuidedRect> guidedMaskList;
        public int guidedNumberOfMask;

        public GuidedMaskList(ArrayList<GuidedRect> arrayList, int i4) {
            this.guidedMaskList = arrayList;
            this.guidedNumberOfMask = i4;
        }
    }

    /* loaded from: classes3.dex */
    public class GuidedRect {
        public Point guidedBottomLeft;
        public Point guidedBottomRight;
        public Point guidedTopLeft;
        public Point guidedTopRight;

        public GuidedRect(Point point, Point point2, Point point3, Point point4) {
            this.guidedBottomLeft = point;
            this.guidedBottomRight = point2;
            this.guidedTopLeft = point3;
            this.guidedTopRight = point4;
        }
    }

    /* loaded from: classes3.dex */
    public class GuidedRejectReasons {
        public boolean guidedLowCoverage;
        public boolean guidedLowQuality;

        public GuidedRejectReasons(boolean z3, boolean z4) {
            this.guidedLowCoverage = z3;
            this.guidedLowQuality = z4;
        }
    }

    /* loaded from: classes3.dex */
    public class GuidedResult {
        public int guidedAcceptance;
        public boolean guidedImmobile;
        public GuidedRejectReasons guidedRejectReasons;
        public boolean guidedStitched;

        public GuidedResult(int i4, boolean z3, boolean z4, GuidedRejectReasons guidedRejectReasons) {
            this.guidedAcceptance = i4;
            this.guidedStitched = z3;
            this.guidedImmobile = z4;
            this.guidedRejectReasons = guidedRejectReasons;
        }
    }

    /* loaded from: classes3.dex */
    public interface IdentifyCallback {
        void onIdentified(int i4, boolean z3);

        void onNoMatch();
    }

    /* loaded from: classes3.dex */
    public interface IdentifyListener {
        void onResult(int i4, int i5, int i6);

        void onStatus(int i4, int i5);
    }

    private FingerprintManager(IBinder iBinder, Looper looper) throws RemoteException {
        this.mService = IFingerprintService.Stub.asInterface(iBinder);
        if (looper == null) {
            HandlerThread handlerThread = new HandlerThread("result_handler");
            this.mzHanderThread = handlerThread;
            handlerThread.start();
            looper = this.mzHanderThread.getLooper();
        }
        String str = TAG;
        Log.e(str, "get fp method time, mService = " + this.mService);
        EventHandler eventHandler = new EventHandler(looper);
        mBundle = new Bundle();
        mGuidedDataBundle = new Bundle();
        IFingerprintClient.Stub stub = new IFingerprintClient.Stub() { // from class: com.fingerprints.service.FingerprintManager.1
            @Override // com.fingerprints.service.IFingerprintClient
            public void onBundleMessage(int i4, int i5, int i6, Bundle bundle) throws RemoteException {
                Message obtainMessage = FingerprintManager.this.mEventhHandler.obtainMessage(i4, i5, i6);
                obtainMessage.setData(bundle);
                FingerprintManager.this.mEventhHandler.sendMessage(obtainMessage);
            }

            @Override // com.fingerprints.service.IFingerprintClient
            public void onBundleMessage2(int i4, int i5, int[] iArr) throws RemoteException {
                Message obtainMessage = FingerprintManager.this.mEventhHandler.obtainMessage(i4, i5, 0);
                switch (i4) {
                    case 11:
                        FingerprintManager.mBundle.putIntArray("lastTouch", iArr);
                        obtainMessage.setData(FingerprintManager.mBundle);
                        break;
                    case 12:
                        FingerprintManager.mBundle.putIntArray("nextTouch", iArr);
                        obtainMessage.setData(FingerprintManager.mBundle);
                        break;
                    case 13:
                        FingerprintManager.mBundle.putIntArray("maskList", iArr);
                        FingerprintManager.mBundle.putInt("maskNumber", i5);
                        obtainMessage.setData(FingerprintManager.mBundle);
                        break;
                }
                FingerprintManager.this.mEventhHandler.sendMessage(obtainMessage);
            }

            @Override // com.fingerprints.service.IFingerprintClient
            public void onMessage(int i4, int i5, int i6) throws RemoteException {
                String str2 = FingerprintManager.TAG;
                Log.i(str2, " onMessage--------what  " + i4);
                FingerprintManager.this.mEventhHandler.sendMessage(FingerprintManager.this.mEventhHandler.obtainMessage(i4, i5, i6));
            }
        };
        this.mClient = stub;
        IFingerprintService iFingerprintService = this.mService;
        if (iFingerprintService != null && iFingerprintService.open(stub)) {
            this.mEventhHandler = eventHandler;
            return;
        }
        throw new RuntimeException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0139 A[LOOP:0: B:21:0x0137->B:22:0x0139, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void PackGuidedData() {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprints.service.FingerprintManager.PackGuidedData():void");
    }

    public static void notifyScreenOff() {
        try {
            String str = TAG;
            Log.i(str, " notifyScreenOff--------  " + Thread.currentThread().hashCode());
            IBinder service = ServiceManager.getService("fingerprints_service");
            if (service != null) {
                IFingerprintService.Stub.asInterface(service).notifyScreenOff();
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public static void notifyScreenOn() {
        try {
            String str = TAG;
            Log.i(str, " notifyScreenOn--------  " + Thread.currentThread().hashCode());
            IBinder service = ServiceManager.getService("fingerprints_service");
            if (service != null) {
                IFingerprintService.Stub.asInterface(service).notifyScreenOn();
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public static FingerprintManager open() {
        try {
            return new FingerprintManager((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "fingerprints_service"), Looper.myLooper());
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        } catch (ClassNotFoundException e5) {
            e5.printStackTrace();
            return null;
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return null;
        } catch (IllegalArgumentException e7) {
            e7.printStackTrace();
            return null;
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
            return null;
        } catch (RuntimeException e9) {
            e9.printStackTrace();
            return null;
        } catch (InvocationTargetException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public void abort() {
        try {
            this.mService.cancel(this.mClient);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void deleteFingerData(DeleteTemplateCallback deleteTemplateCallback, int[] iArr) {
        if (deleteTemplateCallback == null) {
            return;
        }
        this.mDeleteTemplateCallback = deleteTemplateCallback;
        try {
            this.mService.removeData(this.mClient, iArr);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public int[] getIds() {
        try {
            Log.i(TAG, "getIds      ");
            return this.mService.getIds(this.mClient);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public boolean isFingerEnable() {
        try {
            return this.mService.isFingerEnable();
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public boolean isSurpport() {
        try {
            return this.mService.isSurpport();
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void release() {
        Log.i(TAG, " release--------              ");
        if (this.mzHanderThread != null) {
            Log.i(TAG, " release--------  mzHanderThread");
            this.mzHanderThread.quit();
            this.mzHanderThread = null;
        }
        try {
            this.mService.release(this.mClient);
            if (this.mCaptureCallback != null) {
                this.mCaptureCallback = null;
            }
            if (this.mEnrolCallback != null && !this.mReadyToStore) {
                this.mEnrolCallback = null;
            }
            if (this.mIdentifyCallback != null) {
                this.mIdentifyCallback = null;
            }
            this.mIdentifyListener = null;
            this.mClient = null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void setCaptureCallback(CaptureCallback captureCallback) {
        this.mCaptureCallback = captureCallback;
    }

    public void shouldRestartByScreenOn() {
        try {
            String str = TAG;
            Log.i(str, " shouldRestartByScreenOn--------  " + Thread.currentThread().hashCode());
            this.mService.shouldRestartByScreenOn(this.mClient);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void startEnrol(EnrolCallback enrolCallback, int i4) {
        enrolCallback.getClass();
        this.mEnrolCallback = enrolCallback;
        try {
            this.mService.startGuidedEnrol(this.mClient, i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void startIdentify(IdentifyCallback identifyCallback, int[] iArr) {
        if (iArr == null || identifyCallback == null) {
            return;
        }
        this.mIdentifyCallback = identifyCallback;
        try {
            this.mService.startIdentify(this.mClient, iArr);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public boolean updateTA(String str) {
        try {
            return this.mService.updateTA(str);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void startIdentify(IdentifyListener identifyListener, int[] iArr, int i4, int i5) {
        if (iArr != null && identifyListener != null) {
            this.mIdentifyListener = identifyListener;
            this.mUserdata = i5;
            String str = TAG;
            Log.i(str, " startIdentify--------  " + iArr[0]);
            if (i4 > 0) {
                EventHandler eventHandler = this.mEventhHandler;
                eventHandler.sendMessageDelayed(eventHandler.obtainMessage(21, -1, i5), i4);
            }
            try {
                this.mService.startIdentify(this.mClient, iArr);
                return;
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return;
            }
        }
        throw null;
    }
}
