package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.IpaPages;
import com.woniuxy.entity.Relation;
import com.woniuxy.entity.Stateemployees;
import com.woniuxy.mapper.RelationMapper;
import com.woniuxy.mapper.StateemployeesMapper;
import com.woniuxy.service.IpaService;

@Service
public class IpaServiceImp implements IpaService {
	//注入mapper属性
	@Autowired
	RelationMapper relationMapper;
	@Autowired
	StateemployeesMapper Stateemployees;
	/* 删除联系人 */
	@Override
	public void deleteIpaByMobilephone(String mobilephone) {
		relationMapper.deleteIpaByMobilephone(mobilephone);
	}
	/* 插入联系人*/
	@Override
	public void insertIpa(Relation relation) {
		relationMapper.insertSelective(relation);
	}
	/* 更新联系人 */
	@Override
	public void updateIpa(Relation relation) {
		relationMapper.updateIpaByRelation(relation);
	}
	/*根据条件获取联系人总数量，用于分页*/
	@Override
	public int selectCountByMes(String uname,Integer seid) {
		int totalCount=relationMapper.selectCountByMes(uname,seid);
		return totalCount;
	}
	/* 根据条件查询联系人，并封装在IpaPages中 */
	@Override
	public IpaPages<Relation> selectRelationByPage(String uname, int indexPage, int pageSize,Integer seid) {
		int totalCount=relationMapper.selectCountByMes(uname,seid);
		int realIdex = (indexPage - 1) * pageSize;
		List<Relation> pages=relationMapper.selectRelationByPage(uname,realIdex,pageSize,seid);
		IpaPages<Relation> ipas=new IpaPages<>();
		if(seid!=null && seid!=0) {
			Stateemployees stateemloyees = Stateemployees.selectByPrimaryKey(seid);
				ipas.setState(stateemloyees.getState());
		}
		int totalpage=totalCount/pageSize;
		ipas.setIndexPage(indexPage);
		ipas.setIpaList(pages);
		ipas.setPageSize(pageSize);
		ipas.setTotalCount(totalCount);
		ipas.setTotalpage(totalpage);
		return ipas;
	}
	@Override
	public String selectStateemployeesBySeid(Integer seid) {
		Stateemployees states = Stateemployees.selectByPrimaryKey(seid);
		return states.getState();
	}
}
