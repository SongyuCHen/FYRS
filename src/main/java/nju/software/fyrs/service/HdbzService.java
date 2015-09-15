package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.BzbhVO;
import nju.software.fyrs.biz.vo.BzjgVO;
import nju.software.fyrs.biz.vo.HdbzWjVO;

public interface HdbzService {

	/**
	 * 保存核定编制
	 * @param fydm
	 * @param pzwh
	 * @param hdrq
	 * @param zy_zfzxbz_bmld_zz
	 * @param zy_zfzxbz_bmld_fz
	 * @param zy_zfzxbz_bmld_qt
	 * @param zy_zfzxbz_bmld_qt_mx
	 * @param zy_zfzxbz_nsjgld_zz_fc
	 * @param zy_zfzxbz_nsjgld_zz_zk
	 * @param zy_zfzxbz_nsjgld_fz_zk
	 * @param zy_zfzxbz_nsjgld_fz_fk
	 * @param zy_zfzxbz_nsjgld_qt
	 * @param zy_zfzxbz_nsjgld_qt_mx
	 * @param zy_zfzxbz_dyy
	 * @param zy_zfzxbz_fdyy
	 * @param zy_zfzxbz_zrky
	 * @param zy_zfzxbz_fzrky
	 * @param zy_zfzxbz_kybsy
	 * @param zy_zfzxbz_bhyy
	 * @param zy_zfzxbz_bz
	 * @param zy_sy_kbs
	 * @param zy_sy_bhyy
	 * @param zy_sy_bz
	 * @param sheng_zfzxbz_kbs
	 * @param sheng_zfzxbz_bhyy
	 * @param sheng_zfzxbz_bz
	 * @param sheng_qe_kbs
	 * @param sheng_qe_bhyy
	 * @param sheng_qe_bz
	 * @param sheng_ce_kbs
	 * @param sheng_ce_bhyy
	 * @param sheng_ce_bz
	 * @param sheng_zczz_kbs
	 * @param sheng_zczz_bhyy
	 * @param sheng_zczz_bz
	 * @param sheng_fs_kbs
	 * @param sheng_fs_bhyy
	 * @param sheng_fs_bz
	 * @param shi_zfzxbz_kbs
	 * @param shi_zfzxbz_bhyy
	 * @param shi_zfzxbz_bz
	 * @param shi_qe_kbs
	 * @param shi_qe_bhyy
	 * @param shi_qe_bz
	 * @param shi_ce_kbs
	 * @param shi_ce_bhyy
	 * @param shi_ce_bz
	 * @param shi_zczz_kbs
	 * @param shi_zczz_bhyy
	 * @param shi_zczz_bz
	 * @param shi_fs_kbs
	 * @param shi_fs_bhyy
	 * @param shi_fs_bz
	 * @param wj
	 * @param wjm
	 * @return
	 */
	public boolean save(int fydm, String pzwh, String hdrq, Integer zy_zfzxbz_bmld_zz,
			Integer zy_zfzxbz_bmld_fz, Integer zy_zfzxbz_bmld_qt,
			String zy_zfzxbz_bmld_qt_mx, Integer zy_zfzxbz_nsjgld_zz_fc,
			Integer zy_zfzxbz_nsjgld_zz_zk, Integer zy_zfzxbz_nsjgld_fz_zk,
			Integer zy_zfzxbz_nsjgld_fz_fk, Integer zy_zfzxbz_nsjgld_qt,
			String zy_zfzxbz_nsjgld_qt_mx, Integer zy_zfzxbz_dyy,
			Integer zy_zfzxbz_fdyy, Integer zy_zfzxbz_zrky,
			Integer zy_zfzxbz_fzrky, Integer zy_zfzxbz_kybsy,
			String zy_zfzxbz_bhyy, String zy_zfzxbz_bz, Integer zy_sy_kbs,
			String zy_sy_bhyy, String zy_sy_bz, Integer sheng_zfzxbz_kbs,
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
			String shi_fs_bz, byte[] wj,String wjm);
	/**
	 * 获得核定编制变化情况
	 * @param fydm
	 * @param type
	 * @return
	 */
	public List<BzbhVO> getBzbhList(int fydm, String type);
	/**
	 * 获得核定编制结构
	 * @param fydm
	 * @return
	 */
	public List<BzjgVO> getBzjgList(int fydm);
	/**
	 * 根据id获得核定编制批准文件
	 * @param id
	 * @return
	 */
	public HdbzWjVO getWjbyId(int id);
}
