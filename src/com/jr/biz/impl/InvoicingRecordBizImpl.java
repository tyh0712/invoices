package com.jr.biz.impl;

import com.jr.biz.IInvoicingRecordBiz;
import com.jr.dao.impl.InvoicingRecordDaoImpl;
import com.jr.entry.InvoicingRecord;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class InvoicingRecordBizImpl implements IInvoicingRecordBiz {
    InvoicingRecordDaoImpl irdi=new InvoicingRecordDaoImpl();
    @Override
    public List<InvoicingRecord> getIRList(int enterpriseId) {
        return irdi.selectIRByEId(enterpriseId);
    }

    @Override
    public boolean invoicingIR(InvoicingRecord invoicingRecord) {
        return irdi.insertIR(invoicingRecord)==1?true:false;
    }

    @Override
    public boolean refundIR(int iid) {
        return irdi.updateIRStatus(iid)==1?true:false;
    }

    @Override
    public List<InvoicingRecord> detailIR(int iid) {
        return irdi.selectIRByIId(iid);
    }
}
