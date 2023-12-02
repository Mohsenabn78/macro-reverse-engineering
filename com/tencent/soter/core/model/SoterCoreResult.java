package com.tencent.soter.core.model;

/* loaded from: classes6.dex */
public class SoterCoreResult implements SoterErrCode {
    public int errCode;
    public String errMsg;

    public SoterCoreResult(int i4, String str) {
        this(i4);
        if (SoterCoreUtil.isNullOrNil(str)) {
            return;
        }
        this.errMsg = str;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof SoterCoreResult) && ((SoterCoreResult) obj).errCode == this.errCode) {
            return true;
        }
        return false;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public boolean isSuccess() {
        if (this.errCode == 0) {
            return true;
        }
        return false;
    }

    public void setErrCode(int i4) {
        this.errCode = i4;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public String toString() {
        return "SoterCoreResult{errCode=" + this.errCode + ", errMsg='" + this.errMsg + "'}";
    }

    public SoterCoreResult(int i4) {
        this.errCode = i4;
        if (i4 == 0) {
            this.errMsg = "ok";
        } else if (i4 != 2) {
            this.errMsg = "errmsg not specified";
        } else {
            this.errMsg = "device not support soter";
        }
    }
}
