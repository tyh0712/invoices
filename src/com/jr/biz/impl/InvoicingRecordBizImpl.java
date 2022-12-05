package com.jr.biz.impl;

import com.jr.biz.IInvoicingRecordBiz;
import com.jr.dao.impl.InvoicingRecordDaoImpl;
import com.jr.entry.InvoicingRecord;

import java.sql.Timestamp;
import java.util.Date;
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
    public List<InvoicingRecord> selectStatusList(int enterpriseId, String status) {
        return irdi.selectIRByStatus(enterpriseId,status);
    }

    @Override
    public List<InvoicingRecord> selectIRByTitle(int enterpriseId, String title) {
        return irdi.selectIRByTitle(enterpriseId,title);
    }


    @Override
    public List<InvoicingRecord> getIRAmountMinList(int enterpriseId, int amount) {
        return irdi.selectIRByEidAmountMin(enterpriseId,amount);
    }

    @Override
    public List<InvoicingRecord> getIRAmountMaxList(int enterpriseId, int amount) {
        return irdi.selectIRByEidAmountMax(enterpriseId,amount);
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
    public InvoicingRecord detailIR(int iid) {
        return irdi.selectIRByIId(iid);
    }
}
