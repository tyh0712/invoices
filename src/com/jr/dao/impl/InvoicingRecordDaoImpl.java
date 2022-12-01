package com.jr.dao.impl;

import com.jr.dao.IInvoicingRecordDao;
import com.jr.entry.InvoicingRecord;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao.impl
 * @version: 1.0
 */
public class InvoicingRecordDaoImpl implements IInvoicingRecordDao {

    @Override
    public List<InvoicingRecord> selectIRByEId(int enterpriseId) {
        return null;
    }

    @Override
    public int insertIR(InvoicingRecord invoicingRecord) {
        return 0;
    }

    @Override
    public int updateIRStatus(int iid) {
        return 0;
    }

    @Override
    public InvoicingRecord selectIRByIId(int iid) {
        return null;
    }
}
