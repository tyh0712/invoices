package com.jr.biz.impl;

import com.jr.biz.IInvoicingRecordBiz;
import com.jr.entry.InvoicingRecord;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class InvoicingRecordBizImpl implements IInvoicingRecordBiz {

    @Override
    public List<InvoicingRecord> getIRList(int enterpriseId) {
        return null;
    }

    @Override
    public boolean invoicingIR(InvoicingRecord invoicingRecord) {
        return false;
    }

    @Override
    public boolean refundIR(int iid) {
        return false;
    }

    @Override
    public InvoicingRecord detailIR(int iid) {
        return null;
    }
}
