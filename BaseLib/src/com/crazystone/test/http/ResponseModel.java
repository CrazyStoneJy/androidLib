package com.crazystone.test.http;

import java.util.List;

/**
 * Created by crazystone on 2016/3/7.
 */
public class ResponseModel {


    /**
     * pFundId : 922
     * minAmount : 1000
     * cAssetId : 0
     * fundManagerInstruction : 骆帅:清华大学管理科学与工程专业硕士,具有基金从业资格,2009年7月加入南方基金,担任研究部研究员、高级研究员;2014年3月至2015年5月,任南方成份、南方安心基金经理助理;2015年5月至今,任南方高端装备基金经理。
     * growthRate : 0
     * fundAllCount : 1406
     * feexv : 1.8
     * fundType : 1
     * publisherId : 57
     * BriefIntro :  本基金由基金管理人依照《基金法》、《运作办法》、《销售办法》、基金合同及其他有关规定，并经中国证监会2008年4月25日证监许可[2008]596号文批准募集。本基金的管理人和注册登记人为南方基金管理有限公司，基金托管人为中国工商银行股份有限公司。本基金募集期自2008年5月12日至2008年6月13日，通过基金管理人的直销网点及基金代销机构的代销网点公开发售。
     * pName : 南方价值(前端)
     * consignFeeRate : 0
     * fundCode : 202011
     * pFundName : 南方价值(前端)
     * pType : 11
     * fundRank : 1204
     * fundThreeMonthFlow : -29.0598
     * pId : 924
     * fundManagerName : 骆帅,罗安安
     * DailyProfit : 0
     * manageFeeRate : 0
     * NVDailyGrowthRate : -0.03783319
     * publisher : 南方基金管理有限公司
     * ratem : 0
     * propertyScale : 8.3714171435E8
     * fNVDailyGrowthRate : -0.00852515
     * latestWeeklyYield : 0
     * purchaseState : 0
     * currentValue : 1.163
     * index : 0
     */

    private DataModel data;
    /**
     * fundSevenDaysFlow : -4.6848
     * fundYearFlow : 2.9214
     * fundMonthFlow : -10.0482
     * fundAllCount : 1406
     * fundRank : 1204
     * fundThreeMonthFlow : -29.0598
     * DailyProfit : 0
     * fundCurrentValue : 1.119
     * index : 0
     */

    private ZhangdieModel zhangdie;
    /**
     * data : {"pFundId":922,"minAmount":1000,"cAssetId":0,"fundManagerInstruction":"骆帅:清华大学管理科学与工程专业硕士,具有基金从业资格,2009年7月加入南方基金,担任研究部研究员、高级研究员;2014年3月至2015年5月,任南方成份、南方安心基金经理助理;2015年5月至今,任南方高端装备基金经理。","growthRate":0,"fundAllCount":1406,"feexv":1.8,"fundType":1,"publisherId":57,"BriefIntro":" 本基金由基金管理人依照《基金法》、《运作办法》、《销售办法》、基金合同及其他有关规定，并经中国证监会2008年4月25日证监许可[2008]596号文批准募集。本基金的管理人和注册登记人为南方基金管理有限公司，基金托管人为中国工商银行股份有限公司。本基金募集期自2008年5月12日至2008年6月13日，通过基金管理人的直销网点及基金代销机构的代销网点公开发售。","pName":"南方价值(前端)","consignFeeRate":0,"fundCode":"202011","pFundName":"南方价值(前端)","pType":11,"fundRank":1204,"fundThreeMonthFlow":-29.0598,"pId":924,"fundManagerName":"骆帅,罗安安","DailyProfit":0,"manageFeeRate":0,"NVDailyGrowthRate":-0.03783319,"publisher":"南方基金管理有限公司","ratem":0,"propertyScale":8.3714171435E8,"fNVDailyGrowthRate":-0.00852515,"latestWeeklyYield":0,"purchaseState":"0","currentValue":1.163,"index":0}
     * newses : []
     * zhangdie : {"fundSevenDaysFlow":-4.6848,"fundYearFlow":2.9214,"fundMonthFlow":-10.0482,"fundAllCount":1406,"fundRank":1204,"fundThreeMonthFlow":-29.0598,"DailyProfit":0,"fundCurrentValue":1.119,"index":0}
     * zhongCang : [{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0},{"data":[],"mount":0,"index":0}]
     * count : 0
     * start : 0
     * total : 0
     * status : 1
     * currentTime : 2016-03-07 14:12:17
     */

    private int count;
    private int start;
    private int total;
    private int status;
    private String currentTime;
    private List<?> newses;
    /**
     * data : []
     * mount : 0
     * index : 0
     */

    private List<ZhongCangModel> zhongCang;

    public void setData(DataModel data) {
        this.data = data;
    }

    public void setZhangdie(ZhangdieModel zhangdie) {
        this.zhangdie = zhangdie;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public void setNewses(List<?> newses) {
        this.newses = newses;
    }

    public void setZhongCang(List<ZhongCangModel> zhongCang) {
        this.zhongCang = zhongCang;
    }

    public DataModel getData() {
        return data;
    }

    public ZhangdieModel getZhangdie() {
        return zhangdie;
    }

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public int getStatus() {
        return status;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public List<?> getNewses() {
        return newses;
    }

    public List<ZhongCangModel> getZhongCang() {
        return zhongCang;
    }

    public static class DataModel {
        private int pFundId;
        private int minAmount;
        private int cAssetId;
        private String fundManagerInstruction;
        private int growthRate;
        private int fundAllCount;
        private double feexv;
        private int fundType;
        private int publisherId;
        private String BriefIntro;
        private String pName;
        private int consignFeeRate;
        private String fundCode;
        private String pFundName;
        private int pType;
        private int fundRank;
        private double fundThreeMonthFlow;
        private int pId;
        private String fundManagerName;
        private int DailyProfit;
        private int manageFeeRate;
        private double NVDailyGrowthRate;
        private String publisher;
        private int ratem;
        private double propertyScale;
        private double fNVDailyGrowthRate;
        private int latestWeeklyYield;
        private String purchaseState;
        private double currentValue;
        private int index;

        public void setPFundId(int pFundId) {
            this.pFundId = pFundId;
        }

        public void setMinAmount(int minAmount) {
            this.minAmount = minAmount;
        }

        public void setCAssetId(int cAssetId) {
            this.cAssetId = cAssetId;
        }

        public void setFundManagerInstruction(String fundManagerInstruction) {
            this.fundManagerInstruction = fundManagerInstruction;
        }

        public void setGrowthRate(int growthRate) {
            this.growthRate = growthRate;
        }

        public void setFundAllCount(int fundAllCount) {
            this.fundAllCount = fundAllCount;
        }

        public void setFeexv(double feexv) {
            this.feexv = feexv;
        }

        public void setFundType(int fundType) {
            this.fundType = fundType;
        }

        public void setPublisherId(int publisherId) {
            this.publisherId = publisherId;
        }

        public void setBriefIntro(String BriefIntro) {
            this.BriefIntro = BriefIntro;
        }

        public void setPName(String pName) {
            this.pName = pName;
        }

        public void setConsignFeeRate(int consignFeeRate) {
            this.consignFeeRate = consignFeeRate;
        }

        public void setFundCode(String fundCode) {
            this.fundCode = fundCode;
        }

        public void setPFundName(String pFundName) {
            this.pFundName = pFundName;
        }

        public void setPType(int pType) {
            this.pType = pType;
        }

        public void setFundRank(int fundRank) {
            this.fundRank = fundRank;
        }

        public void setFundThreeMonthFlow(double fundThreeMonthFlow) {
            this.fundThreeMonthFlow = fundThreeMonthFlow;
        }

        public void setPId(int pId) {
            this.pId = pId;
        }

        public void setFundManagerName(String fundManagerName) {
            this.fundManagerName = fundManagerName;
        }

        public void setDailyProfit(int DailyProfit) {
            this.DailyProfit = DailyProfit;
        }

        public void setManageFeeRate(int manageFeeRate) {
            this.manageFeeRate = manageFeeRate;
        }

        public void setNVDailyGrowthRate(double NVDailyGrowthRate) {
            this.NVDailyGrowthRate = NVDailyGrowthRate;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public void setRatem(int ratem) {
            this.ratem = ratem;
        }

        public void setPropertyScale(double propertyScale) {
            this.propertyScale = propertyScale;
        }

        public void setFNVDailyGrowthRate(double fNVDailyGrowthRate) {
            this.fNVDailyGrowthRate = fNVDailyGrowthRate;
        }

        public void setLatestWeeklyYield(int latestWeeklyYield) {
            this.latestWeeklyYield = latestWeeklyYield;
        }

        public void setPurchaseState(String purchaseState) {
            this.purchaseState = purchaseState;
        }

        public void setCurrentValue(double currentValue) {
            this.currentValue = currentValue;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getPFundId() {
            return pFundId;
        }

        public int getMinAmount() {
            return minAmount;
        }

        public int getCAssetId() {
            return cAssetId;
        }

        public String getFundManagerInstruction() {
            return fundManagerInstruction;
        }

        public int getGrowthRate() {
            return growthRate;
        }

        public int getFundAllCount() {
            return fundAllCount;
        }

        public double getFeexv() {
            return feexv;
        }

        public int getFundType() {
            return fundType;
        }

        public int getPublisherId() {
            return publisherId;
        }

        public String getBriefIntro() {
            return BriefIntro;
        }

        public String getPName() {
            return pName;
        }

        public int getConsignFeeRate() {
            return consignFeeRate;
        }

        public String getFundCode() {
            return fundCode;
        }

        public String getPFundName() {
            return pFundName;
        }

        public int getPType() {
            return pType;
        }

        public int getFundRank() {
            return fundRank;
        }

        public double getFundThreeMonthFlow() {
            return fundThreeMonthFlow;
        }

        public int getPId() {
            return pId;
        }

        public String getFundManagerName() {
            return fundManagerName;
        }

        public int getDailyProfit() {
            return DailyProfit;
        }

        public int getManageFeeRate() {
            return manageFeeRate;
        }

        public double getNVDailyGrowthRate() {
            return NVDailyGrowthRate;
        }

        public String getPublisher() {
            return publisher;
        }

        public int getRatem() {
            return ratem;
        }

        public double getPropertyScale() {
            return propertyScale;
        }

        public double getFNVDailyGrowthRate() {
            return fNVDailyGrowthRate;
        }

        public int getLatestWeeklyYield() {
            return latestWeeklyYield;
        }

        public String getPurchaseState() {
            return purchaseState;
        }

        public double getCurrentValue() {
            return currentValue;
        }

        public int getIndex() {
            return index;
        }
    }

    public static class ZhangdieModel {
        private double fundSevenDaysFlow;
        private double fundYearFlow;
        private double fundMonthFlow;
        private int fundAllCount;
        private int fundRank;
        private double fundThreeMonthFlow;
        private int DailyProfit;
        private double fundCurrentValue;
        private int index;

        public void setFundSevenDaysFlow(double fundSevenDaysFlow) {
            this.fundSevenDaysFlow = fundSevenDaysFlow;
        }

        public void setFundYearFlow(double fundYearFlow) {
            this.fundYearFlow = fundYearFlow;
        }

        public void setFundMonthFlow(double fundMonthFlow) {
            this.fundMonthFlow = fundMonthFlow;
        }

        public void setFundAllCount(int fundAllCount) {
            this.fundAllCount = fundAllCount;
        }

        public void setFundRank(int fundRank) {
            this.fundRank = fundRank;
        }

        public void setFundThreeMonthFlow(double fundThreeMonthFlow) {
            this.fundThreeMonthFlow = fundThreeMonthFlow;
        }

        public void setDailyProfit(int DailyProfit) {
            this.DailyProfit = DailyProfit;
        }

        public void setFundCurrentValue(double fundCurrentValue) {
            this.fundCurrentValue = fundCurrentValue;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public double getFundSevenDaysFlow() {
            return fundSevenDaysFlow;
        }

        public double getFundYearFlow() {
            return fundYearFlow;
        }

        public double getFundMonthFlow() {
            return fundMonthFlow;
        }

        public int getFundAllCount() {
            return fundAllCount;
        }

        public int getFundRank() {
            return fundRank;
        }

        public double getFundThreeMonthFlow() {
            return fundThreeMonthFlow;
        }

        public int getDailyProfit() {
            return DailyProfit;
        }

        public double getFundCurrentValue() {
            return fundCurrentValue;
        }

        public int getIndex() {
            return index;
        }
    }

    public static class ZhongCangModel {
        private int mount;
        private int index;
        private List<?> data;

        public void setMount(int mount) {
            this.mount = mount;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setData(List<?> data) {
            this.data = data;
        }

        public int getMount() {
            return mount;
        }

        public int getIndex() {
            return index;
        }

        public List<?> getData() {
            return data;
        }
    }
}
