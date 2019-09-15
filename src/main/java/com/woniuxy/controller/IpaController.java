package com.woniuxy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.IpaPages;
import com.woniuxy.entity.Relation;
import com.woniuxy.service.IpaService;
@Controller
@RequestMapping("/ipa")
public class IpaController {
	@Autowired
	IpaService ipaService;

	/* 查询通讯信息名单,将条件查询和查询所有结合一起 */
	@RequestMapping("/findIpa")
	public String findIpa(Model model, String uname, HttpServletRequest request,Integer seid) {
//		System.out.println("uname:"+uname);
//		System.out.println("seid:"+seid);
		int indexPage = getIndexPage(request);
		int pageSize = 2;
		IpaPages<Relation> pages = ipaService.selectRelationByPage(uname, indexPage, pageSize,seid);
		List<Relation> ipas = pages.getIpaList();
		model.addAttribute("uname", uname);
		model.addAttribute("ipaPage", pages);
		model.addAttribute("ipas", ipas);
		return "system/addressList";
	}

	/* 更新已有的通讯人员信息 */
	@RequestMapping("/updataIpa")
	@ResponseBody
	@RequiresRoles("admin")
	public int updataIpa(String uname, Relation relation) {
		/* 通过传入的参数，查询数据库对应的信息，返回给前端 进行修改 */
		try {
			//System.out.println(relation);
			ipaService.updateIpa(relation);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/* 删除已有的通讯人员信息 */
	@RequestMapping("/delete/{mobilephone}")
	@RequiresRoles("admin")
	public String deleteIpa(@PathVariable("mobilephone") String mobilephone, Model model) {
		/* 此处利用软删除将flag改为1 */
		ipaService.deleteIpaByMobilephone(mobilephone);
		return "redirect:/ipa/findIpa";
	}

	/* 添加通讯人员信息 */
	@RequestMapping("/insertIpa")
	@RequiresRoles("admin")
	public String insertIpa(Relation relation, String uname, Model model) {
		try {
			ipaService.insertIpa(relation);
			model.addAttribute("msg", "添加成功！！");
			return "redirect:/ipa/findIpa";
		} catch (Exception e) {
			model.addAttribute("msg", "添加失败！！");
			return "redirect:/ipa/findIpa";
		}

	}
	
	//获取当前页码
		private int getIndexPage(HttpServletRequest request) {
			String parameter = request.getParameter("indexPage");
		//	System.out.println(parameter);
			if (StringUtils.isEmpty(parameter)) {
				return 1;
			} else {
				try {
					int indexPage = Integer.parseInt(parameter);
					return indexPage;
				} catch (Exception e) {
					return 1;
				}

			}
		}

}
