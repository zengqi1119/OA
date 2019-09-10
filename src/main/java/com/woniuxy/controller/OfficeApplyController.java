package com.woniuxy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.PageBean;
import com.woniuxy.entity.Buygoods;
import com.woniuxy.entity.Getgoods;
import com.woniuxy.service.OfficeApplyService;

//申领
@Controller
@RequestMapping("/apply")
public class OfficeApplyController {
	@Autowired
	private OfficeApplyService  officeApplyService;
	
	public void setOfficeApplyService(OfficeApplyService officeApplyService) {
		this.officeApplyService = officeApplyService;
	}

	// 申购展示查询
	@RequestMapping("/officeApply/{placeholder}/{currentPage}")
	public String officeSubscribe(@PathVariable("placeholder") String uname, Model model, HttpServletRequest request,
			Buygoods buygoods, @PathVariable("currentPage") Integer currentPage) {
		int currentpage = currentPage;
		int count = 8;
		// 模糊查询 名字找uid
		List<Integer> uid = officeApplyService.selectUidByUname(uname);
		PageBean<Getgoods> officeApplies = officeApplyService.selectAllMessage(currentpage, count, uid);
		// 翻页url
		officeApplies.setUrl(getUrlMessage(request, currentPage, uname));
		model.addAttribute("officeApplies", officeApplies);
		model.addAttribute("uname", uname);
		return "system/officeApply";
	}

	// 获取url上的后缀信息
	private String getUrlMessage(HttpServletRequest request, Integer currentPage, String uname) {
		String servletPath = request.getServletPath();
		if (servletPath.indexOf("" + uname) != -1) { // 没有这样的字符，则返回 -1。
			servletPath = servletPath.substring(0, servletPath.indexOf("" + currentPage));
		} // substring 截取索引从 0 开始。不包括结束索引
		return servletPath;
	}
	
	
	
	//删除
	@RequestMapping("/deleteGoods/{gid}")
	public String deleteGoods(@PathVariable("gid")Integer gid) {
		officeApplyService.deleteOfficeApply(gid);
		return "redirect:/apply/officeApply/null/1";
	}
	
	//修改
	@ResponseBody
	@RequestMapping("/updateGoods")
	public String updateGood(Getgoods getgoods) {
		try {
			officeApplyService.updateOfficeApply(getgoods); 
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
		return "成功";
	}

	
	  //添加
	@ResponseBody
	@RequestMapping("/addGoods")
	public String addGoods(Getgoods getgoods) {
		try {
			officeApplyService.addOfficeApply(getgoods); 
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
		return "成功";
	  }
}
