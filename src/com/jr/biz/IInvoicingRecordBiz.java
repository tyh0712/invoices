package com.jr.biz;

import com.jr.entry.InvoicingRecord;

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

    //开票 实现向数据库中添加
    public boolean invoicingIR(InvoicingRecord invoicingRecord);

    //退票 修改状态为已作废
    public boolean refundIR(int iid);

    //详情 根据发票id查询全部
    public InvoicingRecord detailIR(int iid);
}
