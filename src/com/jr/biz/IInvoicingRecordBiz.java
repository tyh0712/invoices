package com.jr.biz;

import com.jr.entry.InvoicingRecord;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz
 * @version: 1.0
 */
public interface IInvoicingRecordBiz {

    //完成发票申请列表
    public List<InvoicingRecord> getIRList(int enterpriseId);


    public List<InvoicingRecord> selectStatusList(int enterpriseId,String status);

    public List<InvoicingRecord> selectIRByTitle(int enterpriseId,String title);

    public List<InvoicingRecord> getIRAmountMinList(int enterpriseId,int amount);

    public List<InvoicingRecord> getIRAmountMaxList(int enterpriseId,int amount);


    //开票 实现向数据库中添加
    public boolean invoicingIR(InvoicingRecord invoicingRecord);

    //退票 修改状态为已作废
    public boolean refundIR(int iid);

    //详情 根据发票id查询全部
    public List<InvoicingRecord> detailIR(InvoicingRecord invoicingRecord);
}
