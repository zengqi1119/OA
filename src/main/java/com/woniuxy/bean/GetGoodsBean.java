package com.woniuxy.bean;

import java.io.Serializable;
import java.util.List;

import com.woniuxy.entity.Approvalstate;
import com.woniuxy.entity.Getgoods;

public class GetGoodsBean implements Serializable{

		private List<Getgoods> getGoods;
		private List<String> unames;
		private List<Approvalstate> apstate;
		@Override
		public String toString() {
			return "GetGoodsBean [getGoods=" + getGoods + ", unames=" + unames + ", apstate=" + apstate + "]";
		}
		public GetGoodsBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public List<Getgoods> getGetGoods() {
			return getGoods;
		}
		public void setGetGoods(List<Getgoods> getGoods) {
			this.getGoods = getGoods;
		}
		public List<String> getUnames() {
			return unames;
		}
		public void setUnames(List<String> unames) {
			this.unames = unames;
		}
		public List<Approvalstate> getApstate() {
			return apstate;
		}
		public void setApstate(List<Approvalstate> apstate) {
			this.apstate = apstate;
		}
		public GetGoodsBean(List<Getgoods> getGoods, List<String> unames, List<Approvalstate> apstate) {
			super();
			this.getGoods = getGoods;
			this.unames = unames;
			this.apstate = apstate;
		}
		
		
}
