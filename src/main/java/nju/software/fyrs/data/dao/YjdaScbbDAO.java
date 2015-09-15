package nju.software.fyrs.data.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import nju.software.fyrs.data.dataobject.Ajjtxx;
import nju.software.fyrs.data.dataobject.Gryjda;
import nju.software.fyrs.util.DateUtil;

import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class YjdaScbbDAO extends HibernateDaoSupport{
	private String fdate;
	private String tdate;
	// ѡ�����в���
    // ѡ��ְ��
	// ѡ��ְ��
	private String[] bmZwZjSQL = {"SELECT PUB_DMB.LBBH, PUB_DMB.DMBH, PUB_DMB.DMMS, PUB_DMB.XGDM, PUB_DMB.BZ FROM PUB_DMB WHERE ( PUB_DMB.LBBH = 'USR206-99' ) AND (PUB_DMB.BZ like '%����%'  ) AND DMMS <> '���鰸��' ORDER BY PUB_DMB.DMBH ASC ","SELECT PUB_DMB.LBBH, PUB_DMB.DMBH, PUB_DMB.DMMS, PUB_DMB.XGDM, PUB_DMB.BZ FROM PUB_DMB WHERE ( PUB_DMB.LBBH = 'USER200-212' ) AND PUB_DMB.DMBH NOT IN ('0A','11','12','99') ORDER BY PUB_DMB.DMBH ASC ","SELECT PUB_DMB.LBBH, PUB_DMB.DMBH, PUB_DMB.DMMS, PUB_DMB.XGDM, PUB_DMB.BZ FROM PUB_DMB WHERE ( PUB_DMB.LBBH = 'FBX0019-97' ) AND PUB_DMB.DMBH NOT IN ('01','02','12','13') ORDER BY PUB_DMB.DMBH ASC "};
	private ArrayList<String> codeFromDataBase = new ArrayList<String>();
	public Gryjda getGryjda(Date dateFrom, Date dateTo,String yhmc){
		SessionFactoryImpl impl =(SessionFactoryImpl)getSessionFactory();
		Gryjda gryjda = new Gryjda();
		ArrayList<String> arraysql = new ArrayList<String>(45);
		arraysql = getSqlDmToAll(impl,yhmc);
		Iterator<String> iterator = arraysql.iterator();
		String fromdate = DateUtil.format(dateFrom, DateUtil.webFormat2);
		String todate = DateUtil.format(dateTo, DateUtil.webFormat2);
		fdate = fromdate;
		tdate = todate;
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		for(int i=0;i<arraysql.size();i++){
			String s = arraysql.get(i);
			s = s.replaceAll("#TJ_BEGIN#", "'"+fromdate+"'");
			s = s.replaceAll("#TJ_BEGIN_JA#", "'"+fromdate+"'");
			s = s.replaceAll("#TJ_END#", "'"+todate+"'");
			arraysql.set(i, s);
		}
		
		Iterator<String> iterator2 = arraysql.iterator();
		while(iterator2.hasNext()){
			System.out.println(iterator2.next());
		}
		int[] jg = getJg(impl,arraysql);
		for(int i=0;i<jg.length;i++){
			System.out.println(jg[i]);
		}
		setStGryjda(gryjda,jg);
		return gryjda;
	}
	
	private void setStGryjda(Gryjda gryjda,int[] jg){
		gryjda.setJcajs(String.valueOf(jg[0]));
		gryjda.setXsajzs(String.valueOf(jg[1]));
		gryjda.setJazs(String.valueOf(jg[2]));
		gryjda.setFdsxnjas(String.valueOf(jg[3]));
		gryjda.setTjs(String.valueOf(jg[4]));
		gryjda.setCss(String.valueOf(jg[5]));
		gryjda.setYsajpss(String.valueOf(jg[6]));
		//gryjda.setYsjycxsyl(String.valueOf(jg[7]));
		gryjda.setEsktsljas(String.valueOf(jg[8]));
		gryjda.setSsajs(String.valueOf(jg[9]));
		gryjda.setBgpfhs(String.valueOf(jg[10]));
		gryjda.setSss(String.valueOf(jg[11]));
		gryjda.setBywjas(String.valueOf(jg[12]));
		gryjda.setZzwjs(String.valueOf(jg[13]));
		gryjda.setZdwjs(String.valueOf(jg[14]));
		gryjda.setZtjswjs(String.valueOf(jg[15]));
		gryjda.setCsxwjs(String.valueOf(jg[16]));
		gryjda.setYsajs(String.valueOf(jg[17]));
		gryjda.setEsajs(String.valueOf(jg[18]));
		gryjda.setZsajs(String.valueOf(jg[19]));
		gryjda.setXftss(String.valueOf(jg[20]));
		gryjda.setCjhytajs(String.valueOf(jg[21]));
		gryjda.setYsjycxjas(String.valueOf(jg[22]));
		gryjda.setXzsczxajs(String.valueOf(jg[23]));
		gryjda.setXsfdmsajs(String.valueOf(jg[24]));
		gryjda.setZxajqzzxs(String.valueOf(jg[25]));
		gryjda.setZxajzdlxs(String.valueOf(jg[26]));
		gryjda.setZxhjajs(String.valueOf(jg[27]));
		//
		gryjda.setZjajs(String.valueOf(jg[34]));
		gryjda.setYzjajsqzxbde(String.valueOf(jg[35]));
		gryjda.setZxdwbde(String.valueOf(jg[36]));
		gryjda.setSxnwja(String.valueOf(jg[37]));
		gryjda.setCsxwjs(String.valueOf(jg[38]));
		gryjda.setJxajs(String.valueOf(jg[39]));
	}
	
	private int[] getJg(SessionFactoryImpl impl,ArrayList<String> array){
		int[] t = new int[45];
		ConnectionProvider provider = impl.getConnectionProvider();
		try {
			Connection conn = provider.getConnection();
			Statement sta = conn.createStatement();
			for(int i=0;i<array.size();i++){
				ResultSet rs = sta.executeQuery(array.get(i));
				while(rs.next()){
					t[i] = rs.getInt(1);
				}
				rs.close();
				System.out.println(i);
			}
			sta.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return t;
	}
	
	private String getSqlDm(SessionFactoryImpl impl,String s){
		ConnectionProvider provider = impl.getConnectionProvider();
		String sql="";
		try {
			Connection conn = provider.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(s);
			while(rs.next()){
				sql = rs.getString(1);
			}
			rs.close();
			sta.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return sql;
	}
	
	private ArrayList<String> getSqlDmToAll(SessionFactoryImpl impl,String yhmc){
		
		ArrayList<String> array = new ArrayList<String>(45);
		String sql_temp = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY"; 
		sql_temp = sql_temp +" where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH";
		sql_temp = sql_temp +" AND PUB_SPRY.XM= '" + yhmc;
		sql_temp = sql_temp +"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' AND ";
		 //�ɴ永��
		String s1 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ��ɴ永��'and BZ='����ͳ��'";
		String tmp1 = getSqlDm(impl,s1);
		codeFromDataBase.add(tmp1);
		s1 = sql_temp + tmp1;
		array.add(s1);
		//���հ���
		String s2 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ����հ���'and BZ='����ͳ��'";
		String tmp2 = getSqlDm(impl,s2);
		codeFromDataBase.add(tmp2);
		s2 = sql_temp + tmp2;
		array.add(s2);
		//�ѽ᰸��new
		String s3 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�ѽ᰸��'and BZ='����ͳ��'";
		String tempstr = getSqlDm(impl,s3);
		codeFromDataBase.add(tempstr);
		array.add(sql_temp+tempstr);
		//�������ѽ᰸	
		String s4 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�����������ѽ᰸'and BZ='����ͳ��'";
		String tmp4 = getSqlDm(impl,s4);
		codeFromDataBase.add(tmp4);
		s4 = sql_temp + tmp4;
		array.add(s4);
		//���°���������
		String s5 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'";
		String tmp5 = getSqlDm(impl,s5);
		codeFromDataBase.add(tmp5);
		s5 = sql_temp + tmp5;
		array.add(s5);
		//���°���������
		String s6 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'";
		String tmp6 = getSqlDm(impl,s6);
		codeFromDataBase.add(tmp6);
		s6 = sql_temp + tmp6;
		array.add(s6);
		
		//һ��������
		String s8 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������'and BZ='����ͳ��'";
		String tmp7 = getSqlDm(impl,s8);
		codeFromDataBase.add(tmp7);
		s8 = sql_temp + tmp7;
		array.add(s8);
		//һ��������ͨ����᰸��
		String s9 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������ͨ����᰸��'and BZ='����ͳ��'";
		String tmp8 = getSqlDm(impl,s9);
		codeFromDataBase.add(tmp8);
		s9 = sql_temp + tmp8;
		array.add(s9);
		//����ͥ��
		String s10 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='����ͥ��'and BZ='����ͳ��'";
		String tmp9 = getSqlDm(impl,s10);
		codeFromDataBase.add(tmp9);
		s10 = sql_temp + tmp9;
		array.add(s10);
		
		//������
		String s12 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='������'and BZ='����ͳ��'";
		String tmp10 = getSqlDm(impl,s12);
		codeFromDataBase.add(tmp10);
		s12 = sql_temp + tmp10;
		array.add(s12);
		
		//�����з�����
		String s14 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�����з�����'and BZ='����ͳ��'";
		String tmp11 = getSqlDm(impl,s14);
		codeFromDataBase.add(tmp11);
		s14 = tmp11;
		s14 = s14 + " AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH ";
		s14 = s14 + " AND PUB_SPRY.XM= '" + yhmc;
		s14 = s14 + "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
		array.add(s14);
		//������
		String s15 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͨ����������'and BZ='����ͳ��'";
		String tmp12 = getSqlDm(impl,s15);
		codeFromDataBase.add(tmp12);
		s15 = tmp12;
		s15 = s15 + " AND PUB_AJ_JB.AJXH = PUB_SPRY.AJXH AND XF_LXDJ.AJXH = PUB_AJ_JB.AJXH ";
		s15 = s15 + " AND PUB_SPRY.XM= '" + yhmc;
		s15 = s15 + "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'"; 
		array.add(s15);
		
		//����δ�᰸
		String s17 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='����δ�᰸'and BZ='����ͳ��'";
		String tmp13 = getSqlDm(impl,s17);
		codeFromDataBase.add(tmp13);
		s17 = sql_temp + tmp13;
		array.add(s17);
		//��ֹδ�᰸
		String s18 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='��ֹδ�᰸'and BZ='����ͳ��'";
		String tmp14 = getSqlDm(impl,s18);
		codeFromDataBase.add(tmp14);
		s18 = sql_temp + tmp14;
		array.add(s18);
		//�ж�δ�᰸
		String s19 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�ж�δ�᰸��'and BZ='����ͳ��'";
		String tmp15 = getSqlDm(impl,s19);
		codeFromDataBase.add(tmp15);
		s19 = sql_temp + tmp15;
		array.add(s19);
		//��ͣ����δ�᰸��
		String s20 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͣ��������δ�᰸��' and BZ='����ͳ��'";
		String tmp16 = getSqlDm(impl,s20);
		codeFromDataBase.add(tmp16);
		s20 = sql_temp + tmp16;
		array.add(s20);
		//18��������δ�᰸��
		String s21 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='18��������δ�᰸����' and BZ='����ͳ��'";
		s21 = sql_temp + getSqlDm(impl,s21);
		array.add(s21);
		//һ��᰸��new
		String spcxdzsql = "DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' ";
		String s22 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='һ�����д���'and BZ='����ͳ��'";
		String tmp17 = getSqlDm(impl,s22);
		codeFromDataBase.add(spcxdzsql+tmp17+")");
		String temp = tmp17;
		array.add(sql_temp+spcxdzsql+temp+")");
		//����᰸��new
		String s23 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��'";
		String tmp18 = getSqlDm(impl,s23);
		codeFromDataBase.add(spcxdzsql+tmp18+")");
		String temp1 = tmp18;
		array.add(sql_temp+spcxdzsql+temp1+")");
		//����᰸��new
		String s24 = spcxdzsql + "AND (DMMS LIKE '__��__' OR DMMS LIKE '__��')"+")";
		codeFromDataBase.add(s24);
		s24 = sql_temp + s24;
		array.add(s24);
		//�ŷ�Ͷ����new
		String s25 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�ŷ�Ͷ����'and BZ='����ͳ��'";
		String tmp20 = getSqlDm(impl,s25);
		codeFromDataBase.add(tmp20);
		s25 = sql_temp + tmp20;
		array.add(s25);
		//�μӺ���ͥ������new
		String s26 = tempstr;
		String STR_SQL = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY"; 
		STR_SQL = STR_SQL +" where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH";
		STR_SQL = STR_SQL +" AND PUB_SPRY.XM= '" + yhmc; 
		STR_SQL = STR_SQL +"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'N' AND ";
		s26 = STR_SQL+ s26;
		codeFromDataBase.add(s26);
		array.add(s26);
		//һ����׳���᰸��
		String s27 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='һ����׳���᰸��' and BZ='����ͳ��'";
		String tmp22 = getSqlDm(impl,s27);
		codeFromDataBase.add(tmp22);
		s27 = sql_temp + tmp22;
		array.add(s27);
		  //�������ִ�а���
		String s28 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�������ִ�а���' and BZ='����ͳ��'";
		String tmp23 = getSqlDm(impl,s28);
		codeFromDataBase.add(tmp23);
		s28 = sql_temp + tmp23;
		array.add(s28);
		//���¸�������
		String s29 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='���¸������½᰸��' and BZ='����ͳ��'";
		String tmp24 = getSqlDm(impl,s29);
		codeFromDataBase.add(tmp24);
		s29 = sql_temp + tmp24;
		array.add(s29);
		//ִ�а���ǿ��ִ��
		String s30 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�а���ǿ��ִ��'and BZ='����ͳ��'";
		String tmp25 = getSqlDm(impl,s30);
		codeFromDataBase.add(tmp25);
		s30 = sql_temp + tmp25;
		array.add(s30);
		//ִ�а����Զ�����
		String s31 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�а����Զ�����'and BZ='����ͳ��'";
		String tmp26 = getSqlDm(impl,s31);
		codeFromDataBase.add(tmp26);
		s31 = sql_temp + tmp26;
		array.add(s31);
		//ִ�а����ͽ�
		String s32 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�а����ͽ�'and BZ='����ͳ��'";
		String tmp27 = getSqlDm(impl,s32);
		codeFromDataBase.add(tmp27);
		s32 = sql_temp + tmp27;
		array.add(s32);
		
		String ss;
		String lrx[]={"CBZASSA","CBZASJA","SPAJS","SPCPWSS","PCCPWSS","CXCCCPWSS"};
		for(int i=33;i<=38;i++){
			ss = "DATEDIFF(DD,FGYG_LRX.RQ,#TJ_BEGIN#)<=0 and DATEDIFF(DD,FGYG_LRX.RQ,#TJ_END#)>=0";
			STR_SQL = "select sum("+lrx[i- 33]+") from FGYG_LRX where FGYG_LRX.XM= '"+yhmc+"' AND ";
			ss=STR_SQL+ ss;
			array.add(ss);
		}
		//ִ�в��Ž᰸����
		String s39 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�в��Ž᰸����'and BZ='����ͳ��'";
		String tmp28 = getSqlDm(impl,s39);
		codeFromDataBase.add(tmp28);
		s39 = sql_temp + tmp28;
		array.add(s39);
		//ִ�������Ķ�
		String s40 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�������Ķ�'and BZ='����ͳ��'";
		s40 = getSqlDm(impl,s40) + " AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH "; 
	    s40 = s40 + " AND PUB_SPRY.XM= '" + yhmc; 
		s40 = s40 +"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
		array.add(s40);
		//ִ�е�λ��Ķ�
		String s41 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�е�λ��λ��'and BZ='����ͳ��'";
		s41 = getSqlDm(impl,s41) + " AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH "; 
	    s41 = s41 + " AND PUB_SPRY.XM= '" + yhmc; 
		s41 = s41 +"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
		array.add(s41);
		//������δ�᰸
		String s42 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='������δ�᰸'and BZ='����ͳ��'";
		String tmp29 = getSqlDm(impl,s42);
		codeFromDataBase.add(tmp29);
		s42 = sql_temp + tmp29;
		array.add(s42);
		//������δ�᰸
		String s43 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='������δ�᰸'and BZ='����ͳ��'";
		String tmp30 = getSqlDm(impl,s43);
		codeFromDataBase.add(tmp30);
		s43 = sql_temp + tmp30;
		array.add(s43);
		//���̰�����
		String s44 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='���̰����᰸��' and BZ='����ͳ��'";
		String tmp31 = getSqlDm(impl,s44);
		codeFromDataBase.add(tmp31);
		s44 = sql_temp + tmp31;
		array.add(s44);
		return array;
	}
	
	public List<Ajjtxx> getAjjtxx(String yhmc,String codeNum){
		SessionFactoryImpl impl =(SessionFactoryImpl)getSessionFactory();
		ArrayList<Ajjtxx> ajjtxxList = new ArrayList<Ajjtxx>();
		//String mc = "��Ծ��";
		String sql_temp = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY"; 
		sql_temp = sql_temp +" where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH";
		sql_temp = sql_temp +" AND PUB_SPRY.XM= '" + yhmc;
		sql_temp = sql_temp +"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' AND ";
		
		String selectYf = "SELECT DISTINCT PUB_AJ_JB.BASPT,PUB_AJ_JB.AJMC,PUB_AJ_JB.LYDQ,PUB_AJ_JB.LARQ,PUB_AJ_JB.SX,PUB_AJ_JB.FJSX,PUB_AJ_JB.AJZT,PUB_SPRY.XM,PUB_AJ_JB.JARQ,PUB_AJ_JB.AJXH,PUB_AJ_JB.AJXZ,PUB_AJ_JB.SPCX,PUB_AJ_JB.SPCXDZ,PUB_AJ_JB.JAFS,PUB_AJ_JB.AH,'0' as shixian FROM PUB_AJ_JB,PUB_SPRY";  
		String s1 = "select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ��ɴ永��'and BZ='����ͳ��'";
		int num = Integer.parseInt(codeNum);
		s1 = codeFromDataBase.get(num);
		if(num==20){
			s1 = selectYf +  " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH and PUB_AJ_JB.AJXH in (select Distinct PUB_AJ_JB.AJXH from PUB_AJ_JB,PUB_SPRY where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_SPRY.XM= '" +yhmc+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'N' and ( " + codeFromDataBase.get(2)+ " ))  AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
		}else{
			s1 = selectYf + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_SPRY.XM= '" +yhmc+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' and ( " + s1 + " )";
		}
		s1 = s1.replaceAll("#TJ_BEGIN#", "'"+fdate+"'");
		s1 = s1.replaceAll("#TJ_BEGIN_JA#", "'"+fdate+"'");
		s1 = s1.replaceAll("#TJ_END#", "'"+tdate+"'");
		System.out.println(s1);
		
		ajjtxxList = getAjlb(impl,s1);
		for(int i=0;i<ajjtxxList.size();i++){
			System.out.println(ajjtxxList.get(i));
		}
		return ajjtxxList;
	}
	
	private ArrayList<Ajjtxx> getAjlb(SessionFactoryImpl impl,String s){
		ArrayList<Ajjtxx> ajjtxxList = new ArrayList<Ajjtxx>();
		ConnectionProvider provider = impl.getConnectionProvider();
		try {
			Connection conn = provider.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(s);
			while(rs.next()){
				Ajjtxx ajjtxx = new Ajjtxx();
				ajjtxx.setBASPT(rs.getString(1));
				ajjtxx.setAJMC(rs.getString(2));
				ajjtxx.setLYDQ(rs.getString(3));
				ajjtxx.setLARQ(rs.getString(4));
				ajjtxx.setSX(rs.getString(5));
				ajjtxx.setFJSX(rs.getString(6));
				ajjtxx.setAJZT(rs.getString(7));
				ajjtxx.setXM(rs.getString(8));
				ajjtxx.setJARQ(rs.getString(9));
				ajjtxx.setAJXH(rs.getString(10));
				ajjtxx.setAJXZ(rs.getString(11));
				ajjtxx.setSPCX(rs.getString(12));
				ajjtxx.setSPCXDZ(rs.getString(13));
				ajjtxx.setJAFS(rs.getString(14));
				ajjtxx.setAH(rs.getString(15));
				ajjtxx.setShixian("0");
				ajjtxxList.add(ajjtxx);
			}
			rs.close();
			sta.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ajjtxxList;
	}
    /**
     * ����ȫԺ����
     * @param dateFrom
     * @param dateTo
     * @param yhmc
     */
	@SuppressWarnings("unused")
	public List<List<String>> getQuanYuanyjda(Date dateFrom, Date dateTo,String yhmc)
	{
		String ls_dz[] = new String[32];
		String ls_dz_t[] = new String[32];
		
		String fromdate = DateUtil.format(dateFrom, DateUtil.webFormat2);
		String todate = DateUtil.format(dateTo, DateUtil.webFormat2);
		String tongqiFromdate = DateUtil.format(DateUtil.addYears(dateFrom,-1), DateUtil.webFormat2); 
		String tongqiTodate = DateUtil.format(DateUtil.addYears(dateTo,-1), DateUtil.webFormat2);
		
		String spcxdzsql = "DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' ";
		
		//�ɴ永��
		ls_dz[1] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ��ɴ永��'and BZ='����ͳ��'");
		//���հ���
		ls_dz[2] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ����հ���'and BZ='����ͳ��'");
		//�ѽ᰸��new
		ls_dz[3] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ѽ᰸��'and BZ='����ͳ��'");
		//�������ѽ᰸
		ls_dz[4] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����������ѽ᰸'and BZ='����ͳ��'");
		//���°���������
		ls_dz[5] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//���°���������
		ls_dz[6] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//һ��᰸��new
		ls_dz[22] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ�����д���'and BZ='����ͳ��'");
		ls_dz[22] = spcxdzsql + ls_dz[22] +")";
		//����᰸��new
		ls_dz[23] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��'");
		ls_dz[23] = spcxdzsql + ls_dz[23] +")";
		//����᰸��new
        //select SQLNR INTO:ls_dz[24]  from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��';
		ls_dz[24] = spcxdzsql + "AND (DMMS LIKE '__��__' OR DMMS LIKE '__��')"+")";
		//�ŷ�Ͷ����new
		ls_dz[25] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ŷ�Ͷ����'and BZ='����ͳ��'");
		//����δ�᰸
		ls_dz[17] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='����δ�᰸'and BZ='����ͳ��'");
		//��ֹδ�᰸
		ls_dz[18] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ֹδ�᰸'and BZ='����ͳ��'");
		//�ж�δ�᰸
		ls_dz[19] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ж�δ�᰸��'and BZ='����ͳ��'");
		//��ͣ����δ�᰸��
		ls_dz[20] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͣ��������δ�᰸��' and BZ='����ͳ��'");
		//18��������δ�᰸��
		ls_dz[21] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='18��������δ�᰸����' and BZ='����ͳ��'");
		
		
		//���߸���
		  ls_dz[28]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' AND  (DMMS LIKE '%��' OR (DMMS LIKE '%��' AND DMMS NOT LIKE '%��%��')) )";
		//���̼���
		  ls_dz[29]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' and DMMS LIKE '��ִ')";
		      //��ͥ������
		  ls_dz[30]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.AJXH in (select PUB_JA_PJ.AJXH from PUB_JA_PJ where PUB_JA_PJ.SFDTXP =  'Y')";

		//���˰���
		  ls_dz[31]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' and DMMS LIKE '__��')";
		for(int i = 1; i < 32; i++)
		{
			ls_dz_t[i] = ls_dz[i];
			if(ls_dz[i] != null)
			{
 		      ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN#","'"+fromdate+"'");
			  ls_dz[i] = ls_dz[i].replaceAll("#TJ_END#", "'"+todate+"'");
			  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN_JA#", "'"+fromdate+"'");	
			  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN#","'"+tongqiFromdate+"'");
			  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_END#", "'"+tongqiTodate+"'");
			  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN_JA#", "'"+tongqiFromdate+"'");
        		 //  System.out.println("sql---->"+ls_dz[i]);
			}			
		}
				
		// ѡ�����в��� 
		List<Object[]> rows = getBmZwZjList(1);
	    long resultCount[][] = new long [rows.size()+2][32];
	    long reallyResult[][] = new long[rows.size()+2][25];
		String[][] results = revertList(rows);
	    // DMBH �ڶ���,DMMS ������
	    for(int i = 0; i < results[0].length; i++)
	    {
	    	// ���ű��
	    	String str_yhbm_e = results[1][i];
	    	// ��������
	    	String yhbm_tem = results[2][i];
	        // System.out.println("---->"+yhbm_tem);
	    	for(int j = 1; j  <32; j++)
	    	{
	    		String oneNumberSql = "";
	    		if(j == 14)
	    		{
	    			oneNumberSql = ls_dz[j] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '" +str_yhbm_e + "'";
	    		}
	    		else if(ls_dz[j] != null)
	    		{
	    			oneNumberSql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +" where PUB_AJ_JB.BASPT = '" +str_yhbm_e + "' AND " + ls_dz[j];  			
	    		}
	    		if(ls_dz[j] != null && j != 26)
	    		{	    
	    			
	    			resultCount[i][j] = getCountResult(oneNumberSql);
	    		}
	    	}
	    	// System.out.println();
	    }
	    //ȫԺ�ϼ�--����
	    for(int i = resultCount.length - 2; i < resultCount.length - 1; i++)
	    {
	    	for(int j = 1; j < 32; j++)
		    {
		    	String oneNumberSql2 = "";
		    	if(j == 14)
		    	{
		    		oneNumberSql2 = ls_dz[j] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT IN (select DMBH from PUB_DMB where LBBH='USR206-99')";
		    	}
		    	else if(ls_dz[j] != null)
		    	{
		    		oneNumberSql2 = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB where PUB_AJ_JB.BASPT IN (select DMBH from PUB_DMB where LBBH='USR206-99') and "  + ls_dz[j];
		    	}
		    	if(ls_dz[j] != null && j != 26)
	    		{	    			
	    			resultCount[i][j] = getCountResult(oneNumberSql2);
	    		}
		    }
	    }
	    //��ȫԺ�ϼ�--ͬ��
	    for(int i = resultCount.length - 1; i < resultCount.length; i++)
	    {
	    	for(int j = 1; j < 32; j++)
		    {
		    	String oneNumberSql3 = "";
		    	if(j == 14)
		    	{
		    		oneNumberSql3 = ls_dz_t[j] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT IN (select DMBH from PUB_DMB where LBBH='USR206-99')";
		    	}
		    	else if(ls_dz_t[j] != null)
		    	{
		    		oneNumberSql3 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB where PUB_AJ_JB.BASPT IN (select DMBH from PUB_DMB where LBBH='USR206-99') and "   + ls_dz_t[j];
		    	}
		    	if(ls_dz_t[j] != null && j != 26)
	    		{	    			
	    			resultCount[i][j] = getCountResult(oneNumberSql3);
	    			// System.out.println("----->result--->"+resultCount[i][j]);
	    		}
		    }
	    }
	    
	    
	    
	    /**
	     * ������˳����ǰ��һ��,����ȫԺ����
	     */
	    List<List<String>> result = new ArrayList<List<String>>();
	    int k = 0;
	    for(int i = 0; i < resultCount.length; i++)
	    {
	    	List<String> bm = new ArrayList<String>();
	    	k = 0;
	    	if(i < results[0].length)
	    	{
	    		bm.add(results[2][i]);
	    	}
	    	if(resultCount.length - 2 == i)
	    	{
	    		bm.add("����ȫԺ�ϼ�");
	    	}
	    	if(resultCount.length - 1 == i)
	    	{
	    		bm.add("ͬ��ȫԺ�ϼ�");
	    	}
	    	//�ɴ�
	    	bm.add(resultCount[i][1]+"");
	    	reallyResult[i][k++] = resultCount[i][1];
	    	//����
	    	bm.add(resultCount[i][2]+"");
	    	reallyResult[i][k++] = resultCount[i][2];
	    	//С��
	    	reallyResult[i][k] = resultCount[i][1]+resultCount[i][2];
	    	bm.add(String.valueOf(reallyResult[i][k++]));
	    	//һ��
	    	bm.add(resultCount[i][22]+"");
	    	reallyResult[i][k++] = resultCount[i][22];
	    	//����
	    	reallyResult[i][k++] = resultCount[i][23];
	    	bm.add(resultCount[i][23]+"");
	    	//����
	    	reallyResult[i][k++] = resultCount[i][24];
	    	bm.add(resultCount[i][24]+"");
	    	//���߸���
	    	reallyResult[i][k++] = resultCount[i][28];
	    	bm.add(resultCount[i][28]+"");
	    	//���̼���
	    	reallyResult[i][k++] = resultCount[i][29];
	    	bm.add(resultCount[i][29]+"");
	    	//���˰���
	    	reallyResult[i][k++] = resultCount[i][31];
	    	bm.add(resultCount[i][31]+"");
	    	//����
	    	reallyResult[i][k] = resultCount[i][3] - resultCount[i][22]- resultCount[i][23]- resultCount[i][24]- resultCount[i][28]- resultCount[i][29]- resultCount[i][31];
	    	bm.add(String.valueOf(reallyResult[i][k++]));
	    	//�᰸����
	    	reallyResult[i][k++] = resultCount[i][3];
	    	bm.add(resultCount[i][3]+"");
	    	//���հ���(%)
	    	if(resultCount[i][2] <= 0 )
	    	{
	    		reallyResult[i][k++] = 0;
	    		bm.add("--");
	    	}
	    	else
	    	{
	    		float temp = (float)resultCount[i][3]/(float)resultCount[i][2]*100;
	    		reallyResult[i][k++] = (long)(Float.valueOf(formatFloat(temp, "0.00"))*100);
	    		bm.add(formatFloat(temp, "0.00"));
	    	}
	    	//�᰸��(%)
	    	long temp12 = resultCount[i][2]+ resultCount[i][1];
	    	if(temp12 <= 0)
	    	{
	    		reallyResult[i][k++] = 0;
	    		bm.add("--");
	    	}
	    	else
	    	{
	    		float temp2 = (float)resultCount[i][3]/(float)temp12*100;
	    		reallyResult[i][k++] = (long)(Float.valueOf(formatFloat(temp2, "0.00"))*100);
	    		bm.add(formatFloat(temp2, "0.00"));
	    	}
	    	// ������������ �᰸��
	    	bm.add(resultCount[i][4]+"");
	    	reallyResult[i][k++] = resultCount[i][4];
	    	// ������������ �᰸��(%)
            if(resultCount[i][3] == 0)
            {
            	reallyResult[i][k++] = 0;
            	bm.add("--");
            }
            else
            {
            	float temp3 = (float)resultCount[i][4]/(float)resultCount[i][3]*100;
            	reallyResult[i][k++] = (long)(Float.valueOf(formatFloat(temp3, "0.00"))*100);
	    		bm.add(formatFloat(temp3, "0.00"));
            }
        	// ����ƽ����������          
            if(i < resultCount.length - 2)
            {
            	String str_yhbm_e = results[1][i];
                long li_temp = getCountResult("select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB  where  PUB_AJ_JB.BASPT = '" + str_yhbm_e + "' AND " + ls_dz[3]);
     	    	if(li_temp == 0)
     	    	{
     	    		bm.add(0+"");
     	    		reallyResult[i][k++] = 0;
     	    	}
     	    	else
     	    	{
     	    		String pjslts_bm = pjslts_bm(str_yhbm_e,fromdate, todate, li_temp);
     	    		reallyResult[i][k++] = (long)(Float.valueOf(pjslts_bm)*100);
     	    		bm.add(pjslts_bm);
     	    		
     	    	}
            }
            if(i == resultCount.length - 2)  //ȫԺ�ϼ�--����
            {
                long li_temp2 = getCountResult("select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB  where PUB_AJ_JB.BASPT IN (select DMBH from PUB_DMB where LBBH='USR206-99') and " + ls_dz[3]);
     	    	if(li_temp2 == 0)
     	    	{
     	    		bm.add(0+"");
     	    		reallyResult[i][k++] = 0;
     	    	}
     	    	else
     	    	{
     	    		String pjslts_quanyuan = pjslts_quanyuan(fromdate, todate, li_temp2);
     	    		reallyResult[i][k++] = (long)(Float.valueOf(pjslts_quanyuan)*100);
     	    		bm.add(pjslts_quanyuan);
     	    		// bm.add(pjslts_bm(str_yhbm_e,"2012-12-21", "2013-12-20", li_temp));;
     	    	}
            }
            if(i == resultCount.length - 1) //��ȫԺ�ϼ�--ͬ��
            {
            	 long li_temp3 = getCountResult("select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB  where PUB_AJ_JB.BASPT IN (select DMBH from PUB_DMB where LBBH='USR206-99') and " + ls_dz_t[3]);
      	    	if(li_temp3 == 0)
      	    	{
      	    		bm.add(0+"");
      	    		reallyResult[i][k++] = 0;
      	    	}
      	    	else
      	    	{
      	    		String pjslts_quanyuan = pjslts_quanyuan(fromdate, todate, li_temp3);
      	    		reallyResult[i][k++] = (long)(Float.valueOf(pjslts_quanyuan)*100);
     	    		bm.add(pjslts_quanyuan);    	    		
      	    		// bm.add(pjslts_bm(str_yhbm_e,"2012-12-21", "2013-12-20", li_temp));;
      	    	}
            }
	    	//��ͥ���а�����
            bm.add(resultCount[i][30]+"");
            reallyResult[i][k++] = resultCount[i][30];
	    	//��ͥ������(%)
            if(resultCount[i][3] == 0)
            {
            	bm.add("--");
            	reallyResult[i][k++] = 0;
            }
            else
            {
            	float temp3 = (float)resultCount[i][30]/(float)resultCount[i][3]*100;
            	reallyResult[i][k++] = (long)(Float.valueOf(formatFloat(temp3, "0.00"))*100);
	    		bm.add(formatFloat(temp3, ".00"));
            }
            // ����
            reallyResult[i][k] =  resultCount[i][1]+resultCount[i][2]-resultCount[i][3];
            bm.add(String.valueOf(reallyResult[i][k++]));
	    	//�ӳ�
            reallyResult[i][k++] = resultCount[i][17];
            bm.add(resultCount[i][17]+"");
	    	//��ֹ
            reallyResult[i][k++] = resultCount[i][18];
            bm.add(resultCount[i][18]+"");
	    	//�ж�
            reallyResult[i][k++] = resultCount[i][19];
            bm.add(resultCount[i][19]+"");
	    	//��ͣ
            reallyResult[i][k++] = resultCount[i][20];
            bm.add(resultCount[i][20]+"");
	    	//С��
            reallyResult[i][k] = resultCount[i][17]+resultCount[i][18]+resultCount[i][19]+resultCount[i][20];
            bm.add(String.valueOf(reallyResult[i][k++]));    		    	
	    	// 18��������δ�᰸����
            reallyResult[i][k++] = resultCount[i][21];
            bm.add(resultCount[i][21]+"");           
            result.add(bm);
	    }
	    List<String> bi = new ArrayList<String>();
	    bi.add("ȫԺͬ��");
	    for(int i = 0; i <25; i++ )
	    {
	    	bi.add(benqiYuTongqiBi(reallyResult[resultCount.length - 2][i], reallyResult[resultCount.length - 1][i]));
	    }
	    result.add(bi);	    
//	    for(int i = 0 ; i < result.size(); i++)
//	    {
//	    	if(i < results[0].length)
//	    	{
//	    		System.out.println("---bm--->"+ results[2][i]);
//	    	}
//	    	else
//	    	{
//	    		System.out.println("---bmOther--->"+i);
//	    	}	    	
//	    	for(int j = 0 ; j < result.get(i).size(); j++)
//	    	{
//	    		System.out.print(j + "---->"+result.get(i).get(j) + "    ");
//	    	}
//	    	System.out.println();
//	    }
	    return result;
	}
	
	private String benqiYuTongqiBi(long benqi,long tongqi)
	{
		if(tongqi == 0)
		{
			return "--";
		}
		float biResult = Float.valueOf(benqi)/Float.valueOf(tongqi)*100 - 100;
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(biResult);
	}
	
	private String formatFloat(float value,String format)
	{
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(value);
	}
	private String formatDouble(Double value,String format)
	{
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(value);
	}
	@SuppressWarnings("unchecked")
	private String sqlText(String sql)
	{
		List<String> lists = (List<String>)getSession().createSQLQuery(sql).list();
		if(lists.size() == 0)
		{
			return "";
		}		 
		return lists.get(0);
	}
	private String[][] revertList(List<Object[]> results)
	{
		if(results.size() == 0)
		{
			return null;
		}
		int cols = results.get(0).length;
		String[][] strs = new String[cols][results.size()];
		for(int i = 0; i < results.size(); i++)
		{
			for(int j = 0; j < results.get(i).length; j++)
			{
				// strs[j][i] = (String)results.get(i)[j];
				Object obj = results.get(i)[j];				
				if(null == obj)
				{
					strs[j][i] = "";
				}
				else
				{				
				    strs[j][i] = String.valueOf(obj);
				}
			
			}
		}
		return strs;
	}
	private long getCountResult(String sql)
	{
		Integer result = (Integer) getSession().createSQLQuery(sql).uniqueResult();
		if(null == result)
		{
			return 0;
		}
		else
		{
			return result;
		}
	}
	private float getCountResultTurnToFloat(String sql)
	{
		Object obj = getSession().createSQLQuery(sql).uniqueResult();
		if(null == obj)
		{
			return 0.0f;
		}
		return Float.valueOf(obj.toString());
	}
	private double getCountResultTurnToDouble(String sql)
	{
		Object obj = getSession().createSQLQuery(sql).uniqueResult();
		if(null == obj)
		{
			return 0.0f;
		}
		return Double.valueOf(obj.toString());
	}
	// ����ƽ����������
	private String pjslts_bm(String str_yhbm_e,String timeBegin,String timeEnd,long shu)
	{
		long zts = 0;
		long zzts = 0;
		long zdts = 0;
		// ajpjslts=(zts - zzts - zdts)/shu
		
		if(!str_yhbm_e.equals("14"))
		{
			Object obj_1 = getSession().createSQLQuery("select SUM(DATEDIFF(DD, PUB_AJ_JB.LARQ,PUB_AJ_JB.JARQ))  from PUB_AJ_JB where  PUB_AJ_JB.BASPT = '"+str_yhbm_e+"' and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND PUB_AJ_JB.JARQ>='"+timeBegin+"'  AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeEnd+"')>=0").uniqueResult();
			if(null == obj_1)
			{
				zts = 0;
			}
			else
			{
				zts = (Integer)obj_1;
			}
			Object obj_2 = getSession().createSQLQuery("select SUM(DATEDIFF(DD, PUB_SL_ZOZSL.ZZRQ,PUB_SL_ZOZSL.HFRQ))  FROM PUB_AJ_JB,PUB_SL_ZOZSL WHERE PUB_AJ_JB.AJXH = PUB_SL_ZOZSL.AJXH AND PUB_AJ_JB.BASPT = '"+str_yhbm_e+"' AND PUB_SL_ZOZSL.ZZSLJG='Y' and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND PUB_AJ_JB.JARQ>='"+timeBegin+"'  AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeEnd+"')>=0").uniqueResult();
			if(null == obj_2)
			{
				zzts = 0;
			}
			else
			{
				zzts = (Integer)obj_2;
			}
			Object obj_3 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_SL_SXZD.ZDRQ,PUB_SL_SXZD.HFRQ)) FROM PUB_AJ_JB,PUB_SL_SXZD WHERE  PUB_AJ_JB.AJXH = PUB_SL_SXZD.AJXH  AND PUB_SL_SXZD.ZDCLJG='Y' AND PUB_AJ_JB.BASPT = '"+str_yhbm_e+"' and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND PUB_AJ_JB.JARQ>='"+timeBegin+"'  AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeEnd+"')>=0").uniqueResult();
			if(null == obj_3)
			{
				zdts = 0;
			}
			else
			{
				zdts = (Integer)obj_3;
			}
		}
		else
		{
			Object obj_4 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_AJ_JB.LARQ,PUB_AJ_JB.JARQ)) from PUB_AJ_JB where PUB_AJ_JB.BASPT = '"+str_yhbm_e+"' and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_AJ_JB.AJXZ LIKE '8'  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeBegin+"')<=0 AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeEnd+"')>=0").uniqueResult();
			if(null == obj_4)
			{
				zts = 0;
			}
			else
			{
				zts = (Integer)obj_4;
			}
			Object obj_5 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_SL_ZOZSL.ZZRQ,PUB_SL_ZOZSL.HFRQ)) FROM PUB_AJ_JB,PUB_SL_ZOZSL WHERE PUB_AJ_JB.AJXH = PUB_SL_ZOZSL.AJXH AND PUB_SL_ZOZSL.ZZSLJG='Y'  AND PUB_AJ_JB.BASPT = '"+str_yhbm_e+"' and PUB_AJ_JB.SPCXDZ <> NULL AND  PUB_AJ_JB.AJXZ LIKE '8'  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeBegin+"')<=0 AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeEnd+"')>=0").uniqueResult();
			if(null == obj_5)
			{
				zzts = 0;
			}
			else
			{
				zzts = (Integer)obj_5;
			}
			Object obj_6 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_SL_SXZD.ZDRQ,PUB_SL_SXZD.HFRQ)) FROM PUB_AJ_JB,PUB_SL_SXZD WHERE  PUB_AJ_JB.AJXH = PUB_SL_SXZD.AJXH AND PUB_SL_SXZD.ZDCLJG='Y' AND PUB_AJ_JB.BASPT = '"+str_yhbm_e+"' and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_AJ_JB.AJXZ LIKE '8'  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeBegin+"')<=0 AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeEnd+"')>=0").uniqueResult();
			if(null == obj_6)
			{
				zdts = 0;
			}
			else
			{
				zdts = (Integer)obj_6;
			}			
		}
		float result = (Float.valueOf(zts) - Float.valueOf(zzts) - Float.valueOf(zdts))/Float.valueOf(shu);
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(result)+"";
	}
	private String pjslts_quanyuan(String timeBegin,String timeEnd,long shu)
	{
		long zts = 0;
		long zzts = 0;
		long zdts = 0;
		Object obj_1 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_AJ_JB.LARQ,PUB_AJ_JB.JARQ)) from PUB_AJ_JB where   PUB_AJ_JB.SPCXDZ <> NULL  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND PUB_AJ_JB.JARQ>='"+timeBegin+"'  AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeEnd+"')>=0").uniqueResult();
		if(null == obj_1)
		{
			zts = 0;
		}
		else
		{
			zts = (Integer)obj_1;
		}
		Object obj_2 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_SL_ZOZSL.ZZRQ,PUB_SL_ZOZSL.HFRQ)) FROM PUB_AJ_JB,PUB_SL_ZOZSL WHERE PUB_AJ_JB.AJXH = PUB_SL_ZOZSL.AJXH AND PUB_SL_ZOZSL.ZZSLJG='Y' and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND PUB_AJ_JB.JARQ>='"+timeBegin+"'  AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeEnd+"')>=0").uniqueResult();
		if(null == obj_2)
		{
			zzts = 0;
		}
		else
		{
			zzts = (Integer)obj_2;
		}
		Object obj_3 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_SL_SXZD.ZDRQ,PUB_SL_SXZD.HFRQ))  FROM PUB_AJ_JB,PUB_SL_SXZD WHERE  PUB_AJ_JB.AJXH = PUB_SL_SXZD.AJXH  AND PUB_SL_SXZD.ZDCLJG='Y'  and PUB_AJ_JB.SPCXDZ <> NULL  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND PUB_AJ_JB.JARQ>='"+timeBegin+"'  AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+timeEnd+"')>=0").uniqueResult();
		if(null == obj_3)
		{
			zdts = 0;
		}
		else
		{
			zdts = (Integer)obj_3;
		}
		double result = (Double.valueOf(zts) - Double.valueOf(zzts) - Double.valueOf(zdts))/Double.valueOf(shu);
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(result)+"";
	}
	
	// ѡ�����в���    ѡ��ְ��   ѡ��ְ��
	@SuppressWarnings("unchecked")
	public List<Object[]>  getBmZwZjList(int indexSQL)
	{
		return getSession().createSQLQuery(bmZwZjSQL[indexSQL - 1]).list();
	}
	// �������е�һͥ
	public List<List<String>> getXsspYjda(String bmdm,Date fromDateD,Date toDateD)
	{
		// ��Ҫ����
		String fromDate = DateUtil.format(fromDateD, DateUtil.webFormat2);
		String toDate = DateUtil.format(toDateD, DateUtil.webFormat2);
		String tongFromDate = DateUtil.format(DateUtil.addYears(fromDateD,-1), DateUtil.webFormat2); 
		String tongToDate = DateUtil.format(DateUtil.addYears(toDateD,-1), DateUtil.webFormat2);
		// String bmdm = "03";
		// ��Ҫ����
		int columnCount = 39;
		String[] ls_dz = new String[columnCount];
		String[] ls_dz_t = new String[columnCount];
		long rowCount[] = new long[columnCount];
		long benqi[] = new long[columnCount];
		long tongqi[] = new long[columnCount];
		
		String spcxdzsql = "DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' ";
		//�ɴ永��
		ls_dz[1] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ��ɴ永��'and BZ='����ͳ��'");
		//���հ���
		ls_dz[2] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ����հ���'and BZ='����ͳ��'");
		//�ѽ᰸��new
		ls_dz[3] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ѽ᰸��'and BZ='����ͳ��'");
		//�������ѽ᰸
		ls_dz[4] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����������ѽ᰸'and BZ='����ͳ��'");
		//���°���������
		ls_dz[5] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//���°���������
		ls_dz[6] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//һ��᰸��new
		ls_dz[22] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ�����д���'and BZ='����ͳ��'");
		ls_dz[22] = spcxdzsql + ls_dz[22] +")";
		//����᰸��new
		ls_dz[23] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��'");
		ls_dz[23] = spcxdzsql + ls_dz[23] +")";
		//����᰸��new
//			select SQLNR INTO:ls_dz[24]  from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��';
		ls_dz[24] = spcxdzsql + "AND (DMMS LIKE '__��__' OR DMMS LIKE '__��')"+")";
		//�μӺ���ͥ������new
		ls_dz[26]=ls_dz[3];
//			select SQLNR INTO:ls_dz[26]  from PUB_SQLLIB WHERE SQLMS='�μӺ���ͥ������'and BZ='����ͳ��';
//			if ls_dz[26]='' or isnull(ls_dz[26]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_�μӺ���ͥ������")
//			end if
//			//���߸��鰸����
//			select SQLNR INTO:ls_dz[11]  from PUB_SQLLIB WHERE SQLMS='���߸��鰸����'and BZ='����ͳ��';
//			if ls_dz[11]='' or isnull(ls_dz[11]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_���߸��鰸����")
//			end if
		//�ŷ�Ͷ����new
		ls_dz[25] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ŷ�Ͷ����'and BZ='����ͳ��'");
//			//һ��᰸��
//			select SQLNR INTO:ls_dz[13]  from PUB_SQLLIB WHERE SQLMS='һ��᰸��'and BZ='����ͳ��';
//			if ls_dz[13]='' or isnull(ls_dz[13]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_һ��᰸��")
//			end if
//			//�����з�����
//			select SQLNR INTO:ls_dz[14]  from PUB_SQLLIB WHERE SQLMS='�����з�����'and BZ='����ͳ��';
//			if ls_dz[14]='' or isnull(ls_dz[14]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_�����з�����")
//			end if
		//һ��������
		ls_dz[8] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������'and BZ='����ͳ��'");
		//һ��������ͨ����᰸��
		ls_dz[9] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������ͨ����᰸��'and BZ='����ͳ��'");
		//����ͥ��
		ls_dz[10] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='����ͥ��'and BZ='����ͳ��'");
//			//����᰸��
//			select SQLNR INTO:ls_dz[11]  from PUB_SQLLIB WHERE SQLMS='����᰸��'and BZ='����ͳ��';
//			if ls_dz[11]='' or isnull(ls_dz[11]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_����᰸��")
//			end if
		//������
		ls_dz[12] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='������'and BZ='����ͳ��'");
		//�����з�����
		ls_dz[14] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����з�����'and BZ='����ͳ��'");
		//������
		ls_dz[15] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͨ����������'and BZ='����ͳ��'");
		//����δ�᰸
		ls_dz[17] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='����δ�᰸'and BZ='����ͳ��'");
		//��ֹδ�᰸
		ls_dz[18] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ֹδ�᰸'and BZ='����ͳ��'");
		//�ж�δ�᰸
		ls_dz[19] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ж�δ�᰸��'and BZ='����ͳ��'");
		//��ͣ����δ�᰸��
		ls_dz[20] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͣ��������δ�᰸��' and BZ='����ͳ��'");
		//18��������δ�᰸��
		ls_dz[21] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='18��������δ�᰸����' and BZ='����ͳ��'");
		//һ����׳���᰸��
		ls_dz[27] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ����׳���᰸��' and BZ='����ͳ��'");
		//���̼��Ͱ�����
		ls_dz[28] = "DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' and DMMS LIKE '��ִ')";
		//
		//
//				//���¸�������
		//   select SQLNR INTO:ls_dz[29]  from PUB_SQLLIB WHERE SQLMS='���¸������½᰸��' and BZ='����ͳ��';
//			if ls_dz[29]='' or isnull(ls_dz[29]) then
//		   	messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_���¸������½᰸��")
//			end if
		//���߸���
		ls_dz[30]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' AND  (DMMS LIKE '%��' OR (DMMS LIKE '%��' AND DMMS NOT LIKE '%��%��')) )";
		//���˰���
		ls_dz[31]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' and DMMS LIKE '__��')";

		String lrx[] = new String[7];
		lrx[1] = "CBZASSA";
		lrx[2] = "CBZASJA";
		lrx[3] = "SPAJS";
		lrx[4] = "SPCPWSS";
		lrx[5] = "PCCPWSS";
		lrx[6] = "CXCCCPWSS";
		
		for(int i = 33; i <= 38; i++)
		{
			ls_dz[i] = "DATEDIFF(DD,FGYG_LRX.RQ,#TJ_BEGIN#)<=0 and DATEDIFF(DD,FGYG_LRX.RQ,#TJ_END#)>=0";
		}
		

		// �滻ʱ���ַ���
		for(int i = 1; i < columnCount; i++)
		{
			ls_dz_t[i] = ls_dz[i];
			if(ls_dz[i] != null)
			{
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN#","'"+fromDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_END#", "'"+toDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN_JA#", "'"+fromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN#","'"+tongFromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_END#", "'"+tongToDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN_JA#", "'"+tongFromDate+"'");				  
			}
			
		}
		
		// ѡ����������ж��ٸ���
		String bmRenShu = "SELECT DISTINCT PUB_SPRY.XM,PUB_XTGL_YHB.YHSF FROM PUB_AJ_JB,PUB_SPRY,PUB_XTGL_YHB  WHERE ( (((PUB_AJ_JB.JARQ=NULL OR DATEDIFF( DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0)    AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0)) OR (DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+fromDate+"')<=0  AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0) ) AND PUB_SPRY.AJXH=PUB_AJ_JB.AJXH AND PUB_SPRY.SFCBR='Y' AND PUB_AJ_JB.BASPT='"+bmdm+"' AND PUB_XTGL_YHB.YHMC=PUB_SPRY.XM ORDER BY PUB_XTGL_YHB.YHSF";
	    List<String> xmList = bmRenXmList(bmRenShu);
	    List<List<String>> results = new ArrayList<List<String>>();
	    List<List<Float>> resultReturns = new ArrayList<List<Float>>();
	    List<long[]> resultTemp = new ArrayList<long[]>();
	    List<Float> ajpjslts = new ArrayList<Float>(); 
	    
	    int k = -1;
 	    for(int i = 0; i  < xmList.size(); i++)
	    {
	    	String shengFenMc = getYongHuShenFenByXm(xmList.get(i));
	    	if(shengFenMc.equals("���") || shengFenMc.equals("���Ա") ||  shengFenMc.equals("��ʻԱ"))
	    	{
	    		continue;
	    	}
	    	// ��ʾ�ж���������
	        k++;
	    	List<String> cols = new ArrayList<String>();
	    	List<Float>  resultReturn = new ArrayList<Float>();
	    	long col[] = new long[columnCount];
	    	
	    	String sql_temp = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY" + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH" + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' AND ";
           
	    	
	    	// ����ְ��
	    	cols.add(shengFenMc);
	    	
	    	// ����
	    	cols.add(xmList.get(i));
	    	String str_sql = "";
	    	for(int j = 0; j < columnCount; j++)
	    	{
	    		
	    		if(j == 14)
	    		{
	    			str_sql = ls_dz[j] +" AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH " + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 15)
	    		{
	    			str_sql = ls_dz[j] + " AND PUB_AJ_JB.AJXH = PUB_SPRY.AJXH AND XF_LXDJ.AJXH = PUB_AJ_JB.AJXH " + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 26)
	    		{
	    			str_sql  = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY" + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH" + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'N' AND " +  ls_dz[3];
	    		}
	    		else if( j >= 33 && j <= 38)
	    		{
	    			str_sql  = "select sum("+lrx[j - 32]+") from FGYG_LRX where FGYG_LRX.XM= '"+xmList.get(i)+"' AND " + ls_dz[j];
	    		}
	    		else if(ls_dz[j] != null)
	    		{
	    			str_sql = sql_temp + ls_dz[j];
	    		}
	    		// ִ�л�ý��
	    		if(ls_dz[j] != null)
	    		{
	    			col[j] = getCountResult(str_sql);
	    			rowCount[j] += col[j];
	    		}
	    				
	    	}	
	    	
	    	 //����ƽ����������
    		str_sql = sql_temp+ ls_dz[3];
    		long temp = getCountResult(str_sql);
    		if(temp == 0)
    		{
    			ajpjslts.add(0f);
    		}
    		else
    		{
    			ajpjslts.add(pjslts(temp, bmdm, xmList.get(i), fromDate, toDate));
    		}
	    	
	    	resultTemp.add(col);
	    	resultReturns.add(resultReturn);
	    	results.add(cols);
	    	
	    	 // ����ƽ���������� ,���һ������
	    	xsEveryRowCount(cols,col,formatFloat(ajpjslts.get(k), "0.00"));
	    	       
	    }
 	   // ��Ա�ۼ�
 	   List<String> renyuleiji = new ArrayList<String>();
 	   renyuleiji.add("��Ա�ۼ�");
 	   renyuleiji.add("");	
 	   xsEveryRowCount(renyuleiji, rowCount,"");	   
       results.add(renyuleiji);
       
       //�Ը���ͥ�ϼ�--���� 
       String str_sql = "";
       List<String> bengqiRow = new ArrayList<String>();
       bengqiRow.add("����ͥ�Һϼ�");
       bengqiRow.add("");
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 14)
    	   {
    		   str_sql = ls_dz[i] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '"+bmdm + "'";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql = ls_dz[i] + "  and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '"+bmdm+"'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql =  "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz[i];
    	   }
    	   else if(ls_dz[i] != null)
    	   {
    		   str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB "  + " where PUB_AJ_JB.BASPT = '" +bmdm + "' AND " + ls_dz[i]; 
    	   }
    	   
    	   if(ls_dz[i] != null && i != 26)
    	   {
    		   benqi[i] = getCountResult(str_sql);
    	   }   	   
       }
       //����ƽ����������
		str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " + " where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz[3];
		long temp = getCountResult(str_sql);
		if(temp == 0)
		{
	       xsEveryRowCount(bengqiRow, benqi, "0");
		}
		else
		{
			xsEveryRowCount(bengqiRow, benqi,pjslts_bm(bmdm, fromDate,toDate, temp));
		}
       results.add(bengqiRow);
       
     //�Ը���ͥ�ϼ�--ͬ��
       String str_sql_2 = "";
       List<String> tongqiRow = new ArrayList<String>();
       tongqiRow.add("ͬ��ͥ�Һϼ�");
       tongqiRow.add("");
       
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 14)
    	   {
    		   str_sql_2 =  ls_dz_t[i] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '" +bmdm + "'";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql_2 = ls_dz_t[i] + " and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '" + bmdm + "'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql_2 =   "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz_t[i];
    	   }
    	   else if(ls_dz_t[i] != null)
    	   {
    		   str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +  " where PUB_AJ_JB.BASPT = '" +bmdm+"' AND " + ls_dz_t[i]; 
    	   }
    	   
    	   if(ls_dz[i] != null && i != 26)
    	   {
    		   // System.out.println(str_sql_2);
    		   tongqi[i] = getCountResult(str_sql_2);
    	   }  
       }
     //����ƽ����������
		str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +" where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz_t[3];
		long temp_2 = getCountResult(str_sql_2);
		if(temp_2 == 0)
		{
	       xsEveryRowCount(tongqiRow, tongqi, "0");
		}
		else
		{
			xsEveryRowCount(tongqiRow,tongqi,pjslts_bm(bmdm, tongFromDate,tongToDate, temp_2));
		}
		
       results.add(tongqiRow);
       //�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
       List<String> btbi = new ArrayList<String>();
       btbi.add("ͬ��ͥ�Һϼ�");
       btbi.add("");
       for(int i = 2; i  <tongqiRow.size(); i++)
       {
    	  String benqiTem = bengqiRow.get(i).trim();
    	  String tongqiTem = tongqiRow.get(i).trim();
    	  if(benqiTem.equals("--") || tongqiTem.endsWith("--"))
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(tongqiTem) == 0)
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(benqiTem) == 0)
    	  {
    		  btbi.add("0");
    	  }
    	  else 
    	  {
    		//�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
    		 float resu =  Float.valueOf(benqiTem)/Float.valueOf(tongqiTem)*100 - 100;
    		 btbi.add(formatFloat(resu,"0.00"));
    	  }
       }
       results.add(btbi);
       
// 	   for(int i = 0; i < results.size(); i++)
// 	   {
// 		   for(int j = 0; j < results.get(i).size(); j++)
// 		   {
// 			   System.out.print((j)+" <> "+results.get(i).get(j) + "       ");
// 		   }
// 		   System.out.println("");
// 	   }
 	   
       return results;
	}
	
	/**
	 * 
	 * @param renyuleiji ��Ҫ���صı���ÿ��
	 * @param rowCount  39 ������������
	 * @param ajpjslts  ����ƽ���������� �� ���⴦���У�
	 */
	private void xsEveryRowCount(List<String> renyuleiji,long[] rowCount,String ajpjslts)
	{
		  //�ɴ� (1)
	       renyuleiji.add(rowCount[1]+"");
	     //����  (2)
	       renyuleiji.add(rowCount[2]+"");
	   	//С��(3)
	       long temp_1 = rowCount[1] + rowCount[2];
	       renyuleiji.add(temp_1+"");
	   	//һ�� (4)
	       renyuleiji.add(rowCount[22]+"");
	   	//���� (5)
	       renyuleiji.add(rowCount[23]+"");
	   	//����(6)
	       renyuleiji.add(rowCount[24]+"");
	   	//���̼��� (7)
	       renyuleiji.add(rowCount[28]+"");
	   	//���߸��� (8)
	       renyuleiji.add(rowCount[30]+"");
	       // ���˰��� (9)
	       renyuleiji.add(rowCount[31]+"");
	   	//���� (10)
	       long temp_2 = rowCount[3] - rowCount[22] - rowCount[23] - rowCount[24] - rowCount[28] - rowCount[30] - rowCount[31];
	       renyuleiji.add(temp_2+"");
	   	//�᰸���� (11)
	       renyuleiji.add(rowCount[3]+"");
	   	//���հ���(%) (12)
	       if(rowCount[2] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_3 = (float)rowCount[3]/(float)rowCount[2]*100;
		        renyuleiji.add(formatFloat(temp_3, "0.00"));
	       }
	   	//�᰸��(%) (13)
	       long temp_4 = rowCount[1] + rowCount[2];
	       if(temp_4 <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_5 = (float)rowCount[3]/(float)temp_4*100;
		        renyuleiji.add(formatFloat(temp_5, "0.00"));
	       }
	   	//�᰸�� (14)
	       renyuleiji.add(rowCount[4]+"");
	   	//�᰸��(%) (15)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_6 = (float)rowCount[4]/(float)rowCount[3]*100;
		        renyuleiji.add(formatFloat(temp_6, "0.00"));
	       }
	       // ����ƽ���������� (16)
	       renyuleiji.add(ajpjslts);
	   	//������ (17)
	       renyuleiji.add(rowCount[5]+"");
	   	//������ (18)
	       renyuleiji.add(rowCount[6]+"");
	   	//���⳷����(%) (19)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	long temp_7 = rowCount[5]+rowCount[6];
	       	float temp_8 = (float)temp_7 /(float)rowCount[3]*100;
		        renyuleiji.add(formatFloat(temp_8, "0.00"));
	       }
	   	//������ (20)
	       renyuleiji.add(rowCount[8]+"");
	   	//������(%) (21)
	       if(rowCount[9] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_9 = (float)rowCount[8]/(float)rowCount[9]*100;
		        renyuleiji.add(formatFloat(temp_9, "0.00"));
	       }
	   	//�᰸�� (22)
	       renyuleiji.add(rowCount[27]+"");
	   	//�᰸��(%) (23)
	       if(rowCount[22] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_10 = (float)rowCount[27]/(float)rowCount[22]*100;
		        renyuleiji.add(formatFloat(temp_10, "0.00"));
	       }
	   	//��ͥ�� (24)
	       renyuleiji.add(rowCount[10]+"");
	   	//��ͥ��(%) (25)
	       if(rowCount[23] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_11 = (float)rowCount[10]/(float)rowCount[23]*100;
		        renyuleiji.add(formatFloat(temp_11, "0.00"));
	       } 
	   	//������ (26)
	       renyuleiji.add(rowCount[12]+"");
	   	//������(%) (27)
	       if(rowCount[12] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_12 = (float)rowCount[12]/(float)rowCount[22]*100;
		        renyuleiji.add(formatFloat(temp_12, "0.00"));
	       }
	   	//�����У������� (28)
	       renyuleiji.add(rowCount[14]+"");
	   	//���ķ���(%) (29)
	       if(rowCount[13] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_13 = (float)rowCount[14]/(float)rowCount[13]*100;
		        renyuleiji.add(formatFloat(temp_13, "0.00"));
	       }
	   	//������ (30)
	       renyuleiji.add(rowCount[15]+"");
	   	//������(%) (31)
	       if(rowCount[13] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_14 = (float)rowCount[15]/(float)rowCount[13]*100;
		        renyuleiji.add(formatFloat(temp_14, "0.00"));
	       }
	   	//Ͷ���� (32)
	       renyuleiji.add(rowCount[25]+"");
	   	//Ͷ���� (33)
	       if(rowCount[13] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_15 = (float)rowCount[25]/(float)rowCount[13]*100;
		        renyuleiji.add(formatFloat(temp_15, "0.00"));
	       }
	       // �μӺ���ͥ������ (34)
	       renyuleiji.add(rowCount[26]+"");
	       // ���� (35)
	       long temp_16 = rowCount[1] + rowCount[2] - rowCount[3];
	       renyuleiji.add(temp_16+"");
	   	//�ӳ� (36)
	       renyuleiji.add(rowCount[17]+"");
	   	//��ֹ (37)
	       renyuleiji.add(rowCount[18]+"");
	   	//�ж� (38)
	       renyuleiji.add(rowCount[19]+"");
	   	//��ͣ (39)
	       renyuleiji.add(rowCount[20]+"");
	   	//С�� (40)
	       long temp_17 = rowCount[17] + rowCount[18] + rowCount[19] + rowCount[20] ;
	       renyuleiji.add(temp_17+"");
	       // 18��������δ�᰸���� (41)
	       renyuleiji.add(rowCount[21]+"");
	   	//�հ� (42)
	       renyuleiji.add(rowCount[33]+"");
	   	//�᰸ (43)
	       renyuleiji.add(rowCount[34]+"");	        
	       // ���������� (44)
	       renyuleiji.add(rowCount[35]+"");	   
	       // �������������� (45)
	       renyuleiji.add(rowCount[36]+"");
	       // ������������� (46)
	       renyuleiji.add(rowCount[37]+"");
	       // ���ֲ����������� (47)
	       renyuleiji.add(rowCount[38]+"");
	   	//�����(%) (48)
	       if(rowCount[37] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_18 = (float)rowCount[38]/(float)rowCount[37]*100;
		        renyuleiji.add(formatFloat(temp_18, "0.00"));
	       }
	}
	
	private void xzEveryRowCount(List<String> renyuleiji,long[] rowCount,String ajpjslts)
	{
		  //�ɴ� (1)
	       renyuleiji.add(rowCount[1]+"");
	     //����  (2)
	       renyuleiji.add(rowCount[2]+"");
	   	//С��(3)
	       long temp_1 = rowCount[1] + rowCount[2];
	       renyuleiji.add(temp_1+"");
	   	//һ�� (4)
	       renyuleiji.add(rowCount[22]+"");
	   	//���� (5)
	       renyuleiji.add(rowCount[23]+"");
	   	//����(6)
	       renyuleiji.add(rowCount[24]+"");
		//�������ִ�а���
	       renyuleiji.add(rowCount[28]+"");
		//���߸���
	       renyuleiji.add(rowCount[29]+"");
		//����
	       long temp_2 = rowCount[3] - rowCount[22] - rowCount[23] - rowCount[24] - rowCount[28] - rowCount[29];
	       renyuleiji.add(temp_2+"");
		//�᰸����
	       renyuleiji.add(rowCount[3]+"");
		//���հ���(%)
	       if(rowCount[2] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_3 = (float)rowCount[3]/(float)rowCount[2]*100;
		        renyuleiji.add(formatFloat(temp_3, "0.00"));
	       }
		//�᰸��(%)
	       long temp_4 = rowCount[1] + rowCount[2];
	       if(temp_4 <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_5 = (float)rowCount[3]/(float)temp_4*100;
		        renyuleiji.add(formatFloat(temp_5, "0.00"));
	       }
		//�᰸��
	       renyuleiji.add(rowCount[4]+"");
		//�᰸��(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_6 = (float)rowCount[4]/(float)rowCount[3]*100;
		        renyuleiji.add(formatFloat(temp_6, "0.00"));
	       }
	    // ����ƽ����������
	       renyuleiji.add(ajpjslts);
		//������
	       renyuleiji.add(rowCount[5]+"");
		//������
	       renyuleiji.add(rowCount[6]+"");
		//���⳷����(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_7 = (float)(rowCount[6]+rowCount[5])/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_7, "0.00"));
	       }
		//������
	       renyuleiji.add(rowCount[8]+"");
		//������(%)
	       if(rowCount[9] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_8 = (float)rowCount[8]/(float)rowCount[9]*100;
		    renyuleiji.add(formatFloat(temp_8, "0.00"));
	       } 
		//�᰸��
	       renyuleiji.add(rowCount[27]+"");
		//�᰸��(%)
	       if(rowCount[22] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_9 = (float)rowCount[27]/(float)rowCount[22]*100;
		    renyuleiji.add(formatFloat(temp_9, "0.00"));
	       } 
		//��ͥ��
	       renyuleiji.add(rowCount[10]+"");
		//��ͥ��(%)
	       if(rowCount[23] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_10 = (float)rowCount[10]/(float)rowCount[23]*100;
		    renyuleiji.add(formatFloat(temp_10, "0.00"));
	       } 
		//������
	       renyuleiji.add(rowCount[12]+"");
		//������(%)
	       if(rowCount[22] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_11 = (float)rowCount[12]/(float)rowCount[22]*100;
		    renyuleiji.add(formatFloat(temp_11, "0.00"));
	       } 
		//�����У�������
	       renyuleiji.add(rowCount[14]+"");
		//���ķ���(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_12 = (float)rowCount[14]/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_12, "0.00"));
	       } 
		//������
	       renyuleiji.add(rowCount[15]+"");
		//������(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_13 = (float)rowCount[15]/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_13, "0.00"));
	       } 
		//Ͷ����
	       renyuleiji.add(rowCount[25]+"");
		//Ͷ����
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_14 = (float)rowCount[25]/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_14, "0.00"));
	       } 
	    // �μӺ���ͥ������
	       renyuleiji.add(rowCount[26]+"");
	    // ����
	       long temp_15 = rowCount[1] + rowCount[2] - rowCount[3];
	       renyuleiji.add(temp_15+"");
	     //�ӳ� (36)
	       renyuleiji.add(rowCount[17]+"");
	   	//��ֹ (37)
	       renyuleiji.add(rowCount[18]+"");
	   	//�ж� (38)
	       renyuleiji.add(rowCount[19]+"");
	   	//��ͣ (39)
	       renyuleiji.add(rowCount[20]+"");
	   	//С�� (40)
	       long temp_17 = rowCount[17] + rowCount[18] + rowCount[19] + rowCount[20] ;
	       renyuleiji.add(temp_17+"");
	    // 18��������δ�᰸����
	       renyuleiji.add(rowCount[21]+"");
		//�հ�
	       renyuleiji.add(rowCount[33]+"");
		//�᰸
	       renyuleiji.add(rowCount[34]+"");
	    // ����������
	       renyuleiji.add(rowCount[35]+"");
	    // ��������������
	       renyuleiji.add(rowCount[36]+"");
		//�������������
	       renyuleiji.add(rowCount[37]+"");
		//���ֲ�����������
	       renyuleiji.add(rowCount[38]+"");
		//�����(%)
	       if(rowCount[37] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_18 = (float)rowCount[38]/(float)rowCount[37]*100;
		    renyuleiji.add(formatFloat(temp_18, "0.00"));
	       } 
	}
	// �������е�һͥ
	private void msEveryRowCount(List<String> renyuleiji,long[] rowCount,String ajpjslts)
	{
		  //�ɴ� (1)
	       renyuleiji.add(rowCount[1]+"");
	     //����  (2)
	       renyuleiji.add(rowCount[2]+"");
	   	//С��(3)
	       long temp_1 = rowCount[1] + rowCount[2];
	       renyuleiji.add(temp_1+"");

	    //һ�� (4)
	       renyuleiji.add(rowCount[22]+"");
	   	//���� (5)
	       renyuleiji.add(rowCount[23]+"");
	   	//����(6)
	       renyuleiji.add(rowCount[24]+"");
		//���߸���
	       renyuleiji.add(rowCount[28]+"");
		//����
	       long temp_2 = rowCount[3] - rowCount[22] - rowCount[23] - rowCount[24] - rowCount[28];
	       renyuleiji.add(temp_2+"");
	     //�᰸����
	       renyuleiji.add(rowCount[3]+"");
		//���հ���(%)
	       if(rowCount[2] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_3 = (float)rowCount[3]/(float)rowCount[2]*100;
		    renyuleiji.add(formatFloat(temp_3, "0.00"));
	       }
		//�᰸��(%)
	       long temp_4 = rowCount[1] + rowCount[2];
	       if(temp_4 <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_5 = (float)rowCount[3]/(float)temp_4*100;
		        renyuleiji.add(formatFloat(temp_5, "0.00"));
	       }
	     //�᰸��
	       renyuleiji.add(rowCount[4]+"");
		//�᰸��(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_6 = (float)rowCount[4]/(float)rowCount[3]*100;
		        renyuleiji.add(formatFloat(temp_6, "0.00"));
	       }
	    // ����ƽ����������
	       renyuleiji.add(ajpjslts);
	     //������
	       renyuleiji.add(rowCount[5]+"");
		//������
	       renyuleiji.add(rowCount[6]+"");
		//���⳷����(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_7 = (float)(rowCount[6]+rowCount[5])/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_7, "0.00"));
	       }
	    // �����ر���򳷻�������
	       renyuleiji.add(rowCount[39]+"");
	     //������
	       renyuleiji.add(rowCount[8]+"");
		//������(%)
	       if(rowCount[9] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_8 = (float)rowCount[8]/(float)rowCount[9]*100;
		    renyuleiji.add(formatFloat(temp_8, "0.00"));
	       } 
	     //�᰸��
	       renyuleiji.add(rowCount[27]+"");
		//�᰸��(%)
	       if(rowCount[22] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_9 = (float)rowCount[27]/(float)rowCount[22]*100;
		    renyuleiji.add(formatFloat(temp_9, "0.00"));
	       } 
	     //��ͥ��
	       renyuleiji.add(rowCount[10]+"");
		//��ͥ��(%)
	       if(rowCount[23] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_10 = (float)rowCount[10]/(float)rowCount[23]*100;
		    renyuleiji.add(formatFloat(temp_10, "0.00"));
	       } 
	     //������
	       renyuleiji.add(rowCount[12]+"");
		//������(%)
	       if(rowCount[22] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_11 = (float)rowCount[12]/(float)rowCount[22]*100;
		    renyuleiji.add(formatFloat(temp_11, "0.00"));
	       } 
	     //�����У�������
	       renyuleiji.add(rowCount[14]+"");
		//���ķ���(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_12 = (float)rowCount[14]/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_12, "0.00"));
	       } 
	     //������
	       renyuleiji.add(rowCount[15]+"");
		//������(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_13 = (float)rowCount[15]/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_13, "0.00"));
	       } 
	     //Ͷ����
	       renyuleiji.add(rowCount[25]+"");
		//Ͷ����
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_14 = (float)rowCount[25]/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_14, "0.00"));
	       } 
	    // �μӺ���ͥ������
	       renyuleiji.add(rowCount[26]+"");
		//�����°�������᰸��
	       renyuleiji.add("--");
		//����᰸��ʵ�����н᰸��
	       renyuleiji.add("--");
		//ʵ��������
	       renyuleiji.add("--");
	    // ����
	       long temp_15 = rowCount[1] + rowCount[2] - rowCount[3];
	       renyuleiji.add(temp_15+"");
	    //�ӳ� (36)
	       renyuleiji.add(rowCount[17]+"");
	   	//��ֹ (37)
	       renyuleiji.add(rowCount[18]+"");
	   	//�ж� (38)
	       renyuleiji.add(rowCount[19]+"");
	   	//��ͣ (39)
	       renyuleiji.add(rowCount[20]+"");
	   	//С�� (40)
	       long temp_17 = rowCount[17] + rowCount[18] + rowCount[19] + rowCount[20] ;
	       renyuleiji.add(temp_17+"");
	    // 18��������δ�᰸����
	       renyuleiji.add(rowCount[21]+"");
	     //�հ�
	       renyuleiji.add(rowCount[33]+"");
		//�᰸
	       renyuleiji.add(rowCount[34]+"");

	    // ����������
	       renyuleiji.add(rowCount[35]+"");
	    // ��������������
	       renyuleiji.add(rowCount[36]+"");
		//�������������
	       renyuleiji.add(rowCount[37]+"");
		//���ֲ�����������
	       renyuleiji.add(rowCount[38]+"");
	     //�����(%)
	       if(rowCount[37] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_18 = (float)rowCount[38]/(float)rowCount[37]*100;
		    renyuleiji.add(formatFloat(temp_18, "0.00"));
	       } 

	}
	// ִ�о�
	private void zxEveryRowCount(List<String> renyuleiji,float[] rowCount,String ajpjslts)
	{
		  //�ɴ� (1)
	       renyuleiji.add(formatFloat(rowCount[1],"0"));
	     //����  (2)
	       renyuleiji.add(formatFloat(rowCount[2],"0"));
	   	//С��(3)
	       float temp_1 = rowCount[1] + rowCount[2];
	       renyuleiji.add(formatFloat(temp_1,"0"));


	       //�᰸����
	       renyuleiji.add(formatFloat(rowCount[3],"0"));
		//���հ���(%)
	       if(rowCount[2] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_2 = (float)rowCount[3]/(float)rowCount[2]*100;
		    renyuleiji.add(formatFloat(temp_2, "0.00"));
	       }
		//ִ����(%)
	       float temp_4 = rowCount[1] + rowCount[2];
	       if(temp_4 <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_5 = (float)rowCount[3]/(float)temp_4*100;
		        renyuleiji.add(formatFloat(temp_5, "0.00"));
	       }
		//ǿ��ִ����
	       renyuleiji.add(formatFloat(rowCount[30],"0"));
		//�Զ�������
	       renyuleiji.add(formatFloat(rowCount[31],"0"));
		//�ͽ���
	       renyuleiji.add(formatFloat(rowCount[32],"0"));
		//ʵ��ִ����(%)
	       float temp_6 = rowCount[30] + rowCount[31] + rowCount[32];
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_7 = (float)temp_6/(float)rowCount[3]*100;
		        renyuleiji.add(formatFloat(temp_7, "0.00"));
	       }
	         
		//ִ�а����Զ����кͽ���(%)
	       float temp_8 =  rowCount[31] + rowCount[32];
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_9 = (float)temp_8/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_9, "0.00"));
	       }
	      
		//�᰸��
	       renyuleiji.add(formatFloat(rowCount[4],"0"));
		//�᰸��(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_10 = (float)rowCount[4]/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_10, "0.00"));
	       } 
	    // ����ƽ����������
	       renyuleiji.add(ajpjslts);	
		//��λ��Ķ�(��Ԫ)
	       renyuleiji.add(formatFloat(rowCount[5],"0.00"));
		//�����Ķ�(��Ԫ)
	       renyuleiji.add(formatFloat(rowCount[6],"0.00"));
		//��λ��(%)
	       if(rowCount[6] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_11 = (float)rowCount[5]/(float)rowCount[6]*100;
		    renyuleiji.add(formatFloat(temp_11, "0.00"));
	       } 
		//������
	       renyuleiji.add(formatFloat(rowCount[15],"0"));
		//������(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_12 = (float)rowCount[15]/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_12, "0.00"));
	       } 
		//Ͷ����
	       renyuleiji.add(formatFloat(rowCount[8],"0"));
		//Ͷ����(%)
	       float temp_13 = rowCount[1] + rowCount[2];
	       if(temp_13 <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_14 = (float)rowCount[8]/(float)temp_13*100;
		        renyuleiji.add(formatFloat(temp_14, "0.00"));
	       }
		//ִ�а�����ֹ�᰸��
	       renyuleiji.add("--");
		//ִ�а����ս�᰸��
	       renyuleiji.add("--");
		//ִ�а�����ֹ�ս���
	       renyuleiji.add("--");
		
	    // ����
	       float temp_14 = rowCount[1] + rowCount[2] - rowCount[3];
	       renyuleiji.add(formatFloat(temp_14,"0"));
	       //�ӳ� (36)
	       renyuleiji.add(formatFloat(rowCount[17],"0"));
	   	//��ֹ (37)
	       renyuleiji.add(formatFloat(rowCount[18],"0"));
	   	//�ж� (38)
	       renyuleiji.add(formatFloat(rowCount[19],"0"));
	   	//��ͣ (39)
	       renyuleiji.add(formatFloat(rowCount[20],"0"));
	   	//С�� (40)
	       float temp_17 = rowCount[17] + rowCount[18] + rowCount[19] + rowCount[20] ;
	       renyuleiji.add(formatFloat(temp_17,"0"));
		// 18��������δ�᰸����
	       renyuleiji.add(formatFloat(rowCount[21],"0"));
	       
	       //�հ�
	       renyuleiji.add(formatFloat(rowCount[33],"0"));
		//�᰸
	       renyuleiji.add(formatFloat(rowCount[34],"0"));

	    // ����������
	       renyuleiji.add(formatFloat(rowCount[35],"0"));
	    // ��������������
	       renyuleiji.add(formatFloat(rowCount[36],"0"));
		//�������������
	       renyuleiji.add(formatFloat(rowCount[37],"0"));
		//���ֲ�����������
	       renyuleiji.add(formatFloat(rowCount[38],"0"));
	     //�����(%)
	       if(rowCount[37] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_18 = (float)rowCount[38]/(float)rowCount[37]*100;
		    renyuleiji.add(formatFloat(temp_18, "0.00"));
	       } 
	}
	// ����
	private void laEveryRowCount(List<String> renyuleiji,long[] rowCount,String ajpjslts)
	{
		  //�ɴ� (1)
	       renyuleiji.add(rowCount[1]+"");
	     //����  (2)
	       renyuleiji.add(rowCount[2]+"");
	   	//С��(3)
	       long temp_1 = rowCount[1] + rowCount[2];
	       renyuleiji.add(temp_1+"");

	    //һ�� (4)
	       renyuleiji.add(rowCount[22]+"");
	   	//���� (5)
	       renyuleiji.add(rowCount[23]+"");
	   	//����(6)
	       renyuleiji.add(rowCount[24]+"");
		//���߸���
	       renyuleiji.add(rowCount[28]+"");
		//����
	       long temp_2 = rowCount[3] - rowCount[22] - rowCount[23] - rowCount[24] - rowCount[28];
	       renyuleiji.add(temp_2+"");
	     //�᰸����
	       renyuleiji.add(rowCount[3]+"");
		//���հ���(%)
	       if(rowCount[2] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_3 = (float)rowCount[3]/(float)rowCount[2]*100;
		    renyuleiji.add(formatFloat(temp_3, "0.00"));
	       }

	     //�᰸��(%)
	       long temp_4 = rowCount[1] + rowCount[2];
	       if(temp_4 <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_5 = (float)rowCount[3]/(float)temp_4*100;
		        renyuleiji.add(formatFloat(temp_5, "0.00"));
	       }
	     //�᰸��
	       renyuleiji.add(rowCount[4]+"");

	     //�᰸��(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_6 = (float)rowCount[4]/(float)rowCount[3]*100;
		        renyuleiji.add(formatFloat(temp_6, "0.00"));
	       }
	    // ����ƽ����������
	       renyuleiji.add(ajpjslts);
	       //������
	       renyuleiji.add(rowCount[5]+"");
		//������
	       renyuleiji.add(rowCount[6]+"");
		//���⳷����(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_7 = (float)(rowCount[6]+rowCount[5])/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_7, "0.00"));
	       }

		//Ͷ����
	       renyuleiji.add(rowCount[25]+"");
		//Ͷ����(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_8 = (float)rowCount[25]/(float)rowCount[3]*100;
		    renyuleiji.add(formatFloat(temp_8, "0.00"));
	       }
	    // �μӺ���ͥ������
	       renyuleiji.add(rowCount[26]+"");
	       // ����
	       long temp_15 = rowCount[1] + rowCount[2] - rowCount[3];
	       renyuleiji.add(temp_15+"");
	       //�ӳ� (36)
	       renyuleiji.add(rowCount[17]+"");
	   	//��ֹ (37)
	       renyuleiji.add(rowCount[18]+"");
	   	//�ж� (38)
	       renyuleiji.add(rowCount[19]+"");
	   	//��ͣ (39)
	       renyuleiji.add(rowCount[20]+"");
	   	//С�� (40)
	       long temp_17 = rowCount[17] + rowCount[18] + rowCount[19] + rowCount[20] ;
	       renyuleiji.add(temp_17+"");
	    // 18��������δ�᰸����
	       renyuleiji.add(rowCount[21]+"");
	       //�հ�
	       renyuleiji.add(rowCount[33]+"");
		//�᰸
	       renyuleiji.add(rowCount[34]+"");

	    // ����������
	       renyuleiji.add(rowCount[35]+"");
	    // ��������������
	       renyuleiji.add(rowCount[36]+"");
		//�������������
	       renyuleiji.add(rowCount[37]+"");
		//���ֲ�����������
	       renyuleiji.add(rowCount[38]+"");
	     //�����(%)
	       if(rowCount[37] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	float temp_18 = (float)rowCount[38]/(float)rowCount[37]*100;
		    renyuleiji.add(formatFloat(temp_18, "0.00"));
	       } 
	}
	// ���мල ���
	private void sjEveryRowCount(List<String> renyuleiji,double[] rowCount,String ajpjslts,boolean canjiayianjianshu)
	{
		
		  //�ɴ� (1)
	       renyuleiji.add(formatDouble(rowCount[1],"0"));
	     //����  (2)
	       renyuleiji.add(formatDouble(rowCount[2],"0"));
	   	//С��(3)
	       double temp_1 = rowCount[1] + rowCount[2];
	       renyuleiji.add(formatDouble(temp_1,"0"));

	    //һ�� (4)
	       renyuleiji.add(formatDouble(rowCount[22],"0"));
	   	//���� (5)
	       renyuleiji.add(formatDouble(rowCount[23],"0"));
	   	//����(6)
	       renyuleiji.add(formatDouble(rowCount[24],"0"));
		//���߸���
	       renyuleiji.add(formatDouble(rowCount[28],"0"));

		//���̼���
	       renyuleiji.add(formatDouble(rowCount[29],"0"));
		//����
	       double temp_2 = rowCount[3] - rowCount[22] - rowCount[23] - rowCount[24] - rowCount[28]- rowCount[29];
	       renyuleiji.add(formatDouble(temp_2,"0"));
	     //�᰸����
	       renyuleiji.add(formatDouble(rowCount[3],"0"));
		//���հ���(%)
	       if(rowCount[2] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_3 = (double)rowCount[3]/(double)rowCount[2]*100;
		    renyuleiji.add(formatDouble(temp_3, "0.00"));
	       }

	       //�᰸��(%)
	       double temp_4 = rowCount[1] + rowCount[2];
	       if(temp_4 <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_5 = (double)rowCount[3]/(double)temp_4*100;
		        renyuleiji.add(formatDouble(temp_5, "0.00"));
	       }

	     //�᰸��
	       renyuleiji.add(formatDouble(rowCount[4],"0"));

	     //�᰸��(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_6 = (double)rowCount[4]/(double)rowCount[3]*100;
		        renyuleiji.add(formatDouble(temp_6, "0.00"));
	       }

	       // ����ƽ����������
	       renyuleiji.add(ajpjslts);
	       //������
	       renyuleiji.add(formatDouble(rowCount[5],"0"));
		  //������
	       renyuleiji.add(formatDouble(rowCount[6],"0"));
		  //���⳷����(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	       	Double temp_7 = (double)(rowCount[6]+rowCount[5])/(double)rowCount[3]*100;
		    renyuleiji.add(formatDouble(temp_7, "0.00"));
	       }

		//������
	       renyuleiji.add(rowCount[8]+"");
		//������(%)
	       if(rowCount[9] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_6 = (double)rowCount[8]/(double)rowCount[9]*100;
		        renyuleiji.add(formatDouble(temp_6, "0.00"));
	       }
		//�᰸��
	       renyuleiji.add(formatDouble(rowCount[27],"0"));
		//�᰸��(%)
	       if(rowCount[22] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_6 = (double)rowCount[27]/(double)rowCount[22]*100;
		        renyuleiji.add(formatDouble(temp_6, "0.00"));
	       }
		//������
	       renyuleiji.add(formatDouble(rowCount[12],"0"));
		//������(%)
	       if(rowCount[22] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_6 = (double)rowCount[12]/(double)rowCount[22]*100;
		        renyuleiji.add(formatDouble(temp_6, "0.00"));
	       }
		//�����У�������
	       renyuleiji.add(formatDouble(rowCount[14],"0"));
		//���ķ���(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_6 = (double)rowCount[14]/(double)rowCount[3]*100;
		        renyuleiji.add(formatDouble(temp_6, "0.00"));
	       }
		//������
	       renyuleiji.add(formatDouble(rowCount[15],"0"));
		//������(%)
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_6 = (double)rowCount[15]/(double)rowCount[3]*100;
		        renyuleiji.add(formatDouble(temp_6, "0.00"));
	       }
		//Ͷ����
	       renyuleiji.add(formatDouble(rowCount[25],"0"));
		//Ͷ����
	       if(rowCount[3] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_6 = (double)rowCount[25]/(double)rowCount[3]*100;
		        renyuleiji.add(formatDouble(temp_6, "0.00"));
	       }
	       // �μӺ���ͥ������
	       if(canjiayianjianshu)
	       {
	    	   renyuleiji.add(formatDouble(rowCount[26],"0"));
	       }
	       else
	       {
	    	   renyuleiji.add("");
	       }
	       
	       // ����
	       double temp_15 = rowCount[1] + rowCount[2] - rowCount[3];
	       renyuleiji.add(formatDouble(temp_15,"0"));
	       //�ӳ� (36)
	       renyuleiji.add(formatDouble(rowCount[17],"0"));
	   	//��ֹ (37)
	       renyuleiji.add(formatDouble(rowCount[18],"0"));
	   	//�ж� (38)
	       renyuleiji.add(formatDouble(rowCount[19],"0"));
	   	//��ͣ (39)
	       renyuleiji.add(formatDouble(rowCount[20],"0"));
	   	//С�� (40)
	       double temp_17 = rowCount[17] + rowCount[18] + rowCount[19] + rowCount[20] ;
	       renyuleiji.add(formatDouble(temp_17,"0"));
	    // 18��������δ�᰸����
	       renyuleiji.add(formatDouble(rowCount[21],"0"));
	       //�հ�
	       renyuleiji.add(formatDouble(rowCount[33],"0"));
		//�᰸
	       renyuleiji.add(formatDouble(rowCount[34],"0"));

	    // ����������
	       renyuleiji.add(formatDouble(rowCount[35],"0"));
	    // ��������������
	       renyuleiji.add(formatDouble(rowCount[36],"0"));
		//�������������
	       renyuleiji.add(formatDouble(rowCount[37],"0"));
		//���ֲ�����������
	       renyuleiji.add(formatDouble(rowCount[38],"0"));
	     //�����(%)
	       if(rowCount[37] <= 0)
	       {
	 	        renyuleiji.add("--");
	       }
	       else
	       {
	    	   double temp_18 = (double)rowCount[38]/(double)rowCount[37]*100;
		    renyuleiji.add(formatDouble(temp_18, "0.00"));
	       } 

	}
	private float pjslts(long shu,String spt,String xm,String fromDate,String toDate)
	{
		long zts = 0;
		long zzts = 0;
		long zdts = 0;
		
		if(!spt.equals("14"))
		{
			Object obj_1 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_AJ_JB.LARQ,PUB_AJ_JB.JARQ)) from PUB_AJ_JB,PUB_SPRY where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_AJ_JB.BASPT = '"+spt+"'  and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_SPRY.XM= '"+xm+"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND (PUB_AJ_JB.JARQ>='"+fromDate+"')  AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+toDate+"')>=0").uniqueResult();
			if(null == obj_1)
			{
				zts = 0;
			}
			else
			{
				zts = (Integer)obj_1;
			}
			Object obj_2 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_SL_ZOZSL.ZZRQ,PUB_SL_ZOZSL.HFRQ)) FROM PUB_AJ_JB,PUB_SL_ZOZSL,PUB_SPRY WHERE PUB_AJ_JB.AJXH = PUB_SL_ZOZSL.AJXH and PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_SL_ZOZSL.ZZSLJG='Y' AND PUB_AJ_JB.BASPT = '"+spt+"'  and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_SPRY.XM= '"+xm+"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND (PUB_AJ_JB.JARQ>='"+fromDate+"')  AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+toDate+"')>=0").uniqueResult();
			if(null == obj_2)
			{
				zzts = 0;
			}
			else
			{
				zzts = (Integer)obj_2;
			}
			Object obj_3 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_SL_SXZD.ZDRQ,PUB_SL_SXZD.HFRQ)) FROM PUB_AJ_JB,PUB_SL_SXZD,PUB_SPRY WHERE  PUB_AJ_JB.AJXH = PUB_SL_SXZD.AJXH and PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_SL_SXZD.ZDCLJG='Y' AND PUB_AJ_JB.BASPT = '"+spt+"'  and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_SPRY.XM= '"+xm+"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND (PUB_AJ_JB.JARQ>='"+fromDate+"')  AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+toDate+"')>=0").uniqueResult();
			if(null == obj_3)
			{
				zdts = 0;
			}
			else
			{
				zdts = (Integer)obj_3;
			}
		}
		else
		{
			Object obj_4 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_AJ_JB.LARQ,PUB_AJ_JB.JARQ)) from PUB_AJ_JB,PUB_SPRY where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_AJ_JB.BASPT = '"+spt+"'  and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_SPRY.XM= '"+xm+"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' and  PUB_AJ_JB.AJXZ LIKE '8'  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0 AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+toDate+"')>=0").uniqueResult();
			if(null == obj_4)
			{
				zts = 0;
			}
			else
			{
				zts = (Integer)obj_4;
			}
			Object obj_5 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_SL_ZOZSL.ZZRQ,PUB_SL_ZOZSL.HFRQ)) FROM PUB_AJ_JB,PUB_SL_ZOZSL,PUB_SPRY WHERE PUB_AJ_JB.AJXH = PUB_SL_ZOZSL.AJXH and PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_SL_ZOZSL.ZZSLJG='Y' AND PUB_AJ_JB.BASPT = '"+spt+"'  and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_SPRY.XM= '"+xm+"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' and  PUB_AJ_JB.AJXZ LIKE '8'  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0 AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+toDate+"')>=0").uniqueResult();
			if(null == obj_5)
			{
				zzts = 0;
			}
			else
			{
				zzts = (Integer)obj_5;
			}
			Object obj_6 = getSession().createSQLQuery("SELECT SUM(DATEDIFF(DD, PUB_SL_SXZD.ZDRQ,PUB_SL_SXZD.HFRQ)) FROM PUB_AJ_JB,PUB_SL_SXZD,PUB_SPRY WHERE  PUB_AJ_JB.AJXH = PUB_SL_SXZD.AJXH and PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_SL_SXZD.ZDCLJG='Y' AND PUB_AJ_JB.BASPT = '"+spt+"'  and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_SPRY.XM= '"+xm+"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' and  PUB_AJ_JB.AJXZ LIKE '8'  AND PUB_AJ_JB.LARQ<>NULL AND PUB_AJ_JB.JARQ<>NULL AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0 AND DATEDIFF(DD,PUB_AJ_JB.JARQ,'"+toDate+"')>=0").uniqueResult();
			if(null == obj_6)
			{
				zdts = 0;
			}
			else
			{
				zdts = (Integer)obj_6;
			}			
		}
		float result = (Float.valueOf(zts) - Float.valueOf(zzts) - Float.valueOf(zdts))/Float.valueOf(shu);
		return result;
	}
	@SuppressWarnings("unchecked")
	private List<String> bmRenXmList(String sql)
	{
		List<String> xmList = new ArrayList<String>();
		List<Object[]> listObjs = (List<Object[]>)getSession().createSQLQuery(sql).list();
		 if(listObjs != null)
		 {
			 for(Object[] obj : listObjs)
			 {
				 
				 xmList.add((String)obj[0]);
			 }
		 }
		return xmList;
	}
	/**
	 * �����û������������
	 * @param xm
	 * @return
	 */
	private String getYongHuShenFenByXm(String xm)
	{
		
			String yonghuShenFen = " SELECT YHSF from PUB_XTGL_YHB where PUB_XTGL_YHB.YHMC = '"+xm+"'";		
			return (String) getSession().createSQLQuery(yonghuShenFen).uniqueResult();
	}
	

	// ��������ͥ
	public List<List<String>> getXzspYjda(String bmdm,Date fromDateD,Date toDateD)
	{
		// ��Ҫ����
		String fromDate = DateUtil.format(fromDateD, DateUtil.webFormat2);
		String toDate = DateUtil.format(toDateD, DateUtil.webFormat2);
		String tongFromDate = DateUtil.format(DateUtil.addYears(fromDateD,-1), DateUtil.webFormat2); 
		String tongToDate = DateUtil.format(DateUtil.addYears(toDateD,-1), DateUtil.webFormat2);
		// String bmdm = "03";
		// ��Ҫ����
		int columnCount = 39;
		String[] ls_dz = new String[columnCount];
		String[] ls_dz_t = new String[columnCount];
		long rowCount[] = new long[columnCount];
		long benqi[] = new long[columnCount];
		long tongqi[] = new long[columnCount];
		
		String spcxdzsql = "DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' ";
		//�ɴ永��
		ls_dz[1] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ��ɴ永��'and BZ='����ͳ��'");
		//���հ���
		ls_dz[2] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ����հ���'and BZ='����ͳ��'");
		//�ѽ᰸��new
		ls_dz[3] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ѽ᰸��'and BZ='����ͳ��'");
		//�������ѽ᰸
		ls_dz[4] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����������ѽ᰸'and BZ='����ͳ��'");
		//��������������
		ls_dz[5] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��������������'and BZ='����ͳ��'");
		//��������������
		ls_dz[6] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��������������'and BZ='����ͳ��'");
		//һ��᰸��new
		ls_dz[22] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ�����д���'and BZ='����ͳ��'");
		ls_dz[22] = spcxdzsql + ls_dz[22] +")";
		//����᰸��new
		ls_dz[23] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��'");
		ls_dz[23] = spcxdzsql + ls_dz[23] +")";
		//����᰸��new
//			select SQLNR INTO:ls_dz[24]  from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��';
		ls_dz[24] = spcxdzsql + "AND (DMMS LIKE '__��__' OR DMMS LIKE '__��')"+")";
		//�μӺ���ͥ������new
		ls_dz[26]=ls_dz[3];
		//�ŷ�Ͷ����new
		ls_dz[25] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ŷ�Ͷ����'and BZ='����ͳ��'");
//			//һ��᰸��
//			select SQLNR INTO:ls_dz[13]  from PUB_SQLLIB WHERE SQLMS='һ��᰸��'and BZ='����ͳ��';
//			if ls_dz[13]='' or isnull(ls_dz[13]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_һ��᰸��")
//			end if
//			//�����з�����
//			select SQLNR INTO:ls_dz[14]  from PUB_SQLLIB WHERE SQLMS='�����з�����'and BZ='����ͳ��';
//			if ls_dz[14]='' or isnull(ls_dz[14]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_�����з�����")
//			end if
		//һ��������
		ls_dz[8] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������'and BZ='����ͳ��'");
		//һ��������ͨ����᰸��
		ls_dz[9] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������ͨ����᰸��'and BZ='����ͳ��'");
		//����ͥ��
		ls_dz[10] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='����ͥ��'and BZ='����ͳ��'");
//			//����᰸��
//			select SQLNR INTO:ls_dz[11]  from PUB_SQLLIB WHERE SQLMS='����᰸��'and BZ='����ͳ��';
//			if ls_dz[11]='' or isnull(ls_dz[11]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_����᰸��")
//			end if
		//������
		ls_dz[12] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='������'and BZ='����ͳ��'");
		//�����з�����
		ls_dz[14] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����з�����'and BZ='����ͳ��'");
		//������
		ls_dz[15] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͨ����������'and BZ='����ͳ��'");
		//����δ�᰸
		ls_dz[17] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='����δ�᰸'and BZ='����ͳ��'");
		//��ֹδ�᰸
		ls_dz[18] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ֹδ�᰸'and BZ='����ͳ��'");
		//�ж�δ�᰸
		ls_dz[19] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ж�δ�᰸��'and BZ='����ͳ��'");
		//��ͣ����δ�᰸��
		ls_dz[20] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͣ��������δ�᰸��' and BZ='����ͳ��'");
		//18��������δ�᰸��
		ls_dz[21] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='18��������δ�᰸����' and BZ='����ͳ��'");
		//һ����׳���᰸��
		ls_dz[27] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ����׳���᰸��' and BZ='����ͳ��'");
		//�������ִ�а���
		ls_dz[28] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�������ִ�а���' and BZ='����ͳ��'");
		//���߸���
		ls_dz[29]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' AND  (DMMS LIKE '%��' OR (DMMS LIKE '%��' AND DMMS NOT LIKE '%��%��')) )";

		
		String lrx[] = new String[7];
		lrx[1] = "CBZASSA";
		lrx[2] = "CBZASJA";
		lrx[3] = "SPAJS";
		lrx[4] = "SPCPWSS";
		lrx[5] = "PCCPWSS";
		lrx[6] = "CXCCCPWSS";
		
		for(int i = 33; i < columnCount; i++)
		{
			ls_dz[i] = " DATEDIFF(DD,FGYG_LRX.RQ,#TJ_BEGIN#)<=0 and DATEDIFF(DD,FGYG_LRX.RQ,#TJ_END#)>=0 ";
		}
		// �滻ʱ���ַ���
		for(int i = 1; i < columnCount; i++)
		{
			ls_dz_t[i] = ls_dz[i];
			if(ls_dz[i] != null)
			{
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN#","'"+fromDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_END#", "'"+toDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN_JA#", "'"+fromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN#","'"+tongFromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_END#", "'"+tongToDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN_JA#", "'"+tongFromDate+"'");				  
			}
			
		}
		
		// ѡ����������ж��ٸ���
		String bmRenShu = "SELECT DISTINCT PUB_SPRY.XM,PUB_XTGL_YHB.YHSF FROM PUB_AJ_JB,PUB_SPRY,PUB_XTGL_YHB WHERE ( (((PUB_AJ_JB.JARQ=NULL OR DATEDIFF( DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0)    AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0)) OR (DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+fromDate+"')<=0  AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0) ) AND PUB_SPRY.AJXH=PUB_AJ_JB.AJXH AND PUB_SPRY.SFCBR='Y' AND PUB_AJ_JB.BASPT='"+bmdm+"' AND PUB_XTGL_YHB.YHMC=PUB_SPRY.XM ORDER BY PUB_XTGL_YHB.YHSF";
		System.out.println("bmRenShu-->"+bmRenShu);
		List<String> xmList = bmRenXmList(bmRenShu);
	    List<List<String>> results = new ArrayList<List<String>>();
	    List<List<Float>> resultReturns = new ArrayList<List<Float>>();
	    List<long[]> resultTemp = new ArrayList<long[]>();
	    List<Float> ajpjslts = new ArrayList<Float>(); 
	    
	    int k = -1;
 	    for(int i = 0; i  < xmList.size(); i++)
	    {
	    	String shengFenMc = getYongHuShenFenByXm(xmList.get(i));
	    	if(null == shengFenMc)
	    	{
	    		shengFenMc = "";
	    	}
	    	if( null != shengFenMc && (shengFenMc.equals("���") || shengFenMc.equals("���Ա") ||  shengFenMc.equals("��ʻԱ")))
	    	{
	    		continue;
	    	}
	    	// ��ʾ�ж���������
	        k++;
	    	List<String> cols = new ArrayList<String>();
	    	List<Float>  resultReturn = new ArrayList<Float>();
	    	long col[] = new long[columnCount];
	    	
	    	String sql_temp = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY" + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH" + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' AND ";
           
	    	
	    	// ����ְ��
	    	cols.add(shengFenMc);
	    	
	    	// ����
	    	cols.add(xmList.get(i));
	    	String str_sql = "";
	    	for(int j = 0; j < columnCount; j++)
	    	{
	    		
	    		if(j == 14)
	    		{
	    			str_sql = ls_dz[j] +" AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH " + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 15)
	    		{
	    			str_sql = ls_dz[j] + " AND PUB_AJ_JB.AJXH = PUB_SPRY.AJXH AND XF_LXDJ.AJXH = PUB_AJ_JB.AJXH " + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 26)
	    		{
	    			str_sql  = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY" + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH" + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'N' AND " +  ls_dz[3];
	    		}
	    		else if( j >= 33 && j <= 38)
	    		{
	    			str_sql  = "select sum("+lrx[j - 32]+") from FGYG_LRX where FGYG_LRX.XM= '"+xmList.get(i)+"' AND " + ls_dz[j];
	    		}
	    		else if(ls_dz[j] != null)
	    		{
	    			str_sql = sql_temp + ls_dz[j];
	    		}
	    		// ִ�л�ý��
	    		if(ls_dz[j] != null)
	    		{
	    			col[j] = getCountResult(str_sql);
	    			rowCount[j] += col[j];
	    		}
	    				
	    	}	
	    	
	    	 //����ƽ����������
    		str_sql = sql_temp+ ls_dz[3];
    		long temp = getCountResult(str_sql);
    		if(temp == 0)
    		{
    			ajpjslts.add(0f);
    		}
    		else
    		{
    			ajpjslts.add(pjslts(temp, bmdm, xmList.get(i), fromDate, toDate));
    		}
	    	
	    	resultTemp.add(col);
	    	resultReturns.add(resultReturn);
	    	results.add(cols);
	    	
	    	 // ����ƽ���������� ,���һ������
	    	xzEveryRowCount(cols,col,formatFloat(ajpjslts.get(k), "0.00"));
	    	       
	    }
 	   // ��Ա�ۼ�
 	   List<String> renyuleiji = new ArrayList<String>();
 	   renyuleiji.add("��Ա�ۼ�");
 	   renyuleiji.add("");	
 	   xzEveryRowCount(renyuleiji, rowCount,"");	   
       results.add(renyuleiji);
       
       //�Ը���ͥ�ϼ�--���� 
       String str_sql = "";
       List<String> bengqiRow = new ArrayList<String>();
       bengqiRow.add("����ͥ�Һϼ�");
       bengqiRow.add("");
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 14)
    	   {
    		   str_sql = ls_dz[i] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '"+bmdm + "'";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql = ls_dz[i] + "  and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '"+bmdm+"'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql =  "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz[i];
    	   }
    	   else if(ls_dz[i] != null)
    	   {
    		   str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB "  + " where PUB_AJ_JB.BASPT = '" +bmdm + "' AND " + ls_dz[i]; 
    	   }
    	   
    	   if(ls_dz[i] != null && i != 26)
    	   {
    		   benqi[i] = getCountResult(str_sql);
    	   }   	   
       }
       //����ƽ����������
		str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " + " where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz[3];
		long temp = getCountResult(str_sql);
		if(temp == 0)
		{
	       xzEveryRowCount(bengqiRow, benqi, "0");
		}
		else
		{
			xzEveryRowCount(bengqiRow, benqi,pjslts_bm(bmdm, fromDate,toDate, temp));
		}
       results.add(bengqiRow);
       
     //�Ը���ͥ�ϼ�--ͬ��
       String str_sql_2 = "";
       List<String> tongqiRow = new ArrayList<String>();
       tongqiRow.add("ͬ��ͥ�Һϼ�");
       tongqiRow.add("");
       
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 14)
    	   {
    		   str_sql_2 =  ls_dz_t[i] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '" +bmdm + "'";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql_2 = ls_dz_t[i] + " and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '" + bmdm + "'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql_2 =   "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz_t[i];
    	   }
    	   else if(ls_dz_t[i] != null)
    	   {
    		   str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +  " where PUB_AJ_JB.BASPT = '" +bmdm+"' AND " + ls_dz_t[i]; 
    	   }
    	   
    	   if(ls_dz[i] != null && i != 26)
    	   {
    		  //  System.out.println(str_sql_2);
    		   tongqi[i] = getCountResult(str_sql_2);
    	   }  
       }
     //����ƽ����������
		str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +" where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz_t[3];
		long temp_2 = getCountResult(str_sql_2);
		if(temp_2 == 0)
		{
	       xzEveryRowCount(tongqiRow, tongqi, "0");
		}
		else
		{
			xzEveryRowCount(tongqiRow,tongqi,pjslts_bm(bmdm, tongFromDate,tongToDate, temp_2));
		}
		
       results.add(tongqiRow);
       //�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
       List<String> btbi = new ArrayList<String>();
       btbi.add("ͥ��ͬ��");
       btbi.add("");
       for(int i = 2; i  <tongqiRow.size(); i++)
       {
    	  String benqiTem = bengqiRow.get(i).trim();
    	  String tongqiTem = tongqiRow.get(i).trim();
    	  if(benqiTem.equals("--") || tongqiTem.endsWith("--"))
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(tongqiTem) == 0)
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(benqiTem) == 0)
    	  {
    		  btbi.add("0");
    	  }
    	  else 
    	  {
    		//�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
    		 float resu =  Float.valueOf(benqiTem)/Float.valueOf(tongqiTem)*100 - 100;
    		 btbi.add(formatFloat(resu,"0.00"));
    	  }
       }
       results.add(btbi);
       
// 	   for(int i = 0; i < results.size(); i++)
// 	   {
// 		   for(int j = 0; j < results.get(i).size(); j++)
// 		   {
// 			   System.out.print((j)+" <> "+results.get(i).get(j) + "       ");
// 		   }
// 		   System.out.println("");
// 	   }
      return results;

	}
	// ��������ͥ
	public List<List<String>> getMsspYjda(String bmdm,Date fromDateD,Date toDateD)
	{
		// ��Ҫ����
		String fromDate = DateUtil.format(fromDateD, DateUtil.webFormat2);
		String toDate = DateUtil.format(toDateD, DateUtil.webFormat2);
		String tongFromDate = DateUtil.format(DateUtil.addYears(fromDateD,-1), DateUtil.webFormat2); 
		String tongToDate = DateUtil.format(DateUtil.addYears(toDateD,-1), DateUtil.webFormat2);
		// String bmdm = "03";
		// ��Ҫ����
		int columnCount = 40;
		String[] ls_dz = new String[columnCount];
		String[] ls_dz_t = new String[columnCount];
		long rowCount[] = new long[columnCount];
		long benqi[] = new long[columnCount];
		long tongqi[] = new long[columnCount];
		
		String spcxdzsql = "DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' ";
		//�ɴ永��
		ls_dz[1] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ��ɴ永��'and BZ='����ͳ��'");
		//���հ���
		ls_dz[2] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ����հ���'and BZ='����ͳ��'");
		//�ѽ᰸��new
		ls_dz[3] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ѽ᰸��'and BZ='����ͳ��'");
		//�������ѽ᰸
		ls_dz[4] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����������ѽ᰸'and BZ='����ͳ��'");
		//���°���������
		ls_dz[5] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//���°���������
		ls_dz[6] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//һ��᰸��new
		ls_dz[22] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ�����д���'and BZ='����ͳ��'");
		ls_dz[22] = spcxdzsql + ls_dz[22] +")";
		//����᰸��new
		ls_dz[23] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��'");
		ls_dz[23] = spcxdzsql + ls_dz[23] +")";
		//����᰸��new
//			select SQLNR INTO:ls_dz[24]  from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��';
		ls_dz[24] = spcxdzsql + "AND (DMMS LIKE '__��__' OR DMMS LIKE '__��')"+")";
		//�μӺ���ͥ������new
		ls_dz[26]=ls_dz[3];
		//�ŷ�Ͷ����new
		ls_dz[25] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ŷ�Ͷ����'and BZ='����ͳ��'");
		//һ��������
		ls_dz[8] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������'and BZ='����ͳ��'");
		//һ��������ͨ����᰸��
		ls_dz[9] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������ͨ����᰸��'and BZ='����ͳ��'");
		//����ͥ��
		ls_dz[10] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='����ͥ��'and BZ='����ͳ��'");
		//������
		ls_dz[12] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='������'and BZ='����ͳ��'");
		//�����з�����
		ls_dz[14] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����з�����'and BZ='����ͳ��'");
		//������
		ls_dz[15] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͨ����������'and BZ='����ͳ��'");
		//����δ�᰸
		ls_dz[17] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='����δ�᰸'and BZ='����ͳ��'");
		//��ֹδ�᰸
		ls_dz[18] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ֹδ�᰸'and BZ='����ͳ��'");
		//�ж�δ�᰸
		ls_dz[19] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ж�δ�᰸��'and BZ='����ͳ��'");
		//��ͣ����δ�᰸��
		ls_dz[20] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͣ��������δ�᰸��' and BZ='����ͳ��'");
		//18��������δ�᰸��
		ls_dz[21] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='18��������δ�᰸����' and BZ='����ͳ��'");
		//һ����׳���᰸��
		ls_dz[27] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ����׳���᰸��' and BZ='����ͳ��'");
		//���߸���
		ls_dz[28]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' AND  (DMMS LIKE '%��' OR (DMMS LIKE '%��' AND DMMS NOT LIKE '%��%��')) )";
		//�����ر���򳷻�������
		ls_dz[39]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCX='4' AND PUB_AJ_JB.AJXZ IN ('2','3','4','5') AND PUB_AJ_JB.JAFS='2'";



		
		String lrx[] = new String[7];
		lrx[1] = "CBZASSA";
		lrx[2] = "CBZASJA";
		lrx[3] = "SPAJS";
		lrx[4] = "SPCPWSS";
		lrx[5] = "PCCPWSS";
		lrx[6] = "CXCCCPWSS";
		
		for(int i = 33; i < 39; i++)
		{
			ls_dz[i] = " DATEDIFF(DD,FGYG_LRX.RQ,#TJ_BEGIN#)<=0 and DATEDIFF(DD,FGYG_LRX.RQ,#TJ_END#)>=0 ";
		}
		// �滻ʱ���ַ���
		for(int i = 1; i < columnCount; i++)
		{
			ls_dz_t[i] = ls_dz[i];
			if(ls_dz[i] != null)
			{
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN#","'"+fromDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_END#", "'"+toDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN_JA#", "'"+fromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN#","'"+tongFromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_END#", "'"+tongToDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN_JA#", "'"+tongFromDate+"'");				  
			}
			
		}
		
		// ѡ����������ж��ٸ���
		//String bmRenShu = "SELECT DISTINCT PUB_SPRY.XM  FROM PUB_AJ_JB,PUB_SPRY  WHERE ( (((PUB_AJ_JB.JARQ=NULL OR DATEDIFF( DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0)    AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0)) OR (DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+fromDate+"')<=0  AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0) ) AND PUB_SPRY.AJXH=PUB_AJ_JB.AJXH AND PUB_SPRY.SFCBR='Y' AND PUB_AJ_JB.BASPT='"+bmdm+"'";
		String bmRenShu = "SELECT DISTINCT PUB_SPRY.XM,PUB_XTGL_YHB.YHSF FROM PUB_AJ_JB,PUB_SPRY,PUB_XTGL_YHB WHERE ( (((PUB_AJ_JB.JARQ=NULL OR DATEDIFF( DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0)    AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0)) OR (DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+fromDate+"')<=0  AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0) ) AND PUB_SPRY.AJXH=PUB_AJ_JB.AJXH AND PUB_SPRY.SFCBR='Y' AND PUB_AJ_JB.BASPT='"+bmdm+"' AND PUB_XTGL_YHB.YHMC=PUB_SPRY.XM ORDER BY PUB_XTGL_YHB.YHSF";
		System.out.println(bmRenShu);
		List<String> xmList = bmRenXmList(bmRenShu);
	    List<List<String>> results = new ArrayList<List<String>>();
	    List<List<Float>> resultReturns = new ArrayList<List<Float>>();
	    List<long[]> resultTemp = new ArrayList<long[]>();
	    List<Float> ajpjslts = new ArrayList<Float>(); 
	    
	    int k = -1;
 	    for(int i = 0; i  < xmList.size(); i++)
	    {
	    	String shengFenMc = getYongHuShenFenByXm(xmList.get(i));
	    	if(null == shengFenMc)
	    	{
	    		shengFenMc = "";
	    	}
	    	if( null != shengFenMc && (shengFenMc.equals("���") || shengFenMc.equals("���Ա") ||  shengFenMc.equals("��ʻԱ")))
	    	{
	    		continue;
	    	}
	    	// ��ʾ�ж���������
	        k++;
	    	List<String> cols = new ArrayList<String>();
	    	List<Float>  resultReturn = new ArrayList<Float>();
	    	long col[] = new long[columnCount];
	    	
	    	String sql_temp = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY" + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH" + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' AND ";
           
	    	
	    	// ����ְ��
	    	cols.add(shengFenMc);
	    	
	    	// ����
	    	cols.add(xmList.get(i));
	    	String str_sql = "";
	    	for(int j = 0; j < columnCount; j++)
	    	{
	    		
	    		if(j == 14)
	    		{
	    			str_sql = ls_dz[j] +" AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH " + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 15)
	    		{
	    			str_sql = ls_dz[j] + " AND PUB_AJ_JB.AJXH = PUB_SPRY.AJXH AND XF_LXDJ.AJXH = PUB_AJ_JB.AJXH " + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 26)
	    		{
	    			str_sql  = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY" + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH" + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'N' AND " +  ls_dz[3];
	    		}
	    		else if( j >= 33 && j <= 38)
	    		{
	    			str_sql  = "select sum("+lrx[j - 32]+") from FGYG_LRX where FGYG_LRX.XM= '"+xmList.get(i)+"' AND " + ls_dz[j];
	    		}
	    		else if(ls_dz[j] != null)
	    		{
	    			str_sql = sql_temp + ls_dz[j];
	    		}
	    		// ִ�л�ý��
	    		if(ls_dz[j] != null)
	    		{
	    			col[j] = getCountResult(str_sql);
	    			rowCount[j] += col[j];
	    		}
	    				
	    	}	
	    	
	    	 //����ƽ����������
    		str_sql = sql_temp+ ls_dz[3];
    		long temp = getCountResult(str_sql);
    		if(temp == 0)
    		{
    			ajpjslts.add(0f);
    		}
    		else
    		{
    			ajpjslts.add(pjslts(temp, bmdm, xmList.get(i), fromDate, toDate));
    		}
	    	
	    	resultTemp.add(col);
	    	resultReturns.add(resultReturn);
	    	results.add(cols);
	    	
	    	 // ����ƽ���������� ,���һ������
	    	msEveryRowCount(cols,col,formatFloat(ajpjslts.get(k), "0.00"));
	    	       
	    }
 	   
 	   // ��Ա�ۼ�
 	   List<String> renyuleiji = new ArrayList<String>();
 	   renyuleiji.add("��Ա�ۼ�");
 	   renyuleiji.add("");	
 	   msEveryRowCount(renyuleiji, rowCount,"");	   
       results.add(renyuleiji);
       
       //�Ը���ͥ�ϼ�--���� 
       String str_sql = "";
       List<String> bengqiRow = new ArrayList<String>();
       bengqiRow.add("����ͥ�Һϼ�");
       bengqiRow.add("");
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 14)
    	   {
    		   str_sql = ls_dz[i] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '"+bmdm + "'";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql = ls_dz[i] + "  and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '"+bmdm+"'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql =  "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz[i];
    	   }
    	   else if(ls_dz[i] != null)
    	   {
    		   str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB "  + " where PUB_AJ_JB.BASPT = '" +bmdm + "' AND " + ls_dz[i]; 
    	   }
    	   
    	   if(ls_dz[i] != null && i != 26)
    	   {
    		   benqi[i] = getCountResult(str_sql);
    	   }   	   
       }
       //����ƽ����������
		str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " + " where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz[3];
		long temp = getCountResult(str_sql);
		if(temp == 0)
		{
	       msEveryRowCount(bengqiRow, benqi, "0");
		}
		else
		{
			msEveryRowCount(bengqiRow, benqi,pjslts_bm(bmdm, fromDate,toDate, temp));
		}
       results.add(bengqiRow);
       
     //�Ը���ͥ�ϼ�--ͬ��
       String str_sql_2 = "";
       List<String> tongqiRow = new ArrayList<String>();
       tongqiRow.add("ͬ��ͥ�Һϼ�");
       tongqiRow.add("");
       
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 14)
    	   {
    		   str_sql_2 =  ls_dz_t[i] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '" +bmdm + "'";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql_2 = ls_dz_t[i] + " and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '" + bmdm + "'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql_2 =   "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz_t[i];
    	   }
    	   else if(ls_dz_t[i] != null)
    	   {
    		   str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +  " where PUB_AJ_JB.BASPT = '" +bmdm+"' AND " + ls_dz_t[i]; 
    	   }
    	   
    	   if(ls_dz[i] != null && i != 26)
    	   {
    		   // System.out.println(str_sql_2);
    		   tongqi[i] = getCountResult(str_sql_2);
    	   }  
       }
     //����ƽ����������
		str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +" where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz_t[3];
		long temp_2 = getCountResult(str_sql_2);
		if(temp_2 == 0)
		{
	       msEveryRowCount(tongqiRow, tongqi, "0");
		}
		else
		{
			msEveryRowCount(tongqiRow,tongqi,pjslts_bm(bmdm, tongFromDate,tongToDate, temp_2));
		}
		
       results.add(tongqiRow);
       //�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
       List<String> btbi = new ArrayList<String>();
       btbi.add("ͥ��ͬ��");
       btbi.add("");
       for(int i = 2; i  <tongqiRow.size(); i++)
       {
    	  String benqiTem = bengqiRow.get(i).trim();
    	  String tongqiTem = tongqiRow.get(i).trim();
    	  if(benqiTem.equals("--") || tongqiTem.endsWith("--"))
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(tongqiTem) == 0)
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(benqiTem) == 0)
    	  {
    		  btbi.add("0");
    	  }
    	  else 
    	  {
    		//�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
    		 float resu =  Float.valueOf(benqiTem)/Float.valueOf(tongqiTem)*100 - 100;
    		 btbi.add(formatFloat(resu,"0.00"));
    	  }
       }
       results.add(btbi);
       
// 	   for(int i = 0; i < results.size(); i++)
// 	   {
// 		   for(int j = 0; j < results.get(i).size(); j++)
// 		   {
// 			   System.out.print((j)+" <> "+results.get(i).get(j) + "       ");
// 		   }
// 		   System.out.println("");
// 	   }
		
       return results;
	}
	
	// ִ�о�
	public List<List<String>> getZxspYjda(String bmdm,Date fromDateD,Date toDateD)
	{
		// ��Ҫ����
		String fromDate = DateUtil.format(fromDateD, DateUtil.webFormat2);
		String toDate = DateUtil.format(toDateD, DateUtil.webFormat2);
		String tongFromDate = DateUtil.format(DateUtil.addYears(fromDateD,-1), DateUtil.webFormat2); 
		String tongToDate = DateUtil.format(DateUtil.addYears(toDateD,-1), DateUtil.webFormat2);
		// String bmdm = "03";
		// ��Ҫ����
		int columnCount = 39;
		String[] ls_dz = new String[columnCount];
		String[] ls_dz_t = new String[columnCount];
		float rowCount[] = new float[columnCount];
		float benqi[] = new float[columnCount];
		float tongqi[] = new float[columnCount];
		
		//ִ�в��Ű������������ɴ�
		ls_dz[1] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�в��Ű������������ɴ�'and BZ='����ͳ��'");
		//ִ�в��Ű���������������
		ls_dz[2] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�в��Ű���������������'and BZ='����ͳ��'");
		//ִ�в��Ž᰸����
		ls_dz[3] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�в��Ž᰸����'and BZ='����ͳ��'");
		//��������ִ���ڽ᰸��
		ls_dz[4] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��������ִ���ڽ᰸��'and BZ='����ͳ��'");
		//ִ�е�λ��Ķ�
		ls_dz[5] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�е�λ��λ��'and BZ='����ͳ��'");
		//ִ�������Ķ�
		ls_dz[6] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�������Ķ�'and BZ='����ͳ��'");
		//ִ�кͽ������Ķ�
		ls_dz[7] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�кͽ������Ķ�'and BZ='����ͳ��'");
		//ִ�а���Ͷ����
		ls_dz[8] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�а���Ͷ����'and BZ='����ͳ��'");
		//������
		ls_dz[15] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͨ����������'and BZ='����ͳ��'");
		//ִ�в���δ�᰸����׼�ӳ�
		ls_dz[17] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�в���δ�᰸����׼�ӳ�'and BZ='����ͳ��'");
		//ִ�в���δ�᰸����ִֹ��
		ls_dz[18] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�в���δ�᰸����ִֹ��'and BZ='����ͳ��'");
		//ִ�в���δ�᰸���ж�
		ls_dz[19] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�в���δ�᰸���ж�'and BZ='����ͳ��'");
		//��ͣ����ִ��δ�᰸��
		ls_dz[20] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͣ����ִ��δ�᰸��'and BZ='����ͳ��'");
		ls_dz[21] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='18��������δ�᰸����'and BZ='����ͳ��'");
		//ִ�а���ǿ��ִ��
		ls_dz[30] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�а���ǿ��ִ��'and BZ='����ͳ��'");
		ls_dz[31] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�а����Զ�����'and BZ='����ͳ��'");
		ls_dz[32] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='ִ�а����ͽ�'and BZ='����ͳ��'");



		
		String lrx[] = new String[7];
		lrx[1] = "CBZASSA";
		lrx[2] = "CBZASJA";
		lrx[3] = "SPAJS";
		lrx[4] = "SPCPWSS";
		lrx[5] = "PCCPWSS";
		lrx[6] = "CXCCCPWSS";
		
		for(int i = 33; i < 39; i++)
		{
			ls_dz[i] = " DATEDIFF(DD,FGYG_LRX.RQ,#TJ_BEGIN#)<=0 and DATEDIFF(DD,FGYG_LRX.RQ,#TJ_END#)>=0 ";
		}
		// �滻ʱ���ַ���
		for(int i = 1; i < columnCount; i++)
		{
			ls_dz_t[i] = ls_dz[i];
			if(ls_dz[i] != null)
			{
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN#","'"+fromDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_END#", "'"+toDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN_JA#", "'"+fromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN#","'"+tongFromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_END#", "'"+tongToDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN_JA#", "'"+tongFromDate+"'");				  
			}
			
		}
		
		// ѡ����������ж��ٸ���
		String bmRenShu = "SELECT DISTINCT PUB_SPRY.XM,PUB_XTGL_YHB.YHSF  FROM PUB_AJ_JB,PUB_SPRY,PUB_XTGL_YHB  WHERE ( (((PUB_AJ_JB.JARQ=NULL OR DATEDIFF( DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0)    AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0)) OR (DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+fromDate+"')<=0  AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0) ) AND PUB_SPRY.AJXH=PUB_AJ_JB.AJXH AND PUB_SPRY.SFCBR='Y' AND PUB_AJ_JB.BASPT='"+bmdm+"' AND PUB_XTGL_YHB.YHMC=PUB_SPRY.XM ORDER BY PUB_XTGL_YHB.YHSF";
	    System.out.println("-sql---->"+bmRenShu);
		List<String> xmList = bmRenXmList(bmRenShu);
	    List<List<String>> results = new ArrayList<List<String>>();
	    List<List<Float>> resultReturns = new ArrayList<List<Float>>();
	    List<float[]> resultTemp = new ArrayList<float[]>();
	    List<Float> ajpjslts = new ArrayList<Float>(); 
	    try
	    {
	    int k = -1;
 	    for(int i = 0; i  < xmList.size(); i++)
	    {
	    	String shengFenMc = getYongHuShenFenByXm(xmList.get(i));
	    	if(null == shengFenMc)
	    	{
	    		shengFenMc = "";
	    	}
	    	if( null != shengFenMc && (shengFenMc.equals("���") || shengFenMc.equals("���Ա") ||  shengFenMc.equals("��ʻԱ")))
	    	{
	    		continue;
	    	}
	    	// ��ʾ�ж���������
	        k++;
	    	List<String> cols = new ArrayList<String>();
	    	List<Float>  resultReturn = new ArrayList<Float>();
	    	float col[] = new float[columnCount];
	    	
	    	String sql_temp = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY" + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH" + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' AND ";
           
	    	
	    	// ����ְ��
	    	cols.add(shengFenMc);
	    	
	    	// ����
	    	cols.add(xmList.get(i));
	    	String str_sql = "";
	    	for(int j = 0; j < columnCount; j++)
	    	{
	    		
	    		if(j == 5 || j == 6 || j == 7 )
	    		{
	    			str_sql = ls_dz[j] +" AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH "+" AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 15)
	    		{
	    			str_sql = ls_dz[j] + " AND PUB_AJ_JB.AJXH = PUB_SPRY.AJXH AND XF_LXDJ.AJXH = PUB_AJ_JB.AJXH "+" AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 8)
	    		{
	    			str_sql  = ls_dz[j] + " AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_AJ_JB.AJXH=XF_LXDJ.AJXH "+" AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if( j >= 33 && j <= 38)
	    		{
	    			str_sql  = "select sum("+lrx[j - 32]+") from FGYG_LRX where FGYG_LRX.XM= '"+xmList.get(i)+"' AND " + ls_dz[j];
	    		}
	    		else if(ls_dz[j] != null)
	    		{
	    			str_sql = sql_temp + ls_dz[j];
	    		}
	    		// ִ�л�ý��
	    		if(ls_dz[j] != null)
	    		{
	    			col[j] = getCountResultTurnToFloat(str_sql);
	    			rowCount[j] += col[j];
	    		}
	    				
	    	}	
	    	
	    	 //����ƽ����������
    		str_sql = sql_temp+ ls_dz[3];
    		long temp = getCountResult(str_sql);
    		if(temp == 0)
    		{
    			ajpjslts.add(0f);
    		}
    		else
    		{
    			ajpjslts.add(pjslts(temp, bmdm, xmList.get(i), fromDate, toDate));
    		}
	    	
	    	resultTemp.add(col);
	    	resultReturns.add(resultReturn);
	    	results.add(cols);
	    	
	    	 // ����ƽ���������� ,���һ������
	    	zxEveryRowCount(cols,col,formatFloat(ajpjslts.get(k), "0.00"));
	    	       
	    }
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
 	   // ��Ա�ۼ�
 	   List<String> renyuleiji = new ArrayList<String>();
 	   renyuleiji.add("��Ա�ۼ�");
 	   renyuleiji.add("");	
 	   zxEveryRowCount(renyuleiji, rowCount,"");	   
       results.add(renyuleiji);
       
       //�Ը���ͥ�ϼ�--���� 
       String str_sql = "";
       List<String> bengqiRow = new ArrayList<String>();
       bengqiRow.add("����ͥ�Һϼ�");
       bengqiRow.add("");
       try
	   {
		   
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 5 || i == 6 || i == 7 )
    	   {
    		   str_sql = ls_dz[i] + "  AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_AJ_JB.BASPT = '"+bmdm + "' and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
    	   }
    	   else if(i == 8)
    	   {
    		   str_sql = ls_dz[i] + " AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_AJ_JB.AJXH=XF_LXDJ.AJXH AND PUB_AJ_JB.BASPT = '" + bmdm + "' and PUB_AJ_JB.SPCXDZ <> NULL";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql = ls_dz[i] + " and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '"+bmdm+"'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql =  "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz[i];
    	   }
    	   else if(ls_dz[i] != null)
    	   {
    		  
    		   
    		   str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB "  + " where PUB_AJ_JB.BASPT = '" +bmdm + "' AND PUB_AJ_JB.SPCXDZ <> NULL AND " + ls_dz[i]; 
    	      //  System.out.println("sql--->"+ i +"-------"+ls_dz[i]);
    		  
    	   }
    	   
    	   if(ls_dz[i] != null)
    	   {
    		   benqi[i] = getCountResultTurnToFloat(str_sql);
    	   }   	   
       }
	   }
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
       //����ƽ����������
		str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " + " where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz[3];
		long temp = getCountResult(str_sql);
		if(temp == 0)
		{
	       zxEveryRowCount(bengqiRow, benqi, "0");
		}
		else
		{
			zxEveryRowCount(bengqiRow, benqi,pjslts_bm(bmdm, fromDate,toDate, temp));
		}
       results.add(bengqiRow);
       
     //�Ը���ͥ�ϼ�--ͬ��
       String str_sql_2 = "";
       List<String> tongqiRow = new ArrayList<String>();
       tongqiRow.add("ͬ��ͥ�Һϼ�");
       tongqiRow.add("");
       
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 5 || i==6 || i==7)
    	   {
    		   str_sql_2 =  ls_dz_t[i] + " AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_AJ_JB.BASPT = '" +bmdm +  "' and PUB_AJ_JB.SPCXDZ <> NULL AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
    	   }
    	   else if(i == 8)
    	   {
    		   str_sql_2 = ls_dz_t[i] + " AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH AND PUB_AJ_JB.AJXH=XF_LXDJ.AJXH AND PUB_AJ_JB.BASPT = '" + bmdm + "' and PUB_AJ_JB.SPCXDZ <> NULL";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql_2 = ls_dz_t[i] + " and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '" + bmdm + "'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql_2 =   "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz_t[i];
    	   }
    	   else if(ls_dz_t[i] != null)
    	   {
    		   str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +  " where PUB_AJ_JB.BASPT = '" +bmdm+"' and PUB_AJ_JB.SPCXDZ <> NULL AND " + ls_dz_t[i]; 
    	   }
    	   
    	   if(ls_dz_t[i] != null)
    	   {
    		   tongqi[i] = getCountResultTurnToFloat(str_sql_2);
    	   }  
       }
     //����ƽ����������
		str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +" where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz_t[3];
		long temp_2 = getCountResult(str_sql_2);
		if(temp_2 == 0)
		{
	       zxEveryRowCount(tongqiRow, tongqi, "0");
		}
		else
		{
			zxEveryRowCount(tongqiRow,tongqi,pjslts_bm(bmdm, tongFromDate,tongToDate, temp_2));
		}
		
       results.add(tongqiRow);
       //�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
       List<String> btbi = new ArrayList<String>();
       btbi.add("ͥ��ͬ��");
       btbi.add("");
       for(int i = 2; i  <tongqiRow.size(); i++)
       {
    	  String benqiTem = bengqiRow.get(i).trim();
    	  String tongqiTem = tongqiRow.get(i).trim();
    	  if(benqiTem.equals("--") || tongqiTem.endsWith("--"))
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(tongqiTem) == 0)
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(benqiTem) == 0)
    	  {
    		  btbi.add("0");
    	  }
    	  else 
    	  {
    		//�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
    		 float resu =  Float.valueOf(benqiTem)/Float.valueOf(tongqiTem)*100 - 100;
    		 btbi.add(formatFloat(resu,"0.00"));
    	  }
       }
       results.add(btbi);
       
// 	   for(int i = 0; i < results.size(); i++)
// 	   {
// 		   for(int j = 0; j < results.get(i).size(); j++)
// 		   {
// 			   System.out.print((j)+" <> "+results.get(i).get(j) + "       ");
// 		   }
// 		   System.out.println("");
// 	   }
		
       return results;
	}
	
	// ����ͥ
	public List<List<String>> getLaspYjda(String bmdm,Date fromDateD,Date toDateD)
	{
		// ��Ҫ����
		String fromDate = DateUtil.format(fromDateD, DateUtil.webFormat2);
		String toDate = DateUtil.format(toDateD, DateUtil.webFormat2);
		String tongFromDate = DateUtil.format(DateUtil.addYears(fromDateD,-1), DateUtil.webFormat2); 
		String tongToDate = DateUtil.format(DateUtil.addYears(toDateD,-1), DateUtil.webFormat2);
		// String bmdm = "03";
		// ��Ҫ����
		int columnCount = 39;
		String[] ls_dz = new String[columnCount];
		String[] ls_dz_t = new String[columnCount];
		long rowCount[] = new long[columnCount];
		long benqi[] = new long[columnCount];
		long tongqi[] = new long[columnCount];
		
		String spcxdzsql = "DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' ";
		//�ɴ永��
		ls_dz[1] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ��ɴ永��'and BZ='����ͳ��'");
		//���հ���
		ls_dz[2] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ����հ���'and BZ='����ͳ��'");
		//�ѽ᰸��new
		ls_dz[3] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ѽ᰸��'and BZ='����ͳ��'");
		//�������ѽ᰸
		ls_dz[4] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����������ѽ᰸'and BZ='����ͳ��'");
		//���°���������
		ls_dz[5] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//���°���������
		ls_dz[6] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//һ��᰸��new
		ls_dz[22] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ�����д���'and BZ='����ͳ��'");
		ls_dz[22] = spcxdzsql + ls_dz[22] +")";
		//����᰸��new
		ls_dz[23] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��'");
		ls_dz[23] = spcxdzsql + ls_dz[23] +")";
		//����᰸��new
//			select SQLNR INTO:ls_dz[24]  from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��';
		ls_dz[24] = spcxdzsql + "AND (DMMS LIKE '__��__' OR DMMS LIKE '__��')"+")";
		//�μӺ���ͥ������new
		ls_dz[26]=ls_dz[3];
		//�ŷ�Ͷ����new
		ls_dz[25] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ŷ�Ͷ����'and BZ='����ͳ��'");
		//����δ�᰸
		ls_dz[17] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='����δ�᰸'and BZ='����ͳ��'");
		//��ֹδ�᰸
		ls_dz[18] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ֹδ�᰸'and BZ='����ͳ��'");
		//�ж�δ�᰸
		ls_dz[19] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ж�δ�᰸��'and BZ='����ͳ��'");
		//��ͣ����δ�᰸��
		ls_dz[20] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͣ��������δ�᰸��' and BZ='����ͳ��'");
		//18��������δ�᰸��
		ls_dz[21] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='18��������δ�᰸����' and BZ='����ͳ��'");
		//���߸���
		ls_dz[28]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' AND  (DMMS LIKE '%��' OR (DMMS LIKE '%��' AND DMMS NOT LIKE '%��%��')) )";
	
		String lrx[] = new String[7];
		lrx[1] = "CBZASSA";
		lrx[2] = "CBZASJA";
		lrx[3] = "SPAJS";
		lrx[4] = "SPCPWSS";
		lrx[5] = "PCCPWSS";
		lrx[6] = "CXCCCPWSS";
		
		for(int i = 33; i < 39; i++)
		{
			ls_dz[i] = " DATEDIFF(DD,FGYG_LRX.RQ,#TJ_BEGIN#)<=0 and DATEDIFF(DD,FGYG_LRX.RQ,#TJ_END#)>=0 ";
		}
		// �滻ʱ���ַ���
		for(int i = 1; i < columnCount; i++)
		{
			ls_dz_t[i] = ls_dz[i];
			if(ls_dz[i] != null)
			{
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN#","'"+fromDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_END#", "'"+toDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN_JA#", "'"+fromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN#","'"+tongFromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_END#", "'"+tongToDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN_JA#", "'"+tongFromDate+"'");				  
			}
			
		}
		
		// ѡ����������ж��ٸ���
		String bmRenShu = "SELECT DISTINCT PUB_SPRY.XM,PUB_XTGL_YHB.YHSF  FROM PUB_AJ_JB,PUB_SPRY,PUB_XTGL_YHB  WHERE ( (((PUB_AJ_JB.JARQ=NULL OR DATEDIFF( DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0)    AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0)) OR (DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+fromDate+"')<=0  AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0) ) AND PUB_SPRY.AJXH=PUB_AJ_JB.AJXH AND PUB_SPRY.SFCBR='Y' AND PUB_AJ_JB.BASPT='"+bmdm+"' AND PUB_XTGL_YHB.YHMC=PUB_SPRY.XM ORDER BY PUB_XTGL_YHB.YHSF";
	   //  System.out.println("-sql---->"+bmRenShu);
		List<String> xmList = bmRenXmList(bmRenShu);
	    List<List<String>> results = new ArrayList<List<String>>();
	    List<List<Float>> resultReturns = new ArrayList<List<Float>>();
	    List<long[]> resultTemp = new ArrayList<long[]>();
	    List<Float> ajpjslts = new ArrayList<Float>(); 
	    
	    int k = -1;
 	    for(int i = 0; i  < xmList.size(); i++)
	    {
	    	String shengFenMc = getYongHuShenFenByXm(xmList.get(i));
	    	if(null == shengFenMc)
	    	{
	    		shengFenMc = "";
	    	}
	    	if( null != shengFenMc && (shengFenMc.equals("���") || shengFenMc.equals("���Ա") ||  shengFenMc.equals("��ʻԱ")))
	    	{
	    		continue;
	    	}
	    	// ��ʾ�ж���������
	        k++;
	    	List<String> cols = new ArrayList<String>();
	    	List<Float>  resultReturn = new ArrayList<Float>();
	    	long col[] = new long[columnCount];
	    	
	    	String sql_temp = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY" + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH" + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' AND ";
           
	    	
	    	// ����ְ��
	    	cols.add(shengFenMc);
	    	
	    	// ����
	    	cols.add(xmList.get(i));
	    	String str_sql = "";
	    	for(int j = 0; j < columnCount; j++)
	    	{
	    		
	    		if(j == 26 )
	    		{
	    			str_sql = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY"+" where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH"+" AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'N' AND " + ls_dz[3];
	    		}	    		
	    		else if( j >= 33 && j <= 38)
	    		{
	    			str_sql  = "select sum("+lrx[j - 32]+") from FGYG_LRX where FGYG_LRX.XM= '"+xmList.get(i)+"' AND " + ls_dz[j];
	    		}
	    		else if(ls_dz[j] != null)
	    		{
	    			str_sql = sql_temp + ls_dz[j];
	    		}
	    		// ִ�л�ý��
	    		if(ls_dz[j] != null)
	    		{
	    			col[j] = getCountResult(str_sql);
	    			rowCount[j] += col[j];
	    		}
	    				
	    	}	
	    	
	    	 //����ƽ����������
    		str_sql = sql_temp+ ls_dz[3];
    		long temp = getCountResult(str_sql);
    		if(temp == 0)
    		{
    			ajpjslts.add(0f);
    		}
    		else
    		{
    			ajpjslts.add(pjslts(temp, bmdm, xmList.get(i), fromDate, toDate));
    		}
	    	
	    	resultTemp.add(col);
	    	resultReturns.add(resultReturn);
	    	results.add(cols);
	    	
	    	 // ����ƽ���������� ,���һ������
	    	laEveryRowCount(cols,col,formatFloat(ajpjslts.get(k), "0.00"));
	    	       
	    }
 	   // ��Ա�ۼ�
 	   List<String> renyuleiji = new ArrayList<String>();
 	   renyuleiji.add("��Ա�ۼ�");
 	   renyuleiji.add("");	
 	   laEveryRowCount(renyuleiji, rowCount,"");	   
       results.add(renyuleiji);
//       for(int i = 0; i < renyuleiji.size();  i++)
// 	   {
// 		   System.out.println("-leiji-->" + i + "-" + rowCount[i]);
// 	   }
       //�Ը���ͥ�ϼ�--���� 
       String str_sql = "";
       List<String> bengqiRow = new ArrayList<String>();
       bengqiRow.add("����ͥ�Һϼ�");
       bengqiRow.add("");
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 14)
    	   {
    		   str_sql = ls_dz[i] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '"+bmdm +"' and PUB_AJ_JB.SPCXDZ <> NULL ";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql =  "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz[i];
    	   }
    	   else if(ls_dz[i] != null)
    	   {
    		   str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB "  + " where PUB_AJ_JB.BASPT = '" +bmdm + "' AND " + ls_dz[i]; 
    	   }
    	   
    	   if(ls_dz[i] != null && i != 26)
    	   {
    		   benqi[i] = getCountResult(str_sql);
    	   }   	   
       }
       //����ƽ����������
		str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " + " where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz[3];
		long temp = getCountResult(str_sql);
		if(temp == 0)
		{
	       laEveryRowCount(bengqiRow, benqi, "0");
		}
		else
		{
			laEveryRowCount(bengqiRow, benqi,pjslts_bm(bmdm, fromDate,toDate, temp));
		}
//		 for(int i = 0; i < renyuleiji.size();  i++)
//	 	   {
//	 		   System.out.println("-leiji-->" + i + "-" + benqi[i]);
//	 	   }
       results.add(bengqiRow);
       
     //�Ը���ͥ�ϼ�--ͬ��
       String str_sql_2 = "";
       List<String> tongqiRow = new ArrayList<String>();
       tongqiRow.add("ͬ��ͥ�Һϼ�");
       tongqiRow.add("");
       
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i == 14)
    	   {
    		   str_sql = ls_dz_t[i] + " and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '"+bmdm +"' and PUB_AJ_JB.SPCXDZ <> NULL ";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql =  "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz_t[i];
    	   }
    	   else if(ls_dz[i] != null)
    	   {
    		   str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB "  + " where PUB_AJ_JB.BASPT = '" +bmdm + "' AND " + ls_dz_t[i]; 
    	   }
    	   
    	   if(ls_dz[i] != null && i != 26)
    	   {
    		   tongqi[i] = getCountResult(str_sql);
    	   }  
       }
     //����ƽ����������
		str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +" where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz_t[3];
		long temp_2 = getCountResult(str_sql_2);
		if(temp_2 == 0)
		{
	       laEveryRowCount(tongqiRow, tongqi, "0");
		}
		else
		{
			laEveryRowCount(tongqiRow,tongqi,pjslts_bm(bmdm, tongFromDate,tongToDate, temp_2));
		}
		
       results.add(tongqiRow);
       //�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
       List<String> btbi = new ArrayList<String>();
       btbi.add("ͥ��ͬ��");
       btbi.add("");
       for(int i = 2; i  <tongqiRow.size(); i++)
       {
    	  String benqiTem = bengqiRow.get(i).trim();
    	  String tongqiTem = tongqiRow.get(i).trim();
    	  if(benqiTem.equals("--") || tongqiTem.endsWith("--"))
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(tongqiTem) == 0)
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(benqiTem) == 0)
    	  {
    		  btbi.add("0");
    	  }
    	  else 
    	  {
    		//�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
    		 float resu =  Float.valueOf(benqiTem)/Float.valueOf(tongqiTem)*100 - 100;
    		 btbi.add(formatFloat(resu,"0.00"));
    	  }
       }
       results.add(btbi);
       
// 	   for(int i = 0; i < results.size(); i++)
// 	   {
// 		   for(int j = 0; j < results.get(i).size(); j++)
// 		   {
// 			   System.out.print((j)+" <> "+results.get(i).get(j) + "       ");
// 		   }
// 		   System.out.println("");
// 	   }
		
       return results;
	}
	// ���мල  ���   d_fgyjkp_sj
	public List<List<String>> getSjspYjda(String bmdm,Date fromDateD,Date toDateD)
	{
		
		// ��Ҫ����
		String fromDate = DateUtil.format(fromDateD, DateUtil.webFormat2);
		String toDate = DateUtil.format(toDateD, DateUtil.webFormat2);
		String tongFromDate = DateUtil.format(DateUtil.addYears(fromDateD,-1), DateUtil.webFormat2); 
		String tongToDate = DateUtil.format(DateUtil.addYears(toDateD,-1), DateUtil.webFormat2);
		// String bmdm = "03";
		// ��Ҫ����
		int columnCount = 39;
		String[] ls_dz = new String[columnCount];
		String[] ls_dz_t = new String[columnCount];
		double rowCount[] = new double[columnCount];
		double benqi[] = new double[columnCount];
		double tongqi[] = new double[columnCount];
		
		String spcxdzsql = "DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' ";
		//�ɴ永��
		ls_dz[1] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ��ɴ永��'and BZ='����ͳ��'");
		//���հ���
		ls_dz[2] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ����հ���'and BZ='����ͳ��'");
		//�ѽ᰸��new
		ls_dz[3] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ѽ᰸��'and BZ='����ͳ��'");
		//�������ѽ᰸
		ls_dz[4] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����������ѽ᰸'and BZ='����ͳ��'");
		//���°���������
		ls_dz[5] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//���°���������
		ls_dz[6] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='���°���������'and BZ='����ͳ��'");
		//һ��᰸��new
		ls_dz[22] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ�����д���'and BZ='����ͳ��'");
		ls_dz[22] = spcxdzsql + ls_dz[22] +")";
		//����᰸��new
		ls_dz[23] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��'");
		ls_dz[23] = spcxdzsql + ls_dz[23] +")";
		//����᰸��new
//			select SQLNR INTO:ls_dz[24]  from PUB_SQLLIB WHERE SQLMS='�������д���'and BZ='����ͳ��';
		ls_dz[24] = spcxdzsql + "AND (DMMS LIKE '__��__' OR DMMS LIKE '__��')"+")";
		//�μӺ���ͥ������new
		ls_dz[26]=ls_dz[3];
//			select SQLNR INTO:ls_dz[26]  from PUB_SQLLIB WHERE SQLMS='�μӺ���ͥ������'and BZ='����ͳ��';
//			if ls_dz[26]='' or isnull(ls_dz[26]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_�μӺ���ͥ������")
//			end if
//			//���߸��鰸����
//			select SQLNR INTO:ls_dz[11]  from PUB_SQLLIB WHERE SQLMS='���߸��鰸����'and BZ='����ͳ��';
//			if ls_dz[11]='' or isnull(ls_dz[11]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_���߸��鰸����")
//			end if
		//�ŷ�Ͷ����new
		ls_dz[25] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ŷ�Ͷ����'and BZ='����ͳ��'");
//			//һ��᰸��
//			select SQLNR INTO:ls_dz[13]  from PUB_SQLLIB WHERE SQLMS='һ��᰸��'and BZ='����ͳ��';
//			if ls_dz[13]='' or isnull(ls_dz[13]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_һ��᰸��")
//			end if
//			//�����з�����
//			select SQLNR INTO:ls_dz[14]  from PUB_SQLLIB WHERE SQLMS='�����з�����'and BZ='����ͳ��';
//			if ls_dz[14]='' or isnull(ls_dz[14]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_�����з�����")
//			end if
		//һ��������
		ls_dz[8] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������'and BZ='����ͳ��'");
		//һ��������ͨ����᰸��
		ls_dz[9] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ��������ͨ����᰸��'and BZ='����ͳ��'");
//			//����ͥ��
//			select SQLNR INTO:ls_dz[10]  from PUB_SQLLIB WHERE SQLMS='����ͥ��'and BZ='����ͳ��';
//			if ls_dz[10]='' or isnull(ls_dz[10]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_����ͥ��")
//			end if
//			//����᰸��
//			select SQLNR INTO:ls_dz[11]  from PUB_SQLLIB WHERE SQLMS='����᰸��'and BZ='����ͳ��';
//			if ls_dz[11]='' or isnull(ls_dz[11]) then
//				messagebox('ϵͳ��ʾ',"��鿴ϵͳSQL��_����᰸��")
//			end if
		//������
		ls_dz[12] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='������'and BZ='����ͳ��'");
		//�����з�����
		ls_dz[14] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�����з�����'and BZ='����ͳ��'");
		//������
		ls_dz[15] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͨ����������'and BZ='����ͳ��'");
		//����δ�᰸
		ls_dz[17] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='����δ�᰸'and BZ='����ͳ��'");
		//��ֹδ�᰸
		ls_dz[18] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ֹδ�᰸'and BZ='����ͳ��'");
		//�ж�δ�᰸
		ls_dz[19] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ж�δ�᰸��'and BZ='����ͳ��'");
		//��ͣ����δ�᰸��
		ls_dz[20] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='��ͣ��������δ�᰸��' and BZ='����ͳ��'");
		//18��������δ�᰸��
		ls_dz[21] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='18��������δ�᰸����' and BZ='����ͳ��'");
		//һ����׳���᰸��
		ls_dz[27] = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='һ����׳���᰸��' and BZ='����ͳ��'");
		//���߸���
		ls_dz[28]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' AND  (DMMS LIKE '%��' OR (DMMS LIKE '%��' AND DMMS NOT LIKE '%��%��')) )";
		//���̼���
		ls_dz[29]="DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_BEGIN#) <=0 and DATEDIFF(DD,PUB_AJ_JB.JARQ,#TJ_END#)>=0 AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH ='FBS0023-97' and DMMS LIKE '��ִ')";
		
		String lrx[] = new String[7];
		lrx[1] = "CBZASSA";
		lrx[2] = "CBZASJA";
		lrx[3] = "SPAJS";
		lrx[4] = "SPCPWSS";
		lrx[5] = "PCCPWSS";
		lrx[6] = "CXCCCPWSS";
		
		for(int i = 33; i < 39; i++)
		{
			ls_dz[i] = " DATEDIFF(DD,FGYG_LRX.RQ,#TJ_BEGIN#)<=0 and DATEDIFF(DD,FGYG_LRX.RQ,#TJ_END#)>=0 ";
		}
		// �滻ʱ���ַ���
		for(int i = 1; i < columnCount; i++)
		{
			ls_dz_t[i] = ls_dz[i];
			if(ls_dz[i] != null)
			{
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN#","'"+fromDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_END#", "'"+toDate+"'");
				  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN_JA#", "'"+fromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN#","'"+tongFromDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_END#", "'"+tongToDate+"'");
				  ls_dz_t[i] = ls_dz_t[i].replaceAll("#TJ_BEGIN_JA#", "'"+tongFromDate+"'");				  
			}
			
		}
		
		// ѡ����������ж��ٸ���
		String bmRenShu = "SELECT DISTINCT PUB_SPRY.XM,PUB_XTGL_YHB.YHSF  FROM PUB_AJ_JB,PUB_SPRY,PUB_XTGL_YHB  WHERE ( (((PUB_AJ_JB.JARQ=NULL OR DATEDIFF( DD,PUB_AJ_JB.JARQ,'"+fromDate+"')<=0)    AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0)) OR (DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+fromDate+"')<=0  AND DATEDIFF(DD,PUB_AJ_JB.LARQ,'"+toDate+"')>=0) ) AND PUB_SPRY.AJXH=PUB_AJ_JB.AJXH AND PUB_SPRY.SFCBR='Y' AND PUB_AJ_JB.BASPT='"+bmdm+"' AND PUB_XTGL_YHB.YHMC=PUB-SPRY.XM ORDER BY PUB_XTGL_YHB.YHSF";
	   //  System.out.println("-sql---->"+bmRenShu);
		List<String> xmList = bmRenXmList(bmRenShu);
	    List<List<String>> results = new ArrayList<List<String>>();
	    List<List<Float>> resultReturns = new ArrayList<List<Float>>();
	    List<double[]> resultTemp = new ArrayList<double[]>();
	    List<Float> ajpjslts = new ArrayList<Float>(); 
	    
	    int k = -1;
	      
 	    for(int i = 0; i  < xmList.size(); i++)
	    {
	    	String shengFenMc = getYongHuShenFenByXm(xmList.get(i));
	    	if(null == shengFenMc)
	    	{
	    		shengFenMc = "";
	    	}
	    	if( null != shengFenMc && (shengFenMc.equals("���") || shengFenMc.equals("���Ա") ||  shengFenMc.equals("��ʻԱ")))
	    	{
	    		continue;
	    	}
	    	// ��ʾ�ж���������
	        k++;
	    	List<String> cols = new ArrayList<String>();
	    	List<Float>  resultReturn = new ArrayList<Float>();
	    	double col[] = new double[columnCount];
	    	
	    	String sql_temp = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY" + " where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH" + " AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' AND ";
           
	    	
	    	// ����ְ��
	    	cols.add(shengFenMc);
	    	
	    	// ����
	    	cols.add(xmList.get(i));
	    	String str_sql = "";
	    	
	    	for(int j = 0; j < columnCount; j++)
	    	{
	    		// System.out.println("----jj---------------------------->"+j);
	    		if(j == 14 )
	    		{
	    			str_sql = ls_dz[j] +" AND PUB_AJ_JB.AJXH=PUB_SPRY.AJXH "+" AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 15)
	    		{
	    			str_sql = ls_dz[j] + " AND PUB_AJ_JB.AJXH = PUB_SPRY.AJXH AND XF_LXDJ.AJXH = PUB_AJ_JB.AJXH "+" AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y'";
	    		}
	    		else if(j == 26)
	    		{
	    			str_sql  = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY"+" where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH"+" AND PUB_SPRY.XM= '" +xmList.get(i)+ "' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'N' AND " + ls_dz[j];
	    		}
	    		else if( j >= 33 && j <= 38)
	    		{
	    			str_sql  = "select sum("+lrx[j - 32]+") from FGYG_LRX where FGYG_LRX.XM= '"+xmList.get(i)+"' AND " + ls_dz[j];
	    		}
	    		else if(ls_dz[j] != null)
	    		{
	    			str_sql = sql_temp + ls_dz[j];
	    		}
	    		// ִ�л�ý��
	    		if(ls_dz[j] != null)
	    		{
	    			col[j] = getCountResultTurnToDouble(str_sql);
	    			rowCount[j] += col[j];
	    		}
	    				
	    	}	
	    	
	    	 //����ƽ����������
    		str_sql = sql_temp+ ls_dz[3];
    		long temp = getCountResult(str_sql);
    		if(temp == 0)
    		{
    			ajpjslts.add(0f);
    		}
    		else
    		{
    			ajpjslts.add(pjslts(temp, bmdm, xmList.get(i), fromDate, toDate));
    		}
	    	
	    	resultTemp.add(col);
	    	resultReturns.add(resultReturn);
	    	results.add(cols);
	    	
	    	 // ����ƽ���������� ,���һ������
	    	sjEveryRowCount(cols,col,formatFloat(ajpjslts.get(k), "0.00"),true);
	    	       
	    }
	  
	  
		   
	   
 	   // ��Ա�ۼ�
 	   List<String> renyuleiji = new ArrayList<String>();
 	   renyuleiji.add("��Ա�ۼ�");
 	   renyuleiji.add("");	
 	   sjEveryRowCount(renyuleiji, rowCount,"",false);
	  
	   
       results.add(renyuleiji);
	  
       
       //�Ը���ͥ�ϼ�--���� 
       String str_sql = "";
       List<String> bengqiRow = new ArrayList<String>();
       bengqiRow.add("����ͥ�Һϼ�");
       bengqiRow.add("");
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i ==  14 )
    	   {
    		   str_sql = ls_dz[i] + "  and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '"+bmdm + "'";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql = ls_dz[i] + " and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '"+bmdm+"'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql =  "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz[i];
    	   }
    	   else if(ls_dz[i] != null)
    	   {
    		   str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB "  + " where PUB_AJ_JB.BASPT = '" +bmdm + "' AND  PUB_AJ_JB.SPCXDZ <> NULL AND " + ls_dz[i]; 
    	   }
    	   
    	   if(ls_dz[i] != null)
    	   {
    		   benqi[i] = getCountResultTurnToDouble(str_sql);
    	   }   	   
       }
       //����ƽ����������
		str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " + " where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz[3];
		long temp = getCountResult(str_sql);
		if(temp == 0)
		{
	       sjEveryRowCount(bengqiRow, benqi, "0",false);
		}
		else
		{
			sjEveryRowCount(bengqiRow, benqi,pjslts_bm(bmdm, fromDate,toDate, temp),false);
		}
		
       results.add(bengqiRow);
       
     //�Ը���ͥ�ϼ�--ͬ��
       String str_sql_2 = "";
       List<String> tongqiRow = new ArrayList<String>();
       tongqiRow.add("ͬ��ͥ�Һϼ�");
       tongqiRow.add("");
       
       for(int i = 0; i < columnCount; i++)
       {
    	   if(i ==  14 )
    	   {
    		   str_sql = ls_dz_t[i] + "  and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH and PUB_AJ_JB.BASPT = '"+bmdm + "'";
    	   }
    	   else if(i == 15)
    	   {
    		   str_sql = ls_dz_t[i] + " and PUB_AJ_JB.AJXH = XF_LXDJ.AJXH and PUB_SPRY.AJXH = PUB_AJ_JB.AJXH AND PUB_AJ_JB.BASPT = '"+bmdm+"'";
    	   }
    	   else if( i >= 33 && i <= 38)
    	   {
    		   str_sql =  "select sum("+lrx[i - 32]+") from FGYG_LRX where FGYG_LRX.BASPT = '"+bmdm+"' AND " + ls_dz_t[i];
    	   }
    	   else if(ls_dz_t[i] != null)
    	   {
    		   str_sql = "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB "  + " where PUB_AJ_JB.BASPT = '" +bmdm + "' AND  PUB_AJ_JB.SPCXDZ <> NULL AND " + ls_dz_t[i]; 
    	   }
    	   
    	   if(ls_dz_t[i] != null)
    	   {
    		   tongqi[i] = getCountResultTurnToDouble(str_sql);
    	   }   	   
       }
     //����ƽ����������
		str_sql_2 =  "select count(distinct PUB_AJ_JB.AJXH) from PUB_AJ_JB " +" where  PUB_AJ_JB.BASPT = '" + bmdm +"' AND " + ls_dz_t[3];
		long temp_2 = getCountResult(str_sql_2);
		if(temp_2 == 0)
		{
	       sjEveryRowCount(tongqiRow, tongqi, "0",false);
		}
		else
		{
			sjEveryRowCount(tongqiRow,tongqi,pjslts_bm(bmdm, tongFromDate,tongToDate, temp_2),false);
		}
		
       results.add(tongqiRow);
       //�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
       List<String> btbi = new ArrayList<String>();
       btbi.add("ͥ��ͬ��");
       btbi.add("");
       for(int i = 2; i  <tongqiRow.size(); i++)
       {
    	  String benqiTem = bengqiRow.get(i).trim();
    	  String tongqiTem = tongqiRow.get(i).trim();
    	  if(benqiTem.equals("--") || tongqiTem.endsWith("--"))
    	  {
    		  btbi.add("--");
    	  }
    	  else if(benqiTem.equals("") || tongqiTem.endsWith(""))
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(tongqiTem) == 0)
    	  {
    		  btbi.add("--");
    	  }
    	  else if(Float.valueOf(benqiTem) == 0)
    	  {
    		  btbi.add("0");
    	  }
    	  else 
    	  {
    		//�Ը���ͥ�ϼ�--ͬ��((����/ͬ��)*100-100)
    		 float resu =  Float.valueOf(benqiTem)/Float.valueOf(tongqiTem)*100 - 100;
    		 btbi.add(formatFloat(resu,"0.00"));
    	  }
       }
       results.add(btbi);
       
// 	   for(int i = 0; i < results.size(); i++)
// 	   {
// 		   for(int j = 0; j < results.get(i).size(); j++)
// 		   {
// 			   System.out.print((j)+" <> "+results.get(i).get(j) + "       ");
// 		   }
// 		   System.out.println("");
// 	   }
//		
		
       return results;
		
      
	}
	// �⳥��  'd_fgyjkp_ms (��û������ִ������)
	
	// myCode
	@SuppressWarnings("unchecked")
	public List<List<String>> getScbbZwZj(Date dateFrom,Date dateTo,String biaozhi,String dm){
		String fromdate = DateUtil.format(dateFrom, DateUtil.webFormat2);
		String todate = DateUtil.format(dateTo, DateUtil.webFormat2);
		List<List<String>> listData = new ArrayList<List<String>>();
		
		String[] ls_dz = new String[35];
		String str_sql1 = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�հ����հ���'and BZ='����ͳ��'");
		String str_sql2 = sqlText("select SQLNR from PUB_SQLLIB WHERE SQLMS='�ѽ᰸��'and BZ='����ͳ��'");
		
		//������ǰ��ȫ
		ls_dz[1] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '�߱�')";
		//����һ��
		ls_dz[2] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND (DMMS LIKE '__��' OR DMMS LIKE '����' OR DMMS LIKE '��' OR DMMS LIKE '���' OR DMMS LIKE '�ٱ�')) AND PUB_AJ_JB.SPCX='1'";
		//���ն���
		ls_dz[3] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND (DMMS LIKE '��' OR DMMS LIKE '����'))";
		//������������
		ls_dz[4] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '�̼�')";
		//������������
		ls_dz[5] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '����%')";
		//������������
		ls_dz[6] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '�м�')";
		//������������
		ls_dz[7] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '����%')";
		//������������
		ls_dz[8] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '���')";
		//�������¿���
		ls_dz[9] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '��')";
		//������������
		ls_dz[10] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '%��')";
		//������������
		ls_dz[11] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND (DMMS LIKE '����' OR DMMS LIKE '����'))";
		//������ʾЭ��
		ls_dz[12] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '%��' AND DMMS NOT LIKE 'ִ��') AND PUB_AJ_JB.AJXZ='A'";
		//�������̸���
		ls_dz[13] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '%��' AND DMMS NOT LIKE '�̸�')";
		//���ռ��̼���
		ls_dz[14] = str_sql1 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '%��' AND DMMS NOT LIKE '��ִ')";
		//�����Ʋ�
		ls_dz[15] = str_sql1 + "AND PUB_AJ_JB.SPCX='7'";
		//����ִ��
		ls_dz[16] = str_sql1 + "AND PUB_AJ_JB.AJXZ='8'";
		//�����⳥
		ls_dz[17] = str_sql1 + "AND PUB_AJ_JB.AJXZ='7'";

		//�ɴ���ǰ��ȫ
		ls_dz[18] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '�߱�')";
		//����һ��
		ls_dz[19] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND (DMMS LIKE '__��' OR DMMS LIKE '����' OR DMMS LIKE '��' OR DMMS LIKE '���' OR DMMS LIKE '�ٱ�')) AND PUB_AJ_JB.SPCX='1'";
		//���ն���
		ls_dz[20] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND (DMMS LIKE '��' OR DMMS LIKE '����'))";
		//������������
		ls_dz[21] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '�̼�')";
		//������������
		ls_dz[22] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '����%')";
		//������������
		ls_dz[23] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '�м�')";
		//������������
		ls_dz[24] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '����%')";
		//������������
		ls_dz[25] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '���')";
		//�������¿���
		ls_dz[26] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '��')";
		//������������
		ls_dz[27] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '%��')";
		//������������
		ls_dz[28] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND (DMMS LIKE '����' OR DMMS LIKE '����'))";
		//������ʾЭ��
		ls_dz[29] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '%��' AND DMMS NOT LIKE 'ִ��') AND PUB_AJ_JB.AJXZ='A'";
		//�������̸���
		ls_dz[30] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '%��' AND DMMS NOT LIKE '�̸�')";
		//���ռ��̼���
		ls_dz[31] = str_sql2 + "AND PUB_AJ_JB.SPCXDZ IN (SELECT DMBH FROM PUB_DMB WHERE LBBH='FBS0023-97' AND DMMS LIKE '%��' AND DMMS NOT LIKE '��ִ')";
		//�����Ʋ�
		ls_dz[32] = str_sql2 + "AND PUB_AJ_JB.SPCX='7'";
		//����ִ��
		ls_dz[33] = str_sql2 + "AND PUB_AJ_JB.AJXZ='8'";
		//�����⳥
		ls_dz[34] = str_sql2 + "AND PUB_AJ_JB.AJXZ='7'";
		
		for(int i = 1; i < 35; i++)
		{
			if(ls_dz[i] != null)
			{
			  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN#","'"+fromdate+"'");
			  ls_dz[i] = ls_dz[i].replaceAll("#TJ_END#", "'"+todate+"'");
			  ls_dz[i] = ls_dz[i].replaceAll("#TJ_BEGIN_JA#", "'"+fromdate+"'");	
			}			
		}
		//fydm:120000 200
		String fydm = sqlText("SELECT DMMS FROM PUB_DMB WHERE LBBH = 'ϵͳȱʡ' AND DMBH = '��Ժ����'");
		String ryxmSql="";
		if(biaozhi.equals("2")){
			ryxmSql = "SELECT XM FROM DZRS_RS_JBXXJ WHERE DZRS_RS_JBXXJ.SPZW ="+"'"+dm+"'"+"AND DZRS_RS_JBXXJ.RYLB='1' AND DZRS_RS_JBXXJ.DWMC="+"'"+fydm+"'";
		}else{
			ryxmSql = "SELECT XM FROM DZRS_RS_JBXXJ WHERE DZRS_RS_JBXXJ.SPZW ="+"'"+dm+"'"+"AND DZRS_RS_JBXXJ.RYLB='1' AND DZRS_RS_JBXXJ.DWMC="+"'"+fydm+"'";
		}
		List<String> listryxm = getSession().createSQLQuery(ryxmSql).list();
//		for(int i=0;i<listryxm.size();i++){
//			System.out.println(listryxm.get(i));
//		}
		
		
		for(int i=0;i<listryxm.size();i++){
			List<String> listDataToPeson = new ArrayList<String>();
			listDataToPeson.add(i+1+"");
			listDataToPeson.add(listryxm.get(i));
			for(int j=1;j<35;j++){
				// System.out.println(getSqlTmp(listryxm.get(i))+ls_dz[j]);
				if(getSession().createSQLQuery(getSqlTmp(listryxm.get(i))+ls_dz[j]).uniqueResult()==null){
					listDataToPeson.add(null);
				}else{
					String tmp = getSession().createSQLQuery(getSqlTmp(listryxm.get(i))+ls_dz[j]).uniqueResult().toString();
					listDataToPeson.add(tmp);
				}
			}
			listData.add(listDataToPeson);
		}
		List<String> listDataZj = new ArrayList<String>();
		
		if(listData.size()!=0){
			listDataZj.add(listryxm.size()+1+"");
			listDataZj.add("�ܼ�");
			for(int i=2;i<listData.get(0).size();i++){
				int t = 0;
				for(int j=0;j<listData.size();j++){
					t += Integer.parseInt(listData.get(j).get(i));
				}
				listDataZj.add(t+"");
			}
		}else{
			listDataZj.add(1 + "");
			listDataZj.add("�ܼ�");
			for(int i=0;i<34;i++){
				listDataZj.add(0 + "");
			}
		}
		listData.add(listDataZj);
		return listData;
	}
	
	private String getSqlTmp(String xm){
		String sql_temp = "select count(PUB_AJ_JB.AJXH) from PUB_AJ_JB,PUB_SPRY"; 
		sql_temp = sql_temp +" where PUB_AJ_JB.AJXH=PUB_SPRY.AJXH";
		sql_temp = sql_temp +" AND PUB_SPRY.XM= '" + xm;
		sql_temp = sql_temp +"' AND PUB_SPRY.FG='1' AND PUB_SPRY.SFCBR = 'Y' AND ";
		return sql_temp;
	}
    /**
     * 
     * @param anHou
     */
	public int[] getXfShu(List<String> anHou)
	{
		/**
		 * ���鳤��Ϊ 2 ����һ��Ϊÿ���������ŷõĴ����ܺ�
		 * �ڶ���Ϊ������������ŷã���� 1�����򲻼�
		 */
		int resultRe[] = new int[2];
		for(String str : anHou)
		{
			String sql_temp = "select count(XFGL_LFCL.LFCS) from XFGL_LFCL";
			sql_temp = sql_temp +" where XFGL_LFCL.FYAH= '"+str+"'";
		    Integer result = (Integer) getSession().createSQLQuery(sql_temp).uniqueResult();
		    if(0 != result)
		    {
		    	  resultRe[0] += result;
		    	  resultRe[1]++;
		    }
		}
		
		return resultRe;
	}
	
	

}
