package day06;

import java.util.ArrayList;

public class MemberDataBean {
	ArrayList<MemberBean> datas = new ArrayList<MemberBean>();

	public ArrayList<MemberBean> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<MemberBean> datas) {
		this.datas = datas;
	}
	
	public void add(MemberBean mb) {
		datas.add(mb);
	}
	
	public MemberBean search(String sname) {
		System.out.println("sname: "+sname);
		for(MemberBean v:datas) {
			if(v.getUname().equals(sname)) {
				return v;
			}
		}
		return null;
	}
}
