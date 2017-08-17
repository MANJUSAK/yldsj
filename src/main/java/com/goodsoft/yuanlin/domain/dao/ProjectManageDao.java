package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.project.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 项目管理dao层
 * Created by 严彬荣 on 2017/8/11.
 */
@Repository
public interface ProjectManageDao {
    //查询变更管理数据dao方法
    public List<Alteration> queryAlterationDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询工序报验数据dao方法
    public List<Checkout> queryCheckoutDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询施工日志数据dao方法
    public List<ConsLog> queryConsLogDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询施工安全日志数据dao方法
    public List<ConsSafetyLog> queryConsSafetyLogDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询进度申报数据dao方法
    public List<Declaration> queryDeclarationDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询设备信息数据dao方法
    public List<Equipment> queryEquipmentDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询竣工验收数据dao方法
    public List<Finalaccept> queryFinalacceptDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询会审结果数据dao方法
    public List<HsResult> queryHsResultDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询开工报告数据dao方法
    public List<KgReport> queryKgReportDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询我的轨迹数据dao方法
    public List<Mylocus> queryMylocusDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询项目信息数据dao方法
    public List<Project> queryProjectDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询现场施工数据dao方法
    public List<Prospect> queryProspectDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询施工人员数据dao方法
    public List<SgPersonnel> querySgPersonnelDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询项目结算数据dao方法
    public List<Settlement> querySettlementDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询监理日志数据dao方法
    public List<Suplog> querySuplogDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询供货商数据dao方法
    public List<Supplier> querySupplierDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //查询技术交底数据dao方法
    public List<Technology> queryTechnologyDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //添加施工钱包数据dao方法
    public List<SgWallet> querySgWalletDao(@Param("uid") String uid, @Param("deptId") String deptId, @Param("page") int page) throws Exception;

    //添加变更管理数据dao方法
    public void addAlterationDao(Alteration msg) throws Exception;

    //添加工序报验数据dao方法
    public void addCheckoutDao(Checkout msg) throws Exception;

    //添加施工日志数据dao方法
    public void addConsLogDao(ConsLog msg) throws Exception;

    //添加施工安全日志数据dao方法
    public void addConsSafetyLogDao(ConsSafetyLog msg) throws Exception;

    //添加进度申报数据dao方法
    public void addDeclarationDao(Declaration msg) throws Exception;

    //添加设备信息数据dao方法
    public void addEquipmentDao(Equipment msg) throws Exception;

    //添加竣工验收数据dao方法
    public void addFinalacceptDao(Finalaccept msg) throws Exception;

    //添加会审结果数据dao方法
    public void addHsResultDao(HsResult msg) throws Exception;

    //添加开工报告数据dao方法
    public void addKgReportDao(KgReport msg) throws Exception;

    //添加我的轨迹数据dao方法
    public void addMylocusDao(Mylocus msg) throws Exception;

    //添加项目信息数据dao方法
    public void addProjectDao(Project msg) throws Exception;

    //添加现场施工数据dao方法
    public void addProspectDao(Prospect msg) throws Exception;

    //添加项目结算数据dao方法
    public void addSettlementDao(Settlement msg) throws Exception;

    //添加施工人员数据dao方法
    public void addSgPersonnelDao(SgPersonnel msg) throws Exception;

    //添加监理日志数据dao方法
    public void addSuplogDao(Suplog msg) throws Exception;

    //添加供货商数据dao方法
    public void addSupplierDao(Supplier msg) throws Exception;

    //添加技术交底数据dao方法
    public void addTechnologyDao(Technology msg) throws Exception;

    //添加施工钱包数据dao方法
    public void addSgWalletDao(SgWallet msg) throws Exception;

}
