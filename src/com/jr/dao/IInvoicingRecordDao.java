package com.jr.dao;

import com.jr.entry.InvoicingRecord;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao
 * @version: 1.0
 */
public interface IInvoicingRecordDao {

    //根据企业id查询全部
    //传入：int 企业ID
    //返回：List<InvoicingRecord> 与企业ID有关的发票的展示
    public List<InvoicingRecord> selectIRByEId(int enterpriseId);

    public List<InvoicingRecord> selectIRByStatus(int enterpriseId,String status);
    public List<InvoicingRecord> selectIRByTitle(int enterpriseId,String title);
    //查金额
    public List<InvoicingRecord> selectIRByEidAmountMin(int enterpriseId,int amount);
    public List<InvoicingRecord> selectIRByEidAmountMax(int enterpriseId,int amount);


    //开票
    //传入：InvoicingRecord对象 全部信息
    //返回：int 受影响行数
    public int insertIR(InvoicingRecord invoicingRecord);

    //退票 修改状态为已作废
    //传入：int 开票记录表主键
    //返回：int 受影响行数
    public int updateIRStatus(int iid);

    //详情 根据发票id查询全部
    //传入：int 开票记录表主键
    //返回：InvoicingRecord对象 全部信息
    public List<InvoicingRecord> selectIRByIId(InvoicingRecord invoicingRecord);


}
