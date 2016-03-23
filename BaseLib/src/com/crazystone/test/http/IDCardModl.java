package com.crazystone.test.http;

/**
 * Created by crazystone on 2016/3/23.
 */
public class IDCardModl {


    /**
     * errNum : 0
     * retMsg : success
     * retData : {"address":"湖北省孝感市汉川市","sex":"M","birthday":"1987-04-20"}
     */

    private int errNum;
    private String retMsg;
    /**
     * address : 湖北省孝感市汉川市
     * sex : M
     * birthday : 1987-04-20
     */

    private RetDataModel retData;

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public void setRetData(RetDataModel retData) {
        this.retData = retData;
    }

    public int getErrNum() {
        return errNum;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public RetDataModel getRetData() {
        return retData;
    }

    public static class RetDataModel {
        private String address;
        private String sex;
        private String birthday;

        public void setAddress(String address) {
            this.address = address;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress() {
            return address;
        }

        public String getSex() {
            return sex;
        }

        public String getBirthday() {
            return birthday;
        }
    }
}
