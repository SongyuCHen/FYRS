package nju.software.fyrs.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.fyrs.biz.vo.BzbhVO;
import nju.software.fyrs.biz.vo.BzjgVO;
import nju.software.fyrs.biz.vo.HdbzWjVO;
import nju.software.fyrs.data.dao.HdbzDAO;
import nju.software.fyrs.data.dataobject.RysxHdbz;
import nju.software.fyrs.service.HdbzService;

public class HdbzServiceImpl implements HdbzService {
	private HdbzDAO hdbzDAO;

	public void setHdbzDAO(HdbzDAO hdbzDAO) {
		this.hdbzDAO = hdbzDAO;
	}

	@Override
	public boolean save(int fydm, String pzwh, String hdrq,
			Integer zy_zfzxbz_bmld_zz, Integer zy_zfzxbz_bmld_fz,
			Integer zy_zfzxbz_bmld_qt, String zy_zfzxbz_bmld_qt_mx,
			Integer zy_zfzxbz_nsjgld_zz_fc, Integer zy_zfzxbz_nsjgld_zz_zk,
			Integer zy_zfzxbz_nsjgld_fz_zk, Integer zy_zfzxbz_nsjgld_fz_fk,
			Integer zy_zfzxbz_nsjgld_qt, String zy_zfzxbz_nsjgld_qt_mx,
			Integer zy_zfzxbz_dyy, Integer zy_zfzxbz_fdyy,
			Integer zy_zfzxbz_zrky, Integer zy_zfzxbz_fzrky,
			Integer zy_zfzxbz_kybsy, String zy_zfzxbz_bhyy,
			String zy_zfzxbz_bz, Integer zy_sy_kbs, String zy_sy_bhyy,
			String zy_sy_bz, Integer sheng_zfzxbz_kbs,
			String sheng_zfzxbz_bhyy, String sheng_zfzxbz_bz,
			Integer sheng_qe_kbs, String sheng_qe_bhyy, String sheng_qe_bz,
			Integer sheng_ce_kbs, String sheng_ce_bhyy, String sheng_ce_bz,
			Integer sheng_zczz_kbs, String sheng_zczz_bhyy,
			String sheng_zczz_bz, Integer sheng_fs_kbs, String sheng_fs_bhyy,
			String sheng_fs_bz, Integer shi_zfzxbz_kbs, String shi_zfzxbz_bhyy,
			String shi_zfzxbz_bz, Integer shi_qe_kbs, String shi_qe_bhyy,
			String shi_qe_bz, Integer shi_ce_kbs, String shi_ce_bhyy,
			String shi_ce_bz, Integer shi_zczz_kbs, String shi_zczz_bhyy,
			String shi_zczz_bz, Integer shi_fs_kbs, String shi_fs_bhyy,
			String shi_fs_bz, byte[] wj, String wjm) {
		RysxHdbz hdbz=new RysxHdbz();
		hdbz.setNFy(fydm);
		hdbz.setCPzwh(pzwh);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(hdrq);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		hdbz.setDRq(date);
		hdbz.setNZyZfzxbzBmldZz(zy_zfzxbz_bmld_zz);
		hdbz.setNZyZfzxbzBmldFz(zy_zfzxbz_bmld_fz);
		hdbz.setNZyZfzxbzBmldQt(zy_zfzxbz_bmld_qt);
		hdbz.setCZyZfzxbzBmldQtMx(zy_zfzxbz_bmld_qt_mx);
		hdbz.setNZyZfzxbzNsjgldZzFc(zy_zfzxbz_nsjgld_zz_fc);
		hdbz.setNZyZfzxbzNsjgldZzZk(zy_zfzxbz_nsjgld_zz_zk);
		hdbz.setNZyZfzxbzNsjgldFzZk(zy_zfzxbz_nsjgld_fz_zk);
		hdbz.setNZyZfzxbzNsjgldFzFk(zy_zfzxbz_nsjgld_fz_fk);
		hdbz.setNZyZfzxbzNsjgldQt(zy_zfzxbz_nsjgld_qt);
		hdbz.setCZyZfzxbzNsjgldQtMx(zy_zfzxbz_nsjgld_qt_mx);
		hdbz.setNZyZfzxbzDyy(zy_zfzxbz_dyy);
		hdbz.setNZyZfzxbzFdyy(zy_zfzxbz_fdyy);
		hdbz.setNZyZfzxbzZrky(zy_zfzxbz_zrky);
		hdbz.setNZyZfzxbzFzrky(zy_zfzxbz_fzrky);
		hdbz.setNZyZfzxbzKybsy(zy_zfzxbz_kybsy);
		hdbz.setCZyZfzxbzBhyy(zy_zfzxbz_bhyy);
		hdbz.setCZyZfzxbzBz(zy_zfzxbz_bz);
		hdbz.setNZySyKbs(zy_sy_kbs);
		hdbz.setCZySyBhyy(zy_sy_bhyy);
		hdbz.setCZySyBz(zy_sy_bz);
		hdbz.setNShengZfzxbzKbs(sheng_zfzxbz_kbs);
		hdbz.setCShengZfzxbzBhyy(sheng_zfzxbz_bhyy);
		hdbz.setCShengZfzxbzBz(sheng_zfzxbz_bz);
		hdbz.setNShengQeKbs(sheng_qe_kbs);
		hdbz.setCShengQeBhyy(sheng_qe_bhyy);
		hdbz.setCShengQeBz(sheng_qe_bz);
		hdbz.setNShengCeKbs(sheng_ce_kbs);
		hdbz.setCShengCeBhyy(sheng_ce_bhyy);
		hdbz.setCShengCeBz(sheng_ce_bz);
		hdbz.setNShengZczzKbs(sheng_zczz_kbs);
		hdbz.setCShengZczzBhyy(sheng_zczz_bhyy);
		hdbz.setCShengZczzBz(sheng_zczz_bz);
		hdbz.setNShengFsKbs(sheng_fs_kbs);
		hdbz.setCShengFsBhyy(sheng_fs_bhyy);
		hdbz.setCShengFsBz(sheng_fs_bz);
		hdbz.setNShiZfzxbzKbs(shi_zfzxbz_kbs);
		hdbz.setCShiZfzxbzBhyy(shi_zfzxbz_bhyy);
		hdbz.setCShiZfzxbzBz(shi_zfzxbz_bz);
		hdbz.setNShiQeKbs(shi_qe_kbs);
		hdbz.setCShiQeBhyy(shi_qe_bhyy);
		hdbz.setCShiQeBz(shi_qe_bz);
		hdbz.setNShiCeKbs(shi_ce_kbs);
		hdbz.setCShiCeBhyy(shi_ce_bhyy);
		hdbz.setCShiCeBz(shi_ce_bz);
		hdbz.setNShiZczzKbs(shi_zczz_kbs);
		hdbz.setCShiZczzBhyy(shi_zczz_bhyy);
		hdbz.setCShiZczzBz(shi_zczz_bz);
		hdbz.setNShiFsKbs(shi_fs_kbs);
		hdbz.setCShiFsBhyy(shi_fs_bhyy);
		hdbz.setCShiFsBz(shi_fs_bz);
		hdbz.setImWj(wj);
		hdbz.setCWjm(wjm);
		
		return hdbzDAO.save(hdbz);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<BzbhVO> getBzbhList(int fydm, String type) {
		String col;
		if(type=="ZyZfzxbz") col = "NZyZfzxbzBmldZz";
		else col = "N"+type+"Kbs";
		List<RysxHdbz>hdbzs = hdbzDAO.getHdbzList(fydm, col);
		List<BzbhVO>vos=new ArrayList<BzbhVO>();
		if(hdbzs!=null){
			int size = hdbzs.size();
			if(type=="ZyZfzxbz"){
				int kbs0 = 0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCZyZfzxbzBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs = hdbz.getNZyZfzxbzBmldZz()+hdbz.getNZyZfzxbzBmldFz()+hdbz.getNZyZfzxbzBmldQt()+
							hdbz.getNZyZfzxbzNsjgldZzFc()+hdbz.getNZyZfzxbzNsjgldZzZk()+
							hdbz.getNZyZfzxbzNsjgldFzZk()+hdbz.getNZyZfzxbzNsjgldFzFk()+
							hdbz.getNZyZfzxbzNsjgldQt()+hdbz.getNZyZfzxbzDyy()+hdbz.getNZyZfzxbzFdyy()+
							hdbz.getNZyZfzxbzZrky()+hdbz.getNZyZfzxbzFzrky()+hdbz.getNZyZfzxbzKybsy();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCZyZfzxbzBz());
					vos.add(vo);
				}
			}else if(type=="ZySy"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCZySyBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNZySyKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCZySyBz());
					vos.add(vo);
				}
			}else if(type=="ShengZfzxbz"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCZySyBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShengZfzxbzKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShengZfzxbzBz());
					vos.add(vo);
				}
			}else if(type=="ShengQe"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCShengQeBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShengQeKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShengQeBz());
					vos.add(vo);
				}
			}else if(type=="ShengCe"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCShengCeBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShengCeKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShengCeBz());
					vos.add(vo);
				}
			}else if(type=="ShengZczz"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCShengZczzBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShengZczzKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShengZczzBz());
					vos.add(vo);
				}
			}else if(type=="ShengFs"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCShengFsBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShengFsKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShengFsBz());
					vos.add(vo);
				}
			}else if(type=="ShiZfzxbz"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCShiZfzxbzBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShiZfzxbzKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShiZfzxbzBz());
					vos.add(vo);
				}
			}else if(type=="ShiQe"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCShiQeBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShiQeKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShiQeBz());
					vos.add(vo);
				}
			}else if(type=="ShiCe"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCShiCeBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShiCeKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShiCeBz());
					vos.add(vo);
				}
			}else if(type=="ShiZczz"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCShiZczzBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShiZczzKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShiZczzBz());
					vos.add(vo);
				}
			}else if(type=="ShiFs"){
				int kbs0=0;
				for(int i=0;i<size;i++){
					BzbhVO vo = new BzbhVO();
					RysxHdbz hdbz=hdbzs.get(i);
					vo.setNId(hdbz.getNId());
					if(hdbz.getImWj()!=null)vo.setHasWj(true);
					else vo.setHasWj(false);
					vo.setNYear(hdbz.getDRq().getYear()+1900);
					vo.setNMonth(hdbz.getDRq().getMonth()+1);
					vo.setNDate(hdbz.getDRq().getDate());
					vo.setCBhyy(hdbz.getCShiFsBhyy());
					vo.setCPzwh(hdbz.getCPzwh());
					int kbs=hdbz.getNShiFsKbs();
					vo.setNKbs(kbs);
					if(kbs>kbs0) vo.setNZbs(kbs-kbs0+"");
					else if(kbs<kbs0) vo.setNJbs(kbs0-kbs+"");
					kbs0=kbs;
					vo.setCBz(hdbz.getCShiFsBz());
					vos.add(vo);
				}
			}
		}
		return vos;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<BzjgVO> getBzjgList(int fydm) {
		List<RysxHdbz>hdbzs = hdbzDAO.getHdbzList(fydm, "NZyZfzxbzBmldZz");
		List<BzjgVO>vos=new ArrayList<BzjgVO>();
		if(hdbzs!=null){
			for(RysxHdbz hdbz : hdbzs){
				BzjgVO vo = new BzjgVO();
				vo.setNId(hdbz.getNId());
				if(hdbz.getImWj()!=null)vo.setHasWj(true);
				else vo.setHasWj(false);
				vo.setNYear(hdbz.getDRq().getYear()+1900);
				vo.setNMonth(hdbz.getDRq().getMonth()+1);
				vo.setNDate(hdbz.getDRq().getDate());
				vo.setCHdwh(hdbz.getCPzwh());
				vo.setNZyZfzxbzBmldZz(hdbz.getNZyZfzxbzBmldZz());
				vo.setNZyZfzxbzBmldFz(hdbz.getNZyZfzxbzBmldFz());
				vo.setNZyZfzxbzBmldQt(hdbz.getNZyZfzxbzBmldQt());
				vo.setCZyZfzxbzBmldQtMx(hdbz.getCZyZfzxbzBmldQtMx());
				vo.setNZyZfzxbzNsjgldZzFc(hdbz.getNZyZfzxbzNsjgldZzFc());
				vo.setNZyZfzxbzNsjgldZzZk(hdbz.getNZyZfzxbzNsjgldZzZk());
				vo.setNZyZfzxbzNsjgldFzZk(hdbz.getNZyZfzxbzNsjgldFzZk());
				vo.setNZyZfzxbzNsjgldFzFk(hdbz.getNZyZfzxbzNsjgldFzFk());
				vo.setNZyZfzxbzNsjgldQt(hdbz.getNZyZfzxbzNsjgldQt());
				vo.setCZyZfzxbzNsjgldQtMx(hdbz.getCZyZfzxbzNsjgldQtMx());
				vo.setNZyZfzxbzDyy(hdbz.getNZyZfzxbzDyy());
				vo.setNZyZfzxbzFdyy(hdbz.getNZyZfzxbzFdyy());
				vo.setNZyZfzxbzZrky(hdbz.getNZyZfzxbzZrky());
				vo.setNZyZfzxbzFzrky(hdbz.getNZyZfzxbzFzrky());
				vo.setNZyZfzxbzKybsy(hdbz.getNZyZfzxbzKybsy());
				int xzbz = hdbz.getNZyZfzxbzBmldZz()+hdbz.getNZyZfzxbzBmldFz()+hdbz.getNZyZfzxbzBmldQt()+
						hdbz.getNZyZfzxbzNsjgldZzFc()+hdbz.getNZyZfzxbzNsjgldZzZk()+
						hdbz.getNZyZfzxbzNsjgldFzZk()+hdbz.getNZyZfzxbzNsjgldFzFk()+
						hdbz.getNZyZfzxbzNsjgldQt()+hdbz.getNZyZfzxbzDyy()+hdbz.getNZyZfzxbzFdyy()+
						hdbz.getNZyZfzxbzZrky()+hdbz.getNZyZfzxbzFzrky()+hdbz.getNZyZfzxbzKybsy();
				vo.setNXzbz(xzbz);
				int sdbz;
				if(hdbz.getNShengZfzxbzKbs()!=null)sdbz=hdbz.getNShengZfzxbzKbs();
				else{
					sdbz=hdbzDAO.getSdbzKbsByDate(fydm, hdbz.getDRq());
				}
				vo.setNSdbz(sdbz);
				vo.setNHj(xzbz+sdbz);
				vos.add(vo);
			}
		}
		return vos;
	}

	@Override
	public HdbzWjVO getWjbyId(int id) {
		RysxHdbz hdbz=hdbzDAO.findById(id);
		HdbzWjVO vo=new HdbzWjVO();
		vo.setCPzwh(hdbz.getCPzwh());
		vo.setCWjm(hdbz.getCWjm());
		vo.setImWj(hdbz.getImWj());
		return vo;
	}
}
